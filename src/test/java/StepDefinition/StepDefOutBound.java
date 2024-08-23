package StepDefinition;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.DistributionOrders;
import entity.Items;
import globalFunc.Screenshots;
import pages.AsnsPage;
import pages.DistributionOrderProfilesPage;
import pages.DistributionOrdersPage;
import pages.HomePage;
import pages.ILPNPage;
import pages.ManhattanLoginPage;
import pages.OlpnsPage;
import pages.OrderConsolidationLocationPage;
import pages.PostMessagePage;
import pages.RFMenuPage;
import pages.ShipmentPlanningWorkspace;
import pages.TasksPage;
import pages.WavesPage;
import pages.WeighAndManifestoLPNPage;
import utils.SeleniumTestHelper;
import utils.Xpathxml;

public class StepDefOutBound {
	WebDriver driver = Steps.seleniumDriver;
	HomePage homePage1 = new HomePage();
	DistributionOrdersPage doPage = new DistributionOrdersPage();
	DistributionOrderProfilesPage DOProfilepage =  new DistributionOrderProfilesPage();
	WavesPage wavePage= new WavesPage();
	TasksPage taskPage= new TasksPage();
	//New Raka
	AsnsPage asnsPage = new AsnsPage();
	HomePage homePage = new HomePage();
	RFMenuPage rfMenu= new RFMenuPage();
	OlpnsPage oLPNspage = new OlpnsPage();
	ILPNPage iLPNPage = new ILPNPage();
	Xpathxml xmlInput= new Xpathxml();
	OrderConsolidationLocationPage oCLPage = new OrderConsolidationLocationPage();
	PostMessagePage postMessagePage = new PostMessagePage();

