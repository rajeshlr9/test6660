package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import utils.Config;
import utils.SeleniumTestHelper;
import utils.SeleniumTestHelper.DropDownMode;

public class VendorPortalHomePage {
	
	WebDriver driver;

	public static String TestedBy = null;

	public static String environment = Config.getProperty("Environment"); 
	public static String account = Config.getProperty("Account"); 

	public VendorPortalHomePage() throws Throwable {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='applications']//ul//li/a[contains(text(),'Vendor')]")
	public WebElement VendorTab;

	@FindBy(xpath = "//li[@id='receiveListItem']")
	public WebElement receiveTab;
	
	@FindBy(xpath = "//div[@id='warehouseDetailTable_filter']//input[@type='search']")
	public WebElement nodeFilterField;
	
	@FindBy(xpath = "//select[@id='reasonCodeSelect']")
	public WebElement reasonCodeSelector;
	
	@FindBy(xpath = "//div[@id='Name']//input")
	public WebElement custName;
	
	@FindBy(xpath = "//select[@id='enterprise']")
	public WebElement selectEnterPrise;
	
	@FindBy(xpath = "//input[@name='receiptNbr']")
	public WebElement receiptNumber;
	
	@FindBy(xpath = "//table[@id='warehouseDetailTable']//tr[1]/td//a[contains(text(),'AMIAM')]")
	public WebElement tableDataWithNodeAMIAM;
	
	@FindBy(xpath = "//button[@id='searchButton']")
	public WebElement loadShipmentButton;
	
	@FindBy(xpath = "//table[@id='receiveTable']/tbody/tr[contains(@class,'fsc-rcv-tbl-grp-header')]")
	public WebElement expASNNumInSearchResult;
	
	@FindBy(xpath = "//table[@id='receiveTable']/tbody/tr[contains(@class,'fx-odd')]/td[2]")
	public WebElement statusInSearchResult;
	
	@FindBy(xpath = "//table[@id='receiveTable']/tbody/tr[contains(@class,'fx-odd')]/td[3]")
	public WebElement itemIdInSearchResult;
	
	@FindBy(xpath = "//table[@id='receiveTable']/tbody/tr[contains(@class,'fx-odd')]/td[7]")
	public WebElement uOMInSearchResult;
	
	@FindBy(xpath = "//table[@id='receiveTable']/tbody/tr[contains(@class,'fx-odd')]/td[9]//input")
	public WebElement itemQtyInSearchResult;
	
	@FindBy(xpath = "//table[@id='receiveTable']/tbody/tr[contains(@class,'fx-odd')]/td[4]")
	public WebElement orderNumInSearchResult;
	
	@FindBy(xpath = "//input[@name='lotNbr']")
	public WebElement lotNumber;
	
	@FindBy(xpath = "//input[@id='LOTNO_0_0']")
	public WebElement lotNumInSearchResult;
	
	@FindBy(xpath = "//input[@name='serialNbr']")
	public WebElement serialNumber;
	
	@FindBy(xpath = "//input[@id='SERIALNO_0_0']")
	public WebElement serialNumInSearchResult;
	
	@FindBy(xpath = "//div[contains(@class,'fx-error-banner')]/p")
	public WebElement errorBanner;
	
	@FindBy(xpath = "//*[@id='receiveTable']/tbody/tr[2]/td[10]/input")
	public WebElement putawayLocation;
	
	@FindBy(xpath = "//*[@id='receiveTable']")
	public WebElement receiveTable;
	
	@FindBy(xpath = "//button[@id='receiveButton']")
	public WebElement receiveButton;
	
	@FindBy(xpath = "//table[@id='receiveTable']//following::td[12]")
	public WebElement receiveStatus;
	
	@FindBy(xpath = "//input[@name='shipmentNbr']")
	public WebElement shipmentNbr;
	
	@FindBy(xpath = "//input[@id='SHIPBYDATE_0_1']")
	public WebElement shipmentByDt;
	
		
	public void naviagateAndClickReceiveTab() throws InterruptedException {
		Thread.sleep(5000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, VendorTab, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(VendorTab));
		SeleniumTestHelper.clickOnButton(VendorTab);
		Thread.sleep(5000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, receiveTab, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(receiveTab));
		SeleniumTestHelper.clickOnButton(receiveTab);
		Thread.sleep(10000);
	}
	
