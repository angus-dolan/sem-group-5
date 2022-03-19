package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import com.napier.sem.PopulationClass.Population;

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
        ArrayList<Country> allCountries= new ArrayList<>(); // array to store all countries

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, country.Name, Continent, Region, country.Population, city.Name AS 'Capital'"
                            + "  FROM country LEFT JOIN city ON country.Capital = city.ID"
                            + " ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

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
                allCountries.add(c);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country data");
            return null;
        }
        return allCountries;
    }

    /**
     * Displays a list of countries
     * @param countryList
     */
    public void displayCountries(ArrayList<Country> countryList) {
        String h1 = "Code", h2 = "Name", h3 = "Continent", h4 = "Region", h5 = "Population", h6 = "Capital";
        // print a header
        System.out.println(String.format("%-4s %-44s %-14s %-25s %-10s %-34s", "Code", "Name", "Continent", "Region", "Population", "Capital"));
        // print details of all countries in the list
        for(Country c : countryList) {
            String country = String.format("%-4s %-44s %-14s %-25s %-10d %-34s",
                  c.getCode(), c.getName(), c.getContinent(), c.getRegion(), c.getPopulation(), c.getCapital());
            System.out.println(country);
        }
    }


    /**
     * Create a Country object based on its code
     * @param code  Country code
     * @return      Country object created
     */
    public Country getCountry(String code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, population "
                            + "FROM world.country "
                            + "WHERE Code = " + code;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            if (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("code"));
                ctry.setName(rset.getString("name"));
                ctry.setPopulation(Integer.parseInt(rset.getString("population")));
                return ctry;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country data");
            return null;
        }
    }

    /**
     * Display the country object's data
     * @param ctry  Country object to display
     */
    public void displayCountry(Country ctry)
    {
        if (ctry != null)
        {
            System.out.println(
                ctry.getCode() + " "
                + ctry.getName() + " "
                + ctry.getPopulation() + "\n");
        }
    }

    /**
     * Driver code for the application
     * @param args
     */




    /**
     * Create a Population object based on its code
     * @param       con name
     * @return      the population of people living in cities and living outside cities in both numbers and percents
     */
    public ArrayList<Population> getPopulationinCitybyContinent(Connection con) {
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

    //Display populations
    public static void DisplayPopulations(ArrayList<Population> populations, String typeOfQuery){
        System.out.println(String.format("%-24s %-24s %-14s %-24s %-24s %-24s",  typeOfQuery , "Population", "City Population", "City Population %", "Non City Population", "Non City Population %"));

        for(Population population : populations){
            System.out.println(String.format("%-24s %-24s %-14s %-24s %-24s %-24s",
                    population.getName(), population.getPopulation(), population.getCityPopulation(), population.getCityPopulationPercent(), population.getNotCityPopulation(), population.getNonCityPopulationPercent()));
//            System.out.print(population.getName() + " ");
//            System.out.print(population.getPopulation() + " " );
//            System.out.print(population.getCityPopulation() + " " );
//            System.out.print(population.getCityPopulationPercent()+  " " );
//            System.out.print(population.getNotCityPopulation()+ " ");
//            System.out.println(population.getNonCityPopulationPercent()+ " ");
//            System.out.print(population.getName());
//            System.out.print(population.getName());
//            String str = population.toString();
//            String[] toSplittedString = str.split(" ", 10);
//            String pops;

//            if(toSplittedString.length == 7){
//                pops = String.format("%-14s %-24s %-14s %-24s %-24s %-24s",
//                        toSplittedString[0]+toSplittedString[1], toSplittedString[2], toSplittedString[3], toSplittedString[4], toSplittedString[5], toSplittedString[6]);
//            }else if(toSplittedString.length == 8){
//                pops = String.format("%-24s %-24s %-14s %-24s %-24s %-24s",
//                        toSplittedString[0]+toSplittedString[1]+ toSplittedString[2], toSplittedString[3], toSplittedString[4], toSplittedString[5], toSplittedString[6], toSplittedString[7]);
//            }else if(toSplittedString.length == 9) {
//                pops = String.format("%-24s %-24s %-14s %-24s %-24s %-24s",
//                        toSplittedString[0]+toSplittedString[1]+ toSplittedString[2]+ toSplittedString[3], toSplittedString[4], toSplittedString[5], toSplittedString[6], toSplittedString[7], toSplittedString[8]);
//            }else if(toSplittedString.length == 10){
//                pops = String.format("%-34s %-24s %-14s %-24s %-24s %-24s",
//                        toSplittedString[0]+toSplittedString[1]+ toSplittedString[2]+ toSplittedString[3]+ toSplittedString[4], toSplittedString[5], toSplittedString[6], toSplittedString[7], toSplittedString[8], toSplittedString[9]);
//            }else{
//                //SMILE, BECAUSE THE NAME OF THE OBJECT (mostly countries) IS NOT LONGER THAN 5 WORDS
//                pops = String.format("%-14s %-24s %-14s %-24s %-24s %-24s",
//                        toSplittedString[0], toSplittedString[1], toSplittedString[2], toSplittedString[3], toSplittedString[4], toSplittedString[5]);
//            }

         //   System.out.println(population.toString());
       //     System.out.println(pops);
        }
    }

    public ArrayList<Population> getPopulationinCitybyCountry(Connection con) {
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



    public ArrayList<Population> getPopulationinCitybyRegion(Connection con) {
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

    public ResultSet getLanguage()
    {
        // Creates an SQL statement.
        try
        {
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

                while(rset.next()){
                    ResultSetMetaData rsMetaData = rset.getMetaData();
                    int numberOfColumns = rsMetaData.getColumnCount();
                    ResultSetMetaData rsmd = rset.getMetaData();
// get the column names; column indexes start from 1
                    for (int i = 1; i <= 3; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rset.getString(i);
                        System.out.print(columnValue + " " + rsmd.getColumnName(i));
                    }
                    System.out.println("");
                }





                return rset;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language details");
            return null;
        }
    }

    public void displayLanguage(ArrayList<Language> language)
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





        public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Produce a report of all countries in the world organised by largest population to smallest
        ArrayList<Country> allCountries = new ArrayList<>();
        allCountries = a.getAllCountriesInWorld();

        System.out.println("");
        System.out.println("");


        // Display results
        System.out.println("Report on all the countries in the world organised by largest population to smallest.");
        a.displayCountries(allCountries);

        // Call population by continent

        ArrayList<Population> allPopulationsContinent = new ArrayList<>();
        allPopulationsContinent = a.getPopulationinCitybyContinent(a.con);
        a.DisplayPopulations(allPopulationsContinent, "Continent");
        System.out.println("");
        System.out.println("");

        // Call population by country
        ArrayList<Population> allPopulationsCountry = new ArrayList<>();
        allPopulationsCountry = a.getPopulationinCitybyCountry(a.con);
        a.DisplayPopulations(allPopulationsCountry, "Country");
        System.out.println("");
        System.out.println("");

        // Call population by region
        ArrayList<Population> allPopulationsRegion = new ArrayList<>();
        allPopulationsRegion = a.getPopulationinCitybyRegion(a.con);
        a.DisplayPopulations(allPopulationsRegion, "Region");
        System.out.println("");
        System.out.println("");

        // Call the language query
        a.getLanguage();

        // Disconnect from database
        a.disconnect();
    }
}