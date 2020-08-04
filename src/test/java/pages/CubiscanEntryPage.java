package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import entity.TestDataCreation;
import utils.Driver;
import utils.SeleniumTestHelper;
import utils.TestStubReader;

public class CubiscanEntryPage {
	
	
	
	
	WebDriver driver;
	
	public CubiscanEntryPage()
	{
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
		
	}
	
	 
	HomePage homepage=new HomePage();
	@FindBy(xpath="//input[@id='dataForm:skuEditCtrl']") public  WebElement Item;
	@FindBy(xpath="//select[contains(@id,'uom')]") public  WebElement UOM_ddl;
	@FindBy(xpath="//span[text()='Weight:']//following::input[1]") public  WebElement Weight;
	@FindBy(xpath="//span[text()='Volume:']//following::input[1]") public  WebElement Volume;
	@FindBy(xpath="//span[text()='Length:']//following::input[1]") public  WebElement Length;
	@FindBy(xpath="//span[text()='Width:']//following::input[1]") public  WebElement Width;
	@FindBy(xpath="//span[text()='Height:']//following::input[1]") public  WebElement Height;
	@FindBy(xpath="//input[@value='Save']") public  WebElement Save_btn;
	@FindBy(xpath="//input[@value='Verify Item']") public  WebElement veryItemBtn; 
	@FindBy(xpath="//input[@id='dataForm:b2']") public  WebElement itemBarcodeInput;
	@FindBy(xpath="//input[@id='dataForm:b21']") public  WebElement descriptonInput;
	
	
	
	public void firstReceiptProcess(String Itemname) throws InterruptedException, IOException
	{
		homepage.MenuItems_Distribution_Selection("Cubiscan Entry");
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, Item, 3);
		Item.sendKeys(Itemname);
		SeleniumTestHelper.selectFromDropDown(UOM_ddl, "Units", "visibletext");
		veryItemBtn.click();
		Weight.sendKeys("0.01");
		Width.sendKeys("0.01");
		Volume.sendKeys("0.01");
		Height.sendKeys("0.01");
		Length.sendKeys("0.01");
		SeleniumTestHelper.assertTrue(Save_btn.isDisplayed());
		Save_btn.sendKeys(Keys.ENTER+""+ Keys.ENTER);
		//driver.switchTo().alert().accept();
		homepage.userClosesOpenedwindow("Cubiscan Entry");
		System.out.println("Cubiscan entry is done");
		
	}
	public void firstReceiptProcessforTestDataCreation() throws InterruptedException, IOException
	{
		homepage.MenuItems_Distribution_Selection("Cubiscan Entry");
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, Item, 3);
		for(int j=0;j<=TestDataCreation.ItemNames.size();j++)
		{
			Item.clear();
			Item.sendKeys(TestDataCreation.ItemNames.get(j));
			SeleniumTestHelper.selectFromDropDown(UOM_ddl, "Units", "visibletext");
			veryItemBtn.click();
			Weight.sendKeys("0.01");
			Width.sendKeys("0.01");
			Volume.sendKeys("0.01");
			Height.sendKeys("0.01");
			Length.sendKeys("0.01");
			SeleniumTestHelper.assertTrue(Save_btn.isDisplayed());
			Save_btn.sendKeys(Keys.ENTER+""+ Keys.ENTER);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			
		}
		homepage.userClosesOpenedwindow("Cubiscan Entry");
		System.out.println("Cubiscan entry is done");
		
		
	}
	
	public void firstReceiptProcessForDatcreation(String Itemname,String Sheetname) throws InterruptedException, IOException
	{
		
		
		String area = null;
		String zone = null;
		String aisle = null;
		String bay = null;
		String level = null;
		String position = null;
		String maxQty = null;
		String length = null;
		String width = null;
		String height = null;
		String pickassignmentzone=null;
		
		TestStubReader testStubReader=new TestStubReader();
		if(true){
			String myLocation=testStubReader.getDataBasedOnColumnHeader("CreateLocation", "HUMAN READBLE LOCATION").get(0);
			maxQty=testStubReader.setSheetAndGetData("CreateLocation", myLocation, 16);
			length=testStubReader.setSheetAndGetData("CreateLocation", myLocation, 14);
			width=testStubReader.setSheetAndGetData("CreateLocation", myLocation, 13);
			height=testStubReader.setSheetAndGetData("CreateLocation", myLocation, 12);
		}
		
		homepage.MenuItems_Distribution_Selection("Cubiscan Entry");
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, Item, 3);
		Item.sendKeys(Itemname);
		SeleniumTestHelper.selectFromDropDown(UOM_ddl, "Units", "visibletext");
		veryItemBtn.click();
		Weight.sendKeys("0.01");
		Width.sendKeys("0.01");
		
		Height.sendKeys("0.01");
		Length.sendKeys("0.01");
		Volume.sendKeys("0.01");
		SeleniumTestHelper.assertTrue(Save_btn.isDisplayed());
		Save_btn.sendKeys(Keys.ENTER+""+ Keys.ENTER);
		driver.switchTo().alert().accept();
		homepage.userClosesOpenedwindow("Cubiscan Entry");
		System.out.println("Cubiscan entry is done");
		
	}

	
}
