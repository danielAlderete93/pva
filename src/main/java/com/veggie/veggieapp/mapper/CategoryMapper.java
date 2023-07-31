package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.category.CategoryRequestDTO;
import com.veggie.veggieapp.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements DtoMapper<CategoryRequestDTO, Category> {
    @Override
    public Category toEntity(CategoryRequestDTO categoryRequestDTO) {
        return Category.builder()
                .name(categoryRequestDTO.name())
                .description(categoryRequestDTO.description())
                .build();
    }

    @Override
    public CategoryRequestDTO toDTO(Category category) {
        return new CategoryRequestDTO(
                category.getName(),
                category.getDescription()
        );
    }
}
