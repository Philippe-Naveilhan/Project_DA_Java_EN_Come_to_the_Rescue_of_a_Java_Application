package com.hemebiotech.analytics;

import java.util.TreeMap;

public class ListSymptomsByName {
    public TreeMap<String, Integer> listSymptomsByName = new TreeMap<>();

    public void addSymptom(Symptom symptom){
        if(symptom != null) {
            if (listSymptomsByName.containsKey(symptom.getName())) {
                Integer newValue = listSymptomsByName.get(symptom.getName()) + 1;
                listSymptomsByName.put(symptom.getName(), newValue);
            } else {
                listSymptomsByName.put(symptom.getName(), 1);
            }
        }
    }
}
