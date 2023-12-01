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
    private JComboBox<String> isToastedComboBox;

    public SandwichSelections() {
        setTitle("New Sandwich");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 192, 203));
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        String[] sizeOptions = {"Small", "Medium", "Large"};
        sizeOptionComboBox = new JComboBox<>(sizeOptions);

        String[] breadTypes = {"White", "Wheat", "Rye", "Wrap"};
        breadTypeComboBox = new JComboBox<>(breadTypes);

        String[] premiumToppingsMeat = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
        premiumToppingsMeatCheckBoxes = new JCheckBox[premiumToppingsMeat.length];
        for (int i = 0; i < premiumToppingsMeat.length; i++) {
            premiumToppingsMeatCheckBoxes[i] = new JCheckBox(premiumToppingsMeat[i]);
        }

        String[] extraMeatChoice = {"Yes", "No"};
        extraMeatComboBox = new JComboBox<>(extraMeatChoice);

        String[] premiumToppingsCheese = {"American", "Provolone", "Cheddar", "Swiss"};
        premiumToppingsCheeseComboBox = new JComboBox<>(premiumToppingsCheese);

        String[] extraCheeseChoice = {"Yes", "No"};
        extraCheeseComboBox = new JComboBox<>(extraCheeseChoice);

        String[] isToastedChoice = {"Yes", "No"};
        isToastedComboBox = new JComboBox<>(isToastedChoice);

        String[] regularToppings = {"Lettuce", "Peppers", "Onions", "Jalapenos", "Tomatoes", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
        regularToppingsCheckBoxes = new JCheckBox[regularToppings.length];
        for (int i = 0; i < regularToppings.length; i++) {
            regularToppingsCheckBoxes[i] = new JCheckBox(regularToppings[i]);
        }

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

        JPanel isToastedPanel = new JPanel(new FlowLayout());
        isToastedPanel.add(new JLabel("Toasted: "));
        isToastedPanel.add(isToastedComboBox);

        JPanel toppingsPanel = createToppingsPanel();
        JPanel saucesPanel = createSaucesPanel();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, toppingsPanel, saucesPanel);
        splitPane.setResizeWeight(0.5); // Adjust this value as needed
        splitPane.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment

        // Use a wrapper panel with a BoxLayout to center the splitPane
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.add(Box.createHorizontalGlue()); // Glue before
        centerPanel.add(splitPane);
        centerPanel.add(Box.createHorizontalGlue()); // Glue after

        add(sizePanel);
        add(breadPanel);
        add(meatPanel);
        add(extraMeatPanel);
        add(cheesePanel);
        add(extraCheesePanel);
        add(isToastedPanel);
        add(splitPane);
        add(centerPanel);
        add(submitButton);

        setVisible(true);
    }

    private JPanel createToppingsPanel() {
        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setLayout(new BoxLayout(toppingsPanel, BoxLayout.Y_AXIS));
        toppingsPanel.add(new JLabel("Toppings:"));
        for (JCheckBox checkBox : regularToppingsCheckBoxes) {
            JPanel toppingItemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            toppingItemPanel.add(checkBox);
            JCheckBox extraCheckBox = new JCheckBox("Extra");
            extraCheckBox.setVisible(false);
            checkBox.addActionListener(e -> extraCheckBox.setVisible(checkBox.isSelected()));
            toppingItemPanel.add(extraCheckBox);
            toppingsPanel.add(toppingItemPanel);
        }
        return toppingsPanel;
    }

    private JPanel createSaucesPanel() {
        JPanel saucesPanel = new JPanel();
        saucesPanel.setLayout(new BoxLayout(saucesPanel, BoxLayout.Y_AXIS));
        saucesPanel.add(new JLabel("Sauces:"));

        for (JCheckBox checkBox : sauceChoiceCheckBoxes) {
            JPanel sauceItemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            sauceItemPanel.add(checkBox);

            JCheckBox extraCheckBox = new JCheckBox("Extra");
            extraCheckBox.setVisible(false);

            JCheckBox sideCheckBox = new JCheckBox("Side");
            sideCheckBox.setVisible(false);

            checkBox.addActionListener(e -> {
                extraCheckBox.setVisible(checkBox.isSelected());
                sideCheckBox.setVisible(checkBox.isSelected());
            });

            sauceItemPanel.add(extraCheckBox);
            sauceItemPanel.add(sideCheckBox);
            saucesPanel.add(sauceItemPanel);
        }
        return saucesPanel;
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
