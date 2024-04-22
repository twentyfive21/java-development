package Mod03;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {

    public static void main(String[] args) {
        try{
            /* Create a new BufferedWriter, wrapping around a FileWriter.

             This code is initializing a BufferedWriter called writer which
             will be used to write character data to a file.

             Create a new FileWriter object to write to a file
             Insert the path to the file you want to write to within the parentheses */

            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/tina/pluralsight/" +
                    "java-development/workbook-3/workbook-3/src/main/java" +
                    "/Mod03/logs.txt"));
            // ~~~~~~~~~~~~ Write to file on launch ~~~~~~~~~~~~

            // write to the file
            writer.write(getDate() + "First launching the application\n");

            // set while loop to keep checking until user cancels
            boolean isTrue = true;
            while(isTrue){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please pick the following options: ");
                System.out.println("a. Launching the application \n" +
                        "b. Searching for a term\n" +
                        "c. Exiting the application\n");
                // saving users selection
                System.out.print("Selection: ");
                String selection = scanner.nextLine().toLowerCase().trim();

                // launch application and write user time
                if (selection.equals("a")){
                    System.out.println("You have launched the application :)");
                    writer.write(getDate() + "User chose to launch the application\n");
                    // allow user to type in search
                } else if (selection.equals("b")){
                    System.out.println("You have chosen to search for a term! :)");
                    System.out.print("Enter a search term or (X to exit): ");
                    String choice = scanner.nextLine().toLowerCase().trim();
                    // exits out program or writes to file
                    if(choice.equalsIgnoreCase("x")){
                        System.out.println("You have chosen to exit. Please come again! :)");
                        writer.write(getDate() + "Exit");
                        isTrue = false;
                    }else{
                        writer.write(getDate() + "search: " + choice + "\n");
                    }
                // exits the program
                } else if (selection.equals("c")){
                    System.out.println("You have chosen to exit. Please come again! :)");
                    writer.write(getDate() + "Exit");
                    isTrue = false;
                } else {
                    System.out.println("invalid input");
                }
            }
            // close the writer after while loop is false
            writer.close();
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println("Error please pick a-c!");
        }

    }

    public static String getDate () {
        // Format date
        // get thr current date and time
        LocalDateTime actionTime =  LocalDateTime.now();
        // chose format wanted
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");
        // take date made and pass to formatter
        String formatedString = actionTime.format(fmt);
        return formatedString;
    }
}
