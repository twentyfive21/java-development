package com.pluralsight.portfolio;

import com.pluralsight.finance.Valuable;

import java.util.List;

public class Portfolio {
    private String name;
    private String owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public void add(Valuable asset){
            assets.add(asset);
    }

    public double getValue(){
        double total = 0;
        for (Valuable valuable : assets){
            total += valuable.getValue();
        }
        return total;
    }

    public Valuable getMostValuable(){
        Valuable item = null;
        double current = 0;
        for (Valuable valuable : assets){

            if (valuable.getValue() > current){
                current = valuable.getValue();
                item = valuable;
            }
        }
        return item;
    }

    public Valuable getLeastValuable(){
        Valuable item = null;
        double current = Double.MAX_VALUE; // Initialize to maximum possible value

        for (Valuable valuable : assets){

            if (valuable.getValue() < current){
                current = valuable.getValue();
                item = valuable;
            }
        }
        return item;
    }

}
