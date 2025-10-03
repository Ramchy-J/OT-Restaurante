package com.ot.restaurant.seeder;

import java.util.List;

public interface Seeder<E> {
  List<E> load() throws Exception;

  void save(List<E> entities);
}
