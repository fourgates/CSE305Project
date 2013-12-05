package com.teamusa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController 
{	
	@RequestMapping("/advertisement")
	public String advertisement()
	{
		return "/employee/advertisement";
	}
	
	@RequestMapping("/customerInfo")
	public String customerInfo()
	{
		return "/employee/customerInfo";
	}
	
	@RequestMapping("/employeeHome")
	public String employeeHome()
	{
		return "/employee/employeeHome";
	}
	
	@RequestMapping("/mailing_list")
	public String mailingList()
	{
		return "/employee/mailingList";
	}
	
	@RequestMapping("/recordTransaction")
	public String recordTransaction()
	{
		return "/employee/recordTransaction";
	}
	
	@RequestMapping("/suggestionList")
	public String suggestionList()
	{
		return "/employee/suggestionList";
	}
}
