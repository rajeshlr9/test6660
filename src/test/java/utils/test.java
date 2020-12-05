package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class test {

	
	
	public static void main(String[] args) throws IOException  {
		
		deleteOldFiles("QSC");
		
	}

	
	public static void deleteOldFiles(String Customer) {
		File directory = new File("C:\\ReportFiles\\MailableReports");
		for (File f : directory.listFiles()) {
		    //if (f.getName().contains(Customer)) {
		        f.delete();
		   // }
		}
	}
		
	/*
	 * public static void copyExtentReport(String Customer) { Path original
	 * =Paths.get(
	 * "C:\\Jenkins\\workspace\\CIL\\ManhattanWMS-3535876\\ManhattanPOC\\"+Customer+"
	 * \\resources\\Reports\\\\*.html"); Path destination
	 * =Paths.get("C:\\ReportFiles\\MailableReports\\\\*.html"); //copy file. try {
	 * Files.copy(original, destination,StandardCopyOption.REPLACE_EXISTING); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
		
	}

