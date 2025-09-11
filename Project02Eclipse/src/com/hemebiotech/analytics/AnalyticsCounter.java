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
	 * Analyse and count how many time a symptom in this list {'headache', 'rash', 'dialated pupils'} is in symptom.txt file.
	 * The result is write in the fileName in parameters.
	 * @author Philippe & Axel
	 */
	public void analyseData() {

		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile(inputFile);
		List<String> symptomList = file.GetSymptoms();

		ListSymptomsByName listeOrdonnee = new ListSymptomsByName();
		listeOrdonnee.addSymptomsList(symptomList);

		WriteSymptomDataToFile output = new WriteSymptomDataToFile();
		output.WriteSymptoms(listeOrdonnee, outputFile);
	}
}
