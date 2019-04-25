package ar.edu.unq.desapp.grupoa.testUtils;

import ar.edu.unq.desapp.grupoa.model.Guest;
import ar.edu.unq.desapp.grupoa.model.User;

public class GuestBuilder {

    private Guest guest;

    private GuestBuilder(){
        this.guest  = new Guest();
    }

    public static GuestBuilder buildAGuest(){
        return new GuestBuilder();
    }

    public GuestBuilder withName(User user){
        this.guest.setUser(user);
        return this;
    }

    public Guest build(){
        return this.guest;
    }
}
