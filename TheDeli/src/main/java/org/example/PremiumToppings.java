package org.example;

import java.util.ArrayList;

public class PremiumToppings {

        private String meatType;
        private String cheeseType;

        private ArrayList<String> meatOptions;
        private ArrayList<String> cheeseOptions;

        public PremiumToppings(String meatType, String cheeseType) {
            this.meatType = meatType;
            this.cheeseType = cheeseType;

            meatOptions = new ArrayList<>();
            meatOptions.add("Steak");
            meatOptions.add("Ham");
            meatOptions.add("Salami");
            meatOptions.add("Roast Beef");
            meatOptions.add("Chicken");
            meatOptions.add("Bacon");

            cheeseOptions = new ArrayList<>();
            cheeseOptions.add("American");
            cheeseOptions.add("Provolone");
            cheeseOptions.add("Cheddar");
            cheeseOptions.add("Swiss");
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

        public double addExtraMeat() {
            if (meatType.equals("Steak")) {
                return 3.50;
            } else if (meatType.equals("Ham")) {
                return 1.25;
            } else if (meatType.equals("Salami")) {
                return 1.50;
            } else if (meatType.equals("Roast Beef")) {
                return 2.00;
            } else if (meatType.equals("Chicken")) {
                return 2.00;
            } else if (meatType.equals("Bacon")) {
                return 1.50;
            } else {
                return 0.00;
            }
        }

        public double addExtraCheese() {
            if (cheeseType.equals("American")) {
                return 0.50;
            } else if (cheeseType.equals("Provolone")) {
                return 1.00;
            } else if (cheeseType.equals("Cheddar")) {
                return 1.00;
            } else if (cheeseType.equals("Swiss")) {
                return 0.75;
            } else {
                return 0.00;
            }
        }

        public ArrayList<String> getMeatOptions() {
            return meatOptions;
        }

        public ArrayList<String> getCheeseOptions() {
            return cheeseOptions;
        }
    }

