package com.pluralsight;

import com.pluralsight.forms.Turtle;
import com.pluralsight.forms.World;

import java.awt.*;

public class MainApp
{
    public static void main(String[] args)
    {
        // This starter code to get you familiar with how
        // the TurtleLogo application works

        // The world is your canvas
        World world = new World(200, 200);
        Turtle turtle = new Turtle(world,-100, -100);
        
        int width = 200;
        int height = 200;

        // calculate the hypotenuse (diagonal)
        // a2 + b2 = c2
        double widthSquared = Math.pow(width, 2);
        double heightSquared = Math.pow(height, 2);
        double hypotenuse = Math.sqrt(widthSquared + heightSquared);

        // *************** draws an x ****************
        /* turtle.setPenWidth(3);
        turtle.setColor(Color.PINK);

        turtle.turnRight(45);
        turtle.forward(hypotenuse);

        turtle.penUp();
        turtle.goTo(100, 100);
        turtle.turnRight(90);

        turtle.penDown();
        turtle.forward(hypotenuse); */

        // ************* draw a plus **************
        /*
        turtle.setPenWidth(5);
        turtle.setColor(Color.PINK);

        // pen up so no line is drawn
        turtle.penUp();
        // move to top center of world
        turtle.forward(100);
        // pen down to draw
        turtle.penDown();
        // turn 90 deg to go down
        turtle.turnRight(90);
        // go down to the end of the world
        turtle.forward(215);
        // turn head back to go up
        turtle.turnRight(180);
        // go back up to middle
        turtle.forward(115);
        // turn head left
        turtle.turnLeft(90);
        // draw left
        turtle.forward(110);
        // turn head right
        turtle.turnRight(180);
        // start drawing right line of plus to the end
        turtle.forward(220);
        */

        // ***************** Draw a square **************
        /*
        turtle.setPenWidth(5);
        turtle.setColor(Color.green);

        // up to not draw line
        turtle.penUp();
        // turn head to go down to starting point
         turtle.turnRight(90);
        turtle.forward(30);
        turtle.turnLeft(90);
        turtle.forward(30);
        turtle.penDown();
        turtle.forward(140);
        turtle.turnRight(90);
        turtle.setColor(Color.pink);
        turtle.forward(140);
        turtle.turnRight(90);
        turtle.setColor(Color.blue);
        turtle.forward(140);
        turtle.turnRight(90);
        turtle.setColor(Color.YELLOW);
        turtle.forward(140);
        turtle.penUp();
        turtle.turnRight(135);
        turtle.setColor(Color.red);
        turtle.forward(95);
        */
        // *********** draw a circle ***********
        turtle.penUp();
        turtle.setColor(Color.pink);
        turtle.turnRight(0);
        turtle.forward(100);
        turtle.turnRight(90);
        turtle.forward(30);
        turtle.turnLeft(90);
        turtle.penDown();
        turtle.setPenWidth(5);
        // loop to draw circle
        for(int i = 0; i < 27; i++){
            turtle.turnRight(i);
            turtle.forward(i);
        }

        turtle.penUp();
        turtle.setColor(Color.green);
        for(int i = 0; i < 27; i++){
            turtle.turnRight(i);
            turtle.forward(i);
        }
        turtle.turnRight(120);
        turtle.forward(60);


    }
}
