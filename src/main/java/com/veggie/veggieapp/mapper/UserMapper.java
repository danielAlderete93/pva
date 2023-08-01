package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.UserRequest;
import com.veggie.veggieapp.dto.response.UserResponse;
import com.veggie.veggieapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements DtoMapper<UserRequest, User, UserResponse> {
    @Override
    public User toEntity(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.name())
                .password(userRequest.password())
                .build();
    }

    @Override
    public UserRequest toRequestDTO(User user) {
        return new UserRequest(user.getName(), user.getPassword());
    }

    @Override
    public UserResponse toResponseDTO(User user) {
        //TODO: Completar
        return null;
    }
}
