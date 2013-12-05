package com.teamusa.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teamusa.dao.impl.AccountDAO;
import com.teamusa.dao.impl.AddedToDAO;
import com.teamusa.dao.impl.AdvertisementDAO;
import com.teamusa.dao.impl.CircleDAO;
import com.teamusa.dao.impl.CommentDAO;
import com.teamusa.dao.impl.EmployeeDAO;
import com.teamusa.dao.impl.ManagerDAO;
import com.teamusa.dao.impl.MessageDAO;
import com.teamusa.dao.impl.PersonDAO;
import com.teamusa.dao.impl.PostDAO;
import com.teamusa.dao.impl.PurchaseDAO;
import com.teamusa.dao.impl.UserDAO;
import com.teamusa.dao.impl.UserHasAccountDAO;
import com.teamusa.dao.impl.UserLikesCommentDAO;
import com.teamusa.dao.impl.UserLikesPostDAO;
import com.teamusa.dao.impl.UserPreferencesDAO;

public abstract class AbstractController {
	
	ApplicationContext context = 
    		new ClassPathXmlApplicationContext("root-context.xml");
	AccountDAO accountDao = (AccountDAO) context.getBean("accountDAO");
	AddedToDAO addedToDao = (AddedToDAO) context.getBean("addedToDAO");
	AdvertisementDAO advertisementDao = (AdvertisementDAO) context.getBean("addDAO");
	CircleDAO circleDAO = (CircleDAO) context.getBean("circleDAO");
	CommentDAO commentDao = (CommentDAO) context.getBean("commentDAO");
	EmployeeDAO employeeDao = (EmployeeDAO) context.getBean("employeeDAO");
	ManagerDAO managerDao = (ManagerDAO) context.getBean("managerDAO");
	MessageDAO messageDao = (MessageDAO) context.getBean("messageDAO");
	PersonDAO personDao = (PersonDAO) context.getBean("personDAO");
	PostDAO postDao = (PostDAO) context.getBean("postDAO");
	PurchaseDAO purchaseDao = (PurchaseDAO) context.getBean("purchaseDAO");
	UserDAO userDao = (UserDAO) context.getBean("userDAO");
	UserHasAccountDAO uhaDao = (UserHasAccountDAO) context.getBean("userHasAccountDAO");
	UserLikesCommentDAO ulcDao = (UserLikesCommentDAO) context.getBean("userLikesCommentDAO");
	UserLikesPostDAO ulpDao = (UserLikesPostDAO) context.getBean("userLikesPostDAO");
	UserPreferencesDAO upDao = (UserPreferencesDAO) context.getBean("userPreferencesDAO");

}
