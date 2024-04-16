package com.pluralsight;
import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        CellPhone firstUser = new CellPhone();
        CellPhone secondUser = new CellPhone();
        CellPhone thirdUser = new CellPhone(3,"apple",
                "Verizon","800-222-2222","owner 3");
        getUserInput(firstUser);
        getUserInput(secondUser);
        displayUserData(firstUser);
        displayUserData(secondUser);
        displayUserData(thirdUser);
        // passing using getter and setter
        firstUser.dial(secondUser.getPhoneNumber());
        secondUser.dial(firstUser.getPhoneNumber());
        // overloaded method for dial passing the class
        thirdUser.dial(firstUser);
    }

    public static void getUserInput (CellPhone currentUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the serial number? ");
        currentUser.setSerialNumber(scanner.nextInt());
        // clear leftover in the buffer
        scanner.nextLine();
        System.out.print("What model is the phone? ");
        currentUser.setModel(scanner.nextLine());
        System.out.print("Who is the carrier? ");
        currentUser.setCarrier(scanner.nextLine());
        System.out.print("What is the phone number? ");
        currentUser.setPhoneNumber(scanner.nextLine());
        System.out.print("Who is the owner of the phone? ");
        currentUser.setOwner(scanner.nextLine());
        // new line for spacing
        System.out.println();
    }
    public static void displayUserData (CellPhone currentUser) {
        // get back data from the class
        System.out.printf("Serial number: %d \n",currentUser.getSerialNumber());
        System.out.printf("Phone model: %s \n", currentUser.getModel());
        System.out.printf("Carrier: %s \n", currentUser.getCarrier());
        System.out.printf("Phone number: %s \n", currentUser.getPhoneNumber());
        System.out.printf("Owner: %s \n", currentUser.getOwner());
    }
}
