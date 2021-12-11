package com.example.weather.service;

import com.example.weather.common.Util;
import com.example.weather.dao.WeatherRepository;
import com.example.weather.entity.Weather;
import com.example.weather.exception.WeatherException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WeatherForecastService {

    private final WeatherRepository repository;

    public WeatherForecastService(WeatherRepository repository) {
        this.repository = repository;
    }

    public Weather getTodayWeather(String city) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(date);

        Weather cityWeather = repository.getTodayWeather(city, strDate);

        if(cityWeather == null) {
            throw new WeatherException(city);
        }

        return cityWeather;
    }

    public List<Weather> getThreeDayForecast(String city) throws ParseException {
        Date date = new Date();
        String todayDate = Util.addDaysToDate(date, 0);
        String thirdDate = Util.addDaysToDate(date, 2);

        List<Weather> forecast = repository.getThreeDayWeather(city, todayDate, thirdDate);

        if(forecast == null || forecast.isEmpty()) {
            throw new WeatherException(city);
        }

        return forecast;
    }
}
