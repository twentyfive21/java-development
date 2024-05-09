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

    public double getValue(){
        double cost = 0;
        switch(condition){
            case 1 : cost = 180.00;
                break;
            case 2 : cost = 130.00;
                break;
            case 3 : cost = 90.00;
                break;
            case 4 : cost = 80.00;
                break;
            default: cost = 0.00;
                break;
        }
        cost = cost + (squareFoot * .25);
        return cost;
    }
}

