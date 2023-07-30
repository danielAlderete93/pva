package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.plate.PlateDTO;
import com.veggie.veggieapp.model.Plate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PlateMapper implements DtoMapper<PlateDTO, Plate> {
    @Override
    public Plate toEntity(PlateDTO plateDTO) {
        return Plate.builder()
                .name(plateDTO.name())
                .price(plateDTO.price())
                .stock(plateDTO.stock())
                .categories(new ArrayList<>())
                .build();
    }

    @Override
    public PlateDTO toDTO(Plate plate) {
        return new PlateDTO(plate.getName(), plate.getStock(), plate.getPrice());
    }
}
