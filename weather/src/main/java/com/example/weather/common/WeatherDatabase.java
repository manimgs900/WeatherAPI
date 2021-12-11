package com.example.weather.common;

import com.example.weather.dao.WeatherRepository;
import com.example.weather.entity.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.util.Date;

@Configuration
public class WeatherDatabase {
    private static final Logger log = LoggerFactory.getLogger(WeatherDatabase.class);

    @Bean
    CommandLineRunner initDatabase(WeatherRepository repository) throws ParseException {

        int i = 0;
        Date todayDate = new Date();
        while(i < 4) {
            String date = Util.addDaysToDate(todayDate, i);

            Weather weather = new Weather("Mumbai", date, "45 C");
            Weather weather1 = new Weather("London", date, "20 C");
            Weather weather2 = new Weather("Agra", date, "25 C");
            Weather weather3 = new Weather("Delhi", date, "28 C");
            Weather weather4 = new Weather("Canada", date, "22 C");

            log.info("Preloading " + repository.save(weather));
            log.info("Preloading " + repository.save(weather1));
            log.info("Preloading " + repository.save(weather2));
            log.info("Preloading " + repository.save(weather3));
            log.info("Preloading " + repository.save(weather4));

            i++;
        }

        return args -> {
            log.info("Weather data saved for multiple dates ");
        };
    }
}