	public StepDefOutBound() {

	}
	@When("^user create xml file using \"([^\"]*)\" with updated DO_No$")
	public void user_create_xml_file_with_updated_DO_No(String orderType) throws Exception {
		try {
			Steps.logger.info("XML creation started");
			xmlInput.create_xmlFile_for_DistributionOrder_to_upload(orderType);
			Steps.scenario.write("DO-" + Items.getDONumber());
			Reporter.addStepLog("DO-" + Items.getDONumber());
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user update xml itemDetails from excel sheet for DO$")
	public void user_update_xml_itemDetails_from_sheet_for_DO() throws Exception {

		try {
			Steps.logger.info("XML creation started");
			xmlInput.update_details_for_DistributionOrder_to_upload();
			
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@When("^user opens post message screen and upload file in order to create DO$")
	public void user_opens_post_message_screen_and_upload_file_in_order_to_create_DO() throws Exception {
		// String isjenkinJob = Runner.jenkinJobName;
		BufferedReader reader = null;
		try {
		homePage.menuItemsIntegrationSelection("Post Message");
		Steps.logger.info("Open Post message screen");
		Screenshots.captureSnapshot(driver);

			reader = new BufferedReader(new FileReader(new File(xmlInput.inputOBFilePath)));
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

	@And("user opens Distribution Order Profile in order to create DO")
	public void user_opens_Distribution_Order_Profile_in_order_to_create_DO() throws Exception {
		try {

			homePage1.MenuItems_Distribution_Selection("Distribution Order Profiles");
			Steps.logger.info("Distribution Order Profiles page opened");
			DOProfilepage.createDistributionOrder();
			Reporter.addStepLog("DO Order created successfully");
			Reporter.addStepLog("DO Number: "+Items.getDONumber());
			Steps.logger.info("DO Order created successfully");
			Steps.logger.info("DO Number: "+Items.getDONumber());

		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Then("^user verify the response for DO creation$")
	public void user_verify_the_response_for_DO_Creation() throws Exception {
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
				System.out.println("DO is successfully created");
				Reporter.addStepLog("DO is successfully created");
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
				System.out.println("DO request has not been created");
				Reporter.addStepLog("DO request has not been created");
				SeleniumTestHelper.fail("DO request has not been created");
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@And("^user opens DO screen and searches for the DistributionOrder and verify its status \"([^\"]*)\"$")
	public void user_opens_DOscreen_andsearches_for_DOstatus(String status)	throws Exception {
		try {
			String env = ManhattanLoginPage.environment;
			//if(status.equalsIgnoreCase("110 - Released") && env.equalsIgnoreCase("L2")) {
			if(status.equalsIgnoreCase("110 - Released")) {
				doPage.getDOStatusUsingFulfillment(status);
			}
			else {
				doPage.getDoStatus(status);
			}
			//doPage.getDoStatus(status);
			Reporter.addStepLog("DO Order status is verified successfully");
			Steps.logger.info("DO Order status is verified successfully");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@And("^user get the serial numbers from iLPNs menu$")
	public void user_gets_serialnumbers() {
		try {
			doPage.GetSerialNumber();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	@And("^user opens DO screen and searches for the DO$")
	public void user_opens_DOscreen_andsearches_for_DO()	throws Exception {
		try {
			doPage.getDO();
			Reporter.addStepLog("DO Order status is verified successfully");
			Steps.logger.info("DO Order status is verified successfully");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user cancels the DO$")
	public void user_cancels_the_DO()	throws Throwable {
		try {
			doPage.cancelDOAndClickConfirmButton();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user updates the shipVia$")
	public void user_updates_the_shipVia()	throws Throwable {
		try {
			doPage.updateShipVia();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Then("^user verifies the item details in Distribuion Order page$")
	public void user_verifies_the_item_details_in_Distribuion_Order_page() throws Exception {
		try {
			Reporter.addStepLog("DO Order item details verified successfully");
			doPage.getDOdetails();
			Steps.logger.info("DO Order item details verified successfully");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@And("^user verifies the oLPN details in Distribuion Order page$")
	public void user_verifies_the_oLPN_details_in_Distribuion_Order_page() throws Exception {
		try {
			Thread.sleep(3000);
			doPage.checkOnlyoLPNSstatus();
			//Reporter.addStepLog("DO Order item details verified successfully");
			//Steps.logger.info("DO Order item details verified successfully");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user opens the oLPN details in Distribuion Order page and and verify its status \"([^\"]*)\"$")
	public void user_opens_the_oLPN_details_in_Distribuion_Order_page_and_and_verify_its_status(String status) throws Exception {
		try {
			Thread.sleep(3000);
			doPage.checkOnlyoLPNSstatus(status);
			//Reporter.addStepLog("DO Order item details verified successfully");
			//Steps.logger.info("DO Order item details verified successfully");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@And("^user runs the \"([^\"]*)\"$")
	public void user_run_the_shipwave_template(String waveType) throws Exception {
		String env = ManhattanLoginPage.environment;
		String account = ManhattanLoginPage.account;
		try {
			if (account.equalsIgnoreCase("NVI") && env.equalsIgnoreCase("L4")) {
				if (waveType.contains("NVI No-KIT Wave -PCL")) {

					doPage.runWaveTemplate("NVI No-KIT Wave-PCL");
				} else {
					doPage.runWaveTemplate(waveType);
				}
			} else {
				doPage.runWaveTemplate(waveType);
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("line number" + e.getStackTrace()[0].getLineNumber());
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user views wave and verify the allocation of inventory$")
	public void user_user_views_wave_and_verify_the_allocation_of_inventory() throws Exception {
		try {
			wavePage.searchForTheWaveNumberAndVerifyInventoryAllocation();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user views and Adjust the oLPN$")
	public void user_user_views_and_adjust_the_oLPN_number() throws Exception {
		try {
			String getoLPN = wavePage.searchForTheWaveNumberAndGetTheTask();
			System.out.println("oLPN here: "+getoLPN);
			homePage1.MenuItems_Distribution_Selection("oLPNs");
			SeleniumTestHelper.switchToInnerFrame(driver);
			oLPNspage.adjustoLPN(getoLPN);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user views wave and gets the task Number in Complete status$")
	public void user_views_wave_and_gets_the_task_Number_in_Complete_status() throws Exception {
		try {
			String getoLPN = wavePage.searchForTheWaveNumberAndGetTheTask();
			System.out.println("oLPN here: "+getoLPN);
			homePage1.MenuItems_Distribution_Selection("oLPNs");
			SeleniumTestHelper.switchToInnerFrame(driver);
			oLPNspage.adjustoLPN(getoLPN);
			//add to close the tab here
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user validated some oLPN Number$")
	public void user_validated_some_oLPN_Number() throws Exception {
		try {
			String getoLPN = "00000999990000007718";
			wavePage.searchForTheWaveNumberAndGetTheTask();
			//System.out.println("oLPN here: "+getoLPN);
			//homePage1.MenuItems_Distribution_Selection("oLPNs");
			//SeleniumTestHelper.switchToInnerFrame(driver);
			//oLPNspage.adjustoLPN(getoLPN);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user views wave and verify order got deselected from wave$")
	public void user_user_views_wave_and_verify_order_got_deselected_from_wave() throws Exception {
		try {
			wavePage.searchForTheWaveNumberAndVerifyOrderGotDeselected();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@And("^user open Task screen & verifies task is created for DO in the wave process$")
	public void user_user_views_TaskScreen_and_verify_task_generated() throws Exception {
		try {
			taskPage.getTaskDetails();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@And("^user open RF Menu and complete the tasks created$")
	public void user_user_opeb_RFMenu_and_complete_tasks() throws Exception {
		try {
			homePage1.MenuItems_Distribution_Selection("RF Menu");
			Screenshots.captureSnapshot(driver);
			rfMenu.completeTasks();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user open RF Menu and complete the pick tasks created$")
	public void user_user_opeb_RFMenu_and_complete_pick_tasks() throws Exception {
		try {
			homePage1.MenuItems_Distribution_Selection("RF Menu");
			Screenshots.captureSnapshot(driver);
			
			String env = ManhattanLoginPage.environment;
			System.out.println("Environment:"+env);
			
			String acnt = ManhattanLoginPage.account;
			System.out.println("Account:" + acnt);

			if (acnt.equalsIgnoreCase("QSC") || acnt.equalsIgnoreCase("@Account")) {
				rfMenu.completeTasks();
			}else if (acnt.equalsIgnoreCase("APC")){
				if (Steps.scenarioData.get("Wave Type").equals("LTL")) {
					rfMenu.completePickProcess("MM1 APC Pick LTL");
				} else {
					rfMenu.completePickProcess("MM1 APC Pick PCL");
				}
			}else if (acnt.equalsIgnoreCase("THM") || acnt.equalsIgnoreCase("THH") || acnt.equalsIgnoreCase("ILW") || acnt.equalsIgnoreCase("TRN")|| acnt.equalsIgnoreCase("ATM")){
				
					rfMenu.completePickProcess("MM1 Gen Pack");
				
			}
			else {
				rfMenu.completeTasksForNVI();
			}
			
			
			//rfMenu.completeTasks();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	
	@And("^user open RF Menu and complete the pack tasks created$")
	public void user_user_opeb_RFMenu_and_complete_pack_tasks() throws Exception {
		try {
			homePage1.MenuItems_Distribution_Selection("RF Menu");
			Screenshots.captureSnapshot(driver);
			String env = ManhattanLoginPage.environment;
			System.out.println("Environment:"+env);
			
			String acnt = ManhattanLoginPage.account;
			System.out.println("Account:" + acnt);

			if (acnt.equalsIgnoreCase("QSC") || acnt.equalsIgnoreCase("@Account")) {
				rfMenu.completePackTasks();
			}else if (acnt.equalsIgnoreCase("APC")){
				rfMenu.completePackProcess("MM1 Prt OB Docs");
			}else if (acnt.equalsIgnoreCase("THM") || acnt.equalsIgnoreCase("THH") || acnt.equalsIgnoreCase("ILW") || acnt.equalsIgnoreCase("TRN")|| acnt.equalsIgnoreCase("ATM")){
				rfMenu.completePickProcess("MM1 Locate Carton");
			}else {
				rfMenu.completePackTasksForNVI();
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	
	@And("^user open RF Menu and change the tasks group \"([^\"]*)\"$")
	public void user_user_opeb_RFMenu_and_change_the_tasks_group(String tskgrp) throws Exception {
		try {
			homePage1.MenuItems_Distribution_Selection("RF Menu");
			Screenshots.captureSnapshot(driver);
			rfMenu.changeTasks(tskgrp);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@And("^user open RF Menu and complete a single task created$")
	public void user_user_opeb_RFMenu_and_complete_single_task_created() throws Exception {
		try {
			homePage1.MenuItems_Distribution_Selection("RF Menu");
			Screenshots.captureSnapshot(driver);
			rfMenu.completeSingleTask();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user open Task screen & validates the status of tasks$")
	public void user_user_validates_tasks_status() throws Exception {
		try {
			homePage1.MenuItems_Configuration_Selection("Tasks");
			SeleniumTestHelper.switchToInnerFrame(driver);
			Screenshots.captureSnapshot(driver);
			taskPage.validateTaks();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user open Task screen & validate the status of single task$")
	public void user_user_validates_task_status_of_single_task() throws Exception {
		try {
			homePage1.MenuItems_Configuration_Selection("Tasks");
			SeleniumTestHelper.switchToInnerFrame(driver);
			Screenshots.captureSnapshot(driver);
			taskPage.validateSingleTask();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}


	@Then("^user search for DO and confirms it$")
	public void ship_confirm_DO() throws Exception {
		try {
			doPage.user_views_the_ship_confirm();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	//New Raka
	@Then("^user views ASN, get and verify pallet status is \"([^\"]*)\"$")
	public void user_views_ASNscreen_and_get_palletDetails(String status) throws Exception {
		// asnsPage.searchForTheASN(Items.getAsnNumber());
		try {
			asnsPage.searchForTheASN(Items.getAsnNumber());
			Steps.logger.info("Search for item details");
			SeleniumTestHelper.waitForElementToBeClickable(driver, asnsPage.searchedASNChkbox, 50);
			asnsPage.searchedASNChkbox.click();
			Thread.sleep(2000);
			asnsPage.viewASNBtn.click();
			Steps.logger.info("Click on view ASN");
			// Thread.sleep(5000);
			SeleniumTestHelper.switchToInnerFrame(driver);
			Screenshots.captureSnapshot(driver);
			asnsPage.verifyPalletStatus(status);
			homePage1.userClosesOpenedwindow("Advance Ship Notice");
			// Thread.sleep(3000);
			SeleniumTestHelper.Close_OpenedWindow("ASNs", driver);
			Steps.logger.info("Close ASN window");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}


	@Then("^user opens RF menu and perform \"([^\\\"]*)\" operation in inventory menu$")
	public void MM3_inventory_operations(String function)throws Exception {
		try {
			homePage1.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.inventoryFunctions(function);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^fetch the OLPN number$")
	public void fetch_olpn()throws Exception {
		try {
			doPage.fetchoLPNSnumber();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Then("^fetch the ILPN number$")
	public void fetch_ilpnReferenceVal()throws Exception {
		try {
			doPage.fetchReferenceiLPNnumber();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	@Then("^fetch the OLPN number with only 30 weighed status$")
	public void fetch_olpn_with_30Wegihed()throws Exception {
		try {
			doPage.fetchoLPNSnumberwith30weighed();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Then("^user opens the OLPN screen and verify the splitted oLPNS status$")
	public void check_splitted_oLPNS_status()throws Exception {
	try {
		doPage.checksplittedoLPNandquantity();
	} catch (Exception e) {
		Steps.testRes = "Failed";
		System.out.println(e);
		Assert.assertTrue(false, e.getMessage());
	}
	}
	@Then("^user opens the OLPN screen and verify the combined oLPNS status$")
	public void check_combine_oLPNS_status()throws Exception {
	try {
		doPage.checkcombineoLPNandquantity();
	} catch (Exception e) {
		Steps.testRes = "Failed";
		System.out.println(e);
		Assert.assertTrue(false, e.getMessage());
	}
	}
	
	@Then("^user opens RF menu and completes Shipping using \"([^\"]*)\" menu$")
	public void user_opens_RF_menu_and_completes_Receiving_using_menu(String shippingMethod) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.DOShippingProcess(shippingMethod);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Then("^user opens RF menu and opens Shipping using \"([^\"]*)\" menu$")
	public void user_opens_RF_menu_and_opens_Receiving_using_menu(String shippingMethod) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.DOShippingProcess(shippingMethod);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("user searches for location Code")
	public void user_searches_for_location_code() throws Exception {
		try {
			//homePage.MenuItems_Configuration_Selection("Order Consolidation Locations");
			//SeleniumTestHelper.switchToInnerFrame(driver);
			
			
			String LocCode =oCLPage.getLocation("NV03-1");
			System.out.println(LocCode);
		} catch (Exception e) {
System.out.println(e);
		}
	}
	
	@Then("^user search for the LPN in iLPN screen, and validate the iLPN statusOB as \"([^\"]*)\"$")
	public void user_search_for_the_LPN_in_iLPN_screen_and_validate_the_iLPN_statusOB_as(String arg1) throws Throwable {
		homePage1.MenuItems_Distribution_Selection("iLPNs");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		try {
			//for (int i = 0; i < RFMenuPage.iLPNz.size(); i++) {
			for (int i = 0; i < Items.getLpnsLength(); i++) {	
			//	iLPNPage.searchForTheILPNAndViewIt(RFMenuPage.iLPNz.get(i));
				iLPNPage.searchForTheILPNAndViewIt(Items.getLpns(i));
				iLPNPage.validateiLPNStatusAndQty_trans(arg1);
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@And("^user navigates to shippment planning workspace$")
	public void ShipmentPlanning()throws Exception{
		ShipmentPlanningWorkspace ShipPlan = new ShipmentPlanningWorkspace();
		homePage1.MenuItems_Distribution_Selection("Shipment Planning Workspace");
		//Screenshots.captureSnapshot(driver);
		try {
		ShipPlan.Ship();
		Reporter.addStepLog("Completd Task on Shipment Planning Workspace.");
		Steps.logger.info("Completd Task on Shipment Planning Workspace.");
		}
		catch  (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
	
		}
	}
	
	@Then("^user opens the OLPN screen and retrieve the splitted oLPN$")
	public void retrieve_splitted_oLPN_()throws Exception {
	try {
		doPage.retrieveSplittedToOLPN();
		Reporter.addStepLog("Retrieved the Splitted OLPN");
		Steps.logger.info("Retrieved the Splitted OLPN");
	} catch (Exception e) {
		Steps.testRes = "Failed";
		System.out.println(e);
		Assert.assertTrue(false, e.getMessage());
	}
	}
	
	@And("^user perform weigh and manifest for splitted to OLPN$")
	public void weighForTheOLPNAfterSplitAndMove()throws Exception{
		WeighAndManifestoLPNPage weighAndManifest  = new WeighAndManifestoLPNPage();
		homePage.MenuItems_Distribution_Selection("Weigh and Manifest oLPN");
		Screenshots.captureSnapshot(driver);
		try {
			weighAndManifest.performWeighAndManifest();
			Reporter.addStepLog("Performed Weigh on Splitted OLPN.");
			Steps.logger.info("Performed Weigh on Splitted OLPN.");
		}
		catch  (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
	
		}
	}
	
	@Then("^user opens RF menu and completes Shipping using \"([^\"]*)\" menu after split move$")
	public void user_opens_RF_menu_and_completes_shipping_after_split(String shippingMethod) throws Exception {
		try {
			homePage.MenuItems_Distribution_Selection("RF Menu");
			Steps.logger.info("Open RF menu");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			rfMenu.DOShippingProcessAfterSplitMove(shippingMethod);
			Reporter.addStepLog("Completed shipping process after split and move");
			Steps.logger.info("Completed shipping process after split and move");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}

//	@And("^user opens DO screen and searches for the DO using Fulfillment Status as \"([^\"]*)\"$")
//	public void user_opens_DOscreen_and_Searches_for_DO_Using_FullfillmentStatus(String status)	throws Exception {
//		try {
//			doPage.getDOStatusUsingFulfillment(status);
//			Reporter.addStepLog("DO Order status is verified successfully");
//			Steps.logger.info("DO Order status is verified successfully");
//		} catch (Exception e) {
//			Steps.testRes = "Failed";
//			System.out.println(e);
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
	
	@And("^user perform weigh and manifest and verify status \"([^\"]*)\"$")
	public void userPerformweighAndManifestForTheOLPN(String status)throws Exception{
		WeighAndManifestoLPNPage weighAndManifest  = new WeighAndManifestoLPNPage();
		homePage.MenuItems_Distribution_Selection("Weigh and Manifest oLPN");
		Screenshots.captureSnapshot(driver);
		try {
			weighAndManifest.weighandManifestoLPN(status);
			Reporter.addStepLog("Performed Weigh on Splitted OLPN.");
			Steps.logger.info("Performed Weigh on Splitted OLPN.");
		}
		catch  (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
	
		}
	}
	
	@Then("^user verifies the shipVia populated in Distribuion Order page$")
	public void user_verifies_the_shipVia_populated_in_Distribuion_Order_page() throws Exception {
		try {
			doPage.checkShipViaPopulated();
			Reporter.addStepLog("DO Order item details verified successfully");
			Steps.logger.info("DO Order item details verified successfully");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Then("^user verify the DGRequired Status as \"([^\"]*)\"$")
	public void user_verify_the_DGRequired_Status(String status) throws Exception {
		doPage.getdGRequiredSstatus(status);
	}
	
	@Then("^user update the tracking number for DG item and save it in header$")
	public void user_update_the_tracking_number_for_DG_item_and_save_it_in_header()throws Exception{
		doPage.updatetrackingNumberInHeader();
	}
	
}
