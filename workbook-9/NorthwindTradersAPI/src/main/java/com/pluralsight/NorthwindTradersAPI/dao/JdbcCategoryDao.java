package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDao implements CategoryDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Category> getAll() {
        List<Category> allCategories = new ArrayList<>();
    try{
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM northwind.Categories;");
                ){
                // set string if needed
                try(
                        ResultSet resultSet = preparedStatement.executeQuery();
                        ){
                    while (resultSet.next()){
                        int categoryId = resultSet.getInt("CategoryID");
                        String categoryName = resultSet.getString("CategoryName");
                        // String description = resultSet.getString("Description");
                        Category category = new Category(categoryId,categoryName);
                        allCategories.add(category);
                    }
                }
        }

    }catch (SQLException e){
        e.printStackTrace();
        System.out.println("Error getting categories");
    }
    return allCategories;
    }

    @Override
    public Category getById(int id) {
        Category categoryMatch = null;
        try{
            try(
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM northwind.Categories WHERE CategoryID = ?;");
            ){
                // set string if needed
                preparedStatement.setInt(1,id);
                try(
                        ResultSet resultSet = preparedStatement.executeQuery();
                ){
                    while (resultSet.next()){
                        int categoryId = resultSet.getInt("CategoryID");
                        String categoryName = resultSet.getString("CategoryName");
                        // String description = resultSet.getString("Description");
                        Category category = new Category(categoryId,categoryName);
                        categoryMatch = category;
                    }
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error getting categories");
        }
        return categoryMatch;
    }
}
