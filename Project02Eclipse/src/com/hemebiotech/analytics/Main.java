package com.hemebiotech.analytics;

public class Main {

    public static void main(String[] args){
        AnalyticsCounter analyse = new AnalyticsCounter("symptoms.txt", "result.out");
        analyse.analyseData();

        AnalyticsCounter analyse_pharma1_110925 = new AnalyticsCounter("symptoms_pharma1_110925.txt", "symptoms_pharma1_110925.out");
        analyse_pharma1_110925.analyseData();
    }
}
