package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
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
import globalFunc.Screenshots;
import utils.Config;
import utils.Driver;
//import utils.JSONReadAndWrite;
import utils.SeleniumTestHelper;
import utils.TestStubReader;
import utils.Xpathxml;

public class RFMenuPage {
	WebDriver driver;
	public static ArrayList<String> iLPNz = new ArrayList<String>();
	public static ArrayList<String> palletIdz = new ArrayList<String>();

	public RFMenuPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	HomePage homepage = new HomePage();
	TasksPage taskPage= new TasksPage();
	// TestStubReader testStubReader = new TestStubReader();
	// JSONReadAndWrite jaAndWrite = new JSONReadAndWrite();
	DistributionOrdersPage ditributionorder=new DistributionOrdersPage();
	List<String> serials = new ArrayList<String>();
	String currentSheetName = null;
	String dataFromSheet = null;
	String dataFromsheet = null;

	public String newSysSuggestedLoc = null;
	public String LPNVal = null;
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

	@FindBy(id = "dataForm:rtdcode")
	public WebElement returnCode;

	@FindBy(id = "dataForm:fdcode")
	public WebElement finalDispCode;
	
	@FindBy(xpath = "//div[@id='capSubLocationViewSuggested']")
	public WebElement suggestedLoc;
	
	@FindBy(xpath = "//div[@id='dataForm:ifNotSuggestedMode']")
	public WebElement RLoc;

	@FindBy(xpath = "//span[text()='Accpt/Proceed']")
	public WebElement acceptAndProceedBtn;

	@FindBy(xpath = "//div[@class='caption']")
	public WebElement captionMsg;

	@FindBy(id = "dataForm:invTypeInp")
	public WebElement InvType;

	@FindBy(id = "dataForm:sidzeInpPart0")
	public WebElement mm;
	@FindBy(id = "dataForm:sidzeInpPart2")
	public WebElement dd;
	@FindBy(id = "dataForm:sidzeInpPart4")
	public WebElement yyyy;

	// *[@id="mnbtn_dataForm:menuList:5:menubut1"]
	@FindBy(xpath = "//a[text()='Recv iLPN ASN']")
	public WebElement rfRecviLPNASN;

	// @FindBy(xpath="//TR/TD/TABLE/TBODY/TR/TD/A[normalize-space()=\"MM3
	// Recv-CASE\"]")
	@FindBy(xpath = "//a[text()='MM3 Recv-CASE']")
	public WebElement MM3Rec;
	
	@FindBy(xpath = "//a[text()='MM3 Recv-PLT']")
	public WebElement MM3RecPlt;
	
	//-------------------------------------------------------------
		@FindBy(xpath = "//a[text()='MM3 Recv-PLT-Ptwy']")
		public WebElement MM3RecPltPtway;
		
		@FindBy(id="palletid")
		public WebElement palletid;

	//modified below web element property
	//from
	//@FindBy(xpath = "//a[text()='MM3 Recv Case-Ptwy']")
	//public WebElement BpStgD;
	//to
	@FindBy(xpath = "//a[text()='MM3 Rec-CASE-Ptwy']")
	public WebElement BpStgD;
	
	
	@FindBy(xpath = "//a[text()='MM3 Returns']")
	public WebElement MM3Returns;
	
	@FindBy(xpath = "//a[text()='MM3 Ptwy-Sys Dir']")
	public WebElement MM3sysdirPutaway;

	@FindBy(xpath = "//a[text()='MM3 Recv-Damages']")
	public WebElement MM3recDmg;

	@FindBy(xpath = "//a[text()='MM3 Create iLPN']")
	public WebElement MM3createiLPN;

	@FindBy(xpath = "//a[text()='Modify iLPN']")
	public WebElement ModifyiLPN;
	
	@FindBy(xpath = "//a[text()='Consume iLPN']")
	public WebElement COnsumeiLPN;
	
	@FindBy(xpath = "//a[text()='MM3 ASN Inquiry']")
	public WebElement MM3ASNInquiry;
	@FindBy(xpath = "//a[text()='MM3 Item Inquiry']")
	public WebElement MM3ItemInquiry;
	@FindBy(xpath = "//a[text()='MM3 Location Inquiry']")
	public WebElement MM3LocationInquiry;
	@FindBy(xpath = "//a[text()='MM3 iLPN Inquiry']")
	public WebElement MM3iLPNInquiry;
	@FindBy(xpath = "//a[text()='MM3 oLPN Inquiry']")
	public WebElement MM3oLPNInquiry;
	
	@FindBy(id = "barcode")
	public WebElement MM3ASNInquirytxtBox;
	@FindBy(id = "barcode2Brcd")
	public WebElement MM3ItemInquirytxtBox;
	@FindBy(id = "SubLoc1_Input")
	public WebElement MM3LocationInquirytxtBox;
	@FindBy(id = "barcode2")
	public WebElement MM3iLPNInquirytxtBox;
	@FindBy(id = "barcode2")
	public WebElement MM3oLPNInquirytxtBox;
	@FindBy(xpath = "//span[@value='ASN Dtl']")
	public WebElement ASNDetailBtn;
	
	@FindBy(xpath = "//span[text()='Container:']/..//input")
	public WebElement rfRecviLPNASNContainer;

	@FindBy(id = "p123dd4")
	public WebElement getASNID;

	public String receiveMenu = "//a[text()='<RECEIVE_MENU>']";

	@FindBy(xpath = "//a[text()='RF - CC Res User']")
	public WebElement rfCycleCountResrv;

	@FindBy(xpath = "//span[text()='Continue Count']")
	public WebElement CountiuneCounttxtbox;

	@FindBy(xpath = "//span[@value='Accpt/Proceed']")
	public WebElement acceptProceedButton;

	@FindBy(xpath = "//input[@id='dataForm:listView:filterId:field2value1']")
	public WebElement report_Name_Field;

	@FindBy(xpath = "//input[@name='dataForm:listView:filterId:filterIdapply']")
	public WebElement applyButton;

	@FindBy(xpath = "//input[@id='checkAll_c0_dataForm:listView:dataTable']")
	public WebElement checkBox;

	@FindBy(xpath = "//input[@value='Run Now']")
	public WebElement runNow;

	@FindBy(xpath = "//input[@id='dataForm:REPORT_TEXT_ITEM0']")
	public WebElement wareHouse;

	@FindBy(xpath = "//input[@id='dataForm:REPORT_TEXT_ITEM1']")
	public WebElement poOrder;

	@FindBy(xpath = "//input[@id='dataForm:REPORT_TEXT_ITEM2']")
	public WebElement doOrder;

	@FindBy(xpath = "//input[@id='dataForm:REPORT_TEXT_ITEM3']")
	public WebElement oLPNNumber;

	@FindBy(xpath = "//input[@id='dataForm:processSchdButton1']")
	public WebElement runButton;

	@FindBy(xpath = "//input[@id='dataForm:dt_b2']")
	public WebElement pickerIdBox;

	@FindBy(xpath = "//span[@id='rfbtn_dataForm:SCEAcceptKey']")
	public WebElement pickerAcceptButton;

	@FindBy(xpath = "//input[@id='dataForm:listView:filterId:field10value1']")
	public WebElement oLPNField;

	@FindBy(xpath = "//input[@id='dataForm:listView:filterId:filterIdapply']")
	public WebElement applyButtonOlpn;

	@FindBy(xpath = "//input[@id='checkAll_c0_dataForm:listView:dataTable']")
	public WebElement checkBoxOLPN;

	@FindBy(xpath = "//input[@id='LPNListOutboundMain_commandbutton_view']")
	public WebElement viewButtonOlpn;

	@FindBy(xpath = "//span[text()='Dest Stagin Locn:']")
	public WebElement destStagingLocn;
	@FindBy(xpath = "//span[text()='Dest Stagin Locn:']//following::input[1]")
	public WebElement destStagingLocnInput;
	
	 @FindBy(xpath = "//span[@value='Enter Task']")   public static WebElement EnterTaskBtn;
	 @FindBy(xpath = "//input[@id='dataForm:input1']")  public static WebElement Task_input_field;
	 @FindBy(xpath = "//input[@id='locn_Input']")   public static WebElement Rloc_field;
	 @FindBy(xpath = "//input[@id='dataForm:q1ty2']")  public static WebElement numbersOfLPN_field;
	 
	 @FindBy(xpath="//div[@id='dataForm:notPalletPageQty']") public WebElement suggestedQty;
	 @FindBy(xpath="//*[@id='input1qtyQty51']") public WebElement taskQtyTxtBox;
	 
	 @FindBy(xpath = "//input[starts-with(@id, 'barcode')]")   public static WebElement iLPNInputBx;
		@FindBy(xpath = "//div[@id='dataForm:divFullPlt2']")   public static WebElement promptedPallet;
		@FindBy(xpath = "//div[@id='labelCntr9']")   public static WebElement promptediLPN;
		@FindBy(xpath = "//input[@id='dataForm:locationempty']")   public static WebElement locEmptyInputBx;
		@FindBy(xpath = "//div[@id='dataForm:div012']")   public static WebElement suggestedCloc;
		@FindBy(xpath = "//input[@id='sublocn1_Input']")   public static WebElement clocInputBx;
		@FindBy(xpath="//span[@value='End iLPN']") public WebElement end_iLPN_btn;

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
	// @FindBy(xpath = "//input[@id='containerEntryUserDirected']")
	// input[@id="containerEntryUserDirected"]
	public WebElement lpnTxt;

	@FindBy(xpath = "(//div[contains(text(),'loc')])[1]")
	public WebElement suggestedLocLabel;

	@FindBy(xpath = "//input[@id='subLocationEntry_Input']")
	public WebElement locationInput;

	@FindBy(xpath = "//span[@value='Chg Task Grp']")
	public WebElement ChgTaskGroupBtn;

	@FindBy(xpath = "//input[@id='dataForm:taskGrp']")
	public WebElement taskGroupInputField;

	@FindBy(xpath = "//input[@id='location_Input']")
	public WebElement Locn_field;
	@FindBy(xpath = "//span[@value='Enter']")
	public WebElement enterBtn;
	@FindBy(xpath = "//input[@id='dataForm:TaskType']")
	public WebElement taskType_Field;

	@FindBy(xpath = "//span[text()='Enter']")
	public WebElement changeTaskGroupEnter;

	@FindBy(xpath = "//input[@id='dataForm:INT']")
	public WebElement INT_field;

	@FindBy(xpath = "//a[text()='Receiving']")
	public WebElement rfMenuReceiving;

	@FindBy(xpath = "//a[text()='Putaway']")
	public WebElement rfMenuPutaway;

	@FindBy(xpath = "//a[text()='Recv By ASN']")
	public WebElement rfRecvByASN;

	@FindBy(xpath = "//a[contains(text(),'Ptwy iLPN')]")
	public WebElement putAwayILPN;

	@FindBy(xpath = "//a[text()='Inventory']")
	public WebElement inventoryMgmtMenu;

	@FindBy(xpath = "//a[text()='Inquiry']")
	public WebElement inquiryMenu;
	
	@FindBy(xpath = "//a[text()='Outbound']")
	public WebElement outboundoption;

	@FindBy(xpath = "//a[text()='Audit n Print']")
	public WebElement Auditnprintoption;

	@FindBy(xpath = "//a[text()='Audit oLPN']")
	public WebElement AuditoLPNoption;

	@FindBy(xpath = "//input[@id='cartonNbrInput']")
	public WebElement oLPNinputtxtbx;

	@FindBy(xpath = "//input[@id='skuBrcd']")
	public WebElement skuBrcdinputtxtbx;

	@FindBy(xpath = "//input[@id='input1qtyInput']")
	public WebElement skuqty;

	@FindBy(xpath = "//span[@value='End oLPN']")
	public WebElement EndoLPN;

	@FindBy(xpath = "//a[text()='RF-Create iLPN']")
	public WebElement rfCreateIlpnMenu;
	
	@FindBy(xpath = "//a[text()='MM3 Cancel oLPN']")
	public WebElement rfCancelolpnOption;
	
	@FindBy(xpath = "//input[@id='barcode']")
	public WebElement ilpnInRFcreateilpnTxtBox;
	
	@FindBy(xpath = "//input[@id='barcode1']")
	public WebElement ilpnInRFModifyilpnTxtBox;
	
	@FindBy(xpath = "//input[@id='input1qty1']")
	public WebElement QtyTxtBoxInRFModifyilpn;
	
	@FindBy(xpath = "//input[@id='dataForm:rsn']")
	public WebElement ReasonCOdeTxtBoxInRFModifyilpn;
	
	@FindBy(xpath = "//input[@id='dataForm:ref']")
	public WebElement ReferenceTxtBoxInRFModifyilpn;
	
	@FindBy(xpath = "//span[text()='Delete Detail']")
	public WebElement DeleteDetailBtnInRFModifyilpn;
	
	
	@FindBy(xpath = "//input[@id='barcode2Brcd']")
	public WebElement itemBarcodeInRFcreateIlpnTxtBox;

	@FindBy(xpath = "//span[text()='Lot:']/..//input")
	public WebElement lotInRFcreateIlpnTxtBox;

	@FindBy(xpath = "//input[@id='dataForm:prodStatus']")
	public WebElement productStatusTxtBox;

	@FindBy(xpath = "//input[@id='dataForm:invnType']")
	public WebElement inventoryTypeInRFcreateIlpnTxtBox;

	@FindBy(xpath = "//input[@id='dataForm:shp1Part0']")
	public WebElement mmInRFcreateIlpnTxtBox;

	@FindBy(xpath = "//input[@id='dataForm:shp1Part2']")
	public WebElement ddInRFcreateIlpnTxtBox;

	@FindBy(xpath = "//input[@id='dataForm:shp1Part4']")
	public WebElement yyInRFcreateIlpnTxtBox;

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
	
	@FindBy(xpath = "//input[@id='container']")
	public WebElement consumeilpnTxtBox;
	
	@FindBy(xpath = "//input[@id='dataForm:reference']")
	public WebElement consumeilpnRefTxtBox;

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
	public WebElement enterTaskBtn;

	@FindBy(xpath = "//input[@id='dataForm:input1']")
	public WebElement taskInputField;

	@FindBy(xpath = "//input[@id='locn_Input']")
	public WebElement RlocField;

	@FindBy(xpath = "//input[@id='dataForm:q1ty2']")
	public WebElement numbersOfLPNField;

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

	@FindBy(xpath = "//*[contains(text(),'Number of LPNs:')]//following::input[@id='dataForm:q1ty2']")
	public WebElement NumofLPNsInputtxtbx;

	@FindBy(xpath = "//input[@id='dataForm:qhinpid']")
	public WebElement RFPtwyAltLockCode1;
	@FindBy(xpath = "//a[contains(text(),'Pltz iLPNs')]")
	public WebElement palletizeiLPN;
	@FindBy(xpath = "//input[@id='barcode']")
	public WebElement palletizeILpnInput;
	@FindBy(xpath = "//input[@id='barcode5']")
	public WebElement palletizeiLPN_iLPN_Input;

	@FindBy(xpath = "//input[@id='containerEntry']")
	public WebElement altiLPNBoxafterputaway;
	
	@FindBy(xpath = "//input[@id='subLocationEntryS_Input']")
	public WebElement putawayLoctxtBox;

	@FindBy(xpath = "//input[@id='subLocationEntry_Input']")
	public WebElement RlocinputtxtBox;
	
	
	@FindBy(xpath = "//a[text()='RF- CC Act User']")
	public WebElement rfCycleCountAct;
	@FindBy(xpath = "//input[@id='test1']")
	public WebElement RFFillActvInput;
	@FindBy(xpath = "//span[@value='Exit']")
	public WebElement ExitBtn;
	@FindBy(xpath = "//input[@id='tb_567']")
	public WebElement valueBtn;
	@FindBy(xpath = "//input[@id='itemIdBrcd']")
	public WebElement itemBarcode_CC_Complete;
	@FindBy(xpath = "//input[@id='input1qty20']")
	public WebElement qty_textBox_RCT;
	@FindBy(xpath = "//span[.='Next/End Locn']")
	public WebElement NextEntLocationBtn;
	@FindBy(xpath = "//span[text()='End Pallet']")
	public WebElement EndPallet;

