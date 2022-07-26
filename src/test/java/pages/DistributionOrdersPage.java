package pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.DistributionOrders;
import entity.Items;
import globalFunc.Screenshots;
import utils.SeleniumTestHelper;

public class DistributionOrdersPage {
	WebDriver driver;
	String oLPN;
	String pulllocationvalue;
	WavesPage wavespage = new WavesPage();
	HomePage homepage = new HomePage();
	List<String> List_Shippedqty = new ArrayList<String>();
	List<String> List_ShippedqtyUOM = new ArrayList<String>();
	List<String> List_ItemName = new ArrayList<String>();
	List<String> oLPNSlist_Shippedqty = new ArrayList<String>();

	public DistributionOrdersPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//label[text()='Primary Fields']//following::input[@role='combobox' and @data-ref='inputEl'])[1]")
	public WebElement primaryField;
	@FindBy(xpath = "//input[@name='DistributionorderID']")
	public WebElement distributionOrderID;
	@FindBy(xpath = "//div[text()='Sorting']/following::span[text()='Apply']")
	public WebElement apply_Btn;
	@FindBy(xpath = "//tr[@class='  x-grid-row']//td//div[@class='x-grid-row-checker']")
	public WebElement distributionOrder_chkbox;
	@FindBy(xpath = "//span[text()='View']")
	public WebElement viewBtn;
	@FindBy(xpath = "//a[text()='DO Lines']")
	public WebElement DOlinesTab;
	@FindBy(xpath = "//span[text()='More']")
	public WebElement moreBtn;
	@FindBy(xpath = "//a/span[text()='Wave']")
	public WebElement waveOption;
	@FindBy(xpath = "//input[@value='Run Wave']")
	public WebElement runWaveBtn;
	@FindBy(xpath = "//td[contains(@class,'fulfillmentStatus')]")
	public WebElement DOStatus;
	@FindBy(xpath = "//td[contains(@class,'fulfillmentStatus')]")
	public WebElement shipConfirm;
	@FindBy(xpath = "//a[text()='LPNs']")
	public WebElement lPNSTab;
	@FindBy(xpath = "//span[@id='dataForm:DODetailsMainHeader_Out_DOID']")
	public WebElement distributionOrderIDtxt;
	@FindBy(xpath = "//input[@id='rmButton_1SubmitWave1_100215000']")
	public WebElement submitWaveBtn;
	@FindBy(xpath = "//span[.='Edit Header']")
	public WebElement editHeaderBtn;
	@FindBy(xpath = "//select[@id='dataForm:DOEdit_HeaderTab_Drop_Shipvia']")
	public WebElement shipViaDdl;
	@FindBy(xpath = "//input[@id='dataForm:DOEdit_HeaderTab_InText_AccountReceivableCode']")
	public WebElement accountReceivableCode;
	@FindBy(xpath = "//a[@id='dataForm:AwvNbrRun']")
	public WebElement waveNumber;
	@FindBy(xpath = "//span[contains(text(),'Amazon Vendor Flex')]//following::td[1]")
	public WebElement shipWaveStatus;
	@FindBy(xpath = "//td[@class='tbl_checkBox advtbl_col advtbl_body_col']")
	public WebElement shipWavechkbox;
	@FindBy(id = "rmButton_2View1_100662000")
	public WebElement shipWaveviewBtn;
	@FindBy(xpath = "//input[@type='button' and contains(@value,'More')]")
	public WebElement shipWavemoreBtn;
	@FindBy(xpath = "//li/a[contains(@id,'rmButton_2LPNs')]")
	public WebElement shipWavemoreLPNS;
	@FindBy(xpath = "//li/a[contains(@id,'rmButton_2Tasks')]")
	public WebElement shipWavemoreTasks;
	// @FindBy(xpath="//input[@alt='Refresh']") public WebElement refreshBtn;
	@FindBy(xpath = "//span[text()='Pallet Pull from Reserve']")
	public WebElement Pallet_Pull_from_Reserve;
	@FindBy(xpath = "//span[contains(@id,'taskIdVal')]")
	public WebElement taskId;
	@FindBy(xpath = "//span[text()='Pick inventory from case pick']")
	public WebElement pickfromCasePick;
	@FindBy(xpath = "//span[text()='Replen Case Pick from Reserve']")
	public WebElement ReplnCasePickfromReserve;
	@FindBy(xpath = "//span[text()='Replen Retail Active from Case pick']")
	public WebElement ReplenRetailActivefromCasePick;
	@FindBy(xpath = "//span[contains(text(),'50 - Pick from active')]")
	public WebElement PickInventoryFromActive;
	@FindBy(xpath = "//span[contains(text(),'Repl actv from resv')]")
	public WebElement replnActvfrmReserve;
	@FindBy(xpath = "//input[@id='checkAll_c0_dataForm:listView:dataTable']")
	public WebElement eCom_Parcel_CheckBox;
	@FindBy(xpath = "//span[text()='Zone Picking']")
	public WebElement zonePickingTask;
	@FindBy(xpath = "//span[text()='Pick inventory from active']")
	public WebElement pickInventoryFromActive;
	@FindBy(xpath = "//span[text()='Repln Active from Reserve']")
	public WebElement replenishActiveFromReserve;
	@FindBy(xpath = "//span[text()='PackingSlipReport']")
	public WebElement printPackingSlipReport;
	@FindBy(xpath = "//span[contains(text(),'Transaction successful.')]")
	public WebElement transactionSuccfulMsg;
	@FindBy(xpath = "	//span[contains(text(),'Print EPI Documents')]")
	public WebElement printEpiDoc;

	@FindBy(xpath = "//input[@id='dataForm:listView:dataTable:pager:dataTable_rfsh_but']")
	public WebElement refreshBtn;

	@FindBy(xpath = "//span[@id='dataForm:listView:dataTable:0:c0012']")
	public WebElement Status_Updated;

	@FindBy(xpath = "//input[@id='checkAll_c0_dataForm:listView:dataTable']")
	public WebElement waveNumber_CheckBox;

	@FindBy(xpath = "//input[@id='rmbuttons_1moreButton' and @type='button']")
	public WebElement Wave_MoreBtn;

	@FindBy(xpath = "//a[@id='rmButton_2LPNs1_100665000']")
	public WebElement LPNs;

	@FindBy(xpath = "//span[contains(@id,'dataTable:0:LPNList_Outbound_Link_NameText_param_out')]")
	public WebElement LPN_One;

	@FindBy(xpath = "//span[@id='dataForm:listView:dataTable:1:LPNList_Outbound_Link_NameText_param_out']")
	public WebElement LPN_Two;

	@FindBy(xpath = "//input[@id='checkAll_c1_dataForm:DODetailOrderLinesList_lv:DODetailsOrderLinelist']")
	public WebElement check_Box;

	@FindBy(xpath = "//input[@id='dataForm:DODetailOrderLinesList_Cancel']")
	public WebElement Cancel_Line;

	@FindBy(xpath = "//span[@id='dataForm:DODetailOrderLinesList_lv:DODetailsOrderLinelist:1:DODetailOrderLinesList_LineItemStatusLink_NameText']")
	public WebElement Line_Status;

	@FindBy(xpath = "//span[contains(@id,'dataTable:0:LPNList_Outbound_lpnFacilityStatus_param_out')]")
	public WebElement LPN_Facility_Status;

	@FindBy(xpath = "//*[contains(text(),'Weighed')]")
	public WebElement fulfillment_Status;
	@FindBy(xpath = "//input[@id='checkAll_c1_dataForm:listView:dataTable']")
	public WebElement retail_Parcel_CheckBox;

	@FindBy(xpath = "//span[text()='View Packing Slip']")
	public WebElement ViewPackingSlip;
	@FindBy(xpath = "//img[@id='backImage']")
	public WebElement backBtn;
	@FindBy(xpath = "//span[@id='dataForm:shipmentIdRepeat1:0:DODtlHdr_ShpId_OpLnk_Txt__']")
	public WebElement shippingID;
	@FindBy(xpath = "//span[@id='dataForm:ShpDtlGen_OutText_TrailerNumber']")
	public WebElement trailerNumber;
	@FindBy(xpath = "//span[text()='ools']/following-sibling::span[1]")
	public WebElement Tools;
	@FindBy(xpath = "(//a[text()='Customize'])[1]")
	public WebElement Tools_Customize;
	@FindBy(xpath = "//input[@id = 'dataForm:rowsPerPage']")
	public WebElement Tools_Number_Of_rows_per_Page;
	@FindBy(xpath = "//input[@id = 'dataForm:save']")
	public WebElement Tools_Customize_save_Btn;
	@FindBy(xpath = "//span[text()='Task Type']")
	public WebElement Task_type_sortby;
	@FindBy(xpath = "//input[contains(@id,'pager:next') and @class='paginationCtrlCls']")
	public WebElement nextPageInTable;
	@FindBy(xpath = "//input[@value='View']")
	public WebElement viewBtnTasks;
	@FindBy(xpath = "//span[text()='oLPN:']/../following-sibling::td[1]//span")
	public WebElement oLPNText;
	@FindBy(xpath = "//input[@id='dataForm:lview:dataTable:pager:dataTable_rfsh_but']")
	public WebElement refreshBtnAfterBack;
	@FindBy(xpath = "//input[@alt='Find Task ID']")
	public WebElement inputTaskID;
	@FindBy(xpath = "//input[contains(@id,'filterIdapply') and @title='Apply']")
	public WebElement applyTaskBtn;

	@FindBy(xpath = "(//input[starts-with(@id, 'combobox')])[5]")
	public WebElement statusSearch_inputBox;
	@FindBy(xpath = "//span[@id='dataForm:DODetailsMainHeader_Out_DOID']")
	public WebElement DO_ID_value;
	public String dolineStatuspath = "//span[text()='<ILPNINPUT>']/../../following-sibling::td[6]";

	@FindBy(xpath = "//td[contains(text(),'No data found')]")
	public WebElement noOLPNDataFound;

	@FindBy(xpath = "//a/span[text()='Cancel']")
	public WebElement CnclBtn;
	@FindBy(xpath = "//span[@id='button-1006-btnInnerEl']")
	public WebElement yesBtn;
	@FindBy(xpath = "//input[@value='Confirm' and @id='rmButton_1Confirm1_167271101']")
	public WebElement cnfmBtn;
	@FindBy(xpath = "//div[contains(text(),'Messages (')]")
	public WebElement errorMessage;
	@FindBy(xpath = "(//div[contains(text(),'Messages (')]//following::div[@class='pop_close'])[1]")
	public WebElement errorMessageClose;
	@FindBy(xpath = "(//label[text()='Primary Fields']//following::input[@role='combobox' and @data-ref='inputEl'])[3]")
	public WebElement fulfilmentStatus;

	@FindBy(xpath = "//span[text()='Ship Confirm']")
	public WebElement ViewShipConfirm;

