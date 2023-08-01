package com.veggie.veggieapp.validators;

public interface Validator<T> {
    void validate(T object);
}
