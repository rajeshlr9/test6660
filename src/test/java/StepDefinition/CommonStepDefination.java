
package StepDefinition;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.testng.Assert;
import org.testng.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import entity.DistributionOrders;
import entity.Items;
import pages.ManhattanLoginPage;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;


public class CommonStepDefination  {
	

	WebDriver driver;
	
	
	public static int testDataNo = -1;
	public static List<String> currentScenario;
	public String tempScenario=null;
	public static String productCreationSheetName = null;
	public static String TagNameWithTCname=null;
	public static String ScenarioName=null;
	public static String ScenarioStatus=null;
	public static FileOutputStream out;

	public static int Count=0;

	 /**
	  * @author Vinay Kona
	  *As per the client requirement, Implemented this for adding Screenshots from folder to Word Doc.
	  */
	 
	 public static void FolderScreenShotToWord(String testedBy,String Scenarioname) {
			try {
				String dirPath = System.getProperty("user.dir") + "//PassedScreenshots//"+TagNameWithTCname;
				
				// Create folder/directory if not exist.
				File file = new File(dirPath);
				File[] listOfFiles = file.listFiles();
				for (int i = 0; i < listOfFiles.length; i++) {

					if(listOfFiles[i].getName().endsWith(".docx")){
						listOfFiles[i].delete();
						
					}
				}
				

				int fileSize = listOfFiles.length;

				
				if (!file.exists()) {
					if (file.mkdir()) {
					} else {

					}
				}
				XWPFDocument docx = new XWPFDocument();
				 
				XWPFParagraph paragraph = docx.createParagraph();
				XWPFRun run = paragraph.createRun();
				run.addBreak();
				
				 run.setText("Test Scenario:  "+Scenarioname);
				 run.setBold(true);
				 run.setFontSize(12);
				 run.setColor("4682B4");

				paragraph = docx.createParagraph();
				run = paragraph.createRun();
				// run.setText("Lorem ipsum....");

				// create header start
				CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
				XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docx, sectPr);

				XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);

				paragraph = header.createParagraph();
				paragraph.setAlignment(ParagraphAlignment.LEFT);

				CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
				  
