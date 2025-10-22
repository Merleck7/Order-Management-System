package com.meli.ordermanagement.repository;

import com.meli.ordermanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing Order persistence.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
