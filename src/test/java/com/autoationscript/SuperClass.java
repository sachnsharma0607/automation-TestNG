package com.autoationscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.model.Report;
import com.utils.Reports;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SuperClass {
	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Reports report=new Reports();

	@BeforeMethod
	// @Parameters("browser")
	public void openbrowser() {
		try {
			
			driver.set(WebDriverManager.chromedriver().capabilities(new ChromeOptions()).create());
			driver.get().manage().window().maximize();
			
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			// TODO: handle exception
		}

	}

	@AfterMethod
	public void quiteBrowser() {
		driver.get().quit();
		//report.info("", "Close the Browser");
		

	}

	
	@AfterSuite
	public void a()
	{
		report.generateReport();
	}
//	WebDriver d=
//	new ChromeDriver();

}
