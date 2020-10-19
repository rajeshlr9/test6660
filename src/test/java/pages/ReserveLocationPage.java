package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import utils.Driver;
import utils.SeleniumTestHelper;

public class ReserveLocationPage {
	WebDriver driver;
	public String reserveLocationqty="";
	public String reserveLocationqtyafterupdate="";
	public ReserveLocationPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//input[contains(@id,'locationLookUpId')]")
	public WebElement resvlocnInputBox;

	@FindBy(xpath = "//input[@id='dataForm:listView:filterId:filterIdapply']")
	public WebElement ApplyBtn;
	
	@FindBy(xpath = "//input[contains(@name,'checkAll_c0_dataForm:listView:dataTable')]")
    public WebElement checkBox;
	
	@FindBy(xpath="//input[@value='View']")
	public WebElement ViewButton;
	
	@FindBy(xpath="//select[@id='dataForm:b17']")
	public WebElement putawayLockDropdown;
	
	@FindBy(xpath="//select[@id='dataForm:primaryList']")
	public WebElement putawayZoneDropdown;
	
	@FindBy(xpath="//input[@value='Save']") 
	public WebElement saveBtn;
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:field20value1']") 
	public WebElement locationBarcodetxtBox;
	
	@FindBy(xpath="//input[@id='filterId_fltrExpCol']") 
	public WebElement expandBtn;
	
	@FindBy(xpath = "//img[@id='backImage']")
	public WebElement backbtn;
	
	@FindBy(xpath="//input[@id='checkAll_c0_dataForm:listView:dataTable']") 
	public WebElement firstRsrvLoc;
	
	@FindBy(xpath="//input[@id='rmButton_2LPNs1_8342']") 
	public WebElement LPNsBtn;
	
	@FindBy(xpath="//input[@id='dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:field10value1']") 
	public WebElement iLPntxtBoxResLoc;
	
	@FindBy(xpath="//input[@id='dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:LPNList_Inbound_filterId1apply']") 
	public WebElement iLPnResLocApplyBtn;
	
	@FindBy(xpath="//input[@id='rmButton_1View1_8341']") 
	public WebElement viewBtn;
	
	@FindBy(xpath="//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_Link_NameText_param_out']") 
	public WebElement iLPNvalue;
	
	@FindBy(xpath="//span[@id='dataForm:b22']") 
	public WebElement currentQty;
	
	@FindBy(xpath="//select[@id='dataForm:b18']")
	public WebElement invLockField;
	
	@FindBy(xpath="//select[@id='dataForm:b18']/option[@selected]") 
	public WebElement invLockSelctd;
	
	@FindBy(xpath="//input[@id='dataForm:b356']") public WebElement maxWeight;
	@FindBy(xpath="//select[@id='dataForm:primaryList']") public WebElement putawayZoneDdl;
	
	
	public void unlockLocation(String locationToBeLocked) throws InterruptedException, IOException{
		
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, resvlocnInputBox, 50);
		resvlocnInputBox.clear();
		resvlocnInputBox.sendKeys(locationToBeLocked);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ApplyBtn, 50);
		SeleniumTestHelper.assertTrue(resvlocnInputBox.isDisplayed());
		ApplyBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 50);
		checkBox.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ViewButton, 50);
		ViewButton.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, putawayLockDropdown, 50);
		SeleniumTestHelper.assertTrue(putawayLockDropdown.isDisplayed());
		Select select = new Select(putawayLockDropdown);
		putawayLockDropdown.click();
		WebElement noneOption = driver.findElement(By.xpath("(//select[@id='dataForm:b17']/..//following-sibling::option)[1]"));
		noneOption.click();
		System.out.println("First Selected option: "+select.getFirstSelectedOption().getText());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, saveBtn, 50);
		SeleniumTestHelper.assertEquals(saveBtn.isDisplayed(), true);
		saveBtn.click();
	}

	@FindBy(xpath="//input[@id='dataForm:listView:filterId:locationLookUpId']") public WebElement displayLocBox;
	@FindBy(xpath="//span[.='Dedicated Item']") WebElement dedicatedItemColumn;
	
	public void select_random_empty_Rlocation(String location_initial) {
driver.switchTo().frame(0);
		
		String emptyLocation = null;
		List<WebElement> emptyLocationsList = null;
		displayLocBox.sendKeys(location_initial + "*");
		ApplyBtn.click();
		dedicatedItemColumn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dedicatedItemColumn.click();		
		emptyLocationsList = driver.findElements(By.xpath("//a[.='']/parent::td/preceding-sibling::td[3]/span[1]"));
		emptyLocation = emptyLocationsList.get(0).getText();
		List <WebElement> chkboxList = driver.findElements(By.xpath("//a[.='']/parent::td/preceding-sibling::td[4]/input[1]"));
		chkboxList.get(0).click();
		//chkBox.click();
		ViewButton.click();
		Select putawayzone = new Select(putawayZoneDropdown);
		putawayzone.selectByVisibleText("R01 - Pallet Reserve ptwy");
		saveBtn.click();		
 		
		Items.setRlocation_one(emptyLocation);
		System.out.println("Selected empty location: "+ emptyLocation);
		System.out.println("Set to Items location: " + Items.getRlocation_one());
		
	}
	
	public void getReservelocation() throws InterruptedException
	{
 		//String emptyLocation = null;
		displayLocBox.sendKeys("A-RK*");
 		ApplyBtn.click();
 		Thread.sleep(1000);
	}
	
	public void lockLocation(String locationToBeLocked, String lockCodeToBeSelected) throws InterruptedException, IOException{
 		SeleniumTestHelper.switchToInnerFrame(driver);
 		String Invselected = null;
 		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 30);
	    firstRsrvLoc.click();
	    SeleniumTestHelper.waitForElementToBeDisplayed(driver, ViewButton, 30);
	    ViewButton.click();
 		
 		//Inventory Lock
 		SeleniumTestHelper.waitForElementToBeDisplayed(driver, invLockField, 50);
 		invLockField.click();
 		SeleniumTestHelper.selectFromDropDown(invLockField, lockCodeToBeSelected,"visibletext");
 		Select select = new Select(invLockField);
 		System.out.println("First Selected option: "+select.getFirstSelectedOption().getText());
 		SeleniumTestHelper.waitForElementToBeDisplayed(driver, saveBtn, 50);
 		SeleniumTestHelper.assertEquals(saveBtn.isDisplayed(), true);
 		saveBtn.click();
 		
 		//Verifying that lock is selected
 		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 30);
	    firstRsrvLoc.click();
	    SeleniumTestHelper.waitForElementToBeDisplayed(driver, ViewButton, 30);
	    ViewButton.click();
 		
 		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(invLockSelctd));
 		Invselected=invLockSelctd.getText();
 		SeleniumTestHelper.assertEquals(Invselected, lockCodeToBeSelected);
 		SeleniumTestHelper.waitForElementToBeDisplayed(driver, backbtn, 30);
