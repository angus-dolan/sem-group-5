package com.napier.sem;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static com.napier.sem.ReportPrinting.*;

class AppTest
{
    ArrayList<Country> countries;

    @Test
    void displayCountriesTestNull() {
        displayCountries(null);
    }

    @Test
    void displayCountriesTestEmpty() {
        countries = new ArrayList<>();
        displayCountries(countries);
    }

    @Test
    void displayCountriesContainsNull() {
        countries = new ArrayList<>();
        countries.add(null);
        displayCountries(countries);
    }

    @Test
    void displayCountriesBasic() {
        countries = new ArrayList<>();
        Country c = new Country();
        c.setCode("GBR");
        c.setName("United Kingdom");
        countries.add(c);
        displayCountries(countries);
    }

    @Test
    void displayTopCountriesTestNull() {
        displayTopCountries(null);
    }

    @Test
    void displayTopCountriesTestEmpty() {
        countries = new ArrayList<>();
        displayTopCountries(countries);
    }

    @Test
    void displayTopCountriesContainsNull() {
        countries = new ArrayList<>();
        countries.add(null);
        displayTopCountries(countries);
    }

    @Test
    void displayTopCountriesBasic() {
        countries = new ArrayList<>();
        Country c = new Country();
        c.setCode("GBR");
        c.setName("United Kingdom");
        countries.add(c);
        displayTopCountries(countries);
    }

}