	public void enterMandatoryDetails() throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("Enter Mandatory Details");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, nodeFilterField, 180);
		SeleniumTestHelper.scrollToElement(driver, nodeFilterField);
		if (account.equalsIgnoreCase("ATM")) {
			// SeleniumTestHelper.enterText(nodeFilterField, "MEM1");
			SeleniumTestHelper.enterText(nodeFilterField, "AMI");
			Thread.sleep(2000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, tableDataWithNodeAMIAM, 180);
			SeleniumTestHelper.scrollToElement(driver, tableDataWithNodeAMIAM);
			SeleniumTestHelper.click(tableDataWithNodeAMIAM);
			Thread.sleep(5000);
		}else if (account.equalsIgnoreCase("COM")) {
			// SeleniumTestHelper.enterText(nodeFilterField, "MEM1");
			SeleniumTestHelper.enterText(nodeFilterField, "AMI");
			Thread.sleep(2000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, tableDataWithNodeAMIAM, 180);
			SeleniumTestHelper.scrollToElement(driver, tableDataWithNodeAMIAM);
			SeleniumTestHelper.click(tableDataWithNodeAMIAM);
			Thread.sleep(5000);
		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, reasonCodeSelector, 180);
		SeleniumTestHelper.selectFromDropDown(reasonCodeSelector, "Training", DropDownMode.VALUE);
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, custName, 180);
		SeleniumTestHelper.enterText(custName, "CILTest");
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectEnterPrise, 180);
		SeleniumTestHelper.scrollToElement(driver, selectEnterPrise);
		if (account.equalsIgnoreCase("ATM")) {
		SeleniumTestHelper.selectFromDropDown(selectEnterPrise, "ATM", DropDownMode.VALUE);
		}else if (account.equalsIgnoreCase("COM")) {
			SeleniumTestHelper.selectFromDropDown(selectEnterPrise, "COM", DropDownMode.VALUE);
		}
		Thread.sleep(2000);
	}
	
	public void searchUsingReceiptNumber() throws InterruptedException {
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, receiptNumber, 180);
		SeleniumTestHelper.scrollToElement(driver, receiptNumber);
		SeleniumTestHelper.enterText(receiptNumber, Items.getAsnNumber());
		clickOnLoadShipment();
	}
	
	public void searchUsingShipmentNumber() throws InterruptedException {
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipmentNbr, 180);
		SeleniumTestHelper.scrollToElement(driver, shipmentNbr);
		SeleniumTestHelper.enterText(shipmentNbr, Items.getPONumber());
		clickOnLoadShipment();
	}
	
	public void searchUsingLotNumber() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Enter Lot Number and Receipt Number");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lotNumber, 180);
		SeleniumTestHelper.scrollToElement(driver, lotNumber);
		SeleniumTestHelper.enterText(lotNumber, Items.getLotNumber());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, receiptNumber, 180);
		SeleniumTestHelper.scrollToElement(driver, receiptNumber);
		SeleniumTestHelper.enterText(receiptNumber, Items.getAsnNumber());
		clickOnLoadShipment();
	}
	public void searchUsingSerialNumber() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Enter Serial Number and Receipt Number");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, serialNumber, 180);
		SeleniumTestHelper.scrollToElement(driver, serialNumber);
		SeleniumTestHelper.enterText(serialNumber, Items.getEdiSerialNumber());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, receiptNumber, 180);
		SeleniumTestHelper.scrollToElement(driver, receiptNumber);
		SeleniumTestHelper.enterText(receiptNumber, Items.getAsnNumber());
		clickOnLoadShipment();
	}
	
	public void validateDataInReceiveTable() throws Exception {
		System.out.println("Validate the Expected data in Receive Table");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expASNNumInSearchResult, 300);
		SeleniumTestHelper.scrollToElement(driver, expASNNumInSearchResult);
		
		System.out.println("Expected shipmentVal: "+Items.getShipmentNum());
		System.out.println("Actual shipmentVal: "+expASNNumInSearchResult.getText());
		System.out.println("Item: "+Steps.ItemDataMap.get(0).get("Item"));
		System.out.println("UOM: "+Steps.ItemDataMap.get(0).get("UOM"));
		System.out.println("ShippedQty: "+Steps.ItemDataMap.get(0).get("ShippedQty"));
		System.out.println(itemQtyInSearchResult.getAttribute("value"));
		Reporter.addStepLog("Item: " + itemIdInSearchResult.getText()+";"+"Item Quantity: " + itemQtyInSearchResult.getAttribute("value")+";"+"UOM: " + uOMInSearchResult.getText());
		Reporter.addStepLog("ASN: " + expASNNumInSearchResult.getText()+";"+"Status: " + statusInSearchResult.getText());
		Assert.assertEquals(Items.getShipmentNum().contains(expASNNumInSearchResult.getText()), true, "Actual and Expected ASN Number didn't matched");
		Assert.assertEquals(statusInSearchResult.getText(), "Shipped", "Actual and Expected Status didn't matched");
		Assert.assertEquals(itemIdInSearchResult.getText(), Steps.ItemDataMap.get(0).get("Item"), "Actual and Expected item didn't matched");
		Assert.assertEquals(uOMInSearchResult.getText(), Steps.ItemDataMap.get(0).get("UOM"), "Actual and Expected UOM didn't matched");
		Assert.assertEquals(itemQtyInSearchResult.getAttribute("value"), Steps.ItemDataMap.get(0).get("ShippedQty"), "Actual and Expected Item Qty didn't matched");
		Thread.sleep(5000);
	}
	public void validateLotNumberInReceiveTable() throws InterruptedException {
		System.out.println("Validate lot number in receive table");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lotNumInSearchResult, 180);
		SeleniumTestHelper.scrollToElement(driver, lotNumInSearchResult);
		System.out.println(SeleniumTestHelper.isElementDisplayed(lotNumInSearchResult));
		System.out.println("Lot Number"+lotNumInSearchResult.getAttribute("value"));
		Assert.assertEquals(lotNumInSearchResult.getAttribute("value"), Items.getLotNumber(), "Actual and Expected Lot Number didn't matched");
		Steps.logger.info("Lot Number: " + Items.getLotNumber());
		Reporter.addStepLog("Lot Number: " + Items.getLotNumber());
		Thread.sleep(5000);
	}
	
	public void validateSerialNumberInReceiveTable() throws InterruptedException {
		System.out.println("Validate Serial number in receive table");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, serialNumInSearchResult, 180);
		SeleniumTestHelper.scrollToElement(driver, serialNumInSearchResult);
		System.out.println(SeleniumTestHelper.isElementDisplayed(serialNumInSearchResult));
		System.out.println("Serail Number"+serialNumInSearchResult.getAttribute("value"));
		Assert.assertEquals(serialNumInSearchResult.getAttribute("value"), Items.getEdiSerialNumber(), "Actual and Expected Serial Number didn't matched");
		Steps.logger.info("Serial Number: " + Items.getEdiSerialNumber());
		Reporter.addStepLog("Serial Number: " + Items.getEdiSerialNumber());
		Thread.sleep(5000);
	}
	
	public void clickOnLoadShipment() throws InterruptedException {
		
		Thread.sleep(2000);
		System.out.println("Click on Load Shipment");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, loadShipmentButton, 180);
		SeleniumTestHelper.scrollToElement(driver, loadShipmentButton);
		SeleniumTestHelper.clickOnButton(loadShipmentButton);
		Thread.sleep(5000);
		if(SeleniumTestHelper.isElementDisplayed(errorBanner)){
			Reporter.addStepLog("Error : " + errorBanner.getText());
			Assert.assertTrue(false, errorBanner.getText());
		}
	}
	
	public void vpReceive() throws InterruptedException {
		int rows =  driver.findElements(By.xpath("//table[@id='receiveTable']/tbody//following::tr")).size();
		for(int i=2;i<=rows;i++) {
			driver.findElement(By.xpath("//*[@id='receiveTable']/tbody/tr["+i+"]/td[10]/input")).click();
			 Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='receiveTable']/tbody/tr["+i+"]/td[10]/input")).sendKeys(Steps.ItemDataMap.get(i-2).get("RecLocation"));
			 Thread.sleep(2000);
			 if(Steps.ItemDataMap.get(i-2).get("ShipByDate")!="") {
				 shipmentByDt.sendKeys("11112035");
			 }
			//putawayLocation.click();
			//putawayLocation.sendKeys(Steps.ItemDataMap.get(i-2).get("RecLocation"));
		}
		
		receiveButton.click();
		 Thread.sleep(2000);
		String status = "Completed";
		
		 String AsnreceiveStatus = receiveStatus.getText();
			int count = 0;
			  while (!AsnreceiveStatus.equals(status) && (count != 20)) { 

			  AsnreceiveStatus = receiveStatus.getText();
			  Thread.sleep(6000);			 
			  count++; 
			  }
			  System.out.println("AsnreceiveStatus:"+AsnreceiveStatus);
		//Assert.assertEquals(status, AsnreceiveStatus);
		
	}
		
}
