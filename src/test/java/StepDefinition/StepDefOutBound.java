package StepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import entity.Items;
import pages.DistributionOrderProfilesPage;
import pages.DistributionOrdersPage;
import pages.HomePage;
import pages.WavesPage;

public class StepDefOutBound {
	WebDriver driver = Steps.seleniumDriver;
	HomePage homePage1 = new HomePage();
	DistributionOrdersPage doPage = new DistributionOrdersPage();
	DistributionOrderProfilesPage DOProfilepage =  new DistributionOrderProfilesPage();
	WavesPage wavePage= new WavesPage();

	public StepDefOutBound() {
	
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
	
}
