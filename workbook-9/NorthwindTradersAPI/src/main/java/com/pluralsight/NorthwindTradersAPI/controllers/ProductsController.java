package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    @RequestMapping(path="/products", method= RequestMethod.GET)
    public List<Product> getAllProducts(){

//        List<Product> allProducts = new ArrayList<>();
//        allProducts.add(new Product(1, "Candy", 2, 3.99));
//        allProducts.add(new Product(2, "Grapes", 1, 6.99));
//
//        return allProducts;
    }

    @RequestMapping(path="/products/{id}", method=RequestMethod.GET)
    public Product getProductById(@PathVariable int id){
//
//        for(Product product : getAllProducts()){
//            if(product.getProductId() == id){
//                return product;
//            }
//        }
//        return null;
    }
}
