package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lit un fichier d'entrée et retourne une {@code List<String>}, une valeur par ligne
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filepath;

    /**
     * Prend le nom du fichier source
     * @param filepath chemin/fichier contenant les symptômes lligne par ligne
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Vérifie l'extension du fichier
     * @param fileName Nom du fichier entrant
     * @return True si l'extension du fichier est ".txt"
     */
    public boolean isTxtFile(String fileName) {
        return fileName.endsWith(".txt");
    }

    /**
     * Lit le fichier texte et met chaque ligne dans une List
     * @return une liste des symptômes dans une List
     * @exception IllegalArgumentException si le fichier est {@code null} ou avec une extension autre que .txt
     * @exception RuntimeException s'il est impossible de lire le fichier.
     */
    @Override
    public List<String> getSymptoms() throws IllegalArgumentException{
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
            System.out.println("Lecture du fichier : OK");
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Une erreur s'est produite à la lecture du fichier : " + e);
        }
    }
}
