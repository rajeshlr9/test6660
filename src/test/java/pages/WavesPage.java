package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.Screenshots;
import utils.Driver;
import utils.SeleniumTestHelper;
import utils.TestStubReader;

public class WavesPage {
	WebDriver driver;

	public WavesPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	HomePage homepage = new HomePage();
	@FindBy(xpath = "//span[text()='Wave Number:']/../..//input[@type='text']")
	public WebElement waveNumberSearchTxt;

	@FindBy(xpath = "(//input[@value='Apply' and @title = 'Apply'])[1]")
	public WebElement waveNumberApplySearchBtn;

	@FindBy(xpath = "(//input[@value='Apply' and @title = 'Apply'])[1]")
	public WebElement searchedWaveNumberLbl;
	@FindBy(xpath = "//span[text()='Plt pull task from resv/pack & hold']/../preceding-sibling::td[2]/span[1]")
	public WebElement selectRlocationfrmWave;

	@FindBy(xpath = "//td[@class='tbl_checkBox advtbl_col advtbl_body_col']")
	public WebElement shipWavechkbox;
	@FindBy(id = "rmButton_2View1_100662000")
	public WebElement shipWaveviewBtn;
	@FindBy(id = "dataForm:OrdersDeselected")
	public WebElement OrdersdeselectedValue;
	@FindBy(id = "dataForm:LinesAllocated")
	public WebElement linesAllocatedValue;
	@FindBy(id = "dataForm:UnitsAllocated")
	public WebElement unitsAllocatedValue;
	@FindBy(id = "dataForm:reasonCode11")
	public WebElement shortageReasonCd;
	@FindBy(id = "ExceptionSummaryTab_lnk")
	public WebElement ShortageTab;
	@FindBy(id= "rmbuttons_1moreButton")
	public WebElement MoreButton;
	@FindBy(id="rmButton_2Tasks1_100668000")
	public WebElement TasksOption;
	@FindBy(id="dataForm:lview:dataTable:0:descVal_taskCmplRefNbr")
	public WebElement getoLPNNumber;
	@FindBy(id="dataForm:lview:dataTable:1:descVal_taskCmplRefNbr")
	public WebElement getoLPNNumber2;


