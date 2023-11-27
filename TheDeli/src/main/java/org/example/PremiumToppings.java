package org.example;

public class PremiumToppings {
    public String meatType;
    public String cheeseType;

    public PremiumToppings(String meatType, String cheeseType) {
        this.meatType = meatType;
        this.cheeseType = cheeseType;
    }

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public String getCheeseType() {
        return cheeseType;
    }

    public void setCheeseType(String cheeseType) {
        this.cheeseType = cheeseType;
    }
    public double addExtraMeat(){
        if (meatType.equalsIgnoreCase("Angus Beef")){
            return 1.50;
        } else{
            return 0.00;
        }
    }
    public double addExtraCheese(){
        if (cheeseType.equalsIgnoreCase("Pepper Jack ")){
            return 0.75;
        }else if(cheeseType.equalsIgnoreCase("Provolone")){
            return 1.00;
        }else{
            return 0.00;
        }
    }
}
