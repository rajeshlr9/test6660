package utils;

import org.testng.annotations.Test;

public class CSVWriterTest {
	
	@Test
	public void Test1(){
		for(int i=0; i< 4; i++){
			CSVWriter.setCellValue("C:\\Users\\ulugbek.rahmanov\\git\\QAAutomation\\automation-test\\src\\test\\resources\\testdata\\Copy of OrderBulkUploadMinimum4ProductsFreightSL_17.csv", 
					1, i+1, "ProdUK"+ 71175467);
		
		}
		
		
	    }
	}