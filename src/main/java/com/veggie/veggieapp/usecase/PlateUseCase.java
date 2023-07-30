package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.plate.PlateDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Plate;
import com.veggie.veggieapp.service.AbstractCrudService;
import org.springframework.stereotype.Component;

@Component
public class PlateUseCase extends AbstractCrudUseCase<Plate, Integer, PlateDTO> {
    protected PlateUseCase(AbstractCrudService<Plate, Integer> service, DtoMapper<PlateDTO, Plate> mapper) {
        super(service, mapper);
    }

    @Override
    public Plate update(Integer id, PlateDTO plateDTO) {
        Plate plate = mapper.toEntity(plateDTO);
        plate.setId(id);
        return service.update(plate);
    }
}
