/**
 * 
 */
package com.teamusa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author phillipninan
 *
 */
@Controller
@RequestMapping("/manager")
public class ManagerController 
{
	@RequestMapping("/active_item")
	public String handleActiveItem()
	{
		return "/manager/active_item";
	}
	
	@RequestMapping("/advertised_items")
	public String advertisedItems()
	{
		return "/manager/advertised_items";
	}
	
	@RequestMapping("/customer_by_item")
	public String customerByItem()
	{
		return "/manager/customer_by_item";
	}
	
	@RequestMapping("/employeeInfo")
	public String employeeInfo()
	{
		return "/manager/employeeInfo";
	}
	
	@RequestMapping("/items_by_company")
	public String itemsByCompany()
	{
		return "/manager/items_by_company";
	}
	
	@RequestMapping("/managerHome")
	public String managerHome()
	{
		return "/manager/managerHome";
	}
	
	@RequestMapping("/revenue")
	public String revenue()
	{
		return "/manager/revenue";
	}
	
	@RequestMapping("/sales_report")
	public String salesReport()
	{
		return "/manager/sales_report";
	}
	
	@RequestMapping("/transactions")
	public String managerTransactions()
	{
		return "/manager/transactions";
	}
	
	
}
