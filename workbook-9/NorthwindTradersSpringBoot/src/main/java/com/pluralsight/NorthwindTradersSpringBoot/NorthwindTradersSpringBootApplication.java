package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

// This annotation marks the class as a Spring Boot application.
@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	// The main method serves as the entry point of the application.
	public static void main(String[] args) {
		// SpringApplication.run() starts the Spring Boot application and returns the ApplicationContext.
		ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);

		// Retrieve the SimpleProductDao bean from the ApplicationContext.
		SimpleProductDao simpleProductDao = context.getBean(SimpleProductDao.class);

		// Create a Scanner object to read user input from the console.
		Scanner scanner = new Scanner(System.in);

		boolean running = true;
		while (running) {
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
				// If the user chose option 1, list all products.
				for (Product product : simpleProductDao.getAll()) {
					System.out.println(product);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				}
			} else if (choice == 2) {
				// If the user chose option 2, add a new product and then list all products.
				simpleProductDao.add(new Product(5, "Chocolate", "Candy", 5.99));
				for (Product product : simpleProductDao.getAll()) {
					System.out.println(product);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				}
			} else if (choice == 3) {
				// If the user chose option 3, exit the application.
				System.out.println("\nExiting");
				running = false;
			} else {
				// If the user's choice is not valid, print an error message.
				System.out.println("\n!!! Error !!!");
			}
		}
	}
}