// 		backBtn.click();
 		System.out.println("lockCodeToBeSelected is"+lockCodeToBeSelected);
 		System.out.println("Invselected is"+Invselected);
 		
 		// Change lock code back to None
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, invLockField, 50);
		SeleniumTestHelper.selectFromDropDown(invLockField, "-1", "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, saveBtn, 50);
		saveBtn.click();
	}
	
	public void fetchQty(String zone) throws InterruptedException {
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
		expandBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationBarcodetxtBox, 20);
		locationBarcodetxtBox.sendKeys(zone);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ApplyBtn, 20);
		ApplyBtn.click();
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 20);
		firstRsrvLoc.click();
		viewBtn.click();
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, currentQty, 20);
		reserveLocationqty= currentQty.getText();
		Steps.logger.info("Current reserve Location qty:"+reserveLocationqty);
		Reporter.addStepLog("Current reserve Location qty:"+reserveLocationqty);
		Thread.sleep(2000);
		}

	public void validateQty(String inspectionZone) throws InterruptedException {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
		expandBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationBarcodetxtBox, 20);
		locationBarcodetxtBox.sendKeys(inspectionZone);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ApplyBtn, 20);
		ApplyBtn.click();
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 20);
		firstRsrvLoc.click();
		viewBtn.click();
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, currentQty, 20);
		reserveLocationqtyafterupdate= currentQty.getText();
		int iLPNsize=	RFMenuPage.iLPNz.size();
		String newqty= String.valueOf(Integer.parseInt(reserveLocationqty)+iLPNsize);
		SeleniumTestHelper.assertEquals(reserveLocationqtyafterupdate, newqty);
		Steps.logger.info("Current reserve Location qty after update:"+reserveLocationqtyafterupdate);
		Reporter.addStepLog("Current reserve Location qty after update:"+reserveLocationqtyafterupdate);
		Thread.sleep(2000);		
	}

	public void validateiLPNinReserveLoc(String inspectionZone) throws InterruptedException {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
		expandBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationBarcodetxtBox, 20);
		locationBarcodetxtBox.sendKeys(inspectionZone);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ApplyBtn, 20);
		ApplyBtn.click();
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 20);
		firstRsrvLoc.click();
		LPNsBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPntxtBoxResLoc, 20);
		for (int j = 0; j < RFMenuPage.iLPNz.size(); j++) {
		iLPntxtBoxResLoc.sendKeys(RFMenuPage.iLPNz.get(j));
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPnResLocApplyBtn, 20);
		iLPnResLocApplyBtn.click();
		Thread.sleep(5000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNvalue, 20);
		String iLPN=iLPNvalue.getText();
		System.out.println("iLPN:"+iLPN);
		
		SeleniumTestHelper.assertEquals(iLPN, RFMenuPage.iLPNz.get(j));
		Steps.logger.info("iLPN:"+iLPN+" is present in inspection zone");
		Reporter.addStepLog("iLPN:"+iLPN+" is present in inspection zone");
		}
	}
	
	
}
