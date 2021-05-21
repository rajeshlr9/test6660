package pages;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Steps;
import globalFunc.Screenshots;
import utils.Config;
import utils.SeleniumTestHelper;

public class UsersPage {
	WebDriver driver;

	public UsersPage() throws Throwable {

		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id=\"mps_solutions_menu-1014\"]")
	public WebElement selectStage;

	@FindBy(xpath ="//span[@id=\"button-1013-btnIconEl\"]")
	public WebElement threeButtonIcon;

	@FindBy(xpath = "//input[@id=\"mps_menusearch-1075-inputEl\"]")
	public WebElement search;

	@FindBy(xpath = "//input[@id=\"combobox-1199-inputEl\"]")
	public WebElement filterOut;

	@FindBy(xpath = "(//input[@data-ref=\"inputEl\"])[8]")
	public WebElement textfield;

	@FindBy(xpath = "//span[text()=\"Apply\"]")
	public WebElement apply;

	@FindBy(xpath = "//div[@class=\"x-grid-row-checker\"]")
	public WebElement selectToEdit;

	@FindBy(xpath = "//span[text()=\"Edit\"]")
	public WebElement edit;

	@FindBy(xpath = "//span[text()=\"Data Access\"]")
	public WebElement DataAccess;

	@FindBy(xpath = "//span[contains(text(),\"Users\")]")
	public WebElement Users;

	@FindBy(xpath = "(//div[@class=\"x-grid-row-checker\"])[2]")
	public WebElement checklist;

	@FindBy(xpath = "(//span[text()=\"Delete\"])[3]")
	public WebElement delete;

	@FindBy(xpath = "(//span[text()=\"Delete\"])[4]")
	public WebElement confirmdelete;

	private static String modetype ="//span[contains(text(),\"%s\")]";

	private static String validation ="//div[contains(text(),\"%s\")]";

