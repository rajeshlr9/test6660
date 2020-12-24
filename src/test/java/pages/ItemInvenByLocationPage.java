package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.DistributionOrders;
import entity.Items;
import globalFunc.GlobalClass;
import globalFunc.Screenshots;
import utils.Driver;
import utils.SeleniumTestHelper;


public class ItemInvenByLocationPage {
	WebDriver driver;
	
	public ItemInvenByLocationPage()
	{
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:locationLookUpId']") public static WebElement displayLoc_field;
	@FindBy(xpath="//input[@class='btn  groupBtn' and @id='dataForm:listView:filterId:filterIdapply']") public static WebElement applyBtn;
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:itemLookUpId']") public static WebElement itemLookUp_field;
	@FindBy(xpath="//input[@class='btn' and @value='LPNs']") public static WebElement LPNsBtn;
	@FindBy(xpath="//img[@id='backImage']") public static WebElement navBackBtn;
	@FindBy(xpath="//input[@class='btn' and @value='View by Attributes']") public static WebElement viewByAttribBtn;
	@FindBy(xpath="//span[@id='dataForm:cLocation' and @class='captionData']") public static WebElement locationName;
	@FindBy(xpath="//span[@id='dataForm:c2' and @class='captionData']") public static WebElement itemName;
	//@FindBy(xpath="(//div[@id='dataForm:listView:dataTable_bodyDiv']/table//td/input[@id='checkAll_c0_dataForm:listView:dataTable'])") public static WebElement itemCheckBox;
	@FindBy(xpath="(//span[text()='Active' or text()='Reserve' or text()='Case pick']/../..//input[@type='checkbox'])[1]") public static WebElement itemCheckBox;
	@FindBy(xpath="//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_lpnFacilityStatus_param_out']") public static WebElement LPNstatus;
	@FindBy(xpath="//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_Link_NameText_param_out']") public static WebElement LPN_Num;
	@FindBy(xpath="//input[@type='text' and @id='dataForm:listView:filterId:locationLookUpId']") public WebElement displayLocationBox;
	@FindBy(xpath="//span[text()='Reserve']/../..//input[@type='checkbox']") public WebElement reserveLocChkbox;
	@FindBy(xpath="//span[contains(@id,'CTO_LPNListTPM_LPN_Qty_param')]") public WebElement reserveLpnQty;
	@FindBy(xpath="(//span[text()='Putaway']/../../..//input[@type='checkbox'])[1]") public WebElement reserveLpnCheckbox;
	@FindBy(xpath="//input[@value='Adjust']") public WebElement lpnAdjust;
	@FindBy(xpath="//span[text()='Unallocatable']/..") public WebElement unallocatableColumn;
	
	@FindBy(id="dataForm:listView:filterId:filterIdapply")
	public WebElement locationApply;
	
	@FindBy(xpath="//a[@id='dataForm:listView:dataTable:0:ItemBOMDetailsListEV_item_popup_button']")
	public WebElement CCAItem;
	
	@FindBy(xpath="//*[contains(text(),'Case pick')]")
	public WebElement Case_Pick;

	
	HomePage homepage=new HomePage();
	
	public void case_Pick_Item(String ExpectedTaskType) throws Exception
	{
		if(SeleniumTestHelper.isElementDisplayed(driver.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//a[@id='dataForm:listView:dataTable:4:ItemBOMDetailsListEV_item_popup_button']"))))
			
			driver.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//a[@id='dataForm:listView:dataTable:4:ItemBOMDetailsListEV_item_popup_button']")).getText();
		    driver.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//span[@id='dataForm:listView:dataTable:4:allocatableQty']")).getText();
		
	}
	
	@FindBy(xpath="//span[@id='dataForm:listView:dataTable:0:onHandQuantity']")
	public WebElement CCAOnHand;
	
	@FindBy(xpath="//span[@id='dataForm:listView:dataTable:0:allocatableQty']")
	public WebElement Allocatable;
	
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:itemLookUpId']")
	public WebElement itemBox;
	
	@FindBy(xpath="//input[@type='checkbox' and @id='checkAll_c0_dataForm:listView:dataTable']")
	public WebElement checkBox;
	
	@FindBy(xpath="//span[@id='dataForm:listView:dataTable:1:lotNumber']")
	public WebElement lotNum;
	
	@FindBy(xpath="//input[@id='dataForm:listView:dataTable:pager:next']")
	public WebElement nextBtn;
	
	@FindBy(xpath="//input[@id='rmButton_1LockUnlock1_167271589']")
	public WebElement lock_Unlock;
	
	@FindBy(xpath="//select[@id='dataForm:putawayLock']")
	public WebElement putaway_Lock;
	
	@FindBy(xpath="//select[@id='dataForm:taskType']")
	public WebElement inventory_Lock;
	
	@FindBy(xpath="//input[@id='rmButton_1Save1_167271590']")
	public WebElement save_Btn;
	
	@FindBy(xpath="//a[@id='dataForm:listView:dataTable:0:ItemBOMDetailsListEV_item_popup_button']")
	public WebElement item;
	
	@FindBy(xpath="//span[@id='dataForm:listView:dataTable:0:allocatableQty']")
	public WebElement allocatable;
	
	@FindBy(xpath="//input[@id='rmButton_1AdjustInventory1_100204000']")
	public WebElement adjust_Inventory;
	
	@FindBy(xpath="//input[@id='dataForm:NewQty']")
	public WebElement new_Qty;
	
	@FindBy(xpath="//select[@id='dataForm:adjustReasonSelect']")
	public WebElement reason_Code;
	
	@FindBy(xpath="//input[@id='dataForm:esign_esignUserId']")
	public WebElement User_ID;

	@FindBy(xpath="//span[text()='Putaway']/parent::div/../preceding-sibling::td[2]//span[1]")
	public WebElement firstPutawayilpnvalue;
	
	
	@FindBy(xpath="//span[text()='Allocatable']")
	public WebElement allocatableLbl;

	
	
	@FindBy(xpath="//input[@id='dataForm:esign_password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='dataForm:esign_ok']")
	public WebElement OK_Btn;
	
	@FindBy(xpath="//input[@id='dataForm:esign_ok']")
	public WebElement confirm_Btn;
	
	@FindBy(xpath="//span[@id='dataForm:listView:dataTable:0:dspLocn']")
	public WebElement active_Location;

	@FindBy(xpath="//input[@id='checkAll_c0_dataForm:LPNListInOutboundMain_lv:dataTable']")
	public WebElement firstilpnchekbox;
	
	
	@FindBy(xpath="//input[@alt='Edit Header']")
	public WebElement editHeaderInItemInvByLocationBtn;
	
	@FindBy(xpath="//span[text()='Consume priority date:']/../following::td[1]//input[contains(@id,'ConsumePriorityDateTime') and @type='text']")
	public WebElement consumePriorityDateTextbox;
	
	@FindBy(xpath="//input[@value='View']")
	public WebElement viewILPNinItemInvByLocationBtn;
	
	@FindBy(xpath="//input[@value='Save']")
	public WebElement saveinItemInvByLocationBtn;
	
	@FindBy(xpath="//img[@id='backImage']")
	public WebElement backBtninItemInvByLocationBtn;
	
	@FindBy(xpath="//input[@value='LPNs']")
	public WebElement lpnBtn;
	
	
	/*
	 * This method will find items by location from Item Inventory By Location screen and select random item and returns attributes(Location, number of LPNs, item name)
	 *  of selected  item. Pass location type initial to search specific location EX: R- for reserve, A for active locations.
	 */
	public Map<String, String> getRandom_Item_from_List(WebDriver driver, String locationType) throws Exception {

		Map<String, String> ItemAttributes = new HashMap<String, String>();
		String LPNs;
		String location;
		String itemName;
		String LPN_Number;

		driver.switchTo().frame(0);
		displayLoc_field.sendKeys(locationType + "*");
		applyBtn.click();
		//nextBtn.click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver
				.findElements(By.xpath("//table[@id='dataForm:listView:dataTable_body']/tbody/tr/td[1]/input[1]"));
		
		int RandomNumber = SeleniumTestHelper.generateRandomInt(0, itemList.size()-1);
		WebElement itemChckBox = itemList.get(RandomNumber);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemChckBox, 5);
		itemChckBox.click();
		Thread.sleep(3000);
		LPNsBtn.click();
		int LPNnum = driver
				.findElements(
						By.xpath("//div[@id='dataForm:LPNListInOutboundMain_lv:dataTable_bodyDiv']/table/tbody/tr"))
				.size() - 1;
		LPNs = "" + LPNnum;
		SeleniumTestHelper.assertTrue(LPN_Num.isDisplayed());
		LPN_Number = LPN_Num.getText();
		navBackBtn.click();
		
		List<WebElement> itemList2 = driver
				.findElements(By.xpath("//table[@id='dataForm:listView:dataTable_body']/tbody/tr/td[1]/input[1]"));
		
		itemList2.get(RandomNumber).click();
		Thread.sleep(5000);
		viewByAttribBtn.click();
		location = locationName.getText();
		SeleniumTestHelper.assertTrue(this.itemName.isDisplayed());
		itemName = this.itemName.getText();
		navBackBtn.click();

		ItemAttributes.put("LPNs", LPNs);
		ItemAttributes.put("Location", location);
		Items.setRlocation_one(location);
		ItemAttributes.put("ItemName", itemName);
		Items.setItemName(itemName);
		ItemAttributes.put("LPNNumber", LPN_Number);
		driver.switchTo().defaultContent();
		return ItemAttributes;

	}
	
	public void search_for_item(WebDriver driver, String item) {
		itemLookUp_field.sendKeys(item);
		applyBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SeleniumTestHelper.assertTrue(itemLookUp_field.isDisplayed());
	}
	
	public int get_count_of_search_result(WebDriver driver) {
		int count = 0;
		count = driver.findElements(By.xpath("//span[text()='Reserve' or text() ='Active' or text()='Case pick']")).size();
		System.out.println("Count of different locations "+count);
		return count;
	}
	public void GetLPNQtybyItem(String item) throws Exception {
		homepage.MenuItems_Distribution_Selection("Item Inventory by Location");
		SeleniumTestHelper.switchToInnerFrame(driver);
		itemLookUp_field.sendKeys(item);
		applyBtn.click();
		/*itemCheckBox.click();
		LPNsBtn.click();*/
		SeleniumTestHelper.waitForElementToBeClickable(driver, reserveLocChkbox, 50);
	    List<WebElement> reservelocns=driver.findElements(By.xpath("//span[text()='Reserve']/../..//input[@type='checkbox']"));
	    reservelocns.get(0).click();
	    LPNsBtn.click();
	    SeleniumTestHelper.waitForElementToBeDisplayed(driver, reserveLpnQty, 50);
	    List<WebElement> lpns = driver.findElements(By.xpath("//span[contains(@id,'CTO_LPNListTPM_LPN_Qty_param')]"));
	    String[] lpnQtyAsArray = lpns.get(0).getText().split(" ");
	    DistributionOrders.setLpnQty(Integer.parseInt(lpnQtyAsArray[0]));
	    homepage.userClosesOpenedwindow("Item Inventory by Location - iLPNs"); 
	    
	    }
	//Rakesh
	public int GetLPNQuantityByItemandLoc(String item,String RecLocn,String LPNVal) throws Exception {
		//homepage.MenuItems_Distribution_Selection("Item Inventory by Location");
		//SeleniumTestHelper.switchToInnerFrame(driver);
		displayLoc_field.sendKeys(RecLocn);
		itemLookUp_field.sendKeys(item);
		Screenshots.captureSnapshot(driver);
		applyBtn.click();
		Screenshots.captureSnapshot(driver);
		/*itemCheckBox.click();
		LPNsBtn.click();*/
		SeleniumTestHelper.waitForElementToBeClickable(driver, reserveLocChkbox, 50);
	    List<WebElement> reservelocns=driver.findElements(By.xpath("//span[text()='Reserve']/../..//input[@type='checkbox']"));
	    reservelocns.get(0).click();
	    Thread.sleep(1000);
	    Screenshots.captureSnapshot(driver);
	    LPNsBtn.click();
	    Thread.sleep(5000);
	    Screenshots.captureSnapshot(driver);
	    driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:field10value1")).sendKeys(LPNVal);
	    Screenshots.captureSnapshot(driver);
	    driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:LPNList_Inbound_filterId1apply")).click();
	    Thread.sleep(2000);
	    Screenshots.captureSnapshot(driver);
	   String LPNQty =  driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:dataTable:0:CTO_LPNListTPM_LPN_Qty_param_out2")).getText();
		String[] LPNQty1 =  LPNQty.split(" ");
		
		
		String str =LPNQty1[0];
		
	    return Integer.parseInt(str);
	    }
	
	//Rakesh
		public void GetMovedLPNQuantityByItemandLoc(String item,String RecLocn,ArrayList<String> iLPNz) throws Exception {
			//homepage.MenuItems_Distribution_Selection("Item Inventory by Location");
			//SeleniumTestHelper.switchToInnerFrame(driver);
			displayLoc_field.sendKeys(RecLocn);
			Screenshots.captureSnapshot(driver);
			itemLookUp_field.sendKeys(item);
			Screenshots.captureSnapshot(driver);
			applyBtn.click();
			
			/*itemCheckBox.click();
			LPNsBtn.click();*/
			SeleniumTestHelper.waitForElementToBeClickable(driver, reserveLocChkbox, 50);
			Screenshots.captureSnapshot(driver);
		    List<WebElement> reservelocns=driver.findElements(By.xpath("//span[text()='Reserve']/../..//input[@type='checkbox']"));
		    reservelocns.get(0).click();
		    Thread.sleep(2000);
		    Screenshots.captureSnapshot(driver);
		    LPNsBtn.click();
		    Thread.sleep(2000);
		    Screenshots.captureSnapshot(driver);
		    driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:field10value1")).sendKeys(iLPNz.get(0));
		    Thread.sleep(2000);
		    driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:LPNList_Inbound_filterId1apply")).click();
		    Thread.sleep(2000);
		    Screenshots.captureSnapshot(driver);
		    String LPNQty01 =  driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:dataTable:0:CTO_LPNListTPM_LPN_Qty_param_out2")).getText();
			String[] LPNQty1 =  LPNQty01.split(" ");
			//String newQty1 =LPNQty1[0];
			
			int newQty1  =Integer.parseInt(LPNQty1[0]);
			//SeleniumTestHelper.assertEquals(newQty1, Integer.parseInt(Steps.ItemDataMap.get(0).get("RecQty")));
			Thread.sleep(2000);
			driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:field10value1")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:field10value1")).sendKeys(iLPNz.get(1));
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:LPNList_Inbound_filterId1apply")).click();
			Thread.sleep(3000);
			Screenshots.captureSnapshot(driver);
			String LPNQty02 =  driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:dataTable:0:CTO_LPNListTPM_LPN_Qty_param_out2")).getText();
			Thread.sleep(2000);
			String[] LPNQty2 =  LPNQty02.split(" ");
			//String newQty2 =LPNQty2[0];
			int newQty2 =Integer.parseInt(LPNQty2[0]);
			//SeleniumTestHelper.assertEquals(actualQty, Integer.parseInt(Steps.ItemDataMap.get(0).get("RecQty")));
			int expectediLPN1 =Integer.parseInt(Steps.ItemDataMap.get(0).get("RecQty"))-Integer.parseInt(Steps.scenarioData.get("MoveLPNQty"));
			System.out.println("expectediLPN1: "+expectediLPN1);
			int expectediLPN2 =Integer.parseInt(Steps.ItemDataMap.get(0).get("RecQty2"))+Integer.parseInt(Steps.scenarioData.get("MoveLPNQty"));
			System.out.println("expectediLPN2: "+expectediLPN2);
			SeleniumTestHelper.assertEquals(newQty1, expectediLPN1);
			Reporter.addStepLog("Expected qty in LPN 1 matches the actual qty");
			SeleniumTestHelper.assertEquals(newQty2, expectediLPN2);
			Reporter.addStepLog("Expected qty in LPN 2 matches the actual qty");
			homepage.userClosesOpenedwindow("Item Inventory by Location - iLPNs"); 
		   
		    }

