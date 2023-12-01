package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UserInterface extends JFrame {
    private SandwichBuilder sandwichBuilder;
    private SandwichSelections sandwichSelections;
    private DrinkSelections drinkSelections;
    private ChipsSelections chipsSelections;
    private ReceiptFileManager receiptFileManager;
    private CheckoutSelections checkoutSelections;

    private int currentStep = 0;
    private JPanel buttonPanelStep2;
    private JButton startOrderButton;
    private JButton exitButton;

    private List<String> orderDetails = new ArrayList<>();

    public UserInterface() {
        setTitle("Gorgeous Girlies Sandwich Shop");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        getContentPane().setBackground(new Color(255, 192, 203));

        JLabel welcomeLabel = new JLabel("Welcome to the Gorgeous Girlies Sandwich Shop!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.DARK_GRAY);
        add(welcomeLabel);

        startOrderButton = new JButton("Start New Order");
        startOrderButton.setBackground(new Color(255, 182, 193));
        startOrderButton.setForeground(Color.DARK_GRAY);
        startOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewOrder();
                displayOrderScreen();
                startOrderButton.setVisible(false);
                exitButton.setVisible(false);
            }
        });

        exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(255, 182, 193));
        exitButton.setForeground(Color.DARK_GRAY);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(startOrderButton);
        add(exitButton);
        setVisible(true);
    }

    public void startNewOrder() {
        currentStep = 1;
        receiptFileManager = new ReceiptFileManager();
        sandwichBuilder = new SandwichBuilder();
        chipsSelections = new ChipsSelections(receiptFileManager);
        drinkSelections = new DrinkSelections(receiptFileManager);
    }

    private void displayOrderScreen() {
        if (currentStep == 1) {
            JButton addSandwichButton = new JButton("Add Sandwich");
            addSandwichButton.setBackground(new Color(255, 182, 193));
            addSandwichButton.setForeground(Color.DARK_GRAY);
            addSandwichButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sandwichSelections = new SandwichSelections();
                    sandwichSelections.setVisible(true);
                }
            });

            JButton addChipsButton = new JButton("Add Chips");
            addChipsButton.setBackground(new Color(255, 182, 193));
            addChipsButton.setForeground(Color.DARK_GRAY);
            addChipsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chipsSelections.setVisible(true);
                }
            });

            JButton addDrinkButton = new JButton("Add Drink");
            addDrinkButton.setBackground(new Color(255, 182, 193));
            addDrinkButton.setForeground(Color.DARK_GRAY);
            addDrinkButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drinkSelections.setVisible(true);
                }
            });

            JButton checkoutButton = new JButton("Checkout");
            checkoutButton.setBackground(new Color(255, 182, 193));
            checkoutButton.setForeground(Color.DARK_GRAY);
            checkoutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    collectAndProcessOrderDetails();
                }
            });

            JButton cancelOrderButton = new JButton("Cancel Order");
            cancelOrderButton.setBackground(new Color(255, 182, 193));
            cancelOrderButton.setForeground(Color.DARK_GRAY);
            cancelOrderButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Order canceled");
                    cancelOrderAndReset();
                }
            });


            buttonPanelStep2 = new JPanel(new GridLayout(0, 1));
            buttonPanelStep2.add(addSandwichButton);
            buttonPanelStep2.add(addChipsButton);
            buttonPanelStep2.add(addDrinkButton);
            buttonPanelStep2.add(checkoutButton);
            buttonPanelStep2.add(cancelOrderButton);
            add(buttonPanelStep2);

            revalidate();
            repaint();

            setVisible(true);
        }
    }

    private void collectAndProcessOrderDetails() {
        double totalOrderPrice = 0.0;

        String selectedBreadType = sandwichSelections.getSelectedBreadType();
        String selectedSize = sandwichSelections.getSelectedSize();
        String selectedExtraMeat = sandwichSelections.getSelectedExtraMeat();
        String selectedExtraCheese = sandwichSelections.getSelectedExtraCheese();

        List<String> selectedPremiumToppingsMeat = sandwichSelections.getSelectedPremiumToppingsMeat();
        String selectedPremiumToppingsCheese = sandwichSelections.getSelectedPremiumToppingsCheese();
        List<String> selectedRegularToppings = sandwichSelections.getSelectedRegularToppings();
        List<String> selectedSauces = sandwichSelections.getSelectedSauces();

        Sandwich sandwich = sandwichBuilder
                .breadType(Bread.valueOf(selectedBreadType.toUpperCase()))
                .size(Size.valueOf(selectedSize.toUpperCase()))
                .extraMeat(selectedExtraMeat)
                .extraCheese(selectedExtraCheese)
                .premiumToppings(selectedPremiumToppingsMeat)
                .regularToppings(selectedRegularToppings)
                .sauces(selectedSauces)
                .build();

        double sandwichPrice = sandwich.calculateTotalPrice();
        totalOrderPrice += sandwichPrice;

        StringBuilder sandwichDetails = new StringBuilder();
        sandwichDetails.append("Sandwich Details:\n");
        sandwichDetails.append("Bread Type: ").append(selectedBreadType).append("\n");
        sandwichDetails.append("Size: ").append(selectedSize).append("\n");
        sandwichDetails.append("Extra Meat: ").append(selectedExtraMeat).append("\n");
        sandwichDetails.append("Extra Cheese: ").append(selectedExtraCheese).append("\n");

        if (!selectedPremiumToppingsMeat.isEmpty()) {
            sandwichDetails.append("Premium Toppings (Meat): ").append(String.join(", ", selectedPremiumToppingsMeat)).append("\n");
        }

        if (!selectedPremiumToppingsCheese.isEmpty()) {
            sandwichDetails.append("Premium Toppings (Cheese): ").append(selectedPremiumToppingsCheese).append("\n");
        }

        if (!selectedRegularToppings.isEmpty()) {
            sandwichDetails.append("Regular Toppings: ").append(String.join(", ", selectedRegularToppings)).append("\n");
        }

        if (!selectedSauces.isEmpty()) {
            sandwichDetails.append("Sauces: ").append(String.join(", ", selectedSauces)).append("\n");
        }

        sandwichDetails.append("Price: $").append(sandwichPrice).append("\n");

        orderDetails.add(sandwichDetails.toString());

        String selectedChipType = chipsSelections.getSelectedChipType();
        double chipPrice = chipsSelections.calculateChipPrice(selectedChipType);
        totalOrderPrice += chipPrice;

        StringBuilder chipsDetails = new StringBuilder();
        chipsDetails.append("Chips Details:\n");
        chipsDetails.append("Chip Type: ").append(selectedChipType).append("\n");
        chipsDetails.append("Price: $").append(chipPrice).append("\n");

        orderDetails.add(chipsDetails.toString());

        // Drink details
        String selectedDrinkSize = drinkSelections.getSelectedDrinkSize();
        String drinkType = drinkSelections.getSelectedDrinkType();
        double drinkPrice = drinkSelections.calculateDrinkPrice(selectedDrinkSize);
        totalOrderPrice += drinkPrice;

        StringBuilder drinkDetails = new StringBuilder();
        drinkDetails.append("Drink Details:\n");
        drinkDetails.append("Drink Size: ").append(selectedDrinkSize).append("\n");
        drinkDetails.append("Drink Type: ").append(drinkType).append("\n");
        drinkDetails.append("Price: $").append(drinkPrice).append("\n");

        orderDetails.add(drinkDetails.toString());

        // Set the total price
        totalOrderPrice = Math.round(totalOrderPrice * 100.0) / 100.0;

        // Show checkout screen
        CheckoutSelections checkoutSelections = new CheckoutSelections(orderDetails, totalOrderPrice, this);
        checkoutSelections.displayCheckoutScreen();

        resetToInitialState();
    }

    private void resetToInitialState() {
        // Remove the order buttons from the UI
        remove(buttonPanelStep2);

        // Show the start and exit buttons
        startOrderButton.setVisible(true);
        exitButton.setVisible(true);

        // Reset the user interface
        revalidate();
        repaint();
    }
    private void cancelOrderAndReset() {
        // Clear all order details
        orderDetails.clear();

        // Reset the UI to the initial state
        resetToInitialState();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserInterface ui = new UserInterface();
        });
    }
}
