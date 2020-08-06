package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.DistributionOrders;
import entity.Items;
import globalFunc.DateTime;
import globalFunc.GlobalClass;
import utils.Driver;
import utils.JSONReadAndWrite;
import utils.SeleniumTestHelper;
import utils.TestStubReader;
import utils.Xpathxml;


public class RFMenuPage {
	WebDriver driver;
	public ArrayList<String> iLPNz=new ArrayList<String>();   
	public RFMenuPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	
	HomePage homepage = new HomePage();
	//TestStubReader testStubReader = new TestStubReader();
	//JSONReadAndWrite jaAndWrite = new JSONReadAndWrite();
	List<String> serials=new ArrayList<String>();
	String currentSheetName=null ;
	String dataFromSheet = null;
	String dataFromsheet=null;
	
	public String  newSysSuggestedLoc = null;
	public String  LPNVal = null;
	@FindBy(xpath = "//td[@class='td_tool_bar_icon']/input")
	public WebElement RFmenu_info;
	@FindBy(xpath = "//span[@value='Main Menu']")
	public WebElement Mainmenu;
	@FindBy(xpath = "//div[@id='choiceCaption']//following-sibling::input")
	public WebElement ChoiceCaption;
	@FindBy(xpath = "//a[text()='Receiving']")
	public WebElement Receiving;
	@FindBy(xpath = "//a[contains(text(),'Recv Item L')]")
	public WebElement RF_Recv_Iten_lvl;
	@FindBy(xpath = "//span[text()='ASN:']/..//input")
	public WebElement inputASN;
	@FindBy(xpath = "//input[@id='lpninput']")
	public WebElement lpnInputTxt;
	@FindBy(id = "verfiyItemBrcd")
	public WebElement ItemBarcode;
	@FindBy(xpath = "//span[text()='Lot:']/..//input")
	public WebElement rfMenuLotInput;
	@FindBy(xpath = "//span[text()='ExpDate:']//following::input[1]")
	public WebElement expirydatemonthtxtbox;
	@FindBy(xpath = "//span[text()='ExpDate:']//following::input[2]")
	public WebElement expirydatedatetxtbox;
	@FindBy(xpath = "//span[text()='ExpDate:']//following::input[3]")
	public WebElement expirydateyeartxtbox;
	@FindBy(xpath = "//div[@id='ItemQTy']//following::input[1]")
	public WebElement Item_qty;
	
	@FindBy(xpath = "//span[text()='Page Down']")
	public WebElement pageDown;
	
	@FindBy(xpath = "//DIV[@id=\"tool_bar_buttons\"]/TABLE/TBODY/TR/TD[normalize-space()=\"Page Down\"]")
	public WebElement pageDown1;
	
	@FindBy(xpath = "//span[text()='Pallet:']/..//input")
	public WebElement palletIDTxt;
	@FindBy(xpath = "//div[@class='error']")
	public WebElement errorOrWarningMsg;
	@FindBy(xpath = "//span[text()='Accpt/Proceed']")
	public WebElement acceptAndProceedBtn;
	
	@FindBy(xpath = "//div[@class='caption']")
	public WebElement captionMsg;
	
	@FindBy(id ="dataForm:invTypeInp")
	public WebElement InvType;
	
	@FindBy(id ="dataForm:sidzeInpPart0")
	public WebElement mm;
	@FindBy(id ="dataForm:sidzeInpPart2")
	public WebElement dd;
	@FindBy(id ="dataForm:sidzeInpPart4")
	public WebElement yyyy;
	
	//*[@id="mnbtn_dataForm:menuList:5:menubut1"]	
	@FindBy(xpath = "//a[text()='Recv iLPN ASN']")
	public WebElement rfRecviLPNASN;
	
	//@FindBy(xpath="//TR/TD/TABLE/TBODY/TR/TD/A[normalize-space()=\"MM3 Recv-CASE\"]")
	@FindBy(xpath = "//a[text()='MM3 Recv-CASE']")
	public WebElement MM3Rec;
	
	@FindBy(xpath = "//a[text()='QSC Recv BpStgD']")
	public WebElement BpStgD;
	
	@FindBy(xpath = "//span[text()='Container:']/..//input")
	public WebElement rfRecviLPNASNContainer;

	public String receiveMenu = "//a[text()='<RECEIVE_MENU>']";

	@FindBy(xpath = "//a[text()='RF - CC Res User']")
	public WebElement rfCycleCountResrv;
	

	@FindBy(xpath="//span[text()='Continue Count']")
	public WebElement CountiuneCounttxtbox;
	
	@FindBy(xpath="//span[@value='Accpt/Proceed']")
	public WebElement acceptProceedButton;
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:field2value1']")
	public WebElement report_Name_Field;
	
	@FindBy(xpath="//input[@name='dataForm:listView:filterId:filterIdapply']")
	public WebElement applyButton;
	
	@FindBy(xpath="//input[@id='checkAll_c0_dataForm:listView:dataTable']")
	public WebElement checkBox;
	
	@FindBy(xpath="//input[@value='Run Now']")
	public WebElement runNow;
	
	@FindBy(xpath="//input[@id='dataForm:REPORT_TEXT_ITEM0']")
	public WebElement wareHouse;
	
	@FindBy(xpath="//input[@id='dataForm:REPORT_TEXT_ITEM1']")
	public WebElement poOrder;
	
	@FindBy(xpath="//input[@id='dataForm:REPORT_TEXT_ITEM2']")
	public WebElement doOrder;
	
	@FindBy(xpath="//input[@id='dataForm:REPORT_TEXT_ITEM3']")
	public WebElement oLPNNumber;
	
	@FindBy(xpath="//input[@id='dataForm:processSchdButton1']")
	public WebElement runButton;
	
	@FindBy(xpath="//input[@id='dataForm:dt_b2']")
	public WebElement pickerIdBox;
	
	@FindBy(xpath="//span[@id='rfbtn_dataForm:SCEAcceptKey']")
	public WebElement pickerAcceptButton;
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:field10value1']")
	public WebElement oLPNField;
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:filterIdapply']")
	public WebElement applyButtonOlpn;
	
