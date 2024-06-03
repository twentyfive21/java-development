package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Product;
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
public class JdbcProductDao implements ProductDao{

    @Autowired
    private DataSource dataSource;


    @Override
    public List<Product> getAll() {
        List<Product> allProducts = new ArrayList<>();
        try{
            try(
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Products");
                    ){
                    // set if there are ?
                    try(
                            ResultSet resultSet = preparedStatement.executeQuery();

                            ){
                        while (resultSet.next()){
                            int productId = resultSet.getInt("ProductID");
                            String productName = resultSet.getString("ProductName");
                            int categoryId = resultSet.getInt("CategoryID");
                            double unitPrice = resultSet.getDouble("UnitPrice");
                            Product product = new Product(productId,productName,categoryId,unitPrice);
                            allProducts.add(product);
                        }
                    }
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error in getting all products");
        }
        return allProducts;
    }

    @Override
    public Product getById(int id) {
        Product productMatch = null;
        try{
            try(
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement =
                            connection.prepareStatement("SELECT * FROM Products WHERE ProductID = ?;");
                    ){
                    preparedStatement.setInt(1, id);
                    try(
                            ResultSet resultSet = preparedStatement.executeQuery();
                            ){
                        while(resultSet.next()){
                            int productId = resultSet.getInt("ProductID");
                            String productName = resultSet.getString("ProductName");
                            int categoryId = resultSet.getInt("CategoryID");
                            double unitPrice = resultSet.getDouble("UnitPrice");
                            Product product = new Product(productId,productName,categoryId,unitPrice);
                            productMatch = product;
                        }
                    }
            }
        }catch (SQLException e){
            System.out.println("Error getting product by id");
            e.printStackTrace();
        }
        return productMatch;
    }

    @Override
    public Product insert(Product product) {
        try{
            try(
                    Connection connection = dataSource.getConnection();
                    // "Chips",5,5.99
                    PreparedStatement preparedStatement =
                            connection.prepareStatement("INSERT INTO Products (ProductName,CategoryID,unitPrice)VALUES(?,?,?);",
                                    PreparedStatement.RETURN_GENERATED_KEYS);
                    ){
                    preparedStatement.setString(1,product.getProductName());
                    preparedStatement.setInt(2,product.getCategoryId());
                    preparedStatement.setDouble(3,product.getUnitPrice());

                    int affectedRows = preparedStatement.executeUpdate();
                    try(
                            ResultSet resultSet = preparedStatement.getGeneratedKeys();
                            ){
                        if(resultSet.next()){
                            // In JDBC, when retrieving generated keys using
                            // PreparedStatement.getGeneratedKeys(), the ResultSet
                            // returned often uses column indexes rather than column names.
                            int productId = resultSet.getInt(1);
                            product.setProductId(productId);
                        }
                    }

            }


        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error adding to product table");
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {
        try{
            try(
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement =
                            connection.prepareStatement("UPDATE Products SET ProductName = ?, UnitPrice = ? WHERE ProductID = ?;");
                    ){
                //    private int productId;
                //    private String productName;
                //    private int categoryId;
                //    private double unitPrice;
                preparedStatement.setString(1, product.getProductName());
                preparedStatement.setDouble(2, product.getUnitPrice());
                preparedStatement.setInt(3,id);
                preparedStatement.executeUpdate();

            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error updating product");
        }
    }

    @Override
    public void delete(int id) {
        try{
            try(
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement =
                            connection.prepareStatement("DELETE FROM Products WHERE ProductID = ?;");
                    ){
                    preparedStatement.setInt(1,id);
                    preparedStatement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error deleting from product table");
        }
    }

}
