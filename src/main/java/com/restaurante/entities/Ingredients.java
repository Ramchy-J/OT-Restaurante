package com.restaurante.entities;

import constants.MeasureUnits;
import constants.Status;
import entities.Base;
import java.time.Instant;

public class Ingredients extends Base {

    // Attributes

    private String name;
    private Double quantity;
    private MeasureUnits unit;

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
            final MeasureUnits unit) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
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
}