	public int GetLPNQuantityByItem(String item) throws Exception {
		homepage.MenuItems_Distribution_Selection("Item Inventory by Location");
		SeleniumTestHelper.switchToInnerFrame(driver);
		itemLookUp_field.sendKeys(item);
		applyBtn.click();
		/*itemCheckBox.click();
		LPNsBtn.click();*/
		SeleniumTestHelper.waitForElementToBeClickable(driver, reserveLocChkbox, 50);
	    List<WebElement> reservelocns=driver.findElements(By.xpath("//span[text()='Reserve']/../..//input[@type='checkbox']"));
	    reservelocns.get(0).click();
	    LPNsBtn.click();
	    SeleniumTestHelper.waitForElementToBeDisplayed(driver, reserveLpnQty, 50);
	    List<WebElement> lpns = driver.findElements(By.xpath("//span[contains(@id,'CTO_LPNListTPM_LPN_Qty_param')]"));
	    String[] lpnQtyAsArray = lpns.get(0).getText().split(" ");
	    homepage.userClosesOpenedwindow("Item Inventory by Location - iLPNs"); 
	    return Integer.parseInt(lpnQtyAsArray[0]);
	    }
	
	
	public int GetReserveAndCasepickQtyByItem(String item) throws Exception {
		homepage.MenuItems_Distribution_Selection("Item Inventory by Location");
		SeleniumTestHelper.switchToInnerFrame(driver);
		itemLookUp_field.sendKeys(""+item);
		applyBtn.click();
		Thread.sleep(5000);
		
		List<WebElement> Qtys = driver.findElements(By.xpath("//span[text()='Reserve' or text()='Case pick']/../following-sibling::td//span[contains(@id,':allocatableQty')]"));
		int totalqty=0;
		String[] quantityWithEA = null;
		/**
		for(WebElement qty : Qtys){
			quantityWithEA = qty.getText().split(" ");
			totalqty += Integer.parseInt(quantityWithEA[0]);
		}
		*/
		for(WebElement allocatableLblQty : Qtys){
			quantityWithEA = allocatableLblQty.getAttribute("textContent").split(" ");
			totalqty += Integer.parseInt(quantityWithEA[0]);
		}
		System.out.println("Total Allocatable Qty for item : " + item +  " is " + totalqty);
	    homepage.userClosesOpenedwindow("Item Inventory by Location"); 
	    return totalqty;
	    }
	
