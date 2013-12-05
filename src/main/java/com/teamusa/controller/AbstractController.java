package com.teamusa.controller;

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
	
	AccountDAO accountDao = new AccountDAO();
	AddedToDAO addedToDao = new AddedToDAO();
	AdvertisementDAO advertisementDao = new AdvertisementDAO();
	CircleDAO circleDAO = new CircleDAO();
	CommentDAO commentDao = new CommentDAO();
	EmployeeDAO employeeDao = new EmployeeDAO();
	ManagerDAO managerDao = new ManagerDAO();
	MessageDAO messageDao = new MessageDAO();
	PersonDAO personDao = new PersonDAO();
	PostDAO postDao = new PostDAO();
	PurchaseDAO purchaseDao = new PurchaseDAO();
	UserDAO userDao = new UserDAO();
	UserHasAccountDAO uhaDao = new UserHasAccountDAO();
	UserLikesCommentDAO ulcDao = new UserLikesCommentDAO();
	UserLikesPostDAO ulpDao = new UserLikesPostDAO();
	UserPreferencesDAO upDao = new UserPreferencesDAO();

}
