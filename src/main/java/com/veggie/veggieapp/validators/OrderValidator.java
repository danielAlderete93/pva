package com.veggie.veggieapp.validators;

import com.veggie.veggieapp.model.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderValidator implements Validator<Order> {
    @Override
    public void validate(Order order) {
        validateNotNull(order);
    }

    private void validateNotNull(Order order) {
        if (order == null) {
            throw new NullPointerException("Invalid order. Order must not be null.");
        }
    }


}
