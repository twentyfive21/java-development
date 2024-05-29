package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

public class Main {
    // declare scanner globally for use
    static Scanner scanner = new Scanner(System.in);
    // create the data manager
    static ShipperDataManager dataManager = null;

    // main method
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

                dataManager = new ShipperDataManager(dataSource);

                // interact with database
                String choice = scanner.nextLine();
                switch (choice){
                    case "1" : addNewShipper(dataSource);
                        break;
                    case "2" : updateShipper(dataSource);
                        break;
                    case "3" : deleteShipper(dataSource);
                        break;
                    case "4" : dataManager.displayAllShippers(dataSource);
                        break;
                    case "5" : System.out.println("~~~~~~~~~ Exiting ~~~~~~~~~~~~");
                        running = false;
                        break;
                    default: System.out.println("Invalid input");
                        break;
                }


            }

        }

        public static  void addNewShipper(DataSource dataSource){
            System.out.print("! You have chosen to add a company ! ");
            System.out.print("Name of Company: ");
            String companyName = scanner.nextLine().trim();
            System.out.print("Phone number: ");
            String phoneNumber = scanner.nextLine().trim();
            ShipperDataManager.createShipper(dataSource,companyName,phoneNumber);
            ShipperDataManager.displayAllShippers(dataSource);
        }

        public static void updateShipper(DataSource dataSource){
            System.out.print("! You have chosen to update a company number ! ");
            System.out.print("Enter ID of company: ");
            String id = scanner.nextLine().trim();
            System.out.print("Enter current phone number: ");
            String phone = scanner.nextLine().trim();
            System.out.print("Enter new number: ");
            String newNumber = scanner.nextLine().trim();
            ShipperDataManager.updateShipper(dataSource,id,phone,newNumber);
            ShipperDataManager.displayAllShippers(dataSource);
        }

        public static void deleteShipper(DataSource dataSource){
            System.out.print("! You have chosen to delete a company ! ");
            System.out.print("Enter ID of company: ");
            String id = scanner.nextLine().trim();
            ShipperDataManager.deleteShipper(dataSource,id);
            ShipperDataManager.displayAllShippers(dataSource);
        }

    public static void beginningPrompts(){
        System.out.println("\n~~~ DO NOT DELETE ID'S 1-3 workbook said not to ~~~~");
        System.out.println("\n~~~ Welcome to the Shipper information desk ~~~~");
        System.out.println("(1) Add new shipper");
        System.out.println("(2) Update shipper");
        System.out.println("(3) Delete shipper");
        System.out.println("(4) Display all shippers");
        System.out.println("(5) Exit");
        System.out.print("Selection: ");

    }
}
