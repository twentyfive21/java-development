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

        double totalPay;
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
        System.out.print("Hi " + name + ",");
        System.out.printf("your total pay for hours worked will be : \n $%.2f for this week.", totalPay);

    }
}
