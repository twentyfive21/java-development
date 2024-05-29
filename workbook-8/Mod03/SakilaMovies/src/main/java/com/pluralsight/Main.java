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

            // create the data manager
            DataManager dataManager = new DataManager(dataSource);

            // interact with database
            // get user input for last name
            String lastNameOfActor = scanner.nextLine().trim();

            dataManager.searchByLastName(dataSource, lastNameOfActor);

            System.out.println("~~ Enter the first and last name of the actor you want to see movies of ~~");
            System.out.print("First name: ");
            String firstName = scanner.nextLine().trim();
            System.out.print("Last name: ");
            String lastName = scanner.nextLine().trim();
            dataManager.searchBy(dataSource,firstName,lastName);

            System.out.println("~~ Enter the ID of the actor you want to see movies of ~~");
            System.out.print("Actor id: ");
            String actorId = scanner.nextLine().trim();
            dataManager.searchBy(dataSource,actorId);
        }

    }


    public static void beginningPrompts(){
        System.out.println("\n~~~ Welcome to the movie information desk ~~~~");
        System.out.println("\n~~~ Please provide the last name of an actor you like ~~~~");
        System.out.print("Selection actor last name: ");
    }


}
