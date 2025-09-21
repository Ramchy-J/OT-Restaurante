package com.ot.restaurant.seeder;

import com.ot.restaurant.builders.ChefBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Chef;
import com.ot.restaurant.repositories.ChefRepository;
import java.util.List;

public class ChefSeeder extends AbstractSeeder<Chef> {

  private final ChefRepository chefRepository;

  public ChefSeeder(ChefRepository chefRepository) {
    this.chefRepository = chefRepository;
  }

  @Override
  public List<Chef> load() {
    return List.of(
        ChefBuilder.create()
            .withFirstName("ChefFirstName1")
            .withLastName("ChefLastName1")
            .withExperience(2)
            .withStatus(Status.ACTIVE)
            .build(),
        ChefBuilder.create()
            .withFirstName("ChefFirstName2")
            .withLastName("ChefLastName2")
            .withExperience(3)
            .withStatus(Status.ACTIVE)
            .build(),
        ChefBuilder.create()
            .withFirstName("ChefFirstName3")
            .withLastName("ChefLastName3")
            .withExperience(4)
            .withStatus(Status.ACTIVE)
            .build());
  }

  @Override
  public void save(List<Chef> chefEntities) {
    chefEntities.forEach(chefRepository::insert);
  }
}
