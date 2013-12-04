package com.teamusa.model;

import java.util.Date;

public class Comment {
	
	private int commentID;
	// may need to be java.sql.Timestamp
	private Date date;
	private String content;
	private int post;
	private int author;
	/**
	 * @return the commentID
	 */
	public int getCommentID() {
		return commentID;
	}
	/**
	 * @param commentID the commentID to set
	 */
	public void setCommentID(int commentID) {
		this.commentID = commentID;
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
	 * @return the post
	 */
	public int getPost() {
		return post;
	}
	/**
	 * @param post the post to set
	 */
	public void setPost(int post) {
		this.post = post;
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
