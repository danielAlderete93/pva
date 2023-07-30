package com.veggie.veggieapp.repository;

import com.veggie.veggieapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
