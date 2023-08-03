package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.CategoryRequest;
import com.veggie.veggieapp.dto.response.CategoryResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.service.interfaces.CrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudUseCase;
import com.veggie.veggieapp.usecase.interfaces.CategoryUseCase;
import org.springframework.stereotype.Component;

@Component
public class CategoryUseCaseImpl extends AbstractCrudUseCase<Category, Integer, CategoryRequest, CategoryResponse> implements CategoryUseCase {
    public CategoryUseCaseImpl(CrudService<Category, Integer> service, DtoMapper<CategoryRequest, Category, CategoryResponse> mapper) {
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
