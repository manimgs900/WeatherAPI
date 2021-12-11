package com.example.weather.controller;

import com.example.weather.entity.Weather;
import com.example.weather.service.WeatherForecastService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class WeatherController {
    private final WeatherForecastService weatherService;

    public WeatherController(WeatherForecastService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    ResponseEntity<Weather> getWeather(@RequestParam String city) {
        return new ResponseEntity<>(weatherService.getTodayWeather(city), HttpStatus.OK);
    }

    @GetMapping("/weather/forecast")
    ResponseEntity<List<Weather>> getForecast(@RequestParam String city) throws ParseException {
        return new ResponseEntity<>(weatherService.getThreeDayForecast(city), HttpStatus.OK);
    }
}
