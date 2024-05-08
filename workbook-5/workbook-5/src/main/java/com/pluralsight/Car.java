package com.pluralsight;

public class Car extends Vehicle {
    private String bodyType;
    private String transmission;
    private String safetyFeatures;

    public Car(String color, int numberOfPassengers, int cargoCapacity,
                      int fuelCapacity, int year){
        super(color,numberOfPassengers,cargoCapacity,fuelCapacity,year);
    }

}
