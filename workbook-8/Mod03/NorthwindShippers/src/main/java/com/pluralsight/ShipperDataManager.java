package com.pluralsight;

import javax.sql.DataSource;
import java.sql.*;

public class ShipperDataManager {

    private DataSource dataSource;
    public ShipperDataManager(DataSource dataSource){
        this.dataSource = dataSource;
    }

    // display all shippers
    public static void displayAllShippers(DataSource dataSource){
        try{

            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM northwind.Shippers;")
            ){
                try (
                        ResultSet resultSet = preparedStatement.executeQuery();
                ){
                    // use the first call to next() to see if there are records
                    if (resultSet.next()) {
                        System.out.printf("\n************* Shipping Companies ****************\n");
                        // if there are, you are already sitting on the first one so
                        // switch your loop to using a do/while
                        do {
                            String shipperID = resultSet.getString("ShipperID");
                            String companyName = resultSet.getString("CompanyName");
                            String phone = resultSet.getString("Phone");
                            // Display the customer information
                            System.out.printf("Shipper Info:\n" +
                                            "Shipper ID: %s\n" +
                                            "Company Name: %s\n" +
                                            "Phone : %s\n" +
                                            "-------------------------------------------\n"
                                    ,shipperID,companyName,phone);
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
    // create new shipper get name and phone then display id after insert
    public static void createShipper(DataSource dataSource, String companyName, String phone){
        try{

            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Shippers (CompanyName, Phone) \n" +
                         " VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS)
            ){
                preparedStatement.setString(1, companyName);
                preparedStatement.setString(2, phone);
                int rows = preparedStatement.executeUpdate();
                // confirm the update
                System.out.printf("Rows updated %d\n", rows);
                try (
                        ResultSet keys = preparedStatement.getGeneratedKeys()
                ){
                    // use the first call to next() to see if there are records
                    // Iterate through the primary keys that were generated
                    while (keys.next()) {
                        System.out.printf("Shipper ID : %d key was added\n",
                                keys.getLong(1));
                    }
                }
            }

        } catch(SQLException e){
            // This will catch all SQLExceptions occurring in the
            // block including those in nested try statements
            e.printStackTrace();
        }
    }
    //  change phone number of a shipper enter id and phone number for search
    public static void updateShipper(DataSource dataSource, String id, String phone, String newNumber){
        try{

            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement =
                         connection.prepareStatement("UPDATE Shippers SET Phone = ? " +
                                 "WHERE ShipperID = ? AND Phone = ?")
            ){
                preparedStatement.setString(1, newNumber);
                preparedStatement.setString(2, id);
                preparedStatement.setString(3, phone);

                // Execute the preparedStatement
                int rows = preparedStatement.executeUpdate();
                // confirm the update
                System.out.printf("Rows updated %d\n", rows);
            }

        } catch(SQLException e){
            // This will catch all SQLExceptions occurring in the
            // block including those in nested try statements
            e.printStackTrace();
        }
    }
    // delete a shipper your shipper not 1-3 shippers
    public static void deleteShipper(DataSource dataSource, String id){
        try{

            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement =
                         connection.prepareStatement("DELETE FROM Shippers WHERE ShipperID = ?")
            ){
                preparedStatement.setString(1, id);

                // Execute the preparedStatement
                int rows = preparedStatement.executeUpdate();
                // confirm the update
                System.out.printf("Rows updated %d\n", rows);
            }

        } catch(SQLException e){
            // This will catch all SQLExceptions occurring in the
            // block including those in nested try statements
            e.printStackTrace();
        }
    }

}

