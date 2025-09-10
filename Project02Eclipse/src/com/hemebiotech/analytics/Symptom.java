package com.hemebiotech.analytics;

public class Symptom {
    private String name;

    public String getName() {
        return name;
    }
    public Symptom(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}
