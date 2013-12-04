package com.teamusa.util;

import com.teamusa.dao.AbstractDAO;
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

public class SqlUtil {
	
	private SqlString sqlString;
	
	public SqlUtil() {
		this.sqlString = new SqlString();
	}
	
	public SqlString createInsertString(AbstractDAO dao) {
		if (dao instanceof CircleDAO) {
			this.sqlString.name = "Circle";
			this.sqlString.columns = "(Circle_Id, Circle_NAME, Owner_Of_Circle, Type)";
			this.sqlString.values = "(?, ?, ?, ?)";
		} else if (dao instanceof UserDAO) {
			this.sqlString.name = "User";
			this.sqlString.columns = "(SSN, User_Id, Account_Creation_Date, Rating)";
			this.sqlString.values = "(?, ?, ?, ?)";
		} else if (dao instanceof AddedToDAO) {
			this.sqlString.name = "AddedTo";
			this.sqlString.columns = "(User_Id, Circle_Id)";
			this.sqlString.values = "(?, ?)";
		} else if (dao instanceof AccountDAO) {
			this.sqlString.name = "Account";
			this.sqlString.columns = "(Account_Number, Account_Creation_Date, Credit_Card_Number, Status)";
			this.sqlString.values = "(?, ?, ?, ?)";
		} else if (dao instanceof UserHasAccountDAO) {
			this.sqlString.name = "User_Has_Account";
			this.sqlString.columns = "(User_Id, Account_Number)";
			this.sqlString.values = "(?, ?)";
		} else if (dao instanceof UserPreferencesDAO) {
			this.sqlString.name = "User_Preferences";
			this.sqlString.columns = "(Id, Preference)";
			this.sqlString.values = "(?, ?)";
		} else if (dao instanceof MessageDAO) {
			this.sqlString.name = "Message";
			this.sqlString.columns = "(Message_Id, Date, Subject, Content, Sender, Receiver)";
			this.sqlString.values = "(?, ?, ?, ?, ?, ?)";
		} else if (dao instanceof PersonDAO) {
			this.sqlString.name = "Person";
			this.sqlString.columns = "(SSN, Last_Name, First_Name, Address, City, State, Zip_Code, Telephone, Email_Address)";
			this.sqlString.values = "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		} else if (dao instanceof EmployeeDAO) {
			this.sqlString.name = "Employee";
			this.sqlString.columns = "(SSN, Start_Date, Hourly_Rate, Manager)";
			this.sqlString.values = "(?, ?, ?, ?)";
		} else if (dao instanceof ManagerDAO) {
			this.sqlString.name = "Manager";
			this.sqlString.columns = "(SSN, Start_Date, Hourly_Rate)";
			this.sqlString.values = "(?, ?, ?)";
		} else if (dao instanceof PostDAO) {
			this.sqlString.name = "Post";
			this.sqlString.columns = "(Post_Id, Date, Content, Comment_Count, Circle, Author)";
			this.sqlString.values = "(?, ?, ?, ?, ?, ?)";
		} else if (dao instanceof CommentDAO) {
			this.sqlString.name = "Comment";
			this.sqlString.columns = "(Comment_Id, Date, Content, Post, Author)";
			this.sqlString.values = "(?, ?, ?, ?, ?)";
		} else if (dao instanceof UserLikesPostDAO) {
			this.sqlString.name = "User_Likes_Post";
			this.sqlString.columns = "(User, Post)";
			this.sqlString.values = "(?, ?)";
		} else if (dao instanceof UserLikesCommentDAO) {
			this.sqlString.name = "User_Likes_Comment";
			this.sqlString.columns = "(User, Comment)";
			this.sqlString.values = "(?, ?)";
		} else if (dao instanceof AdvertisementDAO) {
			this.sqlString.name = "Advertisement";
			this.sqlString.columns = "(Advertisement_Id, Employee, Type, Date, Company, Item_Name, Content, Unit_Price, Availabe_Units)";
			this.sqlString.values = "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		} else if (dao instanceof PurchaseDAO) {
			this.sqlString.name = "Purchase";
			this.sqlString.columns = "(Transaction_Id, Date, Advertisement, Number_Of_Units, Account, User)";
			this.sqlString.values = "(?, ?, ?, ?, ?, ?)";
		}
		return this.sqlString;
	}
}
