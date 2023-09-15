package com.springcore.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

import com.springcore.jdbc.configuration.AppConfig;
import com.springcore.jdbc.dao.CustomerDAO;
import com.springcore.jdbc.entity.Customer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// to get xml config
		 //ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/jdbc/configuration/config.xml");
		  //CustomerDAO dao = context.getBean("customerDAO", CustomerDAO.class);
		

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerDAO dao = context.getBean(CustomerDAO.class);

		 // to use jdbc template 
		 //JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class); 
		 //template.update("INSERT INTO Customer (name, address) VALUES ('Tom', '123 Main Street')");
		 

		// create cutomer into db
//		Customer customer = new Customer();
//		customer.setId(100);
//		customer.setName("Pavan");
//		customer.setAddress("A-324 mayur vihar delhi");
//		dao.createCustomer(customer);
// sample github operation:
		
		//get customer by id 
		 Customer c =dao.getCustomerById(26);
		 System.out.println(c);
		 

		//to update the customer 
		//dao.updateCustomer(new Customer(16, "Ankit","Delhi"));
		 

		// delete by id
		//dao.deleteCustomer(11);

		// to get all customer
		List<Customer> cs = dao.getAllCustomers();
		for (Customer cust : cs) {
			System.out.println(cust.toString());
		}

		// ((AbstractApplicationContext) context).close();

	}
}
