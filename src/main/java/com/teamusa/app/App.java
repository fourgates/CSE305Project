package com.teamusa.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teamusa.dao.CustomerDAO;
import com.teamusa.model.Customer;

//test program 
public class App 
{
	public static void main(String args[])
	{
		//get app context, instiate java beans
    	ApplicationContext context = 
        		new ClassPathXmlApplicationContext("root-context.xml");
    	
    		//get the jdbcCustomoerDAO
            CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
            
            //create new customer to test 
            Customer customer = new Customer(2, "mkyong",28);
            
            //test insert and findCustomerId
            customerDAO.insert(customer);
            Customer customer1 = customerDAO.findByCustomerId(1);
            
            //print name of newely added customer 
            System.out.println(customer1.getName());
	}
}
