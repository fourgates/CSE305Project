/**
 * 
 */
package com.teamusa.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamusa.model.Advertisement;
import com.teamusa.model.Employee;
import com.teamusa.model.Person;
import com.teamusa.model.Purchase;
import com.teamusa.model.User;

/**
 * @author phillipninan
 *
 */
@Controller
@RequestMapping("/manager")
public class ManagerController extends AbstractController {
	
	@RequestMapping("/active_item")
	public String handleActiveItem()
	{
		return "/manager/active_item";
	}
	
	@RequestMapping("/advertised_items")
	public String advertisedItems()
	{
		return "/manager/advertised_items";
	}
	
	@RequestMapping("/customer_by_item")
	public String customerByItem()
	{
		return "/manager/customer_by_item";
	}
	
	@RequestMapping("/employeeInfo")
	public String employeeInfo()
	{
		return "/manager/employeeInfo";
	}
	
	@RequestMapping("/items_by_company")
	public String itemsByCompany()
	{
		return "/manager/items_by_company";
	}
	
	@RequestMapping("/managerHome")
	public String managerHome()
	{
		return "/manager/managerHome";
	}
	
	@RequestMapping("/revenue")
	public String revenue()
	{
		return "/manager/revenue";
	}
	
	@RequestMapping("/sales_report")
	public String salesReport()
	{
		return "/manager/sales_report";
	}
	
	@RequestMapping("/transactions")
	public String managerTransactions()
	{
		return "/manager/transactions";
	}
	
	public void addEmployee(int SSN, Date startDate, int hourlyRate, int manager,
			String lastName, String firstName, String address, String city, String state, int zipcode, int telephoneNumber, String emailAddress) {
		Employee employee = new Employee(SSN, startDate, hourlyRate, manager);
		this.employeeDao.insert(employee);
		
		Person person = new Person(SSN, lastName, firstName, address, city, state, zipcode, telephoneNumber, emailAddress);
		this.personDao.insert(person);
	}
	
	public void editEmployee(int SSN, String column, String value) {
		if (column.equals("Start_Date") || column.equals("Hourly_Rate") || column.equals("Manager")) {
			this.employeeDao.update(column, value, "SSN="+SSN);
		} else if (column.equals("SSN")) {
			this.employeeDao.update(column, value, "SSN="+SSN);
			this.personDao.update(column, value, "SSN="+SSN);
		} else {
			this.personDao.update(column, value, "SSN="+SSN);
		}
	}
	
	public void deleteEmployee(int SSN) {
		this.employeeDao.delete("SSN="+SSN);
	}
	
	public ArrayList<Purchase> getSalesReport(int year, int month) {
		GregorianCalendar beforeCal = new GregorianCalendar();
		beforeCal.set(year, month, 1);
		GregorianCalendar afterCal = new GregorianCalendar();
		afterCal.set(year, month+1, 1);
		
		String[] columns = {"Date", "Date"};
		String[] vals = {" > " + beforeCal.getTime(), " < " + afterCal.getTime()};
		return this.purchaseDao.findAllByValue(columns, vals);
	}
	
	public ArrayList<Advertisement> getAllAds() {
		return this.advertisementDao.findAll();
	}
	
	public ArrayList<String> getTransactionItemNames() {
		ArrayList<Purchase> purchases = this.purchaseDao.findAll();
		ArrayList<Advertisement> ads = this.advertisementDao.findAll();
		
		ArrayList<String> itemNames = new ArrayList<String>();
		
		for (Purchase purchase : purchases) {
			for (Advertisement ad : ads) {
				if (purchase.getAdvertisement() == ad.getAdvertisementID())
					itemNames.add(ad.getItemName());
			}
		}
		return itemNames;
	}
	
	public ArrayList<String> getTransactionCustomerNames() {
		ArrayList<Purchase> purchases = this.purchaseDao.findAll();
		ArrayList<User> users = this.userDao.findAll();
		ArrayList<Person> persons = this.personDao.findAll();
		
		ArrayList<String> names = new ArrayList<String>();
		
		for (Purchase purchase : purchases) {
			for (User user : users) {
				for (Person person : persons) {
					if (purchase.getUser() == user.getUserID() && user.getSSN() == person.getSSN()) {
						String name = person.getLastName() + ", " + person.getFirstName();
						names.add(name);
					}
				}
			}
		}
		return names;
	}
	
	public int getRevenueByItem(String adColumn, String adVal) {
		int sum = 0;
		String[] columns = {adColumn};
		String[] vals = {adVal};
		ArrayList<Advertisement> ads = this.advertisementDao.findAllByValue(columns, vals);
		ArrayList<Purchase> purchases = this.purchaseDao.findAll();
		
		for (Purchase purchase : purchases) {
			for (Advertisement ad : ads) {
				if (purchase.getAdvertisement() == ad.getAdvertisementID()) {
					sum += purchase.getNumberOfUnits() * ad.getUnitPrice();
				}
			}
		}
		return sum;
	}
	
	public int getRevenueByCustomer(int userId) {
		int sum = 0;
		String[] columns = {"User"};
		String[] vals = {userId+""};
		ArrayList<Purchase> purchases = this.purchaseDao.findAllByValue(columns, vals);
		ArrayList<Advertisement> ads = this.advertisementDao.findAll();
		
		for (Advertisement ad : ads) {
			for (Purchase purchase : purchases) {
				if (purchase.getAdvertisement() == ad.getAdvertisementID()) {
					sum += purchase.getNumberOfUnits() * ad.getUnitPrice();
				}
			}
		}
		return sum;
	}
}
