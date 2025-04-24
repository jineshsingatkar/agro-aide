package com.agroaide.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    private Double temperature;
    private Double humidity;
    private Double windSpeed;
    private String description;
    private String icon;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private Double latitude;
    private Double longitude;
} 