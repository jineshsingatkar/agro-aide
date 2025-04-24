package com.agroaide.repository;

import com.agroaide.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Optional<Weather> findFirstByCityAndStateOrderByTimestampDesc(String city, String state);
    Optional<Weather> findFirstByLatitudeAndLongitudeOrderByTimestampDesc(Double latitude, Double longitude);
    void deleteByTimestampBefore(LocalDateTime timestamp);
} 