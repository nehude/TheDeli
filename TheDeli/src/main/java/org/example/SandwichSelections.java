package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

        public SandwichSelections() {
            setTitle("New Sandwich");
            setSize(500, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(0, 1));

            //Size
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

            //Extra Meat
            String[] extraMeatChoice = {"Yes", "No"};
            extraMeatComboBox = new JComboBox<>(extraMeatChoice);

            //Cheese Selection
            String[] premiumToppingsCheese = {"American", "Provolone", "Cheddar", "Swiss"};
            premiumToppingsCheeseComboBox = new JComboBox<>(premiumToppingsCheese);

            //Extra Cheese
            String[] extraCheeseChoice = {"Yes", "No"};
            extraCheeseComboBox = new JComboBox<>(extraCheeseChoice);

            // Regular toppings
            String[] regularToppings = {"Lettuce", "Peppers", "Onions", "Jalapenos", "Tomatoes", "Cucumbers", "Pickles",
            "Guacamole", "Mushrooms"};
            regularToppingsCheckBoxes = new JCheckBox[regularToppings.length];
            for (int i = 0; i < regularToppings.length; i++) {
                regularToppingsCheckBoxes[i] = new JCheckBox(regularToppings[i]);
            }

            //Sauce Selection
            String[] sauceSelections = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Island", "Vinaigrette"};
            sauceChoiceCheckBoxes = new JCheckBox[sauceSelections.length];
            for (int i = 0; i < sauceSelections.length; i++){
                sauceChoiceCheckBoxes[i] = new JCheckBox(sauceSelections[i]);
            }

            submitButton = new JButton("Submit");

            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selectedBreadType = (String) breadTypeComboBox.getSelectedItem();
                    String selectedSize = (String) sizeOptionComboBox.getSelectedItem();
                    String selectedExtraMeat = (String) extraMeatComboBox.getSelectedItem();
                    String selectedExtraCheese = (String) extraCheeseComboBox.getSelectedItem();

                    ArrayList<String> selectedPremiumToppingsMeat = new ArrayList<>();
                    for (JCheckBox checkBox : premiumToppingsMeatCheckBoxes) {
                        if (checkBox.isSelected()) {
                            selectedPremiumToppingsMeat.add(checkBox.getText());
                        }
                    }

                    String selectedPremiumToppingsCheese = (String) premiumToppingsCheeseComboBox.getSelectedItem();

                    ArrayList<String> selectedRegularToppings = new ArrayList<>();
                    for (JCheckBox checkBox : regularToppingsCheckBoxes) {
                        if (checkBox.isSelected()) {
                            selectedRegularToppings.add(checkBox.getText());
                        }
                    }

                    ArrayList<String> selectedSauces = new ArrayList<>();
                    for (JCheckBox checkBox : sauceChoiceCheckBoxes) {
                        if (checkBox.isSelected()) {
                            selectedSauces.add(checkBox.getText());
                        }
                    }

                    System.out.println("Selected Size: " + selectedSize);
                    System.out.println("Selected Bread Type: " + selectedBreadType);
                    System.out.println("Selected Extra Meat: " + selectedExtraMeat);
                    System.out.println("Selected Extra Cheese: " + selectedExtraCheese);
                    System.out.println("Selected Premium Toppings (Meat): " + selectedPremiumToppingsMeat);
                    System.out.println("Selected Premium Toppings (Cheese): " + selectedPremiumToppingsCheese);
                    System.out.println("Selected Regular Toppings: " + selectedRegularToppings);
                    System.out.println("Selected Sauces: " + selectedSauces);
                    dispose();
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
            for (JCheckBox checkBox : sauceChoiceCheckBoxes){
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
            add(buttonPanel);
            setVisible(true);
        }
        
}
