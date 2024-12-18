package com.ot.restaurant.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ot.restaurant.exceptions.DependencyKeyNullpointerException;
import com.ot.restaurant.exceptions.DependencyNotFoundException;
import com.ot.restaurant.exceptions.DependencyValueNullpointerException;
import com.ot.restaurant.exceptions.DuplicatedDependencyFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IoCContainerTest {

  private IoCContainer ioc;
  private IoCContainer ioc2;
  private String key;
  private String key2;
  private String key3;
  private Object value;

  @BeforeEach
  void init() {
    ioc = IoCContainer.getInstance();
    ioc2 = IoCContainer.getInstance();
    key = "keyEntiti";
    key2 = null;
    key3 = "keyEntiti3";
    value = new Object();
  }

  @Test
  void shouldInstanceTheSameInstanceWhenInstantiatingIoCContainer() {

    assertEquals(ioc, ioc2);
  }

  @Test
  void shouldResolveValueWhenRegisterValue() throws Exception {

    ioc.register(key, value);

    final var  valueResolvedIoC = ioc.resolve(key);

    assertEquals(value, valueResolvedIoC);
  }

  @Test
  void shouldThrowsExceptionWhenRegisterDuplicated() {

    assertThrows(
        DuplicatedDependencyFoundException.class,
        () -> {
          ioc.register(key, value);
          ioc.register(key, value);
        });
  }

  @Test
  void shouldThrowsExceptionWhenRegisterNullValue() {

    assertThrows(
        DependencyKeyNullpointerException.class,
        () -> {
          String key = null;
          ioc.register(key, value);
        });
  }

  @Test
  void shouldThrowsExceptionWhenResolveNullpointer() {

    assertThrows(
        DependencyValueNullpointerException.class,
        () -> {
          ioc.resolve(key2);
        });
  }

  @Test
  void shouldThrowsExceptionWhenResolveNotFoundValue() {

    assertThrows(
        DependencyNotFoundException.class,
        () -> {
          ioc.resolve(key3);
        });
  }
}
