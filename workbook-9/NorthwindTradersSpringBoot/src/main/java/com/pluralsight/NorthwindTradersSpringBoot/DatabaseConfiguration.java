package com.pluralsight.NorthwindTradersSpringBoot;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
    private BasicDataSource basicDataSource;
    @Bean
    public DataSource dataSource(){
        return basicDataSource;
    }
    @Autowired
    public DatabaseConfiguration (@Value("${datasource.url}") String url,
                           @Value("${datasource.username}") String username,
                           @Value("${datasource.password}") String password)
    {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        // print the values to the screen just to verify it worked
        System.out.println(url + " : " + username + " : " + password);
    }
}
