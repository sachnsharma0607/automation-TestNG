package com.utils;

import java.io.File;

public interface ConstantValue {
	final static String pathSeparator = File.separator;
	
	//login in Constant
	final static String txt_login="txt_login";
	final static String txt_password="txt_password";
	final static String btn_submit="btn_submit";
	
	//Header constant
	final static String lbl_Dashboard="lbl_Dashboard";
	
	//lEFT HAND SIDE Property file constant
	final static String IMG_ARROW="img_arrow";
	final static String LB_ADMIN="lb_admin";
	
	
	//Admin POM
	
	final static String LB_RECORDS="lb_Records";
	final static String LB_NUMBEROFRECORDS="Ib_NumberOfRecord";
	final static String PATH_REPORT_FOLDER = System.getProperty("user.dir") +pathSeparator + "Reports";
	final static String PATH_SCREENSHOT_FOLDER= System.getProperty("user.dir") +pathSeparator + "Screenshot";
			

}