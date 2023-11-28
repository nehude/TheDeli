package org.example;

public class Drink {
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor, double price) {
        this.size = size;
        this.flavor = flavor;
        this.price = price;
    }

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = calculatePrice(size);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
        this.price = calculatePrice(size);
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    private double calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                System.out.println("Invalid drink size. Setting price to 0.00");
                return 0.00;
        }
    }
}