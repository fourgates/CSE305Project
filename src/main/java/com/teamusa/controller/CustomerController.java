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
@RequestMapping("/customer")
public class CustomerController 
{
	@RequestMapping("/account_history")
	public String accountHistory()
	{
		return "/customer/account_history";
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
	
	@RequestMapping("/purchase_page")
	public String purchasePage()
	{
		return "/customer/purchase_page";
	}
	
	@RequestMapping("/purchase_confirm")
	public String purchaseConfirm()
	{
		return "/customer/purchase_confirm";
	}
	
	@RequestMapping("/search_result")
	public String searchResult()
	{
		return "/customer/search_result";
	}
	
}
