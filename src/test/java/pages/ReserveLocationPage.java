package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.Screenshots;
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
	
	@FindBy(xpath = "//input[contains(@id,'itemLookUpId')]")
	public WebElement itemInputBox;

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
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:field5value1']") 
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
	
	@FindBy(xpath="//input[@id='dataForm:b10']") 
	public WebElement LocBarcode;
		
	@FindBy(xpath="//*[@id='dataForm:listView:filterId:itemLookUpId']") 
	public WebElement filterId;
	
	@FindBy(xpath="//*[@id='dataForm:listView:filterId:filterIdapply']") 
	public WebElement filterIdapply;
	
	@FindBy(id="checkAll_c0_dataForm:listView:dataTable") 
	public WebElement firstLocation;
	
	@FindBy(xpath="//span[@id='dataForm:listView:dataTable:0:custId5']") 
	public WebElement firstLocinTable;
	
	@FindBy(xpath="//*[@id='rmButton_1View1_8341']") 
	public WebElement viewBtn1;
	
		
	HomePage homePage = new HomePage();
	
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
	
	public String getReservelocation(String loc) throws Exception
	{
		String locBarCode= "";
 		//String emptyLocation = null;
		try {
		homePage.MenuItems_Configuration_Selection("Reserve Locations");	
		Thread.sleep(5000);
		//SeleniumTestHelper.switchToInnerFrame(driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		displayLocBox.sendKeys(loc);
		  Thread.sleep(1000);
 		ApplyBtn.click();
 		Thread.sleep(1000);
 		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 30);
	    firstRsrvLoc.click();
	    Thread.sleep(1000);
	    SeleniumTestHelper.waitForElementToBeDisplayed(driver, ViewButton, 30);
	    ViewButton.click();
	    Thread.sleep(1000);
	    SeleniumTestHelper.waitForElementToBeDisplayed(driver, LocBarcode, 30);
	    locBarCode = LocBarcode.getAttribute("value");
	    Thread.sleep(1000);
	   
	    
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage.userClosesOpenedwindow("Reserve Locations - Reserve Location");
		Thread.sleep(3000);
		return locBarCode;
		    
	}
	
	public String getReservelocationByitem(String item) throws Exception
	{
		String locBarCode= "";
 		//String emptyLocation = null;
		try {
		homePage.MenuItems_Configuration_Selection("Reserve Locations");	
		Thread.sleep(5000);
		//SeleniumTestHelper.switchToInnerFrame(driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
        SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
        expandBtn.click();
        Thread.sleep(5000);
        filterId.sendKeys(item);
        Thread.sleep(2000);
        filterIdapply.click();
        Thread.sleep(3000);
        firstLocation.click();
        Thread.sleep(2000);
        viewBtn1.click();
        Thread.sleep(2000);
        locBarCode= LocBarcode.getAttribute("value");
        System.out.println("Location barcode is: " +locBarCode);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	homePage.userClosesOpenedwindow("Reserve Locations - Reserve Location");
	Thread.sleep(3000);
	return locBarCode;

	}
	
	public List<String> getReservelocationandCodeByitem(String item) throws Exception
	{
		List<String>LocValues = new ArrayList<String>();
		//String locBarCode= "";
 		//String emptyLocation = null;
		try {
		homePage.MenuItems_Configuration_Selection("Reserve Locations");	
		Thread.sleep(5000);
		//SeleniumTestHelper.switchToInnerFrame(driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
        SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
        expandBtn.click();
        Thread.sleep(5000);
        filterId.sendKeys(item);
        Thread.sleep(2000);
        filterIdapply.click();
        Thread.sleep(3000);
        SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstLocinTable, 50);
        LocValues.add(firstLocinTable.getText());
        firstLocation.click();
        Thread.sleep(2000);
        viewBtn1.click();
        Thread.sleep(2000);
        LocValues.add(LocBarcode.getAttribute("value"));
        //System.out.println("Location barcode is: " +locBarCode);
       
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	homePage.userClosesOpenedwindow("Reserve Locations - Reserve Location");
	Thread.sleep(3000);
	 return LocValues;

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
	
	public void fetchQty(String zone) throws Exception {
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
		expandBtn.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationBarcodetxtBox, 20);
		locationBarcodetxtBox.sendKeys(zone);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ApplyBtn, 20);
		Screenshots.captureSnapshot(driver);
		ApplyBtn.click();
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 20);
		firstRsrvLoc.click();
		Screenshots.captureSnapshot(driver);
		viewBtn.click();
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, currentQty, 20);
		Screenshots.captureSnapshot(driver);
		reserveLocationqty= currentQty.getText();
		Steps.logger.info("Current reserve Location qty:"+reserveLocationqty);
		Reporter.addStepLog("Current reserve Location qty:"+reserveLocationqty);
		Thread.sleep(2000);
		}

	
	
	public void validateQty(String inspectionZone) throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
		expandBtn.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationBarcodetxtBox, 20);
		locationBarcodetxtBox.sendKeys(inspectionZone);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ApplyBtn, 20);
		ApplyBtn.click();
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 20);
		firstRsrvLoc.click();
		Screenshots.captureSnapshot(driver);
		viewBtn.click();
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, currentQty, 20);
		Screenshots.captureSnapshot(driver);
		reserveLocationqtyafterupdate= currentQty.getText();
		//int iLPNsize=	RFMenuPage.iLPNz.size();
		int iLPNsize=	Items.getLpnsLength();
		System.out.println("iLPNsize: "+iLPNsize);
		String newqty= String.valueOf(Integer.parseInt(reserveLocationqty)+iLPNsize);
		System.out.println("newqty: "+newqty);
		SeleniumTestHelper.assertEquals(reserveLocationqtyafterupdate, newqty);
		/*
		 * if(reserveLocationqtyafterupdate.equals(newqty)) {
		 * Steps.logger.info("Current reserve Location qty after update:"
		 * +reserveLocationqtyafterupdate);
		 * Reporter.addStepLog("Current reserve Location qty after update:"
		 * +reserveLocationqtyafterupdate); }else { Steps.testRes = "Failed";
		 * Assert.assertTrue(false); }
		 */
		Thread.sleep(2000);		
	}

	public void validateiLPNinReserveLoc(String inspectionZone) throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
		expandBtn.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationBarcodetxtBox, 20);
		locationBarcodetxtBox.sendKeys(inspectionZone);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ApplyBtn, 20);
		ApplyBtn.click();
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 20);
		firstRsrvLoc.click();
		Screenshots.captureSnapshot(driver);
		LPNsBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPntxtBoxResLoc, 20);
		Screenshots.captureSnapshot(driver);
		//for (int j = 0; j < RFMenuPage.iLPNz.size(); j++) {
		for (int j = 0; j < Items.getLpnsLength(); j++) {
			iLPntxtBoxResLoc.clear();
		//iLPntxtBoxResLoc.sendKeys(RFMenuPage.iLPNz.get(j));
		iLPntxtBoxResLoc.sendKeys(Items.getLpns(j));
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPnResLocApplyBtn, 20);
		iLPnResLocApplyBtn.click();
		Thread.sleep(3000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNvalue, 20);
		String iLPN=iLPNvalue.getText();
		System.out.println("iLPN:"+iLPN);
		
		//SeleniumTestHelper.assertEquals(iLPN, RFMenuPage.iLPNz.get(j));
		SeleniumTestHelper.assertEquals(iLPN, Items.getLpns(j));
		/*
		 * if(iLPN.equals(RFMenuPage.iLPNz.get(j))) {
		 * Steps.logger.info("iLPN:"+iLPN+" is present in inspection zone");
		 * Reporter.addStepLog("iLPN:"+iLPN+" is present in inspection zone"); }else {
		 * Steps.testRes = "Failed"; Assert.assertTrue(false); }
		 */
		}
	}
	
	//search by location id and item id for only 1 ilpn and 1 item
	public void validateiLPNinReserveLoc() throws Exception {
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
		expandBtn.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationBarcodetxtBox, 20);
		locationBarcodetxtBox.sendKeys(Items.getupdtLoc());
		Screenshots.captureSnapshot(driver);
		//itemInputBox.sendKeys(Steps.ItemDataMap.get(0).get("Item"));
	//	Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ApplyBtn, 20);	
		ApplyBtn.click();
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		//validate if the putaway zone conatins FL1,FL2 or FL3
		String getPutawayZone = driver.findElement(By.xpath("//span[@id='dataForm:listView:dataTable:0:custId16']")).getText();
		Reporter.addStepLog("Putaway zone in reserve location is: " + getPutawayZone);
		if(Steps.scenarioData.get("PutawayType").equals("Normal")) {
			if(getPutawayZone.startsWith("DST")||getPutawayZone.startsWith("P5A")||getPutawayZone.startsWith("PL3")||getPutawayZone.startsWith("FL2")) {
				Reporter.addStepLog("Putaway zone in reserve location is for Normal item");
				Assert.assertTrue(true, "putaway zone starts with "+getPutawayZone.subSequence(0, 2));
				
			}else {
				Steps.testRes = "Failed";
				Reporter.addStepLog("Putaway zone in reserve location is for Normal item in not "+getPutawayZone);
				Assert.assertTrue(false, "Invalid Putaway zone");
			}
		}else if(Steps.scenarioData.get("PutawayType").equals("Heavy")) {
			if(getPutawayZone.startsWith("FL1")) {
				Reporter.addStepLog("Putaway zone in reserve location is for Heavy item");
				Assert.assertTrue(true, "putaway zone starts with "+getPutawayZone.subSequence(0, 2));
			}else {
				Steps.testRes = "Failed";
				Reporter.addStepLog("Putaway zone in reserve location is for Heavy item in not "+getPutawayZone);
				Assert.assertTrue(false, "Invalid Putaway zone");
			}
		}else if(Steps.scenarioData.get("PutawayType").equals("Oversized")) {
			if(getPutawayZone.startsWith("FL2")) {
				Reporter.addStepLog("Putaway zone in reserve location is for Oversized item");
				Assert.assertTrue(true, "putaway zone starts with "+getPutawayZone.subSequence(0, 2));
			}else {
				Steps.testRes = "Failed";
				Reporter.addStepLog("Putaway zone in reserve location is for Oversized item in not "+getPutawayZone);
				Assert.assertTrue(false, "Invalid Putaway zone");
			}
		}
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 20);
		firstRsrvLoc.click();
		Screenshots.captureSnapshot(driver);
		LPNsBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPntxtBoxResLoc, 20);
		Screenshots.captureSnapshot(driver);
		Thread.sleep(2000);
		//iLPntxtBoxResLoc.sendKeys(RFMenuPage.iLPNz.get(0));
		iLPntxtBoxResLoc.sendKeys(Items.getLpns(0));
		Thread.sleep(10000);
		iLPnResLocApplyBtn.click();
		Thread.sleep(3000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNvalue, 20);
		//String iLPNqty =driver.findElement(By.xpath("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:CTO_LPNListTPM_LPN_Qty_param_out2']")).getText();
		//System.out.println("iLPNqty:"+iLPNqty.substring(0, 3).trim());
		//System.out.println("RecQty:"+String.valueOf(Steps.ItemDataMap.get(0).get("RecQty")));
	//	SeleniumTestHelper.assertEquals(Integer.parseInt(iLPNqty.substring(0, 3).trim()), Integer.parseInt(Steps.ItemDataMap.get(0).get("RecQty")));
		
		/*
		 * if(iLPN.equals(RFMenuPage.iLPNz.get(j))) {
		 * Steps.logger.info("iLPN:"+iLPN+" is present in inspection zone");
		 * Reporter.addStepLog("iLPN:"+iLPN+" is present in inspection zone"); }else {
		 * Steps.testRes = "Failed"; Assert.assertTrue(false); }
		 */
		
	}
	
	public String getReservelocationByWorkGroup(String item) throws Exception
	{
		String locBarCode= "";
 		//String emptyLocation = null;
		try {
		homePage.MenuItems_Configuration_Selection("Reserve Locations");	
		Thread.sleep(5000);
		//SeleniumTestHelper.switchToInnerFrame(driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
        SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
        expandBtn.click();
        Thread.sleep(5000);
        Select selWorkGroupArea = new Select(driver.findElement(By.id("dataForm:listView:filterId:field160value1")));
        selWorkGroupArea.selectByVisibleText(item);
       // filterId.sendKeys(item);
        //Thread.sleep(2000);
        filterIdapply.click();
        
        Thread.sleep(3000);
        firstLocation.click();
        Thread.sleep(2000);
        viewBtn1.click();
        Thread.sleep(2000);
        locBarCode= LocBarcode.getAttribute("value");
        System.out.println("Location barcode is: " +locBarCode);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	homePage.userClosesOpenedwindow("Reserve Locations - Reserve Location");
	Thread.sleep(3000);
	return locBarCode;

	}
	
	public void validateiLPNinReserveLocForAPC() throws Exception {
		try {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
			expandBtn.click();
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationBarcodetxtBox, 20);
			locationBarcodetxtBox.sendKeys(Items.getupdtLoc());
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, ApplyBtn, 20);
			ApplyBtn.click();
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			String getPutawayZone = driver.findElement(By.xpath("//span[@id='dataForm:listView:dataTable:0:custId16']"))
					.getText();
			Reporter.addStepLog("Putaway zone in reserve location is: " + getPutawayZone);
			//String itemType = Steps.scenarioData.get("PutawayType");
			String volumeType = ItemsPage.getPutawayType().split(" ")[ItemsPage.getPutawayType().split(" ").length-2].trim();
			System.out.println("Putaway Zone :"+getPutawayZone);
			System.out.println("Volume Type :"+volumeType);
			System.out.println("Validate if putaway zone contains expected volume for item"+getPutawayZone.contains(volumeType));
			if (getPutawayZone.contains(volumeType)) {
				Reporter.addStepLog("Putaway zone in reserve location contains valid item code" + ItemsPage.getPutawayType().split("-")[0].subSequence(0, 2));
				Assert.assertTrue(getPutawayZone.contains(ItemsPage.getPutawayType().split("-")[0].subSequence(0, 2)), "putaway zone start with" + ItemsPage.getPutawayType().split("-")[0].subSequence(0, 1));
				
			} else {
				Steps.testRes = "Failed";
				Reporter.addStepLog("Putaway zone in reserve location does not contain expected volume");
				Assert.assertTrue(false, "Invalid Putaway zone");
			}

			Thread.sleep(2000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstRsrvLoc, 20);
			firstRsrvLoc.click();
			Screenshots.captureSnapshot(driver);
			LPNsBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPntxtBoxResLoc, 20);
			Screenshots.captureSnapshot(driver);
			Thread.sleep(2000);
			// iLPntxtBoxResLoc.sendKeys(RFMenuPage.iLPNz.get(0));
			iLPntxtBoxResLoc.sendKeys(Items.getLpns(0));
			Thread.sleep(10000);
			iLPnResLocApplyBtn.click();
			Thread.sleep(3000);
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNvalue, 20);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public String getReservelocationByPutawayZone(String itemId,String putawayCode) throws Exception
	{
		String locBarCode= "";
 		//String emptyLocation = null;
		try {
		homePage.MenuItems_Configuration_Selection("Reserve Locations");	
		Thread.sleep(5000);
		//SeleniumTestHelper.switchToInnerFrame(driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
        SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandBtn, 20);
        expandBtn.click();
        Thread.sleep(5000);
        
        filterId.sendKeys(itemId);
        Thread.sleep(2000);
        Select selPutawayZone = new Select(driver.findElement(By.id("dataForm:listView:filterId:field80value1")));
        
        List<WebElement> putawayZoneAllOptions = selPutawayZone.getOptions();
        for(WebElement putawayZoneOption:putawayZoneAllOptions) {
        	if(StringUtils.startsWith(putawayZoneOption.getText(), putawayCode)) {
        		putawayZoneOption.click();
        		Screenshots.captureSnapshot(driver);
				Steps.logger.info("Selected the putaway zone "+putawayZoneOption.getText()+ " successfully");
				System.out.println("Selected the putaway zone successfully");
        	}
        }
       // selPutawayZone.selectByVisibleText(putawayZone);
       // filterId.sendKeys(item);
        //Thread.sleep(2000);
        filterIdapply.click();
        
        Thread.sleep(3000);
        firstLocation.click();
        Thread.sleep(2000);
        viewBtn1.click();
        Thread.sleep(2000);
        locBarCode= LocBarcode.getAttribute("value");
        System.out.println("Location barcode is: " +locBarCode);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	homePage.userClosesOpenedwindow("Reserve Locations - Reserve Location");
	Thread.sleep(3000);
	return locBarCode;

	}


}
