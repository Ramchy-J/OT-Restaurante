package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Person;
import java.util.Optional;

public abstract class PersonRepositoryImpl<P extends com.ot.restaurant.entities.Person>
    extends GenericRepositoryImpl<P> {

  public void update(Long id, P updatedEntity) throws Exception {

    super.update(id, updatedEntity);

    var existingType = findById(id, updatedEntity.getStatus()).orElseThrow(null);
    existingType.setFirstName(
        Optional.ofNullable(updatedEntity)
            .map(com.ot.restaurant.entities.Person::getFirstName)
            .orElseGet(existingType::getFirstName));
    existingType.setLastName(
        Optional.ofNullable(updatedEntity)
            .map(Person::getLastName)
            .orElseGet(existingType::getLastName));
  }
}
