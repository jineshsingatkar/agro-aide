package com.agroaide.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String fullName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String pincode;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private boolean enabled = true;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private Set<Crop> crops = new HashSet<>();

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();
}

enum UserRole {
    ROLE_USER,
    ROLE_ADMIN
} 