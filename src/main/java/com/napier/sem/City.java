package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * representation of a city
 */
public class City {

    /**
     * name of city
     */
    private String name;
    /**
     * country of city
     */
    private String country;
    /**
     * district of city
     */
    private String district;
    /**
     * population of city
     */
    private long population;

    /**
     * Constructor for City
     */
    public City(){

    }

    /**
     * Retrieves the cities name
     * @return city name
     */
    public String getName() {
        return name;
    }

    /**
     * sets/changes the cities name
     * @param name of city to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * retrieves city name
     * @return city name
     */
    public String getCountry() {
        return country;
    }

    /**
     * sets/changes the cities country
     * @param country name to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * retrieves cities district
     * @return cities district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * sets/changes cities district
     * @param district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * retrieves cities population
     * @return cities populations
     */
    public long getPopulation() {
        return population;
    }

    /**
     * sets/changes cities population
     * @param population to set
     */
    public void setPopulation(long population) {
        this.population = population;
    }


}
