package com.example.weather.advice;

import com.example.weather.exception.WeatherException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WeatherNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(WeatherException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(WeatherException ex) {
        return ex.getMessage();
    }
}
