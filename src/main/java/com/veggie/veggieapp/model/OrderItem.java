package com.veggie.veggieapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "items_order")
public class OrderItem {

    @EmbeddedId
    private OrderItemKey id;

    @Column(name = "unit_price", nullable = false)
    private Float unitPrice;
    @Column(nullable = false)
    private Integer count;
    @Column(nullable = false)
    private Float subtotal;


}

