package com.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormate {
	
	
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");

	
	public DateFormate() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString()
	{
		return myDateObj.format(myFormatObj);
	}
	
}

