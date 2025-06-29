package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Chef;
import com.ot.restaurant.exceptions.ChefNotFoundException;
import java.util.Optional;

public class ChefRepositoryImpl<E extends Chef> extends PersonRepositoryImpl<E> {
  public void update(Long id, E updatedChef) throws Exception {

    super.update(id, updatedChef);

    var existingChef =
        findById(id, updatedChef.getStatus()).orElseThrow(ChefNotFoundException::new);
    existingChef.setExperience(
        Optional.ofNullable(updatedChef)
            .map(Chef::getExperience)
            .orElseGet(existingChef::getExperience));
  }
}
