package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class UserInterface extends JFrame {
    private SandwichBuilder sandwichBuilder;
    private SandwichSelections sandwichSelections;
    private ReceiptFileManager receiptFileManager;

    private int currentStep = 0;
    private JPanel buttonPanelStep2;
    private JButton startOrderButton;
    private JButton exitButton;

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

       /* JPanel imagePanel = new JPanel(new BorderLayout());
        String imagePath = "C:\\Users\\lesli\\OneDrive\\Pictures\\Screenshots\\Screenshot 2023-11-30 152427.png";
        File file = new File(imagePath);
        if (file.exists()) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            JLabel imageLabel = new JLabel(imageIcon);
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } else {
            JLabel errorLabel = new JLabel("Image not found!");
            imagePanel.add(errorLabel, BorderLayout.CENTER);
        }

        add(imagePanel, BorderLayout.CENTER);
        
        */

        add(startOrderButton);
        add(exitButton);
        setVisible(true);

    }


    public void startNewOrder() {
        currentStep = 1;
        sandwichBuilder = new SandwichBuilder();
        receiptFileManager = new ReceiptFileManager();
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
                    ChipsSelections chipsSelections = new ChipsSelections();
                    chipsSelections.setVisible(true);
                }
            });

            JButton addDrinkButton = new JButton("Add Drink");
            addDrinkButton.setBackground(new Color(255, 182, 193));
            addDrinkButton.setForeground(Color.DARK_GRAY);
            addDrinkButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DrinkSelections drinkSelections = new DrinkSelections();
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
                    // code for canceling order
                    JOptionPane.showMessageDialog(null, "Order canceled");
                    dispose();
                }
            });

            buttonPanelStep2 = new JPanel(new GridLayout(0, 1));
            buttonPanelStep2.add(addSandwichButton);
            buttonPanelStep2.add(addChipsButton);
            buttonPanelStep2.add(addDrinkButton);
            buttonPanelStep2.add(checkoutButton);
            buttonPanelStep2.add(cancelOrderButton);
            add(buttonPanelStep2);

            pack();
            setVisible(true);
        }
    }




    private void collectAndProcessOrderDetails() {
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

        receiptFileManager.printSandwichDetailsToReceipt(sandwich);
        JOptionPane.showMessageDialog(null, "Order submitted successfully!");
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserInterface ui = new UserInterface();
        });
    }
}
