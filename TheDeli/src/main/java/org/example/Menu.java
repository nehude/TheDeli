package org.example;

public class Menu {

    private String breadType;
    private String meatType;
    private String cheeseType;
    private String sandwichSize;
    private String sideOption;
    private String drinkSize;
    private boolean wantChips;

    private double basePrice;
    private double meatPremium;
    private double extraMeatPremium;
    private double cheesePremium;
    private double extraCheesePremium;
    private double sidePrice;
    private double drinkPrice;
    private double chipsPrice;

    public Menu(String breadType, String meatType, String cheeseType, String sandwichSize,
                String sideOption, String drinkSize, boolean wantChips) {
        this.breadType = breadType;
        this.meatType = meatType;
        this.cheeseType = cheeseType;
        this.sandwichSize = sandwichSize;
        this.sideOption = sideOption;
        this.drinkSize = drinkSize;
        this.wantChips = wantChips;

        initializePrices();
    }

    private void initializePrices() {
        // Sandwich prices
        switch (sandwichSize) {
            case "4 inch":
                basePrice = 5.50;
                break;
            case "8 inch":
                basePrice = 7.00;
                break;
            case "12 inch":
                basePrice = 8.50;
                break;
            default:
                System.out.println("Invalid sandwich size: " + sandwichSize);
                break;
        }

        calculateMeatPremiums();
        calculateCheesePremiums();

        switch (sideOption) {
            case "au jus":
                sidePrice = 0.00;
                break;
            default:
                System.out.println("Invalid side option: " + sideOption);
                break;
        }

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

        chipsPrice = wantChips ? 1.50 : 0.00;
    }

    private void calculateMeatPremiums() {
        if (isMeatPremium()) {
            meatPremium = 1.00;
            if (isMeatPremium()) {
                extraMeatPremium = 0.50;
            }
        }
    }

    private void calculateCheesePremiums() {
        if (isCheesePremium()) {
            cheesePremium = 0.75;
            if (isCheesePremium()) {
                extraCheesePremium = 0.30;
            }
        }
    }

    private boolean isMeatPremium() {
        return meatType.equals("Steak")
                || meatType.equals("Ham")
                || meatType.equals("Salami")
                || meatType.equals("Roast Beef")
                || meatType.equals("Chicken");
    }

    private boolean isCheesePremium() {
        return cheeseType.equals("Provolone")
                || cheeseType.equals("Cheddar")
                || cheeseType.equals("Swiss");
    }



    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
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

    public String getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public String getSideOption() {
        return sideOption;
    }

    public void setSideOption(String sideOption) {
        this.sideOption = sideOption;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public boolean isWantChips() {
        return wantChips;
    }

    public void setWantChips(boolean wantChips) {
        this.wantChips = wantChips;
    }
}


