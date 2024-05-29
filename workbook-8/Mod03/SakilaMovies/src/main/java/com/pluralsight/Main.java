package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    // declare scanner globally for use
    static Scanner scanner = new Scanner(System.in);

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
            dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
            dataSource.setUsername("root");
            dataSource.setPassword("password");

            // get user input for last name
            String lastNameOfActor = scanner.nextLine().trim();

            try{

                try( // Database Connection: A connection to the MySQL database is established using Datasource
                     Connection connection = dataSource.getConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM sakila.actor WHERE last_name = ?")
                        ){
                    preparedStatement.setString(1, lastNameOfActor);
                    try (
                            ResultSet resultSet = preparedStatement.executeQuery();
                            ){
                        // use the first call to next() to see if there are records
                        if (resultSet.next()) {
                            System.out.printf("\n************* Actors matching %s ****************\n", lastNameOfActor);
                            // if there are, you are already sitting on the first one so
                            // switch your loop to using a do/while
                            do {
                                String actorID = resultSet.getString("actor_id");
                                String firstName = resultSet.getString("first_name");
                                String lastName = resultSet.getString("last_name");
                                // Display the customer information
                                System.out.printf("Actor Info:\n" +
                                                "Actor ID: %s\n" +
                                                "First Name: %s\n" +
                                                "Last Name: %s\n" +
                                                "-------------------------------------------\n"
                                        ,actorID,firstName,lastName);
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

    public static void beginningPrompts(){
        System.out.println("\n~~~ Welcome to the movie information desk ~~~~");
        System.out.println("\n~~~ Please provide the last name of an actor you like ~~~~");
        System.out.print("Selection actor last name: ");
    }


}
