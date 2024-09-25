package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	Properties prop = new Properties();
	String path = "";

	public ReadPropertiesFile() {
		// TODO Auto-generated constructor stub
	}

	public ReadPropertiesFile(String FilePath) {
		try {
			this.path = path;
			System.out.println(path);
			prop.load(new FileInputStream(path));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getValue(String key) {
		return (String) prop.get(key);

	}
}
