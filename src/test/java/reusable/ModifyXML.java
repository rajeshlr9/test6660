package reusable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.hp.lft.sdk.GeneralLeanFtException;

import StepDefinition.Steps;
import unittesting.UnitTestClassBase;

public class ModifyXML extends UnitTestClassBase {

   
    public static void ModifyFile() throws GeneralLeanFtException, IOException, InterruptedException {
    	
    	String srcFolder1 = "src\\test\\resources\\testdata\\";
    	String Account = Steps.scenarioData.get("Account");
    	String scenarioType = Steps.scenarioData.get("scenarioType");
    	String fullSrcFolder  = srcFolder1+Account+scenarioType+"\\";
    	String SheetsrcFolder = "E:\\dumpspace\\QSC2\\856";
    	String SheetdestFolder = "E:\\dumpspace\\EDI\\UpdatedEDI";
    	String path = SheetdestFolder+"\\QSC-IB-2.xml";   	
    	//String SheetsrcFolder = Steps.scenarioData.get("srcFolder");		
    	//String SheetdestFolder = Steps.scenarioData.get("destFolder");
    	//String path = SheetdestFolder+"\\"+Steps.scenarioData.get("xmlName");    	
    	//copy folder    	
    	File srcFolder = new File(SheetsrcFolder);
    	File destFolder = new File(SheetdestFolder);  	
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
    File fileToBeModified = new File(path); 
 	String oldContent = "";	    	
	BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));	
	String line = reader.readLine();	
	while (line != null) {
		oldContent = oldContent + line + System.lineSeparator();
		line = reader.readLine();
	}
	globalFunc.DateTime.TimeDateFunc();	
	String newContent = oldContent.replaceAll("yyyymmdd", globalFunc.DateTime.strDate5);
	//	String newcontent_ship=newContent.replaceAll("2018073101", "2018073001");
	String newcontent_ship=newContent.replaceAll("yyMMddHHmm", globalFunc.DateTime.strDate6);
	FileWriter writer = new FileWriter(path);
	//	writer.write(newContent);    
	writer.write(newcontent_ship);  			    	
	reader.close();
	writer.close();
        }
}
	//    			    
 
 
    	
   

