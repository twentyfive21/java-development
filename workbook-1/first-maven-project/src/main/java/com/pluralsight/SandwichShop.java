package com.pluralsight;
import java.util.Scanner;

// equalsIgnoreCase

public class SandwichShop {
    static double youngDiscount = 0.90;
    static double oldDiscount = 0.80;
    static double loadedRegular = 1.00;
    static double loadedLarge = 1.75;

    public static void main(String[] args) {
      getUserOrder();
    }

    // getting user age and sandwich size
    public static void getUserOrder () {
        System.out.println("Welcome to my sandwich shop!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like a regular or a large? ");
        String itemSize = scanner.nextLine();
        System.out.print("How old are you? ");
        int age = scanner.nextInt();
        scanner.nextLine();
        calculatePrice(age, itemSize, scanner);
    }

    // calculating total
    public static void calculatePrice (int age, String itemSize, Scanner scanner) {
        // if item == regular return 5.45 else assumes large and return 8.95
        double total = itemSize.equals("regular") ? 5.45 : 8.95;
        System.out.print("Would you liked the sandwich loaded? ");
        String isLoaded = scanner.nextLine();

        // calculating total if item is loaded
        if (itemSize.equals("regular")) {
            total = isLoaded.equals("yes") ? total + loadedRegular : total;
        } else if (itemSize.equals("large")){
            total = isLoaded.equals("yes") ? total + loadedLarge : total;
        }
        total = age <= 17 ? total * youngDiscount : total * oldDiscount;
        displayTotal(total);
    }

    // displaying the total to the user
    public static void displayTotal (double total) {
        System.out.printf("Your total today will be $%.2f. \n" , total);
        System.out.println("Thank you, for coming! Have a nice day !!!");
    }

}
