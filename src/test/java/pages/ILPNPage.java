package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.Screenshots;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;

public class ILPNPage {
	WebDriver driver;

	public ILPNPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	HomePage homePage = new HomePage();

	@FindBy(xpath = "//img[@id='backImage']")
	public WebElement backBtn;

	@FindBy(xpath = "//span[text()='Quick filter']")
	public WebElement quickFilter;

	//@FindBy(xpath = "//span[text()='LPN:']/../..//input[@type='text']")
	
	@FindBy(xpath = "//input[@id='dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:field10value1']")
	public WebElement inputLPNSearchTextBox;
	
	@FindBy(xpath = "(//span[text()='LPN:']/ancestor::*[position()=11]//input[@value='Apply'])[1]")
	public WebElement applySearchBtn;

	@FindBy(xpath = "//input[@name='checkAll_c0_dataForm:LPNListInOutboundMain_lv:dataTable']")
	public WebElement searchedLPNChkbox;

	@FindBy(xpath = "//input[@id='checkAll_c0_dataForm:LPNListInOutboundMain_lv:dataTable']")
	public WebElement firstCheckBx;

	@FindBy(xpath = "//input[@id='LPNListInboundMain_commandbutton_CanceliLPN']")
	public WebElement cancelSelectedLPN;

	@FindBy(xpath = "//select[@id='dataForm:reasonCode']")
	public WebElement cancelReasonDrpDwn;

	@FindBy(xpath = "//input[@value='Confirm']")
	public WebElement confirmCancelBtn;
	
	@FindBy(xpath = "//input[@id='LPNListInboundMain_commandbutton_view']")
	public WebElement viewLPNBtn;
	
	@FindBy(xpath = "//a[text()='Header']")
	public WebElement headerLPNTab;
	
	@FindBy(xpath = "//span[@id='dataForm:ViewLPNInbound_Header_CurrentLocation_Text']")
	public WebElement headerCurrentLocationValue;
	
	@FindBy(xpath = "//span[@id='dataForm:LPNCommonHeader_LPNStatus_outputText']")
	public WebElement iLPNstatus;
	
	@FindBy(xpath = "//span[@id='dataForm:viewLPNPOLineItemsList:0:ViewPOLineItemList_LPN_qty_param_out']")
	public WebElement iLPNqty;
	
	@FindBy(xpath = "//input[@id='LPNListInboundMain_commandbutton_LockUnlockLPN']")
	public WebElement iLPNLockUnlockBtn1;
	
	@FindBy(id = "LPN_Locks_Tab_lnk")
	public WebElement LocksTab;
	
	@FindBy(id = "dataForm:lockTable:0:ViewLPNLocksList_LockCode_out")
	public WebElement LockCodeValue;
	
	@FindBy(id = "dataForm:lockTable_body")
	public List<WebElement> lockCodeTable;
	
	@FindBy(id = "backButton")
	public WebElement backButton;
	
	
	@FindBy(xpath = "//input[@id='LPNListInboundMain_CmdBtn_LockiLPN']")
	public WebElement iLPNLockUnlockBtn2;
	
	@FindBy(xpath = "//input[@id='rmButton_1Lock1_167270008']")
	public WebElement iLPNlockButton;
	
	@FindBy(xpath = "//input[@id='rmButton_1Unlock1_167270009']")
	public WebElement iLPNunlockButton;
	
	@FindBy(id= "dataForm:listView:dataTable:newRow_1:LockCodeSelect")
	public WebElement locksDropdown;
	
	@FindBy(xpath = "//input[@name='dataForm:listView:dataTable_checkAll']")
	public WebElement checkBox;
	
	@FindBy(xpath = "//input[@id='rmButton_1Save1_167270010']")
	public WebElement saveButton;
	
	
	@FindBy(xpath = "//input[@value='Lock']")
	public WebElement iLPNLockBtn;
	
	@FindBy(xpath = "//input[@value='Unlock']")
	public WebElement iLPNUnlockBtn;
	
