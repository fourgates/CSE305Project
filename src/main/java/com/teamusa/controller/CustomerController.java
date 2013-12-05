/**
 * 
 */
package com.teamusa.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamusa.dao.impl.CircleDAO;
import com.teamusa.dao.impl.MessageDAO;
import com.teamusa.dao.impl.PersonDAO;
import com.teamusa.dao.impl.PostDAO;
import com.teamusa.dao.impl.PurchaseDAO;
import com.teamusa.dao.impl.UserDAO;
import com.teamusa.model.AddedTo;
import com.teamusa.model.Circle;
import com.teamusa.model.Comment;
import com.teamusa.model.Message;
import com.teamusa.model.Person;
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
@RequestMapping(value = "/customer")
public class CustomerController extends AbstractController {
	
	@RequestMapping(value = "/accountHistory", method = RequestMethod.GET)
	public String accountHistory(HttpServletRequest request) {
		
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String name = auth.getName(); //get logged in usernam	
		//System.out.println(name);
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"root-context.xml");

		// get bean
		PurchaseDAO purchaseDAO = (PurchaseDAO) context.getBean("purchaseDAO");

		// get list of circles
		ArrayList<Purchase> purchaseList = purchaseDAO.findAll();

		// set bean in view
		request.setAttribute("purchaseList", purchaseList);
		
		return "/customer/accountHistory";
	}

	@RequestMapping("/comment")
	public String comment() {
		return "/customer/comment";
	}

	@RequestMapping(value = "/circle", method = RequestMethod.GET)
	public String circle(HttpServletRequest request) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"root-context.xml");
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String name = auth.getName(); //get logged in usernam	
		// get bean
		CircleDAO circleDAO = (CircleDAO) context.getBean("circleDAO");

		// get list of circles
		ArrayList<Circle> circleList = circleDAO.findAll();

		// set bean in view
		request.setAttribute("circleList", circleList);

		return "/customer/circle";
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message(HttpServletRequest request) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"root-context.xml");
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String name = auth.getName(); //get logged in usernam	
		// get bean
		MessageDAO messageDAO = (MessageDAO) context.getBean("messageDAO");

		// get list of messages
		ArrayList<Message> messageList = messageDAO.findAll();

		// set bean in view
		request.setAttribute("messageList", messageList);

		return "/customer/message";
	}

	@RequestMapping("/post")
	public String post() {
		return "/customer/post";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(HttpServletRequest request) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"root-context.xml");
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String name = auth.getName(); //get logged in usernam	
		// get bean
		PostDAO postDAO = (PostDAO) context.getBean("postDAO");

		// get list of messages
		ArrayList<Post> postList = postDAO.findAll();

		// set bean in view
		request.setAttribute("postList", postList);
		return "/customer/profile";
	}

	@RequestMapping(value = "/purchasePage", method = RequestMethod.GET)
	public String purchasePage(HttpServletRequest request) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"root-context.xml");
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String name = auth.getName(); //get logged in usernam	
		// get bean
		PurchaseDAO purchaseDAO = (PurchaseDAO) context.getBean("purchaseDAO");

		// get list of purchase
		ArrayList<Purchase> purchaseList = purchaseDAO.findAll();

		// set bean in view
		request.setAttribute("purchaseList", purchaseList);
		return "/customer/purchasePage";
	}

	@RequestMapping("/purchaseConfirm")
	public String purchaseConfirm() {
		return "/customer/purchaseConfirm";
	}

	@RequestMapping(value = "/searchResult/", method = RequestMethod.GET)
	public String searchResult(HttpServletRequest request) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"root-context.xml");

		// get bean
		PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");
		UserDAO userDAO = (UserDAO)context.getBean("userDAO");

		// get list of people
		ArrayList<Person> personList = personDAO.findAll();
		ArrayList<User> userList = userDAO.findAll();

		// set bean in view
		request.setAttribute("personList", personList);
		request.setAttribute("userList", userList);
		return "/customer/searchResult";
	}

	public void createCircle(int id, String name, int owner, String type) {
		Circle circle = new Circle(id, name, owner, type);
		this.circleDAO.insert(circle);
	}

	public User findUser(String column, String val) {
		String[] columns = { column };
		String[] vals = { " = " + val };
		return this.userDao.findByValue(columns, vals);
	}

	public void addUserToCircle(int id, int circle) {
		AddedTo addedTo = new AddedTo(id, circle);
		this.addedToDao.insert(addedTo);
	}

	public void removeFromCircle(int id, int circle) {
		this.addedToDao.delete("User_Id = " + id + " AND " + "Circle_Id = "
				+ circle);
	}

	public void makePost(int id, Date date, String content, int commentCount,
			int circle, int author) {
		Post post = new Post(id, date, content, commentCount, circle, author);
		this.postDao.insert(post);
	}

	public void makeComment(int id, Date date, String content, int post,
			int author) {
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
		this.addedToDao.delete("User_Id = " + user + " AND Circle_Id = "
				+ circle);
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

	public void sendMessage(int id, Date date, String subject, String content,
			int sender, int receiver) {
		Message message = new Message(id, date, subject, content, sender,
				receiver);
		this.messageDao.insert(message);
	}

	public ArrayList<Message> showAllReceivedMessages(int receiver) {
		String[] columns = { "Receiver" };
		String[] vals = { " = " + receiver };
		return this.messageDao.findAllByValue(columns, vals);
	}

	public Message viewMessage(int id) {
		String[] columns = { "Message_Id" };
		String[] vals = { " = " + id };
		return this.messageDao.findByValue(columns, vals);
	}

	public void deleteMessage(int id) {
		this.messageDao.delete("Message_Id = " + id);
	}

	public void purchaseItem(int id, Date date, int ad, int numUnits,
			int account, int user) {
		Purchase purchase = new Purchase(id, date, ad, numUnits, account, user);
		this.purchaseDao.insert(purchase);
	}

}
