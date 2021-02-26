package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.Items;
import globalFunc.Screenshots;
import pages.DistributionOrderProfilesPage;
import pages.DistributionOrdersPage;
import pages.HomePage;
import pages.RFMenuPage;
import reusable.KelliPages;
import utils.SeleniumTestHelper;

public class StepDefRFInquiry {
	WebDriver driver = Steps.seleniumDriver;
HomePage homePage= new HomePage();
RFMenuPage rfMenu= new RFMenuPage();
	public StepDefRFInquiry() {
		
	}
	
		@Then("^user opens RF menu and go to Inquiry & validate \"([^\"*])\" is displaying data$")
		public void user_opens_RF_menu_and_validate_Inquiry_Transaction(String menuOption) throws Exception {
			try {
				homePage.MenuItems_Distribution_Selection("RF Menu");
				Steps.logger.info("Open RF menu");
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.switchToInnerFrame(driver);
				rfMenu.InquiryTransactions(menuOption);
			} catch (Exception e) {
				Steps.testRes = "Failed";
				e.printStackTrace();
				Assert.assertTrue(false, e.getMessage());
			}
		}
}
