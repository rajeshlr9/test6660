package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.Items;
import pages.DistributionOrderProfilesPage;
import pages.DistributionOrdersPage;
import pages.HomePage;
import reusable.KelliPages;

public class StepDefKelli {
	WebDriver driver = Steps.seleniumDriver;

	public StepDefKelli() {

	}

	KelliPages kelliPages = new KelliPages();

	@And("^user logs into the kelli application$")
	public void login_to_kelli_application() {
		try {
			kelliPages.loginPage();
			Steps.logger.info("Logged in to kelli application");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@When("^user upload the ASN Load file$")
	public void ASN_upoload_file() {
		try {
			kelliPages.ASNupload();
			Steps.logger.info("File uploaded successfully");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@And("^user updates data in ASN Upload Sheet$")
	public void ASNSheet_Update_data() {
		try {
			kelliPages.KelliASNLoadSheetUpdate();
			Steps.logger.info("Excel data updated before uploading file");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	
	@And("^user updates data in Item Upload Sheet$")
	public void ItemSheet_Update_data() {
		try {
			kelliPages.KelliItemLoadSheetUpdate();
			Steps.logger.info("Excel data updated before uploading file");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@When("^user upload the Item Load file$")
	public void Uploads_the_excel() throws InterruptedException {
		try {
			kelliPages.itemUpload();
			Steps.logger.info("Excel uploading successfull");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red" + Steps.testRes);
			e.printStackTrace();
		}
	}

	@And("^user view the logs and validates the success message for Item Load$")
	public void user_gets_logs() throws InterruptedException {
		try {
			kelliPages.viewlogsforItemUplaod();
			Reporter.addStepLog("Logs are verified successfully");
			driver.quit();
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red" + Steps.testRes);
			e.printStackTrace();
		}
	}

	@And("^user view the logs and validates the success message for ASN Load$")
	public void Kelli_View_logs() {
		try {

			kelliPages.viewlogsforASNUpload();
			Steps.logger.info("Logs verification successfull");
			Reporter.addStepLog("Logs verification successfull");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Then("^user logout from the kelli application$")
	public void kellilogout() throws Throwable {
		try {
			// Kellilogout.logoutKelliApplication();
			kelliPages.logoutKelliApplication();
			Steps.logger.info("Logout from the application");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
