package com.veggie.veggieapp.usecase.interfaces;

import com.veggie.veggieapp.dto.request.TypeCategoryRequest;
import com.veggie.veggieapp.dto.response.TypeCategoryResponse;

import java.util.List;

public interface TypeCategoryUseCase extends CrudUseCase<Integer, TypeCategoryRequest, TypeCategoryResponse> {

    List<TypeCategoryResponse> findAll();
}
