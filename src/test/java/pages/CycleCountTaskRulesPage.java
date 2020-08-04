package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import entity.Items;
import utils.Driver;
import utils.SeleniumTestHelper;

public class CycleCountTaskRulesPage {
	WebDriver driver;
	public CycleCountTaskRulesPage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='CC By Item']/../..//input[@type='checkbox']")
	public static WebElement ruleBYitemChckBox;
	@FindBy(xpath = "//input[@id='checkAll_c3_dataForm:lview:dataTable']")
	public static WebElement ruleRESERVEchckBox;
	@FindBy(xpath = "//input[@class='btn' and @value='View']")
	public static WebElement viewBtn;
	@FindBy(xpath = "//input[@id='rmButton_1Run1_480000' and @type='button']")
	public  WebElement RunBtn;
	@FindBy(xpath = "//input[@id='dataForm:ruleSelDtlDataTable:0:ruleSelDtlRuleCmparValue']")
	public static WebElement RuleComparisonValeu;
	@FindBy(xpath = "//input[@class='btn' and @value='Save']")
	public static WebElement saveBtn;
	@FindBy(xpath = "//a[@id='backButton']/img[@id='backImage']")
	public static WebElement navBackBtn;
	
	
	@FindBy(xpath="//input[@type='checkbox' and @id='checkAll_c0_dataForm:lview:dataTable']")
	public WebElement taskCriteriaBox;
	
	@FindBy(xpath="//input[@type='button' and @id='rmButton_2View1_167270976']")
	public WebElement view;
	
	@FindBy(xpath="//input[@id='dataForm:ruleSelDtlDataTable:0:ruleSelDtlRuleCmparValue' and @type='text']")
	public WebElement comparisonValue;
	
	@FindBy(xpath="//img[@id='backImage']")
	public WebElement arrowSign;
	
	@FindBy(xpath="//input[@id='rmButton_1Save1_473000']")
	public WebElement save_Btn;
	
	@FindBy(xpath = "//span[text()='CC Active']/../..//input[@type='checkbox']")
	public static WebElement ruleBYActiveChckBox;
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:itemLookUpId']") public WebElement item_lookUp_InputBox;
	@FindBy(xpath="(//input[@value='Apply'])[2]") public WebElement Apply_btn;
	@FindBy(xpath="//table[@id='dataForm:listView:dataTable_body']//tr[1]/td[4]/span[1]") public WebElement first_CC_loation;
	@FindBy(xpath="//table[@id='dataForm:listView:dataTable_body']//tr[1]/td[5]/span[1]") public WebElement first_CC_status;
	

	public void create_Task_By_Item(WebDriver driver) throws InterruptedException {
		
		//driver.switchTo().frame(0);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ruleBYitemChckBox, 20);
		ruleBYitemChckBox.click();
		SeleniumTestHelper.assertTrue(ruleBYitemChckBox.isSelected());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RunBtn, 20);
		RunBtn.sendKeys(Keys.ENTER + "" + Keys.ENTER);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	public void modify_ByItem_rule(WebDriver driver, String itemName) throws InterruptedException {
		driver.switchTo().frame(0);
		ruleBYitemChckBox.click();
		viewBtn.click();
		RuleComparisonValeu.click();
		RuleComparisonValeu.clear();
		RuleComparisonValeu.sendKeys(itemName + Keys.ENTER);
		Thread.sleep(5000);
		saveBtn.click();
		Thread.sleep(3000);
		SeleniumTestHelper.assertTrue(RuleComparisonValeu.getAttribute("value").equalsIgnoreCase(itemName));
		navBackBtn.click();
		
		//driver.switchTo().defaultContent();

	}
	
	/*
	 * This method will modify "Reserve" task rule. Pass location as string that task needs to be created on (Exp: R-RR-00-000-A01)
	 */
	public void modify_RESERVE_rule(WebDriver driver, String location) {
		driver.switchTo().frame(0);
		ruleRESERVEchckBox.click();
		viewBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		RuleComparisonValeu.clear();
		RuleComparisonValeu.sendKeys(location + Keys.ENTER);
		SeleniumTestHelper.assertTrue(RuleComparisonValeu.isDisplayed());
		saveBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		navBackBtn.click();

	}
	
	
	public void create_Task_RESERVE_rule(WebDriver driver) {
		ruleRESERVEchckBox.click();
		SeleniumTestHelper.assertTrue(ruleRESERVEchckBox.isSelected());
		RunBtn.sendKeys(Keys.ENTER + "" + Keys.ENTER);
		//System.out.println(driver.switchTo().alert().getText());
		//SeleniumTestHelper.assertEquals(driver.switchTo().alert().getText(), "Request Submitted");
		
		driver.switchTo().alert().accept();
	
	}
	
	public void modifyCycleCount(String taskCriteria) throws InterruptedException {
		
		switch(taskCriteria){
		
		case "CC By Item":
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, ruleBYitemChckBox, 20);
			ruleBYitemChckBox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewBtn, 20);
			SeleniumTestHelper.assertTrue(viewBtn.isDisplayed());
			viewBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, RuleComparisonValeu, 20);
			RuleComparisonValeu.click();
			RuleComparisonValeu.clear();
			RuleComparisonValeu.sendKeys(Items.getItemName() + Keys.ENTER);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, saveBtn, 20);
			saveBtn.click();
			Thread.sleep(2000);
			SeleniumTestHelper.assertTrue(RuleComparisonValeu.getAttribute("value").equalsIgnoreCase(Items.getItemName()));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, navBackBtn, 20);
			navBackBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, ruleBYitemChckBox, 20);
			ruleBYitemChckBox.click();
			SeleniumTestHelper.assertTrue(ruleBYitemChckBox.isSelected());
		break;
		
		case "CC Active":
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, ruleBYActiveChckBox, 20);
			ruleBYActiveChckBox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewBtn, 20);
			SeleniumTestHelper.assertTrue(viewBtn.isDisplayed());
			viewBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, RuleComparisonValeu, 20);
			RuleComparisonValeu.click();
			RuleComparisonValeu.clear();
			RuleComparisonValeu.sendKeys(Items.getALocation_two() + Keys.ENTER);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, saveBtn, 20);
			saveBtn.click();
			Thread.sleep(2000);
			SeleniumTestHelper.assertTrue(RuleComparisonValeu.getAttribute("value").equalsIgnoreCase(Items.getALocation_two()));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, navBackBtn, 20);
			navBackBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, ruleBYActiveChckBox, 20);
			ruleBYActiveChckBox.click();
			SeleniumTestHelper.assertTrue(ruleBYActiveChckBox.isSelected());
		break;
		}
		
		
	}

	public void CycleCountUI(String status, int noOfItems) throws InterruptedException {
	
		for (int i = 0; i < noOfItems; i++) {
			String item = Items.getItemName();
			String Rloc = Items.getSuggestedRLOCWithItem(item);
			System.out.println("item.." + item + "Rlocation.." + Rloc);
		

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, item_lookUp_InputBox, 5);
		item_lookUp_InputBox.clear();
		item_lookUp_InputBox.sendKeys(item);
		Apply_btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, first_CC_loation, 5);
		String expected_Location = Items.getSuggestedRLOCWithItem(item);
		String actual_Location = first_CC_loation.getText().replaceAll("-", "");
		SeleniumTestHelper.assertEquals(first_CC_status.getText(), status);
		}
	}

	public void modify_and_run_CC_Active_rule(String location_barcode) throws InterruptedException{
		driver.switchTo().frame(0);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ruleBYActiveChckBox, 20);
		ruleBYActiveChckBox.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewBtn, 20);
		SeleniumTestHelper.assertTrue(viewBtn.isDisplayed());
		viewBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RuleComparisonValeu, 20);
		RuleComparisonValeu.click();
		RuleComparisonValeu.clear();
		RuleComparisonValeu.sendKeys(location_barcode);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, saveBtn, 20);
		saveBtn.click();
		Thread.sleep(2000);
		SeleniumTestHelper.assertTrue(RuleComparisonValeu.getAttribute("value").equalsIgnoreCase(location_barcode));
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, navBackBtn, 20);
		navBackBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ruleBYActiveChckBox, 20);
		ruleBYActiveChckBox.click();
		SeleniumTestHelper.assertTrue(ruleBYActiveChckBox.isSelected());
		RunBtn.sendKeys(Keys.ENTER + "" + Keys.ENTER);
		
		driver.switchTo().alert().accept();
		
		
	}
}
