package com.pluralsight.finance;

public class House extends FixedAsset{

    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    public House(String name, double marketValue, int yearBuilt, int squareFeet, int bedrooms) {
        super(name, marketValue);
        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    @Override
    public double getValue(){
        return squareFeet;
    }

    @Override
    public String toString() {
        return String.format("House Info: \n" +
                        "Year Built: %d\n" +
                        "Square Feet: %d\n" +
                        "Bedrooms: %d\n",
                yearBuilt, squareFeet, bedrooms);
    }
}
