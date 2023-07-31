package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.repository.PlateRepository;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService extends AbstractCrudService<Food, Integer> {

    @Autowired
    public FoodService(PlateRepository plateRepository) {
        super(plateRepository);
    }

}

