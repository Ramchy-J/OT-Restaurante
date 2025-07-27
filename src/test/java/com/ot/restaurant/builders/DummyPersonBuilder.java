package com.ot.restaurant.builders;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.DummyPersonEntity;
import com.ot.restaurant.entities.Person;

public class DummyPersonBuilder extends DummyGenericBuilder {
  private Person person = new DummyPersonEntity();

  public static DummyPersonBuilder create() {
    return new DummyPersonBuilder();
  }

  public DummyPersonBuilder withFirstName(String firstName) {
    person.setFirstName(firstName);
    return this;
  }

  public DummyPersonBuilder withLastName(String lastName) {
    person.setLastName(lastName);
    return this;
  }

  public DummyPersonBuilder withStatus(Status status) {
    person.setStatus(status);
    return this;
  }

  public Person build() {
    return this.person;
  }
}
