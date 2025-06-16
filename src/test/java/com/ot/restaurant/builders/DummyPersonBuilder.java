package com.ot.restaurant.builders;

import com.ot.restaurant.entities.Person;
import constants.Status;
import java.time.Instant;

public class DummyPersonBuilder extends DummyGenericBuilder {
  // private Person person = new DummyPersonEntity();
  private String firstName;
  private String lastName;

  public DummyPersonBuilder withFirstName(String firstName) {
    // person.setFirstName(firstName);
    this.firstName = firstName;
    return this;
  }

  public DummyPersonBuilder withLastName(String lastName) {
    // person.setLastName(lastName);
    this.lastName = lastName;
    return this;
  }

  public Person build() {
    // return this.person;
    Long id = null;
    Instant createdDate = null;
    Instant updatedDate = null;
    Long createdBy = null;
    Long updatedBy = null;
    Status status = null;

    return new Person(
        id, createdDate, updatedDate, createdBy, updatedBy, status, firstName, lastName) {};
  }
}
