package com.autoationscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SuperClass {
	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

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

	}

//	WebDriver d=
//	new ChromeDriver();

}
