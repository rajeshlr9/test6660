package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Steps;
import utils.SeleniumTestHelper;

public class OrderConsolidationLocationPage {
	
	WebDriver driver;
	
	public OrderConsolidationLocationPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Location:']")
	public WebElement Location;
	
	@FindBy(xpath = "//span[@id='dataForm:barCd_d']")
			public WebElement LocationCode;
			
			
	HomePage homePage = new HomePage();

	public String getLocation(String setLocation) throws Exception {
		//homePage.MenuItems_Distribution_Selection("RF Menu");
		homePage.MenuItems_Configuration_Selection("Order Consolidation Locations");
		Thread.sleep(5000);
		//SeleniumTestHelper.switchToInnerFrame(driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		//nt size = driver.findElements(By.tagName("iframe")).size();
		//System.out.println("iframe size: "+size);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Location, 50);
		System.out.println("text1");
		System.out.println(setLocation);
		Thread.sleep(3000);
		WebElement element =driver.findElement(By.xpath("//span[text()='"+setLocation+"']//parent::td//preceding-sibling::td//input[@type='checkbox']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(5000);
		element.click();
		System.out.println("text2");
		Thread.sleep(5000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, LocationCode, 50);
		System.out.println("text3");
		String LocCode = LocationCode.getText().trim();
		Thread.sleep(3000);
		System.out.println("LocCode: "+LocCode);
		homePage.userClosesOpenedwindow("Order Consolidation Locations");
		return LocCode;
		
	}
	
}
