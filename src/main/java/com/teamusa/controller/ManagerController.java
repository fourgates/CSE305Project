/**
 * 
 */
package com.teamusa.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.TreeMap;

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
	
	@RequestMapping("/activeItem")
	public String handleActiveItem()
	{
		return "/manager/activeItem";
	}
	
	@RequestMapping("/advertisedItems")
	public String advertisedItems()
	{
		return "/manager/advertisedItems";
	}
	
	@RequestMapping("/customerByItem")
	public String customerByItem()
	{
		return "/manager/customerByItem";
	}
	
	@RequestMapping("/employeeInfo")
	public String employeeInfo()
	{
		return "/manager/employeeInfo";
	}
	
	@RequestMapping("/itemsByCompany")
	public String itemsByCompany()
	{
		return "/manager/itemsByCompany";
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
	
	@RequestMapping("/salesReport")
	public String salesReport()
	{
		return "/manager/salesReport";
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
	
	public int getHighestRevenueGeneratingEmployee() {
		TreeMap<Integer, Integer> employeeRevenue = new TreeMap<Integer, Integer>();
		ArrayList<Employee> employees = this.employeeDao.findAll();
		ArrayList<Purchase> purchases = this.purchaseDao.findAll();
		for (Employee employee : employees) {
			int sum = 0;
			String[] columns = {"Employee"};
			String[] vals = {employee.getSSN()+""};
			ArrayList<Advertisement> empAds = this.advertisementDao.findAllByValue(columns, vals);
			for (Purchase purchase : purchases) {
				for (Advertisement ad : empAds) {
					if (purchase.getAdvertisement() == ad.getAdvertisementID()) {
						sum += ad.getUnitPrice() * purchase.getNumberOfUnits();
					}
				}
			}
			employeeRevenue.put(sum, employee.getSSN());
		}
		return employeeRevenue.lastEntry().getValue();
	}
	
	public int getHighestRevenueGeneratingCustomer() {
		TreeMap<Integer, Integer> customerRevenue = new TreeMap<Integer, Integer>();
		ArrayList<User> users = this.userDao.findAll();
		ArrayList<Advertisement> ads = this.advertisementDao.findAll();
		for (User user : users) {
			int sum = 0;
			String[] columns = {"User"};
			String[] vals = {user.getUserID()+""};
			ArrayList<Purchase> userPurchases = this.purchaseDao.findAllByValue(columns, vals);
			for (Advertisement ad : ads) {
				for (Purchase purchase : userPurchases) {
					if (purchase.getAdvertisement() == ad.getAdvertisementID()) {
						sum += ad.getUnitPrice() * purchase.getNumberOfUnits();
					}
				}
			}
			customerRevenue.put(sum, user.getSSN());
		}
		return customerRevenue.lastEntry().getValue();
	}
	
	public ArrayList<String> getMostActiveItems() {
		TreeMap<Integer, String> activeItems = new TreeMap<Integer, String>();
		ArrayList<Advertisement> ads = this.advertisementDao.findAll();
		ArrayList<Purchase> purchases = this.purchaseDao.findAll();
		
		for (Advertisement ad : ads) {
			int sum = 0;
			for (Purchase purchase : purchases) {
				if (ad.getAdvertisementID() == purchase.getAdvertisement()) {
					sum += purchase.getNumberOfUnits();
				}
			}
			activeItems.put(sum, ad.getItemName());
		}
		ArrayList<String> items = (ArrayList<String>) activeItems.values();
		Collections.reverse(items);
		return items;
	}
	
	public ArrayList<Integer> getCustomersByItemPurchased(String itemName) {
		ArrayList<Integer> customers = new ArrayList<Integer>();
		String[] columns = {"Item_Name"};
		String[] vals = {itemName};
		ArrayList<Advertisement> itemAds = this.advertisementDao.findAllByValue(columns, vals);
		ArrayList<Purchase> purchases = this.purchaseDao.findAll();
		
		for (Purchase purchase : purchases) {
			for (Advertisement ad : itemAds) {
				if (purchase.getAdvertisement() == ad.getAdvertisementID()) {
					customers.add(purchase.getUser());
				}
			}
		}
		return customers;
	}
	
	public ArrayList<Advertisement> getAdsByCompany(String company) {
		String[] columns = {"Company"};
		String[] vals = {company};
		return this.advertisementDao.findAllByValue(columns, vals);
	}
}
