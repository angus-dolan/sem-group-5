package com.napier.sem;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static com.napier.sem.ReportPrinting.*;

class AppTest {

    ArrayList < Country > countries;
    ArrayList < City > cities;



    @Test
    void displayCountriesTestNull() {
        displayCountries(null);
    }

    @Test
    void displayCountriesTestEmpty() {
        countries = new ArrayList < > ();
        displayCountries(countries);
    }

    @Test
    void displayCountriesContainsNull() {
        countries = new ArrayList < > ();
        countries.add(null);
        displayCountries(countries);
    }

    @Test
    void displayCountriesBasic() {
        countries = new ArrayList < > ();
        Country c = new Country();
        c.setCode("GBR");
        c.setName("United Kingdom");
        c.setContinent("Europe");
        c.setPopulation(59623400);
        c.setCapital("London");
        c.setRegion("British Islands");
        countries.add(c);
        displayCountries(countries);
    }

    @Test
    void displayTopCountriesTestNull() {
        displayTopCountries(null);
    }

    @Test
    void displayTopCountriesTestEmpty() {
        countries = new ArrayList < > ();
        displayTopCountries(countries);
    }

    @Test
    void displayTopCountriesContainsNull() {
        countries = new ArrayList < > ();
        countries.add(null);
        displayTopCountries(countries);
    }

    @Test
    void displayTopCountriesBasic() {
        countries = new ArrayList < > ();
        Country c = new Country();
        c.setCode("GBR");
        c.setName("United Kingdom");
        countries.add(c);
        displayTopCountries(countries);
    }

    @Test
    void displayCitiesTestNullSet() {

        displayCountries(null);
    }

    @Test
    void displayCitiesTestEmptySet() {
        cities = new ArrayList < > ();
        displayCities(cities);
    }

    @Test
    void displayCitiesTestSetContainsNull() {
        cities = new ArrayList < > ();
        cities.add(null);
        displayCities(cities);
    }

    @Test
    void displayCitiesTestStandard() {
        cities = new ArrayList < > ();
        City city = new City();
        city.setCountry("France");
        city.setName("Paris");
        city.setPopulation(90);
        city.setDistrict("Île-de-France");
        cities.add(city);
        displayCities(cities);
    }

    @Test
    void displayTopCitiesTestContainsNull() {
        cities = new ArrayList < City > ();
        cities.add(null);
        displayTopCountries(countries);
    }
    @Test
    void displayTopCitiesTestStandard() {
        cities = new ArrayList < > ();
        City city = new City();
        city.setName("Paris");
        city.setPopulation(400);
        city.setDistrict("Île-de-France");
        city.setCountry("France");
        cities.add(city);
        displayTopCountries(countries);
    }
    @Test
    void displayTopCitiesTestEmptySet() {
        cities = new ArrayList < > ();
        displayTopCities(cities);
    }
    @Test
    void displayTopCitiesTestNull() {
        displayTopCountries(null);
    }

    @Test
    void DisplayPopulationsTestNullEntry() {
        countries = new ArrayList<>();
        countries.add(null);
        displayTopCountries(countries);
    }

    @Test
    void DisplayPopulationsTestNull() {
        displayTopCountries(null);
    }
    @Test
    void DisplayPopulationsSimple() {
        countries = new ArrayList<>();
        Country c = new Country();
        c.setCapital("Paris");
        c.setPopulation(500);
        c.setCode("Fra");
        c.setRegion("Paris Region");
        c.setContinent("Europe");
        c.setName("France");
        countries.add(c);
        displayTopCountries(countries);
    }
    @Test
    void DisplayPopulationsEmptySet() {
       countries = new ArrayList<>();
        displayTopCountries(countries);
    }


}