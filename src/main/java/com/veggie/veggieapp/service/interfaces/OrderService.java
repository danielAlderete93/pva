package com.veggie.veggieapp.service.interfaces;

import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.model.Order;

/**
 * This interface represents an Order Service that manages orders and their items.
 * It defines methods to add, remove, increment, and reduce items in an order.
 */
public interface OrderService extends CrudService<Order, Integer> {

    /**
     * Adds an item to the order with the specified quantity.
     *
     * @param order    The order to which the item will be added.
     * @param food     The food item to add to the order.
     * @param quantity The quantity of the food item to add.
     * @return The updated order after adding the item.
     * @throws IllegalArgumentException If any of the parameters is null or if the quantity is not a positive value.
     */
    Order addItem(Order order, Food food, Integer quantity);

    /**
     * Removes an item from the order.
     *
     * @param order The order from which the item will be removed.
     * @param food  The food item to remove from the order.
     * @return The updated order after removing the item.
     * @throws IllegalArgumentException If any of the parameters is null.
     */
    Order removeItem(Order order, Food food);

    /**
     * Increments the quantity of an existing item in the order.
     *
     * @param order    The order to which the item's quantity will be incremented.
     * @param food     The food item of which the quantity will be incremented.
     * @param quantity The quantity to increment.
     * @return The updated order after incrementing the item's quantity.
     * @throws IllegalArgumentException If any of the parameters is null or if the quantity is not a positive value.
     */
    Order incrementQuantity(Order order, Food food, Integer quantity);

    /**
     * Reduces the quantity of an existing item in the order.
     *
     * @param order    The order from which the item's quantity will be reduced.
     * @param food     The food item of which the quantity will be reduced.
     * @param quantity The quantity to reduce.
     * @return The updated order after reducing the item's quantity.
     * @throws IllegalArgumentException If any of the parameters is null or if the quantity is not a positive value.
     */
    Order reduceQuantity(Order order, Food food, Integer quantity);
}
