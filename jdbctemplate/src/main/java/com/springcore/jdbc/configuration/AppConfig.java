package com.springcore.jdbc.configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.springcore.jdbc.dao.CustomerDAO;

@Configuration
public class AppConfig {

    // Configure the DataSource
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbctemplatedemo");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    // Configure JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    // Define the CustomerDAO bean
    @Bean
    public CustomerDAO customerDAO() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.setJdbcTemplate(jdbcTemplate());
        return customerDAO;
    }
}
