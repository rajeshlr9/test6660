package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import entity.DistributionOrders;
import utils.Driver;
import utils.SeleniumTestHelper;

public class SerialNumbersPage {
	
	
	WebDriver driver;
	
	public SerialNumbersPage()
	{
		this.driver=Driver.getInstance();
	}
	
	List<String> serials=new ArrayList<String>();
	@FindBy(xpath="//input[contains(@id,'itemLookUpId')]")
	public WebElement itemLookupInput;
	@FindBy(xpath="//input[@value='Apply']")
	public WebElement applyBtn;
	
	HomePage homePage=new HomePage();
	
	



public void setSerialNumbers(int noOfitems) throws InterruptedException, IOException{
	homePage.MenuItems_Distribution_Selection("Serial Numbers");
	SeleniumTestHelper.switchToInnerFrame(driver);
	for(int i=1; i< noOfitems;i++ )
	{
	SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemLookupInput, 50);
	itemLookupInput.clear();
	itemLookupInput.sendKeys(DistributionOrders.getProductsForDistOrder(i));
	SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtn, 50);
	applyBtn.click();
	List<WebElement> serailNums=driver.findElements(By.xpath("//span[contains(@id,'srlNbr')]"));
	
	for( WebElement snum : serailNums)
	{
		serials.add(snum.getAttribute("textContent"));
		System.out.println(snum.getAttribute("textContent"));
	}
	DistributionOrders.setSerialNumbersforItem(DistributionOrders.getProductsForDistOrder(i),serials);	
	}
	homePage.userClosesOpenedwindow("Serial Numbers");
	
}


}
