package com.veggie.veggieapp.dto.request;

public record OrderRequest(
        Integer userId,
        Integer addressId
) {
}
