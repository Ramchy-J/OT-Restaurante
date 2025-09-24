package com.ot.restaurant.builders;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Ingredients;
import com.ot.restaurant.entities.Product;
import java.util.List;

public class ProductBuilder {
  private Product product = new Product();

  public static ProductBuilder create() {
    return new ProductBuilder();
  }

  public ProductBuilder withName(String name) {
    product.setName(name);
    return this;
  }

  public ProductBuilder withPrice(Double price) {
    product.setPrice(price);
    return this;
  }

  public ProductBuilder withCategory(String category) {
    product.setCategory(category);
    return this;
  }

  public ProductBuilder withIngredients(List<Ingredients> ingredients) {
    product.setIngredients(ingredients);
    return this;
  }

  public ProductBuilder withStatus(Status status) {
    product.setStatus(status);
    return this;
  }

  public Product build() {
    final var newProduct = new Product();
    newProduct.setId(this.product.getId());
    newProduct.setName(this.product.getName());
    newProduct.setPrice(this.product.getPrice());
    newProduct.setCategory(this.product.getCategory());
    newProduct.setIngredients(this.product.getIngredients());
    newProduct.setStatus(this.product.getStatus());

    return newProduct;
  }
}
