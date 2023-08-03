package com.veggie.veggieapp.usecase.interfaces;

import com.veggie.veggieapp.dto.request.UserRequest;
import com.veggie.veggieapp.dto.response.UserResponse;

public interface UserUseCase extends CrudUseCase<Integer, UserRequest, UserResponse> {
}
