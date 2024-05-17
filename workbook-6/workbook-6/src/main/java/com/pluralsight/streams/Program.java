package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static void getUserInput(){
        while (true){
        System.out.println();
        System.out.println("~~~~ Please select a option below ~~~~");
        System.out.println("(0) View all names");
        System.out.println("(1) Search for first or last name");
        System.out.println("(2) Display oldest age");
        System.out.println("(3) Display youngest age");
        System.out.println("(4) Exit");
        System.out.print("Selection: ");
        // get user choice for filtering
        String choice = scanner.nextLine();

            switch (choice){
                case "0":  viewNames();
                    break;
                case "1":  getName();
                    break;
                case "2" : getAge("old");
                    break;
                case "3" : getAge("young");
                    break;
                case "4" : System.out.println("Exiting ...");
                    return;
                default: System.out.println("Error pick a valid choice");
                    break;
            }
        }
    }

    public static void getName(){
        // let user pick first or last name
        System.out.println("Select (1) first name & (2) for last name");
        System.out.print("Selection: ");
        String choice = scanner.nextLine().trim();
        int type = 0;
        switch (choice){
            case "1": type = 1;
                break;
            case "2" : type = 0;
                break;
            default: System.out.println("Error pick a valid choice");
                break;
        }
        System.out.print("Please provide the name: ");
        String name = scanner.nextLine().trim().toLowerCase();
        // search for last name
        if(type == 0){
            for(Person person : people){
                if(person.getLastName().toLowerCase().contains(name)){
                    System.out.println(person);
                }

            }
        } else {
            // search for first name
            for(Person person : people){
                if(person.getFirstName().toLowerCase().contains(name)){
                    System.out.println(person);
                }

            }
        }
    }

    public static int getAge(String age){
        int startAge = 0;
        int ageMatch = 0;
        String sentence;

        System.out.println();
        // check for oldest age
        if(age.equals("old")){
            sentence = " is the oldest age";
            for(Person person : people){
                if (person.getAge() > startAge){
                    ageMatch = person.getAge();
                    startAge = ageMatch;
                }
            }
        } else {
            // check for youngest age
            sentence = " is the youngest age";
            startAge = 150;
            for(Person person : people){
                if (person.getAge() < startAge){
                    ageMatch = person.getAge();
                    startAge = ageMatch;
                }
            }
        }
        System.out.println(ageMatch + sentence);
        return ageMatch;
    }

    public static void viewNames(){
    // display all available people
        for (Person person : people){
            System.out.println("~~~~~~~~~~~~~~~~~~~");
            System.out.println(person);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~");
    }
    public static void loadUsers(){
        // create person objects
        Person person1 = new Person("Tim", "Baker", 80);
        Person person2 = new Person("Timmy", "William", 18);
        Person person3 = new Person("Kathy", "Baker", 45);
        Person person4 = new Person("Lily", "Morton", 15);
        Person person5 = new Person("John", "Gold", 45);
        Person person6 = new Person("Tina", "Nguyen", 20);
        Person person7 = new Person("Michael", "Zane", 24);
        Person person8 = new Person("Glenn", "Cash", 34);
        Person person9 = new Person("Melody", "Collins", 53);
        Person person10 = new Person("Zachery", "Peter", 34);
        // add to array
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);
        people.add(person8);
        people.add(person9);
        people.add(person10);
    }
}