	@FindBy(xpath = "//span[@id='button-1006-btnInnerEl']")
	public WebElement ConfirmationYes;
	@FindBy(xpath = "//div[text()='190 - Shipped']")
	public WebElement fullfilmentStatusShipped;
	@FindBy(xpath = "//span[text()='Condition:']/../../following::input[1]")
	public WebElement firstOptionalFieldCondition;
	@FindBy(xpath = "//span[text()='Condition:']/../../following::input[3]")
	public WebElement firstOptionalFieldStatusValue;
	@FindBy(xpath = "//span[text()='Add Condition']")
	public WebElement addCondition;
	@FindBy(xpath = "//span[text()='Condition:']/../../following::input[4]")
	public WebElement secondOptionalFieldCondition;
	@FindBy(xpath = "//span[text()='Condition:']/../../following::input[6]")
	public WebElement secondOptionalFieldStatusValue;
	@FindBy(xpath = "//span[text()='Distribution Order ID:']/../following::span[1]")
	public WebElement orderID;
	@FindBy(xpath = "//input[contains(@id,'checkAll_c0_dataForm:DODetailOrderLinesList')]")
	public WebElement firstLineItemCheckBx;
	@FindBy(xpath = "//input[@value='View Line']")
	public WebElement viewLineBtn;
	@FindBy(xpath = "//span[text()='External system Purchase Order:']/../following::span[1]")
	public WebElement externalPurchaseOrderID;
	@FindBy(xpath = "//input[contains(@id,'checkAll_c0_dataForm:DODetailOrderLinesList')]/../following::span[5]")
	public WebElement itemNumber;
	@FindBy(xpath = "//select[@id='dataForm:adjustReasonSelect']")
	public WebElement rsnCode;
	
	@FindBy(id="dataForm:DODetailsMainHeader_Edit_button")
	public WebElement dOEditBtn;
				
	@FindBy(id="dataForm:DOEdit_HeaderTab_PAN_DesignatedResources_Title_OT")
	public WebElement editDesignatedResources;
	
	@FindBy(id="dataForm:DODetailsHeader_PAN_DesignatedResources_Title_OT")
	public WebElement designatedResources;
	
	@FindBy(id="dataForm:DOEdit_HeaderTab_InText_Carrier")
	public WebElement carrier;
	
	@FindBy(id="dataForm:DOEdit_HeaderTab_SOM_Servicelevel")
	public WebElement servicelevel;
	
	@FindBy(id="dataForm:DOEdit_HeaderTab_Drop_Shipvia")
	public WebElement shipvia;
	
	@FindBy(id="dataForm:DOEdit_save_button")
	public WebElement saveBtn;
	
	
	

	public String getDolinesStatus(String donumber) {

		String dolinestatusxpath = dolineStatuspath.replace("<ILPNINPUT>", donumber);
		System.out.println(dolinestatusxpath);
		return driver.findElement(By.xpath(dolinestatusxpath)).getText();
	}

	@FindBy(xpath = "//span[text()='Cancel']")
	public WebElement cancelBtn;

	@FindBy(xpath = "//span[text()='Yes']")
	public WebElement confirmationYespopup;

	@FindBy(xpath = "//input[@value='Confirm']")
	public WebElement confirmBtn;

	@FindBy(xpath = "//img[@id='backImage']")
	public WebElement arrow_Sign;

	@FindBy(xpath = "//a[@id='rmButton_2Tasks1_100668000']")
	public WebElement tasks;

	@FindBy(xpath = "//span[@id='dataForm:lview:dataTable:lsize']")
	public WebElement task_Id_Text;

	@FindBy(xpath = "//input[@id='checkAll_c0_dataForm:lview:dataTable']")
	public WebElement task_Id_ChkBox;

	@FindBy(xpath = "//input[@type='button' and @value='View']")
	public WebElement task_Id_viewBtn;

	@FindBy(xpath = "//span[text()='Pull Location:']/../following-sibling::td[1]//span")
	public WebElement pullLocationValue;

	@FindBy(xpath = "//span[text()='Container:']/following::div[1]//span")
	public WebElement containerilpnValue;

	@FindBy(xpath = "//td[text()=' No data found']")
	public WebElement noDataFound;
	@FindBy(xpath = "//a[contains(@id,'rmButton_2AllocationDetails') and text()='Allocation Details']")
	public WebElement AllocationDetails;

	@FindBy(xpath = "(//table[starts-with(@id, 'gridview')][1]/tbody/tr/td/div)[1]/div")
	public WebElement first_checkBox;
	@FindBy(xpath = "//span[@id='dataForm:DOHeaderFulfillmentStatus']/b/span")
	public WebElement DO_FulFill_Status;
	@FindBy(xpath = "//span[@id='dataForm:DODetailsHeader_OutText_DSG_Shipvia']")
	public WebElement shipVia_Value;
	@FindBy(xpath = "//input[contains(@id,'checkAll_c0_dataForm:')]")
	public WebElement doFirstLineChkBox;

	@FindBy(xpath = "//span[@id='button-1490-btnIconEl']")
	public WebElement nxtBtn;
	@FindBy(xpath = "//span[@id='dataForm:DODetailsLpnList_lv:LPNListTable:0:LPNListTPM_Link_NameText_param_out']")
	public WebElement olpnTxt;
	@FindBy(xpath = "//span[text()='Distribution Order' and @data-ref='textEl']/ancestor::div[5]/following-sibling::div//table[1]//td[3]")
	public WebElement doTxt;

	@FindBy(xpath = "(//div[class='mps-memo-item'])")
	public WebElement DOPopup;

	@FindBy(xpath = "(//label[text()='Primary Fields']//following::input[@role='combobox' and @data-ref='inputEl'])[3]") 
	public WebElement primaryFieldStatus;
	
	@FindBy(xpath = "(//label[text()='Optional Fields']//following::input[@role='combobox' and @data-ref='inputEl'])[2]") 
	public WebElement optionalField;
	
	@FindBy(xpath = "(//label[text()='Optional Fields']//following::input[@role='textbox' and @data-ref='inputEl'])[1]") 
	public WebElement optionalFieldInputText;
	
	public void getDO() throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		Screenshots.captureSnapshot(driver);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		Screenshots.captureSnapshot(driver);
		distributionOrderID.click();
		System.out.println(Items.getDONumber());
		distributionOrderID.sendKeys(Items.getDONumber());
		Screenshots.captureSnapshot(driver);
		apply_Btn.click();
		System.out.println("clicked");
		//SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		Screenshots.captureSnapshot(driver);
		//WebElement actualDOstatus = driver.findElement(By.xpath("//td[@data-columnid='distributionorderID']/div[text()='"
		//		+ Items.getDONumber() + "']//following::td[1]"));
		int temp=0;
		 while (!SeleniumTestHelper.isElementDisplayed(distributionOrder_chkbox) && (temp != 10)) {
			 apply_Btn.click();
			 Thread.sleep(3000);
			 temp++;
		 }
		
		 if(SeleniumTestHelper.isElementDisplayed(distributionOrder_chkbox)) {
			 Reporter.addStepLog("DO is created");
			 Assert.assertTrue(false);
		 }else {
			 Reporter.addStepLog("DO is not created");
			 Assert.assertTrue(true); 
		 }
		 
		
		
