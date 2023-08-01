package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.CategoryRequest;
import com.veggie.veggieapp.dto.response.CategoryResponse;
import com.veggie.veggieapp.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements DtoMapper<CategoryRequest, Category, CategoryResponse> {
    @Override
    public Category toEntity(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.name())
                .description(categoryRequest.description())
                .build();
    }

    @Override
    public CategoryRequest toRequestDTO(Category category) {
        return new CategoryRequest(
                category.getName(),
                category.getDescription()
        );
    }

    @Override
    public CategoryResponse toResponseDTO(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}
