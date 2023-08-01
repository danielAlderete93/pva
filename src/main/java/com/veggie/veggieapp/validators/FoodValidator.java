package com.veggie.veggieapp.validators;

import com.veggie.veggieapp.model.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodValidator implements Validator<Food> {
    @Override
    public void validate(Food order) {
        validateNotNull(order);
    }

    private void validateNotNull(Food food) {
        if (food == null) {
            throw new NullPointerException("Invalid food. Food must not be null.");
        }
    }
}
