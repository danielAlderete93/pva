package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.model.Item;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.repository.OrderRepository;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import com.veggie.veggieapp.service.interfaces.OrderService;
import com.veggie.veggieapp.validators.FoodValidator;
import com.veggie.veggieapp.validators.ItemValidator;
import com.veggie.veggieapp.validators.OrderValidator;
import com.veggie.veggieapp.validators.Validator;
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
        validateItemForOrder(order, item);

        Food food = item.getFood();

        order.addItem(item);
        food.decrementStock(item.getCount());
        order.updateTotal();

        return update(order);
    }

    @Override
    public Order removeItem(Order order, Item item) {
        validateItemForOrder(order, item);

        Food food = item.getFood();

        // Increment stock and update total
        food.incrementStock(item.getCount());

        order.removeItem(item);

        return update(order);
    }

    private void validateItemForOrder(Order order, Item item) {
        Validator<Order> orderValidator = new OrderValidator();
        Validator<Item> itemValidator = new ItemValidator();
        Validator<Food> foodValidator = new FoodValidator();
        orderValidator.validate(order);
        itemValidator.validate(item);
        foodValidator.validate(item.getFood());
    }


}