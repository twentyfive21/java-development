package Mod04;
import java.util.ArrayList;
import java.util.Arrays;
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
    static String skuGenerator = "AV105";
    static int startNum = 2; // update num first then add to String to make sku

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
        for (int i = 0; i < inventory.size(); i++){
            System.out.println(inventory.get(i));
        }
        System.out.println("~~~~~~~~ All current items End ~~~~~~~");

        System.out.print("\nWould you like to do any of the following?\n" +
                "(1) Search by product by name, price or department\n" +
                "(2) Add a product to cart\n" +
                "(3) Go Back to home page\n" + "Selection: ");
        String choice = scanner.nextLine();
        switch (choice){
            case "1": System.out.println("searchByChoice");;
                break;
            case "2": System.out.println("Add product to cart");
                break;
            case "3": displayUserHomeScreen();
                break;
            default: System.out.println("\n!!! Error invalid input please select again !!!");
                displayProducts(scanner);
                break;
        }
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

DONE(Displays a list of products that your store sells.)
- On this screen the customer should be able to - Search or filter the list of products
- They should also be able to search by Product Name, Price or Department
- Add a product to their cart
(DONE)- Go Back to the home page

~~~~~~~~~~~~~ Display Cart ~~~~~~~~`~~~~~~~~~~
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