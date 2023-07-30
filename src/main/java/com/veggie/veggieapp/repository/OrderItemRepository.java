package com.veggie.veggieapp.repository;

import com.veggie.veggieapp.model.OrderItem;
import com.veggie.veggieapp.model.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemKey> {
}
