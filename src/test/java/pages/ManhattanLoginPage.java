package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import globalFunc.CreateBrowser;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;

public class ManhattanLoginPage extends Steps{
	WebDriver driver;

	public ManhattanLoginPage()  throws Throwable {
		// this.driver = Driver.getInstance();
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	public static String TestedBy = null;

	public static String environment = Config.getProperty("Environment"); // Different environments Dev and Test

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "loginButton")
	public WebElement signInBtn;

	@FindBy(xpath = "//a[@data-qtip='Workspaces']/following-sibling::a[1]")
	public WebElement userLoggedin;

	@FindBy(xpath = "//label[text()='Maximized']//preceding-sibling::input")
	public WebElement maximizedChkbox;

	@FindBy(xpath = "//label[text()='Tile Single Click']//preceding-sibling::input")
	public WebElement tileSingleClick;

	@FindBy(xpath = "//a[contains(@id,'mps_regions_selector')]")
	public WebElement facilitySelection;

	@FindBy(xpath = "//span[text()='Warehouse:']/../following-sibling::div[1]")
	public WebElement warehouseDropdown;

	@FindBy(xpath = "//li[text()='MM3']")
	public WebElement verWarehouse;

	@FindBy(xpath = "//A/SPAN[@role=\"presentation\"]/SPAN[@role=\"presentation\"]/SPAN[normalize-space()=\"MM3 - QSC\"]")
	public WebElement facilityApplyBtn;

	@FindBy(xpath = "//span[text()='Apply']")
	public WebElement facilityDisp;

	@FindBy(xpath = "//DIV[normalize-space()=\"Business Unit:\"]/DIV[1]/DIV[1]/DIV[1]/INPUT[@role=\"combobox\"][1]")
	public WebElement BusinessUnitDisp;

	@FindBy(xpath = "//DIV[normalize-space()=\"Business Unit:\"]/DIV[1]/DIV[1]/DIV[2]")
	public WebElement BusinessUnitDd;

	@FindBy(xpath = "//li[text()='QSC']")
	public WebElement verBusinessUnit;

