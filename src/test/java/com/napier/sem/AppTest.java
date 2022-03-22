package com.napier.sem;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static com.napier.sem.ReportPrinting.*;

class AppTest {

    ArrayList < Country > countries;
    ArrayList<Population> populations;
    ArrayList < City > cities;
    ArrayList < CapitalCity > capCities;
    App a = new App();

    // *** displayCountries ***
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

    // *** displayTopCountries ***
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

    // *** displayCities ***
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

    // *** displayTopCities ***
    @Test
    void displayTopCitiesTestContainsNull() {
        cities = new ArrayList < City > ();
        cities.add(null);
        displayTopCities(cities);
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
        displayTopCities(cities);
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
    // *** displayPopulations ***
    @Test
    void testDisplayPopulationsTestNullEntry() {
        populations = new ArrayList<>();
        populations.add(null);
        displayPopulations(populations, "Country");
    }
    @Test
    void testDisplayPopulationsTestBothNull() {
        displayPopulations(null, null);
    }
    @Test
    void testDisplayPopulationsSimple() {
        populations = new ArrayList<>();
        Population p = new Population();
        p.setPopulation(130000);
        p.setCityPopulation(40000);
        p.setCityPopulationPercent(12);
        p.setName("Scottish");
        p.setNotCityPopulation(90000);
        p.setNonCityPopulationPercent(88);
        populations.add(p);
        displayPopulations(populations, "Country");
    }
    @Test
    void DisplayPopulationsEmptySet() {
        populations = new ArrayList<>();
        displayPopulations(populations, "Country");
    }

    // *** City reports ***
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

    // *** Top cities reports ***
    @Test
    void topNCitiesInWorldBigNumber(){
        cities = new ArrayList<>();
        int pass = 70000000;
        cities = a.getNCitiesInWorld(pass);
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
        cities = a.getNCitiesInCountry(pass, "France");
    }

    // *** language tests ***
    @Test
    void testLanguage(){
        a.getLanguage();
    }
    @Test
    void testDisplayLanguageNull(){
        displayLanguage(null);
    }
    @Test
    void testDisplayLanguageEmpty(){
        ArrayList languages = new ArrayList();
        displayLanguage(languages);
    }
    @Test
    void testDisplayLanguageNormal(){
        ArrayList <Language> languages = new ArrayList();
        Language l = new Language(900000, "Arabic", 17);

        languages.add(l);
        displayLanguage(languages);
    }
    @Test
    void testDisplayLanguageNullEntry(){
        ArrayList <Language> languages = new ArrayList();
        languages.add(null);
        displayLanguage(languages);
    }

    // *** Population reports ***
    @Test
    void getTestPopulationInCityByContinent(){
        a.getPopulationInCityByContinent();
    }
    @Test
    void getTestPopulationInCityByCountry(){
        a.getPopulationInCityByCountry();
    }
    @Test
    void getTestPopulationInCityByRegion(){
        a.getPopulationInCityByRegion();
    }
    @Test
    void testLanguageConstructor(){
        Language l = new Language();
        l.setLanguage("Russian");
        l.setPopulation(12);
        l.setPercentage(1);
        l.getLanguage();
        l.getPercentage();
        l.getPopulation();
        l.toString();
        Language l2 = new Language( 12, "Swedish",3);
    }
    @Test
    void testPopulationConstructor(){
        Population p = new Population();
        p.setCityPopulation(40000);
        p.setCityPopulationPercent(12);
        p.setName("Scottish");
        p.setNotCityPopulation(90000);
        p.setNonCityPopulationPercent(88);
        p.getCityPopulation();
        p.getCityPopulationPercent();
        p.getName();
        p.getNotCityPopulation();
        p.getNonCityPopulationPercent();
        p.toString();
    }

    // *** Country reports ***
    @Test
    void testGetAllCountriesInWorld() {
        a.getAllCountriesInWorld();
    }
    @Test
    void testGetTopNCountriesInWorld0() {
        a.getTopNCountriesInWorld(0);
    }
    @Test
    void testGetTopNCountriesInWorldNegative() {
        a.getTopNCountriesInWorld(-1);
    }
    @Test
    void testGetTopNCountriesInWorldBasic() {
        a.getTopNCountriesInWorld(5);
    }
    @Test
    void testGetAllCountriesInContinentBasic() {
        a.getAllCountriesInContinent("Africa");
    }
    @Test
    void testGetAllCountriesInContinentNull() {
        a.getAllCountriesInContinent(null);
    }

    // *** Top countries reports ***
    @Test
    void testGetTopNCountriesInContinentBothWrong() {
        a.getTopNCountriesInContinent(null, 0);
    }
    @Test
    void testGetTopNCountriesInContinentWrongLimit() {
        a.getTopNCountriesInContinent("Africa", -1);
    }
    @Test
    void testGetTopNCountriesInContinentWrongCont() {
        a.getTopNCountriesInContinent(null, 5);
    }
    @Test
    void testGetTopNCountriesInContinentBasic() {
        a.getTopNCountriesInContinent("Africa", 5);
    }
    @Test
    void testGetAllCountriesInRegionBasic() {
        a.getAllCountriesInRegion("Baltic Countries");
    }
    @Test
    void testGetAllCountriesInRegionNull() {
        a.getAllCountriesInRegion(null);
    }
    @Test
    void testGetTopNCountriesInRegionBothWrong() {
        a.getTopNCountriesInRegion(null, 0);
    }
    @Test
    void testGetTopNCountriesInRegionWrongLimit() {
        a.getTopNCountriesInRegion("Baltic Countries", -1);
    }
    @Test
    void testGetTopNCountriesInRegionWrongRegion() {
        a.getTopNCountriesInRegion(null, 4);
    }
    @Test
    void testGetTopNCountriesInRegionBasic() {
        a.getTopNCountriesInRegion("Baltic Countries", 5);
    }

    // *** processCountryQuery ***
    @Test
    void testProcessCountryQueryNull(){
        a.processCountryQuery(null);
    }
    @Test
    void testProcessCountryQuery(){
        a.processCountryQuery("query");
    }
    @Test
    void testProcessPopulationQueryNull() {
        a.processPopulationQuery(null);
    }
    @Test
    void testProcessPopulationQuery() {
        a.processPopulationQuery("query");
    }
    @Test
    void testProcessCityQueryNull() {
        a.processCityQuery(null);
    }
    @Test
    void testProcessCityQuery() {
        a.processCityQuery("query");
    }

    // *** Capital City Reports ***
    @Test
    void displayCapitalCitiesTestNull() {
        displayCapitalCities(null);
    }
    @Test
    void displayCapitalCitiesTestEmpty() {
        capCities = new ArrayList<>();
        displayCapitalCities(capCities);
    }
    @Test
    void displayCapitalCitiesContainsNull() {
        capCities = new ArrayList < > ();
        capCities.add(null);
        displayCapitalCities(capCities);
    }
    @Test
    void displayCapitalCitiesBasic() {
        capCities = new ArrayList < > ();
        CapitalCity c = new CapitalCity();

        c.setID("5");
        c.setName("Amsterdam");
        c.setCountryCode("NLD");
        c.setDistrict("Noord-Holland");
        c.setPopulation("731200");

        c.getID();
        c.getName();
        c.getCountryCode();
        c.getDistrict();
        c.getPopulation();

        capCities.add(c);
        displayCapitalCities(capCities);
    }

}