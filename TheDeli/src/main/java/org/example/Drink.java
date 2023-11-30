package org.example;

public class Drink {
    private String drinkSize;
    private String drinkType;
    private double drinkPrice;

    public Drink(String drinkSize, String drinkType) {
        this.drinkSize = drinkSize;
        this.drinkType = drinkType;
        initializePrices();
    }

    private void initializePrices() {
        switch (drinkSize) {
            case "small":
                drinkPrice = 2.00;
                break;
            case "medium":
                drinkPrice = 2.50;
                break;
            case "large":
                drinkPrice = 3.00;
                break;
            default:
                System.out.println("Invalid drink size: " + drinkSize);
                break;
        }
    }

    public void displayDrinkDetails() {
        System.out.println("Drink: " + drinkType);
        System.out.println("Size: " + drinkSize);
        System.out.println("Price: $" + drinkPrice);
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    // total price including drink
    public double calculateTotalPrice() {
        return drinkPrice;
    }
}

