package area.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        // Create an object of the shape class and call the getArea() method.
        Shape shape = new Shape();
        System.out.println("Shape area: "+ shape.getArea());

        // Create an object of the Rectangle class and call the getArea() method.
        Rectangle rectangle2 = new Rectangle(2,10);
        System.out.println("Rectangle area: " + rectangle2.getArea());

        // Create an object of the Square class and call the getArea() method.
        Square square1 = new Square(3,3);
        System.out.println("Square 1: " + square1.getArea());

        Square square2 = new Square(3,6);
        System.out.println("Square 2: " + square2.getArea());
        // Create an object of the Box class and call the getArea() method.
        Box box2 = new Box(4,4,4);
        System.out.println("Box area: " + box2.getArea());
        // Extra - create a menu where the user can choose which shape and also provide the lengths needed to calculate the area depending on the shape chosen.
        */

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Choose shape:");
            System.out.println("1. Rectangle");
            System.out.println("2. Square");
            System.out.println("3. Box");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter length of rectangle: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width of rectangle: ");
                    double width = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(length, width);
                    System.out.println("Area of rectangle: " + rectangle.getArea());
                    break;
                case 2:
                    System.out.print("Enter side length of square: ");
                    double lengthSquare = scanner.nextDouble();
                    System.out.print("Enter side length of square: ");
                    double widthSquare = scanner.nextDouble();
                    Square square = new Square(lengthSquare,widthSquare);
                    System.out.println("Area of square: " + square.getArea());
                    break;
                case 3:
                    System.out.print("Enter length of box: ");
                    double boxLength = scanner.nextDouble();
                    System.out.print("Enter width of box: ");
                    double boxWidth = scanner.nextDouble();
                    System.out.print("Enter height of box: ");
                    double boxHeight = scanner.nextDouble();
                    Box box = new Box(boxLength, boxWidth, boxHeight);
                    System.out.println("Surface area of box: " + box.getArea());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 4);
        scanner.close();
    }
    }

