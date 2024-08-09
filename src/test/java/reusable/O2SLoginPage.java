package reusable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import globalFunc.Screenshots;
import utils.Config;
import utils.SeleniumTestHelper;

public class O2SLoginPage extends Steps {
	WebDriver driver;

	public static String TestedBy = null;

	public static String environment = Config.getProperty("Environment"); 
	public static String account = Config.getProperty("Account"); 

	public O2SLoginPage() throws Throwable {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='identifier']")
	public WebElement username;

	@FindBy(xpath = "//input[@name='credentials.passcode']")
	public WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement signInBtn;

	@FindBy(xpath = "//h1[contains(text(),'FedEx Critical Inventory Logistics')]")
	public WebElement headerMsg;
	
	/**
	 * This method loginToO2SApp use for login to O2S application
	 * @throws Exception
	 */
	public void loginToO2SApp() throws Exception {
		{
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 180);
			String env = environment;

			if (env.equalsIgnoreCase("L2") || env.equalsIgnoreCase("@Env")) {
				username.sendKeys(Config.getProperty("O2SApp_L2_Username_Admin"));
				Steps.logger.info("L2UserName: " + Config.getProperty("O2SApp_L2_Username_Admin"));
				password.sendKeys(Config.getProperty("O2SApp_L2_Password_Admin"));
				Steps.logger.info("L2Password: " + Config.getProperty("O2SApp_L2_Password_Admin"));
			}else if (env.equalsIgnoreCase("L4")) {
				username.sendKeys(Config.getProperty("O2SApp_L4_Username_Admin"));
				Steps.logger.info("L4UserName: " + Config.getProperty("O2SApp_L4_Username_Admin"));
				password.sendKeys(Config.getProperty("O2SApp_L4_Password_Admin"));
				Steps.logger.info("L4Password: " + Config.getProperty("O2SApp_L4_Password_Admin"));
			}
			else if (env.equalsIgnoreCase("L5")) {
				username.sendKeys(Config.getProperty("O2SApp_L5_Username_Admin"));
				Steps.logger.info("L5UserName: " + Config.getProperty("O2SApp_L5_Username_Admin"));
				password.sendKeys(Config.getProperty("O2SApp_L5_Password_Admin"));
				Steps.logger.info("L5Password: " + Config.getProperty("O2SApp_L5_Password_Admin"));
			}
			//2023062350
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(signInBtn));
			signInBtn.click();
			Steps.logger.info("Clicked on Sign in Button");
			//Thread.sleep(10000);
			SeleniumTestHelper.WaitForPageLoad(5000);
			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(headerMsg));
			Screenshots.captureSnapshot(driver);
			Reporter.addStepLog("User Successfully logon to O2S Application...");
		}
	}

}