	/**
	 * below method is to login to the Manhattan app
	 * 
	 * @throws InterruptedException
	 */
	public void loginToManhattanApp() throws InterruptedException {
		{
			try {
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 180);
				String env = environment;
				//String userType= Config.getProperty("UserRole");
				if (env.equalsIgnoreCase("Dev")) {
					
				}else if (env.equalsIgnoreCase("TEST")|| env.equalsIgnoreCase("@Env") ) {
					username.sendKeys(Config.getProperty("TESTUsername_Admin"));
					Steps.logger.info("UserName: " + Config.getProperty("TESTUsername_Admin"));
					password.sendKeys(Config.getProperty("TESTPassword_Admin"));
					Steps.logger.info("Password: " + Config.getProperty("TESTPassword_Admin"));
				}
				else if (env.equalsIgnoreCase("STAGE")) {
					
				}
		
				/*	switch (userType) {
					case "Admin":
						username.sendKeys(Config.getProperty("DevUsername_Admin"));
						Steps.logger.info("UserName: " + Config.getProperty("DevUsername_Admin"));
						password.sendKeys(Config.getProperty("DevPassword_Admin"));
						Steps.logger.info("Password: " + Config.getProperty("DevPassword_Admin"));
						break;
					case "Supervisor":
						username.sendKeys(Config.getProperty("DevUsername_Supervisor"));
						Steps.logger.info("UserName: " + Config.getProperty("DevUsername_Supervisor"));
						password.sendKeys(Config.getProperty("DevPassword_Supervisor"));
						Steps.logger.info("Password: " + Config.getProperty("DevPassword_Supervisor"));
						break;
					case "Associate":
						username.sendKeys(Config.getProperty("DevUsername_Associate"));
						Steps.logger.info("UserName: " + Config.getProperty("DevUsername_Associate"));
						password.sendKeys(Config.getProperty("DevPassword_Associate"));
						Steps.logger.info("Password: " + Config.getProperty("DevPassword_Associate"));
						break;

					default:
						System.out.println("User trying to login with : " + userType + " credentials");
						break;
					}
				} else if (env.equalsIgnoreCase("TEST")) {
					switch (userType) {
					case "Admin":
						username.sendKeys(Config.getProperty("TESTUsername_Admin"));
						Steps.logger.info("UserName: " + Config.getProperty("TESTUsername_Admin"));
						password.sendKeys(Config.getProperty("TESTPassword_Admin"));
						Steps.logger.info("Password: " + Config.getProperty("TESTPassword_Admin"));
						break;
					case "Supervisor":
						username.sendKeys(Config.getProperty("TESTUsername_Supervisor"));
						Steps.logger.info("UserName: " + Config.getProperty("TESTUsername_Supervisor"));
						password.sendKeys(Config.getProperty("TESTPassword_Supervisor"));
						Steps.logger.info("Password: " + Config.getProperty("TESTPassword_Supervisor"));
						break;
					case "Associate":
						username.sendKeys(Config.getProperty("TESTUsername_Associate"));
						Steps.logger.info("UserName: " + Config.getProperty("TESTUsername_Associate"));
						password.sendKeys(Config.getProperty("TESTPassword_Associate"));
						Steps.logger.info("Password: " + Config.getProperty("TESTPassword_Associate"));
						break;

					default:
						System.out.println("User trying to login with : " + userType + " credentials");
						break;
					}
				}
					else if (env.equalsIgnoreCase("STAGE")) {
						switch (userType) {
						case "Admin":
							username.sendKeys(Config.getProperty("UAUsername_Admin"));
							Steps.logger.info("UserName: " + Config.getProperty("UAUsername_Admin"));
							password.sendKeys(Config.getProperty("UAPassword_Admin"));
							Steps.logger.info("Password: " + Config.getProperty("UAPassword_Admin"));
							break;
						case "Supervisor":
							username.sendKeys(Config.getProperty("UAUsername_Supervisor"));
							Steps.logger.info("UserName: " + Config.getProperty("UAUsername_Supervisor"));
							password.sendKeys(Config.getProperty("UAPassword_Supervisor"));
							Steps.logger.info("Password: " + Config.getProperty("UAPassword_Supervisor"));
							break;
						case "Associate":
							username.sendKeys(Config.getProperty("UAUsername_Associate"));
							Steps.logger.info("UserName: " + Config.getProperty("UAUsername_Associate"));
							password.sendKeys(Config.getProperty("UAPassword_Associate"));
							Steps.logger.info("Password: " + Config.getProperty("UAPassword_Associate"));
							break;

						default:
							System.out.println("User trying to login with : " + userType + " credentials");
							break;
						}
				*/
					
				SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(signInBtn));
				signInBtn.click();
				Steps.logger.info("Clicked on Sign in Button");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, facilitySelection, 180);
				Thread.sleep(3000);
				if (!facilityApplyBtn.getText().contains("MM3 - QSC")) {

					facilitySelection.click();
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, warehouseDropdown, 180);
					warehouseDropdown.click();
					if (SeleniumTestHelper.isElementDisplayed(verWarehouse)) {
						verWarehouse.click();
					} else {
						warehouseDropdown.click();
						Thread.sleep(1000);
						warehouseDropdown.click();
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, verWarehouse, 180);
						verWarehouse.click();
					}
					if (BusinessUnitDisp.getText() != "QSC") {
						BusinessUnitDd.click();
						Thread.sleep(1000);
						if (verBusinessUnit.isEnabled()) {
							verBusinessUnit.click();
						}
						Thread.sleep(1000);
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, facilityApplyBtn, 180);
						if (facilityApplyBtn.isEnabled()) {
							facilityApplyBtn.click();
						}

						SeleniumTestHelper.waitForElementToBeDisplayed(driver, userLoggedin, 180);
					}
				}
				userLoggedin.click();
				Steps.logger.info("User in Home Page");
				if (!maximizedChkbox.isSelected()) {
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(maximizedChkbox));
					Steps.logger.info("Pages will be maximized");
					maximizedChkbox.click();
				}
				if (!tileSingleClick.isSelected()) {
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(tileSingleClick));
					Steps.logger.info("Single click is enabled");
					tileSingleClick.click();
				}

				TestedBy = driver
						.findElement(
								By.xpath("//a[@data-qtip='Workspaces']/following-sibling::a[1]/following::label[3]"))
						.getText();
				// Steps.logger.info("TestedBy: "+TestedBy);
				Reporter.addStepLog("User logged in successfully");
				userLoggedin.click();
				Thread.sleep(2000);

			}

			catch (NoSuchElementException noSuchElementExec) {

				System.out.println("Error occured : " + noSuchElementExec.getMessage());
				Steps.logger.info("Error occured : " + noSuchElementExec.getMessage());
			}
		}

	}

	public void loginToManhattanApp(String userType) throws InterruptedException {

		try {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 180);
			String env = environment;
			if (env.equalsIgnoreCase("Dev")) {
				switch (userType) {
				case "Admin":
					username.sendKeys(Config.getProperty("DevUsername_Admin"));
					Steps.logger.info("UserName: " + Config.getProperty("DevUsername_Admin"));
					password.sendKeys(Config.getProperty("DevPassword_Admin"));
					Steps.logger.info("Password: " + Config.getProperty("DevPassword_Admin"));
					break;
				case "Supervisor":
					username.sendKeys(Config.getProperty("DevUsername_Supervisor"));
					Steps.logger.info("UserName: " + Config.getProperty("DevUsername_Supervisor"));
					password.sendKeys(Config.getProperty("DevPassword_Supervisor"));
					Steps.logger.info("Password: " + Config.getProperty("DevPassword_Supervisor"));
					break;
				case "Associate":
					username.sendKeys(Config.getProperty("DevUsername_Associate"));
					Steps.logger.info("UserName: " + Config.getProperty("DevUsername_Associate"));
					password.sendKeys(Config.getProperty("DevPassword_Associate"));
					Steps.logger.info("Password: " + Config.getProperty("DevPassword_Associate"));
					break;

				default:
					System.out.println("User trying to login with : " + userType + " credentials");
					break;
				}
			} else if (env.equalsIgnoreCase("TEST")|| env.equalsIgnoreCase("@Env") ) {
				switch (userType) {
				case "Admin":
					username.sendKeys(Config.getProperty("TESTUsername_Admin"));
					Steps.logger.info("UserName: " + Config.getProperty("TESTUsername_Admin"));
					password.sendKeys(Config.getProperty("TESTPassword_Admin"));
					Steps.logger.info("Password: " + Config.getProperty("TESTPassword_Admin"));
					break;
				case "Supervisor":
					username.sendKeys(Config.getProperty("TESTUsername_Supervisor"));
					Steps.logger.info("UserName: " + Config.getProperty("TESTUsername_Supervisor"));
					password.sendKeys(Config.getProperty("TESTPassword_Supervisor"));
					Steps.logger.info("Password: " + Config.getProperty("TESTPassword_Supervisor"));
					break;
				case "Associate":
					username.sendKeys(Config.getProperty("TESTUsername_Associate"));
					Steps.logger.info("UserName: " + Config.getProperty("TESTUsername_Associate"));
					password.sendKeys(Config.getProperty("TESTPassword_Associate"));
					Steps.logger.info("Password: " + Config.getProperty("TESTPassword_Associate"));
					break;

				default:
					System.out.println("User trying to login with : " + userType + " credentials");
					break;
				}
			}
				else if (env.equalsIgnoreCase("STAGE")) {
					switch (userType) {
					case "Admin":
						username.sendKeys(Config.getProperty("UAUsername_Admin"));
						Steps.logger.info("UserName: " + Config.getProperty("UAUsername_Admin"));
						password.sendKeys(Config.getProperty("UAPassword_Admin"));
						Steps.logger.info("Password: " + Config.getProperty("UAPassword_Admin"));
						break;
					case "Supervisor":
						username.sendKeys(Config.getProperty("UAUsername_Supervisor"));
						Steps.logger.info("UserName: " + Config.getProperty("UAUsername_Supervisor"));
						password.sendKeys(Config.getProperty("UAPassword_Supervisor"));
						Steps.logger.info("Password: " + Config.getProperty("UAPassword_Supervisor"));
						break;
					case "Associate":
						username.sendKeys(Config.getProperty("UAUsername_Associate"));
						Steps.logger.info("UserName: " + Config.getProperty("UAUsername_Associate"));
						password.sendKeys(Config.getProperty("UAPassword_Associate"));
						Steps.logger.info("Password: " + Config.getProperty("UAPassword_Associate"));
						break;

					default:
						System.out.println("User trying to login with : " + userType + " credentials");
						break;
					}
			}
			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(signInBtn));
			signInBtn.click();
			Steps.logger.info("Clicked on Sign in Button");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, facilitySelection, 180);
			if (!facilityApplyBtn.getText().contains("MM3 - QSC")) {

				facilitySelection.click();
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, warehouseDropdown, 180);
				warehouseDropdown.click();
				if (SeleniumTestHelper.isElementDisplayed(verWarehouse)) {
					verWarehouse.click();
				} else {
					warehouseDropdown.click();
					warehouseDropdown.click();
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, verWarehouse, 180);
					verWarehouse.click();
				}
				if (BusinessUnitDisp.getText() != "QSC") {
					BusinessUnitDd.click();
					if (verBusinessUnit.isEnabled()) {
						verBusinessUnit.click();
					}
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, facilityApplyBtn, 180);
					if (facilityApplyBtn.isEnabled()) {
						facilityApplyBtn.click();
					}

					SeleniumTestHelper.waitForElementToBeDisplayed(driver, userLoggedin, 180);
				}
			}
			userLoggedin.click();
			Steps.logger.info("User in Home Page");
			if (!maximizedChkbox.isSelected()) {
				SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(maximizedChkbox));
				Steps.logger.info("Pages will be maximized");
				maximizedChkbox.click();
			}
			if (!tileSingleClick.isSelected()) {
				SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(tileSingleClick));
				Steps.logger.info("Single click is enabled");
				tileSingleClick.click();
				Thread.sleep(1000);
			}

			TestedBy = driver
					.findElement(By.xpath("//a[@data-qtip='Workspaces']/following-sibling::a[1]/following::label[3]"))
					.getText();
			// Steps.logger.info("TestedBy: "+TestedBy);
			Reporter.addStepLog("User logged in successfully with "+ userType+" crdentials");
			Thread.sleep(2000);
			userLoggedin.click();
		}

		catch (NoSuchElementException noSuchElementExec) {

			System.out.println("Error occured : " + noSuchElementExec.getMessage());
			Steps.logger.info("Error occured : " + noSuchElementExec.getMessage());
		}
	}

}
