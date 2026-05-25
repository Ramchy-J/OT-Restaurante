package com.ot.restaurant.entities;

import com.ot.restaurant.constants.CookingType;
import com.ot.restaurant.constants.MeasureUnits;
import com.ot.restaurant.constants.Status;
import java.time.Instant;

public class Ingredients extends Base {

  // Attributes

  private String name;
  private Double quantity;
  private MeasureUnits unit;

  private CookingType cookingType;

  // Constructors

  public Ingredients() {}

  public Ingredients(
      final Long id,
      final Instant createdDate,
      final Instant updatedDate,
      final Long createdBy,
      final Long updatedBy,
      final Status status,
      final String name,
      final Double quantity,
      final MeasureUnits unit,
      final CookingType cookingType) {
    super(id, createdDate, updatedDate, createdBy, updatedBy, status);
    this.name = name;
    this.quantity = quantity;
    this.unit = unit;
    this.cookingType = cookingType;
  }

  // Methods

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(final Double quantity) {
    this.quantity = quantity;
  }

  public MeasureUnits getUnit() {
    return unit;
  }

  public void setUnit(final MeasureUnits unit) {
    this.unit = unit;
  }

  public CookingType getCookingType() {
    return cookingType;
  }

  public void setCookingType(CookingType cookingType) {
    this.cookingType = cookingType;
  }
}
