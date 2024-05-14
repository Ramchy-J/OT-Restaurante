package entities;

import constants.Status;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Customer extends Base {
    //Attributes

    private String firstName;
    private String lastName;
    private String phoneNumber;

    //Constructors

    public Customer() {
    }

    public Customer(Long id, Instant createdDate, Instant updatedDate, Long createdBy, Long updatedBy, Status status, String firstName, String lastName, String phoneNumber) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //Methods

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

