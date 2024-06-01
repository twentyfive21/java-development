// This package declaration specifies the package to which this class belongs.
package com.pluralsight.NorthwindTradersAPI.dao;

// Import necessary classes from external libraries.
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;

// This annotation indicates that this class contains configuration metadata for Spring.
@Configuration
public class DataConfiguration {

    // Declare a private variable for BasicDataSource.
    private BasicDataSource basicDataSource;

    // This annotation indicates that this method produces a bean to be managed by the Spring container.
    @Bean
    public DataSource dataSource(){
        // Return the configured BasicDataSource as a DataSource bean.
        return basicDataSource;
    }

    // Constructor for DataConfiguration class. The @Autowired annotation tells Spring to automatically inject
    // the values for the parameters from the application's properties file.
    @Autowired
    public DataConfiguration (
            @Value("${datasource.url}") String url,       // Injects the database URL from application properties.
            @Value("${datasource.username}") String username, // Injects the database username from application properties.
            @Value("${datasource.password}") String password // Injects the database password from application properties.
    ) {
        // Initialize the BasicDataSource object.
        basicDataSource = new BasicDataSource();

        // Set the database URL.
        basicDataSource.setUrl(url);

        // Set the database username.
        basicDataSource.setUsername(username);

        // Set the database password.
        basicDataSource.setPassword(password);
    }
}

