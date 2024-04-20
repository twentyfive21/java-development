package com.pluralsight;
import java.util.Scanner;

public class FamousQuotes {
    // main method
    public static void main(String[] args) {
        String[] quotes = new String[10];
        getQuotes(quotes);
        getUserInput(quotes);
    }
    // set quotes array with values
    public static void getQuotes(String[] quotes) {
        quotes[0] = "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill";
        quotes[1] = "The only way to do great work is to love what you do. - Steve Jobs";
        quotes[2] = "In the midst of chaos, there is also opportunity. - Sun Tzu";
        quotes[3] = "The greatest glory in living lies not in never falling, but in rising every time we fall. - Nelson Mandela";
        quotes[4] = "Believe you can and you're halfway there. - Theodore Roosevelt";
        quotes[5] = "It does not matter how slowly you go as long as you do not stop. - Confucius";
        quotes[6] = "The only limit to our realization of tomorrow will be our doubts of today. - Franklin D. Roosevelt";
        quotes[7] = "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt";
        quotes[8] = "The only person you should try to be better than is the person you were yesterday. - Unknown";
        quotes[9] = "Strive not to be a success, but rather to be of value. - Albert Einstein";
    }
    // get user input method
    public static void getUserInput(String[] quotes){
        Scanner scanner = new Scanner(System.in);
        // use try catch to handle error is 1-10 is not chosen
        try {
            System.out.print("Select a number between 1 - 10! ");
            System.out.print("Or select (r) for a random quote! : ");
            String choice = scanner.nextLine();
            // type caste random num returned from math.random
            // this func returns a double you must do (int) to resolve issue
            if (choice.equalsIgnoreCase("r")){
                int randomNum = (int)(Math.random() * 10) + 1;
                System.out.println("\n"+quotes[randomNum]);
            } else {
                int choiceInt = Integer.parseInt(choice);
                choiceInt = choiceInt - 1;
                System.out.println("\n"+quotes[choiceInt]);
            }
        } catch (Exception e){
            System.out.println("Error please pick a number within the range!");
        }
        System.out.print("\nWould you like another quote? Yes(y) or No(n): ");
        String selection = scanner.nextLine().toLowerCase().trim();
        // loop around to let user select another quote
        switch (selection){
            case "n" : System.out.println("Have a nice day please come again!");
                    break;
            case "y" :
            default  :
                    getUserInput(quotes);
                    break;
        }

    }
}
