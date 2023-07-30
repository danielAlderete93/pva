package com.veggie.veggieapp.dto.order;

public record OrderDTO(
        Integer userId,
        Integer addressId,
        Integer orderStatus
) {
}
