package Mod04;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;

public class SearchStore {

    // ~~~~~~~~~~~~~~~~~~~~~~~ MAIN METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        loadInventory();
        displayUserHomeScreen();
    }
    // ~~~~~~~~~~~~~~~~ STATIC VARIABLES & PATH ~~~~~~~~~~~~~~~~~~~~

    final static String path = "/Users/tina/pluralsight/java-development/" +
            "workbook-3/workbook-3/src/main/java/Mod04/products.csv";

    static ArrayList<Product2> inventory = new ArrayList<Product2>();
    static HashMap<String,Integer> cart = new HashMap<String,Integer>();

    // ~~~~~~~~~~~~~~~ DISPLAY HOME SCREEN METHOD ~~~~~~~~~~~~~~~~~
    public static void displayUserHomeScreen () {
        // declare scanner to get home screen choice
        Scanner scanner = new Scanner(System.in);
        // present options to the user
        System.out.print("\n! Welcome to Best Buy !\n" +
                "(1) Display Products\n(2) Display Cart\n" +
                "(3) Exit\nSelection: ");
        // get user input
        String choice = scanner.nextLine();
        // switch case to call methods selected
        switch (choice){
            case "1": displayProducts(scanner);
                    break;
            case "2": System.out.println("displayCart");
                    break;
            case "3": exitProgram();
                    break;
            default: System.out.println("\n!!! Error invalid input please select again !!!");
                    displayUserHomeScreen();
                    break;
        }
    }

    // ~~~~~~~~~~~~~~~ DISPLAY PRODUCTS SCREEN METHOD ~~~~~~~~~~~~~~~~~

    public static void displayProducts(Scanner scanner){

        System.out.println("\n~~~~~~~~ All current items Start ~~~~~~~");
        for (Product2 product : inventory) {
            System.out.println(product);
        }
        System.out.println("~~~~~~~~ All current items End ~~~~~~~");

        System.out.print("\nWould you like to do any of the following?\n" +
                "(1) Search by product by name, price or department\n" +
                "(2) Add a product to cart\n" +
                "(3) Go Back to home page\n" + "Selection: ");
        String choice = scanner.nextLine();
        switch (choice){
            case "1": searchByChoice(scanner);
                break;
            case "2": addToCart(scanner);
                break;
            case "3": displayUserHomeScreen();
                break;
            default: System.out.println("\n!!! Error invalid input please select again !!!");
                displayProducts(scanner);
                break;
        }
    }
    // ~~~~~~~~~ SEARCH BY MAIN METHOD & OTHER SEARCHES  ~~~~~~~~~~~~~~~~

    public static void searchByChoice(Scanner scanner){
        System.out.print("\nHow would you like to search by?\n" +
                "(1) Search by item name\n" +
                "(2) Search by price\n" +
                "(3) Search by department\n" +
                "Selection: ");
        String choice = scanner.nextLine();
        switch (choice){
            case "1": searchByName(scanner);
                    break;
            case"2": searchByPrice(scanner);
                    break;
            case "3": searchByDepartment(scanner);
                    break;
            default: System.out.println("Error please select a valid input");
                    searchByChoice(scanner);
                    break;
        }
    }

    // ********************* SEARCH BY NAME **********************

    public static void searchByName(Scanner scanner){
        System.out.print("\nYou have chosen to search by name!" +
                "\nPlease provide name of item: ");
        String itemName = scanner.nextLine().trim();
        System.out.printf("Items matching : %s\n", itemName);

        // check for matching search by name ignoring case
        for(Product2 currentItem : inventory){
            String nameToCheck = currentItem.getName();
            if(nameToCheck.equalsIgnoreCase(itemName)){
                System.out.println(currentItem);
            }
        }
        // re-run program
        displayUserHomeScreen();
    }

    // ********************* SEARCH BY DEPARTMENT **********************

    public static void searchByDepartment(Scanner scanner){
        // create array of departments

        String[] allDepartments = {"(1) Audio Video", "(2) Computers","(3) Games", "(4) Electronics"};
        System.out.println("\nPlease select one of the following to search by: ");

        // print all available departments
        for (String dep : allDepartments){
            System.out.println(dep);
        }

        // save user choice and assign department to loop through
        System.out.print("Selection: ");
        String choice = scanner.nextLine();
        String depChoice = "";
        switch (choice){
            case "1": depChoice = "Audio Video";
                    break;
            case "2" : depChoice = "Computers";
                    break;
            case "3" : depChoice = "Games";
                    break;
            case "4" : depChoice = "Electronics";
                    break;
            default: System.out.println("Invalid department choice please choose again!");
                    searchByDepartment(scanner);
                    break;
        }

        // display matching categories by checking through inventory
        System.out.printf("\nMatching categories for: %s\n",depChoice);
        for (Product2 currentDep : inventory) {
            if (currentDep.getDepartment().equals(depChoice)) {
                System.out.println(currentDep);
            }
        }

        // take user back to home screen after showing matching departments
        displayUserHomeScreen();
    }

    // *********************** SEARCH BY PRICE ************************

    public static void searchByPrice(Scanner scanner){
        System.out.println("\nYou have chosen search by price");
        System.out.print("\nPlease provide the max price: ");
        // max price
        float max = scanner.nextFloat();
        System.out.print("\nPlease provide the min price: ");
        // min price
        float min = scanner.nextFloat();
        // clear left over in buffer
        scanner.nextLine();

        // loop through and search for matching price range
        for(Product2 currentItem : inventory){
            float priceToCheck = currentItem.getPrice();
            if((priceToCheck >= min) && (priceToCheck <= max)){
                System.out.println(currentItem);
            }
        }
        // take user back to home screen after showing price range
        displayUserHomeScreen();
    }

    // ~~~~~~~~~~~~~~~~~~~~~~ ADD TO CART METHOD ~~~~~~~~~~~~~~~~~~~~~~~

    public static void addToCart(Scanner scanner){
        System.out.println("before");
        for(String key: cart.keySet()){
            System.out.println(key + ":" + cart.get(key));
        }
        System.out.println("\nYou have chosen to add a product to cart!");
        System.out.print("Please provide the sku of the item: ");
        String sku = scanner.nextLine();
        /* merge is used to merge the key sku with value of 1
        using the remapping func Integer::sum.
        - If the sku already exists in the cart, it updates the quantity
            associated with that SKU by adding 1 to the existing quantity.
        - If the sku doesn't exist in the cart, it adds the sku with a quantity of 1.
        - If the sku exists but its associated value is null,
            it associates the sku with the value 1.
        - If the sku exists but its associated value is not an Integer,
            it throws a ClassCastException.
        */
        cart.merge(sku, 1, Integer::sum);
        // longer way of updating/adding to cart
//         Integer quantity = cart.get(sku);
//         if (quantity!= null){
//             cart.put(sku, quantity + 1);
//             } else {
//               cart.put(sku,1);
//             }

//        System.out.println("after");
//        for(String key: cart.keySet()){
//            System.out.println(key + ":" + cart.get(key));
//        }
        displayProducts(scanner);
    }

    // ~~~~~~~~~~~~~~~~~~~~ LOAD INVENTORY METHOD ~~~~~~~~~~~~~~~~~~~~~~

    public static void loadInventory() {

        try{ // use buffer to read from text but, must provide file reader
            BufferedReader bufReader = new BufferedReader(new FileReader(path));

            String item = bufReader.readLine();

            while ((item = bufReader.readLine()) != null){
            String[] currentItem = item.split(Pattern.quote("|"));

            Product2 currentProduct = new Product2(Float.parseFloat(currentItem[2]),
                    currentItem[0], currentItem[1], currentItem[3]);
            // System.out.println(currentProduct);
             inventory.add(currentProduct);
            }

            // close readers
            bufReader.close();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error loading inventory! Please come back later");
        }
    }

    // ~~~~~~~~~~~~~~~~~~~~~~ EXIT METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void exitProgram(){
        System.out.println("Thank you for visiting! Goodbye, come again! :)");
    }
}


