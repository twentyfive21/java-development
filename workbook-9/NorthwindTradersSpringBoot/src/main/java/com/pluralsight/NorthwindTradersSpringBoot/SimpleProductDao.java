package com.pluralsight.NorthwindTradersSpringBoot;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SimpleProductDao implements ProductDao {

    private List<Product> products;

    public SimpleProductDao() {
        this.products = new ArrayList<>();
        products.add(new Product(1, "Orange", "Grocery", 1.99));
        products.add(new Product(2, "Strawberry", "Grocery", 2.99));
        products.add(new Product(3, "Lemon", "Grocery", 1.59));
        products.add(new Product(4, "Blueberry", "Grocery", 4.99));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}


