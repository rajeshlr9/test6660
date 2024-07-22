package pages;

import org.openqa.selenium.By;
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

	//@FindBy(xpath = "//table[@id='inputInboundForm:whItems']//tr//td[7]/span")
	@FindBy(xpath = "//table[@id='inputInboundForm:whItems']//tr//td[7]")
	public WebElement inventoryAvailable;
	
	@FindBy(xpath = "//*[@id='LoadingDisplayBox']")
	public WebElement loadingDisplayBox;
	
	@FindBy(xpath = "//span[@id='inputForm:findInventoryOutboundRequestedItems:reqItems:0:notes:0:noteError']")
	public WebElement itemNotFoundError;
		
	
	@FindBy(xpath = "//*[@id='inputForm:selectUom']")
	public WebElement UOM;
	
	@FindBy(xpath = "//input[@id='inputForm:chkdefectiveItem']")
	public WebElement productClass;
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
		if(!(Steps.scenarioData.get("Account").equals("THH") || Steps.scenarioData.get("Account").equals("THM") || Steps.scenarioData.get("Account").equals("ATM"))) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, UOM, 180);
			SeleniumTestHelper.selectFromDropDown(UOM, Steps.ItemDataMap.get(i).get("UOM"), "value");
		}
//		if(!(Steps.scenarioData.get("Account")).equals("ATM")) {
//		SeleniumTestHelper.waitForElementToBeDisplayed(driver, UOM, 180);
//		SeleniumTestHelper.selectFromDropDown(UOM, Steps.ItemDataMap.get(i).get("UOM"), "value");
//		}
		
		if((Steps.scenarioData.get("Account")).equals("ATM")) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, productClass, 180);
			//SeleniumTestHelper.enterTextInTextBox(productClass, "");
			SeleniumTestHelper.enterTextInTextBox(productClass, Steps.ItemDataMap.get(i).get("ProductStatus"));
			}
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
		
		driver.findElement(By.xpath("//table[@id='inputInboundForm:whItems']//tbody//child::tr[1]/td[4]")).click();
		System.out.println("Default warehouse unselected!");
		int Rowcount = driver.findElements(By.xpath("//table[@id='inputInboundForm:whItems']//tbody//child::tr")).size();  //2
		for(int i=1;i<=Rowcount;i++) {
			String warehouse = driver.findElement(By.xpath("//table[@id='inputInboundForm:whItems']//tbody//child::tr["+i+"]/td[2]")).getText();
			if(warehouse.contains("MEMPHIS")&& Steps.scenarioData.get("EDIFacility").equals("MEM1")) {
				driver.findElement(By.xpath("//table[@id='inputInboundForm:whItems']//tbody//child::tr["+i+"]/td[4]")).click();
				System.out.println("Selected Warehouse: "+warehouse);
			}
			else if(warehouse.contains("AMIAM")&& Steps.scenarioData.get("EDIFacility").equals("AMIAM")){
				driver.findElement(By.xpath("//table[@id='inputInboundForm:whItems']//tbody//child::tr["+i+"]/td[4]")).click();
				System.out.println("Selected Warehouse: "+warehouse);
			}
			else if(warehouse.contains("AALB3")&& Steps.scenarioData.get("EDIFacility").equals("AALB3")){
				driver.findElement(By.xpath("//table[@id='inputInboundForm:whItems']//tbody//child::tr["+i+"]/td[4]")).click();
				System.out.println("Selected Warehouse: "+warehouse);
			}
		}
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
