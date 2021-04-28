package reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

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
import globalFunc.DateTime;
import pages.ManhattanLoginPage;
import utils.Config;
import utils.SeleniumTestHelper;

public class KelliPages {

	WebDriver driver;
	public static String UploadString = null;
	public String a1;
	public String S1;
	DataFormatter dataFormatter = new DataFormatter(); 

	public KelliPages() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);

	}

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

	@FindBy(xpath = "//label[text()='Welcome - SYSTEM USER (Admin)']")
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

	String dir= System.getProperty("user.dir");
	String kelliASNfilePath = dir+"/TestData/Kelli ASN Load.xls";
	String KelliItemLoadfilePath = dir+"/TestData/Kelli Item Load.xls";

	public void loginPage() throws Exception {

			String env = ManhattanLoginPage.environment;
			System.out.println("Environment:--"+env);
			if (env.equalsIgnoreCase("DEV")|| env.equalsIgnoreCase("@Env")) {
				driver.get(Config.getProperty("Kelli_Dev_URL"));

				driver.navigate().to("javascript:document.getElementById('overridelink').click()");

				SeleniumTestHelper.waitForElementToBeDisplayed(driver, userid, 20);
				System.out.println("Entering the userid");
				userid.sendKeys(Config.getProperty("Kelli_Dev_Username"));

				SeleniumTestHelper.waitForElementToBeDisplayed(driver, password, 30);
				System.out.println("Entering the password");
				password.sendKeys(Config.getProperty("Kelli_Dev_Pwd"));

				SeleniumTestHelper.waitForElementToBeDisplayed(driver, loginbutton, 50);
				System.out.println("Clicked on login button");
				loginbutton.click();

				if (SeleniumTestHelper.isElementDisplayed(WelcomeSYSTEMUSER)) {
					SeleniumTestHelper.assertEquals(WelcomeSYSTEMUSER.getText(), "Welcome - SYSTEM USER (Admin)");
					System.out.println("Log in to Kelli application successfully");
					Reporter.addStepLog("Log in to Kelli application successfully");
				} else {

					Reporter.addStepLog("Log in not successfull to kelli application");

				}
				Steps.logger.info("Dev Environment");
			} else if (env.equalsIgnoreCase("TEST") ) {
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

				if (SeleniumTestHelper.isElementDisplayed(WelcomeSYSTEMUSER)) {
					SeleniumTestHelper.assertEquals(WelcomeSYSTEMUSER.getText(), "Welcome - SYSTEM USER (Admin)");
					System.out.println("Log in to Kelli application successfully");
					Reporter.addStepLog("Log in to Kelli application successfully");
				} else {

					Reporter.addStepLog("Log in not successfull to kelli application");

				}
			} else if (env.equalsIgnoreCase("STAGE")) {
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

				if (SeleniumTestHelper.isElementDisplayed(WelcomeSYSTEMUSER)) {
					SeleniumTestHelper.assertEquals(WelcomeSYSTEMUSER.getText(), "Welcome - SYSTEM USER (Admin)");
					System.out.println("Log in to Kelli application successfully");
					Reporter.addStepLog("Log in to Kelli application successfully");
				} else {

					Reporter.addStepLog("Log in not successfull to kelli application");

				}
				Steps.logger.info("UA Environment");
			}
	}
		
		

	// Updating Kelli ASN Load Sheet
	public void KelliASNLoadSheetUpdate() throws Exception {

		// Create an object of File class to open xlsx file
		File file = new File(kelliASNfilePath);

		 // Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		 // creating workbook instance that refers to .xls file
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);

		 // creating a Sheet object
		HSSFSheet sheet = wb.getSheetAt(0);

		 // get all rows in the sheet
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		 int cellNo1 = 0;
		 int cellNo2 = 0;

		 // iterate over the first row to get column number based on column name.
		for (int i = 0; i < 1; i++) {

		 // get cell count in a row
		int cellcount = sheet.getRow(i).getLastCellNum();

		 // iterate over each cell to print its value
		System.out.println("Row " + i + " data is :");

		 for (int j = 0; j < cellcount; j++) {
		System.out.print(sheet.getRow(i).getCell(j).getCellType() + ",");
		if (sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("Tracking_Nbr")) {
		cellNo1 = j;
		}
		if (sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("PO_Nbr")) {
		cellNo2 = j;
		}
		}
		System.out.println();
		}

		 System.out.println("Tracking_Nbr::" + cellNo1);
		System.out.println("PO_Nbr::" + cellNo2);
		String po_Nbr_subString = null;
		for (int i = 1; i <= rowCount; i++) {
		// reading tracking Nbr for Excel.
		Cell cell = sheet.getRow(i).getCell(cellNo1);
		String trackNo = dataFormatter.formatCellValue(cell);
		//long trackNo = (long) sheet.getRow(i).getCell(cellNo1).getNumericCellValue();
		System.out.println("Tracking_Nbr::" + trackNo);
		// updating tracking Nbr to Excel.
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmm");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		System.out.println("date::" + date);
		long udatedTrackNo = new Long(date).longValue();
		sheet.getRow(i).getCell(cellNo1).setCellValue(i+"_"+new Long(udatedTrackNo).longValue());
		System.out.println("Updated Tracking_Nbr::" + udatedTrackNo);

		 // Reading PO_Nbr from Excel.
		String pO_NbrValue = sheet.getRow(i).getCell(cellNo2).getStringCellValue();
		System.out.println("PO_Nbr value::" + pO_NbrValue);

		 // Updating PO_Nbr to Excel.
		if (pO_NbrValue != null && po_Nbr_subString == null) {
		po_Nbr_subString = pO_NbrValue.substring(0, pO_NbrValue.lastIndexOf("_"));
		System.out.println("po_Nbr_subString::" + po_Nbr_subString);
		}

		 if (po_Nbr_subString != null) {
		String updatedPo_Nbr = po_Nbr_subString + "_" + udatedTrackNo;
		sheet.getRow(i).getCell(cellNo2).setCellValue(i+"_"+udatedTrackNo);
		System.out.println("Updated Tracking_Nbr::" + updatedPo_Nbr);
		}

		 }
		inputStream.close(); // Close the InputStream
		FileOutputStream output_file = new FileOutputStream(new File(kelliASNfilePath));
		wb.write(output_file); // write changes

		 output_file.close();

	}

	public void KelliItemLoadSheetUpdate()throws Exception{
		// Create an object of File class to open xlsx file
				File file = new File(KelliItemLoadfilePath);

				 // Create an object of FileInputStream class to read excel file
				FileInputStream inputStream = new FileInputStream(file);

				 // creating workbook instance that refers to .xls file
				HSSFWorkbook wb = new HSSFWorkbook(inputStream);

				 // creating a Sheet object
				HSSFSheet sheet = wb.getSheetAt(0);

				 // get all rows in the sheet
				int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
				for (int i = 1; i <= rowCount; i++) {
				// updating Item Id
				DateTime.TimeDateFunc();
				String updatedItemId="Item"+DateTime.strDate6;
				sheet.getRow(i).getCell(1).setCellValue(updatedItemId);
				System.out.println("Updated ItemId:" + updatedItemId);

				// updating SHORT_DESCRIPTION
				String updatedSD="Item"+DateTime.strDate6;
				sheet.getRow(i).getCell(2).setCellValue(updatedSD);
				System.out.println("Updated Short description:" + updatedSD);
				
				// updating DESCRIPTION
				String updatedDesc="Item"+DateTime.strDate6;
				sheet.getRow(i).getCell(3).setCellValue(updatedDesc);
				System.out.println("Updated Short description:" + updatedDesc);
				
				// updating EXTENDED_DESCRIPTION
				String updatedED="Item"+DateTime.strDate6;
				sheet.getRow(i).getCell(4).setCellValue(updatedED);
				System.out.println("Updated Extended description:" + updatedED);

				 }
				inputStream.close(); // Close the InputStream
				FileOutputStream output_file = new FileOutputStream(new File(KelliItemLoadfilePath));
				wb.write(output_file); // write changes

				 output_file.close();

	}

	// Upload file functionality for ASN load
	public void ASNupload() throws Exception {

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, FSCupload, 100);
		FSCupload.click();
		System.out.println("Clicked on FSCupload button");
		Steps.logger.info("Clicked on FSCupload button");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, upload, 100);
		upload.click();
		System.out.println("Clicked on upload button");
		Steps.logger.info("Clicked on upload button");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, messagetype, 100);
		Select sel = new Select(messagetype);
		sel.selectByValue("7");
		System.out.println("selected message type");
		Steps.logger.info("selected message type");
		Thread.sleep(2000);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 100);
		choosefile.sendKeys("kelliASNfilePath");
		System.out.println("file selected to uploaed ");
		Steps.logger.info("file selected to uploaed ");
		Thread.sleep(1000);

		// ((JavascriptExecutor)
		// driver).executeScript("$('input[id*=\"fileUpld:fileEntry\"]').click()");

		// driver.findElement(By.xpath("//*[@id=\"fileUpld:fileEntry\"]")).sendKeys("E:\\RAP-Kelli
		// ASN Load-MEM.xls");
		// Steps.logger.info("Clicked on browse file");
		// System.out.println("Clicked on browse file");

		// ((JavascriptExecutor) driver).executeScript("var t =
		// document.getElementById('fileUpld:fileEntr'); " + "t.value =
		// arguments[0];","E:\\RAP-Kelli ASN Load-MEM.xls");
		// Thread.sleep(10000);
		// SeleniumTestHelper.uploadfile(System.getProperty("E:\\RAP-Kelli ASN
		// Load-MEM.xls"));
		// System.out.println("File is Uploaded Successfully");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, uploadfile, 100);
		System.out.println("Clicked on uploadfile");
		Steps.logger.info("Clicked on uploadfile");
		uploadfile.click();

		Thread.sleep(2000);

		if (SeleniumTestHelper.isElementDisplayed(File_uploaded_successfully)) {
			// SeleniumTestHelper.assertEquals(File_uploaded_successfully.getText(), "File
			// uploaded successfully.");
			SeleniumTestHelper.assertTrue(
					File_uploaded_successfully.getText().matches("^[\\s\\S]*File uploaded successfully[\\s\\S]*$"));
			System.out.println("ASN file uploaded successfully");
			Reporter.addStepLog("ASN file uploaded successfully");
		} else {

			Reporter.addStepLog("ASN file not uploaded successfully");

		}
		Thread.sleep(2000);
		String s1 = File_uploaded_successfully.getText().trim().replaceAll("File uploaded successfully.", "").trim();
		s1 = "debfer->" + s1;

		this.UploadString = s1;

	}

	// Upload file functionality for Item load
	public void itemUpload() throws Exception {
		System.out.println("uploading..");
		// driver.findElement(By.xpath("//span[@id='fileUpload']//a[normalize-space(text())='FSC
		// Upload']")).click();
		// driver.findElement(By.id("fileUpload")).click();
		Thread.sleep(2000);
		fileupload.click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//a[normalize-space(text())='Upload']")).click();
		upload.click();
		Thread.sleep(2000);

		// Select menu = new Select(driver.findElement(By.id("fileUpld:messageType")));
		Select menu = new Select(ItemLoadWMS);
		menu.selectByVisibleText("ItemLoad(WMS)");
		Thread.sleep(5000);
		// WebElement uploadElement = driver.findElement(By.id("fileUpld:fileEntry"));
		uploadelement.sendKeys(Config.getProperty("excelpath"));
		Thread.sleep(5000);
		// driver.findElement(By.id("fileUpld:search")).click();
		search.click();
		Thread.sleep(3000);
		a1 = fileUploadedSuccessfully1.getText();
		System.out.println(a1);

		String str2 = "File uploaded successfully";

		Assert.assertTrue(a1.contains(str2), "FileUploaded Successfully");
		{
			Steps.logger.info("fileUploadedSuccessfully is validated");
			Reporter.addStepLog("fileUploadedSuccessfully is validated");
		}
	}

	// getlogs for Item load and validate the success status
	public void viewlogsforItemUplaod() throws Exception {
		Thread.sleep(3000);
		viewlogs.click();
		Select menu = new Select(logsmessagetype);
		menu.selectByVisibleText("ItemLoad(WMS)");
		Thread.sleep(5000);
		// String subs=fileUploadedSuccessfully.substring(0, 49);
		String subs = a1.replace("File uploaded successfully.", "");
		String subs1 = subs.trim();
		System.out.println(subs1);
		Select Choose_an_uploaded_file = new Select(chooseAnUplodadedFile);
		Choose_an_uploaded_file.selectByVisibleText("debfer->" + subs1);
		// Choose_an_uploaded_file.selectByVisibleText("debfer->20201223-RAP-Kelli ASN
		// Load-MEM.xls-1608737260168");
		Thread.sleep(2000);
		Select menu4 = new Select(lineNo);
		menu4.selectByIndex(1);
		Thread.sleep(2000);
		// driver.findElement(By.cssSelector("#viewLogs\\:search")).click();
		search_logs.click();
		Thread.sleep(2000);
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"viewLogs:serchResultTable_body\"]/tr"));
		// List<WebElement> rows= number_of_rows;
		int num = rows.size();
		System.out.println("number of rows in the table " + num);
		int success = 0, fail = 0;
		for (int i = 0; i < num; i++) {
			Thread.sleep(2000);
			String lineNo = driver.findElement(By.cssSelector("#viewLogs\\:serchResultTable\\:" + i + "\\:j_idt96"))
					.getText();
			// String Status
			// =driver.findElement(By.id("viewLogs:serchResultTable:"+i+":j_idt102")).getText();
			String Status = driver.findElement(By.xpath("//*[@id=\"viewLogs:serchResultTable_row_" + i + "\"]/td[4]"))
					.getText();
			// System.out.println("status for line number " +lineNo +" is " +Status);

			if (Status.equalsIgnoreCase("Success")) {
				success++;
			} else if (Status.equalsIgnoreCase("Failed")) {
				fail++;
			}
			Thread.sleep(2000);
		}

		Steps.logger.info("Number of successes= " + success);
		Steps.logger.info("Number of failures= " + fail);
		driver.quit();
		Assert.assertEquals(fail, 0, " 0 failures");
		Steps.logger.info("logs verified successfully");
		// Assert.assertTrue(false);
		// Steps.logger.info("All are successful ");
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

		Thread.sleep(1000);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, chooseanuploadfile, 50);
		Select sel1 = new Select(chooseanuploadfile);
		System.out.println("choose an chooseanuploadfile selected");
		sel1.selectByVisibleText(UploadString);
		Steps.logger.info("choose an uploadfile selected");

		Thread.sleep(1000);
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
		System.out.println("Clicked on logout button");
		Steps.logger.info("Clicked on logout button");

	}
}
