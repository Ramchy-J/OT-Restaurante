package com.ot.restaurant.seeder;

import java.util.List;

public abstract class AbstractSeeder<E> implements Seeder<E> {

  public void seed() throws Exception {
    List<E> entities = load();
    save(entities);
  }
}
