package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Prend une collection {@code TreeMap} et écris le résultat dans le fichier de sortie sous ce format :
 *  {symptom1} : {quantité}
 *  {symptom2} : {quantité}
 *  {symptom3} : {quantité}
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String outputFile;

    /**
     * Récupère le chemin et le nom du fichier ed sortie
     * @param outputFile Chemin et nom du fichier de sortie
     */

    public WriteSymptomDataToFile(String outputFile) {
        this.outputFile = outputFile;
    }

    /**
     * Ecrit le fichier de sortie
     * @param symptoms Map des symptoms et de leur quantité classés par ordre alphabétique
     * @throws IOException "Une erreur est survenue lors de l'écriture du fichier : " + e
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        if (symptoms == null) {

            throw new IllegalArgumentException("Enable to proccess array symptoms : " + symptoms);
        }

        try (FileWriter writer = new FileWriter(outputFile)){
            for (String symptom : symptoms.keySet()) {
                writer.write(symptom + " : " + symptoms.get(symptom) + "\n");
            }
            System.out.println("Ecriture du fichier : OK");
        } catch (IOException e) {
            throw new IOException("Une erreur est survenue lors de l'écriture du fichier : " + e);
        }
    }
}
