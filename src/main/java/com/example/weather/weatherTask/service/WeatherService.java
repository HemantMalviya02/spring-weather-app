package com.example.weather.weatherTask.service;

import com.example.weather.weatherTask.dto.WeatherResponseDTO;

public interface WeatherService {
    WeatherResponseDTO getWeatherForCoords(double lat, double lon);
    WeatherResponseDTO getWeatherByCity(String city);
}
