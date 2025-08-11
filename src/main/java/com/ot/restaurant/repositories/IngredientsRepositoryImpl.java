package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Ingredients;
import com.ot.restaurant.exceptions.IngredientsNotFoundException;
import java.util.Optional;

public class IngredientsRepositoryImpl<E extends Ingredients> extends GenericRepositoryImpl<E>
    implements IngredientsRepository<E> {
  public void update(Long id, E updatedIngredients) throws Exception {

    super.update(id, updatedIngredients);

    var existingIngredients =
        findById(id, updatedIngredients.getStatus()).orElseThrow(IngredientsNotFoundException::new);
    existingIngredients.setName(
        Optional.ofNullable(updatedIngredients)
            .map(Ingredients::getName)
            .orElseGet(existingIngredients::getName));
    existingIngredients.setQuantity(
        Optional.ofNullable(updatedIngredients)
            .map(Ingredients::getQuantity)
            .orElseGet(existingIngredients::getQuantity));
    existingIngredients.setUnit(
        Optional.ofNullable(updatedIngredients)
            .map(Ingredients::getUnit)
            .orElseGet(existingIngredients::getUnit));
  }
}
