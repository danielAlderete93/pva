package com.veggie.veggieapp.dto.response;

import java.util.List;

public record FoodResponse(
        Integer id,
        String name,
        Integer stock,
        Float price,
        List<CategoryResponse> categories


) {
}
