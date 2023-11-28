package org.example;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class Order {

    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        this.chips.add(chips);
    }

    public double calculateTotalPrice() {
        double total = 0;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.calculatePrice();
        }

        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        for (Chips chip : chips) {
            total += chip.getPrice();
        }

        return total;
    }

    public void displayOrderDetails() {
        System.out.println("Order Details:");

        // Display sandwich details
        System.out.println("Sandwiches:");
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich.toString());
        }
        
        System.out.println("Drinks:");
        for (Drink drink : drinks) {
            System.out.println(drink.getSize() + " " + drink.getFlavor() + " - $" + drink.getPrice());
        }
        
        System.out.println("Chips:");
        for (Chips chip : chips) {
            System.out.println(chip.getFlavor() + " - $" + chip.getPrice());
        }
        
        System.out.println("Total Price: $" + calculateTotalPrice());
    }

    public void saveOrderToReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String dateTime = dateFormat.format(new Date());
        String fileName = "receipts/order_" + dateTime + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            //order details saves to the receipt file (neha)
            writer.println("Order Details:");
            
            writer.println("Sandwiches:");
            for (Sandwich sandwich : sandwiches) {
                writer.println(sandwich.toString());
            }
            
            writer.println("Drinks:");
            for (Drink drink : drinks) {
                writer.println(drink.getSize() + " " + drink.getFlavor() + " - $" + drink.getPrice());
            }
            
            writer.println("Chips:");
            for (Chips chip : chips) {
                writer.println(chip.getFlavor() + " - $" + chip.getPrice());
            }
            
            writer.println("Total Price: $" + calculateTotalPrice());

            System.out.println("Order receipt saved to: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving order receipt: " + e.getMessage());
        }
    }
}

