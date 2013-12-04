package com.teamusa.model;

import java.util.Date;

public class User {
	
	private int SSN;
	private int userID;
	// This might have to be java.sql.Timestamp
	private Date accountCreationDate;
	private int rating;
	/**
	 * @return the ssn
	 */
	public int getSSN() {
		return SSN;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSSN(int ssn) {
		this.SSN = ssn;
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return the accountCreationDate
	 */
	public Date getAccountCreationDate() {
		return accountCreationDate;
	}
	/**
	 * @param accountCreationDate the accountCreationDate to set
	 */
	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

}
