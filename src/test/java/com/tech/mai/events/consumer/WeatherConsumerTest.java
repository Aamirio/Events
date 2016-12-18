package com.tech.mai.events.consumer;

import com.tech.mai.events.consumer.domain.Forecast;
import com.tech.mai.events.consumer.domain.WeatherData;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Aamirio on 18/12/2016.
 */
public class WeatherConsumerTest {

    private static final Logger log = LoggerFactory.getLogger(WeatherConsumerTest.class);

    private WeatherConsumer weatherConsumer = new WeatherConsumer();

    @Test
    public void getWeatherByLocation() {
        WeatherData weatherData = weatherConsumer.getWeatherByLocation(51.501, -0.124, 16);
        assertForecasts(weatherData);
    }

    private void assertForecasts(WeatherData weatherData) {

        assertNotNull(weatherData);
        assertNotNull(weatherData.getList());
        assertNotNull(weatherData.getCity());
        assertNotNull(weatherData.getCity().getCoord());
        assertNotNull(weatherData.getCnt());
        assertEquals(16, weatherData.getCnt().intValue());

        log.info("\n\tCity: " + weatherData.getCity().getName()
                + "\n\tLatitude: " + weatherData.getCity().getCoord().getLat()
                + "\n\tLongitude: " + weatherData.getCity().getCoord().getLon()
                + "\n\tCount: " + weatherData.getCnt());

        List<Forecast> forecasts = weatherData.getList();

        assertTrue(forecasts.size() > 0);

        for(Forecast forecast : weatherData.getList()) {
            assertNotNull(forecast);
            assertNotNull(forecast.getWeather());
            assertNotNull(forecast.getTemp());

            log.info("\n\tDaytime Temp: " + forecast.getTemp().getDay()
                    + "\n\tClouds: " + forecast.getClouds()
                    + "\n\tDate: " + forecast.getDt()
                    + "\n\tHumidity: " + forecast.getHumidity()
                    + "\n\tPressure: " + forecast.getPressure());
        }
    }

    private Date getDate(long milliseconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return calendar.getTime();
    }

}
