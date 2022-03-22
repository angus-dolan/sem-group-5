package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

import static com.napier.sem.ReportPrinting.*;

/**
 * <h1>App</h1>
 * <p>Main entry point of application</p>
 * @author group-5
 */
public class App {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Driver code for the application
     * @param args
     */
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        if(args.length < 1){
            a.connect("localhost:33060", 0);
        }else{
            a.connect("db:3306", 30000);
        }

        // Use case 2
        ArrayList <CapitalCity> useCase2 = a.useCase2("Africa");
        System.out.println("Report on all the capital cities in a continent organised by largest population to smallest.");
        displayCapitalCities(useCase2);

        // Use case 18
        ArrayList <CapitalCity> useCase18 = a.useCase18();
        System.out.println("Report on all the capital cities in the world organised by largest population to smallest");
        displayCapitalCities(useCase18);

        // Use case 20
        ArrayList <CapitalCity> useCase20 = a.useCase20("Southern Europe", 5);
        System.out.println("Report on the top N populated capital cities in a region");
        displayCapitalCities(useCase20);

        // Use case 21
        ArrayList <CapitalCity> useCase21 = a.useCase21("Caribbean");
        System.out.println("Report on the capital cities in a region organised by largest to smallest");
        displayCapitalCities(useCase21);

        // Use case 22
        ArrayList <CapitalCity> useCase22 = a.useCase22(5);
        System.out.println("Report on the top N populated capital cities in the world");
        displayCapitalCities(useCase22);

        // Use case 23
        ArrayList <CapitalCity> useCase23 = a.useCase23("Asia", 5);
        System.out.println("Report on top N populated capital cities in a continent");
        displayCapitalCities(useCase23);

        // Produce a report of all countries in the world organised by largest population to smallest
        ArrayList < Country > allCountries = a.getAllCountriesInWorld();
        System.out.println("Report on all the countries in the world organised by largest population to smallest.");
        displayCountries(allCountries); //Display results

        // Produce a report of all countries in a continent organised by largest population to smallest
        String continent = "Africa";
        ArrayList < Country > continentCountries = a.getAllCountriesInContinent(continent);
        System.out.println("Report on all the countries in " + continent + " organised by largest population to smallest.");
        displayCountries(continentCountries); //Display results

        // Produce a report of all countries in a region organised by largest population to smallest
        String region = "Nordic Countries";
        ArrayList < Country > regionCountries = a.getAllCountriesInRegion(region);
        System.out.println("Report on all the countries in " + region + " organised by largest population to smallest.");
        displayCountries(regionCountries); //Display results

        // Produce a report of top N populated countries in the world
        int n = 10;
        ArrayList < Country > topNInWorld = a.getTopNCountriesInWorld(n);
        System.out.println("Report of top " + n + " populated countries in the world");
        displayTopCountries(topNInWorld);

        // Produce a report of top N populated countries in a continent
        int n2 = 10;
        String continent2 = "Europe";
        ArrayList < Country > topNInContinent = a.getTopNCountriesInContinent(continent2, n2);
        System.out.println("Report of top " + n2 + " populated countries in " + continent2);
        displayTopCountries(topNInContinent);

        // Produce a report of top N populated countries in a region
        int n3 = 10;
        String region2 = "Baltic Countries";
        ArrayList < Country > topNInRegion = a.getTopNCountriesInRegion(region2, n3);
        System.out.println("Report of top " + n3 + " populated countries in " + region2);
        displayTopCountries(topNInRegion);

        ArrayList < City > retrieved = new ArrayList < City > ();
        int limit = 10;
        String continentName = "Africa";
        String regionName = "Middle East";
        String countryName = "France";
        String districtName = "Île-de-France";

        // Produce a report of all the cities in the world organised by largest population to smallest.
        retrieved = a.getAllCitiesInWorld();
        System.out.println("\nA report of all the cities in the world organised by largest population to smallest.");
        displayCities(retrieved);

