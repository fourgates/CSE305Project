package com.teamusa.model;

public class UserHasAccount {
	
	private int userID;
	private int accountNumber;
	
	public UserHasAccount(int userID, int accountNumber) {
		this.userID = userID;
		this.accountNumber = accountNumber;
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
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}