/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Screens ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

~~~~~~~~~~~~~~~ Display Products ~~~~~~~~~~~~~
DONE(Use the provided products.csv file to load the store's product inventory into your application.)
DONE(Create a Product class that stores all the properties defined in the csv file)

DONE (Displays a list of products that your store sells.)
(DONE) On this screen the customer should be able to - Search or filter the list of products
- Product Name
(DONE) - Price
(DONE) - Department
(DONE) Add a product to their cart
(DONE)- Go Back to the home page

~~~~~~~~~~~~~ Display Cart ~~~~~~~~~~~~~~~~~~
-This displays a list of line items that are in the customer's cart.
It should also display the total sales amount of the cart.
The customer should be able to:
- Check Out
- Remove Product from the cart
- Go Back to the home screen
o If the customer chooses to remove a product need to prompt
them for the product to remove


 ~~~~~~~~~~~~ BONUS (optional) ~~~~~~~~~~~~
• CheckOut
-Here you should display the total sales amount
owed for this order & prompt the user for payment.
- Assume that the user will pay in cash
- When the customer enters their payment amount,
verify that the amount is sufficient to cover the cost of the cart
- If the customer added enough money for the sale,
• calculate the change that is owed to the customer and display the calculated change

• print a sales receipt to the screen :
 -Order Date
- All Line items
- Sales Total
- Amount Paid
- Change Given
- clear the shopping cart
• Return to the home screen

- When a customer adds multiple items to a cart
- Instead of showing the item multiple times, your cart
should only display each item once, but display the quantity for each item

• Create Sales Receipt File
o After checkout, in addition to displaying the sales receipt to
the screen, create a file with the sale information
- Save the file in a Receipts folder
- The file name should be the date and time stamp of the
sale202303151148.txt
- All the information printed to the screen should be
saved to the file



!!!!!!!!!!!!!!!!!!!!!!!!!! COMPLETED ITEMS !!!!!!!!!!!!!!!!!!!!!!!!

~~~~~~ The Store Home Screen ~~~~~~
The home screen should display a list of options that a user can choose from.
o Display Products
o Display Cart
o Exit - closes out of the application

*/