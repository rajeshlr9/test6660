package StepDefinition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import TestRunner.Runner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.Items;
import globalFunc.CreateBrowser;
import globalFunc.GlobalClass;
import pages.AsnsPage;
import pages.CreateASNFromPOpage;
import pages.CubiscanEntryPage;
import pages.HomePage;
import pages.ILPNPage;
import pages.ItemInvenByLocationPage;
import pages.ItemsPage;
import pages.ManhattanLoginPage;
import pages.PixTransactionPage;
import pages.PostMessagePage;
import pages.RFMenuPage;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;
import utils.TestStubReader;
import utils.Xpathxml;


public class StepDefInBound {
	WebDriver driver=Steps.seleniumDriver;
	Xpathxml xmlInput = new Xpathxml();
	//TestStubReader testStubReader = new TestStubReader();
	ManhattanLoginPage manhattanLoginPage = new ManhattanLoginPage();
	//String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Inbound\\";
	//String itemfilepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Items\\";
	HomePage homePage = new HomePage();
	//TestStubReader testStubReader = new TestStubReader();
	PostMessagePage postMessagePage = new PostMessagePage();
	AsnsPage asnsPage = new AsnsPage();
	RFMenuPage rfMenu = new RFMenuPage();
	ItemInvenByLocationPage itemInvenByLocationPage = new ItemInvenByLocationPage();
	
	/*
	 * AsnsPage asnsPage = new AsnsPage(); ItemsPage itempage = new ItemsPage();
	 * CreateASNFromPOpage AsnfrmPO = new CreateASNFromPOpage(); CubiscanEntryPage
	 * cubiScanPage=new CubiscanEntryPage(); RFMenuPage rfMenu = new RFMenuPage();
	 */
	
	String itemName = null;
	String GtinNum = null;
	String ItemBarCode = null;
	String SerialNumReq = null;
	String miscellaneous1 = null;
	String miscellaneous2 = null;
	String miscellaneous4 = null;
	String velocityCode = null;
	
	 public StepDefInBound() throws Throwable { // this.driver =
	 // CreateBrowser.CreateBrowserInstance(); this.driver = Steps.seleniumDriver;
	  }
	 
	 

	
	/*
	 * @Before public void intiate(Scenario scenario) {
	 * 
	 * }
	 * 
	 * @After public void cleanUp(Scenario scenario) {
	 * 
	 * }
	 * 
	 */

	

