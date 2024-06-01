package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    @RequestMapping(path="/categories", method=RequestMethod.GET)
    public List<Category> getCategories(){

    List<Category> allCategories = new ArrayList<>();

    allCategories.add(new Category(1, "Dairy"));
    allCategories.add(new Category(2, "Snacks"));

    return allCategories;
    }

    @RequestMapping(path="/categories/{id}", method=RequestMethod.GET)
    public Category getCategoriesById(@PathVariable int id){
        for(Category category : getCategories()){
            if(category.getCategoryId() == id){
                return category;
            }
        }
        return null;
    }
}

