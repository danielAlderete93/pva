package com.veggie.veggieapp.model;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column()
    private String description;
}
