package com.veggie.veggieapp.dto.request.plate;

public record FoodDTO(
        String name,
        Integer stock,
        Float price
) {
}
