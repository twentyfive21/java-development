package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class Main {
    // declare scanner globally for use
    static Scanner scanner = new Scanner(System.in);
    // create the data manager
    static DataManager dataManager = null;

    public static void main(String[] args) {
        // keep program running till set to exit
        boolean running = true;
        // start of entire while
        while (running){
            // display beginning messages
            beginningPrompts();
            // data source to generate connections instead of drive manager
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
            dataSource.setUsername("root");
            dataSource.setPassword("password");

            dataManager = new DataManager(dataSource);

            // interact with database
            String choice = scanner.nextLine();
            switch (choice){
                case "1" : getOrderHistoryCustomer(dataSource);
                    break;
                case "2" : getSalesByYear(dataSource);
                    break;
                case "3" : getSalesByCategory(dataSource);
                    break;
                case "4" : System.out.println("~~~~~~~~~~~~ Exiting ~~~~~~~~~~~~");
                    running = false;
                    break;
                default: System.out.println("Invalid input");
                    break;
            }


        }
    }

    private static void getSalesByCategory(BasicDataSource dataSource) {
        System.out.print("! You have chosen to view customer order history ! ");
        System.out.print("Enter Category name: ");
        String category = scanner.nextLine().trim();
        System.out.print("Enter year (2000): ");
        String year = scanner.nextLine().trim();
        DataManager.getCategoriesFromData(dataSource,category,year);
    }

    private static void getSalesByYear(BasicDataSource dataSource) {
        // 1996-07-04 00:00:00
        // 1996-07-10 00:00:00
        System.out.print("! You have chosen to view sales by year ! ");
        System.out.print("Enter start date (1996-07-10): ");
        String startDate= scanner.nextLine().trim();
        System.out.print("Enter end date (1996-07-10): ");
        String endDate = scanner.nextLine().trim();
        DataManager.getSalesByYearData(dataSource,startDate,endDate);
    }

    private static void getOrderHistoryCustomer(BasicDataSource dataSource) {
        System.out.print("! You have chosen to view customer order history ! ");
        System.out.print("Enter ID of customer: ");
        String id = scanner.nextLine().trim();
        DataManager.getCustomerHistory(dataSource,id);
        // ShipperDataManager.displayAllShippers(dataSource);
    }


    public static void beginningPrompts(){
        System.out.println("\n~~~ Welcome to the Procedures information desk ~~~~");
        System.out.println("(1) View customer order history");
        System.out.println("(2) Search for sales by year");
        System.out.println("(3) Search for sales by category");
        System.out.println("(4) Exit");
        System.out.print("Selection: ");

    }
}
