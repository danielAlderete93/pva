package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.FoodRequest;
import com.veggie.veggieapp.dto.response.FoodResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.service.abstracts.AbstractCrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudUseCase;
import com.veggie.veggieapp.usecase.interfaces.FoodUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodUseCaseImpl extends AbstractCrudUseCase<Food, Integer, FoodRequest, FoodResponse> implements FoodUseCase {

    public FoodUseCaseImpl(AbstractCrudService<Food, Integer> service, DtoMapper<FoodRequest, Food, FoodResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public FoodResponse update(Integer id, FoodRequest foodRequest) {
        Food food = mapper.toEntity(foodRequest);
        food.setId(id);
        food = service.update(food);

        return mapper.toResponseDTO(food);
    }

    @Override
    public List<FoodResponse> findAll() {
        List<Food> foods = service.getAll();
        return foods.stream()
                .map(mapper::toResponseDTO)
                .toList()
                ;
    }
}
