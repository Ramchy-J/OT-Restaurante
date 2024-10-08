package com.restaurante.entities;

import constants.Status;
import java.time.Instant;

public class Chef extends Person {

    // Attributes

    private Integer experience;

    // Constructors

    public Chef() {}

    public Chef(
            final Long id,
            final Instant createdDate,
            final Instant updatedDate,
            final Long createdBy,
            final Long updatedBy,
            final Status status,
            final String firstName,
            final String lastName,
            final Integer experience) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status, firstName, lastName);
        this.experience = experience;
    }

    // Methods

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(final Integer experience) {
        this.experience = experience;
    }
}
