package Mod03;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class SearchInventoryMap {

    // ~~~~~~~~~~~ main method ~~~~~~~~
    public static void main(String[] args) {
        loadInventory();
        getUserInput();
    }

    static HashMap<String, Product> inventory = new HashMap<String, Product>();

    final static String path = "/Users/tina/pluralsight/" +
            "java-development/workbook-3/workbook-3/src/main/java" +
            "/Mod03/inventory.csv";
    // ~~~~~~~~~~~ load inventory method ~~~~~~~~
    public static void loadInventory() {
        try{
            BufferedReader bufReader = new BufferedReader(new FileReader(path));
            String item = "";
            while((item = bufReader.readLine()) != null){
                // split item at the pipe to create the object
                String[] currentItem = item.split(Pattern.quote("|"));

                // create new product object after split
                Product currentProd = new Product(Integer.parseInt(currentItem[0]),
                        currentItem[1],Float.parseFloat(currentItem[2]));
                // assign the name as the key and product object as the value
                inventory.put(currentItem[1], currentProd);
            }

            System.out.println("~~~~~~~~~~ Here are all our current Items ~~~~~~~~~");
            for (Product value : inventory.values()){
                System.out.println(value);
            }
            System.out.println("~~~~~~~~~~ End of all our current Items ~~~~~~~~~");
            // close reader
            bufReader.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error!");
        }
    }

    // ~~~~~~~~~~~ load inventory method ~~~~~~~~
    public static void getUserInput () {
        Scanner scanner = new Scanner(System.in);

            System.out.print("Please type the name of the item you want to search for: ");
            String item = scanner.nextLine().trim();

             Product match = inventory.get(item);
             if (match != null) {
                 System.out.println("\nItem found:\n"+ match);
             } else {
                 System.out.println("\nItem does not exist");
             }

            System.out.print("\nDo you want to search again y(yes) or n(no)? ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "y": getUserInput();
                    break;
                case "n": System.out.println("\nHave a nice day!");
                    break;
                default : System.out.println("\nPlease provide a valid option");
                    getUserInput();
                    break;
        }

    }


}
