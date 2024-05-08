package com.pluralsight;

public class Moped extends Vehicle{
    private String engineSize;
    private String pedalAssist;
    private String storageCompartment;

    public Moped(String color, int numberOfPassengers, int cargoCapacity,
                      int fuelCapacity, int year){
        super(color,numberOfPassengers,cargoCapacity,fuelCapacity,year);
    }
}
