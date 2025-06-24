package com.ot.restaurant.fixtures;

import com.ot.restaurant.entities.DummyPersonEntity;
import com.ot.restaurant.entities.Person;
import constants.Status;
import java.util.Optional;

public class PersonFixture extends BaseFixture {
  public static Person buildDefaultPerson() {
    final var person = new DummyPersonEntity();
    person.setFirstName("Loki");
    person.setLastName("Samahia");
    person.setStatus(Status.ACTIVE);
    return person;
  }

  public static Person buildPersonFromExample(Person personExample) {
    final var person = new DummyPersonEntity();
    person.setFirstName(
        Optional.ofNullable(personExample).map(Person::getFirstName).orElse("Loki"));
    person.setStatus(
        Optional.ofNullable(personExample).map(Person::getStatus).orElse(Status.ACTIVE));
    return person;
  }
}
