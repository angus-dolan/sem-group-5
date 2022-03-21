package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

import static com.napier.sem.ReportPrinting.*;

/**
 * <h1>App</h1>
 * <p>Main entry point of application</p>
 * @author group-5
 */
public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Driver code for the application
     * @param args
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Produce a report of all countries in the world organised by largest population to smallest
        ArrayList<Country> allCountries = a.getAllCountriesInWorld();
        System.out.println("Report on all the countries in the world organised by largest population to smallest.");
        displayCountries(allCountries); //Display results

        // Produce a report of all countries in a continent organised by largest population to smallest
        String continent = "Africa";
        ArrayList<Country> continentCountries = a.getAllCountriesInContinent(continent);
        System.out.println("Report on all the countries in " + continent + " organised by largest population to smallest.");
        displayCountries(continentCountries);   //Display results

        // Produce a report of all countries in a region organised by largest population to smallest
        String region = "Nordic Countries";
        ArrayList<Country> regionCountries = a.getAllCountriesInRegion(region);
        System.out.println("Report on all the countries in " + region + " organised by largest population to smallest.");
        displayCountries(regionCountries);   //Display results

        // Produce a report of top N populated countries in the world
        int n = 10;
        ArrayList<Country> topNInWorld = a.getTopNCountriesInWorld(n);
        System.out.println("Report of top " + n + " populated countries in the world");
        displayTopCountries(topNInWorld);

        // Produce a report of top N populated countries in a continent
        int n2 = 10;
        String continent2 = "Europe";
        ArrayList<Country> topNInContinent = a.getTopNCountriesInContinent(continent2, n2);
        System.out.println("Report of top " + n2 + " populated countries in " + continent2);
        displayTopCountries(topNInContinent);

        // Produce a report of top N populated countries in a region
        int n3 = 10;
        String region2 = "Baltic Countries";
        ArrayList<Country> topNInRegion = a.getTopNCountriesInRegion(region2, n3);
        System.out.println("Report of top " + n3 + " populated countries in " + region2);
        displayTopCountries(topNInRegion);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // try to connect to the database 10 times, otherwise throw an error
        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        // check if it is not already closed
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Returns all countries in the world, organised by the population from largest to smallest
     * @return  list of Country objects
     */
    public ArrayList<Country> getAllCountriesInWorld() {
        // query to get all countries in the world
        String query =
                "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital'"
                        + "  FROM country LEFT JOIN city ON country.Capital = city.ID"
                        + " ORDER BY Population DESC";
        // execute the query
        ArrayList<Country> allCountries= processCountryQuery(query);
        return allCountries;
    }

    /**
     * Returns top N populated countries in the world
     * @param limit number of countries to return
     * @return  list of Country objects
     */
    public ArrayList<Country> getTopNCountriesInWorld(int limit) {
        // query to get all countries in the world
        String query =
                "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital'"
                        + "  FROM country LEFT JOIN city ON country.Capital = city.ID"
                        + " ORDER BY Population DESC "
                        + " LIMIT " + limit;
        // execute the query
        ArrayList<Country> allCountries= processCountryQuery(query);
        if(allCountries.size() < limit) {
            System.out.println("***Not enough countries for this ranking. Returning all countries in the world***");
        }
        return allCountries;
    }

    /**
     * Returns all countries in the continent specified, organised by the population from largest to smallest
     * @param continentName Name of the continent to extract
     * @return List of countries in the continent
     */
    public ArrayList<Country> getAllCountriesInContinent(String continentName) {
        String query = "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital' " +
                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                "WHERE Continent = '" + continentName + "' " +
                "ORDER BY Population DESC";
        ArrayList<Country> countriesInContinent = processCountryQuery(query);
        if (countriesInContinent.isEmpty()) {
            System.out.println("Invalid continent specified.");
            return null;
        }
        return countriesInContinent;
    }

    /**
     * Returns top N populated countries in the continent specified
     * @param continentName continent to extract
     * @param limit number of countries to extract
     * @return  list of Country objects
     */
    public ArrayList<Country> getTopNCountriesInContinent(String continentName, int limit) {
        String query = "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital' " +
                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                "WHERE Continent = '" + continentName + "' " +
                "ORDER BY Population DESC " +
                "LIMIT " + limit;
        ArrayList<Country> countriesInContinent = processCountryQuery(query);
        if (countriesInContinent.isEmpty()) {
            System.out.println("Invalid continent specified.");
            return null;
        }
        if(countriesInContinent.size() < limit) {
            System.out.println("***Not enough countries in continent for this ranking. Returning all in continent***");
        }
        return countriesInContinent;
    }

    /**
     * Returns a list of all countries in the region specified
     * @param regionName    region to extract
     * @return  list of Country objects
     */
    public ArrayList<Country> getAllCountriesInRegion(String regionName) {
        String query = "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital' " +
                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                "WHERE Region = '" + regionName + "' " +
                "ORDER BY Population DESC";
        ArrayList<Country> countriesInRegion = processCountryQuery(query);
        if (countriesInRegion.isEmpty()) {
            System.out.println("Invalid region specified.");
            return null;
        }
        return countriesInRegion;
    }

    /**
     * Returns top N populated countries in the region specified
     * @param regionName    region to extract
     * @param limit     countries to extract
     * @return  list of Country objects
     */
    public ArrayList<Country> getTopNCountriesInRegion(String regionName, int limit) {
        String query = "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital' " +
                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                "WHERE Region = '" + regionName + "' " +
                "ORDER BY Population DESC " +
                "LIMIT " + limit;
        ArrayList<Country> countriesInRegion = processCountryQuery(query);
        if (countriesInRegion.isEmpty()) {
            System.out.println("Invalid region specified.");
            return null;
        }
        if(countriesInRegion.size() < limit) {
            System.out.println("***Not enough countries in region for this ranking. Returning all countries in region***");
        }
        return countriesInRegion;
    }

    /**
     * Processes an SQL query to get a list of countries
     * @param query Query to process
     * @return  a list of Country objects
     */
    public ArrayList<Country> processCountryQuery(String query) {
        ArrayList<Country> countries = new ArrayList<>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);

            //Extract country information
            // while there are new rows in the result set, keep creating new country objects
            while (rset.next())
            {
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
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country data");
            return null;
        }
    }
}