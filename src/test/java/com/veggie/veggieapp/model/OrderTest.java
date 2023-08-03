package com.veggie.veggieapp.model;

import com.veggie.veggieapp.exceptions.DuplicateFoodOrderException;
import com.veggie.veggieapp.exceptions.FoodNotOrderedException;
import com.veggie.veggieapp.exceptions.InvalidOrderStateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class OrderTest {
    Order order;
    Food food1;
    Food food2;
    Item item1;
    Item item2;

    @BeforeEach
    public void setUp() {
        User customer = mock(User.class);
        Address address = mock(Address.class);

        food1 = Food.builder()
                .name("Food1")
                .stock(0)
                .price(10.0f)
                .build();

        food2 = Food.builder()
                .name("Food2")
                .stock(5)
                .price(15.0f)
                .build();


        item1 = Item.builder().food(food1).unitPrice(food1.getPrice()).quantity(2).subtotal(20.0f).build();
        item2 = Item.builder().food(food2).unitPrice(food2.getPrice()).quantity(3).subtotal(45.0f).build();


        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        order = Order.builder()
                .customer(customer)
                .address(address)
                .items(items)
                .status(OrderStatus.READY_TO_ORDER)
                .build();
    }

    @Test
    @DisplayName("Adding a new food item should increase the order items and total")
    void testAddItem_NewFoodInOrder_ItemsIncreased() {
        Food newFood = Food.builder()
                .name("New Food")
                .stock(12)
                .price(12.0f)
                .build();
        int quantity = 1;

        order.addItem(newFood, quantity);

        assertTrue(order.hasOrderedFood(newFood));
        assertEquals(3, order.getItems().size());
        assertEquals(77.0f, order.getTotal());
    }

    @Test
    @DisplayName("Adding a duplicate item should throw DuplicateFoodOrderException")
    void testAddDuplicateItem_ShouldThrowException() {
        assertThrows(DuplicateFoodOrderException.class, () -> order.addItem(food1, 1));
    }

    @Test
    @DisplayName("Removing an existing item should decrease the order items and total")
    void testRemoveItem_ExistingItemInOrder_ItemsDecreased() {
        order.removeItem(food1);

        assertFalse(order.hasOrderedFood(food1));
        assertEquals(1, order.getItems().size());
        assertEquals(45.0f, order.getTotal());
    }

    @Test
    @DisplayName("Removing a non-existing item should throw FoodNotOrderedException")
    void testRemoveNonExistingItem_ShouldThrowException() {
        Food foodNoExisting = Food.builder()
                .name("foodNoExisting")
                .price(10.f)
                .stock(5)
                .build();
        assertThrows(FoodNotOrderedException.class, () -> order.removeItem(foodNoExisting));
    }

    @Test
    @DisplayName("Items can be updated for specific order statuses")
    void testItemsCanBeUpdated_ForDifferentOrderStatuses() {
        order.setStatus(OrderStatus.READY_TO_ORDER);
        assertTrue(order.itemsCanBeUpdated());

        order.setStatus(OrderStatus.READY_TO_PAY);
        assertTrue(order.itemsCanBeUpdated());

        order.setStatus(OrderStatus.IN_DELIVERY);
        assertFalse(order.itemsCanBeUpdated());

        order.setStatus(OrderStatus.IN_PROGRESS);
        assertFalse(order.itemsCanBeUpdated());

        order.setStatus(OrderStatus.FINISHED);
        assertFalse(order.itemsCanBeUpdated());
    }

    @Test
    @DisplayName("Adding an item to an order with status IN_DELIVERY should throw InvalidOrderStateException")
    void testAddItem_OrderInDelivery_ShouldThrowException() {
        Food newFood = Food.builder()
                .name("New Food")
                .stock(12)
                .price(12.0f)
                .build();
        int quantity = 1;

        order.setStatus(OrderStatus.IN_DELIVERY);

        assertThrows(InvalidOrderStateException.class, () -> order.addItem(newFood, quantity));
    }


    @Test
    @DisplayName("Increasing quantity for an existing item should update the quantity and total")
    void testIncreaseQuantityForItem_ItemExists_QuantityIncreased() {
        int initialQuantity = item2.getQuantity();
        int quantityToAdd = 2;

        order.increaseQuantityForItem(food2, quantityToAdd);

        assertEquals(initialQuantity + quantityToAdd, item2.getQuantity());
        assertEquals(95.0f, order.getTotal());
    }

    @Test
    @DisplayName("Increasing quantity for a non-existing item should throw FoodNotOrderedException")
    void testIncreaseQuantityForItem_ItemNotExists_ShouldThrowException() {
        Food nonExistingFood = Food.builder()
                .name("NonExisting Food")
                .price(20.0f)
                .stock(10)
                .build();
        int quantityToAdd = 2;

        assertThrows(FoodNotOrderedException.class, () -> order.increaseQuantityForItem(nonExistingFood, quantityToAdd));
    }

    @Test
    @DisplayName("Reducing quantity for an existing item should update the quantity and total")
    void testReduceQuantityForItem_ItemExists_QuantityReduced() {
        int initialQuantity = item2.getQuantity();
        int initialStock = item2.getFood().getStock();
        int quantityToReduce = 2;

        order.reduceQuantityForItem(food2, quantityToReduce);

        assertEquals(initialQuantity - quantityToReduce, item2.getQuantity());
        assertEquals(initialStock + quantityToReduce, item2.getFood().getStock());
        assertEquals(35.0f, order.getTotal());
    }

    @Test
    @DisplayName("Reducing quantity for a non-existing item should throw FoodNotOrderedException")
    void testReduceQuantityForItem_ItemNotExists_ShouldThrowException() {
        Food nonExistingFood = Food.builder()
                .name("NonExisting Food")
                .price(20.0f)
                .stock(10)
                .build();
        int quantityToReduce = 2;

        assertThrows(FoodNotOrderedException.class, () -> order.reduceQuantityForItem(nonExistingFood, quantityToReduce));
    }

    @Test
    @DisplayName("Reducing quantity to zero should remove the item from the order")
    void testReduceQuantityForItem_ItemExists_QuantityToZero_ItemRemovedFromOrder() {
        int initialItemsCount = order.getItems().size();
        int quantityToReduce = item2.getQuantity();

        order.reduceQuantityForItem(food2, quantityToReduce);

        assertEquals(0, item2.getQuantity());
        assertEquals(initialItemsCount - 1, order.getItems().size());
        assertEquals(20.0f, order.getTotal());
    }


}
