package com.hemebiotech.analytics;

/**
 * Program for analysis of symtoms.
 * It take a txt file with a list of symtoms, count each symptom, sort its alphabetical order and put result in an outfile.
 *
 */
public class Main {

    public static void main(String[] args) {
        String inputFile = "symptoms.txt";
        try {
            ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(inputFile);
            WriteSymptomDataToFile writer = new WriteSymptomDataToFile();

            AnalyticsCounter analyse = new AnalyticsCounter(reader, writer);

            analyse.analyseData();

        } catch (Exception e) {
            System.out.println("Error(s) : \n\t" + e);
        }
    }
}
