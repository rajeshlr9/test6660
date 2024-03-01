package reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.DateTime;
import pages.ManhattanLoginPage;
import utils.Config;
import utils.SeleniumTestHelper;

public class KelliPages {

	public WebDriver driver;
	public static String UploadString = null;
	public String a1;
	public String S1;
	public static String partialASNValue= "";
	public String dir = System.getProperty("user.dir");
	public String KelliSingleLineASNfilePath = dir + "\\TestData\\Kelli\\Kelli ASN Load Single Line.xls";
	public String KelliSingleLineASNfilePathForNVI = dir + "\\TestData\\Kelli\\Kelli ASN Load Single Line_NVI.xls";
	public String KelliSingleLineASNfilePathForAPC = dir + "\\TestData\\Kelli\\Kelli ASN Load Single Line_APC.xls";
	public String KelliSingleLineSerialAPC = dir + "\\TestData\\Kelli\\Kelli Single Line Serial_APC.xls";
	public String KelliSingleLineLotAPC = dir + "\\TestData\\Kelli\\Kelli Single Line Lot_APC.xls";
	public String KelliMultiLineASNfilePath = dir + "\\TestData\\Kelli\\Kelli ASN Load Multi Line.xls";
	public String KelliItemloadfilePath = dir + "\\TestData\\Kelli\\Item Load.xls";
	public String KelliLocationloadfilePath = dir + "\\TestData\\Kelli\\Location Load.xls";
	public String KelliSingleLineOrderfilePath = dir + "\\TestData\\Kelli\\Order Load Single Line.xls";
	public String KelliMultiLineOrderfilePath = dir + "\\TestData\\Kelli\\Order Load Multi Line.xls";
	public String KelliASNfilePathForTHH = dir + "\\TestData\\Kelli\\THH ASNLoad.xls";
	public String KelliASNfilePathForFUJ = dir + "\\TestData\\Kelli\\FUJ ASNLoad.xls";
	public String KelliASNfilePathForTHM = dir + "\\TestData\\Kelli\\THM ASNLoad.xls";
	public String KelliMultiLineASNfilePathForTRN = dir + "\\TestData\\Kelli\\TRN ASNLoad.xls";
	public String KelliASNfilePathForTRN = dir + "\\TestData\\Kelli\\TRN ASNLoad.xls";
	public String KelliASNfilePathForILW = dir + "\\TestData\\Kelli\\ILW ASNLoad.xls";
	public String KelliSingleLineNormalForATM = dir + "\\TestData\\Kelli\\ATM ASN Load Single Line.xls";
	public String KelliSingleLineLotForATM = dir + "\\TestData\\Kelli\\ATM ASN Load Single Line Lot.xls";
	public String KelliSingleLineSerialForATM = dir + "\\TestData\\Kelli\\ATMASNLoadSingleLineSerial.xls";
	public String KelliMultiLineNormalForATM = dir + "\\TestData\\Kelli\\ATMASNLoadMultiLineNormal.xls";

	DataFormatter dataFormatter = new DataFormatter();
	
	public static List<String> itemList = new ArrayList<>();

