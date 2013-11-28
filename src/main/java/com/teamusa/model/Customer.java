package com.teamusa.model;

import java.sql.Timestamp;

public class Customer 
{
	int custId;
	String name;
	int age;
	public Customer(int int1, String string, int int2) {
		// TODO Auto-generated constructor stub
		custId = int1;
		name = string;
		age = int2;
	}
	//getter and setter methods
	public int getCustId() {
		// TODO Auto-generated method stub
		return custId;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}
 
}
