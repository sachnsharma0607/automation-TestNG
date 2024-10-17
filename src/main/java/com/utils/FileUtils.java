package com.utils;

import java.io.File;

public class FileUtils {

	public FileUtils() {
		// TODO Auto-generated constructor stub
	}

	public static void createFolder(String path) {
		File theDir = new File(path);
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
	}

	public static void deleteDirectory(File file) {
		// store all the paths of files and folders present
		// inside directory
		if (file.list() != null) {
			for (File subfile : file.listFiles()) {

				// if it is a subfolder,e.g Rohan and Ritik,
				// recursively call function to empty subfolder
				if (subfile.isDirectory()) {
					deleteDirectory(subfile);
				}

				// delete files and empty subfolders
				subfile.delete();
			}
		}
	}
}
