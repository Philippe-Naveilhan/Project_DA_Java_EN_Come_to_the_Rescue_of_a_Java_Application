package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	/**
	 * Analyse and count how many time a symptom in this list {'headache', 'rash', 'dialated pupils'} is in symptom.txt file.
	 * The result is write in result.out
	 * @author Philippe & Axel
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		// take text file with symptoms and affect first line to String line
		BufferedReader reader = new BufferedReader (new FileReader("../symptoms.txt"));
		String line = reader.readLine();

		while (line != null) {
			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.equals("dialated pupils")) {
				pupilCount++;
			}
			line = reader.readLine();	// get another line in text
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
