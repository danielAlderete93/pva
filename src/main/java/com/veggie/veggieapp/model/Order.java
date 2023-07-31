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
    private List<Item> items;
    @ManyToOne
    @JoinColumn(name = "fk_address")
    private Address address;
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;
    @Column
    private Float total;


    public void addItem(Item item) {
        this.items.add(item);
        this.updateTotal();
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void updateTotal() {
        this.total = this.items.stream().map(Item::getSubtotal).reduce(Float::sum).orElse(0.00f);
    }


}
