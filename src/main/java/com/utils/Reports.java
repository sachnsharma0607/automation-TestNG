package com.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports implements ConstantValue {

	private final String filepath = FOLDER_PATH + pathSeparator + "Report_" + new DateFormate().toString() + ".html";
	ExtentReports extentReports = null;;
	ExtentSparkReporter extentSparkReporter = null;
	ExtentTest eTest=null;

	public Reports() {
		deleteDirectory();
		extentReports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(new File(filepath));
	}

	public void generateReport() {
		extentReports.attachReporter(extentSparkReporter);
		extentReports.flush();
		try {
			Desktop.getDesktop().browse(new File(filepath).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createTest(String testCaseName)
	{
		 eTest=extentReports.createTest(testCaseName);
	}

	public static void deleteDirectory() {
		new FileUtils().deleteDirectory(new File(FOLDER_PATH));
	}
	
	public void pass(String StepDescription, String expectedResult)
	{
		createTest(StepDescription);
		eTest.pass(expectedResult);
		
	}
	
	public void fail(String StepDescription, String expectedResult)
	{
		createTest(StepDescription);
		eTest.fail(expectedResult);
		
	}
	
	public void skip(String StepDescription, String expectedResult)
	{
		createTest(StepDescription);
		eTest.skip(expectedResult);
		
	}
	
	enum status{
		
		PASS,FAIL, SKIP;
		
		
	}
}
