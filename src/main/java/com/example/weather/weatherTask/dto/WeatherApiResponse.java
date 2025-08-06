package com.example.weather.weatherTask.dto;

import lombok.Data;

import java.util.List;

@Data
public class WeatherApiResponse {
    private Coord coord;
    private List<Weather> weather;
    private Main main;
    private String name;

    @Data
    public static class Coord{
        private double lon;
        private double lat;
    }

    @Data
    public static class Weather{
        private String description;
    }

    @Data
    public static class Main{
        private double temp;
        private double humidity;
    }
}
