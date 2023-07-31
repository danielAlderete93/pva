package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.dto.request.category.TypeCategoryRequestDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;

import java.util.List;

public abstract class AbstractTypeCategoryUseCase extends AbstractCrudUseCase<TypeCategory, Integer, TypeCategoryRequestDTO> {


    protected AbstractTypeCategoryUseCase(AbstractCrudService<TypeCategory, Integer> service, DtoMapper<TypeCategoryRequestDTO, TypeCategory> mapper) {
        super(service, mapper);
    }

    @Override
    public TypeCategory update(Integer id, TypeCategoryRequestDTO typeCategoryRequestDTO) {
        TypeCategory typeCategory = mapper.toEntity(typeCategoryRequestDTO);
        typeCategory.setId(id);
        return service.update(typeCategory);
    }

    public List<TypeCategory> findAll() {
        return service.getAll();
    }
}