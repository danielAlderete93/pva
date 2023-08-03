package com.veggie.veggieapp.model;

import com.veggie.veggieapp.exceptions.InvalidQuantityException;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_food", referencedColumnName = "id")
    private Food food;
    @Column(name = "unit_price", nullable = false)
    private Float unitPrice;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Float subtotal;


    public void incrementQuantity(Integer quantity) {
        validateFoodHasStock(this.quantity + quantity);

        this.quantity += quantity;
        this.food.reduceStock(quantity);


        this.updateSubtotal();
    }


    public void reduceQuantity(Integer quantity) {
        validateReduceQuantity(this.quantity - quantity);
        this.quantity -= quantity;
        this.food.incrementStock(quantity);

        this.updateSubtotal();
    }


    public void reduceFoodStock() {
        food.reduceStock(quantity);
    }

    public void increaseFoodStock() {
        food.incrementStock(quantity);
    }

    public boolean hasQuantity() {
        return this.quantity > 0;
    }

    private void updateSubtotal() {
        this.subtotal = this.unitPrice * this.quantity;
    }

    private void validateFoodHasStock(Integer quantity) {
        if (!food.hasStockFor(quantity)) {
            throw new InvalidQuantityException("Insufficient stock for the requested quantity.");
        }
    }

    private void validateReduceQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new InvalidQuantityException("The resulting quantity would be negative.");
        }
    }

}

