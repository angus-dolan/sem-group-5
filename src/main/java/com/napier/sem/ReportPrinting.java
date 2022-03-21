package com.napier.sem;

import java.util.ArrayList;

public class ReportPrinting {

    /**
     * Displays a list of capital cities
     * @param cityList   capital cities to display
     */
    public static void displayCapitalCities(ArrayList <CapitalCity> cityList) {
        if (cityList == null || cityList.isEmpty()) {
            System.out.println("No cities to print");
        } else {
            String h1 = "Name", h2 = "Population";
            // print a header
            System.out.println(String.format("%-25s %-25s", "Name", "Population"));
            // print details of all countries in the list
            for (CapitalCity c: cityList) {
                if (c == null) {
                    continue;
                }
                String country = String.format("%-25s %-25s ", c.getName(), c.getPopulation());
                System.out.println(country);
            }
        }
    }

    /**
     * Displays a list of countries
     * @param countryList   countries to display
     */
    public static void displayCountries(ArrayList < Country > countryList) {
        if (countryList == null || countryList.isEmpty()) {
            System.out.println("No countries to print");
        } else {
            String h1 = "Code", h2 = "Name", h3 = "Continent", h4 = "Region", h5 = "Population", h6 = "Capital";
            // print a header
            System.out.println(String.format("%-4s %-44s %-14s %-25s %-10s %-34s", "Code", "Name", "Continent", "Region", "Population", "Capital"));
            // print details of all countries in the list
            for (Country c: countryList) {
                if (c == null) {
                    continue;
                }
                String country = String.format("%-4s %-44s %-14s %-25s %-10d %-34s",
                        c.getCode(), c.getName(), c.getContinent(), c.getRegion(), c.getPopulation(), c.getCapital());
                System.out.println(country);
            }
        }
    }
    /**
     * Displays a list of countries with numbering
     * @param countryList   countries to display
     */
    public static void displayTopCountries(ArrayList < Country > countryList) {
        if (countryList == null || countryList.isEmpty()) {
            System.out.println("No countries to print");
        } else {
            String h1 = "Code", h2 = "Name", h3 = "Continent", h4 = "Region", h5 = "Population", h6 = "Capital";
            // print a header
            System.out.println(String.format("%3s %-4s %-44s %-14s %-25s %-10s %-34s", "No", "Code", "Name", "Continent", "Region", "Population", "Capital"));
            // print details of all countries in the list
            int counter = 1;
            for (Country c: countryList) {
                if (c == null) {
                    continue;
                }
                String country = String.format("%2s. %-4s %-44s %-14s %-25s %-10d %-34s", counter,
                        c.getCode(), c.getName(), c.getContinent(), c.getRegion(), c.getPopulation(), c.getCapital());
                System.out.println(country);
                counter++;
            }
        }
    }
    /**
     * Displays a list of cities
     * @param cityList   countries to display
     */
    public static void displayCities(ArrayList < City > cityList) {
        if (cityList == null || cityList.isEmpty()) {
            System.out.println("No cities to print");
        } else {
            String h1 = "Name", h2 = "Country", h3 = "District", h4 = "Population";
            // print a header
            System.out.println(String.format("%-25s   %-50s   %-47s   %-25s", "Name", "Country", "District", "Population"));
            // print details of all countries in the list
            for (City c: cityList) {
                if (c == null) {
                    continue;
                }
                String city = String.format("%-25s   %-50s   %-47s   %-25d",
                        c.getName(), c.getCountry(), c.getDistrict(), c.getPopulation());
                System.out.println(city);
            }
        }
    }
    /**
     * Displays a list of cities with numbering
     * @param cityList   cities to display
     */
    public static void displayTopCities(ArrayList < City > cityList) {
        int counter = 1;
        if (cityList == null || cityList.isEmpty()) {
            System.out.println("No cities to print");
        } else {
            String h1 = "Name", h2 = "Country", h3 = "District", h4 = "Population";
            // print a header
            System.out.println(String.format("%3s. %-20s   %-50s   %-47s   %-25s", "No", "Name", "Country", "District", "Population"));
            // print details of all countries in the list
            for (City c: cityList) {
                if (c == null) {
                    continue;
                }

                String city = String.format("%2d. %-20s   %-50s   %-47s   %-25d", counter,
                        c.getName(), c.getCountry(), c.getDistrict(), c.getPopulation());
                System.out.println(city);
                counter++;
            }
        }
    }

    /**
     * Displays a list of populations
     * @param populations   list of Population objects
     * @param typeOfQuery
     */
    public static void displayPopulations(ArrayList<Population> populations, String typeOfQuery){
        if(typeOfQuery == null) {
            System.out.println("Invalid type of query specified to print header");
        }
        else {
            System.out.println(String.format("%-24s %-24s %-14s %-24s %-24s %-24s",  typeOfQuery , "Population", "City Population", "City Population %", "Non City Population", "Non City Population %"));
        }

        if(populations == null || populations.isEmpty()) {
            System.out.println("No populations to print");
        }
        else {
            for (Population population : populations) {
                if(population != null) {
                    System.out.println(String.format("%-24s %-24s %-14s %-24s %-24s %-24s",
                            population.getName(), population.getPopulation(), population.getCityPopulation(), population.getCityPopulationPercent(), population.getNotCityPopulation(), population.getNonCityPopulationPercent()));
                }
            }
        }
    }

    /**
     * Displays a report on languages
     * @param language   list of Language objects
     */
    public static void displayLanguage(ArrayList<Language> language)
    {
        // Check language is not null
        if (language == null)
        {
            System.out.println("No languages information available from the database!");
            return;
        }

        // Print header
        System.out.println(String.format("%-24s %-24s %-24s", "language", "Population", "Percentage"));
        // Loop over all languages in the list
        for (Language cnt : language)
        {
            if (cnt == null)
                continue;

            String cnt_string =
                    String.format("%-24s %-24s %-24s",
                            cnt.getLanguage(), cnt.getPopulation(), cnt.getPercentage());
            System.out.println(cnt_string);
        }
    }
}