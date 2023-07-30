package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.user.UserDto;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.User;
import com.veggie.veggieapp.service.AbstractCrudService;
import org.springframework.stereotype.Component;

@Component
public class UserUseCase extends AbstractCrudUseCase<User, Integer, UserDto> {
    protected UserUseCase(AbstractCrudService<User, Integer> service, DtoMapper<UserDto, User> mapper) {
        super(service, mapper);
    }

    @Override
    public User update(Integer id, UserDto userDto) {
        User user = mapper.toEntity(userDto);
        user.setId(id);
        return service.update(user);
    }
}
