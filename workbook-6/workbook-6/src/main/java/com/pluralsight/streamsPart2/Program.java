package com.pluralsight.streamsPart2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    // create list object to store person
    static List<Person> people = new ArrayList<>();
    // create scanner to get user input
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // load all users in list
        loadUsers();
        getUserInput();

    }

    public static void getUserInput() {
        while (true) {
            System.out.println();
            System.out.println("~~~~ Please select a option below Stream 2 ~~~~");
            System.out.println("(0) View all names");
            System.out.println("(1) Search for first or last name");
            System.out.println("(2) Display oldest age");
            System.out.println("(3) Display youngest age");
            System.out.println("(4) Calculate average age ");
            System.out.println("(5) Exit");
            System.out.print("Selection: ");
            // get user choice for filtering
            String choice = scanner.nextLine();

            switch (choice) {
                case "0":
                    viewNames();
                    break;
                case "1":
                    getName();
                    break;
                case "2":
                    getAge("old");
                    break;
                case "3":
                    getAge("young");
                    break;
                case "4":
                    calculateAverageAge();
                    break;
                case "5":
                    System.out.println("Exiting ...");
                    return;
                default:
                    System.out.println("Error pick a valid choice");
                    break;
            }
        }
    }

    public static void getName() {
        // let user pick first or last name
        System.out.println("Select (1) first name & (2) for last name");
        System.out.print("Selection: ");
        String choice = scanner.nextLine().trim();
        int type = 0;
        switch (choice) {
            case "1":
                type = 1;
                break;
            case "2":
                type = 0;
                break;
            default:
                System.out.println("Error pick a valid choice");
                break;
        }
        System.out.print("Please provide the name: ");
        String name = scanner.nextLine().trim().toLowerCase();
        // search for last name
        System.out.println();
        if (type == 0) {
            List<Person> matchingNames = people.stream().filter(currentName ->
                    currentName.getLastName().toLowerCase().contains(name)).collect(Collectors.toList());
            matchingNames.forEach(lastName -> System.out.println(lastName + "\n"));

        } else {
            // search for first name
            List<Person> matchingNames = people.stream().filter(currentName ->
                    currentName.getFirstName().toLowerCase().contains(name)).collect(Collectors.toList());
            matchingNames.forEach(firstName -> System.out.println(firstName + "\n"));
        }
    }

    public static void getAge(String age) {

        String sentence;

        System.out.println();
        // check for oldest age
        if (age.equals("old")) {
            // TODO STREAMS WAY OLD AGE
        } else{
            // check for youngest age
            // TODO STREAMS WAY YOUNG
        }


    }


    public static void viewNames(){
    // display all available people
        // TODO STREAMS ALL NAMES
        people.forEach(name -> {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(name);
        });
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
    }
    public static void calculateAverageAge(){
        // display all available people
        // TODO STREAMS AVERAGE
    }
    public static void loadUsers(){
        // create Person objects & add to array
        people.add(new Person("Tim", "Baker", 80));
        people.add(new Person("Timmy", "William", 18));
        people.add(new Person("Kathy", "Baker", 45));
        people.add(new Person("Lily", "Morton", 15));
        people.add(new Person("John", "Gold", 45));
        people.add(new Person("Tina", "Nguyen", 20));
        people.add(new Person("Michael", "Zane", 24));
        people.add(new Person("Glenn", "Cash", 34));
        people.add(new Person("Melody", "Collins", 53));
        people.add(new Person("Zachery", "Peter", 34));
    }
}
