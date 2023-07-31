package com.veggie.veggieapp.service.interfaces;

import com.veggie.veggieapp.model.Item;
import com.veggie.veggieapp.model.Order;

public interface OrderService extends CrudService<Order, Integer> {

    Order addItem(Order order, Item item);
}
