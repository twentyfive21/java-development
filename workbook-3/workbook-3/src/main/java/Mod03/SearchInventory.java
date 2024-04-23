package Mod03;
import java.io.*;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.regex.Pattern;

public class SearchInventory {

    // main method
    public static void main(String[] args) {
        getInventory();
    }

    // get inventory method and also create at least 5 products
    public static ArrayList<Product>  getInventory(){

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
            for(int i = 0; i < inventory.size(); i++){
                System.out.println(inventory.get(i) + " item in array list");
            }

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error!");
        }
        // return all inventory at the end
        return inventory;
    }

}

/* array to string to see String value & not as default string [L java.lang.String;@372f7a8d
 System.out.println(Arrays.toString(currentItem));
 loop to check array list


 */