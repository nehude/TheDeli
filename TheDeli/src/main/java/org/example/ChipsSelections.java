package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChipsSelections extends JFrame {
    private JComboBox<String> chipTypeComboBox;
    private JButton submitButton;

    private ReceiptFileManager receiptFileManager;

    public ChipsSelections(ReceiptFileManager receiptFileManager) {
        this.receiptFileManager = receiptFileManager;

        setTitle("Add Chips");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        String[] chipTypes = {"Original", "Barbecue", "Salt and Vinegar", "Cheddar", "Sour Cream and Onion", "Jalapeno"};
        chipTypeComboBox = new JComboBox<>(chipTypes);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                collectChipsDetails();
            }
        });

        JPanel chipTypePanel = new JPanel(new FlowLayout());
        chipTypePanel.add(new JLabel("Chip Type:"));
        chipTypePanel.add(chipTypeComboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);

        add(chipTypePanel);
        add(buttonPanel);
        setVisible(true);
    }

    private void collectChipsDetails() {
        String selectedChipType = getSelectedChipType();
        double chipPrice = calculateChipPrice(selectedChipType);

        JOptionPane.showMessageDialog(null, "Chips added to order. Price: $" + chipPrice);

        dispose();
    }

    public String getSelectedChipType() {
        return (String) chipTypeComboBox.getSelectedItem();
    }

    public double calculateChipPrice(String selectedChipType) {
        return 1.50;
    }
}
