package com.veggie.veggieapp.dto.response;

import com.veggie.veggieapp.model.Address;
import com.veggie.veggieapp.model.Order;

import java.util.List;

//TODO: Completar
public record UserResponse(
        Integer id,
        String name,
        List<Address> addresses,
        List<Order> orders
) {
}
