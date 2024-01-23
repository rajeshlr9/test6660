package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import globalFunc.CreateBrowser;
import globalFunc.Screenshots;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;

public class ManhattanLoginPage extends Steps {
	WebDriver driver;

	public ManhattanLoginPage() throws Throwable {
		// this.driver = Driver.getInstance();
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	public static String TestedBy = null;

	public static String environment = Config.getProperty("Environment"); // Different environments Dev and Test
	public static String account = Config.getProperty("Account"); //Different accounts QSC and NVI 
	
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
	
	//@FindBy(id = "combobox-1058-trigger-picker")
	@FindBy(xpath="(//input[contains(@class,'x-form-text-default')])[1]")
	//@FindBy(xpath = "//*[@class='x-form-item-body x-form-item-body-default x-form-text-field-body x-form-text-field-body-default  '][0]")
	public WebElement warehouseDropdownArrow;
	
	//@FindBy(id = "combobox-1060-trigger-picker")
	@FindBy(xpath="(//input[contains(@class,'x-form-text-default')])[2]")
	//@FindBy(xpath = "//*[@class='x-form-item-body x-form-item-body-default x-form-text-field-body x-form-text-field-body-default  '][1]")
	public WebElement BusinessUnitDropdownArrow;

	@FindBy(id = "combobox-1058-inputEl")
	public WebElement warehouseDropdown1;

	//@FindBy(id = "boundlist-1059-listEl")
	@FindBy(xpath="(//ul[@class='x-list-plain'])[1]")
	public WebElement warehouseDropdownlist;
	
	//@FindBy(id = "boundlist-1061-listEl")
	@FindBy(xpath="(//ul[@class='x-list-plain'])[2]")
	public WebElement BusinessUnitdropdown;

	@FindBy(xpath = "//li[text()='MM3']")
	public WebElement verWarehouse;

	//@FindBy(xpath = "//A/SPAN[@role=\"presentation\"]/SPAN[@role=\"presentation\"]/SPAN[normalize-space()=\"MM3 - QSC\"]")
	@FindBy (xpath="//span[contains(@id, 'mps_regions_selector')]")
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
	public void loginToManhattanApp() throws Exception {
		{
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 180);
				String env = environment;
				// String userType= Config.getProperty("UserRole");
				if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env")) {
					username.sendKeys(Config.getProperty("DEVUsername_Admin"));
					Steps.logger.info("L1UserName: " + Config.getProperty("DEVUsername_Admin"));
					password.sendKeys(Config.getProperty("DEVPassword_Admin"));
					Steps.logger.info("L1Password: " + Config.getProperty("DEVPassword_Admin"));

				} else if (env.equalsIgnoreCase("L2"))  {
					username.sendKeys(Config.getProperty("TESTUsername_Admin"));
					Steps.logger.info("TESTUserName: " + Config.getProperty("TESTUsername_Admin"));
					password.sendKeys(Config.getProperty("TESTPassword_Admin"));
					Steps.logger.info("TESTPassword: " + Config.getProperty("TESTPassword_Admin"));
				} else if (env.equalsIgnoreCase("L4")) {
					username.sendKeys(Config.getProperty("L4Username_Admin"));
					Steps.logger.info("L4UserName: " + Config.getProperty("L4Username_Admin"));
					password.sendKeys(Config.getProperty("L4Password_Admin"));
					Steps.logger.info("L4Password: " + Config.getProperty("L4Password_Admin"));

				}else if (env.equalsIgnoreCase("L5")) {
					username.sendKeys(Config.getProperty("L5Username_Admin"));
					Steps.logger.info("L5UserName: " + Config.getProperty("L5Username_Admin"));
					password.sendKeys(Config.getProperty("L5Password_Admin"));
					Steps.logger.info("L5Password: " + Config.getProperty("L5Password_Admin"));

				}

				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(signInBtn));
				signInBtn.click();
				Steps.logger.info("Clicked on Sign in Button");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, facilitySelection, 180);
				Thread.sleep(1000);
				
				String Facility = Steps.scenarioData.get("Facility");
				String BusinnesUnit = Steps.scenarioData.get("Account");
				Steps.logger.info("Facility is : "+Facility);
				Steps.logger.info("Business Unit : "+BusinnesUnit);
				
				if (!facilityApplyBtn.getText().contains(Facility + " - " + BusinnesUnit)) {

					facilitySelection.click();
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, warehouseDropdownArrow, 10);
					warehouseDropdownArrow.click();
					//driver.findElement(By.xpath("(//*[@id='x-form-trigger x-form-trigger-default x-form-arrow-trigger x-form-arrow-trigger-default '][0])")).click();
					List<WebElement> list = warehouseDropdownlist.findElements(By.tagName("li"));
					for (WebElement option : list) {
						if (option.getText().equals(Facility)) {
							System.out.println(option.getText());
							option.click(); // click the desired option
							break;
						}
					}
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, BusinessUnitDropdownArrow, 10);
					BusinessUnitDropdownArrow.click();
					List<WebElement> list2 = BusinessUnitdropdown.findElements(By.tagName("li"));
					for (WebElement option2 : list2) {
						
						if (option2.getText().equals(BusinnesUnit)) {
							option2.click(); // click the desired option
							break;
						}
					}
					Thread.sleep(1000);
					SeleniumTestHelper.waitForElementToBeClickable(driver, facilityDisp, 10);
					facilityDisp.click();
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, userLoggedin, 10);
				}
					Screenshots.captureSnapshot(driver);
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
				Thread.sleep(1000);

		}

	}
	