	@Given("user log in to the Manhattan application")
	public void user_log_in_to_the_Manhattan_application()  {
		try {
			String env = ManhattanLoginPage.environment;
			System.out.println(env);
		if (env.equalsIgnoreCase("Dev")) {
			driver.get(Config.getProperty("ManhattanURL_Dev"));
			Steps.logger.info("Dev Environment");
		}else if(env.equalsIgnoreCase("Test")){
			driver.get(Config.getProperty("ManhattanURL_Test"));
			Steps.logger.info("Test Environment");
		}
		manhattanLoginPage.loginToManhattanApp();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@And("user logs into the Manhattan application")
	public void user_logs_into_the_Manhattan_application()  {
		try {
			String env = ManhattanLoginPage.environment;
			System.out.println(env);
						
		if (env.equalsIgnoreCase("Dev")) {
			driver.get(Config.getProperty("ManhattanURL_Dev"));
			Steps.logger.info("Dev Environment");
		}else if(env.equalsIgnoreCase("Test")){
			driver.get(Config.getProperty("ManhattanURL_Test"));
			Steps.logger.info("Test Environment");
		}
		manhattanLoginPage.loginToManhattanApp();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	@When("^user create xml file with Item Value updated with DeliveryStartDate for ReceivingASN$")
	public void user_create_xml_file_with_updated_DeliveryStartDate_for_ReceivingASN() throws Throwable {
		Steps.logger.info("XML creation started");
		xmlInput.user_create_inputXML_for_inbound_basedOn_noOfItem(Steps.ItemDataMap.get(0).get("Qty"));
		
	}
	
	@When("^user update xml itemDetails (\\d+) from sheet \"([^\"]*)\" with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" for receiving ASN$")
	public void user_update_xml_itemDetails_with(int noOfItem, String sheetName, String shippedQty, String qtyUOM,
			String rowHeaderTcname) throws Throwable {
		
		String[] shippedQtyAsArray = shippedQty.split("/");
		String[] qtyUOMAsArray = qtyUOM.split("/");
		Items.setCurrentTestCase(rowHeaderTcname);
		for (int i = 1; i <= noOfItem; i++) {
		//	itemName = testStubReader.setSheetAndGetData(sheetName, rowHeaderTcname, i);
			xmlInput.ModifyXmlfile(xmlInput.ASNUpdateItemName(i), itemName, xmlInput.inputIBFilePath);
			System.out.println("Item : " + itemName + " has been updated successfully");
			xmlInput.ModifyXmlfile(xmlInput.ASNUpdateQty(i), shippedQtyAsArray[i - 1], xmlInput.inputIBFilePath);
			System.out.println("Qty : " + shippedQtyAsArray[i - 1] + " has been updated successfully");
			xmlInput.ModifyXmlfile(xmlInput.ASNUpdateShippedQty(i), shippedQtyAsArray[i - 1], xmlInput.inputIBFilePath);
			System.out.println("ShippedASNQty : " + shippedQtyAsArray[i - 1] + " has been updated successfully");
			xmlInput.ModifyXmlfile(xmlInput.ASNUpdateQtyUOM(i), qtyUOMAsArray[i - 1], xmlInput.inputIBFilePath);
			System.out.println("QtyUOM : " + qtyUOMAsArray[i - 1] + " has been updated successfully");
			Items.setItemsForReceivingASN(itemName);
			Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shippedQtyAsArray[i - 1]));
			Items.setItemWithQtyUOM(itemName, qtyUOMAsArray[i - 1]);

		}
	}
	
	@When("^user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN$")
	public void user_create_xml_file_with_updated_ASNNo_DeliveryStartDate_for_ReceivingASN() throws Throwable {
		Steps.logger.info("XML creation started");
		xmlInput.user_create_inputXML_for_inbound_basedOn_noOfItem();
		Steps.scenario.write("ASN-"+Items.getAsnNumber());
		Reporter.addStepLog("ASN-"+Items.getAsnNumber());
	}

	@And("^user update xml itemDetails from excel sheet$")
	public void user_update_xml_itemDetails_from_sheet_for_Scenario() throws Throwable {
		
		String itemName = null;
		String shpQty=null;
		String uom=null;
		for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
			itemName = Steps.ItemDataMap.get(i).get("Item");
			xmlInput.ModifyXmlfile(xmlInput.ASNUpdateItemName(i+1), itemName, xmlInput.inputIBFilePath);
			System.out.println("Item : " + itemName + " has been updated successfully");
			Steps.logger.info("Item : " + itemName + " has been updated successfully");
			shpQty= Steps.ItemDataMap.get(i).get("ShippedQty");
			xmlInput.ModifyXmlfile(xmlInput.ASNUpdateQty(i+1), shpQty, xmlInput.inputIBFilePath);
			System.out.println("Shipped Qty : " + shpQty + " has been updated successfully");
			Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");
			uom=Steps.ItemDataMap.get(i).get("UOM");
			xmlInput.ModifyXmlfile(xmlInput.ASNUpdateQtyUOM(i+1), uom, xmlInput.inputIBFilePath);
			System.out.println("QtyUOM : " + uom + " has been updated successfully");
			Steps.logger.info("QtyUOM : " + uom + " has been updated successfully");
			
			Items.setItemsForReceivingASN(itemName);
			Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shpQty));
			Items.setItemWithQtyUOM(itemName, uom);
		}
	}
	
	@When("^user opens post message screen and upload file in order to create ASN$")
	public void user_opens_post_message_screen_and_upload_file_in_order_to_create_ASN() throws Throwable {
		//String isjenkinJob = Runner.jenkinJobName;
		homePage.menuItemsIntegrationSelection("Post Message");
		Steps.logger.info("Open Post message screen");
		BufferedReader reader = null;
		
		  try {
		  
		  reader = new BufferedReader(new FileReader(new File(xmlInput.inputIBFilePath)));
		  StringBuffer targetString = new StringBuffer(); 
		  String line = null; 
		  while ((line = reader.readLine()) !=null) { 
			  targetString.append(line.trim()); 
			  }
		  String request = String.valueOf(targetString).replaceAll("> <", "><"); 
		  JavascriptExecutor js =  (JavascriptExecutor) driver;
		  js.executeScript("var t = document.getElementById('dataForm:xmlString'); "+"t.value = arguments[0];", request);
		  SeleniumTestHelper.waitForElementToBeDisplayed(driver,postMessagePage.sendBtn, 50); 
		  postMessagePage.sendBtn.click();
		  Steps.logger.info("Clicked on post message button");
		  
		  } catch (Exception exec) {
		  SeleniumTestHelper.fail("Error occured while entering xml : " +
		  exec.getMessage()); 
		  } finally { 
			  reader.close();
		  }
		 
	}
	
