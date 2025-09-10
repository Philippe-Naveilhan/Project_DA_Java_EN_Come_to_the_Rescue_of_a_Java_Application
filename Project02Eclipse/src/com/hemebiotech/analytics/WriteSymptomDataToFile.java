package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;

public class WriteSymptomDataToFile implements ISymptomWriter {

    @Override
    public void WriteSymptoms() { }

    public void WriteSymptoms(ListSymptomsByName listSymptomsByName, String nameFile) {

        if(listSymptomsByName != null) {
            try {
                FileWriter writer = new FileWriter(nameFile);
                for (String symptom : listSymptomsByName.listSymptomsByName.keySet()) {
                    writer.write("*" + listSymptomsByName.listSymptomsByName.get(symptom) + "\t" + symptom + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
