package com.teamusa.app;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teamusa.dao.AccountDAO;
import com.teamusa.dao.impl.EmployeeDAO;
import com.teamusa.model.Account;
import com.teamusa.model.Employee;
import com.teamusa.test.ManagerControllerTest;

//test program 
public class App 
{
	public static void main(String args[])
	{
		//get app context, instiate java beans
    	ApplicationContext context = 
        		new ClassPathXmlApplicationContext("root-context.xml");
    	ManagerControllerTest managerTest = new ManagerControllerTest() ;
    	EmployeeDAO employeeDAO = (EmployeeDAO)context.getBean("employeeDAO");
    	String[] columns = {"SSN"};
    	String[] vals = {" = 111222333"};
    	Employee e = employeeDAO.findByValue(columns, vals);
    	
    	ArrayList<Employee> list = employeeDAO.findAllByValue(columns, vals);
    	
    	employeeDAO.delete("SSN = 111222333");
    	
    	System.out.println(e.getHourlyRate());
    	System.out.println(list.get(0).getHourlyRate());
    		//get the jdbcCustomoerDAO
            //CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
            //AccountDAO accountDAO = (AccountDAO)context.getBean("accountDAO");
          
            
            
            
            //create new customer to test 
            //Customer customer = new Customer(2, "mkyong",28);
            //Account account = accountDAO.findByAccountNumber(90010101);
            
            //System.out.println("Account Status: "+account.getStatus());
            
            //test insert and findCustomerId
            //customerDAO.insert(customer);
            //Customer customer1 = customerDAO.findByCustomerId(1);
            
            //print name of newely added customer 
            //System.out.println(customer1.getName());
	}
}
