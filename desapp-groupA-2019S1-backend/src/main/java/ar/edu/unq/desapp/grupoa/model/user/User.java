package ar.edu.unq.desapp.grupoa.model.user;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private  String firstName;

    @NotBlank(message = "LastName is mandatory")
    private  String lastName;

    @NotBlank(message = "Mail is mandatory")
    private  String email;

    @NotBlank(message = "Password is mandatory")
    private  String password;

    @NotNull(message = "BornDay is mandatory")
    @Column
    private LocalDateTime bornDay;


    public User(String firstName, String lastName, String email, String password, LocalDateTime bornDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bornDay = bornDay;
    }

    public User(){}

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public LocalDateTime getBornDay() {
        return bornDay;
    }

    public Integer getId() {
        return this.id;
    }

    public void setFirstName(String name) {
        this.firstName= name;
    }
}