package com.autoationscript;

import static org.testng.Assert.assertTrue;
import com.pom.HeaderPom;
import com.pom.LoginPOM;

public class BaseClass extends SuperClass {

	final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	final String USERNAME = "Admin";
	final String PASSWORD = "admin123";
	final String VERIFYDASHBOARD = "Dashboard";

	public void userableToLogin(String testCaseName) {

		// class Object
		LoginPOM login = new LoginPOM(driver);
		;
		HeaderPom header = new HeaderPom(driver);
		System.out.println(report);
		report.createTest(testCaseName);

		// Step 1: Open the URL
		login.get(url);
		report.pass("Step 1", "Login should be displayed successfully");
		assertTrue(login.verifyLoginPage());

		
		// Step 2: Enter the User Name and Password
		assertTrue(login.Login(USERNAME, PASSWORD), "login");
		report.pass("Step 2", "Enter the use Name and password");
		
		// Step 3: Verify the Desashoboard Page open
		assertTrue(header.verifyhomePage(VERIFYDASHBOARD));
		report.pass("Step 3", "Home Page should be successfully");

	}

}
