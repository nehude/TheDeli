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
