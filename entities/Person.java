package entities;

import constants.Status;

import java.time.Instant;

public class Person extends Base {

    //Attributes

    private String firstName;
    private String lastName;

    //Constructor

    public Person() {
    }

    public Person(Long id, Instant createdDate, Instant updatedDate, Long createdBy, Long updatedBy, Status status, String firstName, String lastName) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.firstName = firstName;
        this.lastName = lastName;
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
}
