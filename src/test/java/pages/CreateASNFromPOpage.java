package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import entity.Items;
import utils.Driver;
import utils.SeleniumTestHelper;
import utils.Xpathxml;

public class CreateASNFromPOpage {
	WebDriver driver;
	public CreateASNFromPOpage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	HomePage homepage = new HomePage();
	Xpathxml xmlInput = new Xpathxml();
	@FindBy(xpath = "//span[text()='PO:']//preceding::span[text()='Quick filter']")
	public WebElement quickFilerPO;
	@FindBy(xpath = "//span[text()='PO:']//preceding::li/a[text()='Saved filters']")
	public WebElement savedFilerPO;
	@FindBy(xpath = "//span[text()='PO:']//following::input[@id='dataForm:filterId:savedapply']")
	public WebElement applyBtnPO;
	@FindBy(xpath = "//span[text()='Purchase order status:']//following::div[@id='ms_stimgdiv2']")
	public WebElement purchaseOrderStatus;
	@FindBy(xpath = "//div[@id='ms_popcnt2']//following::button[@id='ms_popok2'  and text()='OK']")
	public WebElement savedFilerOKBtnPO;
	@FindBy(xpath = "//input[@value='Apply' and @id='dataForm:applyFltrBtnPopup']")
	public WebElement savedFilerApplyBtnPO;
	@FindBy(xpath = "//input[@title='PODTL']//following::td[4]/a/span[1]")
	public WebElement remainingShippedQty;
	@FindBy(xpath = "//input[@title='PODTL']")
	public WebElement poChckBox;
	@FindBy(xpath = "//input[@value='Add']")
	public WebElement addBtn;
	@FindBy(xpath = "//input[@value='Generate']")
	public WebElement generateBtn;
	@FindBy(xpath = "//input[@id='dataForm:asnidh1']")
	public WebElement asnIdTxtBox;
	@FindBy(xpath = "//input[@title='Select date and time']")
	public WebElement selectDateAndTime;
	@FindBy(xpath = "//td[@class='day selected today']//following::td[2]")
	public WebElement estimatedDeliveryDate;
	@FindBy(xpath = "//span[text()='Estimated delivery']//following::input[@id='dataForm:sdqtyhcc']")
	public WebElement estimatedDeliverytxtbox;
	@FindBy(xpath = "(//span[text()='Estimated delivery']//following::input[@value='OK'])[1]")
	public WebElement createNewASNOkBtn;
	@FindBy(xpath = "//input[@alt='Find ASN']")
	public WebElement asnTxtBox;
	@FindBy(xpath = "//input[@id='dataForm:cbdelasns']")
	public WebElement saveBtn;
	@FindBy(xpath = "//input[@alt='Find Purchase Order']")
	public WebElement POIdInput;
	@FindBy(xpath = "//span[text()='PO:']//following::input[@id='dataForm:filterId:filterIdapply']")
	public WebElement applyBtnPOInput;
	@FindBy(xpath = "//input[@id='dataForm:treeTable:0:treeB:adaptor:0::selectId']")
	public WebElement selectPO;

	@FindBy(xpath = "//span[text()='PO:']//following::input[@id='dataForm:filterId2:filterId2apply']")
	public WebElement applyBtnAsn;

	@FindBy(xpath = "//input[@id='dataForm:atreeTable:0:atreeB:aadaptor:0::aselectId']")
	public WebElement selectASN;

	@FindBy(xpath = "//input[@id='dataForm:cb5']")
	public WebElement selectchekBox;

	@FindBy(xpath = "//input[@title='Select date and time']")
	public WebElement selectdatetime;

	@FindBy(xpath = "//div[@unselectable='on' and text()='Today']")
	public WebElement selectTodaydate;

	

	public void CreateASNFromPO(String POId) throws InterruptedException, IOException {
		homepage.MenuItems_Distribution_Selection("Create ASN From PO");
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, POIdInput, 50);
		POIdInput.click();
		POIdInput.sendKeys(POId);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtnPOInput, 50);
		applyBtnPOInput.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectPO, 50);
		selectPO.click();		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, addBtn, 50);
		addBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, generateBtn, 50);
		generateBtn.click();
		Thread.sleep(3000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, asnIdTxtBox, 50);
		String asnId = asnIdTxtBox.getAttribute("value");
		Items.setAsnNumber(asnId);
		SeleniumTestHelper.assertEquals(asnId.equals(""), false);		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectdatetime, 50);
		selectdatetime.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectTodaydate, 50);
		selectTodaydate.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, createNewASNOkBtn, 50);
		Thread.sleep(2000);
		createNewASNOkBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, asnTxtBox, 50);
		Thread.sleep(1000);
		asnTxtBox.sendKeys(Items.getAsnNumber());
		WebElement asnDisplayed = driver.findElement(By.xpath("//span[contains(text(),'" + Items.getAsnNumber() + "')]"));
		if (SeleniumTestHelper.isElementDisplayed(asnDisplayed)) {
			SeleniumTestHelper.assertEquals(SeleniumTestHelper.isElementDisplayed(asnDisplayed), true);
		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtnAsn, 50);
		applyBtnAsn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectASN, 50);
		Thread.sleep(1000);
		selectASN.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, selectchekBox, 50);
		selectchekBox.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, saveBtn, 50);
		saveBtn.click();
		homepage.userClosesOpenedwindow("Create ASN From PO - Create ASN fro...");
		                                 
	}
}
	
	
