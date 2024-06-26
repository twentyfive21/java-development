package Mod02;
import java.io.*;
import java.util.regex.Pattern;

public class PayrollCalculator {

    public static void main(String[] args) {

        try{
            //  BufferedReader from the java.io package reads text from a stream of characters
            // To create a BufferedReader, pass a FileReader to its constructor

            /* Two line method version commented out example

            FileReader fileReader = new FileReader("poem.txt");
            BufferedReader bufReader = new BufferedReader(fileReader);

             */

            BufferedReader bufReader = new BufferedReader(
                    new FileReader("/Users/tina/pluralsight/" +
                    "java-development/workbook-3/workbook-3/src/main/java" +
                    "/Mod02/employees.csv"));

            // Use readLine() to read a line of text from the file
            // skipping headers and stores them here then gets deleted when next line read
            // headers are id/name/payroll ect
            String input = bufReader.readLine();

            // Create placeholder to store separated user values after splitting
            // When you reach the end-of-file, readLine() returns null
            while ((input = bufReader.readLine()) != null){
               String[] currentUser = input.split(Pattern.quote("|"));
                Employee variable = new Employee(Integer.parseInt(currentUser[0]),
                                    currentUser[1], Double.parseDouble(currentUser[2]),
                                    Double.parseDouble(currentUser[3]));
                System.out.printf("Employee Id : %d \n" +
                        "Employee name: %s \n" +
                        "Employee gross pay: $%.2f \n\n",
                        variable.getEmployeeId(), variable.getName(), variable.getGrossPay());
            }
            // close buffer reader
            bufReader.close();

        } catch(IOException e){
            // display stack trace if there was an error
            e.printStackTrace();
        }

    }


}
