package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.bson.codecs.CollectibleCodec;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StepDefinition.Steps;
import entity.DistributionOrders;
import entity.Items;
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
	@FindBy(xpath="//span[@id='dataForm:orderStatus']") public WebElement manifestedStatus;
	@FindBy(xpath="//select[@name='dataForm:shipviaList']") public WebElement ShipViaElement;
	@FindBy(xpath="//select[@id='dataForm:shipviaList']/option[@selected='selected']") public WebElement ShipVia;
	
	
	@FindBy(xpath="//input[@value='Weigh >']") public WebElement weighBtn;
	@FindBy(xpath="//select[@id='dataForm:containerTypeList']") public WebElement oLPNType;
	@FindBy(xpath="//input[@id='dataForm:exitButton']") public WebElement exitBtn;
	@FindBy(xpath = "//a[@id='backButton']//img")
	public WebElement backBtn;
	@FindBy(xpath="//input[@id='dataForm:nextButton' and @value='Scan Next oLPN >']") public WebElement scanNextoLPN;

	public void weighandManifestoLPN(String olpnStatus) throws Exception {
		Thread.sleep(10000);
		System.out.println("weigh and manifest");
		//homepage.openWindows.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
//		LinkedList<String> s = new LinkedList<String>();
//		for(int i=DistributionOrders.oLPNList.size()-1;i>=0;i--) {
//			s.add(DistributionOrders.oLPNList.get(i));
//			System.out.println(s);
//		}
//		//Collections.sort(s);
//		System.out.println(s);
		for (int i = 0; i < DistributionOrders.oLPNList.size(); i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputOLPNtxtbox, 50);
			inputOLPNtxtbox.clear();
			inputOLPNtxtbox.sendKeys(DistributionOrders.oLPNList.get(i));
			SeleniumTestHelper.assertEquals(inputOLPNtxtbox.isDisplayed(), true);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, nextBtn, 50);
			nextBtn.click();
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//table[@class='pophead']//div[@class='pop_close']")).isDisplayed()) {
				break;
			}
			//Thread.sleep(2000);
			SeleniumTestHelper.WaitForPageLoad();
			String actWeight = EstimatedWeight.getText();
			ActualWeightInput.clear();
			ActualWeightInput.sendKeys(actWeight);
			// SeleniumTestHelper.assertEquals(ActualWeightInput.isDisplayed(), true);
			// SeleniumTestHelper.assertNotEquals(actualShipvia, "(select one)","Ship Via
			// Populated");
//			Select shipViaSelector = new Select(ShipViaElement);
//			shipViaSelector.selectByVisibleText("FedEx Express 2 Day-E264 - E264");
			String actualShipvia = ShipVia.getText();
			SeleniumTestHelper.assertNotEquals(actualShipvia, "(select one)","Ship Via Populated");
			// SeleniumTestHelper.assertEquals(distOrderId.getText(), DistributionOrders.getDOnumber());
			
			if(Steps.scenarioData.get("Wave Type").equals("LTL")) {
				
				SeleniumTestHelper.waitForElementToBeClickable(driver, weighBtn, 50);
				//Thread.sleep(2000);
				SeleniumTestHelper.WaitForPageLoad();
				weighBtn.click();
			}else {
				SeleniumTestHelper.waitForElementToBeClickable(driver, manifestBtn, 50);
				//Thread.sleep(2000);
				SeleniumTestHelper.WaitForPageLoad();
				manifestBtn.click();
			}
			
//			SeleniumTestHelper.waitForElementToBeClickable(driver, manifestBtn, 50);
//			Thread.sleep(2000);
//			manifestBtn.click();
			
			//Thread.sleep(30000);
			SeleniumTestHelper.WaitForPageLoad();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver,scanNextoLPN, 120);

			SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNStatus, 50);
			//Thread.sleep(2000);
			SeleniumTestHelper.WaitForPageLoad();
			System.out.println(manifestedStatus.getText());
			System.out.println("Manifested status"+manifestedStatus.getText());
			SeleniumTestHelper.assertEquals(manifestedStatus.getText(), olpnStatus);
			SeleniumTestHelper.assertEquals(manifestedStatus.isDisplayed(), true);
			//FedEx Express Priority - Intl-E269 - E269
			//FedEx Express Priority - Intl-E269
		}
		exitBtn.click();
		//Thread.sleep(5000);
		SeleniumTestHelper.WaitForPageLoad();
		Steps.logger.info("Weigh and Manifest of oLPN done successfully");
		System.out.println("Weigh and Manifest of oLPN done successfully");
		homepage.user_closes_openedwindow("Weigh and Manifest oLPN - Weigh and...");
		
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
			if(driver.findElement(By.xpath("//table[@class='pophead']//div[@class='pop_close']")).isDisplayed()) {
				break;
			}
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
			Steps.logger.info("Clicked on weigh button");
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
		Steps.logger.info("Weigh and Manifest of oLPN done successfully");
		homepage.user_closes_openedwindow("Weigh and Manifest oLPN - Weigh and...");

	}

}

