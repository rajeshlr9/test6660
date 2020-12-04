package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import entity.DistributionOrders;
import utils.Driver;
import utils.SeleniumTestHelper;
import utils.TestStubReader;

public class OlpnsPage {
	WebDriver driver;
	
	public OlpnsPage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	HomePage homepage = new HomePage();
	String firstOlpn;

	@FindBy(xpath = "//input[@alt='Find oLPN']")
	public WebElement oLPNinput;

	// @FindBy(xpath="//input[@value='Apply' and
	// contains(@id,'dataForm:listView:filterId:filterIdapply')]") public
	// WebElement applyBtn;
	// @FindBy(xpath="//input[@id='checkAll_c0_dataForm:listView:dataTable']")
	// public WebElement oLPNchkbox;

	@FindBy(xpath = "(//input[@value='Apply' and @title = 'Apply'])[1]")
	public WebElement applyBtn;

	@FindBy(xpath = "//input[contains(@name,'checkAll_c0_dataForm:')]")
	public WebElement oLPNchkbox;

	@FindBy(xpath = "//input[@value='View']")
	public WebElement viewBtn;
	@FindBy(xpath = "//a[@id='LPN_Header_Tab_lnk']")
	public WebElement headerTab;
	@FindBy(xpath = "//span[@id='dataForm:ViewLPNHeader_PickLocation_Text']")
	public WebElement pickLocation;
	@FindBy(xpath = "//img[@id='backImage']")
	public WebElement backBtn;

	@FindBy(xpath = "//span[text()='Quick filter']")
	public WebElement quickFilterdrpdwn;

	@FindBy(xpath = "//input[@id='dataForm:LPNListInOutboundMain_lv:LPNList_Outbound_filterId1:LPNList_Outbound_filterId1apply']")
	public WebElement apply;

	@FindBy(xpath = "//input[@id='dataForm:LPNListInOutboundMain_lv:LPNList_Outbound_filterId1:savedapply']")
	public WebElement applyonSaved;

	@FindBy(xpath = "//input[contains(@id,'savedapply')]")
	public WebElement apply_Btn;

	@FindBy(xpath = "//a[text()='Saved filters']")
	public WebElement savedFilters;

	@FindBy(xpath = "(//span[text()='From:'])[1]/../following-sibling::td//select")
	public WebElement olpnsFacilitysatusFrom;

	@FindBy(xpath = "(//span[text()='To:'])[1]/../following-sibling::td//select")
	public WebElement olpnsFacilitysatusTo;

	@FindBy(xpath = "//input[@id='dataForm:applyFltrBtnPopupAjax']")
	public WebElement applyinSavedFilterbtn;

	@FindBy(xpath = "((//span[text()='Packed'])[1]/../../preceding-sibling::td)[1]")
	public WebElement packedolpnfirstChkx;

	@FindBy(xpath = "//span[contains(@id,'ViewPOLineItemList_LPN_POLine_Item_param_out_Commnd')]")
	public List<WebElement> itemNames;

	public String itemnamepath = "(//span[contains(@id,'ViewPOLineItemList_LPN_POLine_Item_param_out_Commnd')])[<INDEX>]";

	@FindBy(xpath = "//input[@id='dataForm:filterDetailId:field10value1']")
	public WebElement lpninFilterTxtbx;

	@FindBy(xpath = "//input[@value='Lock/Unlock']")
	public WebElement lockorunlockiLPNbtn1;

	@FindBy(xpath = "//input[@id='rmButton_1Lock1_167270008']")
	public WebElement lockbtn;

	// @FindBy(xpath="//input[@id='//select[contains(@id,'dataForm:listView:dataTable:newRow_1:LockCodeSelect')]']")

	@FindBy(xpath = "//select[@id='dataForm:listView:dataTable:newRow_1:LockCodeSelect']")
	public WebElement selctdrpdwn;

	@FindBy(xpath = "//input[@id='rmButton_1Save1_167270010']")
	public WebElement savebtn;

	@FindBy(xpath = "//td[contains(text(),'No data found')]")
	public WebElement lockNoDataFoundLbl;

	@FindBy(xpath = "//select[@id='dataForm:listView:filterId:field20value1']/option")
	public List<WebElement> fromDropDown;

	@FindBy(xpath = "//select[@id='dataForm:listView:filterId:field20value2']/option")
	public List<WebElement> ToDropDown;

