package com.hemebiotech.analytics;

import java.io.FileWriter;

/**
 * Take the collection and write in {outputFile} the result with this format :
 *  {symptom1} : {quantity}
 *  {symptom2} : {quantity}
 *  {symptom3} : {quantity}
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    @Override
    public void WriteSymptoms(ListSymptomsByName listSymptomsByName, String nameFile) throws Exception {

        if (listSymptomsByName != null) {
            FileWriter writer = new FileWriter(nameFile);
            for (String symptom : listSymptomsByName.listSymptomsByName.keySet()) {
                writer.write(listSymptomsByName.listSymptomsByName.get(symptom) + " :\t" + symptom + "\n");
            }
            writer.close();
        }
    }
}
