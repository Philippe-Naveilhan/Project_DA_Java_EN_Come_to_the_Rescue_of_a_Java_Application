package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Analyse and count how many time a symptom is in this list in reader object.
     * The result is sent to write object.
     *
     * @author Philippe & Axel
     */
    public void analyseData() throws Exception {

        List<String> symptoms = reader.getSymptoms();
        Map<String, Integer> symptomsMap = new TreeMap<>();
        try {
            for (String symptom : symptoms) {
                symptomsMap.put(symptom, symptomsMap.getOrDefault(symptom, 0) + 1);
            }

            System.out.println("Tri des données reçue après lecture : OK");
        } catch(Exception e) {
            throw new Exception("Une erreur est survenue lors de l'analyse des données : " + e);
        }
        writer.writeSymptoms(symptomsMap);
    }
}
