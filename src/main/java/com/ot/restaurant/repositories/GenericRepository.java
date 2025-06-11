package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Base;
import constants.Status;
import java.util.List;
import java.util.Optional;

public interface GenericRepository<E extends Base> {
  List<E> findAll() throws Exception;

  Optional<E> findById(Long id, Status status) throws Exception;

  void insert(E entity) throws Exception;

  void update(Long id, E entity) throws Exception;

  void deleteById(Long id, E entity) throws Exception;
}
