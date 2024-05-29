package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // load the MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 1. open a connection to the database
        // use the database URL to point to the correct database
        Connection connection;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind", "root", "password");
        // create statement
        // the statement is tied to the open connection
        Statement statement = connection.createStatement();
        // define your query
        String query = "SELECT * FROM Products";
        // 2. Execute your query
        ResultSet results = statement.executeQuery(query);
        // process the results
        System.out.println("-------------------------------------------");
        while (results.next()) {
            // do by column number counting starts by 1
            String productID = results.getString(1);
            String productName = results.getString("ProductName");
            Double unitPrice = results.getDouble("UnitPrice");
            String inStock = results.getString("UnitsInStock");
            System.out.printf("Product Id: %s \n" +
                    "Name: %s\n" +
                    "Price: %,.2f\n" +
                    "Stock: %s\n" +
                    "-------------------------------------------\n"
                    ,productID,productName,unitPrice,inStock);
        }
    // Close the connection always close in reverse not FIFO do LIFO
        connection.close();
        statement.close();
        results.close();
    }
}
