package com.ot.restaurant.repositories;

import com.ot.restaurant.exceptions.CustomerNotFoundException;
import com.ot.restaurant.exceptions.IdNullException;
import constants.Status;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public abstract class GenericRepositoryImpl<E extends com.ot.restaurant.entities.Base>
    implements GenericRepository<E> {
  private final TreeMap<Long, E> treeMapDataStore = new TreeMap<Long, E>();
  private Long nextId = 0L;

  private Long generateNextId() {
    Long currentId = nextId;
    nextId++;
    return currentId;
  }

  public List<E> findAll() {
    return treeMapDataStore.values().stream()
        .filter(entity -> entity.getStatus().equals(Status.ACTIVE))
        .toList();
  }

  public Optional<E> findById(Long id, Status status) throws Exception {
    Optional.ofNullable(id).orElseThrow(IdNullException::new);

    return Optional.ofNullable(treeMapDataStore.get(id))
        .map(Optional::of)
        .orElseThrow(CustomerNotFoundException::new);
  }

  public void insert(E entity) {
    entity.setId(generateNextId());
    entity.setCreatedDate(
        Optional.ofNullable(entity)
            .map(com.ot.restaurant.entities.Base::getCreatedDate)
            .orElseGet(Instant::now));
    entity.setStatus(
        Optional.ofNullable(entity)
            .map(com.ot.restaurant.entities.Base::getStatus)
            .orElse(Status.ACTIVE));

    treeMapDataStore.put(entity.getId(), entity);
  }

  public void update(Long id, E updatedEntity) throws Exception {
    var existingEntity =
        findById(id, updatedEntity.getStatus()).orElseThrow(CustomerNotFoundException::new);

    existingEntity.setUpdatedBy(
        Optional.ofNullable(updatedEntity)
            .map(com.ot.restaurant.entities.Base::getUpdatedBy)
            .orElseGet(existingEntity::getUpdatedBy));

    final var defaultUpdatedDate =
        Optional.ofNullable(updatedEntity)
            .map(com.ot.restaurant.entities.Base::getUpdatedDate)
            .orElseGet(Instant::now);

    existingEntity.setUpdatedDate(
        Optional.ofNullable(updatedEntity)
            .map(com.ot.restaurant.entities.Base::getUpdatedDate)
            .orElse(defaultUpdatedDate));
  }

  public void deleteById(Long id, E entity) throws Exception {
    final var existingType = findById(id, entity.getStatus());
    existingType.get().setStatus(Status.DELETED);
    update(id, entity);
  }

  public static class GenericRepositoryImplHelper extends GenericRepositoryImpl {}
}
