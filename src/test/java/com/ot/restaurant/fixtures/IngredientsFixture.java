package com.ot.restaurant.fixtures;

import com.ot.restaurant.entities.Ingredients;
import constants.MeasureUnits;
import constants.Status;
import java.util.Optional;

public class IngredientsFixture {
  public static Ingredients buildDefaultIngredients() {
    final var ingredients = new Ingredients();
    ingredients.setName("Default");
    ingredients.setQuantity(10.0);
    ingredients.setUnit(MeasureUnits.MILLILITERS);
    ingredients.setStatus(Status.ACTIVE);
    return ingredients;
  }

  public static Ingredients buildIngredientsFromExample(Ingredients ingredientsExample) {
    final var ingredient = new Ingredients();
    ingredient.setName(
        Optional.ofNullable(ingredientsExample).map(Ingredients::getName).orElse("Default"));
    ingredient.setStatus(
        Optional.ofNullable(ingredientsExample).map(Ingredients::getStatus).orElse(Status.ACTIVE));
    return ingredient;
  }
}
