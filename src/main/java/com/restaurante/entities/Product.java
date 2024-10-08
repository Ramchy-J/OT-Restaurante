package com.restaurante.entities;

import constants.Status;
import entities.Base;
import java.time.Instant;
import java.util.List;

public class Product extends Base {

    // Attributes

    private String name;
    private Double price;
    private String category;
    private List<Ingredients> ingredients;

    // Constructors

    public Product() {}

    public Product(
            final Long id,
            final Instant createdDate,
            final Instant updatedDate,
            final Long createdBy,
            final Long updatedBy,
            final Status status,
            final String name,
            final Double price,
            final String category,
            final List<Ingredients> ingredients) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
    }

    // Methods

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(final List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
