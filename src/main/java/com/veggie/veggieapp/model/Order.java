package com.veggie.veggieapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "fk_customer")
    private User customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "item_x_order")
    private List<OrderItem> items;
    @ManyToOne
    @JoinColumn(name = "fk_address")
    private Address address;
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;
    @Column
    private Float total;

}
