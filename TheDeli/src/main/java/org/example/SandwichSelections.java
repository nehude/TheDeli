package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SandwichSelections extends JFrame {

        private JComboBox<String> breadTypeComboBox;
        private JCheckBox[] premiumToppingsCheckBoxes;
        private JCheckBox[] regularToppingsCheckBoxes;
        private JButton submitButton;

        public SandwichSelections() {
            setTitle(" Sandwich Ordering");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());

            // Bread types
            String[] breadTypes = {"White", "Wheat", "Rye", "Wrap"};
            breadTypeComboBox = new JComboBox<>(breadTypes);

            // Premium toppings
            String[] premiumToppings = {"Meat", "Cheese"};
            premiumToppingsCheckBoxes = new JCheckBox[premiumToppings.length];
            for (int i = 0; i < premiumToppings.length; i++) {
                premiumToppingsCheckBoxes[i] = new JCheckBox(premiumToppings[i]);
            }

            // Regular toppings
            String[] regularToppings = {"Lettuce", "Tomato", "Onion"};
            regularToppingsCheckBoxes = new JCheckBox[regularToppings.length];
            for (int i = 0; i < regularToppings.length; i++) {
                regularToppingsCheckBoxes[i] = new JCheckBox(regularToppings[i]);
            }

            submitButton = new JButton("Submit");

            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selectedBreadType = (String) breadTypeComboBox.getSelectedItem();
                    ArrayList<String> selectedPremiumToppings = new ArrayList<>();
                    ArrayList<String> selectedRegularToppings = new ArrayList<>();

                    for (JCheckBox checkBox : premiumToppingsCheckBoxes) {
                        if (checkBox.isSelected()) {
                            selectedPremiumToppings.add(checkBox.getText());
                        }
                    }

                    for (JCheckBox checkBox : regularToppingsCheckBoxes) {
                        if (checkBox.isSelected()) {
                            selectedRegularToppings.add(checkBox.getText());
                        }
                    }

                    System.out.println("Selected Bread Type: " + selectedBreadType);
                    System.out.println("Selected Premium Toppings: " + selectedPremiumToppings);
                    System.out.println("Selected Regular Toppings: " + selectedRegularToppings);
                }
            });

            add(new JLabel("Select Bread Type:"));
            add(breadTypeComboBox);

            add(new JLabel("Select Premium Toppings:"));
            for (JCheckBox checkBox : premiumToppingsCheckBoxes) {
                add(checkBox);
            }

            add(new JLabel("Select Regular Toppings:"));
            for (JCheckBox checkBox : regularToppingsCheckBoxes) {
                add(checkBox);
            }

            add(submitButton);

            setVisible(true);
        }

        public static void main(String[] args) {
            new SandwichSelections();
        }


}
