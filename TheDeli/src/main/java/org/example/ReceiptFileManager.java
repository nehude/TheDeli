package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptFileManager {
    public void createReceiptFile(List<String> orderDetails, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String detail : orderDetails) {
                writer.println(detail);
            }
            System.out.println("Receipt file created: " + fileName);
        } catch (IOException e) {
            System.out.println("Error creating receipt file: " + e.getMessage());
        }
    }

    public void printSandwichDetailsToReceipt(Sandwich sandwich) {
        String fileName = generateReceiptFileName();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Order Details\n");
            sb.append("Order Date: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");

            sb.append("\nSandwich Details:\n");
            sb.append("Bread Type: ").append(sandwich.getBreadType()).append("\n");
            sb.append("Size: ").append(sandwich.getSize()).append("\n");
            sb.append("Extra Meat: ").append(sandwich.getExtraMeat()).append("\n");
            sb.append("Extra Cheese: ").append(sandwich.getExtraCheese()).append("\n");

            List<String> premiumToppings = sandwich.getPremiumToppings();
            if (premiumToppings != null && !premiumToppings.isEmpty()) {
                sb.append("Premium Toppings (Meat): ").append(String.join(", ", premiumToppings)).append("\n");
            }


            sb.append("\nTotal Price: $").append(sandwich.calculateTotalPrice()).append("\n");

            writer.println(sb.toString());

            System.out.println("Sandwich details printed to receipt: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error printing sandwich details to receipt file.");
        }
    }

    private String generateReceiptFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);
        return "src/main/resources/receipts/" + formattedDateTime + ".csv";
    }
}



