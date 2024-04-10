package com.pluralsight;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        System.out.println("Hi I am here to help calculate your pay.");
        System.out.print("Please provide your name : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("Please provide your hours worked : ");
        double hoursWorked = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Please provide your pay rate : ");
        double payRate = scanner.nextDouble();

        double totalPay = hoursWorked * payRate;
        System.out.println("Hi " + name + ",");
        System.out.println("Your total pay for hours worked will be : " + "$"+ String.format("%.2f",totalPay));

    }
}
