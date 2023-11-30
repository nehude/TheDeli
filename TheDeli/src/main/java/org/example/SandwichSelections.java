package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SandwichSelections extends JFrame {
    private JComboBox<String> sizeOptionComboBox;
    private JComboBox<String> extraMeatComboBox;
    private JComboBox<String> breadTypeComboBox;
    private JCheckBox[] premiumToppingsMeatCheckBoxes;
    private JComboBox<String> premiumToppingsCheeseComboBox;
    private JComboBox<String> extraCheeseComboBox;
    private JCheckBox[] regularToppingsCheckBoxes;
    private JCheckBox[] sauceChoiceCheckBoxes;
    private JButton submitButton;

    private String selectedBreadType;
    private String selectedSize;
    private String selectedExtraMeat;
    private String selectedExtraCheese;
    private List<String> selectedPremiumToppingsMeat;
    private String selectedPremiumToppingsCheese;
    private List<String> selectedRegularToppings;
    private List<String> selectedSauces;

    public SandwichSelections() {
        setTitle("New Sandwich");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        // Size
        String[] sizeOptions = {"Small", "Medium", "Large"};
        sizeOptionComboBox = new JComboBox<>(sizeOptions);

        // Bread types
        String[] breadTypes = {"White", "Wheat", "Rye", "Wrap"};
        breadTypeComboBox = new JComboBox<>(breadTypes);

        // Meat Selection
        String[] premiumToppingsMeat = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
        premiumToppingsMeatCheckBoxes = new JCheckBox[premiumToppingsMeat.length];
        for (int i = 0; i < premiumToppingsMeat.length; i++) {
            premiumToppingsMeatCheckBoxes[i] = new JCheckBox(premiumToppingsMeat[i]);
        }

        // Extra Meat
        String[] extraMeatChoice = {"Yes", "No"};
        extraMeatComboBox = new JComboBox<>(extraMeatChoice);

        // Cheese Selection
        String[] premiumToppingsCheese = {"American", "Provolone", "Cheddar", "Swiss"};
        premiumToppingsCheeseComboBox = new JComboBox<>(premiumToppingsCheese);

        // Extra Cheese
        String[] extraCheeseChoice = {"Yes", "No"};
        extraCheeseComboBox = new JComboBox<>(extraCheeseChoice);

        // Regular toppings
        String[] regularToppings = {"Lettuce", "Peppers", "Onions", "Jalapenos", "Tomatoes", "Cucumbers", "Pickles",
                "Guacamole", "Mushrooms"};
        regularToppingsCheckBoxes = new JCheckBox[regularToppings.length];
        for (int i = 0; i < regularToppings.length; i++) {
            regularToppingsCheckBoxes[i] = new JCheckBox(regularToppings[i]);
        }

        // Sauce Selection
        String[] sauceSelections = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Island", "Vinaigrette"};
        sauceChoiceCheckBoxes = new JCheckBox[sauceSelections.length];
        for (int i = 0; i < sauceSelections.length; i++) {
            sauceChoiceCheckBoxes[i] = new JCheckBox(sauceSelections[i]);
        }

        submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                collectSandwichDetails();
            }
        });

        JPanel sizePanel = new JPanel(new FlowLayout());
        sizePanel.add(new JLabel("Size:"));
        sizePanel.add(sizeOptionComboBox);

        JPanel breadPanel = new JPanel(new FlowLayout());
        breadPanel.add(new JLabel("Bread Type:"));
        breadPanel.add(breadTypeComboBox);

        JPanel meatPanel = new JPanel(new FlowLayout());
        meatPanel.add(new JLabel("Meat Choice:"));
        for (JCheckBox checkBox : premiumToppingsMeatCheckBoxes) {
            meatPanel.add(checkBox);
        }

        JPanel extraMeatPanel = new JPanel(new FlowLayout());
        extraMeatPanel.add(new JLabel("Extra Meat: "));
        extraMeatPanel.add(extraMeatComboBox);

        JPanel cheesePanel = new JPanel(new FlowLayout());
        cheesePanel.add(new JLabel("Cheese:"));
        cheesePanel.add(premiumToppingsCheeseComboBox);

        JPanel extraCheesePanel = new JPanel(new FlowLayout());
        extraCheesePanel.add(new JLabel("Extra Cheese:"));
        extraCheesePanel.add(extraCheeseComboBox);

        JPanel toppingsPanel = new JPanel(new FlowLayout());
        toppingsPanel.add(new JLabel("Toppings:"));
        for (JCheckBox checkBox : regularToppingsCheckBoxes) {
            toppingsPanel.add(checkBox);
        }

        JPanel saucesPanel = new JPanel(new FlowLayout());
        saucesPanel.add(new JLabel("Sauces:"));
        for (JCheckBox checkBox : sauceChoiceCheckBoxes) {
            saucesPanel.add(checkBox);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);

        add(sizePanel);
        add(breadPanel);
        add(meatPanel);
        add(extraMeatPanel);
        add(cheesePanel);
        add(extraCheesePanel);
        add(toppingsPanel);
        add(saucesPanel);
        add(buttonPanel);
        setVisible(true);
    }

    private void collectSandwichDetails() {
        selectedBreadType = (String) breadTypeComboBox.getSelectedItem();
        selectedSize = (String) sizeOptionComboBox.getSelectedItem();
        selectedExtraMeat = (String) extraMeatComboBox.getSelectedItem();
        selectedExtraCheese = (String) extraCheeseComboBox.getSelectedItem();

        selectedPremiumToppingsMeat = new ArrayList<>();
        for (JCheckBox checkBox : premiumToppingsMeatCheckBoxes) {
            if (checkBox.isSelected()) {
                selectedPremiumToppingsMeat.add(checkBox.getText());
            }
        }

        selectedPremiumToppingsCheese = (String) premiumToppingsCheeseComboBox.getSelectedItem();

        selectedRegularToppings = new ArrayList<>();
        for (JCheckBox checkBox : regularToppingsCheckBoxes) {
            if (checkBox.isSelected()) {
                selectedRegularToppings.add(checkBox.getText());
            }
        }

        selectedSauces = new ArrayList<>();
        for (JCheckBox checkBox : sauceChoiceCheckBoxes) {
            if (checkBox.isSelected()) {
                selectedSauces.add(checkBox.getText());
            }
        }

        JOptionPane.showMessageDialog(null, "Sandwich added to cart");

        dispose();
    }


    public String getSelectedBreadType() {
        return selectedBreadType;
    }

    public String getSelectedSize() {
        return selectedSize;
    }

    public String getSelectedExtraMeat() {
        return selectedExtraMeat;
    }

    public String getSelectedExtraCheese() {
        return selectedExtraCheese;
    }

    public List<String> getSelectedPremiumToppingsMeat() {
        return selectedPremiumToppingsMeat;
    }

    public String getSelectedPremiumToppingsCheese() {
        return selectedPremiumToppingsCheese;
    }

    public List<String> getSelectedRegularToppings() {
        return selectedRegularToppings;
    }

    public List<String> getSelectedSauces() {
        return selectedSauces;
    }
}
