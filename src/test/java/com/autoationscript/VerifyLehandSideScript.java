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
		userableToLogin();
		assertTrue(lefthandside.verifyArroInExpandMode());

		assertTrue(lefthandside.clickOnAdmin());
		assertTrue(lefthandside.verifyadmin("Admin"));
		assertTrue(admin.VerifyRecords("Found"));
		// assertTrue(admin.VerifyRecords(""));

	}

	@Test
	public void t() {
		PIMPOM pimpom = new PIMPOM(driver);
		pimpom.b();

	}

}
