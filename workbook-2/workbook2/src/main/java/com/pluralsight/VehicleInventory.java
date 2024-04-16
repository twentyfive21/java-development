package com.pluralsight;
import java.util.Scanner;
//import java.util.Arrays;

public class VehicleInventory {
    static int amountOfCars = 6;
    public static void main(String[] args) {
        // create an array with 20 vehicles
        Vehicle[] carsArray = new Vehicle[20];
        setArray(carsArray);
        getUserInfo(carsArray);
    }
    // ~~~~~~~~~~~~~~ pre-set the array with 6 values ~~~~~~~~~~~~~~~
    public static void setArray (Vehicle[] carsArray) {
        carsArray[0] = new Vehicle(101121,"Ford Explorer",
                "Red",45000,13500);
        carsArray[1] = new Vehicle(101122,"Toyota Camry",
                "Blue",60000,11000);
        carsArray[2] = new Vehicle(101123,"Chevrolet Malibu",
                "Black",50000,9700);
        carsArray[3] = new Vehicle(101124,"Honda Civic",
                "White",70000,7500);
        carsArray[4] = new Vehicle(101125,"Subaru Outback",
                "Green",55000,14500);
        carsArray[5] = new Vehicle(101126,"Jeep Wrangler",
                "Yellow",30000,16000);
    }
    // ~~~~~~~~~ get users car information ~~~~~~~~
    public static void getUserInfo(Vehicle[] carsArray) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"\n What do you want to do?"," 1 - List all vehicles", " 2 - Search by make/model",
        " 3 - Search by price range", " 4 - Search by color"," 5 - Add a vehicle", " 6 - Quit \n"};
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Enter your command: ");
        int selection = scanner.nextInt();
        scanner.nextLine();
        // TODO 2,5 first
        // TODO  2 - Search by make/model
        // TODO  3 - Search by price range
        // TODO 4 - Search by color
        // TODO 5 - Add a vehicle

        // ~~~~ cases to call based on users choice ~~~~
        switch (selection) {
            case 1 : listCars(carsArray);
            break;
            case 2: searchfor(carsArray, scanner);
            break;
            case 3: System.out.print("searchByPrice");
            break;
            case 4: System.out.print("searchByColor");
            break;
            case 5: System.out.print("addVehicle");
            break;
            case 6: quitProgram();
            break;
            default: System.out.println("Error please pick a valid option!");
                    getUserInfo(carsArray);
        }
        // clear buffer for next input
    }
    // ~~~~~~~~~~~ quit program method ~~~~~
    public static void quitProgram() {
        System.out.println("You have chosen to leave. \n" +
                "Please come again and we hope you enjoyed our services!");
        System.out.println("Have a nice day! :)");
    }
    // ~~~~~~~~~~~ list all cars method ~~~~
    public static void listCars(Vehicle[] carsArray) {
        System.out.println("You have selected the all vehicles option: ");
        // if vehicle is null do not display
        for (Vehicle vehicle : carsArray) {
            if (vehicle != null) {
                System.out.println(vehicle);
            }
        }
    }
    // ~~~~~~~~~~ search for make and model method ~~~~~
    public static void searchfor(Vehicle[] carsArray, Scanner scanner){
        System.out.print("Provide the make/model: ");

        String searchInput = scanner.nextLine().toLowerCase();
        searchInput= searchInput.trim();
        System.out.println(searchInput);
        for (int i = 0; i < carsArray.length; i++) {
            if (carsArray[i] != null &&
                    carsArray[i].getMakeModel().toLowerCase().contains(searchInput)) {
                    System.out.println(carsArray[i]);
            }
        }
    }

}