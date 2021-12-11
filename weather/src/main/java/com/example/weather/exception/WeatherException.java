package com.example.weather.exception;

public class WeatherException extends RuntimeException {

    public WeatherException(String city) {
        super("Could not find weather for " + city);
    }
}
