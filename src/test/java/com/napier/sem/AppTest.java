package com.napier.sem;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static com.napier.sem.ReportPrinting.*;

class AppTest {

    ArrayList < Country > countries;
    ArrayList < City > cities;
    App a = new App();

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
    @Test
    void getAllCitiesInContinentTestFalse() {
        cities = new ArrayList<>();
        String continent = "Boop";
        cities = a.getAllCitiesInContinent(continent);
    }
    @Test
    void getAllCitiesInContinentTestTrue() {
        cities = new ArrayList<>();
        String continent = "Africa";
        cities = a.getAllCitiesInContinent(continent);
    }
    @Test
    void getAllCitiesInDistrictTestFalse() {
        cities = new ArrayList<>();
        String district = "Boop";
        cities = a.getAllCitiesInDistrict(district);
    }
    @Test
    void getAllCitiesInDistrictTestTrue() {
        cities = new ArrayList<>();
        String district = "Bretagne";
        cities = a.getAllCitiesInDistrict(district);
    }
    @Test
    void getAllCitiesInCountryTestFalse() {
        cities = new ArrayList<>();
        String country = "Boop";
        cities = a.getAllCitiesInCountry(country);
    }
    @Test
    void getAllCitiesInCountryTestTrue() {
        cities = new ArrayList<>();
        String country = "France";
        cities = a.getAllCitiesInCountry(country);
    }
    @Test
    void getAllCitiesInRegionTestFalse() {
        cities = new ArrayList<>();
        String region = "Boop";
        cities = a.getAllCitiesInRegion(region);
    }
    @Test
    void getAllCitiesInRegionTestTrue() {
        cities = new ArrayList<>();
        String region = "Middle East";
        cities = a.getAllCitiesInRegion(region);
    }
    @Test
    void getAllCitiesInWorldTestTrue() {
        cities = new ArrayList<>();
        cities = a.getAllCitiesInWorld();
    }

    @Test
    void topNCitiesInWorldBigNumber(){
        cities = new ArrayList<>();
        int pass = 70000000;
        cities = a.getNCitiesInWorld(pass);
        // assertEquals(cities, null);

    }
    @Test
    void topNCitiesInWorldSmallNumber(){
        cities = new ArrayList<>();
        int pass = -70000000;
        cities = a.getNCitiesInWorld(pass);


    }
    @Test
    void topNCitiesInWorldNull(){
        cities = new ArrayList<>();
        int pass = 0;
        cities =  a.getNCitiesInWorld(pass);

    }
    @Test
    void topNCitiesInWorldNormal(){
        cities = new ArrayList<>();
        int pass = 5;
        cities = a.getNCitiesInWorld(pass);

    }
    @Test
    void topNCitiesInDistrictBigNumber(){
        cities = new ArrayList<>();
        int pass = 70000000;
        cities =  a.getNCitiesInDistrict(pass, "");

    }
    @Test
    void topNCitiesInDistrictSmallNumber(){
        cities = new ArrayList<>();
        int pass = -70000000;
        cities = a.getNCitiesInDistrict(pass, "");

    }
    @Test
    void topNCitiesInDistrictNull(){
        cities = new ArrayList<>();
        int pass = 0;
        cities = a.getNCitiesInDistrict(pass, "");

    }
    @Test
    void topNCitiesInDistrictNormal(){
        cities = new ArrayList<>();
        int pass = 5;
        cities = a.getNCitiesInDistrict(pass, "");

    }
    @Test
    void topNCitiesInRegionBigNumber(){
        cities = new ArrayList<>();
        int pass = 70000000;
        cities =  a.getNCitiesInRegion(pass, "");

    }
    @Test
    void topNCitiesInRegionSmallNumber(){
        cities = new ArrayList<>();
        int pass = -70000000;
        cities = a.getNCitiesInRegion(pass, "");

    }
    @Test
    void topNCitiesInRegionNull(){
        cities = new ArrayList<>();
        int pass = 0;
        cities = a.getNCitiesInRegion(pass, "");

    }
    @Test
    void topNCitiesInRegionNormal(){
        cities = new ArrayList<>();
        int pass = 5;
        cities = a.getNCitiesInRegion(pass, "");

    }
    @Test
    void topNCitiesInCountryBigNumber(){
        cities = new ArrayList<>();
        int pass = 70000000;
        cities = a.getNCitiesInCountry(pass, "");

    }
    @Test
    void topNCitiesInCountrySmallNumber(){
        cities = new ArrayList<>();
        int pass = -70000000;
        cities = a.getNCitiesInCountry(pass, "");

    }
    @Test
    void topNCitiesInCountryNull(){
        cities = new ArrayList<>();
        int pass = 0;
        cities = a.getNCitiesInCountry(pass, "");

    }
    @Test
    void topNCitiesInCountryNormal(){
        cities = new ArrayList<>();
        int pass = 5;
        cities = a.getNCitiesInCountry(pass, "");

    }



}
