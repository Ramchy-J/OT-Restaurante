package com.ot.restaurant.builders;

import com.ot.restaurant.entities.Chef;
import constants.Status;

public class ChefBuilder {
  private Chef chef = new Chef();

  public static ChefBuilder create() {
    return new ChefBuilder();
  }

  public ChefBuilder withExperience(Integer experience) {
    chef.setExperience(experience);
    return this;
  }

  public ChefBuilder withStatus(Status status) {
    chef.setStatus(status);
    return this;
  }

  public Chef build() {
    return chef;
  }
}
