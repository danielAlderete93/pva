package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.Plate;
import com.veggie.veggieapp.repository.PlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateService extends AbstractCrudService<Plate, Integer> {
    private final PlateRepository plateRepository;

    @Autowired
    public PlateService(PlateRepository plateRepository) {
        super(plateRepository);
        this.plateRepository = plateRepository;
    }

}

