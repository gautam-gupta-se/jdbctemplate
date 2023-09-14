package com.springcore.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springcore.jdbc.entity.Customer;
import com.springcore.jdbc.utils.CustomerMapper;

import javax.sql.DataSource;
import java.util.List;

public class CustomerDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create operation
    public void createCustomer(Customer customer) { 
        //INSERT INTO Customer (id, name, address) VALUES (10,'Gautam Gupta', 'sec 132 Noida');
        //jdbcTemplate.update(sql, customer.getId(), customer.getName(), customer.getAddress());
    	String sql = "INSERT INTO Customer (name, address) VALUES (?, ?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getAddress());
    }

    // Read operation
	public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        RowMapper<Customer> mapper = new CustomerMapper();
        return jdbcTemplate.queryForObject(sql, new Object[]{id},  mapper);
        //return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerMapper());
        //return jdbcTemplate.query(sql, mapper, id).get(0);
        
    }

    // Update operation
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE Customer SET name = ?, address = ? WHERE id = ?";
        jdbcTemplate.update(sql, customer.getName(), customer.getAddress(), customer.getId());
    }

    // Delete operation
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // List all customers
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM Customer";
        return jdbcTemplate.query(sql, new CustomerMapper());
    }
}
