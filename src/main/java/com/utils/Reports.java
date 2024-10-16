package com.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports implements ConstantValue {

	private final String filepath = FOLDER_PATH + pathSeparator + "Report_" + new DateFormate().toString() + ".html";
	ExtentReports extentReports = null;;
	ExtentSparkReporter extentSparkReporter = null;

	public Reports() {
		deleteDirectory();
		extentReports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(new File(filepath));
	}

	public void generateReport() {
		extentReports.attachReporter(extentSparkReporter);
		extentReports.flush();
	}

	public static void deleteDirectory() {
		new FileUtils().deleteDirectory(new File(FOLDER_PATH));
	}
}
