package com.ot.restaurant.fixtures;

import com.ot.restaurant.entities.Base;
import com.ot.restaurant.entities.DummyBaseEntity;
import constants.Status;
import java.util.Optional;

public class BaseFixture {
  public static Base builDefaultBase() {
    final var base = new DummyBaseEntity();
    base.setCreatedBy(123L);
    base.setStatus(Status.ACTIVE);
    return base;
  }

  public static Base buildBaseFromExample(Base baseExample) {
    final var base = new DummyBaseEntity();
    base.setCreatedBy(Optional.ofNullable(baseExample).map(Base::getCreatedBy).orElse(123L));
    base.setStatus(Optional.ofNullable(baseExample).map(Base::getStatus).orElse(Status.ACTIVE));

    return base;
  }
}
