package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot extends WebElement implements ConstantValue {

	public ScreenShot() {
		new FileUtils().deleteDirectory(new File(PATH_SCREENSHOT_FOLDER));
		new FileUtils().createFolder(PATH_SCREENSHOT_FOLDER);
	}

	public ScreenShot(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this();
		this.driver.set(driver);
		System.out.println(this.driver.get());
	}

	public String takescreennShot(WebDriver driver) {
		this.driver.set(driver);
		return takescreennShot();
	}

	public String takescreennShot() {

		File scr = ((TakesScreenshot) this.driver.get()).getScreenshotAs(OutputType.FILE);
		String screenshotpath = PATH_SCREENSHOT_FOLDER + pathSeparator + new DateFormate().toString();
		try {
			FileOutputStream output = new FileOutputStream(new File(screenshotpath));
			try {
				org.apache.commons.io.FileUtils.copyFile(scr, new File(screenshotpath));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// .output.write(Base64);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new File(screenshotpath).getAbsolutePath();
	}
}
