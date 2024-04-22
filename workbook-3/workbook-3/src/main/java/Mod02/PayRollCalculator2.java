package Mod02;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PayRollCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file employee file to process:");
        String fileToRead = scanner.nextLine();
        System.out.print("Enter the name of the payroll file to create: ");
        String fileToCreate = scanner.nextLine();

        try{
            BufferedReader bufReader = new BufferedReader(
                    new FileReader("/Users/tina/pluralsight/" +
                            "java-development/workbook-3/workbook-3/src/main/java" +
                            "/Mod02/" + fileToRead));

            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/tina/pluralsight/" +
                    "java-development/workbook-3/workbook-3/src/main/java" +
                            "/Mod02/" + fileToCreate));

            String input = bufReader.readLine();

            // Create placeholder to store separated user values after splitting
            // When you reach the end-of-file, readLine() returns null
            writer.write("id|name|gross pay\n");
            while ((input = bufReader.readLine()) != null){
                String[] currentUser = input.split(Pattern.quote("|"));
                Employee variable = new Employee(Integer.parseInt(currentUser[0]),
                        currentUser[1], Double.parseDouble(currentUser[2]),
                        Double.parseDouble(currentUser[3]));
                writer.write(variable.getEmployeeId() + "|" + variable.getName() + "|" + variable.getGrossPay() + "\n");
            }
            // close buffer reader
            writer.close();
            bufReader.close();

        }catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }
    }
}

// BufferedReader reader = new BufferedReader(new FileReader("path"));
// reader.readLine();

//BufferedWriter writer = new BufferedWriter(new FileWriter("tax.txt"));
//writer.write("hello world);