	public KelliPages() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);

	}

	public static String account = Config.getProperty("Account"); //Different accounts QSC and NVI 

	@FindBy(xpath = "//input[contains(@id,'login:userId')]")
	public WebElement userid;

	@FindBy(xpath = "//input[contains(@id,'login:lastName')]")
	public WebElement password;

	@FindBy(xpath = "//input[contains(@id,'ogin:loginBtn')]")
	public WebElement loginbutton;

	@FindBy(xpath = "//span[@id='fileUpload']//a[normalize-space(text())='FSC Upload']")
	public WebElement FSCupload;

	@FindBy(xpath = "//a[normalize-space(text())='Upload']")
	public WebElement upload;

	@FindBy(xpath = "//select[@id='fileUpld:messageType']")
	public WebElement messagetype;

	@FindBy(id = "j_idt8:j_idt15")
	public WebElement WelcomeSYSTEMUSER;

	@FindBy(xpath = "//*[@id=\"fileUpld:fileEntry\"]")
	public WebElement choosefile;

	@FindBy(xpath = "//input[@id='fileUpld:search']")
	public WebElement uploadfile;

	@FindBy(xpath = "//*[@id=\"fileUpld:j_idt65\"]/ul/li[1]")
	public WebElement File_uploaded_successfully;

	@FindBy(xpath = "//a[contains(text(),'View Logs')]")
	public WebElement Viewlogs;

	@FindBy(xpath = "//select[@name='viewLogs:messageType']")
	public WebElement Logsmessagetype;

	@FindBy(xpath = "//select[@id='viewLogs:chooseAnUplodadedFile']")
	public WebElement chooseanuploadfile;

	@FindBy(xpath = "//select[@id='viewLogs:lineNo']")
	public WebElement LineNo;

	@FindBy(xpath = "//Select[@id='viewLogs:statusType']")
	public WebElement Status;

	@FindBy(xpath = "//input[@id='viewLogs:search']")
	public WebElement Getlogs;

	@FindBy(id = "fileUpload")
	public WebElement fileupload;

	// @FindBy(xpath="/html/body/div[1]/form/table/tbody/tr/td[2]/div/div[2]/div/table/tbody/tr[2]/td/div/div/ul/li[1]/a")
	// public WebElement upload;

	@FindBy(id = "fileUpld:messageType")
	public WebElement ItemLoadWMS;

	@FindBy(id = "fileUpld:fileEntry")
	public WebElement uploadelement;

	@FindBy(id = "fileUpld:search")
	public WebElement search;

	@FindBy(xpath = "//*[@id=\"fileUpld:j_idt65\"]/ul/li[1]")
	public WebElement fileUploadedSuccessfully1;

	@FindBy(xpath = "//*[@id=\"imenus0\"]/li[2]/a")
	public WebElement viewlogs;

	@FindBy(id = "viewLogs:messageType")
	public WebElement logsmessagetype;

	@FindBy(id = "viewLogs:chooseAnUplodadedFile")
	public WebElement chooseAnUplodadedFile;

	@FindBy(id = "viewLogs:lineNo")
	public static WebElement lineNo;

	@FindBy(id = "viewLogs:search")
	public static WebElement search_logs;

	@FindBy(xpath = "//input[@id='viewLogs:search']")
	public WebElement Getlogs1;

	@FindBy(xpath = "//*[@id=\"j_idt8:j_idt57\"]/b")
	public WebElement Logout;

	@FindBy(id="fileUpld:messageType")
	public static WebElement OrderLoadWMS;
	
	@FindBy(id="fileUpld:messageType")
	public static WebElement LocationLoadWMS;
	
	String userVal = "";

	public void loginPage() throws Exception {
		String env = Config.getProperty("Environment");
		System.out.println("Environment:--" + env);
		Thread.sleep(1000);
		if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env") ||env.equalsIgnoreCase("L2")) {
			driver.get(Config.getProperty("Kelli_Dev_URL"));
			userVal = Config.getProperty("Kelli_Dev_Username");
			//driver.navigate().to("javascript:document.getElementById('overridelink').click()");

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, userid, 20);
			userid.sendKeys(Config.getProperty("Kelli_Dev_Username"));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, password, 30);
			password.sendKeys(Config.getProperty("Kelli_Dev_Pwd"));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, loginbutton, 50);
			loginbutton.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, WelcomeSYSTEMUSER, 50);
			if(WelcomeSYSTEMUSER.getText().contains("Welcome")) {
			Steps.logger.info("Log in to Kelli application successful");
			}else {
				Steps.logger.info("Log in to Kelli application is unsuccessful");
				Steps.testRes = "Failed";
				Assert.assertTrue(false);
			}
		}else if(env.equalsIgnoreCase("L5")) {
			driver.get(Config.getProperty("Kelli_Dev_URL_L5"));
			userVal = Config.getProperty("Kelli_Dev_Username");
			//driver.navigate().to("javascript:document.getElementById('overridelink').click()");

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, userid, 20);
			userid.sendKeys(Config.getProperty("Kelli_Dev_Username_L5"));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, password, 30);
			password.sendKeys(Config.getProperty("Kelli_Dev_Pwd_L5"));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, loginbutton, 50);
			loginbutton.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, WelcomeSYSTEMUSER, 50);
			if(WelcomeSYSTEMUSER.getText().contains("Welcome")) {
				Steps.logger.info("Log in to Kelli application successful");
			}else {
				Steps.logger.info("Log in to Kelli application is unsuccessful");
				Steps.testRes = "Failed";
				Assert.assertTrue(false);
			}

		}
		else if (env.equalsIgnoreCase("TEST")) {
			driver.get(Config.getProperty("Kelli_QA_URL"));
			userVal = Config.getProperty("Kelli_QA_username");
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, userid, 20);
			System.out.println("Entering the userid");
			userid.sendKeys(Config.getProperty("Kelli_QA_username"));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, password, 30);
			System.out.println("Entering the password");
			password.sendKeys(Config.getProperty("Kelli_QA_password"));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, loginbutton, 50);
			System.out.println("Clicked on login button");
			loginbutton.click();

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, WelcomeSYSTEMUSER, 50);
			if(WelcomeSYSTEMUSER.getText().contains("Welcome")) {
			Steps.logger.info("Log in to Kelli application successful");
			}else {
				Steps.logger.info("Log in to Kelli application is unsuccessful");
				Steps.testRes = "Failed";
				Assert.assertTrue(false);
			}
		} else if (env.equalsIgnoreCase("STAGE")) {
			userVal = Config.getProperty("Kelli_QA_username");
			driver.get(Config.getProperty("Kelli_QA_URL"));

			driver.navigate().to("javascript:document.getElementById('overridelink').click()");

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, userid, 20);
			System.out.println("Entering the userid");
			userid.sendKeys(Config.getProperty("Kelli_QA_username"));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, password, 30);
			System.out.println("Entering the password");
			password.sendKeys(Config.getProperty("Kelli_QA_password"));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, loginbutton, 50);
			System.out.println("Clicked on login button");
			loginbutton.click();

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, WelcomeSYSTEMUSER, 50);
			if(WelcomeSYSTEMUSER.getText().contains("Welcome")) {
			Steps.logger.info("Log in to Kelli application successful");
			}else {
				Steps.logger.info("Log in to Kelli application is unsuccessful");
				Steps.testRes = "Failed";
				Assert.assertTrue(false);
			}
		}else if(env.equalsIgnoreCase("L4")) {
			driver.get(Config.getProperty("Kelli_Dev_URL_L4"));
			userVal = Config.getProperty("Kelli_Dev_Username_L4");
			//driver.navigate().to("javascript:document.getElementById('overridelink').click()");

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, userid, 20);
			userid.sendKeys(Config.getProperty("Kelli_Dev_Username_L4"));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, password, 30);
			password.sendKeys(Config.getProperty("Kelli_Dev_Pwd_L4"));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, loginbutton, 50);
			loginbutton.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, WelcomeSYSTEMUSER, 50);
			if(WelcomeSYSTEMUSER.getText().contains("Welcome")) {
				Steps.logger.info("Log in to Kelli application successful");
			}else {
				Steps.logger.info("Log in to Kelli application is unsuccessful");
				Steps.testRes = "Failed";
				Assert.assertTrue(false);
			}
		}
	}

	// Updating Kelli ASN Load Sheet
	public void updateASNLoadSheet(String fileType) throws Exception {
		String kelliASNfilePath = null;
		
		String accnt = KelliPages.account;
		System.out.println("Account : = "+accnt);
		if (accnt.equalsIgnoreCase("QSC")) {
			if (fileType.contains("Single Line")) {
				kelliASNfilePath = KelliSingleLineASNfilePath;
			} else if (fileType.contains("Multi Line")) {
				kelliASNfilePath = KelliMultiLineASNfilePath;
			}
		} else if (accnt.equalsIgnoreCase("NVI")) {
			if (fileType.contains("Single Line")) {
				kelliASNfilePath = KelliSingleLineASNfilePathForNVI;
			} else if (fileType.contains("Multi Line")) {
				// kelliASNfilePath = KelliMultiLineASNfilePath;
			}
		} else if (accnt.equalsIgnoreCase("APC")) {
			if (fileType.contains("Single Line Normal")) {
				kelliASNfilePath = KelliSingleLineASNfilePathForAPC;
			} else if (fileType.contains("Single Line Serial")) {
				kelliASNfilePath = KelliSingleLineSerialAPC;
			} else if (fileType.contains("Single Line Lot")) {
				kelliASNfilePath = KelliSingleLineLotAPC;
			} else if (fileType.contains("Multi Line")) {
				// kelliASNfilePath = KelliMultiLineASNfilePath;
			} else if (fileType.contains("Single Line ASN")) {
				kelliASNfilePath = KelliSingleLineASNfilePathForAPC;
			}
		} else if (accnt.equalsIgnoreCase("THH")) {
			kelliASNfilePath = KelliASNfilePathForTHH;
		} else if (accnt.equalsIgnoreCase("FUJ")) {
			kelliASNfilePath = KelliASNfilePathForFUJ;
		}else if (accnt.equalsIgnoreCase("THM")) {
			kelliASNfilePath = KelliASNfilePathForTHM;
		}else if (accnt.equalsIgnoreCase("TRN")) {
			if (fileType.contains("Single Line")) {
				kelliASNfilePath = KelliASNfilePathForTRN;
			} else if (fileType.contains("Multi Line")) {
				kelliASNfilePath = KelliMultiLineASNfilePathForTRN;
			}
		}else if (accnt.equalsIgnoreCase("ILW")) {
			kelliASNfilePath = KelliASNfilePathForILW;
		} else if (accnt.equalsIgnoreCase("ATM")) {
			if (fileType.contains("Single Line Normal")) {
				kelliASNfilePath = KelliSingleLineNormalForATM;
			}else if (fileType.contains("Single Line Lot")) {
				kelliASNfilePath = KelliSingleLineLotForATM;
			} else if (fileType.contains("Single Line Serial")) {
				kelliASNfilePath = KelliSingleLineSerialForATM;
			} else if (fileType.contains("Multi Line Normal")) {
				kelliASNfilePath = KelliMultiLineNormalForATM;
			}
		}

		File file = new File(kelliASNfilePath);

		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int cellNo1 = 0;
		int cellNo2 = 0;
		int cellNo3 = 0;
		int cellNo4 = 0;
		for (int i = 0; i < 1; i++) {
			int cellcount = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j < cellcount; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getCellType() + ",");
				if (sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("Tracking_Nbr")) {
					cellNo1 = j;
				}
				if (sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("PO_Nbr")) {
					cellNo2 = j;
				}
				if (sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("Lot_Nbr")) {
					cellNo3 = j;
				}
				if (sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("Serial_Nbr")) {
					cellNo4 = j;
				}
			}
		}

		String po_Nbr_subString = null;
		for (int i = 1; i <= rowCount; i++) {
			Cell cell = sheet.getRow(i).getCell(cellNo1);
			String trackNo = dataFormatter.formatCellValue(cell);
			String updatedTrackNo_subString = trackNo.substring(0, trackNo.indexOf("_"));
			System.out.println("udatedTrackNo_subString: " + updatedTrackNo_subString);
			// long trackNo = (long) sheet.getRow(i).getCell(cellNo1).getNumericCellValue();
			System.out.println("Tracking_Nbr::" + trackNo);
			// updating tracking Nbr to Excel.
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmm");
			LocalDateTime now = LocalDateTime.now();
			String date = dtf.format(now);
			long udatedTrackNo = new Long(date).longValue();
			sheet.getRow(i).getCell(cellNo1).setCellValue(updatedTrackNo_subString + "_" + new Long(udatedTrackNo).longValue());
			Steps.logger.info("Updated Tracking_Nbr::" + updatedTrackNo_subString + "_" + new Long(udatedTrackNo).longValue());
			partialASNValue=  updatedTrackNo_subString + "_" + new Long(udatedTrackNo).longValue();

			// Reading PO_Nbr from Excel.
			String pO_NbrValue = sheet.getRow(i).getCell(cellNo2).getStringCellValue();
			System.out.println("PO_Nbr value::" + pO_NbrValue);
			String updatedPONbrValue_subString = pO_NbrValue.substring(0, trackNo.indexOf("_"));
			sheet.getRow(i).getCell(cellNo2)
					.setCellValue(updatedPONbrValue_subString + "_" + new Long(udatedTrackNo).longValue());
			Steps.logger.info("Updated PO_Nbr::" + updatedPONbrValue_subString + "_" + new Long(udatedTrackNo).longValue());
			
			if (sheet.getRow(i).getCell(cellNo3) != null) {
				String lotNumber = sheet.getRow(i).getCell(cellNo3).getStringCellValue();
				System.out.println("Lot_Nbr value::" + lotNumber);
				String updatedLotNumber_subString = lotNumber.substring(0, 2);
				System.out.println("updated lot number" + updatedLotNumber_subString);
				long udatedLotNo = new Long(date).longValue();
				sheet.getRow(i).getCell(cellNo3)
						.setCellValue(updatedLotNumber_subString + new Long(udatedLotNo).longValue());
				Steps.logger
						.info("Updated Lot Number::" + updatedLotNumber_subString + new Long(udatedLotNo).longValue());
			}
			
			if (sheet.getRow(i).getCell(cellNo4) != null) {
				String serialNumber = sheet.getRow(i).getCell(cellNo4).getStringCellValue();
				System.out.println("Serial_Nbr value::" + serialNumber);
				String updatedSerialNumber_subString = serialNumber.substring(0, 2);
				System.out.println("updated serail number" + updatedSerialNumber_subString);
				long udatedSerialNo = new Long(date).longValue();
				sheet.getRow(i).getCell(cellNo4)
						.setCellValue(updatedSerialNumber_subString + new Long(udatedSerialNo).longValue());
				Steps.logger.info("Updated Serial Number::" + updatedSerialNumber_subString
						+ new Long(udatedSerialNo).longValue());
				
				serialNumber =  updatedSerialNumber_subString
						+ new Long(udatedSerialNo).longValue();
				System.out.println("Serial Number fetch from Edi file"+serialNumber);
				Items.setEdiSerialNumber(serialNumber);
				Steps.logger.info("ASNNumber: " + Items.getEdiSerialNumber());
				
			}
		}

		inputStream.close(); // Close the InputStream
		FileOutputStream output_file = new FileOutputStream(new File(kelliASNfilePath));
		wb.write(output_file); // write changes

		output_file.close();
		String itemName = null;
		String shpQty = null;
		String uom = null;
		for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
			itemName = Steps.ItemDataMap.get(i).get("Item");
			shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
			uom = Steps.ItemDataMap.get(i).get("UOM");
			System.out.println("itemName"+itemName);
			Items.setItemsForReceivingASN(itemName.trim());
			System.out.println("itemName="+Items.getItemsForReceivingASN(i));
			Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shpQty));
			Items.setItemWithQtyUOM(itemName, uom);
		}
	}

	public void updateItemLoadSheet() throws Exception {
		File file = new File(KelliItemloadfilePath);
		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i <= rowCount; i++) {
			// updating Item Id
			DateTime.TimeDateFunc();
			String updatedItemId = "Item" + DateTime.strDate7;
			sheet.getRow(i).getCell(1).setCellValue(updatedItemId);
			System.out.println("Updated ItemId:" + updatedItemId);
			itemList.add(updatedItemId);

			// updating SHORT_DESCRIPTION
			String updatedSD = "Item" + DateTime.strDate7;
			sheet.getRow(i).getCell(2).setCellValue(updatedSD);
			System.out.println("Updated Short description:" + updatedSD);

			// updating DESCRIPTION
			String updatedDesc = "Item" + DateTime.strDate7;
			sheet.getRow(i).getCell(3).setCellValue(updatedDesc);
			System.out.println("Updated Short description:" + updatedDesc);

			// updating EXTENDED_DESCRIPTION
			String updatedED = "Item" + DateTime.strDate7;
			sheet.getRow(i).getCell(4).setCellValue(updatedED);
			System.out.println("Updated Extended description:" + updatedED);

		}
		inputStream.close(); // Close the InputStream
		FileOutputStream output_file = new FileOutputStream(new File(KelliItemloadfilePath));
		wb.write(output_file); // write changes

		output_file.close();

	}
	
	public void updateOrderLoadSheet(String filetype) throws IOException {
		
		String path= null;
		if(filetype.contains("Single Line Order")) {
			path= KelliSingleLineOrderfilePath;
		}else if(filetype.contains("Multi Line Order")) {
			path= KelliMultiLineOrderfilePath;
		}
		
		FileInputStream fsIP= new FileInputStream(new File(path));                  
		HSSFWorkbook wb = new HSSFWorkbook(fsIP); 
		HSSFSheet worksheet = wb.getSheetAt(0); 
		// declare a Cell object
		Cell cell = null; 
		// Access the second cell in second row to update the value


		String currentOrderDate = null;
		String currentOrderTime = null;
		String currentOrderDateTime = null;
		Date currDate = new Date();
		SimpleDateFormat formatterDate = new SimpleDateFormat("YYMMdd");
		currentOrderDate = formatterDate.format(currDate);
		SimpleDateFormat formatterTime = new SimpleDateFormat("mm");
		currentOrderTime = formatterTime.format(currDate);
		currentOrderDateTime = currentOrderDate + currentOrderTime;

		//System.out.println(S1+currentOrderDateTime);
		//System.out.println(currentOrderDateTime);
		//Close the InputStream 
		//System.out.println("updated");
		fsIP.close(); 
		//Open FileOutputStream to write updates
		//String columnWanted = "Tracking_Nbr";
		String columnWanted = "CustPONum";
		Integer columnNo = null;
		//output all not null values to the list
		List<Cell> cells = new ArrayList<Cell>();

		Row firstRow = worksheet.getRow(0);
		for(Cell cell2:firstRow){
			if (cell2.getStringCellValue().equals(columnWanted)){
				columnNo = cell2.getColumnIndex();
				//System.out.println("CustPONum is present im " +columnNo);
			}
		}


		if (columnNo != null){
			for (Row row : worksheet) {
				Cell c = row.getCell(columnNo);
				cells.add(c);
				 //System.out.println("c is "+c);
			}
		}
		int size= cells.size();
		//System.out.println("size is " +size);
		for (int i=1;i<size;i++) {
			cell = worksheet.getRow(i).getCell(columnNo)  ; 
			// Get current cell value value and overwrite the value
			String s= cell.getStringCellValue();
			int length=s.length();
			String S1=s.substring(0, length - 8) ;
			//System.out.println("S1 IS " +S1);
			//System.out.println(S1+currentOrderDateTime);
			String ss=S1+currentOrderDateTime;
			//cell.setCellValue(S1+currentOrderDateTime);
			
			cell.setCellValue(ss);
			Steps.logger.info("CustPONum is set to " +ss);
		}
		String columnWanted3 = "OrderNumber";
		Integer columnNo3 = null;
		List<Cell> cells3 = new ArrayList<Cell>();
		for(Cell cell1:firstRow){
			if (cell1.getStringCellValue().equals(columnWanted3)){
				columnNo3 = cell1.getColumnIndex();
				//System.out.println("OrderNum is present im " +columnNo3);
			}
		}


		if (columnNo3 != null){
			for (Row row : worksheet) {
				Cell c = row.getCell(columnNo3);
				cells3.add(c);
				// System.out.println("c is "+c);
			}
		}
		int size3= cells3.size();
		//System.out.println("size is " +size);
		for (int i=1;i<size3;i++) {
			cell = worksheet.getRow(i).getCell(columnNo3)  ; 
			// Get current cell value value and overwrite the value
			String s= cell.getStringCellValue();
			int length=s.length();
			String S1=s.substring(0, length - 8) ;
			//System.out.println("S1 IS " +S1);
			//System.out.println(S1+currentOrderDateTime);
			String ss=S1+currentOrderDateTime;
			//cell.setCellValue(S1+currentOrderDateTime);
			
			cell.setCellValue(ss);
			Steps.logger.info("Order Number is set to " +ss);
			Items.setDONumber(ss);
			Steps.logger.info("DO Number: "+ss);
			Reporter.addStepLog("DO Number: "+ss);
		}
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = new Date();
	       // System.out.println(dateFormat.format(date));
		String columnWanted1 = "ShipDate";
		Integer columnNo1 = null;
		List<Cell> cells1 = new ArrayList<Cell>();
		for(Cell cell2:firstRow){
			if (cell2.getStringCellValue().equals(columnWanted1)){
				columnNo1 = cell2.getColumnIndex();
				// System.out.println("Po no is present im " +columnNo1);
			}
		}
		if (columnNo1 != null){
			for (Row row : worksheet) {
				Cell c1 = row.getCell(columnNo1);
				cells1.add(c1);
				//System.out.println("c1 is "+c1);
			}
		}

		int size1= cells1.size();
		//System.out.println("size is " +size1);
		String S1;
		for (int i=1;i<size1;i++) {
			cell = worksheet.getRow(i).getCell(columnNo1)  ; 
			// Get current cell value value and overwrite the value
			//double s= cell.getNumericCellValue();
			//int length=s.length();
			//S1=s.substring(0, length - 8) ;
			//	System.out.println(S1+currentOrderDateTime);
			cell.setCellValue(dateFormat.format(date));
			Steps.logger.info("Ship date is set to "+dateFormat.format(date));

		}
		FileOutputStream output_file =new FileOutputStream(new File(path));  
		//write changes
		wb.write(output_file);
		//close the stream
		output_file.close();
		Reporter.addStepLog("Order Load Excel updated ");
		Steps.logger.info("Order Load Excel updated ");

	}
	
	public void updateLocationsLoadSheet() throws IOException {
		System.out.println("updating...");
		FileInputStream fsIP= new FileInputStream(new File(Config.getProperty("excelpathLocationLoad")));                  
		HSSFWorkbook wb = new HSSFWorkbook(fsIP); 
		HSSFSheet worksheet = wb.getSheetAt(0); 
		// declare a Cell object
		Cell cell = null; 
		// Access the second cell in second row to update the value


		String currentOrderDate = null;
		String currentOrderTime = null;
		String currentOrderDateTime = null;
		Date currDate = new Date();
		SimpleDateFormat formatterDate = new SimpleDateFormat("YYMMdd");
		currentOrderDate = formatterDate.format(currDate);
		SimpleDateFormat formatterTime = new SimpleDateFormat("HHmm");
		currentOrderTime = formatterTime.format(currDate);
		currentOrderDateTime = currentOrderDate + currentOrderTime;

		//System.out.println(S1+currentOrderDateTime);
		System.out.println(currentOrderDateTime);
		//Close the InputStream 
		System.out.println("updated");
		fsIP.close(); 
		//Open FileOutputStream to write updates
		//String columnWanted = "Tracking_Nbr";
		String columnWanted = "Location";
		Integer columnNo = null;
		//output all not null values to the list
		List<Cell> cells = new ArrayList<Cell>();

		Row firstRow = worksheet.getRow(0);
		for(Cell cell2:firstRow){
			if (cell2.getStringCellValue().equals(columnWanted)){
				columnNo = cell2.getColumnIndex();
				System.out.println("Location is present im " +columnNo);
			}
		}


		if (columnNo != null){
			for (Row row : worksheet) {
				Cell c = row.getCell(columnNo);
				cells.add(c);
				 System.out.println("c is "+c);
			}
		}
		int size= cells.size();
		//System.out.println("size is " +size);
		for (int i=1;i<size;i++) {
			cell = worksheet.getRow(i).getCell(columnNo)  ; 
			// Get current cell value value and overwrite the value
			//String s= cell.getStringCellValue();
			//int length=s.length();
			//String S1=s.substring(0, length - 8) ;
		//	System.out.println("S1 IS " +S1);
			//System.out.println(S1+currentOrderDateTime);
			String ss="LOC"+currentOrderDateTime;
			//cell.setCellValue(S1+currentOrderDateTime);
			
			cell.setCellValue(ss);
			System.out.println("Location is set to " +ss);
		}
		
		FileOutputStream output_file =new FileOutputStream(new File(Config.getProperty("excelpathLocationLoad")));  
		//write changes
		wb.write(output_file);
		//close the stream
		output_file.close();
		Reporter.addStepLog("Excel updated ");
		//Steps.logger.info("Columns are updated with " +S1+currentOrderDateTime);

	}

	// Upload file functionality 
	public void Kelliupload(String fileType) throws Exception {

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, FSCupload, 100);
		FSCupload.click();
		System.out.println("Clicked on FSCupload button");
		Steps.logger.info("Clicked on FSCupload button");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, upload, 100);
		upload.click();
		System.out.println("Clicked on upload button");
		Steps.logger.info("Clicked on upload button");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, messagetype, 100);
		String accnt = KelliPages.account;
		if (accnt.equalsIgnoreCase("QSC")) {

			if (fileType.contains("Single Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineASNfilePath);
			} else if (fileType.contains("Multi Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliMultiLineASNfilePath);
			} else if (fileType.contains("Single Line Order")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "OrderLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineOrderfilePath);
			} else if (fileType.contains("Multi Line Order")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "OrderLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliMultiLineOrderfilePath);
			} else if (fileType.contains("Item")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ItemLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliItemloadfilePath);
			} else if (fileType.contains("Location")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "LocationLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliLocationloadfilePath);
			}
		} else if (accnt.equalsIgnoreCase("NVI")){
			if (fileType.contains("Single Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineASNfilePathForNVI);
			} else if (fileType.contains("Multi Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliMultiLineASNfilePath);
			} else if (fileType.contains("Single Line Order")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "OrderLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineOrderfilePath);
			} else if (fileType.contains("Multi Line Order")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "OrderLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliMultiLineOrderfilePath);
			} else if (fileType.contains("Item")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ItemLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliItemloadfilePath);
			} else if (fileType.contains("Location")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "LocationLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliLocationloadfilePath);
			}

		} else if (accnt.equalsIgnoreCase("APC")){
			if (fileType.contains("Single Line Normal")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineASNfilePathForAPC);
			}else if (fileType.contains("Single Line Serial")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineSerialAPC);
			}else if (fileType.contains("Single Line Lot")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineLotAPC);
			}else if (fileType.contains("Single Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineASNfilePathForAPC);
			} 
		} else if(accnt.equalsIgnoreCase("THH")) {
			if (fileType.contains("Single Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliASNfilePathForTHH);
			}
		}else if(accnt.equalsIgnoreCase("FUJ")) {
			if (fileType.contains("Single Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliASNfilePathForFUJ);
			}
		}else if(accnt.equalsIgnoreCase("THM")) {
			if (fileType.contains("Single Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliASNfilePathForTHM);
			}
		}else if(accnt.equalsIgnoreCase("TRN")) {
			if (fileType.contains("Single Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliASNfilePathForTRN);
			}else if (fileType.contains("Multi Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliMultiLineASNfilePathForTRN);
			} 
		}else if(accnt.equalsIgnoreCase("ILW")) {
			if (fileType.contains("Single Line ASN")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliASNfilePathForILW);
			}
		}else if(accnt.equalsIgnoreCase("ATM")) {
			if (fileType.contains("Single Line Normal")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineNormalForATM);
			}else if (fileType.contains("Single Line Lot")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineLotForATM);
			}else if (fileType.contains("Single Line Serial")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliSingleLineSerialForATM);
			}//KelliMultiLineNormalForATM
			else if (fileType.contains("Multi Line Normal")) {
				SeleniumTestHelper.selectFromDropDown(messagetype, "ASNLoad(WMS)", "visibletext");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
				choosefile.sendKeys(KelliMultiLineNormalForATM);
			}
		}
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, uploadfile, 100);
		Steps.logger.info("Clicked on uploadfile");
		uploadfile.click();

		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, File_uploaded_successfully, 100);
		if (SeleniumTestHelper.isElementDisplayed(File_uploaded_successfully)) {
			// SeleniumTestHelper.assertEquals(File_uploaded_successfully.getText(), "File
			// uploaded successfully.");
			SeleniumTestHelper.assertTrue(
					File_uploaded_successfully.getText().matches("^[\\s\\S]*File uploaded successfully[\\s\\S]*$"));
			System.out.println(fileType + " file uploaded successfully");
			Reporter.addStepLog(fileType+" file uploaded successfully");
		} else {
			System.out.println(fileType+" file not uploaded successfully");
			Reporter.addStepLog(fileType+" file not uploaded successfully");
			Steps.testRes = "Failed";
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		String s1 = File_uploaded_successfully.getText().trim().replaceAll("File uploaded successfully.", "").trim();
		s1 = userVal + "->" + s1;
		this.UploadString = s1;
	}


	// getlogs for Item load and validate the success status
	public void viewlogs() throws Exception {
		Thread.sleep(3000);
		viewlogs.click();
		Select menu = new Select(messagetype);
		//menu.selectByVisibleText("ItemLoad(WMS)");
		menu.selectByVisibleText("OrderLoad(WMS)");
		//menu.selectByVisibleText("LocationLoad(WMS)");
		
		Thread.sleep(5000);
		// String subs=fileUploadedSuccessfully.substring(0, 49);
		String subs=a1.replace("File uploaded successfully.","");
		String subs1=  subs.trim();
		System.out.println(subs1);
		Select Choose_an_uploaded_file = new Select(chooseAnUplodadedFile);
		Choose_an_uploaded_file.selectByVisibleText("debfer->"+subs1);
		//Choose_an_uploaded_file.selectByVisibleText("debfer->20201223-RAP-Kelli ASN Load-MEM.xls-1608737260168");
		Thread.sleep(2000);
		Select menu4 = new Select(lineNo);
		menu4.selectByIndex(1);
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector("#viewLogs\\:search")).click();
		search_logs.click();
		Thread.sleep(2000);
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"viewLogs:serchResultTable_body\"]/tr"));
		//List<WebElement> rows= number_of_rows;
		int num=rows.size();
		System.out.println("number of rows in the table "+num);
		int success=0,fail=0;
		for(int i=0;i<num;i++)
		{
			Thread.sleep(2000);
			String lineNo=driver.findElement(By.cssSelector("#viewLogs\\:serchResultTable\\:"+i+"\\:j_idt96")).getText();
			//String Status =driver.findElement(By.id("viewLogs:serchResultTable:"+i+":j_idt102")).getText();
			String Status =driver.findElement(By.xpath("//*[@id=\"viewLogs:serchResultTable_row_"+i+"\"]/td[4]")).getText();
			//System.out.println("status for line number " +lineNo +" is " +Status);
			
			if(Status.equalsIgnoreCase("Success")) {
				success++;
			}
			else if(Status.equalsIgnoreCase("Failed")){
				fail++;
			}
			Thread.sleep(2000);
		}

		Steps.logger.info("Number of successes= " +success);
		Steps.logger.info("Number of failures= " +fail);
		driver.quit();
		Assert.assertEquals(fail, 0," 0 failures");
		Steps.logger.info("logs verified successfully");
		//Assert.assertTrue(false);
		//Steps.logger.info("All are successful ");
	}

	// View logs for ASN upload functionality
	public void viewlogsforASNUpload() throws Exception {

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Viewlogs, 50);
		Thread.sleep(1000);
		Viewlogs.click();
		System.out.println("Clicking on viewlogs button");
		Steps.logger.info("Clicked on viewlogs button");
		System.out.println("UploadString::" + UploadString);
		Thread.sleep(1000);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Logsmessagetype, 50);
		Select sel = new Select(Logsmessagetype);
		System.out.println("logs message type selecting");
		sel.selectByValue("7");
		Steps.logger.info("logs message type selected");

		Thread.sleep(2000);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, chooseanuploadfile, 50);
		Select sel1 = new Select(chooseanuploadfile);
		System.out.println("choose an chooseanuploadfile selected");
		sel1.selectByVisibleText(UploadString);
		Steps.logger.info("choose an uploadfile selected");

		Thread.sleep(3000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Getlogs, 50);
		Getlogs.click();
		System.out.println("Clicked on Getlogs");
		Steps.logger.info("Clicked on Getlogs");

		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, LineNo, 50);
		Select sel2 = new Select(LineNo);
		sel2.selectByIndex(1);
		System.out.println("LineNo selected");
		Steps.logger.info("LineNo selected");

		/*
		 * Thread.sleep(1000);
		 * SeleniumTestHelper.waitForElementToBeDisplayed(driver,Status,50); Select sel3
		 * = new Select(Status); sel3.deselectByIndex(1);
		 * System.out.println("Status selected"); Steps.logger.info("Status selected");
		 */

		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Getlogs, 50);
		Getlogs.click();
		System.out.println("Clicked on Getlogs");
		Steps.logger.info("Clicked on Getlogs");

		Thread.sleep(1000);

		String text = LineNo.getText();
		System.out.println(text);

		Thread.sleep(5000);

		List<WebElement> tableStatus = driver
				.findElements(By.xpath("//*[contains(@class,'ui-datatable')]//*[@class='null ui-col-3']"));

		int failCount = 0;
		for (int i = 0; i < tableStatus.size(); i++) {
			int row = i + 1;
			if (tableStatus.get(i).getText().trim().equalsIgnoreCase("Success")) {
				System.out.println("Row No " + row + " " + tableStatus.get(i).getText());

				// SoftAssert softassert = new SoftAssert();
				// softassert.assertEquals("Success", tableStatus.get(i).getText().trim());

			} else {
				// Reporter.addStepLog("Failed");
				Steps.testRes = "Failed";
				failCount++;

			}
			// Steps.logger.info("Row No " + row + " " + tableStatus.get(i).getText());
			// Reporter.addStepLog("Row No " + row + " " + tableStatus.get(i).getText());
		}
		if (failCount != 0) {
			Steps.logger.info(tableStatus.size() + " out of " + failCount + " Failed");
			Reporter.addStepLog(tableStatus.size() + " out of " + failCount + " Failed");
			Assert.assertEquals("Failed", "Success");
		}

	}

	
	
	// Logout from the application
	public void logoutKelliApplication() throws Exception {

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Logout, 100);
		Thread.sleep(1000);
		Logout.click();
		Thread.sleep(2000);
		System.out.println("Clicked on logout button");
		Steps.logger.info("User is logged out");
		//driver.close();
	}
}
