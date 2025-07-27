package com.ot.restaurant.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.ot.restaurant.builders.ChefBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Chef;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.ChefFixture;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChefRepositoryImplTest {

  private ChefRepositoryImpl<Chef> chefRepository = new ChefRepositoryImpl<>();
  private List<Chef> chefListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {

    final var chefs =
        List.of(
            ChefFixture.buildChefFromExample(ChefBuilder.create().withExperience(1).build()),
            ChefFixture.buildChefFromExample(ChefBuilder.create().withExperience(2).build()),
            ChefFixture.buildChefFromExample(ChefBuilder.create().withExperience(3).build()));
    chefs.forEach(chefRepository::insert);
    chefListTest.addAll(chefs);
  }

  @Test
  void shouldReturnTheChefListWhenFindAll() {

    assertEquals(chefListTest, chefRepository.findAll());
  }

  @Test
  void shouldReturnSpecificChefWhenFindByIdAndStatusActive() throws Exception {
    final var existingChef = chefRepository.findById(1L, Status.ACTIVE).get();

    assertEquals(1L, existingChef.getId());
    assertEquals(2, existingChef.getExperience());
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    assertThrows(
        IdNullException.class,
        () -> {
          chefRepository.findById(null, Status.ACTIVE);
        });
  }

  @Test
  void shouldAddChefWhenInsert() throws Exception {
    final var newChef =
        ChefFixture.buildChefFromExample(ChefBuilder.create().withExperience(4).build());
    chefRepository.insert(newChef);
    final var existingChefs = chefRepository.findAll();

    assertEquals(
        existingChefs.getLast(),
        chefRepository.findById(existingChefs.getLast().getId(), Status.ACTIVE).get());
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var existingChefs = chefRepository.findAll();
    final var existingChef = existingChefs.getLast();

    chefRepository.deleteById(existingChefs.getLast().getId(), existingChef);

    final var result = chefRepository.findById(existingChef.getId(), existingChef.getStatus());

    assertEquals(Status.DELETED, result.get().getStatus());
  }
}
