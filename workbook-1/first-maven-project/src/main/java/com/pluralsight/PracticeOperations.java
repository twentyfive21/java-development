package com.pluralsight;
/*
 Create a class named PracticeOperations that
 creates three variables of type String and concatenated
 them into one String.

 It also declares three doubles and then assigns
 the result of adding, subtracting, and multiplying those doubles
 to a third variable of type double.

 Also assign the values of the first double divided by the second
 double and then the result of that divided by the third double.

 Create another double variable that holds the accumulation
 of that result variable added to 10, 100 and 1000. */

public class PracticeOperations {

    public static void main(String[] args) {

        // strings practice
        String word1 = "Hi";
        String word2 = "I am";
        String word3 = "Tina!";
        String sentence = word1 + " " + word2 + " " + word3;
        System.out.println(sentence);


        // doubles practice
        double firstValue = 2.53423234432223;
        double secondValue = 3.5693939343324;
        double thirdValue = 5.24324223332338;

        double result = firstValue + thirdValue;
        System.out.println(result + " " + "Adding first and third value");
        result = secondValue - thirdValue;
        System.out.println(result + " " + "Adding second and third value");
        result = thirdValue * thirdValue;
        System.out.println(result + " " + "Adding third value");

        double result2 = firstValue / secondValue / thirdValue;

        double finalResult = result2;
        System.out.println(finalResult + " " + "Current final result after diving 3 variables");

        finalResult += 10;
        System.out.println(finalResult + " " + "Final result + 10");
        finalResult += 100;
        System.out.println(finalResult + " " + "Final result + 100");
        finalResult += 1000;
        System.out.println(finalResult + " " + "Final result + 1000");

    }

}
