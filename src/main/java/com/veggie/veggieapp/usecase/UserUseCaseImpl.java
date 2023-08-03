package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.UserRequest;
import com.veggie.veggieapp.dto.response.UserResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.User;
import com.veggie.veggieapp.service.abstracts.AbstractCrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudUseCase;
import com.veggie.veggieapp.usecase.interfaces.UserUseCase;
import org.springframework.stereotype.Component;

@Component
public class UserUseCaseImpl extends AbstractCrudUseCase<User, Integer, UserRequest, UserResponse> implements UserUseCase {
    public UserUseCaseImpl(AbstractCrudService<User, Integer> service, DtoMapper<UserRequest, User, UserResponse> mapper) {
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