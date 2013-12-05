/**
 * 
 */
package com.teamusa.controller;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamusa.model.AddedTo;
import com.teamusa.model.Circle;
import com.teamusa.model.Comment;
import com.teamusa.model.Message;
import com.teamusa.model.Post;
import com.teamusa.model.Purchase;
import com.teamusa.model.User;
import com.teamusa.model.UserLikesComment;
import com.teamusa.model.UserLikesPost;

/**
 * @author phillipninan
 *
 */

@Controller
@RequestMapping("/customer")
public class CustomerController extends AbstractController
{
	@RequestMapping("/accountHistory")
	public String accountHistory()
	{
		return "/customer/accountHistory";
	}
	
	@RequestMapping("/comment")
	public String comment()
	{
		return "/customer/comment";
	}
	
	@RequestMapping("/circle")
	public String circle()
	{
		return "/customer/circle";
	}
	
	@RequestMapping("/message")
	public String message()
	{
		return "/customer/message";
	}
	
	@RequestMapping("/post")
	public String post()
	{
		return "/customer/post";
	}
	
	@RequestMapping("/profile")
	public String profile()
	{
		return "/customer/profile";
	}
	
	@RequestMapping("/purchasePage")
	public String purchasePage()
	{
		return "/customer/purchasePage";
	}
	
	@RequestMapping("/purchaseConfirm")
	public String purchaseConfirm()
	{
		return "/customer/purchaseConfirm";
	}
	
	@RequestMapping("/searchResult")
	public String searchResult()
	{
		return "/customer/searchResult";
	}
	
	public void createCircle(int id, String name, int owner, String type) {
		Circle circle = new Circle(id, name, owner, type);
		this.circleDAO.insert(circle);
	}
	
	public User findUser(String column, String val) {
		String[] columns = {column};
		String[] vals = {" = " + val};
		return this.userDao.findByValue(columns, vals);
	}
	
	public void addUserToCircle(int id, int circle) {
		AddedTo addedTo = new AddedTo(id, circle);
		this.addedToDao.insert(addedTo);
	}
	
	public void removeFromCircle(int id, int circle) {
		this.addedToDao.delete("User_Id = " + id + " AND " + "Circle_Id = " + circle);
	}
	
	public void makePost(int id, Date date, String content, int commentCount, int circle, int author) {
		Post post = new Post(id, date, content, commentCount, circle, author);
		this.postDao.insert(post);
	}
	
	public void makeComment(int id, Date date, String content, int post, int author) {
		Comment comment = new Comment(id, date, content, post, author);
		this.commentDao.insert(comment);
	}
	
	public void likePost(int user, int post) {
		UserLikesPost ulp = new UserLikesPost(user, post);
		this.ulpDao.insert(ulp);
	}
	
	public void likeComment(int user, int comment) {
		UserLikesComment ulc = new UserLikesComment(user, comment);
		this.ulcDao.insert(ulc);
	}
	
	public void removeUserFromCircle(int user, int circle) {
		this.addedToDao.delete("User_Id = " + user + " AND Circle_Id = " + circle);
	}
	
	public void removePost(int id) {
		this.postDao.delete("Post_Id = " + id);
	}
	
	public void removeComment(int id) {
		this.commentDao.delete("Comment_Id = " + id);
	}
	
	public void unlikePost(int user, int post) {
		this.ulpDao.delete("User = " + user + " AND Post = " + post);
	}
	
	public void unlikeComment(int user, int comment) {
		this.ulcDao.delete("User = " + user + " AND Comment = " + comment);
	}
	
	public void modifyPost(int post, String column, String val) {
		this.postDao.update(column, val, "Post_Id = " + post);
	}
	
	public void modifyComment(int comment, String column, String val) {
		this.commentDao.update(column, val, "Comment_Id = " + comment);
	}
	
	public void deleteCircle(int id) {
		this.circleDAO.delete("Circle_Id = " + id);
	}
	
	public void modifyCircle(int id, String column, String val) {
		this.circleDAO.update(column, val, "Circle_Id = " + id);
	}
	
	public void sendMessage(int id, Date date, String subject, String content, int sender, int receiver) {
		Message message = new Message(id, date, subject, content, sender, receiver);
		this.messageDao.insert(message);
	}
	
	public ArrayList<Message> showAllReceivedMessages(int receiver) {
		String[] columns = {"Receiver"};
		String[] vals = {" = " + receiver};
		return this.messageDao.findAllByValue(columns, vals);
	}
	
	public Message viewMessage(int id) {
		String[] columns = {"Message_Id"};
		String[] vals = {" = " + id};
		return this.messageDao.findByValue(columns, vals);
	}
	
	public void deleteMessage(int id) {
		this.messageDao.delete("Message_Id = " + id);
	}
	
	public void purchaseItem(int id, Date date, int ad, int numUnits, int account, int user) {
		Purchase purchase = new Purchase(id, date, ad, numUnits, account, user);
		this.purchaseDao.insert(purchase);
	}
	
}
