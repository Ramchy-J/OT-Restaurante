package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.DummyGenericBuilder;
import com.ot.restaurant.entities.Base;
import constants.Status;
import java.util.Optional;

public class BaseFixture {
  public static Base builDefaultBase() {
    final var base = new DummyGenericBuilder().withCreatedBy(123L).build();
    base.setStatus(Status.ACTIVE);
    return base;
  }

  public static Base buildBaseFromExample(Base baseExample) {
    final var base =
        new DummyGenericBuilder()
            .withCreatedBy(Optional.ofNullable(baseExample).map(Base::getCreatedBy).orElse(123L))
            .build();
    base.setStatus(Optional.ofNullable(baseExample).map(Base::getStatus).orElse(Status.ACTIVE));
    return base;
  }
}
