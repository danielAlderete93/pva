package com.veggie.veggieapp.exceptions;

public class FoodNotOrderedException extends RuntimeException {
    public FoodNotOrderedException(String message) {
        super(message);
    }
}
