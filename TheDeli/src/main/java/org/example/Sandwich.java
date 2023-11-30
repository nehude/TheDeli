package org.example;

import java.util.List;

public class Sandwich {
    private Bread breadType;
    private Size size;
    private boolean isToasted;
    private String extraMeat;
    private String extraCheese;
    private List<String> premiumToppings;
    private List<String> regularToppings;
    private List<String> sauces;

    public Sandwich(Bread breadType, Size size, boolean isToasted, String extraMeat, String extraCheese, List<String> premiumToppings, List<String> regularToppings, List<String> sauces) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.premiumToppings = premiumToppings;
        this.regularToppings = regularToppings;
        this.sauces = sauces;
    }

    public Bread getBreadType() {
        return breadType;
    }

    public void setBreadType(Bread breadType) {
        this.breadType = breadType;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public String getExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(String extraMeat) {
        this.extraMeat = extraMeat;
    }

    public String getExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(String extraCheese) {
        this.extraCheese = extraCheese;
    }

    public List<String> getPremiumToppings() {
        return premiumToppings;
    }

    public void setPremiumToppings(List<String> premiumToppings) {
        this.premiumToppings = premiumToppings;
    }

    public List<String> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<String> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public void setSauces(List<String> sauces) {
        this.sauces = sauces;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;

        switch (size) {
            case SMALL:
                totalPrice += 5.50;
                break;
            case MEDIUM:
                totalPrice += 7.00;
                break;
            case LARGE:
                totalPrice += 8.50;
                break;
            default:
                System.out.println("Invalid sandwich size: " + size);
                break;
        }

        if (extraMeat != null && !extraMeat.isEmpty()) {
            switch (size) {
                case SMALL:
                    totalPrice += 1.00;
                    break;
                case MEDIUM:
                    totalPrice += 2.00;
                    break;
                case LARGE:
                    totalPrice += 3.00;
                    break;
                default:
                    System.out.println("Invalid sandwich size: " + size);
                    break;
            }
        }

        if (extraCheese != null && !extraCheese.isEmpty()) {
            switch (size) {
                case SMALL:
                    totalPrice += 0.75;
                    break;
                case MEDIUM:
                    totalPrice += 1.50;
                    break;
                case LARGE:
                    totalPrice += 2.25;
                    break;
                default:
                    System.out.println("Invalid sandwich size: " + size);
                    break;
            }
        }

        return totalPrice;
    }
}
