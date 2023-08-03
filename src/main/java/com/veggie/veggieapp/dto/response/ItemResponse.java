package com.veggie.veggieapp.dto.response;

public record ItemResponse(
        Integer id,
        String foodName,
        Float unitPrice,
        Integer count,
        Float subtotal
) {


}
