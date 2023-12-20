package pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import globalFunc.Screenshots;
import utils.Config;
import utils.SeleniumTestHelper;

public class O2SHomePage {
	WebDriver driver;

	public static String TestedBy = null;

	public static String environment = Config.getProperty("Environment"); 
	public static String account = Config.getProperty("Account"); 

	public O2SHomePage() throws Throwable {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath = "//table/tbody/tr/td/a[contains(text(),'Logout')]")
	@FindBy(xpath = "//*[contains(@id,'logoutLink')]")
	public WebElement logout;

	@FindBy(xpath = "//*[@id='ulaitem0z1']")
	public WebElement createBtn;

	@FindBy(xpath = "//input[@name='identifyCustomerForm:customerAccount']")
	public WebElement accountTextField;

	@FindBy(xpath = "//input[@id='identifyCustomerForm:submitB']")
	public WebElement continueBtn;

	@FindBy(xpath = "//input[@name='identifyCustomerForm:callerIdNumber']")
	public WebElement callerID;

	@FindBy(xpath = "//input[@name='identifyCustomerForm:locationCode']")
	public WebElement locationCode;
	
	@FindBy(xpath = "(//input[@name='identifyCustomerForm:orderType'])[3] ")
	public WebElement returnItemAndReplaceOption;
	
	@FindBy(xpath = "//input[@id='identifyCustomerForm:rmaNumber']")
	public WebElement rmaNumberTextFiled;
	
	@FindBy(xpath = "//*[@id='ulitem0z3']")
	public WebElement searchOrderMenu;
	
	@FindBy(xpath = "//*[@id='ulitem0z3']//div[@class='imsc']//div[@class='imsubc']//ul/li/a[contains(text(),'Search Order')]")
	public WebElement searchOrderSubMenu;
	
	@FindBy(xpath="//*[@id='headertopnav']/span[@class='nav_link_inactive_services']/a[contains(text(),'WMS')]")
	public WebElement wmsTab;

	
	/**
	 * This method logoutFormO2SApp use for logout from the O2S application 
	 * @throws Exception
	 */
	public void logoutFormO2SApp() throws Exception {
		System.out.println("Click on Logout");
		SeleniumTestHelper.scrollUp();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, logout, 120);
		SeleniumTestHelper.scrollToElement(driver, logout);
		//SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(logout));
		SeleniumTestHelper.clickOnButton(logout);
		//logout.click();
		Steps.logger.info("Clicked on Logout Button");
		Thread.sleep(10000);
	}
	
	/**
	 * This method createOrderFirstStep use for Create an Order using Caller ID and Location Code as first step
	 * @throws Exception
	 */
	public void createOrderFirstStep(String orderType) throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, createBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(createBtn));
		SeleniumTestHelper.clickOnButton(createBtn);
		//createBtn.click();
		Steps.logger.info("Clicked on Create Button");
		Thread.sleep(5000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, accountTextField, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(accountTextField));
		SeleniumTestHelper.enterTextInTextBox(accountTextField, account);
		Steps.logger.info("Enter Account Number");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, continueBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(continueBtn));
		SeleniumTestHelper.clickOnButton(continueBtn);
		//continueBtn.click();
		Steps.logger.info("Clicked on Continue Button");
		Thread.sleep(5000);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, callerID, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(callerID));
		SeleniumTestHelper.enterTextInTextBox(callerID, "123456");
		Steps.logger.info("Enter Called ID");
		Thread.sleep(5000);
		callerID.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		if (orderType.equalsIgnoreCase("retunItemAndReplace")) {
			selectTheReturnItemAndReplaceOptionAndRMANumber();
		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationCode, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(locationCode));
		SeleniumTestHelper.scrollToElement(driver, locationCode);
		if (orderType.equalsIgnoreCase("retunItemAndReplace")) {
			SeleniumTestHelper.enterTextInTextBox(locationCode, "1");
		} else {
			SeleniumTestHelper.enterTextInTextBox(locationCode, "12");
		}
		Thread.sleep(5000);
		locationCode.sendKeys(Keys.ENTER);
		Steps.logger.info("Enter Location Code");
		Thread.sleep(5000);
		Screenshots.captureSnapshot(driver);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, continueBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(continueBtn));
		SeleniumTestHelper.scrollToElement(driver, continueBtn);
		SeleniumTestHelper.clickOnButton(continueBtn);
		//continueBtn.click();
		Steps.logger.info("Clicked on Continue Button");
		Thread.sleep(5000);
		Reporter.addStepLog("User perform FirstStep in Create Order by using Caller ID and Location Code...");

	}
	
