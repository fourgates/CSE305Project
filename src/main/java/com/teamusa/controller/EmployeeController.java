package com.teamusa.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamusa.dao.impl.AdvertisementDAO;
import com.teamusa.dao.impl.PersonDAO;
import com.teamusa.dao.impl.UserDAO;
import com.teamusa.model.Advertisement;
import com.teamusa.model.Person;
import com.teamusa.model.Purchase;
import com.teamusa.model.User;

@Controller
@RequestMapping(value = "employee",method = RequestMethod.GET)
public class EmployeeController extends AbstractController
{	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@RequestMapping(value = "/advertisement",method = RequestMethod.GET)
	public String advertisement(HttpServletRequest request)
	{
		ApplicationContext context = 
        		new ClassPathXmlApplicationContext("root-context.xml");
		
		//get addvertisement bean
		AdvertisementDAO addDAO = (AdvertisementDAO)context.getBean("addDAO");
		
		//get all adds
		ArrayList<Advertisement> advertisements = addDAO.findAll();

		request.setAttribute("AddList", advertisements);
		logger.info("Add Size: "+advertisements.size());
		System.out.println("Add Size: "+advertisements.size());
		
		return "/employee/advertisement";
	}
	
	@RequestMapping(value = "/customerInfo", method = RequestMethod.GET)
	public String customerInfo(HttpServletRequest request)
	{
		ApplicationContext context = 
        		new ClassPathXmlApplicationContext("root-context.xml");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		System.out.println(name);
		
		//get user bean
		UserDAO userDAO = (UserDAO)context.getBean("userDAO");
		
		ArrayList<User> userList = userDAO.findAll();
		//userDAO.f
		
		//add bean to model
		request.setAttribute("userList", userList);
		
		return "/employee/customerInfo";
	}
	
	@RequestMapping("/employeeHome")
	public String employeeHome()
	{
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String name = auth.getName(); //get logged in username
		return "/employee/employeeHome";
	}
	
	@RequestMapping("/mailingList")
	public String mailingList(HttpServletRequest request)
	{	
		ApplicationContext context = 
        		new ClassPathXmlApplicationContext("root-context.xml");
		
		PersonDAO personDAO = (PersonDAO)context.getBean("personDAO");
		
		ArrayList<Person> people = personDAO.findAll();
		
		request.setAttribute("people", people);
		return "/employee/mailingList";
	}
	
	@RequestMapping("/recordTransaction")
	public String recordTransaction()
	{
		return "/employee/recordTransaction";
	}
	
	@RequestMapping("/suggestionList")
	public String suggestionList()
	{
		return "/employee/suggestionList";
	}
	
	public void createAdvertisement(int id, int employee, String type, Date date, String company,
			String itemName, String content, int unitPrice, int availableUnits) {
		Advertisement ad = new Advertisement(id, employee, type, date, company, itemName, content, unitPrice, availableUnits);
		this.advertisementDao.insert(ad);
	}
	
	public void deleteAdvertisement(int id) {
		this.advertisementDao.delete("Advertisement_Id="+id);
	}
	
	public void createPurchase(int id, Date date, int ad, int numberOfUnits, int account, int user) {
		Purchase purchase = new Purchase(id, date, ad, numberOfUnits, account, user);
		this.purchaseDao.insert(purchase);
	}
	
	public void addCustomer(int SSN, int userId, Date creationDate, int rating,
			String lastName, String firstName, String address, String city, String state,
			int zipcode, int telephoneNumber, String emailAddress) {
		User user = new User(SSN, userId, creationDate, rating);
		this.userDao.insert(user);
		Person person = new Person(SSN, lastName, firstName, address, city, state, zipcode, telephoneNumber, emailAddress);
		this.personDao.insert(person);
	}
	
	public void editCustomer(int SSN, String column, String value) {
		if (column.equals("User_Id") || column.equals("Account_Creation_Date") || column.equals("Rating")) {
			this.userDao.update(column, value, "SSN="+SSN);
		} else if (column.equals("SSN")) {
			this.userDao.update(column, value, "SSN="+SSN);
			this.personDao.update(column, value, "SSN="+SSN);
		} else {
			this.personDao.update(column, value, "SSN="+SSN);
		}
	}
	
	public void deleteCustomer(int SSN) {
		this.userDao.delete("SSN="+SSN);
	}
	
	public ArrayList<String> getCustomerMailingList() {
		ArrayList<String> emails = new ArrayList<String>();
		ArrayList<User> users = this.userDao.findAll();
		ArrayList<Person> persons = this.personDao.findAll();
		
		for (User user : users) {
			for (Person person : persons) {
				if (user.getSSN() == person.getSSN()) {
					emails.add(person.getEmailAddress());
				}
			}
		}
		return emails;
	}
	
	public ArrayList<Advertisement> getItemSuggestions(int userId) {
		String[] columns = {"User"};
		String[] vals = {" = " + userId};
		ArrayList<Purchase> userPurchases = this.purchaseDao.findAllByValue(columns, vals);
		ArrayList<String> preferredTypes = new ArrayList<String>();
		ArrayList<Advertisement> ads = this.advertisementDao.findAll();
		ArrayList<Advertisement> suggestions = new ArrayList<Advertisement>();
		
		for (Advertisement ad : ads) {
			for (Purchase purchase : userPurchases) {
				if (purchase.getAdvertisement() == ad.getAdvertisementID()) {
					preferredTypes.add(ad.getType());
				}
			}
		}
		for (Advertisement ad : ads) {
			for (String type : preferredTypes) {
				if (ad.getType().equals(type)) {
					suggestions.add(ad);
				}
			}
		}
		return suggestions;
	}
}