//Only for sanity check
	
	public void loginToManhattanApp2(String customer) throws Exception {
		{
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 180);
				String env = environment;
				// String userType= Config.getProperty("UserRole");
				if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env")) {
					username.sendKeys(Config.getProperty("DEVUsername_Admin"));
					Steps.logger.info("L1UserName: " + Config.getProperty("DEVUsername_Admin"));
					password.sendKeys(Config.getProperty("DEVPassword_Admin"));
					Steps.logger.info("L1Password: " + Config.getProperty("DEVPassword_Admin"));

				} else if (env.equalsIgnoreCase("L2"))  {
					username.sendKeys(Config.getProperty("TESTUsername_Admin"));
					Steps.logger.info("TESTUserName: " + Config.getProperty("TESTUsername_Admin"));
					password.sendKeys(Config.getProperty("TESTPassword_Admin"));
					Steps.logger.info("TESTPassword: " + Config.getProperty("TESTPassword_Admin"));
				} else if (env.equalsIgnoreCase("L4")) {
					username.sendKeys(Config.getProperty("L4Username_Admin"));
					Steps.logger.info("L4UserName: " + Config.getProperty("L4Username_Admin"));
					password.sendKeys(Config.getProperty("L4Password_Admin"));
					Steps.logger.info("L4Password: " + Config.getProperty("L4Password_Admin"));

				}else if (env.equalsIgnoreCase("L5")) {
					username.sendKeys(Config.getProperty("L5Username_Admin"));
					Steps.logger.info("L5UserName: " + Config.getProperty("L5Username_Admin"));
					password.sendKeys(Config.getProperty("L5Password_Admin"));
					Steps.logger.info("L5Password: " + Config.getProperty("L5Password_Admin"));

				}

				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(signInBtn));
				signInBtn.click();
				Steps.logger.info("Clicked on Sign in Button");
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, facilitySelection, 180);
				//Thread.sleep(1000);
				SeleniumTestHelper.WaitForPageLoad();
				String Facility = Steps.scenarioData.get("Facility");
				String BusinnesUnit = customer;
				Steps.logger.info("Facility is : "+Facility);
				Steps.logger.info("Business Unit : "+BusinnesUnit);
				
				if (!facilityApplyBtn.getText().contains(Facility + " - " + BusinnesUnit)) {

					facilitySelection.click();
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, warehouseDropdownArrow, 10);
					warehouseDropdownArrow.click();
					//driver.findElement(By.xpath("(//*[@id='x-form-trigger x-form-trigger-default x-form-arrow-trigger x-form-arrow-trigger-default '][0])")).click();
					List<WebElement> list = warehouseDropdownlist.findElements(By.tagName("li"));
					for (WebElement option : list) {
						if (option.getText().equals(Facility)) {
							System.out.println(option.getText());
							option.click(); // click the desired option
							break;
						}
					}
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, BusinessUnitDropdownArrow, 10);
					BusinessUnitDropdownArrow.click();
					List<WebElement> list2 = BusinessUnitdropdown.findElements(By.tagName("li"));
					for (WebElement option2 : list2) {
						
						if (option2.getText().equals(BusinnesUnit)) {
							option2.click(); // click the desired option
							break;
						}
					}
					//Thread.sleep(1000);
					SeleniumTestHelper.WaitForPageLoad();
					SeleniumTestHelper.waitForElementToBeClickable(driver, facilityDisp, 10);
					facilityDisp.click();
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, userLoggedin, 10);
				}
					Screenshots.captureSnapshot(driver);
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
				Thread.sleep(1000);

		}

	}
	
	
	
	

	public void loginToManhattanApp(String userType) throws Exception {

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 180);
			String env = environment;
			if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env")) {
				switch (userType) {
				case "Admin":
					username.sendKeys(Config.getProperty("DEVUsername_Admin"));
					Steps.logger.info("L1AdminUserName: " + Config.getProperty("DEVUsername_Admin"));
					password.sendKeys(Config.getProperty("DEVPassword_Admin"));
					Steps.logger.info("L1AdminPassword: " + Config.getProperty("DEVPassword_Admin"));
					break;
				case "Supervisor":
					username.sendKeys(Config.getProperty("DEVUsername_Supervisor"));
					Steps.logger.info("L1SupervisorUserName: " + Config.getProperty("DEVUsername_Supervisor"));
					password.sendKeys(Config.getProperty("DEVPassword_Supervisor"));
					Steps.logger.info("L1SupervisorPassword: " + Config.getProperty("DEVPassword_Supervisor"));
					break;
				case "Associate":
					username.sendKeys(Config.getProperty("DEVUsername_Associate"));
					Steps.logger.info("L1AssociateUserName: " + Config.getProperty("DEVUsername_Associate"));
					password.sendKeys(Config.getProperty("DEVPassword_Associate"));
					Steps.logger.info("L1AssociatePassword: " + Config.getProperty("DEVPassword_Associate"));
					break;

				default:
					System.out.println("User trying to login with : " + userType + " credentials");
					break;
				}
			} else if (env.equalsIgnoreCase("L2")) {
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
			} else if (env.equalsIgnoreCase("L4")) {
				switch (userType) {
				case "Admin":
					username.sendKeys(Config.getProperty("L4Username_Admin"));
					Steps.logger.info("UserName: " + Config.getProperty("L4Username_Admin"));
					password.sendKeys(Config.getProperty("L4Password_Admin"));
					Steps.logger.info("Password: " + Config.getProperty("L4Password_Admin"));
					break;
				case "Supervisor":
					username.sendKeys(Config.getProperty("L4Username_Supervisor"));
					Steps.logger.info("UserName: " + Config.getProperty("L4Username_Supervisor"));
					password.sendKeys(Config.getProperty("L4Password_Supervisor"));
					Steps.logger.info("Password: " + Config.getProperty("L4Password_Supervisor"));
					break;
				case "Associate":
					username.sendKeys(Config.getProperty("L4Username_Associate"));
					Steps.logger.info("UserName: " + Config.getProperty("L4Username_Associate"));
					password.sendKeys(Config.getProperty("L4Password_Associate"));
					Steps.logger.info("Password: " + Config.getProperty("L4Password_Associate"));
					break;

				default:
					System.out.println("User trying to login with : " + userType + " credentials");
					break;
				}
			}
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(signInBtn));
			signInBtn.click();
			Steps.logger.info("Clicked on Sign in Button");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, facilitySelection, 180);
			Thread.sleep(1000);
			String Facility = Steps.scenarioData.get("Facility");
			String BusinnesUnit = Steps.scenarioData.get("Account");
			
			if (!facilityApplyBtn.getText().contains(Facility + " - " + BusinnesUnit)) {

				facilitySelection.click();
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, warehouseDropdownArrow, 10);
				warehouseDropdownArrow.click();
				//driver.findElement(By.xpath("(//*[@id='x-form-trigger x-form-trigger-default x-form-arrow-trigger x-form-arrow-trigger-default '][0])")).click();
				List<WebElement> list = warehouseDropdownlist.findElements(By.tagName("li"));
				for (WebElement option : list) {
					if (option.getText().equals(Facility)) {
						System.out.println(option.getText());
						option.click(); // click the desired option
						break;
					}
				}
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, BusinessUnitDropdownArrow, 10);
				BusinessUnitDropdownArrow.click();
				List<WebElement> list2 = BusinessUnitdropdown.findElements(By.tagName("li"));
				for (WebElement option2 : list2) {
					
					if (option2.getText().equals(BusinnesUnit)) {
						option2.click(); // click the desired option
						break;
					}
				}
				Thread.sleep(1000);
				SeleniumTestHelper.waitForElementToBeClickable(driver, facilityDisp, 10);
				facilityDisp.click();
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, userLoggedin, 10);
			}
				Screenshots.captureSnapshot(driver);
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

}
