package org.example;


public class SandwichBuilder {
    Bread breadType;
    Size size;
    boolean isToasted;
    RegularToppings[] regularToppings;
    PremiumToppings[] premiumToppings;

    public SandwichBuilder() {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.regularToppings = regularToppings;
        this.premiumToppings = premiumToppings;
    }
    public SandwichBuilder breadType(Bread breadType){
        this.breadType = breadType;
        return this;
    }
    public SandwichBuilder size(Enum size){
        this.size = (Size) size;
        return this;
    }
    public SandwichBuilder isToasted(boolean isToasted){
        this.isToasted = isToasted;
        return this;
    }
    public SandwichBuilder regularToppings(RegularToppings... regularToppings){
        this.regularToppings = regularToppings;
        return this;
    }
    public SandwichBuilder premiumToppings(PremiumToppings... premiumToppings){
        this.premiumToppings = premiumToppings;
        return this;
    }

    public Sandwich build(){
        return new Sandwich(this);
    }





}
