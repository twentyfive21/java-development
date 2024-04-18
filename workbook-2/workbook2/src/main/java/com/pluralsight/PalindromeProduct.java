package com.pluralsight;

public class PalindromeProduct {
    public static void main(String[] args) {
        // Initialize max with a value that indicates no palindrome found yet
        String max = "0";
        // Outer loop
        for (int i = 1; i <= 999; i++) {
            // Inner loop
            for (int j = 1; j <= 999; j++) {
                // Calculate the product of the two factors
                int sum = i * j;
                // Create a new StringBuilder for each product to store the reversed number
                StringBuilder reversedNumber = new StringBuilder();
                // Convert the product to a string to check for palindrome
                String numberToCheck = String.valueOf(sum);
                // Loop to reverse the digits of the product
                // append each digit of the product in reverse order to the StringBuilder
                for (int z = numberToCheck.length() - 1; z >= 0; z--) {
                    // Append each digit of the product in reverse order to the StringBuilder
                    reversedNumber.append(numberToCheck.charAt(z));
                }
                if (numberToCheck.equals(reversedNumber.toString())) {
                    // Check if the current palindrome is greater than the max palindrome found so far
                    if (Integer.parseInt(numberToCheck) > Integer.parseInt(max)) {
                        max = numberToCheck; // Update the max palindrome if a larger one is found
                    }
                }
            }
        }
        // Check if any palindrome was found within the given range
        if (max.equals("0")) {
            System.out.println("No palindrome found in the given range.");
        } else {
            // Print the largest palindrome found
            System.out.println("Largest palindrome: " + max);
        }
    }
}



