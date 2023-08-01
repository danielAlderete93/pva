package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.dto.request.UserRequest;
import com.veggie.veggieapp.dto.response.UserResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.User;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;

public abstract class AbstractCrudUserUseCase extends AbstractCrudUseCase<User, Integer, UserRequest, UserResponse> {


    protected AbstractCrudUserUseCase(AbstractCrudService<User, Integer> service, DtoMapper<UserRequest, User, UserResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public UserResponse update(Integer id, UserRequest userRequest) {
        User user = mapper.toEntity(userRequest);
        user.setId(id);
        user = service.update(user);
        return mapper.toResponseDTO(user);
    }
}
