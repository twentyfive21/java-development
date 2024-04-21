package Mod01;
//The Scanner class from the java.io package can be used to read a file
import java.io.*;
import java.util.Scanner;

public class BedtimeStories {

    public static void main(String[] args) {

        // initialize scanner to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please pick a number for which story you would like! \n"
                +"(1) Goldilocks\n(2) Hansel & Gretel\n" +
                "(3) Mary had a little lamb\n" +
                "Selection: " );
        String selection = scanner.nextLine();

        // switch cases for all 3 stories and handles error if valid option not chosen
        switch(selection){
            case "1": selection = "goldilocks.txt";
                break;
            case "2": selection = "hansel_and_gretel.txt";
                break;
            case "3": selection = "mary_had_a_little_lamb.txt";
                break;
            default: System.out.println("Please choose a number from 1-3!");
        }

        //try to find the file to read and print out in the command line
        try{// create a FileInputStream object pointing to a specific file
            // give path to file input, so it can find the txt file
            FileInputStream fis = new FileInputStream("/Users/tina/" +
                    "pluralsight/java-development/workbook-3/workbook" +
                    "-3/src/main/java/Mod01/" + selection);
            // create a Scanner to reference the file to be read
            /* When you create a Scanner, have it reference a file by
            wrapping the name of the file inside a FileInputStream
            object and passing that to the Scanner constructor */
            Scanner scannerText = new Scanner(fis);
            String input;
            // read until there is no more data
            // hasNextLine() method returns true if there are more lines in the file
            // With nextLine(), you can read a line of text from the file
            int lineCounter = 1;
            while(scannerText.hasNextLine()) {
                input = scannerText.nextLine();
                System.out.println(lineCounter + ". " +input);
                lineCounter++;
            }
            // close the scanner & release the resources
            scannerText.close();
        } catch (IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
        }
}