	@FindBy(xpath = "//input[@value='Save']")
	public WebElement iLPNLockUnlockSaveBtn;
	
	@FindBy(xpath = "//select[contains(@id,'newRow_1:LockCodeSelect')]")
	public WebElement iLPNLockCodeFirstRowDrpDown;
	
	public String lockcode = "//select[@disabled='disabled']/option[@selected='selected' and text()='Lost In Warehouse']";	
	
	@FindBy(xpath = "//input[@value='Adjust']")
	public WebElement adjustBtn;
	
	@FindBy(xpath = "//input[@id='dataForm:NewQty']")
	public WebElement newQtyTxtBox;
	
	@FindBy(xpath = "//select[@id='dataForm:adjustReasonSelect']")
	public WebElement reasonCodeddnlist;
	
	@FindBy(xpath = "//input[@value='Save']")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//input[@value='Edit Header']")
	public WebElement editHeaderBtn;
	
	@FindBy(xpath = "//input[@id='dataForm:EditLPNHeaderInbound_LPNActualWeight_outputText']")
	public WebElement actualWeightTxtBx;
	
	@FindBy(xpath="//a[text()='Override']") 
	public WebElement overridePopUp;
	
	@FindBy(xpath = "//span[text()='Estimated volume:']/following::input[1]")
	public WebElement estimatedVolumeTxtBx;
	
	@FindBy(xpath = "//span[text()='LPN Quantity']")
	public WebElement ilpnQuantity;
	
	@FindBy(xpath = "//span[contains(@id,':0:CTO_LPNListTPM_LPN_Qty')]")
	public WebElement firstLPNQty;
	
	@FindBy(xpath = "//span[contains(@id,':1:CTO_LPNListTPM_LPN_Qty')]")
	public WebElement secondLPNQty;
	
	@FindBy(xpath = "//span[@id='dataForm:LPNCommonHeader_LPNFacilityStatus_outputText']")
	public WebElement LPNFacilityStatus;
	
	@FindBy(xpath = "//input[@id='LPNListInboundMain_commandbutton_SerialNumbers']")
	public WebElement serialNumbersBtn;
	
	@FindBy(xpath = "//a[text()='Details']")
	public WebElement detailsTab;
	
	@FindBy(xpath = "//span[@id='dataForm:srlNbr2']")
	public WebElement serialNumberText;
	
	static String serialNumber;
	
	

