package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
	 * Analyse and count how many time a symptom is in this list in {inputFile}.
	 * The result is written in the {outputFile}.
	 * @author Philippe & Axel
	 */
	public void analyseData() {

		List<String> symptoms = reader.getSymptoms();
		Map<String, Integer> symptomsMap = new TreeMap<>();
		for(String symptom : symptoms) {
			symptomsMap.put(symptom, symptomsMap.getOrDefault(symptom,0) + 1);
		}

		writer.writeSymptoms(symptomsMap);
	}
}
