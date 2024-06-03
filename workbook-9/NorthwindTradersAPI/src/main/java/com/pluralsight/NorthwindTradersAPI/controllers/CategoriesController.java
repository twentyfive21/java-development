package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    private CategoryDao categoryDao;

    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping(path="/categories", method=RequestMethod.GET)
    public List<Category> getCategories(){

//    List<Category> allCategories = new ArrayList<>();

//    allCategories.add(new Category(1, "Dairy"));
//    allCategories.add(new Category(2, "Snacks"));
//
//    return allCategories;
       return categoryDao.getAll();
    }

    @RequestMapping(path="/categories/{id}", method=RequestMethod.GET)
    public Category getCategoriesById(@PathVariable int id){
//        for(Category category : getCategories()){
//            if(category.getCategoryId() == id){
//                return category;
//            }
//        }
//        return null;
        return categoryDao.getById(id);

    }

    @RequestMapping(path="/categories", method =RequestMethod.POST)
    // request body needed if posting!
    public Category insert(@RequestBody Category category){
        return categoryDao.insert(category);
    }


}

