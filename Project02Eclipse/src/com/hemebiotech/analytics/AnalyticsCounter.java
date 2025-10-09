package com.hemebiotech.analytics;

import java.io.IOException;
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
     * Retourne la liste des symptômes issue de la class ReadSymptomDataFromFile sous forme de {@code List<String>}
     * @return reader.getSymtoms()
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Compte et trie par ordre alphabétique les symptômes.
     * @return TreeMap des symptômes, avec le nom du symptôme en clé et son occurrence en valeur.
     * @throws Exception si analyse impossible
     * @param symptoms liste des symptômes.
     */
    public Map<String, Integer> countAndSort(List<String> symptoms) throws Exception{
        Map<String, Integer> symptomsMap = new TreeMap<>();
        try {
            for (String symptom : symptoms) {
                symptomsMap.put(symptom, symptomsMap.getOrDefault(symptom, 0) + 1);
            }

            System.out.println("Tri des données reçue après lecture : OK");
            return symptomsMap;
        } catch(Exception e) {
            throw new Exception("Une erreur est survenue lors de l'analyse des données : " + e);
        }
    }

    /**
     * Ecrit l'outputFile des symptomes et occurence.
     * @param symptomsMap qui est un TreeMap des symptômes (clé) et de leur occurrence (valeur).
     * @throws IOException Si erreur dans l'écriture du outputFile.
     */
    public void writeSymptoms(Map<String, Integer> symptomsMap) throws IOException {
        writer.writeSymptoms(symptomsMap);
    }
}
