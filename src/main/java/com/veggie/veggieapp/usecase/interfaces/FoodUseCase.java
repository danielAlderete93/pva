package com.veggie.veggieapp.usecase.interfaces;

import com.veggie.veggieapp.dto.request.FoodRequest;
import com.veggie.veggieapp.dto.response.FoodResponse;

import java.util.List;

public interface FoodUseCase extends CrudUseCase<Integer, FoodRequest, FoodResponse> {
    List<FoodResponse> findAll();


}