	@FindBy(xpath="//input[@id='checkAll_c0_dataForm:listView:dataTable']")
	public WebElement checkBoxOLPN;
	
	@FindBy(xpath="//input[@id='LPNListOutboundMain_commandbutton_view']")
	public WebElement viewButtonOlpn;

	@FindBy(xpath="//span[text()='Dest Stagin Locn:']")
	public WebElement destStagingLocn;
	@FindBy(xpath="//span[text()='Dest Stagin Locn:']//following::input[1]")
	public WebElement destStagingLocnInput;
	
	
	
	public WebElement getReceivingMenu(String menu) {
		String rfMenu = receiveMenu.replace("<RECEIVE_MENU>", menu);
		WebElement rfMenuElement = driver.findElement(By.xpath(rfMenu));
		return rfMenuElement;
	}

	@FindBy(xpath = "//a[contains(text(),'Ptwy By Plt')]")
	public WebElement putAwayByPit;
	
	@FindBy(xpath = "//a[text()='Ptwy iLPN - Manual']")
	public WebElement PtwyiLPNManual;
	
	@FindBy(xpath = "//input[@id='subLocationEntryUserDirected_Input']")
	public WebElement UserDirectedLocationLabel;
	
	@FindBy(xpath = "//span[text()='LPN:']/..//input")
	//@FindBy(xpath = "//input[@id='containerEntryUserDirected']")
	//input[@id="containerEntryUserDirected"]
	public WebElement lpnTxt;

	@FindBy(xpath = "(//div[contains(text(),'loc')])[1]")
	public WebElement suggestedLocLabel;

	@FindBy(xpath = "//input[@id='subLocationEntry_Input']")
	public WebElement locationInput;

	@FindBy(xpath = "//span[@value='Chg Task Grp']")
	public  WebElement ChgTaskGroupBtn;

	@FindBy(xpath = "//input[@id='dataForm:taskGrp']")
	public  WebElement taskGroupInputField;

	@FindBy(xpath = "//input[@id='location_Input']")
	public  WebElement Locn_field;
	@FindBy(xpath = "//span[@value='Enter']")
	public  WebElement enterBtn;
	@FindBy(xpath = "//input[@id='dataForm:TaskType']")
	public  WebElement taskType_Field;

	@FindBy(xpath = "//span[text()='Enter']")
	public WebElement changeTaskGroupEnter;

	@FindBy(xpath = "//input[@id='dataForm:INT']")
	public  WebElement INT_field;

	@FindBy(xpath = "//a[text()='Receiving']")
	public  WebElement rfMenuReceiving;

	@FindBy(xpath = "//a[text()='Putaway']")
	public WebElement rfMenuPutaway;

	@FindBy(xpath = "//a[text()='Recv By ASN']")
	public WebElement rfRecvByASN;

	@FindBy(xpath = "//a[contains(text(),'Ptwy iLPN')]")
	public WebElement putAwayILPN;
	
	@FindBy(xpath = "//a[text()='Inventory']")
	public WebElement inventoryMgmtMenu;
	
	@FindBy(xpath="//a[text()='Outbound']")
	public WebElement outboundoption;
	
	@FindBy(xpath="//a[text()='Audit n Print']")
	public WebElement Auditnprintoption;
	
	@FindBy(xpath="//a[text()='Audit oLPN']")
	public WebElement AuditoLPNoption;
	
	@FindBy(xpath="//input[@id='cartonNbrInput']")
	public WebElement oLPNinputtxtbx;
	
	@FindBy(xpath="//input[@id='skuBrcd']")
	public WebElement skuBrcdinputtxtbx;
	
	@FindBy(xpath="//input[@id='input1qtyInput']")
	public WebElement skuqty;
	
	
	@FindBy(xpath="//span[@value='End oLPN']")
	public WebElement EndoLPN;
	
	
	
	@FindBy(xpath = "//a[text()='RF-Create iLPN']")
	public WebElement rfCreateIlpnMenu;
	
	@FindBy(xpath = "//input[@id='barcode']")
	public WebElement ilpnInRFcreateilpnTxtBox;
	
	@FindBy(xpath = "//input[@id='barcode2Brcd']")
	public WebElement itemBarcodeInRFcreateIlpnTxtBox;
	
	@FindBy(xpath = "//span[text()='Lot:']/..//input")
	public WebElement lotInRFcreateIlpnTxtBox;
	
	@FindBy(xpath="//input[@id='dataForm:prodStatus']")
	public WebElement productStatusTxtBox;
	
	@FindBy(xpath = "//input[@id='dataForm:invnType']")
	public WebElement inventoryTypeInRFcreateIlpnTxtBox;
	
	@FindBy(xpath = "//input[@id='input1qtypack1']")
	public WebElement qtyPackedInRFcreateIlpnTxtBox;
	
	@FindBy(xpath = "//a[text()='RF-Pck iLPN Frm CP']")
	public WebElement packiLpnFrmCP;
	
	@FindBy(xpath = "//input[@id='locn1_Input' and @type='text']")
	public WebElement clocBox;
	
	@FindBy(xpath = "//a[text()='Split Move iLPN']")
	public WebElement splitMoveiLPN;
	
	@FindBy(xpath = "//input[@id='barcode2']")
	public WebElement ilpnInRFmoveilpnTxtBox;
	
	@FindBy(xpath = "//input[@id='input1qty2']")
	public WebElement moveQty;
	
	@FindBy(xpath = "//a[text()='RF - Merge iLPN']")
	public WebElement rfMergeIlpnMenu;
	
	@FindBy(xpath = "//span[text()='Move To LPN :']/following::input[1]")
	public WebElement moveToLPNinMergeilpnTxtBox;
	
	@FindBy(xpath = "//input[@id='dataForm:lpnSizeTypeVal']")
	public WebElement lpnSizeType;
	
	@FindBy(xpath = "//a[contains(text(),'Fill Actv')]")
	public WebElement rfPutawayFillActive;
	
	@FindBy(xpath = "//span[text()='Quantity:']/../..//input")
	public WebElement rfPutawayFillActiveQty;
	
	@FindBy(xpath = "//input[@id='sublocn1_Input']")
	public WebElement rfPutawayFillActiveAloc;
	
