package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read file and return a List, one value by line *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    public boolean isTxtFile(String fileName) {
        return fileName.endsWith(".txt");
    }

    /**
     *
     * @return a list of symptoms
     */
    @Override
    public List<String> getSymptoms() {
        if (filepath == null || !isTxtFile(filepath)) {
            throw new IllegalArgumentException("Impossible de lire le fichier ou l'extension est différente de .txt : " + filepath);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            ArrayList<String> result = new ArrayList<>();
            String line = reader.readLine();

            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
            System.out.println("Lecture du fichier terminée.");
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Une erreur s'est produite à la lecture du fichier : " + e);
        }
    }
}
