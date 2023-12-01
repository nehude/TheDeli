package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CheckoutSelections extends JFrame {
    private List<String> orderDetails;
    private double totalOrderPrice;
    private UserInterface userInterface;

    public CheckoutSelections(List<String> orderDetails, double totalOrderPrice, UserInterface userInterface) {
        this.orderDetails = orderDetails;
        this.totalOrderPrice = totalOrderPrice;
        this.userInterface = userInterface;
        setTitle("Order Checkout");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 192, 203));
    }

    public void displayCheckoutScreen() {
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(orderPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        for (String detail : orderDetails) {
            JTextArea detailArea = new JTextArea(detail);
            detailArea.setEditable(false);
            detailArea.setWrapStyleWord(true);
            detailArea.setLineWrap(true);
            orderPanel.add(detailArea);
        }

        JLabel totalLabel = new JLabel("Total Order Price: $" + totalOrderPrice);
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            generateReceipt();
            JOptionPane.showMessageDialog(this, "Receipt generated!");
            dispose();
        });

        JButton returnButton = new JButton("Cancel Order");
        returnButton.addActionListener(e -> dispose());

        buttonPanel.add(confirmButton);
        buttonPanel.add(returnButton);

        add(scrollPane, BorderLayout.CENTER);
        add(totalLabel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void generateReceipt() {
        ReceiptFileManager receiptFileManager = new ReceiptFileManager();
        receiptFileManager.createReceiptFile(orderDetails, totalOrderPrice);
    }
}
