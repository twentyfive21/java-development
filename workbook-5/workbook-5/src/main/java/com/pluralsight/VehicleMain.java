package com.pluralsight;

public class VehicleMain {
    public static void main(String[] args) {
    // instantiate objects
        // car child object
        Car car = new Car();
        car.setColor("Pink");
        car.setYear(2024);
        System.out.println("Car details: "+ car.getColor() + " "+ car.getYear());
        // hovercraft child object
        Hovercraft hovercraft = new Hovercraft();
        hovercraft.setFuelCapacity(1000);
        System.out.println("Hovercraft fuel: " + hovercraft.getFuelCapacity());
        // moped child object
        Moped moped = new Moped();
        moped.setNumberOfPassengers(2);
        System.out.println("Moped passengers "+moped.getNumberOfPassengers());
        // semi child object
        SemiTruck semiTruck= new SemiTruck();
        semiTruck.setColor("White");
        System.out.println("Semi color: "+ semiTruck.getColor());
    }
}
