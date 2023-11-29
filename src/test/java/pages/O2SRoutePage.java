package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import globalFunc.Screenshots;
import utils.SeleniumTestHelper;

public class O2SRoutePage {

	WebDriver driver;

	public static String TestedBy = null;

	public O2SRoutePage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//input[@name='form1:routeOptions:0:scheduleOptions:0:selSchdOpt']")
//	public WebElement route0;

	@FindBy(xpath = "//input[@type='radio' and @value='opt1']//following::span[contains(text(),'First Overnight')]")
	public WebElement firstOvernightOption;
	@FindBy(xpath = "//input[@type='radio' and @value='opt2']//following::span[contains(text(),'Priority Overnight')]")
	public WebElement priorityOvernightOption;
	@FindBy(xpath = "//input[@type='radio' and @value='opt0']//following::span[contains(text(),'Express Saver')]")
	public WebElement expressSaverOption;
	@FindBy(xpath = "//input[@type='radio' and @value='opt3']//following::span[contains(text(),'2Day')]")
	public WebElement twoDayOption;
	@FindBy(xpath = "//input[@type='radio' and @value='opt4']//following::span[contains(text(),'SameDay Courier')]")
	public WebElement sameDayCourierOption;
	
	@FindBy(xpath = "//input[@type='radio' and @name='form1:routeOptions:0:scheduleOptions:0:selSchdOpt']//following::span[contains(text(),'FedEx ')][1]")
	public WebElement fedExsameDayCourierOption;
	

	@FindBy(xpath = "//input[@id='form1:submit']")
	public WebElement continueBtn;

	/***
	 * This method selectRoute is use for selecting the route
	 * @throws Exception
	 */
	public void selectRoute() throws Exception {

		// SeleniumTestHelper.waitForElementToBeDisplayed(driver, expressSaverOption,
		// 180);
		
		if (SeleniumTestHelper.isElementDisplayed(firstOvernightOption)) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstOvernightOption, 180);
			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(firstOvernightOption));
			SeleniumTestHelper.scrollToElement(driver, firstOvernightOption);
			firstOvernightOption.click();
			Steps.logger.info("Clicked on firstOvernightOption");
		}
		else if (SeleniumTestHelper.isElementDisplayed(priorityOvernightOption)) {
			System.out.println(SeleniumTestHelper.isElementDisplayed(priorityOvernightOption));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, priorityOvernightOption, 180);
			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(priorityOvernightOption));
			SeleniumTestHelper.scrollToElement(driver, priorityOvernightOption);
			priorityOvernightOption.click();
			Steps.logger.info("Clicked on Priority overnight option");
		}
		else if (SeleniumTestHelper.isElementDisplayed(expressSaverOption)) {
			System.out.println(SeleniumTestHelper.isElementDisplayed(expressSaverOption));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, expressSaverOption, 180);
			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(expressSaverOption));
			SeleniumTestHelper.scrollToElement(driver, expressSaverOption);
			expressSaverOption.click();
			Steps.logger.info("Clicked on express saver");
		}
//		else if (SeleniumTestHelper.isElementDisplayed(fedExsameDayCourierOption)) {
//			System.out.println(SeleniumTestHelper.isElementDisplayed(fedExsameDayCourierOption));
//			SeleniumTestHelper.waitForElementToBeDisplayed(driver, fedExsameDayCourierOption, 180);
//			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(fedExsameDayCourierOption));
//			SeleniumTestHelper.scrollToElement(driver, fedExsameDayCourierOption);
//			fedExsameDayCourierOption.click();
//			Steps.logger.info("Clicked on express saver");
//		}
		else {
			System.out.println("No Expected Services are available at this time");
			Steps.logger.info("No Expected Services are available at this time");
			SeleniumTestHelper.assertTrue(false, "No Service Available,hence makes the script failed");
		}
		Thread.sleep(5000);
		Screenshots.captureSnapshot(driver);
		Reporter.addStepLog("User selected the Route...");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, continueBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(continueBtn));
		SeleniumTestHelper.scrollToElement(driver, continueBtn);
		SeleniumTestHelper.clickOnButton(continueBtn);
		//continueBtn.click();
		Steps.logger.info("Clicked on Continue button");
		Thread.sleep(5000);
	}

}
