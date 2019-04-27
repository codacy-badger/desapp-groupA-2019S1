package ar.edu.unq.desapp.grupoa.model;

import ar.edu.unq.desapp.grupoa.model.user.account.Account;
import ar.edu.unq.desapp.grupoa.model.user.account.Movement;
import ar.edu.unq.desapp.grupoa.model.user.account.MovementType;
import org.junit.Before;
import org.junit.Test;

import static ar.edu.unq.desapp.grupoa.utils.builders.Randomizer.randomDate;
import static ar.edu.unq.desapp.grupoa.utils.builders.Randomizer.randomNumber;
import static ar.edu.unq.desapp.grupoa.utils.builders.Randomizer.randomUser;
import static org.junit.Assert.assertEquals;

public class AccountTest {


    @Before
    public void setup(){
    }

    @Test
    public void accountIsCreatedWithNoMovementsAndZeroBalance(){
        Account account = new Account(randomUser());

        assertEquals(integer(0) ,account.balance());
        assertEquals(integer(0) ,movementsSize(account));
    }

    @Test
    public void addAMovementWithPositiveAmountToUserAccount(){
        Account account         = accountForUserWithRandomBalance();
        Integer balanceBefore   = account.balance();
        Integer movementsSizeBefore = movementsSize(account);

        account.addMovement(movementWithRandomTypeAndDate(500));

        assertEquals(integer(balanceBefore+500)     , account.balance());
        assertEquals(integer(movementsSizeBefore +1),movementsSize(account));
    }

    @Test
    public void addAMovementWithNegativeAmountToUserAccount(){
        Account account         = accountForUserWithRandomBalance();
        Integer balanceBefore   = account.balance();
        Integer movementsSizeBefore = movementsSize(account);

        account.addMovement(movementWithRandomTypeAndDate(-500));

        assertEquals(integer(balanceBefore-500)     , account.balance());
        assertEquals(integer(movementsSizeBefore +1),movementsSize(account));
    }

    private Integer movementsSize(Account account) {
        return account.movements().size();
    }

    private Movement movementWithRandomTypeAndDate(Integer amount) {
        return new Movement(amount, MovementType.CASH, randomDate());
    }




    private Account accountForUserWithRandomBalance() {
        Account account = new Account(randomUser());
        account.addMovement(movementWithRandomTypeAndDate(randomNumber()));
        return account;
    }

    private Integer integer(int number) {
        return number;
    }

}