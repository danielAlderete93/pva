package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.User;
import com.veggie.veggieapp.repository.UserRepository;
import com.veggie.veggieapp.service.abstracts.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<User, Integer> {

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
