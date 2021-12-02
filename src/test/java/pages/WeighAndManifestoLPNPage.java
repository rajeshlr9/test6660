package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StepDefinition.Steps;
import entity.DistributionOrders;
import utils.Driver;
import utils.SeleniumTestHelper;

public class WeighAndManifestoLPNPage {
	
	WebDriver driver;
	
	HomePage homepage = new HomePage();
	OlpnsPage olpnsPage = new OlpnsPage();
	
	public WeighAndManifestoLPNPage() {
		//this.driver = Driver.getInstance();
		//PageFactory.initElements(driver, this);
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}
	
	//HomePage homepage = new HomePage();
	//OlpnsPage olpnsPage = new OlpnsPage();
	
	@FindBy(xpath="//input[@id='dataForm:EnterLPNNumber']") public WebElement inputOLPNtxtbox;
	@FindBy(xpath="//input[@id='dataForm:nextButtonAddLPN']") public WebElement nextBtn;
	@FindBy(xpath="//span[@id='dataForm:estWeight']") public WebElement EstimatedWeight;
	@FindBy(xpath="//span[contains(text(),'Actual Weight')]/following::input[1]") public WebElement ActualWeightInput;
	//@FindBy(xpath="//select[@id='dataForm:shipviaList']/option[@selected='selected']") public WebElement ShipVia;
	
	@FindBy(xpath="//input[@value='Manifest >']") public WebElement manifestBtn;
	@FindBy(xpath="//span[@id='dataForm:order']") public WebElement distOrderId;
	@FindBy(xpath="//span[@id='dataForm:oLPNStatus']") public WebElement oLPNStatus;
	@FindBy(xpath="//span[text()='FedEx Ground�']") public WebElement ShipViaaftermanifest;
	@FindBy(xpath="//li[contains(text(),'LPN weight entered exceeds tolerance percentage')]") public WebElement weightEnteredExceedErrormsg;
	@FindBy(xpath="(//div[contains(text(),'Messages (')]//following::div[@class='pop_close'])[1]") public WebElement closeMsgBtn;
	@FindBy(xpath="//li[contains(text(),'Could not load Ship Via: Ship Via cannot be empty')]") public WebElement shipViaEmptyErrormsg;
	@FindBy(xpath="//span[@id='dataForm:oLPNStatus' and text()='Manifested']") public WebElement manifestedStatus;
	//@FindBy(xpath="//select[@name='dataForm:shipviaList']") public WebElement ShipVia;
	@FindBy(xpath="//select[@id='dataForm:shipviaList']/option[@selected='selected']") public WebElement ShipVia;
	@FindBy(xpath="//input[@value='Weigh >']") public WebElement weighBtn;
	@FindBy(xpath="//select[@id='dataForm:containerTypeList']") public WebElement oLPNType;
	@FindBy(xpath="//input[@id='dataForm:exitButton']") public WebElement exitBtn;
	@FindBy(xpath = "//a[@id='backButton']//img")
	public WebElement backBtn;
	
	public void weighandManifestoLPN(String olpnStatus) throws InterruptedException, IOException{
		
		for(int i= 0;i< DistributionOrders.oLPNList.size();i++)
		{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputOLPNtxtbox, 50);
		inputOLPNtxtbox.clear();
		inputOLPNtxtbox.sendKeys(DistributionOrders.getoLPNList(i));
		SeleniumTestHelper.assertEquals(inputOLPNtxtbox.isDisplayed(), true);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, nextBtn, 50);
		nextBtn.click();
		String actWeight=EstimatedWeight.getText();
		ActualWeightInput.clear();
		ActualWeightInput.sendKeys(actWeight);
		SeleniumTestHelper.assertEquals(ActualWeightInput.isDisplayed(), true);
		String actualShipvia=ShipVia.getText();
		SeleniumTestHelper.assertNotEquals(actualShipvia, "(select one)","Ship Via Populated");
		//ShipVia.sendKeys("UPS� Ground - E325");
		SeleniumTestHelper.assertEquals(distOrderId.getText(), DistributionOrders.getDOnumber());  
		SeleniumTestHelper.waitForElementToBeClickable(driver, manifestBtn, 50);
		Thread.sleep(2000);
		manifestBtn.click();
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver,oLPNStatus , 50);
		Thread.sleep(2000);
		SeleniumTestHelper.assertEquals(manifestedStatus.getText(), olpnStatus); 
		SeleniumTestHelper.assertEquals(manifestedStatus.isDisplayed(), true); 
		
		}
	}
	
	public void weighandManifestValidateweight() throws Exception{
		
		//for(int i=0 ;i < DistributionOrders.oLPNwithActive.size();i++)
		for(int i=0 ;i < DistributionOrders.oLPNList.size();i++)

		{
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputOLPNtxtbox, 50);
			inputOLPNtxtbox.clear();
			inputOLPNtxtbox.sendKeys(DistributionOrders.getoLPNwithActive(i));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, nextBtn, 50);
			nextBtn.click();
			Thread.sleep(2000);
			String actWeight = EstimatedWeight.getText();
			double result = Double.parseDouble(actWeight);
			double maxWeight=result+5;
			System.out.println(result);
			System.out.println("maxWeight"+maxWeight);
			ActualWeightInput.sendKeys(String.valueOf(maxWeight));
			manifestBtn.click();
			if(SeleniumTestHelper.isElementDisplayed(weightEnteredExceedErrormsg)){
				
				SeleniumTestHelper.assertEquals(weightEnteredExceedErrormsg.isDisplayed(), true);
				closeMsgBtn.click();
			}