        // Produce a report of all the cities in a continent organised by largest population to smallest.
        retrieved = a.getAllCitiesInContinent(continentName);
        System.out.println("\nA report of all the cities on the continent " + continentName + " organised by largest population to smallest.");
        displayCities(retrieved);
        // Produce a report of all the cities in a region organised by largest population to smallest.
        retrieved = a.getAllCitiesInRegion(regionName);
        System.out.println("\nA report of all the cities in the region " + regionName + " organised by largest population to smallest.");
        displayCities(retrieved);
        // Produce a report of all the cities in a country organised by largest population to smallest.
        retrieved = a.getAllCitiesInCountry(countryName);
        System.out.println("\nA report of all the cities in a country " + countryName + " organised by largest population to smallest.");
        displayCities(retrieved);
        // Produce a report of all the cities in a district organised by largest population to smallest.
        retrieved = a.getAllCitiesInDistrict(districtName);
        System.out.println("\nA report of all the cities in the district  " + districtName + " organised by largest population to smallest. ");
        displayCities(retrieved);
        // Produce a report of the top N populated cities in the world where N is provided by the user.
        retrieved = a.getNCitiesInWorld(limit);
        System.out.println("\nA report of the top N populated cities in the world where N is provided by the user (" + limit + ")");
        displayTopCities(retrieved);
        // Produce a report of the top N populated cities in the continent where N is provided by the user.
        retrieved = a.getNCitiesInContinent(limit, continentName);
        System.out.println("\nA report of the top N populated cities on the continent " + continentName + " where N is provided by the user(" + limit + ")");
        displayTopCities(retrieved);
        // Produce a report of the top N populated cities in the region where N is provided by the user.

        retrieved = a.getNCitiesInRegion(limit, regionName);
        System.out.println("\nA report of the top N populated cities in the region " + regionName + " where N is provided by the user(" + limit + ")");
        displayTopCities(retrieved);
        // Produce a report of the top N populated cities in the country where N is provided by the user.

        retrieved = a.getNCitiesInCountry(limit, countryName);
        System.out.println("\nA report of the top N populated cities in the country " + countryName + " where N is provided by the user(" + limit + ")");
        displayTopCities(retrieved);
        // Produce a report of the top N populated cities in the district where N is provided by the user.

        retrieved = a.getNCitiesInDistrict(limit, districtName);
        System.out.println("\nA report of the top N populated cities in the district " + districtName + "where N is provided by the user (" + limit + ")");
        displayTopCities(retrieved);

        // Call population by country
        ArrayList<Population> allPopulationsCountry = new ArrayList<>();
        allPopulationsCountry = a.getPopulationInCityByCountry();
        System.out.println("\nA report of the population of the people living in cities and outside cities in each country");
        displayPopulations(allPopulationsCountry, "Country");
        System.out.println("");
        System.out.println("");
        
        // Call population by continent
        ArrayList<Population> allPopulationsContinent = new ArrayList<>();
        allPopulationsContinent = a.getPopulationInCityByContinent();
        System.out.println("\nA report of the population of the people living in cities and outside cities in each continent");
        displayPopulations(allPopulationsContinent, "Continent");
        System.out.println("");
        System.out.println("");
        
     

        // Call population by region
        ArrayList<Population> allPopulationsRegion = new ArrayList<>();
        allPopulationsRegion = a.getPopulationInCityByRegion();
        System.out.println("\nA report of the population of the people living in cities and outside cities in each region");
        displayPopulations(allPopulationsRegion, "Region");
        System.out.println("");
        System.out.println("");

