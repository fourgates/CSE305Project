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
	
}
