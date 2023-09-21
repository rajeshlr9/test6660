package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import globalFunc.Screenshots;
import utils.SeleniumTestHelper;

public class O2SReturnShipmentPage {

	WebDriver driver;

	public static String TestedBy = null;

	public O2SReturnShipmentPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='form1:submit']")
	public WebElement continueBtn;

	/***
	 * This method selectRoute is use for selecting the route
	 * 
	 * @throws Exception
	 */
	public void clickOnContinueInReturnShipmentPage() throws Exception {

		Thread.sleep(10000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, continueBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(continueBtn));
		SeleniumTestHelper.scrollToElement(driver, continueBtn);
		Screenshots.captureSnapshot(driver);
		Reporter.addStepLog("User will click the Continue button to proceed...");
		SeleniumTestHelper.clickOnButton(continueBtn);
		//continueBtn.click();
		Thread.sleep(10000);
	}

}