        // Call the language query
        a.getLanguage();

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " +                                  Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        // check if it is not already closed
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Returns all the capital cities in a continent organised by largest population to smallest
     * @return  list of CapitalCity objects
     */
    public ArrayList <CapitalCity> useCase2(String continent) {
        // Prepare SQL query as string
        String query = "SELECT * FROM city JOIN country ON country.Capital = city.id WHERE country.Continent = '" + continent + "' ORDER BY city.Population DESC;";
        // Execute query
        ArrayList <CapitalCity> res = processCapitalCityQuery(query);

        if(res != null) {
            if (res.isEmpty()) {
                System.out.println("Invalid continent specified.");
                return null;
            }
        }

        return res;
    }
    /**
     * Returns all the capital cities in the world organised by largest population to smallest
     * @return  list of CapitalCity objects
     */
    public ArrayList <CapitalCity> useCase18() {
        // Prepare SQL query as string
        String query = "SELECT * FROM city JOIN country ON country.Capital = city.id ORDER BY city.Population DESC;";
        // Execute query
        ArrayList <CapitalCity> res = processCapitalCityQuery(query);

        return res;
    }
    /**
     * Returns the top N populated capital cities in a region where N is provided by the user
     * @return  list of CapitalCity objects
     */
    public ArrayList <CapitalCity> useCase20(String region, int limit) {
        // Prepare SQL query as string
        String query = "SELECT * FROM city JOIN country ON country.Capital = city.id WHERE country.Region = '" + region + "' ORDER BY city.Population DESC LIMIT " + limit;
        // Execute query
        ArrayList <CapitalCity> res = processCapitalCityQuery(query);

        if(res != null) {
            if (res.isEmpty()) {
                System.out.println("Invalid region specified.");
                return null;
            }
            if (res.size() < limit) {
                System.out.println("***Not enough capital cities in region for this ranking. Returning all capital's in region***");
            }
        }

        return res;
    }
    /**
     * Returns all the capital cities in a region organised by largest to smallest
     * @return  list of CapitalCity objects
     */
    public ArrayList <CapitalCity> useCase21(String region) {
        // Prepare SQL query as string
        String query = "SELECT * FROM city JOIN country ON country.Capital = city.id WHERE country.Region = '" + region + "' ORDER BY city.Population DESC;";
        // Execute query
        ArrayList <CapitalCity> res = processCapitalCityQuery(query);

        if(res != null) {
            if (res.isEmpty()) {
                System.out.println("Invalid region specified.");
                return null;
            }
        }

        return res;
    }
    /**
     * Returns the top N populated capital cities
     * @return  list of CapitalCity objects
     */
    public ArrayList <CapitalCity> useCase22(int limit) {
        // Prepare SQL query as string
        String query = "SELECT * FROM city JOIN country ON country.Capital = city.id ORDER BY city.Population DESC LIMIT " + limit;
        // Execute query
        ArrayList <CapitalCity> res = processCapitalCityQuery(query);

        if(res != null) {
            if (res.size() < limit) {
                System.out.println("***Not enough capital cities for limit provided.***");
            }
        }

        return res;
    }
    /**
     * Returns the top N populated capital cities in a continent
     * @return  list of CapitalCity objects
     */
    public ArrayList <CapitalCity> useCase23(String continent, int limit) {
        // Prepare SQL query as string
        String query = "SELECT * FROM city JOIN country ON country.Capital = city.id WHERE country.Continent = '" + continent + "' ORDER BY city.Population DESC LIMIT " + limit;
        // Execute query
        ArrayList <CapitalCity> res = processCapitalCityQuery(query);

        if(res != null) {
            if (res.isEmpty()) {
                System.out.println("Invalid continent specified.");
                return null;
            }
            if (res.size() < limit) {
                System.out.println("***Not enough capital cities in continent for this ranking. Returning all capital's in continent***");
            }
        }

        return res;
    }
    /**
     * Processes an SQL query to get a list of capital cities
     * @param query Query to process
     * @return  arraylist of capital cities
     */
    public ArrayList <CapitalCity> processCapitalCityQuery(String query) {
        ArrayList <CapitalCity> cities = new ArrayList <CapitalCity> ();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);

            //Extract country information
            // while there are new rows in the result set, keep creating new country objects
            while (rset.next()) {
                CapitalCity c = new CapitalCity();

                c.setID(rset.getString("ID"));
                c.setName(rset.getString("Name"));
                c.setCountryCode(rset.getString("CountryCode"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getString("Population"));

                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city data");
            return null;
        }
    }

    /**
     * Returns all countries in the world, organised by the population from largest to smallest
     * @return  list of Country objects
     */
    public ArrayList < Country > getAllCountriesInWorld() {
        // query to get all countries in the world
        String query =
                "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital'" +
                        "  FROM country LEFT JOIN city ON country.Capital = city.ID" +
                        " ORDER BY Population DESC";
        // execute the query
        ArrayList < Country > allCountries = processCountryQuery(query);
        return allCountries;
    }

    /**
     * Returns top N populated countries in the world
     * @param limit number of countries to return
     * @return  list of Country objects
     */
    public ArrayList < Country > getTopNCountriesInWorld(int limit) {
        if(limit <= 0) {
            System.out.println("Invalid number specified");
            return null;
        }
        // query to get all countries in the world
        String query =
                "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital'" +
                        "  FROM country LEFT JOIN city ON country.Capital = city.ID" +
                        " ORDER BY Population DESC " +
                        " LIMIT " + limit;
        // execute the query
        ArrayList < Country > allCountries = processCountryQuery(query);
        if (allCountries != null) {
            if (allCountries.size() < limit) {
                System.out.println("***Not enough countries for this ranking. Returning all countries in the world***");
            }
        }
        return allCountries;
    }

