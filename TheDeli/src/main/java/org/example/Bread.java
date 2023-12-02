package org.example;

public enum Bread {
    WHITE("White"),
    WHEAT("Wheat"),
    RYE("Rye"),
    WRAP("Wrap");

    private final String breadType;

    Bread(String breadType) {
        this.breadType = breadType;
    }

    public String getBreadType() {
        return breadType;
    }
}