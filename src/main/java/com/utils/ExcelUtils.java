package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static String path;
	private static String fileName;
	private static FileInputStream fs = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private Map<String, String> rowcolumn;
	private Map<String, Map<String, String>> mapOfrowcolumn = new HashMap<>();
	private static String sheetName = null;
	private static int sheetNumber;
	private static List<String> header = new ArrayList<>();
	private static int lastRowNum;
	private static int lastColumnRowm;

	public ExcelUtils() {

	}

	public ExcelUtils(String path, String sheetName) {
		this.path = path;
		this.sheetName = sheetName;
	}

	public ExcelUtils(String path, int sheetNumber) {
		this.path = path;
		this.sheetNumber = sheetNumber;

	}

	public static void readWorkBook() {
		readWorkBook(path);
	}

	public static void readWorkBook(String path) {

		try {

			fs = new FileInputStream(new File(path));
			if (path.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(fs);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("File Not Found");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done");
	}

	public static void getSheetName(String sheetName) {
		sheet = workbook.getSheet(sheetName);
	}

	public static void getSheetName(int sheetNumber) {
		sheet = workbook.getSheetAt(sheetNumber);

	}

	public static void getLastRowNum() {
		lastRowNum = sheet.getLastRowNum();
	}

	public static void getLastCellNum() {
		lastColumnRowm = sheet.getRow(0).getLastCellNum();
	}

	public static void header() {
		for (int rowindex = 0; rowindex < sheet.getRow(0).getLastCellNum(); rowindex++) {
			header.add(sheet.getRow(0).getCell(rowindex).getStringCellValue());
		}
		// }
	}

	public void readExcel() {

		if (sheet == null) {
			if (sheetName == null) {
				getSheetName(sheetNumber);
			} else {
				getSheetName(sheetName);
			}
		}
		header();
		int lastRowNum = sheet.getLastRowNum();
		for (int i = 1; i <= lastRowNum; i++) {
			rowcolumn = new HashMap<>();
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {

				rowcolumn.put(header.get(j), sheet.getRow(i).getCell(j).getStringCellValue());
			}
			;
			mapOfrowcolumn.put(rowcolumn.get("Test Case id"), rowcolumn);

		}

	}

	public Map<String, String> filterData(List<String> keys) {

		for (String key : keys) {
			return filterData(key);
		}

		return null;
	}

	public Map<String, String> filterData(String key) {

		if (mapOfrowcolumn.containsKey(key)) {
			return mapOfrowcolumn.get(key);
		}
		return null;
	}
}
