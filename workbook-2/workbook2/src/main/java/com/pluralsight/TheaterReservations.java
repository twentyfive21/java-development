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

        String userInput;
        DateTimeFormatter formatter;
        userInput = date;
        formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
        LocalDate reservation = LocalDate.parse(userInput, formatter);
        System.out.println(reservation);

    }
}
