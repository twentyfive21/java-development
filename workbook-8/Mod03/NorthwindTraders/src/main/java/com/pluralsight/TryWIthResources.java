package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class TryWIthResources {

    public static void main(String[] args) throws ClassNotFoundException {

        // Create a Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);
        // User Input: The program prompts the user to select an option
        System.out.print("What do you want to do?\n" +
                "1) Display all products\n" +
                "2) Display all customers\n" +
                "3) Display all categories\n" +
                "0) Exit\n" +
                "Select an option:");
        String choice = scanner.nextLine().trim();

        String query ="";
        String dataBaseChoice = "";
        // SQL Query Selection: Based on user input, the appropriate SQL query is chosen
        switch (choice){
            case "1" : query = "SELECT * FROM northwind.Products";
                dataBaseChoice = "products";
                break;
            case "2": query = "SELECT * FROM northwind.Customers ORDER BY Country";
                dataBaseChoice = "customers";
                break;
            case "3" : query = "SELECT CategoryID,CategoryName FROM northwind.Categories ORDER BY CategoryID";
                dataBaseChoice = "category";
                break;
            case "0" : System.out.println("Goodbye");
                return;
            default: System.out.println("Error invalid input");
                break;
        }

        // Loading JDBC Driver: The MySQL JDBC driver is loaded
        Class.forName("com.mysql.cj.jdbc.Driver");

        // create the connection and prepared statement in a
        // try-with-resources block
        try{

            try (  // Database Connection: A connection to the MySQL database is established using the DriverManager
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/northwind", "root", "password");
                   PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ){

                try (
                        ResultSet resultSet =  preparedStatement.executeQuery();
                ){
                        if(dataBaseChoice.equals("products")){
                            while (resultSet.next()){
                                // Retrieve data by column index and column name
                                // do by column number counting starts by 1
                                String productID = resultSet.getString(1);
                                String productName = resultSet.getString("ProductName");
                                Double unitPrice = resultSet.getDouble("UnitPrice");
                                String inStock = resultSet.getString("UnitsInStock");
                                // Display the product information
                                System.out.printf("Product Id: %s \n" +
                                                "Name: %s\n" +
                                                "Price: %,.2f\n" +
                                                "Stock: %s\n" +
                                                "-------------------------------------------\n"
                                        ,productID,productName,unitPrice,inStock);
                            }
                        } else if (dataBaseChoice.equals("customers")){
                            while (resultSet.next()){
                                String contactName = resultSet.getString("ContactName");
                                String companyName = resultSet.getString("CompanyName");
                                String city = resultSet.getString("City");
                                String country = resultSet.getString("Country");
                                String phone = resultSet.getString("Phone");
                                // Display the customer information
                                System.out.printf("Customer Info:  \n" +
                                                "Contact Name: %s\n" +
                                                "Company Name: %s\n" +
                                                "City: %s\n" +
                                                "Country: %s\n" +
                                                "Phone : %s\n" +
                                                "-------------------------------------------\n"
                                        ,contactName,companyName,city,country,phone);
                            }
                        } else {
                            while (resultSet.next()){
                                String contactName = resultSet.getString("ContactName");
                                String companyName = resultSet.getString("CompanyName");
                                String city = resultSet.getString("City");
                                String country = resultSet.getString("Country");
                                String phone = resultSet.getString("Phone");
                                // Display the customer information
                                System.out.printf("Customer Info:  \n" +
                                                "Contact Name: %s\n" +
                                                "Company Name: %s\n" +
                                                "City: %s\n" +
                                                "Country: %s\n" +
                                                "Phone : %s\n" +
                                                "-------------------------------------------\n"
                                        ,contactName,companyName,city,country,phone);
                    }
                            // let user pick category

                }
            }
    }
        }catch (SQLException e){
            // This will catch all SQLExceptions occurring in the
            // block including those in nested try statements
            e.printStackTrace();
        }
}}
