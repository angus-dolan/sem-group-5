package com.napier.sem;

public class Language {


        // Properties population
        /**
         * Population of Speakers
         */
        private long population;

        /**
         * Language
         */
        private String language;

        /**
         * Percentage of the world population
         */
        private float percentage;


        // Constructors
        /**
         * Blank Language Constructor
         */
        public Language() {
        }

        /**
         * Constructor for language class
         * @param population Population of Speakers
         * @param language Language Name
         * @param percentage Percentage of world population
         */
        public Language(long population, String language, float percentage) {
            this.population = population;
            this.language = language;
            this.percentage = percentage;
        }

        // Getters
        /**
         * Returns value of _population
         */
        public long getPopulation(){
            return population;
        }

        /**
         * Returns value of _language
         */
        public String getLanguage(){
            return language;
        }

        /**
         * Returns value of _percentage
         */
        public float getPercentage(){
            return percentage;
        }

        // Setters
        /**
         * Sets private population property
         * @param population population of speakers
         */
        public void setPopulation(long population){
            population = population;
        }

        /**
         * Sets private language property
         * @param language language name
         */
        public void setLanguage(String language) {
            language = language;
        }

        /**
         * Sets private population property
         * @param percentage percentage of world population
         */
        public void setPercentage(float percentage) {
            percentage = percentage;
        }

        // ToString Method
        /**
         * Returns string representation of class.
         */
        @Override
        public String toString() {
            return "Language{" +
                    "_population=" + population +
                    ", _language='" + language + '\'' +
                    ", _percentage=" + percentage +
                    '}';
        }

}
