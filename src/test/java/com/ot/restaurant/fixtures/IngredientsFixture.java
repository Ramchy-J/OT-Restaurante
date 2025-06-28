package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.IngredientsBuilder;
import com.ot.restaurant.entities.Ingredients;
import constants.MeasureUnits;
import constants.Status;
import java.util.Optional;

public class IngredientsFixture {
  public static Ingredients buildDefaultIngredients() {
    final var ingredients =
        IngredientsBuilder.create()
            .withName("Default")
            .withQuantity(10.0)
            .withUnit(MeasureUnits.MILLILITERS)
            .withStatus(Status.ACTIVE)
            .build();
    return ingredients;
  }

  public static Ingredients buildIngredientsFromExample(Ingredients ingredientsExample) {
    final var ingredient =
        IngredientsBuilder.create()
            .withName(
                Optional.ofNullable(ingredientsExample).map(Ingredients::getName).orElse("Default"))
            .withStatus(
                Optional.ofNullable(ingredientsExample)
                    .map(Ingredients::getStatus)
                    .orElse(Status.ACTIVE))
            .build();
    return ingredient;
  }
}