	public void searchForTheWaveNumberAndVerifyItsDisplayed(String waveNumber) throws Exception {
		homepage.MenuItems_Distribution_Selection("Waves");
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveNumberSearchTxt, 50);
		waveNumberSearchTxt.sendKeys(waveNumber);
		waveNumberApplySearchBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				driver.findElement(By.xpath("//span[text()='" + waveNumber + "']")), 50);
		SeleniumTestHelper.assertTrue(true, "Wave number : " + waveNumber + " displayed");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
		shipWavechkbox.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWaveviewBtn, 50);
		shipWaveviewBtn.click();
	}

	public void getLocation() throws InterruptedException, IOException {

		String sheetname = null;
		String rowname = null;
		int columnnumber = 0;

		List<WebElement> getLocation = driver.findElements(
				By.xpath("//span[text()='Plt pull task from resv/pack & hold']/../preceding-sibling::td[2]/span[1]"));

		String RLocation = getLocation.get(0).getText();
		Items.setRlocation_one(RLocation);
		System.out.println("Selected FIFO Location: " + RLocation);

		SeleniumTestHelper.assertTrue(true, "Wave number : " + RLocation + " displayed");
		TestStubReader stubReader = new TestStubReader();
		String currentSheetName = sheetname;
		System.out.println("SheetName Is : " + currentSheetName);
		stubReader.setReadingSheet(currentSheetName);
		String dataFromsheet = stubReader.setSheetAndGetData(sheetname, rowname, columnnumber);
		String FirstRLocation = stubReader.setSheetAndGetData(sheetname, rowname, columnnumber + 1);
		System.out.println("--------------------" + FirstRLocation);
		System.out.println(dataFromsheet);
		SeleniumTestHelper.assertEquals(getLocation, FirstRLocation, "Inventory picked from First Priority Location");
	}

	public void searchForTheWaveNumberAndVerifyInventoryAllocation() throws Exception {
		homepage.MenuItems_Distribution_Selection("Waves");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveNumberSearchTxt, 50);
		waveNumberSearchTxt.sendKeys(Items.getWaveNumber());
		Screenshots.captureSnapshot(driver);
		waveNumberApplySearchBtn.click();
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				driver.findElement(By.xpath("//span[text()='" + Items.getWaveNumber() + "']")), 50);
		SeleniumTestHelper.assertTrue(true, "Wave number : " + Items.getWaveNumber() + " displayed");
		Reporter.addStepLog("Wave number : " + Items.getWaveNumber() + " displayed");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
		shipWavechkbox.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWaveviewBtn, 50);
		shipWaveviewBtn.click();

		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		if (OrdersdeselectedValue.getText().equals("0")) {
			String noofLines = String.valueOf(Steps.ItemDataMap.size());
			System.out.println("No of Lines:" + noofLines);
			SeleniumTestHelper.assertEquals(linesAllocatedValue.getText(), noofLines,
					"Verification of lines allocation ");
			Steps.logger.info("Total lines allocated: "+linesAllocatedValue.getText());
			Reporter.addStepLog("Total lines allocated: "+linesAllocatedValue.getText());
			int totalshippedQty = 0;
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				int temp = Integer.parseInt(Steps.ItemDataMap.get(i).get("ShippedQty"));
				totalshippedQty = temp + totalshippedQty;
			}
			String totalShippedQty = String.valueOf(totalshippedQty);
			System.out.println("Toatal Shipped Qty:" + totalShippedQty);
			SeleniumTestHelper.assertEquals(unitsAllocatedValue.getText(), totalShippedQty,"Verification of units allocation ");
			Steps.logger.info("Total units allocated: "+unitsAllocatedValue.getText());
			Reporter.addStepLog("Total units allocated: "+unitsAllocatedValue.getText());
			Thread.sleep(2000);
			Steps.logger.info("Inventory got allocated successfuuly");
			Reporter.addStepLog("Inventory got allocated successfuuly");
		} else if (OrdersdeselectedValue.getText().equals("1")) {
			SeleniumTestHelper.waitForElementToBeClickable(driver, ShortageTab, 10);
			ShortageTab.click();
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shortageReasonCd, 10);
			String reasonCode = shortageReasonCd.getText();
			Steps.logger.info("Order got deselected. Reason: " + reasonCode);
			Reporter.addStepLog("Order got deselected. Reason: " + reasonCode);
			Steps.testRes = "Failed";
			Assert.assertTrue(false, "Order got deselected. Reason: " + reasonCode);
		}
		homepage.userClosesOpenedwindow("Waves - Wave Details");
	}

	public void searchForTheWaveNumberAndVerifyOrderGotDeselected() throws Exception {
		homepage.MenuItems_Distribution_Selection("Waves");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveNumberSearchTxt, 50);
		waveNumberSearchTxt.sendKeys(Items.getWaveNumber());
		Screenshots.captureSnapshot(driver);
		waveNumberApplySearchBtn.click();
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				driver.findElement(By.xpath("//span[text()='" + Items.getWaveNumber() + "']")), 50);
		SeleniumTestHelper.assertTrue(true, "Wave number : " + Items.getWaveNumber() + " displayed");
		Reporter.addStepLog("Wave number : " + Items.getWaveNumber() + " displayed");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
		shipWavechkbox.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWaveviewBtn, 50);
		shipWaveviewBtn.click();

		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		if (OrdersdeselectedValue.getText().equals("1")) {
			SeleniumTestHelper.waitForElementToBeClickable(driver, ShortageTab, 10);
			ShortageTab.click();
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shortageReasonCd, 10);
			String reasonCode = shortageReasonCd.getText();
			Steps.logger.info("Order got deselected. Reason: " + reasonCode);
			Reporter.addStepLog("Order got deselected. Reason: " + reasonCode);
			globalFunc.Screenshots.seleniumSnapshot(driver);
			Screenshots.addingScreenshottoExentReport();
		}else {
			Steps.testRes = "Failed";
			Assert.assertTrue(false, "Order was not deselected from wave");
		}

		homepage.userClosesOpenedwindow("Waves - Wave Details");
	}

	public String searchForTheWaveNumberAndGetTheTask() throws Exception {
		homepage.MenuItems_Distribution_Selection("Waves");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveNumberSearchTxt, 50);
		waveNumberSearchTxt.sendKeys(Items.getWaveNumber());
		Reporter.addStepLog("Entered wave number"+Items.getWaveNumber());
		Steps.logger.info("Entered wave number"+Items.getWaveNumber());
		Screenshots.captureSnapshot(driver);
		waveNumberApplySearchBtn.click();
		Reporter.addStepLog("Clicked on search button");
		Steps.logger.info("Clicked on search button");
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				driver.findElement(By.xpath("//span[text()='" + Items.getWaveNumber() + "']")), 50);
		SeleniumTestHelper.assertTrue(true, "Wave number : " + Items.getWaveNumber() + " displayed");
		Reporter.addStepLog("Wave number : " + Items.getWaveNumber() + " displayed");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
		shipWavechkbox.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWaveviewBtn, 50);	
		MoreButton.click();
		Thread.sleep(2000);
		//SeleniumTestHelper.switchToInnerFrame(driver);
		TasksOption.click();
		WebElement simpleTable=driver.findElement(By.id("dataForm:lview:dataTable_body"));
		List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
		System.out.println("Table row size: "+rows.size());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
		shipWavechkbox.click();
		Screenshots.captureSnapshot(driver);
		Thread.sleep(2000);
		driver.findElement(By.id("rmButton_1View1_167271343")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("DetailsTab_lnk")).click();
		Thread.sleep(2000);
		String oLPN = driver.findElement(By.id("dataForm:Tab1_D29")).getText();
		System.out.println("oLPN Number is: "+oLPN);
		Reporter.addStepLog("oLPN Number is: "+oLPN);
		Steps.logger.info("oLPN Number is: "+oLPN);
		homepage.userClosesOpenedwindow("Waves - Task Details");
		return oLPN;
	}
	public String GetTheTaskinCompleteStatus() throws Exception {
		homepage.MenuItems_Distribution_Selection("Waves");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveNumberSearchTxt, 50);
		waveNumberSearchTxt.sendKeys(Items.getWaveNumber());
		Screenshots.captureSnapshot(driver);
		waveNumberApplySearchBtn.click();
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				driver.findElement(By.xpath("//span[text()='" + Items.getWaveNumber() + "']")), 50);
		SeleniumTestHelper.assertTrue(true, "Wave number : " + Items.getWaveNumber() + " displayed");
		Reporter.addStepLog("Wave number : " + Items.getWaveNumber() + " displayed");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
		shipWavechkbox.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWaveviewBtn, 50);	
		MoreButton.click();
		Thread.sleep(2000);
		//SeleniumTestHelper.switchToInnerFrame(driver);
		TasksOption.click();
		/*
		 * WebElement
		 * simpleTable=driver.findElement(By.id("dataForm:lview:dataTable_body"));
		 * List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
		 * System.out.println("Table row size: "+rows.size());
		 * 
		 * //Print data from each row for (WebElement row : rows) { List<WebElement>
		 * cols = row.findElements(By.tagName("td")); for (WebElement col : cols) {
		 * 
		 * System.out.print(col.getText() + "\t"); } System.out.println(); }
		 */

		WebElement base = driver.findElement(By.id("dataForm:lview:dataTable_body"));
		List<WebElement> tableRows = base.findElements(By.tagName("tr"));
		System.out.println("tableRows.size: "+tableRows.size());
		String oLPNVal=null;
		for(int tRows=0;tRows<tableRows.size()-1;tRows++) {
			List<WebElement> tableCols = tableRows.get(tRows).findElements(By.tagName("td"));
			System.out.println("col size: "+tableCols.size());
			String cellValue = tableCols.get(5).getText();
			if(cellValue.equals("90 - Complete")) {
				oLPNVal = tableCols.get(8).getText();
				System.out.println("oLPNVal: "+oLPNVal);
				break;
			}


		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, getoLPNNumber, 50);

		System.out.println("oLPN Number is: "+oLPNVal);
		String oLPN = oLPNVal;
		homepage.user_closes_openedwindow("Waves - Tasks");
		return oLPN;
	}
}
