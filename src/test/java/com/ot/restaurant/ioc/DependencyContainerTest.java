package com.ot.restaurant.ioc;

import static org.junit.jupiter.api.Assertions.*;

import com.ot.restaurant.controllers.IngredientsController;
import com.ot.restaurant.exceptions.DependencyNotFoundException;
import com.ot.restaurant.repositories.ChefRepositoryImpl;
import com.ot.restaurant.repositories.CustomerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IoCContainerInitializerTest {

  private final IoCContainerInitializer dependencyContainer = new IoCContainerInitializer();
  private final IoCContainer ioc = IoCContainer.getInstance();

  @BeforeEach
  void setUp() {}

  @Test
  void shouldTrowsExceptionWhenResolveWithoutInitialize() {

    assertThrows(
        DependencyNotFoundException.class,
        () -> {
          ioc.resolve("chefRepository");
        });

    assertThrows(
        DependencyNotFoundException.class,
        () -> {
          ioc.resolve("customerRepository");
        });

    assertThrows(
        DependencyNotFoundException.class,
        () -> {
          ioc.resolve("ingredientsController");
        });
  }

  @Test
  void shouldReturnSpecificInstanceWhenResolve() throws Exception {

    dependencyContainer.initialize();

    final var instance1 = ioc.resolve("chefRepository");
    assertEquals(ChefRepositoryImpl.class, instance1.getClass());

    final var instance2 = ioc.resolve("customerRepository");
    assertEquals(CustomerRepositoryImpl.class, instance2.getClass());

    final var instance3 = ioc.resolve("ingredientsController");
    assertEquals(IngredientsController.class, instance3.getClass());
  }
}
