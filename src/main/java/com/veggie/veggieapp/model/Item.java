package com.veggie.veggieapp.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "items_order")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_food", referencedColumnName = "id")
    private Food food;
    @Column(name = "unit_price", nullable = false)
    private Float unitPrice;
    @Column(nullable = false)
    private Integer count;
    @Column(nullable = false)
    private Float subtotal;

    public void updateSubtotal() {
        this.subtotal = this.unitPrice * this.count;
    }


}

