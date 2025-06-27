package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.DummyGenericBuilder;
import com.ot.restaurant.entities.Base;
import constants.Status;
import java.util.Optional;

public class BaseFixture {
  public static Base builDefaultBase() {
    final var base =
        DummyGenericBuilder.create().withCreatedBy(123L).withStatus(Status.ACTIVE).build();
    return base;
  }

  public static Base buildBaseFromExample(Base baseExample) {
    final var base =
        DummyGenericBuilder.create()
            .withCreatedBy(Optional.ofNullable(baseExample).map(Base::getCreatedBy).orElse(123L))
            .withStatus(Optional.ofNullable(baseExample).map(Base::getStatus).orElse(Status.ACTIVE))
            .build();
    return base;
  }
}
