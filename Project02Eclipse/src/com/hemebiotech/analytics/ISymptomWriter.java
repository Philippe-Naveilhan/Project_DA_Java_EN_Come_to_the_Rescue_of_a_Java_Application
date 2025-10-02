package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Tout est reçu afin d'écrire dans le fichier de sortie. Il est nécessaire d'avoir 2 valeurs :
 *     - Le nom du fichier de sortie (Au moment de l'instantiation de l'objet)
 *     - Un {@code treeMap} des symptomes et de la quantité de chaque envoyé à {@code writeSymptoms} en param.
 *     
 */

public interface ISymptomWriter {
    /**
     * Si les données ne sont pas fournies, nous levons une exception.
     * Sinon, le fichier est crée, et nous écrivons un message de réussite.
     * @param symptoms Map des symptoms et de leur quantité classés par ordre alphabétique
     * @throws IOException Erreur d'écriture.
     */

    void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
