package com.hemebiotech.analytics;

/**
 * Programme pour l'analyse de liste de symptômes.
 * Prend en entrée un fichier texte (.txt), compte chaque symptôme, les trie par ordre alphabétique et écrit les résultat dans un fichier de sortie.
 *
 * @author Alex et Philippe
 *
 */
public class Main {

    /**
     * Main qui édite les exceptions lancées par les différentes classes appelées
     * @param args Pas d'arguments
     *
     */
    public static void main(String[] args) {

        try {
            ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
            WriteSymptomDataToFile writer = new WriteSymptomDataToFile("result/symptoms.out");

            AnalyticsCounter analyse = new AnalyticsCounter(reader, writer);

            analyse.analyseData();

        } catch (Exception e) {
            System.out.println("Error(s) : \n\t" + e);
        }
    }
}
