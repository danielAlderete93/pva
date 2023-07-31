package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.category.TypeCategoryRequestDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractTypeCategoryUseCase;
import org.springframework.stereotype.Component;

@Component
public class TypeCategoryUseCase extends AbstractTypeCategoryUseCase {

    protected TypeCategoryUseCase(AbstractCrudService<TypeCategory, Integer> service, DtoMapper<TypeCategoryRequestDTO, TypeCategory> mapper) {
        super(service, mapper);
    }
}