	@FindBy(xpath = "//input[@id='subLocationEntryUserDirected_Input']")
	public WebElement locationInputUserDirected;
	
	@FindBy(xpath = "//a[text()='RF - Lock iLPN']")
	public WebElement rfLockiLPN;
	
   @FindBy(xpath = "//span[text()='Lock Code:']/following::input[1]")
	public WebElement LockCode;
   
   @FindBy(xpath = "//span[text()='iLPN:']/following::input[1]")
	public WebElement iLPNTextBox;
   
	@FindBy(xpath = "//a[text()='Fill Case Pick']")
	public WebElement rfPutawayFillCasePick;
	
	@FindBy(xpath = "//input[@id='sublocn1_Input']")
	public WebElement rfPutawayFillCasePickLocation;
	
	@FindBy(xpath = "//a[text()='RF-UnLock iLPN']")
	public WebElement rfUnLockiLPN;
	
	@FindBy(xpath = "//*[contains(text(),'No data found')]")
	public WebElement Nolockcodeavbl;
	

	@FindBy(xpath = "//div[@id='dataForm:ifNotSuggestedMode']")
	public WebElement altsuggestedLocLabel;
	
	@FindBy(xpath = "//input[@id='dataForm:qhinpid']")
	public WebElement RFPtwyAltLockCode;
	
	@FindBy(xpath = "//span[@value='Enter Task']")
	public  WebElement enterTaskBtn;
	
	@FindBy(xpath = "//input[@id='dataForm:input1']")
	public  WebElement taskInputField;
	
	@FindBy(xpath = "//input[@id='locn_Input']")
	public  WebElement RlocField;
	
	@FindBy(xpath = "//input[@id='dataForm:q1ty2']")
	public  WebElement numbersOfLPNField;

	@FindBy(xpath = "//input[@id='locn_Input']")
	public WebElement rfResvLocationInputtxtbx;
		
	@FindBy(xpath = "//span[text()='Number of LPNs:']//following::input[1]")
	public WebElement rfNumOfLPNSInputtxtbox;
	
	@FindBy(xpath = "//*[contains(text(),'Aloc:')]//following::input[@id='locn_Input']")
	public WebElement RFAloc;
	
	@FindBy(xpath = "//*[contains(text(),'Item Barcode:')]//following::input[@id='itemIdBrcd']")
	public WebElement RFItem;
	
	@FindBy(xpath = "//span[@id='rfbtn_dataForm:b5']")
	public WebElement endLocation;
	
	@FindBy(xpath = "//*[contains(text(),'Qty:')]//following::input[@id='input1qty2']")
	public WebElement qtyInputBx;
	
	@FindBy(xpath="//*[contains(text(),'Number of LPNs:')]//following::input[@id='dataForm:q1ty2']")
	public WebElement NumofLPNsInputtxtbx;
	
	@FindBy(xpath = "//input[@id='dataForm:qhinpid']")
	public WebElement RFPtwyAltLockCode1;
	@FindBy(xpath="//a[contains(text(),'Pltz iLPNs')]")
	public WebElement palletizeiLPN;
	@FindBy(xpath="//input[@id='barcode']")
	public WebElement palletizeILpnInput;
	@FindBy(xpath="//input[@id='barcode5']")
	public WebElement palletizeiLPN_iLPN_Input;
	
	@FindBy(xpath = "//input[@id='containerEntry']")
	public WebElement altiLPNBoxafterputaway;
	
	@FindBy(xpath = "//a[text()='RF- CC Act User']")
	public WebElement rfCycleCountAct;
	@FindBy(xpath="//input[@id='test1']")
	public WebElement RFFillActvInput;
	@FindBy(xpath="//span[@value='Exit']") public WebElement ExitBtn;
	@FindBy(xpath="//input[@id='tb_567']")public WebElement valueBtn;
	@FindBy(xpath="//input[@id='itemIdBrcd']")  public WebElement itemBarcode_CC_Complete;
	@FindBy(xpath="//input[@id='input1qty20']") public WebElement qty_textBox_RCT;
	@FindBy(xpath="//span[.='Next/End Locn']") public WebElement NextEntLocationBtn;
	@FindBy(xpath="//span[text()='End Pallet']") public WebElement EndPallet;
	
	
	@FindBy(xpath = "//input[@id='barcode1']") public WebElement ilpnInRFCCreserveilpnTxtBox;
	@FindBy(xpath = "//a[text()='Outbound']") public WebElement rfOutboundMenu;
	@FindBy(xpath = "//a[text()='Pick Pack']") public WebElement rfPickPackOption;
	@FindBy(xpath = "//a[text()='RF Make Pk Tote Cart']") public WebElement rfmanPkToteOption;
	@FindBy(xpath = "//*[@id='barcode2']") public WebElement rfmanpickcart;
	@FindBy(xpath = "//*[@id='barcode']") public WebElement rfmanoLPN;
	@FindBy(xpath = "//*[@id='dataForm:SlotNbr']") public WebElement rfmanSlot;
	@FindBy(xpath = "//*[@id='tool_bar_buttons']/table/tbody/tr/td[1]") public WebElement rfmanExit;
	@FindBy(xpath = "//a[text()='RF Pck Pick Cart']") public WebElement rfmanPickPackCartOption;
	@FindBy(xpath = "//*[@id='barcode']") public WebElement rfmanpickcartno;
	@FindBy(xpath = "//span[text()='End Pick Cart']") public WebElement EndPickCart;
	@FindBy(xpath = "//span[text()='Accpt/Proceed']") public WebElement manacp_pro_btn;
	@FindBy(xpath = "//input[@name='itemId2Brcd']") public WebElement rfmanItemBarcodeInputBx;
	@FindBy(xpath = "//*[@id='barcode1']") public WebElement rfman_oLPN;
	@FindBy(xpath = "//*[@id='tb_567']") public WebElement rfmaninfo;
	@FindBy(xpath = "//a[text()='Shipping']") public WebElement rfShipping;
	@FindBy(xpath = "//a[text()='RF Close Trailer']") public WebElement rfclose_trailer;
	@FindBy(xpath = "//*[@id='barcode20']") public WebElement rfclose_trailer_Shipment;
	@FindBy(xpath = "//*[@id='barcode13']") public WebElement rfclose_trailer_DD;
	@FindBy(xpath = "//*[@id='barcode32']") public WebElement rfclose_trailer_BOL;
	@FindBy(xpath = "//span[text()='Accpt/Proceed']") public WebElement rfclose_acp_pro_btn;
	
	
	@FindBy(xpath = "//a[text()='RF Load oLPN']") public WebElement rfLoad_oLPN;
	@FindBy(xpath = "//input[@name='barcode1']") public WebElement rfLoad_oLPN_Num;
	@FindBy(xpath = "//span[text()='Accpt/Proceed']") public WebElement rfLoad_acp_pro_btn;
	
	
	
