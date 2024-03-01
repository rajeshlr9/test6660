package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import utils.SeleniumTestHelper;

public class O2SInventoryPage {

	WebDriver driver;

	public static String TestedBy = null;

	public O2SInventoryPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='inputForm:itemNum']")
	public WebElement itemId;

	@FindBy(xpath = "//input[@id='inputForm:qty']")
	public WebElement itemQty;

	@FindBy(xpath = "//input[@id='inputForm:addItem']")
	public WebElement addItem;

	@FindBy(xpath = "//*[@id='inputForm:findInventoryOutboundRequestedItems:searchAvail']")
	public WebElement searchAvailability;

	@FindBy(xpath = "//input[@id='inputInboundForm:submitBtn']")
	public WebElement continueBtn;

	@FindBy(xpath = "//table[@id='inputInboundForm:whItems']//tr//td[7]/span")
	public WebElement inventoryAvailable;
	
	@FindBy(xpath = "//*[@id='LoadingDisplayBox']")
	public WebElement loadingDisplayBox;
	
	@FindBy(xpath = "//span[@id='inputForm:findInventoryOutboundRequestedItems:reqItems:0:notes:0:noteError']")
	public WebElement itemNotFoundError;
		
	/**
	 * This method use for add items in add inventory step
	 * @throws Exception
	 */
	public void addInventory() throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemId, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(itemId));

		String itemName = null;
		String shpQty = null;

		for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
			System.out.println(Steps.ItemDataMap.size());
			Steps.logger.info("Steps.ItemDataMap Size" + Steps.ItemDataMap.size());
			itemName = Steps.ItemDataMap.get(i).get("Item");
			shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
		//}
		System.out.println("Item Id or Name = " + itemName);
		SeleniumTestHelper.enterTextInTextBox(itemId, itemName);

		// SeleniumTestHelper.enterTextInTextBox(itemId, "619-00-014");
		Steps.logger.info("Enter item id");
		//Thread.sleep(10000);
		SeleniumTestHelper.WaitForPageLoad(5000);
		System.out.println("Item Qty or Number = " + shpQty);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemQty, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(itemQty));

		SeleniumTestHelper.enterTextInTextBox(itemQty, shpQty);
		// SeleniumTestHelper.enterTextInTextBox(itemQty, "1");
		Steps.logger.info("Enter item Qty");
		//Thread.sleep(5000);
		SeleniumTestHelper.WaitForPageLoad(3000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, addItem, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(addItem));
		SeleniumTestHelper.clickOnButton(addItem);
		//addItem.click();
		Steps.logger.info("Clicked on Add Item");
		SeleniumTestHelper.WaitForPageLoad(3000);
		//Thread.sleep(5000);
		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, searchAvailability, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(searchAvailability));
		SeleniumTestHelper.scrollToElement(driver, searchAvailability);
		SeleniumTestHelper.clickOnButton(searchAvailability);
		//searchAvailability.click();
		Steps.logger.info("Clicked on Search Availability");
		//Thread.sleep(5000);
		SeleniumTestHelper.WaitForPageLoad(3000);
		if(SeleniumTestHelper.isElementDisplayed(itemNotFoundError)) {
			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(inventoryAvailable), "Inventory not available - Showing Item Not found Error");
		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, inventoryAvailable, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(inventoryAvailable));
		SeleniumTestHelper.scrollToElement(driver, inventoryAvailable);
		Steps.logger.info("Inventory available");
		
		//Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, continueBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(continueBtn));
		SeleniumTestHelper.scrollToElement(driver, continueBtn);
		SeleniumTestHelper.clickOnButton(continueBtn);
		//continueBtn.click();
		Steps.logger.info("Clicked on Continue button");
		//Thread.sleep(5000);
		SeleniumTestHelper.WaitForPageLoad(3000);
		while(SeleniumTestHelper.isElementDisplayed(loadingDisplayBox)) {
			System.out.println("Wait till the loading Display Box getting display");
			SeleniumTestHelper.WaitForPageLoad();
		}
		Reporter.addStepLog("User added item details in add inventory step");
	}

}
