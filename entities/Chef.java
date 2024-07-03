package entities;

import constants.Status;

import java.time.Instant;
import java.util.List;

public class Chef extends Person {

    //Attributes

    private Integer experience;

    //Constructors

    public Chef() {
    }

    public Chef(Long id, Instant createdDate, Instant updatedDate, Long createdBy, Long updatedBy, Status status, String firstName, String lastName, Integer experience) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status, firstName, lastName);
        this.experience = experience;
    }

    //Methods

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }
}

