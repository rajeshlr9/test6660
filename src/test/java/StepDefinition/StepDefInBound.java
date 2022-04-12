package StepDefinition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.Items;
import globalFunc.FileUtilities;
import globalFunc.Screenshots;
import globalFunc.UnZipUtility;
import pages.AsnsPage;
import pages.HomePage;
import pages.ILPNPage;
import pages.ItemInvenByLocationPage;
import pages.ItemsPage;
import pages.ManhattanLoginPage;
import pages.PixTransactionPage;
import pages.PostMessagePage;
import pages.RFMenuPage;
import pages.ReserveLocationPage;
import reusable.FedexnetPage;
import reusable.KelliPages;
import reusable.ModifyXML;
import reusable.ValidateFilesAfterReceving;
import utils.Config;
import utils.SeleniumTestHelper;
import utils.Xpathxml;

public class StepDefInBound {
	WebDriver driver = Steps.seleniumDriver;
	Xpathxml xmlInput = new Xpathxml();
	Steps st=new Steps();
	ManhattanLoginPage manhattanLoginPage = new ManhattanLoginPage();
	FedexnetPage FedexnetPage = new FedexnetPage();
	HomePage homePage = new HomePage();
	PostMessagePage postMessagePage = new PostMessagePage();
	AsnsPage asnsPage = new AsnsPage();
	RFMenuPage rfMenu = new RFMenuPage();
	ILPNPage iLPNPage = new ILPNPage();
	ItemInvenByLocationPage itemInvenByLocationPage = new ItemInvenByLocationPage();
	PixTransactionPage pixTransaction = new PixTransactionPage();
	ReserveLocationPage resLocPage = new ReserveLocationPage();
	ItemsPage itemsPage= new ItemsPage();
	ValidateFilesAfterReceving vfr = new ValidateFilesAfterReceving();

	String itemName = null;
	String GtinNum = null;
	String ItemBarCode = null;
	String SerialNumReq = null;
	String miscellaneous1 = null;
	String miscellaneous2 = null;
	String miscellaneous4 = null;
	String velocityCode = null;

