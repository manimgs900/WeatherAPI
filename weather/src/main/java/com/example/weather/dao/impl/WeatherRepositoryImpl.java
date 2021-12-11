package com.example.weather.dao.impl;

import com.example.weather.dao.WeatherRepository;
import com.example.weather.entity.Weather;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Weather getTodayWeather(String city, String date) {
        try {
            Weather weather =
                    (Weather) entityManager.createQuery("select w from Weather w "
                                    + "where w.city =: city and w.date =: date")
                            .setParameter("city", city)
                            .setParameter("date", date)
                            .getSingleResult();
            return weather;
        } catch (NoResultException nRex) {
            return null;
        }
    }

    @Override
    public List<Weather> getThreeDayWeather(String city, String startDate, String endDate) {
        try {
            List<Weather> weatherList =
                    (List<Weather>) entityManager.createQuery("select w from Weather w "
                                    + "where w.city =: city and w.date >=: startDate and w.date <=: endDate")
                            .setParameter("city", city)
                            .setParameter("startDate", startDate)
                            .setParameter("endDate", endDate)
                            .getResultList();
            return weatherList;
        } catch (NoResultException nRex) {
            return null;
        }
    }

    @Transactional
    @Override
    public String save(Weather weather) {
        try {
            entityManager.persist(weather);
            return weather.getCity();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