	@FindBy(xpath = "//span[@id='dataForm:listView:dataTable:0:LPNList_Outbound_Link_NameText_param_out']")
	public WebElement firstOlpntext;

	@FindBy(xpath = "//input[@name='soheaderbuttonsmoreButton']")
	public WebElement moreBtn;
	@FindBy(xpath="//a[@id='LPNListInboundMain_commandbutton_PrintoLPNContentLabel']")
	public WebElement printContentLabel;
	
    @FindBy(xpath="//input[@id='rmButton_1PrintContentLabels1_167271503']")
    public WebElement printContentLabelnextpage; 
    
    @FindBy(xpath="//li[text()='Transaction successful.']")
    public WebElement Transactionsucceful;
    
    @FindBy(xpath="//span[@id='dataForm:ViewLPNHeader_ShipVia_param_out66']")
    public WebElement shipvia;
    

	public WebElement getitemxpath(Integer index) {

		String indexstring = String.valueOf(index);
		String itemxpath = itemnamepath.replace("<INDEX>", indexstring);
		System.out.println(itemxpath);
		return driver.findElement(By.xpath(itemxpath));
	}

	@FindBy(xpath = "//span[text()='LPN:']/../following-sibling::td[1]//span")
	public WebElement lpnValue;

	@FindBy(xpath = "//span[contains(@id,'ViewPOLineItemList_LPN_tobepackedqty_param_out')]")
	public WebElement tpbepackedqty;

	public String tobepackedqtypath = "(//span[contains(@id,'ViewPOLineItemList_LPN_tobepackedqty_param_out')])[<INDEX>]";

	public WebElement gettobepackedqtypath(int index) {

		String indexstring = String.valueOf(index);
		String tobepackedqtyxpath = tobepackedqtypath.replace("<INDEX>", indexstring);
		System.out.println(tobepackedqtyxpath);
		return driver.findElement(By.xpath(tobepackedqtyxpath));
	}

	@FindBy(xpath = "//a[text()='Locks']")
	public WebElement locksTab;

	@FindBy(xpath = "//input[@id='LPNListOutboundMain_CmdBtn_LockoLPN']")
	public WebElement lockunlockBtn;

	@FindBy(xpath = "//input[@value='Lock']")
	public WebElement lockBtn;

	@FindBy(xpath = "//input[@value='Save']")
	public WebElement SavelockBtn;

	@FindBy(xpath = "//select[@id='dataForm:listView:dataTable:newRow_1:LockCodeSelect']")
	public WebElement selectlockcodeDrpdown;

	@FindBy(xpath = "((//span[contains(@id,'LPNList_Inbound_LockCount_param_out')])[1]/../../preceding-sibling::td)[1]")
	public WebElement lockedolpnfirstChkx;

	@FindBy(xpath = "(//span[contains(@id,'LPNList_Inbound_LockCount_param_out') and not(contains(text(),'0'))])[1]")
	public WebElement firstlockedolpn;

	@FindBy(xpath = "//span[text()='Quality audit?:']/../following-sibling::td[1]")
	public WebElement auditlockValue;
	
	@FindBy(xpath = "//span[@id='dataForm:listView:dataTable:0:LPNList_Outbound_Link_NameText_param_out']")
	public WebElement firstOlpnText;
	
	@FindBy(xpath = "//span[text()='Shipment']")
	public WebElement shipmentTab;
	
	@FindBy(xpath = "//span[contains(@id,':0:LPNList_Outbound_DistributionOrderId')]")
	public WebElement firstDONum;
	
	@FindBy(xpath = "//input[@id='LPNListInboundMain_commandbutton_CanceloLPN']")
	public WebElement cancelOlpn;

	
	
