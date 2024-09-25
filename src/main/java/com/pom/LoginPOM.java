package com.pom;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.utils.ReadPropertiesFile;
import com.utils.WebElement;

public class LoginPOM extends WebElement{
	
	ReadPropertiesFile loginProp;
	//public WebDriver driver;


	final static String filename="Login.properties";
	final static String path=System.getProperty("user.dir")+pathSeparator+"src"+pathSeparator+"main"+pathSeparator+"resources"+pathSeparator+filename;
	

	public LoginPOM(ThreadLocal<WebDriver> driver) {
		this.driver=driver;
		
		loginProp=new ReadPropertiesFile(path);
		
	}
	public boolean Login(String username,String password)
	{
		try {
			if(enterToText(loginProp.getValue(txt_login), username)&(enterToText(loginProp.getValue(txt_password), password)))
			if(clickToElement(loginProp.getValue(btn_submit)))
					return true;
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public  boolean verifyLoginPage()
	{
		try {
			if(verifyElementIsPresent(loginProp.getValue(txt_login))) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
}
