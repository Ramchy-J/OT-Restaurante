package com.ot.restaurant.seeder;

import com.ot.restaurant.builders.IngredientsBuilder;
import com.ot.restaurant.builders.ProductBuilder;
import com.ot.restaurant.constants.MeasureUnits;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Product;
import com.ot.restaurant.repositories.ProductRepository;
import java.util.List;

public class ProductSeeder extends AbstractSeeder<Product> {
  private final ProductRepository productRepository;

  public ProductSeeder(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> load() {

    final var cheeseburgerIngredients =
        List.of(
            IngredientsBuilder.create()
                .withName("Bread")
                .withUnit(MeasureUnits.BUNS)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("Cheese")
                .withUnit(MeasureUnits.SLICES)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("Tomato")
                .withUnit(MeasureUnits.SLICES)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("Lettuce")
                .withUnit(MeasureUnits.SLICES)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("BeefMeat")
                .withUnit(MeasureUnits.OUNCES)
                .withQuantity(20.0)
                .withStatus(Status.ACTIVE)
                .build());

    final var chickenburgerIngredients =
        List.of(
            IngredientsBuilder.create()
                .withName("Bread")
                .withUnit(MeasureUnits.BUNS)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("Cheese")
                .withUnit(MeasureUnits.SLICES)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("Tomato")
                .withUnit(MeasureUnits.SLICES)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("Lettuce")
                .withUnit(MeasureUnits.SLICES)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("ChickenMeat")
                .withUnit(MeasureUnits.OUNCES)
                .withQuantity(20.0)
                .withStatus(Status.ACTIVE)
                .build());

    final var veggieburgerIngredients =
        List.of(
            IngredientsBuilder.create()
                .withName("Bread")
                .withUnit(MeasureUnits.BUNS)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("Cheese")
                .withUnit(MeasureUnits.SLICES)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("Tomato")
                .withUnit(MeasureUnits.SLICES)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("Lettuce")
                .withUnit(MeasureUnits.SLICES)
                .withQuantity(2.0)
                .withStatus(Status.ACTIVE)
                .build(),
            IngredientsBuilder.create()
                .withName("VeggieMeat")
                .withUnit(MeasureUnits.OUNCES)
                .withQuantity(20.0)
                .withStatus(Status.ACTIVE)
                .build());

    return List.of(
        ProductBuilder.create()
            .withName("Cheeseburger")
            .withPrice(10.0)
            .withCategory("Burger")
            .withIngredients(cheeseburgerIngredients)
            .withStatus(Status.ACTIVE)
            .build(),
        ProductBuilder.create()
            .withName("Chickenburger")
            .withPrice(10.0)
            .withCategory("Burger")
            .withIngredients(chickenburgerIngredients)
            .withStatus(Status.ACTIVE)
            .build(),
        ProductBuilder.create()
            .withName("Veggieburger")
            .withPrice(10.0)
            .withCategory("Burger")
            .withIngredients(veggieburgerIngredients)
            .withStatus(Status.ACTIVE)
            .build());
  }

  @Override
  public void save(List<Product> productsEntities) {
    productsEntities.forEach(productRepository::insert);
  }
}
