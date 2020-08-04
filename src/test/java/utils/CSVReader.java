package utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader {
	
	public static int getRecordCount(String filePath){
		String csvFile = "src/test/resources/BigfileProduct85.csv";
	     BufferedReader br = null;
	     int count = 0;
	     try{
	    	 br = new BufferedReader(new FileReader(filePath));
	         while ((br.readLine()) != null) {
	        	 count++;
	         }
	         br.close();
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
     	System.out.println(count);
	 	return count;
	}
}
