package com.example.weather.weatherTask.service;

import com.example.weather.weatherTask.client.WeatherApiClient;
import com.example.weather.weatherTask.dto.WeatherApiResponse;
import com.example.weather.weatherTask.dto.WeatherResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherApiClient apiClient;

    private WeatherResponseDTO mapToDTO(WeatherApiResponse apiResponse){
        double temperatureInCelsius = apiResponse.getMain().getTemp() - 273.15;

        return new WeatherResponseDTO(
                apiResponse.getName(),
                apiResponse.getCoord().getLat(),
                apiResponse.getCoord().getLon(),
                Math.round(temperatureInCelsius * 100.0) / 100.0,
                apiResponse.getMain().getHumidity(),
                apiResponse.getWeather().get(0).getDescription()
        );
    }

    @Override
    public WeatherResponseDTO getWeatherForCoords(double lat, double lon) {
        WeatherApiResponse apiResponse = apiClient.fetchWeather(lat, lon);
        return mapToDTO(apiResponse);
    }

    @Override
    public WeatherResponseDTO getWeatherByCity(String city) {
        WeatherApiResponse apiResponse = apiClient.fetchWeatherByCity(city);
        return mapToDTO(apiResponse);
    }
}
