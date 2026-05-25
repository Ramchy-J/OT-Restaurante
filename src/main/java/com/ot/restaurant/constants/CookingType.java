package com.ot.restaurant.constants;

public enum CookingType {
  FRYING(2.00),
  ADDING(1.00),
  BAKING(3.00);

  private final Double cookingTime;

  CookingType(final Double cookingTime) {
    this.cookingTime = cookingTime;
  }

  public Double getCookingTime() {
    return cookingTime;
  }
}
