package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class ListSymptomsByName {
    public TreeMap<String, Integer> listSymptomsByName = new TreeMap<>();

    public TreeMap<String, Integer> getListSymptomsByName(){
        return listSymptomsByName;
    }

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

    public void addSymptomsList(List<String> list){
        if(list != null) {
            for(int i=0; i<list.size(); i++){
                Symptom symptom = new Symptom(list.get(i));
                addSymptom(symptom);
            }
        }
    }
}
