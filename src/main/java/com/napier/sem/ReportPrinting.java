package com.napier.sem;

import java.util.ArrayList;

public class ReportPrinting {
    /**
     * Displays a list of countries
     * @param countryList   countries to display
     */
    public static void displayCountries(ArrayList<Country> countryList) {
        if (countryList == null) {
            System.out.println("No countries to print");
        }
        else {
            String h1 = "Code", h2 = "Name", h3 = "Continent", h4 = "Region", h5 = "Population", h6 = "Capital";
            // print a header
            System.out.println(String.format("%-4s %-44s %-14s %-25s %-10s %-34s", "Code", "Name", "Continent", "Region", "Population", "Capital"));
            // print details of all countries in the list
            for (Country c : countryList) {
                if(c == null) {
                    continue;
                }
                String country = String.format("%-4s %-44s %-14s %-25s %-10d %-34s",
                        c.getCode(), c.getName(), c.getContinent(), c.getRegion(), c.getPopulation(), c.getCapital());
                System.out.println(country);
            }
        }
    }
}