	public void location_Selected(String ExpectedTaskType) throws Exception
	{
		if(SeleniumTestHelper.isElementDisplayed(driver.findElement(By.xpath("//a[text()='" + ExpectedTaskType + "']/../..//input[@type='checkbox']"))))
			
			driver.findElement(By.xpath("//a[text()='" + ExpectedTaskType + "']/../..//input[@type='checkbox']")).click();
		
	}

	// This method will get the active location with allocatable item
	public Map<String, String> Active_Inventory_Location(WebDriver driver, String locationType) throws Exception{
	
		Map<String, String> ItemAttributes = new HashMap<String, String>();
		String location;
		String itemName;

		driver.switchTo().frame(0);
		displayLoc_field.sendKeys(locationType + "*");
		applyBtn.click();
		//nextBtn.click();
		Thread.sleep(2000);
		String ItemName = item.getText();
		Items.setItemName(ItemName);
		location_Selected(ItemName);
		lock_Unlock.click();
		String ALocation_one = active_Location.getText();
		Items.setALocation_one(ALocation_one);

	    SeleniumTestHelper.selectFromDropDown(putaway_Lock,"(none)","visibletext");
	    SeleniumTestHelper.waitForElementToBeDisplayed(driver, inventory_Lock, 50);
	    inventory_Lock.click();
	    
	    for(int i =1; i<=1; i++) {
	    	inventory_Lock.sendKeys(""+ Keys.ARROW_DOWN);
	    }
		
	    save_Btn.click();
		location_Selected(ItemName);
		adjust_Inventory.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, new_Qty, 50);
		new_Qty.clear();
		new_Qty.sendKeys("20");
		
