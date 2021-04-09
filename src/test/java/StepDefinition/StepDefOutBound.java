package StepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.Items;
import globalFunc.Screenshots;
import pages.AsnsPage;
import pages.DistributionOrderProfilesPage;
import pages.DistributionOrdersPage;
import pages.HomePage;
import pages.ILPNPage;
import pages.OlpnsPage;
import pages.RFMenuPage;
import pages.TasksPage;
import pages.WavesPage;
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

	public StepDefOutBound() {
	
	}
	@When("^user create xml file with updated DO_No$")
	public void user_create_xml_file_with_updated_DO_No() throws Exception {
		try {
			Steps.logger.info("XML creation started");
			xmlInput.create_xmlFile_for_DistributionOrder_to_upload();
			Steps.scenario.write("DO-" + Items.getDONumber());
			Reporter.addStepLog("DO-" + Items.getDONumber());
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
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
	
	@And("^user opens DO screen and searches for the DistributionOrder and verify its status \"([^\"]*)\"$")
	public void user_opens_DOscreen_andsearches_for_DOstatus(String status)	throws Exception {
		try {
			doPage.getDoStatus(status);
		Thread.sleep(3000);
		Reporter.addStepLog("DO Order status is verified successfully");
		Steps.logger.info("DO Order status is verified successfully");
	} catch (Exception e) {
		Steps.testRes = "Failed";
		System.out.println(e);
		Assert.assertTrue(false, e.getMessage());
	}
	}
	
	@Then("^user verifies the item details in Distribuion Order page$")
	public void user_verifies_the_item_details_in_Distribuion_Order_page() throws Exception {
		try {
		Thread.sleep(3000);
		doPage.getDOdetails();
		Reporter.addStepLog("DO Order item details verified successfully");
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
	
	@And("^user runs the \"([^\"]*)\"$")
	public void user_run_the_shipwave_template(String waveType) throws Exception {
		try {
			doPage.runWaveTemplate(waveType);
		} catch (Exception e) {
			Steps.testRes = "Failed";
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
		
		//Jaya
		@Then("^user opens RF menu and perform \"([^\\\"]*)\" operation in inventory menu$")
		public void MM3_split_oLPN(String function)throws Exception {
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
		
		
		@Then("^user search for the LPN in iLPN screen, and validate the iLPN statusOB$")
		public void user_opens_iLPN_and_validate_iLPN_status_OB() throws Exception {
			homePage1.MenuItems_Distribution_Selection("iLPNs");
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.switchToInnerFrame(driver);
			try {
				for (int i = 0; i < RFMenuPage.iLPNz.size(); i++) {
					iLPNPage.searchForTheILPNAndViewIt(RFMenuPage.iLPNz.get(i));
					iLPNPage.validateiLPNStatusAndQty_trans();
				}
			} catch (Exception e) {
				Steps.testRes = "Failed";
				e.printStackTrace();
				Assert.assertTrue(false, e.getMessage());
			}
		}
}
