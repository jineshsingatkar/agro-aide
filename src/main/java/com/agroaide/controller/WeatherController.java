package com.agroaide.controller;

import com.agroaide.entity.Weather;
import com.agroaide.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/location")
    public ResponseEntity<?> getWeatherByLocation(
            @RequestParam String city,
            @RequestParam String state) {
        return ResponseEntity.ok(weatherService.getWeatherByCityAndState(city, state));
    }

    @GetMapping("/coordinates")
    public ResponseEntity<?> getWeatherByCoordinates(
            @RequestParam Double latitude,
            @RequestParam Double longitude) {
        return ResponseEntity.ok(weatherService.getWeatherByCoordinates(latitude, longitude));
    }
} 