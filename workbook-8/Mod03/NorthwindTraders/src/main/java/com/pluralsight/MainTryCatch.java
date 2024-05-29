package com.pluralsight;
import java.sql.*;

import java.sql.SQLException;
import java.util.Scanner;

public class MainTryCatch {

    public static void main(String[] args) {
        // Variable Initialization: Variables for the Connection, PreparedStatement, and ResultSet are initialized to null
        // outside the try block to ensure they are accessible in the finally block for proper resource cleanup.
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // Create a Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);
        // User Input: The program prompts the user to select an option
        System.out.print("What do you want to do?\n" +
                "1) Display all products\n" +
                "2) Display all customers\n" +
                "0) Exit\n" +
                "Select an option:");
        String choice = scanner.nextLine().trim();
        try{
            // Loading JDBC Driver: The MySQL JDBC driver is loaded
             Class.forName("com.mysql.cj.jdbc.Driver");
            // Database Connection: A connection to the MySQL database is established using the DriverManager
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind", "root", "password");

            String query = "";
            String dataBaseChoice = "";
            // SQL Query Selection: Based on user input, the appropriate SQL query is chosen
           switch (choice){
               case "1" : query = "SELECT * FROM Products";
                        dataBaseChoice = "products";
                    break;
               case "2": query = "SELECT * FROM Customers";
                   dataBaseChoice = "customers";
                    break;
               case "3" : System.out.println("Goodbye");
                    return;
               default: System.out.println("Error invalid input");
                    break;
           }
            // Preparing and Executing SQL: The SQL query is prepared and executed
            preparedStatement = connection.prepareStatement(query);

           resultSet = preparedStatement.executeQuery();

            // Processing Result Set: The result set is processed,
            // and data is printed based on whether products or customers were selected
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
           }


        }catch (SQLException | ClassNotFoundException e){
            // Exception Handling: Exceptions are caught and printed
            e.printStackTrace();
        }finally {
            // Resource Cleanup: Resources (ResultSet, PreparedStatement, and Connection) are closed in the finally block
            // to ensure they are closed even if an exception occurs
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
