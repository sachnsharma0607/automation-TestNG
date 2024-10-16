package com.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports implements ConstantValue {

	private final String filepath = FOLDER_PATH + pathSeparator + "Report_" + new DateFormate().toString() + ".html";
	ThreadLocal<ExtentReports> extentRepor=new ThreadLocal<>();
	ThreadLocal<ExtentSparkReporter> extentSparkReporter = 
			new ThreadLocal<ExtentSparkReporter>();
	ThreadLocal<ExtentTest> eTest = new ThreadLocal<ExtentTest>();

	public Reports() {
		deleteDirectory();
		extentRepor.set(new ExtentReports());
		extentSparkReporter.set( new ExtentSparkReporter(new File(filepath)));
	}

	public void generateReport() {

		extentRepor.get().attachReporter(extentSparkReporter.get());
		extentRepor.get().flush();
//		extentReports.attachReporter(extentSparkReporter);
//		extentReports.flush();
		try {
			Desktop.getDesktop().browse(new File(filepath).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createTest(String testCaseName) {
		eTest.set(extentRepor.get().createTest(testCaseName));
				
	}

	public static void deleteDirectory() {
		new FileUtils().deleteDirectory(new File(FOLDER_PATH));
	}

	public void info(String StepDescription, String expectedResult) {
		//createTest(StepDescription);
		// eTest.pass(expectedResult);
		eTest.get().log(Status.INFO,    "<b>" + StepDescription+" : </b>"+ expectedResult  );

	}

	public void pass(String StepDescription, String expectedResult) {
		// eTest.pass(expectedResult);
		eTest.get().log(Status.PASS, "<b>" + StepDescription+" : </b>"+ expectedResult  );


	}

	public void waring(String StepDescription, String expectedResult) {
		createTest(StepDescription);
		// eTest.pass(expectedResult);
		eTest.get().log(Status.WARNING,  "<b>" + StepDescription+" : </b>"+ expectedResult  );

	}

	public void fail(String StepDescription, String expectedResult) {
		//createTest(StepDescription);
		// eTest.fail(expectedResult);
		eTest.get().log(Status.FAIL, "<b>" + StepDescription+" : </b>"+ expectedResult  );


	}

	public void skip(String StepDescription, String expectedResult) {
		//createTest(StepDescription);
		// eTest.skip(expectedResult);
		eTest.get().log(Status.SKIP,  "<b>" + StepDescription+" : </b>"+ expectedResult  );

	}

}
