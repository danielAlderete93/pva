package com.veggie.veggieapp.usecase.interfaces;

import com.veggie.veggieapp.dto.request.CategoryRequest;
import com.veggie.veggieapp.dto.response.CategoryResponse;

public interface CategoryUseCase extends CrudUseCase<Integer, CategoryRequest, CategoryResponse> {
}
