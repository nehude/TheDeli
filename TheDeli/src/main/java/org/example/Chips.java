package org.example;

public class Chips {
    private String chipType;
    private double chipPrice;

    public Chips(String chipType) {
        this.chipType = chipType;
        this.chipPrice = 1.50;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    public double getChipPrice() {
        return chipPrice;
    }

    public void setChipPrice(double chipPrice) {
        this.chipPrice = chipPrice;
    }

    public String getChipType() {
        return chipType;
    }

    public double calculateTotalPrice() {
        return chipPrice;
    }
}
