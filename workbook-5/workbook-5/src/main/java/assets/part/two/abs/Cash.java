package assets.part.two.abs;

public class Cash extends Asset{
    // private members
    private double amount;

    // constructor
    public Cash(String description, String dateAcquired, double originalCost, double amount){
        super(description,dateAcquired,originalCost);
        this.amount = amount;
    }

    public double getValue(){
        return amount;
    }
}
