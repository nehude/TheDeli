package org.example;

import java.util.ArrayList;

public class RegularToppings {
    private String toppingType;
    private String toppingSauceType;
    private String sideSauceType;
    private ArrayList<String> regularToppingsList;
    private ArrayList<String> saucesList;


    public RegularToppings(String toppingType, String toppingSauceType, String sideSauceType) {
        this.toppingType = toppingType;
        this.toppingSauceType = toppingSauceType;
        this.sideSauceType = sideSauceType;

        regularToppingsList = new ArrayList<>();
        regularToppingsList.add("lettuce");
        regularToppingsList.add("peppers");
        regularToppingsList.add("onions");
        regularToppingsList.add("tomatoes");
        regularToppingsList.add("jalapenos");
        regularToppingsList.add("cucumbers");
        regularToppingsList.add("pickles");
        regularToppingsList.add("guacamole");
        regularToppingsList.add("mushrooms");

        saucesList = new ArrayList<>();
        saucesList.add("mayo");
        saucesList.add("mustard");
        saucesList.add("ketchup");
        saucesList.add("ranch");
        saucesList.add("thousand island");
        saucesList.add("vinaigrette");
    }

    public String getToppingType() {
        return toppingType;
    }

    public void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    public String getToppingSauceType() {
        return toppingSauceType;
    }

    public void setToppingSauceType(String toppingSauceType) {
        this.toppingSauceType = toppingSauceType;
    }

    public String getSideSauceType() {
        return sideSauceType;
    }

    public void setSideSauceType(String sideSauceType) {
        this.sideSauceType = sideSauceType;

    }

    public ArrayList<String> getRegularToppingsList() {
        return regularToppingsList;
    }

    public ArrayList<String> getSaucesList() {
        return saucesList;
    }
}
