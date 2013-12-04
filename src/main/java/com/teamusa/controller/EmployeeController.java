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
		return "/employee/mailing_list";
	}
	
	@RequestMapping("/recordTransaction")
	public String recordTransaction()
	{
		return "/employee/record_transaction";
	}
	
	@RequestMapping("/suggestion_list")
	public String suggestionList()
	{
		return "/employee/suggestion_list";
	}
}
