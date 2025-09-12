package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	String inputFile = "";
	String outputFile = "";

	public AnalyticsCounter(String inputFile, String outpuFile){
		this.inputFile = inputFile;
		this.outputFile = outpuFile;
	}
	/**
	 * Analyse and count how many time a symptom is in this list in {inputFile}.
	 * The result is written in the {outpuFile}.
	 * @author Philippe & Axel
	 */
	public void analyseData() {

		try {
			ReadSymptomDataFromFile file = new ReadSymptomDataFromFile(inputFile);
			List<String> symptomList = file.GetSymptoms();
			try {
				ListSymptomsByName listeOrdonnee = new ListSymptomsByName();
				listeOrdonnee.addSymptomsList(symptomList);
				try {
					WriteSymptomDataToFile output = new WriteSymptomDataToFile();
					output.WriteSymptoms(listeOrdonnee, outputFile);
				} catch (Exception e) {
					System.out.println("//------> Erreur dans l'écriture du fichier de sortie.");
					e.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("//------> Erreur dans le traitement des données du fichier.");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("//------> Erreur dans la tentative d'accès au fichier.");
			e.printStackTrace();
		}
	}
}
