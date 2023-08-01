package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.dto.request.FoodRequest;
import com.veggie.veggieapp.dto.response.FoodResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;

import java.util.List;

public abstract class AbstractCrudFoodUseCase extends AbstractCrudUseCase<Food, Integer, FoodRequest, FoodResponse> {

    protected AbstractCrudFoodUseCase(AbstractCrudService<Food, Integer> service, DtoMapper<FoodRequest, Food, FoodResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public FoodResponse update(Integer id, FoodRequest foodRequest) {
        Food food = mapper.toEntity(foodRequest);
        food.setId(id);
        food = service.update(food);
        return mapper.toResponseDTO(food);
    }

    public List<FoodResponse> findAll() {
        return service.getAll().stream()
                .map(mapper::toResponseDTO)
                .toList()
                ;
    }


}