package com.teamusa.model;

import java.sql.Date;

public class Post {
	
	private int postID;
	// may need to be java.sql.Timestamp
	private Date date;
	private String content;
	private int commentCount;
	private int circle;
	private int author;
	
	public Post(int postID, Date date, String content, int commentCount, int circle, int author) {
		this.postID = postID;
		this.date = date;
		this.content = content;
		this.commentCount = commentCount;
		this.circle = circle;
		this.author = author;
	}
	/**
	 * @return the postID
	 */
	public int getPostID() {
		return postID;
	}
	/**
	 * @param postID the postID to set
	 */
	public void setPostID(int postID) {
		this.postID = postID;
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
	 * @return the commentCount
	 */
	public int getCommentCount() {
		return commentCount;
	}
	/**
	 * @param commentCount the commentCount to set
	 */
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	/**
	 * @return the circle
	 */
	public int getCircle() {
		return circle;
	}
	/**
	 * @param circle the circle to set
	 */
	public void setCircle(int circle) {
		this.circle = circle;
	}
	/**
	 * @return the author
	 */
	public int getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(int author) {
		this.author = author;
	}

}
