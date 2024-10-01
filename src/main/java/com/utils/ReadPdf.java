package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPdf {
	
	
	private String path;
	
	public ReadPdf() {
		// TODO Auto-generated constructor stub
	}

	
	public ReadPdf(String path) {
		this.path=path;
	}

	
	public String getpdfVaueintoString()
	{
		PDDocument doc;
		String pdfText = null;
		try {
			doc = Loader.loadPDF(new File(path));
			PDFTextStripper pdfStripper = new PDFTextStripper();
			pdfText=pdfStripper.getText(doc); 
			doc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 
		}
		
		return pdfText;
		
	}
}
