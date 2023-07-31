package com.veggie.veggieapp.dto.request.order;

public record ItemRequestDTO(
        Integer orderId,
        Integer foodId,
        Integer count
) {
}
