package asset.manager;

public class House extends Asset{
    // members
    private String address;
    private int condition; // 1-4 : 1 being excellent 4 being poor.
    private int squareFoot;
    private int lotSize;

    // constructor of derived class
    public House(String description, String dateAcquired, double originalCost,
                 String address, int condition,int squareFoot, int lotSize){
        super(description,dateAcquired,originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    // getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public double getValue() {
        double costPerSquareFoot = 0;

        switch(condition) {
            case 1:
                costPerSquareFoot = 180.00;
                break;
            case 2:
                costPerSquareFoot = 130.00;
                break;
            case 3:
                costPerSquareFoot = 90.00;
                break;
            case 4:
                costPerSquareFoot = 80.00;
                break;
            default:
                return 0; // Return 0 for invalid condition
        }

        // Calculate the total cost based on the condition and square footage
        double totalCost = costPerSquareFoot * squareFoot;

        // Add 25 cents per square foot of lot size
        double tax = lotSize * 0.25;

        // Add the tax to the total cost
        totalCost += tax;

        return totalCost;
    }

}

