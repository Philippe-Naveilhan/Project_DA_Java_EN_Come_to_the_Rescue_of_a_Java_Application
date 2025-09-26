package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Take the collection and write in {outputFile} the result with this format :
 *  {symptom1} : {quantity}
 *  {symptom2} : {quantity}
 *  {symptom3} : {quantity}
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IllegalArgumentException, IOException {
        if (symptoms == null) {
            throw new IllegalArgumentException("Enable to proccess array symptoms : " + symptoms);
        }

        try{
            FileWriter writer = new FileWriter("result/symptoms.out");
            for (String symptom : symptoms.keySet()) {
                writer.write(symptom + " : " + symptoms.get(symptom) + "\n");
            }
            writer.close();
            System.out.println("Ecriture du fichier : OK");
        } catch (IOException e) {
            throw new IOException("Une erreur est survenue lors de l'écriture du fichier : " + e);
        }
    }
}
