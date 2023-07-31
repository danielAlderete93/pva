package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.user.UserDto;
import com.veggie.veggieapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements DtoMapper<UserDto, User> {
    @Override
    public User toEntity(UserDto userDto) {
        return User.builder()
                .name(userDto.name())
                .password(userDto.password())
                .build();
    }

    @Override
    public UserDto toDTO(User user) {
        return new UserDto(user.getName(), user.getPassword());
    }
}