	@FindBy(xpath = "//input[@id='barcode1']")
	public WebElement ilpnInRFCCreserveilpnTxtBox;
	@FindBy(xpath = "//a[text()='Outbound']")
	public WebElement rfOutboundMenu;
	@FindBy(xpath = "//a[text()='Pick Pack']")
	public WebElement rfPickPackOption;
	@FindBy(xpath = "//a[text()='RF Make Pk Tote Cart']")
	public WebElement rfmanPkToteOption;
	@FindBy(xpath = "//*[@id='barcode2']")
	public WebElement rfmanpickcart;
	@FindBy(xpath = "//*[@id='barcode']")
	public WebElement rfmanoLPN;
	@FindBy(xpath = "//*[@id='dataForm:SlotNbr']")
	public WebElement rfmanSlot;
	@FindBy(xpath = "//*[@id='tool_bar_buttons']/table/tbody/tr/td[1]")
	public WebElement rfmanExit;
	@FindBy(xpath = "//a[text()='RF Pck Pick Cart']")
	public WebElement rfmanPickPackCartOption;
	@FindBy(xpath = "//*[@id='barcode']")
	public WebElement rfmanpickcartno;
	@FindBy(xpath = "//span[text()='End Pick Cart']")
	public WebElement EndPickCart;
	@FindBy(xpath = "//span[text()='Accpt/Proceed']")
	public WebElement manacp_pro_btn;
	@FindBy(xpath = "//input[@name='itemId2Brcd']")
	public WebElement rfmanItemBarcodeInputBx;
	@FindBy(xpath = "//*[@id='barcode1']")
	public WebElement rfman_oLPN;
	@FindBy(xpath = "//*[@id='tb_567']")
	public WebElement rfmaninfo;
	@FindBy(xpath = "//a[text()='Shipping']")
	public WebElement rfShipping;
	@FindBy(xpath = "//a[text()='RF Close Trailer']")
	public WebElement rfclose_trailer;
	@FindBy(xpath = "//*[@id='barcode20']")
	public WebElement rfclose_trailer_Shipment;
	@FindBy(xpath = "//*[@id='barcode13']")
	public WebElement rfclose_trailer_DD;
	@FindBy(xpath = "//*[@id='barcode32']")
	public WebElement rfclose_trailer_BOL;
	@FindBy(xpath = "//span[text()='Accpt/Proceed']")
	public WebElement rfclose_acp_pro_btn;

	@FindBy(xpath = "//a[text()='RF Load oLPN']")
	public WebElement rfLoad_oLPN;
	@FindBy(xpath = "//input[@name='barcode1']")
	public WebElement rfLoad_oLPN_Num;
	@FindBy(xpath = "//span[text()='Accpt/Proceed']")
	public WebElement rfLoad_acp_pro_btn;

	@FindBy(xpath = "//a[text()='RF Anchor oLPN']")
	public WebElement rfAnchor_oLPN;
	@FindBy(xpath = "//input[@name='barcode1']")
	public WebElement rfAnchor_oLPN_no;
	@FindBy(xpath = "//input[@name='sublocn31c_Input']")
	public WebElement rfAnchor_Locn;
	@FindBy(xpath = "//a[text()='RF Locate oLPN']")
	public WebElement rfLocate_oLPN;
	@FindBy(xpath = "//input[@name='OBcontainerEntryUserDirectedLPN']")
	public WebElement rfLocate_oLPN_num;
	@FindBy(xpath = "//input[@name='subLocationEntryUserDirected18_Input']")
	public WebElement rfLocate_Locn;

	@FindBy(xpath = "//a[text()='Pck Cubed Dir - Parcel']")
	public WebElement rfPckCubedDirParcelOption;
	@FindBy(xpath = "//span[text()='oLPN:']//following-sibling::input")
	public WebElement oLPNtxtbox;
	@FindBy(xpath = "//input[@id='itemIdBrcd']")
	public WebElement oLPNItemBarCode;
	@FindBy(xpath = "//input[@id='input1qty2']")
	public WebElement oLPNItemQty;
	@FindBy(xpath = "//div[@class='error']")
	public WebElement error;
	@FindBy(xpath = "//span[text()='Accpt/Proceed']")
	public WebElement Accept_Proceed_btn;
	@FindBy(xpath = "(//span[text()='Qty:'])[1]/ancestor::div[position()=2]")
	public WebElement displayedQtyOLPN;
	@FindBy(xpath = "//span[text()='Srl Nbr:']//following::input[1]")
	public WebElement serialNumbersInput;
	@FindBy(xpath = "//input[@id='barcode2']")
	public WebElement serialNumberInputParcel;
	@FindBy(xpath = "//a[text()='RF-Pck iLPN Frm Actv']")
	public WebElement RF_Pck_iLPN_Frm_Actv;
	@FindBy(xpath = "//input[@id='locn1_Input']")
	public WebElement AlocInput;
	@FindBy(xpath = "//input[@id='input1qtypack2']")
	public WebElement qtyInput;

	@FindBy(xpath = "(//div[contains(text(),'Aloc')])[2]")
	public WebElement suggestedLocLabelFillAct;
	@FindBy(xpath = "//span[text()='Minor Srl Nbr:']//following::input[1]")
	public WebElement minorSerialNumberInput;
	@FindBy(xpath = "//span[@value='End Entry']")
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
	@FindBy(xpath = "//span[@id='dataForm:EnterlpnNumberPanelGroup']")
	public WebElement olpnInput;
	@FindBy(xpath = "//select[@id='dataForm:shipviaList']")
	public WebElement shipViaOptions;
	@FindBy(xpath = "//input[@id='dataForm:inputText1']")
	public WebElement outQ;
	@FindBy(xpath = "//input[@id='dataForm:declaredValue']")
	public WebElement declaredValue;
	@FindBy(xpath = "//input[@value='Manifest >']")
	public WebElement ManifestBtn;
	@FindBy(xpath = "//a[@id='mnbtn_dataForm:menuList:3:menubut1']")
	public WebElement PackCubedParcel;
	@FindBy(xpath = "//span[text()='OutQ:']")
	public WebElement outQPrinter;

	@FindBy(xpath = "//span[text()='Pallet:']//following::input[1]")
	public WebElement anchorPalletID;
	@FindBy(xpath = "//input[@id='sublocn3556_Input']")
	public WebElement anchorLocn;
	
	//Jaya
	
	@FindBy(xpath = "//a[contains(text(),'MM3 Split Cmbne oLPN')]")
	public WebElement SplitCmbneoLPN;
	
	@FindBy(xpath = "//input[@id='barcode1']")
	public WebElement SplitFromoLPNtextbox;
	
	@FindBy(xpath = "//input[@id='barcode2']")
	public WebElement SplitToLPNtextbox;
	
	@FindBy(xpath = "//input[@name='itemId01Brcd']")
	public WebElement Splititembarcodetextbox;
	
	@FindBy(xpath = "//input[@id='input1qty2']")
	public WebElement SplititQtytextbox;
	
	@FindBy(xpath = "//a[text()='Pack From Actv']")
	public WebElement PackfromActv;
	
	@FindBy(xpath = "//input[@id='dataForm:ti2']")
	public WebElement TL;

	@FindBy(xpath = "//a[text()='MM3 Pack From Trans']")
	public WebElement MM3PACKTRANS;
	
