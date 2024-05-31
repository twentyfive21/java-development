package com.pluralsight;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // The main method serves as the entry point of the application.
            // Create a Scanner object to read user input from the console.
            Scanner scanner = new Scanner(System.in);

            // Load the Spring application context from the beans.xml configuration file.
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

            // Retrieve the SimpleProductDao bean from the Spring application context.
            SimpleProductDao simpleProductDao = context.getBean(SimpleProductDao.class);
            boolean running = true;
            while(running) {
                // Print a welcome message to the console.
                System.out.println("\n!! Welcome !!");

                // Display menu options to the user.
                System.out.println("(1) List Products");
                System.out.println("(2) Add Product Chocolate");
                System.out.print("Selection:");

                // Read the user's choice from the console.
                int choice = scanner.nextInt();

                // Check the user's choice and execute the corresponding action.
                if (choice == 1) {
                    // If the user chose option 1, list all employees (products).
                    for (Product product : simpleProductDao.getAll()) {
                        System.out.println(product);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                } else if (choice == 2) {
                    // If the user chose option 2, add a new employee (product) and then list all employees.
                    simpleProductDao.add(new Product(5, "Chocolate", "Candy", 5.99));
                    for (Product product : simpleProductDao.getAll()) {
                        System.out.println(product);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                } else if (choice == 3) {
                    System.out.println("\nExiting");
                    running = false;
                } else {
                    // If the user's choice is not valid, print an error message.
                    System.out.println("\n!!! Error !!!");
                }
            }
        }
    }

