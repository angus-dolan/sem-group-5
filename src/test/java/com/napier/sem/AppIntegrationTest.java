
package com.napier.sem;

import com.mysql.cj.protocol.Resultset;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.ResultSet;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testGetTopNCountriesInContinent() {
        ArrayList<Country> top5 = app.getTopNCountriesInContinent("Asia", 2);
        assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "China");
        assertEquals(top5.get(1).getName(), "India");
    }

    @Test
    void testGetTopNCountriesInWorld() {
        ArrayList<Country> top5 = app.getTopNCountriesInWorld(2);
        assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "China");
        assertEquals(top5.get(1).getName(), "India");
    }

    @Test
    void testGetTopNCountriesInRegion() {
        ArrayList<Country> top5 = app.getTopNCountriesInRegion("Nordic Countries", 2);
        assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Sweden");
        assertEquals(top5.get(1).getName(), "Denmark");
    }

    @Test
    void testGetAllCountriesInRegion() {
        ArrayList<Country> top5 = app.getAllCountriesInRegion("Nordic Countries");
        //assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Sweden");
        assertEquals(top5.get(1).getName(), "Denmark");
    }

    @Test
    void testGetAllCountriesInContinent() {
        ArrayList<Country> top5 = app.getAllCountriesInContinent("Asia");
        //assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "China");
        assertEquals(top5.get(1).getName(), "India");
    }

    @Test
    void testGetAllCountriesInWorld() {
        ArrayList<Country> top5 = app.getAllCountriesInWorld();
        //assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "China");
        assertEquals(top5.get(1).getName(), "India");
    }

    @Test
    void testgetNCitiesInContinent() {
        ArrayList<City> top5 = app.getNCitiesInContinent(2, "Asia");
        assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(top5.get(1).getName(), "Seoul");
    }

    @Test
    void testgetNCitiesInWorld() {
        ArrayList<City> top5 = app.getNCitiesInWorld(2);
        assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(top5.get(1).getName(), "Seoul");
    }

    @Test
    void testgetNCitiesInRegion() {
        ArrayList<City> top5 = app.getNCitiesInRegion(2, "Middle East");
        assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Istanbul");
        assertEquals(top5.get(1).getName(), "Baghdad");
    }

    @Test
    void testGetAllCitiesInRegion() {
        ArrayList<City> top5 = app.getNCitiesInRegion(2, "Middle East");
        assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Istanbul");
        assertEquals(top5.get(1).getName(), "Baghdad");
    }

    @Test
    void testGetAllCitiesInContinent() {
        ArrayList<City> top5 = app.getAllCitiesInContinent("Asia");
        // assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(top5.get(1).getName(), "Seoul");
    }

    @Test
    void testGetAllCitiesInWorld() {
        ArrayList<City> top5 = app.getAllCitiesInWorld();
        // assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(top5.get(1).getName(), "Seoul");
    }

    @Test
    void testgetNCitiesInDistrict() {
        ArrayList<City> top5 = app.getNCitiesInDistrict(2, "Île-de-France");
        assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Paris");
        assertEquals(top5.get(1).getName(), "Boulogne-Billancourt");
    }

    @Test
    void testGetAllCitiesInDistrict() {
        ArrayList<City> top5 = app.getNCitiesInDistrict(2, "Île-de-France");
        assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Paris");
        assertEquals(top5.get(1).getName(), "Boulogne-Billancourt");
    }
    @Test
    void testUseCase2() {
        ArrayList<CapitalCity> top5 = app.useCase2("Africa");
        //  assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Cairo");
        assertEquals(top5.get(1).getName(), "Kinshasa");
    }
    @Test
    void testUseCase18() {
        ArrayList<CapitalCity> top5 = app.useCase18();
        //  assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Seoul");
        assertEquals(top5.get(1).getName(), "Jakarta");
    }
    @Test
    void testUseCase20() {
        ArrayList<CapitalCity> top5 = app.useCase20("Southern Europe", 5);
        //  assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Madrid");
        assertEquals(top5.get(1).getName(), "Roma");
    }
    @Test
    void testUseCase21() {
        ArrayList<CapitalCity> top5 = app.useCase21("Caribbean");
        //  assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "La Habana");
        assertEquals(top5.get(1).getName(), "Santo Domingo de Guzmán");
    }
    @Test
    void testUseCase22() {
        ArrayList<CapitalCity> top5 = app.useCase22(5);
        //  assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Seoul");
        assertEquals(top5.get(1).getName(), "Jakarta");
    }
    @Test
    void testUseCase23() {
        ArrayList<CapitalCity> top5 = app.useCase23("Asia", 5);
        //  assertEquals(top5.size(), 2);
        assertEquals(top5.get(0).getName(), "Seoul");
        assertEquals(top5.get(1).getName(), "Jakarta");
    }
    @Test // first
    void testGetPopulationInCityByCountry(){
        ArrayList<Population> top5 = app.getPopulationInCityByCountry();
        assertEquals(top5.get(0).getName(), "Afghanistan");
        assertEquals(top5.get(1).getName(), "Albania");
    }

    @Test // second
    void testGetPopulationInCityByRegion(){
        ArrayList<Population> top5 = app.getPopulationInCityByRegion();
        assertEquals(top5.get(0).getName(), "Australia and New Zealand");
        assertEquals(top5.get(1).getName(), "Baltic Countries");
    }
    @Test // third
    void testGetLanguage(){
        ResultSet rset = app.getLanguage();
        assertNotNull(rset);
    }
    @Test //not currently printed
    void testGetPopulationInCityByContinent(){
        ArrayList<Population> output =  app.getPopulationInCityByContinent();
    }

}