	public void ASNReceivingProcess(int noOfItems, String receivingMethod, String recLocation) throws Exception {
		String iLPN = null;
		String fututeDate = SeleniumTestHelper.user_generate_estimated_delivery_date(365);
		String[] futureDateAsArray = fututeDate.split("-");
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
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);
				destStagingLocnInput.sendKeys("ABC01001D01" + Keys.ENTER);
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
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);
				destStagingLocnInput.sendKeys("ABC01001D02" + Keys.ENTER);
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
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);
				destStagingLocnInput.sendKeys("ABC01001D03" + Keys.ENTER);
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
				SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);
				destStagingLocnInput.sendKeys(recLocation + Keys.ENTER);
			}
			lpnInputTxt.sendKeys(Keys.ENTER);
			ItemBarcode.sendKeys(Items.getItemsForReceivingASN(0) + Keys.ENTER);
			InvType.sendKeys(Keys.ENTER);
			Item_qty.sendKeys(
					String.valueOf(Items.getItemWithShippedASNQty(Items.getItemsForReceivingASN(0))) + Keys.ENTER);
			mm.sendKeys("07");
			dd.sendKeys("31");
			yyyy.sendKeys("2020");
			acceptAndProceedBtn.click();
			/*
			 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg,
			 * 50); System.out.println("Info :- " + errorOrWarningMsg.getText());
			 * SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
			 * acceptAndProceedBtn.click();
			 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
			 * 
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

	public void ASNReceivingProcess(String receivingMethod) throws Exception {
		try {
			String iLPN = null;
			//iLPNz = null;
			Steps.logger.info("Start Receiving Process");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
			RFmenu_info.click();
			Steps.logger.info("Clicked on RF Menu");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
			Mainmenu.click();
			Steps.logger.info("Clicked on Main Menu");
			Thread.sleep(2000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfMenuReceiving, 50);
			rfMenuReceiving.click();
			Steps.logger.info("Clicked on Receiving");
			Screenshots.captureSnapshot(driver);
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
					SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);
					destStagingLocnInput.sendKeys("ABC01001D01" + Keys.ENTER);
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
					SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);
					destStagingLocnInput.sendKeys("ABC01001D02" + Keys.ENTER);
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
					SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);
					destStagingLocnInput.sendKeys("ABC01001D03" + Keys.ENTER);
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
				while (!(SeleniumTestHelper.isElementDisplayed(MM3Rec))) {
					pageDown.click();
				}
				SeleniumTestHelper.assertTrue(MM3Rec.isDisplayed());
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeClickable(driver, MM3Rec, 50);
				MM3Rec.click();
				Steps.logger.info("Click on " + receivingMethod + " method");
				// Thread.sleep(5000);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
				Screenshots.captureSnapshot(driver);
				inputASN.sendKeys(Items.getAsnNumber());
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("Enter ASN number: " + Items.getAsnNumber());
				SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
				inputASN.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				// Thread.sleep(2000);
				for (int i = 0, j = 1; i < Steps.ItemDataMap.size(); i++, j++) {
					if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
						SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

						// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
						// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
						System.out.println("Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						Steps.logger.info("Enter Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						destStagingLocnInput.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation")));
						Screenshots.captureSnapshot(driver);
						destStagingLocnInput.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
					}
					 Thread.sleep(2000);
					 SeleniumTestHelper.waitForElementToBeDisplayed(driver, lpnInputTxt, 50);
					lpnInputTxt.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					// for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					// Thread.sleep(3000);
					String LPNs = driver.findElement(By.id("csid")).getText();
					String[] LPNnum = LPNs.split(":");
					System.out.println("LPN# :" + LPNnum[1].trim());

					iLPNz.add(LPNnum[1].trim());
					System.out.println("LPN " + j + " : " + iLPNz.get(i));
					Reporter.addStepLog("LPN " + j + " : " + iLPNz.get(i));
					/// Thread.sleep(3000);
					ItemBarcode.sendKeys(Steps.ItemDataMap.get(i).get("Item"));
					Screenshots.captureSnapshot(driver);
					ItemBarcode.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Item Id: " + Steps.ItemDataMap.get(i).get("Item"));
					// Thread.sleep(3000);
					InvType.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					// Thread.sleep(3000);
					Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					Screenshots.captureSnapshot(driver);
					Item_qty.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					// Thread.sleep(3000);

					if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
						if (errorOrWarningMsg.getText().contains("Error")) {
							System.out.println("Info :- " + errorOrWarningMsg.getText());
							Steps.logger.info(errorOrWarningMsg.getText());
							globalFunc.Screenshots.seleniumSnapshot(driver);
							Steps.testRes = "Failed";
							Assert.assertTrue(false);
							//Screenshots.addingScreenshottoExentReport();
						//	acceptAndProceedBtn.click();
						//	Screenshots.captureSnapshot(driver);
							break;
						} else if (errorOrWarningMsg.getText().contains("Warning")) {
							System.out.println("Info :- " + errorOrWarningMsg.getText());
							globalFunc.Screenshots.seleniumSnapshot(driver);
							Screenshots.addingScreenshottoExentReport();
							acceptAndProceedBtn.click();
							Screenshots.captureSnapshot(driver);
						}
					}
					String fututeDate = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
				
					String[] futureDateAsArray = fututeDate.split("-");
					// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					List <WebElement> shipbyDate=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
					if(shipbyDate.size()!=0) {
						Steps.logger.info("Enter fututeDate: " + fututeDate);
					mm.sendKeys(futureDateAsArray[0]);
					dd.sendKeys(futureDateAsArray[1]);
					Screenshots.captureSnapshot(driver);
					yyyy.sendKeys(futureDateAsArray[2]);
					}
					Thread.sleep(3000);
					Screenshots.captureSnapshot(driver);
					acceptAndProceedBtn.click();
					Thread.sleep(10000);
					Screenshots.captureSnapshot(driver);
					Steps.logger
							.info(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ iLPNz.get(i) + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
					Reporter.addStepLog(
							String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ iLPNz.get(i) + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));

					if (Steps.ItemDataMap.get(i).get("RecQty2") != "") {
						if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
							SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

							// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
							// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
							System.out.println("Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
							Steps.logger.info("Enter Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
							destStagingLocnInput.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation")));
							Screenshots.captureSnapshot(driver);
							destStagingLocnInput.sendKeys(Keys.ENTER);
							Screenshots.captureSnapshot(driver);
						}
						// Thread.sleep(2000);
						lpnInputTxt.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						// for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
						// Thread.sleep(3000);
						String LPNs1 = driver.findElement(By.id("csid")).getText();
						String[] LPNnum1 = LPNs1.split(":");
						System.out.println("LPN# :" + LPNnum1[1].trim());

						iLPNz.add(LPNnum1[1].trim());
						System.out.println("LPN 2 : " + LPNnum1[1].trim());
						Reporter.addStepLog("LPN 2 : " + LPNnum1[1].trim());
						// Thread.sleep(3000);
						ItemBarcode.sendKeys(Items.getItemsForReceivingASN(i));
						Screenshots.captureSnapshot(driver);
						ItemBarcode.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Item Id: " + Items.getItemsForReceivingASN(0));
						// Thread.sleep(3000);
						InvType.sendKeys(Keys.ENTER);
						Thread.sleep(2000);
						Screenshots.captureSnapshot(driver);
						Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) );
						Screenshots.captureSnapshot(driver);
						Item_qty.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")));
						Thread.sleep(3000);

						if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
							SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
							if (errorOrWarningMsg.getText().contains("Error")) {
								System.out.println("Info :- " + errorOrWarningMsg.getText());
								globalFunc.Screenshots.seleniumSnapshot(driver);
								Screenshots.addingScreenshottoExentReport();
								acceptAndProceedBtn.click();
								Screenshots.captureSnapshot(driver);
								break;
							} else if (errorOrWarningMsg.getText().contains("Warning")) {
								System.out.println("Info :- " + errorOrWarningMsg.getText());
								globalFunc.Screenshots.seleniumSnapshot(driver);
								Screenshots.addingScreenshottoExentReport();
								acceptAndProceedBtn.click();
								Screenshots.captureSnapshot(driver);
							}
						}
						Thread.sleep(3000);
						String fututeDate1 = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						System.out.println(fututeDate1);
						Steps.logger.info("Enter fututeDate: " + fututeDate1);
						String[] futureDateAsArray1 = fututeDate1.split("-");
						// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						List <WebElement> shipbyDate2=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
						if(shipbyDate2.size()!=0) {
						mm.sendKeys(futureDateAsArray1[0]);
						dd.sendKeys(futureDateAsArray1[1]);
						Screenshots.captureSnapshot(driver);
						yyyy.sendKeys(futureDateAsArray1[2]);
						}
						Thread.sleep(3000);
						Screenshots.captureSnapshot(driver);
						acceptAndProceedBtn.click();
						Screenshots.captureSnapshot(driver);
						Steps.logger.info(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) + " qty is received in LPN "
										+ LPNnum1[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
						Reporter.addStepLog(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) + " qty is received in LPN "
										+ LPNnum1[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
						Thread.sleep(10000);
					}
				}
				Steps.logger.info("Completed Receiving");
				/*
				 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg,
				 * 50); System.out.println("Info :- " + errorOrWarningMsg.getText());
				 * SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
				 * acceptAndProceedBtn.click();
				 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
				 * 
				 * for (int i = 0; i < noOfItems; i++) { iLPN =
				 * Items.getItemILPN(Items.getItemsForReceivingASN(i));
				 * System.out.println("iLPN : " + iLPN + " for the product : " +
				 * Items.getItemsForReceivingASN(i)); }
				 */
				break;

			case "MM3 Rec-CASE-Ptwy":
				System.out.println("Receiving process starting with : " + receivingMethod + " menu");
				Steps.logger.info("Receiving process starting with : " + receivingMethod + " menu");
				while (!(SeleniumTestHelper.isElementDisplayed(BpStgD))) {
					pageDown.click();
				}
				SeleniumTestHelper.assertTrue(BpStgD.isDisplayed());
				Screenshots.captureSnapshot(driver);
				BpStgD.click();
				Steps.logger.info("Click on " + receivingMethod + " method");
				Thread.sleep(10000);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
				inputASN.sendKeys(Items.getAsnNumber());
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("Enter ASN number: " + Items.getAsnNumber());
				SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
				inputASN.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Screenshots.captureSnapshot(driver);
				for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
						SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

						// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
						// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
						System.out.println("Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						Steps.logger.info("Enter Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						destStagingLocnInput.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation")));
						Screenshots.captureSnapshot(driver);
						destStagingLocnInput.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
					}
					Thread.sleep(2000);
					lpnInputTxt.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					// for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					String LPNs3 = driver.findElement(By.id("csid")).getText();
					String[] LPNnum3 = LPNs3.split(":");
					System.out.println("LPN# :" + LPNnum3[1].trim());

					iLPNz.add(LPNnum3[1].trim());
					System.out.println("LPN : " + LPNnum3[1].trim());
					Reporter.addStepLog("LPN : " + LPNnum3[1].trim());
					// Thread.sleep(3000);
					Thread.sleep(3000);
					ItemBarcode.sendKeys(Steps.ItemDataMap.get(i).get("Item"));
					Screenshots.captureSnapshot(driver);
					ItemBarcode.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Item Id: " + Items.getItemsForReceivingASN(0));
					Thread.sleep(2000);
					InvType.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Thread.sleep(2000);
					Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					Screenshots.captureSnapshot(driver);
					Item_qty.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					
					Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					Thread.sleep(2000);
					
					if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
						if (errorOrWarningMsg.getText().contains("Error")) {
							System.out.println("Info :- " + errorOrWarningMsg.getText());
							Steps.logger.info(errorOrWarningMsg.getText());
							globalFunc.Screenshots.seleniumSnapshot(driver);
							Steps.testRes = "Failed";
							Assert.assertTrue(false);
							//Screenshots.addingScreenshottoExentReport();
						//	acceptAndProceedBtn.click();
						//	Screenshots.captureSnapshot(driver);
							break;
						} else if (errorOrWarningMsg.getText().contains("Warning")) {
							System.out.println("Info :- " + errorOrWarningMsg.getText());
							globalFunc.Screenshots.seleniumSnapshot(driver);
							Screenshots.addingScreenshottoExentReport();
							acceptAndProceedBtn.click();
							Screenshots.captureSnapshot(driver);
						}
					}
					String fututeDate = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					Steps.logger.info("Enter fututeDate: " + fututeDate);
					String[] futureDateAsArray = fututeDate.split("-");
					// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					List <WebElement> shipbyDate=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
					if(shipbyDate.size()!=0) {
					mm.sendKeys(futureDateAsArray[0]);
					dd.sendKeys(futureDateAsArray[1]);
					Screenshots.captureSnapshot(driver);
					yyyy.sendKeys(futureDateAsArray[2]);
					}
					Thread.sleep(3000);
					Screenshots.captureSnapshot(driver);
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
					System.out.println("Info :- " + errorOrWarningMsg.getText());

					String errorOrWarningMsgs = errorOrWarningMsg.getText();
					String[] errorOrWarningMsgs1 = errorOrWarningMsgs.split(" ");

					System.out.println("LPN is: " + errorOrWarningMsgs1[1]);
					LPNVal = errorOrWarningMsgs1[1];
					Thread.sleep(2000);
					acceptAndProceedBtn.click();
					Thread.sleep(2000);
					Screenshots.captureSnapshot(driver);
					String sysSuggestedLoc = altsuggestedLocLabel.getText();
					String[] sysSuggestedLocSplit = sysSuggestedLoc.split(" ");
					newSysSuggestedLoc = sysSuggestedLocSplit[1];
					String[] spltarr = sysSuggestedLocSplit[1].split("-");
					String str = GlobalClass.removeZero(spltarr[1]);
					System.out.println(str);
					spltarr[1] = str;
					String updtLoc = "";
					for (String a : spltarr)
						updtLoc = updtLoc + a;

					System.out.println("updtLoc is: " + updtLoc);

					locationInput.sendKeys(updtLoc);
					Screenshots.captureSnapshot(driver);
					locationInput.sendKeys( Keys.ENTER);
					Thread.sleep(2000);
					Screenshots.captureSnapshot(driver);
					if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
						if (errorOrWarningMsg.getText().contains("Error")) {
							System.out.println("Info :- " + errorOrWarningMsg.getText());
							Steps.logger.info(errorOrWarningMsg.getText());
							globalFunc.Screenshots.seleniumSnapshot(driver);
							Steps.testRes = "Failed";
							Assert.assertTrue(false);
						}
					}
					Steps.logger.info(
							String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ LPNnum3[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
					Reporter.addStepLog(
							String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ LPNnum3[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
					Thread.sleep(2000);
					
					if (Steps.ItemDataMap.get(i).get("RecQty2") != "") {
						lpnInputTxt.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						// for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
						String LPNs4 = driver.findElement(By.id("csid")).getText();
						String[] LPNnum4 = LPNs4.split(":");
						System.out.println("LPN# :" + LPNnum4[1].trim());

						iLPNz.add(LPNnum4[1].trim());
						System.out.println("LPN : " + LPNnum4[1].trim());
						Reporter.addStepLog("LPN : " + LPNnum4[1].trim());
						// Thread.sleep(3000);
						Thread.sleep(3000);
						ItemBarcode.sendKeys(Steps.ItemDataMap.get(i).get("Item"));
						Screenshots.captureSnapshot(driver);
						ItemBarcode.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Item Id: " + Items.getItemsForReceivingASN(0));
						Thread.sleep(2000);
						InvType.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Thread.sleep(2000);
						Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
						Screenshots.captureSnapshot(driver);
						Item_qty.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
						Thread.sleep(2000);
						
						if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
							SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
							if (errorOrWarningMsg.getText().contains("Error")) {
								System.out.println("Info :- " + errorOrWarningMsg.getText());
								Steps.logger.info(errorOrWarningMsg.getText());
								globalFunc.Screenshots.seleniumSnapshot(driver);
								Steps.testRes = "Failed";
								Assert.assertTrue(false);
								//Screenshots.addingScreenshottoExentReport();
							//	acceptAndProceedBtn.click();
							//	Screenshots.captureSnapshot(driver);
								break;
							} else if (errorOrWarningMsg.getText().contains("Warning")) {
								System.out.println("Info :- " + errorOrWarningMsg.getText());
								globalFunc.Screenshots.seleniumSnapshot(driver);
								Screenshots.addingScreenshottoExentReport();
								acceptAndProceedBtn.click();
								Screenshots.captureSnapshot(driver);
							}
						}
						String fututeDate1 = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						Steps.logger.info("Enter fututeDate: " + fututeDate1);
						String[] futureDateAsArray1 = fututeDate1.split("-");
						// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						//List <WebElement> shipbyDate1=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
						if(SeleniumTestHelper.isElementDisplayed(mm)) {
						mm.sendKeys(futureDateAsArray1[0]);
						dd.sendKeys(futureDateAsArray1[1]);
						Screenshots.captureSnapshot(driver);
						yyyy.sendKeys(futureDateAsArray1[2]);
						}
						Thread.sleep(3000);
						Screenshots.captureSnapshot(driver);
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
						System.out.println("Info :- " + errorOrWarningMsg.getText());

						String errorOrwarningMsgs = errorOrWarningMsg.getText();
						String[] errorOrwarningMsgs1 = errorOrwarningMsgs.split(" ");

						System.out.println("LPN is: " + errorOrwarningMsgs1[1]);
						LPNVal = errorOrWarningMsgs1[1];
						Thread.sleep(2000);
						acceptAndProceedBtn.click();
						Thread.sleep(2000);
						Screenshots.captureSnapshot(driver);
						String syssuggestedLoc1 = altsuggestedLocLabel.getText();
						String[] syssuggestedLocSplit1 = syssuggestedLoc1.split(" ");
						newSysSuggestedLoc = syssuggestedLocSplit1[1];
						String[] spltarr2 = syssuggestedLocSplit1[1].split("-");
						String str2 = GlobalClass.removeZero(spltarr2[1]);
						System.out.println(str);
						spltarr2[1] = str2;
						String updtLoc1 = "";
						for (String a : spltarr2)
							updtLoc1 = updtLoc1 + a;

						System.out.println("updtLoc is: " + updtLoc1);

						locationInput.sendKeys(updtLoc1);
						Screenshots.captureSnapshot(driver);
						locationInput.sendKeys( Keys.ENTER);
						Thread.sleep(2000);
						Screenshots.captureSnapshot(driver);
						
						if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
							SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
							if (errorOrWarningMsg.getText().contains("Error")) {
								System.out.println("Info :- " + errorOrWarningMsg.getText());
								Steps.logger.info(errorOrWarningMsg.getText());
								globalFunc.Screenshots.seleniumSnapshot(driver);
								Steps.testRes = "Failed";
								Assert.assertTrue(false);
							}
						}
						Steps.logger.info(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
										+ LPNnum4[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
						Reporter.addStepLog(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
										+ LPNnum4[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
						Thread.sleep(2000);
					}
					// Reporter.addStepLog(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty"))+"
					// qty is received in LPN "+iLPNz.get(i)+" for Item-
					// "+Steps.ItemDataMap.get(i).get("Item"));
				}
				Steps.logger.info("Completed Receiving");
				/*
				 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg,
				 * 50); System.out.println("Info :- " + errorOrWarningMsg.getText());
				 * SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
				 * acceptAndProceedBtn.click();
				 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
				 * 
				 * for (int i = 0; i < noOfItems; i++) { iLPN =
				 * Items.getItemILPN(Items.getItemsForReceivingASN(i));
				 * System.out.println("iLPN : " + iLPN + " for the product : " +
				 * Items.getItemsForReceivingASN(i)); }
				 */
				break;
				
			case "MM3 Recv-PLT":
				System.out.println("Receiving process starting with : " + receivingMethod + " menu");
				Steps.logger.info("Receiving process starting with : " + receivingMethod + " menu");
				while (!(SeleniumTestHelper.isElementDisplayed(MM3RecPlt))) {
					pageDown.click();
				}
				SeleniumTestHelper.assertTrue(MM3RecPlt.isDisplayed());
				Screenshots.captureSnapshot(driver);
				MM3RecPlt.click();
				Steps.logger.info("Click on " + receivingMethod + " method");
				Thread.sleep(10000);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
				inputASN.sendKeys(Items.getAsnNumber());
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("Enter ASN number: " + Items.getAsnNumber());
				SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
				inputASN.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Screenshots.captureSnapshot(driver);
				if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
					SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

					// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
					// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
					System.out.println("Rec Location-" + Steps.scenarioData.get("RecLocation"));
					Steps.logger.info("Enter Rec Location-" + Steps.scenarioData.get("RecLocation"));
					destStagingLocnInput.sendKeys(Steps.scenarioData.get("RecLocation"));
					Screenshots.captureSnapshot(driver);
					destStagingLocnInput.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
				}
				int noOfpallets=Integer.parseInt(Steps.scenarioData.get("PltQty"));
				int b=0;
				if (noOfpallets==1) {
					b=Steps.ItemDataMap.size();
				}else
				{
					b=1;
				}
				System.out.println("b="+b);
				for (int j = 0; j < noOfpallets; j++) {
				globalFunc.DateTime.TimeDateFunc();
				palletid.sendKeys("PLT1"+DateTime.strDate8+Keys.ENTER);
				Thread.sleep(2000);
				acceptAndProceedBtn.click();
				Thread.sleep(2000);
				String palletId = driver.findElement(By.id("p123")).getText();
				String[] palletIds = palletId.split(":");
				System.out.println("palletId# :" + palletIds[1].trim());

				palletIdz.add(palletIds[1].trim());
				System.out.println("palletId: " + palletIds[1].trim());
				Reporter.addStepLog("palletId : " + palletIds[1].trim());
				int i=0;
				for(int k=0;k<b;k++) {
					
					 i=j+k;
					if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
						SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

						// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
						// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
						System.out.println("Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						Steps.logger.info("Enter Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						destStagingLocnInput.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation")));
						Screenshots.captureSnapshot(driver);
						destStagingLocnInput.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
					}
					Thread.sleep(2000);
					lpnInputTxt.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					// for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					String LPNs3 = driver.findElement(By.id("csid")).getText();
					String[] LPNnum3 = LPNs3.split(":");
					System.out.println("LPN# :" + LPNnum3[1].trim());

					iLPNz.add(LPNnum3[1].trim());
					System.out.println("LPN 3: " + LPNnum3[1].trim());
					Reporter.addStepLog("LPN 3 : " + LPNnum3[1].trim());
					// Thread.sleep(3000);
					Thread.sleep(3000);
					ItemBarcode.sendKeys(Steps.ItemDataMap.get(i).get("Item"));
					Screenshots.captureSnapshot(driver);
					ItemBarcode.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Item Id: " + Items.getItemsForReceivingASN(0));
					Thread.sleep(2000);
					InvType.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Thread.sleep(2000);
					Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					Screenshots.captureSnapshot(driver);
					Item_qty.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					Thread.sleep(2000);
					if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
						if (errorOrWarningMsg.getText().contains("Error")) {
							System.out.println("Info :- " + errorOrWarningMsg.getText());
							Steps.logger.info(errorOrWarningMsg.getText());
							globalFunc.Screenshots.seleniumSnapshot(driver);
							Steps.testRes = "Failed";
							Assert.assertTrue(false);
							//Screenshots.addingScreenshottoExentReport();
						//	acceptAndProceedBtn.click();
						//	Screenshots.captureSnapshot(driver);
							break;
						} else if (errorOrWarningMsg.getText().contains("Warning")) {
							System.out.println("Info :- " + errorOrWarningMsg.getText());
							globalFunc.Screenshots.seleniumSnapshot(driver);
							Screenshots.addingScreenshottoExentReport();
							acceptAndProceedBtn.click();
							Screenshots.captureSnapshot(driver);
						}
					}
					String fututeDate = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					Steps.logger.info("Enter fututeDate: " + fututeDate);
					String[] futureDateAsArray = fututeDate.split("-");
					// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					//List <WebElement> shipbyDate=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
					if(SeleniumTestHelper.isElementDisplayed(mm)) {
					mm.sendKeys(futureDateAsArray[0]);
					dd.sendKeys(futureDateAsArray[1]);
					Screenshots.captureSnapshot(driver);
					yyyy.sendKeys(futureDateAsArray[2]);
					}
					Thread.sleep(3000);
					Screenshots.captureSnapshot(driver);
					//List <WebElement> acceptprocBtn=   driver.findElements(By.id("rfbtn_dataForm:InfoAcceptKey"));
					
					if(SeleniumTestHelper.isElementDisplayed(acceptAndProceedBtn)) {
					
						acceptAndProceedBtn.click();
					}
					Steps.logger.info(
							String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ LPNnum3[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
					Reporter.addStepLog(
							String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ LPNnum3[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
					Thread.sleep(2000);
					if (Steps.ItemDataMap.get(i).get("RecQty2") != "") {
						if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
							SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

							// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
							// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
							System.out.println("Rec Location-" + Steps.scenarioData.get("RecLocation"));
							Steps.logger.info("Enter Rec Location-" + Steps.scenarioData.get("RecLocation"));
							destStagingLocnInput.sendKeys(Steps.scenarioData.get("RecLocation"));
							Screenshots.captureSnapshot(driver);
							destStagingLocnInput.sendKeys(Keys.ENTER);
							Screenshots.captureSnapshot(driver);
						}
						// Thread.sleep(2000);
						lpnInputTxt.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						// for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
						// Thread.sleep(3000);
						String LPNs1 = driver.findElement(By.id("csid")).getText();
						String[] LPNnum1 = LPNs1.split(":");
						System.out.println("LPN# :" + LPNnum1[1].trim());

						iLPNz.add(LPNnum1[1].trim());
						System.out.println("LPN 2 : " + LPNnum1[1].trim());
						Reporter.addStepLog("LPN 2 : " + LPNnum1[1].trim());
						// Thread.sleep(3000);
						ItemBarcode.sendKeys(Items.getItemsForReceivingASN(i));
						Screenshots.captureSnapshot(driver);
						ItemBarcode.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Item Id: " + Items.getItemsForReceivingASN(0));
						// Thread.sleep(3000);
						InvType.sendKeys(Keys.ENTER);
						Thread.sleep(2000);
						Screenshots.captureSnapshot(driver);
						Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) );
						Screenshots.captureSnapshot(driver);
						Item_qty.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")));
						Thread.sleep(3000);

						if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
							SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
							if (errorOrWarningMsg.getText().contains("Error")) {
								System.out.println("Info :- " + errorOrWarningMsg.getText());
								globalFunc.Screenshots.seleniumSnapshot(driver);
								Screenshots.addingScreenshottoExentReport();
								acceptAndProceedBtn.click();
								Screenshots.captureSnapshot(driver);
								break;
							} else if (errorOrWarningMsg.getText().contains("Warning")) {
								System.out.println("Info :- " + errorOrWarningMsg.getText());
								globalFunc.Screenshots.seleniumSnapshot(driver);
								Screenshots.addingScreenshottoExentReport();
								acceptAndProceedBtn.click();
								Screenshots.captureSnapshot(driver);
							}
						}
						Thread.sleep(3000);
						String fututeDate1 = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						System.out.println(fututeDate1);
						Steps.logger.info("Enter fututeDate: " + fututeDate1);
						String[] futureDateAsArray1 = fututeDate1.split("-");
						// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						//List <WebElement> shipbyDate2=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
						if(SeleniumTestHelper.isElementDisplayed(mm)) {
						mm.sendKeys(futureDateAsArray1[0]);
						dd.sendKeys(futureDateAsArray1[1]);
						Screenshots.captureSnapshot(driver);
						yyyy.sendKeys(futureDateAsArray1[2]);
						}
						Thread.sleep(3000);
						Screenshots.captureSnapshot(driver);
						acceptAndProceedBtn.click();
						Screenshots.captureSnapshot(driver);
						Steps.logger.info(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) + " qty is received in LPN "
										+ LPNnum1[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
						Reporter.addStepLog(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) + " qty is received in LPN "
										+ LPNnum1[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
						Thread.sleep(2000);
					}
				} 
					
					RFmenu_info.click();
					Steps.logger.info("Clicked on RF Menu");
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, EndPallet, 20);
					EndPallet.click();
					Steps.logger.info("Clicked on EndPallet Menu");
					Thread.sleep(2000);
					if(SeleniumTestHelper.isElementDisplayed(acceptAndProceedBtn)) {
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, acceptAndProceedBtn, 20);
					acceptAndProceedBtn.click();
					}
				
				}
				Steps.logger.info("Completed Receiving using MM3 Recv Pallet option");
				break;
				
			case "MM3 Rec-PLT-Ptwy":
				System.out.println("Receiving process starting with : " + receivingMethod + " menu");
				Steps.logger.info("Receiving process starting with : " + receivingMethod + " menu");
				while (!(SeleniumTestHelper.isElementDisplayed(MM3RecPltPtway))) {
					pageDown.click();
				}
				SeleniumTestHelper.assertTrue(MM3RecPltPtway.isDisplayed());
				Screenshots.captureSnapshot(driver);
				MM3RecPltPtway.click();
				Steps.logger.info("Click on " + receivingMethod + " method");
				Thread.sleep(10000);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
				inputASN.sendKeys(Items.getAsnNumber());
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("Enter ASN number: " + Items.getAsnNumber());
				SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
				inputASN.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Screenshots.captureSnapshot(driver);
				int noOfPallets=Integer.parseInt(Steps.scenarioData.get("PltQty"));
				int bb=0;
				if (noOfPallets==1) {
					bb=Steps.ItemDataMap.size();
				}else
				{
					bb=1;
				}
				System.out.println("bb="+bb);
				for (int j = 0; j < noOfPallets; j++) {
				globalFunc.DateTime.TimeDateFunc();
				palletid.sendKeys("PLT1"+DateTime.strDate8+Keys.ENTER);
				Thread.sleep(2000);
				acceptAndProceedBtn.click();
				Thread.sleep(2000);
				String palletId = driver.findElement(By.id("p123")).getText();
				String[] palletIds = palletId.split(":");
				System.out.println("palletId# :" + palletIds[1].trim());

				palletIdz.add(palletIds[1].trim());
				System.out.println("palletId: " + palletIds[1].trim());
				Reporter.addStepLog("palletId : " + palletIds[1].trim());
				int i=0;
				for(int k=0;k<bb;k++) {
					
					 i=j+k;
					if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
						SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

						// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
						// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
						System.out.println("Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						Steps.logger.info("Enter Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						destStagingLocnInput.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation")));
						Screenshots.captureSnapshot(driver);
						destStagingLocnInput.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
					}
					Thread.sleep(2000);
					lpnInputTxt.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					// for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					String LPNs3 = driver.findElement(By.id("csid")).getText();
					String[] LPNnum3 = LPNs3.split(":");
					System.out.println("LPN# :" + LPNnum3[1].trim());

					iLPNz.add(LPNnum3[1].trim());
					System.out.println("LPN 3: " + LPNnum3[1].trim());
					Reporter.addStepLog("LPN 3 : " + LPNnum3[1].trim());
					// Thread.sleep(3000);
					Thread.sleep(3000);
					ItemBarcode.sendKeys(Steps.ItemDataMap.get(i).get("Item"));
					Screenshots.captureSnapshot(driver);
					ItemBarcode.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Item Id: " + Items.getItemsForReceivingASN(0));
					Thread.sleep(2000);
					InvType.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Thread.sleep(2000);
					Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					Screenshots.captureSnapshot(driver);
					Item_qty.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					Thread.sleep(2000);
					String fututeDate = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					Steps.logger.info("Enter fututeDate: " + fututeDate);
					String[] futureDateAsArray = fututeDate.split("-");
					if(SeleniumTestHelper.isElementDisplayed(mm)) {
					mm.sendKeys(futureDateAsArray[0]);
					dd.sendKeys(futureDateAsArray[1]);
					Screenshots.captureSnapshot(driver);
					yyyy.sendKeys(futureDateAsArray[2]);
					}
					Thread.sleep(3000);
					Screenshots.captureSnapshot(driver);
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
					System.out.println("Info :- " + errorOrWarningMsg.getText());

					String errorOrWarningMsgs = errorOrWarningMsg.getText();
					String[] errorOrWarningMsgs1 = errorOrWarningMsgs.split(" ");

					System.out.println("LPN is: " + errorOrWarningMsgs1[1]);
					LPNVal = errorOrWarningMsgs1[1];
					Thread.sleep(2000);
					acceptAndProceedBtn.click();
					Thread.sleep(2000);
					Screenshots.captureSnapshot(driver);
					if(SeleniumTestHelper.isElementDisplayed(acceptAndProceedBtn)) {
						acceptAndProceedBtn.click();
					}
					Steps.logger.info(
							String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ LPNnum3[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
					Reporter.addStepLog(
							String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ LPNnum3[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
					Thread.sleep(2000);
					if (Steps.ItemDataMap.get(i).get("RecQty2") != "") {
						if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
							SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

							// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
							// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
							System.out.println("Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
							Steps.logger.info("Enter Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
							destStagingLocnInput.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation")));
							Screenshots.captureSnapshot(driver);
							destStagingLocnInput.sendKeys(Keys.ENTER);
							Screenshots.captureSnapshot(driver);
						}
						// Thread.sleep(2000);
						lpnInputTxt.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						// for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
						// Thread.sleep(3000);
						String LPNs1 = driver.findElement(By.id("csid")).getText();
						String[] LPNnum1 = LPNs1.split(":");
						System.out.println("LPN# :" + LPNnum1[1].trim());

						iLPNz.add(LPNnum1[1].trim());
						System.out.println("LPN 2 : " + LPNnum1[1].trim());
						Reporter.addStepLog("LPN 2 : " + LPNnum1[1].trim());
						// Thread.sleep(3000);
						ItemBarcode.sendKeys(Items.getItemsForReceivingASN(i));
						Screenshots.captureSnapshot(driver);
						ItemBarcode.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Item Id: " + Items.getItemsForReceivingASN(0));
						// Thread.sleep(3000);
						InvType.sendKeys(Keys.ENTER);
						Thread.sleep(2000);
						Screenshots.captureSnapshot(driver);
						Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) );
						Screenshots.captureSnapshot(driver);
						Item_qty.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")));
						Thread.sleep(3000);

						if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
							SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
							if (errorOrWarningMsg.getText().contains("Error")) {
								System.out.println("Info :- " + errorOrWarningMsg.getText());
								globalFunc.Screenshots.seleniumSnapshot(driver);
								Screenshots.addingScreenshottoExentReport();
								acceptAndProceedBtn.click();
								Screenshots.captureSnapshot(driver);
								break;
							} else if (errorOrWarningMsg.getText().contains("Warning")) {
								System.out.println("Info :- " + errorOrWarningMsg.getText());
								globalFunc.Screenshots.seleniumSnapshot(driver);
								Screenshots.addingScreenshottoExentReport();
								acceptAndProceedBtn.click();
								Screenshots.captureSnapshot(driver);
							}
						}
						Thread.sleep(3000);
						String fututeDate1 = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						System.out.println(fututeDate1);
						Steps.logger.info("Enter fututeDate: " + fututeDate1);
						String[] futureDateAsArray1 = fututeDate1.split("-");
						// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						List <WebElement> shipbyDate2=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
						if(shipbyDate2.size()!=0) {
						mm.sendKeys(futureDateAsArray1[0]);
						dd.sendKeys(futureDateAsArray1[1]);
						Screenshots.captureSnapshot(driver);
						yyyy.sendKeys(futureDateAsArray1[2]);
						}
						Thread.sleep(3000);
						Screenshots.captureSnapshot(driver);
						if(SeleniumTestHelper.isElementDisplayed(acceptAndProceedBtn)) {
						acceptAndProceedBtn.click();
						}
						Screenshots.captureSnapshot(driver);
						Steps.logger.info(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) + " qty is received in LPN "
										+ LPNnum1[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
						Reporter.addStepLog(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) + " qty is received in LPN "
										+ LPNnum1[1].trim() + " for Item- " + Items.getItemsForReceivingASN(i));
						Thread.sleep(2000);
					}
				} 
					
					RFmenu_info.click();
					Steps.logger.info("Clicked on RF Menu");
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, EndPallet, 20);
					EndPallet.click();
					Steps.logger.info("Clicked on EndPallet Menu");
					Thread.sleep(2000);
					if(SeleniumTestHelper.isElementDisplayed(acceptAndProceedBtn)) {
					acceptAndProceedBtn.click();
					}
					// Reporter.addStepLog(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty"))+"
					// qty is received in LPN "+iLPNz.get(i)+" for Item-
					// "+Steps.ItemDataMap.get(i).get("Item"));
					Thread.sleep(4000);
					String sysSuggestedLoc = altsuggestedLocLabel.getText();
					String[] sysSuggestedLocSplit = sysSuggestedLoc.split(" ");
					newSysSuggestedLoc = sysSuggestedLocSplit[1];
					String[] spltarr = sysSuggestedLocSplit[1].split("-");
					String str = GlobalClass.removeZero(spltarr[1]);
					System.out.println(str);
					spltarr[1] = str;
					String updtLoc = "";
					for (String a : spltarr)
						updtLoc = updtLoc + a;

					System.out.println("updtLoc is: " + updtLoc);

					locationInput.sendKeys(updtLoc);
					Screenshots.captureSnapshot(driver);
					locationInput.sendKeys( Keys.ENTER);
					Thread.sleep(2000);
					Screenshots.captureSnapshot(driver);
					if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
						if (errorOrWarningMsg.getText().contains("Error")) {
							System.out.println("Info :- " + errorOrWarningMsg.getText());
							Steps.logger.info(errorOrWarningMsg.getText());
							globalFunc.Screenshots.seleniumSnapshot(driver);
							Steps.testRes = "Failed";
							Assert.assertTrue(false);
						}
					}
				
				}
				Steps.logger.info("Completed Receiving");
				break;
				
				
			case "MM3 Returns":
				Screenshots.captureSnapshot(driver);
				System.out.println("Receiving process starting with : " + receivingMethod + " menu");
				Steps.logger.info("Receiving process starting with : " + receivingMethod + " menu");
				while (!(SeleniumTestHelper.isElementDisplayed(MM3Returns))) {
					pageDown.click();
				}
				SeleniumTestHelper.assertTrue(MM3Returns.isDisplayed());
				Screenshots.captureSnapshot(driver);
				MM3Returns.click();
				Steps.logger.info("Click on " + receivingMethod + " method");
				Screenshots.captureSnapshot(driver);
				Thread.sleep(2000);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
				if (Items.getAsnNumber() == null) {
					// System will generate ASN No
					inputASN.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					Screenshots.captureSnapshot(driver);
					acceptAndProceedBtn.click();
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("ASN is generated by system");

				} else {
					inputASN.sendKeys(Items.getAsnNumber());
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("ASN number: " + Steps.scenarioData.get("ASNId"));
					SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
					inputASN.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
				}

				for (int i = 0, j = 1; i < Steps.ItemDataMap.size(); i++, j++) {
					if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
						
						SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

						// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
						// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
						System.out.println("Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						Steps.logger.info("Enter Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						destStagingLocnInput.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation")));
						Screenshots.captureSnapshot(driver);
						destStagingLocnInput.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
					}
					
					String ASNId = getASNID.getText();
					String[] asnNo = ASNId.split(":");
					Items.setAsnNumber(asnNo[1].trim());
					System.out.println(Items.getAsnNumber());
					Steps.logger.info("ASN No-" + Items.getAsnNumber());
					Reporter.addStepLog("ASN No-" + Items.getAsnNumber());
					lpnInputTxt.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					String LPNs = driver.findElement(By.id("csid")).getText();
					String[] LPNnum = LPNs.split(":");
					System.out.println("LPN# :" + LPNnum[1].trim());

					iLPNz.add(LPNnum[1].trim());
					System.out.println("LPN " + j + " : " + iLPNz.get(i));
					Reporter.addStepLog("LPN " + j + " : " + iLPNz.get(i));
					ItemBarcode.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("Item")));
					Screenshots.captureSnapshot(driver);
					ItemBarcode.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Item Id: " + Steps.ItemDataMap.get(i).get("Item"));
					Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					Screenshots.captureSnapshot(driver);
					Item_qty.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));

					if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
						System.out.println("Info :- " + errorOrWarningMsg.getText());
						globalFunc.Screenshots.seleniumSnapshot(driver);
						Screenshots.addingScreenshottoExentReport();
						acceptAndProceedBtn.click();
						Screenshots.captureSnapshot(driver);
						// Assert.fail("Info :- " + errorOrWarningMsg.getText());
						break;
					}
					String fututeDate = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					
					Steps.logger.info("Enter fututeDate: " + fututeDate);
					String[] futureDateAsArray = fututeDate.split("-");
					// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					List <WebElement> shipbyDate=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
					if(shipbyDate.size()!=0) {
					mm.sendKeys(futureDateAsArray[0]);
					dd.sendKeys(futureDateAsArray[1]);
					Screenshots.captureSnapshot(driver);
					yyyy.sendKeys(futureDateAsArray[2]);
					}
					
					Thread.sleep(2000);
					Screenshots.captureSnapshot(driver);
					if (SeleniumTestHelper.isElementDisplayed(returnCode)) {
						SeleniumTestHelper.assertEquals(returnCode.isDisplayed(), true);
						returnCode.sendKeys(Steps.ItemDataMap.get(i).get("ReturnCode"));
						Screenshots.captureSnapshot(driver);
						returnCode.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Return Code: " + Steps.ItemDataMap.get(i).get("ReturnCode"));
					}
					if (SeleniumTestHelper.isElementDisplayed(finalDispCode)) {
						SeleniumTestHelper.assertEquals(finalDispCode.isDisplayed(), true);
						finalDispCode.sendKeys(Keys.ENTER);
					}
						Screenshots.captureSnapshot(driver);
					acceptAndProceedBtn.click();
						Screenshots.captureSnapshot(driver);
					Steps.logger
							.info(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ iLPNz.get(i) + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
					Reporter.addStepLog(
							String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ iLPNz.get(i) + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
					if (Steps.ItemDataMap.get(i).get("RecQty2") != "") {
						if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
							SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

							// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
							// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
							System.out.println("Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
							
							Steps.logger.info("Enter Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
							destStagingLocnInput
									.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation")) );
								Screenshots.captureSnapshot(driver);
								destStagingLocnInput.sendKeys( Keys.ENTER);
								Screenshots.captureSnapshot(driver);
						}
						lpnInputTxt.sendKeys(Keys.ENTER);
							Screenshots.captureSnapshot(driver);
						// for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
						Thread.sleep(3000);
						String LPNs1 = driver.findElement(By.id("csid")).getText();
						String[] LPNnum1 = LPNs1.split(":");
						System.out.println("LPN# :" + LPNnum1[1].trim());

						iLPNz.add(LPNnum1[1].trim());
						System.out.println("LPN 2 : " + LPNnum1[1].trim());
						Reporter.addStepLog("LPN 2 : " + LPNnum1[1].trim());
						ItemBarcode.sendKeys(Steps.ItemDataMap.get(i).get("Item"));
						Screenshots.captureSnapshot(driver);
						ItemBarcode.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Item Id: " + Items.getItemsForReceivingASN(0));
						InvType.sendKeys(Keys.ENTER);
						Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")));
						Screenshots.captureSnapshot(driver);
						Item_qty.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")));

						if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
							SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
							System.out.println("Info :- " + errorOrWarningMsg.getText());
							globalFunc.Screenshots.seleniumSnapshot(driver);
							Screenshots.addingScreenshottoExentReport();
							acceptAndProceedBtn.click();
							Screenshots.captureSnapshot(driver);

							// Assert.fail("Info :- " + errorOrWarningMsg.getText());
							break;
						}
						String fututeDate1 = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						Steps.logger.info("Enter fututeDate: " + fututeDate1);
						String[] futureDateAsArray1 = fututeDate1.split("-");
						// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						List <WebElement> shipbyDate2=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
						if(shipbyDate2.size()!=0) {
						mm.sendKeys(futureDateAsArray1[0]);
						dd.sendKeys(futureDateAsArray1[1]);
						yyyy.sendKeys(futureDateAsArray1[2]);
						Screenshots.captureSnapshot(driver);
						}
						acceptAndProceedBtn.click();
						Screenshots.captureSnapshot(driver);
						Steps.logger.info(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) + " qty is received in LPN "
										+ LPNnum1[1].trim() + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
						Reporter.addStepLog(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) + " qty is received in LPN "
										+ LPNnum1[1].trim() + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));

					}
				}
				Steps.logger.info("Completed Receiving");
				/*
				 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg,
				 * 50); System.out.println("Info :- " + errorOrWarningMsg.getText());
				 * SeleniumTestHelper.assertTrue(errorOrWarningMsg.isDisplayed());
				 * acceptAndProceedBtn.click();
				 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
				 * 
				 * for (int i = 0; i < noOfItems; i++) { iLPN =
				 * Items.getItemILPN(Items.getItemsForReceivingASN(i));
				 * System.out.println("iLPN : " + iLPN + " for the product : " +
				 * Items.getItemsForReceivingASN(i)); }
				 */
				break;

			case "MM3 Recv-Damages":
				System.out.println("Receiving process starting with : " + receivingMethod + " menu");
				Steps.logger.info("Receiving process starting with : " + receivingMethod + " menu");
				while (!(SeleniumTestHelper.isElementDisplayed(MM3recDmg))) {
					pageDown.click();
				}
				SeleniumTestHelper.assertTrue(MM3recDmg.isDisplayed());
				Screenshots.captureSnapshot(driver);
				MM3recDmg.click();
				Steps.logger.info("Click on " + receivingMethod + " method");
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, inputASN, 50);
				if (Items.getAsnNumber() == null) {
					// System will generate ASN No
					inputASN.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					Screenshots.captureSnapshot(driver);
					acceptAndProceedBtn.click();
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("ASN is generated by system");

				} else {
					inputASN.sendKeys(Items.getAsnNumber());
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("ASN number: " + Steps.scenarioData.get("ASNId"));
					SeleniumTestHelper.assertTrue(inputASN.isDisplayed());
					inputASN.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
				}

				for (int i = 0, j = 1; i < Steps.ItemDataMap.size(); i++, j++) {
					if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
						SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

						// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
						// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
						System.out.println("Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						Steps.logger.info("Enter Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
						destStagingLocnInput
								.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation")));
						Screenshots.captureSnapshot(driver);
						destStagingLocnInput.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
					}
					String ASNId = getASNID.getText();
					String[] asnNo = ASNId.split(":");
					Items.setAsnNumber(asnNo[1].trim());
					System.out.println(Items.getAsnNumber());
					Steps.logger.info("ASN No-" + Items.getAsnNumber());
					Reporter.addStepLog("ASN No-" + Items.getAsnNumber());
					lpnInputTxt.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					String LPNs = driver.findElement(By.id("csid")).getText();
					String[] LPNnum = LPNs.split(":");
					System.out.println("LPN# :" + LPNnum[1].trim());

					iLPNz.add(LPNnum[1].trim());
					System.out.println("LPN " + j + " : " + iLPNz.get(i));
					Reporter.addStepLog("LPN " + j + " : " + iLPNz.get(i));
					ItemBarcode.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("Item")) );
					Screenshots.captureSnapshot(driver);
					ItemBarcode.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Item Id: " + Steps.ItemDataMap.get(i).get("Item"));
					InvType.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					Screenshots.captureSnapshot(driver);
					Item_qty.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));

					if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
						System.out.println("Info :- " + errorOrWarningMsg.getText());
						globalFunc.Screenshots.seleniumSnapshot(driver);
						Screenshots.addingScreenshottoExentReport();
						acceptAndProceedBtn.click();
						Screenshots.captureSnapshot(driver);
						// Assert.fail("Info :- " + errorOrWarningMsg.getText());
						break;
					}
					String fututeDate = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					Steps.logger.info("Enter fututeDate: " + fututeDate);
					String[] futureDateAsArray = fututeDate.split("-");
					// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					//List <WebElement> shipbyDate=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
					if(SeleniumTestHelper.isElementDisplayed(mm)) {
					mm.sendKeys(futureDateAsArray[0]);
					dd.sendKeys(futureDateAsArray[1]);
					Screenshots.captureSnapshot(driver);
					yyyy.sendKeys(futureDateAsArray[2]);
					}
					Thread.sleep(2000);
					Screenshots.captureSnapshot(driver);
					if (SeleniumTestHelper.isElementDisplayed(returnCode)) {
						SeleniumTestHelper.assertEquals(returnCode.isDisplayed(), true);
						returnCode.sendKeys(Steps.ItemDataMap.get(i).get("ReturnCode") );
						Screenshots.captureSnapshot(driver);
						returnCode.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Return Code: " + Steps.ItemDataMap.get(i).get("ReturnCode"));
					}
					if (SeleniumTestHelper.isElementDisplayed(finalDispCode)) {
						SeleniumTestHelper.assertEquals(finalDispCode.isDisplayed(), true);
						finalDispCode.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
					}
					acceptAndProceedBtn.click();
					Screenshots.captureSnapshot(driver);
					Steps.logger
							.info(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ iLPNz.get(i) + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
					Reporter.addStepLog(
							String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ iLPNz.get(i) + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
					if (Steps.ItemDataMap.get(i).get("RecQty2") != "") {
						if (SeleniumTestHelper.isElementDisplayed(destStagingLocn)) {
							SeleniumTestHelper.assertEquals(destStagingLocnInput.isDisplayed(), true);

							// System.out.println("Rec Location-"+Steps.scenarioData.get("RecLocation"));
							// destStagingLocnInput.sendKeys(String.valueOf(Steps.scenarioData.get("RecLocation"))+Keys.ENTER);
							System.out.println("Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
							Steps.logger.info("Enter Rec Location-" + Steps.ItemDataMap.get(i).get("RecLocation"));
							destStagingLocnInput
									.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecLocation")));
							Screenshots.captureSnapshot(driver);
							destStagingLocnInput.sendKeys( Keys.ENTER);
							Screenshots.captureSnapshot(driver);
						}
						lpnInputTxt.sendKeys(Keys.ENTER);
						// for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
						Thread.sleep(3000);
						Screenshots.captureSnapshot(driver);
						String LPNs1 = driver.findElement(By.id("csid")).getText();
						String[] LPNnum1 = LPNs1.split(":");
						System.out.println("LPN# :" + LPNnum1[1].trim());

						iLPNz.add(LPNnum1[1].trim());
						System.out.println("LPN 2 : " + LPNnum1[1].trim());
						Reporter.addStepLog("LPN 2 : " + LPNnum1[1].trim());
						ItemBarcode.sendKeys(Steps.ItemDataMap.get(i).get("Item"));
						Screenshots.captureSnapshot(driver);
						ItemBarcode.sendKeys( Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Item Id: " + Items.getItemsForReceivingASN(0));
						InvType.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						Item_qty.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")));
						Screenshots.captureSnapshot(driver);
						Item_qty.sendKeys(Keys.ENTER);
								Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")));

						if (SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {
							SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
							System.out.println("Info :- " + errorOrWarningMsg.getText());
							globalFunc.Screenshots.seleniumSnapshot(driver);
							Screenshots.addingScreenshottoExentReport();
							acceptAndProceedBtn.click();
							Screenshots.captureSnapshot(driver);

							// Assert.fail("Info :- " + errorOrWarningMsg.getText());
							break;
						}
						String fututeDate1 = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						Steps.logger.info("Enter fututeDate: " + fututeDate1);
						String[] futureDateAsArray1 = fututeDate1.split("-");
						// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
						List <WebElement> shipbyDate2=  driver.findElements(By.id("dataForm:sidzeInpPart0"));
						if(shipbyDate2.size()!=0) {
						mm.sendKeys(futureDateAsArray1[0]);
						dd.sendKeys(futureDateAsArray1[1]);
						Screenshots.captureSnapshot(driver);
						yyyy.sendKeys(futureDateAsArray1[2]);
						}
						acceptAndProceedBtn.click();
						Screenshots.captureSnapshot(driver);
						Steps.logger.info(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) + " qty is received in LPN "
										+ LPNnum1[1].trim() + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
						Reporter.addStepLog(
								String.valueOf(Steps.ItemDataMap.get(i).get("RecQty2")) + " qty is received in LPN "
										+ LPNnum1[1].trim() + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));

					}
				}
				Steps.logger.info("Completed Receiving");
				break;

			default:
				System.out.println("Receiving process starting with : " + receivingMethod + " menu");
				break;
			}
			System.out.println("Receiving process completed with : " + receivingMethod + " menu");
			homepage.userClosesOpenedwindow("RF Menu");
			Thread.sleep(5000);
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red" + Steps.testRes);
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}

	}

	public void inventoryFunctions(String inventoryFunctions) throws Exception {
		try {
			String iLPN = null;
			Steps.logger.info("Start Inventory Functions");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 20);
			RFmenu_info.click();
			Steps.logger.info("CLicked on RF Menu");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
			Mainmenu.click();
			Steps.logger.info("Clicked on Main Menu");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfMenuReceiving, 20);
			while (!(SeleniumTestHelper.isElementDisplayed(inventoryMgmtMenu))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(inventoryMgmtMenu.isDisplayed());
			Screenshots.captureSnapshot(driver);
			inventoryMgmtMenu.click();
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Clicked on Inventory");
			switch (inventoryFunctions) {
			case "RF MM3 Create iLPN":
				System.out.println("iLPN creation started with : " + inventoryFunctions + " menu");
				Steps.logger.info("iLPN creation started with : " + inventoryFunctions + " menu");
				while (!(SeleniumTestHelper.isElementDisplayed(MM3createiLPN))) {
					pageDown.click();
				}
				SeleniumTestHelper.assertTrue(MM3createiLPN.isDisplayed());
				MM3createiLPN.click();
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("Click on " + inventoryFunctions + " method");
				for (int i = 0, j = 1; i < Steps.ItemDataMap.size(); i++, j++) {
					ilpnInRFcreateilpnTxtBox.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					String LPNs = driver.findElement(By.id("iblpn1")).getText();
					String[] LPNnum = LPNs.split(":");
					System.out.println("LPN# :" + LPNnum[1].trim());

					iLPNz.add(LPNnum[1].trim());
					System.out.println("LPN " + j + " : " + iLPNz.get(i));
					Reporter.addStepLog("LPN " + j + " : " + iLPNz.get(i));
					itemBarcodeInRFcreateIlpnTxtBox
							.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("Item")) );
					Screenshots.captureSnapshot(driver);
					itemBarcodeInRFcreateIlpnTxtBox.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					//Product status
					Steps.logger.info("Enter Item Id: " + Steps.ItemDataMap.get(i).get("Item"));
					inventoryTypeInRFcreateIlpnTxtBox.sendKeys(Keys.ENTER);
					//List <WebElement> PS= driver.findElements(By.xpath("//input[@id='dataForm:prodStatus']"));
				//	if(PS.size()>0) {
					if(SeleniumTestHelper.isElementDisplayed(productStatusTxtBox)) {
					productStatusTxtBox.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("ProductStatus")));
					Screenshots.captureSnapshot(driver);
					productStatusTxtBox.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					}
					qtyPackedInRFcreateIlpnTxtBox.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));
					Screenshots.captureSnapshot(driver);
					qtyPackedInRFcreateIlpnTxtBox.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")));

					String fututeDate = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					List <WebElement> shipbyDate2=  driver.findElements(By.id("dataForm:shp1Part0"));
					if(shipbyDate2.size()!=0) {
					Steps.logger.info("Enter fututeDate: " + fututeDate);
					String[] futureDateAsArray = fututeDate.split("-");
					// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
					mmInRFcreateIlpnTxtBox.sendKeys(futureDateAsArray[0]);
					ddInRFcreateIlpnTxtBox.sendKeys(futureDateAsArray[1]);
					//Screenshots.captureSnapshot(driver);
					yyInRFcreateIlpnTxtBox.sendKeys(futureDateAsArray[2]);
					}
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, acceptAndProceedBtn, 20);
					acceptAndProceedBtn.click();
					Screenshots.captureSnapshot(driver);
					Steps.logger
							.info(String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ iLPNz.get(i) + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
					Reporter.addStepLog(
							String.valueOf(Steps.ItemDataMap.get(i).get("RecQty")) + " qty is received in LPN "
									+ iLPNz.get(i) + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
				}
				Steps.logger.info("iLPN created successfully");
				break;
				
			case "Consume iLPN" :
			{
				while (!(SeleniumTestHelper.isElementDisplayed(COnsumeiLPN))) {
					pageDown.click();
					Thread.sleep(5000);
				}
				SeleniumTestHelper.assertTrue(COnsumeiLPN.isDisplayed());
				Screenshots.captureSnapshot(driver);
				COnsumeiLPN.click();
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("Clicked on COnsume iLPN method");
				for (int i = 0; i < iLPNz.size(); i++) {
					SeleniumTestHelper.isElementDisplayed(consumeilpnTxtBox);
					consumeilpnTxtBox.sendKeys(iLPNz.get(i));
					Screenshots.captureSnapshot(driver);
					consumeilpnTxtBox.sendKeys( Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					SeleniumTestHelper.isElementDisplayed(consumeilpnRefTxtBox);
					consumeilpnRefTxtBox.sendKeys(Steps.ItemDataMap.get(i).get("Reference"));
					Screenshots.captureSnapshot(driver);
					consumeilpnRefTxtBox.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
				}		
				Steps.logger.info("iLPN is consumed");
				Reporter.addStepLog("iLPN is consumed");
				break;
			}
			case "MM3 Cancel oLPN":
				int ii=0;
				while (!(SeleniumTestHelper.isElementDisplayed(rfCancelolpnOption))) {
					pageDown.click();
				}
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfCancelolpnOption, 50);
				rfCancelolpnOption.click();
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, MM3oLPNInquirytxtBox, 50);
				for(ii=0;ii<Items.getoLPNListSize();ii++) {
					MM3oLPNInquirytxtBox.sendKeys(Items.getoLPN(ii)+Keys.TAB);
					Thread.sleep(2000);
				if(SeleniumTestHelper.isElementDisplayed(errorOrWarningMsg)) {	
					if(errorOrWarningMsg.getText().contains("oLPN is in shipped status and cannot be cancelled"))
					{
						Steps.logger.info(errorOrWarningMsg.getText());
						Thread.sleep(1000);
						Screenshots.captureSnapshot(driver);
						acceptAndProceedBtn.click();
						Thread.sleep(2000);
						//Assert.assertEquals(errorOrWarningMsg.getText(), "oLPN is in shipped status and cannot be cancelled","oLPN cancellation status: ");
					
					}else if(errorOrWarningMsg.getText().contains("oLPN is already in cancelled status"))
					{
						Steps.logger.info(errorOrWarningMsg.getText());
						Thread.sleep(1000);
						Screenshots.captureSnapshot(driver);
						acceptAndProceedBtn.click();
						Thread.sleep(2000);
						//Assert.assertEquals(errorOrWarningMsg.getText(), "oLPN is already in cancelled status","oLPN cancellation status: ");
					Assert.assertTrue(false);
					break;
					
					}else if(errorOrWarningMsg.getText().contains("Invalid Barcode - Carton / EAN prefix"))
					{
						Steps.logger.info(errorOrWarningMsg.getText());
						Thread.sleep(1000);
						Screenshots.captureSnapshot(driver);
						acceptAndProceedBtn.click();
						Thread.sleep(2000);
						Assert.assertEquals(errorOrWarningMsg.getText(), "Invalid Barcode - Carton / EAN prefix","oLPN cancellation status: ");
						Assert.assertTrue(false);
						break;
					}
					/*
					 * else if (errorOrWarningMsg.getText().contains("Error")) { Thread.sleep(1000);
					 * Screenshots.captureSnapshot(driver); Steps.testRes = "Failed";
					 * Assert.assertTrue(false); }
					 */
				}
				if(Steps.scenarioData.get("canceloLPNFlag")!="") {
					if(Integer.parseInt(Steps.scenarioData.get("canceloLPNFlag"))==1&& ii==0)
					{
						System.out.println("inside parseint");
						break;
					}
				}
				}
				Steps.logger.info("oLPN is cancelled");
				Reporter.addStepLog("oLPN is cancelled");
				
				break;
				
			case "MM3 split OLPN":
				//split OLPN functionality 
					
					while (!(SeleniumTestHelper.isElementDisplayed(SplitCmbneoLPN))) {
						pageDown.click();
						Thread.sleep(5000);
					}
					SeleniumTestHelper.assertTrue(SplitCmbneoLPN.isDisplayed());
					Screenshots.captureSnapshot(driver);
					SplitCmbneoLPN.click();
					Steps.logger.info("Click on splitCmbneoLPN method");
					Thread.sleep(3000);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Enter the value of oLPN: " + Items.getoLPN(0));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, SplitFromoLPNtextbox, 20);
					SplitFromoLPNtextbox.sendKeys(Items.getoLPN(0));
					Screenshots.captureSnapshot(driver);
					SplitFromoLPNtextbox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);				
					Screenshots.captureSnapshot(driver);
					SeleniumTestHelper.waitForElementToBeDisplayed(driver,SplitToLPNtextbox, 20);
					String stringdate=DateTime.current_date_time();	
					System.out.println(stringdate);
					SplitToLPNtextbox.sendKeys(stringdate);
					SplitToLPNtextbox.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Entered to OLPN number");
					Thread.sleep(2000);
					SeleniumTestHelper.waitForElementToBeDisplayed(driver,Splititembarcodetextbox, 20);
					
					for (int i = 0 ; i < Steps.ItemDataMap.size(); i++) {
							System.out.println("Item" + Steps.ItemDataMap.get(i).get("Item"));											
							Steps.logger.info("Item-" + Steps.ItemDataMap.get(i).get("Item"));						
							Splititembarcodetextbox.sendKeys(Steps.ItemDataMap.get(i).get("Item"));									
							Screenshots.captureSnapshot(driver);
							Splititembarcodetextbox.sendKeys(Keys.ENTER);
							Steps.logger.info("Entered barcode number");
					}
					Thread.sleep(2000);
					SeleniumTestHelper.waitForElementToBeDisplayed(driver,SplititQtytextbox, 20);
					for (int i = 0 ; i < Steps.ItemDataMap.size(); i++) {
						System.out.println("SplitoLPNQty" + Steps.ItemDataMap.get(i).get("SplitoLPNQty"));					
						Steps.logger.info("SplitoLPNQty" + Steps.ItemDataMap.get(i).get("SplitoLPNQty"));
						SplititQtytextbox.sendKeys(Steps.ItemDataMap.get(i).get("SplitoLPNQty"));							
						Screenshots.captureSnapshot(driver);
						SplititQtytextbox.sendKeys(Keys.ENTER);
						Steps.logger.info("splitted OLPN Qty");
				}	
								
					Steps.logger.info("OLPN splitted successfully");
					break;
					
					//JAYAREDDY
				case "MM3 cmbne OLPN":
					//Cmbne OLPN functionality 
						
						while (!(SeleniumTestHelper.isElementDisplayed(SplitCmbneoLPN))) {
							pageDown.click();
							Thread.sleep(5000);
						}
						SeleniumTestHelper.assertTrue(SplitCmbneoLPN.isDisplayed());
						Screenshots.captureSnapshot(driver);
						SplitCmbneoLPN.click();
						Steps.logger.info("Click on SplitCmbneoLPN method");
						Thread.sleep(3000);
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter the value of oLPN: " + Items.getoLPN(0));
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, SplitFromoLPNtextbox, 20);
						SplitFromoLPNtextbox.sendKeys(Items.getoLPN(0));
						Screenshots.captureSnapshot(driver);
						Thread.sleep(2000);
						if(SeleniumTestHelper.isElementDisplayed(SplitFromoLPNtextbox)) {
						SplitFromoLPNtextbox.sendKeys(Keys.ENTER);
						}
						Thread.sleep(1000);	
						
						Screenshots.captureSnapshot(driver);
						Steps.logger.info("Enter the value of oLPN: " + Items.getoLPN(1));
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, SplitToLPNtextbox, 20);
						SplitToLPNtextbox.sendKeys(Items.getoLPN(1));
						Screenshots.captureSnapshot(driver);
						SplitToLPNtextbox.sendKeys(Keys.ENTER);
						
						
						
						Thread.sleep(2000);
						SeleniumTestHelper.waitForElementToBeDisplayed(driver,Splititembarcodetextbox, 20);
						
						for (int i = 0 ; i < Steps.ItemDataMap.size(); i++) {
								System.out.println("Item" + Steps.ItemDataMap.get(i).get("Item"));											
								Steps.logger.info("Item-" + Steps.ItemDataMap.get(i).get("Item"));						
								Splititembarcodetextbox.sendKeys(Steps.ItemDataMap.get(i).get("Item"));									
								Screenshots.captureSnapshot(driver);
								Splititembarcodetextbox.sendKeys(Keys.ENTER);
								Steps.logger.info("Entered barcode number");
						}
						Thread.sleep(2000);
						SeleniumTestHelper.waitForElementToBeDisplayed(driver,SplititQtytextbox, 20);
						for (int i = 0 ; i < Steps.ItemDataMap.size(); i++) {
							System.out.println("CmbneOLPNQty" + Steps.ItemDataMap.get(i).get("CmbneOLPNQty"));					
							Steps.logger.info("CmbneOLPNQty" + Steps.ItemDataMap.get(i).get("CmbneOLPNQty"));
							SplititQtytextbox.sendKeys(Steps.ItemDataMap.get(i).get("CmbneOLPNQty"));							
							Screenshots.captureSnapshot(driver);
							SplititQtytextbox.sendKeys(Keys.ENTER);
							Steps.logger.info("Combined OLPN Qty");
					}	
						
						Steps.logger.info("OLPN combined successfully");
						break;	
					
				case "MM3 Pack From Trans":
					System.out.println("iLPN creation started with : " + inventoryFunctions + " menu");
					Steps.logger.info("iLPN creation started with : " + inventoryFunctions + " menu");
					while (!(SeleniumTestHelper.isElementDisplayed(MM3PACKTRANS))) {
						pageDown.click();
					}	
					
					SeleniumTestHelper.assertTrue(MM3PACKTRANS.isDisplayed());
					MM3PACKTRANS.click();
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Click on " + inventoryFunctions + " method");
					
					for (int i = 0, j = 1; i < Steps.ItemDataMap.size(); i++, j++) {
						
						ilpnInRFcreateilpnTxtBox.sendKeys(Keys.ENTER);
						Screenshots.captureSnapshot(driver);
						String LPNs = driver.findElement(By.id("iblpn1")).getText();
						String[] LPNnum = LPNs.split(":");
						System.out.println("LPN# :" + LPNnum[1].trim());
				
						
						iLPNz.add(LPNnum[1].trim());
						System.out.println("LPN " + j + " : " + iLPNz.get(i));
						Reporter.addStepLog("LPN " + j + " : " + iLPNz.get(i));
			
						TL.sendKeys(Keys.ENTER);
					
						
				
						itemBarcodeInRFcreateIlpnTxtBox
						.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("Item")) );
				Screenshots.captureSnapshot(driver);
				itemBarcodeInRFcreateIlpnTxtBox.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				//Product status
				Steps.logger.info("Enter Item Id: " + Steps.ItemDataMap.get(i).get("Item"));
				
				
				
				qtyPackedInRFcreateIlpnTxtBox.sendKeys(String.valueOf(Steps.ItemDataMap.get(i).get("ShippedQty")));
				Screenshots.captureSnapshot(driver);
				qtyPackedInRFcreateIlpnTxtBox.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("Enter Qty: " + String.valueOf(Steps.ItemDataMap.get(i).get("ShippedQty")));
		
				
				String fututeDate = String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
				
				
				List <WebElement> shipbyDate2=  driver.findElements(By.id("dataForm:shp1Part0"));
				if(shipbyDate2.size()!=0) {
				Steps.logger.info("Enter fututeDate: " + fututeDate);
				String[] futureDateAsArray = fututeDate.split("-");
				// fututeDate=String.valueOf(Steps.ItemDataMap.get(i).get("ShipByDate"));
				mmInRFcreateIlpnTxtBox.sendKeys(futureDateAsArray[0]);
				ddInRFcreateIlpnTxtBox.sendKeys(futureDateAsArray[1]);
				//Screenshots.captureSnapshot(driver);
				yyInRFcreateIlpnTxtBox.sendKeys(futureDateAsArray[2]);
				
				Screenshots.captureSnapshot(driver);
				Steps.logger
						.info(String.valueOf(Steps.ItemDataMap.get(i).get("ShippedQty")) + " qty is received in LPN "
								+ iLPNz.get(i) + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
				Reporter.addStepLog(
						String.valueOf(Steps.ItemDataMap.get(i).get("ShippedQty")) + " qty is received in LPN "
								+ iLPNz.get(i) + " for Item- " + Steps.ItemDataMap.get(i).get("Item"));
			}
			Steps.logger.info("iLPN created successfully");
					}
			break;
			
			default:
				System.out.println("Inventory management starting with : " + inventoryFunctions + " menu");
				break;
			}
			System.out.println("Inventory management completed with : " + inventoryFunctions + " menu");
			homepage.userClosesOpenedwindow("RF Menu");
			
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red" + Steps.testRes);
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());

		}
	}
	private int Parseint(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	//jaya
	public void splitCmbneoLPN() throws Exception {

		try {
			ditributionorder.fetchoLPNSnumber();				
			homepage.MenuItems_Distribution_Selection("RF Menu");
			System.out.println("rfmenuclick");
			Thread.sleep(2000);
			SeleniumTestHelper.switchToInnerFrame(driver);
			System.out.println("frame");
			Thread.sleep(2000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
			System.out.println("rfmenuclick");
			RFmenu_info.click();
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Clicked on RF Menu");			
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			Mainmenu.click();
			Steps.logger.info("Clicked on Main Menu");
			Thread.sleep(2000);
			
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfMenuReceiving, 20);
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			while (!(SeleniumTestHelper.isElementDisplayed(inventoryMgmtMenu))) {
				pageDown.click();
				Thread.sleep(3000);
			}
			SeleniumTestHelper.assertTrue(inventoryMgmtMenu.isDisplayed());
			Screenshots.captureSnapshot(driver);
			inventoryMgmtMenu.click();
			Steps.logger.info("Clicked on Inventory method");
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
			
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, PackfromActv, 20);
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			
			while (!(SeleniumTestHelper.isElementDisplayed(SplitCmbneoLPN))) {
				pageDown.click();
				Thread.sleep(3000);
			}
			SeleniumTestHelper.assertTrue(SplitCmbneoLPN.isDisplayed());
			Screenshots.captureSnapshot(driver);
			SplitCmbneoLPN.click();
			Steps.logger.info("Click on splitCmbneoLPN method");
			Thread.sleep(3000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Enter the value of oLPN: " + Items.getoLPN(0));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, SplitFromoLPNtextbox, 20);
			SplitFromoLPNtextbox.sendKeys(Items.getoLPN(0),Keys.ENTER);
			Screenshots.captureSnapshot(driver);
			//SplitFromoLPNtextbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);	
			
			//Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver,SplitToLPNtextbox, 20);
			String stringdate=DateTime.current_date_time();	
			System.out.println(stringdate);
			SplitToLPNtextbox.sendKeys(stringdate,Keys.ENTER);
			Thread.sleep(3000);
			
			Screenshots.captureSnapshot(driver);
			//SplitToLPNtextbox.sendKeys(Keys.ENTER);
			
			
			
							
			SeleniumTestHelper.waitForElementToBeDisplayed(driver,Splititembarcodetextbox, 20);
			//Splititembarcodetextbox.sendKeys(Steps.ItemDataMap.get(i).get("Item"));
			Splititembarcodetextbox.sendKeys(Steps.scenarioData.get("Item"));
			Screenshots.captureSnapshot(driver);
			Splititembarcodetextbox.sendKeys(Keys.ENTER);
			Screenshots.captureSnapshot(driver);
			Thread.sleep(2000);
			
			Steps.logger.info("Enter the value of Qty : " + Steps.scenarioData.get("SplitoLPNQty"));
			SplititQtytextbox.sendKeys(Steps.scenarioData.get("SplitoLPNQty"));
			Screenshots.captureSnapshot(driver);
			SplititQtytextbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);				
			Screenshots.captureSnapshot(driver);
			
			
			homepage.userClosesOpenedwindow("RF Menu");
		} catch (Exception e) {
			e.printStackTrace();
			Steps.testRes = "Failed";
			System.out.println("test red" + Steps.testRes);
			//e.printStackTrace();			
			Assert.assertTrue(false, e.getMessage());

	}
	}

	public void modifyiLPN(String operations, String inventoryFunctions) throws Exception {
		try {
			Steps.logger.info("Start Inventory Functions");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 20);
			RFmenu_info.click();
			Steps.logger.info("Clicked on RF Menu");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
			Mainmenu.click();
			Steps.logger.info("Clicked on Main Menu");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfMenuReceiving, 20);
			while (!(SeleniumTestHelper.isElementDisplayed(inventoryMgmtMenu))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(inventoryMgmtMenu.isDisplayed());
			Screenshots.captureSnapshot(driver);
			inventoryMgmtMenu.click();
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Clicked on Inventory");

			while (!(SeleniumTestHelper.isElementDisplayed(ModifyiLPN))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(ModifyiLPN.isDisplayed());
			ModifyiLPN.click();
			Steps.logger.info("Clicked on " + inventoryFunctions + " method");
			switch (operations) {
			case "Increase":
				ilpnInRFModifyilpnTxtBox.sendKeys(iLPNz.get(0));
				Screenshots.captureSnapshot(driver);
				ilpnInRFModifyilpnTxtBox.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, QtyTxtBoxInRFModifyilpn, 10);
				QtyTxtBoxInRFModifyilpn.sendKeys(Steps.ItemDataMap.get(0).get("ChangeQty"));
				Screenshots.captureSnapshot(driver);
				QtyTxtBoxInRFModifyilpn.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, ReasonCOdeTxtBoxInRFModifyilpn, 10);
				ReasonCOdeTxtBoxInRFModifyilpn.clear();
				Thread.sleep(2000);
				Screenshots.captureSnapshot(driver);
				ReasonCOdeTxtBoxInRFModifyilpn.sendKeys(Steps.ItemDataMap.get(0).get("ReasonCode"));
				Screenshots.captureSnapshot(driver);
				ReferenceTxtBoxInRFModifyilpn.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("iLPN Quantity is increased using " + Steps.ItemDataMap.get(0).get("ReasonCode")+" reason code");
				Reporter.addStepLog("iLPN Quantity is increased using " + Steps.ItemDataMap.get(0).get("ReasonCode")+" reason code");
				break;

			case "Decrease":
				ilpnInRFModifyilpnTxtBox.sendKeys(iLPNz.get(0));
				Screenshots.captureSnapshot(driver);
				ilpnInRFModifyilpnTxtBox.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, QtyTxtBoxInRFModifyilpn, 10);
				QtyTxtBoxInRFModifyilpn.sendKeys(Steps.ItemDataMap.get(0).get("ChangeQty"));
				Screenshots.captureSnapshot(driver);
				QtyTxtBoxInRFModifyilpn.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, ReasonCOdeTxtBoxInRFModifyilpn, 10);
				ReasonCOdeTxtBoxInRFModifyilpn.clear();
				Thread.sleep(2000);
				Screenshots.captureSnapshot(driver);
				ReasonCOdeTxtBoxInRFModifyilpn.sendKeys(Steps.ItemDataMap.get(0).get("ReasonCode"));
				Thread.sleep(1000);
				Screenshots.captureSnapshot(driver);
				ReferenceTxtBoxInRFModifyilpn.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("iLPN Quantity is decreased using " + Steps.ItemDataMap.get(0).get("ReasonCode")+" reason code");
				Reporter.addStepLog("iLPN Quantity is decreased using " + Steps.ItemDataMap.get(0).get("ReasonCode")+" reason code");
				break;

			case "Delete Line":
				ilpnInRFModifyilpnTxtBox.sendKeys(iLPNz.get(0));
				Screenshots.captureSnapshot(driver);
				ilpnInRFModifyilpnTxtBox.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
				RFmenu_info.click();
				Thread.sleep(1000);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, DeleteDetailBtnInRFModifyilpn, 10);
				DeleteDetailBtnInRFModifyilpn.click();
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, ReasonCOdeTxtBoxInRFModifyilpn, 10);
				ReasonCOdeTxtBoxInRFModifyilpn.clear();
				Thread.sleep(2000);
				Screenshots.captureSnapshot(driver);
				ReasonCOdeTxtBoxInRFModifyilpn.sendKeys(Steps.ItemDataMap.get(0).get("ReasonCode"));
				Thread.sleep(1000);
				Screenshots.captureSnapshot(driver);
				ReferenceTxtBoxInRFModifyilpn.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("iLPN line is deleted using " + Steps.ItemDataMap.get(0).get("ReasonCode")+" reason code");
				Reporter.addStepLog("iLPN line is deleted using " + Steps.ItemDataMap.get(0).get("ReasonCode")+" reason code");
				break;

			default:
				System.out.println("Invalid operation to perform");
				System.out.println("Operation should be either Increase or Decrease or Delete Line");
				break;
			}
			System.out.println("iLPN is modified with : " + inventoryFunctions + " menu");
			homepage.userClosesOpenedwindow("RF Menu");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red" + Steps.testRes);
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());

		}
	}

	public void split_Move_iLPN_for_same_Item() throws Exception {

		try {
			Thread.sleep(1000);
			RFmenu_info.click();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			Mainmenu.click();
			Steps.logger.info("Clicked on Main Menu");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfMenuReceiving, 20);
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			while (!(SeleniumTestHelper.isElementDisplayed(inventoryMgmtMenu))) {
				pageDown.click();
				Thread.sleep(5000);
			}
			SeleniumTestHelper.assertTrue(inventoryMgmtMenu.isDisplayed());
			Screenshots.captureSnapshot(driver);
			inventoryMgmtMenu.click();
			Steps.logger.info("Clicked on Inventory method");
			Thread.sleep(3000);
			Screenshots.captureSnapshot(driver);
			while (!(SeleniumTestHelper.isElementDisplayed(splitMoveiLPN))) {
				pageDown.click();
				Thread.sleep(5000);
			}
			SeleniumTestHelper.assertTrue(splitMoveiLPN.isDisplayed());
			Screenshots.captureSnapshot(driver);
			splitMoveiLPN.click();
			Steps.logger.info("Click on split move iLPN method");
			Thread.sleep(3000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Enter the value of 1st LPN: " + iLPNz.get(0));
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, ilpnInRFmoveilpnTxtBox, 20);
			ilpnInRFmoveilpnTxtBox.sendKeys(iLPNz.get(0));
			Screenshots.captureSnapshot(driver);
			ilpnInRFmoveilpnTxtBox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Enter the value of Qty : " + Steps.scenarioData.get("MoveLPNQty"));
			moveQty.sendKeys(Steps.scenarioData.get("MoveLPNQty"));
			Screenshots.captureSnapshot(driver);
			moveQty.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Enter the value of 2nd LPN: " + iLPNz.get(1));
			ilpnInRFmoveilpnTxtBox.sendKeys(iLPNz.get(1));
			Screenshots.captureSnapshot(driver);
			ilpnInRFmoveilpnTxtBox.sendKeys( Keys.ENTER);
			Thread.sleep(3000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Completed iLPN move");
			Reporter.addStepLog(Steps.scenarioData.get("MoveLPNQty") + " qty is moved from LPN " + iLPNz.get(0) + " to "
					+ iLPNz.get(1));
			homepage.userClosesOpenedwindow("RF Menu");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red" + Steps.testRes);
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}

	}
	
	public void Consume_iLPN_for_same_Item() throws Exception {

		try {
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
			Screenshots.captureSnapshot(driver);
			inventoryMgmtMenu.click();
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Clicked on Inventory method");
			Thread.sleep(3000);
			while (!(SeleniumTestHelper.isElementDisplayed(COnsumeiLPN))) {
				pageDown.click();
				Thread.sleep(5000);
			}
			SeleniumTestHelper.assertTrue(COnsumeiLPN.isDisplayed());
			Screenshots.captureSnapshot(driver);
			COnsumeiLPN.click();
			Steps.logger.info("Click on COnsume iLPN method");
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Enter the value of 1st LPN: " + iLPNz.get(0));
			ilpnInRFmoveilpnTxtBox.sendKeys(iLPNz.get(0));
			Screenshots.captureSnapshot(driver);
			ilpnInRFmoveilpnTxtBox.sendKeys( Keys.ENTER);
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Enter the value of Qty : " + Steps.scenarioData.get("MoveLPNQty"));
			moveQty.sendKeys(Steps.scenarioData.get("MoveLPNQty"));
			Screenshots.captureSnapshot(driver);
			moveQty.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Enter the value of 2nd LPN: " + iLPNz.get(1));
			ilpnInRFmoveilpnTxtBox.sendKeys(iLPNz.get(1));
			Screenshots.captureSnapshot(driver);
			ilpnInRFmoveilpnTxtBox.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Completed iLPN move");
			Reporter.addStepLog(Steps.scenarioData.get("MoveLPNQty") + " qty is moved from LPN " + iLPNz.get(0) + " to "
					+ iLPNz.get(1));
			homepage.userClosesOpenedwindow("RF Menu");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red" + Steps.testRes);
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}

	}

	public void putawayProcess(String putawayMethod) throws Exception {
		
		try {
			Steps.logger.info("Start Putaway Process");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
			RFmenu_info.click();
			Steps.logger.info("Clicked on RF Menu");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
			Mainmenu.click();
			Steps.logger.info("Clicked on Main Menu");
			Thread.sleep(1000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfMenuPutaway, 50);
			rfMenuPutaway.click();
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Clicked on Putaway");
			switch (putawayMethod) {
			case "MM3 Ptwy-Sys Dir":
				
				while (!(SeleniumTestHelper.isElementDisplayed(MM3sysdirPutaway))) {
					pageDown.click();
				}
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, MM3sysdirPutaway, 50);
				MM3sysdirPutaway.click();
				Screenshots.captureSnapshot(driver);
				for (int i = 0; i < iLPNz.size(); i++) {
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, altiLPNBoxafterputaway, 50);
				altiLPNBoxafterputaway.sendKeys(iLPNz.get(i));
				Screenshots.captureSnapshot(driver);
				altiLPNBoxafterputaway.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				
				List <WebElement> sugLOC= driver.findElements(By.id("capSubLocationViewSuggested"));
				List <WebElement> RLOC= driver.findElements(By.id("dataForm:ifNotSuggestedMode"));
				if(sugLOC.size()>0) {
				//SeleniumTestHelper.waitForElementToBeDisplayed(driver, suggestedLoc, 50);
				String sugLoc=suggestedLoc.getText();
				System.out.println(suggestedLoc.getText());
				String[] sysSuggestedLocSplit = sugLoc.split("\n");
				System.out.println(sysSuggestedLocSplit[1]);
				String[] spltarr = sysSuggestedLocSplit[1].split("-");
				String str = GlobalClass.removeZero(spltarr[1]);
				System.out.println(str);
				spltarr[1] = str;
				String updtLoc = "";
				for (String a : spltarr)
					updtLoc = updtLoc + a;

				System.out.println("updtLoc is: " + updtLoc);
				putawayLoctxtBox.sendKeys(updtLoc);
				Screenshots.captureSnapshot(driver);
				Thread.sleep(1000);
				putawayLoctxtBox.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				Steps.logger.info("Putaway Completed. Item moved to:"+sysSuggestedLocSplit[1]+" location");
				Reporter.addStepLog("Putaway Completed. Item moved to:"+sysSuggestedLocSplit[1]+" location");
				}
				else if(RLOC.size()>0) {
					String RLocation=RLoc.getText();
					System.out.println(RLoc.getText());
					String[] sysSuggestedLocSplit = RLocation.split("Rloc: ");
					System.out.println(sysSuggestedLocSplit[1]);
					String[] spltarr = sysSuggestedLocSplit[1].split("-");
					String str = GlobalClass.removeZero(spltarr[1]);
					System.out.println(str);
					spltarr[1] = str;
					String updtLoc = "";
					for (String a : spltarr)
						updtLoc = updtLoc + a;

					System.out.println("updtLoc is: " + updtLoc);
					RlocinputtxtBox.sendKeys(updtLoc);
					Screenshots.captureSnapshot(driver);
					Thread.sleep(1000);
					RlocinputtxtBox.sendKeys(Keys.ENTER);
					Screenshots.captureSnapshot(driver);
					Steps.logger.info("Putaway Completed. iLPN "+ iLPNz.get(i)+ " moved to "+sysSuggestedLocSplit[1]+" location");
					Reporter.addStepLog("Putaway Completed. iLPN "+ iLPNz.get(i)+ " moved to "+sysSuggestedLocSplit[1]+" location");
				}
				}
				homepage.userClosesOpenedwindow("RF Menu");
				
			break;
			
			default:
				System.out.println("Invalid putaway operation");
			}
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red" + Steps.testRes);
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
		
	}

	public void completeTasks() throws Exception {
		
		String qty = null;
		SeleniumTestHelper.switchToInnerFrame(driver);
		Steps.logger.info("Start Task Completion Process");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
		RFmenu_info.click();
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Clicked on RF Menu");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
		Mainmenu.click();
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Clicked on Main Menu");
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 20);
		RFmenu_info.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, EnterTaskBtn, 5);
		EnterTaskBtn.click();
		Screenshots.captureSnapshot(driver);
		System.out.println("task length:"+taskPage.tasks.length);
		for (int i = 0; i < taskPage.tasks.length; i++) {
		Steps.logger.info("Started task completion for task: "+taskPage.tasks[i]);
		Task_input_field.sendKeys(taskPage.tasks[i] );
		//Task_input_field.sendKeys("82321");
		SeleniumTestHelper.assertTrue(Task_input_field.isDisplayed());
		Screenshots.captureSnapshot(driver);
		Task_input_field.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		while(SeleniumTestHelper.isElementDisplayed(promptediLPN)) {
			String iLPN = null;
			iLPN = promptediLPN.getText();
			System.out.println(iLPN);
			String iLPNarray[] = iLPN.split(":");
			iLPN = iLPNarray[1].trim();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNInputBx, 10);
			iLPNInputBx.clear();
			iLPNInputBx.sendKeys(iLPN);
			Thread.sleep(1000);
			SeleniumTestHelper.assertTrue(iLPNInputBx.isDisplayed());
			Screenshots.captureSnapshot(driver);
			iLPNInputBx.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
		}
		while(SeleniumTestHelper.isElementDisplayed(suggestedQty)) {
		String text= suggestedQty.getText();
		String split[]= text.split("Qty:");
		String split2[]= split[1].split(" ");
		qty= split2[0].trim();
		System.out.println("Suggested Qty: "+qty);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskQtyTxtBox, 5);
		taskQtyTxtBox.sendKeys(qty);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.assertTrue(taskQtyTxtBox.isDisplayed());
		taskQtyTxtBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		Thread.sleep(4000);
		}
		
		while(SeleniumTestHelper.isElementDisplayed(serialNumbersInput)) {
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, serialNumbersInput, 50);
				serialNumbersInput.clear();
				String serial="21"+globalFunc.DateTime.current_date_time();
				Steps.logger.info("Serial no's entered: "+serial);
				serialNumbersInput.sendKeys(serial);
				Screenshots.captureSnapshot(driver);
				serialNumbersInput.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
				if(errorOrWarningMsg.getText().contains("create a new one?"))
				{
					Thread.sleep(1000);
					Screenshots.captureSnapshot(driver);
					acceptAndProceedBtn.click();
					Thread.sleep(2000);
				}
				else if (errorOrWarningMsg.getText().contains("Error")) {
					Thread.sleep(1000);
					Screenshots.captureSnapshot(driver);
					Steps.testRes = "Failed";
					Assert.assertTrue(false);
				}
				Screenshots.captureSnapshot(driver);
		}
		}
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
		RFmenu_info.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ExitBtn, 50);
		ExitBtn.click();
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Task is completed successfully");
		Reporter.addStepLog("Task is completed successfully");
		homepage.userClosesOpenedwindow("RF Menu");
	}
