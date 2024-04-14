package com.pluralsight;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {

    // main method
    public static void main(String[] args) {
        getUserInput();
    }

    // get user input
    public static void getUserInput () {
        // name Johnson, Geri
        // date  (MM/dd/yyyy)
        // tickets
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String fullName = scanner.nextLine();
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String date = scanner.nextLine();
        System.out.print("How many tickets would you like? ");
        int tickets = scanner.nextInt();
        // clear leftover input in the buffer
        scanner.nextLine();
        formatReservations(fullName, date, tickets);
    }

    // format values
    public static void formatReservations (String fullName, String date, int tickets) {

        // format the tickets
        if (tickets > 1) {
            System.out.printf("%d tickets reserved for ", tickets);
        } else {
            System.out.printf("%d ticket reserved for ", tickets);
        }

        // format the date
        String userInput;
        DateTimeFormatter formatter;
        userInput = date;
        formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
        LocalDate reservation = LocalDate.parse(userInput, formatter);
        System.out.print(reservation);

        String space = " ";
        // split the string at each space and return into the splitName array
        String[] splitName = fullName.split(space);
        String firstName = splitName[1].substring(0,1).toUpperCase() + splitName[1].substring(1);
        String lastName = splitName[0].substring(0,1).toUpperCase() + splitName[0].substring(1);
        System.out.printf(" under %s, %s", lastName, firstName);
    }
}
