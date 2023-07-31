package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.plate.FoodDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractPlateUseCase;
import org.springframework.stereotype.Component;

@Component
public class FoodUseCase extends AbstractPlateUseCase {

    protected FoodUseCase(AbstractCrudService<Food, Integer> service, DtoMapper<FoodDTO, Food> mapper) {
        super(service, mapper);
    }
}
