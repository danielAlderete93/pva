package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.CategoryRequest;
import com.veggie.veggieapp.dto.request.FoodRequest;
import com.veggie.veggieapp.dto.response.CategoryResponse;
import com.veggie.veggieapp.dto.response.FoodResponse;
import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodMapper implements DtoMapper<FoodRequest, Food, FoodResponse> {
    private final DtoMapper<CategoryRequest, Category, CategoryResponse> categoryMapper;

    @Autowired
    public FoodMapper(DtoMapper<CategoryRequest, Category, CategoryResponse> categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Food toEntity(FoodRequest foodRequest) {
        return Food.builder()
                .name(foodRequest.name())
                .price(foodRequest.price())
                .stock(foodRequest.stock())
                .categories(new ArrayList<>())
                .build();
    }

    @Override
    public FoodRequest toRequestDTO(Food food) {
        return new FoodRequest(food.getName(), food.getStock(), food.getPrice());
    }

    @Override
    public FoodResponse toResponseDTO(Food food) {
        List<CategoryResponse> categoryList = new ArrayList<>();
        if (!food.getCategories().isEmpty()) {
            categoryList = food.getCategories().stream()
                    .map(categoryMapper::toResponseDTO)
                    .toList()
            ;
        }

        return new FoodResponse(
                food.getId(),
                food.getName(),
                food.getStock(),
                food.getPrice(),
                categoryList
        );
    }
}
