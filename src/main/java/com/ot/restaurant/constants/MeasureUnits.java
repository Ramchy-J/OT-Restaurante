package com.ot.restaurant.constants;

public enum MeasureUnits {
  TABLESPOONS("tbsp"),
  TEASPOONS("tsp"),
  CUPS("cup"),
  GRAMS("g"),
  MILLILITERS("ml"),
  OUNCES("oz"),
  POUNDS("lb"),
  PINTS("pt"),
  QUARTS("qt"),
  LITERS("l"),
  BUNS("buns"),
  SLICES("slc");

  private final String abbreviation;

  MeasureUnits(final String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public String getAbbreviation() {
    return abbreviation;
  }
}
