package pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.Screenshots;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;

public class AsnsPage {
	public WebDriver driver;

	public AsnsPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);

	}

	HomePage homepage = new HomePage();

	@FindBy(xpath = "(//label[text()='Primary Fields']//following::input[@role='combobox' and @data-ref='inputEl'])[1]")
	public WebElement primaryField;
	@FindBy(xpath = "//input[@name='asnId']")
	public WebElement asnIdInput;
	//@FindBy(xpath = "//A/SPAN[@role='presentation']/SPAN[@role='presentation' and normalize-space()='Apply']/SPAN[2]")
	//@FindBy(xpath = "(//span[text()='Apply'])[2]")
	//@FindBy(xpath = "//*[text()='Apply'][1]")
	@FindBy(xpath = "//span[@class= 'x-btn-inner x-btn-inner-default-small' and text()='Apply' ]")
	public WebElement applyBtn;
	@FindBy(xpath = "//td[@data-columnid='status']/div")
	public WebElement asnStatus;
	@FindBy(xpath = "//span[text()='View']")
	public WebElement viewBtn;
	@FindBy(xpath = "//tr[@class='  x-grid-row']//td//div[@class='x-grid-row-checker']")
	public WebElement asnChkbox;
	@FindBy(xpath = "//img[@class='x-tool-img x-tool-collapse-left']")
	public WebElement collapseLeft;
	@FindBy(xpath = "//a[@data-qtip='Refresh']")
	public WebElement refreshBtn;
	@FindBy(xpath = "//div[@class='x-grid-cell-inner ']/img")
	public WebElement ASNmessage;
	

	@FindBy(xpath = "//a[@name='ASNDetailASNLinesTab']")
	public WebElement linesTab;

	@FindBy(xpath = "//span[@id='dataForm:Item_popup_barcode_outText']")
	public WebElement itemBarcode;

	@FindBy(xpath = "//div[@class='pop_close' and @id='dataForm:ASNDetails_ITEM_basicDialogTemplate_cCId']")
	public WebElement closeBtn;

	@FindBy(xpath = "//span[contains(@id,'shippedQtyuom')]")
	public WebElement shippedQtyLbl;

	@FindBy(xpath = "//span[text()='View']")
	public WebElement viewASNBtn;

	@FindBy(xpath = "//tr[@class='  x-grid-row']//td//div[@class='x-grid-row-checker']")
	public WebElement searchedASNChkbox;

	@FindBy(xpath = "//a[@id='ASNDetailLPNsTab_lnk']")
	public WebElement lpnsTab;

	@FindBy(xpath = "//tr[@class='advtbl_row -dg_tr'][1]")
	public WebElement iLPNSFirstRecord;

	@FindBy(xpath = "//span[text()='LPN facility status:']/../..//span[contains(@id,'LPNFacilityStatus_outputText')]")
	public WebElement iLPNSFacilityStatus;

	@FindBy(xpath = "//a[@id='backButton']")
	public WebElement asnBackBtn;

	@FindBy(xpath = "//span[text()='More']")
	public WebElement More;

	@FindBy(xpath = "//span[text()='Verify ASN']")
	public WebElement verifyASN;

	@FindBy(xpath = "//input[@value='Verify ASN']")
	public WebElement verifyASNBtn;

	@FindBy(xpath = "//span[@id='dataForm:ASN_Detail_Summary_TotalShippedQty']")
	public WebElement totalShippedQty;

	@FindBy(xpath = "//span[@id='dataForm:ASN_Detail_TotalReceived_totalReceivedQtyString']")
	public WebElement totalReceivedQty;

	@FindBy(xpath = "//td[@data-columnid='status']")
	public WebElement asnStatusLbl;

	@FindBy(xpath = "//table[contains(@id,'LPNDetailListTable1_body')]")
	public WebElement contentsLPNFirstRecord;

	@FindBy(xpath = "//input[@id='dataForm:ASNDetail_commandbutton_EditASN']")
	public WebElement editHeaderBtn;

	@FindBy(xpath = "//input[@id='dataForm:EditASN_SealNbr_Addbutton']")
	public WebElement editHeaderAddSealBtn;

	@FindBy(xpath = "//input[@id='dataForm:editASNSealNumberTable:newRow_1:SeqNbr']")
	public WebElement editHeaderAddSealSequenceNumTxt;

	@FindBy(xpath = "//input[@id='dataForm:editASNSealNumberTable:newRow_1:SealNbr']")
	public WebElement editHeaderAddSealNumTxt;

	@FindBy(xpath = "//input[@id='dataForm:editASNSealNumberTable:newRow_1:SealIntact']")
	public WebElement editHeaderAddSealIntactChkbox;

	@FindBy(xpath = "//input[@id='dataForm:save']")
	public WebElement editHeaderAddSealSaveBtn;

	@FindBy(xpath = "//input[@id='dataForm:editASNSealNumberTable:newRow_2:SeqNbr']")
	public WebElement editHeaderAddSealSequenceNumTxtSecond;
	
	@FindBy(xpath = "//input[@id='dataForm:ASNLPNListView_id:ASNLPNList_commandbutton_SerialNumbers']")
	public WebElement serailNumberButton;
	
			
	public void getASNandPONumber(String asnId) throws Exception {
		String account = Config.getProperty("Account");
		homepage.MenuItems_Distribution_Selection("ASNs");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 120);
		primaryField.sendKeys("ASN");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, asnIdInput, 50);
		driver.findElement(By.xpath(
				"//DIV[3]/DIV[1]/DIV[@role=\"presentation\"][1]/DIV[@role=\"presentation\"][1]/DIV[@role=\"presentation\"][1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/INPUT[@role=\"combobox\"][1]"))
				.click();
		driver.findElement(By.xpath("(//div[starts-with(@id,'mpslookupfield')])[5]")).click();
		Thread.sleep(2000);
		if (account.equalsIgnoreCase("QSC")) {
			driver.findElement(By.xpath("(//input[contains(@class,'x-form-field x-form-text x-form-text-default')])[12]")).sendKeys("QSC");
		} else if (account.equalsIgnoreCase("NVI")) {
			driver.findElement(By.xpath("(//input[contains(@class,'x-form-field x-form-text x-form-text-default')])[12]")).sendKeys("NVI");
		} else if (account.equalsIgnoreCase("APC")) {
			//driver.findElement(By.xpath("(//input[contains(@class,'x-form-field x-form-text x-form-text-default')])[14]")).sendKeys("APC");
		driver.findElement(By.xpath("//div[contains(text(),'Find ASN')]/following::input[1]")).sendKeys("APC");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Find ASN')]/following::input[2]")).sendKeys(asnId);
		
		int count = 0;
		while (count < 3) {
			//Thread.sleep(60000);
			Thread.sleep(10000);
			System.out.println("Trying to click the Find Button and wait for ASN to get displayed..");
			SeleniumTestHelper.waitForElementToBeClickable(driver,
					driver.findElement(By.xpath("//span[contains(text(),'Find')]")), 10);
			SeleniumTestHelper.clickOnButton(driver.findElement(By.xpath("//span[contains(text(),'Find')]")));
			count++;
		}
		
		Thread.sleep(1000);
				
		String ASNvalue = driver.findElement(By.xpath("(//div[contains(@class,'x-grid-cell-inner')])[1]")).getText();
		Items.setAsnNumber(ASNvalue);
		StringBuffer PONum = new StringBuffer(ASNvalue);
		PONum.delete(PONum.length() - 2, PONum.length());
		String PONumber = PONum.toString();
		Items.setPONumber(PONumber);
		driver.findElement(By.xpath("(//div[contains(@class,'x-grid-cell-inner')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Select')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();
		homepage.userClosesOpenedwindow("ASNs");
	}
//for negative scenario with wrong 
	public void verifyAsn(String asnId) throws Exception {
		homepage.MenuItems_Distribution_Selection("ASNs");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 120);
		primaryField.sendKeys("ASN");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, asnIdInput, 50);
		driver.findElement(By.xpath(
				"//DIV[3]/DIV[1]/DIV[@role=\"presentation\"][1]/DIV[@role=\"presentation\"][1]/DIV[@role=\"presentation\"][1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/INPUT[@role=\"combobox\"][1]"))
				.click();
		driver.findElement(By.xpath(
				"//DIV[3]/DIV[1]/DIV[@role=\"presentation\"][1]/DIV[@role=\"presentation\"][1]/DIV[@role=\"presentation\"][1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/INPUT[@role=\"combobox\"][1]"))
				.sendKeys(asnId);
		
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeClickable(driver, applyBtn, 50);
		 
		applyBtn.click();
		Thread.sleep(2000);
		int temp=0;
		 while (!SeleniumTestHelper.isElementDisplayed(asnStatus) && (temp != 10)) {
			 applyBtn.click();
			 Thread.sleep(3000);
			 temp++;
		 }
		
		 if(SeleniumTestHelper.isElementDisplayed(asnStatus)) {
			 Reporter.addStepLog("ASN is created");
			 Assert.assertTrue(false);
		 }else {
			 Reporter.addStepLog("ASN is not created");
			 Assert.assertTrue(true); 
		 }
		 
	}
	
	
	public void verifyAsnsStatus(String asnId, String status) throws Exception {
		homepage.MenuItems_Distribution_Selection("ASNs");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 120);
		primaryField.sendKeys("ASN");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, asnIdInput, 50);
		driver.findElement(By.xpath(
				"//DIV[3]/DIV[1]/DIV[@role=\"presentation\"][1]/DIV[@role=\"presentation\"][1]/DIV[@role=\"presentation\"][1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/INPUT[@role=\"combobox\"][1]"))
				.click();
		driver.findElement(By.xpath(
				"//DIV[3]/DIV[1]/DIV[@role=\"presentation\"][1]/DIV[@role=\"presentation\"][1]/DIV[@role=\"presentation\"][1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/INPUT[@role=\"combobox\"][1]"))
				.sendKeys(asnId);
		
		
	//	Screenshots.captureSnapshot(driver);
		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(asnIdInput).build().perform(); asnIdInput.click();
		 * asnIdInput.sendKeys(asnId);
		 */
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeClickable(driver, applyBtn, 50);
		 
		applyBtn.click();
		Thread.sleep(2000);
		int temp=0;
		 while (!SeleniumTestHelper.isElementDisplayed(asnStatus) && (temp != 20)) {
			 applyBtn.click();
			 Thread.sleep(5000);
			 temp++;
		 }
		//driver.findElement(By.xpath("(//span[text()='Apply'])[2]")).click();
		// List<WebElement>links = driver.findElements(By.xpath("//A/SPAN[@role='presentation']/SPAN[@role='presentation' and normalize-space()='Apply']/SPAN[2]"));
		  //  int total_count = links.size();       
		    //System.out.println("Total size :=" +total_count);   
		// Thread.sleep(3000);
	//	SeleniumTestHelper.waitForElementToBeDisplayed(driver, collapseLeft, 70);
		//collapseLeft.click();
		//SeleniumTestHelper.waitForElementToBeDisplayed(driver, refreshBtn, 50);
		String AsnStatus = asnStatus.getText();
		int count = 0;
		  while (!AsnStatus.equals(status) && (count != 20)) { 
			  applyBtn.click();
		  Thread.sleep(1000); 
		  AsnStatus = asnStatus.getText();
		  Thread.sleep(5000);
		  count++; 
		  }
		 
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, collapseLeft, 70);
		collapseLeft.click();
		Thread.sleep(1000);
		
			SeleniumTestHelper.assertEquals(AsnStatus, status);
			
			if(SeleniumTestHelper.isElementDisplayed(ASNmessage)) {
				String message= ASNmessage.getAttribute("src");
				System.out.println(message);
						if(message.contains("error")) {
							System.out.println("ASN created with some errors");
							Reporter.addStepLog("ASN Created but it has some errors");
							Steps.testRes = "Failed";
							Assert.assertTrue(false);
						}
			}
		
		Screenshots.captureSnapshot(driver);
		System.out.println("Status : " + AsnStatus + " has been verified successfully for ASN : " + asnId);
		Reporter.addStepLog("Status of ASN is " + AsnStatus);
		homepage.userClosesOpenedwindow("ASNs");

	}

	public void GetItemDetails() throws Exception {
		Thread.sleep(5000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, linesTab, 120);
		linesTab.click();
		List<WebElement> lines = driver.findElements(By.xpath("//span[contains(@id,'SKUId')]"));
		List<WebElement> Shipqty = driver.findElements(By.xpath("//span[contains(@id,'shippedQtyuom')]"));
		Thread.sleep(5000);
		Screenshots.captureSnapshot(driver);
		String itemInASNPage = null;
		String barcodes = null;
		String[] shippedQty = null;
		//
		System.out.println("Line size:" + lines.size());
		System.out.println("Line qty size:" + Shipqty.size());
		for (int i = 0; i < lines.size(); i++) {
			System.out.println("Line" + i + ":" + lines.get(i).getText());
		}
		for (int i = 0; i < Shipqty.size(); i++) {
			System.out.println("Line qty" + i + ":" + Shipqty.get(i).getText());
		}

		for (int i = 1; i < lines.size(); i++) {
			itemInASNPage = lines.get(i).getText();
			System.out.println("Line Item:" + itemInASNPage);
			//modifying the code - work in progress for fixing an issue
			SeleniumTestHelper.assertEquals(itemInASNPage, Items.getItemsForReceivingASN(i - 1));
			System.out.println("Item : " + itemInASNPage + " successfully verified in ASN page");

			shippedQty = Shipqty.get(i - 1).getText().split("\\s+");
			System.out.println("shippedQty:" + shippedQty[0]);
				SeleniumTestHelper.assertEquals(shippedQty[0],Steps.ItemDataMap.get(i-1).get("ShippedQty"));
			System.out.println(
					"ShippedQty : " + shippedQty[0] + " successfully verified in ASN page for item : " + itemInASNPage);

			/*
			 * SeleniumTestHelper.assertEquals(itemInASNPage,
			 * Items.getItemsForReceivingASN(i-1)); System.out.println("Item : " +
			 * itemInASNPage + " successfully verified in ASN page" ); lines.get(i).click();
			 * Thread.sleep(2000);
			 * SeleniumTestHelper.waitForElementToBeDisplayed(driver,itemBarcode,50);
			 * SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(
			 * itemBarcode)); barcodes=itemBarcode.getText();
			 * System.out.println("Barcode : " + barcodes + " is captured for item : " +
			 * itemInASNPage); Items.setItemBarcode(itemInASNPage, barcodes);
			 * SeleniumTestHelper.waitForElementToBeDisplayed(driver,closeBtn,50);
			 * closeBtn.click();
			 * SeleniumTestHelper.waitForElementToBeDisplayed(driver,shippedQtyLbl,50);
			 * shippedQty = Shipqty.get(i-1).getText().split("\\s+");
			 * SeleniumTestHelper.assertEquals(Integer.parseInt(shippedQty[0]),
			 * Items.getItemWithShippedASNQty(itemInASNPage));
			 * System.out.println("ShippedQty : " + shippedQty[0] +
			 * " successfully verified in ASN page for item : " + itemInASNPage );
			 */

		}
		Thread.sleep(2000);
	}

	public void searchForTheASN(String asnID) throws Exception {
		homepage.MenuItems_Distribution_Selection("ASNs");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, primaryField, 120);
		Screenshots.captureSnapshot(driver);
		primaryField.sendKeys("ASN");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, asnIdInput, 50);
		Actions action = new Actions(driver);
		action.moveToElement(asnIdInput).build().perform();
		asnIdInput.click();
		asnIdInput.sendKeys(asnID);
		//SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtn, 50);
		Thread.sleep(1000);
		applyBtn.click();
		Screenshots.captureSnapshot(driver);
	}

	public void verifyILPNStatusForAllItems(int noOfItem, String iLPNStatus) throws InterruptedException {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, lpnsTab, 50);
		lpnsTab.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNSFirstRecord, 50);
		Thread.sleep(5000);
		for (int i = 0; i < noOfItem; i++) {
			try {
				driver.findElement(By.xpath("//span[text()='" + Items.getItemPalletID(Items.getItemsForReceivingASN(i))
						+ "']/../../..//input[@type='checkbox']")).click();
			} catch (NoSuchElementException noSuchEle) {
				driver.findElement(By.xpath("//span[text()='" + Items.getItemILPN(Items.getItemsForReceivingASN(i))
						+ "']/../../..//input[@type='checkbox']")).click();
			}
			driver.findElement(By.xpath("//span[text()='" + Items.getItemILPN(Items.getItemsForReceivingASN(i)) + "']"))
					.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNSFacilityStatus, 120);
			if (iLPNStatus.contains("/")) {
				String[] iLPNStatusAsArray = iLPNStatus.split("/");
				SeleniumTestHelper.assertEquals(iLPNSFacilityStatus.getText(), iLPNStatusAsArray[i]);
				System.out.println("Status : " + iLPNStatusAsArray[i] + " verified for iLPN : "
						+ Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			} else {
				SeleniumTestHelper.assertEquals(iLPNSFacilityStatus.getText(), iLPNStatus);
				System.out.println("Status : " + iLPNStatus + " verified for iLPN : "
						+ Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			}
			asnBackBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNSFirstRecord, 50);
		}
	}

	public void verifyASN(String status) throws Exception {
		SeleniumTestHelper.waitForElementToBeClickable(driver, searchedASNChkbox, 50);
		searchedASNChkbox.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, More, 50);
		More.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, verifyASN, 50);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.assertTrue(verifyASN.isDisplayed());
		Thread.sleep(1000);
		verifyASN.click();
		Thread.sleep(3000);
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, verifyASNBtn, 50);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.assertTrue(verifyASNBtn.isDisplayed());
//		int shippedQty = 0;
//		String receivedQty = null;
//		for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
//			shippedQty = Items.getItemWithShippedASNQty(Items.getItemsForReceivingASN(i));
//			receivedQty = driver
//					.findElement(By.xpath(
//							"(//span[text()='" + Items.getItemsForReceivingASN(i) + "']/../../..//td[5]/span[1])[1]"))
//					.getText();
//			SeleniumTestHelper.assertEquals(shippedQty, Integer.parseInt(receivedQty));
//			System.out.println("ReceivedQty : " + receivedQty + " has been verifed against ShippedQty for item : "
//					+ Items.getItemsForReceivingASN(i));
//		}
		verifyASNBtn.click();
		Thread.sleep(3000);
		Screenshots.captureSnapshot(driver);
		driver.switchTo().defaultContent();
		String asnStatusActual = null;
		try {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, asnStatusLbl, 50);
			asnStatusActual = asnStatusLbl.getText();
		} catch (WebDriverException webDerExec) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtn, 50);
			applyBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, asnStatusLbl, 50);
			asnStatusActual = asnStatusLbl.getText();
		}
		int count = 0;
		while (!asnStatusActual.equals(status) && (count != 40)) {
			asnStatusLbl.click();
			asnStatusActual = asnStatusLbl.getText();
			Thread.sleep(5000);
			count++;
		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, collapseLeft, 70);
		collapseLeft.click();
		SeleniumTestHelper.assertEquals(asnStatusActual, status);
		Screenshots.captureSnapshot(driver);
		System.out.println(
				"Status : " + asnStatusActual + " has been verified successfully for ASN : " + Items.getAsnNumber());

	}

	public void verifyASNWithShortageOrOverageQty(String status) throws InterruptedException {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, More, 50);
		More.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, verifyASN, 50);
		SeleniumTestHelper.assertTrue(verifyASN.isDisplayed());
		verifyASN.click();
		Thread.sleep(3000);
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeClickable(driver, verifyASNBtn, 50);
		SeleniumTestHelper.assertTrue(verifyASNBtn.isDisplayed());
		verifyASNBtn.click();
		Thread.sleep(8000);
		driver.switchTo().defaultContent();
		String asnStatusActual = asnStatusLbl.getText();
		int count = 0;
		while (!asnStatusActual.equals(status) && (count != 40)) {
			asnStatusLbl.click();
			asnStatusActual = asnStatusLbl.getText();
			Thread.sleep(5000);
			count++;
		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, collapseLeft, 70);
		collapseLeft.click();
		SeleniumTestHelper.assertEquals(asnStatusActual, status);
		System.out.println(
				"Status : " + asnStatusActual + " has been verified successfully for ASN : " + Items.getAsnNumber());

	}

	public void GetItemDetails(String ASNStatus) throws Exception {

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, linesTab, 120);
		linesTab.click();
		List<WebElement> lines = driver.findElements(By.xpath("//span[contains(@id,'SKUId')]"));
		List<WebElement> Recqty = driver.findElements(By.xpath("//span[contains(@id,'receivedQty')]"));
		Thread.sleep(5000);
		Screenshots.captureSnapshot(driver);
		String itemInASNPage = null;
		String[] receivedQty = null;
		//
		System.out.println("Line size:" + lines.size());
		System.out.println("Line qty size:" + Recqty.size());

		if (ASNStatus.equalsIgnoreCase("Receiving Started")) {
			System.out.println("ASN Status is:"+ASNStatus);
			for (int i = 0; i < lines.size(); i++) {
				System.out.println("Line" + i + ":" + lines.get(i).getText());
			}
			for (int i = 0; i < Recqty.size(); i++) {
				System.out.println("Line qty" + i + ":" + Recqty.get(i).getText());
			}

			for (int i = 1; i < lines.size(); i++) {
				itemInASNPage = lines.get(i).getText();
				System.out.println("Line Item:" + itemInASNPage);

				SeleniumTestHelper.assertEquals(itemInASNPage, Items.getItemsForReceivingASN(i - 1));
				System.out.println("Item : " + itemInASNPage + " successfully verified in ASN page");

				receivedQty = Recqty.get(i).getText().split("\\s+");
				System.out.println("received qty:" + receivedQty[0]);
				System.out.println("Excel:"+Steps.ItemDataMap.get(i-1).get("ChangeQty"));
				SeleniumTestHelper.assertEquals(receivedQty[0], Steps.ItemDataMap.get(i-1).get("ChangeQty"));
				System.out.println("received qty : " + receivedQty[0] + " successfully verified in ASN page for item : "
						+ itemInASNPage);
			}
			System.out.println("ASN details also changed after modifying iLPN since ASN status was "+ASNStatus);
			
		} else if (ASNStatus.equalsIgnoreCase("Receiving Verified")) {
			System.out.println("ASN Status is:"+ASNStatus);
			for (int i = 0; i < lines.size(); i++) {
				System.out.println("Line" + i + ":" + lines.get(i).getText());
			}
			for (int i = 0; i < Recqty.size(); i++) {
				System.out.println("Line qty" + i + ":" + Recqty.get(i).getText());
			}

			for (int i = 1; i < lines.size(); i++) {
				itemInASNPage = lines.get(i).getText();
				System.out.println("Line Item:" + itemInASNPage);

				SeleniumTestHelper.assertEquals(itemInASNPage, Items.getItemsForReceivingASN(i - 1));
				System.out.println("Item : " + itemInASNPage + " successfully verified in ASN page");

				receivedQty = Recqty.get(i).getText().split("\\s+");
				System.out.println("received Qty:" + receivedQty[0]);
				SeleniumTestHelper.assertEquals(receivedQty[0],Steps.ItemDataMap.get(i-1).get("RecQty"));
				Screenshots.captureSnapshot(driver);
				System.out.println("received Qty : " + receivedQty[0] + " successfully verified in ASN page for item : "
						+ itemInASNPage);
				System.out.println("No changes in ASN even after modifying iLPN since ASN status was "+ASNStatus);
			}
		}
	}

	public void GetLineDetails(String ASNStatus) throws Exception {
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, linesTab, 120);
		linesTab.click();
		List<WebElement> lines = driver.findElements(By.xpath("//span[contains(@id,'SKUId')]"));
		List<WebElement> Recqty = driver.findElements(By.xpath("//span[contains(@id,'receivedQty')]"));
		Thread.sleep(5000);
		Screenshots.captureSnapshot(driver);
		String itemInASNPage = null;
		String[] receivedQty = null;
		//
		System.out.println("Line size:" + lines.size());
		System.out.println("Line qty size:" + Recqty.size());

		if (ASNStatus.equalsIgnoreCase("Receiving Started")) {
			System.out.println("ASN Status is:"+ASNStatus);
			for (int i = 0; i < lines.size(); i++) {
				System.out.println("Line" + i + ":" + lines.get(i).getText());
			}
			for (int i = 0; i < Recqty.size(); i++) {
				System.out.println("Line qty" + i + ":" + Recqty.get(i).getText());
			}

			for (int i = 1; i < lines.size(); i++) {
				itemInASNPage = lines.get(i).getText();
				System.out.println("Line Item:" + itemInASNPage);

				SeleniumTestHelper.assertEquals(itemInASNPage, Items.getItemsForReceivingASN(i - 1));
				System.out.println("Item : " + itemInASNPage + " successfully verified in ASN page");

				receivedQty = Recqty.get(i).getText().split("\\s+");
				System.out.println("received qty:" + receivedQty[0]);
				SeleniumTestHelper.assertEquals(receivedQty[0], "0");
				Screenshots.captureSnapshot(driver);
				System.out.println("received qty : " + receivedQty[0] + " successfully verified in ASN page for item : "
						+ itemInASNPage);
			}
			System.out.println("ASN details also changed after modifying iLPN since ASN status was "+ASNStatus);
			
		} else if (ASNStatus.equalsIgnoreCase("Receiving Verified")) {
			System.out.println("ASN Status is:"+ASNStatus);
			for (int i = 0; i < lines.size(); i++) {
				System.out.println("Line" + i + ":" + lines.get(i).getText());
			}
			for (int i = 0; i < Recqty.size(); i++) {
				System.out.println("Line qty" + i + ":" + Recqty.get(i).getText());
			}

			for (int i = 1; i < lines.size(); i++) {
				itemInASNPage = lines.get(i).getText();
				System.out.println("Line Item:" + itemInASNPage);

				SeleniumTestHelper.assertEquals(itemInASNPage, Items.getItemsForReceivingASN(i - 1));
				System.out.println("Item : " + itemInASNPage + " successfully verified in ASN page");

				receivedQty = Recqty.get(i).getText().split("\\s+");
				System.out.println("received Qty:" + receivedQty[0]);
				SeleniumTestHelper.assertEquals(receivedQty[0],Steps.ItemDataMap.get(i-1).get("RecQty"));
				System.out.println("received Qty : " + receivedQty[0] + " successfully verified in ASN page for item : "
						+ itemInASNPage);
				Screenshots.captureSnapshot(driver);
				System.out.println("No changes in ASN even after modifying iLPN since ASN status was "+ASNStatus);
			}
		}		
	}

	public void validateNewlyCreatedASN() throws Exception{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, linesTab, 120);
		linesTab.click();
		Thread.sleep(3000);
		List<WebElement> lines = driver.findElements(By.xpath("//span[contains(@id,'SKUId')]"));
		List<WebElement> Shipqty = driver.findElements(By.xpath("//span[contains(@id,'shippedQtyuom')]"));
		Screenshots.captureSnapshot(driver);
		
		//
		System.out.println("Line size:" + lines.size());
		System.out.println("Line qty size:" + Shipqty.size());
		for (int i = 0; i < lines.size(); i++) {
			System.out.println("Line" + i + ":" + lines.get(i).getText());
		}
		for (int i = 0; i < Shipqty.size(); i++) {
			System.out.println("Line qty" + i + ":" + Shipqty.get(i).getText());
		}

		for (int i = 0,j=0; i < Steps.ItemDataMap.size(); i++) {
			String itemInASNPage = null;
			String[] shippedQty = null;
			System.out.println("in for loop "+i);
			System.out.println((Integer.parseInt(Steps.ItemDataMap.get(i).get("ShippedQty"))-Integer.parseInt(Steps.ItemDataMap.get(i).get("RecQty"))));
			if((Integer.parseInt(Steps.ItemDataMap.get(i).get("ShippedQty"))-Integer.parseInt(Steps.ItemDataMap.get(i).get("RecQty")))>0){
				System.out.println("if loop");
			
			itemInASNPage = lines.get(j+1).getText();
			System.out.println("Line Item:" + itemInASNPage);

			SeleniumTestHelper.assertEquals(itemInASNPage, Steps.ItemDataMap.get(i).get("Item"));
			System.out.println("Item : " + itemInASNPage + " successfully verified in ASN page");

			shippedQty = Shipqty.get(j).getText().split("\\s+");
			System.out.println("shippedQty:" + shippedQty[0]);
				SeleniumTestHelper.assertEquals(Integer.parseInt(shippedQty[0]),(Integer.parseInt(Steps.ItemDataMap.get(i).get("ShippedQty"))-Integer.parseInt(Steps.ItemDataMap.get(i).get("RecQty"))));
			System.out.println(
					"ShippedQty : " + shippedQty[0] + " successfully verified in ASN page for item : " + itemInASNPage);
			j++;
			}
			Thread.sleep(2000);
		}
	}
	
	//New Raka
		public void verifyPalletStatus(String status) throws InterruptedException {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, lpnsTab, 50);
			lpnsTab.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNSFirstRecord, 50);
			Thread.sleep(5000);
			
			WebElement base = driver.findElement(By.id("dataForm:ASNLPNListView_id:LPNListTable_body"));
			List<WebElement> tableRows = base.findElements(By.tagName("tr"));
			System.out.println("tableRows.size: "+tableRows.size());
			String PalletVal=null;
			for(int tRows=0;tRows<tableRows.size()-1;tRows++) {
				List<WebElement> tableCols = tableRows.get(tRows).findElements(By.tagName("td"));
				//System.out.println("col size: "+tableCols.size());
				String cellValue = tableCols.get(10).getText();
				if(cellValue.equals(status)) {
					PalletVal = tableCols.get(4).getText();
					System.out.println("PalletVal: "+PalletVal);
					
				}
				
			}
		}
		
		public void verifyILPNStatus(String iLPNStatus) throws InterruptedException {
			System.out.println("Verify LPN Status");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, lpnsTab, 50);
			lpnsTab.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNSFirstRecord, 50);
			Thread.sleep(5000);
			String shpQty = null;
			String itemName = null;
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
				itemName = Steps.ItemDataMap.get(i).get("Item");
				Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shpQty));
			}
			for (int i = 1; i <= Items.getItemWithShippedASNQty(itemName); i++) {

				String lpn = driver.findElement(By.xpath("//table[@id='dataForm:ASNLPNListView_id:LPNListTable_body']//tr[" + i + "]/td[5]")).getText();
				String lpnStatus = driver.findElement(By.xpath("//table[@id='dataForm:ASNLPNListView_id:LPNListTable_body']//tr[" + i + "]/td[9]")).getText();
				System.out.println(lpn);
				System.out.println(lpnStatus);
				SeleniumTestHelper.assertEquals(lpnStatus, iLPNStatus);
				driver.findElement(By.xpath("//table[@id='dataForm:ASNLPNListView_id:LPNListTable_body']//tr[" + i + "]/td[1]")).click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, serailNumberButton, 5);
				SeleniumTestHelper.clickOnButton(serailNumberButton);
				String s = driver.findElement(By.xpath("//span[@id='dataForm:listView:dataTable:0:srlNbr']")).getText();
				System.out.println(s);
				driver.findElement(By.xpath("//a[@id='backButton']")).click();
				Thread.sleep(5000);
			}
			System.out.println("LPN Verified Successfully");
			Thread.sleep(10000);
		}
		
		public void verifyLotNumberInASnPage() throws Exception {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, linesTab, 120);
			linesTab.click();
			List<WebElement> lines = driver.findElements(By.xpath("//span[contains(@id,'SKUId')]"));
			List<WebElement> Shipqty = driver.findElements(By.xpath("//span[contains(@id,'shippedQtyuom')]"));
			List<WebElement> batchNum = driver.findElements(By.xpath("//span[contains(@id,'Batch_Otext')]"));

			
			Thread.sleep(5000);
			Screenshots.captureSnapshot(driver);
			String itemInASNPage = null;
			String barcodes = null;
			String[] shippedQty = null;
			String batchNo = null;
			
			//
			System.out.println("Line size:" + lines.size());
			System.out.println("Line qty size:" + Shipqty.size());
			for (int i = 0; i < lines.size(); i++) {
				System.out.println("Line" + i + ":" + lines.get(i).getText());
			}
			for (int i = 0; i < Shipqty.size(); i++) {
				System.out.println("Line qty" + i + ":" + Shipqty.get(i).getText());
			}

			for (int i = 1; i < lines.size(); i++) {
				itemInASNPage = lines.get(i).getText();
				System.out.println("Line Item:" + itemInASNPage);
				//modifying the code - work in progress for fixing an issue
				SeleniumTestHelper.assertEquals(itemInASNPage, Items.getItemsForReceivingASN(i - 1));
				System.out.println("Item : " + itemInASNPage + " successfully verified in ASN page");

				shippedQty = Shipqty.get(i - 1).getText().split("\\s+");
				System.out.println("shippedQty:" + shippedQty[0]);
					SeleniumTestHelper.assertEquals(shippedQty[0],Steps.ItemDataMap.get(i-1).get("ShippedQty"));
				System.out.println(
						"ShippedQty : " + shippedQty[0] + " successfully verified in ASN page for item : " + itemInASNPage);
				if (batchNum.size() != 0) {
					batchNo = batchNum.get(i - 1).getText();
				}
				Items.setLotNumber(batchNo);
				System.out.println("Batch Number" + batchNo);
				System.out.println("Get Lot Number"+Items.getLotNumber());

			}
			Thread.sleep(2000);
		}
