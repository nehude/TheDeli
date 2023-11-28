package org.example;

public class Chips {

    private String flavor;
    private double price;

    public Chips(String flavor, double price) {
        this.flavor = flavor;
        this.price = price;
    }

    public Chips(String flavor) {
        this.flavor = flavor;
        this.price = calculatePrice();
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
        this.price = calculatePrice();
    }

    public double getPrice() {
        return price;
    }

    private double calculatePrice() {
        return 1.50;
    }
}

