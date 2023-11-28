package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath = "//table[@id='warehouseDetailTable']//tr[1]/td//a[contains(text(),'MEM1')]")
	public WebElement tableDataWithNodeMem1;
	
	@FindBy(xpath = "//button[@id='searchButton']")
	public WebElement loadShipmentButton;
		
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
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, nodeFilterField, 180);
		SeleniumTestHelper.scrollToElement(driver, nodeFilterField);
		SeleniumTestHelper.enterText(nodeFilterField, "MEM1");
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, tableDataWithNodeMem1, 180);
		SeleniumTestHelper.scrollToElement(driver, tableDataWithNodeMem1);
		SeleniumTestHelper.click(tableDataWithNodeMem1);
		Thread.sleep(5000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, reasonCodeSelector, 180);
		SeleniumTestHelper.selectFromDropDown(reasonCodeSelector, "Training", DropDownMode.VALUE);
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, custName, 180);
		SeleniumTestHelper.enterText(custName, "CILTest");
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectEnterPrise, 180);
		SeleniumTestHelper.scrollToElement(driver, selectEnterPrise);
		SeleniumTestHelper.selectFromDropDown(selectEnterPrise, "APC", DropDownMode.VALUE);
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, receiptNumber, 180);
		SeleniumTestHelper.scrollToElement(driver, receiptNumber);
		SeleniumTestHelper.enterText(receiptNumber, "APOC000000810-280731033-1");
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, loadShipmentButton, 180);
		SeleniumTestHelper.scrollToElement(driver, loadShipmentButton);
		SeleniumTestHelper.clickOnButton(loadShipmentButton);
		Thread.sleep(2000);

	}
	
	//div[@id='warehouseDetailTable_filter']//input[@type='search'] ->Node Filter
	//select[@id='reasonCodeSelect']
	//option value=Training
	//div[@id='Name']//input
	//select[@id='enterprise'] -SelectEnterPrise
	//option -> APC
	//input[@name='receiptNbr']
	//input[@name='shipmentNbr']
	//input[@name='lotNbr']
	//input[@name='serialNbr']
	//input[@name='itemNbr']
	//input[@name='orderNbr']
	//input[@name='bolNbr']
	//button[@id='searchButton'] ->Load Shipment button
	//button[@id='clearButton'] ->Clear button


}
