package com.pluralsight;
import java.util.Scanner;

public class FullNameParser {

    // main method
    public static void main(String[] args) {
        getUserInfo();
    }

    //get users info method
    public static void getUserInfo () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter your name: ");
        String fullName = scanner.nextLine().trim();

        if (fullName.isEmpty()) {
            System.out.println("Error nothing was provided please enter your name!");
            getUserInfo();
        } else {
            formatName(fullName);
        }
    }

    //  display the users information method
    public static void formatName (String fullName) {
        String space = " ";
        // split the string at each space and return into the splitName array
        String[] splitName = fullName.split(space);

        // declare variables and set middle name to default if none is given
        if (splitName.length == 3) {
            splitName[0] = splitName[0].substring(0,1).toUpperCase() + splitName[0].substring(1);
            splitName[1] = splitName[1].substring(0,1).toUpperCase() + ".";
            splitName[2] =  splitName[2].substring(0,1).toUpperCase() + splitName[2].substring(1);
        } else {
            splitName[0] = splitName[0].substring(0,1).toUpperCase() + splitName[0].substring(1);
            splitName[1] =  splitName[1].substring(0,1).toUpperCase() + splitName[1].substring(1);
        }
        // call display name method with values
        displayName(splitName);
    }

    public static void displayName (String[] splitName) {
        System.out.println("Here is your name split ! ");
        if (splitName.length == 3) {
            System.out.printf("First name: %s \n", splitName[0]);
            System.out.printf("Middle name: %s \n", splitName[1]);
            System.out.printf("Last name: %s \n", splitName[2]);
        } else {
            System.out.printf("First name: %s \n", splitName[0]);
            System.out.println("Middle name: (none)");
            System.out.printf("Last name: %s \n", splitName[1]);
        }
        System.out.println("Thank you and come again ! ");
    }

}
