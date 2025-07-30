package com.ot.restaurant.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.ot.restaurant.builders.IngredientsBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Ingredients;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.IngredientsFixture;
import com.ot.restaurant.repositories.IngredientsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngredientsControllerTest {

  private IngredientsRepository ingredientsRepositorySpy = spy(IngredientsRepository.class);
  private IngredientsController ingredientsController =
      new IngredientsController(ingredientsRepositorySpy);
  private List<Ingredients> ingredientsListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void shouldReturnTheIngredientsListWhenFindAll() throws Exception {
    when(ingredientsRepositorySpy.findAll()).thenReturn(new ArrayList<>());

    ingredientsController.findAll();

    verify(ingredientsRepositorySpy, times(1)).findAll();
  }

  @Test
  void shouldReturnSpecificIngredientsWhenFindByIdAndStatusActive() throws Exception {

    when(ingredientsRepositorySpy.findById(1L, Status.ACTIVE)).thenReturn(Optional.empty());

    ingredientsRepositorySpy.findById(1L, Status.ACTIVE);

    verify(ingredientsRepositorySpy, times(1)).findById(1L, Status.ACTIVE);
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    when(ingredientsRepositorySpy.findById(null, Status.ACTIVE)).thenThrow(IdNullException.class);

    verify(ingredientsRepositorySpy, times(0)).findById(null, Status.ACTIVE);
  }

  @Test
  void shouldAddIngredientsWhenInsert() throws Exception {
    final var newIngredients =
        IngredientsFixture.buildIngredientsFromExample(
            IngredientsBuilder.create().withName("Samahia").build());
    ingredientsListTest.add(newIngredients);

    doNothing().when(ingredientsRepositorySpy).insert(newIngredients);
    ingredientsController.insert(newIngredients);
    verify(ingredientsRepositorySpy, times(1)).insert(newIngredients);
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var newIngredients =
        IngredientsFixture.buildIngredientsFromExample(
            IngredientsBuilder.create().withName("Samahia").build());
    ingredientsListTest.add(newIngredients);
    final var existingIngredients = ingredientsListTest.getLast();

    doNothing()
        .when(ingredientsRepositorySpy)
        .deleteById(existingIngredients.getId(), existingIngredients);
    ingredientsController.deleteById(existingIngredients.getId(), existingIngredients);
    verify(ingredientsRepositorySpy, times(1))
        .deleteById(existingIngredients.getId(), existingIngredients);
  }
}
