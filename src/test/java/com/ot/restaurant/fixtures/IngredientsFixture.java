package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.IngredientsBuilder;
import com.ot.restaurant.entities.Ingredients;
import constants.MeasureUnits;
import constants.Status;
import java.util.Optional;

public class IngredientsFixture {
  public static Ingredients buildDefaultIngredients() {
    final var ingredients =
        new IngredientsBuilder()
            .withName("Default")
            .withQuantity(10.0)
            .withUnit(MeasureUnits.MILLILITERS)
            .build();

    ingredients.setStatus(Status.ACTIVE);
    return ingredients;
  }

  public static Ingredients buildIngredientsFromExample(Ingredients ingredientsExample) {
    final var ingredient =
        new IngredientsBuilder()
            .withName(
                Optional.ofNullable(ingredientsExample).map(Ingredients::getName).orElse("Default"))
            .build();
    ingredient.setStatus(
        Optional.ofNullable(ingredientsExample).map(Ingredients::getStatus).orElse(Status.ACTIVE));
    return ingredient;
  }
}