	@FindBy(xpath = "//a[text()='RF Anchor oLPN']") public WebElement rfAnchor_oLPN;
	@FindBy(xpath = "//input[@name='barcode1']") public WebElement rfAnchor_oLPN_no;
	@FindBy(xpath = "//input[@name='sublocn31c_Input']") public WebElement rfAnchor_Locn;
	@FindBy(xpath = "//a[text()='RF Locate oLPN']") public WebElement rfLocate_oLPN;
	@FindBy(xpath = "//input[@name='OBcontainerEntryUserDirectedLPN']") public WebElement rfLocate_oLPN_num;
	@FindBy(xpath = "//input[@name='subLocationEntryUserDirected18_Input']") public WebElement rfLocate_Locn;
	
	
	
	
	@FindBy(xpath = "//a[text()='Pck Cubed Dir - Parcel']")
	public WebElement rfPckCubedDirParcelOption;
	@FindBy(xpath="//span[text()='oLPN:']//following-sibling::input")
	public WebElement oLPNtxtbox;
	@FindBy(xpath="//input[@id='itemIdBrcd']")
	public WebElement oLPNItemBarCode;
	@FindBy(xpath="//input[@id='input1qty2']")
	public WebElement oLPNItemQty;
	@FindBy(xpath = "//div[@class='error']")
	public WebElement error;
	@FindBy(xpath = "//span[text()='Accpt/Proceed']")
	public WebElement Accept_Proceed_btn;
	@FindBy(xpath="(//span[text()='Qty:'])[1]/ancestor::div[position()=2]")
	public WebElement displayedQtyOLPN;
	@FindBy(xpath="//span[text()='Srl Nbr:']//following::input[1]")
	public WebElement serialNumbersInput;
	@FindBy(xpath="//input[@id='barcode2']")
	public WebElement serialNumberInputParcel;
	@FindBy(xpath="//a[text()='RF-Pck iLPN Frm Actv']")
	public WebElement RF_Pck_iLPN_Frm_Actv;
	@FindBy(xpath="//input[@id='locn1_Input']")
	public WebElement AlocInput;
	@FindBy(xpath="//input[@id='input1qtypack2']")
	public WebElement qtyInput;
	
	@FindBy(xpath = "(//div[contains(text(),'Aloc')])[2]")
	public WebElement suggestedLocLabelFillAct;
	@FindBy(xpath="//span[text()='Minor Srl Nbr:']//following::input[1]")
	public WebElement minorSerialNumberInput;
	@FindBy(xpath="//span[@value='End Entry']")
	public WebElement minorSerialNumEndEntry;
	@FindBy(xpath = "//input[@id='case2']")
	public WebElement fromLPNInputBox;
	@FindBy(xpath = "//input[@id='dataForm:rsn2']")
	public WebElement reasonCodeTxtBox;
	@FindBy(xpath = "//input[@id='dataForm:ref2']")
	public WebElement referenceCodeTxtBox;
	@FindBy(xpath = "//span[@value='Toggle']")
	public WebElement toggleBtn;
	@FindBy(xpath = "//div[text()='Item Components:']")
	public WebElement itemComponentsTxt;
	@FindBy(xpath = "//input[@id='barcode2ItemName']")
	public WebElement itemInputBx;
	@FindBy(xpath = "//span[text()='Toggle Locn']")
	public WebElement toggleLocBtn;
	@FindBy(xpath = "//a[text()='Misc']")
	public WebElement miscOption;
	@FindBy(xpath = "//a[text()='FILA']")
	public WebElement filaProduction;
	@FindBy(xpath = "//span[text()='Quantity:']//following::input[1]")
	public WebElement filaQty;
	@FindBy(xpath = "//a[text()='Pck Cubed Dir-Bulk n TL/LTL']")
	public WebElement pckCubedDirBulknTLLTL;
	@FindBy(xpath = "//span[text()='Picker ID:']/following::input[1]")
	public WebElement pickerId;
	@FindBy(xpath = "dataForm:EnterLPNNumber")
	public WebElement oLPNinput;
	@FindBy(xpath="//span[@id='dataForm:EnterlpnNumberPanelGroup']")
	public WebElement olpnInput;
	@FindBy(xpath="//select[@id='dataForm:shipviaList']")
	public WebElement shipViaOptions;
	@FindBy(xpath="//input[@id='dataForm:inputText1']")
	public WebElement outQ;
	@FindBy(xpath="//input[@id='dataForm:declaredValue']")
	public WebElement declaredValue;
	@FindBy(xpath="//input[@value='Manifest >']")
	public WebElement ManifestBtn;	
	@FindBy(xpath="//a[@id='mnbtn_dataForm:menuList:3:menubut1']")
	public WebElement PackCubedParcel;
	@FindBy(xpath="//span[text()='OutQ:']")
	public WebElement outQPrinter;
	
	@FindBy(xpath="//span[text()='Pallet:']//following::input[1]")
	public WebElement anchorPalletID;
	@FindBy(xpath="//input[@id='sublocn3556_Input']")
	public WebElement anchorLocn;
	
	
	
	
		
