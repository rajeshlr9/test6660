package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.Screenshots;
import utils.Config;
import utils.SeleniumTestHelper;

public class O2SSearchOrderDetails {
	WebDriver driver;

	public static String TestedBy = null;

	public static String environment = Config.getProperty("Environment"); // Different environments Dev and Test
	public static String account = Config.getProperty("Account"); // Different accounts QSC and NVI
	
	public O2SSearchOrderDetails() throws Throwable {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='orderSearchform:orderNumber']")
	public WebElement orderNumberTextField;
	
	@FindBy(xpath = "//input[@id='orderSearchform:searchDetails']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//span[@id='orderSearchform:resultTable:0:orderNumberTCS']")
	public WebElement orderNumberInSearchResultTable;
	
	@FindBy(xpath = "//span[@id='orderSearchform:resultTable:0:erpstatusVal']")
	public WebElement orderStatus;
	
	@FindBy(xpath = "//*[@id='ulaitem0z1']")
	public WebElement createBtn;
	
	/**
	 * This method checkOrderSummaryPage ensure Order has been created successfully
	 * @throws Exception
	 */
	public void enterOrderNumberToSearchDetails() throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, orderNumberTextField, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(orderNumberTextField));
		SeleniumTestHelper.enterTextInTextBox(orderNumberTextField, Items.getDONumber());
		Steps.logger.info("Order number enetered successfully...");
		SeleniumTestHelper.click(searchButton);
		Reporter.addStepLog("User entered the order number in search page and clicked on search");
		Thread.sleep(5000);
	}
	/**
	 * This method getOrderNumberGenerated get the order number generated
	 * @throws Exception
	 */
	public void verifyTheOrderStatusIsBookedOrNot() throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, orderNumberInSearchResultTable, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(orderNumberInSearchResultTable));
		Thread.sleep(5000);
		SeleniumTestHelper.assertNotNull(orderNumberInSearchResultTable.getText());
		System.out.println("Order Number displayed = "+orderNumberInSearchResultTable.getText());
		Steps.logger.info("The Order Number displayed in search page is : " + orderNumberInSearchResultTable.getText());
		//SeleniumTestHelper.waitForElementToBeDisplayed(driver, orderStatus, 180);
		int counter=0;
		while(!SeleniumTestHelper.isElementDisplayed(orderStatus)){
			Thread.sleep(10000);
			SeleniumTestHelper.click(searchButton);
			counter++;
			if(counter==9) {
				break;
			}
		}
		Assert.assertEquals(SeleniumTestHelper.isElementDisplayed(orderStatus),true,"Item status not present");
		SeleniumTestHelper.assertEquals("Booked", orderStatus.getText());
		Reporter.addStepLog("Order created successfully and status is ..." + orderStatus.getText());
		Screenshots.captureSnapshot(driver);
		//Thread.sleep(10000);
		SeleniumTestHelper.WaitForPageLoad(3000);

	}
	public void clickOnCreateButton() throws Exception{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, createBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(createBtn));
		SeleniumTestHelper.clickOnButton(createBtn);
		Steps.logger.info("Clicked on Create Button");
		//Thread.sleep(10000);
		SeleniumTestHelper.WaitForPageLoad(3000);
	}
	
	

}
