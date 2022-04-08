package reusable;

import java.io.IOException;
import java.util.List;
import java.util.Set;

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
	
	//added below xpath to support 861 and 851 files validation
	
	@FindBy(xpath = "//a[text()='Document Queue']")
	public WebElement documentQueueLink;
	
	@FindBy(xpath = "//a[text()='Filter']")
	public WebElement filterLink;


	@FindBy(xpath = "//input[@name='txtSndrTPID']")
	public WebElement senderTPIDInput;
	
	@FindBy(xpath = "//input[@name='btnSearchSender']")
	public WebElement searchBtnForSender;

	@FindBy(xpath = "//input[@name='txtRcvrTPID']")
	public WebElement receiverTPIDInput;
	
	@FindBy(xpath = "//input[@name='btnSearchReceiver']")
	public WebElement searchBtnForReceiver;

	@FindBy(xpath = "//input[@name='rdoSelectApp'][1]")
	public WebElement radioSelectApp;
	
	@FindBy(xpath = "//input[@name='txtAppType']")
	public WebElement appTypeInput;
	
	@FindBy(xpath = "//input[@name='btnSearchSubType']")
	public WebElement searchBtnForAppType;

	@FindBy(xpath = "//input[@name='btnOk']")
	public WebElement okBtn;
	
//	@FindBy(xpath = "//input[@name='rdoDocChoice' and @value='0']")
//	public WebElement selectFirstRadioAfterFilter;
//	
//	@FindBy(xpath = "//input[@name='btnDoc' and @value='View Doc']")
//	public WebElement viewDocBtn;
	
	public static String environment = Config.getProperty("Environment");
	public static String account = Config.getProperty("Account");

	public  void logintoFedexNet() throws Exception {
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 100);
		String env = environment;
		// String userType= Config.getProperty("UserRole");
		//String userType= Config.getProperty("UserRole");
		String custAccount = account; 
		System.out.println("customer account"+custAccount);
		if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env") || env.equalsIgnoreCase("L2")|| env.equalsIgnoreCase("L5")|| env.equalsIgnoreCase("L4")) {
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
	
	public void verify861And856Files(String dropEnv, String filetype, String filepath)throws Exception {
		try {
			driver.switchTo().frame("LinkFrame");
			Thread.sleep(1000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, documentQueueLink, 50);
			documentQueueLink.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, filterLink, 50);
			filterLink.click();
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			driver.switchTo().frame("ApplicationFrame");
			driver.switchTo().frame("mainFrame");
			Thread.sleep(1000);
			Steps.logger.info("selected the link and swith to frame");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, senderTPIDInput, 50);
			senderTPIDInput.sendKeys(dropEnv);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, searchBtnForSender, 50);
			searchBtnForSender.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, receiverTPIDInput, 50);
			receiverTPIDInput.sendKeys("QSC");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, searchBtnForReceiver, 50);
			searchBtnForReceiver.click();

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, radioSelectApp, 50);
			radioSelectApp.click();

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, appTypeInput, 50);
			appTypeInput.sendKeys(filetype);

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, searchBtnForAppType, 50);
			searchBtnForAppType.click();
			Steps.logger.info("Clicked on Search button after providing input as 861");

			driver.switchTo().defaultContent();
			driver.switchTo().parentFrame();
			driver.switchTo().frame("ApplicationFrame");
			driver.switchTo().frame("bottomFrame");

			Steps.logger.info("switched to bottom frame frame");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, okBtn, 50);
			okBtn.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
			Steps.logger.info("clicked on Ok button successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void logintoFedexNetForFileValidation() throws Exception {

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 100);
		String env = environment;
		String custAccount = account;
		Steps.logger.info("customer account" + custAccount);
		if (env.equalsIgnoreCase("L1") || env.equalsIgnoreCase("@Env") || env.equalsIgnoreCase("L2")
				|| env.equalsIgnoreCase("L5") || env.equalsIgnoreCase("L4")) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, username, 50);
			username.sendKeys(Config.getProperty("FedexNetUsername_FileVerify" + "_" + custAccount));
			Steps.logger.info("Entered UserName: " + Config.getProperty("FedexNetUsername_FileVerify" + "_" + custAccount));
			password.sendKeys(Config.getProperty("FedexNetPassword_FileVerify" + "_" + custAccount));
			Steps.logger.info("Entered Password: " + Config.getProperty("FedexNetPassword_FileVerify" + "_" + custAccount));
			SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(signInBtn));
			signInBtn.click();
			Steps.logger.info("Clicked on SignIn Button");
			Reporter.addStepLog("Entered Credentails and Clicked on SignIn Button...");
			Thread.sleep(240000);
		}
	}
	
}