	public void ASNReceivingProcess(int noOfItems, String receivingMethod, String recLocation) throws Throwable {
		String iLPN = null;
		String fututeDate = SeleniumTestHelper.user_generate_estimated_delivery_date(365);
		String[] futureDateAsArray = fututeDate.split("-");
		System.out.println(futureDateAsArray[0]);
		System.out.println(futureDateAsArray[1]);
		System.out.println(futureDateAsArray[2]);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
		RFmenu_info.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 50);
		Mainmenu.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfMenuReceiving, 50);
		rfMenuReceiving.click();
		switch (receivingMethod) {
		case "Recv Item Lvl":
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			while (!(SeleniumTestHelper.isElementDisplayed(RF_Recv_Iten_lvl))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(RF_Recv_Iten_lvl.isDisplayed());
			RF_Recv_Iten_lvl.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
			inputASN.sendKeys(Items.getAsnNumber());
			SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
			inputASN.sendKeys(Keys.ENTER);
			
			if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(),true);
				destStagingLocnInput.sendKeys("ABC01001D01"+Keys.ENTER);	
			}			
			
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, palletIDTxt, 50);
			if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
				SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
				acceptAndProceedBtn.click();
			}
			int itemShippedQty = 0;
			for (int i = 0; i < noOfItems; i++) {
				palletIDTxt.sendKeys(Items.getItemPalletID(Items.getItemsForReceivingASN(i)));
				SeleniumTestHelper.assertTrue(palletIDTxt.isDisplayed());
				palletIDTxt.sendKeys(Keys.ENTER);
				iLPN = Items.getItemILPN(Items.getItemsForReceivingASN(i));
				System.out.println("iLPN : " + iLPN + " for the product : " + Items.getItemsForReceivingASN(i));
				lpnInputTxt.sendKeys(iLPN);
				SeleniumTestHelper.assertTrue(lpnInputTxt.isDisplayed());
				lpnInputTxt.sendKeys(Keys.ENTER);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, ItemBarcode, 10);
				ItemBarcode.sendKeys(Items.getItemBarcode(Items.getItemsForReceivingASN(i)));
				ItemBarcode.sendKeys(Keys.ENTER);
				if (SeleniumTestHelper.isElementDisplayed(rfMenuLotInput)) {
					System.out.println("Item : " + Items.getItemsForReceivingASN(i) + " is lot controlled");
					rfMenuLotInput.sendKeys("LOT2");
					rfMenuLotInput.sendKeys(Keys.ENTER);

					if (SeleniumTestHelper.isElementDisplayed(expirydatemonthtxtbox)) {
						System.out.println("Item : " + Items.getItemsForReceivingASN(i) + " is expiry date item");
						expirydatemonthtxtbox.sendKeys(futureDateAsArray[0]);
						expirydatedatetxtbox.sendKeys(futureDateAsArray[1]);
						expirydateyeartxtbox.sendKeys(futureDateAsArray[2]);
						Thread.sleep(2000);
					}
				}

				itemShippedQty = Items.getItemWithShippedASNQty(Items.getItemsForReceivingASN(i));
				Item_qty.sendKeys(String.valueOf(itemShippedQty));
				Item_qty.sendKeys(Keys.ENTER);

				if (SeleniumTestHelper.isElementDisplayed(expirydatemonthtxtbox)) {
					System.out.println("Item : " + Items.getItemsForReceivingASN(i) + " is expiry date item");
					expirydatemonthtxtbox.sendKeys(futureDateAsArray[0]);
					expirydatedatetxtbox.sendKeys(futureDateAsArray[1]);
					expirydateyeartxtbox.sendKeys(futureDateAsArray[2]);
					Thread.sleep(2000);
				}
			}
			break;
		case "Recv iLPN ASN":
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			while (!(SeleniumTestHelper.isElementDisplayed(rfRecviLPNASN))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(rfRecviLPNASN.isDisplayed());
			rfRecviLPNASN.click();
			if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(),true);
				destStagingLocnInput.sendKeys("ABC01001D02"+Keys.ENTER);	
			}	
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfRecviLPNASNContainer, 50);
			for (int i = 0; i < noOfItems; i++) {
				iLPN = Items.getItemILPN(Items.getItemsForReceivingASN(i));
				System.out.println("iLPN : " + iLPN + " for the product : " + Items.getItemsForReceivingASN(i));
				rfRecviLPNASNContainer.sendKeys(iLPN);
				SeleniumTestHelper.assertTrue(rfRecviLPNASNContainer.isDisplayed());
				rfRecviLPNASNContainer.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfRecviLPNASNContainer, 50);
			}
			break;
		case "Recv By ASN":
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			while (!(SeleniumTestHelper.isElementDisplayed(rfRecvByASN))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(rfRecvByASN.isDisplayed());
			rfRecvByASN.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
			inputASN.sendKeys(Items.getAsnNumber());
			SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
			inputASN.sendKeys(Keys.ENTER);
			if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(),true);
				destStagingLocnInput.sendKeys("ABC01001D03"+Keys.ENTER);	
			}	
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
			System.out.println("Info :- " + errorOrWarningMsg.getText());
			SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
			acceptAndProceedBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
			for (int i = 0; i < noOfItems; i++) {
				iLPN = Items.getItemILPN(Items.getItemsForReceivingASN(i));
				System.out.println("iLPN : " + iLPN + " for the product : " + Items.getItemsForReceivingASN(i));
			}
			break;
		case "MM3 Recv-CASE":
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			
			while (!(SeleniumTestHelper.isElementDisplayed(MM3Rec))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(MM3Rec.isDisplayed());
			MM3Rec.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
			inputASN.sendKeys(Xpathxml.ASNNumber);
			SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
			inputASN.sendKeys(Keys.ENTER);
			if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(),true);
				destStagingLocnInput.sendKeys(recLocation+Keys.ENTER);	
			}	
			lpnInputTxt.sendKeys(Keys.ENTER);	
			ItemBarcode.sendKeys(Items.getItemsForReceivingASN(0)+Keys.ENTER);
			InvType.sendKeys(Keys.ENTER);
			Item_qty.sendKeys(String.valueOf(Items.getItemWithShippedASNQty(Items.getItemsForReceivingASN(0)))+Keys.ENTER);
			mm.sendKeys("07");
			dd.sendKeys("31");
			yyyy.sendKeys("2020");
			acceptAndProceedBtn.click();
			/*	SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
			System.out.println("Info :- " + errorOrWarningMsg.getText());
			SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
			acceptAndProceedBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
		
			 * for (int i = 0; i < noOfItems; i++) { iLPN =
			 * Items.getItemILPN(Items.getItemsForReceivingASN(i));
			 * System.out.println("iLPN : " + iLPN + " for the product : " +
			 * Items.getItemsForReceivingASN(i)); }
			 */
			break;
		default:
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			break;
		}
		System.out.println("Receiving process completed with : " + receivingMethod + " menu");
		homepage.userClosesOpenedwindow("RF Menu");
	}





	public void ASNReceivingProcess(String receivingMethod) throws InterruptedException {
		try {
		String iLPN = null;
		Steps.logger.info("Start Receiving Process");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
		Thread.sleep(1000);
		RFmenu_info.click();
		Steps.logger.info("CLicked on RF Menu");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
		Thread.sleep(1000);
		Mainmenu.click();
		Steps.logger.info("Clicked on Main Menu");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfMenuReceiving, 20);
		Thread.sleep(1000);
		rfMenuReceiving.click();
		Steps.logger.info("Clicked on Receiving");
		switch (receivingMethod) {
		case "Recv Item Lvl":
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			while (!(SeleniumTestHelper.isElementDisplayed(RF_Recv_Iten_lvl))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(RF_Recv_Iten_lvl.isDisplayed());
			RF_Recv_Iten_lvl.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
			inputASN.sendKeys(Items.getAsnNumber());
			SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
			inputASN.sendKeys(Keys.ENTER);
			
			if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(),true);
				destStagingLocnInput.sendKeys("ABC01001D01"+Keys.ENTER);	
			}			
			
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, palletIDTxt, 50);
			if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
				SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
				acceptAndProceedBtn.click();
			}
			int itemShippedQty = 0;
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				palletIDTxt.sendKeys(Items.getItemPalletID(Items.getItemsForReceivingASN(i)));
				SeleniumTestHelper.assertTrue(palletIDTxt.isDisplayed());
				palletIDTxt.sendKeys(Keys.ENTER);
				iLPN = Items.getItemILPN(Items.getItemsForReceivingASN(i));
				System.out.println("iLPN : " + iLPN + " for the product : " + Items.getItemsForReceivingASN(i));
				lpnInputTxt.sendKeys(iLPN);
				SeleniumTestHelper.assertTrue(lpnInputTxt.isDisplayed());
				lpnInputTxt.sendKeys(Keys.ENTER);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, ItemBarcode, 10);
				ItemBarcode.sendKeys(Items.getItemBarcode(Items.getItemsForReceivingASN(i)));
				ItemBarcode.sendKeys(Keys.ENTER);
				if (SeleniumTestHelper.isElementDisplayed(rfMenuLotInput)) {
					System.out.println("Item : " + Items.getItemsForReceivingASN(i) + " is lot controlled");
					rfMenuLotInput.sendKeys("LOT2");
					rfMenuLotInput.sendKeys(Keys.ENTER);
					/*
					 * if (SeleniumTestHelper.isElementDisplayed(expirydatemonthtxtbox)) {
					 * System.out.println("Item : " + Items.getItemsForReceivingASN(i) +
					 * " is expiry date item");
					 * expirydatemonthtxtbox.sendKeys(futureDateAsArray[0]);
					 * expirydatedatetxtbox.sendKeys(futureDateAsArray[1]);
					 * expirydateyeartxtbox.sendKeys(futureDateAsArray[2]); Thread.sleep(2000); }
					 */
				}

				itemShippedQty = Items.getItemWithShippedASNQty(Items.getItemsForReceivingASN(i));
				Item_qty.sendKeys(String.valueOf(itemShippedQty));
				Item_qty.sendKeys(Keys.ENTER);

				/*
				 * if (SeleniumTestHelper.isElementDisplayed(expirydatemonthtxtbox)) {
				 * System.out.println("Item : " + Items.getItemsForReceivingASN(i) +
				 * " is expiry date item");
				 * expirydatemonthtxtbox.sendKeys(futureDateAsArray[0]);
				 * expirydatedatetxtbox.sendKeys(futureDateAsArray[1]);
				 * expirydateyeartxtbox.sendKeys(futureDateAsArray[2]); Thread.sleep(2000); }
				 */
			}
			break;
		case "Recv iLPN ASN":
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			while (!(SeleniumTestHelper.isElementDisplayed(rfRecviLPNASN))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(rfRecviLPNASN.isDisplayed());
			rfRecviLPNASN.click();
			if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(),true);
				destStagingLocnInput.sendKeys("ABC01001D02"+Keys.ENTER);	
			}	
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfRecviLPNASNContainer, 50);
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				iLPN = Items.getItemILPN(Items.getItemsForReceivingASN(i));
				System.out.println("iLPN : " + iLPN + " for the product : " + Items.getItemsForReceivingASN(i));
				rfRecviLPNASNContainer.sendKeys(iLPN);
				SeleniumTestHelper.assertTrue(rfRecviLPNASNContainer.isDisplayed());
				rfRecviLPNASNContainer.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfRecviLPNASNContainer, 50);
			}
			break;
		case "Recv By ASN":
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			while (!(SeleniumTestHelper.isElementDisplayed(rfRecvByASN))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(rfRecvByASN.isDisplayed());
			rfRecvByASN.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
			inputASN.sendKeys(Items.getAsnNumber());
			SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
			inputASN.sendKeys(Keys.ENTER);
			if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(),true);
				destStagingLocnInput.sendKeys("ABC01001D03"+Keys.ENTER);	
			}	
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
			System.out.println("Info :- " + errorOrWarningMsg.getText());
			SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
			acceptAndProceedBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				iLPN = Items.getItemILPN(Items.getItemsForReceivingASN(i));
				System.out.println("iLPN : " + iLPN + " for the product : " + Items.getItemsForReceivingASN(i));
			}
			break;
		case "MM3 Recv-CASE":
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			Steps.logger.info("Receiving process starting with : " + receivingMethod + " menu");
			Thread.sleep(10000);
			while (!(SeleniumTestHelper.isElementDisplayed(MM3Rec))) {
				pageDown.click();
				Thread.sleep(5000);
			}
			SeleniumTestHelper.assertTrue(MM3Rec.isDisplayed());
			MM3Rec.click();
			Steps.logger.info("Click on " + receivingMethod + " method");
			Thread.sleep(5000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
			inputASN.sendKeys(Items.getAsnNumber());
			Steps.logger.info("Enter ASN number: "+Items.getAsnNumber());
			SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
			inputASN.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			for (int i = 0,j=1; i < Steps.ItemDataMap.size(); i++,j++) {
				if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
					SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(),true);
					
					//System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
					//destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);	
					System.out.println("Rec Location-"+Steps.ItemDataMap.get(i).get("RecLocation"));
					Steps.logger.info("Enter Rec Location-"+Steps.ItemDataMap.get(i).get("RecLocation"));
					destStagingLocnInput.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation"))+Keys.ENTER);	
				}	
				Thread.sleep(2000);
				lpnInputTxt.sendKeys(Keys.ENTER);	
			//	for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					Thread.sleep(3000);
				String LPNs = 	driver.findElement(By.id("csid")).getText();
				String[] LPNnum = LPNs.split(":");
				System.out.println("LPN# :"+ LPNnum[1].trim());	
				
				iLPNz.add(LPNnum[1].trim());
				System.out.println("LPN "+j+" : "+iLPNz.get(i));
				Reporter.addStepLog("LPN "+j+" : "+iLPNz.get(i));
				Thread.sleep(3000);
				ItemBarcode.sendKeys(Items.getItemsForReceivingASN(i)+Keys.ENTER);
				Steps.logger.info("Enter Item Id: "+Items.getItemsForReceivingASN(0));
				Thread.sleep(3000);
				InvType.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty"))+Keys.ENTER);
				Steps.logger.info("Enter Qty: "+String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
				Thread.sleep(3000);
				
				
				if(SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
				System.out.println("Info :- " + errorOrWarningMsg.getText());
				globalFunc.Screenshots.seleniumSnapshot(driver);
				Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") +"\\resources\\Screenshots\\" + DateTime.strDate3 + ".jpeg");
				acceptAndProceedBtn.click();
				
				
				//Assert.fail("Info :- " + errorOrWarningMsg.getText());
				break;
				}
				Thread.sleep(3000);
				String fututeDate = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
				Steps.logger.info("Enter fututeDate: "+fututeDate);
				String[] futureDateAsArray = fututeDate.split("-");
			//	fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
				mm.sendKeys(futureDateAsArray[0]);
				dd.sendKeys(futureDateAsArray[1]);
				yyyy.sendKeys(futureDateAsArray[2]);
				Thread.sleep(3000);
				
				acceptAndProceedBtn.click();
				Steps.logger.info(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty"))+" qty is received in LPN "+iLPNz.get(i)+" for Item- "+Items.getItemsForReceivingASN(i));
				Reporter.addStepLog(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty"))+" qty is received in LPN "+iLPNz.get(i)+" for Item- "+Items.getItemsForReceivingASN(i));
				if(Steps.ItemDataMap.get(i).get("RecQty2")!="") {
					if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
						SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(),true);
						
						//System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
						//destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);	
						System.out.println("Rec Location-"+Steps.ItemDataMap.get(i).get("RecLocation"));
						Steps.logger.info("Enter Rec Location-"+Steps.ItemDataMap.get(i).get("RecLocation"));
						destStagingLocnInput.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation"))+Keys.ENTER);	
					}	
					Thread.sleep(2000);
					lpnInputTxt.sendKeys(Keys.ENTER);	
				//	for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
						Thread.sleep(3000);
					String LPNs1 = 	driver.findElement(By.id("csid")).getText();
					String[] LPNnum1 = LPNs1.split(":");
					System.out.println("LPN# :"+ LPNnum1[1].trim());	
					
					iLPNz.add(LPNnum1[1].trim());
					System.out.println("LPN 2 : "+LPNnum1[1].trim());
					Reporter.addStepLog("LPN 2 : "+LPNnum1[1].trim());
					Thread.sleep(3000);
					ItemBarcode.sendKeys(Items.getItemsForReceivingASN(i)+Keys.ENTER);
					Steps.logger.info("Enter Item Id: "+Items.getItemsForReceivingASN(0));
					Thread.sleep(3000);
					InvType.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2"))+Keys.ENTER);
					Steps.logger.info("Enter Qty: "+String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")));
					Thread.sleep(3000);
					
					
					if(SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
					System.out.println("Info :- " + errorOrWarningMsg.getText());
					globalFunc.Screenshots.seleniumSnapshot(driver);
					Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") +"\\resources\\Screenshots\\" + DateTime.strDate3 + ".jpeg");
					acceptAndProceedBtn.click();
					
					
					//Assert.fail("Info :- " + errorOrWarningMsg.getText());
					break;
					}
					Thread.sleep(3000);
					String fututeDate1 = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					Steps.logger.info("Enter fututeDate: "+fututeDate1);
					String[] futureDateAsArray1 = fututeDate1.split("-");
				//	fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					mm.sendKeys(futureDateAsArray1[0]);
					dd.sendKeys(futureDateAsArray1[1]);
					yyyy.sendKeys(futureDateAsArray1[2]);
					Thread.sleep(3000);
					
					acceptAndProceedBtn.click();
					Steps.logger.info(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2"))+" qty is received in LPN "+LPNnum1[1].trim()+" for Item- "+Items.getItemsForReceivingASN(i));
					Reporter.addStepLog(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2"))+" qty is received in LPN "+LPNnum1[1].trim()+" for Item- "+Items.getItemsForReceivingASN(i));
					
				}
			}
			Steps.logger.info("Completed Receiving");
			/*	SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
			System.out.println("Info :- " + errorOrWarningMsg.getText());
			SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
			acceptAndProceedBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
		
			 * for (int i = 0; i < noOfItems; i++) { iLPN =
			 * Items.getItemILPN(Items.getItemsForReceivingASN(i));
			 * System.out.println("iLPN : " + iLPN + " for the product : " +
			 * Items.getItemsForReceivingASN(i)); }
			 */
			break;
			
		case "QSC Recv BpStgD":
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			Steps.logger.info("Receiving process starting with : " + receivingMethod + " menu");
			Thread.sleep(10000);
			while (!(SeleniumTestHelper.isElementDisplayed(BpStgD))) {
				pageDown.click();
				Thread.sleep(10000);
			}
			SeleniumTestHelper.assertTrue(BpStgD.isDisplayed());
			BpStgD.click();
			Steps.logger.info("Click on " + receivingMethod + " method");
			Thread.sleep(10000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
			inputASN.sendKeys(Items.getAsnNumber());
			Steps.logger.info("Enter ASN number: "+Items.getAsnNumber());
			SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
			inputASN.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
					SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(),true);
					
					//System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
					//destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);	
					System.out.println("Rec Location-"+Steps.ItemDataMap.get(i).get("RecLocation"));
					Steps.logger.info("Enter Rec Location-"+Steps.ItemDataMap.get(i).get("RecLocation"));
					destStagingLocnInput.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation"))+Keys.ENTER);	
				}	
				Thread.sleep(2000);
				lpnInputTxt.sendKeys(Keys.ENTER);	
			//	for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				Thread.sleep(3000);
				ItemBarcode.sendKeys(Items.getItemsForReceivingASN(i)+Keys.ENTER);	
				Steps.logger.info("Enter Item Id: "+Items.getItemsForReceivingASN(0));
				Thread.sleep(3000);
				InvType.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty"))+Keys.ENTER);
				Steps.logger.info("Enter Qty: "+String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
				Thread.sleep(3000);
				String fututeDate = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
				Steps.logger.info("Enter fututeDate: "+fututeDate);
				String[] futureDateAsArray = fututeDate.split("-");
			//	fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
				mm.sendKeys(futureDateAsArray[0]);
				dd.sendKeys(futureDateAsArray[1]);
				yyyy.sendKeys(futureDateAsArray[2]);
				Thread.sleep(5000);
				
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
				System.out.println("Info :- " + errorOrWarningMsg.getText());
				
				String errorOrWarningMsgs = errorOrWarningMsg.getText();
				String[] errorOrWarningMsgs1 =  errorOrWarningMsgs.split(" ");
				
				
				
				System.out.println("LPN is: "+errorOrWarningMsgs1[1]);
				LPNVal = errorOrWarningMsgs1[1];
				Thread.sleep(5000);
				acceptAndProceedBtn.click();
				Thread.sleep(5000);
				String sysSuggestedLoc = altsuggestedLocLabel.getText();
				String[] sysSuggestedLocSplit =  sysSuggestedLoc.split(" ");
				newSysSuggestedLoc= sysSuggestedLocSplit[1];
				String[] spltarr = sysSuggestedLocSplit[1].split("-");
				String str =GlobalClass.removeZero(spltarr[1]);
				System.out.println(str);
				spltarr[1] =str;
				String updtLoc = "";
				 for (String a : spltarr) 
					 updtLoc= updtLoc+a;
					 
					 
				 System.out.println("updtLoc is: "+updtLoc);
				
				locationInput.sendKeys(updtLoc+Keys.ENTER);
				//Reporter.addStepLog(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty"))+" qty is received in LPN "+iLPNz.get(i)+" for Item- "+Items.getItemsForReceivingASN(i));
			}
			Steps.logger.info("Completed Receiving");
			/*	SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
			System.out.println("Info :- " + errorOrWarningMsg.getText());
			SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
			acceptAndProceedBtn.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
		
			 * for (int i = 0; i < noOfItems; i++) { iLPN =
			 * Items.getItemILPN(Items.getItemsForReceivingASN(i));
			 * System.out.println("iLPN : " + iLPN + " for the product : " +
			 * Items.getItemsForReceivingASN(i)); }
			 */
			break;
			
		default:
			System.out.println("Receiving process starting with : " + receivingMethod + " menu");
			break;
		}
		System.out.println("Receiving process completed with : " + receivingMethod + " menu");
		homepage.userClosesOpenedwindow("RF Menu");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red"+Steps.testRes);
			e.printStackTrace();
		}	
	}

	public void  split_Move_iLPN_for_same_Item() throws Exception{
		 
		Thread.sleep(1000);
		RFmenu_info.click();
		Steps.logger.info("CLicked on RF Menu");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
		Thread.sleep(1000);
		Mainmenu.click();
		Steps.logger.info("Clicked on Main Menu");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfMenuReceiving, 20);
		Thread.sleep(1000);
		 
		 while (!(SeleniumTestHelper.isElementDisplayed(inventoryMgmtMenu))) {
				pageDown.click();
				Thread.sleep(5000);
			}
		SeleniumTestHelper.assertTrue(inventoryMgmtMenu.isDisplayed());
		inventoryMgmtMenu.click();
		Steps.logger.info("Clicked on Inventory method");
		Thread.sleep(3000);
		 while (!(SeleniumTestHelper.isElementDisplayed(splitMoveiLPN))) {
				pageDown.click();
				Thread.sleep(5000);
			}
		SeleniumTestHelper.assertTrue(splitMoveiLPN.isDisplayed());
		splitMoveiLPN.click();
		Steps.logger.info("Click on split move iLPN method");
		Thread.sleep(3000);
		Steps.logger.info("Enter the value of 1st LPN: "+iLPNz.get(0));
		ilpnInRFmoveilpnTxtBox.sendKeys(iLPNz.get(0)+Keys.ENTER);
		Thread.sleep(3000);
		Steps.logger.info("Enter the value of Qty : "+Steps.scenarioData.get("MoveLPNQty"));
		moveQty.sendKeys(Steps.scenarioData.get("MoveLPNQty")+Keys.ENTER);
		Thread.sleep(3000);
		Steps.logger.info("Enter the value of 2nd LPN: "+iLPNz.get(1));
		ilpnInRFmoveilpnTxtBox.sendKeys(iLPNz.get(1)+Keys.ENTER);
		Thread.sleep(3000);
		Steps.logger.info("Completed iLPN move");
		Reporter.addStepLog(Steps.scenarioData.get("MoveLPNQty")+" qty is moved from LPN "+iLPNz.get(0)+ " to "+iLPNz.get(1));
		homepage.userClosesOpenedwindow("RF Menu");
		
	}
}

