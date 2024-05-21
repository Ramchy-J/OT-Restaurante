package entities;

import constants.Status;
import constants.MeasureUnits;

import java.time.Instant;

public class Ingredients extends Base {

    //Attributes

    private String name;
    private Double quantity;
    private MeasureUnits unit;

    //Constructors

    public Ingredients() {
    }

    public Ingredients(Long id, Instant createdDate, Instant updatedDate, Long createdBy, Long updatedBy, Status status, String name, Double quantity, MeasureUnits unit) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

//Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public MeasureUnits getUnit() {
        return unit;
    }

    public void setUnit(MeasureUnits unit) {
        this.unit = unit;
    }
}

