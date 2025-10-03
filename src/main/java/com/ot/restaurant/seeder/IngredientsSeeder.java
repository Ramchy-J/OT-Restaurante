package com.ot.restaurant.seeder;

import com.ot.restaurant.builders.IngredientsBuilder;
import com.ot.restaurant.constants.MeasureUnits;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Ingredients;
import com.ot.restaurant.repositories.IngredientsRepository;
import java.util.List;

public class IngredientsSeeder extends AbstractSeeder<Ingredients> {
  private final IngredientsRepository ingredientsRepository;

  public IngredientsSeeder(IngredientsRepository ingredientsRepository) {
    this.ingredientsRepository = ingredientsRepository;
  }

  @Override
  public List<Ingredients> load() {
    return List.of(
        IngredientsBuilder.create()
            .withName("Bread")
            .withUnit(MeasureUnits.BUNS)
            .withQuantity(200.0)
            .withStatus(Status.ACTIVE)
            .build(),
        IngredientsBuilder.create()
            .withName("Cheese")
            .withUnit(MeasureUnits.SLICES)
            .withQuantity(200.0)
            .withStatus(Status.ACTIVE)
            .build(),
        IngredientsBuilder.create()
            .withName("Tomato")
            .withUnit(MeasureUnits.SLICES)
            .withQuantity(200.0)
            .withStatus(Status.ACTIVE)
            .build(),
        IngredientsBuilder.create()
            .withName("Lettuce")
            .withUnit(MeasureUnits.SLICES)
            .withQuantity(200.0)
            .withStatus(Status.ACTIVE)
            .build(),
        IngredientsBuilder.create()
            .withName("BeefMeat")
            .withUnit(MeasureUnits.OUNCES)
            .withQuantity(2000.0)
            .withStatus(Status.ACTIVE)
            .build(),
        IngredientsBuilder.create()
            .withName("ChickenMeat")
            .withUnit(MeasureUnits.OUNCES)
            .withQuantity(2000.0)
            .withStatus(Status.ACTIVE)
            .build(),
        IngredientsBuilder.create()
            .withName("VeggieMeat")
            .withUnit(MeasureUnits.OUNCES)
            .withQuantity(2000.0)
            .withStatus(Status.ACTIVE)
            .build());
  }

  @Override
  public void save(List<Ingredients> ingredientssEntities) {
    ingredientssEntities.forEach(ingredientsRepository::insert);
  }
}
