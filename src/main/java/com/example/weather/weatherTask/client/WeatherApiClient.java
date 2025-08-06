package com.example.weather.weatherTask.client;

import com.example.weather.weatherTask.dto.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApiClient {

    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherApiResponse fetchWeather(double lat, double lon){
        String url = String.format("%s?lat=%s&lon=%s&appid=%s", apiUrl, lat, lon, apiKey);
        return restTemplate.getForObject(url, WeatherApiResponse.class);
    }

    public WeatherApiResponse fetchWeatherByCity(String city){
        String url = String.format("%s?q=%s&appid=%s", apiUrl, city, apiKey);
        return restTemplate.getForObject(url, WeatherApiResponse.class);
    }
}
