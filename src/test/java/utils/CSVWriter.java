package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSVWriter {
	
	public static void setCellValue(String filePath, int columnNumber, int rowNumber, String value){
		
		List<String> allLines = new LinkedList<>();
		
		//Reading		
		BufferedReader br = null;
			
		try{			
			br = new BufferedReader(new FileReader(filePath));
			
			int rowIndex = 0;
			String line = null;		
			String columnsLine = br.readLine();
			allLines.add(columnsLine);
			
			int columnLength = columnsLine.split(",").length;
			String[] valueContainer = new String[columnLength];
			for(int j=0; j<columnLength; j++){
				valueContainer[j] = "";
			}
			
			while((line = br.readLine()) != null){
				
				if(rowIndex + 1 == rowNumber){
					String[] values = line.split(",");
					
					for(int i=0; i< values.length; i++){
						valueContainer[i] = values[i];
					}
					
					valueContainer[columnNumber-1] = value;
					
					line = "";
					
					for(int i=0; i < valueContainer.length; i++){
						line+=valueContainer[i]+","; 
					}
					
					line = line.substring(0, line.length()-1);					
				}
				
				allLines.add(line);
				rowIndex++;				
			}		
			
			br.close();			
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(br != null){
					br.close();
				}				
			}catch(Exception e){}
		}		
		
		
		//Writing
		BufferedWriter bw = null;
		
		try{
			bw = new BufferedWriter(new FileWriter(filePath));
			
			for(String line : allLines){
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();
			
		}catch(IOException e){			
			e.printStackTrace();			
		}finally{
			try{
				if(bw != null){
					bw.close();
				}				
			}catch(Exception e){}
		}		
	}
}
