package com.tech.mai.events.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aamirio on 18/12/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {

    Double lon;
    Double lat;

    public Coordinates() {
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
