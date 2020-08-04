package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import entity.DistributionOrders;
import utils.Driver;
import utils.SeleniumTestHelper;

public class CheckInPage {
	
	WebDriver driver;
	public CheckInPage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	HomePage homepage = new HomePage();
	
	@FindBy(xpath="(//input[@name='trailerName'])[1]") 
	public WebElement trailerInputBx;
	
	@FindBy(xpath="(//span[text()='Carrier:']//following::div[4])[1]") 
	public WebElement carrierSearchBx;
	
	@FindBy(xpath="//*[@id='textfield-5232-inputEl']")
	public WebElement carrierInputBx;
	
	@FindBy(xpath="//table[@data-recordindex='0']") 
	public WebElement firstCarrier;
	
	@FindBy(xpath="//span[text()='Select']") 
	public WebElement selectBtn;
	
	@FindBy(xpath="//span[text()='Done']") 
	public WebElement doneBtn;
	
	@FindBy(xpath="//span[text()='Trailer Check-In']") 
	public WebElement trailerCheckInBtn;
	
	@FindBy(xpath="//input[@name='visitType']") 
	public WebElement visitTypeInputBx;
	
	@FindBy(xpath="//input[@name='trailerType']//following::div[1]") 
	public WebElement trailerTypeSearchBx;
	
	@FindBy(xpath="//table[@data-recordindex='0']") 
	public WebElement firstTrailerType;
	
	@FindBy(xpath="//span[text()='Location']//following::div[4]") 
	public WebElement locationSearchBx;
	
	@FindBy(xpath="//table[@data-recordindex='0']") 
	public WebElement firstDockDoorLocn;
	
	@FindBy(xpath="//span[text()='Add']") 
	public WebElement addBtn;
	
	@FindBy(xpath="(//span[text()='Shipment'])[2]//following::td[4]") 
	public WebElement shippingIDInputBx;
	
	@FindBy(xpath="(//input[@name='tcShipmentId'])[2]") 
	public WebElement shipmentIDInputBx;
	
	@FindBy(xpath="//span[text()='Find']") 
	public WebElement findBtn;
	
	@FindBy(xpath="(//table[@data-recordindex='0'])[2]") 
	public WebElement selectedShippingID;
	
	@FindBy(xpath="(//span[text()='Confirm'])[1]") 
	public WebElement confirmBtn;
	
	@FindBy(xpath="//div[@class='mps-memo-item ']") 	
	public  WebElement confirmationmsg;
	
	
	
	public void checkInTrailer() throws InterruptedException, IOException, AWTException{
		
		homepage.MenuItems_Distribution_Selection("Check-In");
		int TrailerNum= SeleniumTestHelper.generateRandomInt(100, 999);
		String Trailer_Number = "TLR" + TrailerNum;
		System.out.println("Trailer number generated is " +Trailer_Number);
		
		System.out.println("Trail Num: "+DistributionOrders.getTrailerNumber());
		
		if(DistributionOrders.getTrailerNumber()==null)
		{
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, trailerInputBx, 30);
			trailerInputBx.clear();
			trailerInputBx.sendKeys(Trailer_Number);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, carrierSearchBx, 30);
			carrierSearchBx.click();
			carrierInputBx.click();
			carrierInputBx.sendKeys("LTL");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, findBtn, 30);
			findBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstCarrier, 30);
			firstCarrier.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectBtn, 30);
			selectBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, doneBtn, 30);
			doneBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, trailerCheckInBtn, 30);
			trailerCheckInBtn.click();
			
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, visitTypeInputBx, 30);
			visitTypeInputBx.click();
			visitTypeInputBx.sendKeys(Keys.ARROW_DOWN);
			visitTypeInputBx.sendKeys(Keys.ARROW_DOWN);
			visitTypeInputBx.sendKeys(Keys.ARROW_DOWN);
			visitTypeInputBx.sendKeys(Keys.TAB);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, trailerTypeSearchBx, 30);
			trailerTypeSearchBx.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstTrailerType, 30);
			firstTrailerType.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectBtn, 30);
			selectBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, doneBtn, 30);
			doneBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationSearchBx, 30);
			locationSearchBx.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstDockDoorLocn, 30);
			firstDockDoorLocn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectBtn, 30);
			selectBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, doneBtn, 30);
			doneBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, addBtn, 30);
			addBtn.click();
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipmentIDInputBx, 30);
//			shipmentIDInputBx.clear();
//			shipmentIDInputBx.sendKeys(DistributionOrders.getShippingID());
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, findBtn, 30);
			findBtn.click();
			shipmentIDInputBx.sendKeys(DistributionOrders.getShippingID());
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, findBtn, 30);
			findBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectedShippingID, 30);
			selectedShippingID.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectBtn, 30);
			selectBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, doneBtn, 30);
			doneBtn.click();
			
		}
		else
		{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, trailerInputBx, 30);
		trailerInputBx.clear();
		trailerInputBx.sendKeys(DistributionOrders.getTrailerNumber());
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(trailerInputBx));
		trailerInputBx.sendKeys(Keys.ENTER);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, trailerCheckInBtn, 30);
		trailerCheckInBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationSearchBx, 30);
		locationSearchBx.click();
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(firstDockDoorLocn));
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstDockDoorLocn, 30);
		firstDockDoorLocn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectBtn, 30);
		selectBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, doneBtn, 30);
		doneBtn.click();
		}
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, confirmBtn, 30);
		confirmBtn.click();
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(confirmationmsg));
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, confirmationmsg, 50);
		Thread.sleep(2000);
		String message = confirmationmsg.getText();
		if (message.contains("successfully checked into facility") || message.contains("Trailer already checked in")) {
		//SeleniumTestHelper.assertEquals(message.contains("successfully checked into facility"), true);
		System.out.println("Trailer checked process is successfully.");
		} else {
		SeleniumTestHelper.fail("Error occured while trailer checkin");
		}
		homepage.userClosesOpenedwindow("Check-In");
	}
	
	
	

}
