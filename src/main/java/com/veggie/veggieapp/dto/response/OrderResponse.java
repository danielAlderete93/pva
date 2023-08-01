package com.veggie.veggieapp.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderResponse(

        Integer id,
        Integer customerId,
        List<ItemResponse> items,
        Integer addressId,
        Integer status,
        Float total
) {
}
