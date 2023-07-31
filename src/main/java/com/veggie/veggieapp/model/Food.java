package com.veggie.veggieapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@SuppressWarnings("ALL")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false)
    private Float price;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_x_food",
            joinColumns = @JoinColumn(name = "fk_food"),
            inverseJoinColumns = @JoinColumn(name = "fk_category"))
    private List<Category> categories;


    public Boolean hasStockFor(Integer countToOrder) {
        return stock - countToOrder > 0;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
    }

    public void incrementStock(Integer count) {
        this.stock += count;
    }

    public void decrementStock(Integer count) {
        this.stock -= count;
    }


}
