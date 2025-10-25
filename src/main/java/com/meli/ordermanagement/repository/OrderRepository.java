package com.meli.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meli.ordermanagement.model.Order;

// Repository for Order entity
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}


