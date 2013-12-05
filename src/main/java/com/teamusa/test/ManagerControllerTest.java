package com.teamusa.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.teamusa.controller.ManagerController;

public class ManagerControllerTest {
	ManagerController controller = new ManagerController() ;

	@Test
	public void testAddEmployee() {
		Date d = new Date(0);
		controller.addEmployee(12345678, d , 10, 123, "ninan", "phil", "17 washington"
				, "StonyBrook", "New York", 11790, 518, "ninan.phillip@gmail.com");
		fail("Not yet implemented");
	}

	@Test
	public void testEditEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSalesReport() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllAds() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTransactionItemNames() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTransactionCustomerNames() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRevenueByItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRevenueByCustomer() {
		fail("Not yet implemented");
	}

}
