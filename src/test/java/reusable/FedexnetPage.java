package reusable;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.Screenshots;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;

public class FedexnetPage  extends Steps {
	WebDriver driver;
	
	public FedexnetPage() throws Throwable {
		// this.driver = Driver.getInstance();
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='UserID']")
	public WebElement username;

	@FindBy(xpath = "//input[@name='Password']")
	public WebElement password;

	@FindBy(xpath = "//input[@name='Submit']")
	public WebElement signInBtn;
	
	@FindBy(xpath = "//a[text()='Transfer Doc']")
	public WebElement TransferDoc;
	
	@FindBy(xpath = "//a[text()='Send Doc']")
	public WebElement SendDoc;
	
	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement Logout;
	
	@FindBy(xpath = "//frame[@name='topFrame']")
	public WebElement topFrame;
	
	public static String environment = Config.getProperty("Environment");
	public static String account = Config.getProperty("Account");

	public  void logintoFedexNet() throws Exception {
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 100);
		String env = environment;
		// String userType= Config.getProperty("UserRole");
		//String userType= Config.getProperty("UserRole");
		String custAccount = account; 
		System.out.println("customer account"+custAccount);
		if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env") || env.equalsIgnoreCase("L2")|| env.equalsIgnoreCase("L5")) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 50);
			username.sendKeys(Config.getProperty("FedexNetUsername_DEV"+"_"+custAccount));
			Steps.logger.info("DEVUserName: " + Config.getProperty("FedexNetUsername_DEV"+"_"+custAccount));
			password.sendKeys(Config.getProperty("FedexNetPassword_DEV"+"_"+custAccount));
			Steps.logger.info("DEVPassword: " + Config.getProperty("FedexNetPassword_DEV"+"_"+custAccount));
			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(signInBtn));
			signInBtn.click();
			Thread.sleep(3000);
		}
	}
	
	public void dropOrder(String dropEnv, String filetype, String filepath) throws Exception {

		driver.switchTo().frame("LinkFrame");
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, TransferDoc, 50);
		TransferDoc.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, SendDoc, 50);
		SendDoc.click();
		Thread.sleep(1000);
		driver.switchTo().parentFrame();		
		driver.switchTo().frame("ApplicationFrame");
		driver.switchTo().frame("topFrame");	
		Thread.sleep(1000);
		//WebElement table =  driver.findElement(By.xpath("/html/body/form/table[4]"));
		List<WebElement>  rows =  driver.findElements(By.xpath("/html/body/form/table[4]/tbody/tr"));
	    System.out.println("No of row are : " +rows.size()); 
	        //No.of rows 
	     List<WebElement>  cols = rows.get(3).findElements(By.tagName("td")); 
	      System.out.println("No of col are : " + cols.size());	
	      for (int i=4;i<=rows.size();i++)
	      {
	    	  String AppValue =driver.findElement(By.xpath("/html/body/form/table[4]/tbody/tr["+i+"]/td[3]/input")).getAttribute("value");
	    	  String RecNameValue =driver.findElement(By.xpath("/html/body/form/table[4]/tbody/tr["+i+"]/td[2]/input")).getAttribute("value");
	    	  if(RecNameValue.equals(dropEnv)&& AppValue.equals(filetype)) {
	    		 Steps.logger.info("Expected drop Env. "+dropEnv+" and File type "+filetype+ " matched");
	    		 driver.findElement(By.xpath("/html/body/form/table[4]/tbody/tr["+i+"]/td[1]/input")).click();
	    	  break;
	    	  }else if(RecNameValue.equals(dropEnv)&& AppValue.equals(filetype+"UA")) {
	    		 Steps.logger.info("Expected drop Env. "+dropEnv+" and File type "+filetype+"UA"+ " matched");
	    		 driver.findElement(By.xpath("/html/body/form/table[4]/tbody/tr["+i+"]/td[1]/input")).click();
	    	  break;
	    	  }    	 
	      }
	      	driver.switchTo().parentFrame();		
		//	driver.switchTo().frame("ApplicationFrame");
			driver.switchTo().frame("bottomFrame");			
			Thread.sleep(1000);		
			
			// Locating input tag which as type as file.
			WebElement searchBox= driver.findElement(By.name("FILENAME"));
			Thread.sleep(1000);
			// Sending file name as argument to input tag
			searchBox.sendKeys(filepath);
			Thread.sleep(1000);
			driver.findElement(By.name("btnUPLOAD")).click();
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
			driver.switchTo().frame("topFrame");
			Thread.sleep(1000);
			String validationMsg = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr[1]/td")).getText();
	
			if(validationMsg.contains("Acknowledgement received")) {
				Steps.logger.info("Upload successful");
				
			}else {
				Steps.logger.info("Upload Unsuccessful");
			}
	}

	public void logoutApplication() throws InterruptedException {
		
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		//driver.switchTo().frame("ApplicationFrame");
		Thread.sleep(1000);
		driver.switchTo().frame("LinkFrame");
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Logout, 10);
		Logout.click();
		Thread.sleep(3000);
		Steps.logger.info("User logged out from Fedexnet");
		
	}
	
}
