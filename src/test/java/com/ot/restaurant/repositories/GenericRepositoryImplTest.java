package com.ot.restaurant.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ot.restaurant.builders.DummyGenericBuilder;
import com.ot.restaurant.entities.Base;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.BaseFixture;
import constants.Status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericRepositoryImplTest {

  private DummyGenericRepositoryImpl genericRepository = new DummyGenericRepositoryImpl();
  private List<Base> genericListTest = new ArrayList<>();

  @BeforeEach
  void setUp() {

    final var entities =
        List.of(
            BaseFixture.buildBaseFromExample(
                DummyGenericBuilder.create().withCreatedBy(123L).build()),
            BaseFixture.buildBaseFromExample(
                DummyGenericBuilder.create().withCreatedBy(456L).build()),
            BaseFixture.buildBaseFromExample(
                DummyGenericBuilder.create().withCreatedBy(789L).build()));

    entities.forEach(genericRepository::insert);
    genericListTest.addAll(entities);
  }

  @Test
  void shouldReturnTheGenericListWhenFindAll() {
    assertEquals(genericListTest, genericRepository.findAll());
  }

  @Test
  void shouldReturnSpecificGenericWhenFindByIdAndStatusActive() throws Exception {

    final var existingGeneric = (genericRepository.findById(1L, Status.ACTIVE).get());

    assertEquals(1L, existingGeneric.getId());
    assertEquals(456L, existingGeneric.getCreatedBy());
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    assertThrows(
        IdNullException.class,
        () -> {
          genericRepository.findById(null, Status.ACTIVE);
        });
  }

  @Test
  void shouldAddGenericWhenInsert() throws Exception {
    final var newGeneric =
        BaseFixture.buildBaseFromExample(DummyGenericBuilder.create().withCreatedBy(159L).build());
    genericRepository.insert(newGeneric);
    final var existingGeneric = genericRepository.findAll();

    assertEquals(
        newGeneric,
        genericRepository
            .findById(existingGeneric.getLast().getId(), existingGeneric.getLast().getStatus())
            .get());
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var existingGenerics = genericRepository.findAll();
    final var existingGeneric = existingGenerics.getLast();

    genericRepository.deleteById(existingGeneric.getId(), existingGeneric);
    final var result =
        genericRepository.findById(existingGeneric.getId(), existingGeneric.getStatus());

    assertEquals(Status.DELETED, result.get().getStatus());
  }
}
