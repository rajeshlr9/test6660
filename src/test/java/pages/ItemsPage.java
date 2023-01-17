package pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import entity.TestDataCreation;
import globalFunc.Screenshots;
import reusable.KelliPages;
import utils.Driver;
import utils.SeleniumTestHelper;
import utils.TestStubReader;

public class ItemsPage {
	WebDriver driver;
	
	public ItemsPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	String slotMiscellaneous4 = null;
	String slotMiscellaneous2 = null;
	String slotMiscellaneous1 = null;
	String serialNumberFlag=null;
	String serialNumber1=null;
	//TestStubReader stubReader = new TestStubReader();
	public static HashMap<String, String> putawayType=new HashMap<String,String>();

	@FindBy(xpath = "//input[contains(@id,'itemLookUpId')]")
	public WebElement itemNumber;
	@FindBy(xpath = "//input[contains(@id,'ItemList_filterIdapply')]")
	public WebElement itemApplyButton;
	@FindBy(xpath = "//td[@class='tbl_checkBox advtbl_col advtbl_body_col']//input[@type='checkbox']")
	public WebElement itemCheckbox;
	@FindBy(id = "dataForm:ItemList_Viewbutton")
	public WebElement viewButton;
	@FindBy(xpath = "//input[contains(@id,'Viewbutton')]")
	public WebElement viewButtonItemFaclilities;
	@FindBy(xpath = "//input[@id='dataForm:ItemFacilityList_Viewbutton']")
	public WebElement FacilityButton;
	@FindBy(xpath = "//a[text()='Warehouse']")
	public WebElement warehouseTab;
	@FindBy(xpath = "//input[@name='checkAll_c0_dataForm:ItemFacilityList_lv:dataTable']")
	public WebElement itemFacilityCheckbox;
	@FindBy(xpath = "//input[@id='dataForm:ItemFacilityList_Viewbutton']")
	public WebElement viewItemFacility;
	@FindBy(xpath = "//input[@id='dataForm:ItemDetailsMain_Return_button_2']")
	public WebElement returnButton;
	@FindBy(xpath = "//span[contains(@id,'itemList_Link_NameText')]")
	public WebElement itemName;
	@FindBy(xpath = "(//span[text()='Unit weight:']/../following-sibling::td[1]//span)[1]")
	public WebElement unitWeight;
	@FindBy(xpath = "//a[@data-qtip='Open Windows']")
	public WebElement OpenWindows;
	@FindBy(xpath = "//input[@value='Item Facility']")
	public WebElement itemFacilityBtn;
	@FindBy(xpath = "//span[text()='Miscellaneous 1:']/following::span[2]")
	public WebElement Misc1text;
	@FindBy(xpath = "//span[text()='Miscellaneous 2:']/following::span[2]")
	public WebElement Misc2text;
	@FindBy(xpath = "//span[text()='Miscellaneous 4:']/following::span[2]")
	public WebElement Misc4text;
	@FindBy(xpath = "//span[text()='Unit width:']/../following-sibling::td[1]//span")
	public WebElement unitWidth;
	@FindBy(xpath = "//span[text()='Unit length:']/../following-sibling::td[1]//span")
	public WebElement unitLength;
	@FindBy(xpath = "//span[text()='Unit height:']/../following-sibling::td[1]//span")
	public WebElement unitHeight;
	@FindBy(xpath = "//span[@id='dataForm:ItemWmosEV_SOMSrlNbrReqd_outText']")
	public WebElement SrlNumberReqd;
	@FindBy(xpath="//span[contains(@id,'ItemList_desc_txt2')]")
	public WebElement itemDescription;
	@FindBy(xpath="//td[@class='tbl_checkBox advtbl_col advtbl_body_col']//input[@type='checkbox']")
	public WebElement Item_chkbox;
	@FindBy(xpath="//input[contains(@id,'itemLookUpId')]")
	public WebElement Item_lookup;
	@FindBy(xpath="//input[contains(@id,'ItemList_filterIdapply')]")
	public WebElement Item_Filter_apply;
	@FindBy(xpath="//span[contains(@id,'itemList_Link_NameText')]")
	public WebElement Item_name;
	@FindBy(xpath="//input[contains(@id,'dataForm:ItemList_Editbutton')]")
	public WebElement Items_Edit_btn;
	@FindBy(xpath="//input[contains(@id,'ITUnitLength')]")
	public WebElement UnitLength;
	@FindBy(xpath="//input[contains(@id,'ITUnitWidth')]") 
	public WebElement UnitWidth;
	@FindBy(xpath="//input[contains(@id,'ITUnitHeight')]") 
	public WebElement UnitHeight;
	@FindBy(id="dataForm:ItemDetailsMain_Save_Detail_button")
	public WebElement Save_btn;
	@FindBy(id="//input[contains(@id,'ITItemBarCode')]")
	public WebElement ITItemBarCode;
	@FindBy(xpath="//span[contains(@id,'ItemList_CubiscanLastUpdatedOn_txt2')]")
	public WebElement cubiscanDate;
	@FindBy(xpath="//select[@id='dataForm:ItemDetailsEditView_SOMProductType']")
	public WebElement prodType;
	@FindBy(xpath="//img[@id='backImage']")
	public WebElement backBtn;
	@FindBy(xpath="//input[@id='dataForm:ItemList_lv:dataTable:pager:ajaxCntQueryImg']")
	public WebElement itemcountinSearch;
	@FindBy(xpath="//a[@id='Item_Package_Tab_lnk']") public WebElement packageTab;
	@FindBy(xpath="//input[@id='dataForm:ItemDetailsMain_Edit_button']") public WebElement editBtnPackageTab;
	@FindBy(xpath="//input[@id='dataForm:ItemPackageListEV_addbutton']") public WebElement addBtnPackageType;
	@FindBy(xpath="//input[@id='dataForm:ItemPackageListEV_dataTable:newRow_1:ItemPackageListEV_inputMask_PackageQty']")
	public WebElement QTY_Base_UOM_package_Tab;
	
