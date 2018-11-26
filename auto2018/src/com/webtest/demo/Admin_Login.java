package com.webtest.demo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Admin_Login extends BaseTest{
	
	@Test
	public void testLogin() {
		webtest.open("localhost:8032/MyMovie/admin.php/Login/index.html");
	}
	
	
}
