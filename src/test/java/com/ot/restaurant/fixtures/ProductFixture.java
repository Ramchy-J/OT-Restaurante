package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.IngredientsBuilder;
import com.ot.restaurant.builders.ProductBuilder;
import com.ot.restaurant.entities.Ingredients;
import com.ot.restaurant.entities.Product;
import constants.Status;
import java.util.List;
import java.util.Optional;

public class ProductFixture {
  public static Product buildDefaultProduct() {
    final List<Ingredients> ingredients =
        List.of(new IngredientsBuilder().withName("Default").build());
    final var product =
        ProductBuilder.create()
            .withName("Default")
            .withPrice(10.0)
            .withCategory("DefaultCategory")
            .withIngredients(ingredients)
            .withstatus(Status.ACTIVE)
            .build();
    return product;
  }

  public static Product buildProductFromExample(Product productExample) {
    final var product =
        ProductBuilder.create()
            .withName(Optional.ofNullable(productExample).map(Product::getName).orElse("Default"))
            .withstatus(
                Optional.ofNullable(productExample).map(Product::getStatus).orElse(Status.ACTIVE))
            .build();
    return product;
  }
}
