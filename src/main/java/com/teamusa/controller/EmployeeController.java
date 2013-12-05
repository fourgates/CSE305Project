package com.teamusa.controller;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamusa.model.Advertisement;
import com.teamusa.model.Person;
import com.teamusa.model.Purchase;
import com.teamusa.model.User;

@Controller
@RequestMapping("employee")
public class EmployeeController extends AbstractController
{	
	@RequestMapping("/advertisement")
	public String advertisement()
	{
		return "/employee/advertisement";
	}
	
	@RequestMapping("/customerInfo")
	public String customerInfo()
	{
		return "/employee/customerInfo";
	}
	
	@RequestMapping("/employeeHome")
	public String employeeHome()
	{
		return "/employee/employeeHome";
	}
	
	@RequestMapping("/mailing_list")
	public String mailingList()
	{
		return "/employee/mailing_list";
	}
	
	@RequestMapping("/record_transaction")
	public String recordTransaction()
	{
		return "/employee/record_transaction";
	}
	
	@RequestMapping("/suggestion_list")
	public String suggestionList()
	{
		return "/employee/suggestion_list";
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
		String[] vals = {userId+""};
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