	@Then("^user verify the response$")
	public void user_verify_the_response() throws Throwable {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, postMessagePage.responseTxt, 10000);
		postMessagePage.responseTxt.click();
		int noOfClick = 10;
		for (int i = 0; i < noOfClick; i++) {
			postMessagePage.responseTxt.sendKeys(Keys.ARROW_DOWN);
		}
		String responseType = postMessagePage.Validate_Response(driver, "Response_Type");
		System.out.println("responseType: "+responseType);
		Steps.logger.info("responseType: "+responseType);
		String errorType = postMessagePage.Validate_Response(driver, "Error_Type");
		if ((responseType.equals("Confirmation")) && (errorType.equals("0"))) {
			System.out.println("Receving request is successfully created");
			SeleniumTestHelper.assertEquals(responseType, "Confirmation");
			SeleniumTestHelper.assertEquals(errorType, "0");
			// System.out.println("Item : " + ItemName + " successfully verified
			// in the response");
			driver.switchTo().defaultContent();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, postMessagePage.openWindows, 50);
			postMessagePage.openWindows.click();
			SeleniumTestHelper.Close_OpenedWindow("Post Message", driver);
		} else {
			System.out.println("Receving request has not been created");
			SeleniumTestHelper.fail("Receving request has not been created");
		}
	}
	
	@Then("^user opens ASN screen and searches for the ASN and verify its status \"([^\"]*)\"$")
	public void user_opens_ASN_screen_and_searches_for_the_ASN_and_verify_its_status(String status) throws Throwable {

		//asnsPage.verifyAsnsStatus(Items.getAsnNumber(), status);
				asnsPage.verifyAsnsStatus(Items.getAsnNumber(), status);
	}
	@And("^user views ASN, get and verify item details$")
	public void user_views_ASNscreen_and_get_itemdetails() throws Throwable {
		//asnsPage.searchForTheASN(Items.getAsnNumber());
		asnsPage.searchForTheASN(Items.getAsnNumber());
		Steps.logger.info("Search for item details");
		SeleniumTestHelper.waitForElementToBeClickable(driver, asnsPage.searchedASNChkbox, 50);
		asnsPage.searchedASNChkbox.click();
		
		asnsPage.viewASNBtn.click();
		Steps.logger.info("Click on view ASN");
		Thread.sleep(5000);
		SeleniumTestHelper.switchToInnerFrame(driver);
		asnsPage.GetItemDetails();
		homePage.userClosesOpenedwindow("Advance Ship Notice");
		Thread.sleep(3000);
		SeleniumTestHelper.Close_OpenedWindow("ASNs", driver);
		Steps.logger.info("Close ASN window");
	}

	@Then("^user log out from application$")
	public void user_log_out_from_application() throws Throwable {
		homePage.user_logout_from_application();
	}
	
	@And("^user opens RF menu and completes Receiving using \"([^\"]*)\" menu for (\\d+) item in \"([^\"]*)\"$")
	public void user_opens_RF_menu_and_completes_Receiving_using_menu_for_item_in(String receivingMethod, int noOfItems, String recLocation) throws Throwable {
		homePage.MenuItems_Distribution_Selection("RF Menu");
		SeleniumTestHelper.switchToInnerFrame(driver);
		rfMenu.ASNReceivingProcess(noOfItems, receivingMethod, recLocation);
	}
	
	@Then("^user opens RF menu and completes Receiving using \"([^\"]*)\" menu$")
	public void user_opens_RF_menu_and_completes_Receiving_using_menu(String receivingMethod) throws Throwable {
		homePage.MenuItems_Distribution_Selection("RF Menu");
		Steps.logger.info("Open RF menu");
		SeleniumTestHelper.switchToInnerFrame(driver);
		rfMenu.ASNReceivingProcess(receivingMethod);
	}
	
	@Then("^user opens Inventory by location screen and validates the LPN created$")
	public void user_opens_InventoryByLocation_screen_and_validates_the_LPN_created() throws Throwable {
		homePage.MenuItems_Distribution_Selection("Item Inventory by Location");
		Steps.logger.info("Open Item Inventory by Location menu");
		Reporter.addStepLog("Open Item Inventory by Location menu");
		SeleniumTestHelper.switchToInnerFrame(driver);
		int actualQty = itemInvenByLocationPage.GetLPNQuantityByItemandLoc(Items.getItemsForReceivingASN(0),rfMenu.newSysSuggestedLoc,rfMenu.LPNVal);
		SeleniumTestHelper.assertEquals(actualQty, Integer.parseInt(Steps.ItemDataMap.get(0).get("RecQty")));
	}
	
	/*
	 * @Then("user opens RF menu and completes Receiving using \"([^\"]*)\" menu for (\\d+)$"
	 * ) public void
	 * user_opens_RF_menu_and_completes_Receiving_using_menu_for(String
	 * receivingMethod, int noOfItems) throws Throwable {
	 * homePage.MenuItems_Distribution_Selection("RF Menu");
	 * SeleniumTestHelper.switchToInnerFrame(driver);
	 * rfMenu.ASNReceivingProcess(noOfItems, receivingMethod); }
	 */
}
   