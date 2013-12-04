package com.teamusa.model;

import java.sql.Date;

public class Advertisement {
	
	private int advertisementID;
	private int employee;
	private String type;
	// may need to be java.sql.Timestamp
	private Date date;
	private String company;
	private String itemName;
	private String content;
	private int unitPrice;
	// WARNING: misspelled in DB as 'Availabe_Units'
	private int availableUnits;
	
	public Advertisement(int advertisementID, int employee, String type, Date date, String company, String itemName,
			String content, int unitPrice, int availableUnits) {
		this.advertisementID = advertisementID;
		this.employee = employee;
		this.type = type;
		this.date = date;
		this.company = company;
		this.itemName = itemName;
		this.content = content;
		this.unitPrice = unitPrice;
		this.availableUnits = availableUnits;
	}
	/**
	 * @return the advertisementID
	 */
	public int getAdvertisementID() {
		return advertisementID;
	}
	/**
	 * @param advertisementID the advertisementID to set
	 */
	public void setAdvertisementID(int advertisementID) {
		this.advertisementID = advertisementID;
	}
	/**
	 * @return the employee
	 */
	public int getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(int employee) {
		this.employee = employee;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the unitPrice
	 */
	public int getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the availableUnits
	 */
	public int getAvailableUnits() {
		return availableUnits;
	}
	/**
	 * @param availableUnits the availableUnits to set
	 */
	public void setAvailableUnits(int availableUnits) {
		this.availableUnits = availableUnits;
	}

}
