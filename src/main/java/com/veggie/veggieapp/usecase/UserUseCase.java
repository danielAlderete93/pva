package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.user.UserDto;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.User;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractUserUseCase;
import org.springframework.stereotype.Component;

@Component
public class UserUseCase extends AbstractUserUseCase {
    protected UserUseCase(AbstractCrudService<User, Integer> service, DtoMapper<UserDto, User> mapper) {
        super(service, mapper);
    }
}