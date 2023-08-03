package com.veggie.veggieapp.exceptions;

public class DuplicateFoodOrderException extends RuntimeException {
    public DuplicateFoodOrderException(String message) {
        super(message);
    }
}
