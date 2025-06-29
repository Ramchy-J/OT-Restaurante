package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.ChefBuilder;
import com.ot.restaurant.entities.Chef;
import constants.Status;
import java.util.Optional;

public class ChefFixture {
  public static Chef buildDefaultChef() {
    final var chef = ChefBuilder.create().withExperience(0).withStatus(Status.ACTIVE).build();
    return chef;
  }

  public static Chef buildChefFromExample(Chef chefExample) {
    final var chef =
        ChefBuilder.create()
            .withExperience(Optional.ofNullable(chefExample).map(Chef::getExperience).orElse(0))
            .withStatus(Optional.ofNullable(chefExample).map(Chef::getStatus).orElse(Status.ACTIVE))
            .build();
    return chef;
  }
}
