package StepDefinition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.xml.sax.SAXException;

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
import pages.ReserveLocationPage;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;
import utils.TestStubReader;
import utils.Xpathxml;

public class StepDefInBound {
	WebDriver driver = Steps.seleniumDriver;
	Xpathxml xmlInput = new Xpathxml();
	Steps st=new Steps();
	// TestStubReader testStubReader = new TestStubReader();
	ManhattanLoginPage manhattanLoginPage = new ManhattanLoginPage();
	// String filepath = System.getProperty("user.dir") +
	// "\\src\\test\\resources\\testdata\\Inbound\\";
	// String itemfilepath = System.getProperty("user.dir") +
	// "\\src\\test\\resources\\testdata\\Items\\";
	HomePage homePage = new HomePage();
	// TestStubReader testStubReader = new TestStubReader();
	PostMessagePage postMessagePage = new PostMessagePage();
	AsnsPage asnsPage = new AsnsPage();
	RFMenuPage rfMenu = new RFMenuPage();
	ILPNPage iLPNPage = new ILPNPage();
	ItemInvenByLocationPage itemInvenByLocationPage = new ItemInvenByLocationPage();
	PixTransactionPage pixTransaction = new PixTransactionPage();
	ReserveLocationPage resLocPage = new ReserveLocationPage();

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
	public void user_log_in_to_the_Manhattan_application() {
		try {
			String env = ManhattanLoginPage.environment;
			System.out.println("Environment:--"+env);
			if (env.equalsIgnoreCase("Dev")) {
				driver.get(Config.getProperty("ManhattanURL_Dev"));
				Steps.logger.info("Dev Environment");
			} else if (env.equalsIgnoreCase("TEST")|| env.equalsIgnoreCase("@Env") ) {
				driver.get(Config.getProperty("ManhattanURL_TEST"));
			} else if (env.equalsIgnoreCase("STAGE")) {
				driver.get(Config.getProperty("ManhattanURL_STAGE"));
				Steps.logger.info("UA Environment");
			}
			
			manhattanLoginPage.loginToManhattanApp();
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}

	@When("^user logs into Manhattan application using \"([^\"]*)\" Credentials$")
	public void user_logs_into_Manhattan_application(String userType) throws Exception {
		try {
			// driver = CreateBrowser.CreateBrowserInstance();
			// Steps.logger.info("Browser Instance created");

			String env = ManhattanLoginPage.environment;
			System.out.println("Environment:"+env);

			if (env.equalsIgnoreCase("DEV")|| env.equalsIgnoreCase("@Env")) {
				driver.get(Config.getProperty("ManhattanURL_DEV"));
				Steps.logger.info("Dev Environment");
			} else if (env.equalsIgnoreCase("TEST") ) {
				driver.get(Config.getProperty("ManhattanURL_TEST"));
				Steps.logger.info("TEST Environment");
			}
				else if (env.equalsIgnoreCase("STAGE")) {
					driver.get(Config.getProperty("ManhattanURL_STAGE"));
					Steps.logger.info("STAGE Environment");
			}
			manhattanLoginPage.loginToManhattanApp(userType);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}

	@And("user logs into the Manhattan application")
	public void user_logs_into_the_Manhattan_application() {
		try {
			String env = ManhattanLoginPage.environment;
			System.out.println("Environment:"+env);

			if (env.equalsIgnoreCase("DEV")|| env.equalsIgnoreCase("@Env")) {
				driver.get(Config.getProperty("ManhattanURL_DEV"));
				Steps.logger.info("Dev Environment");
			} else if (env.equalsIgnoreCase("TEST") ) {
				driver.get(Config.getProperty("ManhattanURL_TEST"));
				Steps.logger.info("TEST Environment");
			}
				else if (env.equalsIgnoreCase("STAGE")) {
					driver.get(Config.getProperty("ManhattanURL_STAGE"));
					Steps.logger.info("STAGE Environment");
			}
			manhattanLoginPage.loginToManhattanApp();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}

	@When("^user create xml file with Item Value updated with DeliveryStartDate for ReceivingASN$")
	public void user_create_xml_file_with_updated_DeliveryStartDate_for_ReceivingASN() throws Exception {
		try {
			Steps.logger.info("XML creation started");
			xmlInput.user_create_inputXML_for_inbound_basedOn_noOfItem(Steps.ItemDataMap.get(0).get("Qty"));
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false);
		}

	}

	@When("^user update xml itemDetails (\\d+) from sheet \"([^\"]*)\" with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" for receiving ASN$")
	public void user_update_xml_itemDetails_with(int noOfItem, String sheetName, String shippedQty, String qtyUOM,
			String rowHeaderTcname) throws Exception {

		try {
			String[] shippedQtyAsArray = shippedQty.split("/");
			String[] qtyUOMAsArray = qtyUOM.split("/");
			Items.setCurrentTestCase(rowHeaderTcname);
			for (int i = 1; i <= noOfItem; i++) {
				// itemName = testStubReader.setSheetAndGetData(sheetName, rowHeaderTcname, i);
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
		} catch (NumberFormatException e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}

	@When("^user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN$")
	public void user_create_xml_file_with_updated_ASNNo_DeliveryStartDate_for_ReceivingASN() throws Exception {
		try {
			Steps.logger.info("XML creation started");
			xmlInput.user_create_inputXML_for_inbound_basedOn_noOfItem();
			Steps.scenario.write("ASN-" + Items.getAsnNumber());
			Reporter.addStepLog("ASN No-" + Items.getAsnNumber());
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}

	@When("^user create xml file using \"([^\"]*)\" with updated ASNNo & DeliveryStartDate for ReceivingASN$")
	public void user_create_xml_swith_updated_ASNNo_DeliveryStartDate_for_ReceivingASN(String xmlType)
			throws Exception {
		try {
			Steps.logger.info("XML creation started");
			xmlInput.user_create_inputXML_for_inbound_basedOn_xmlType(xmlType);
			Steps.scenario.write("ASN-" + Items.getAsnNumber());
			Reporter.addStepLog("ASN No-" + Items.getAsnNumber());
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}

	@And("^user update xml itemDetails from excel sheet$")
	public void user_update_xml_itemDetails_from_sheet_for_Scenario() throws Exception {

		try {
			String itemName = null;
			String shpQty = null;
			String uom = null;
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				itemName = Steps.ItemDataMap.get(i).get("Item");
				xmlInput.ModifyXmlfile(xmlInput.ASNUpdateItemName(i + 1), itemName, xmlInput.inputIBFilePath);
				System.out.println("Item : " + itemName + " has been updated successfully");
				Steps.logger.info("Item : " + itemName + " has been updated successfully");
				shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
				xmlInput.ModifyXmlfile(xmlInput.ASNUpdateQty(i + 1), shpQty, xmlInput.inputIBFilePath);
				System.out.println("Shipped Qty : " + shpQty + " has been updated successfully");
				Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");
				uom = Steps.ItemDataMap.get(i).get("UOM");
				xmlInput.ModifyXmlfile(xmlInput.ASNUpdateQtyUOM(i + 1), uom, xmlInput.inputIBFilePath);
				System.out.println("QtyUOM : " + uom + " has been updated successfully");
				Steps.logger.info("QtyUOM : " + uom + " has been updated successfully");

				Items.setItemsForReceivingASN(itemName);
				Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shpQty));
				Items.setItemWithQtyUOM(itemName, uom);
				Reporter.addStepLog("Item Id- " + Steps.ItemDataMap.get(i).get("Item") + ", Shipped Qty- "
						+ Steps.ItemDataMap.get(i).get("ShippedQty"));
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}

	@When("^user opens post message screen and upload file in order to create ASN$")
	public void user_opens_post_message_screen_and_upload_file_in_order_to_create_ASN() throws Exception {
		// String isjenkinJob = Runner.jenkinJobName;
		homePage.menuItemsIntegrationSelection("Post Message");
		Steps.logger.info("Open Post message screen");
		BufferedReader reader = null;

		try {

			reader = new BufferedReader(new FileReader(new File(xmlInput.inputIBFilePath)));
			StringBuffer targetString = new StringBuffer();
			String line = null;
			while ((line = reader.readLine()) != null) {
				targetString.append(line.trim());
			}
			String request = String.valueOf(targetString).replaceAll("> <", "><");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("var t = document.getElementById('dataForm:xmlString'); " + "t.value = arguments[0];",
					request);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, postMessagePage.sendBtn, 50);
			postMessagePage.sendBtn.click();
			Steps.logger.info("Clicked on post message button");

		} catch (Exception exec) {
			Steps.testRes = "Failed";
			SeleniumTestHelper.fail("Error occured while entering xml : " + exec.getMessage());
			Assert.assertTrue(false);
		} finally {
			reader.close();
		}

	}

	@Then("^user verify the response$")
	public void user_verify_the_response() throws Exception {
		try {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, postMessagePage.responseTxt, 10000);
			postMessagePage.responseTxt.click();
			int noOfClick = 10;
			for (int i = 0; i < noOfClick; i++) {
				postMessagePage.responseTxt.sendKeys(Keys.ARROW_DOWN);
			}
			String responseType = postMessagePage.Validate_Response(driver, "Response_Type");
			System.out.println("responseType: " + responseType);
			Steps.logger.info("responseType: " + responseType);
			String errorType = postMessagePage.Validate_Response(driver, "Error_Type");
			if ((responseType.equals("Confirmation")) && (errorType.equals("0"))) {
				System.out.println("Receving request is successfully created");
				Reporter.addStepLog("Receving request is successfully created");
				SeleniumTestHelper.assertEquals(responseType, "Confirmation");
				SeleniumTestHelper.assertEquals(errorType, "0");
				// System.out.println("Item : " + ItemName + " successfully verified
				// in the response");
				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, postMessagePage.openWindows, 50);
				postMessagePage.openWindows.click();
				SeleniumTestHelper.Close_OpenedWindow("Post Message", driver);
			} else {
				System.out.println("Receving request has not been created");
				Reporter.addStepLog("Receving request has not been created");
				SeleniumTestHelper.fail("Receving request has not been created");
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Then("^user opens ASN screen and searches for the ASN and verify its status \"([^\"]*)\"$")
	public void user_opens_ASN_screen_and_searches_for_the_ASN_and_verify_its_status(String status) throws Exception {

		// asnsPage.verifyAsnsStatus(Items.getAsnNumber(), status);
		try {
			asnsPage.verifyAsnsStatus(Items.getAsnNumber(), status);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@And("^user verifies the ASN$")
	public void user_verifies_ASN() throws Exception {

		try {
			asnsPage.searchForTheASN(Items.getAsnNumber());
			asnsPage.verifyASN("Receiving Verified");
		Reporter.addStepLog("Receiving Verified");
			Steps.logger.info("Receiving Verified");
			homePage.userClosesOpenedwindow("ASNs");
			Steps.logger.info("Close ASN window");
			Thread.sleep(1000);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
//After ASN creation
	@And("^user views ASN, get and verify item details$")
	public void user_views_ASNscreen_and_get_itemdetails() throws Exception {
		// asnsPage.searchForTheASN(Items.getAsnNumber());
		try {
			asnsPage.searchForTheASN(Items.getAsnNumber());
			Steps.logger.info("Search for item details");
			SeleniumTestHelper.waitForElementToBeClickable(driver, asnsPage.searchedASNChkbox, 50);
			asnsPage.searchedASNChkbox.click();

			asnsPage.viewASNBtn.click();
			Steps.logger.info("Click on view ASN");
			// Thread.sleep(5000);
			SeleniumTestHelper.switchToInnerFrame(driver);
			asnsPage.GetItemDetails();
			homePage.userClosesOpenedwindow("Advance Ship Notice");
			// Thread.sleep(3000);
			SeleniumTestHelper.Close_OpenedWindow("ASNs", driver);
			Steps.logger.info("Close ASN window");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	//after receiving
	@Then("^user views ASN, and validate ASN details$")
	public void user_opens_ASN_screen_and_validate_ASN_details() throws Exception {

		try {
			asnsPage.searchForTheASN(Items.getAsnNumber());
			String asnStatus=asnsPage.asnStatus.getText();
			Steps.logger.info("Search for item details");
			SeleniumTestHelper.waitForElementToBeClickable(driver, asnsPage.searchedASNChkbox, 50);
			asnsPage.searchedASNChkbox.click();
			asnsPage.viewASNBtn.click();
			Steps.logger.info("Click on view ASN");
			// Thread.sleep(5000);
			SeleniumTestHelper.switchToInnerFrame(driver);
			asnsPage.GetItemDetails(asnStatus);
			homePage.userClosesOpenedwindow("Advance Ship Notice");
			// Thread.sleep(3000);
			SeleniumTestHelper.Close_OpenedWindow("ASNs", driver);
			Steps.logger.info("Close ASN window");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	@Then("^user views ASN, and validate ASN details after deleting a line from iLPN$")
	public void user_opens_ASN_screen_and_validate_ASN_details_after_deleting_a_line_from_an_iLPN() throws Exception {

		try {
			asnsPage.searchForTheASN(Items.getAsnNumber());
			String asnStatus=asnsPage.asnStatus.getText();
			Steps.logger.info("Search for item details");
			SeleniumTestHelper.waitForElementToBeClickable(driver, asnsPage.searchedASNChkbox, 50);
			asnsPage.searchedASNChkbox.click();
			asnsPage.viewASNBtn.click();
			Steps.logger.info("Click on view ASN");
			// Thread.sleep(5000);
			SeleniumTestHelper.switchToInnerFrame(driver);
			asnsPage.GetLineDetails(asnStatus);
			homePage.userClosesOpenedwindow("Advance Ship Notice");
			// Thread.sleep(3000);
			SeleniumTestHelper.Close_OpenedWindow("ASNs", driver);
			Steps.logger.info("Close ASN window");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@And("^user views ASN, and validate ASN details after consuming an iLPN$")
	public void user_opens_ASN_screen_and_validate_ASN_details_after_consuming_an_iLPN() throws Exception {
	try {
		asnsPage.searchForTheASN(Items.getAsnNumber());
		String asnStatus=asnsPage.asnStatus.getText();
		Steps.logger.info("Search for item details");
		SeleniumTestHelper.waitForElementToBeClickable(driver, asnsPage.searchedASNChkbox, 50);
		asnsPage.searchedASNChkbox.click();
		asnsPage.viewASNBtn.click();
		Steps.logger.info("Click on view ASN");
		// Thread.sleep(5000);
		SeleniumTestHelper.switchToInnerFrame(driver);
		asnsPage.GetLineDetails(asnStatus);
		homePage.userClosesOpenedwindow("Advance Ship Notice");
		// Thread.sleep(3000);
		SeleniumTestHelper.Close_OpenedWindow("ASNs", driver);
		Steps.logger.info("Close ASN window");
	} catch (Exception e) {
		Steps.testRes = "Failed";
		e.printStackTrace();
		Assert.assertTrue(false);
	}
}
	
	
	@Then("^user log out from application$")
	public void user_log_out_from_application() throws Exception {
		try {
			Thread.sleep(5000);
			homePage.user_logout_from_application();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@And("^user opens RF menu and completes Receiving using \"([^\"]*)\" menu for (\\d+) item in \"([^\"]*)\"$")
	public void user_opens_RF_menu_and_completes_Receiving_using_menu_for_item_in(String receivingMethod, int noOfItems,
			String recLocation) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.ASNReceivingProcess(noOfItems, receivingMethod, recLocation);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Then("^user opens RF menu and completes Receiving using \"([^\"]*)\" menu$")
	public void user_opens_RF_menu_and_completes_Receiving_using_menu(String receivingMethod) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.ASNReceivingProcess(receivingMethod);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@And("^user opens RF menu and completes Putaway using \"([^\"]*)\" menu$")
	public void user_opens_RF_menu_and_completes_Putaway(String putawayMethod) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.putawayProcess(putawayMethod);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@And("^user open reserve locations & naviagtes to \"([^\"]*)\" zone and fetches the current quantity$")
	public void fetch_current_qty_from_inspection_zone(String INSZone) throws Exception {
		try {
			homePage.MenuItems_Configuration_Selection("Reserve Locations");
			Steps.logger.info("Open Reserve Locations");
			SeleniumTestHelper.switchToInnerFrame(driver);
			resLocPage.fetchQty(INSZone);
			System.out.println("reserveLocationqty:"+resLocPage.reserveLocationqty);
			homePage.user_closes_openedwindow("Reserve Locations - Reserve Location");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	@Then("^user navigates to reserve locations & validates that the quantity is increased in \"([^\"]*)\" by no of iLPN's moved$")
	public void user_navigates_to_reserve_locations_validates_that_the_quantity_is_increased_in_by_no_of_iLPN_s_moved(String inspectionZone) throws Exception {
		try {
			homePage.MenuItems_Configuration_Selection("Reserve Locations");
			Steps.logger.info("Open Reserve Locations");
			SeleniumTestHelper.switchToInnerFrame(driver);
			resLocPage.validateQty(inspectionZone);
			homePage.user_closes_openedwindow("Reserve Locations - Reserve Location");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	

	@Then("^validates that the iLPN is also moved to inspection zone \"([^\"]*)\"$")
	public void validates_that_the_iLPN_is_also_moved_to_inspection_zone(String inspectionZone) throws Exception {
		try {
			homePage.MenuItems_Configuration_Selection("Reserve Locations");
			Steps.logger.info("Open Reserve Locations");
			SeleniumTestHelper.switchToInnerFrame(driver);
			resLocPage.validateiLPNinReserveLoc(inspectionZone);
			homePage.user_closes_openedwindow("Reserve Locations - iLPNs");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
		

	@And("^user opens RF menu and go to invenorty & perform \"([^\"]*)\" operation$")
	public void user_opens_RF_menu_and_create_iLPN(String menuOption) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.inventoryFunctions(menuOption);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@And("^user opens RF menu and \"([^\"]*)\" iLPN quantity using \"([^\"]*)\" menu in Inventory$")
	public void user_opens_RF_menu_and_modify_iLPN(String operation, String menuOption) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.modifyiLPN(operation, menuOption);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@And("^user opens RF menu and \"([^\"]*)\" from an iLPN using \"([^\"]*)\" menu in Inventory$")
	public void user_opens_RF_menu_and_delete_line_from_an_iLPN(String operation, String menuOption) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.modifyiLPN(operation, menuOption);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Then("^user opens Inventory by location screen and validates the LPN created$")
	public void user_opens_InventoryByLocation_screen_and_validates_the_LPN_created() throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("Item Inventory by Location");
			Steps.logger.info("Open Item Inventory by Location menu");
			Reporter.addStepLog("Open Item Inventory by Location menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				int actualQty = itemInvenByLocationPage.GetLPNQuantityByItemandLoc(Items.getItemsForReceivingASN(i),
						rfMenu.newSysSuggestedLoc, rfMenu.LPNVal);
				SeleniumTestHelper.assertEquals(actualQty, Integer.parseInt(Steps.ItemDataMap.get(i).get("RecQty")));
				Reporter.addStepLog("Actual Qty is- " + actualQty + " & Expected qty is- "
						+ Integer.parseInt(Steps.ItemDataMap.get(i).get("RecQty")));
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Then("^user search for the LPN in iLPN screen, and validate the lock code$")
	public void user_search_for_the_LPN_in_iLPN_screen_and_validate_the_lock_code() throws Exception {
		try {
			iLPNPage.validateiLPNLockCode();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
			
		}
	}
	
	@Then("^user search for the LPN in iLPN screen, and validate the modification \"([^\"]*)\" in iLPN$")
			public void user_opens_iLPN_and_validate_change_in_iLPN(String opeartion) throws Exception {
				try {
						iLPNPage.validateiLPNModification(opeartion);
				} catch (Exception e) {
					Steps.testRes = "Failed";
					e.printStackTrace();
					Assert.assertTrue(false);
				}
			}
	
	@Then("^user search for the LPN in iLPN screen, and validate the iLPN status$")
	public void user_opens_iLPN_and_validate_iLPN_status() throws Exception {
		homePage.MenuItems_Distribution_Selection("iLPNs");
		SeleniumTestHelper.switchToInnerFrame(driver);
		try {
			for (int i = 0; i < RFMenuPage.iLPNz.size(); i++) {
				iLPNPage.searchForTheILPNAndViewIt(RFMenuPage.iLPNz.get(i));
				iLPNPage.validateiLPNStatusAndQty();
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@And("user open iLPN and applies the lock code")
	public void user_opens_iLPN_and_apply_lockCode() throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("iLPNs");
			Steps.logger.info("Open iLPN screen");
			SeleniumTestHelper.switchToInnerFrame(driver);
			for (int i = 0; i < RFMenuPage.iLPNz.size(); i++) {
				iLPNPage.searchForTheILPNAndViewIt(RFMenuPage.iLPNz.get(i));
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNPage.LocksTab, 50);
				iLPNPage.lockiLPN();
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@And("user open iLPN and unlock the existing code")
	public void user_opens_iLPN_and_unlock_the_exisitng_code() throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("iLPNs");
			Steps.logger.info("Open iLPN screen");
			SeleniumTestHelper.switchToInnerFrame(driver);
			for (int i = 0; i < RFMenuPage.iLPNz.size(); i++) {
				iLPNPage.searchForTheILPNAndViewIt(RFMenuPage.iLPNz.get(i));
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNPage.LocksTab, 50);
				iLPNPage.unlockiLPN();
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@And("^validates the PIX Transactions \"([^\"]*)\" for this operation$")
	public void validate_PIX_transaction(String PixCode) throws Exception {
		
		try {
			String[] pixCodeArr = null;
			if (PixCode.contains(",")) {
				pixCodeArr = PixCode.split(",");
			} else {
				pixCodeArr = new String[] { PixCode };
			}
			pixTransaction.validatePixTransactionforLock_Unlock(pixCodeArr);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	@And("^validates the PIX Transactions \"([^\"]*)\" for modifying iLPN$")
	public void validate_PIX_transaction_for_modifying_iLPN(String PixCode) throws Exception {
		
		try {
			String[] pixCodeArr = null;
			if (PixCode.contains(",")) {
				pixCodeArr = PixCode.split(",");
			} else {
				pixCodeArr = new String[] { PixCode };
			}
			pixTransaction.validatePixTransactionforModifyiLPN(pixCodeArr);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	

	@And("^validates the PIX Transactions \"([^\"]*)\" for consuming iLPN$")
	public void validate_PIX_transaction_for_consuming_iLPN(String PixCode) throws Exception {
		
		try {
			String[] pixCodeArr = null;
			if (PixCode.contains(",")) {
				pixCodeArr = PixCode.split(",");
			} else {
				pixCodeArr = new String[] { PixCode };
			}
			pixTransaction.validatePixTransactionforconsumingiLPN(pixCodeArr);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}

	@Then("^user opens Inventory by location screen and validates the LPN moved$")
	public void user_opens_InventoryByLocation_screen_and_validates_the_LPN_moved() throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("Item Inventory by Location");
			Steps.logger.info("Open Item Inventory by Location menu");
			Reporter.addStepLog("Open Item Inventory by Location menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			itemInvenByLocationPage.GetMovedLPNQuantityByItemandLoc(Items.getItemsForReceivingASN(0),
					Steps.scenarioData.get("RecLocation"), rfMenu.iLPNz);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Then("^user break Split LPN and move to another LPN of same ASN$")
	public void user_Break_Split_LPN_and_move_to_another_LPN_of_same_ASN() throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.split_Move_iLPN_for_same_Item();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);

		}
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
