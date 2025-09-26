package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Take the collection (TreeMap) and write in result/symptoms.out the result with this format :
 *  {symptom1} : {quantity}
 *  {symptom2} : {quantity}
 *  {symptom3} : {quantity}
 *
 * @return void
 * @exception IllegalArgumentException if symptom is null
 * @exception IOException if impossibility to create file
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String outputFile;

    public WriteSymptomDataToFile(String outputFile) {
        this.outputFile = outputFile;
    }

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
