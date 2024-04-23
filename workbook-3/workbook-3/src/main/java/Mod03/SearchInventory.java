package Mod03;
import java.io.*;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SearchInventory {

    // ~~~~~~~~~~~~~~~~ main method ~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        getUserInput();
    }

    // ~~~~~~~~~~~~ get inventory method ~~~~~~~~~~~~~~
    public static ArrayList<Product> getInventory(){
        String path = "/Users/tina/pluralsight/" +
                "java-development/workbook-3/workbook-3/src/main/java" +
                "/Mod03/inventory.csv";
        String path2 = "/Users/tina/pluralsight/" +
                "java-development/workbook-3/workbook-3/src/main/java" +
                "/Mod03/inventory2.csv";

        // create Array list of object Product
        ArrayList<Product> inventory = new ArrayList<Product>();
        try{ // use buffer to read from text but, must provide file reader
            BufferedReader bufReader = new BufferedReader(new FileReader(path));
            BufferedWriter writer = new BufferedWriter(new FileWriter(path2));

            String item = " ";
            while((item = bufReader.readLine()) != null){
                String[] currentItem = item.split(Pattern.quote("|"));

                // create new product object after split
                 Product currentProd = (new Product(Integer.parseInt(currentItem[0]),
                        currentItem[1],Float.parseFloat(currentItem[2])));

                // write to inventory 2 csv
                 writer.write(currentProd.getId() + "|"
                 + currentProd.getName() + "|" + currentProd.getPrice()+ "\n");

                 // add to inventory Array.list
                 inventory.add(currentProd);
            }
            // close reader and write after while loop ends
            writer.close();
            bufReader.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error!");
        }
        // return all inventory at the end
        return inventory;
    }

    // ~~~~~~~~~~~~~ get user input method ~~~~~~~~~~~~~~~~~~~
    public static void getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n~~~~~~~ Welcome to my store! ~~~~~~~");
        System.out.print("What do you want to do?\n" +
                "1-List all products\n" +
                "2-Lookup a product by its id\n" +
                "3-Find all products within a price range \n" +
                "4-Add a new product\n" +
                "5-Quit the application\n" +
                "Enter command: ");

        String choice = scanner.nextLine();
        System.out.println(" ");
        switch (choice){
            case "1" : getAllItems();
                      break;
            case "2" : getProductById(scanner);
                      break;
//            case "3" : findByPriceRange();
//                      break;
//            case "4" : addProduct();
//                      break;
            case "5" : quitProgram();
                      break;
            default : System.out.println("!!! Error please pick a valid option !!!\n");
                      getUserInput();
                      break;
        }

    }

    // ~~~~~~~~~~~~~ case 1 get all items method ~~~~~~~~~~~~~~~~~~~~
    public static void getAllItems(){
        ArrayList<Product> inventory = getInventory();
        // Sort the inventory of products based on their names
        inventory.sort(Comparator.comparing(Product::getName));
        // Collections.sort(inventory, Comparator.comparing(Product::getName));
        System.out.println("Here is all my current products : \n");
        for (Product product : inventory) {
            System.out.println(product);
        }
        getUserInput();
    }
    // ~~~~~~~~~~~~~ case 2 get product by id method ~~~~~~~~~~~~~~~~~~~~
    public static void getProductById(Scanner scanner) {
        boolean found = false;
        System.out.print("Please provide the product ID number: ");
        int input = scanner.nextInt();
        // clear leftover in buffer from int
        scanner.nextLine();
        ArrayList<Product> inventory = getInventory();
        // to access an element at a specific index in an ArrayList (or any List implementation),
        for (int i = 0; i < inventory.size(); i++){
            if (input == inventory.get(i).getId()){
                // .get(i) method. This returns the element at the specified index in the list.
                // vs in normal arrays you do inventory[i]. Array lists use .get()!
                System.out.println("\nHere is the item you searched for: \n");
                System.out.println(inventory.get(i));
                found = true;
            }
        }
        if (!found){
            System.out.printf("\nError the id : %d does not match any of our items! :(\n", input);
        }
        getUserInput();
    }
    // ~~~~~~~~~~~~~ case 5 get quit program method ~~~~~~~~~~~~~~~~~~~~
    public static void quitProgram(){
        System.out.println("Thank you for coming today!");
        System.out.println("Have an amazing day!");
    }

}

/* array to string to see String value & not as default string [L java.lang.String;@372f7a8d
 System.out.println(Arrays.toString(currentItem));

    3-Find all products within a price range
    4-Add a new product
 */