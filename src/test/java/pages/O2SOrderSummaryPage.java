package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import utils.Config;
import utils.SeleniumTestHelper;

public class O2SOrderSummaryPage {
	WebDriver driver;

	public static String TestedBy = null;

	public static String environment = Config.getProperty("Environment"); 
	public static String account = Config.getProperty("Account"); 

	public O2SOrderSummaryPage() throws Throwable {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Thank you for shipping with FedEx.  Your shipment number is')]")
	public WebElement successMsgForOrderPlace;

	@FindBy(xpath = "//a[@name='form1:orderNum']")
	public WebElement orderNumber;
	
	@FindBy(xpath = "//*[@id='ulaitem0z1']")
	public WebElement createBtn;
	
	/**
	 * This method checkOrderSummaryPage ensure Order has been created successfully
	 * @throws Exception
	 */
	public void checkOrderSummaryPage() throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, successMsgForOrderPlace, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(successMsgForOrderPlace));
		SeleniumTestHelper.assertTrue(successMsgForOrderPlace.getText().contains("Thank you for shipping with FedEx."));
		Steps.logger.info("Order created successfully...");
		Reporter.addStepLog("User in Order Summary page and see the message for successful order creation");
		Thread.sleep(5000);
	}
	/**
	 * This method getOrderNumberGenerated get the order number generated
	 * @throws Exception
	 */
	public void getOrderNumberGenerated() throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, orderNumber, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(orderNumber));
		Thread.sleep(10000);
		SeleniumTestHelper.assertNotNull(orderNumber.getText());
		System.out.println("Order Number  Generated Successfully = "+orderNumber.getText());
		Items.setDONumber(orderNumber.getText());
		Steps.logger.info("The Order Number Generated Succssfully : " + orderNumber.getText());
		Reporter.addStepLog("Order created successfully..." + orderNumber.getText());
		Thread.sleep(2000);

	}
	public void clickOnCreateButton() throws Exception{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, createBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(createBtn));
		SeleniumTestHelper.clickOnButton(createBtn);
		Steps.logger.info("Clicked on Create Button");
		Thread.sleep(10000);
	}

}
