package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Read file and return a List, one value by line *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	public boolean isTxtFile(String fileName){
		return fileName.endsWith(".txt");
	}
	@Override
	public List<String> GetSymptoms() throws Exception {
		ArrayList<String> result = new ArrayList<String>();
		if (filepath != null && isTxtFile(filepath)) {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
        }
		return result;
	}

}
