package com.veggie.veggieapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item;
    private Food food;

    @BeforeEach
    public void setUp() {
        food = Food.builder()
                .name("Food1")
                .stock(5)
                .price(10.0f)
                .build();

        item = Item.builder()
                .food(food)
                .unitPrice(food.getPrice())
                .quantity(2)
                .subtotal(20.0f)
                .build();
    }

    @Test
    @DisplayName("Test incrementQuantity() method")
    void testIncrementQuantity() {
        item.incrementQuantity(2);

        assertEquals(4, item.getQuantity());
        assertEquals(3, food.getStock());
        assertEquals(40.0f, item.getSubtotal());
    }

    @Test
    @DisplayName("Test reduceQuantity() method")
    void testReduceQuantity() {
        item.reduceQuantity(1);

        assertEquals(1, item.getQuantity());
        assertEquals(6, food.getStock());
        assertEquals(10.0f, item.getSubtotal());
    }

    @Test
    @DisplayName("Test reduceFoodStock() method")
    void testReduceFoodStock() {
        item.reduceFoodStock();

        assertEquals(3, food.getStock()); // Negative value since the stock was already 0
    }

    @Test
    @DisplayName("Test increaseFoodStock() method")
    void testIncreaseFoodStock() {
        item.increaseFoodStock();

        assertEquals(7, food.getStock());
    }

    @Test
    @DisplayName("Test increaseFoodStock() method")
    void testReducecFoodStock() {
        item.reduceFoodStock();

        assertEquals(3, food.getStock());
    }

    @Test
    @DisplayName("Test hasQuantity() method")
    void testHasQuantity() {
        assertTrue(item.hasQuantity());

        item.setQuantity(0);
        assertFalse(item.hasQuantity());
    }


}
