package asset.manager;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // create asset object array list
        ArrayList<Asset> assets = new ArrayList<>();

        // two house objects
        House firstHome = new House("First Home", "May 9 2024", 50000,
                "123 first house ln", 1, 2000, 300);
        House secondHome = new House("Second Home", "May 10 2024", 70000,
                "456 second house dr", 2, 3000, 400);
        // two vehicle objects
        // String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer
        Vehicle firstCar = new Vehicle("First Car", "May 12 2024",
                10000, "Toyota 4runner",2,500);
        Vehicle secondCar = new Vehicle("Second Car", "May 14 2024",
                10000, "Toyota 4runner",11,10000);

        // add assets to array list
        assets.add(firstHome);
        assets.add(secondHome);
        assets.add(firstCar);
        assets.add(secondCar);

        for (Asset asset : assets){
            String desc = asset.getDescription();
            String date = asset.getDateAcquired();
            double originalValue = asset.getOriginalCost();
            double currentValue = asset.getValue();
            System.out.printf("\nDescription: %s \nDate purchased: %s\n" +
                            "Original value: $%,.2f\nCurrent Value: $%,.2f\n",
                    desc,date,originalValue,currentValue);

            if(asset instanceof House){
                // if instance of house downcast to house
                House house = (House) asset;
                System.out.print("Address: " + house.getAddress() + "\n");
            }
            if(asset instanceof Vehicle){
                // if instance of vehicle downcast to vehicle
                Vehicle vehicle = (Vehicle) asset;
                System.out.print("Make/Mode: " + vehicle.getMakeModel());
                System.out.print("\nYear: " + vehicle.getYear() + "\n");
            }


        }
    }

}
