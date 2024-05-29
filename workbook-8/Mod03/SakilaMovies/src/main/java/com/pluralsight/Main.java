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
    // create the data manager
    static DataManager dataManager = null;
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

            dataManager = new DataManager(dataSource);

            // interact with database
            String choice = scanner.nextLine();
            switch (choice){
                case "1" : getLastNameInfo(dataSource);
                    break;
                case "2" : getFullNameInfo(dataSource);
                    break;
                case "3" : getByIdInfo(dataSource);
                    break;
                case "4" : System.out.println("~~~~~~~~~ Exiting ~~~~~~~~~~~~");
                            running = false;
                    break;
                default: System.out.println("Invalid input");
                    break;
            }


        }

    }


    public static void beginningPrompts(){
        System.out.println("\n~~~ Welcome to the movie information desk ~~~~");
        System.out.println("(1) Search by last name");
        System.out.println("(2) Search by full name");
        System.out.println("(3) Search by actor id");
        System.out.println("(4) Exit");
        System.out.print("Selection: ");

    }

    public static void getLastNameInfo(DataSource dataSource){
        // get user input for last name
        System.out.print("Selection actor last name: ");
        String lastNameOfActor = scanner.nextLine().trim();
        dataManager.searchByLastName(dataSource, lastNameOfActor);

    }

    public static void getFullNameInfo(DataSource dataSource){
        System.out.println("~~ Enter the first and last name of the actor you want to see movies of ~~");
        System.out.print("First name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine().trim();
        dataManager.searchBy(dataSource,firstName,lastName);
    }

    public static void getByIdInfo(DataSource dataSource){
        System.out.println("~~ Enter the ID of the actor you want to see movies of ~~");
        System.out.print("Actor id: ");
        String actorId = scanner.nextLine().trim();
        dataManager.searchBy(dataSource,actorId);
    }


}