	public void ApplyLockOLPN(String lockcode) throws Exception {
		homepage.MenuItems_Distribution_Selection("oLPNs");
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < DistributionOrders.oLPNList.size(); i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNinput, 50);
			oLPNinput.clear();
			oLPNinput.sendKeys(DistributionOrders.getoLPNList(i));
			SeleniumTestHelper.waitForElementToBeClickable(driver, applyBtn, 50);
			applyBtn.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, oLPNchkbox, 50);
			oLPNchkbox.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, lockorunlockiLPNbtn1, 50);
			lockorunlockiLPNbtn1.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, lockbtn, 50);
			lockbtn.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, selctdrpdwn, 50);
			selctdrpdwn.click();

			WebElement lockCode1 = driver
					.findElement(By.xpath("//select[@id='dataForm:listView:dataTable:newRow_1:LockCodeSelect']"));
			Select selectLock = new Select(lockCode1);
			selctdrpdwn.click();
			List<WebElement> allOptions = selectLock.getOptions();
			for (WebElement optInv : allOptions) {
				selctdrpdwn.sendKeys(Keys.ARROW_DOWN);
				if (optInv.getText().equals(lockcode)) {
					break;
				}
			}
			SeleniumTestHelper.assertTrue(selctdrpdwn.isDisplayed());

			driver.findElement(
					By.xpath("//select[contains(@id,'newRow_1:LockCodeSelect')]/option[text()='" + lockcode + "']"))
					.click();
			savebtn.click();
			Thread.sleep(5000);
			backBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNinput, 50);
		}
		homepage.user_closes_openedwindow("oLPNs");
	}

	public void selectFromolpnFacilitystatus(String fromstatus) {

		Select sel = new Select(olpnsFacilitysatusFrom);
		sel.selectByVisibleText(fromstatus);

	}

	public void selectToolpnFacilitystatus(String Tostatus) {

		Select select = new Select(olpnsFacilitysatusTo);

		select.selectByVisibleText(Tostatus);

	}

	public void getoLPNStatus(String expectedoLPNstatus) throws Exception {

		homepage.MenuItems_Distribution_Selection("oLPNs");
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < DistributionOrders.oLPNList.size(); i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNinput, 50);
			oLPNinput.clear();
			oLPNinput.sendKeys(DistributionOrders.getoLPNList(i));
			SeleniumTestHelper.waitForElementToBeClickable(driver, applyBtn, 50);
			applyBtn.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, oLPNchkbox, 50);
			oLPNchkbox.click();
			String actualoLPNstatus = driver
					.findElement(By
							.xpath("//div[contains(@class,'dshow')]//following-sibling::span[contains(@id,'LPNList_Outbound_lpnFacilityStatus')]"))
					.getText();
			SeleniumTestHelper.assertEquals(actualoLPNstatus, expectedoLPNstatus);
		}
		homepage.userClosesOpenedwindow("oLPNs");
	}

	public void getReserveandCaseoLPNStatus(String oLPNtype, String expectedoLPNstatus)
			throws Exception {
		homepage.MenuItems_Distribution_Selection("oLPNs");
		SeleniumTestHelper.switchToInnerFrame(driver);
		if (oLPNtype.equalsIgnoreCase("Reserve")) {
			for (int i = 0; i < DistributionOrders.oLPNwithReserve.size(); i++) {
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNinput, 50);
				oLPNinput.clear();
				oLPNinput.sendKeys(DistributionOrders.getoLPNwithReserve(i));
				SeleniumTestHelper.waitForElementToBeClickable(driver, applyBtn, 50);
				applyBtn.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, oLPNchkbox, 50);
				oLPNchkbox.click();
				String actualoLPNstatus = driver
						.findElement(By
								.xpath("//div[contains(@class,'dshow')]//following-sibling::span[contains(@id,'LPNList_Outbound_lpnFacilityStatus')]"))
						.getText();
				SeleniumTestHelper.assertEquals(actualoLPNstatus, expectedoLPNstatus);
			}
		} else if (oLPNtype.equalsIgnoreCase("Case Pick")) {
			for (int i = 0; i < DistributionOrders.oLPNwithCase.size(); i++) {
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNinput, 50);
				oLPNinput.clear();
				oLPNinput.sendKeys(DistributionOrders.getoLPNwithCase(i));
				SeleniumTestHelper.waitForElementToBeClickable(driver, applyBtn, 50);
				applyBtn.click();
				SeleniumTestHelper.waitForElementToBeClickable(driver, oLPNchkbox, 50);
				oLPNchkbox.click();
				String actualoLPNstatus = driver
						.findElement(By
								.xpath("//div[contains(@class,'dshow')]//following-sibling::span[contains(@id,'LPNList_Outbound_lpnFacilityStatus')]"))
						.getText();
				SeleniumTestHelper.assertEquals(actualoLPNstatus, expectedoLPNstatus);
			}
		}
		homepage.user_closes_openedwindow("oLPNs");
	}

	public void verifiesappliedLock() throws Exception {
		homepage.MenuItems_Distribution_Selection("oLPNs");
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < DistributionOrders.oLPNList.size(); i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNinput, 50);
			oLPNinput.clear();
			oLPNinput.sendKeys(DistributionOrders.getoLPNList(i));
			SeleniumTestHelper.waitForElementToBeClickable(driver, applyBtn, 50);
			applyBtn.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, oLPNchkbox, 50);
			oLPNchkbox.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, lockorunlockiLPNbtn1, 50);
			lockorunlockiLPNbtn1.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, lockBtn, 50);
			SeleniumTestHelper.assertTrue(lockNoDataFoundLbl.isDisplayed());
			backBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNinput, 50);
		}
		homepage.user_closes_openedwindow("oLPNs");
	}

	public void userOpensOlpnScreen() throws Exception {
		homepage.MenuItems_Distribution_Selection("oLPNs");
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNinput, 50);
		oLPNinput.clear();

		SeleniumTestHelper.dropdownByFindElements(fromDropDown, "Packed");
		SeleniumTestHelper.dropdownByFindElements(ToDropDown, "Packed");

		SeleniumTestHelper.waitForElementToBeClickable(driver, applyBtn, 50);
		applyBtn.click();
		// selecting First visible OLPN
		SeleniumTestHelper.waitForElementToBeClickable(driver, firstOlpntext, 50);
		@SuppressWarnings("unused")
		String firstOlpn = firstOlpntext.getText();
		System.out.println("First OLPN text is " + firstOlpn);
		homepage.user_closes_openedwindow("oLPNs");
	}
	public void userOpensOlpnScreenContentoLPN(String sheetName, String rowname, int columnnumber)
			throws Exception {
		homepage.MenuItems_Distribution_Selection("oLPNs");
		SeleniumTestHelper.switchToInnerFrame(driver);
		TestStubReader stubReader = new TestStubReader();
		stubReader.setReadingSheet(sheetName);
		String oLPNnumber = stubReader.setSheetAndGetData(sheetName, rowname, columnnumber);
		System.out.println("oLPNnumber.." + oLPNnumber);
		oLPNinput.sendKeys(oLPNnumber);

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNinput, 50);
		oLPNinput.clear();
		oLPNinput.sendKeys(oLPNnumber);
		SeleniumTestHelper.waitForElementToBeClickable(driver, applyBtn, 50);
		applyBtn.click();
		SeleniumTestHelper.waitForElementToBeClickable(driver, oLPNchkbox, 50);
		oLPNchkbox.click();

		SeleniumTestHelper.waitForElementToBeClickable(driver, moreBtn, 50);
		moreBtn.click();

		SeleniumTestHelper.waitForElementToBeClickable(driver, printContentLabel, 50);
		printContentLabel.click();

		SeleniumTestHelper.waitForElementToBeClickable(driver, printContentLabelnextpage, 50);
		printContentLabelnextpage.click();

		SeleniumTestHelper.assertTrue(printContentLabelnextpage.isDisplayed());

		SeleniumTestHelper.waitForElementToBeClickable(driver, Transactionsucceful, 50);
		Transactionsucceful.getText();

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Transactionsucceful, 50);

		homepage.user_closes_openedwindow("oLPNs - Print Content Labels");

	}

	public void ValidateShipviaFromoLPN(String shipviaval,String sheetName, String rowname, int columnnumber)
			throws Exception {
		homepage.MenuItems_Distribution_Selection("oLPNs");
		SeleniumTestHelper.switchToInnerFrame(driver);
		for (int i = 0; i < DistributionOrders.oLPNList.size(); i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, oLPNinput, 50);
			oLPNinput.clear();
			oLPNinput.sendKeys(DistributionOrders.getoLPNList(i));

			SeleniumTestHelper.waitForElementToBeClickable(driver, applyBtn, 50);
			applyBtn.click();
			SeleniumTestHelper.waitForElementToBeClickable(driver, oLPNchkbox, 50);
			oLPNchkbox.click();

			SeleniumTestHelper.waitForElementToBeClickable(driver, viewBtn, 50);
			viewBtn.click();

			SeleniumTestHelper.waitForElementToBeClickable(driver, headerTab, 50);
			headerTab.click();

			SeleniumTestHelper.assertTrue(shipvia.isDisplayed());

			SeleniumTestHelper.waitForElementToBeClickable(driver, shipvia, 50);
			shipvia.getText();

			String Actualshipvia = shipvia.getText();
			SeleniumTestHelper.assertEquals(Actualshipvia, shipviaval);


			homepage.user_closes_openedwindow("oLPNs - oLPN Details");

		

		}
	}

}
