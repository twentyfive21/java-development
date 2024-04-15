package com.pluralsight;

public class LoopingExercises {
    public static void main(String[] args) throws InterruptedException{
            WhileLoop.main(args);
            DoWhileLoop.main(args);
            ForLoop.main(args);
    }

    public static class WhileLoop {
        public static void main(String[] args) {
            int i = 0;
            while(i < 5) {
                System.out.println((i+1) + ". I love java <3");
                i++;
            }
            System.out.println("End of While Loop \n");
        }
    }

    public static class DoWhileLoop {
        public static void main(String[] args) {
            int i = 0;
            do {
                System.out.println((i+1) +". I love java <3");
                i++;
            }  while (i < 5);
            System.out.println("End of Do While Loop \n");
        }
    }

    public static class ForLoop {
        public static void main(String[] args) throws InterruptedException{
            for(int i = 10; i >= 1; i--){
                System.out.println(i);
                Thread.sleep(1000);
            }
            System.out.println("!Launch!");
            System.out.println("End of For Loop \n");
        }
    }
}
