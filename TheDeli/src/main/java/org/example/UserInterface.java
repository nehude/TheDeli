package org.example;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order currentOrder = null;

        int choice;
        do {
            System.out.println("Home Screen");
            System.out.println("1. New Order");
            System.out.println("0. Exit the app");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    currentOrder = new Order();
                    handleOrder(currentOrder, scanner);
                    break;

                case 0:
                    System.out.println("Exiting the app. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    private static void handleOrder(Order order, Scanner scanner) {
        int choice;
        do {
            System.out.println("Order Screen");
            System.out.println("1. Add sandwich");
            System.out.println("2. Add drink");
            System.out.println("3. Add chips");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel order");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSandwich(order, scanner);
                    break;

                case 2:
                    addDrink(order, scanner);
                    break;

                case 3:
                    addChips(order, scanner);
                    break;

                case 4:
                    checkout(order, scanner);
                    break;

                case 0:
                    System.out.println("Order canceled. Going back to the home screen.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    private static void addSandwich(Order order, Scanner scanner) {
        Scanner input = new Scanner(System.in);

        Sandwich sandwich = new Sandwich();


        System.out.println("Select bread type:");
        System.out.println("1. White");
        System.out.println("2. Wheat");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");
        System.out.print("Enter your choice: ");
        int breadChoice = scanner.nextInt();

        switch (breadChoice) {
            case 1:
                sandwich.setBreadType("White");
                break;
            case 2:
                sandwich.setBreadType("Wheat");
                break;
            case 3:
                sandwich.setBreadType("Rye");
                break;
            case 4:
                sandwich.setBreadType("Wrap");
                break;
            default:
                System.out.println("Invalid choice. Going back to the order screen.");
                return;
        }

        System.out.println("Select sandwich size:");
        System.out.println("1. 4 inch");
        System.out.println("2. 8 inch");
        System.out.println("3. 12 inch");
        System.out.print("Enter your choice: ");
        int sizeChoice = scanner.nextInt();

        switch (sizeChoice) {
            case 1:
                sandwich.setSize(4);
                break;
            case 2:
                sandwich.setSize(8);
                break;
            case 3:
                sandwich.setSize(12);
                break;
            default:
                System.out.println("Invalid choice. Going back to the order screen.");
                return;
        }

    }

    private static void addDrink(Order order, Scanner scanner) {
        Scanner input = new Scanner(System.in);

        //Drink drink = new Drink();

        System.out.println("Select drink size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.print("Enter your choice: ");
        int sizeChoice = scanner.nextInt();

        Drink drink = null;
        switch (sizeChoice) {
            case 1:
                drink.setSize("Small");
                break;
            case 2:
                drink.setSize("Medium");
                break;
            case 3:
                drink.setSize("Large");
                break;
            default:
                System.out.println("Invalid choice. Going back to the order screen.");
                return;
        }

        order.addDrink(drink);
        System.out.println("Drink added to the order!");
    }


    public void addChipsToOrder(Scanner scanner, boolean isSide) {
        System.out.println("Would you like to add chips to your order?");
        String chipsInput = scanner.nextLine();
        boolean wantsChips = chipsInput.equalsIgnoreCase("yes");

        if (wantsChips) {
            int chipQuantity;
            do {
                System.out.println("Enter the quantity of chips you want:");
                chipQuantity = scanner.nextInt();
            } while (chipQuantity < 1);

            if (isSide) {
                menu.addSide(new Chip("Chips", 1.50, chipQuantity));
            } else {
                menu.addMainItem(new Chip("Chips", 1.50, chipQuantity));
            }

            System.out.println("Chips added to your order.");
        } else {
            System.out.println("Chips not added to your order.");
        }
    }

    private static void checkout(Order order, Scanner scanner) {
      //method for checkout goes here
    }
}