		homepage.user_closes_openedwindow("Distribution Orders");

	}
	
	
	
	public void getDoStatus(String expectedDOstatus) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		Screenshots.captureSnapshot(driver);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		Screenshots.captureSnapshot(driver);
		distributionOrderID.click();
		//
		//Items.setDONumber("QSC202112011519");
		System.out.println(Items.getDONumber());
		distributionOrderID.sendKeys(Items.getDONumber());
		Screenshots.captureSnapshot(driver);
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		Screenshots.captureSnapshot(driver);
		String actualDOstatus = driver.findElement(By.xpath("//td[@data-columnid='distributionorderID']/div[text()='"
				+ Items.getDONumber() + "']//following::td[1]")).getText();
		SeleniumTestHelper.assertEquals(actualDOstatus, expectedDOstatus);
		Reporter.addStepLog("DO Order status:" + actualDOstatus);
		Steps.logger.info("DO Order status:" + actualDOstatus);
		Thread.sleep(2000);
		homepage.user_closes_openedwindow("Distribution Orders");

	}

	public void checkoLPNSstatus(String expectedDOstatus) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(Items.getDONumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, lPNSTab, 50);
		lPNSTab.click();
		List<WebElement> oLPNS = driver
				.findElements(By.xpath("//span[contains(@id,'LPNListTPM_Link_NameText_param_out')]"));
		List<WebElement> oLPNSstatus = driver
				.findElements(By.xpath("//span[contains(@id,'ListTPM_lpnFacilityStatus_param_out')]"));
		String oLPNIndividual = null;
		String oLPNStatusIndividual = null;
		for (int i = 0; i < oLPNS.size(); i++) {
			oLPNIndividual = oLPNS.get(i).getText();
			oLPNStatusIndividual = oLPNSstatus.get(i).getText();
			SeleniumTestHelper.assertEquals(oLPNStatusIndividual, expectedDOstatus);
			System.out.println("Status : " + oLPNStatusIndividual + " verified for oLPN : " + oLPNIndividual);
		}

	}
	
	public void updateShipVia() throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(Items.getDONumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, dOEditBtn, 50);
		dOEditBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, editDesignatedResources, 50);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", editDesignatedResources);
		carrier.clear();
		Thread.sleep(1000);
		String shpViaarr[] = Steps.scenarioData.get("ShipVia").split(";");
		Select shipViaOpton = new Select(shipvia);
		shipViaOpton.selectByVisibleText(Steps.scenarioData.get("ShipVia"));
		Thread.sleep(1000);
		Select svcLevelOpton = new Select(servicelevel);
		svcLevelOpton.selectByVisibleText("(none)");;
		Thread.sleep(1000);
		saveBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, dOEditBtn, 50);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", designatedResources);
		Assert.assertEquals(shipVia_Value.getText(), (shpViaarr[0]).trim());
		//Thread.sleep(10000);
		Thread.sleep(2000);
		homepage.user_closes_openedwindow("Distribution Orders");
		Thread.sleep(2000);
		SeleniumTestHelper.Close_OpenedWindow("DO Detail - Distribution Order", driver);
	}

	public void checkOnlyoLPNSstatus() throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(Items.getDONumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, lPNSTab, 50);
		lPNSTab.click();
		List<WebElement> oLPNS = driver
				.findElements(By.xpath("//span[contains(@id,'LPNListTPM_Link_NameText_param_out')]"));
		List<WebElement> oLPNSstatus = driver
				.findElements(By.xpath("//span[contains(@id,'ListTPM_lpnFacilityStatus_param_out')]"));
		String oLPNIndividual = null;
		String oLPNStatusIndividual = null;
		for (int i = 0; i < oLPNS.size(); i++) {
			oLPNIndividual = oLPNS.get(i).getText();
			oLPNStatusIndividual = oLPNSstatus.get(i).getText();
			// SeleniumTestHelper.assertEquals(oLPNStatusIndividual, expectedDOstatus);
			Reporter.addStepLog("Status : " + oLPNStatusIndividual + " verified for oLPN : " + oLPNIndividual);
			Steps.logger.info("Status : " + oLPNStatusIndividual + " verified for oLPN : " + oLPNIndividual);
			System.out.println("Status : " + oLPNStatusIndividual + " verified for oLPN : " + oLPNIndividual);
		}
		homepage.user_closes_openedwindow("Distribution Orders");
		homepage.user_closes_openedwindow("DO Detail - Distribution Order");

	}

	public void checkOnlyoLPNSstatus(String status) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(Items.getDONumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, lPNSTab, 50);
		lPNSTab.click();
		List<WebElement> oLPNS = driver
				.findElements(By.xpath("//span[contains(@id,'LPNListTPM_Link_NameText_param_out')]"));
		List<WebElement> oLPNSstatus = driver
				.findElements(By.xpath("//span[contains(@id,'ListTPM_lpnFacilityStatus_param_out')]"));
		String oLPNIndividual = null;
		String oLPNStatusIndividual = null;
		for (int i = 0; i < oLPNS.size(); i++) {
			oLPNIndividual = oLPNS.get(i).getText();
			oLPNStatusIndividual = oLPNSstatus.get(i).getText();
			// SeleniumTestHelper.assertEquals(oLPNStatusIndividual, expectedDOstatus);
			System.out.println("Status : " + oLPNStatusIndividual + " for oLPN : " + oLPNIndividual);
			if(oLPNStatusIndividual.equals(status)) {
				globalFunc.Screenshots.seleniumSnapshot(driver);
				Assert.assertEquals(oLPNStatusIndividual, status, "oLPN Status");
			}
			
		}
		homepage.user_closes_openedwindow("Distribution Orders");
		homepage.user_closes_openedwindow("DO Detail - Distribution Order");

	}

	public void runWaveTemplate(String waveTemplateDesc, String expStatus, String OrderType)
			throws Exception, AWTException {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 100);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.assertEquals(DOStatus.getText(), "Released");
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		moreBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveOption, 50);
		waveOption.click();
		Thread.sleep(3000);
		homepage.user_closes_openedwindow("Distribution Orders");
		homepage.openWindows.click();

		List<WebElement> myframes = driver.findElements(By.tagName("Iframe"));
		System.out.println("my framecount is   " + myframes.size());
		SeleniumTestHelper.switchToInnerFrame(driver);
		driver.findElement(By.xpath("//input[@alt='Find Description']")).sendKeys(waveTemplateDesc);
		wavespage.waveNumberApplySearchBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);

		driver.findElement(By.xpath("//span[contains(text(),'" + waveTemplateDesc
				+ "')]/ancestor::td/preceding-sibling::td[2][contains(@class,'checkBox')]")).click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, runWaveBtn, 100);

		runWaveBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, submitWaveBtn, 100);
		submitWaveBtn.click();

		if (SeleniumTestHelper.isElementDisplayed(waveNumber)) {
			String waveNumberValue = waveNumber.getText();
			DistributionOrders.setWaveNumber(waveNumberValue);
			waveNumber.click();
			SeleniumTestHelper.switchToInnerFrame(driver);
			String actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
			int count = 0;
			while (!actualStatus.equals("Ship wave completed") && (count != 20)) {
				refreshBtn.click();
				actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
				Thread.sleep(5000);
				count++;
			}
			SeleniumTestHelper.assertEquals(actualStatus, "Ship wave completed");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
			shipWavechkbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
			shipWavemoreBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreLPNS, 50);
			shipWavemoreLPNS.click();
			List<WebElement> oLPNS = driver
					.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_Link_NameText')]"));
			List<WebElement> olpnStatus = driver
					.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_lpnFacilityStatus_param_out')]"));
			List<WebElement> olpnItems = driver
					.findElements(By.xpath("//span[contains(@id,'Case_LPN_With_PO_LPN_POLine_Item_param_out')]"));
			List<WebElement> olpnwithqty = driver
					.findElements(By.xpath("//span[contains(@id,'CTO_LPNListTPM_LPN_Qty_param_out2')]"));

			for (int i = 0; i < olpnStatus.size(); i++) {
				String oLPNSnum = oLPNS.get(i).getText();
				String oLPNSinShipwave = olpnStatus.get(i).getText();
				String[] olpnwithqtydata = olpnwithqty.get(i).getText().split("\\s+");
				DistributionOrders.setoLPNList(oLPNSnum);
				if (olpnItems.get(i).getText().equals("Mixed")) {
					int noOfItem = 0;
					String item = null;
					noOfItem = DistributionOrders.productsForDistOrder.size();
					System.out.println("Total noOfItem :- " + noOfItem);
					for (int j = 0; j < noOfItem; j++) {
						item = DistributionOrders.getProductsForDistOrder(j);
						DistributionOrders.setoLPNForMixeditem(item, oLPNSnum);
						System.out.println("oLPN : " + DistributionOrders.getoLPNForMixeditem(item)
								+ " is set for item : " + item);
					}

				} else {
					DistributionOrders.setoLPNwithitem(oLPNSnum, olpnItems.get(i).getText());
				}
				DistributionOrders.setoLPNwithQty(oLPNSnum, olpnwithqtydata[0]);
				oLPN = oLPNS.get(i).getText();
				DistributionOrders.setSingle_oLPN(oLPN);
				System.out.println("oLPN  : " + oLPNS.get(i).getText() + ", status is : " + oLPNSinShipwave);
				SeleniumTestHelper.assertEquals(oLPNSinShipwave, expStatus);
			}

			arrow_Sign.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
			shipWavechkbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
			shipWavemoreBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreTasks, 50);
			shipWavemoreTasks.click();

			WebElement activeChkbox;
			Thread.sleep(5000);
			System.out.println("OrderType is " + OrderType);
			if (OrderType.equalsIgnoreCase("DFILL")) {
				if (SeleniumTestHelper.isElementDisplayed(zonePickingTask)
						|| SeleniumTestHelper.isElementDisplayed(pickInventoryFromActive)) {
					System.out.println("PickInventoryFromActive.getAttribute textContent "
							+ PickInventoryFromActive.getAttribute("textContent"));
					if (PickInventoryFromActive.getAttribute("textContent").contains("Pick from active")) {
						System.out.println("Task id generated is " + taskId);
						System.out.println(PickInventoryFromActive.getText());
						SeleniumTestHelper.assertEquals(PickInventoryFromActive.getAttribute("textContent"),
								"50 - Pick from active");

					}
					List<WebElement> activetaskID = driver.findElements(By.xpath(
							"//span[text()='Pick inventory from active']/../preceding-sibling::td//span[contains(@id,'taskIdVal')]"));
					List<String> activeTaskIdStr = new ArrayList<String>();

					for (WebElement ele : activetaskID) {
						System.out.println("TaskId for Active-> " + ele.getText());
						ele.getAttribute("textContent");
						activeTaskIdStr.add(ele.getText().trim());
						DistributionOrders.setActiveTasks(ele.getText().trim());

					}
					for (String active : activeTaskIdStr) {

						System.out.println("Inside for loop " + active);
						activeChkbox = driver.findElement(By.xpath(
								"//span[text()='" + active + "']/../preceding-sibling::td//input[@type='checkbox']"));
						SeleniumTestHelper.waitForElementToBeClickable(driver, activeChkbox, 50);
						activeChkbox.click();
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewBtnTasks, 50);
						viewBtnTasks.click();
						DistributionOrders.setoLPNwithActive(oLPNText.getText());
						System.out.println("Active oLPN: " + oLPNText.getText());
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 100);
						backBtn.click();

						activeChkbox = null;
					}

				}
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 100);
				backBtn.click();
			}

			else if (OrderType.equalsIgnoreCase("Bulk Parcel") || OrderType.equalsIgnoreCase("NL")) {

				try {
					if (PickInventoryFromActive.getAttribute("textContent").contains("Pick from active")) {
						System.out.println(PickInventoryFromActive.getAttribute("textContent"));
						SeleniumTestHelper.assertEquals(PickInventoryFromActive.getAttribute("textContent"),
								"50 - Pick from active");

						List<WebElement> activetaskID = driver.findElements(By.xpath(
								"//span[contains(text(),'Pick from active')]/../preceding-sibling::td//span[contains(@id,'taskIdVal')]"));
						List<String> activeTaskIdStr = new ArrayList<String>();

						for (WebElement ele : activetaskID) {
							System.out.println("TaskId for Active-> " + ele.getAttribute("textContent"));
							activeTaskIdStr.add(ele.getAttribute("textContent").trim());
							DistributionOrders.setActiveTasks(ele.getAttribute("textContent").trim());
						}
						for (String active : activeTaskIdStr) {

							System.out.println("Inside for loop " + active);
							activeChkbox = driver.findElement(By.xpath("//span[text()='" + active
									+ "']/../preceding-sibling::td//input[@type='checkbox']"));
							SeleniumTestHelper.waitForElementToBeClickable(driver, activeChkbox, 50);
							activeChkbox.click();
							SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewBtnTasks, 50);
							viewBtnTasks.click();
							DistributionOrders.setoLPNwithActive(oLPNText.getText());
							System.out.println("Active oLPN: " + oLPNText.getText());

							SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 100);
							backBtn.click();

							activeChkbox = null;
						}
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 50);
						backBtn.click();
						Thread.sleep(3000);
					}
				} catch (NoSuchElementException e) {
					System.out.println("Active Inventory task did not got generated");
				}

				if (SeleniumTestHelper.isElementDisplayed(pickfromCasePick)) {
					List<WebElement> casePicktaskID = driver.findElements(By.xpath(
							"//span[contains(text(),'Pick inventory from case pick')]/../preceding-sibling::td//span[contains(@id,'taskIdVal')]"));
					List<String> casePickTaskIdStr = new ArrayList<String>();
					System.out.println("Number of Case Pick Task ID's " + casePicktaskID.size());
					for (WebElement ele : casePicktaskID) {
						System.out.println("TaskId for casePick-> " + ele.getText());
						casePickTaskIdStr.add(ele.getText().trim());
						// DistributionOrders.casePickTasks.add(ele.getText().trim());
						DistributionOrders.setCasePickTasks(ele.getText().trim());

					}
					for (String casePick : casePickTaskIdStr) {

						System.out.println("Inside for loop " + casePick);
						activeChkbox = driver.findElement(By.xpath(
								"//span[text()='" + casePick + "']/../preceding-sibling::td//input[@type='checkbox']"));
						SeleniumTestHelper.waitForElementToBeClickable(driver, activeChkbox, 50);
						activeChkbox.click();
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewBtnTasks, 50);
						viewBtnTasks.click();
						DistributionOrders.setoLPNwithCase(oLPNText.getText());
						System.out.println("CasePick oLPN: " + oLPNText.getText());
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 50);
						backBtn.click();
						activeChkbox = null;
					}
				}
				if (SeleniumTestHelper.isElementDisplayed(replenishActiveFromReserve)) {
					if (replnActvfrmReserve.getAttribute("textContent").contains("Repl actv from resv")) {
						List<WebElement> replnActvfrmResrvtaskID = driver.findElements(By.xpath(
								"//span[contains(text(),'Repl actv from resv')]/../preceding-sibling::td//span[contains(@id,'taskIdVal')]"));
						List<String> replnActvfrmResrvTaskIdStr = new ArrayList<String>();
						for (WebElement ele : replnActvfrmResrvtaskID) {
							System.out.println(
									"TaskId for Replenish Active from Reserve-> " + ele.getAttribute("textContent"));
							replnActvfrmResrvTaskIdStr.add(ele.getAttribute("textContent").trim());
							DistributionOrders.setReplnTasks(ele.getAttribute("textContent").trim());
						}
						System.out.println("Replenishment task size: " + DistributionOrders.replnTasks.size());
					}
				}
				// backBtn.click();
				// shipWavechkbox.click();
				// SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				// shipWavemoreBtn, 50);
				// shipWavemoreBtn.click();
				// SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				// AllocationDetails, 50);
				// AllocationDetails.click();

				// if(DistributionOrders.oLPNwithCase.size()>0)
				// {
				// List<WebElement> casepickoLPN =
				// driver.findElements(By.xpath("//span[text()='51 - Pick from
				// case pick']/../following-sibling::td[3]/span[1]"));
				// for(WebElement ele : casepickoLPN){
				// System.out.println("oLPN for case pick -> " + ele.getText());
				// DistributionOrders.setoLPNwithCase(ele.getText().trim());
				//
				// }
				// }
				/*
				 * if(DistributionOrders.oLPNwithActive.size()>0) { List<WebElement> ActiveoLPN
				 * = driver.findElements(By.
				 * xpath("//span[contains(text(),'50 - Pick from active')]/../following-sibling::td[3]/span[1]"
				 * )); for(WebElement ele : ActiveoLPN){
				 * System.out.println("oLPN for Active -> " + ele.getText());
				 * DistributionOrders.setoLPNwithActive(ele.getText().trim()); } } }
				 */
				/*
				 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 100);
				 * backBtn.click();
				 */
				/*
				 * for(WebElement ele : reserveoLPN){ System.out.println("oLPN for Reserve -> "
				 * + ele.getText());
				 * DistributionOrders.setoLPNwithReserve(ele.getText().trim());
				 * 
				 * 
				 * }
				 */

				// if(SeleniumTestHelper.isElementDisplayed(Pallet_Pull_from_Reserve)&&SeleniumTestHelper.isElementDisplayed(pickfromCasePick))
				// {
				// System.out.println("Task id generated is "+ taskId);
				// System.out.println(Pallet_Pull_from_Reserve.getText());
				// SeleniumTestHelper.assertEquals(Pallet_Pull_from_Reserve.getText(),
				// "Pallet Pull from Reserve");
				// SeleniumTestHelper.assertEquals(pickfromCasePick.getText(),
				// "Pick from case pick");
				//
				// List<WebElement> reservetaskID =
				// driver.findElements(By.xpath("//span[text()='Pallet Pull from
				// Reserve']/../preceding-sibling::td//span[contains(@id,'taskIdVal')]"));
				// List<WebElement> casepicktaskID =
				// driver.findElements(By.xpath("//span[text()='Pick from case
				// pick']/../preceding-sibling::td//span[contains(@id,'taskIdVal')]"));
				//
				// WebElement casePickChkbox;
				// WebElement reservePickChkbox;
				// List<String> casepickTaskIdStr = new ArrayList<String>();
				// List<String> reserveTaskIdStr = new ArrayList<String>();
				// for(WebElement ele : casepicktaskID){
				// System.out.println("TaskId for case pick -> " +
				// ele.getText());
				// casepickTaskIdStr.add(ele.getText().trim());
				//
				// }
				// for(WebElement ele : reservetaskID){
				// System.out.println("TaskId for Reserve -> " + ele.getText());
				// reserveTaskIdStr.add(ele.getText().trim());
				//
				// }
				//
				// for (String casePick : casepickTaskIdStr) {
				//
				// System.out.println("Inside for loop " + casePick);
				// casePickChkbox =
				// driver.findElement(By.xpath("//span[text()='"+casePick+"']/../preceding-sibling::td//input[@type='checkbox']"));
				// SeleniumTestHelper.waitForElementToBeClickable(driver,
				// casePickChkbox, 50);
				// casePickChkbox.click();
				// SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				// viewBtnTasks, 50);
				// viewBtnTasks.click();
				// DistributionOrders.setoLPNwithCase(oLPNText.getText());
				// System.out.println("Case Pick oLPN: "+ oLPNText.getText());
				// SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				// backBtn, 50);
				// backBtn.click();
				// Thread.sleep(3000);
				// casePickChkbox = null;
				// }
				// for (String reserve : reserveTaskIdStr) {
				//
				// reservePickChkbox =
				// driver.findElement(By.xpath("//span[text()='"+reserve+"']/../preceding-sibling::td//input[@type='checkbox']"));
				// SeleniumTestHelper.waitForElementToBeClickable(driver,
				// reservePickChkbox, 50);
				// reservePickChkbox.click();
				// SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				// viewBtnTasks, 50);
				// viewBtnTasks.click();
				// DistributionOrders.setoLPNwithReserve(oLPNText.getText());
				// System.out.println("Reserve Pick oLPN: "+oLPNText.getText());
				// SeleniumTestHelper.waitForElementToBeDisplayed(driver,
				// backBtn, 50);
				// backBtn.click();
				// Thread.sleep(3000);
				// reservePickChkbox = null;
				// }
				//
			}

			if (OrderType.equalsIgnoreCase("NL")) {
				backBtn.click();
			}

			// else
			// if(OrderType.equalsIgnoreCase("NL")||OrderType.equalsIgnoreCase("DFill"))
			// {
			// backBtn.click();
			// }
			Thread.sleep(3000);

			homepage.user_closes_openedwindow("ShipWaveTemplate - Waves");

		}

	}

	public void runWaveTemplate(String waveTemplateDesc) throws Exception {
		try {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 100);
		primaryField.sendKeys("Distribution Order");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(Items.getDONumber());
		System.out.println("Failed11");
		Screenshots.captureSnapshot(driver);
		apply_Btn.click();
		System.out.println("Failed0");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		Screenshots.captureSnapshot(driver);
		distributionOrder_chkbox.click();
		System.out.println("Failed1");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, DOStatus, 50);
		System.out.println("Failed2");
		SeleniumTestHelper.assertEquals(DOStatus.getText(), "110 - Released");
		System.out.println("Failed3");
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		System.out.println("Failed4");
		moreBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveOption, 50);
		Screenshots.captureSnapshot(driver);
		waveOption.click();
		Thread.sleep(3000);
		Screenshots.captureSnapshot(driver);
		homepage.user_closes_openedwindow("Distribution Orders");
		homepage.openWindows.click();

		List<WebElement> myframes = driver.findElements(By.tagName("Iframe"));
		System.out.println("my framecount is   " + myframes.size());
		Thread.sleep(2000);
		SeleniumTestHelper.switchToInnerFrame(driver);
		driver.findElement(By.xpath("//input[@alt='Find Description']")).sendKeys(waveTemplateDesc);
		Screenshots.captureSnapshot(driver);
		wavespage.waveNumberApplySearchBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		Screenshots.captureSnapshot(driver);

		driver.findElement(By.xpath("//span[contains(text(),'" + waveTemplateDesc
				+ "')]/ancestor::td/preceding-sibling::td[2][contains(@class,'checkBox')]")).click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, runWaveBtn, 100);

		runWaveBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, submitWaveBtn, 100);
		Screenshots.captureSnapshot(driver);
		Thread.sleep(2000);
		submitWaveBtn.click();
		Screenshots.captureSnapshot(driver);
		if (SeleniumTestHelper.isElementDisplayed(waveNumber)) {
			String waveNumberValue = waveNumber.getText();
			Items.setWaveNumber(waveNumberValue);
			Steps.logger.info("Wave no generated successfully");
			Reporter.addStepLog("Wave no generated successfully");
			Steps.logger.info("Wave no:" + Items.getWaveNumber());
			Reporter.addStepLog("Wave no:" + Items.getWaveNumber());
			//Items.setWaveNumber(waveNumberValue);
			Thread.sleep(6000);
			SeleniumTestHelper.waitForElementToBeClickable(driver, waveNumber, 150);
			waveNumber.click();
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			String actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
			int count = 0;
			while (!actualStatus.equals("90 - Ship wave completed") && (count != 20)) {
				refreshBtn.click();
				//stale element
				actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
				Thread.sleep(10000);
				count++;
			}
			Steps.logger.info("Wave status:" + actualStatus);
			Reporter.addStepLog("Wave status:" + actualStatus);

		}
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);

		homepage.user_closes_openedwindow("ShipWaveTemplate - Waves");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	public void getDOdetails() throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		Screenshots.captureSnapshot(driver);
		distributionOrderID.click();
		distributionOrderID.sendKeys(Items.getDONumber()); // DistributionOrders.getDOnumber()
		Screenshots.captureSnapshot(driver);
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		Screenshots.captureSnapshot(driver);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);

		SeleniumTestHelper.waitForElementToBeClickable(driver, DOlinesTab, 50);
		Screenshots.captureSnapshot(driver);
		DOlinesTab.click();
		Thread.sleep(5000);
		List<WebElement> itemslist = driver.findElements(By.xpath("//span[contains(@id,'ItemID_Link_NameText')]"));
		List<WebElement> OriginalOrderedqty = driver
				.findElements(By.xpath("//span[contains(@id,'DODetailOrderLinesList_OrigOrderQtyLink_NameText')]"));
		System.out.println(itemslist.size());
		System.out.println(OriginalOrderedqty.size());
		Screenshots.captureSnapshot(driver);
		String[] shippedQty = null;
		String itemInDOPage = null;
		// String DoID = distributionOrderIDtxt.getText();
		System.out.println("Size of ItemDataMap"+Steps.ItemDataMap.size());
		for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
			System.out.println("value of i "+i);
			shippedQty = OriginalOrderedqty.get(i).getText().split("\\s+");
			List_Shippedqty.add(shippedQty[0]);
			List_ShippedqtyUOM.add(shippedQty[1]);
			itemInDOPage = itemslist.get(i).getText();
			List_ItemName.add(itemInDOPage);
			/*
			 * DistributionOrders.DOItemQTYUOM.put("IteminDO" + (i + 1), itemInDOPage);
			 * DistributionOrders.DOItemQTYUOM.put("QtyinItem" + (i + 1), shippedQty[0]);
			 * DistributionOrders.DOItemQTYUOM.put("UOMinItem" + (i + 1), shippedQty[1]);
			 * DistributionOrders.DOMap.put(DoID, DistributionOrders.DOItemQTYUOM);
			 */
			System.out.println("Items in DO page: " + List_ItemName.get(i));
			System.out.println("Qty for item in DO page: " + List_Shippedqty.get(i));
			System.out.println("UOM for Items in DO page: " + List_ShippedqtyUOM.get(i));
			SeleniumTestHelper.assertEquals(List_ItemName.get(i), Steps.ItemDataMap.get(i).get("Item"));
			SeleniumTestHelper.assertEquals(List_Shippedqty.get(i), Steps.ItemDataMap.get(i).get("ShippedQty"));
			SeleniumTestHelper.assertEquals(List_ShippedqtyUOM.get(i), Steps.ItemDataMap.get(i).get("UOM"));

			Reporter.addStepLog("Item Id: " + List_ItemName.get(i) + ", Qty: " + List_Shippedqty.get(i) + ", UOM: "
					+ List_ShippedqtyUOM.get(i));
			Steps.logger.info("Item Id: " + List_ItemName.get(i) + ", Qty: " + List_Shippedqty.get(i) + ", UOM: "
					+ List_ShippedqtyUOM.get(i));

			/*
			 * SeleniumTestHelper.assertEquals(DistributionOrders.DOMap.get(DoID
			 * ).get("IteminDO"+(i+1)), "7978767501003");
			 * SeleniumTestHelper.assertEquals(Integer.parseInt(
			 * DistributionOrders.DOMap.get(DoID).get("QtyinItem"+(i+1))), 8);
			 * SeleniumTestHelper.assertEquals(DistributionOrders.DOMap.get(DoID
			 * ).get("UOMinItem"+(i+1)), "EA");
			 */
		}
		Thread.sleep(5000);
		homepage.user_closes_openedwindow("Distribution Orders");
		Thread.sleep(3000);
		SeleniumTestHelper.Close_OpenedWindow("DO Detail - Distribution Order", driver);
	}

	public void getOLPNdetails() throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, lPNSTab, 50);
		lPNSTab.click();
		Thread.sleep(3000);
		List<WebElement> oLPNS = driver
				.findElements(By.xpath("//span[contains(@id,'LPNListTPM_Link_NameText_param_out')]"));
		List<WebElement> Qty = driver
				.findElements(By.xpath("//span[contains(@id,'CTO_LPNListTPM_LPN_Qty_param_out')]"));
		String[] Qunatity = null;
		for (int i = 0; i < oLPNS.size(); i++) {
			// String oLPNid=oLPNS.get(i).getText();
			// DistributionOrders.setoLPNList(oLPNid);
			Qunatity = Qty.get(i).getText().split("\\s+");
			oLPNSlist_Shippedqty.add(Qunatity[0]);

		}
		Thread.sleep(3000);
		homepage.user_closes_openedwindow("Distribution Orders");
		Thread.sleep(5000);
		SeleniumTestHelper.Close_OpenedWindow("DO Detail - Distribution Order", driver);

	}

	public void getOLPNdetailsfromShipWaveTemplate() throws InterruptedException {
		List<WebElement> oLPNS = driver
				.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_Link_NameText')]"));
		List<WebElement> olpnStatus = driver
				.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_lpnFacilityStatus_param_out')]"));
		List<WebElement> olpnItems = driver
				.findElements(By.xpath("//span[contains(@id,'Case_LPN_With_PO_LPN_POLine_Item')]"));

	}

	public static String shiwaveStatusxpath(String shipwavetemplate) {
		return "//span[contains(text(),'" + shipwavetemplate + "')]//following::td[1]";
	}

	public void user_views_the_packing_slip() throws Throwable {

		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		moreBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ViewPackingSlip, 50);
		SeleniumTestHelper.assertEquals(ViewPackingSlip.isDisplayed(), true);
		ViewPackingSlip.click();
		Thread.sleep(10000);
		SeleniumTestHelper.switchToOtherWindowAndCloseItAndComeBack(driver);

	}

	public WebElement CheckTask(String taskname) {
		WebElement task = driver.findElement(By.xpath("//span[text()='" + taskname + "']"));
		return task;

	}

	public void runWaveTemplateandchecknotasksgenerated(String waveTemplateDesc) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.assertEquals(DOStatus.getText(), "Released");
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		moreBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveOption, 50);
		waveOption.click();
		Thread.sleep(3000);
		homepage.user_closes_openedwindow("Distribution Orders");
		SeleniumTestHelper.switchToInnerFrame(driver);
		driver.findElement(By.xpath("//span[contains(text(),'" + waveTemplateDesc
				+ "') and contains(@id,'wvdesc')]/ancestor::td/preceding-sibling::td[2]")).click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, runWaveBtn, 50);
		runWaveBtn.click();
		submitWaveBtn.click();
		if (SeleniumTestHelper.isElementDisplayed(waveNumber)) {
			waveNumber.click();
			SeleniumTestHelper.switchToInnerFrame(driver);
			String actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
			int count = 0;
			while (!actualStatus.equals("Ship wave completed") && (count != 20)) {
				refreshBtn.click();
				actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
				Thread.sleep(5000);
				count++;
			}
			SeleniumTestHelper.assertEquals(actualStatus, "Ship wave completed");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
			shipWavechkbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
			shipWavemoreBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreLPNS, 50);
			shipWavemoreLPNS.click();
			try {
				if (SeleniumTestHelper.isElementDisplayed(noDataFound)) {
					System.out.println("oLPNS not generated due to insufficient inventory");
					SeleniumTestHelper.assertEquals(noDataFound.isDisplayed(), true);
				}
			} catch (Exception e) {
				System.out.println("oLPNS got generated due to sufficient inventory available for all items");
				SeleniumTestHelper.fail("oLPNS got generated due to sufficient inventory available for all items");
			}

		}
		arrow_Sign.click();
		shipWavechkbox.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
		shipWavemoreBtn.click();
		tasks.click();
		Thread.sleep(3000);
		try {
			if (SeleniumTestHelper.isElementDisplayed(noDataFound)) {
				System.out.println("No tasks generated due to sufficient inventory available for all items");
				SeleniumTestHelper.assertEquals(noDataFound.isDisplayed(), true);
			}
		} catch (Exception e) {
			{
				System.out.println("Tasks got generated due to sufficient inventory available for all items");
				SeleniumTestHelper.fail("Tasks got generated due to sufficient inventory available for all items");
			}
		}
		homepage.user_closes_openedwindow("ShipWaveTemplate - Tasks");
	}

	public void runWaveTemplate_CheckTasksforAmazonOrder(String waveTemplateDesc, String expStatus, String ExpTask)
			throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.assertEquals(DOStatus.getText(), "Released");
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		moreBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveOption, 50);
		waveOption.click();
		Thread.sleep(3000);
		homepage.user_closes_openedwindow("Distribution Orders");
		SeleniumTestHelper.switchToInnerFrame(driver);
		driver.findElement(By.xpath("//span[contains(text(),'" + waveTemplateDesc
				+ "') and contains(@id,'wvdesc')]/ancestor::td/preceding-sibling::td[2]")).click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, runWaveBtn, 50);
		runWaveBtn.click();
		submitWaveBtn.click();
		if (SeleniumTestHelper.isElementDisplayed(waveNumber)) {
			waveNumber.click();
			SeleniumTestHelper.switchToInnerFrame(driver);
			String actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
			int count = 0;
			while (!actualStatus.equals("Ship wave completed") && (count != 20)) {
				refreshBtn.click();
				actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
				Thread.sleep(5000);
				count++;
			}
			SeleniumTestHelper.assertEquals(actualStatus, "Ship wave completed");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
			shipWavechkbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
			shipWavemoreBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreTasks, 50);
			shipWavemoreTasks.click();
			// SeleniumTestHelper.waitForElementToBeDisplayed(driver,
			// Pallet_Pull_from_Reserve, 50);

			Thread.sleep(5000);
			if (SeleniumTestHelper.isElementDisplayed(CheckTask(ExpTask))) {
				System.out.println("Task id generated is " + taskId);
				System.out.println(CheckTask(ExpTask).getText());
				SeleniumTestHelper.assertEquals(CheckTask(ExpTask).getText(), ExpTask);
			}
			Thread.sleep(3000);
			backBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
			shipWavechkbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
			shipWavemoreBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreLPNS, 50);
			shipWavemoreLPNS.click();
			List<WebElement> oLPNS = driver
					.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_Link_NameText')]"));
			List<WebElement> olpnStatus = driver
					.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_lpnFacilityStatus_param_out')]"));
			List<WebElement> olpnItems = driver
					.findElements(By.xpath("//span[contains(@id,'Case_LPN_With_PO_LPN_POLine_Item_param_out1')]"));
			List<WebElement> olpnwithqty = driver
					.findElements(By.xpath("//span[contains(@id,'CTO_LPNListTPM_LPN_Qty_param_out2')]"));

			for (int i = 0; i < olpnStatus.size(); i++) {
				String oLPNSnum = oLPNS.get(i).getText();
				String oLPNSinShipwave = olpnStatus.get(i).getText();
				String[] olpnwithqtydata = olpnwithqty.get(i).getText().split("\\s+");
				DistributionOrders.setoLPNList(oLPNSnum);
				DistributionOrders.setoLPNwithitem(oLPNSnum, olpnItems.get(i).getText());
				DistributionOrders.setoLPNwithQty(oLPNSnum, olpnwithqtydata[0]);
				System.out.println("oLPN  :" + oLPNS.get(i).getText() + "status is :" + oLPNSinShipwave);
				SeleniumTestHelper.assertEquals(oLPNSinShipwave, expStatus);
			}

			backBtn.click();
			shipWavechkbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
			shipWavemoreBtn.click();
			AllocationDetails.click();
			// List<WebElement> reserveoLPN =
			// driver.findElements(By.xpath("//span[text()='Pallet Pull from
			// Reserve']/../preceding-sibling::td//span[contains(@id,'taskIdVal')]"));
			List<WebElement> casepickoLPN = driver.findElements(
					By.xpath("//span[text()='51-Pick from case pick']/../following-sibling::td[3]/span[1]"));
			List<WebElement> ActiveoLPN = driver.findElements(
					By.xpath("//span[contains(text(),'50 - Pick from active')]/../following-sibling::td[3]/span[1]"));

			for (WebElement ele : casepickoLPN) {
				System.out.println("oLPN for case pick -> " + ele.getText());
				DistributionOrders.setoLPNwithCase(ele.getText().trim());

			}
			/*
			 * for(WebElement ele : reserveoLPN){ System.out.println("oLPN for Reserve -> "
			 * + ele.getText());
			 * DistributionOrders.setoLPNwithReserve(ele.getText().trim());
			 * 
			 * 
			 * }
			 */
			for (WebElement ele : ActiveoLPN) {
				System.out.println("oLPN for Active -> " + ele.getText());
				DistributionOrders.setoLPNwithActive(ele.getText().trim());
			}
			Thread.sleep(4000);
			backBtn.click();
		}
		homepage.user_closes_openedwindow("ShipWaveTemplate - Waves");
	}

	public void runWaveTemplate_Check_Replen_Case_Pick_and_Pick_from_case_pick(String waveTemplateDesc,
			String expStatus) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.assertEquals(DOStatus.getText(), "Released");
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		moreBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveOption, 50);
		waveOption.click();
		Thread.sleep(3000);
		homepage.user_closes_openedwindow("Distribution Orders");
		SeleniumTestHelper.switchToInnerFrame(driver);
		driver.findElement(By.xpath("//span[contains(text(),'" + waveTemplateDesc
				+ "') and contains(@id,'wvdesc')]/ancestor::td/preceding-sibling::td[2]")).click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, runWaveBtn, 50);
		runWaveBtn.click();
		submitWaveBtn.click();
		if (SeleniumTestHelper.isElementDisplayed(waveNumber)) {
			waveNumber.click();
			SeleniumTestHelper.switchToInnerFrame(driver);
			String actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
			int count = 0;
			while (!actualStatus.equals("Ship wave completed") && (count != 20)) {
				refreshBtn.click();
				actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
				Thread.sleep(5000);
				count++;
			}
			SeleniumTestHelper.assertEquals(actualStatus, "Ship wave completed");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
			shipWavechkbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
			shipWavemoreBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreTasks, 50);
			shipWavemoreTasks.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, ReplnCasePickfromReserve, 50);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, pickfromCasePick, 50);
			if (SeleniumTestHelper.isElementDisplayed(ReplnCasePickfromReserve)
					&& SeleniumTestHelper.isElementDisplayed(pickfromCasePick)) {
				System.out.println("Task id generated is " + taskId);
				System.out.println(ReplnCasePickfromReserve.getText());
				SeleniumTestHelper.assertEquals(ReplnCasePickfromReserve.getText(), "Replen Case Pick from Reserve");
				SeleniumTestHelper.assertEquals(pickfromCasePick.getText(), "Pick from case pick");
			}

			List<WebElement> reservetaskID = driver.findElements(By.xpath(
					"//span[text()='Replen Case Pick from Reserve']/../preceding-sibling::td//span[contains(@id,'taskIdVal')]"));
			List<WebElement> casepicktaskID = driver.findElements(By.xpath(
					"//span[text()='Pick from case pick']/../preceding-sibling::td//span[contains(@id,'taskIdVal')]"));

			WebElement casePickChkbox;
			WebElement reservePickChkbox;
			List<String> casepickTaskIdStr = new ArrayList<String>();
			List<String> reserveTaskIdStr = new ArrayList<String>();
			for (WebElement ele : casepicktaskID) {
				System.out.println("TaskId for case pick -> " + ele.getText());
				casepickTaskIdStr.add(ele.getText().trim());
			}
			for (WebElement ele : reservetaskID) {
				System.out.println("TaskId for Reserve -> " + ele.getText());
				reserveTaskIdStr.add(ele.getText().trim());
				DistributionOrders.setReplnTasks(ele.getText().trim());

			}

			for (String casePick : casepickTaskIdStr) {

				System.out.println("Inside for loop " + casePick);
				casePickChkbox = driver.findElement(By
						.xpath("//span[text()='" + casePick + "']/../preceding-sibling::td//input[@type='checkbox']"));
				SeleniumTestHelper.waitForElementToBeClickable(driver, casePickChkbox, 50);
				casePickChkbox.click();
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewBtnTasks, 50);
				viewBtnTasks.click();
				DistributionOrders.setoLPNwithCase(oLPNText.getText());
				System.out.println("Case Pick oLPN: " + oLPNText.getText());
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 50);
				backBtn.click();
				Thread.sleep(3000);
				casePickChkbox = null;
			}
			for (String reserve : reserveTaskIdStr) {

				reservePickChkbox = driver.findElement(
						By.xpath("//span[text()='" + reserve + "']/../preceding-sibling::td//input[@type='checkbox']"));
				SeleniumTestHelper.waitForElementToBeClickable(driver, reservePickChkbox, 50);
				reservePickChkbox.click();
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewBtnTasks, 50);
				viewBtnTasks.click();
				DistributionOrders.setoLPNwithReserve(oLPNText.getText());
				System.out.println("Reserve Pick oLPN: " + oLPNText.getText());
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 50);
				backBtn.click();
				Thread.sleep(3000);
				reservePickChkbox = null;
			}

			Thread.sleep(3000);
			backBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
			shipWavechkbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
			shipWavemoreBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreLPNS, 50);
			shipWavemoreLPNS.click();
			Thread.sleep(2000);
			List<WebElement> oLPNS = driver
					.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_Link_NameText')]"));
			List<WebElement> olpnStatus = driver
					.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_lpnFacilityStatus_param_out')]"));
			List<WebElement> olpnItems = driver
					.findElements(By.xpath("//span[contains(@id,'Case_LPN_With_PO_LPN_POLine_Item_param_out1')]"));
			List<WebElement> olpnwithqty = driver
					.findElements(By.xpath("//span[contains(@id,'CTO_LPNListTPM_LPN_Qty_param_out2')]"));
			System.out.println("oLPN status size: " + olpnStatus.size());
			for (int i = 0; i < olpnStatus.size(); i++) {
				String oLPNSnum = oLPNS.get(i).getText();
				String oLPNSinShipwave = olpnStatus.get(i).getText();
				String[] olpnwithqtydata = olpnwithqty.get(i).getText().split("\\s+");
				DistributionOrders.setoLPNList(oLPNSnum);
				DistributionOrders.setoLPNwithitem(oLPNSnum, olpnItems.get(i).getText());
				DistributionOrders.setoLPNwithQty(oLPNSnum, olpnwithqtydata[0]);
				System.out.println("oLPN  :" + oLPNS.get(i).getText() + "status is :" + oLPNSinShipwave);
				SeleniumTestHelper.assertEquals(oLPNSinShipwave, expStatus);
			}
		}
		homepage.user_closes_openedwindow("ShipWaveTemplate - oLPNs");
	}

	public void runWaveTemplate_Check_Replen_to_active(String waveTemplateDesc, String expStatus) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.assertEquals(DOStatus.getText(), "Released");
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		moreBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveOption, 50);
		waveOption.click();
		Thread.sleep(3000);
		homepage.user_closes_openedwindow("Distribution Orders");
		SeleniumTestHelper.switchToInnerFrame(driver);
		driver.findElement(By.xpath("//span[contains(text(),'" + waveTemplateDesc
				+ "') and contains(@id,'wvdesc')]/ancestor::td/preceding-sibling::td[2]")).click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, runWaveBtn, 50);
		runWaveBtn.click();
		submitWaveBtn.click();
		if (SeleniumTestHelper.isElementDisplayed(waveNumber)) {
			waveNumber.click();
			SeleniumTestHelper.switchToInnerFrame(driver);
			String actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
			int count = 0;
			while (!actualStatus.equals("Ship wave completed") && (count != 20)) {
				refreshBtn.click();
				actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
				Thread.sleep(5000);
				count++;
			}
			SeleniumTestHelper.assertEquals(actualStatus, "Ship wave completed");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
			shipWavechkbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
			shipWavemoreBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreTasks, 50);
			shipWavemoreTasks.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, ReplenRetailActivefromCasePick, 50);

			if (SeleniumTestHelper.isElementDisplayed(ReplenRetailActivefromCasePick)) {
				System.out.println("Task id generated is " + taskId);
				System.out.println(ReplenRetailActivefromCasePick.getText());
				SeleniumTestHelper.assertEquals(ReplenRetailActivefromCasePick.getText(),
						"Replen Retail Active from Case pick");

			}

			List<WebElement> replenishtaskID = driver.findElements(By.xpath(
					"//span[text()='Replen Retail Active from Case pick']/../preceding-sibling::td//span[contains(@id,'taskIdVal')]"));
			List<String> replenishTaskIdStr = new ArrayList<String>();

			for (WebElement ele : replenishtaskID) {
				System.out.println("TaskId of Replen Retail Active from CasePick  -> " + ele.getText());
				replenishTaskIdStr.add(ele.getText().trim());
				DistributionOrders.setReplnTasks(ele.getText().trim());

			}

			Thread.sleep(3000);
			backBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
			shipWavechkbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreBtn, 50);
			shipWavemoreBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavemoreLPNS, 50);
			shipWavemoreLPNS.click();
			Thread.sleep(2000);
			List<WebElement> oLPNS = driver
					.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_Link_NameText')]"));
			List<WebElement> olpnStatus = driver
					.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_lpnFacilityStatus_param_out')]"));
			List<WebElement> olpnItems = driver
					.findElements(By.xpath("//span[contains(@id,'Case_LPN_With_PO_LPN_POLine_Item_param_out1')]"));
			List<WebElement> olpnwithqty = driver
					.findElements(By.xpath("//span[contains(@id,'CTO_LPNListTPM_LPN_Qty_param_out2')]"));
			System.out.println("oLPN status size: " + olpnStatus.size());
			for (int i = 0; i < olpnStatus.size(); i++) {
				String oLPNSnum = oLPNS.get(i).getText();
				String oLPNSinShipwave = olpnStatus.get(i).getText();
				String[] olpnwithqtydata = olpnwithqty.get(i).getText().split("\\s+");
				DistributionOrders.setoLPNList(oLPNSnum);
				DistributionOrders.setoLPNwithitem(oLPNSnum, olpnItems.get(i).getText());
				DistributionOrders.setoLPNwithQty(oLPNSnum, olpnwithqtydata[0]);
				System.out.println("oLPN  :" + oLPNS.get(i).getText() + "status is :" + oLPNSinShipwave);
				SeleniumTestHelper.assertEquals(oLPNSinShipwave, expStatus);
			}
		}
		homepage.user_closes_openedwindow("ShipWaveTemplate - oLPNs");
	}

	public void checkTaskstatus(String taskStatus) throws Exception {
		homepage.MenuItems_Configuration_Selection("Tasks");
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < DistributionOrders.replnTasks.size(); i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputTaskID, 50);
			inputTaskID.clear();
			inputTaskID.sendKeys(DistributionOrders.getReplnTasks(i));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyTaskBtn, 50);
			applyTaskBtn.click();
			WebElement statusTask = driver.findElement(By.xpath("//span[contains(@id,'statusVal')]"));
			String taskIDstatus = statusTask.getText();
			SeleniumTestHelper.assertEquals(taskIDstatus, taskStatus);
		}
		homepage.user_closes_openedwindow("Tasks");
	}

	public void verifyDOLineStatusForPackedAndCancelItem(String statusPacked, String statusCancel) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, DOlinesTab, 50);
		DOlinesTab.click();
		SeleniumTestHelper.assertTrue(SeleniumTestHelper
				.isElementDisplayed(driver.findElement(By.xpath("//span[text()='" + statusPacked + "']"))));
		SeleniumTestHelper.assertTrue(SeleniumTestHelper
				.isElementDisplayed(driver.findElement(By.xpath("//span[text()='" + statusCancel + "']"))));
		System.out.println("Status Canceled verified");
		System.out.println("Status Packed verified");
		Thread.sleep(3000);
		homepage.user_closes_openedwindow("Distribution Orders");
		Thread.sleep(3000);
		SeleniumTestHelper.Close_OpenedWindow("DO Detail - Distribution Order", driver);
	}

	public void search_for_DO_with_Fulfillment_status(String fullfulmentsStatus) throws Exception {
		// driver.switchTo().frame(0);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 5);
		primaryField.sendKeys("Fulfillment Status" + Keys.TAB + Keys.TAB);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, statusSearch_inputBox, 5);
		statusSearch_inputBox.click();
		statusSearch_inputBox.sendKeys(fullfulmentsStatus + Keys.ARROW_DOWN + Keys.ARROW_DOWN + Keys.ENTER);
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, first_checkBox, 5);
		first_checkBox.click();
		viewBtn.click();
		driver.switchTo().frame(0);
		shipVia_Value.click();
		DistributionOrders.setDOnumber(DO_ID_value.getText());
		SeleniumTestHelper.assertEquals(DO_FulFill_Status.getText(), fullfulmentsStatus);
		homepage.user_closes_openedwindow("DO Detail - Distribution Order");

	}

	public void toRunWaveTemplate(String waveTemplateDesc) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.assertEquals(DOStatus.getText(), "Released");
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		moreBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveOption, 50);
		waveOption.click();
		Thread.sleep(3000);
		homepage.user_closes_openedwindow("Distribution Orders");
		homepage.openWindows.click();

		List<WebElement> myframes = driver.findElements(By.tagName("Iframe"));
		System.out.println("my framecount is   " + myframes.size());
		SeleniumTestHelper.switchToInnerFrame(driver);
		driver.findElement(By.xpath("//input[@alt='Find Description']")).sendKeys(waveTemplateDesc);
		wavespage.waveNumberApplySearchBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);

		driver.findElement(By.xpath("//span[contains(text(),'" + waveTemplateDesc
				+ "')]/ancestor::td/preceding-sibling::td[2][contains(@class,'checkBox')]")).click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, runWaveBtn, 100);

		runWaveBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, submitWaveBtn, 100);
		submitWaveBtn.click();
		if (SeleniumTestHelper.isElementDisplayed(waveNumber)) {
			String waveNumberValue = waveNumber.getText();
			DistributionOrders.setWaveNumber(waveNumberValue);
			waveNumber.click();
			SeleniumTestHelper.switchToInnerFrame(driver);
			String actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
			int count = 0;
			while (!actualStatus.equals("Ship wave completed") && (count != 20)) {
				refreshBtn.click();
				actualStatus = driver.findElement(By.xpath(shiwaveStatusxpath(waveTemplateDesc))).getText().trim();
				Thread.sleep(5000);
				count++;
			}
			SeleniumTestHelper.assertEquals(actualStatus, "Ship wave completed");
			System.out.println(
					"Status : " + actualStatus + " verified for wave number " + DistributionOrders.getWaveNumber());
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipWavechkbox, 50);
			shipWavechkbox.click();
		}
		homepage.user_closes_openedwindow("ShipWaveTemplate - Waves");
	}

	public void cancelDOAndClickConfirmButton() throws Throwable {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(Items.getDONumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		moreBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, CnclBtn, 50);
		CnclBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, yesBtn, 50);
		yesBtn.click();
		Thread.sleep(3000);
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, rsnCode, 50);
		rsnCode.click();
		String account = ManhattanLoginPage.account;
		if (account.equalsIgnoreCase("QSC") || account.equalsIgnoreCase("@Account")) {
			rsnCode.sendKeys("CP – Cancel Request – Processed Order");
		} else {
			rsnCode.sendKeys("UD - OEM Damage");
		}
		// rsnCode.sendKeys(Keys.TAB);
		SeleniumTestHelper.assertTrue(true);
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeClickable(driver, cnfmBtn, 50);
		cnfmBtn.click();
		homepage.user_closes_openedwindow("Distribution Orders");
	}

	public void verifyDOAndCheckStatus(String expectedDOstatus) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		String actualDOstatus = driver.findElement(By.xpath("//td[@data-columnid='distributionorderID']/div[text()='"
				+ DistributionOrders.getDOnumber() + "']//following::td[1]")).getText();
		SeleniumTestHelper.assertEquals(actualDOstatus, expectedDOstatus);
		homepage.user_closes_openedwindow("Distribution Orders");
	}

	public void cancelDOLine(String expectedDoLineStatus) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, DOlinesTab, 50);
		DOlinesTab.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, doFirstLineChkBox, 50);
		doFirstLineChkBox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, Cancel_Line, 50);
		Cancel_Line.click();
		Thread.sleep(2000);
		String actualDoLineStatus = driver
				.findElement(
						By.xpath("//span[contains(@id,'DODetailsOrderLinelist:0:DODetailOrderLinesList_LineItem')]"))
				.getText();
		SeleniumTestHelper.assertEquals(actualDoLineStatus, expectedDoLineStatus);
		homepage.user_closes_openedwindow("Distribution Orders");
		Thread.sleep(2000);
		SeleniumTestHelper.Close_OpenedWindow("DO Detail - Distribution Order", driver);
	}

	public void printPackingSlipReport() throws Exception {

		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		moreBtn.click();
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeClickable(driver, printPackingSlipReport, 50);
		printPackingSlipReport.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, transactionSuccfulMsg, 50);
		transactionSuccfulMsg.click();
		SeleniumTestHelper.assertEquals(transactionSuccfulMsg.getText(), "Transaction successful.");
		Thread.sleep(2000);
		homepage.user_closes_openedwindow("Distribution Orders");

	}

	public void search_for_DO_with_Fulfillment_EPIDoc(String fullfulmentsStatus) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Fulfillment Status");
		Thread.sleep(3000);
		fulfilmentStatus.click();
		Thread.sleep(1000);
		fulfilmentStatus.sendKeys(fullfulmentsStatus);
		fulfilmentStatus.sendKeys(Keys.ARROW_DOWN);
		fulfilmentStatus.sendKeys(Keys.TAB);
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, first_checkBox, 5);
		first_checkBox.click();
		moreBtn.click();
		SeleniumTestHelper.assertEquals(moreBtn.isDisplayed(), true);
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeClickable(driver, printEpiDoc, 50);
		Thread.sleep(1000);
		printEpiDoc.click();
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, transactionSuccfulMsg, 50);
		SeleniumTestHelper.assertEquals(transactionSuccfulMsg.getText(), "Transaction successful.");
		Thread.sleep(2000);
		homepage.user_closes_openedwindow("Distribution Orders");

	}

	// Ashish

	public void user_views_the_ship_confirm() throws Exception {

		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(Items.getDONumber());
		Screenshots.captureSnapshot(driver);
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		Screenshots.captureSnapshot(driver);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		Screenshots.captureSnapshot(driver);
		moreBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ViewShipConfirm, 50);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.assertEquals(ViewShipConfirm.isDisplayed(), true);
		ViewShipConfirm.click();
		Thread.sleep(5000);
		Screenshots.captureSnapshot(driver);

		/*
		 * if() { SeleniumTestHelper.switchToInnerFrame(driver);
		 * Assert.assertEquals(driver.findElement(By.className("overlayerrorList")).
		 * getText(),"Pulled Quantity Exceeds Allocated Quantity!"
		 * ,"values expected and actual");
		 * Reporter.addStepLog("Pulled Quantity Exceeds Allocated Quantity!");
		 * Steps.logger.info("Pulled Quantity Exceeds Allocated Quantity!"); } else {
		 */
		ConfirmationYes.click();
		// }
		Thread.sleep(5000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.assertEquals(fullfilmentStatusShipped.isDisplayed(), true);
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("DO was shipped successfully");
		Reporter.addStepLog("DO was shipped successfully");
		homepage.user_closes_openedwindow("Distribution Orders");
	}

	public void storeDO_PO_oLPN_numbersForDFill(String FulFilmentStatus) throws Exception {

		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 50);
		primaryField.sendKeys("Fulfillment Status");
		Thread.sleep(1000);
		fulfilmentStatus.click();
		Thread.sleep(1000);
		System.out.println("FulFillment Status is " + FulFilmentStatus);
		fulfilmentStatus.sendKeys(FulFilmentStatus);
		fulfilmentStatus.sendKeys(Keys.ARROW_DOWN);
		fulfilmentStatus.sendKeys(Keys.TAB);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstOptionalFieldCondition, 50);
		firstOptionalFieldCondition.sendKeys("Order Type");
		fulfilmentStatus.sendKeys(Keys.ARROW_DOWN);
		fulfilmentStatus.sendKeys(Keys.TAB);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstOptionalFieldStatusValue, 50);
		firstOptionalFieldStatusValue.sendKeys("DFILL");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, addCondition, 50);
		addCondition.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, secondOptionalFieldCondition, 50);
		secondOptionalFieldCondition.sendKeys("External SO / PO");
		secondOptionalFieldCondition.sendKeys(Keys.TAB);
		secondOptionalFieldCondition.sendKeys(Keys.TAB);
		secondOptionalFieldStatusValue.sendKeys("*");
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		DistributionOrders.setDOnumber(orderID.getText());
		System.out.println("DO Order ID is  " + DistributionOrders.getDOnumber());
		SeleniumTestHelper.waitForElementToBeClickable(driver, DOlinesTab, 50);
		DOlinesTab.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemNumber, 50);
		DistributionOrders.setProductsForDistOrder(itemNumber.getText());
		System.out.println("Item is  " + DistributionOrders.getProductsForDistOrder(0));
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstLineItemCheckBx, 50);
		firstLineItemCheckBx.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewLineBtn, 50);
		viewLineBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, externalPurchaseOrderID, 50);
		DistributionOrders.setLineItemWithPO(DistributionOrders.getProductsForDistOrder(0),
				externalPurchaseOrderID.getText());
		System.out.println("External PO is  "
				+ DistributionOrders.getLineItemWithPO(DistributionOrders.getProductsForDistOrder(0)));
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 50);
		backBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, lPNSTab, 50);
		lPNSTab.click();
		Thread.sleep(2000);
		List<WebElement> oLPNS = driver
				.findElements(By.xpath("//span[contains(@id,'LPNListTPM_Link_NameText_param_out')]"));
		DistributionOrders.setoLPNwithActive(oLPNS.get(0).getText());
		System.out.println("oLPN is " + DistributionOrders.getoLPNwithActive(0));
		Thread.sleep(2000);
		homepage.user_closes_openedwindow("Distribution Orders");
		Thread.sleep(2000);
		SeleniumTestHelper.Close_OpenedWindow("DO Detail - Distribution Order", driver);
	}

	public void getDOStatus(String expectedDOstatus) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		distributionOrderID.sendKeys(DistributionOrders.getDOnumber());
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		String actualDOstatus = driver.findElement(By.xpath("//td[@data-columnid='distributionorderID']/div[text()='"
				+ DistributionOrders.getDOnumber() + "']//following::td[1]")).getText();
		SeleniumTestHelper.assertEquals(actualDOstatus, expectedDOstatus);

	}

	// jaya
	public void fetchoLPNSnumberwith30weighed() throws Exception {

		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		System.out.println("DISTRIBUTION");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		System.out.println("sendkeys");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		System.out.println("click");

		distributionOrderID.sendKeys(Items.getDONumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		homepage.user_closes_openedwindow("Distribution Orders");
		homepage.openWindows.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, lPNSTab, 50);
		lPNSTab.click();
		// To locate table.
		Thread.sleep(5000);
		WebElement mytable = driver
				.findElement(By.xpath("//*[@id=\"dataForm:DODetailsLpnList_lv:LPNListTable_body\"]"));
		System.out.println("table");
		// To locate rows of table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate no of rows In table.
		int rows_count = rows_table.size();
		System.out.println("No of Rows ::" + rows_count);
		System.out.println("no of rows");
		// Loop will execute till the last row of table.
		for (int row = 0; row < rows_count - 1; row++) {
			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			System.out.println("getrows::" + Columns_row.size());
			String oLPN = Columns_row.get(1).getText();
			String oLPNStatus = Columns_row.get(8).getText();
			System.out.println(oLPNStatus);
			if(Columns_row.get(8).getText().equals("30 - Weighed") || Columns_row.get(8).getText().equals("30 - Weighed")) {
				System.out.println("OLPNStatus"+oLPNStatus);
				Items.setoLPN(oLPN);
				System.out.println(Items.getoLPNListSize());
				//System.out.println("oLPN : "+"i: "+Items.getoLPN(row));
			}
		}
		homepage.user_closes_openedwindow("DO Detail - Distribution Order");
	}

	public void fetchoLPNSnumber() throws Exception {
		System.out.println("Fetch OLPN -");
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		System.out.println("DISTRIBUTION");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		System.out.println("sendkeys");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		System.out.println("click");

		distributionOrderID.sendKeys(Items.getDONumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		homepage.user_closes_openedwindow("Distribution Orders");
		homepage.openWindows.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, lPNSTab, 50);
		lPNSTab.click();
		// To locate table.
		Thread.sleep(5000);
		WebElement mytable = driver
				.findElement(By.xpath("//*[@id=\"dataForm:DODetailsLpnList_lv:LPNListTable_body\"]"));
		System.out.println("table");
		// To locate rows of table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate no of rows In table.
		int rows_count = rows_table.size();
		System.out.println("No of Rows ::" + rows_count);
		System.out.println("no of rows");
		// Loop will execute till the last row of table.
		for (int row = 0; row < rows_count - 1; row++) {
			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			System.out.println("getrows::" + Columns_row.size());
			String oLPN = Columns_row.get(1).getText();
			String oLPNStatus = Columns_row.get(8).getText();
			String oLPNQty = Columns_row.get(6).getText();
			String qty[] = oLPNQty.split(" ");
			Items.setoLPN(oLPN);
			Items.setoLPNStatus(oLPNStatus);
			Items.setoLPNQty(qty[0]);
			System.out.println(Items.getoLPN(row));
			System.out.println(Items.getoLPNStatus(row));
			System.out.println(Items.getoLPNQty(row));
		}
		homepage.user_closes_openedwindow("DO Detail - Distribution Order");
	}

	public void checksplittedoLPNandquantity() throws Exception {

		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		System.out.println("DISTRIBUTION");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		System.out.println("sendkeys");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		System.out.println("click");

		distributionOrderID.sendKeys(Items.getDONumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		homepage.user_closes_openedwindow("Distribution Orders");
		homepage.openWindows.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, lPNSTab, 50);
		lPNSTab.click();

		Thread.sleep(5000);
		// To locate the table
		WebElement mytable = driver.findElement(By.xpath("//*[@id='dataForm:DODetailsLpnList_lv:LPNListTable_body']"));

		System.out.println("table");
		// To locate rows of table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate no of rows In table.
		int rows_count = rows_table.size();
		System.out.println("No of Rows ::" + rows_count);
		System.out.println("no of rows");

		boolean olpnExist = false;
		for (int row = 0; row < rows_count - 1; row++) {
			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			String oLPN = Columns_row.get(1).getText();
			String oLPNqty = Columns_row.get(6).getText();
			String[] qty = oLPNqty.split(" ");
			System.out.println("oLPN: " + oLPN);
			System.out.println("oLPN qty: " + qty[0]);

			if (oLPN.equals(RFMenuPage.splittedolpn)) {
				SeleniumTestHelper.assertEquals(qty[0], Steps.ItemDataMap.get(0).get("SplitoLPNQty"), "Splitted Qty");
				olpnExist = true;
				break;
			}

			/*
			 * if (celtext != null && celtext1 != null && celtext.equals(splitToOLPN) &&
			 * celtext1.contains(Steps.ItemDataMap.get(0).get("SplitoLPNQty"))) {
			 * SeleniumTestHelper.assertEquals(celtext, splitToOLPN, "OLPN number");
			 * SeleniumTestHelper.assertEquals(qty[0],
			 * Steps.ItemDataMap.get(0).get("SplitoLPNQty"), "split QTY Number"); }
			 */
		}

		if (olpnExist) {
			Steps.logger.info("New oLPN " + RFMenuPage.splittedolpn + " is created with splitted qty "
					+ Steps.ItemDataMap.get(0).get("SplitoLPNQty"));
			Reporter.addStepLog("New oLPN " + RFMenuPage.splittedolpn + " is created with splitted qty "
					+ Steps.ItemDataMap.get(0).get("SplitoLPNQty"));
		} else {
			Steps.logger.info("oLPN does not exist in DO");
			Steps.testRes = "Failed";
			Assert.assertTrue(false);
		}

	}

	public void checkcombineoLPNandquantity() throws Exception {

		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		System.out.println("DISTRIBUTION");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		System.out.println("sendkeys");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		System.out.println("click");

		distributionOrderID.sendKeys(Items.getDONumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		homepage.user_closes_openedwindow("Distribution Orders");
		homepage.openWindows.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, lPNSTab, 50);
		lPNSTab.click();

		Thread.sleep(5000);
		// To locate the table
		WebElement mytable = driver.findElement(By.xpath("//*[@id='dataForm:DODetailsLpnList_lv:LPNListTable_body']"));

		System.out.println("table");
		// To locate rows of table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate no of rows In table.
		int rows_count = rows_table.size();
		System.out.println("No of Rows ::" + rows_count);
		System.out.println("no of rows");

		System.out.println("CmbneOLPNQty " + Steps.ItemDataMap.get(0).get("CmbneOLPNQty"));
		System.out.println("CombineToOLPN " + Items.getoLPN(1));
		int counter;
		for (int row = 0; row < rows_count - 1; row++) {
			 counter = 0;
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			String oLPN = Columns_row.get(1).getText();
			String oLPNqty = Columns_row.get(6).getText();
			String[] qty = oLPNqty.split(" ");
			System.out.println("oLPN: " + oLPN);
			System.out.println("oLPN qty:" + qty[0]);
			if (oLPN.equals(Items.getoLPN(counter))) {
				int decqty = (Integer.parseInt(Items.getoLPNQty(counter))
						- Integer.parseInt(Steps.ItemDataMap.get(0).get("CmbneOLPNQty")));
				System.out.println(decqty);
				SeleniumTestHelper.assertEquals(qty[0], String.valueOf(decqty), "Splitted Qty");
				Steps.logger.info(Steps.ItemDataMap.get(0).get("CmbneOLPNQty")+" qty is decreased from oLPN "+oLPN);
				Reporter.addStepLog(Steps.ItemDataMap.get(0).get("CmbneOLPNQty")+" qty is decreased from oLPN "+oLPN);
			} else if (oLPN.equals((Items.getoLPN(counter+1)))) {
				int incqty = Integer.parseInt(Items.getoLPNQty(counter+1))
						+ Integer.parseInt(Steps.ItemDataMap.get(0).get("CmbneOLPNQty"));
				SeleniumTestHelper.assertEquals(qty[0], String.valueOf(incqty), "Splitted Qty");
				Steps.logger.info(Steps.ItemDataMap.get(0).get("CmbneOLPNQty")+" qty is increased to oLPN "+oLPN);
				Reporter.addStepLog(Steps.ItemDataMap.get(0).get("CmbneOLPNQty")+" qty is increased to oLPN "+oLPN);
			}
			/*
			 * if (celtext != null && celtext1 != null && celtext.equals(splitToOLPN) &&
			 * celtext1.contains(Steps.ItemDataMap.get(0).get("CmbneOLPNQty"))) {
			 * 
			 * SeleniumTestHelper.assertEquals(celtext, Items.getoLPN(1), "OLPN number");
			 * SeleniumTestHelper.assertEquals(qty[0],
			 * Steps.ItemDataMap.get(0).get("CmbneOLPNQty"), "CmbneOLPNQty"); }
			 */
		}
	}
	public void cancelDO() throws Exception {
	homepage.MenuItems_Distribution_Selection("Distribution Orders");
	SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
	primaryField.sendKeys("Distribution Order");
	Screenshots.captureSnapshot(driver);
	SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
	distributionOrderID.click();
	distributionOrderID.sendKeys(Items.getDONumber());
	Screenshots.captureSnapshot(driver);
	apply_Btn.click();
	SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
	Screenshots.captureSnapshot(driver);
	distributionOrder_chkbox.click();
	SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
	Screenshots.captureSnapshot(driver);
	moreBtn.click();
	SeleniumTestHelper.waitForElementToBeDisplayed(driver, ViewShipConfirm, 50);
	Screenshots.captureSnapshot(driver);
	SeleniumTestHelper.assertEquals(CnclBtn.isDisplayed(), true);
	CnclBtn.click();
	Thread.sleep(5000);
	Screenshots.captureSnapshot(driver);
	}
	
	public void retrieveSplittedToOLPN() throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		System.out.println("DISTRIBUTION");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		primaryField.sendKeys("Distribution Order");
		System.out.println("sendkeys");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrderID, 50);
		distributionOrderID.click();
		System.out.println("click");

		distributionOrderID.sendKeys(Items.getDONumber()); // DistributionOrders.getDOnumber()
		apply_Btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
		viewBtn.click();
		homepage.user_closes_openedwindow("Distribution Orders");
		homepage.openWindows.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, lPNSTab, 50);
		lPNSTab.click();
		// To locate table.
		Thread.sleep(5000);
		WebElement mytable = driver
				.findElement(By.xpath("//*[@id=\"dataForm:DODetailsLpnList_lv:LPNListTable_body\"]"));
		System.out.println("table");
		// To locate rows of table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate no of rows In table.
		int rows_count = rows_table.size();
		System.out.println("No of Rows ::" + rows_count);
		System.out.println("no of rows");
		// Loop will execute till the last row of table.
		for (int row = 0; row < rows_count - 1; row++) {
			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			System.out.println("getrows::" + Columns_row.size());
			String oLPN = Columns_row.get(1).getText();
			String oLPNStatus = Columns_row.get(8).getText();
			String oLPNQty = Columns_row.get(6).getText();
			String qty[] = oLPNQty.split(" ");
			Items.setoLPN(oLPN);
			Items.setoLPNStatus(oLPNStatus);
			Items.setoLPNQty(qty[0]);
			System.out.println(Items.getoLPN(row));
			System.out.println(Items.getoLPNStatus(row));
			System.out.println(Items.getoLPNQty(row));
			if (oLPN.equals(RFMenuPage.splittedolpn)) {
				DistributionOrders.setoLPNList(oLPN);
				System.out.println("oLPN list :" + DistributionOrders.oLPNList);
				System.out.println("size of oLPN list :" + DistributionOrders.oLPNList.size());
				System.out.println("Splitted to oLPN :" + DistributionOrders.oLPNList.get(0));
			} else if (oLPNStatus.equals("20 - Packed")) {
				DistributionOrders.setoLPNList(oLPN);
				System.out.println("oLPN list :" + DistributionOrders.oLPNList);
				System.out.println("size of oLPN list :" + DistributionOrders.oLPNList.size());
				System.out.println("Splitted to oLPN :" + DistributionOrders.oLPNList.get(0));
			}
		}
		homepage.user_closes_openedwindow("DO Detail - Distribution Order");
	}
	
	public void getDOStatusUsingFulfillment(String status) throws Exception {
		homepage.MenuItems_Distribution_Selection("Distribution Orders");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 80);
		Screenshots.captureSnapshot(driver);
		primaryField.sendKeys("Fulfillment Status");
		primaryField.sendKeys(Keys.ENTER);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryFieldStatus, 80);
		primaryFieldStatus.sendKeys("110 - Released");
		primaryFieldStatus.sendKeys(Keys.ENTER);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, optionalField, 80);
		optionalField.sendKeys("External SO / PO");
		optionalField.sendKeys(Keys.ENTER);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, optionalFieldInputText, 50);
		System.out.println(Items.getDONumber());
		optionalFieldInputText.sendKeys(Items.getDONumber());
		Screenshots.captureSnapshot(driver);
		apply_Btn.click();
		System.out.println("clicked");
		// SeleniumTestHelper.waitForElementToBeDisplayed(driver,
		// distributionOrder_chkbox, 50);
		Screenshots.captureSnapshot(driver);
		// WebElement actualDOstatus =
		// driver.findElement(By.xpath("//td[@data-columnid='distributionorderID']/div[text()='"
		// + Items.getDONumber() + "']//following::td[1]"));
		int temp = 0;
		while (!SeleniumTestHelper.isElementDisplayed(distributionOrder_chkbox) && (temp != 10)) {
			apply_Btn.click();
			Thread.sleep(3000);
			temp++;
		}

		if (SeleniumTestHelper.isElementDisplayed(distributionOrder_chkbox)) {
			Reporter.addStepLog("DO is created");
			Assert.assertTrue(true);
		} else {
			Reporter.addStepLog("DO is not created");
			Assert.assertTrue(false);
		}

		String actualDONumber = driver
				.findElement(By.xpath("//td[@data-columnid='distributionorderID']/div[contains(text(),'')]")).getText();
		System.out.println("actual do number" + actualDONumber);
		Items.setDONumber(actualDONumber);
		System.out.println("New DO Number is" + Items.getDONumber());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		Screenshots.captureSnapshot(driver);
		String actualDOstatus = driver.findElement(By.xpath("//td[@data-columnid='distributionorderID']/div[text()='"
				+ Items.getDONumber() + "']//following::td[1]")).getText();
		SeleniumTestHelper.assertEquals(actualDOstatus, status);
		Reporter.addStepLog("DO Order status:" + actualDOstatus);
		Steps.logger.info("DO Order status:" + actualDOstatus);
		Thread.sleep(2000);

		homepage.user_closes_openedwindow("Distribution Orders");

	}

}
