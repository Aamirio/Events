package com.tech.mai.events.consumer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aamirio on 18/12/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    private City(){}

    private Integer id;
    private String name;
    private Coordinates coord;
    private String country;
    private Integer population;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
