package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.DateTime;
import globalFunc.Screenshots;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;

public class PixTransactionPage {
	WebDriver driver;

	public PixTransactionPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	HomePage homePage = new HomePage();

	@FindBy(xpath = "//select[@name='dataForm:lview:filterId:field0value1']")
	public WebElement Transaction_type;

	@FindBy(xpath = "//select[@name='dataForm:lview:filterId:field1value1']")
	public WebElement Transaction_code;

	@FindBy(xpath = "//span[@id='dataForm:lview:filterId:QFCap']")
	public WebElement quickFilter;

	@FindBy(xpath = "//ul[@id='filterId_ul']/li/a[text()='Saved filters']")
	public WebElement savedFilter;

	@FindBy(xpath = "//input[@value='Apply' and @type='button' and @id='dataForm:lview:filterId:savedapply']")
	public WebElement Apply_savedfilter;

	@FindBy(xpath = "//input[@id='as_bas3_in']")
	public WebElement dateFrom;

	@FindBy(xpath = "//input[@id='as_bas4_in']")
	public WebElement dateTo;

	@FindBy(xpath = "//select[@id='dataForm:filterDetailId:field0value1']")
	public WebElement Transaction_type_Apply;

	@FindBy(xpath = "//select[@name='dataForm:filterDetailId:field0value1']")
	public WebElement savedFilterTransactionType;

	@FindBy(xpath = "//select[@name='dataForm:filterDetailId:field1value1']")
	public WebElement savedFilterTransactionCode;

	@FindBy(xpath = "//input[@alt='Find Inbound LPN']")
	public WebElement savedFilteriLPN;

	@FindBy(xpath = "//input[@id='dataForm:applyFltrBtnPopupAjax']")
	public WebElement addsavedFilter;

	@FindBy(xpath = "//input[@id='rmButton_1View1_154178000']")
	public WebElement pixTransviewButton;

	@FindBy(xpath = "(//span[text()='Status:']/../following-sibling::td//span)[1]")
	public WebElement pixStatus;

	@FindBy(xpath = "//span[text()='Status']/ancestor::*[position()=5]/following-sibling::div//td")
	public WebElement pixTransactionFirstRow;

	public By pixTransactionFirstrowData = By
			.xpath("//span[text()='Status']/ancestor::*[position()=5]/following-sibling::div//td/span");

	@FindBy(xpath = "//input[@value='View']")
	public WebElement pixView;

	@FindBy(xpath = "//a[@id='backButton']")
	public WebElement backBtn;

	@FindBy(xpath = "//*[@id=\"dataForm:lview:filterId:filterIdapply\"]") ///
	public WebElement apply_Btn;

	@FindBy(xpath = "(//table[@id='filterId_quckFltrTable']//select)[1]")
	public static WebElement TransactionTypeDdl;

	@FindBy(xpath = "//input[@class='btn  groupBtn']")
	public static WebElement applyBtn;

	@FindBy(xpath = "//span[@id='dataForm:detail_Value_1']")
	public static WebElement tr1;

	@FindBy(xpath = "//span[@id='dataForm:detail_Value_3']")
	public static WebElement tr2;

	@FindBy(xpath = "//input[@id='dataForm:lview:dataTable:pager:dataTable_rfsh_but']")
	public WebElement refreshIcon;

	@FindBy(xpath = "//input[@id='checkAll_c0_dataForm:lview:dataTable']")
	public WebElement firstCheckBox;

	@FindBy(xpath = "//span[@id='dataForm:detail_Value_5']")
	public WebElement statusUnprocessed;

	@FindBy(xpath = "//input[@id='dataForm:lview:dataTable:pager:dataTable_rfsh_but']")
	public WebElement refreshBtn;
	
	//##############################
	@FindBy(xpath="//input[@src ='/lps/resources/themes/icons/mablue/arrow_collapse.gif']")
	public WebElement ExpandArrow;
	
	@FindBy(xpath="//*[@id=\"as_bas1_in\"]")
	public WebElement ExpandCreatedDateFrom;
    
