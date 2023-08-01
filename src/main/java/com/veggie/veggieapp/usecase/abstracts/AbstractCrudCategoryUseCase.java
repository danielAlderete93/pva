package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.dto.request.CategoryRequest;
import com.veggie.veggieapp.dto.response.CategoryResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.service.interfaces.CrudService;

public abstract class AbstractCrudCategoryUseCase extends AbstractCrudUseCase<Category, Integer, CategoryRequest, CategoryResponse> {

    protected AbstractCrudCategoryUseCase(CrudService<Category, Integer> service, DtoMapper<CategoryRequest, Category, CategoryResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public CategoryResponse update(Integer id, CategoryRequest categoryRequest) {
        Category category = mapper.toEntity(categoryRequest);
        category.setId(id);
        category = service.update(category);

        return mapper.toResponseDTO(category);
    }
}
