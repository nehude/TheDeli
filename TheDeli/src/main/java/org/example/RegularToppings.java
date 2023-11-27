package org.example;

public class RegularToppings {
        private String toppingType;
        private String toppingSauceType;
        private String sideSauceType;

        public RegularToppings(String toppingType, String toppingSauceType, String sideSauceType) {
            this.toppingType = toppingType;
            this.toppingSauceType = toppingSauceType;
            this.sideSauceType = sideSauceType;
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
    }
