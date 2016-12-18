package com.tech.mai.events.consumer;

import com.tech.mai.events.rest.domain.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Aamirio on 18/12/2016.
 */
public class WeatherConsumer {

    private static final Logger log = LoggerFactory.getLogger(EventsConsumer.class);
    private static final String URL_WEATHER =
            "http://api.openweathermap.org/data/2.5/forecast/daily?APPID=3f1f41d412ab64655c33952291121a96&lat=%s&lon=%s&cnt=%s";

    public WeatherData getWeatherByLocation(double latitude, double longitude, int noOfDays) {
        log.info(String.format("getWeatherByLocation(lat: %s,long: %s,noOfDays: %s)", latitude, longitude, noOfDays));

        final String url = String.format(URL_WEATHER, latitude, longitude, noOfDays);
        WeatherData weatherData = new RestTemplate().getForObject(url, WeatherData.class);

        return weatherData;
    }

}
