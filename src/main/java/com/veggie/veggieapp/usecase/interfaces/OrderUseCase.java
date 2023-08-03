package com.veggie.veggieapp.usecase.interfaces;

import com.veggie.veggieapp.dto.request.OrderRequest;
import com.veggie.veggieapp.dto.response.OrderResponse;

/**
 * Interface representing the use case for managing orders.
 * Extends the CrudUseCase interface for common CRUD operations.
 */
public interface OrderUseCase extends CrudUseCase<Integer, OrderRequest, OrderResponse> {

    /**
     * Adds an item to the specified order with the given quantity.
     *
     * @param orderId  The ID of the order to which the item will be added.
     * @param foodId   The ID of the food item to add to the order.
     * @param quantity The quantity of the food item to add.
     * @return The response object representing the updated order after adding the item.
     */
    OrderResponse addItemToOrder(Integer orderId, Integer foodId, Integer quantity);

    /**
     * Removes an item from the specified order.
     *
     * @param orderId The ID of the order from which the item will be removed.
     * @param foodId  The ID of the food item to remove from the order.
     * @return The response object representing the updated order after removing the item.
     */
    OrderResponse removeItemFromOrder(Integer orderId, Integer foodId);

    /**
     * Increments the quantity of a specific item in the specified order.
     *
     * @param orderId  The ID of the order in which to increment the item's quantity.
     * @param foodId   The ID of the food item for which the quantity will be incremented.
     * @param quantity The quantity to increment.
     * @return The response object representing the updated order after incrementing the item's quantity.
     */
    OrderResponse incrementQuantityInOrder(Integer orderId, Integer foodId, Integer quantity);

    /**
     * Reduces the quantity of a specific item in the specified order.
     *
     * @param orderId  The ID of the order in which to reduce the item's quantity.
     * @param foodId   The ID of the food item for which the quantity will be reduced.
     * @param quantity The quantity to reduce.
     * @return The response object representing the updated order after reducing the item's quantity.
     */
    OrderResponse reduceQuantityInOrder(Integer orderId, Integer foodId, Integer quantity);
}

