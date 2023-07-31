package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.model.Item;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.repository.OrderRepository;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import com.veggie.veggieapp.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractCrudService<Order, Integer> implements OrderService {

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository);
    }

    @Override
    public Order addItem(Order order, Item item) {
        Food food = item.getFood();

        food.decrementStock(item.getCount());
        item.updateSubtotal();
        order.addItem(item);


        return update(order);
    }
}