	public void searchLPNCancelItAndVerifyLPNFacilityStatus(int noOfItems, String status)
			throws Exception {
		homePage.MenuItems_Distribution_Selection("iLPNs");
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < noOfItems; i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, quickFilter, 50);
			Thread.sleep(2000);
			inputLPNSearchTextBox.clear();
			Thread.sleep(2000);
			inputLPNSearchTextBox.sendKeys(Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
			applySearchBtn.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, firstCheckBx, 60);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='" + Items.getItemILPN(Items.getItemsForReceivingASN(i))
					+ "']/../..//input[@type='checkbox']")).click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, cancelSelectedLPN, 60);

			try {
				cancelSelectedLPN.click();
			} catch (UnhandledAlertException unHandle) {
				Alert alert = driver.switchTo().alert();
				System.out.println("Alert appeared : " + alert.getText());
				alert.accept();
			}
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, cancelReasonDrpDwn, 50);
			SeleniumTestHelper.selectFromDropDown(cancelReasonDrpDwn, "SCN-Soft Cancel", "visibletext");
			SeleniumTestHelper.waitForElementToBeClickable(driver, confirmCancelBtn, 60);
			confirmCancelBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
			SeleniumTestHelper.waitForElementToBeClickable(driver, firstCheckBx, 60);
			String iLPN_Status = driver
					.findElement(By.xpath("//span[text()='" + Items.getItemILPN(Items.getItemsForReceivingASN(i))
							+ "']/following::span[contains(@id,'Outbound_lpnFacilityStatus')]"))
					.getText();
			SeleniumTestHelper.assertEquals(iLPN_Status, status);
			System.out.println("LPN Facility Status : " + status + " verified successfully");
		}
		homePage.userClosesOpenedwindow("iLPNs");
	}
	public void searchForTheILPNAndViewIt(String iLPN) throws Exception{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputLPNSearchTextBox, 50);
		inputLPNSearchTextBox.clear();
		inputLPNSearchTextBox.sendKeys(iLPN);
		Screenshots.captureSnapshot(driver);
		//Thread.sleep(3000);
		SeleniumTestHelper.WaitForPageLoad();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
		applySearchBtn.click();
		//Thread.sleep(3000);
		SeleniumTestHelper.WaitForPageLoad();
		SeleniumTestHelper.waitForElementToBeClickable(driver, firstCheckBx, 60);
		Screenshots.captureSnapshot(driver);
		driver.findElement(By.xpath("//span[text()='" + iLPN + "']/../..//input[@type='checkbox']")).click();
		//Thread.sleep(3000);
		SeleniumTestHelper.WaitForPageLoad();
        SeleniumTestHelper.waitForElementToBeClickable(driver, cancelSelectedLPN, 60);
        viewLPNBtn.click();
        //Thread.sleep(3000);
        SeleniumTestHelper.WaitForPageLoad();
        SeleniumTestHelper.waitForElementToBeClickable(driver, headerLPNTab, 120);
        Screenshots.captureSnapshot(driver);
	}
	
	public String getQuantityILPN(String ilpn) {
		
		String lPnpath = "//span[text()='<ILPNINPUT>']/../following-sibling::td//span[contains(@id,'LPN_Qty_param')]";
		String lPnxpath = lPnpath.replace("<ILPNINPUT>", ilpn);
		System.out.println(lPnxpath);
		return driver.findElement(By.xpath(lPnxpath)).getText();
	}
	
   public void verifyiLPNStatus(String status) throws Exception{
		
		SeleniumTestHelper.switchToInnerFrame(driver);
		//for (int i = 0; i < RFMenuPage.iLPNz.size(); i++) {
		for (int i = 0; i < Items.getLpnsLength(); i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputLPNSearchTextBox, 50);
			inputLPNSearchTextBox.clear();
			//inputLPNSearchTextBox.sendKeys(RFMenuPage.iLPNz.get(i));
			inputLPNSearchTextBox.sendKeys(Items.getLpns(i));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
			applySearchBtn.click();
			//String iLPN_Status=driver.findElement(By.xpath("//span[text()='"+RFMenuPage.iLPNz.get(i)+"']/following::span[contains(@id,'Outbound_lpnFacilityStatus')]")).getText();
			String iLPN_Status=driver.findElement(By.xpath("//span[text()='"+Items.getLpns(i)+"']/following::span[contains(@id,'Outbound_lpnFacilityStatus')]")).getText();
			SeleniumTestHelper.assertEquals(iLPN_Status, status);
			//Steps.logger.info("Status for iLPN "+RFMenuPage.iLPNz.get(i)+" is "+status);
			//Reporter.addStepLog("Status for iLPN "+RFMenuPage.iLPNz.get(i)+" is "+status);
			Steps.logger.info("Status for iLPN "+Items.getLpns(i)+" is "+status);
			Reporter.addStepLog("Status for iLPN "+Items.getLpns(i)+" is "+status);
		}
	}

   public void lockiLPN() throws Exception{
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, LocksTab, 50);
		LocksTab.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lockCodeTable.get(0), 50);
		Screenshots.captureSnapshot(driver);
		System.out.println(lockCodeTable.get(0).getText());
		if(lockCodeTable.get(0).getText().contains("No data found")) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNLockUnlockBtn2, 50);
			iLPNLockUnlockBtn2.click();
			//SeleniumTestHelper.waitForElementToBeDisplayed(driver, lockCodeTable.get(0), 50);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNlockButton, 50);
			Screenshots.captureSnapshot(driver);
			iLPNlockButton.click();
			String lockcode = String.valueOf(Steps.scenarioData.get("LockCode"));
			System.out.println(lockcode);
			Screenshots.captureSnapshot(driver);
			Select dropdown = new Select(locksDropdown);
			dropdown.selectByVisibleText(lockcode);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 50);
			checkBox.click();
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, saveButton, 50);
			saveButton.click();
			Steps.logger.info("Lock code applied successfully");
			Reporter.addStepLog("Lock code applied successfully");
			Screenshots.captureSnapshot(driver);
			homePage.userClosesOpenedwindow("iLPNs - Lock Unlock LPNs");
			
		}else {
			Steps.logger.info("Lock code already present");
			Reporter.addStepLog("Lock code already present");
			Steps.testRes="Failed";
			Assert.assertTrue(false);
		}
	}
   
   public void unlockiLPN() throws Exception{
		SeleniumTestHelper.switchToInnerFrame(driver);
		Steps.logger.info("Started removing lock code");
		Reporter.addStepLog("Started removing lock code");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, LocksTab, 50);
		LocksTab.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lockCodeTable.get(0), 50);
		Screenshots.captureSnapshot(driver);
		if(!(lockCodeTable.get(0).getText().contains("No data found"))) {
			iLPNLockUnlockBtn2.click();
			//SeleniumTestHelper.waitForElementToBeDisplayed(driver, lockCodeTable.get(0), 50);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 50);
			checkBox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNunlockButton, 50);
			Screenshots.captureSnapshot(driver);
			iLPNunlockButton.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, saveButton, 50);
			Screenshots.captureSnapshot(driver);
			saveButton.click();
			Steps.logger.info("Lock code removed successfully");
			Reporter.addStepLog("Lock code removed successfully");
			Screenshots.captureSnapshot(driver);
			homePage.userClosesOpenedwindow("iLPNs - Lock Unlock LPNs");
			
		}else {
			Steps.logger.info("iLPN doesnt have any lock");
			Reporter.addStepLog("iLPN doesnt have any lock");
			Steps.testRes="Failed";
			Assert.assertTrue(false);
		}
	}
   
   public void validateiLPNLockCode() throws Exception{
	   String ilpnLockCode = "";
		String lpn = null;
		int i, j;
		String lockcodes = String.valueOf(Steps.scenarioData.get("LockCode"));
		System.out.println(String.valueOf(Steps.scenarioData.get("LockCode")));
		String[] lockCode = null;
		if (lockcodes.contains(",")) {
			lockCode = lockcodes.split(",");
		} else {
			lockCode = new String[] { lockcodes };
		}
		//Thread.sleep(2000);
		SeleniumTestHelper.WaitForPageLoad();
		homePage.MenuItems_Distribution_Selection("iLPNs");
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Open iLPN screen");
		SeleniumTestHelper.switchToInnerFrame(driver);
		//for (i = 0, j = 0; i < RFMenuPage.iLPNz.size(); i++) {
		for (i = 0, j = 0; i < Items.getLpnsLength(); i++) {
			//lpn = RFMenuPage.iLPNz.get(i);
			lpn = Items.getLpns(i);
			searchForTheILPNAndViewIt(lpn);
			System.out.println("lpn "+lpn);
			SeleniumTestHelper.waitForElementToBeClickable(driver, LocksTab, 50);
			LocksTab.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, lockCodeTable.get(0), 50);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Actual lock code: " + lockCodeTable.get(0).getText());
			Reporter.addStepLog("Actual lock code: " + lockCodeTable.get(0).getText());
			Steps.logger.info("Expected lock code: " + lockCode[i]);
			Reporter.addStepLog("Expected lock code: " + lockCode[i]);
			
			  if (lockCodeTable.get(0).getText().contains(lockCode[i])) { 
				  Steps.logger.info("Actual lock code matches the expected lock code");
				Reporter.addStepLog("Lock code is successfully verified");
				  } else {
			  ilpnLockCode += lpn; 
			  Steps.testRes="Failed";
			  Assert.assertTrue(false, "iLPN Lock code that are not same " + ilpnLockCode);
			  }
			 
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, backButton, 20);
			backButton.click();
			//Thread.sleep(3000);
			SeleniumTestHelper.WaitForPageLoad();
		}
		/*
		 * if (i == j) {
		 * Steps.logger.info("Actual lock code matches the expected lock code");
		 * Reporter.addStepLog("Lock code is successfully verified"); } else {
		 * Steps.testRes="Failed"; Assert.assertTrue(false,
		 * "iLPN Lock code that are not same " + ilpnLockCode); }
		 */
		homePage.userClosesOpenedwindow("iLPNs");
   }
   
   public void verifyLockCodeStatus(String lockcodetext) throws Exception{
		
		SeleniumTestHelper.switchToInnerFrame(driver);
		WebElement lockcode = driver.findElement(By.xpath("//select[@disabled='disabled']/option[@selected='selected' and text()='"+lockcodetext+"']"));
		SeleniumTestHelper.assertEquals(lockcode.getText(), lockcodetext);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 50);
		backBtn.click();
	}

   public void adjustiLPNQuantity(String adjust, int noOfItem) throws Exception{
	   
	   SeleniumTestHelper.switchToInnerFrame(driver);
	   for (int i = 0; i < noOfItem; i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputLPNSearchTextBox, 50);
			inputLPNSearchTextBox.clear();
			inputLPNSearchTextBox.sendKeys(Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
			applySearchBtn.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, firstCheckBx, 60);
			firstCheckBx.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, adjustBtn, 60);
			adjustBtn.click();
			Thread.sleep(2000);
			int noOfClick = 5;
			Actions act = new Actions(driver);
			for (int j = 0; j < noOfClick; j++) {
				act.sendKeys(Keys.ARROW_DOWN);
			}
			String oldQty = newQtyTxtBox.getAttribute("value").replaceAll(",","");
			Items.setOldQty(oldQty);
			int oldQtytonum = Integer.parseInt(oldQty);
			SeleniumTestHelper.assertTrue(newQtyTxtBox.isDisplayed());
			Thread.sleep(2000);
			newQtyTxtBox.clear();
			if(adjust.equals("decreases")){
				newQtyTxtBox.sendKeys(String.valueOf(oldQtytonum - 1));
			}else if(adjust.equals("increases")){
				newQtyTxtBox.sendKeys(String.valueOf(oldQtytonum + 1));
				}
			SeleniumTestHelper.waitForElementToBeDisplayed(driver,reasonCodeddnlist, 50);
			SeleniumTestHelper.selectFromDropDown(reasonCodeddnlist,"CC-Cycle Count-Physical Count Difference","visibletext");
			SeleniumTestHelper.assertTrue(saveBtn.isDisplayed());
			Thread.sleep(2000);
			saveBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver,backBtn, 50);
			backBtn.click();
			Thread.sleep(2000);
			WebElement newQty = driver.findElement(By.xpath("//span[contains(@id,'LPN_Qty_param_out2')]"));
			String[] newQtyStr = newQty.getText().split(" ");
			if(adjust.equals("decreases")){
				SeleniumTestHelper.assertEquals(newQtyStr[0], String.valueOf(oldQtytonum - 1));
			}else if(adjust.equals("increases")){
				SeleniumTestHelper.assertEquals(newQtyStr[0], String.valueOf(oldQtytonum + 1));
				}
			
		}
	}
   
   public void get_iLPN_status(String iLPN, String status){
	   SeleniumTestHelper.switchToInnerFrame(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputLPNSearchTextBox, 50);
			inputLPNSearchTextBox.clear();
			inputLPNSearchTextBox.sendKeys(iLPN);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
			applySearchBtn.click();
			String iLPN_Status=driver.findElement(By.xpath("//span[text()='"+iLPN+"']/following::span[contains(@id,'Outbound_lpnFacilityStatus')]")).getText();
			SeleniumTestHelper.assertEquals(iLPN_Status, status);
   }
   
   public void validateiLPNStatusAndQty() throws Exception{
	   
	   SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNstatus, 10);
	   SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNqty, 10);
	   if(iLPNstatus.getText().contains("Consumed") && iLPNqty.getText().contains("0")) {
		   Steps.logger.info("iLPN status is:"+iLPNstatus.getText().trim()+" & iLPN qty is:"+iLPNqty.getText());
		   Reporter.addStepLog("iLPN status is:"+iLPNstatus.getText().trim()+" & iLPN qty is:"+iLPNqty.getText());
	   }else {
		   Steps.testRes = "Failed";
		   SeleniumTestHelper.assertEquals(iLPNstatus.getText(), "Consumed");
		   SeleniumTestHelper.assertEquals(iLPNqty.getText(), "0");
	   }
	   homePage.userClosesOpenedwindow("iLPNs - iLPN Details");
   }
   
   public void verify_iLPN_lockCode(String iLPN, String lockCode){
	   driver.switchTo().frame(0);
	   inputLPNSearchTextBox.clear();
	   inputLPNSearchTextBox.sendKeys(Items.getiLpn());
	   SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 20);
	   applySearchBtn.click();
	   firstCheckBx.click();
		if (SeleniumTestHelper.isElementDisplayed(iLPNLockUnlockBtn1)) {
			iLPNLockUnlockBtn1.click();
		} else {
			iLPNLockUnlockBtn2.click();
		}
	   
		WebElement lockcode = driver.findElement(By.xpath("//select[@disabled='disabled']/option[@selected='selected' and text()='"+lockCode+"']"));
		SeleniumTestHelper.assertEquals(lockcode.getText(), lockCode);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 50);
		backBtn.click();
		driver.switchTo().defaultContent();
		
   }
   
   //Ashish
   public void verifyTheiLPNStatus(String status,int noOfItems) throws Exception{
		
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < noOfItems; i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputLPNSearchTextBox, 50);
			inputLPNSearchTextBox.clear();
			//lpnTxt.sendKeys(Items.getiLpn());
			inputLPNSearchTextBox.sendKeys(Items.getiLpn());
			//inputLPNSearchTextBox.sendKeys(Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
			applySearchBtn.click();
			String iLPN_Status=driver.findElement(By.xpath("//span[text()='"+Items.getiLpn()+"']/following::span[contains(@id,'Outbound_lpnFacilityStatus')]")).getText();
			//String iLPN_Status=driver.findElement(By.xpath("//span[text()='"+Items.getItemILPN(Items.getItemsForReceivingASN(i))+"']/following::span[contains(@id,'Outbound_lpnFacilityStatus')]")).getText();
			SeleniumTestHelper.assertEquals(iLPN_Status, status);
		}
	}
   
