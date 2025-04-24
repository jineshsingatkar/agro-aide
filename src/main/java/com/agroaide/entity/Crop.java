package com.agroaide.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "crops")
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private String unit; // kg, ton, etc.

    @Column(nullable = false)
    private String category; // grains, vegetables, fruits, etc.

    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime harvestDate;

    @Column(nullable = false)
    private LocalDateTime expiryDate;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    private boolean available = true;

    @Column(nullable = false)
    private String location;

    private String qualityGrade;

    @Column(columnDefinition = "TEXT")
    private String additionalDetails;
} 