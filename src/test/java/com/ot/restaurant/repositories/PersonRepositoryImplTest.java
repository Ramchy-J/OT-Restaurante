package com.ot.restaurant.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ot.restaurant.builders.DummyPersonBuilder;
import com.ot.restaurant.entities.Person;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.PersonFixture;
import constants.Status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonRepositoryImplTest {
  private DummyPersonRepositoryImpl personRepository = new DummyPersonRepositoryImpl();
  private List<Person> personListTest = new ArrayList<>();

  @BeforeEach
  void setUp() {

    final var entities =
        List.of(
            PersonFixture.buildPersonFromExample(
                DummyPersonBuilder.create().withFirstName("Loki1").build()),
            PersonFixture.buildPersonFromExample(
                DummyPersonBuilder.create().withFirstName("Loki2").build()),
            PersonFixture.buildPersonFromExample(
                DummyPersonBuilder.create().withFirstName("Loki3").build()));

    entities.forEach(personRepository::insert);
    personListTest.addAll(entities);
  }

  @Test
  void shouldReturnTheGenericListWhenFindAll() {
    assertEquals(personListTest, personRepository.findAll());
  }

  @Test
  void shouldReturnSpecificGenericWhenFindByIdAndStatusActive() throws Exception {

    final var existingPerson = (personRepository.findById(1L, Status.ACTIVE).get());

    assertEquals(1L, existingPerson.getId());
    assertEquals("Loki2", existingPerson.getFirstName());
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    assertThrows(
        IdNullException.class,
        () -> {
          personRepository.findById(null, Status.ACTIVE);
        });
  }

  @Test
  void shouldAddGenericWhenInsert() throws Exception {
    final var newPerson =
        PersonFixture.buildPersonFromExample(
            DummyPersonBuilder.create().withFirstName("Loki4").build());
    personRepository.insert(newPerson);
    final var existingGeneric = personRepository.findAll();

    assertEquals(
        newPerson,
        personRepository
            .findById(existingGeneric.getLast().getId(), existingGeneric.getLast().getStatus())
            .get());
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var existingPersons = personRepository.findAll();
    final var existingPerson = existingPersons.getLast();

    personRepository.deleteById(existingPerson.getId(), existingPerson);
    final var result =
        personRepository.findById(existingPerson.getId(), existingPerson.getStatus());

    assertEquals(Status.DELETED, result.get().getStatus());
  }
}
