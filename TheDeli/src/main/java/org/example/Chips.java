package org.example;

public class Chips {
    private String chipType;
    private double chipPrice;

    public Chips(String chipType) {
        this.chipType = chipType;
        initializePrices();
    }

    private void initializePrices(){}
    // price for chips


    public void displayChipDetails() {
        System.out.println("Chips: " + chipType);
        System.out.println("Price: $" + chipPrice);
    }


    public String getChipType() {
        return chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    public double getChipPrice() {
        return chipPrice;
    }

    public double calculateTotalPrice() {
        return chipPrice;
    }
}
