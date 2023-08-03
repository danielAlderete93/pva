package com.veggie.veggieapp.model;

import com.veggie.veggieapp.exceptions.DuplicateFoodOrderException;
import com.veggie.veggieapp.exceptions.FoodNotOrderedException;
import com.veggie.veggieapp.exceptions.InvalidOrderStateException;
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
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column
    private Float total;

    public void addItem(Food food, Integer quantity) {
        validateOrderCanBeUpdated();
        validateFoodNotOrdered(food);


        Item item = createItem(food, quantity);
        this.items.add(item);
        item.reduceFoodStock();
        updateTotal();
    }

    public void removeItem(Food food) {
        validateOrderCanBeUpdated();

        Item itemOrdered = this.findItemByFood(food);

        this.items.remove(itemOrdered);
        itemOrdered.increaseFoodStock();
        updateTotal();
    }

    public void increaseQuantityForItem(Food food, Integer quantity) {
        validateOrderCanBeUpdated();

        Item itemToIncrease = this.findItemByFood(food);
        itemToIncrease.incrementQuantity(quantity);
        updateTotal();
    }

    public void reduceQuantityForItem(Food food, Integer quantity) {
        validateOrderCanBeUpdated();

        Item itemToReduce = this.findItemByFood(food);
        itemToReduce.reduceQuantity(quantity);

        if (!itemToReduce.hasQuantity()) {
            this.items.remove(itemToReduce);
        }
        updateTotal();
    }

    private void updateTotal() {
        this.total = this.items.stream()
                .map(Item::getSubtotal)
                .reduce(Float::sum)
                .orElse(0.00f)
        ;
    }

    public boolean hasOrderedFood(Food food) {
        return this.items.stream().anyMatch(item -> item.getFood().equals(food));
    }

    public boolean itemsCanBeUpdated() {
        return this.getStatus() == OrderStatus.READY_TO_ORDER || this.getStatus() == OrderStatus.READY_TO_PAY;
    }

    private void validateOrderCanBeUpdated() {
        if (!itemsCanBeUpdated()) {
            throw new InvalidOrderStateException("The order cannot be updated because its current state does not allow modifications. Only orders with 'ReadyToOrder' or 'ReadyToPay' status can be updated.");
        }
    }

    private Item findItemByFood(Food food) {
        return this.items.stream()
                .filter(item -> item.getFood().equals(food))
                .findFirst()
                .orElseThrow(() -> new FoodNotOrderedException("The food item has not been ordered."));
    }


    private void validateFoodNotOrdered(Food food) {
        if (hasOrderedFood(food)) {
            throw new DuplicateFoodOrderException("The food item has already been ordered.");
        }
    }

    private Item createItem(Food food, Integer quantity) {
        return Item.builder()
                .food(food)
                .unitPrice(food.getPrice())
                .quantity(quantity)
                .subtotal(food.getPrice() * quantity)
                .build();
    }


}
