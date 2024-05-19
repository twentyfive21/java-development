package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide your name! ");
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.printf("\nHello %s!", name);
    }
}