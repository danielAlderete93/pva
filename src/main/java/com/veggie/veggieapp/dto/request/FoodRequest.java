package com.veggie.veggieapp.dto.request;

public record FoodRequest(
        String name,
        Integer stock,
        Float price
) {
}
