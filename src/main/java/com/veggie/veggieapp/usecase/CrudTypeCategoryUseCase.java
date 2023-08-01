package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.TypeCategoryRequest;
import com.veggie.veggieapp.dto.response.TypeCategoryResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudTypeCategoryUseCase;
import org.springframework.stereotype.Component;

@Component
public class CrudTypeCategoryUseCase extends AbstractCrudTypeCategoryUseCase {

    protected CrudTypeCategoryUseCase(AbstractCrudService<TypeCategory, Integer> service, DtoMapper<TypeCategoryRequest, TypeCategory, TypeCategoryResponse> mapper) {
        super(service, mapper);
    }
}
