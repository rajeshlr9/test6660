package reusable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.hp.lft.sdk.GeneralLeanFtException;

import unittesting.UnitTestClassBase;

public class ModifyXML extends UnitTestClassBase {

   
    public static void ModifyFile() throws GeneralLeanFtException, IOException, InterruptedException {
    	
    	
    	//copy folder 
    	
    	File srcFolder = new File("TestData\\EDI\\EMC");
    	File destFolder = new File("E:\\EMC");
    	
    	
    	//make sure source exists
    	if(!srcFolder.exists()){

           System.out.println("Directory does not exist.");
           //just exit
           System.exit(0);

        }else{

           try{
        	copyFolder.copyFolder(srcFolder,destFolder);
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }
    	
 String path = "E:\\EMC\\940\\EMC-IB-ORDER-01-940.x12";

 File fileToBeModified = new File(path);
 
 String oldContent = "";
		    	
	BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
	
	
	String line = reader.readLine();
	
	
	
	while (line != null) 
	{
		oldContent = oldContent + line + System.lineSeparator();
		line = reader.readLine();
	}
	globalFunc.DateTime.TimeDateFunc();
	
	String newContent = oldContent.replaceAll("yymmdd", globalFunc.DateTime.strDate5);

	//	String newcontent_ship=newContent.replaceAll("2018073101", "2018073001");

	String newcontent_ship=newContent.replaceAll("yyMMddHHmm", globalFunc.DateTime.strDate6);


	FileWriter writer = new FileWriter(path);	//
	//	writer.write(newContent);    

	writer.write(newcontent_ship);
	//    			    	
	reader.close();
	writer.close();
	
        }
}
	//    			    
 
 
    	
   

