package com.teamusa.model;

import java.util.Date;

public class Purchase {
	
	private int transactionID;
	// may need to be java.sql.Timestamp
	private Date date;
	private int advertisement;
	private int numberOfUnits;
	private int account;
	private int user;
	/**
	 * @return the transactionID
	 */
	public int getTransactionID() {
		return transactionID;
	}
	/**
	 * @param transactionID the transactionID to set
	 */
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
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
	 * @return the advertisement
	 */
	public int getAdvertisement() {
		return advertisement;
	}
	/**
	 * @param advertisement the advertisement to set
	 */
	public void setAdvertisement(int advertisement) {
		this.advertisement = advertisement;
	}
	/**
	 * @return the numberOfUnits
	 */
	public int getNumberOfUnits() {
		return numberOfUnits;
	}
	/**
	 * @param numberOfUnits the numberOfUnits to set
	 */
	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	/**
	 * @return the account
	 */
	public int getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(int account) {
		this.account = account;
	}
	/**
	 * @return the user
	 */
	public int getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(int user) {
		this.user = user;
	}

}
