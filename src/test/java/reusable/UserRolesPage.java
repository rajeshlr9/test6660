package reusable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import StepDefinition.Steps;
import utils.Config;
import utils.SeleniumTestHelper;

public class UserRolesPage {
	
	WebDriver driver;

	public UserRolesPage() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}
	
	public static String environment = Config.getProperty("Environment"); // Different environments Dev and Test
	
	@FindBy(id = "userNameId")
	public WebElement username;

	@FindBy(id = "passwordId")
	public WebElement Password;
	
	@FindBy(xpath ="//button[text()=\" Log In \"]")
	public WebElement login;
	

	@FindBy(xpath = "/html/body/app-root/div[2]/div/ul/li[4]")
	public WebElement userRoles;

	@FindBy(xpath = "//input[@id=\"s10\"]")
	public WebElement userId;

	@FindBy(xpath = "//input[@id=\"s9\"]")
	public WebElement password;

	@FindBy(xpath = "//input[@id=\"s8\"]")
	public WebElement firstName;

	@FindBy(xpath = "//input[@id=\"s7\"]")
	public WebElement lastName;

	@FindBy(xpath = "//select[@id='BizUnit']")
	public WebElement businessUnit;

	@FindBy(xpath = "//select[@id=\"Region\"]")
	public WebElement region;

	@FindBy(xpath = "//button[text()=\" Submit\"]")
	public WebElement submit;
	
	@FindBy(xpath = "//a[text()=\"Logout\"]")
	public WebElement logout;

	private static String role ="//*[contains(text(),\"%s\")]//input[@type=\"checkbox\"]";

	public  boolean selectRoleName(String roleName) { 
		driver.findElement(By.xpath(String.format(role, roleName))).click();
		return true;
	}

	private static WebElement findElement(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}
	public void loginToRooneyApp() throws Exception {
		{
	
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 180);
				String env = environment;
				// String userType= Config.getProperty("UserRole");
				if(env.equalsIgnoreCase("Dev") || env.equalsIgnoreCase("@Env")) {
					username.sendKeys(Config.getProperty("Rooney_DEV_Username"));
					Steps.logger.info("Rooney_DEV_Username: " + Config.getProperty("Rooney_DEV_Username"));
					Password.sendKeys(Config.getProperty("Rooney_DEV_Password"));
					Steps.logger.info("Rooney_DEV_Password: " + Config.getProperty("Rooney_DEV_Password"));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, login, 10);
					login.click();
				}
				else
			      Steps.logger.info("not able to login");
}
	}
	public void user_create_a_user_role_With_different_role()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Firstname= Steps.scenarioData.get("FirstName");
		String Lastname = Steps.scenarioData.get("LastName");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String Region = Steps.scenarioData.get("Region");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstName, 10);
		firstName.sendKeys(Firstname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(selectRole);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();		
		Thread.sleep(1000);
		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		
		Thread.sleep(1000);	
		// Displaying alert message		
		Assert.assertEquals(alertMessage,Config.getProperty("Rooney_Message"),  "Update Message");	
		Thread.sleep(1000);

		// Accepting alert		
		alert.accept();
		logout.click();
	}
	public void user_create_a_user_role_With_two_different_role()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String selectRole= Steps.scenarioData.get("Roles");
		String[] parts = selectRole.split(",");
		String string1 = parts[0];
		String string2 = parts[1];
		System.out.println(string1);  
		System.out.println(string2);
		String Firstname= Steps.scenarioData.get("FirstName");
		String Lastname = Steps.scenarioData.get("LastName");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String Region = Steps.scenarioData.get("Region");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstName, 10);
		firstName.sendKeys(Firstname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(string1);
		selectRoleName(string2);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();		
		Thread.sleep(1000);
		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		
		Thread.sleep(1000);	
		// Displaying alert message		
		Assert.assertEquals(alertMessage,Config.getProperty("Rooney_Message"),  "Update Message");	
		Thread.sleep(1000);

		// Accepting alert		
		alert.accept();
		logout.click();
	}
	public void user_create_a_user_role_for_Without_Region()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Firstname= Steps.scenarioData.get("FirstName");
		String Lastname = Steps.scenarioData.get("LastName");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstName, 10);
		firstName.sendKeys(Firstname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(selectRole);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		submit.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();		
		Thread.sleep(1000);
		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		
		Thread.sleep(1000);	
		// Displaying alert message		
		System.out.println(alertMessage);	
		Thread.sleep(1000);

		// Accepting alert		
		alert.accept();	
		logout.click();
	}

	public void user_create_a_user_role_for_Without_BusinessUnit()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Firstname= Steps.scenarioData.get("FirstName");
		String Lastname = Steps.scenarioData.get("LastName");
		String Region = Steps.scenarioData.get("Region");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstName, 10);
		firstName.sendKeys(Firstname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(selectRole);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();
		Thread.sleep(2000);
		// Switching to Alert        
		Alert alert = driver.switchTo().alert();		
		Thread.sleep(1000);
		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		

		// Displaying alert message		
		System.out.println(alertMessage);	
		Thread.sleep(1000);

		// Accepting alert		
		alert.accept();	
		logout.click();
	}
	public void user_create_a_user_role_for_Without_FirstName()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String selectRole= Steps.scenarioData.get("Roles");	
		String Lastname = Steps.scenarioData.get("LastName");
		String Region = Steps.scenarioData.get("Region");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(selectRole);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();		

		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		
		Thread.sleep(1000);
		// Displaying alert message		
		System.out.println(alertMessage);	
		Thread.sleep(1000);

		// Accepting alert		
		alert.accept();	
		logout.click();
	}
	public void user_create_a_user_role_for_Without_UserName()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Firstname= Steps.scenarioData.get("FirstName");
		String Lastname = Steps.scenarioData.get("LastName");
		String Region = Steps.scenarioData.get("Region");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		userId.clear();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstName, 10);
		firstName.sendKeys(Firstname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(selectRole);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();
		 Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();		
		 Thread.sleep(1000);
		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		
		
		// Displaying alert message		
		System.out.println(alertMessage);	
		Thread.sleep(1000);

		// Accepting alert		
		alert.accept();	
		logout.click();
	}	
	public void user_create_a_user_role_for_With_Updating_UserName()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Firstname= Steps.scenarioData.get("FirstName");
		String Lastname = Steps.scenarioData.get("LastName");
		String Region = Steps.scenarioData.get("Region");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String UserName= Steps.scenarioData.get("Username");
		String[] parts = UserName.split(",");
		String string1 = parts[0];
		String string2 = parts[1];
		userId.clear();
		userId.sendKeys(string2);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstName, 10);
		firstName.sendKeys(Firstname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(selectRole);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();	
		logout.click();
	}

	public void user_create_a_user_role_with_wrong_password()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String Password = Steps.scenarioData.get("Password");
		String selectRole= Steps.scenarioData.get("Roles");
		String Firstname= Steps.scenarioData.get("FirstName");
		String Lastname = Steps.scenarioData.get("LastName");
		String Region = Steps.scenarioData.get("Region");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String[] parts = Password.split(",");
		String string1 = parts[0];
		String string2 = parts[1];
		password.clear();
		password.sendKeys(string2);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstName, 10);
		firstName.sendKeys(Firstname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(selectRole);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();
		Thread.sleep(2000);
		// Switching to Alert        
		Alert alert = driver.switchTo().alert();		

		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		

		// Displaying alert message		
		System.out.println(alertMessage);	
		Thread.sleep(1000);

		// Accepting alert		
		alert.accept();	
		logout.click();
	}

	public void user_create_user_role_without_exiting_refreshing_trying_to_add_a_new_role()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String selectRole= Steps.scenarioData.get("Roles");
		String[] parts = selectRole.split(",");
		String string1 = parts[0];
		String string2 = parts[1];
		System.out.println(string1);  
		System.out.println(string2);
		String Firstname= Steps.scenarioData.get("FirstName");
		String Lastname = Steps.scenarioData.get("LastName");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String Region = Steps.scenarioData.get("Region");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstName, 10);
		firstName.sendKeys(Firstname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(string1);	
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();
		Thread.sleep(2000);
		// Switching to Alert        
				Alert alert = driver.switchTo().alert();		
				Thread.sleep(1000);
				// Capturing alert message.    
				String alertMessage= driver.switchTo().alert().getText();		

				// Displaying alert message		
				System.out.println(alertMessage);	
				Thread.sleep(1000);

				// Accepting alert		
				alert.accept();
	
		selectRoleName(string2);
		submit.click();
		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();		
		Thread.sleep(1000);
		// Capturing alert message.    
		String alertMessage1= driver.switchTo().alert().getText();		
		Thread.sleep(1000);	
		// Displaying alert message		
		Assert.assertEquals(alertMessage1,Config.getProperty("Rooney_Message"),  "Update Message");	
		Thread.sleep(1000);

		// Accepting alert		
		alert1.accept();
		logout.click();
	}
	public void user_create_user_role_with_three_role()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String selectRole= Steps.scenarioData.get("Roles");
		String[] parts = selectRole.split(",");
		String string1 = parts[0];
		String string2 = parts[1];
		String string3 = parts[2];
		String Firstname= Steps.scenarioData.get("FirstName");
		String Lastname = Steps.scenarioData.get("LastName");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String Region = Steps.scenarioData.get("Region");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstName, 10);
		firstName.sendKeys(Firstname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(string1);	
		selectRoleName(string2);
		selectRoleName(string3);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();		
		Thread.sleep(1000);
		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		
		Thread.sleep(1000);	
		// Displaying alert message		
		Assert.assertEquals(alertMessage,Config.getProperty("Rooney_Message"),  "Update Message");	
		Thread.sleep(1000);

		// Accepting alert		
		alert.accept();
		logout.click();
	}
	public void user_create_a_user_role_for_Without_LastName()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		String selectRole= Steps.scenarioData.get("Roles");	
		String Firstname = Steps.scenarioData.get("FirstName");
		String Region = Steps.scenarioData.get("Region");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		firstName.sendKeys(Firstname);
		lastName.clear();
		selectRoleName(selectRole);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();		
		Thread.sleep(1000);
		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		

		// Displaying alert message		
		System.out.println(alertMessage);	
		Thread.sleep(1000);

		// Accepting alert		
		alert.accept();	
		logout.click();
	}
	public void user_access_control_is_not_mapped_to_the_region()throws Exception 
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, userRoles, 10);
		userRoles.click();	
		Thread.sleep(1000);
		String selectRole= Steps.scenarioData.get("Roles");
		String Firstname= Steps.scenarioData.get("FirstName");
		String Lastname = Steps.scenarioData.get("LastName");
		String Region = Steps.scenarioData.get("Region");
		String Businessunit = Steps.scenarioData.get("BusinessUnit");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstName, 10);
		firstName.sendKeys(Firstname);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lastName, 10);
		lastName.sendKeys(Lastname);
		selectRoleName(selectRole);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, businessUnit, 10);
		businessUnit.click();
		SeleniumTestHelper.selectFromDropDown(businessUnit, Businessunit, "value");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, region, 10);
		region.click();
		SeleniumTestHelper.selectFromDropDown(region, Region, "value");
		submit.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();		
		Thread.sleep(1000);
		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		
		Thread.sleep(1000);	
		// Displaying alert message		
		System.out.println(alertMessage);	
		Thread.sleep(1000);

		// Accepting alert		
		alert.accept();	
		logout.click();
	}

}