//only used for a negative scenario
public void completeSingleTask() throws Exception {
		
		String qty = null;
		SeleniumTestHelper.switchToInnerFrame(driver);
		Steps.logger.info("Start Task Completion Process");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
		RFmenu_info.click();
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Clicked on RF Menu");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
		Mainmenu.click();
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Clicked on Main Menu");
		Thread.sleep(2000);
		Screenshots.captureSnapshot(driver);
		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 20);
		RFmenu_info.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, EnterTaskBtn, 5);
		EnterTaskBtn.click();
		Screenshots.captureSnapshot(driver);
		System.out.println("task length:"+taskPage.tasks.length);
		for (int i = 0; i < 1; i++) {
		Steps.logger.info("Started task completion for task: "+taskPage.tasks[i]);
		Task_input_field.sendKeys(taskPage.tasks[i] );
		//Task_input_field.sendKeys("82321");
		SeleniumTestHelper.assertTrue(Task_input_field.isDisplayed());
		Screenshots.captureSnapshot(driver);
		Task_input_field.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		while(SeleniumTestHelper.isElementDisplayed(promptediLPN)) {
			String iLPN = null;
			iLPN = promptediLPN.getText();
			System.out.println(iLPN);
			String iLPNarray[] = iLPN.split(":");
			iLPN = iLPNarray[1].trim();
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, iLPNInputBx, 10);
			iLPNInputBx.clear();
			iLPNInputBx.sendKeys(iLPN);
			Thread.sleep(1000);
			SeleniumTestHelper.assertTrue(iLPNInputBx.isDisplayed());
			Screenshots.captureSnapshot(driver);
			iLPNInputBx.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
		}
		while(SeleniumTestHelper.isElementDisplayed(suggestedQty)) {
		String text= suggestedQty.getText();
		String split[]= text.split("Qty:");
		String split2[]= split[1].split(" ");
		qty= split2[0].trim();
		System.out.println("Suggested Qty: "+qty);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskQtyTxtBox, 5);
		taskQtyTxtBox.sendKeys(qty);
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.assertTrue(taskQtyTxtBox.isDisplayed());
		taskQtyTxtBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		Thread.sleep(4000);
		}
		
		while(SeleniumTestHelper.isElementDisplayed(serialNumbersInput)) {
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, serialNumbersInput, 50);
				serialNumbersInput.clear();
				String serial="21"+globalFunc.DateTime.current_date_time();
				Steps.logger.info("Serial no's entered: "+serial);
				serialNumbersInput.sendKeys(serial);
				Screenshots.captureSnapshot(driver);
				serialNumbersInput.sendKeys(Keys.ENTER);
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, errorOrWarningMsg, 50);
				if(errorOrWarningMsg.getText().contains("create a new one?"))
				{
					Thread.sleep(1000);
					Screenshots.captureSnapshot(driver);
					acceptAndProceedBtn.click();
					Thread.sleep(2000);
				}
				else if (errorOrWarningMsg.getText().contains("Error")) {
					Thread.sleep(1000);
					Screenshots.captureSnapshot(driver);
					Steps.testRes = "Failed";
					Assert.assertTrue(false);
				}
				Screenshots.captureSnapshot(driver);
		}
		}
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
		RFmenu_info.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ExitBtn, 50);
		ExitBtn.click();
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Task is completed successfully  for 1st Task");
		Reporter.addStepLog("Task is completed successfully  for 1st Task");
		homepage.userClosesOpenedwindow("RF Menu");
	}
	public void InquiryTransactions(String menuOption) throws Exception {
		Steps.logger.info("Start Inquiry Transactions");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 20);
		RFmenu_info.click();
		Steps.logger.info("CLicked on RF Menu");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
		Mainmenu.click();
		Steps.logger.info("Clicked on Main Menu");
		Thread.sleep(1000);
		while (!(SeleniumTestHelper.isElementDisplayed(inquiryMenu))) {
			pageDown.click();
		}
		SeleniumTestHelper.assertTrue(inquiryMenu.isDisplayed());
		Screenshots.captureSnapshot(driver);
		inquiryMenu.click();
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Clicked on Inventory");
		switch (menuOption) {
		case "MM3 ASN Inquiry":
			Steps.logger.info("MM3 ASN Inquiry process started");
			Reporter.addStepLog("MM3 ASN Inquiry process started");
			while (!(SeleniumTestHelper.isElementDisplayed(MM3ASNInquiry))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(MM3ASNInquiry.isDisplayed());
			MM3ASNInquiry.click();
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
			
		
				MM3ASNInquirytxtBox.sendKeys(Steps.scenarioData.get("ASNNo"));
				Screenshots.captureSnapshot(driver);
				MM3ASNInquirytxtBox.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Screenshots.captureSnapshot(driver);
				 List<WebElement> l=driver.findElements(By.className("error"));
					if(l.size()==1) {
						Steps.logger.info("ASN is not available");
						Steps.testRes = "Failed";
						Assert.assertTrue(false);
					}
				String ASNno= driver.findElement(By.id("dtltxt1_a")).getText();
				String a[]= ASNno.split("\n");
				SeleniumTestHelper.assertEquals(a[1], Steps.scenarioData.get("ASNNo"), "ASN No ");
				
				String ASNstatus= driver.findElement(By.id("dataForm:dtltxt1_b3")).getText();
				SeleniumTestHelper.assertEquals(ASNstatus, Steps.scenarioData.get("ASNStatus"), "ASN Status ");
				Thread.sleep(1000);
				globalFunc.Screenshots.seleniumSnapshot(driver);
				Screenshots.addingScreenshottoExentReport();
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 20);
				RFmenu_info.click();
				Thread.sleep(1000);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, ASNDetailBtn, 20);
				Screenshots.captureSnapshot(driver);
				ASNDetailBtn.click();
				Thread.sleep(1000);
				Screenshots.captureSnapshot(driver);
				String itemID= driver.findElement(By.id("dtl_a")).getText();
				String b[]= itemID.split(":");
				SeleniumTestHelper.assertEquals(b[1].trim(), Steps.scenarioData.get("ASNItem"), "ASN Item ");
				
				Steps.logger.info("ASN Inquiry process completed");
				Reporter.addStepLog("MM3 ASN Inquiry process is completed for ASN: "+Steps.scenarioData.get("ASNNo"));
				Reporter.addStepLog("ASN Details are available");
				break;
				
				
		case "MM3 Item Inquiry":
			Steps.logger.info("MM3 Item Inquiry process started");
			Reporter.addStepLog("MM3 Item Inquiry process started");
			while (!(SeleniumTestHelper.isElementDisplayed(MM3ItemInquiry))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(MM3ItemInquiry.isDisplayed());
			MM3ItemInquiry.click();
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);

			MM3ItemInquirytxtBox.sendKeys(Steps.scenarioData.get("ItemBarcode"));
			Screenshots.captureSnapshot(driver);
			MM3ItemInquirytxtBox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
			 List<WebElement> list=driver.findElements(By.className("error"));
				if(list.size()==1) {
					Steps.logger.info("Item is not available");
					Steps.testRes = "Failed";
					Assert.assertTrue(false);
				}
				
				if(driver.findElement(By.id("dataForm")).isDisplayed()){
					Steps.logger.info("Item Id details are available");
					Assert.assertTrue(true);
				}else {
					Steps.logger.info("Item details are not available");
					Steps.testRes = "Failed";
					Assert.assertTrue(false);
				}
			String ItemID= driver.findElement(By.id("dataForm")).getText();
			String itemText[]= ItemID.split(":");
			String item[]=itemText[1].split("\n");
			SeleniumTestHelper.assertEquals(item[0].trim(), Steps.scenarioData.get("ItemBarcode"), "Item Id ");
			globalFunc.Screenshots.seleniumSnapshot(driver);
			Screenshots.addingScreenshottoExentReport();
			Steps.logger.info("Item Inquiry process completed");
			Reporter.addStepLog("MM3 Item Inquiry process is completed for Item: "+Steps.scenarioData.get("ItemBarcode"));
			Reporter.addStepLog("Item Id Details are available");
			break;
				
		case "MM3 Location Inquiry":
			Steps.logger.info("MM3 Location Inquiry process started");
			Reporter.addStepLog("MM3 Location Inquiry process started");
			while (!(SeleniumTestHelper.isElementDisplayed(MM3LocationInquiry))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(MM3LocationInquiry.isDisplayed());
			MM3LocationInquiry.click();
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
				
			MM3LocationInquirytxtBox.sendKeys(Steps.scenarioData.get("Location"));
			Screenshots.captureSnapshot(driver);
			MM3LocationInquirytxtBox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
			 List<WebElement> list1=driver.findElements(By.className("error"));
				if(list1.size()==1) {
					Steps.logger.info("Location is not available");
					Steps.testRes = "Failed";
					Assert.assertTrue(false);
				}
				
				if(driver.findElement(By.id("dataForm")).isDisplayed()){
					Steps.logger.info("Location details are available");
					Assert.assertTrue(true);
				}else {
					Steps.logger.info("Location details are not available");
					Steps.testRes = "Failed";
					Assert.assertTrue(false);
				}
			String location= driver.findElement(By.id("dataForm")).getText();
			String locText[]= location.split("Rloc:");
			String loc[]=locText[1].split("\n");
			loc[0]= loc[0].replace("-", "");
			SeleniumTestHelper.assertEquals(loc[0].trim(), Steps.scenarioData.get("Location"), "Location ");
			globalFunc.Screenshots.seleniumSnapshot(driver);
			Screenshots.addingScreenshottoExentReport();
			Steps.logger.info("Location Inquiry process completed");
			Reporter.addStepLog("MM3 Location Inquiry process is completed for Location: "+Steps.scenarioData.get("Location"));
			Reporter.addStepLog("Location Details are available");
			
			break;
				
		case "MM3 iLPN Inquiry":
			Steps.logger.info("MM3 iLPN Inquiry process started");
			Reporter.addStepLog("MM3 iLPN Inquiry process started");
			while (!(SeleniumTestHelper.isElementDisplayed(MM3iLPNInquiry))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(MM3iLPNInquiry.isDisplayed());
			MM3iLPNInquiry.click();
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);
				
				MM3iLPNInquirytxtBox.sendKeys(Steps.scenarioData.get("iLPN"));
				Screenshots.captureSnapshot(driver);
				MM3iLPNInquirytxtBox.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Screenshots.captureSnapshot(driver);
				 List<WebElement> list2=driver.findElements(By.className("error"));
					if(list2.size()==1) {
						Steps.logger.info("iLPN is not available");
						Steps.testRes = "Failed";
						Assert.assertTrue(false);
					}
					
					if(driver.findElement(By.id("dataForm")).isDisplayed()){
						Steps.logger.info("iLPN details are available");
						Assert.assertTrue(true);
					}else {
						Steps.logger.info("iLPN details are not available");
						Steps.testRes = "Failed";
						Assert.assertTrue(false);
					}
				String iLPN= driver.findElement(By.id("dataForm:ot10")).getText();
				SeleniumTestHelper.assertEquals(iLPN.trim(), Steps.scenarioData.get("iLPN"), "iLPN ");
				globalFunc.Screenshots.seleniumSnapshot(driver);
				Screenshots.addingScreenshottoExentReport();
				Steps.logger.info("iLPN Inquiry process completed");
				Reporter.addStepLog("MM3 iLPN Inquiry process is completed for iLPN: "+Steps.scenarioData.get("iLPN"));
				Reporter.addStepLog("iLPN Details are available");
				break;
				
		case "MM3 oLPN Inquiry":
			Steps.logger.info("MM3 oLPN Inquiry process started");
			Reporter.addStepLog("MM3 oLPN Inquiry process started");
			while (!(SeleniumTestHelper.isElementDisplayed(MM3oLPNInquiry))) {
				pageDown.click();
			}
			SeleniumTestHelper.assertTrue(MM3oLPNInquiry.isDisplayed());
			MM3oLPNInquiry.click();
			Thread.sleep(1000);
			Screenshots.captureSnapshot(driver);

			MM3oLPNInquirytxtBox.sendKeys(Steps.scenarioData.get("oLPN"));
			Screenshots.captureSnapshot(driver);
			MM3oLPNInquirytxtBox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
			 List<WebElement> list3=driver.findElements(By.className("error"));
				if(list3.size()==1) {
					Steps.logger.info("iLPN is not available");
					Steps.testRes = "Failed";
					Assert.assertTrue(false);
				}
				
				if(driver.findElement(By.id("dataForm")).isDisplayed()){
					Steps.logger.info("oLPN details are available");
					Assert.assertTrue(true);
				}else {
					Steps.logger.info("oLPN details are not available");
					Steps.testRes = "Failed";
					Assert.assertTrue(false);
				}
			String oLPN= driver.findElement(By.id("dataForm:ot10")).getText();
			SeleniumTestHelper.assertEquals(oLPN.trim(), Steps.scenarioData.get("oLPN"), "oLPN ");
			globalFunc.Screenshots.seleniumSnapshot(driver);
			Screenshots.addingScreenshottoExentReport();
			Steps.logger.info("oLPN Inquiry process completed");
			Reporter.addStepLog("MM3 oLPN Inquiry process is completed for oLPN: "+Steps.scenarioData.get("oLPN"));
			Reporter.addStepLog("oLPN Details are available");
				
				break;
				
		default:
			System.out.println("Invalid putaway operation");
	}
		Thread.sleep(1000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
		RFmenu_info.click();
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ExitBtn, 50);
		ExitBtn.click();
		Screenshots.captureSnapshot(driver);
		Steps.logger.info("Inquiry operation is completed successfully");
		homepage.userClosesOpenedwindow("RF Menu");
	}
	
	//Cancel Olpn
	public void CanceloLPN(String oLPNNumber) throws Exception {
		
		try {
			
			Steps.logger.info("Start Cancel oLPN Process");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, RFmenu_info, 50);
			RFmenu_info.click();
			Steps.logger.info("Clicked on RF Menu");
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, Mainmenu, 20);
			Mainmenu.click();
			Steps.logger.info("Clicked on Main Menu");
			Thread.sleep(1000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfMenuPutaway, 50);
			rfMenuPutaway.click();
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Clicked on Putaway");
			while (!(SeleniumTestHelper.isElementDisplayed(rfCancelolpnOption))) {
					pageDown.click();
				}
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, rfCancelolpnOption, 50);
				rfCancelolpnOption.click();
				Screenshots.captureSnapshot(driver);
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, MM3oLPNInquirytxtBox, 50);
				MM3oLPNInquirytxtBox.sendKeys(oLPNNumber);
				
		
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red" + Steps.testRes);
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}

	}
	
}
