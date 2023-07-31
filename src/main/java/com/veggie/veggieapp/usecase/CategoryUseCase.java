package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.category.CategoryRequestDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.service.interfaces.CrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCategoryUseCase;
import org.springframework.stereotype.Component;

@Component
public class CategoryUseCase extends AbstractCategoryUseCase {
    public CategoryUseCase(CrudService<Category, Integer> service, DtoMapper<CategoryRequestDTO, Category> mapper) {
        super(service, mapper);
    }


}
