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

    @Override
    public Category insert(Category category) {
        try{
            try(
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement =
                            connection.prepareStatement("INSERT INTO Categories (CategoryName) VALUES (?);",
                                    PreparedStatement.RETURN_GENERATED_KEYS);
                    ){
                        preparedStatement.setString(1, category.getCategoryName());
                        int affectedRows = preparedStatement.executeUpdate();
                        try(
                                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                                ){
                            if(resultSet.next()){
                                // In JDBC, when retrieving generated keys using
                                // PreparedStatement.getGeneratedKeys(), the ResultSet
                                // returned often uses column indexes rather than column names.
                                int categoryId = resultSet.getInt(1);
                                category.setCategoryId(categoryId);
                            }
                        }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error inserting to category table");
        }
    return category;
    }


    @Override
    public void update(int id, Category category) {
        try{
            try(
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement =
                            connection.prepareStatement("UPDATE Categories SET CategoryName = ? WHERE CategoryID = ?;");
                    ){
                    preparedStatement.setString(1,category.getCategoryName());
                    preparedStatement.setInt(2,category.getCategoryId());
                    preparedStatement.executeUpdate();

            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error updating category");
        }
    }
}
