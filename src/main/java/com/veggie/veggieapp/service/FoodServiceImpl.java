package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.repository.PlateRepository;
import com.veggie.veggieapp.service.abstracts.AbstractCrudService;
import com.veggie.veggieapp.service.interfaces.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl extends AbstractCrudService<Food, Integer> implements FoodService {

    @Autowired
    public FoodServiceImpl(PlateRepository plateRepository) {
        super(plateRepository);
    }

}

