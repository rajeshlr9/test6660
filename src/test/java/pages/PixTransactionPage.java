package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Steps;
import entity.Items;
import utils.Config;
import utils.Driver;
import utils.SeleniumTestHelper;

public class PixTransactionPage {
	WebDriver driver;

	public PixTransactionPage() {
		this.driver=Steps.seleniumDriver;
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

	@FindBy(xpath = "//input[@id='dataForm:lview:dataTable:pager:dataTable_rfsh_but']")
	public WebElement refreshIcon;

	@FindBy(xpath = "//input[@id='checkAll_c0_dataForm:lview:dataTable']")
	public WebElement firstCheckBox;

	@FindBy(xpath = "//span[@id='dataForm:detail_Value_5']")
	public WebElement statusUnprocessed;

	@FindBy(xpath = "//input[@id='dataForm:lview:dataTable:pager:dataTable_rfsh_but']")
	public WebElement refreshBtn;

	public void checkForPixTransaction(String pixTranNumber, String pixTranCode, int noOfItems, String status)
			throws Throwable {
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
			savedFilteriLPN.sendKeys(Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			addsavedFilter.click();
			Thread.sleep(3000);
			SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 50);
			SeleniumTestHelper.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='" + Items.getItemsForReceivingASN(i) + "']")), 60);
			Thread.sleep(1000);
			String pixStatusValue = null;
			int count = 0;
			pixStatusValue = driver.findElement(By.xpath("//span[text()='" + Items.getItemILPN(Items.getItemsForReceivingASN(i))+ "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']")).getAttribute("textContent");
			boolean waitFortenMinutesForStatusChange = Boolean.parseBoolean(Config.getProperty("waitForTenMinutesForPixStatusChange"));
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
				}
				SeleniumTestHelper.assertEquals(pixStatusValue, status);
				System.out.println("PIX Transc status : " + pixStatusValue + " verified successfully for iLPN : "+ Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			} else {
				System.out.println("PIX Transc status : " + pixStatusValue + " displayed for iLPN : "+ Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			}
		}
		homePage.userClosesOpenedwindow("PIX Transactions");
	}
	
	public void checkForPixTransactions(String pixTranNumber, String pixTranCode, int noOfItems, String status)
			throws Throwable {
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
			//savedFilteriLPN.sendKeys(Items.getItemILPN(Items.getItemsForReceivingASN(i)));
			addsavedFilter.click();
			Thread.sleep(3000);
			SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 50);
			
			SeleniumTestHelper.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//span[text()='" + Items.getiLpn() + "']")), 60);
			//SeleniumTestHelper.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='" + Items.getItemsForReceivingASN(i) + "']")), 60);
			Thread.sleep(1000);
			String pixStatusValue = null;
			int count = 0;
			
			pixStatusValue = driver.findElement(By.xpath("//span[text()='" + Items.getiLpn()+ "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']")).getAttribute("textContent");
			//pixStatusValue = driver.findElement(By.xpath("//span[text()='" + Items.getItemILPN(Items.getItemsForReceivingASN(i))+ "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']")).getAttribute("textContent");
			boolean waitFortenMinutesForStatusChange = Boolean.parseBoolean(Config.getProperty("waitForTenMinutesForPixStatusChange"));
			if (waitFortenMinutesForStatusChange) {
				int maximunWait = 600000;
				int iteration = 20000;
				int totalItrWait = 0;
				while (!pixStatusValue.equals(status) && (count != 40) && (maximunWait > totalItrWait)) {
					refreshBtn.click();
					Thread.sleep(5000);
					SeleniumTestHelper.waitForElementToBeClickable(driver, quickFilter, 50);
					SeleniumTestHelper.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='" + Items.getiLpn() + "']")), 60);
					//SeleniumTestHelper.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='" + Items.getItemsForReceivingASN(i) + "']")), 60);
					pixStatusValue = driver.findElement(By.xpath("//span[text()='" + Items.getiLpn()+ "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']")).getAttribute("textContent");
				//	pixStatusValue = driver.findElement(By.xpath("//span[text()='" + Items.getItemILPN(Items.getItemsForReceivingASN(i))+ "']/../..//span[@id='dataForm:lview:dataTable:0:fuid9']")).getAttribute("textContent");
					Thread.sleep(iteration);
					count++;
					totalItrWait = iteration + totalItrWait;
				}
				SeleniumTestHelper.assertEquals(pixStatusValue, status);
				System.out.println("PIX Transc status : " + pixStatusValue + " verified successfully for iLPN : "+ Items.getiLpn());
			} else {
				System.out.println("PIX Transc status : " + pixStatusValue + " displayed for iLPN : "+ Items.getiLpn());
			}
		}
		homePage.userClosesOpenedwindow("PIX Transactions");
	}
}
