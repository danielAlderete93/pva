package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.category.CategoryDTO;
import com.veggie.veggieapp.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements DtoMapper<CategoryDTO, Category> {
    @Override
    public Category toEntity(CategoryDTO categoryDTO) {
        return Category.builder()
                .name(categoryDTO.name())
                .description(categoryDTO.description())
                .build();
    }

    @Override
    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(
                category.getName(),
                category.getDescription()
        );
    }
}
