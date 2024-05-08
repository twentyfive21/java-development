package com.pluralsight;

public class Hovercraft extends Vehicle{
    private double maximumAltitude;
    private int waterSpeed;
    private int airSpeed;
    private String controlSystem;

    public Hovercraft(String color, int numberOfPassengers, int cargoCapacity,
                      int fuelCapacity, int year){
        super(color,numberOfPassengers,cargoCapacity,fuelCapacity,year);
    }
}
