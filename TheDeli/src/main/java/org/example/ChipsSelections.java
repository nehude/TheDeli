package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChipsSelections extends JFrame {
    private JComboBox<String> chipTypeComboBox;
    private JButton submitButton;

    private String selectedChipType;

    public ChipsSelections() {
        setTitle("Add Chips");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        selectedChipType = (String) chipTypeComboBox.getSelectedItem();

        // handle chip selection

        JOptionPane.showMessageDialog(null, "Chips added to order");

        dispose();
    }

    public String getSelectedChipType() {
        return selectedChipType;
    }
}
