package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Order;

public interface OrderRepository<E extends Order> extends GenericRepository<E> {}
