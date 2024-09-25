package com.pom;

import org.openqa.selenium.WebDriver;
import com.utils.ReadPropertiesFile;


public class LeftHandSidePOM extends HeaderPom{
	ReadPropertiesFile LeftHandSideProp;
	final static String filename="LeftHandSide.properties";
	final static String path=System.getProperty("user.dir")+pathSeparator+"src"+pathSeparator+"main"+pathSeparator+"resources"+pathSeparator+filename;
	


	public LeftHandSidePOM(ThreadLocal<WebDriver> driver) {
		super(driver);
		this.driver=driver;
		LeftHandSideProp=new ReadPropertiesFile(path);
		
	}
	
	public boolean verifyArroInExpandMode()
	{
		try {
			if(verifyElementIsPresent(LeftHandSideProp.getValue(IMG_ARROW)))
			return true;
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return true;
		}
	}
	
	public boolean clickOnAdmin()
	{
		try {
			if(clickToElement(LeftHandSideProp.getValue(LB_ADMIN)))
				return true;
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
