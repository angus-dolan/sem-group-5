package com.napier.sem;

/**
 * Represents a country
 */
public class Country {
    /**
     * Country's code, e.g. "GBR" -> "United Kingdom"
     */
    private String code;

    /**
     * Country's name
     */
    private String name;

    /**
     * Country's population
     */
    private int population;

    /**
     * Country's capital
     */
    private String capital;

    /**
     * Country's continent
     */
    private String continent;

    /**
     * Country's region
     */
    private String region;

    /**
     * Default empty constructor
     */
    public Country() {
    }

    /**
     * Gets the country's code
     * @return  country code
     */
    public String getCode() {
        return code;
    }

    /**
     * Changes the value of the country's code
     * @param code  country code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the country name
     * @return  country name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the country
     * @param name  country name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the population of the country
     * @return  country's population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Changes the population of the country
     * @param population    population to set
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Gets the country's capital
     * @return  country's capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Changes the country's capital
     * @param capital   the country's capital to set
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * Gets the country's continent
     * @return  country's continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Changes the country's continent
     * @param continent country's continent to set
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets the country's region
     * @return  country's region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Changes the country's region
     * @param region    country's region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }
}
