package pages;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import globalFunc.Screenshots;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;

public class HomePage {
	WebDriver driver;

	public HomePage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@data-ref='targetEl' and @id='topbar-1012-targetEl']/a[1]")
	public WebElement menuBtn;

	@FindBy(xpath = "//input[contains(@id,'mps_menusearch')]")
	public WebElement searchTxt;

	@FindBy(xpath = "//a[@data-qtip='Open Windows']")
	public WebElement openWindows;

	@FindBy(xpath = "//a[@data-qtip='Home']")
	public WebElement homeIcon;

	@FindBy(xpath = "//span[.='Close']")
	public WebElement closeBtn;

	@FindBy(xpath = "//input[@value='Clear All' and @type='button']")
	public WebElement checkallBtn;

	@FindBy(xpath = "//a[@data-qtip='Workspaces']/following-sibling::a[1]")
	public WebElement userLoggedin;
	@FindBy(xpath = "//span[text()='Sign out']")
	public WebElement signoutBtn;

	public void menuItemsIntegrationSelection(String Screenname)
			throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		System.out.println("Clicking on Menu btn");
		menuBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, searchTxt, 50);
		searchTxt.sendKeys(Screenname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		driver.findElement(
				By.xpath("//ul[@data-ref='listEl']/li/div[text()=' (Integration)']/b[text()='" + Screenname + "']"))
				.click();
		Thread.sleep(3000);
		SeleniumTestHelper.switchToInnerFrame(driver);

	}

	public void userClosesOpenedwindow(String Screenname) throws Exception {
		driver.switchTo().defaultContent();
		SeleniumTestHelper.WaitForElement(openWindows, 30);
		openWindows.click();
		Thread.sleep(3000);
		SeleniumTestHelper.Close_OpenedWindow(Screenname, driver);
	}

	public void MenuItems_Configuration_Selection(String Screenname) throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		menuBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, searchTxt, 50);
		searchTxt.sendKeys(Screenname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		driver.findElement(
				By.xpath("//ul[@data-ref='listEl']/li/div[text()=' (Configuration)']/b[text()='" + Screenname + "']"))
				.click();
		Thread.sleep(3000);
	}

	public void MenuItems_Distribution_Selection(String Screenname) throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 100);
		menuBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, searchTxt, 50);
		searchTxt.sendKeys(Screenname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		driver.findElement(
				By.xpath("//ul[@data-ref='listEl']/li/div[text()=' (Distribution)']/b[text()='" + Screenname + "']"))
				.click();
		Thread.sleep(3000);
		/*
		 * if(!(driver.findElements(By.tagName("iframe")).size()==0)) {
		 * driver.switchTo().frame(0); }
		 */
	}
	
	public void MenuItems_Reporting_Selection(String Screenname) throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 100);
		menuBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, searchTxt, 50);
		searchTxt.sendKeys(Screenname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		driver.findElement(
				By.xpath("//ul[@data-ref='listEl']/li/div[text()=' (Reporting)']/b[text()='" + Screenname + "']"))
				.click();
		Thread.sleep(5000);
	}
	
	public void user_logout_from_application()
			throws Exception {
		driver.switchTo().defaultContent();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userLoggedin, 50);
		userLoggedin.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, signoutBtn, 50);
		signoutBtn.click();
		Steps.logger.info("Clicked on sign out button");
		Thread.sleep(12000);
		String Title_signout = driver.getTitle();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.assertEquals(Title_signout, "Sign Out | Manhattan Associates Inc.");
		Reporter.addStepLog("Sign Out is successfull");

	}
	public void user_logout_from_application1()
			throws Exception {
		driver.switchTo().defaultContent();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userLoggedin, 50);
		userLoggedin.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, signoutBtn, 50);
		signoutBtn.click();
		Steps.logger.info("Clicked on sign out button");

	}
	public void user_closes_openedwindow(String Screenname) throws Exception
	{
		driver.switchTo().defaultContent();
		SeleniumTestHelper.WaitForElement(openWindows, 50);
		openWindows.click();
		SeleniumTestHelper.Close_OpenedWindow(Screenname, driver);
		Thread.sleep(3000);
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Closed the open Window");
	}
	public void user_click_openedWindow(String Screenname) throws Exception
	{
		driver.switchTo().defaultContent();
		SeleniumTestHelper.WaitForElement(openWindows, 50);
		openWindows.click();
		Thread.sleep(3000);
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Closed the open Window");
	}
}
