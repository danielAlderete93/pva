package com.veggie.veggieapp.dto.request;

public record ItemRequest(
        Integer orderId,
        Integer foodId,
        Integer count
) {
}
