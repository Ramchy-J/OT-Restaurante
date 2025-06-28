package com.ot.restaurant.builders;

import com.ot.restaurant.entities.Base;
import com.ot.restaurant.entities.DummyBaseEntity;
import constants.Status;
import java.time.Instant;

public class DummyGenericBuilder {
  private Base base = new DummyBaseEntity();

  public DummyGenericBuilder() {}

  public static DummyGenericBuilder create() {
    return new DummyGenericBuilder();
  }

  public DummyGenericBuilder withID(Long id) {
    base.setId(id);
    return this;
  }

  public DummyGenericBuilder withCreatedDate(Instant createdDate) {
    base.setCreatedDate(createdDate);
    return this;
  }

  public DummyGenericBuilder withUpdatedDate(Instant updatedDate) {
    base.setUpdatedDate(updatedDate);
    return this;
  }

  public DummyGenericBuilder withCreatedBy(Long createdBy) {
    base.setCreatedBy(createdBy);
    return this;
  }

  public DummyGenericBuilder withStatus(Status status) {
    base.setStatus(status);
    return this;
  }

  public Base build() {
    return this.base;
  }
}
