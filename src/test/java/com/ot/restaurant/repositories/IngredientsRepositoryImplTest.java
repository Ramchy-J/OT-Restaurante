package com.ot.restaurant.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.ot.restaurant.builders.IngredientsBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Ingredients;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.IngredientsFixture;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngredientsRepositoryImplTest {

  private IngredientsRepositoryImpl<Ingredients> ingredientsRepository =
      new IngredientsRepositoryImpl<>();
  private List<Ingredients> ingredientsListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {

    final var ingredients =
        List.of(
            IngredientsFixture.buildIngredientsFromExample(
                IngredientsBuilder.create().withName("Default1").build()),
            IngredientsFixture.buildIngredientsFromExample(
                IngredientsBuilder.create().withName("Default2").build()),
            IngredientsFixture.buildIngredientsFromExample(
                IngredientsBuilder.create().withName("Default3").build()));
    ingredients.forEach(ingredientsRepository::insert);
    ingredientsListTest.addAll(ingredients);
  }

  @Test
  void shouldReturnTheOrderListWhenFindAll() {

    assertEquals(ingredientsListTest, ingredientsRepository.findAll());
  }

  @Test
  void shouldReturnSpecificOrderWhenFindByIdAndStatusActive() throws Exception {
    final var existingIngredient = ingredientsRepository.findById(1L, Status.ACTIVE).get();
    final var ingredient = existingIngredient.getName();

    assertEquals(1L, existingIngredient.getId());
    assertEquals("Default2", existingIngredient.getName());
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    assertThrows(
        IdNullException.class,
        () -> {
          ingredientsRepository.findById(null, Status.ACTIVE);
        });
  }

  @Test
  void shouldAddOrderWhenInsert() throws Exception {
    final var newIngredient =
        IngredientsFixture.buildIngredientsFromExample(
            IngredientsBuilder.create().withName("Default4").build());
    ingredientsRepository.insert(newIngredient);
    final var existingIngredient = ingredientsRepository.findAll();

    assertEquals(
        existingIngredient.getLast(),
        ingredientsRepository.findById(existingIngredient.getLast().getId(), Status.ACTIVE).get());
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var existingIngredients = ingredientsRepository.findAll();
    final var existingIngredient = existingIngredients.getLast();

    ingredientsRepository.deleteById(existingIngredients.getLast().getId(), existingIngredient);

    final var result =
        ingredientsRepository.findById(existingIngredient.getId(), existingIngredient.getStatus());

    assertEquals(Status.DELETED, result.get().getStatus());
  }
}
