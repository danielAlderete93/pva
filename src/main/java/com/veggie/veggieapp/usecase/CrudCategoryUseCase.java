package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.CategoryRequest;
import com.veggie.veggieapp.dto.response.CategoryResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.service.interfaces.CrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudCategoryUseCase;
import org.springframework.stereotype.Component;

@Component
public class CrudCategoryUseCase extends AbstractCrudCategoryUseCase {
    public CrudCategoryUseCase(CrudService<Category, Integer> service, DtoMapper<CategoryRequest, Category, CategoryResponse> mapper) {
        super(service, mapper);
    }


}
