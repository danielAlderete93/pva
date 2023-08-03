package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.TypeCategoryRequest;
import com.veggie.veggieapp.dto.response.TypeCategoryResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.service.abstracts.AbstractCrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudUseCase;
import com.veggie.veggieapp.usecase.interfaces.TypeCategoryUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeCategoryUseCaseImpl extends AbstractCrudUseCase<TypeCategory, Integer, TypeCategoryRequest, TypeCategoryResponse> implements TypeCategoryUseCase {

    public TypeCategoryUseCaseImpl(AbstractCrudService<TypeCategory, Integer> service, DtoMapper<TypeCategoryRequest, TypeCategory, TypeCategoryResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public TypeCategoryResponse update(Integer id, TypeCategoryRequest typeCategoryRequest) {
        TypeCategory typeCategory = mapper.toEntity(typeCategoryRequest);
        typeCategory.setId(id);
        typeCategory = service.update(typeCategory);
        return mapper.toResponseDTO(typeCategory);
    }

    @Override
    public List<TypeCategoryResponse> findAll() {
        return service.getAll().stream()
                .map(mapper::toResponseDTO)
                .toList();
    }
}
