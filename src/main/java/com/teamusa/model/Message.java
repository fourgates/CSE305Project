package com.teamusa.model;

import java.sql.Date;

public class Message {
	
	private int messageID;
	// may need to be java.sql.Timestamp
	private Date date;
	private String subject;
	private String content;
	private int sender;
	private int receiver;
	
	public Message(int messageID, Date date, String subject, String content, int sender, int receiver) {
		this.messageID = messageID;
		this.date = date;
		this.subject = subject;
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
	}
	/**
	 * @return the messageID
	 */
	public int getMessageID() {
		return messageID;
	}
	/**
	 * @param messageID the messageID to set
	 */
	public void setMessageID(int messageID) {
		this.messageID = messageID;
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
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
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
	 * @return the sender
	 */
	public int getSender() {
		return sender;
	}
	/**
	 * @param sender the sender to set
	 */
	public void setSender(int sender) {
		this.sender = sender;
	}
	/**
	 * @return the receiver
	 */
	public int getReceiver() {
		return receiver;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

}