public void adjustiLPNQuantityWith(String adjust, int noOfItem) throws Exception{
	   
	   SeleniumTestHelper.switchToInnerFrame(driver);
	   for (int i = 0; i < noOfItem; i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputLPNSearchTextBox, 50);
			inputLPNSearchTextBox.clear();
			
			
			inputLPNSearchTextBox.sendKeys(Items.getiLpn());
			//inputLPNSearchTextBox.sendKeys(Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
			applySearchBtn.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, firstCheckBx, 60);
			firstCheckBx.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, adjustBtn, 60);
			adjustBtn.click();
			Thread.sleep(2000);
			int noOfClick = 5;
			Actions act = new Actions(driver);
			for (int j = 0; j < noOfClick; j++) {
				act.sendKeys(Keys.ARROW_DOWN);
			}
			String oldQty = newQtyTxtBox.getAttribute("value").replaceAll(",","");
			Items.setOldQty(oldQty);
			int oldQtytonum = Integer.parseInt(oldQty);
			SeleniumTestHelper.assertTrue(newQtyTxtBox.isDisplayed());
			Thread.sleep(2000);
			newQtyTxtBox.clear();
			if(adjust.equals("decreases")){
				newQtyTxtBox.sendKeys(String.valueOf(oldQtytonum - 1));
			}else if(adjust.equals("increases")){
				newQtyTxtBox.sendKeys(String.valueOf(oldQtytonum + 1));
				}
			SeleniumTestHelper.waitForElementToBeDisplayed(driver,reasonCodeddnlist, 50);
			SeleniumTestHelper.selectFromDropDown(reasonCodeddnlist,"CC-Cycle Count-Physical Count Difference","visibletext");
			SeleniumTestHelper.assertTrue(saveBtn.isDisplayed());
			Thread.sleep(2000);
			saveBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver,backBtn, 50);
			backBtn.click();
			Thread.sleep(2000);
			WebElement newQty = driver.findElement(By.xpath("//span[contains(@id,'LPN_Qty_param_out2')]"));
			String[] newQtyStr = newQty.getText().split(" ");
			if(adjust.equals("decreases")){
				SeleniumTestHelper.assertEquals(newQtyStr[0], String.valueOf(oldQtytonum - 1));
			}else if(adjust.equals("increases")){
				SeleniumTestHelper.assertEquals(newQtyStr[0], String.valueOf(oldQtytonum + 1));
				}
			
		}
	}
   
	public void validateILPN() throws Exception {
 		
		homePage.MenuItems_Distribution_Selection("iLPNs");
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputLPNSearchTextBox, 50);
			inputLPNSearchTextBox.clear();
			inputLPNSearchTextBox.sendKeys(Items.getiLpn()+","+Items.getLPNID());
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
			applySearchBtn.click();
			Thread.sleep(2000);
			if(firstLPNQty.getText().contains("0") && secondLPNQty.getText().contains(Items.getItemQTY())){
				SeleniumTestHelper.assertTrue(true);
			}
			
			homePage.userClosesOpenedwindow("iLPNs");
	}
	public void validateiLPNModification(String opeartion) throws Exception {

		homePage.MenuItems_Distribution_Selection("iLPNs");
		Steps.logger.info("Open iLPN screen");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		//for (int i = 0; i < RFMenuPage.iLPNz.size(); i++) {
		for (int i = 0; i < Items.getLpnsLength(); i++) {			
			//searchForTheILPNAndViewIt(RFMenuPage.iLPNz.get(i));
			searchForTheILPNAndViewIt(Items.getLpns(i));
		
			switch (opeartion) {
			case "Increase Qty":
				WebElement qty1= driver.findElement(By.xpath("//*[@id=\"dataForm:viewLPNPOLineItemsList_body\"]/tbody/tr[1]/td[7]"));
				String a=qty1.getText();
				String arrQty1[]= a.split(" ");
				if(arrQty1[0].equals(Steps.ItemDataMap.get(i).get("ChangeQty"))) {
					Steps.logger.info("Expected iLPN Quantity is:" + Steps.ItemDataMap.get(i).get("ChangeQty")+" & Actual is: "+arrQty1[0]);
					Reporter.addStepLog("Expected iLPN Quantity is:" + Steps.ItemDataMap.get(i).get("ChangeQty")+" & Actual is:"+arrQty1[0]);
				}
				else {
					Steps.testRes="Failed";
					Reporter.addStepLog("Expected iLPN Quantity is:" + Steps.ItemDataMap.get(i).get("ChangeQty")+" & Actual is:"+arrQty1[0]);
					SeleniumTestHelper.assertTrue(false, "Quantity did not increased");
				}
				break;
			case"Decrease Qty":
				WebElement qty2= driver.findElement(By.xpath("//*[@id=\"dataForm:viewLPNPOLineItemsList_body\"]/tbody/tr[1]/td[7]"));
				String b=qty2.getText();
				String arrQty2[]= b.split(" ");
				if(arrQty2[0].equals(Steps.ItemDataMap.get(i).get("ChangeQty"))) {
					Steps.logger.info("Expected iLPN Quantity is:" + Steps.ItemDataMap.get(i).get("ChangeQty")+" & Actual is: "+arrQty2[0]);
					Reporter.addStepLog("Expected iLPN Quantity is:" + Steps.ItemDataMap.get(i).get("ChangeQty")+" & Actual is:"+arrQty2[0]);
				}
				else {
					Steps.testRes="Failed";
					Reporter.addStepLog("Expected iLPN Quantity is:" + Steps.ItemDataMap.get(i).get("ChangeQty")+" & Actual is:"+arrQty2[0]);
					SeleniumTestHelper.assertTrue(false, "Quantity did not decreased");
				}
				break;
			case "Delete Line":
				WebElement status= driver.findElement(By.xpath("//*[@id=\"dataForm:LPNCommonHeader_PanelGrid1_Panel1\"]/tbody/tr[1]/td[8]"));
				WebElement qty= driver.findElement(By.xpath("//*[@id=\"dataForm:viewLPNPOLineItemsList_body\"]/tbody/tr[1]/td[7]"));
				
				if(status.getText().contains("Canceled")&& qty.getText().contains("0")) {
					Steps.logger.info("iLPN line is deleted");
					Reporter.addStepLog("iLPN line is deleted");
				}else {
					Steps.testRes="Failed";
					Reporter.addStepLog("Actual status & Quantity-"+ status.getText()+" , "+ qty.getText() );
					Reporter.addStepLog("Expected status & Quantity- Canceled , 0" );
					SeleniumTestHelper.assertTrue(false, "iLPN line is not deleted");
				}
				break;
				default:
					System.out.println("Invalid operation");
			}
		}
		homePage.userClosesOpenedwindow("iLPNs - iLPN Details");
	}
	
	public void validateiLPNStatusAndQty_trans(String arg1) throws Exception{
		   
		   SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNstatus, 10);
		   SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNqty, 10);
		   if(LPNFacilityStatus.getText().contains(arg1) ) {
			   Steps.logger.info("iLPN status is:"+LPNFacilityStatus.getText().trim()+" & iLPN qty is:"+iLPNqty.getText());
			   Reporter.addStepLog("iLPN status is:"+LPNFacilityStatus.getText().trim()+" & iLPN qty is:"+iLPNqty.getText());
		   }else {
			   Steps.testRes = "Failed";
			   SeleniumTestHelper.assertEquals(LPNFacilityStatus.getText(), arg1);
		   }
		   homePage.userClosesOpenedwindow("iLPNs - iLPN Details");
	   }
	
		public String searchForTheILPNAndFetchSerialNumber(String iLPN) throws Exception {
							
				//homePage.MenuItems_Configuration_Selection("iLPNs");
				homePage.MenuItems_Distribution_Selection("iLPNs");
				//Thread.sleep(5000);
				//SeleniumTestHelper.switchToInnerFrame(driver);
				driver.switchTo().defaultContent();
				driver.switchTo().frame(1);
				
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputLPNSearchTextBox, 50);
				//driver.findElement(By.xpath("//input[@id='dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:field10value1']")).clear();
				inputLPNSearchTextBox.clear();
				inputLPNSearchTextBox.sendKeys(iLPN);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
				applySearchBtn.click();
				//SeleniumTestHelper.waitForElementToBeClickable(driver, firstCheckBx, 60);
				Screenshots.captureSnapshot(driver);
				Thread.sleep(3000);
				//driver.findElement(By.xpath("//span[text()='" + iLPN + "']/../..//input[@type='checkbox']")).click();
				driver.findElement(By.xpath("//input[@id='checkAll_c0_dataForm:LPNListInOutboundMain_lv:dataTable']")).click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, cancelSelectedLPN, 60);
				serialNumbersBtn.click();
				Thread.sleep(3000);
				SeleniumTestHelper.waitForElementToBeClickable(driver, detailsTab, 120);
				Screenshots.captureSnapshot(driver);
				serialNumber = serialNumberText.getText();
				//ILPNPage.setSerialNumber(serialNumber);
				//System.out.println(ILPNPage.getSerialNumber());

				backButton.click();
				Thread.sleep(3000);

				homePage.userClosesOpenedwindow("iLPNs");
				//return serialNumber;
			
			return serialNumber;


		}
	public static String getSerialNumber() {
		return serialNumber;
	}
	public static void setSerialNumber(String serNum) {
		serialNumber = serNum;
	}
	
}
