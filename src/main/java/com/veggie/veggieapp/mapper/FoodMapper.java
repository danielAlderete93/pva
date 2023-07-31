package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.plate.FoodDTO;
import com.veggie.veggieapp.model.Food;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FoodMapper implements DtoMapper<FoodDTO, Food> {
    @Override
    public Food toEntity(FoodDTO foodDTO) {
        return Food.builder()
                .name(foodDTO.name())
                .price(foodDTO.price())
                .stock(foodDTO.stock())
                .categories(new ArrayList<>())
                .build();
    }

    @Override
    public FoodDTO toDTO(Food food) {
        return new FoodDTO(food.getName(), food.getStock(), food.getPrice());
    }
}