	public StepDefInBound() throws Throwable { 
		// this.driver =
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
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@When("^user logs into Manhattan application using \"([^\"]*)\" Credentials$")
	public void user_logs_into_Manhattan_application(String userType) throws Exception {
		try {
			// driver = CreateBrowser.CreateBrowserInstance();
			// Steps.logger.info("Browser Instance created");

			String env = ManhattanLoginPage.environment;
			System.out.println("Environment:"+env);

			if (env.equalsIgnoreCase("L1")|| env.equalsIgnoreCase("@Env")) {
				driver.get(Config.getProperty("ManhattanURL_L1"));
				Steps.logger.info("L1 Environment");
			} else if (env.equalsIgnoreCase("L2") ) {
				driver.get(Config.getProperty("ManhattanURL_L2"));
				Steps.logger.info("L2 Environment");
			}
				else if (env.equalsIgnoreCase("L4")) {
					driver.get(Config.getProperty("ManhattanURL_L4"));
					Steps.logger.info("L4 Environment");
			}
			manhattanLoginPage.loginToManhattanApp(userType);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@And("user logs into the Manhattan application")
	public void user_logs_into_the_Manhattan_application() {
		try {
			String env = ManhattanLoginPage.environment;
			System.out.println("Environment:"+env);

			if (env.equalsIgnoreCase("L1")|| env.equalsIgnoreCase("@Env")) {
				driver.get(Config.getProperty("ManhattanURL_L1"));
				Steps.logger.info("L1 Environment");
			} else if (env.equalsIgnoreCase("L2") ) {
				driver.get(Config.getProperty("ManhattanURL_L2"));
				Steps.logger.info("L2 Environment");
			} else if (env.equalsIgnoreCase("L4")) {
					driver.get(Config.getProperty("ManhattanURL_L4"));
					Steps.logger.info("L4 Environment Manhattan URL :"+Config.getProperty("ManhattanURL_L4"));
			}else if (env.equalsIgnoreCase("L5")) {
				driver.get(Config.getProperty("ManhattanURL_L5"));
				Steps.logger.info("L5 Environment");
			}
			manhattanLoginPage.loginToManhattanApp();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	//********************************************FedexNet******************************************
		//FedexNet
		@Then("^user logs into the FedexNet application$")
		public void user_logs_into_the_FedexNet_application() {
		try {
			String env = Config.getProperty("Environment");
			System.out.println("Environment:"+env);

			if (env.equalsIgnoreCase("L1")|| env.equalsIgnoreCase("@Env") || env.equalsIgnoreCase("L2")) {
				driver.get(Config.getProperty("FedexNetURL_DEV"));
				Steps.logger.info("Dev Environment");
				
			} else if (env.equalsIgnoreCase("L3") ) {
				driver.get(Config.getProperty("FedexNetURL_TEST"));
				Steps.logger.info("TEST Environment");
			}else if (env.equalsIgnoreCase("L4")) {
					driver.get(Config.getProperty("FedexNetURL_STAGE"));
					Steps.logger.info("STAGE Environment");
			}else if (env.equalsIgnoreCase("L5")) {
				driver.get(Config.getProperty("FedexNetURL_DEV"));
				Steps.logger.info("Dev Environment");
			}
			FedexnetPage.logintoFedexNet();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
		}
		
		@And("^user upload \"([^\"]*)\" XML file in fedexnet$")
		public void user_upload_the_xml_in_fedexnet(String fileType) {
		try {
			String env = ManhattanLoginPage.environment;
			System.out.println("Environment:"+env);
			String dropEnv=null;
			if (env.equalsIgnoreCase("L1")|| env.equalsIgnoreCase("@Env") || env.equalsIgnoreCase("L2")) {
				dropEnv="FSCS";
				
			} else if (env.equalsIgnoreCase("L3") ) {
				dropEnv="FSCSQA";
			}
				else if (env.equalsIgnoreCase("L4")) {
					dropEnv="FSCSQA";
			}
				else if (env.equalsIgnoreCase("L5")) {
					System.out.println("L5 Env - FSCSUA");
					dropEnv="FSCSUA";
			}
			if(fileType.equals("856")||fileType.equals("943")) {			
			FedexnetPage.dropOrder(dropEnv, fileType, xmlInput.inputEDIInboundFilePath);
			}else if(fileType.equals("850")||fileType.equals("940")) {			
				FedexnetPage.dropOrder(dropEnv, fileType, xmlInput.inputEDIOutboundFilePath);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		}
		
		@Then("^user log out from Fedenxet application$")
		public void user_logout_from_fedexnet() {
			try {
				FedexnetPage.logoutApplication();
		}catch(Exception e){
			System.out.println(e);
		}
		}
		
	//********************************************FedexNet******************************************
	
	@When("^user create xml file with Item Value updated with DeliveryStartDate for ReceivingASN$")
	public void user_create_xml_file_with_updated_DeliveryStartDate_for_ReceivingASN() throws Exception {
		try {
			Steps.logger.info("XML creation started");
			xmlInput.user_create_inputXML_for_inbound_basedOn_noOfItem(Steps.ItemDataMap.get(0).get("Qty"));
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
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
			Assert.assertTrue(false, e.getMessage());
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
			Assert.assertTrue(false, e.getMessage());
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
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@When("^user update \"([^\"]*)\" for dropping into fedexnet application$")
	public void user_update_EDI_XML_file_for(String xmlType)	throws Exception {
		try {
			Steps.logger.info("XML updation started");
			xmlInput.user_create_EDI_file(xmlType);
			xmlInput.user_modify_EDI_file(xmlType);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@When("^user update \"([^\"]*)\" for dropping into fedexnet application with \"([^\"]*)\",\"([^\"]*)\"$")
	public void user_update_for_dropping_into_fedexnet_application_with(String arg1, String arg2, String arg3) throws Throwable {
		try {
			Steps.logger.info("XML updation started");
			xmlInput.user_create_EDI_file(arg1);
			xmlInput.user_modify_EDI_file(arg1,arg2,arg3);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
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
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@When("^user opens post message screen and upload file in order to create ASN$")
	public void user_opens_post_message_screen_and_upload_file_in_order_to_create_ASN() throws Exception {
		// String isjenkinJob = Runner.jenkinJobName;
		BufferedReader reader = null;
		try {
		homePage.menuItemsIntegrationSelection("Post Message");
		Steps.logger.info("Open Post message screen");
		Screenshots.captureSnapshot(driver);

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
			Screenshots.captureSnapshot(driver);

		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
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
				Screenshots.captureSnapshot(driver);
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
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^fetches the actual ASN number and PO Number uploaded from Kelli$")
	public void fetch_ASN_And_PO_Number() {
		try {
			asnsPage.getASNandPONumber(KelliPages.partialASNValue);
			Steps.logger.info("ASN_No:"+Items.getAsnNumber());
			Reporter.addStepLog("ASN_No:"+Items.getAsnNumber());
			Steps.logger.info("PO_No:"+Items.getPONumber());
			Reporter.addStepLog("PO_No:"+Items.getPONumber());
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user opens ASN screen and searches for the ASN to be not available in Manhattan$")
	public void user_opens_ASN_screen_and_searches_for_the_ASN_to_be_not_available_in_Manhattan() throws Exception {

		// asnsPage.verifyAsnsStatus(Items.getAsnNumber(), status);
		try {
			asnsPage.verifyAsn(Items.getAsnNumber());
			
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
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
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	
	
	@Then("^user opens ASN screen and searches for the 2nd ASN and verify its status \"([^\"]*)\"$")
	public void user_opens_ASN_screen_and_searches_for_the_2nd_ASN_and_verify_its_status(String status) throws Exception {

		// asnsPage.verifyAsnsStatus(Items.getAsnNumber(), status);
		try {
			asnsPage.verifyAsnsStatus(Items.getAsnNumber2(), status);
			
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user verifies the ASN \"([^\"]*)\"$")
	public void user_verifies_ASN(String VerifyASN) throws Exception {

		try {
			asnsPage.searchForTheASN(Items.getAsnNumber());
			asnsPage.verifyASN(VerifyASN);
		Reporter.addStepLog("Receiving Verified");
			Steps.logger.info("Receiving Verified");
			homePage.userClosesOpenedwindow("ASNs");
			Steps.logger.info("Close ASN window");
			Thread.sleep(1000);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
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
			Screenshots.captureSnapshot(driver);
			asnsPage.GetItemDetails();
			homePage.userClosesOpenedwindow("Advance Ship Notice");
			// Thread.sleep(3000);
			SeleniumTestHelper.Close_OpenedWindow("ASNs", driver);
			Steps.logger.info("Close ASN window");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
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
			Screenshots.captureSnapshot(driver);
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
			Assert.assertTrue(false, e.getMessage());
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
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			asnsPage.GetLineDetails(asnStatus);
			homePage.userClosesOpenedwindow("Advance Ship Notice");
			// Thread.sleep(3000);
			SeleniumTestHelper.Close_OpenedWindow("ASNs", driver);
			Steps.logger.info("Close ASN window");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
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
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		asnsPage.GetLineDetails(asnStatus);
		homePage.userClosesOpenedwindow("Advance Ship Notice");
		// Thread.sleep(3000);
		SeleniumTestHelper.Close_OpenedWindow("ASNs", driver);
		Steps.logger.info("Close ASN window");
	} catch (Exception e) {
		Steps.testRes = "Failed";
		e.printStackTrace();
		Assert.assertTrue(false, e.getMessage());
	}
}
	
	
	@Then("^user log out from application$")
	public void user_log_out_from_application() throws Exception {
		try {
			Thread.sleep(2000);
			homePage.user_logout_from_application();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@And("^user opens RF menu and completes Receiving using \"([^\"]*)\" menu for (\\d+) item in \"([^\"]*)\"$")
	public void user_opens_RF_menu_and_completes_Receiving_using_menu_for_item_in(String receivingMethod, int noOfItems,
			String recLocation) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.ASNReceivingProcess(noOfItems, receivingMethod, recLocation);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user opens RF menu and completes Receiving using \"([^\"]*)\" menu$")
	public void user_opens_RF_menu_and_completes_Receiving_using_menu(String receivingMethod) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.ASNReceivingProcess(receivingMethod);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			System.out.println("line number"+e.getStackTrace()[0].getLineNumber() );
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And ("^user opens RF menu and completes \"([^\"]*)\" operation in Misc menu$")
	public void user_opens_RF_menu_and_perform_transaction_in_Misc_option(String operation) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.Miscellaneous(operation);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user opens RF menu and completes Putaway using \"([^\"]*)\" menu$")
	public void user_opens_RF_menu_and_completes_Putaway(String putawayMethod) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.putawayProcess(putawayMethod);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user open reserve locations & naviagtes to \"([^\"]*)\" zone and fetches the current quantity$")
	public void fetch_current_qty_from_inspection_zone(String INSZone) throws Exception {
		try {
			homePage.MenuItems_Configuration_Selection("Reserve Locations");
			Steps.logger.info("Open Reserve Locations");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			
			String env = ManhattanLoginPage.environment;
			System.out.println("Environment:"+env);
			
			resLocPage.fetchQty(INSZone);
			System.out.println("reserveLocationqty:"+resLocPage.reserveLocationqty);
			homePage.user_closes_openedwindow("Reserve Locations - Reserve Location");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
		
	}
	
	//Rakesh
	@And("^user open reserve locations and naviagtes to validate iLPN$")
	public void  user_open_reserve_locations_and_naviagtes_to_validate_iLPN() throws Exception {
		try {
			homePage.MenuItems_Configuration_Selection("Reserve Locations");
			Steps.logger.info("Open Reserve Locations");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			resLocPage.validateiLPNinReserveLoc();
			System.out.println("reserveLocationqty:"+resLocPage.reserveLocationqty);
			homePage.user_closes_openedwindow("Reserve Locations - iLPNs");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
		
	}
	
	@Then("^user navigates to reserve locations & validates that the quantity is increased in \"([^\"]*)\" by no of iLPN's moved$")
	public void user_navigates_to_reserve_locations_validates_that_the_quantity_is_increased_in_by_no_of_iLPN_s_moved(String inspectionZone) throws Exception {
		try {
			homePage.MenuItems_Configuration_Selection("Reserve Locations");
			Steps.logger.info("Open Reserve Locations");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			resLocPage.validateQty(inspectionZone);
			homePage.user_closes_openedwindow("Reserve Locations - Reserve Location");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	

	@Then("^validates that the iLPN is also moved to inspection zone \"([^\"]*)\"$")
	public void validates_that_the_iLPN_is_also_moved_to_inspection_zone(String inspectionZone) throws Exception {
		try {
			homePage.MenuItems_Configuration_Selection("Reserve Locations");
			Steps.logger.info("Open Reserve Locations");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			resLocPage.validateiLPNinReserveLoc(inspectionZone);
			homePage.user_closes_openedwindow("Reserve Locations - iLPNs");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
		

	@And("^user opens RF menu and go to invenorty & perform \"([^\"]*)\" operation$")
	public void user_opens_RF_menu_and_create_iLPN(String menuOption) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.inventoryFunctions(menuOption);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user opens RF menu and \"([^\"]*)\" iLPN quantity using \"([^\"]*)\" menu in Inventory$")
	public void user_opens_RF_menu_and_modify_iLPN(String operation, String menuOption) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.modifyiLPN(operation, menuOption);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user opens RF menu and \"([^\"]*)\" from an iLPN using \"([^\"]*)\" menu in Inventory$")
	public void user_opens_RF_menu_and_delete_line_from_an_iLPN(String operation, String menuOption) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.modifyiLPN(operation, menuOption);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	
	@Then("^user opens iLPN screen and validate iLPN status \"([^\"]*)\"$")
		public void user_opens_iLPN_screen_and_validates_iLPN_status(String iLPNStatus) throws Exception {
		
		try {
			homePage.MenuItems_Distribution_Selection("iLPNs");
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("iLPNs screen opened");
			SeleniumTestHelper.switchToInnerFrame(driver);
			iLPNPage.verifyiLPNStatus(iLPNStatus);
			homePage.userClosesOpenedwindow("iLPNs");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
		
	}
	
	@Then("^user opens Inventory by location screen and validates the LPN created$")
	public void user_opens_InventoryByLocation_screen_and_validates_the_LPN_created() throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("Item Inventory by Location");
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Open Item Inventory by Location menu");
			Reporter.addStepLog("Open Item Inventory by Location menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				int actualQty = itemInvenByLocationPage.GetLPNQuantityByItemandLoc(Items.getItemsForReceivingASN(i),
						rfMenu.newSysSuggestedLoc, rfMenu.LPNVal);
			System.out.println(actualQty);
				SeleniumTestHelper.assertEquals(actualQty, Integer.parseInt(Steps.ItemDataMap.get(i).get("RecQty")));
				//Reporter.addStepLog("Actual Qty is- " + actualQty + " & Expected qty is- "
					//	+ Integer.parseInt(Steps.ItemDataMap.get(i).get("RecQty")));
				Reporter.addStepLog("iLPN is created & it matches the qty received");
				homePage.user_closes_openedwindow("Item Inventory by Location - iLPNs");
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user search for the LPN in iLPN screen, and validate the lock code$")
	public void user_search_for_the_LPN_in_iLPN_screen_and_validate_the_lock_code() throws Exception {
		try {
			iLPNPage.validateiLPNLockCode();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
			
		}
	}
	
	@Then("^user search for the LPN in iLPN screen, and validate the modification \"([^\"]*)\" in iLPN$")
			public void user_opens_iLPN_and_validate_change_in_iLPN(String opeartion) throws Exception {
				try {
						iLPNPage.validateiLPNModification(opeartion);
				} catch (Exception e) {
					Steps.testRes = "Failed";
					e.printStackTrace();
					Assert.assertTrue(false, e.getMessage());
				}
			}
	
	@Then("^user search for the LPN in iLPN screen, and validate the iLPN status$")
	public void user_opens_iLPN_and_validate_iLPN_status() throws Exception {
		homePage.MenuItems_Distribution_Selection("iLPNs");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		try {
			//for (int i = 0; i < RFMenuPage.iLPNz.size(); i++) {
			for (int i = 0; i < Items.getLpnsLength(); i++) {	
				//iLPNPage.searchForTheILPNAndViewIt(RFMenuPage.iLPNz.get(i));
				iLPNPage.searchForTheILPNAndViewIt(Items.getLpns(i));
				iLPNPage.validateiLPNStatusAndQty();
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@And("user open iLPN and applies the lock code")
	public void user_opens_iLPN_and_apply_lockCode() throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("iLPNs");
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Open iLPN screen");
			SeleniumTestHelper.switchToInnerFrame(driver);
			//for (int i = 0; i < RFMenuPage.iLPNz.size(); i++) {
			for (int i = 0; i < Items.getLpnsLength(); i++) {
				//iLPNPage.searchForTheILPNAndViewIt(RFMenuPage.iLPNz.get(i));
				iLPNPage.searchForTheILPNAndViewIt(Items.getLpns(i));
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNPage.LocksTab, 50);
				iLPNPage.lockiLPN();
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("user open iLPN and unlock the existing code")
	public void user_opens_iLPN_and_unlock_the_exisitng_code() throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("iLPNs");
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Open iLPN screen");
			SeleniumTestHelper.switchToInnerFrame(driver);
		//	for (int i = 0; i < RFMenuPage.iLPNz.size(); i++) {
			for (int i = 0; i < Items.getLpnsLength(); i++) {			
				//iLPNPage.searchForTheILPNAndViewIt(RFMenuPage.iLPNz.get(i));
				iLPNPage.searchForTheILPNAndViewIt(Items.getLpns(i));
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNPage.LocksTab, 50);
				iLPNPage.unlockiLPN();
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
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
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^validates the PIX message \"([^\"]*)\"$")
	public void validate_PIX_transactions(String PixTrans) throws Exception {
		
		try {
			pixTransaction.checkForPixTransaction(PixTrans);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
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
			Assert.assertTrue(false, e.getMessage());
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
			Assert.assertTrue(false, e.getMessage());
		}
		
	}

	@Then("^user opens Inventory by location screen and validates the LPN moved$")
	public void user_opens_InventoryByLocation_screen_and_validates_the_LPN_moved() throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("Item Inventory by Location");
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Open Item Inventory by Location menu");
			Reporter.addStepLog("Open Item Inventory by Location menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			itemInvenByLocationPage.GetMovedLPNQuantityByItemandLoc(Items.getItemsForReceivingASN(0),Steps.scenarioData.get("RecLocation"),Items.getAllLpns());
					//Steps.scenarioData.get("RecLocation"), rfMenu.iLPNz);
					
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user break Split LPN and move to another LPN of same ASN$")
	public void user_Break_Split_LPN_and_move_to_another_LPN_of_same_ASN() throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Open RF menu");
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.split_Move_iLPN_for_same_Item();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());

		}
	}

	@Then("^user verifies new ASN is created with remaining qty$")
	public void user_verifies_new_ASN_is_created_with_remaining_qty() throws Exception {
		try {
			Steps.logger.info("Validating newly created ASN");
			System.out.println(Items.getPONumber()+"-2");
			Items.setAsnNumber2(Items.getPONumber()+"-2");
			asnsPage.verifyAsnsStatus(Items.getPONumber()+"-2", "20 - InTransit");
			asnsPage.searchForTheASN(Items.getPONumber()+"-2");
			Steps.logger.info("New ASN is created automatically with ASN: "+Items.getPONumber()+"-2");
			Steps.logger.info("Started validating item details");
			SeleniumTestHelper.waitForElementToBeClickable(driver, asnsPage.searchedASNChkbox, 50);
			asnsPage.searchedASNChkbox.click();
			asnsPage.viewASNBtn.click();
			Steps.logger.info("Click on view ASN");
			// Thread.sleep(5000);
			SeleniumTestHelper.switchToInnerFrame(driver);
			Screenshots.captureSnapshot(driver);
			asnsPage.validateNewlyCreatedASN();
			homePage.userClosesOpenedwindow("Advance Ship Notice");
			// Thread.sleep(3000);
			SeleniumTestHelper.Close_OpenedWindow("ASNs", driver);
			Steps.logger.info("Close ASN window");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Then("^user opens Items screen and validate Item creation$")
	public void validate_Item_Creation() {
		try {
			itemsPage.verify_Items_creation();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
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
	
	@And ("^user opens RF menu and completes split move using \"([^\"]*)\" operation in Misc menu$")
	public void user_opens_RF_menu_and_completes_split_move_in_Misc_option(String operation) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.SplitAndMoveUsingMiscellaneous(operation,true);
			Reporter.addStepLog("Completed Split and Move from Misc Menu");
			Steps.logger.info("Completed Split and Move from Misc Menu");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And ("^user opens RF menu and performs split move using \"([^\"]*)\" operation in Misc menu$")
	public void user_opens_RF_menu_and_performs_split_move_in_Misc_option(String operation) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.SplitAndMoveUsingMiscellaneous(operation,false);
			Reporter.addStepLog("Performed Split and Move from Misc Menu.");
			Steps.logger.info("Performed Split and Move from Misc Menu");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user verify the \"([^\"]*)\" file in fedexnet$")
	public void user_verify_the_861_file_in_fedexnet(String fileType) throws Exception {
		try {
			String env = ManhattanLoginPage.environment;
			String tpid = null;
			if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env") || env.equalsIgnoreCase("L2")) {
				tpid = "FSCS";
			} else if (env.equalsIgnoreCase("L3")) {
				tpid = "FSCSQA";
			} else if (env.equalsIgnoreCase("L4")) {
				tpid = "FSCSQA";
			} else if (env.equalsIgnoreCase("L5")) {
				tpid = "FSCSUA";
			}
			Steps.logger.info("Sender Qual Code - TPID	:" + tpid);

			if (fileType.equals("856") || fileType.equals("943")) {
				Steps.logger.info("Verify 856 Files");
				if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env") || env.equalsIgnoreCase("L2")) {
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Validation of 856 File");
					FedexnetPage.verify861And856Files(tpid, "856", "");
					String fileNameRetrieved = vfr.downloadTheFileFromFedexNet(tpid, "856");
					Steps.logger.info("File name retrieved  :"+fileNameRetrieved);
					FileUtilities.verifyOrderNumIn856File(fileNameRetrieved);
				} else if (env.equalsIgnoreCase("L4")) {
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Validation of 856 File");
					FedexnetPage.verify861And856Files(tpid, "856QA", "");
					String fileNameRetrieved = vfr.downloadTheFileFromFedexNet(tpid, "856QA");
					Steps.logger.info(fileNameRetrieved);
					FileUtilities.verifyOrderNumIn856File(fileNameRetrieved);
				} else if (env.equalsIgnoreCase("L5")) {
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Validation of 856 File");
					FedexnetPage.verify861And856Files(tpid, "856UA", "");
					String fileNameRetrieved = vfr.downloadTheFileFromFedexNet(tpid, "856UA");
					Steps.logger.info(fileNameRetrieved);
					FileUtilities.verifyOrderNumIn856File(fileNameRetrieved);
				}
				
				Reporter.addStepLog("Verified the 856 Files");
			} else if (fileType.equals("850") || fileType.equals("940")) {
				Steps.logger.info("Verify 850 Files");
			} else if (fileType.equals("861")) {
				Steps.logger.info("Verify 861 Files");
				if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env") || env.equalsIgnoreCase("L2")) {
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Validation of 861 File");
					FedexnetPage.verify861And856Files(tpid, "861", "");
					String fileNameRetrieved = vfr.downloadTheFileFromFedexNet(tpid, "861");
					Steps.logger.info(fileNameRetrieved);
					FileUtilities.verifyOrderNumIn856File(fileNameRetrieved);
				} else if (env.equalsIgnoreCase("L4")) {
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Validation of 861 File");
					FedexnetPage.verify861And856Files(tpid, "861QA", "");
					String fileNameRetrieved = vfr.downloadTheFileFromFedexNet(tpid, "861QA");
					Steps.logger.info(fileNameRetrieved);
					FileUtilities.verifyOrderNumIn856File(fileNameRetrieved);
				}  else if (env.equalsIgnoreCase("L5")) {
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Validation of 861 File");
					FedexnetPage.verify861And856Files(tpid, "861UA", "");
					String fileNameRetrieved = vfr.downloadTheFileFromFedexNet(tpid, "861UA");
					Steps.logger.info(fileNameRetrieved);
					FileUtilities.verifyOrderNumIn856File(fileNameRetrieved);
				}
				Reporter.addStepLog("Verified the 856 Files");
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	//Login to FedexNet for Verify 861 and 856 files
	@Then("^user logs into the FedexNet application for verify files$")
	public void user_logs_into_the_FedexNet_application_for_verify_files()throws Exception {
		try {
			String env = Config.getProperty("Environment");

			if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env") || env.equalsIgnoreCase("L2")) {
				driver.get(Config.getProperty("FedexNetURL_DEV"));
				Steps.logger.info("Dev Environment");
			} else if (env.equalsIgnoreCase("L3")) {
				driver.get(Config.getProperty("FedexNetURL_TEST"));
				Steps.logger.info("TEST Environment");
			} else if (env.equalsIgnoreCase("L4")) {
				driver.get(Config.getProperty("FedexNetURL_STAGE"));
				Steps.logger.info("STAGE Environment");
			} else if (env.equalsIgnoreCase("L5")) {
				driver.get(Config.getProperty("FedexNetURL_DEV"));
				Steps.logger.info("Dev Environment");
			}
			Steps.logger.info("Trying to Login to FedexNet For 861/856 File Validation");
			FedexnetPage.logintoFedexNetForFileValidation();
			Steps.logger.info("User Logged In to FedexNet");
			Reporter.addStepLog("Logged In to FedexNet Application Successfully...");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
}
