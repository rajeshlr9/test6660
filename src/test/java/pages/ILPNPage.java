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
	@FindBy(id="dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:field10value1")
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
	
	@FindBy(xpath = "//input[@id='LPNListInboundMain_commandbutton_LockUnlockLPN']")
	public WebElement iLPNLockUnlockBtn1;
	
	@FindBy(id = "LPN_Locks_Tab_lnk")
	public WebElement LocksTab;
	
	@FindBy(id = "dataForm:lockTable:0:ViewLPNLocksList_LockCode_out")
	public WebElement LockCodeValue;
	
	@FindBy(id = "dataForm:lockTable_body")
	public List<WebElement> lockCodeTable;
	
	@FindBy(xpath = "//input[@id='LPNListInboundMain_CmdBtn_LockiLPN']")
	public WebElement iLPNLockUnlockBtn2;
	
	@FindBy(xpath = "//input[@id='rmButton_1Lock1_167270008']")
	public WebElement iLPNlockButton;
	
	@FindBy(id= "dataForm:listView:dataTable:newRow_1:LockCodeSelect")
	public WebElement locksDropdown;
	
	@FindBy(xpath = "//input[@id='checkAll_c0_dataForm:listView:dataTable']")
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

	public void searchLPNCancelItAndVerifyLPNFacilityStatus(int noOfItems, String status)
			throws InterruptedException, IOException, AWTException {
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
	public void searchForTheILPNAndViewIt(String iLPN) throws InterruptedException, IOException{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputLPNSearchTextBox, 50);
		inputLPNSearchTextBox.clear();
		inputLPNSearchTextBox.sendKeys(iLPN);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
		applySearchBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, firstCheckBx, 60);
		driver.findElement(By.xpath("//span[text()='" + iLPN + "']/../..//input[@type='checkbox']")).click();
        SeleniumTestHelper.waitForElementToBeClickable(driver, cancelSelectedLPN, 60);
        viewLPNBtn.click();
        SeleniumTestHelper.waitForElementToBeClickable(driver, headerLPNTab, 120);
        Thread.sleep(1000);
	}
	
	public String getQuantityILPN(String ilpn) {
		
		String lPnpath = "//span[text()='<ILPNINPUT>']/../following-sibling::td//span[contains(@id,'LPN_Qty_param')]";
		String lPnxpath = lPnpath.replace("<ILPNINPUT>", ilpn);
		System.out.println(lPnxpath);
		return driver.findElement(By.xpath(lPnxpath)).getText();
	}
	
   public void verifyiLPNStatus(String status,int noOfItems) throws InterruptedException, IOException{
		
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < noOfItems; i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputLPNSearchTextBox, 50);
			inputLPNSearchTextBox.clear();
			inputLPNSearchTextBox.sendKeys(Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applySearchBtn, 50);
			applySearchBtn.click();
			String iLPN_Status=driver.findElement(By.xpath("//span[text()='"+Items.getItemILPN(Items.getItemsForReceivingASN(i))+"']/following::span[contains(@id,'Outbound_lpnFacilityStatus')]")).getText();
			SeleniumTestHelper.assertEquals(iLPN_Status, status);
		}
	}

   public void lockiLPN() throws InterruptedException, IOException{
		SeleniumTestHelper.switchToInnerFrame(driver);
		LocksTab.click();
		System.out.println(lockCodeTable.get(0).getText());
		if(lockCodeTable.get(0).getText().contains("No data found")) {
			iLPNLockUnlockBtn2.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, lockCodeTable.get(0), 50);
			iLPNlockButton.click();
			String lockcode = String.valueOf(Steps.scenarioData.get("LockCode"));
			System.out.println(lockcode);
			Select dropdown = new Select(locksDropdown);
			for (int i = 0; i < dropdown.getOptions().size(); i++) {
				System.out.println("elements-"+dropdown.getOptions().get(i).getText());
				if(dropdown.getOptions().get(i).getText().equals(lockcode)) {
					System.out.println("value found");
				}else {
					System.out.println("value not found");
				}
			}
			dropdown.selectByValue(lockcode);
			checkBox.click();
			saveButton.click();
			
		}else {
			Steps.logger.info("Lock code already present");
			Reporter.addStepLog("Lock code already present");
			Assert.assertTrue(false);
		}
	}
   
   public void verifyLockCodeStatus(String lockcodetext) throws InterruptedException, IOException{
		
		SeleniumTestHelper.switchToInnerFrame(driver);
		WebElement lockcode = driver.findElement(By.xpath("//select[@disabled='disabled']/option[@selected='selected' and text()='"+lockcodetext+"']"));
		SeleniumTestHelper.assertEquals(lockcode.getText(), lockcodetext);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 50);
		backBtn.click();
	}

   public void adjustiLPNQuantity(String adjust, int noOfItem) throws InterruptedException, IOException{
	   
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
   public void verifyTheiLPNStatus(String status,int noOfItems) throws InterruptedException, IOException{
		
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
   
public void adjustiLPNQuantityWith(String adjust, int noOfItem) throws InterruptedException, IOException{
	   
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
   
	public void validateILPN() throws InterruptedException, IOException {
 		
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
	
}
