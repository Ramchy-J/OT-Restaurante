package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Person;

public interface PersonRepository<E extends Person> extends GenericRepository<E> {}
