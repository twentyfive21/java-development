package com.pluralsight;

public class VehicleMain {
    public static void main(String[] args) {
    // instantiate objects
        // car child object
        Car car = new Car("pink",2,4,50,4);
        car.setColor("Pink");
        car.setYear(2024);
        System.out.println("Car details: "+ car.getColor() + " "+ car.getYear());
        // hovercraft child object
        Hovercraft hovercraft = new Hovercraft("pink",2,4,50,4);
        hovercraft.setFuelCapacity(1000);
        System.out.println("Parameter Constructor: "+ hovercraft);
        System.out.println("Hovercraft fuel: " + hovercraft.getFuelCapacity());
        // moped child object
        Moped moped = new Moped("pink",2,4,50,4);
        moped.setNumberOfPassengers(2);
        System.out.println("Moped passengers "+moped.getNumberOfPassengers());
        // semi child object
        SemiTruck semiTruck= new SemiTruck("pink",2,4,50,4);
        semiTruck.setColor("White");
        // bonus check
        semiTruck.setTrailerLength("Long");
        System.out.println("Semi color: "+ semiTruck.getColor());
        System.out.println("Semi length: "+ semiTruck.getTrailerLength());


    }
}
