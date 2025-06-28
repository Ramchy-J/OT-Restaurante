package com.ot.restaurant.builders;

import com.ot.restaurant.entities.Ingredients;
import constants.MeasureUnits;
import constants.Status;

public class IngredientsBuilder {

  private Ingredients ingredients = new Ingredients();

  public static IngredientsBuilder create() {
    return new IngredientsBuilder();
  }

  public IngredientsBuilder withName(String name) {
    ingredients.setName(name);
    return this;
  }

  public IngredientsBuilder withQuantity(Double quantity) {
    ingredients.setQuantity(quantity);
    return this;
  }

  public IngredientsBuilder withUnit(MeasureUnits unit) {
    ingredients.setUnit(unit);
    return this;
  }

  public IngredientsBuilder withStatus(Status status) {
    ingredients.setStatus(status);
    return this;
  }

  public Ingredients build() {
    return ingredients;
  }
}