//		public void getSerialNumberFromASNViewPage() throws Exception {
//			SeleniumTestHelper.waitForElementToBeDisplayed(driver, linesTab, 120);
//			linesTab.click();
//			List<WebElement> lines = driver.findElements(By.xpath("//span[contains(@id,'SKUId')]"));
//			List<WebElement> Shipqty = driver.findElements(By.xpath("//span[contains(@id,'shippedQtyuom')]"));
//			
//			Thread.sleep(5000);
//			Screenshots.captureSnapshot(driver);
//			String itemInASNPage = null;
//			String barcodes = null;
//			String[] shippedQty = null;
//			String batchNo = null;
//						
//			System.out.println("Line size:" + lines.size());
//			System.out.println("Line qty size:" + Shipqty.size());
//			for (int i = 0; i < lines.size(); i++) {
//				System.out.println("Line" + i + ":" + lines.get(i).getText());
//			}
//			for (int i = 0; i < Shipqty.size(); i++) {
//				System.out.println("Line qty" + i + ":" + Shipqty.get(i).getText());
//			}
//			
//			for (int i = 1; i < lines.size(); i++) {
//				itemInASNPage = lines.get(i).getText();
//				System.out.println("Line Item:" + itemInASNPage);
//				//modifying the code - work in progress for fixing an issue
//				SeleniumTestHelper.assertEquals(itemInASNPage, Items.getItemsForReceivingASN(i - 1));
//				System.out.println("Item : " + itemInASNPage + " successfully verified in ASN page");
//
//				shippedQty = Shipqty.get(i - 1).getText().split("\\s+");
//				System.out.println("shippedQty:" + shippedQty[0]);
//					SeleniumTestHelper.assertEquals(shippedQty[0],Steps.ItemDataMap.get(i-1).get("ShippedQty"));
//				System.out.println(
//						"ShippedQty : " + shippedQty[0] + " successfully verified in ASN page for item : " + itemInASNPage);
//				if (batchNum.size() != 0) {
//					batchNo = batchNum.get(i - 1).getText();
//				}
//				Items.setLotNumber(batchNo);
//				System.out.println("Batch Number" + batchNo);
//				System.out.println("Get Lot Number"+Items.getLotNumber());
//
//			}
//			Thread.sleep(2000);
//
//		}

}
