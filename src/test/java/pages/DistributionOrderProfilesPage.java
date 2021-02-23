package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.DateTime;
import globalFunc.Screenshots;
import utils.SeleniumTestHelper;

public class DistributionOrderProfilesPage {
	WebDriver driver;
	
	HomePage homepage2= new HomePage();

	public DistributionOrderProfilesPage(){
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ms_stimgdiv1")
	public WebElement profiletypeDD;

	@FindBy(xpath = "//*[@id='ms_popall1']")
	public WebElement value1;

	@FindBy(id = "ms_popok1")
	public WebElement profiletypeOKBtn;

	@FindBy(id = "dataForm:DOTemplateList_entityListView:DistributionOrderlist:DistributionOrderlistapply")
	public WebElement DOProfilesApplyBtn;

	@FindBy(id = "dataForm:DOTemplateList_entityListView:DistributionOrderlist:field80value1")
	public WebElement DOProfilesIDtextBox;
	
	@FindBy(id = "checkAll_c0_dataForm:DOTemplateList_entityListView:DOTemplateList_MainListTable")
	public WebElement multiLineprofilechkbx;

	@FindBy(id = "dataForm:DO_TemplateList_CreateOrder_button")
	public WebElement createDOBtn;

	@FindBy(id = "dataForm:DOCreateMain_InText_DistributionorderID")
	public WebElement doIDtxtBox;

	@FindBy(xpath = "//*[@id='DOCreateDOLines_lnk']")
	public WebElement DOlinesTab;

	@FindBy(xpath = "//*[@id='dataForm:D2']/thead/tr/td[1]/input")
	public WebElement itemLinesSelectallCheckBx;

	@FindBy(id = "dataForm:D88")
	public WebElement deleteButton;

	@FindBy(id = "dataForm:D87")
	public WebElement addButton;

	@FindBy(id = "dataForm:DOCreate_save_button")
	public WebElement saveBtn;

	public void createDistributionOrder() throws Exception {
		driver.switchTo().frame(0);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, profiletypeDD, 10);
		profiletypeDD.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, value1, 10);
		value1.click();
		profiletypeOKBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, DOProfilesIDtextBox, 10);
		DOProfilesIDtextBox.sendKeys("MultiLine");
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		DOProfilesApplyBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, multiLineprofilechkbx, 10);
		Screenshots.captureSnapshot(driver);
		multiLineprofilechkbx.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, createDOBtn, 10);
		createDOBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, doIDtxtBox, 20);
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Distribution Order creation started");
		String DONumber = DateTime.current_date_time();
		Items.setDONumber(DONumber);
		doIDtxtBox.sendKeys(DONumber);
		Screenshots.captureSnapshot(driver);
		System.out.println("DO Number: " + Items.getDONumber());
		SeleniumTestHelper.waitForElementToBeClickable(driver, DOlinesTab, 10);
		Screenshots.captureSnapshot(driver);
		DOlinesTab.click();
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeClickable(driver, itemLinesSelectallCheckBx, 10);
		itemLinesSelectallCheckBx.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, deleteButton, 10);
		Screenshots.captureSnapshot(driver);
		deleteButton.click();
		Thread.sleep(2000);
	//	Screenshots.captureSnapshot(driver);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, addButton, 10);
		for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
			addButton.click();
			Thread.sleep(2000);
			WebElement lineNo = driver.findElement(By.id("dataForm:D2:newRow_" + (i+1) + ":D8"));
			lineNo.sendKeys(String.valueOf(i + 1));
			Thread.sleep(1000);
			WebElement itemID = driver.findElement(By.id("dataForm:D2:newRow_" + (i+1) + ":D25"));
			itemID.sendKeys(Steps.ItemDataMap.get(i).get("Item"));
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			WebElement orderQty = driver.findElement(By.id("dataForm:D2:newRow_" + (i + 1) + ":D30"));
			orderQty.sendKeys(Steps.ItemDataMap.get(i).get("ShippedQty"));
			Thread.sleep(1000);
			Select uom = new Select(driver.findElement(By.id("dataForm:D2:newRow_" + (i + 1) + ":D32")));
			uom.selectByVisibleText(" "+Steps.ItemDataMap.get(i).get("UOM"));
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			Select freighClass = new Select(driver.findElement(By.id("dataForm:D2:newRow_" + (i + 1) + ":D70")));
			freighClass.selectByVisibleText(Steps.ItemDataMap.get(i).get("NMFCFreightClass"));
			Thread.sleep(1000);
			Select waveallocationtype = new Select(driver.findElement(By.id("dataForm:D2:newRow_" + (i + 1) + ":D117")));
			waveallocationtype.selectByVisibleText(Steps.ItemDataMap.get(i).get("WaveAllocationType"));
			Thread.sleep(1000);
			Select inventoryType = new Select(driver.findElement(By.id("dataForm:D2:newRow_" + (i + 1) + ":D127")));
			inventoryType.selectByVisibleText(Steps.ItemDataMap.get(i).get("InventoryType"));
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);

			Reporter.addStepLog("Line " + (i + 1) + " is created with Item: " + Steps.ItemDataMap.get(i).get("Item")
					+ " & with Qty: " + Steps.ItemDataMap.get(i).get("ShippedQty"));
			Steps.logger.info("Line " + (i + 1) + " is created with Item: " + Steps.ItemDataMap.get(i).get("Item")
					+ " & with Qty: " + Steps.ItemDataMap.get(i).get("ShippedQty"));
		}
		saveBtn.click();
		Thread.sleep(3000);
		Screenshots.captureSnapshot(driver);
		
		String doStatus= driver.findElement(By.xpath("//*[@id='dataForm:DODetailsMainHeader_Out_FulfillmentStatus']")).getText();
		SeleniumTestHelper.assertEquals(doStatus, "110 - Released");
		
		homepage2.user_closes_openedwindow("Distribution Order Profiles - Distr...");
	}

}
