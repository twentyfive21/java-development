package com.pluralsight;

public class RollTheDice {
    public static void main(String[] args) {
        Dice dice = new Dice();
        int roll1;
        int roll2;
        int curSum = 0;
        int counter2 = 0;
        int counter4 = 0;
        int counter6 = 0;
        int counter7 = 0;
        // roll dice 100 times method
        for(int i = 1; i <= 100; i++) {
            roll1 = dice.roll();
            roll2 = dice.roll();
            // keep count of current sum for counters
            curSum = roll1 + roll2;
            System.out.printf("Roll %d: %d - %d", i, roll1, roll2);
            System.out.printf("  Sum: %d\n", roll1 + roll2);
            // add to counters based on sum rolled
            switch(curSum){
                case 2: counter2++;
                break;
                case 4: counter4++;
                break;
                case 6: counter6++;
                break;
                case 7: counter7++;
                break;
            }
        }
        System.out.println("Number of times of 2 is rolled " + counter2);
        System.out.println("Number of times of 4 is rolled " + counter4);
        System.out.println("Number of times of 6 is rolled " + counter6);
        System.out.println("Number of times of 7 is rolled " + counter7);
    }
    // Dice roller to generate random number 1-6
    public static class Dice {
        public static int roll () {
            int randomNumber = (int)(Math.random() * 6) + 1;
            return randomNumber;
        }
    }
}