package com.veggie.veggieapp.dto.response;

import java.util.List;

public record TypeCategoryResponse(
        Integer id,
        String name,
        String description,
        List<CategoryResponse> categories
) {
}
