package asset.manager;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // ******************** create asset object array list ********************
        ArrayList<Asset> assets = new ArrayList<>();

        // ********************  two house objects ********************
        House firstHome = new House("First Home", "May 9 2024", 50000,
                "123 first house ln", 1, 2000, 300);
        House secondHome = new House("Second Home", "May 10 2024", 70000,
                "456 second house dr", 4, 3000, 400);

        // ********************  two vehicle objects ********************

        Vehicle firstCar = new Vehicle("First Car", "May 12 2024",
                10000, "Toyota 4runner",2,500);
        Vehicle secondCar = new Vehicle("Second Car", "May 14 2024",
                10000, "Jeep Wrangler",11,121000);
        Vehicle thirdCar = new Vehicle("Third Car", "May 14 2024",
                10000, "Honda Civic",11,151000);

        // ******************** Add assets to array list ********************
        assets.add(firstHome);
        assets.add(secondHome);
        assets.add(firstCar);
        assets.add(secondCar);
        assets.add(thirdCar);

        // ************************** Print out asset data **************************
        for (Asset asset : assets){
            // super class data
            String desc = asset.getDescription();
            String date = asset.getDateAcquired();
            double originalValue = asset.getOriginalCost();
            double currentValue = asset.getValue();

            System.out.println("\n--------------------------------------------");
            System.out.println("|              Asset Information            |");
            System.out.println("---------------------------------------------");
            System.out.printf("| Description: %s\n", desc);
            System.out.printf("| Date purchased: %s\n", date);
            System.out.printf("| Original value: $%,.2f\n", originalValue);
            System.out.printf("| Current Value: $%,.2f\n", currentValue);

            // house asset subclass info
            if(asset instanceof House){
                // if instance of house downcast to house
                House house = (House) asset;
                String address = house.getAddress();
                System.out.print("| Address: " + house.getAddress() + "\n");
                System.out.print("| Condition : " + house.getCondition() + "\n");
            }

            // vehicle asset subclass info
            if(asset instanceof Vehicle){
                // if instance of vehicle downcast to vehicle
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("| Make/Mode: " + vehicle.getMakeModel());
                System.out.printf("| Odometer: %,d\n",vehicle.getOdometer());
                System.out.println("| Year: " + vehicle.getYear());
            }
            // end of each asset
            System.out.println("---------------------------------------------\n");
        }
    }

}
