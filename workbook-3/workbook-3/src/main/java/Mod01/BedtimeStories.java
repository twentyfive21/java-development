package Mod01;
//The Scanner class from the java.io package can be used to read a file
import java.io.*;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        try{
            // create a FileInputStream object pointing to a specific file
            // give path to file input so it can find the txt file
            // else it has no clue where the file is at
            FileInputStream fis = new FileInputStream("/Users/tina/" +
                    "pluralsight/java-development/workbook-3/workbook" +
                    "-3/src/main/java/Mod01/goldilocks.txt");
            // create a Scanner to reference the file to be read
            /* When you create a Scanner, have it reference a file by
            wrapping the name of the file inside a FileInputStream
            object and passing that to the Scanner constructor */
            Scanner scanner = new Scanner(fis);
            String input;
            // read until there is no more data
            // hasNextLine() method returns true if there are more lines in the file
            // With nextLine(), you can read a line of text from the file
            while(scanner.hasNextLine()) {
                input = scanner.nextLine();
                System.out.println(input);
            }
            // close the scanner & release the resources
            scanner.close();
        } catch (IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
        }

}
