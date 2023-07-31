package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.dto.request.plate.FoodDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;

import java.util.List;

public abstract class AbstractPlateUseCase extends AbstractCrudUseCase<Food, Integer, FoodDTO> {

    protected AbstractPlateUseCase(AbstractCrudService<Food, Integer> service, DtoMapper<FoodDTO, Food> mapper) {
        super(service, mapper);
    }

    @Override
    public Food update(Integer id, FoodDTO foodDTO) {
        Food food = mapper.toEntity(foodDTO);
        food.setId(id);
        return service.update(food);
    }

    public List<Food> findAll() {
        return service.getAll();
    }


}