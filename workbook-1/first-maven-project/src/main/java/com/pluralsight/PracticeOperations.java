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

        double result = firstValue + secondValue+ thirdValue;
        System.out.println(result + " " + "adding");

        result = firstValue - secondValue - thirdValue;
        System.out.println(result + " " + "subtraction");

        result =firstValue * thirdValue * thirdValue;
        System.out.println(result + " " + "multiplying");

        result = firstValue / secondValue / thirdValue;
        System.out.println(result + " " + "Current final result after diving 3 variables");

        double accumulation = result + 10;
        System.out.println(accumulation + " " + "Final result + 10");

        accumulation += 100;
        System.out.println(accumulation + " " + "Final result + 100");

        accumulation += 1000;
        System.out.println(accumulation + " " + "Final result + 1000");

    }

}
