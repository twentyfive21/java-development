package Mod03;
import java.io.*;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SearchInventory {

    // ~~~~~~~~~~~~~~~~ main method ~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        getInventory();
        getUserInput();
    }

    // ~~~~~~~~~~~~~~~ paths for file ~~~~~~~~~~~~~~~~
    final static String path = "/Users/tina/pluralsight/" +
            "java-development/workbook-3/workbook-3/src/main/java" +
            "/Mod03/inventory.csv";
    final static String path2 = "/Users/tina/pluralsight/" +
            "java-development/workbook-3/workbook-3/src/main/java" +
            "/Mod03/inventory2.csv";
    static ArrayList<Product> inventory = new ArrayList<Product>();
    static int idNum = 9880;

    // ~~~~~~~~~~~~ get inventory method ~~~~~~~~~~~~~~
    public static ArrayList<Product> getInventory(){
        // create Array list of object Product
        try{ // use buffer to read from text but, must provide file reader
            BufferedReader bufReader = new BufferedReader(new FileReader(path));
            BufferedWriter writer = new BufferedWriter(new FileWriter(path2));

            String item = " ";
            while((item = bufReader.readLine()) != null){
                String[] currentItem = item.split(Pattern.quote("|"));

                // create new product object after split
                 Product currentProd = new Product(Integer.parseInt(currentItem[0]),
                        currentItem[1],Float.parseFloat(currentItem[2]));
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
            case "3" : findByPriceRange(scanner);
                      break;
            case "4" : addProduct(scanner);
                      break;
            case "5" : quitProgram();
                      break;
            default : System.out.println("!!! Error please pick a valid option !!!\n");
                      getUserInput();
                      break;
        }

    }

    // ~~~~~~~~~~~~~ case 1 get all items method ~~~~~~~~~~~~~~~~~~~~
    public static void getAllItems(){
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
        System.out.print("Please provide the product ID number: ");
        int input = scanner.nextInt();
        // clear leftover in buffer from int
        scanner.nextLine();
        // to access an element at a specific index in an ArrayList (or any List implementation),
        boolean found = false;
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
    // ~~~~~~~~~~~~~ case 3 get price range method ~~~~~~~~~~~~~~~~~~~~
    public static void findByPriceRange(Scanner scanner) {
        System.out.print("Please provide your max price: ");
        float max = scanner.nextFloat();
        System.out.print("Please provide your minimum price: ");
        float min = scanner.nextFloat();
        // clear leftover in buffer
        scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < inventory.size(); i++){
            float currentItem = inventory.get(i).getPrice();
            if((currentItem >= min) && (currentItem <= max)){
                System.out.println(inventory.get(i));
                found = true;
            }
        }
        if (!found){
            System.out.printf("No matching items in the range $%.2f-$%.2f provided", min, max);
        }
        getUserInput();
    }
    // ~~~~~~~~~~~~~ case 4 add new product method ~~~~~~~~~~~~~
    public static void addProduct(Scanner scanner){
        try{
            System.out.print("Please provide the item price: ");
            float price = scanner.nextFloat();
            // clear left over in buffer
            scanner.nextLine();
            System.out.print("Please provide item name: ");
            String name = scanner.nextLine();

            // if invalid items are provided ask user to input again
            if (name.isEmpty() || price == 0){
                System.out.println("Error please provide valid input!");
                addProduct(scanner);
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(path2, true));
            // create new product object
            Product productToAdd = new Product(idNum,name,price);
            // write to inventory 2 csv
            writer.write(productToAdd.getId() + "|"
                    + productToAdd.getName() + "|" + productToAdd.getPrice()+ "\n");
            // add to inventory Array.list
            idNum++;
            inventory.add(productToAdd);
            // print out added product
            System.out.println("\nYour item below has been added: \n");
            System.out.println("Product Id= " + productToAdd.getId() + "\n"
                    + "Item name= " + productToAdd.getName() + "\n"
                    + "Item price= " + productToAdd.getPrice()+ "\n");
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error!");
        }
        getUserInput();
    }
    // ~~~~~~~~~~~~~ case 5 get quit method ~~~~~~~~~~~~~~~~~~~~
    public static void quitProgram(){
        System.out.println("Thank you for coming today!");
        System.out.println("Have an amazing day!");
    }

}

/* array to string to see String value & not as default string [L java.lang.String;@372f7a8d
 System.out.println(Arrays.toString(currentItem));
 */