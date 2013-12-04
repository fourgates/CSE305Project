/**
 * 
 */
package com.teamusa.model;

import java.sql.Date;

/**
 * @author Team USA
 *
 */
public class Account 
{
	int accountNumber;
	Date accountCreationDate;
	int creditCardNumber;
	String status;
	
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
	 * @return the creditCardNumber
	 */
	public int getCreditCardNumber() {
		return creditCardNumber;
	}
	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
