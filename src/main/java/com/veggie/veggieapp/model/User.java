package com.veggie.veggieapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "address_x_user",
            joinColumns = @JoinColumn(name = "fk_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_address"))
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_x_user",
            joinColumns = @JoinColumn(name = "fk_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_order"))
    private List<Order> orders;

}
