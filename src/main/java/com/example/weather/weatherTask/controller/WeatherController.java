package com.example.weather.weatherTask.controller;

import com.example.weather.weatherTask.dto.WeatherResponseDTO;
import com.example.weather.weatherTask.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public WeatherResponseDTO getWeather(@RequestParam double lat, @RequestParam double lon){
        return weatherService.getWeatherForCoords(lat, lon);
    }

    @GetMapping("/city")
    public WeatherResponseDTO getWeatherByCity(@RequestParam String city){
        return weatherService.getWeatherByCity(city);
    }
}
