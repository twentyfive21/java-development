package com.pluralsight;
import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        CellPhone firstUser = new CellPhone();
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the serial number? ");
        firstUser.setSerialNumber(scanner.nextInt());
        // clear leftover in the buffer
        scanner.nextLine();
        System.out.print("What model is the phone? ");
        firstUser.setModel(scanner.nextLine());
        System.out.print("Who is the carrier? ");
        firstUser.setCarrier(scanner.nextLine());
        System.out.print("What is the phone number? ");
        firstUser.setPhoneNumber(scanner.nextLine());
        System.out.print("Who is the owner of the phone? ");
        firstUser.setOwner(scanner.nextLine());
        // new line for spacing
        System.out.println();

        // get back data from the class
        System.out.printf("Serial number: %d \n",firstUser.getSerialNumber());
        System.out.printf("Phone model: %s \n", firstUser.getModel());
        System.out.printf("Carrier: %s \n", firstUser.getCarrier());
        System.out.printf("Phone number: %s \n", firstUser.getPhoneNumber());
        System.out.printf("Owner: %s \n", firstUser.getOwner());

    }
}
