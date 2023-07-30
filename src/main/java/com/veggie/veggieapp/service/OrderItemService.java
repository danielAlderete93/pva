package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.OrderItem;
import com.veggie.veggieapp.model.OrderItemKey;
import com.veggie.veggieapp.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends AbstractCrudService<OrderItem, OrderItemKey> {

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        super(orderItemRepository);
    }
}