	@FindBy(xpath="//input[@id='dataForm:ItemPackageListEV_dataTable:newRow_2:ItemPackageListEV_inputMask_PackageQty']")
	public WebElement second_QTY_Base_UOM_package_Tab;
	
	@FindBy(xpath="//select[@id='dataForm:ItemPackageListEV_dataTable:newRow_1:ItemPackageListEV_PackageUOM_Sel_Menu']")
	public WebElement packageUOMDdl;
	@FindBy(xpath="//select[@id='dataForm:ItemPackageListEV_dataTable:newRow_2:ItemPackageListEV_PackageUOM_Sel_Menu']")
	public WebElement second_packageUOMDdl;
	
	@FindBy(xpath="//input[@id='dataForm:ItemPackageListEV_dataTable:newRow_1:ItemPackageListEV_StdPackage_Sbc']")
	public WebElement statndartPackageCheckBox;
	
	@FindBy(xpath="//input[@id='dataForm:ItemPackageListEV_dataTable:newRow_2:ItemPackageListEV_StdPackage_Sbc']")
	public WebElement second_statndartPackageCheckBox;
	
	@FindBy(xpath="//img[@id='dataForm:ItemPackageListEV_dataTable:0:ItemPackageListEV_StdPackage_icon']")
	public WebElement checkBoxImage;
	
	@FindBy(xpath="//span[@id='dataForm:ItemWmosEV_SOMSrlNbrReqd_outText']")
	public WebElement srlNumType;
	
	@FindBy(xpath="//select[@id='dataForm:ItemWmosEV_SOMVolatilityCode']")
	public WebElement velocityCodeDropDown;
	@FindBy(xpath="//span[text()='Serial nbr required?:']/following::select[1]")
	public WebElement serialNumberDDN;

	@FindBy (xpath="//select[@id='dataForm:ItemDetailsEditView_SOMDimensionUOM']")
	public WebElement Dimension_UOM;
	
	@FindBy (xpath="//span[text()='Putaway type:']/../following-sibling::td[1]//span")
	public WebElement putawayTypeAttribute;
	
	HomePage homePage = new HomePage();

