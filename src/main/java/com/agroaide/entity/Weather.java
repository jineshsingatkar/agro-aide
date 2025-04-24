package com.agroaide.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String state;
    private Double temperature;
    private Double humidity;
    private Double windSpeed;
    private String description;
    private LocalDateTime timestamp;
    private Double latitude;
    private Double longitude;
} 