package com.agroaide.service;

import com.agroaide.entity.Weather;
import com.agroaide.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;

    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    private final WebClient webClient;

    public WeatherService() {
        this.webClient = WebClient.builder()
            .baseUrl(apiUrl)
            .build();
    }

    public Weather getWeatherByCityAndState(String city, String state) {
        Optional<Weather> cachedWeather = weatherRepository.findFirstByCityAndStateOrderByTimestampDesc(city, state);
        
        if (cachedWeather.isPresent() && 
            cachedWeather.get().getTimestamp().isAfter(LocalDateTime.now().minusHours(1))) {
            return cachedWeather.get();
        }

        Weather weather = fetchWeatherFromAPI(city, state);
        weather.setCity(city);
        weather.setState(state);
        weather.setTimestamp(LocalDateTime.now());
        
        return weatherRepository.save(weather);
    }

    public Weather getWeatherByCoordinates(Double latitude, Double longitude) {
        Optional<Weather> cachedWeather = weatherRepository.findFirstByLatitudeAndLongitudeOrderByTimestampDesc(latitude, longitude);
        
        if (cachedWeather.isPresent() && 
            cachedWeather.get().getTimestamp().isAfter(LocalDateTime.now().minusHours(1))) {
            return cachedWeather.get();
        }

        Weather weather = fetchWeatherFromAPIByCoordinates(latitude, longitude);
        weather.setLatitude(latitude);
        weather.setLongitude(longitude);
        weather.setTimestamp(LocalDateTime.now());
        
        return weatherRepository.save(weather);
    }

    private Weather fetchWeatherFromAPI(String city, String state) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/weather")
                .queryParam("q", city + "," + state)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .build())
            .retrieve()
            .bodyToMono(Weather.class)
            .block();
    }

    private Weather fetchWeatherFromAPIByCoordinates(Double latitude, Double longitude) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/weather")
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .build())
            .retrieve()
            .bodyToMono(Weather.class)
            .block();
    }

    public void cleanupOldWeatherData() {
        weatherRepository.deleteByTimestampBefore(LocalDateTime.now().minusDays(7));
    }
} 