				tabStop.setVal(STTabJc.RIGHT);
				int twipsPerInch = 1440;
				tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));
				run = paragraph.createRun();
				run.setText(CommonStepDefination.TagNameWithTCname);
				run.setBold(true);
				run.setColor("000000");
				run.addTab();
				run.setText("Tester :"+testedBy);
				run.addBreak();
				run.setText("Verizon_Testing");
				run.addTab();
				run.setText(SeleniumTestHelper.myCurrentDate());
				run = docx.createParagraph().createRun();
				File evidenceFile=new File(System.getProperty("user.dir") + "//Verizon_Evidences");
				if(evidenceFile.exists()){
					
				 out = new FileOutputStream(System.getProperty("user.dir") + "//Verizon_Evidences//"+CommonStepDefination.TagNameWithTCname+".docx");
				 System.out.println("Verizon_Evidence folder is already Exists");
				 
				}
				else{
					
					evidenceFile.mkdir();
					out = new FileOutputStream(System.getProperty("user.dir") + "//Verizon_Evidences//"+CommonStepDefination.TagNameWithTCname+".docx");
					 System.out.println("Verizon_Evidence folder is not present and created new Folder with name as Verizon_Evidences");	
				}
				
				
				// Add for loop for example, because here we are capturing 5
				// screenhots
				for (int counter = 0; counter < fileSize; counter++) {
					InputStream pic = new FileInputStream(dirPath + "//" + listOfFiles[counter].getName());
					run.addBreak();
					run.addBreak();
					TimeUnit.SECONDS.sleep(1);
					run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, listOfFiles[counter].getName(), Units.toEMU(500),
							Units.toEMU(250));
					pic.close();
					file.delete();
				}
				
				run.addBreak();
				if(CommonStepDefination.ScenarioStatus.equalsIgnoreCase("passed")){
				 run.setText("TestCase Status : "+CommonStepDefination.ScenarioStatus);
				 run.setBold(true);
				 run.setFontSize(14);
				 run.setColor("006600");
				}
				
				else{
					
					 run.setText("Test Case Status : "+CommonStepDefination.ScenarioStatus);
					 run.setBold(true);
					 run.setFontSize(14);
					 run.setColor("FF0000");
				}
				XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);

				paragraph = footer.getParagraphArray(0);
				if (paragraph == null)
					paragraph = footer.createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText("Page ");
				paragraph.getCTP().addNewFldSimple().setInstr("PAGE \\* MERGEFORMAT");
				run = paragraph.createRun();
				run.setText(" | ");
				paragraph.getCTP().addNewFldSimple().setInstr("NUMPAGES \\* MERGEFORMAT");
	            
				System.out.println("Written to .docx file sucessfully...");
				docx.write(out);
				out.flush();
				out.close();
				docx.close();
				 Toolkit.getDefaultToolkit().beep();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 public static String getScreenshotForWord() throws IOException{
			
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			WebDriver driver = Driver.getInstance();
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File path1=new File(System.getProperty("user.dir") +"//PassedScreenshots");
			File pathNew=new File(System.getProperty("user.dir") +"//PassedScreenshots//"+CommonStepDefination.TagNameWithTCname);
			String[] subFolders=path1.list();
			List<String> sub = Arrays.asList(subFolders);
			if(!sub.contains(CommonStepDefination.TagNameWithTCname)){
				
				pathNew.mkdir();
				
			}
			
			 
			String[] entries = pathNew.list();
			
			if(Count==0 && entries.length> 0 ){
			
			for(int i=0;i<entries.length;i++){
			
				File currentFile = new File(pathNew.getPath(),entries[i]);	
				currentFile.delete();	
			}
			
			
			}
			
			Count++;
			String destination = System.getProperty("user.dir") + "/PassedScreenshots/"+TagNameWithTCname + "/"+ dateName + ".png";
			File finalDestination = new File(destination);
			try {
				FileUtils.copyFile(source, finalDestination);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return destination;
		}
		
		
		public static void assertEquals(Object actual, Object expected, String message){

			try {
				com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
				getScreenshotForWord();
			} catch (IOException e) {
				e.printStackTrace();
			}
			com.cucumber.listener.Reporter.addStepLog("Expected is "+expected.toString()+" and Actual is "+actual);

			if(null != message){
				System.out.println(message + "actual is - "+ actual + "expected is - "+expected);
				Assert.assertEquals(actual, expected, message);
				

			}else{
				Assert.assertEquals(actual, expected);
			}
		}
		public static String getScreenshot(){
	        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        WebDriver driver = Driver.getInstance();
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + dateName + ".png";
	        File finalDestination = new File(destination);
	        try {
	               FileUtils.copyFile(source, finalDestination);
	        } catch (IOException e) {
	               e.printStackTrace();
	        }
	        return destination;
	 }
		public static void assertNotEquals(Object actual, Object expected, String message){

			try {
				com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
				getScreenshotForWord();
			} catch (IOException e) {
				e.printStackTrace();
			}
			com.cucumber.listener.Reporter.addStepLog("Expected is "+expected.toString()+" and Actual is "+actual);

			if(null != message){
				System.out.println(message + "actual is - "+ actual + "expected is - "+expected);
				Assert.assertNotEquals(actual, expected, message);

			}else{
				Assert.assertNotEquals(actual, expected);
			}
		}


	@Before
	public void intiate(Scenario scenario) {

		Reporter.log("Execution started for : " + scenario.getName(), true);
		
		tempScenario=scenario.getName();
		ScenarioName =scenario.getName();
		    
		
		
		if (!scenario.getName().equals(currentScenario)) {
			testDataNo = -1;
			 currentScenario =(List<String>) scenario.getSourceTagNames();
			 }
		
           for (int tagNameCnt = 0; tagNameCnt <currentScenario.size(); tagNameCnt++) {
			
			if(currentScenario.get(tagNameCnt).contains("TC_")){
				
				TagNameWithTCname=currentScenario.get(tagNameCnt).substring(1);
				
				
 			}
		
           }
		
	}

	/*
	 * @After public void cleanUp(Scenario scenario) {
	 * 
	 * ScenarioStatus=scenario.getStatus();
	 * System.out.println(scenario.getStatus()); if
	 * ("failed".equals(scenario.getStatus())) { try {
	 * com.cucumber.listener.Reporter.addScreenCaptureFromPath(SeleniumTestHelper.
	 * getFailedScreenshot()); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * FolderScreenShotToWord(ManhattanLoginPage.TestedBy,ScenarioName);
	 * FolderScreenShotToWord(Config.getProperty(System.getProperty("user.name"),
	 * "TesterDetails"),ScenarioName);
	 * 
	 * Driver.closeDriver();
	 * 
	 * Items.removeAllTheValuesFromMap();
	 * DistributionOrders.removeAllTheValuesFromMap(); testDataNo = -1; }
	 */

}
