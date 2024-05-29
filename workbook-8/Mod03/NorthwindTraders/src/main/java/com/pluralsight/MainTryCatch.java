package com.pluralsight;
import java.sql.*;

import java.sql.SQLException;
import java.util.Scanner;

public class MainTryCatch {

    public static void main(String[] args) {
        // Establish the variables with null outside the try scope
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Scanner scanner = new Scanner(System.in);

        System.out.print("What do you want to do?\n" +
                "1) Display all products\n" +
                "2) Display all customers\n" +
                "0) Exit\n" +
                "Select an option:");
        String choice = scanner.nextLine().trim();
        try{
            // load driver
             Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind", "root", "password");

            String query = "";
            String dataBaseChoice = "";

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
            preparedStatement = connection.prepareStatement(query);

           resultSet = preparedStatement.executeQuery();


           if(dataBaseChoice.equals("products")){
               while (resultSet.next()){
                   // do by column number counting starts by 1
                   String productID = resultSet.getString(1);
                   String productName = resultSet.getString("ProductName");
                   Double unitPrice = resultSet.getDouble("UnitPrice");
                   String inStock = resultSet.getString("UnitsInStock");
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
            e.printStackTrace();
        }finally {
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
