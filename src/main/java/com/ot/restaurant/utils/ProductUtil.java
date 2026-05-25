package com.ot.restaurant.utils;

import com.ot.restaurant.entities.Chef;
import com.ot.restaurant.entities.Ingredients;
import com.ot.restaurant.entities.Product;

public class ProductUtil {

  public static Double getIngredientCookingType(Ingredients ingredients) {
    return ingredients.getCookingType().getCookingTime();
  }

  public static Double calculateTotalCookingType(Product product) {
    return product.getIngredients().stream()
        .map(ProductUtil::getIngredientCookingType)
        .reduce(0.00, Double::sum);
  }

  public static Double calculatePreparationTime(Product product, Chef chef) {
    return calculateTotalCookingType(product) / chef.getExperience();
  }
}
