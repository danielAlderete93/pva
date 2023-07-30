package com.veggie.veggieapp.dto.order;

public record OrderItemDTO(
        Integer orderId,
        Integer plateId,
        Integer count
) {
}
