package com.pluralsight;

public class ShoppingList {

    public static void main(String[] args) {
        String[] cartItems = {
                "milk","chips","chocolate","lime",
                "lemon", "blueberries", "apple", "kiwi",
                "strawberries", "corn"
        };

        for (int i = 0; i < cartItems.length; i++) {
            System.out.println(cartItems[i] + " at index " + (i + 1));
        }
    }

}

