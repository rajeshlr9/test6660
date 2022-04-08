package reusable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import utils.SeleniumTestHelper;

public class ValidateFilesAfterReceving extends Steps{

	WebDriver driver;
	
	public ValidateFilesAfterReceving() throws Throwable {
		// this.driver = Driver.getInstance();
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='rdoDocChoice' and @value='0']")
	public WebElement selectFirstRadioAfterFilter;
	
	@FindBy(xpath = "//input[@name='btnDoc' and @value='View Doc']")
	public WebElement viewDocBtn;
	
	@FindBy(xpath = "//input[@name='txtDocVer']")
	public WebElement fileName;
	
	public String actualFileName;
	
	public String downloadTheFileFromFedexNet(String dropEnv, String filetype) throws Exception {
		try {
			Thread.sleep(1000);
			Steps.logger.info("In FedExNet Try to Retrive and Downlaod the FileName");
			
			Steps.logger.info("Switch to Frame...for interact with the component");
			driver.switchTo().parentFrame();
			driver.switchTo().frame("ApplicationFrame");
			driver.switchTo().frame("mainFrame");

			String title = driver.getTitle();
			Steps.logger.info("Page title"+title);
			
			SeleniumTestHelper.isElementDisplayed(selectFirstRadioAfterFilter);
			Steps.logger.info("Verified the radio Button getting displayed for file to be selected..."
					+ SeleniumTestHelper.isElementDisplayed(selectFirstRadioAfterFilter));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectFirstRadioAfterFilter, 50);
			selectFirstRadioAfterFilter.click();

			Steps.logger.info(
					"Verified the file name getting displayed..." + SeleniumTestHelper.isElementDisplayed(fileName));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, fileName, 50);
			String nameofThefile = fileName.getAttribute("value");
			Steps.logger.info("Name of the retrieved file is :"+nameofThefile);
			actualFileName = nameofThefile.replace('-', 'v');
			Steps.logger.info(actualFileName);

			Thread.sleep(1000);
			// driver.switchTo().defaultContent();
			
			Steps.logger.info("Again swtich to frame to interact with the component");
			driver.switchTo().parentFrame();
			driver.switchTo().frame("bottomFrame");
			Thread.sleep(5000);
			Steps.logger.info(
					"Verified the ViewDoc Button getting displayed..." + SeleniumTestHelper.isElementDisplayed(viewDocBtn));

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewDocBtn, 50);
			viewDocBtn.click();

			Thread.sleep(120000);
			Steps.logger.info("Clicked on ViewDoc Button");
			Reporter.addStepLog("Download the file in FedExNet");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return actualFileName;
	}
}
