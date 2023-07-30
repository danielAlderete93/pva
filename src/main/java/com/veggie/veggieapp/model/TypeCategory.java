package com.veggie.veggieapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "types_category")
public class TypeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column()
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_x_type_category",
            joinColumns = @JoinColumn(name = "fk_type_category"),
            inverseJoinColumns = @JoinColumn(name = "fk_category"))
    private List<Category> categories;
}