	public void user_opens_ItemsUI_and_verify_item_Attributes(int noOfItems, String serialNumber,
			String SlotMiscellaneous1, String SlotMiscellaneous2, String SlotMiscellaneous4)
			throws Exception {
		for (int i = 1; i <= noOfItems; i++) {
			homePage.MenuItems_Configuration_Selection("Items");
			
			SeleniumTestHelper.switchToInnerFrame(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemNumber, 50);
			
			System.out.println("item name is :" + Items.getItemnameList(i - 1));
			String itemname = Items.getItemnameList(i - 1);
			itemNumber.sendKeys(itemname);
			itemApplyButton.click();
			System.out.println("item name is :" + itemNumber);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemCheckbox, 50);
			itemCheckbox.click();
			viewButton.click();
			SeleniumTestHelper.assertTrue(unitWeight.getText().equals(""));
			SeleniumTestHelper.assertTrue(unitWidth.getText().equals(""));
			SeleniumTestHelper.assertTrue(unitLength.getText().equals(""));
			SeleniumTestHelper.assertTrue(unitHeight.getText().equals(""));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, warehouseTab, 50);
			warehouseTab.click();
			warehouseTab.click();
			
			/*JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", SrlNumberReqd);*/
			
			for(int j=0;j<=1;j++) {
			
				warehouseTab.sendKeys(Keys.PAGE_DOWN);
			}
			
			
			
			serialNumber1=serialNumber.split("/")[i-1];
			
			if (serialNumber1.equalsIgnoreCase("yes")) {
				
				serialNumberFlag="Track sns for OB only";
			    SeleniumTestHelper.assertEquals(SrlNumberReqd.getText(), serialNumberFlag);
				System.out.println("Serial Number flag is :" +serialNumberFlag);
					
			}
			
			else if(serialNumber1.equalsIgnoreCase("no")){
				
				serialNumberFlag="Don't track sns for item";
				SeleniumTestHelper.assertEquals(SrlNumberReqd.getText(), serialNumberFlag);
				System.out.println("Serial Number flag is :" +serialNumberFlag);
			}
			
			itemFacilityBtn.click();
			itemCheckbox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewButtonItemFaclilities, 50);
			viewButtonItemFaclilities.click();
