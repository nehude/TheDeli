package org.example;

import java.util.ArrayList;

public class Bread {

    private String breadType;

    private ArrayList<String> breadOptions;

    public Bread(String breadType) {
        this.breadType = breadType;
        breadOptions = new ArrayList<>();
        breadOptions.add("White");
        breadOptions.add("Wheat");
        breadOptions.add("Rye");
        breadOptions.add("Wrap");
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public ArrayList<String> getBreadOptions() {
        return breadOptions;
    }
}

