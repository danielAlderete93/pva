package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.CategoryRequest;
import com.veggie.veggieapp.dto.request.TypeCategoryRequest;
import com.veggie.veggieapp.dto.response.CategoryResponse;
import com.veggie.veggieapp.dto.response.TypeCategoryResponse;
import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.model.TypeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeCategoryMapper implements DtoMapper<TypeCategoryRequest, TypeCategory, TypeCategoryResponse> {

    private final DtoMapper<CategoryRequest, Category, CategoryResponse> categoryMapper;

    @Autowired
    public TypeCategoryMapper(DtoMapper<CategoryRequest, Category, CategoryResponse> categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public TypeCategory toEntity(TypeCategoryRequest typeCategoryRequest) {

        return TypeCategory.builder()
                .categories(new ArrayList<>())
                .description(typeCategoryRequest.description())
                .name(typeCategoryRequest.name())
                .build();
    }

    @Override
    public TypeCategoryRequest toRequestDTO(TypeCategory typeCategory) {
        return new TypeCategoryRequest(typeCategory.getName(), typeCategory.getDescription());
    }

    @Override
    public TypeCategoryResponse toResponseDTO(TypeCategory typeCategory) {
        List<CategoryResponse> categoryList = new ArrayList<>();

        if (!typeCategory.getCategories().isEmpty()) {
            categoryList = typeCategory.getCategories().stream()
                    .map(categoryMapper::toResponseDTO)
                    .toList();

        }


        return new TypeCategoryResponse(typeCategory.getId(), typeCategory.getName(), typeCategory.getDescription(), categoryList);
    }
}
