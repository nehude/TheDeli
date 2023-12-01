package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptFileManager {
    private String fileName;

    public ReceiptFileManager() {
        this.fileName = generateReceiptFileName();
    }

    public void printSandwichDetailsToReceipt(Sandwich sandwich) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nSandwich Details:\n");
        sb.append("Bread Type: ").append(sandwich.getBreadType()).append("\n");
        sb.append("Size: ").append(sandwich.getSize()).append("\n");
        List<String> premiumToppings = sandwich.getPremiumToppings();
        if (premiumToppings != null && !premiumToppings.isEmpty()) {
            sb.append("Meat: ").append(String.join(", ", premiumToppings)).append("\n");
        }
        sb.append("Extra Meat: ").append(sandwich.getExtraMeat()).append("\n");
        sb.append("Extra Cheese: ").append(sandwich.getExtraCheese()).append("\n");

        double sandwichPrice = sandwich.calculateTotalPrice();
        sb.append("Price: $").append(sandwichPrice).append("\n");

        appendToReceipt(sb.toString());
    }

    public void printChipsDetailsToReceipt(ChipsSelections chipsSelections) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nChips Details:\n");
        sb.append("Chip Type: ").append(chipsSelections.getSelectedChipType()).append("\n");
        double chipPrice = chipsSelections.calculateChipPrice(chipsSelections.getSelectedChipType());
        sb.append("Price: $").append(chipPrice).append("\n");

        appendToReceipt(sb.toString());
    }

    public void printDrinkDetailsToReceipt(String selectedDrinkSize, String selectedDrinkType, double drinkPrice) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nDrink Details:\n");
        sb.append("Drink Size: ").append(selectedDrinkSize).append("\n");
        sb.append("Drink Type: ").append(selectedDrinkType).append("\n");
        sb.append("Price: $").append(drinkPrice).append("\n");

        appendToReceipt(sb.toString());
    }

    private void appendToReceipt(String detail) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(detail);
        } catch (IOException e) {
            System.out.println("Error appending to receipt file: " + e.getMessage());
        }
    }

    private String generateReceiptFileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        return "src/main/resources/receipts/receipt_" + formattedDateTime + ".csv";
    }

    public void createReceiptFile(List<String> orderDetails, double totalOrderPrice) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            writer.println("Order Details");
            writer.println("Order Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            writer.println();

            if (!orderDetails.isEmpty()) {
                for (String detail : orderDetails) {
                    writer.println(detail);
                }
            }


            writer.println("\nTotal Price: $" + totalOrderPrice);
            System.out.println("Receipt file created: " + fileName);
        } catch (IOException e) {
            System.out.println("Error creating receipt file: " + e.getMessage());
        }
    }
}
