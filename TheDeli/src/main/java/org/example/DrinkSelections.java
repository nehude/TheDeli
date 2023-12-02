package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrinkSelections extends JFrame {
    private JComboBox<String> drinkSizeComboBox;
    private JComboBox<String> drinkTypeComboBox;
    private JButton submitButton;

    private String selectedDrinkSize;
    private String selectedDrinkType;

    private ReceiptFileManager receiptFileManager;

    public DrinkSelections(ReceiptFileManager receiptFileManager) {
        this.receiptFileManager = receiptFileManager;

        setTitle("Add Drink");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        String[] drinkSizes = {"Small", "Medium", "Large"};
        drinkSizeComboBox = new JComboBox<>(drinkSizes);

        String[] drinkTypes = {"Coke", "Sprite", "Hi-C", "Fanta", "Lemonade", "Water"};
        drinkTypeComboBox = new JComboBox<>(drinkTypes);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                collectDrinkDetails();
            }
        });

        JPanel drinkSizePanel = new JPanel(new FlowLayout());
        drinkSizePanel.add(new JLabel("Drink Size:"));
        drinkSizePanel.add(drinkSizeComboBox);

        JPanel drinkTypePanel = new JPanel(new FlowLayout());
        drinkTypePanel.add(new JLabel("Drink Type:"));
        drinkTypePanel.add(drinkTypeComboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);

        add(drinkSizePanel);
        add(drinkTypePanel);
        add(buttonPanel);
        setVisible(true);
    }

    private void collectDrinkDetails() {
        selectedDrinkSize = (String) drinkSizeComboBox.getSelectedItem();
        selectedDrinkType = (String) drinkTypeComboBox.getSelectedItem();

        double drinkPrice = calculateDrinkPrice(selectedDrinkSize);

        JOptionPane.showMessageDialog(null, "Drink added to order. Price: $" + drinkPrice);

        dispose();
    }

    public double calculateDrinkPrice(String selectedDrinkSize) {
        return switch (selectedDrinkSize.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.00;
        };
    }

    public String getSelectedDrinkType() {
        return selectedDrinkType;
    }

    public String getSelectedDrinkSize() {
        return selectedDrinkSize;
    }
}
