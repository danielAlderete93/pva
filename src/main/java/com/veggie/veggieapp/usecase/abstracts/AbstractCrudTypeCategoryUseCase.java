package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.dto.request.TypeCategoryRequest;
import com.veggie.veggieapp.dto.response.TypeCategoryResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;

import java.util.List;

public abstract class AbstractCrudTypeCategoryUseCase extends AbstractCrudUseCase<TypeCategory, Integer, TypeCategoryRequest, TypeCategoryResponse> {


    protected AbstractCrudTypeCategoryUseCase(AbstractCrudService<TypeCategory, Integer> service, DtoMapper<TypeCategoryRequest, TypeCategory, TypeCategoryResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public TypeCategoryResponse update(Integer id, TypeCategoryRequest typeCategoryRequest) {
        TypeCategory typeCategory = mapper.toEntity(typeCategoryRequest);
        typeCategory.setId(id);
        typeCategory = service.update(typeCategory);
        return mapper.toResponseDTO(typeCategory);
    }

    public List<TypeCategoryResponse> findAll() {
        return service.getAll().stream()
                .map(mapper::toResponseDTO)
                .toList();
    }
}