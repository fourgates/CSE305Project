package com.teamusa.model;

public class UserPreferences {
	
	private int id;
	private String preference;
	
	public UserPreferences(int id, String preference) {
		this.id = id;
		this.preference = preference;
	}
	/**
	 * @return the id
	 */
	public int getID() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setID(int id) {
		this.id = id;
	}
	/**
	 * @return the preference
	 */
	public String getPreference() {
		return preference;
	}
	/**
	 * @param preference the preference to set
	 */
	public void setPreference(String preference) {
		this.preference = preference;
	}

}
