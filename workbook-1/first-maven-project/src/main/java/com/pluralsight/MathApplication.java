package com.pluralsight;

public class MathApplication {

    // declare variables here
    // then code solution
    // then use System.out.println() to display results

    public static void main(String[] args) {

        // question 1
        int bobSalary = 70000;
        int garySalary = 20000;

        int highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("The highest salary is " + highestSalary);

        // question 2
        int carPrice = 3000;
        int truckPrice = 1000;

        int lowestPrice = Math.min(carPrice, truckPrice);
        System.out.println("The lowest price is " + lowestPrice);

        // question 3
        double radius = 7.25;
        final double piValue = 3.14;

        double areaOfCircle = piValue * Math.pow(radius, 2);
        System.out.println("The area of the circle is " +String.format("%.2f", areaOfCircle));

        // question 4
        double valueToBeSquared = 5.0;
        double squaredValue = Math.sqrt(valueToBeSquared);
        System.out.println("The squared value of " + valueToBeSquared + " is " + String.format("%.2f", squaredValue));

        // question 5
        //(5,10) (85,50) find the distance
        double x1 = 5;
        double y1 = 10;
        double x2 = 85;
        double y2 = 50;

        double xValue = x2 - x1;
        double yValue = y2 - y1;
        xValue = Math.pow(xValue, 2);
        yValue = Math.pow(yValue, 2);
        double addedSquaredValues = xValue + yValue;
        double distance = Math.sqrt(addedSquaredValues);
        System.out.println("The distance between the points is " + String.format("%.2f" ,distance));

        // question 6
        double setNumPositive = -3.8;
        setNumPositive = Math.abs(setNumPositive);
        System.out.println(setNumPositive + " as positive would be "+ setNumPositive);

        // question 7
        double randomNum = Math.random();
        System.out.println( "A random number between 0-1 is " + String.format("%.2f",randomNum));

        //String.format()

    }

}