String slotMiscellaneous1= SlotMiscellaneous1.split("/")[i-1];
			
			SeleniumTestHelper.assertEquals(Misc1text.getText(),slotMiscellaneous1);
			System.out.println("Misc 1 verified sucessfully");
			
			if (SlotMiscellaneous2.trim().equals("/")) {
				slotMiscellaneous2 = "";

			}

			else{
               slotMiscellaneous2= SlotMiscellaneous2.split("/")[i-1];
			}
			
			
             
			
			SeleniumTestHelper.assertEquals(Misc2text.getText(),slotMiscellaneous2);
			System.out.println("Misc 2 verified sucessfully");
			
			if (SlotMiscellaneous4.trim().equals("/")) {
				slotMiscellaneous4 = "";

			}

			else{
           slotMiscellaneous4= SlotMiscellaneous4.split("/")[i-1];
			}
			
			SeleniumTestHelper.assertEquals(Misc4text.getText(),slotMiscellaneous4);
			System.out.println("Misc 4 verified sucessfully");
			
			driver.switchTo().defaultContent();
			OpenWindows.click();
			SeleniumTestHelper.Close_OpenedWindow("Items - View Item Facility", driver);

		}

	}
	
	public void verify_Items_description(int noOfItems,String ItemDescription) throws Exception
	{
		homePage.MenuItems_Configuration_Selection("Items");
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 1; i <= noOfItems; i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemNumber, 50);
			System.out.println("item name is :" + Items.getItemnameList(i - 1));
			String itemname = Items.getItemnameList(i - 1);
			itemNumber.clear();
			itemNumber.sendKeys(itemname);
			itemApplyButton.click();
			System.out.println("item name is :" + itemNumber);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemCheckbox, 50);
			String itemDesc=itemDescription.getText();
			SeleniumTestHelper.assertEquals(itemDesc, ItemDescription);
		}
		homePage.userClosesOpenedwindow("Items");
	
	}
	public void verify_Items_creation() throws Exception
	{
		homePage.MenuItems_Configuration_Selection("Items");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < KelliPages.itemList.size(); i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemNumber, 50);
			System.out.println("item name is :" + KelliPages.itemList.get(i));
			String itemname = KelliPages.itemList.get(i);
			itemNumber.clear();
			itemNumber.sendKeys(itemname);
			Screenshots.captureSnapshot(driver);
			itemApplyButton.click();
			Thread.sleep(2000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemCheckbox, 50);
			Screenshots.captureSnapshot(driver);
			String Actualitem=itemName.getText();
			SeleniumTestHelper.assertEquals(Actualitem, itemname);
			Reporter.addStepLog("Item created successfully-"+Actualitem);
		}
		homePage.userClosesOpenedwindow("Items");
	
	}
	
	public void Update_Item_manually(String Length,String Width, String height) throws InterruptedException
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, UnitLength, 50);
		UnitLength.clear();
		UnitLength.sendKeys(Length);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, UnitWidth, 50);
		UnitWidth.clear();
		UnitWidth.sendKeys(Width);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, UnitHeight, 50);
		UnitHeight.clear();
		SeleniumTestHelper.assertTrue(Save_btn.isDisplayed());
		UnitHeight.sendKeys(height);
		Save_btn.click();
		Thread.sleep(4000);
	}
	public void verify_Cubiscanentry(String ItemName) throws Exception
	{
		homePage.MenuItems_Configuration_Selection("Items");
		SeleniumTestHelper.switchToInnerFrame(driver);
		
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemNumber, 50);
			itemNumber.clear();
			itemNumber.sendKeys(ItemName);
			itemApplyButton.click();
			System.out.println("item name is :" + ItemName);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemCheckbox, 50);
			String cubiscandate=cubiscanDate.getText();
			System.out.println("cubiscan is "+cubiscandate);
			if(cubiscandate.equalsIgnoreCase(""))
			{
				System.out.println("cubiscan is not done");
			}
			else
			{
				System.out.println("cubiscan is done successfully for Item "+ItemName);
				SeleniumTestHelper.assertEquals(itemNumber.isDisplayed(), true);
			}	
		homePage.userClosesOpenedwindow("Items");
	
	}
	public void verify_CubiscanentryforTestDataCreation() throws Exception
	{
		homePage.MenuItems_Configuration_Selection("Items");
		SeleniumTestHelper.switchToInnerFrame(driver);
		
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemNumber, 50);
			for(int j=0;j< TestDataCreation.ItemNames.size();j++)
			{
			itemNumber.clear();
			itemNumber.sendKeys(TestDataCreation.ItemNames.get(j));
			itemApplyButton.click();
			System.out.println("item name is :" + TestDataCreation.ItemNames.get(j));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemCheckbox, 50);
			String cubiscandate=cubiscanDate.getText();
			System.out.println("cubiscan is "+cubiscandate);
			if(cubiscandate.equalsIgnoreCase(""))
			{
				System.out.println("cubiscan is not done");
			}
			else
			{
				System.out.println("cubiscan is done successfully for Item "+TestDataCreation.ItemNames.get(j));
				SeleniumTestHelper.assertEquals(itemNumber.isDisplayed(), true);
			}
			Thread.sleep(3000);
			}
		homePage.userClosesOpenedwindow("Items");
	
	}
	
	public void user_opens_ItemsUI_and_get_putaway_AttributesValues(String ItemName) throws Exception {
		try {
		System.out.println("Inside user_opens_ItemsUI_and_get_putaway_AttributesValues");

		homePage.MenuItems_Configuration_Selection("Items");

		SeleniumTestHelper.switchToInnerFrame(driver);
		
		
		
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemNumber, 50);

		itemNumber.clear();
		itemNumber.sendKeys(ItemName);
		itemApplyButton.click();
		
		System.out.println("item name is :" + ItemName);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemCheckbox, 50);
		itemCheckbox.click();
		viewButton.click();

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, warehouseTab, 50);
		warehouseTab.click();
		warehouseTab.click();

		/*
		 * JavascriptExecutor jse = (JavascriptExecutor) driver;
		 * jse.executeScript("arguments[0].scrollIntoView();", SrlNumberReqd);
		 */

		for (int j = 0; j <= 1; j++) {

			warehouseTab.sendKeys(Keys.PAGE_DOWN);
		}

		itemFacilityBtn.click();
		itemCheckbox.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewButtonItemFaclilities, 50);
		viewButtonItemFaclilities.click();

		if (SeleniumTestHelper.isElementDisplayed(putawayTypeAttribute)) {
			putawayType.put(ItemName,putawayTypeAttribute.getText().trim());
			System.out.println(putawayType);
			ItemsPage.setPutawayType(putawayType);
		}

		driver.switchTo().defaultContent();
		OpenWindows.click();
		SeleniumTestHelper.Close_OpenedWindow("Items - View Item Facility", driver);
		
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static HashMap<String,String> getPutawayType() {
		return putawayType;
	}
	public static void setPutawayType(HashMap<String,String> putawayType) {
		ItemsPage.putawayType = putawayType;
	}

}


