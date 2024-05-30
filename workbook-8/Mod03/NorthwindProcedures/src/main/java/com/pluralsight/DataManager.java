package com.pluralsight;

import javax.sql.DataSource;
import java.sql.*;

public class DataManager {

    private DataSource dataSource;
    public DataManager(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public static void getCustomerHistory(DataSource dataSource, String customerID){
        try{
            String query = "{CALL CustOrderHist(?)}";
            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 // create the query, but surround it with { } and
                // use a ? for parameters

                 // Create the CallableStatement
                 CallableStatement stmt = connection.prepareCall(query);
            ){
                stmt.setString(1,customerID);
                try (
                        ResultSet resultSet = stmt.executeQuery();
                ){
                    // use the first call to next() to see if there are records
                    if (resultSet.next()) {
                        System.out.printf("\n************* Customer Order History ****************\n");
                        // if there are, you are already sitting on the first one so
                        // switch your loop to using a do/while
                        do {
                            String productName = resultSet.getString("ProductName");
                            String total = resultSet.getString("Total");
                            // Display the customer information
                            System.out.printf("Product Info:\n" +
                                            "Product name : %s\n" +
                                            "Total: %s\n" +
                                            "-------------------------------------------\n"
                                    ,productName,total);
                        } while (resultSet.next());
                    }
                    else {
                        System.out.println("No matches!");
                    }
                }
            }

        } catch(SQLException e){
            // This will catch all SQLExceptions occurring in the
            // block including those in nested try statements
            e.printStackTrace();
        }
    }


    public static void getSalesByYearData(DataSource dataSource, String startDate, String endDate){
        try{
            String query = "{CALL `Sales by Year`(?,?)}";
            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 // create the query, but surround it with { } and
                 // use a ? for parameters

                 // Create the CallableStatement
                 CallableStatement stmt = connection.prepareCall(query);
            ){
                stmt.setString(1,startDate);
                stmt.setString(2,endDate);
                try (
                        ResultSet resultSet = stmt.executeQuery();
                ){
                    // use the first call to next() to see if there are records
                    if (resultSet.next()) {
                        System.out.printf("\n************* Sales by year ****************\n");
                        // if there are, you are already sitting on the first one so
                        // switch your loop to using a do/while
                        do {
                            String shippedDate = resultSet.getString("ShippedDate");
                            String year = resultSet.getString("Year");
                            String orderID = resultSet.getString("OrderID");
                            Double subtotal = resultSet.getDouble("Subtotal");
                            // Display the customer information
                            System.out.printf("Sales Info:\n" +
                                            "Order ID : %s\n" +
                                            "Year %s\n" +
                                            "Shipped date %s\n" +
                                            "Subtotal %,.2f\n" +
                                            "-------------------------------------------\n"
                                    ,orderID,year,shippedDate,subtotal);
                        } while (resultSet.next());
                    }
                    else {
                        System.out.println("No matches!");
                    }
                }
            }

        } catch(SQLException e){
            // This will catch all SQLExceptions occurring in the
            // block including those in nested try statements
            e.printStackTrace();
        }
    }

    public static void getCategoriesFromData(DataSource dataSource, String category, String year){
        try{
            String query = "{CALL SalesByCategory(?,?)}";
            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 // create the query, but surround it with { } and
                 // Create the CallableStatement
                 CallableStatement stmt = connection.prepareCall(query);
            ){
                stmt.setString(1,category);
                stmt.setString(2,year);
                try (
                        ResultSet resultSet = stmt.executeQuery();
                ){
                    // use the first call to next() to see if there are records
                    if (resultSet.next()) {
                        System.out.printf("\n************* Sales by year ****************\n");
                        // if there are, you are already sitting on the first one so
                        // switch your loop to using a do/while
                        do {
                            String productName = resultSet.getString("ProductName");
                            String totalPurchase = resultSet.getString("TotalPurchase");
                            // Display the customer information
                            System.out.printf("Category Info:\n" +
                                            "Product name : %s\n" +
                                            "Total Purchase %s\n" +
                                            "-------------------------------------------\n"
                                    ,productName,totalPurchase);
                        } while (resultSet.next());
                    }
                    else {
                        System.out.println("No matches!");
                    }
                }
            }

        } catch(SQLException e){
            // This will catch all SQLExceptions occurring in the
            // block including those in nested try statements
            e.printStackTrace();
        }
    }

    // get DATA for user
    public static void displayCategories(DataSource dataSource){
        try{

            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT CategoryName,Description FROM northwind.Categories")
            ){
                try (
                        ResultSet resultSet = preparedStatement.executeQuery();
                ){
                    // use the first call to next() to see if there are records
                    if (resultSet.next()) {
                        System.out.printf("\n************* Categories ****************\n");
                        // if there are, you are already sitting on the first one so
                        // switch your loop to using a do/while
                        do {
                            String categoryName= resultSet.getString("CategoryName");
                            String description = resultSet.getString("Description");
                            // Display the customer information
                            System.out.printf("Category Info:\n" +
                                            "Category name: %s\n" +
                                            "Description: %s\n" +
                                            "-------------------------------------------\n"
                                    ,categoryName,description);
                        } while (resultSet.next());
                    }
                    else {
                        System.out.println("No matches!");
                    }
                }
            }

        } catch(SQLException e){
            // This will catch all SQLExceptions occurring in the
            // block including those in nested try statements
            e.printStackTrace();
        }
    }

    public static void displayCustomerID(DataSource dataSource){
        try{

            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT CustomerID,CompanyName,ContactName FROM northwind.Customers")
            ){
                try (
                        ResultSet resultSet = preparedStatement.executeQuery();
                ){
                    // use the first call to next() to see if there are records
                    if (resultSet.next()) {
                        System.out.printf("\n************* Customers Info ****************\n");
                        // if there are, you are already sitting on the first one so
                        // switch your loop to using a do/while
                        do {
                            String customerID = resultSet.getString("CustomerID");
                            String companyName = resultSet.getString("CompanyName");
                            String contactName = resultSet.getString("ContactName");
                            // Display the customer information
                            System.out.printf("Customer Info:\n" +
                                            "Customer ID: %s\n" +
                                            "Company name: %s\n" +
                                            "Contact name: %s\n" +
                                            "-------------------------------------------\n"
                                    ,customerID,companyName,contactName);
                        } while (resultSet.next());
                    }
                    else {
                        System.out.println("No matches!");
                    }
                }
            }

        } catch(SQLException e){
            // This will catch all SQLExceptions occurring in the
            // block including those in nested try statements
            e.printStackTrace();
        }
    }

}