	@FindBy(xpath="//*[@id=\"as_bas2_in\"]")
	public WebElement ExpandCreatedDateTo; 
	
	@FindBy(xpath="//*[@id=\"dataForm:lview:filterId:itemLookUpId\"]")
	public WebElement ExpandItem;
	
	@FindBy(xpath="//*[@id=\"dataForm:lview:filterId:filterIdapply\"]")
	public WebElement ExpandApplyBtn;
	
	@FindBy(xpath="//*[@id=\"rmButton_1View1_154178000\"]")
	public WebElement ViewBtn;
	
	@FindBy(id="dataForm:detail_Value_40")
	public WebElement Ordernumber;
	
	@FindBy(xpath="//*[@id=\"dataForm:detail_Value_42\"]")
	public WebElement Wavenumber;
	
	@FindBy(xpath="//*[@id=\"dataForm:detail_Value_1\"]")
	public WebElement TransactionType; 

	public void checkForPixTransaction(String pixTranNumber)throws Exception {
		Thread.sleep(2000);
		homePage.MenuItems_Distribution_Selection("PIX Transactions");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		
		if(pixTranNumber.contains("620")) {
		     ExpandArrow.click();
		        System.out.println("clicked");
		        Thread.sleep(2000);
		        DateTime.TimeDateFunc();
		        ExpandCreatedDateFrom.sendKeys(DateTime.strDate10);
		        ExpandCreatedDateTo.sendKeys(DateTime.strDate9);
		        Thread.sleep(2000);
		        ExpandItem.sendKeys(Steps.ItemDataMap.get(0).get("Item"));
		        ExpandApplyBtn.click();
		        Thread.sleep(3000);
		        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='dataForm:lview:dataTable_bodyDiv']/table/tbody/tr"));
		        int num=rows.size()-1;
		        System.out.println("number of rows in the table "+num);
		        
		        for(int i=0;i<num;i++)
		        {
		            String PixDescription = driver.findElement(By.xpath("//*[@id=\"dataForm:lview:dataTable:"+i+":fuid6\"]")).getText();
		            if(PixDescription.equalsIgnoreCase("Cancel reserve order"))
		            //if(PixDescription.equalsIgnoreCase("Decrease of allocated during de-allocation"))
		            {
		                driver.findElement(By.xpath("//*[@id=\"checkAll_c"+i+"_dataForm:lview:dataTable\"]")).click();
		                ViewBtn.click();
		                Thread.sleep(3000);
		                String ornum = Ordernumber.getText();
		                System.out.println("order number is " +ornum);
		                String waveno = Wavenumber.getText();
		                System.out.println("wave number is " +waveno);
		                if(Items.getDONumber().equalsIgnoreCase(ornum)&&(waveno.equalsIgnoreCase(Items.getWaveNumber()))){
		                    System.out.println("wave number and order number matches");
		                    String pixTransValue=null;
		                    pixTransValue= TransactionType.getText();
		                    System.out.println(pixTransValue);
		                    if(pixTransValue.equalsIgnoreCase("620 - Order transactions")){
		                    SeleniumTestHelper.assertEquals(pixTransValue, "620 - Order transactions");
		                    Steps.logger.info("620 Pix generated for the transaction");
		                    Reporter.addStepLog("620 Pix generated for the transaction ");
		                    SeleniumTestHelper.assertTrue(true);
		                    break;
		                    }
		                    }else {
		                System.out.println("wave number and order number does not match");
		                Reporter.addStepLog("PIX code is invalid");
		                Steps.logger.info("PIX code is invalid");
		                Steps.testRes = "Failed";
		                //Assert.assertTrue(false);
		             Thread.sleep(2000);
		            }
		                driver.findElement(By.xpath("//*[@id=\"backImage\"]")).click();
		            }
		            }
		}
		else {
		for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
			SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 120);
			quickFilter.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, savedFilter, 50);
			Screenshots.captureSnapshot(driver);
			savedFilter.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, Apply_savedfilter, 50);
			Screenshots.captureSnapshot(driver);
			Apply_savedfilter.click();
			Thread.sleep(5000);
			
				SeleniumTestHelper.selectFromDropDown(savedFilterTransactionType, pixTranNumber, "visibletext");
				Screenshots.captureSnapshot(driver);
			savedFilteriLPN.sendKeys(RFMenuPage.iLPNz.get(i));
			Screenshots.captureSnapshot(driver);
			addsavedFilter.click();
			Thread.sleep(3000);
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 50);
			//SeleniumTestHelper.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='" + Items.getItemsForReceivingASN(i) + "']")), 60);
			Thread.sleep(2000);
		//	String pixStatusValue = null;
		//	int count = 0;
		//	pixStatusValue = driver.findElement(By.xpath("//span[text()='" + RFMenuPage.iLPNz.get(i)+ "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']")).getAttribute("textContent");
			
			String pixTransValue=null;
			pixTransValue= driver.findElement(By.id("dataForm:lview:dataTable:0:v_trantype")).getText();
			if(pixTranNumber.contains("606")){
			SeleniumTestHelper.assertEquals(pixTransValue, "606");
			Steps.logger.info("606 Pix generated for iLPN "+RFMenuPage.iLPNz.get(i));
			Reporter.addStepLog("606 Pix generated for iLPN "+RFMenuPage.iLPNz.get(i));
		}
		else if(pixTranNumber.contains("603")){
				SeleniumTestHelper.assertEquals(pixTransValue, "603");
				Steps.logger.info("603 Pix generated for iLPN "+RFMenuPage.iLPNz.get(i));
				Reporter.addStepLog("603 Pix generated for iLPN "+RFMenuPage.iLPNz.get(i));
			}
			Thread.sleep(2000);
			/*boolean waitFortenMinutesForStatusChange = Boolean.parseBoolean(Config.getProperty("waitForTenMinutesForPixStatusChange"));
			if (waitFortenMinutesForStatusChange) {
				int maximunWait = 600000;
				int iteration = 20000;
				int totalItrWait = 0;
				while (!pixStatusValue.equals(status) && (count != 40) && (maximunWait > totalItrWait)) {
					refreshBtn.click();
					Thread.sleep(5000);
					SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 50);
					SeleniumTestHelper.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='" + Items.getItemsForReceivingASN(i) + "']")), 60);
					pixStatusValue = driver.findElement(By.xpath("//span[text()='" + Items.getItemILPN(Items.getItemsForReceivingASN(i))+ "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']")).getAttribute("textContent");
					Thread.sleep(iteration);
					count++;
					totalItrWait = iteration + totalItrWait;
				}*/
			//	SeleniumTestHelper.assertEquals(pixStatusValue, status);
				//System.out.println("PIX Transc status : " + pixStatusValue + " displayed for iLPN : "+ RFMenuPage.iLPNz.get(i));
		}
		}
		homePage.userClosesOpenedwindow("PIX Transactions");
	}

	public void checkForPixTransactions(String pixTranNumber, String pixTranCode, int noOfItems, String status)
			throws Exception {
		Thread.sleep(2000);
		homePage.MenuItems_Distribution_Selection("PIX Transactions");
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < noOfItems; i++) {
			SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 120);
			quickFilter.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, savedFilter, 50);
			savedFilter.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, Apply_savedfilter, 50);
			Apply_savedfilter.click();
			Thread.sleep(5000);
			if (pixTranNumber.contains("/")) {
				String[] pixTransNumberAsArray = pixTranNumber.split("/");
				String[] pixTransCodeAsArray = pixTranCode.split("/");
				SeleniumTestHelper.selectFromDropDown(savedFilterTransactionType, pixTransNumberAsArray[i],
						"visibletext");
				SeleniumTestHelper.selectFromDropDown(savedFilterTransactionCode, pixTransCodeAsArray[i],
						"visibletext");
			} else {
				SeleniumTestHelper.selectFromDropDown(savedFilterTransactionType, pixTranNumber, "visibletext");
				SeleniumTestHelper.selectFromDropDown(savedFilterTransactionCode, pixTranCode, "visibletext");
			}
			savedFilteriLPN.sendKeys(Items.getiLpn());
			// savedFilteriLPN.sendKeys(Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			addsavedFilter.click();
			Thread.sleep(3000);
			SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 50);

			SeleniumTestHelper.waitForElementToBeClickable(driver,
					driver.findElement(By.xpath("//span[text()='" + Items.getiLpn() + "']")), 60);
			// SeleniumTestHelper.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='"
			// + Items.getItemsForReceivingASN(i) + "']")), 60);
			Thread.sleep(1000);
			String pixStatusValue = null;
			int count = 0;

			pixStatusValue = driver.findElement(By.xpath(
					"//span[text()='" + Items.getiLpn() + "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']"))
					.getAttribute("textContent");
			// pixStatusValue = driver.findElement(By.xpath("//span[text()='" +
			// Items.getItemILPN(Items.getItemsForReceivingASN(i))+
			// "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']")).getAttribute("textContent");
			boolean waitFortenMinutesForStatusChange = Boolean
					.parseBoolean(Config.getProperty("waitForTenMinutesForPixStatusChange"));
			if (waitFortenMinutesForStatusChange) {
				int maximunWait = 600000;
				int iteration = 20000;
				int totalItrWait = 0;
				while (!pixStatusValue.equals(status) && (count != 40) && (maximunWait > totalItrWait)) {
					refreshBtn.click();
					Thread.sleep(5000);
					SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 50);
					SeleniumTestHelper.waitForElementToBeClickable(driver,
							driver.findElement(By.xpath("//a[text()='" + Items.getiLpn() + "']")), 60);
					// SeleniumTestHelper.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='"
					// + Items.getItemsForReceivingASN(i) + "']")), 60);
					pixStatusValue = driver
							.findElement(By.xpath("//span[text()='" + Items.getiLpn()
									+ "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']"))
							.getAttribute("textContent");
					// pixStatusValue = driver.findElement(By.xpath("//span[text()='" +
					// Items.getItemILPN(Items.getItemsForReceivingASN(i))+
					// "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']")).getAttribute("textContent");
					Thread.sleep(iteration);
					count++;
					totalItrWait = iteration + totalItrWait;
				}
				SeleniumTestHelper.assertEquals(pixStatusValue, status);
				System.out.println("PIX Transc status : " + pixStatusValue + " verified successfully for iLPN : "
						+ Items.getiLpn());
			} else {
				System.out
						.println("PIX Transc status : " + pixStatusValue + " displayed for iLPN : " + Items.getiLpn());
			}
		}
		homePage.userClosesOpenedwindow("PIX Transactions");
	}

	@SuppressWarnings("null")
	public void validatePixTransactionforLock_Unlock(String[] pixCodeArr) throws Exception {

		homePage.MenuItems_Distribution_Selection("PIX Transactions");
		SeleniumTestHelper.switchToInnerFrame(driver);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 120);
		quickFilter.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, savedFilter, 50);
		Screenshots.captureSnapshot(driver);
		savedFilter.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, Apply_savedfilter, 50);
		Screenshots.captureSnapshot(driver);
		Apply_savedfilter.click();
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		dateFrom.sendKeys("Today");
		Screenshots.captureSnapshot(driver);
		dateTo.sendKeys("Today");
		Screenshots.captureSnapshot(driver);
		savedFilteriLPN.sendKeys(RFMenuPage.iLPNz.get(0));
		Screenshots.captureSnapshot(driver);
		addsavedFilter.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 50);

		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		for (int i = 0; i < pixCodeArr.length; i++) {
			driver.findElement(By.xpath("//*[@id=\"checkAll_c" + i + "_dataForm:lview:dataTable\"]")).click();
			// *[@id="checkAll_c0_dataForm:lview:dataTable"]
			// *[@id="checkAll_c1_dataForm:lview:dataTable"]
		}
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		pixTransviewButton.click();
		Thread.sleep(3000);
		Screenshots.captureSnapshot(driver);
		ArrayList<String> transactionType = new ArrayList<String>();
		ArrayList<String> actionCode = new ArrayList<String>();

		for (int k = 0, j = 1; k < pixCodeArr.length; k++) {
			System.out.println("text1-" + tr1.getText());
			transactionType.add(tr1.getText());
			System.out.println("text2-" + tr2.getText());
			actionCode.add(tr2.getText());
			if (j < pixCodeArr.length) {
				Thread.sleep(3000);
				driver.findElement(By.id("dataForm:dataTable_nextDtlBtn")).click();
				Thread.sleep(3000);
				Screenshots.captureSnapshot(driver);
				j++;
			}
		}
		int l = 0;
		for (int i = 0; i < pixCodeArr.length; i++) {
			for (int j = 0; j < actionCode.size(); j++) {
				if (transactionType.get(j).contains(pixCodeArr[i])
						&& (actionCode.get(j).contains("Lock iLPN") || actionCode.get(j).contains("Unlock iLPN"))) {
					l++;
					System.out.println(transactionType.get(j) + "&" + pixCodeArr[i]);
					System.out.println(actionCode.get(j));
					System.out.println("passed");
					Steps.logger.info(
							"Transaction Type is:" + transactionType.get(j) + " & Action Code is:" + actionCode.get(j));
					Reporter.addStepLog("Transaction Type is:" + transactionType.get(j));
					Reporter.addStepLog("Action Code is:" + actionCode.get(j));
					Reporter.addStepLog("Pix Code validated");
					SeleniumTestHelper.assertTrue(true);
				} else {
					System.out.println("PIX code is invalid");
					// Steps.testRes="Failed";
					// Assert.assertTrue(false);
				}
			}
		}
		if (l != 2) {
			Reporter.addStepLog("PIX code is invalid");
			Steps.testRes = "Failed";
			Assert.assertTrue(false);
		}

		homePage.userClosesOpenedwindow("PIX Transactions");
	}

	public void validatePixTransactionforModifyiLPN(String[] pixCodeArr) throws Exception {

		homePage.MenuItems_Distribution_Selection("PIX Transactions");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 120);
		quickFilter.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, savedFilter, 50);
		Screenshots.captureSnapshot(driver);
		savedFilter.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, Apply_savedfilter, 50);
		Screenshots.captureSnapshot(driver);
		Apply_savedfilter.click();
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		dateFrom.sendKeys("Today");
		Screenshots.captureSnapshot(driver);
		dateTo.sendKeys("Today");
		Screenshots.captureSnapshot(driver);
		savedFilteriLPN.sendKeys(RFMenuPage.iLPNz.get(0));
		Screenshots.captureSnapshot(driver);
		addsavedFilter.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 50);

		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		for (int i = 0; i < pixCodeArr.length; i++) {
			driver.findElement(By.xpath("//*[@id=\"checkAll_c" + i + "_dataForm:lview:dataTable\"]")).click();
			// *[@id="checkAll_c0_dataForm:lview:dataTable"]
			// *[@id="checkAll_c1_dataForm:lview:dataTable"]
		}

		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		pixTransviewButton.click();
		Thread.sleep(3000);
		Screenshots.captureSnapshot(driver);
		ArrayList<String> transactionType = new ArrayList<String>();
		ArrayList<String> actionCode = new ArrayList<String>();

		for (int k = 0, j = 1; k < pixCodeArr.length; k++) {
			System.out.println("text1-" + tr1.getText());
			transactionType.add(tr1.getText());
			System.out.println("text2-" + tr2.getText());
			actionCode.add(tr2.getText());
			if (j < pixCodeArr.length) {
				Thread.sleep(2000);
				driver.findElement(By.id("dataForm:dataTable_nextDtlBtn")).click();
				Thread.sleep(2000);
				Screenshots.captureSnapshot(driver);
				j++;

			}
		}

		for (int i = 0; i < pixCodeArr.length; i++) {
			for (int j = 0; j < actionCode.size(); j++) {
				if (transactionType.get(j).contains(pixCodeArr[i])
						&& (actionCode.get(j).contains("Mod iLPN") || actionCode.get(j).contains("Modify iLPN"))) {
					System.out.println(transactionType.get(j) + "&" + pixCodeArr[i]);
					System.out.println(actionCode.get(j));
					System.out.println("passed");
					Steps.logger.info(
							"Transaction Type is:" + transactionType.get(j) + " & Action Code is:" + actionCode.get(j));
					Reporter.addStepLog("Transaction Type is:" + transactionType.get(j));
					Reporter.addStepLog("Action Code is:" + actionCode.get(j));
					SeleniumTestHelper.assertTrue(true);
				} else {
					Reporter.addStepLog("PIX code is invalid");
					System.out.println("PIX code is invalid");
					Steps.testRes = "Failed";
					Assert.assertTrue(false);
				}
			}
		}

		homePage.userClosesOpenedwindow("PIX Transactions");
	}

	public void validatePixTransactionforconsumingiLPN(String[] pixCodeArr) throws Exception {
		homePage.MenuItems_Distribution_Selection("PIX Transactions");
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);

		SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 120);
		quickFilter.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, savedFilter, 50);
		Screenshots.captureSnapshot(driver);
		savedFilter.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, Apply_savedfilter, 50);
		Screenshots.captureSnapshot(driver);
		Apply_savedfilter.click();
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		dateFrom.sendKeys("Today");
		Screenshots.captureSnapshot(driver);
		dateTo.sendKeys("Today");
		Screenshots.captureSnapshot(driver);
		savedFilteriLPN.sendKeys(RFMenuPage.iLPNz.get(0));
		Screenshots.captureSnapshot(driver);
		addsavedFilter.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 50);

		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);

		for (int i = 0; i < pixCodeArr.length; i++) {
			driver.findElement(By.xpath("//*[@id=\"checkAll_c" + i + "_dataForm:lview:dataTable\"]")).click();
			// *[@id="checkAll_c0_dataForm:lview:dataTable"]
			// *[@id="checkAll_c1_dataForm:lview:dataTable"]
		}
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		pixTransviewButton.click();
		Thread.sleep(3000);
		Screenshots.captureSnapshot(driver);
		ArrayList<String> transactionType = new ArrayList<String>();
		ArrayList<String> actionCode = new ArrayList<String>();

		for (int k = 0, j = 1; k < pixCodeArr.length; k++) {
			System.out.println("text1-" + tr1.getText());
			transactionType.add(tr1.getText());
			System.out.println("text2-" + tr2.getText());
			actionCode.add(tr2.getText());
			if (j < pixCodeArr.length) {
				Thread.sleep(2000);
				driver.findElement(By.id("dataForm:dataTable_nextDtlBtn")).click();
				Thread.sleep(2000);
				Screenshots.captureSnapshot(driver);
				j++;
			}
		}

		for (int i = 0; i < pixCodeArr.length; i++) {
			for (int j = 0; j < actionCode.size(); j++) {
				if (transactionType.get(j).contains(pixCodeArr[i]) && (actionCode.get(j).contains("Consume iLPN"))) {
					System.out.println(transactionType.get(j) + "&" + pixCodeArr[i]);
					System.out.println(actionCode.get(j));
					System.out.println("passed");
					Steps.logger.info(
							"Transaction Type is:" + transactionType.get(j) + " & Action Code is:" + actionCode.get(j));
					Reporter.addStepLog("Transaction Type is:" + transactionType.get(j));
					Reporter.addStepLog("Action Code is:" + actionCode.get(j));
					SeleniumTestHelper.assertTrue(true);
				} else {
					Reporter.addStepLog("PIX code is invalid");
					System.out.println("PIX code is invalid");
					Steps.testRes = "Failed";
					Assert.assertTrue(false);
				}
			}
		}

		homePage.userClosesOpenedwindow("PIX Transactions");
	}

}
