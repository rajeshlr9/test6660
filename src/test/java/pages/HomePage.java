package pages;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Steps;
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
			throws InterruptedException, IOException, ParserConfigurationException, TransformerException {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		System.out.println("Clicking on Menu btn");
		menuBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, searchTxt, 50);
		searchTxt.sendKeys(Screenname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		driver.findElement(
				By.xpath("//ul[@data-ref='listEl']/li/div[text()=' (Integration)']/b[text()='" + Screenname + "']"))
				.click();
		Thread.sleep(5000);
		SeleniumTestHelper.switchToInnerFrame(driver);

	}

	public void userClosesOpenedwindow(String Screenname) throws InterruptedException {
		driver.switchTo().defaultContent();
		SeleniumTestHelper.WaitForElement(openWindows, 50);
		openWindows.click();
		Thread.sleep(5000);
		SeleniumTestHelper.Close_OpenedWindow(Screenname, driver);
	}

	public void MenuItems_Configuration_Selection(String Screenname) throws InterruptedException, IOException {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		menuBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, searchTxt, 50);
		searchTxt.sendKeys(Screenname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		driver.findElement(
				By.xpath("//ul[@data-ref='listEl']/li/div[text()=' (Configuration)']/b[text()='" + Screenname + "']"))
				.click();
		Thread.sleep(5000);
	}

	public void MenuItems_Distribution_Selection(String Screenname) throws InterruptedException, IOException {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 100);
		menuBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, searchTxt, 50);
		searchTxt.sendKeys(Screenname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, menuBtn, 50);
		driver.findElement(
				By.xpath("//ul[@data-ref='listEl']/li/div[text()=' (Distribution)']/b[text()='" + Screenname + "']"))
				.click();
		Thread.sleep(5000);
		/*
		 * if(!(driver.findElements(By.tagName("iframe")).size()==0)) {
		 * driver.switchTo().frame(0); }
		 */
	}
	
	public void MenuItems_Reporting_Selection(String Screenname) throws InterruptedException, IOException {
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
			throws InterruptedException, IOException, ParserConfigurationException, TransformerException {
		driver.switchTo().defaultContent();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userLoggedin, 50);
		userLoggedin.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, signoutBtn, 50);
		signoutBtn.click();
		Steps.logger.info("Clicked on sign out button");
		Thread.sleep(12000);
		String Title_signout = driver.getTitle();
		SeleniumTestHelper.assertEquals(Title_signout, "Sign Out | Manhattan Associates Inc.");

	}
	public void user_closes_openedwindow(String Screenname) throws InterruptedException
	{
		driver.switchTo().defaultContent();
		SeleniumTestHelper.WaitForElement(openWindows, 50);
		openWindows.click();
		SeleniumTestHelper.Close_OpenedWindow(Screenname, driver);
	}
}
