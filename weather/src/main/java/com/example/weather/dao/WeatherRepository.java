package com.example.weather.dao;

import com.example.weather.entity.Weather;

import java.util.List;

public interface WeatherRepository {

    Weather getTodayWeather(String city, String date);

    List<Weather> getThreeDayWeather(String city, String startDate, String endDate);

    String save(Weather weather);
}
