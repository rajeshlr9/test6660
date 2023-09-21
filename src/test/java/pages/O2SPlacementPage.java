package pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.Screenshots;
import utils.SeleniumTestHelper;

public class O2SPlacementPage {

	WebDriver driver;

	public static String TestedBy = null;

	public O2SPlacementPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='form1:referenceFields:0:value']")
	public WebElement poNumberInputField;

	@FindBy(xpath = "//input[@id='form1:submitPlacement']")
	public WebElement continueBtn;

	public static String strDate12;
	
	/***
	 * This method performPlacement use for Order placement after enter PO/DO number
	 * @throws Exception
	 */
	public void performPlacement() throws Exception {

		String PODONumber = "";
		Date date = new Date();
		SimpleDateFormat sdfDate = new SimpleDateFormat("HHmmss");
		strDate12 = sdfDate.format(date);
		PODONumber = "2023" + strDate12;
		Items.setDONumber(PODONumber);
		Steps.logger.info("DO Number: " + PODONumber);
		Reporter.addStepLog("DO Number: " + PODONumber);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, poNumberInputField, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(poNumberInputField));
		SeleniumTestHelper.scrollToElement(driver, poNumberInputField);

		System.out.println("PODO Number = " + PODONumber);
		SeleniumTestHelper.enterTextInTextBox(poNumberInputField, PODONumber);

		// SeleniumTestHelper.enterTextInTextBox(poNumberInputField, "1008202306");
		Steps.logger.info("Enter PO Number");
		Thread.sleep(10000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, continueBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(continueBtn));
		SeleniumTestHelper.scrollToElement(driver, continueBtn);
		SeleniumTestHelper.clickOnButton(continueBtn);
		//continueBtn.click();
		Steps.logger.info("Clicked on Continue button");
		Thread.sleep(10000);
	}

}
