package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import entity.Items;
import utils.Driver;
import utils.SeleniumTestHelper;

public class LeanTimeReplenishmentPage {
	
	WebDriver driver;

	
	
	public LeanTimeReplenishmentPage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	HomePage homepage = new HomePage();
	
	@FindBy(xpath="//span[text()='Case pick']/../..//input[@type='checkbox']")
	public WebElement caseLocReplenishCheckBx;
	
	@FindBy(xpath="//input[@value='View']") 
	public WebElement viewButton;
	
	@FindBy(xpath="//input[@id='areaCfromLocn']") 
	public WebElement fromAreaInputBx;
	
	@FindBy(xpath="//input[@id='zoneCfromLocn']") 
	public WebElement fromZoneInputBx;
	
	@FindBy(xpath="//input[@id='aisleCfromLocn']") 
	public WebElement fromAisleInputBx;
	
	@FindBy(xpath="//input[@id='bayCfromLocn']") 
	public WebElement fromBayInputBx;
	
	@FindBy(xpath="//input[@id='lvlCfromLocn']") 
	public WebElement fromLevelInputBx;
	
	@FindBy(xpath="//input[@id='posnCfromLocn']") 
	public WebElement fromPositionInputBx;
	
	@FindBy(xpath="//input[@id='areaCtoLocn']") 
	public WebElement toAreaInputBx;
	
	@FindBy(xpath="//input[@id='zoneCtoLocn']") 
	public WebElement toZoneInputBx;
	
	@FindBy(xpath="//input[@id='aisleCtoLocn']") 
	public WebElement toAisleInputBx;
	
	@FindBy(xpath="//input[@id='bayCtoLocn']") 
	public WebElement toBayInputBx;
	
	@FindBy(xpath="//input[@id='lvlCtoLocn']") 
	public WebElement toLevelInputBx;
	
	@FindBy(xpath="//input[@id='posnCtoLocn']") 
	public WebElement toPositionInputBx;
	
	@FindBy(xpath="//input[@value='Save']") 
	public WebElement saveBtn;
	
	@FindBy(xpath="//input[@value='Submit']") 
	public WebElement submitBtn;
	
	@FindBy(xpath="//span[text()='Active']/../..//input[@type='checkbox']") 
	public WebElement activeLocReplenishCheckBx;
	
	public void replenish(String replenishtype) throws InterruptedException{
		
		SeleniumTestHelper.switchToInnerFrame(driver);
		
		switch(replenishtype){
		case "Location":
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, caseLocReplenishCheckBx, 5);
			caseLocReplenishCheckBx.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewButton, 5);
			viewButton.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, fromAreaInputBx, 5);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, fromZoneInputBx, 5);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, fromAisleInputBx, 5);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, fromBayInputBx, 5);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, fromLevelInputBx, 5);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, fromPositionInputBx, 5);
			
			fromAreaInputBx.clear();
			fromZoneInputBx.clear();
			fromAisleInputBx.clear();
			fromBayInputBx.clear();
			fromLevelInputBx.clear();
			fromPositionInputBx.clear();
			if(Items.getALocation_one().equals(Items.getALocation_two())){
				fromAreaInputBx.sendKeys(Items.getALocation_one().substring(0));
				fromZoneInputBx.sendKeys(Items.getALocation_one().substring(1,3));
				fromAisleInputBx.sendKeys(Items.getALocation_one().substring(3,5));
				fromBayInputBx.sendKeys(Items.getALocation_one().substring(5,8));
				fromLevelInputBx.sendKeys(Items.getALocation_one().substring(8,9));
				fromPositionInputBx.sendKeys(Items.getALocation_one().substring(Items.getALocation_one().length()-2, Items.getALocation_one().length()));
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, toPositionInputBx, 5);
				toAreaInputBx.clear();
				toZoneInputBx.clear();
				toAisleInputBx.clear();
				toBayInputBx.clear();
				toLevelInputBx.clear();
				toPositionInputBx.clear();
				toAreaInputBx.sendKeys(Items.getALocation_one().substring(0));
				toZoneInputBx.sendKeys(Items.getALocation_one().substring(1,3));
				toAisleInputBx.sendKeys(Items.getALocation_one().substring(3,5));
				toBayInputBx.sendKeys(Items.getALocation_one().substring(5,8));
				toLevelInputBx.sendKeys(Items.getALocation_one().substring(8,9));
				toPositionInputBx.sendKeys(Items.getALocation_one().substring(Items.getALocation_one().length()-2, Items.getALocation_one().length()));
			}else{
				fromAreaInputBx.sendKeys(Items.getALocation_one().substring(0));
				fromZoneInputBx.sendKeys(Items.getALocation_one().substring(1,3));
				fromAisleInputBx.sendKeys(Items.getALocation_one().substring(3,5));
				fromBayInputBx.sendKeys(Items.getALocation_one().substring(5,8));
				fromLevelInputBx.sendKeys(Items.getALocation_one().substring(8,9));
				fromPositionInputBx.sendKeys(Items.getALocation_one().substring(Items.getALocation_one().length()-2, Items.getALocation_one().length()));
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, toPositionInputBx, 5);
				toAreaInputBx.clear();
				toZoneInputBx.clear();
				toAisleInputBx.clear();
				toBayInputBx.clear();
				toLevelInputBx.clear();
				toPositionInputBx.clear();
				System.out.println("to location: "+Items.getALocation_two());
				toAreaInputBx.sendKeys(Items.getALocation_two().substring(0));
				toZoneInputBx.sendKeys(Items.getALocation_two().substring(1,3));
				toAisleInputBx.sendKeys(Items.getALocation_two().substring(3,5));
				toBayInputBx.sendKeys(Items.getALocation_two().substring(5,8));
				toLevelInputBx.sendKeys(Items.getALocation_two().substring(8,9));
				toPositionInputBx.sendKeys(Items.getALocation_two().substring(Items.getALocation_two().length()-2, Items.getALocation_two() .length()));
			}
			SeleniumTestHelper.assertEquals(saveBtn.isDisplayed(), true);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, saveBtn, 5);
			saveBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, caseLocReplenishCheckBx, 5);
			caseLocReplenishCheckBx.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, submitBtn, 5);
			submitBtn.click();
			Thread.sleep(2000);
			WebElement transsuccessful = driver.findElement(By.xpath("//li[text()='Transaction successful.']"));
			SeleniumTestHelper.assertEquals(transsuccessful.isDisplayed(), true);
			break;
			
		}
	}

}
