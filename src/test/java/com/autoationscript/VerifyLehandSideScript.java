package com.autoationscript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.pom.AdminPOM;
import com.pom.LeftHandSidePOM;
import com.pom.PIMPOM;

public class VerifyLehandSideScript extends BaseClass {

	@Test
	public void clicknLethandSide_Arrow() {

		LeftHandSidePOM lefthandside = new LeftHandSidePOM(driver);
		AdminPOM admin = new AdminPOM(driver);
		
		// Step 1-3
		userableToLogin("Verify the use ");
		
		//Step 4:  //Verify Expend Mode
		assertTrue(lefthandside.verifyArroInExpandMode());
		report.pass("Step 4", "click ON Expand Mode");

		assertTrue(lefthandside.clickOnAdmin());
		report.pass("Step 5", "Click on Admin Button on left side");
		
		
		assertTrue(lefthandside.verifyadmin("Admin"));
		report.pass("Step 6", "Verify the admin button");
		
		assertTrue(admin.VerifyRecords("Found"));
		report.pass("Step 7", "Verify the records");
		
		// assertTrue(admin.VerifyRecords(""));

	}

	@Test
	public void t() {
		PIMPOM pimpom = new PIMPOM(driver);
		userableToLogin("Verify the use ");

	}

}
