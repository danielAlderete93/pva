package com.veggie.veggieapp.validators;

import com.veggie.veggieapp.exceptions.InsufficientStockException;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.model.Item;
import org.springframework.stereotype.Component;


@Component
public class ItemValidator implements Validator<Item> {
    @Override
    public void validate(Item item) {
        validateNotNull(item);
        validateItemCountGreaterThanZero(item.getCount());
        validateFoodNotNull(item.getFood());
        validateFoodStock(item);
    }

    private void validateNotNull(Item item) {
        if (item == null) {
            throw new NullPointerException("Invalid item. Item must not be null.");
        }
    }

    private void validateItemCountGreaterThanZero(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Invalid item. Item count must be greater than zero.");
        }
    }

    private void validateFoodNotNull(Food food) {
        if (food == null) {
            throw new NullPointerException("Invalid item. Item's associated food must not be null.");
        }
    }

    private void validateFoodStock(Item item) {
        Food food = item.getFood();
        if (!food.hasStockFor(item.getCount())) {
            throw new InsufficientStockException("Invalid item. Food hasn't got stock for item count.");
        }
    }
}

