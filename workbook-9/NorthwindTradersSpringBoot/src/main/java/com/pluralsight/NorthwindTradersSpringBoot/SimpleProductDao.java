package com.pluralsight.NorthwindTradersSpringBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

// Marks this class as a Spring component, making it a candidate for component scanning and dependency injection.
@Component
public class SimpleProductDao implements ProductDao {

    // A private list to store Product objects, representing the data storage.
    private List<Product> employees;

    // Constructor initializes the list and adds some sample products to it.
    public SimpleProductDao() {
        this.employees = new ArrayList<>();
        employees.add(new Product(1, "Orange", "Grocery", 1.99));
        employees.add(new Product(2, "Strawberry", "Grocery", 2.99));
        employees.add(new Product(3, "Lemon", "Grocery", 1.59));
        employees.add(new Product(4, "Blueberry", "Grocery", 4.99));
    }

    // Adds a new product to the list.
    @Override
    public void add(Product product) {
        employees.add(product);
    }

    // Returns the list of all products.
    @Override
    public List<Product> getAll() {
        return employees;
    }
}

