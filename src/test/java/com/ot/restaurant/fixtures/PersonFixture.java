package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.DummyPersonBuilder;
import com.ot.restaurant.entities.Person;
import constants.Status;
import java.util.Optional;

public class PersonFixture extends BaseFixture {
  public static Person buildDefaultPerson() {
    final var person =
        DummyPersonBuilder.create().withFirstName("Loki").withLastName("Samahia").build();
    person.setStatus(Status.ACTIVE);
    return person;
  }

  public static Person buildPersonFromExample(Person personExample) {
    final var person =
        DummyPersonBuilder.create()
            .withFirstName(
                Optional.ofNullable(personExample).map(Person::getFirstName).orElse("Loki"))
            .withStatus(
                Optional.ofNullable(personExample).map(Person::getStatus).orElse(Status.ACTIVE))
            .build();
    return person;
  }
}
