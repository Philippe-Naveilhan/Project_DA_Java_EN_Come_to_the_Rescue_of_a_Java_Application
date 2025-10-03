package com.hemebiotech.analytics;

import java.util.List;

/**
 * Traitement de la lecture des symptomes depuis une source.
 * Le retour est une liste  : {@code List<String>} qui peut contenir plusieurs fois le même symptome.
 * Cette liste n'est pas triée.
 * 
 */
public interface ISymptomReader {
	/**
	 * Sans data, on retourne une liste vide
	 * 
	 * @return une liste de symptomes sous forme {@code List<String>}
	 */
	List<String> getSymptoms();
}