//------------------------------------------------	
	//created for sanity check
	public void createOrderFirstStep2(String account1,String orderType) throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, createBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(createBtn));
		SeleniumTestHelper.clickOnButton(createBtn);
		//createBtn.click();
		Steps.logger.info("Clicked on Create Button");
		Thread.sleep(5000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, accountTextField, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(accountTextField));
		SeleniumTestHelper.enterTextInTextBox(accountTextField, account1);
		Steps.logger.info("Enter Account Number: "+account1);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, continueBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(continueBtn));
		SeleniumTestHelper.clickOnButton(continueBtn);
		//continueBtn.click();
		Steps.logger.info("Clicked on Continue Button");
		Thread.sleep(5000);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, callerID, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(callerID));
		SeleniumTestHelper.enterTextInTextBox(callerID, "123456");
		Steps.logger.info("Enter Called ID");
		Thread.sleep(5000);
		callerID.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		if (orderType.equalsIgnoreCase("retunItemAndReplace")) {
			selectTheReturnItemAndReplaceOptionAndRMANumber();
		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationCode, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(locationCode));
		SeleniumTestHelper.scrollToElement(driver, locationCode);
		if (orderType.equalsIgnoreCase("retunItemAndReplace")) {
			SeleniumTestHelper.enterTextInTextBox(locationCode, "1");
		} else {
			SeleniumTestHelper.enterTextInTextBox(locationCode, "12");
		}
		Thread.sleep(5000);
		locationCode.sendKeys(Keys.ENTER);
		Steps.logger.info("Enter Location Code");
		Thread.sleep(5000);
		Screenshots.captureSnapshot(driver);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, continueBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(continueBtn));
		SeleniumTestHelper.scrollToElement(driver, continueBtn);
		SeleniumTestHelper.clickOnButton(continueBtn);
		//continueBtn.click();
		Steps.logger.info("Clicked on Continue Button");
		Thread.sleep(5000);
		Reporter.addStepLog("User perform FirstStep in Create Order by using Caller ID and Location Code...");

	}
//------------------------------------------------	
	
	

	public void selectTheReturnItemAndReplaceOptionAndRMANumber() throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, returnItemAndReplaceOption, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(returnItemAndReplaceOption));
		SeleniumTestHelper.scrollToElement(driver, returnItemAndReplaceOption);
		returnItemAndReplaceOption.click();
		Steps.logger.info("Clicked on Return Item and Replace option");
		Thread.sleep(5000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, rmaNumberTextFiled, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(rmaNumberTextFiled));
		String rmaNumber = "";
		Date date = new Date();
		SimpleDateFormat sdfDate = new SimpleDateFormat("HHmmss");
		String strDate12 = sdfDate.format(date);
		rmaNumber = "1234" + strDate12;
		SeleniumTestHelper.enterTextInTextBox(rmaNumberTextFiled, rmaNumber);
		Thread.sleep(5000);
	}
	
	public void moveToSearchOrderMenuandClickSearchOrder() throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, searchOrderMenu, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(searchOrderMenu));
		SeleniumTestHelper.actionMouseHoverAndClickOnSubMenu(searchOrderMenu, searchOrderSubMenu);
		Steps.logger.info("Clicked on Return Item and Replace option");
		Thread.sleep(8000);
	}
	
	public void navigateToWMSApp() throws InterruptedException {
		//*[@id='headertopnav']/span[@class='nav_link_inactive_services']/a[contains(text(),'WMS')]
		//div[@id='applications']//ul//li/a[contains(text(),'Vendor')]
		//li[@id='receiveListItem']
		Thread.sleep(8000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, wmsTab, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(wmsTab));
		SeleniumTestHelper.clickOnButton(wmsTab);
		Thread.sleep(15000);
	}
	
	

}
