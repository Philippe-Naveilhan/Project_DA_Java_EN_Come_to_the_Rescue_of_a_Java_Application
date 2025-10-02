package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Analyse la liste des symptome, les compte et les classe par ordre alphabétique.
 */
public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
     * Prend en paramètres 2 objets
     * @param reader Objet, ISymptomReader, lit le fichier de données.
     * @param writer Objet, ISymptomWriter, écrit les données analysées dans le fichier de sortie.
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Récupère les données de reader sous forme d'un array, les traite, et les envoie sous forme d'un TreeMap à writer.
     * @throws Exception "Une erreur est survenue lors de l'analyse des données : " + e
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
        } finally {
            writer.writeSymptoms(symptomsMap);
        }
    }
}
