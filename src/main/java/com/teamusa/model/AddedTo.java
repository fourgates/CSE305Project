package com.teamusa.model;

public class AddedTo {
	
	private int userID;
	private int circleID;
	
	public AddedTo(int userID, int circleID) {
		this.userID = userID;
		this.circleID = circleID;
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
	 * @return the circleID
	 */
	public int getCircleID() {
		return circleID;
	}
	/**
	 * @param circleID the circleID to set
	 */
	public void setCircleID(int circleID) {
		this.circleID = circleID;
	}

}
