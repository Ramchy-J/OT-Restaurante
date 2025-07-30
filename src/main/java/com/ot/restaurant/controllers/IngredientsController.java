package com.ot.restaurant.controllers;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Ingredients;
import com.ot.restaurant.exceptions.IngredientsNotFoundException;
import com.ot.restaurant.repositories.IngredientsRepository;
import java.util.List;

public class IngredientsController {

  private IngredientsRepository<Ingredients> ingredientsRepository;

  public IngredientsController(IngredientsRepository<Ingredients> ingredientsRepository) {
    this.ingredientsRepository = ingredientsRepository;
  }

  public List<Ingredients> findAll() throws Exception {
    return ingredientsRepository.findAll();
  }

  public Ingredients findById(Long id, Status status) throws Exception {
    return ingredientsRepository
        .findById(id, status)
        .orElseThrow(IngredientsNotFoundException::new);
  }

  public void insert(Ingredients ingredients) throws Exception {
    ingredientsRepository.insert(ingredients);
  }

  public void update(Long id, Ingredients ingredients) throws Exception {
    ingredientsRepository.update(id, ingredients);
  }

  public void deleteById(Long id, Ingredients ingredients) throws Exception {
    ingredientsRepository.deleteById(id, ingredients);
  }
}
