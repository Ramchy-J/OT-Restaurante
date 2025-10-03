package com.ot.restaurant.seeder;

import java.util.List;

public abstract class AbstractSeeder<E> implements Seeder<E> {

  public void seed() {
    List<E> entities = null;
    try {
      entities = load();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    save(entities);
  }
}
