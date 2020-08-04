package pages;

import java.util.ArrayList;
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

public class PickLocationPage {

	WebDriver driver;
	
	public PickLocationPage() {

		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);

	}
	HomePage homePage = new HomePage();
	TestStubReader testStubReader = new TestStubReader();

	
	
	@FindBy(xpath="//span[text()='Item']")
	public WebElement itemTableheader;
	
	@FindBy(xpath="//input[@id='checkAll_c0_dataForm:listView:dataTable']")
	public WebElement firstCheckBox;
	
	@FindBy(xpath="//span[@id='dataForm:listView:dataTable:cc2']")
	public WebElement expectedText;
	
	@FindBy(xpath="//input[@type='button' and contains(@id,'AssignItemToLocation')]")
	public WebElement assignItemToLocation;
	
	@FindBy(xpath="//input[@id='dataForm:skuEditCtrl']")
	public WebElement itemBox;
	
	@FindBy(xpath="//span[@id='dataForm:gitm11']")
	public WebElement text;
	
	@FindBy(xpath="//input[@type='text' and @id='dataForm:c44_1']")
	public WebElement locationMinimumUnits;
	
	@FindBy(xpath="//input[@type='text' and @id='dataForm:c43_1']")
	public WebElement locationMaximumUnits;
	
	@FindBy(xpath="//input[@type='text' and @id='dataForm:c45_1']")
	public WebElement releaseMinimumUnits;
	
	@FindBy(xpath="//span[text()='Location:']//following::span[@class='captionData'][1]") 
	public WebElement pickLocation;
	
	@FindBy(xpath="//input[@type='button' and @id='rmButton_1Save1_8402']")
	public WebElement pickLocationsSaveButton;
	
	@FindBy(xpath="//span[contains(text(),'Max dynamic Active locations exceeded for Item')]") 
	public WebElement maxdynamicActiveLocnsExceeded;
	
	@FindBy(xpath="//input[@value='Yes']") 
	public WebElement yesBtn;
	
	@FindBy(xpath="//input[contains(@id,'itemLookUpId')]") 
	public WebElement itemLookUp;
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:filterIdapply' and @type='button']")
	public WebElement apply;
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:field20value1']")
    public WebElement DisplayLocationSearchBox;
	@FindBy(xpath="//td[@title='Click to sort'][4]") public WebElement itemColumn;
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:locationLookUpId']")
    public WebElement DisplayLocation;
	
	@FindBy(xpath="//input[contains(@id,'field20value1')]") 
	public WebElement locBarcodeInputBx;
			
	@FindBy(xpath="//span[contains(text(),'assignment Exceeds Location Max')]") 
	public WebElement maxdynamicItemsExceeded;
	
	@FindBy(xpath="//input[@id='rmButton_1LockUnlock1_8315']") 
	public WebElement lckUnlckBtnPicLtn;
	
	@FindBy(xpath="//select[@id='dataForm:pikng121']/option")
	public WebElement invLckPicLtn;
		
	@FindBy(xpath="//input[@id='rmButton_1Save1_8407']") 
	public WebElement ptyLcksave;
	
	@FindBy(xpath="//a[@id='backButton']") 
	public WebElement backBtn;
	
	@FindBy(xpath="//li[contains(text(),'Invalid Item.')]") 
	public WebElement invalidItemerror;
	
	@FindBy(xpath="(//div[contains(text(),'Messages ')]//following::div[@class='pop_close'])[1]") 
	public WebElement invalidItemerrorPopupClose;
	
	@FindBy(xpath="//input[@id='rmButton_1View1_8319']") public WebElement viewBtn;
	@FindBy(xpath="//input[@id='dataForm:c25r1']") public WebElement maxWeight;
	@FindBy(xpath="//select[@id='dataForm:c21e']") public WebElement pickDetZoneDdl;
	@FindBy(xpath="//select[@id='dataForm:c23r']") public WebElement slotTypeDdl;
	@FindBy(xpath="//input[@id='rmButton_1Save1_8421']") public WebElement saveBtn;
	@FindBy(xpath="//input[@id='rmButton_1Delete1_8317']") public WebElement deleteBtn;
	
	public void select_random_empty_location(String locationType) {

		driver.switchTo().frame(0);
		String emptyLocation = null;
		if(locationType.startsWith("A")){
		      DisplayLocationSearchBox.sendKeys("A*");
		}else if(locationType.startsWith("C")){
			  DisplayLocationSearchBox.sendKeys("A-R*");
		}
		apply.click();
		//nextBtn.click();
		itemColumn.click();
		itemColumn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> emptyLocations = driver
				.findElements(By
						.xpath("//a[.='']/parent::td/preceding-sibling::td[3]/span[1]"));

		System.out.println("Total empty locations found: " + emptyLocations.size());
		emptyLocation = emptyLocations.get(0).getText();
		if(locationType.startsWith("A")){
			entity.Items.setALocation_one(emptyLocation);
		}else if(locationType.startsWith("C")){
			  entity.Items.setCLocation_one(emptyLocation);
		}
		System.out.println("Selected empty location: "+ emptyLocation);
	}
	
	public void itemAssigntoALocation(String pickLocation) throws InterruptedException{
		
		//int count=0;
		//List<String> locbarcode=new ArrayList<String>();
		SeleniumTestHelper.switchToInnerFrame(driver);
		
		
		//for (int i = 0; i < count; i++) {
			
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, DisplayLocation, 20);
			DisplayLocation.clear();
			DisplayLocation.sendKeys(pickLocation);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, apply, 20);
			apply.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstCheckBox, 20);
			firstCheckBox.click();
			
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, assignItemToLocation, 20);
			assignItemToLocation.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemBox, 50);
			itemBox.sendKeys(Items.getItemName());
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, text, 50);
			String textstr = text.getText();
			String text1 = "Item";
			SeleniumTestHelper.assertEquals(textstr, text1);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationMinimumUnits, 50);
			String MinimumUnits = "" + SeleniumTestHelper.generateRandomInt(1, 3);
			locationMinimumUnits.sendKeys(MinimumUnits);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationMaximumUnits, 50);
			String MaximumUnits = "" + SeleniumTestHelper.generateRandomInt(500, 1000);
			locationMaximumUnits.sendKeys(MaximumUnits);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, releaseMinimumUnits, 50);
			releaseMinimumUnits.sendKeys(MinimumUnits);
			SeleniumTestHelper.assertEquals(releaseMinimumUnits.isDisplayed(), true);
			//String PickLocn = pickLocation.getText();
			System.out.println("Item is assigned to the location" + pickLocation);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, pickLocationsSaveButton, 50);
			pickLocationsSaveButton.click();
			Thread.sleep(1000);
			if (SeleniumTestHelper.isElementDisplayed(maxdynamicActiveLocnsExceeded) || SeleniumTestHelper.isElementDisplayed(maxdynamicItemsExceeded) ) {
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, yesBtn, 50);
				SeleniumTestHelper.assertEquals(yesBtn.isDisplayed(), true);
				yesBtn.click();
			}
			//Thread.sleep(2000);
		//}
	}
	
	
	public void itemAssigntoLocation(String sheetName, String rowHeaderTcname, int columnnumber) throws InterruptedException{
		
		String fromLocation = null;
		String toLocation=null;
		int count=0;
		List<String> locbarcode=new ArrayList<String>();
		SeleniumTestHelper.switchToInnerFrame(driver);
		fromLocation = testStubReader.setSheetAndGetData(sheetName, rowHeaderTcname, columnnumber);
		toLocation = testStubReader.setSheetAndGetData(sheetName, rowHeaderTcname, columnnumber+1);
		if(fromLocation.equals(toLocation)){
			count=1;
			locbarcode.add(fromLocation);
			Items.setALocation_one(fromLocation);
			Items.setALocation_two(fromLocation);
		}else{
			count=2;
			locbarcode.add(fromLocation);
			Items.setALocation_one(fromLocation);
			locbarcode.add(toLocation);
			Items.setALocation_two(toLocation);
		}
		for (int i = 0; i < count; i++) {
			
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, locBarcodeInputBx, 20);
			locBarcodeInputBx.clear();
			locBarcodeInputBx.sendKeys(locbarcode.get(i));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, apply, 20);
			apply.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstCheckBox, 20);
			firstCheckBox.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, expectedText, 20);
			String actual_Text = expectedText.getText();
			String expected_Text = "Location Class";
			SeleniumTestHelper.assertEquals(actual_Text, expected_Text);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, assignItemToLocation, 20);
			assignItemToLocation.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, itemBox, 50);
			itemBox.sendKeys(Items.getItemName());
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, text, 50);
			String textstr = text.getText();
			String text1 = "Item";
			SeleniumTestHelper.assertEquals(textstr, text1);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationMinimumUnits, 50);
			String MinimumUnits = "" + SeleniumTestHelper.generateRandomInt(1, 3);
			locationMinimumUnits.sendKeys(MinimumUnits);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, locationMaximumUnits, 50);
			String MaximumUnits = "" + SeleniumTestHelper.generateRandomInt(500, 1000);
			locationMaximumUnits.sendKeys(MaximumUnits);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, releaseMinimumUnits, 50);
			releaseMinimumUnits.sendKeys(MinimumUnits);
			SeleniumTestHelper.assertEquals(releaseMinimumUnits.isDisplayed(), true);
			String PickLocn = pickLocation.getText();
			System.out.println("Item is assigned to the location" + PickLocn);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, pickLocationsSaveButton, 50);
			pickLocationsSaveButton.click();
			Thread.sleep(1000);
			if (SeleniumTestHelper.isElementDisplayed(maxdynamicActiveLocnsExceeded) || SeleniumTestHelper.isElementDisplayed(maxdynamicItemsExceeded) ) {
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, yesBtn, 50);
				SeleniumTestHelper.assertEquals(yesBtn.isDisplayed(), true);
				yesBtn.click();
			}
			Thread.sleep(2000);
		}
	}
	
	public void selectLocation(String searchValue) throws InterruptedException {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstCheckBox, 30);
		firstCheckBox.click();
		lckUnlckBtnPicLtn.click();
		Thread.sleep(1000);
		}
 
	public void pickLocationLockCode(String PickLocationLockcode) throws InterruptedException {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, invLckPicLtn, 50);
		invLckPicLtn.click();
		driver.findElement(By.xpath("//select[@id='dataForm:pikng121']/option[text()='"+PickLocationLockcode+"']")).click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ptyLcksave, 50);
		SeleniumTestHelper.assertEquals(ptyLcksave.isDisplayed(), true);
		ptyLcksave.click();
	}

}
