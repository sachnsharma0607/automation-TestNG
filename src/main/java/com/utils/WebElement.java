package com.utils;

import java.awt.Desktop;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WebElement implements ConstantValue {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public ThreadLocal<Integer> noOfRecords = new ThreadLocal<Integer>();

	public boolean visibilityofElement(String xpath) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver.get()).withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10)).ignoring(Exception.class);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	private static By getBy(String locator) {
		
		if(locator.contains("xpath~"))
		{
			return By.xpath(locator.replaceAll("xpath~", ""));
		}
		else if(locator.contains("id~")) {
			return  By.id(locator.replaceAll("id~", ""));
		}
		else if(locator.contains("name~")) {
			return  By.name(locator.replaceAll("name~", ""));
		}
		else if(locator.contains("className~")) {
			return  By.className(locator.replaceAll("className~", ""));
		}
		else if(locator.contains("linkText~")) {
			return  By.linkText(locator.replaceAll("linkText~", ""));
		}
		else if(locator.contains("partialLinkText~")) {
			return  By.partialLinkText(locator.replaceAll("partialLinkText~", ""));
		}
		else if(locator.contains("tagName~")) {
			return  By.tagName(locator.replaceAll("tagName~", ""));
		}
		else if(locator.contains("cssSelector~")) {
			return  By.cssSelector(locator.replaceAll("cssSelector~", ""));
		}
		return null;

	}

	public boolean clickToElement(String xpath) {
		try {
			driver.get().findElement(getBy(xpath)).click();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean enterToText(String xpath, String value) {
		try {
			driver.get().findElement(getBy(xpath)).sendKeys(value);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean get(String url) {
		try {
			driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get().manage().window().maximize();
			driver.get().get(url);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean verifyText(String xpath, String value) {
		try {
			driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			visibilityofElement(xpath);
			if (driver.get().findElement(By.xpath(xpath)).getText().equalsIgnoreCase(value))
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyTextWithcontains(String xpath, String value) {
		try {
			driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			visibilityofElement(xpath);
			String records = driver.get().findElement(By.xpath(xpath)).getText();
			// System.out.println(records.strip("\\D"));
			System.out.println(driver.get().findElement(By.xpath(xpath)).getText());
			if (driver.get().findElement(By.xpath(xpath)).getText().contains(value))
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean getNumberOfRecords(String xpath, String value) {
		try {
			driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			visibilityofElement(xpath);
			int records = driver.get().findElements(By.xpath(xpath)).size();
			if (records > 1) {
				noOfRecords.set(records - 1);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public int getNumberOfRecords() {
		return noOfRecords.get();
	}

	public boolean verifyElementIsPresent(String xpath) {
		try {
			//if (!driver.get().findElements(By.xpath(xpath)).isEmpty())
			if (!driver.get().findElements(getBy(xpath)).isEmpty())
				return true;
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}