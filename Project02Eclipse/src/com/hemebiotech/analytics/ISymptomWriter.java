package com.hemebiotech.analytics;

import java.util.Map;

/**
 * All sended for write in output file need to have at least 2 values :
 *     - The output filename
 *     - A TreeMap of symptoms and quantity of each.    
 *     
 */

public interface ISymptomWriter {
    /**
     * If no all data needed, we have to return a message.
     * If all data are done, we have to do the job, and return a message.
     */

    void writeSymptoms(Map<String, Integer> symptoms);
}
