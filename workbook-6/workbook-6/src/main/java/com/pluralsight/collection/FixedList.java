package com.pluralsight.collection;

import java.util.ArrayList;
import java.util.List;

public class FixedList<T> {

    // private members
    private List<T> items = new ArrayList<>();
    private int maxSize;

    // constructor
    public FixedList(int maxSize) {
        this.maxSize = maxSize;
    }

    // methods/getters/setters
    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T item){
        if (items.isEmpty()){
            System.out.println("\n0 items currently");;
        }
        if(items.size() < maxSize){
            items.add(item);
            System.out.println("Item " + item +" added");
        } else {
            System.out.println("Error not enough space for " + item);
        }
    }

    @Override
    public String toString() {
        return "FixedList{" +
                "items=" + items +
                '}';
    }
}
