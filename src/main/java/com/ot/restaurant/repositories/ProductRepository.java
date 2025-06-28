package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Product;

public interface ProductRepository<E extends Product> extends GenericRepository<E> {}