		SeleniumTestHelper.selectFromDropDown(reason_Code, "CC-Counting-Cycle Count-PHYSICAL_COUNT_DIFFERENCE", "VisibleText");
		WebElement save = driver.findElement(By.xpath("//input[@id='rmButton_1Save1_154183000']"));
		save.click();
		
		try{
			if(User_ID.isEnabled()){
			User_ID.sendKeys("3751376");
			password.sendKeys("3751376");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, OK_Btn, 50);
			OK_Btn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, confirm_Btn, 50);
			confirm_Btn.click();
			}
		}
		
		catch(Exception e){
			System.out.println("E-Signiture doesn't require");
		}
		
		navBackBtn.click();
		WebElement new_Qty = driver.findElement(By.xpath("//span[@id='dataForm:listView:dataTable:0:allocatableQty']"));
		//String[] activeQty = new_Qty.getAttribute("textContent").split(" ");
		String itemQTY = new_Qty.getText();
		Items.setItemQTY(itemQTY);
		//itemQTY = itemQTY.substring(0, 2).trim();
		driver.switchTo().defaultContent();
		return ItemAttributes;
			
	}

	public int GetLPNQuantityByItemActive(String item) throws Exception {
		homepage.MenuItems_Distribution_Selection("Item Inventory by Location");
		SeleniumTestHelper.switchToInnerFrame(driver);
		itemLookUp_field.sendKeys(item);
		applyBtn.click();		
		List<WebElement> activelocnsqty = driver.findElements(
				By.xpath("//span[contains(text(),'Active')]/../..//span[contains(@id,':allocatableQty') ]"));
		int totalQty = 0;
		for (WebElement qty : activelocnsqty) {
			// String[] lpnQtyAsArray = qty.getText().split(" ");
			String[] lpnQtyAsArray = qty.getAttribute("textContent").split("");
			int Quantity = Integer.parseInt(lpnQtyAsArray[0]);
			System.out.println("Active Allocatable Quantity: " + Quantity);
			totalQty = totalQty + Quantity;
		}
		System.out.println("Total Active Allocatable Quantity: " + totalQty);
		DistributionOrders.setLpnQty(totalQty);
		homepage.userClosesOpenedwindow("Item Inventory by Location");
        return totalQty;
	}
	
	// This method will get the Reserve location with allocatable item
		public Map<String, String> Reserve_Inventory_Location(WebDriver driver, String locationType) throws Exception{
		
			Map<String, String> ItemAttributes = new HashMap<String, String>();
			String location;
			String itemName;

			driver.switchTo().frame(0);
			displayLoc_field.sendKeys(locationType + "*");
			applyBtn.click();
			//nextBtn.click();
			Thread.sleep(2000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, unallocatableColumn, 50);
			 unallocatableColumn.click();
		    Thread.sleep(2000);
//		    unallocatableColumn.click();
//			Thread.sleep(2000);
			String ItemName = item.getText();
			Items.setItemName(ItemName);
			location_Selected(ItemName);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, lpnBtn, 20);
			lpnBtn.click();
			String numLpn=null;
			List<WebElement> lpns = driver.findElements(By.xpath("//span[contains(@id,'LPNList_Outbound_Link_NameText_param_out')]"));
			for(WebElement lpn:lpns){
				Items.ilpns.add(lpn.getText());
				System.out.println("iLPN's of the location is "+lpn.getText());
				List<WebElement> numberofLPN = driver.findElements(By.xpath("//span[text()='Putaway']"));
				numLpn = String.valueOf(numberofLPN.size());
				Items.setNumberOfLpn(numLpn);
			
			}
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, navBackBtn, 20);
			navBackBtn.click();
			location_Selected(ItemName);
			lock_Unlock.click();
			String RLocation_one = active_Location.getText();
			Items.setRlocation_one(RLocation_one);
            System.out.println("Location is "+Items.getRlocation_one());
		    SeleniumTestHelper.selectFromDropDown(putaway_Lock,"(none)","visibletext");
		    SeleniumTestHelper.waitForElementToBeDisplayed(driver, inventory_Lock, 50);
		    inventory_Lock.click();
		    
		    for(int i =0; i<1; i++) {
		    	inventory_Lock.sendKeys(""+ Keys.ARROW_DOWN);
		    }
			
		    save_Btn.click();
		    Thread.sleep(2000);
			WebElement new_Qty = driver.findElement(By.xpath("//span[@id='dataForm:listView:dataTable:0:allocatableQty']"));
			String[] activeQty = new_Qty.getAttribute("textContent").split(" ");
			String itemQTY = activeQty[0];
			Items.setItemQTY(itemQTY);
			//itemQTY = itemQTY.substring(0, 2).trim();
			driver.switchTo().defaultContent();
			return ItemAttributes;
				
		}
	
