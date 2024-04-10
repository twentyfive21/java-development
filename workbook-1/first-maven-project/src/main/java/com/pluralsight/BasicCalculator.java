package com.pluralsight;
import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println("Please choose if you want to add, subtract, multiply, or divide.");
        System.out.print("Please type in the first letter lowercased here : ");
        Scanner myScanner = new Scanner(System.in);
        String selection = myScanner.nextLine();
        System.out.println("Cool you have chosen " + selection + "!");
        System.out.print("Provide first value : ");
        int num1 = myScanner.nextInt();
        myScanner.nextLine();
        System.out.print("Provide next value :");
        int num2 = myScanner.nextInt();

        int answer = 0;
        if (selection.equals("a")) {
             answer = num1 + num2;
        } else if (selection.equals("s")) {
             answer = num1 - num2;
        } else if (selection.equals("m")) {
             answer = num1 * num2;
        } else if (selection.equals("d")) {
             answer = num1 / num2;
        }
        System.out.println("Your total is " + answer + "!");
        System.out.println("Thank you, for using me today come again if you need help!");
    }

}
