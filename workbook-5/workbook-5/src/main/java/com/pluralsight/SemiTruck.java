package com.pluralsight;

public class SemiTruck extends Vehicle{
    private String trailerLength;
    private String axel;

    public SemiTruck(String color, int numberOfPassengers, int cargoCapacity,
                      int fuelCapacity, int year){
        super(color,numberOfPassengers,cargoCapacity,fuelCapacity,year);
    }

    public String getTrailerLength() {
        return trailerLength;
    }

    public void setTrailerLength(String trailerLength) {
        this.trailerLength = trailerLength;
    }
}
