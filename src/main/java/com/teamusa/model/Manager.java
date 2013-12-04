package com.teamusa.model;

import java.util.Date;

public class Manager {
	
	private int SSN;
	// may need to be java.sql.Timestamp
	private Date startDate;
	private int hourlyRate;
	/**
	 * @return the sSN
	 */
	public int getSSN() {
		return SSN;
	}
	/**
	 * @param sSN the sSN to set
	 */
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the hourlyRate
	 */
	public int getHourlyRate() {
		return hourlyRate;
	}
	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

}
