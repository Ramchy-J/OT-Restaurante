package com.ot.restaurant.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.ot.restaurant.builders.ChefBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Chef;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.ChefFixture;
import com.ot.restaurant.repositories.ChefRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChefControllerTest {

  private ChefRepository chefRepositorySpy = spy(ChefRepository.class);
  private ChefController chefController = new ChefController(chefRepositorySpy);
  private List<Chef> chefListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void shouldReturnTheChefListWhenFindAll() throws Exception {
    when(chefRepositorySpy.findAll()).thenReturn(new ArrayList<>());

    chefController.findAll();

    verify(chefRepositorySpy, times(1)).findAll();
  }

  @Test
  void shouldReturnSpecificChefWhenFindByIdAndStatusActive() throws Exception {

    when(chefRepositorySpy.findById(1L, Status.ACTIVE)).thenReturn(Optional.empty());

    chefRepositorySpy.findById(1L, Status.ACTIVE);

    verify(chefRepositorySpy, times(1)).findById(1L, Status.ACTIVE);
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    when(chefRepositorySpy.findById(null, Status.ACTIVE)).thenThrow(IdNullException.class);

    verify(chefRepositorySpy, times(0)).findById(null, Status.ACTIVE);
  }

  @Test
  void shouldAddChefWhenInsert() throws Exception {
    final var newChef =
        ChefFixture.buildChefFromExample(ChefBuilder.create().withExperience(3).build());
    chefListTest.add(newChef);

    doNothing().when(chefRepositorySpy).insert(newChef);
    chefController.insert(newChef);
    verify(chefRepositorySpy, times(1)).insert(newChef);
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var newChef =
        ChefFixture.buildChefFromExample(ChefBuilder.create().withExperience(3).build());
    chefListTest.add(newChef);
    final var existingChef = chefListTest.getLast();

    doNothing().when(chefRepositorySpy).deleteById(existingChef.getId(), existingChef);
    chefController.deleteById(existingChef.getId(), existingChef);
    verify(chefRepositorySpy, times(1)).deleteById(existingChef.getId(), existingChef);
  }
}
