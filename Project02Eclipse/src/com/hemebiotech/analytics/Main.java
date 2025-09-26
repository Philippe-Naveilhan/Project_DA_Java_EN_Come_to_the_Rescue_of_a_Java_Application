package com.hemebiotech.analytics;

public class Main {

    public static void main(String[] args) {
        String inputFile = "symptoms.txt";
        try {
            ReadSymptomDataFromFile fileToRead = new ReadSymptomDataFromFile(inputFile);
            WriteSymptomDataToFile writeResults = new WriteSymptomDataToFile();
            AnalyticsCounter analyse = new AnalyticsCounter(fileToRead, writeResults);

            analyse.analyseData();

        } catch (Exception e) {
            System.out.println("Error(s) : \n\t" + e);
        }
    }
}
