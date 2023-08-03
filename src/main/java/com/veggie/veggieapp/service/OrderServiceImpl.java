package com.veggie.veggieapp.service;

import com.veggie.veggieapp.exceptions.InvalidQuantityException;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.repository.OrderRepository;
import com.veggie.veggieapp.service.abstracts.AbstractCrudService;
import com.veggie.veggieapp.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Concrete implementation of the OrderService interface for managing orders.
 * Extends the AbstractCrudService class to inherit common CRUD operations for Order entities.
 */
@Service
public class OrderServiceImpl extends AbstractCrudService<Order, Integer> implements OrderService {
    /**
     * Constructs the OrderServiceImpl with the required dependencies.
     *
     * @param orderRepository The repository responsible for data access and manipulation of Order entities.
     */
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository);
    }

    /**
     * Adds an item to the order with the specified quantity.
     *
     * @param order    The order to which the item will be added.
     * @param food     The food item to add to the order.
     * @param quantity The quantity of the food item to add.
     * @return The updated order after adding the item.
     * @throws IllegalArgumentException If any of the parameters is null or if the quantity is not a positive value.
     */
    @Override
    public Order addItem(Order order, Food food, Integer quantity) {
        validateOrderFoodAndQuantity(order, food, quantity);

        order.addItem(food, quantity);

        return update(order);
    }

    /**
     * Removes an item from the order.
     *
     * @param order The order from which the item will be removed.
     * @param food  The food item to remove from the order.
     * @return The updated order after removing the item.
     * @throws IllegalArgumentException If any of the parameters is null.
     */
    @Override
    public Order removeItem(Order order, Food food) {
        validateOrderAndFood(order, food);

        order.removeItem(food);

        return update(order);
    }

    /**
     * Increments the quantity of an existing item in the order.
     *
     * @param order    The order to which the item's quantity will be incremented.
     * @param food     The food item of which the quantity will be incremented.
     * @param quantity The quantity to increment.
     * @return The updated order after incrementing the item's quantity.
     * @throws IllegalArgumentException If any of the parameters is null or if the quantity is not a positive value.
     */
    @Override
    public Order incrementQuantity(Order order, Food food, Integer quantity) {
        validateOrderFoodAndQuantity(order, food, quantity);

        order.increaseQuantityForItem(food, quantity);

        return update(order);
    }

    /**
     * Reduces the quantity of an existing item in the order.
     *
     * @param order    The order from which the item's quantity will be reduced.
     * @param food     The food item of which the quantity will be reduced.
     * @param quantity The quantity to reduce.
     * @return The updated order after reducing the item's quantity.
     * @throws IllegalArgumentException If any of the parameters is null or if the quantity is not a positive value.
     */
    @Override
    public Order reduceQuantity(Order order, Food food, Integer quantity) {
        validateOrderFoodAndQuantity(order, food, quantity);

        order.reduceQuantityForItem(food, quantity);

        return update(order);
    }

    private void validateOrderFoodAndQuantity(Order order, Food food, Integer quantity) {
        validateOrderNotNull(order);
        validateFoodNotNull(food);
        validateQuantityNotNull(quantity);

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive value");
        }
    }

    private void validateOrderAndFood(Order order, Food food) {
        validateOrderNotNull(order);
        validateFoodNotNull(food);
    }

    private void validateOrderNotNull(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
    }

    private void validateFoodNotNull(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Food cannot be null");
        }
    }

    private void validateQuantityNotNull(Integer quantity) {
        if (quantity == null) {
            throw new InvalidQuantityException("Quantity cannot be null");
        }
    }
}
