package com.ot.restaurant.controllers;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Chef;
import com.ot.restaurant.exceptions.ChefNotFoundException;
import com.ot.restaurant.repositories.ChefRepository;
import java.util.List;

public class ChefController {
  private ChefRepository<Chef> chefRepository;

  public ChefController(ChefRepository<Chef> chefRepository) {
    this.chefRepository = chefRepository;
  }

  public List<Chef> findAll() throws Exception {
    return chefRepository.findAll();
  }

  public Chef findById(Long id, Status status) throws Exception {
    return chefRepository.findById(id, status).orElseThrow(ChefNotFoundException::new);
  }

  public void insert(Chef chef) throws Exception {
    chefRepository.insert(chef);
  }

  public void update(Long id, Chef chef) throws Exception {
    chefRepository.update(id, chef);
  }

  public void deleteById(Long id, Chef chef) throws Exception {
    chefRepository.deleteById(id, chef);
  }
}