//			if(ActualWeightInput.isDisplayed())
//			ActualWeightInput.clear();
//			if(ActualWeightInput.isDisplayed())
//			ActualWeightInput.sendKeys(actWeight);
//			manifestBtn.click();
//			if(SeleniumTestHelper.isElementDisplayed(shipViaEmptyErrormsg))
//			{
//				closeMsgBtn.click();
	//		}
			
		}
		for(int i=0 ;i < DistributionOrders.oLPNwithCase.size();i++)
		{
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputOLPNtxtbox, 50);
			inputOLPNtxtbox.clear();
			inputOLPNtxtbox.sendKeys(DistributionOrders.getoLPNwithCase(i));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, nextBtn, 50);
			nextBtn.click();
			Thread.sleep(2000);
			String actWeight = EstimatedWeight.getText();
			double result = Double.parseDouble(actWeight);
			double maxWeight=result+5;
			System.out.println(result);
			System.out.println("maxWeight"+maxWeight);
			ActualWeightInput.sendKeys(String.valueOf(maxWeight));
			manifestBtn.click();
			if(SeleniumTestHelper.isElementDisplayed(weightEnteredExceedErrormsg)){
				
				SeleniumTestHelper.assertEquals(weightEnteredExceedErrormsg.isDisplayed(), true);
				closeMsgBtn.click();
			}
			ActualWeightInput.clear();
			ActualWeightInput.sendKeys(actWeight);
			manifestBtn.click();
			if(SeleniumTestHelper.isElementDisplayed(shipViaEmptyErrormsg))
			{
				closeMsgBtn.click();
			}
	
		}
		homepage.user_closes_openedwindow("Weigh and Manifest oLPN - Weigh and...");
		}
	
	public void weighandManifestOnlyOneoLPN(String olpnStatus) throws InterruptedException, IOException{
		
		for(int i= 0;i< DistributionOrders.oLPNList.size()-1;i++)
		{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputOLPNtxtbox, 50);
		inputOLPNtxtbox.clear();
		inputOLPNtxtbox.sendKeys(DistributionOrders.getoLPNList(i));
		SeleniumTestHelper.assertEquals(inputOLPNtxtbox.isDisplayed(), true);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, nextBtn, 50);
		nextBtn.click();
		String actWeight=EstimatedWeight.getText();
		ActualWeightInput.clear();
		ActualWeightInput.sendKeys(actWeight);
		SeleniumTestHelper.assertEquals(ActualWeightInput.isDisplayed(), true);
		String actualShipvia=ShipVia.getText();
		SeleniumTestHelper.assertNotEquals(actualShipvia, "(select one)","Ship Via Populated");
		SeleniumTestHelper.assertEquals(distOrderId.getText(), DistributionOrders.getDOnumber());  
		SeleniumTestHelper.waitForElementToBeClickable(driver, manifestBtn, 50);
		Thread.sleep(2000);
		manifestBtn.click();
		Thread.sleep(2000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver,oLPNStatus , 50);
		Thread.sleep(2000);
		SeleniumTestHelper.assertEquals(oLPNStatus.getText(), olpnStatus); 
		SeleniumTestHelper.assertEquals(manifestedStatus.isDisplayed(), true); 
		
		}
	}
	
	public void performWeighAndManifest() throws Exception {
		homepage.openWindows.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < DistributionOrders.oLPNList.size(); i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputOLPNtxtbox, 50);
			inputOLPNtxtbox.clear();
			inputOLPNtxtbox.sendKeys(DistributionOrders.oLPNList.get(i));
			SeleniumTestHelper.assertEquals(inputOLPNtxtbox.isDisplayed(), true);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, nextBtn, 50);
			nextBtn.click();
			Thread.sleep(2000);
			Select oLPNTypeSelector = new Select(oLPNType);
			oLPNTypeSelector.selectByVisibleText("QSC Pallet");
			Thread.sleep(1000);

			String actWeight = EstimatedWeight.getText();
			double result = Double.parseDouble(actWeight);
			double maxWeight = result + 5;
			System.out.println(result);
			System.out.println("maxWeight" + maxWeight);
			ActualWeightInput.sendKeys(String.valueOf(maxWeight));
			Thread.sleep(2000);
			weighBtn.click();
			Thread.sleep(2000);
			Steps.logger.info("Clicked on weigh button");

			if (SeleniumTestHelper.isElementDisplayed(weightEnteredExceedErrormsg)) {

				SeleniumTestHelper.assertEquals(weightEnteredExceedErrormsg.isDisplayed(), true);
				closeMsgBtn.click();
			}
			ActualWeightInput.clear();
			ActualWeightInput.sendKeys(actWeight);
			weighBtn.click();
			System.out.println("Clicked on weigh button");
			Thread.sleep(2000);
			if (SeleniumTestHelper.isElementDisplayed(shipViaEmptyErrormsg)) {
				closeMsgBtn.click();
			}
			Thread.sleep(2000);
			if (SeleniumTestHelper.isElementDisplayed(backBtn)) {
				backBtn.click();
			}
		}
		exitBtn.click();
		homepage.user_closes_openedwindow("Weigh and Manifest oLPN - Weigh and...");

	}

}