public void getNumberOfLPNs(String item) throws Exception {
			
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemLookUp_field, 50);
			itemLookUp_field.clear();
			itemLookUp_field.sendKeys(item);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtn, 50);
			applyBtn.click();
			SeleniumTestHelper.assertTrue(applyBtn.isDisplayed());
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemCheckBox, 50);
			itemCheckBox.click();
			//WebElement locBarcode = driver.findElement(By.xpath("//span[@id='dataForm:listView:dataTable:0:dspLocn']"));
			WebElement locBarcode = driver.findElement(By.xpath("//span[text()='Active' or text()='Reserve' or text()='Case pick']/../..//span[contains(@id,':dspLocn')]"));
			String locbar = locBarcode.getText();
			Items.setALocation_two(locbar);
		//	WebElement locQty = driver.findElement(By.xpath("//span[@id='dataForm:listView:dataTable:0:allocatableQty']"));
			WebElement locQty = driver.findElement(By.xpath("//span[text()='Active' or text()='Reserve' or text()='Case pick']/../..//span[contains(@id,':allocatableQty')]"));
			String[] locQuantity = locQty.getAttribute("textContent").split(" ");
			System.out.println("ItemQty for Aloc"+locQuantity[0]);
			
			Items.setItemQTY(locQuantity[0]);
			Thread.sleep(2000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, LPNsBtn, 50);
			LPNsBtn.click();
			WebElement numberOfLPNs = driver.findElement(By.xpath("//input[contains(@id,'dataTable:pager:ajaxCntQueryImg')]"));
			String numOfLPNs = numberOfLPNs.getAttribute("value");
			Items.setNumberOfLpn(numOfLPNs);
			System.out.println("Number of LPN's are "+ Items.getNumberOfLpn());
			Thread.sleep(2000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtninItemInvByLocationBtn, 50);
			backBtninItemInvByLocationBtn.click();
		}
	
	public void getNumberOfLPNsAndLPNs(String item) throws Exception {

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemLookUp_field, 50);
		itemLookUp_field.clear();
		itemLookUp_field.sendKeys(item);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtn, 50);
		applyBtn.click();
		SeleniumTestHelper.assertTrue(applyBtn.isDisplayed());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemCheckBox, 50);
		itemCheckBox.click();

		WebElement locBarcode = driver.findElement(By.xpath(
				"//span[text()='Active' or text()='Reserve' or text()='Case pick']/../..//span[contains(@id,':dspLocn')]"));
		String locbar = locBarcode.getText();
		Items.setALocation_two(locbar);
		WebElement locQty = driver.findElement(By.xpath(
				"//span[text()='Active' or text()='Reserve' or text()='Case pick']/../..//span[contains(@id,':allocatableQty')]"));
		String[] locQuantity = locQty.getAttribute("textContent").split(" ");
		System.out.println("ItemQty for Aloc" + locQuantity[0]);

		Items.setItemQTY(locQuantity[0]);
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, LPNsBtn, 50);
		LPNsBtn.click();
		WebElement numberOfLPNs = driver.findElement(By.xpath("//input[contains(@id,'dataTable:pager:ajaxCntQueryImg')]"));
		String numOfLPNs = numberOfLPNs.getAttribute("value");
		Items.setNumberOfLpn(numOfLPNs);
		System.out.println("Number of LPN's are " + Items.getNumberOfLpn());
		Thread.sleep(2000);

		List<WebElement> LPNIDs = driver
				.findElements(By.xpath("//span[contains(@id,':LPNList_Outbound_Link_NameText')]"));
		Items.ilpns.clear();
		for (WebElement LPNID : LPNIDs) {
			String lpn = LPNID.getText();
			Items.setLpns(lpn);
			Items.setLPNID(lpn);
			System.out.println("LPN : " + lpn);
		}

		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtninItemInvByLocationBtn, 50);
		backBtninItemInvByLocationBtn.click();
		Thread.sleep(2000);
	}

}
