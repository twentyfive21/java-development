package asset.manager;

public class Vehicle extends Asset{
    // members
    private String makeModel;
    private int year;
    private int odometer;

    // derived class constructor
    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    // getters and setters
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        double reducedValue = getOriginalCost();
        double discountRate =0;
        // Determine the discount rate based on the age of the car
        if (year >= 0 && year <= 3) {
            discountRate = 0.03;
        } else if (year >= 4 && year <= 6) {
            discountRate = 0.06;
        } else if (year >= 7 && year <= 10) {
            discountRate = 0.08;
        } else {
            // If the car is over 10 years old, reduce the value by $1000
            reducedValue -= 1000;
        }

        // If the car is over 10 years old, further reduce the value using Math.pow()
        if (year < 10) {
            reducedValue *= Math.pow((1 - discountRate), year);
        }

        // Split the make and model from the string
        String make = getMakeModel().toLowerCase();
        // Check if the mileage is over 100,000 and if the brand's make is not Honda or Toyota
        if (getOdometer() > 100000 && (!make.contains("honda") && !make.contains("toyota"))) {
            // If both conditions are met, further reduce the value by 25%
            reducedValue *= 0.75; // 25% reduction
        }

        // Return the final reduced value
        return reducedValue;
    }

}
