package com.veggie.veggieapp.controller.v1;

import com.veggie.veggieapp.dto.request.UserRequest;
import com.veggie.veggieapp.dto.response.UserResponse;
import com.veggie.veggieapp.usecase.interfaces.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserUseCase userUseCaseImpl;

    @Autowired
    public UserController(UserUseCase userUseCaseImpl) {
        this.userUseCaseImpl = userUseCaseImpl;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest user) {
        UserResponse createdUser = userUseCaseImpl.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {
        UserResponse user = userUseCaseImpl.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Integer id, @RequestBody UserRequest user) {
        UserResponse updatedUser = userUseCaseImpl.update(id, user);

        return ResponseEntity.ok(updatedUser);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        boolean isDeleted = userUseCaseImpl.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

