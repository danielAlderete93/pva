package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.UserRequest;
import com.veggie.veggieapp.dto.response.UserResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.User;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudUserUseCase;
import org.springframework.stereotype.Component;

@Component
public class CrudUserUseCase extends AbstractCrudUserUseCase {
    protected CrudUserUseCase(AbstractCrudService<User, Integer> service, DtoMapper<UserRequest, User, UserResponse> mapper) {
        super(service, mapper);
    }
}