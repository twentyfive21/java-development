package com.pluralsight;
import java.util.Scanner;

public class AddressBuilder {
    // main method
    public static void main(String[] args) {
        getUserInput();
    }
    // getting user input
    public static void getUserInput () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the following information:");
        System.out.print("Full name: ");
        String inputName = scanner.nextLine();
        String fullBilling = getAddress("Billing", scanner);
        String fullShipping = getAddress("Shipping", scanner);
        formatAddress(inputName, fullBilling, fullShipping);
    }
    // get address and do a small amount of formatting by pre-formatting string builder method is cleaner
    public static String getAddress (String string, Scanner scanner) {
        System.out.printf("%s Street: ", string);
        String inputAddress = scanner.nextLine().trim();
        System.out.printf("%s City: ", string);
        String inputCity = scanner.nextLine().trim();
        System.out.printf("%s State: ", string);
        String inputState = scanner.nextLine().trim();
        System.out.printf("%s Zip: ", string);
        String inputZip = scanner.nextLine().trim();
        return inputAddress + "\n" + inputCity + ", " + inputState.toUpperCase() + " " + inputZip;
    }
    // format code using string builder
    public static void formatAddress (String inputName, String fullBilling, String fullShipping) {
        // create a String Builder object
        StringBuilder fullAddress = new StringBuilder();
        fullAddress.append("\n");
        fullAddress.append(inputName);
        fullAddress.append("\n\n");
        fullAddress.append("Billing Address: \n");
        fullAddress.append(fullBilling);
        fullAddress.append("\n\n");
        fullAddress.append("Shipping Address: \n");
        fullAddress.append(fullShipping);
        String combinedAddress = fullAddress.toString();
        // print out the full address in correct format
        System.out.println(combinedAddress);
    }
}