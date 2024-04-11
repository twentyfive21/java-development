package com.pluralsight;
import java.util.Scanner;

public class RentalCarCalculator {

    static double rentalChargePerDay = 29.99;
    static double tollTagChargePerDay = 3.95;
    static double gpsChargePerDay = 2.95;
    static double roadsideChargePerDay = 3.95;
    static double totalCost = 0;

    public static void main(String[] args) {
        getUserInput();
    }

    // getting user input and calling other methods in order needed
    public static void getUserInput () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Bliss Car Rental! Please enter in the date for vehicle pick up : ");
        String pickUpDate = scanner.nextLine();
        System.out.print("What is your age? ");
        int age = scanner.nextInt();
        System.out.print("How many days would you need the vehicle for? ");
        int daysRented = scanner.nextInt();
        // clears out CRLF which is the enter key left in input buffer after int
        scanner.nextLine();
        calculateCost(age, daysRented);
        carAddOns(scanner, daysRented);
        displayTotalCost(pickUpDate);
    }

    // adding car add on price after surcharge is applied
    public static void carAddOns (Scanner scanner, int daysRented) {
        System.out.print("Would you like roadside assistance? ");
        String roadsideSelection = scanner.nextLine();
        System.out.print("Would you like a electronic toll tag? ");
        String tollTagSelection = scanner.nextLine();
        System.out.print("Would you like gps added? ");
        String gpsSelection = scanner.nextLine();

        if(roadsideSelection.equals("yes")) {
            totalCost += daysRented * roadsideChargePerDay;
        }
        if (tollTagSelection.equals("yes")){
            totalCost += daysRented * tollTagChargePerDay;
        }
        if (gpsSelection.equals("yes")){
            totalCost += daysRented * gpsChargePerDay;
        }
    }

    // calculate basic rental with surcharge if underage
    public static void calculateCost (int age, int daysRented) {
        totalCost += daysRented * rentalChargePerDay;

        if (age < 25) {
            double surcharge = totalCost * .30;
            totalCost += surcharge;
        }

    }

    // display total rental cost
    public static void displayTotalCost (String pickUpDate) {
        System.out.printf("Your Pickup date for %s is confirmed. \n", pickUpDate);
        System.out.printf("Your total cost is $%.2f ! Thank you for booking with us.", totalCost);
    }

}
