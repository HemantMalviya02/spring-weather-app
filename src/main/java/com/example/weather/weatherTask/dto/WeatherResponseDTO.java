package com.example.weather.weatherTask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherResponseDTO {

    private String location;
    private double latitude;
    private double longitude;
    private double temperature;
    private int humidity;
    private String description;
}
