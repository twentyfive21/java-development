package com.pluralsight;

import java.util.List;

public interface ProductDao {
    // interfaces just put void if not return type (double)
    void add(Product product);

     List<Product> getAll();

}
