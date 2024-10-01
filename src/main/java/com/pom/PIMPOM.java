package com.pom;

import org.openqa.selenium.WebDriver;

import com.utils.ReadPropertiesFile;
import com.utils.WebElement;

public class PIMPOM extends HeaderPom{
	
ReadPropertiesFile pimprop;
	
	final static String filename="pim.properties";
	final static String path=System.getProperty("user.dir")+pathSeparator+"src"+pathSeparator+"main"+pathSeparator+"resources"+pathSeparator+filename;
	final static String LB_EMPLOYEELIST="lb_employeeList";
		
	public PIMPOM(ThreadLocal<WebDriver> driver) {
		super(driver);
		this.driver=driver;
		pimprop=new ReadPropertiesFile(path);
		
	}
	
	public void b()
	{
		clickToElement(pimprop.getValue(LB_EMPLOYEELIST));
	}

}
