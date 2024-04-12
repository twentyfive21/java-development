package com.pluralsight;
import java.util.Scanner;

public class FinancialCalculators {

    // main method
    public static void main(String[] args) {
        getUserInput();
    }

    // user input method
    public static void getUserInput () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi :) Please pick one of the following calculators!");
        System.out.println("Select (a) for Mortgage, (b) for Future Value, or (c) for Present Value.");
        System.out.print("Enter here : ");
        String userChoice = scanner.nextLine();
        // switch cases for user input and error handling in case valid input is not given
        switch (userChoice.toLowerCase()) {
            case "a" : getMortgageValues(scanner);
            break;
            case "b" : getFutureValues(scanner);
            break;
            case "c" : getPresentValues(scanner);
            break;
            default : System.out.println("!!! Input invalid please select a letter !!!");
                 getUserInput();
                 break;
        }
    }

    // ~~~~ START All input checks below ~~~~
    // get user values for the mortgage calculator
    public static void getMortgageValues (Scanner scanner) {
        // attempting to get user input values
        try {
            System.out.println("You have selected the mortgage calculator.");
            System.out.print("Please provide the principle amount : ");
             double principle = scanner.nextDouble();
            System.out.print("Please provide the interest amount : ");
            double interest = scanner.nextDouble();
            System.out.print("Please provide the years: ");
            double years = scanner.nextDouble();
            mortgageCalculator(principle, interest, years);
        } catch (Exception e) {
            // throw an error if given string & clears out buffer from left over input to avoid overflow
            scanner.nextLine();
            System.out.println("Error! Please provide a number!");
            getMortgageValues(scanner);
        }
    }

    // get user values for the future value calculator
    public static void getFutureValues (Scanner scanner) {
        // attempting to get user input values
        try {
            System.out.println("You have selected the future value calculator.");
            System.out.print("Please provide the principle amount : ");
            double principle = scanner.nextDouble();
            System.out.print("Please provide the interest amount : ");
            double interest = scanner.nextDouble();
            System.out.print("Please provide the years: ");
            int time = scanner.nextInt();
            futureValueCalculator(principle,interest,time);
        } catch (Exception e) {
            // throw an error if string is given & clears out buffer from left over input to avoid overflow
            scanner.nextLine();
            System.out.println("Error! Please provide a number!");
            getFutureValues(scanner);
        }
    }

    // get user values for the present value calculator
    public static void getPresentValues (Scanner scanner) {
        // attempting to get user input values
        try {
            System.out.println("You have selected the future value calculator.");
            System.out.print("Please provide the monthly amount : ");
            double monthly = scanner.nextDouble();
            System.out.print("Please provide the interest amount : ");
            double interest = scanner.nextDouble();
            System.out.print("Please provide the years: ");
            double periods = scanner.nextInt();
            presentValueCalculator(monthly,interest,periods);
        } catch (Exception e) {
            // throw an error if string is given & clears out buffer from left over input to avoid overflow
            scanner.nextLine();
            System.out.println("Error! Please provide a number!");
            getPresentValues(scanner);
        }
    }
    // ~~~~  Input checks END ~~~~


    // ~~~~ START All 3 calculators below ~~~~

    // mortgage calculator method
    public static void mortgageCalculator (double principle, double interest, double years) {
        double monthlyInterestRate = interest / 1200;
        double payments = years * 12;
        // formula for monthly payment
        double monthlyMortgagePayment =
                principle * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, payments))
                        / (Math.pow(monthlyInterestRate + 1, payments) - 1);

        System.out.printf("Your monthly payment will be $%.2f \n", monthlyMortgagePayment);

        // calculating total loan cost
        double totalLoan = payments * monthlyMortgagePayment;
        // calculating the total interest
        double totalInterest = totalLoan - principle;
        System.out.printf("This loan will cost you $%.2f \n", totalLoan);
        System.out.printf("The total interest is $%.2f", totalInterest);
    }

    // future value calculator
    public static void futureValueCalculator (double principle, double interest, int time) {
        // A = P(1 + r/n)^nt, where:  r = interest rate (as a decimal)* , t = time (in years).
        // A = ending amount (this means original balance plus all interest earned after n years).
        // P = original balance (or your initial deposit, since there are typically no other contributions to CDs).
        // n = number of times interest is compounded per year (typically 365 for daily, 12 for monthly, 4 for quarterly)
        double interestRate = interest / 100;
        int number = 365;
        System.out.println("You have selected the future value calculator");
            // double interestRate = 1.75 / 100; // Annual interest rate (as a decimal)
        double nt = number * time;
        // full balance calculation
        double balance = principle * Math.pow((1 + interestRate / number), nt);
        // total interest calculation
        double totalInterest = balance - principle;
        System.out.printf("Your ending balance is $%.2f \n", balance);
        System.out.printf("Total interest earned is $%.2f\n", totalInterest);
    }

    // present value calculator
    public static void presentValueCalculator (double monthly, double interest, double periods) {
        System.out.println("You have selected the present value calculator");
        // convert the years into monthly payments
        double periodConverted = periods * 12;
        // divide by 12000 to get the monthly interest rate
        double interestConverted = interest / 1200;
        // formula for present value
        double value = monthly * (1 - Math.pow((1 + interestConverted), -periodConverted)) / interestConverted;
        System.out.printf("You would need to invest $%.2f ", value);
    }

    // ~~~~  Calculators END ~~~~
}
