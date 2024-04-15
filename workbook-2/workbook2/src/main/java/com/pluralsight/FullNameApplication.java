package com.pluralsight;
import java.util.Scanner;

public class FullNameApplication {

    // main method
    public static void main(String[] args) {
        getUserInfo();
    }

    // getting user input
    public static void getUserInfo () {
        // trim strings white space before assigning to variable
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name ");
        System.out.print("First name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Middle name: ");
        String middleName = scanner.nextLine().trim();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Suffix : ");
        String suffix = scanner.nextLine().trim();

        // handle error if first and last name are not provided
        if(firstName.isEmpty() || lastName.isEmpty()) {
            System.out.println("Error must provide a first and last name!");
            getUserInfo();
        } else {
            formatName(firstName, middleName, lastName, suffix);
        }
    }

    public static void formatName (String firstName,String middleName,String lastName,String suffix) {
        // create String array to loop over
        String[] usersInfo= {firstName, middleName, lastName, suffix};
        // get only first letter of muddle name if it exists
        if (!usersInfo[1].isEmpty()) {
            usersInfo[1] = usersInfo[1].substring(0, 1);
        }
        // uppercase the first letter of each word
        for (int i = 0; i < usersInfo.length; i++) {
            if(!usersInfo[i].isEmpty()) {
                usersInfo[i] = usersInfo[i].substring(0,1).toUpperCase() + usersInfo[i].substring(1);
            }
        }
        // send over users name for printing
        displayName(usersInfo[0], usersInfo[1], usersInfo[2], usersInfo[3]);
    }

    // displaying users inputted name
    public static void displayName (String firstName, String middleName, String lastName, String suffix) {
        String space = " ";
        String firstLast = firstName + space + lastName;
        String noMiddle = firstName + space + lastName + ", " + suffix;
        String noSuffix = firstName + space + middleName + "." + space + lastName;
        String fullName = firstName + space + middleName + "." + space + lastName + ", " + suffix;

        if(middleName.isEmpty() && suffix.isEmpty()){
            System.out.println(firstLast);
        }else if(middleName.isEmpty()){
            System.out.println(noMiddle);
        }else if(suffix.isEmpty()){
            System.out.println(noSuffix);
        }else{
            System.out.println(fullName);
        }
    }
}