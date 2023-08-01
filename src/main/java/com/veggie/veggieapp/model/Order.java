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


    public Order addItem(Item item) {
        Item itemExisted = this.findItemByFood(item.getFood());

        if (itemExisted == null) {
            this.items.add(item);
        } else {
            itemExisted.incrementCount(item.getCount());
        }

        return this.updateTotal();
    }

    public Order removeItem(Item item) {
        Item itemExisted = this.findItemByFood(item.getFood());

        if (itemExisted == null)
            return this;

        itemExisted.decrementCount(item.getCount());

        if (!itemExisted.hasCount()) {
            this.items.remove(item);
        }

        return this.updateTotal();
    }

    public Order updateTotal() {
        this.total = this.items.stream().map(Item::getSubtotal).reduce(Float::sum).orElse(0.00f);
        return this;
    }

    private Item findItemByFood(Food food) {
        return this.items.stream()
                .filter(item -> item.getFood().equals(food))
                .findFirst()
                .orElse(null);
    }


}
