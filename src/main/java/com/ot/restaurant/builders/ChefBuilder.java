package com.ot.restaurant.builders;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Chef;

public class ChefBuilder {
  private Chef chef = new Chef();

  public static ChefBuilder create() {
    return new ChefBuilder();
  }

  public ChefBuilder withId(Long id) {
    chef.setId(id);
    return this;
  }

  public ChefBuilder withFirstName(String firstName) {
    chef.setFirstName(firstName);
    return this;
  }

  public ChefBuilder withLastName(String lastName) {
    chef.setLastName(lastName);
    return this;
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
