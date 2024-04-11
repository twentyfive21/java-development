package com.pluralsight;
import java.util.Scanner;

public class PayrollCalculator2 {
    static String name;
    static double hoursWorked;
    static double payRate;
    static double totalPay;

    public static void main(String[] args) {
        System.out.println(" ");
        System.out.print("Hi I am here to help calculate your pay. Please provide your name : ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.print("Please provide your hours worked : ");
        hoursWorked = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Please provide your pay rate : ");
        payRate = scanner.nextDouble();
        calculatePay();
    }

    // method calculating pay
    public static void calculatePay () {
        double overTime;
        if (hoursWorked > 40) {
            double otPayRate = payRate * 1.5;
            overTime = hoursWorked - 40;
            totalPay = payRate * 40;
            double otPayToAdd = overTime * otPayRate;
            totalPay += otPayToAdd;
        } else {
            totalPay = hoursWorked * payRate;
        }
        displayPay();
    }

    // display the pay for the week
    public static void displayPay () {
        System.out.println(" ");
        System.out.print("~ Hi " + name + ", ");
        System.out.printf("your total pay for hours worked will be : $%.2f ~ \n", totalPay );
        System.out.println(" Have a nice day " + name + " :) !");
    }

}
