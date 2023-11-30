package org.example;


import java.util.List;

public class Sandwich {
    private Size size;
    private Bread breadType;
    private RegularToppings[] regularToppingsList;
    private PremiumToppings[] premiumToppingsList;
    private boolean isToasted;


    public Sandwich(SandwichBuilder builder) {
        this.breadType = builder.breadType;
        this.size = builder.size;
        this.isToasted = builder.isToasted;
        this.regularToppingsList = builder.regularToppings;
        this.premiumToppingsList = builder.premiumToppings;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Bread getBreadType() {
        return breadType;
    }

    public void setBreadType(Bread breadType) {
        this.breadType = breadType;
    }

    public RegularToppings[] getRegularToppingsList() {
        return regularToppingsList;
    }

    public void setRegularToppingsList(RegularToppings[] regularToppingsList) {
        this.regularToppingsList = regularToppingsList;
    }

    public PremiumToppings[] getPremiumToppingsList() {
        return premiumToppingsList;
    }

    public void setPremiumToppingsList(PremiumToppings[] premiumToppingsList) {
        this.premiumToppingsList = premiumToppingsList;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
}