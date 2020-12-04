package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import entity.Items;
import utils.Driver;
import utils.SeleniumTestHelper;
import utils.TestStubReader;

public class WavesPage {
	WebDriver driver;
	
	
	public WavesPage(){
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	HomePage homepage = new HomePage();
	@FindBy(xpath="//span[text()='Wave Number:']/../..//input[@type='text']")
	public WebElement waveNumberSearchTxt;
	
	@FindBy(xpath="(//input[@value='Apply' and @title = 'Apply'])[1]")
	public WebElement waveNumberApplySearchBtn;
	
	@FindBy(xpath="(//input[@value='Apply' and @title = 'Apply'])[1]")
	public WebElement searchedWaveNumberLbl;
	@FindBy(xpath="//span[text()='Plt pull task from resv/pack & hold']/../preceding-sibling::td[2]/span[1]")
		public WebElement selectRlocationfrmWave;
	
	public void searchForTheWaveNumberAndVerifyItsDisplayed(String waveNumber) throws Exception{
		homepage.MenuItems_Distribution_Selection("Waves");
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveNumberSearchTxt, 50);
		waveNumberSearchTxt.sendKeys(waveNumber);
		waveNumberApplySearchBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, driver.findElement(By.xpath("//span[text()='"+waveNumber+"']")), 50);
		SeleniumTestHelper.assertTrue(true, "Wave number : " + waveNumber + " displayed");
	}

	
	public void getLocation() throws InterruptedException, IOException {

		String sheetname = null;
		String rowname = null;
		int columnnumber = 0;

		List<WebElement> getLocation = driver.findElements(
				By.xpath("//span[text()='Plt pull task from resv/pack & hold']/../preceding-sibling::td[2]/span[1]"));

		String RLocation = getLocation.get(0).getText();
		Items.setRlocation_one(RLocation);
		System.out.println("Selected FIFO Location: " + RLocation);

		SeleniumTestHelper.assertTrue(true, "Wave number : " + RLocation + " displayed");
		TestStubReader stubReader = new TestStubReader();
		String currentSheetName = sheetname;
		System.out.println("SheetName Is : " + currentSheetName);
		stubReader.setReadingSheet(currentSheetName);
		String dataFromsheet = stubReader.setSheetAndGetData(sheetname, rowname, columnnumber);
		String FirstRLocation = stubReader.setSheetAndGetData(sheetname, rowname, columnnumber + 1);
		System.out.println("--------------------" + FirstRLocation);
		System.out.println(dataFromsheet);
		SeleniumTestHelper.assertEquals(getLocation, FirstRLocation, "Inventory picked from First Priority Location");
	}	

	
}
