package com.pluralsight.finance;

import com.pluralsight.portfolio.Portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    // Initialize the portfolio with the initial assets
    static Portfolio portfolio = new Portfolio("Portfolio", "Tina");

    public static void main(String[] args) {



        boolean running = true;
        while (running) {
            // Print main menu.
            System.out.println("\nSelect Asset Below");
            System.out.println("(1) Bank Account");
            System.out.println("(2) Credit Card");
            System.out.println("(3) Gold");
            System.out.println("(4) Jewelry");
            System.out.println("(5) House");
            System.out.println("(6) Portfolio Information");
            System.out.println("(7) Exit");

            // Ask user for choice
            System.out.print("Selection: ");
            String choice = scanner.nextLine().trim();

            // Read the user input
            switch (choice) {
                case "1": getBankAccount();
                    break;
                case "2": getCreditCard();
                    break;
                case "3": getGold();
                    break;
                case "4": getJewelry();
                    break;
                case "5": getHouse();
                    break;
                case "6": getPortfolioInfo();
                    break;
                case "7": exitProgram();
                    return;
                default:
                    System.out.println("**** Error Invalid choice ****");
            }
        }
    }

    // Create bankAccount method.
    public static void getBankAccount() {
        // Ask user for the account name:
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        // Ask user for the account number.
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        // Ask user for the account balance.
        System.out.print("Enter account balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        // Add the bank account to the portfolio.
        portfolio.add(new BankAccount(accountName, accountNumber,balance));
    }

    // Create creditCard method.
    public static void getCreditCard() {
        // Ask user for the credit card name.
        System.out.print("Enter credit card name: ");
        String cardName = scanner.nextLine();

        // Ask user for the card number.
        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();

        // Ask user for the card balance.
        System.out.print("Enter card balance: ");
        double cardBalance = scanner.nextDouble();
        scanner.nextLine();

        // Add the credit card to the portfolio.
        portfolio.add(new CreditCard(cardName, cardNumber, cardBalance));
    }

    // Create gold method.
    public static void getGold() {
        // Ask user for the weight of their gold.
        System.out.print("Enter name of the Gold(yellow,white): ");
        String goldName = scanner.nextLine();
        System.out.print("Enter the market value: ");
        double goldValue = scanner.nextDouble();
        System.out.print("Enter weight of gold: ");
        double goldWeight = scanner.nextDouble();
        scanner.nextLine();

        // Add the gold to the portfolio.
        portfolio.add(new Gold(goldName,goldValue,goldWeight));
    }

    // Create jewelry method.
    public static void getJewelry() {
        // Ask user for the name of the jewelry.
        System.out.print("Enter name of jewelry: ");
        String jewelryName = scanner.nextLine();
        System.out.print("Enter the market value: ");
        double jewelryValue = scanner.nextDouble();
        // Ask user for the karat of the jewelry.
        System.out.print("Enter karat of jewelry: ");
        double karat = scanner.nextDouble();

        // Add the jewelry to the portfolio.
        portfolio.add(new Jewelry(jewelryName,jewelryValue,karat));
    }

    // Create house method.
    public static void getHouse() {
        // Ask the user for the year the house was built.
        System.out.print("Enter year built: ");
        int yearBuilt = scanner.nextInt();

        // Ask the user for the square feet.
        System.out.print("Enter square feet: ");
        int squareFeet = scanner.nextInt();

        // Ask the user for the number of bedrooms.
        System.out.print("Enter number of bedrooms: ");
        int bedrooms = scanner.nextInt();

        // Add the house to the portfolio.
        portfolio.add(new House("New default house", 5000, yearBuilt, squareFeet, bedrooms));
    }

    // Create portfolioInformation method.
    public static void getPortfolioInfo() {
        // Print portfolio total value.
        System.out.println("\nPortfolio's current total value: $" + portfolio.getValue());

        // Print most valuable asset from the portfolio.
        Valuable mostValuable = portfolio.getMostValuable();
        if (mostValuable != null) {
            System.out.println("Most valuable asset: " + mostValuable);
        } else {
            System.out.println("No assets in the portfolio.");
        }

        // Print least valuable asset from the portfolio.
        Valuable leastValuable = portfolio.getLeastValuable();
        if (leastValuable != null) {
            System.out.println("Least valuable asset: " + leastValuable);
        } else {
            System.out.println("No assets in the portfolio.");
        }
    }

    public static void  exitProgram(){
        System.out.println("Thank you and have a nice day!");
    }
}
