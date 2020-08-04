package globalFunc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GlobalClass {
	// Get Test Data from Data sheet
	  HashMap < String, String > hmap1 = new HashMap < String, String > ();
	  
	public   HashMap < String, String > getExcelData(String MyRowFlag,String SheetName,String filename) throws IOException {
		hmap1.clear();
		File MyFileName = new File(filename);
		FileInputStream MyInputStream = new FileInputStream(MyFileName);
		XSSFWorkbook MyWorkBook = new XSSFWorkbook(MyInputStream);
		XSSFSheet MySheet = MyWorkBook.getSheet(SheetName);
		int RowCount = MySheet.getLastRowNum() + 1;

		for (int iRow = 0; iRow < RowCount; iRow++) {
			XSSFRow row = MySheet.getRow(iRow);
			if (MyRowFlag.equals(row.getCell(0).getStringCellValue())) {

				int ColumnCount = MySheet.getRow(iRow).getLastCellNum();
				for (int iColumn = 1; iColumn < ColumnCount; iColumn++) {
					XSSFRow row2 = MySheet.getRow(0);
					String cell = row2.getCell(iColumn).getStringCellValue();
					XSSFRow rowcapture = MySheet.getRow(iRow);
					XSSFCell cellcapture = rowcapture.getCell(iColumn);
					String intValue = (MySheet.getRow(iRow).getCell(iColumn)== null) ? "" : convertString(MySheet.getRow(iRow).getCell(iColumn));
					hmap1.put(cell, intValue);
				}
				break;
			}
		}
		return hmap1;	
	}

	
	public int getExcelRowCount(String fileName) throws IOException
	{
		File MyFileName = new File(fileName);
		FileInputStream MyInputStream = new FileInputStream(MyFileName);
		XSSFWorkbook MyWorkBook = new XSSFWorkbook(MyInputStream);
		XSSFSheet MySheet = MyWorkBook.getSheet("Sheet1");
		int RowCount = MySheet.getLastRowNum();
		return RowCount;
	}
	public Map<Integer, Map<String, String>> filterData(Map<Integer, Map<String, String>> outerMap, String filterBy, String sheetname){
		Map<Integer, Map<String, String>> newMap = new HashMap<Integer, Map<String, String>>();
		int outerMapSize = outerMap.size();
		if (sheetname.equals("ItemData")){
			System.out.println("Item Data sheet");
			String[] itemsArr = null;
			if (filterBy.contains("|"))
				itemsArr = filterBy.split("[|]");
			else
				itemsArr =  new String[] {filterBy};
			boolean itemCheck = false ;
			for(int i =0,j=0;i<outerMapSize;i++){
				
				itemCheck = Arrays.asList(itemsArr).contains(outerMap.get(i).get("Item_Ref"));
				if (itemCheck){
					newMap.put(j, outerMap.get(i));
					j++;
				}				
			}			
		}else if (sheetname.equals("Service")){
			System.out.println("Service Data sheet");
			String[] serviceArr = null;
			if (filterBy.contains("|"))
				serviceArr = filterBy.split("[|]");
			else
				serviceArr =  new String[] {filterBy};
			boolean serviceCheck = false ;
			for(int i =0,j=0;i<outerMapSize;i++){
				
				serviceCheck = Arrays.asList(serviceArr).contains(outerMap.get(i).get("Service_Ref"));
				if (serviceCheck){
					newMap.put(j, outerMap.get(i));
					j++;
				}				
			}			
		}
		
		return newMap;	
	}
	public Map<Integer, Map<String, String>> readData(String path, String sheetname) throws Exception{
		Map<Integer, Map<String, String>> outerMap = new HashMap<Integer, Map<String, String>>();
		Map<String, String> innerMap = new HashMap<String, String>();
		File myFile = new File(path);
		org.apache.poi.ss.usermodel.Workbook WBook = WorkbookFactory.create(myFile);
		org.apache.poi.ss.usermodel.Sheet sheet = WBook.getSheet(sheetname);

		int totalRows = sheet.getLastRowNum();		
		int totalColumns = sheet.getRow(0).getLastCellNum();
		System.out.println(totalRows);
		for(int i=1;i<=totalRows;i++){
			if(!(sheet.getRow(i)== null)){
				innerMap = new HashMap<String, String>();
				String key,value;
				for(int j=0;j<totalColumns;j++){ 
					key = convertString(sheet.getRow(0).getCell(j));
					value = (sheet.getRow(i).getCell(j)== null) ? "" : convertString(sheet.getRow(i).getCell(j));
					innerMap.put(key, value);
				}		
			}
			outerMap.put(i-1, innerMap);
			
		}
		return outerMap;

	}
	
	public static String convertString(Cell cell){
		String value = cell.getStringCellValue();
		return value ; 	
	}

	
	

	   public void writeexceldata(String varData, String path) throws Exception {

	      //Create blank workbook
	      XSSFWorkbook workbook = new XSSFWorkbook();
	      
	      //Create a blank sheet
	      XSSFSheet spreadsheet = workbook.createSheet( "Test");

	      //Create row object
	      XSSFRow row;

	      //This data needs to be written (Object[])
	      Map < String, Object[] > data = new TreeMap < String, Object[] >();
	      data.put( "1", new Object[] {
	    		  varData });
	      

	      //Iterate over data and write to sheet
	      Set < String > keyid = data.keySet();
	      int rowid = 0;
	      
	      for (String key : keyid) {
	         row = spreadsheet.createRow(rowid++);
	         Object [] objectArr = data.get(key);
	         int cellid = 0;
	         
	         for (Object obj : objectArr){
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      //Write the workbook in file system
	      FileOutputStream out = new FileOutputStream(
	         new File(path));
	      
	      workbook.write(out);
	      out.close();
	      System.out.println("Data written successfully");
	   }
	   public static String removeZero(String str) 
	    { 
	        // Count leading zeros 
	        int i = 0; 
	        while (i < str.length() && str.charAt(i) == '0') 
	            i++; 
	  
	        // Convert str into StringBuffer as Strings 
	        // are immutable. 
	        StringBuffer sb = new StringBuffer(str); 
	  
	        // The  StringBuffer replace function removes 
	        // i characters from given index (0 here) 
	        sb.replace(0, i, ""); 
	  
	        return sb.toString();  // return in String 
	    }
	}