    /**
     * Returns all countries in the continent specified, organised by the population from largest to smallest
     * @param continentName Name of the continent to extract
     * @return List of countries in the continent
     */
    public ArrayList < Country > getAllCountriesInContinent(String continentName) {
        String query = "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital' " +
                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                "WHERE Continent = '" + continentName + "' " +
                "ORDER BY Population DESC";
        ArrayList < Country > countriesInContinent = processCountryQuery(query);
        if(countriesInContinent != null) {
            if (countriesInContinent.isEmpty()) {
                System.out.println("Invalid continent specified.");
                return null;
            }
        }
        return countriesInContinent;
    }

    /**
     * Returns top N populated countries in the continent specified
     * @param continentName continent to extract
     * @param limit number of countries to extract
     * @return  list of Country objects
     */
    public ArrayList < Country > getTopNCountriesInContinent(String continentName, int limit) {
        String query = "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital' " +
                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                "WHERE Continent = '" + continentName + "' " +
                "ORDER BY Population DESC " +
                "LIMIT " + limit;
        ArrayList < Country > countriesInContinent = processCountryQuery(query);

        if(countriesInContinent != null) {
            if (countriesInContinent.isEmpty()) {
                System.out.println("Invalid continent specified.");
                return null;
            }
            if (countriesInContinent.size() < limit) {
                System.out.println("***Not enough countries in continent for this ranking. Returning all in continent***");
            }
        }
        return countriesInContinent;
    }

    /**
     * Returns a list of all countries in the region specified
     * @param regionName    region to extract
     * @return  list of Country objects
     */
    public ArrayList < Country > getAllCountriesInRegion(String regionName) {
        String query = "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital' " +
                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                "WHERE Region = '" + regionName + "' " +
                "ORDER BY Population DESC";
        ArrayList < Country > countriesInRegion = processCountryQuery(query);
        if(countriesInRegion != null) {
            if (countriesInRegion.isEmpty()) {
                System.out.println("Invalid region specified.");
                return null;
            }
        }
        return countriesInRegion;
    }

    /**
     * Returns top N populated countries in the region specified
     * @param regionName    region to extract
     * @param limit     countries to extract
     * @return  list of Country objects
     */
    public ArrayList < Country > getTopNCountriesInRegion(String regionName, int limit) {
        String query = "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital' " +
                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                "WHERE Region = '" + regionName + "' " +
                "ORDER BY Population DESC " +
                "LIMIT " + limit;
        ArrayList < Country > countriesInRegion = processCountryQuery(query);
        if(countriesInRegion != null) {
            if (countriesInRegion.isEmpty()) {
                System.out.println("Invalid region specified.");
                return null;
            }
            if (countriesInRegion.size() < limit) {
                System.out.println("***Not enough countries in region for this ranking. Returning all countries in region***");
            }
        }
        return countriesInRegion;
    }

    /**
     * Processes an SQL query to get a list of countries
     * @param query Query to process
     * @return  a list of Country objects
     */
    public ArrayList < Country > processCountryQuery(String query) {
        ArrayList < Country > countries = new ArrayList < > ();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);

