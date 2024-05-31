package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner {

    @Autowired
    private ProductDao productDao;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n!! Welcome !!");
            System.out.println("(1) List Products");
            System.out.println("(2) Add Product Chocolate");
            System.out.println("(3) Exit");
            System.out.print("Selection: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                for (Product product : productDao.getAll()) {
                    System.out.println(product);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            } else if (choice == 2) {
                productDao.add(new Product(5, "Chocolate", "Candy", 5.99));
                for (Product product : productDao.getAll()) {
                    System.out.println(product);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            } else if (choice == 3) {
                System.out.println("\nExiting");
                running = false;
            } else {
                System.out.println("\n!!! Error !!!");
            }
        }
    }
}

