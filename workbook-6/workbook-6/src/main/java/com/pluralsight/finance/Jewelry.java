package com.pluralsight.finance;

public class Jewelry extends FixedAsset {
    private double karat;

    public Jewelry(String name, double marketValue, double karat) {
        super(name, marketValue);
        this.karat = karat;
    }

    @Override
    public double getValue(){
        return karat;
    }

    @Override
    public String toString() {
        return String.format("Jewelry weight= %.2f ",karat);
    }
}
