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

                        }
                    }
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error in getting all products");
        }
//        return List.of();
    }

    @Override
    public Product getById(int id) {
//        return null;
    }
}