	public boolean  Validation_of_UserRole_With_One_Role_Manhattan_Application() throws Exception 
	{
		//Thread.sleep(7000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String Region = Steps.scenarioData.get("Region");
		String Username= Steps.scenarioData.get("Username");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectStage, 10);
		selectStage.click();
		driver.findElement(By.xpath(String.format(modetype, Config.getProperty("Manhattan_Mode_Stage")))).click();	
		String MainWindow = driver.getWindowHandle();
		System.out.println("Main window handle is " + MainWindow);
		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Child window handle is" + s1);
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Thread.sleep(3000);
				threeButtonIcon.click();
				driver.findElement(By.xpath(String.format(modetype, Config.getProperty("Manhattan_Menu_List")))).click();
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, filterOut, 10);
				Thread.sleep(2000);
				filterOut.sendKeys(Config.getProperty("Manhattan_Filter_list"));
				Thread.sleep(2000);
				textfield.click();
				Thread.sleep(2000);
				textfield.sendKeys(Username);
				SeleniumTestHelper.waitForElementToBeClickable(driver, apply, 10);
				Thread.sleep(2000);
				apply.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, selectToEdit, 10);
				selectToEdit.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, edit, 10);
				edit.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, DataAccess, 10);
				DataAccess.click();
				String role1 = selectRole.trim();
				driver.findElement(By.xpath(String.format(validation,Businessunit))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,Region))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,role1))).isDisplayed();

			}
		}
		return true;
	}
	public boolean  Validation_of_new_Username_and_Role_In_Manhattan_Application() throws Exception 
	{
		//Thread.sleep(7000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String Region = Steps.scenarioData.get("Region");
		String Username= Steps.scenarioData.get("Username");
		String[] username= Username.split(",");
		String username1 = username[0];
		String username2 = username[1];
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectStage, 10);
		selectStage.click();
		driver.findElement(By.xpath(String.format(modetype, Config.getProperty("Manhattan_Mode_Stage")))).click();	
		String MainWindow = driver.getWindowHandle();
		System.out.println("Main window handle is " + MainWindow);
		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Child window handle is" + s1);
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Thread.sleep(3000);
				threeButtonIcon.click();
				driver.findElement(By.xpath(String.format(modetype, Config.getProperty("Manhattan_Menu_List")))).click();
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, filterOut, 10);
				Thread.sleep(1000);
				filterOut.sendKeys(Config.getProperty("Manhattan_Filter_list"));
				Thread.sleep(2000);
				textfield.click();
				Thread.sleep(1000);
				textfield.sendKeys(username2);
				SeleniumTestHelper.waitForElementToBeClickable(driver, apply, 10);
				Thread.sleep(1000);
				apply.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, selectToEdit, 10);
				selectToEdit.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, edit, 10);
				edit.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, DataAccess, 10);
				DataAccess.click();
				String role1 = selectRole.trim();
				driver.findElement(By.xpath(String.format(validation,Businessunit))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,Region))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,role1))).isDisplayed();

			}
		}
		return true;
	}
	public boolean  Validation_of_UserRole_With_two_Role_Manhattan_Application() throws Exception 
	{
		//Thread.sleep(7000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String Region = Steps.scenarioData.get("Region");
		String Username= Steps.scenarioData.get("Username");
		String[] parts = selectRole.split(",");
		String string1 = parts[0];
		String string2 = parts[1];
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectStage, 10);
		selectStage.click();
		driver.findElement(By.xpath(String.format(modetype, Config.getProperty("Manhattan_Mode_Stage")))).click();	
		String MainWindow = driver.getWindowHandle();
		System.out.println("Main window handle is " + MainWindow);
		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Child window handle is" + s1);
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Thread.sleep(2000);
				threeButtonIcon.click();
				driver.findElement(By.xpath(String.format(modetype, Config.getProperty("Manhattan_Menu_List")))).click();
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, filterOut, 10);
				Thread.sleep(2000);
				filterOut.sendKeys(Config.getProperty("Manhattan_Filter_list"));
				Thread.sleep(1000);
				textfield.click();
				Thread.sleep(1000);
				textfield.sendKeys(Username);
				SeleniumTestHelper.waitForElementToBeClickable(driver, apply, 10);
				Thread.sleep(1000);
				apply.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, selectToEdit, 10);
				selectToEdit.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, edit, 10);
				edit.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, DataAccess, 10);
				DataAccess.click();
				String role1 = string1.trim();
				String role2 = string2.trim();
				driver.findElement(By.xpath(String.format(validation,Businessunit))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,Region))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,role1))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,role2))).isDisplayed();
			}
		}
		return true;
	}
	public boolean  Delete_the_userRole__in_Manhattan_Application() throws Exception 
	{
		//Thread.sleep(7000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String Region = Steps.scenarioData.get("Region");
		String Username= Steps.scenarioData.get("Username");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectStage, 10);
		selectStage.click();
		driver.findElement(By.xpath(String.format(modetype, Config.getProperty("Manhattan_Mode_Stage")))).click();	
		String MainWindow = driver.getWindowHandle();
		System.out.println("Main window handle is " + MainWindow);
		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Child window handle is" + s1);
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Thread.sleep(2000);
				threeButtonIcon.click();
				driver.findElement(By.xpath(String.format(modetype, Config.getProperty("Manhattan_Menu_List")))).click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, filterOut, 10);
				filterOut.sendKeys(Config.getProperty("Manhattan_Filter_list"));
				Thread.sleep(1000);
				textfield.click();
				Thread.sleep(1000);
				textfield.sendKeys(Username);
				SeleniumTestHelper.waitForElementToBeClickable(driver, apply, 10);
				apply.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, selectToEdit, 10);
				selectToEdit.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, edit, 10);
				edit.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, DataAccess, 10);
				DataAccess.click();
				String role = selectRole.trim();
				driver.findElement(By.xpath(String.format(validation,Businessunit))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,Region))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,role))).isDisplayed();

				SeleniumTestHelper.waitForElementToBeClickable(driver, checklist, 10);
				checklist.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, delete, 10);
				delete.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, confirmdelete, 10);
				confirmdelete.click();
			}
		}
		return true;
	}
	public boolean  Validation_of_UserRole_With_three_Role_Manhattan_Application() throws Exception 
	{
		//Thread.sleep(7000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String Region = Steps.scenarioData.get("Region");
		String[] parts = selectRole.split(",");
		String string1 = parts[0];
		String string2 = parts[1];
		String string3 = parts[2];
		String Username= Steps.scenarioData.get("Username");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectStage, 10);
		selectStage.click();
		driver.findElement(By.xpath(String.format(modetype, Config.getProperty("Manhattan_Mode_Stage")))).click();	
		String MainWindow = driver.getWindowHandle();
		System.out.println("Main window handle is " + MainWindow);
		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Child window handle is" + s1);
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Thread.sleep(2000);
				threeButtonIcon.click();
				driver.findElement(By.xpath(String.format(modetype, Config.getProperty("Manhattan_Menu_List")))).click();
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, filterOut, 10);
				Thread.sleep(2000);
				filterOut.sendKeys(Config.getProperty("Manhattan_Filter_list"));
				Thread.sleep(2000);
				textfield.click();
				Thread.sleep(1000);
				textfield.sendKeys(Username);
				SeleniumTestHelper.waitForElementToBeClickable(driver, apply, 10);
				Thread.sleep(1000);
				apply.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, selectToEdit, 10);
				selectToEdit.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, edit, 10);
				edit.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, DataAccess, 10);
				DataAccess.click();
				String role1 = string1.trim();
				String role2 = string2.trim();
				String role3 = string3.trim();
				driver.findElement(By.xpath(String.format(validation,Businessunit))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,Region))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,role1))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,role2))).isDisplayed();
				driver.findElement(By.xpath(String.format(validation,role3))).isDisplayed();
			}
		}
		return true;
	}
}
