package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.FoodRequest;
import com.veggie.veggieapp.dto.response.FoodResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudFoodUseCase;
import org.springframework.stereotype.Component;

@Component
public class FoodUseCase extends AbstractCrudFoodUseCase {

    protected FoodUseCase(AbstractCrudService<Food, Integer> service, DtoMapper<FoodRequest, Food, FoodResponse> mapper) {
        super(service, mapper);
    }
}
