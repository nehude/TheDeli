package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrinkSelections extends JFrame {
    private JComboBox<String> drinkSizeComboBox;
    private JButton submitButton;

    private String selectedDrinkSize;

    public DrinkSelections() {
        setTitle("Add Drink");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        String[] drinkSizes = {"Small", "Medium", "Large"};
        drinkSizeComboBox = new JComboBox<>(drinkSizes);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                collectDrinkDetails();
            }
        });

        JPanel drinkSizePanel = new JPanel(new FlowLayout());
        drinkSizePanel.add(new JLabel("Drink Size:"));
        drinkSizePanel.add(drinkSizeComboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);

        add(drinkSizePanel);
        add(buttonPanel);
        setVisible(true);
    }

    private void collectDrinkDetails() {
        selectedDrinkSize = (String) drinkSizeComboBox.getSelectedItem();

        // handle drink selection

        double drinkPrice = calculateDrinkPrice();
        JOptionPane.showMessageDialog(null, "Drink added to order. Price: $" + drinkPrice);

        dispose();
    }

    private double calculateDrinkPrice() {
        // calculate drink price based on selected size
        if ("Small".equals(selectedDrinkSize)) {
            return 2.00;
        } else if ("Medium".equals(selectedDrinkSize)) {
            return 2.50;
        } else if ("Large".equals(selectedDrinkSize)) {
            return 3.00;
        } else {
            return 0.00;
        }
    }

    public String getSelectedDrinkSize() {
        return selectedDrinkSize;
    }
}

