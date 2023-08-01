package com.veggie.veggieapp.dto.response;

public record ItemResponse(
        String foodName,
        Float unitPrice,
        Integer count,
        Float subtotal
) {


}
