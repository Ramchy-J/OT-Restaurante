package entities;

import constants.Status;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Customer extends Person {
    //Attributes

    private String phoneNumber;

    //Constructors

    public Customer() {
    }

    public Customer(Long id, Instant createdDate, Instant updatedDate, Long createdBy, Long updatedBy, Status status, String firstName, String lastName, String phoneNumber) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status, firstName, lastName);
        this.phoneNumber = phoneNumber;
    }

    //Methods

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


