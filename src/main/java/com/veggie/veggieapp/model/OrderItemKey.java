package com.veggie.veggieapp.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class OrderItemKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "fk_plate")
    private Plate plate;

    @ManyToOne
    @JoinColumn(name = "fk_order")
    private Order order;
}
