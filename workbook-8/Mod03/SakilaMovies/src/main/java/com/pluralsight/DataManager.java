package com.pluralsight;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataManager {

    private DataSource dataSource;
    public DataManager(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public static void searchByLastName(DataSource dataSource, String lastNameOfActor){
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

    public static void searchBy(DataSource dataSource, String firstName, String lastName){
        try{

            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement =
                         connection.prepareStatement("SELECT film.film_id,film.title,film.description,film.release_year FROM sakila.film\n" +
                                 "JOIN film_actor ON film_actor.film_id = film.film_id\n" +
                                 "JOIN actor ON actor.actor_id = film_actor.actor_id WHERE actor.first_name = ? AND actor.last_name = ? ")
            ){
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                try (
                        ResultSet resultSet = preparedStatement.executeQuery();
                ){
                    // use the first call to next() to see if there are records
                    if (resultSet.next()) {
                        System.out.printf("\n************* Movies %s %s is in****************\n", firstName, lastName);
                        // if there are, you are already sitting on the first one so
                        // switch your loop to using a do/while
                        do {
                            String filmId = resultSet.getString("film_id");
                            String title = resultSet.getString("title");
                            String description = resultSet.getString("description");
                            String releaseYear = resultSet.getString("release_year");
                            // Display the customer information
                            System.out.printf("Movie Info:\n" +
                                            "Film ID: %s\n" +
                                            "Title : %s\n" +
                                            "Description: %s\n" +
                                            "Release year: %s\n" +
                                            "-------------------------------------------\n"
                                    ,filmId,title,description,releaseYear);
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
    public static void searchBy(DataSource dataSource, String id){
        try{

            try( // Database Connection: A connection to the MySQL database is established using Datasource
                 Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement =
                         connection.prepareStatement("SELECT film.film_id,film.title,film.description,film.release_year, film.length FROM sakila.film\n" +
                                 "JOIN film_actor ON film_actor.film_id = film.film_id\n" +
                                 "JOIN actor ON actor.actor_id = film_actor.actor_id WHERE actor.actor_id = ? ")
            ){
                preparedStatement.setString(1, id);
                try (
                        ResultSet resultSet = preparedStatement.executeQuery();
                ){
                    // use the first call to next() to see if there are records
                    if (resultSet.next()) {
                        System.out.printf("\n************* Movies actor id : %s is in ****************\n", id);
                        // if there are, you are already sitting on the first one so
                        // switch your loop to using a do/while
                        do {
                            String filmId = resultSet.getString("film_id");
                            String title = resultSet.getString("title");
                            String description = resultSet.getString("description");
                            String releaseYear = resultSet.getString("release_year");
                            String length= resultSet.getString("length");
                            // Display the customer information
                            System.out.printf("Movie Info:\n" +
                                            "Film ID: %s\n" +
                                            "Title : %s\n" +
                                            "Description: %s\n" +
                                            "Release year: %s\n" +
                                            "Length: %s\n" +
                                            "-------------------------------------------\n"
                                    ,filmId,title,description,releaseYear, length);
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