            //Extract country information
            // while there are new rows in the result set, keep creating new country objects
            while (rset.next()) {
                Country c = new Country();

                c.setCode(rset.getString("code"));
                c.setName(rset.getString("name"));
                c.setPopulation(Integer.parseInt(rset.getString("population")));
                c.setContinent(rset.getString("continent"));
                c.setRegion(rset.getString("region"));
                c.setCapital(rset.getString("capital"));
                countries.add(c);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country data");
            return null;
        }
    }

    /**
     * returns a list of cities in the world
     * @return a list of cities objects
     */
    public ArrayList < City > getAllCitiesInWorld() {
        //  SELECT Name, CountryCode, District, Population FROM world.city ORDER BY  Population DESC ;
        String query = "SELECT city.Name as 'City',  country.Name as 'Country', District, city.Population as 'Population'" +
                "FROM world.city join world.country on city.CountryCode = country.code " +
                "ORDER BY city.Population DESC ;";
        ArrayList < City > cities = processCityQuery(query);
        return cities;
    }

    /**
     * returns a list of cities on a continent
     * @return a list of cities objects
     */
    public ArrayList < City > getAllCitiesInContinent(String continentName) {
        String query = "SELECT city.Name as 'City',  country.Name as 'Country', District, city.Population as 'Population' " +
                "FROM world.city join world.country on city.CountryCode = country.code " +
                "WHERE country.continent = '" + continentName + "' " +
                "ORDER BY Population DESC;";
        ArrayList < City > cities = processCityQuery(query);
        return cities;
    }
    /**
     * returns a list of cities in a region
     * @return a list of cities objects
     */
    public ArrayList < City > getAllCitiesInRegion(String regionName) {
        String query = "SELECT city.Name as 'City',  country.Name as 'Country', District, city.Population as 'Population' " +
                "FROM world.city join world.country on city.CountryCode = country.code " +
                "WHERE country.Region = '" + regionName +
                "' ORDER BY Population DESC;";
        ArrayList < City > cities = processCityQuery(query);
        return cities;
    }
    /**
     * returns a list of cities in a country
     * @return a list of cities objects
     */
    public ArrayList < City > getAllCitiesInCountry(String countryName) {
        String query = "SELECT city.Name as 'City',  country.Name as 'Country', District, city.Population as 'Population' " +
                "FROM world.city join world.country on city.CountryCode = country.code " +
                "WHERE country.Name = '" + countryName + "' " +
                "ORDER BY Population DESC;";
        ArrayList < City > cities = processCityQuery(query);
        return cities;
    }
    /**
     * returns a list of cities in a district
     * @return a list of cities objects
     */
    public ArrayList < City > getAllCitiesInDistrict(String districtName) {
        String query = "SELECT city.Name as 'city',  country.Name as 'country', District, city.Population " +
                "FROM world.city join world.country on city.CountryCode = country.code " +
                "WHERE city.District = '" + districtName +
                "'ORDER BY city.Population DESC;";
        ArrayList < City > cities = processCityQuery(query);
        return cities;
    }
    /**
     * returns a list of N cities on a continent
     * @param   c number of cities to return
     * @return a list of cities objects
     */
    public ArrayList < City > getNCitiesInWorld(int c) {
        String query = "SELECT city.Name AS 'city', country.Name AS 'country', District, city.Population " +
                "FROM world.city join world.country on city.CountryCode = country.Code " +
                "ORDER BY city.Population DESC LIMIT " + c + ";";
        ArrayList<City> cityList = new ArrayList<City>();
        cityList = processCityQuery(query);
        if (cityList == null) {
            System.out.println("*** Amount specified was set to 0, or else nothing found ***");
            return cityList;
        }
        else if (cityList.isEmpty()) {
                System.out.println("*** Amount specified was set to 0, or else nothing found ***");
                return cityList;
            } else if (cityList.size() < c) {
                System.out.println("*** Not enough cities in the world for this ranking. Returning as many as there are in world ***");
            }

        return cityList;
    }

    /**
     * returns a list of N cities on a continent
     * @param continent to search on
     * @param c2 number of cities to return
     * @return a list of cities objects
     */
    public ArrayList < City > getNCitiesInContinent(int c2, String continent) {
        String query = "SELECT city.Name as 'city',  country.Name as 'country', District, city.Population " +
                "FROM world.city join world.country on city.CountryCode = country.code " +
                "WHERE country.continent = '" + continent + "' " +
                "ORDER BY city.Population DESC LIMIT " + c2 + ";";
        ArrayList<City> cityList = new ArrayList<City>();
        cityList = processCityQuery(query);
        if (cityList == null) {
            System.out.println("*** Amount specified was set to 0, or else nothing found ***");
            return cityList;
        }
        else if (cityList.isEmpty()) {
            System.out.println("*** Amount specified was set to 0, or else nothing found ***");
            return cityList;
        } else if (cityList.size() < c2) {
            System.out.println("*** Not enough cities in the world for this ranking. Returning as many as there are in world ***");
        }

        return cityList;
    }
    /**
     * returns a list of N cities on a continent
     * @param  region to search on
     * @param c3 number of cities to return
     * @return a list of cities objects
     */
    public ArrayList < City > getNCitiesInRegion(int c3, String region) {
        String query = "SELECT city.Name as 'city',  country.Name as 'country', District, city.Population " +
                "FROM world.city join world.country on city.CountryCode = country.code  " +
                "WHERE country.Region = '" + region + "' " +
                "ORDER BY city.Population DESC LIMIT " + c3 + ";";
        ArrayList<City> cityList = new ArrayList<City>();
        cityList = processCityQuery(query);
        if (cityList == null) {
            System.out.println("*** Amount specified was set to 0, or else nothing found ***");
            return cityList;
        }
        else if (cityList.isEmpty()) {
            System.out.println("*** Amount specified was set to 0, or else nothing found ***");
            return cityList;
        } else if (cityList.size() < c3) {
            System.out.println("*** Not enough cities in the world for this ranking. Returning as many as there are in world ***");
        }

        return cityList;
    }
    /**
     * returns a list of N cities on a continent
     * @param  country to search through
     * @param c4 number of cities to return
     * @return a list of cities objects
     */
    public ArrayList < City > getNCitiesInCountry(int c4, String country) {
        String query = "SELECT city.Name as 'city',  country.Name as 'country', District, city.Population " +
                "FROM world.city join world.country on city.CountryCode = country.code " +
                "WHERE country.Name = '" + country + "' " +
                " ORDER BY city.Population DESC LIMIT " + c4 + ";";
        ArrayList<City> cityList = new ArrayList<City>();
        cityList = processCityQuery(query);
        if (cityList == null) {
            System.out.println("*** Amount specified was set to 0, or else nothing found ***");
            return cityList;
        }
        else if (cityList.isEmpty()) {
            System.out.println("*** Amount specified was set to 0, or else nothing found ***");
            return cityList;
        } else if (cityList.size() < c4) {
            System.out.println("*** Not enough cities in the world for this ranking. Returning as many as there are in world ***");
        }

        return cityList;
    }
    /**
     * returns a list of N cities on a continent
     * @param  district to search through
     * @param  c5 number of cities to return
     * @return a list of cities objects
     */
    public ArrayList < City > getNCitiesInDistrict(int c5, String district) {
        String query = "SELECT city.Name as 'city',  country.Name as 'country', District, city.Population " +
                "FROM world.city join world.country on city.CountryCode = country.Code " +
                "WHERE city.District = '" + district +
                "' ORDER BY Population DESC LIMIT " + c5 + ";";
        ArrayList<City> cityList = new ArrayList<City>();
        cityList = processCityQuery(query);
        if (cityList == null) {
            System.out.println("*** Amount specified was set to 0, or else nothing found ***");
            return cityList;
        }
        else if (cityList.isEmpty()) {
            System.out.println("*** Amount specified was set to 0, or else nothing found ***");
            return cityList;
        } else if (cityList.size() < c5) {
            System.out.println("*** Not enough cities in the world for this ranking. Returning as many as there are in world ***");
        }

        return cityList;
    }

    /**
     * Processes an SQL query to get a list of cities
     * @param query Query to process
     * @return  a list of City objects
     */

    public ArrayList < City > processCityQuery(String query) {
        ArrayList < City > cities = new ArrayList < City > ();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);

            //Extract country information
            // while there are new rows in the result set, keep creating new city objects
            while (rset.next()) {

                City c = new City();

                c.setCountry(rset.getString("Country"));
                c.setName(rset.getString("City"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(Integer.parseInt(rset.getString("Population")));

                //add object to list
                cities.add(c);
            }
            // when no more rows, return list
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city data");
            return null;
        }
    }

    /**
     *
     * @param populations takes the information about population living in cities and outside cities in order to print it out
     * @param typeOfQuery takes the type of the exact query so it'll display it with the actual message
     */
    public static void DisplayPopulations(ArrayList<Population> populations, String typeOfQuery){
        System.out.println(String.format("%-24s %-24s %-14s %-24s %-24s %-24s",  typeOfQuery , "Population", "City Population", "City Population %", "Non City Population", "Non City Population %"));

        for(Population population : populations){
            System.out.println(String.format("%-24s %-24s %-14s %-24s %-24s %-24s",
                    population.getName(), population.getPopulation(), population.getCityPopulation(), population.getCityPopulationPercent(), population.getNotCityPopulation(), population.getNonCityPopulationPercent()));
        }
    }

    /**
     * Processes an SQL query to get a list of populations
     * @param query Query to process
     * @return  a list of City objects
     */
    public ArrayList<Population> processPopulationQuery(String query) {
        ArrayList<Population> populations = new ArrayList<>();
        try{
            // Creates an SQL statement.
            Statement stmt = con.createStatement();
            // Sends the SQL statement to the database.
            ResultSet rset = stmt.executeQuery(query);

            // Indicates which columns on the database align to which attributes within "country".
            while (rset.next()) {
                Population popReport = new Population();
                popReport.setName(rset.getString("country.continent"));
                popReport.setPopulation(rset.getLong("SUM(DISTINCT country.population)"));
                double percentCity = Math.round((rset.getLong("SUM(city.population)") * 1D) / rset.getLong("SUM(DISTINCT country.population)") * 100);
                popReport.setCityPopulationPercent(percentCity);
                popReport.setCityPopulation(rset.getLong("SUM(city.population)"));
                long outCity = (rset.getLong("SUM(DISTINCT country.population)") - rset.getLong("SUM(city.population)"));
                popReport.setNotCityPopulation(outCity);
                double percentNonCity = Math.round((outCity * 1D) / rset.getLong("SUM(DISTINCT country.population)") * 100);
                popReport.setNonCityPopulationPercent(percentNonCity);
                populations.add(popReport);
            }
            return populations;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
            return null;
        }
    }

    /**
     * Returns a list of Populations of people living in cities in each continent
     * @return   arrayList of Population objects
     */
    public ArrayList<Population> getPopulationInCityByContinent() {
        try {
            ArrayList<Population> output = new ArrayList<>();

            // Creates an SQL statement.
            Statement stmt = con.createStatement();

            // Creates an SQL statement, stored as a STRING.
            String strSelect =
                    "SELECT country.continent, SUM(DISTINCT country.population), SUM(city.population) "
                            + "FROM city JOIN country ON CountryCode=code "
                            + "GROUP BY country.continent ";

            // Sends the SQL statement to the database.
            ResultSet rset = stmt.executeQuery(strSelect);

            // Indicates which columns on the database align to which attributes within "country".
            while (rset.next()) {
                Population popReport = new Population();
                popReport.setName(rset.getString("country.continent"));
                popReport.setPopulation(rset.getLong("SUM(DISTINCT country.population)"));
                double percentCity = Math.round((rset.getLong("SUM(city.population)") * 1D) / rset.getLong("SUM(DISTINCT country.population)") * 100);
                popReport.setCityPopulationPercent(percentCity);
                popReport.setCityPopulation(rset.getLong("SUM(city.population)"));
                long outCity = (rset.getLong("SUM(DISTINCT country.population)") - rset.getLong("SUM(city.population)"));
                popReport.setNotCityPopulation(outCity);
                double percentNonCity = Math.round((outCity * 1D) / rset.getLong("SUM(DISTINCT country.population)") * 100);
                popReport.setNonCityPopulationPercent(percentNonCity);


                // Adds this country (plus details) to the ArrayList.
                //System.out.println(popReport);
                output.add(popReport);

            }//end while

            return output;

        }//end try
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get information from database (City); check connection?");
            return null;
        }//end catch
    }//end getPopulationinCitybyContinent


    /**
     * Returns a list of Populations of people living in cities in each country
     * @return   arrayList of Population objects
     */
    public ArrayList<Population> getPopulationInCityByCountry() {
        try {
            ArrayList<Population> output = new ArrayList<>();

            // Creates an SQL statement.
            Statement stmt = con.createStatement();

            // Creates an SQL statement, stored as a STRING.
            String strSelect =
                    "SELECT country.Name, SUM(DISTINCT country.population), SUM(city.population) "
                            + "FROM city JOIN country ON CountryCode=code "
                            + "GROUP BY country.Name ";

            // Sends the SQL statement to the database.
            ResultSet rset = stmt.executeQuery(strSelect);

            // Indicates which columns on the database align to which attributes within "country".
            while (rset.next()) {
                Population popReport = new Population();
                popReport.setName(rset.getString("country.Name"));
                popReport.setPopulation(rset.getLong("SUM(DISTINCT country.population)"));
                double percentCity = Math.round((rset.getLong("SUM(city.population)") * 1D) / rset.getLong("SUM(DISTINCT country.population)") * 100);
                popReport.setCityPopulationPercent(percentCity);
                popReport.setCityPopulation(rset.getLong("SUM(city.population)"));
                long outCity = (rset.getLong("SUM(DISTINCT country.population)") - rset.getLong("SUM(city.population)"));
                popReport.setNotCityPopulation(outCity);
                double percentNonCity = Math.round((outCity * 1D) / rset.getLong("SUM(DISTINCT country.population)") * 100);
                popReport.setNonCityPopulationPercent(percentNonCity);


                output.add(popReport);
            }//end while

            return output;

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get information from database (City); check connection?");
            return null;
        }// end the exception handler
    }//end getPopulationinCitybyCountry


    /**
     * Returns a list of Populations of people living in cities in each region
     * @return   arrayList of Population objects
     */
    public ArrayList<Population> getPopulationInCityByRegion() {
        try {
            ArrayList<Population> output = new ArrayList<>();

            // Creates an SQL statement.
            Statement stmt = con.createStatement();

            // Creates an SQL statement, stored as a STRING.
            String strSelect =
                    "SELECT country.region, SUM(DISTINCT country.population), SUM(city.population) "
                            + "FROM city JOIN country ON CountryCode=code "
                            + "GROUP BY country.region ";

            // Sends the SQL statement to the database.
            ResultSet rset = stmt.executeQuery(strSelect);

            // Indicates which columns on the database align to which attributes within "country".
            while (rset.next()) {
                Population popReport = new Population();
                popReport.setName(rset.getString("country.region"));
                popReport.setPopulation(rset.getLong("SUM(DISTINCT country.population)"));
                double percentCity = Math.round((rset.getLong("SUM(city.population)") * 1D) / rset.getLong("SUM(DISTINCT country.population)") * 100);
                popReport.setCityPopulationPercent(percentCity);
                popReport.setCityPopulation(rset.getLong("SUM(city.population)"));
                long outCity = (rset.getLong("SUM(DISTINCT country.population)") - rset.getLong("SUM(city.population)"));
                popReport.setNotCityPopulation(outCity);
                double percentNonCity = Math.round((outCity * 1D) / rset.getLong("SUM(DISTINCT country.population)") * 100);
                popReport.setNonCityPopulationPercent(percentNonCity);


                output.add(popReport);
            }//end while

            return output;

        }//end try
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get information from database (City); check connection?");
            return null;
        }//end catch
    }//end getPopulationinCitybyContinent

    /**
     * Returns a report of people speaking Chinese, English, Hindi, Spanish and Arabic
     * @return  ResultSet from the query
     */
        public ResultSet getLanguage() {
        try {
            ArrayList<Language> output = new ArrayList<>();
            {
                // Create string for SQL statement
                String strSelect =
                        "SELECT la.Language, ROUND(SUM((co.Population * la.Percentage) / 100)) AS 'Population', (((ROUND(SUM((co.Population * la.Percentage) / 100))) * 100) / (SELECT SUM(country.Population) FROM country)) AS 'WorldPercentage' "
                                + "FROM countrylanguage la, country co "
                                + "WHERE (la.Language = 'Chinese' "
                                + "OR la.Language = 'English' "
                                + "OR la.Language = 'Hindi' "
                                + "OR la.Language = 'Spanish' "
                                + "OR la.Language = 'Arabic') "
                                + "AND la.CountryCode = co.Code "
                                + "GROUP BY la.Language "
                                + "ORDER BY Population DESC ";
                // Creates an SQL statement.
                Statement stmt = con.createStatement();
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                System.out.println("\nA report that returns the information about the wanted languages speakers and the percentage of the world population");
                System.out.println(String.format("%-14s %-24s %-24s", "Language", "Population of speakers", "% of world population"));

                while (rset.next()) {
                    ResultSetMetaData rsMetaData = rset.getMetaData();
                    int numberOfColumns = rsMetaData.getColumnCount();
                    ResultSetMetaData rsmd = rset.getMetaData();
                    // get the column names; column indexes start from 1
                    for (int i = 1; i <= 3; i++) {
                        if (i > 1) {
                        }
                        String columnValue = rset.getString(i);
                        System.out.print(columnValue + "             ");
                    }
                    System.out.println("");
                }
                return rset;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language details");
            return null;
        }
    }
}
