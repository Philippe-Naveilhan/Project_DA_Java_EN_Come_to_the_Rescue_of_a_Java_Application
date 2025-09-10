package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	/**
	 * Analyse and count how many time a symptom in this list {'headache', 'rash', 'dialated pupils'} is in symptom.txt file.
	 * The result is write in the fileName in parameters (resultsOfDay.out)
	 * @author Philippe & Axel
	 * @param args
	 */
	public static void main(String args[]) throws Exception {


		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptomList = file.GetSymptoms();
		ListSymptomsByName listeOrdonnee = new ListSymptomsByName();

		for(int i=0; i<symptomList.size(); i++){
			Symptom symptom = new Symptom(symptomList.get(i));
			System.out.println(symptom.getName());
			listeOrdonnee.addSymptom(symptom);
		}

		WriteSymptomDataToFile output = new WriteSymptomDataToFile();

		output.WriteSymptoms(listeOrdonnee, "resultsOfDay.out");

	}
}
