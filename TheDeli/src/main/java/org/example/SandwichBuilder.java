package org.example;

import java.util.List;

public class SandwichBuilder {
    private Bread breadType;
    private Size size;
    private boolean isToasted;
    private String extraMeat;
    private String extraCheese;
    private List<String> premiumToppings;
    private List<String> regularToppings;
    private List<String> sauces;

    public SandwichBuilder() {
    }

    public SandwichBuilder breadType(Bread breadType) {
        this.breadType = breadType;
        return this;
    }

    public SandwichBuilder size(Size size) {
        this.size = size;
        return this;
    }

    public SandwichBuilder isToasted(boolean isToasted) {
        this.isToasted = isToasted;
        return this;
    }

    public SandwichBuilder extraMeat(String extraMeat) {
        this.extraMeat = extraMeat;
        return this;
    }

    public SandwichBuilder extraCheese(String extraCheese) {
        this.extraCheese = extraCheese;
        return this;
    }

    public SandwichBuilder premiumToppings(List<String> premiumToppings) {
        this.premiumToppings = premiumToppings;
        return this;
    }

    public SandwichBuilder regularToppings(List<String> regularToppings) {
        this.regularToppings = regularToppings;
        return this;
    }

    public SandwichBuilder sauces(List<String> sauces) {
        this.sauces = sauces;
        return this;
    }

    public Sandwich build() {
        return new Sandwich(breadType, size, isToasted, extraMeat, extraCheese, premiumToppings, regularToppings, sauces);
    }
}
