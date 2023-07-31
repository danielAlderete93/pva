package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.dto.request.user.UserDto;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.User;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;

public abstract class AbstractUserUseCase extends AbstractCrudUseCase<User, Integer, UserDto> {


    protected AbstractUserUseCase(AbstractCrudService<User, Integer> service, DtoMapper<UserDto, User> mapper) {
        super(service, mapper);
    }

    @Override
    public User update(Integer id, UserDto userDto) {
        User user = mapper.toEntity(userDto);
        user.setId(id);
        return service.update(user);
    }
}
