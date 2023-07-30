package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractCrudService<Order, Integer> {

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        super(orderRepository);
    }

}