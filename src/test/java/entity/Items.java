package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import StepDefinition.Steps;
import pages.RFMenuPage;
import reusable.KelliPages;



public class Items {
	
	private static String asnNumber;
	private static String PONumber;
	public static List<String> itemsForReceivingASN = new ArrayList<>();
	private static Map<String, Integer> itemWithShippedASNQty = new HashMap<>();
	private static Map<String, String> itemWithQtyUOM = new HashMap<>();
	private static String lpnID;
	private static List<String>  taskTypeList= new ArrayList<>();
	private static List<String>  taskTypeValues= new ArrayList<>();
	private static List<String>  newlpnID = new ArrayList<>();
	private static String palletID;
	private static String purchaseOrderID;
	private static Map<String, String> itemWithBarCode = new HashMap<>();
	private static Map<String, String> itemWithILPN = new HashMap<>();
	private static Map<Integer, String> itemname = new HashMap<>();
	private static List<String> itemnameList = new ArrayList<>();
	private static Map<String, String> itemWithPalletID = new HashMap<>();
	private static String testCaseName;
	private static Map<String, String> LPNWithLock = new HashMap<>();
	private static String oldQty;
	public static List<String> itemsPO = new ArrayList<>();
	private static String ItemName;
	private static String Rlocation_one;
	private static String ALocation_one;
	private static String ALocation_two;
	private static String CLocation_one;
	private static String CLocation_two;
	private static String numberOfLpn;
	private static String itemQTY;
	private static int taskCount;
	public static String iLpn;
	private static String DONumber;
	private static String waveNumber;
	private static String updtLoc;
	public static List<String> IlpNWithOB = new ArrayList<>();
	public static List<String> LPNThreeDgtList = new ArrayList();
	private static String pdfCOntent;
	public static List<String> productsForDistOrder = new ArrayList<>();
	public static List<String> TrnsprtSCACDO = new ArrayList<>();
	public static List<String> TrnsprtSvcLvlDO  = new ArrayList<>();
	private static Map<String, Integer> itemWithShippedQtyDO = new HashMap<>();
	private static Map<String, String> itemWithQtyUOMDO = new HashMap<>();
	private static List<String> List_celtext = new ArrayList<>();
	private static List<String> List_celtext1 = new ArrayList<>();
	private static List<String> List_celtext2 = new ArrayList<>();
	public static String getItemName() {
		return ItemName;
	}

	public static void setItemName(String itemName) {
		Items.ItemName = itemName;
	}

	public static String getOldQty() {
		return oldQty;
	}

	public static void setOldQty(String oldQty) {
		Items.oldQty = oldQty;
	}

	public static String getupdtLoc() {
		return updtLoc;
	}

	public static void setupdtLoc(String updtLoc) {
		Items.updtLoc = updtLoc;
	}
	
	public static String getItemnameList(int i) {
		return itemnameList.get(i);
	}

	public static void setItemnameList(String myitem) {
		itemnameList.add(myitem);
	}
	public static String  getIlpNWithOB(int index) {
		return IlpNWithOB.get(index);
	}

	public static void setIlpNWithOB(String ilpNWithOB) {
		IlpNWithOB.add(ilpNWithOB);
	}


	private static Map<String, String> itemWithSuggestedLocation = new HashMap<>();
	public static List<String> ilpns = new ArrayList<>();
	private static String locationBarCode;
	public static String MovedQty;
	public static String getMovedQty() {
		return MovedQty;
	}

	public static void setMovedQty(String movedQty) {
		MovedQty = movedQty;
	}

	public static String getLocationBarCode() {
		return locationBarCode;
	}

	public static void setLocationBarCode(String locationBarCode) {
		Items.locationBarCode = locationBarCode;
	}

	public static String getLpns(int index) {
		return ilpns.get(index);
	}

	public static void setLpns(String lpn) {
		ilpns.add(lpn);
	}

	public static String getAsnNumber() {
		return asnNumber;
	}

	public static void setAsnNumber(String asnNumber) {
		Items.asnNumber = asnNumber;
	}
	
	public static String getPONumber() {
		return PONumber;
	}

	public static void setPONumber(String poNumber) {
		Items.PONumber = poNumber;
	}
	
	
	public static String getItemsForReceivingASN(int i) {
		return itemsForReceivingASN.get(i);
	}

	public static void setItemsForReceivingASN(String items) {
		itemsForReceivingASN.add(items);
	}

	public static int getItemWithShippedASNQty(String item) {
		return itemWithShippedASNQty.get(item);
	}

	public static void setItemWithShippedASNQty(String item, int itemQty) {
		itemWithShippedASNQty.put(item, itemQty);
	}

	public static String getItemWithQtyUOM(String item) {
		return itemWithQtyUOM.get(item);
	}

	public static void setItemWithQtyUOM(String item, String QtyUOM) {
		itemWithQtyUOM.put(item, QtyUOM);
	}
	public static String getLPNID() {
		return lpnID;
	}

	public static void setLPNID(String lpnId) {
		Items.lpnID = lpnId;
	}

	public static String getPalletID() {
		return palletID;
	}

	public static void setPalletID(String palletId) {
		Items.palletID = palletId;
	}
	public static String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public static void setPurchaseOrderID(String purchaseOrderId) {
		Items.purchaseOrderID = purchaseOrderId;
	}
	
	public static String getItemBarcode(String item) {
		return itemWithBarCode.get(item);
	}

	public static void setItemBarcode(String item, String barcode) {
		itemWithBarCode.put(item, barcode);
	}
	public static String getItemILPN(String item) {
		return itemWithILPN.get(item);
	}

	public static void setItemILPN(String item, String iLPN) {
		itemWithILPN.put(item, iLPN);
	}
	

	public static String getItemname(Integer itemnumber) {
		return itemname.get(itemnumber);
	}

	public static void setItemname(Integer itemnumber, String Itemname) {
		itemname.put(itemnumber, Itemname);
	}
	

	public static String getSuggestedRLOCWithItem(String item) {
		return itemWithSuggestedLocation.get(item);
	}

	public static void setSuggestedRLOCWithItem(String item, String suggestedRloc) {
		itemWithSuggestedLocation.put(item, suggestedRloc);
	}
	public static String getItemsPO(int i) {
		return itemsPO.get(i);
	}

	public static void setItemsPO(String items) {
		itemsPO.add(items);
	}
	public static String getItemPalletID(String item) {
		return itemWithPalletID.get(item);
	}

	public static void setItemPalletID(String item, String palletId) {
		itemWithPalletID.put(item, palletId);
	}
	
	public static String getCurrentTestCase() {
		return testCaseName;
	}

	public static void setCurrentTestCase(String tcname) {
		Items.testCaseName = tcname;
	}
	
	public static String getLockForLPN(String LPN) {
		return LPNWithLock.get(LPN);
	}

	public static void setLockForLPN(String LPN, String lockCode) {
		LPNWithLock.put(LPN, lockCode);
	}

	public static String getRlocation_one() {
		return Rlocation_one;
	}

	public static void setRlocation_one(String rlocation_one) {
		Rlocation_one = rlocation_one;
	}

	public static String getALocation_one() {
		return ALocation_one;
	}

	public static void setALocation_one(String aLocation_one) {
		ALocation_one = aLocation_one;
	}

	public static String getALocation_two() {
		return ALocation_two;
	}

	public static void setALocation_two(String aLocation_two) {
		ALocation_two = aLocation_two;
	}
    
	public static String getCLocation_one() {
		return CLocation_one;
	}
		public static void setCLocation_one(String cLocation_one) {
		CLocation_one = cLocation_one;
	}

	public static void setCLocation_two(String cLocation_two) {
		CLocation_two = cLocation_two;
	}
	public static String getCLocation_two() {
		return CLocation_two;
	}
	public static String getNumberOfLpn() {
		return numberOfLpn;
	}

	public static void setNumberOfLpn(String numberOfLpn) {
		Items.numberOfLpn = numberOfLpn;
	}

	public static void setItemQTY(String itemQTY) {
		Items.itemQTY = itemQTY;
	}

	public static String getItemQTY() {
		return itemQTY;
	}
	
	public static void setTaskCount(int taskcount) {
		Items.taskCount = taskcount;
	}

	public static int getTaskCount() {
		return taskCount;
	}
	
	private static String taskID; 
	public static String getTaskID() {
		return taskID;
	}

	public static void setTaskID(String taskID) {
		Items.taskID = taskID;
	}
	
	private static String itemBarcode; 

	public static String getItemBarcode() {
		return itemBarcode;
	}

	public static void setItemBarcode(String itemBarcode) {
		Items.itemBarcode = itemBarcode;
	}
	
	private static List<String> iLPN_list = new ArrayList<String>();
	
	
	public static String getiLPN_list(int index) {
		return iLPN_list.get(index);
	}

	public static void setiLPN_list(String iLPN) {
		iLPN_list.add(iLPN);
	}

	/**
	 * Below method is to clear all variables,maps,list etc after end of execution
	 */
	public static String getiLpn() {
		return iLpn;
	}

	public static void setiLpn(String iLpn) {
		Items.iLpn = iLpn;
	}
	
	private static Map<String, List<String>> minorserialNumbersforItem = new HashMap<>();
	
	public static String getMinorSerialNumbersforItem(String itemName,int i) {
		return minorserialNumbersforItem.get(itemName).get(i);
	}
	public static void setMinorSerialNumbersforItem(String itemName,List<String> serialNumber) {
		minorserialNumbersforItem.put(itemName,serialNumber);
	}
	
	private static String minorSerialItemName;
	
	public static String getMinorSerialItemName() {
		return minorSerialItemName;
	}

	public static void setMinorSerialItemName(String minorSerialItemName) {
		Items.minorSerialItemName = minorSerialItemName;
	}
	

	public static String getLPNThreeDgtList(int index) {
		return LPNThreeDgtList.get(index);
	}

	public static void setLPNThreeDgtList(String lPNThreeDgt) {
		LPNThreeDgtList.clear(); 
		LPNThreeDgtList.add(lPNThreeDgt);
	}
	
	public static String getDONumber() {
		return DONumber;
	}

	public static void setDONumber(String DONumber) {
		Items.DONumber = DONumber;
	}
	
	public static String getWaveNumber() {
		return Items.waveNumber;
	}
	public static void setWaveNumber(String waveNum) {
		waveNumber = waveNum;
	}

	//jaya
	public static String getoLPN(int i) {
		return List_celtext.get(i);
	}

	public static void setoLPN(String myitem) {
		List_celtext.add(myitem);
	}
	
	public static int getoLPNListSize() {
		return List_celtext.size();
	}
	public static String getoLPNStatus(int i) {
		return List_celtext1.get(i);
	}

	public static void setoLPNStatus(String myitem) {
		List_celtext1.add(myitem);
	}
	
	public static String getoLPNQty(int i) {
		return List_celtext2.get(i);
	}

	public static void setoLPNQty(String myitem) {
		List_celtext2.add(myitem);
	}
	
	public static String getTaskTypeValues(int i) {
		return taskTypeValues.get(i);
	}

	public static void setTaskTypeValues(String taskTypeValue) {
		taskTypeValues.add(taskTypeValue);
	}
	
	public static String gettaskTypeList(int i) {
		return taskTypeList.get(i);
	}

	public static void settaskTypeList(String taskType) {
		taskTypeList.add(taskType);
	}
	
	
	
	public static String getnewiLPNPack(int i) {
		return newlpnID.get(i);
	}
	public static void setnewiLPNPack(String newlpnId) {
		newlpnID.add(newlpnId);
	}
	
	public static int getnewiLPNPackSize() {
		return newlpnID.size();
	}
	
	public static String getProductsForDistOrder(int i) {
		return productsForDistOrder.get(i);
	}
	public static void setProductsForDistOrder(String productsForDistOrd) {
		productsForDistOrder.add(productsForDistOrd);
	}
	public static int getItemWithShippedQtyDO(String item) {
		return itemWithShippedQtyDO.get(item);
	}

	public static void setItemWithShippedQtyDO(String item, int itemQty) {
		itemWithShippedQtyDO.put(item, itemQty);
	}
	public static String getItemWithQtyUOMDO(String item) {
		return itemWithQtyUOMDO.get(item);
	}

	public static void setItemWithQtyUOMDO(String item, String QtyUOM) {
		itemWithQtyUOMDO.put(item, QtyUOM);
	}
	
	public static void setItemOrderTrnsprtSvcLvlDO(String trnsprtSvcLvl ) {
		TrnsprtSvcLvlDO.add(trnsprtSvcLvl);
	}
	
	public static void setItemOrderTrnsprtSCACDO(String trnsprtSCAC) {
		TrnsprtSCACDO.add(trnsprtSCAC);
	}
	
	
	
	public static void removeAllTheValuesFromMap() {
		List_celtext.clear();
		List_celtext1.clear();
		List_celtext2.clear();
		TrnsprtSvcLvlDO.clear();
		TrnsprtSCACDO.clear();
		RFMenuPage.splittedolpn= null;
		itemWithQtyUOMDO.clear();
		itemWithQtyUOMDO.clear();
		itemWithShippedQtyDO.clear();
		Steps.testRes="";
		RFMenuPage.iLPNz.clear();
		KelliPages.partialASNValue=null;
		KelliPages.itemList.clear();
		waveNumber=null;
		DONumber=null;
		asnNumber = null;
		PONumber =  null;
		itemsForReceivingASN.clear();
		itemWithShippedASNQty.clear();
		itemWithQtyUOM.clear();
		itemWithSuggestedLocation.clear();
		ilpns.clear();
		purchaseOrderID = null;
	    locationBarCode= null;
	    MovedQty= null;
		itemname.clear();
		purchaseOrderID = null;
		itemsPO.clear();
		lpnID = null;
		palletID = null;
		testCaseName = null;
		LPNWithLock.clear();
		oldQty=null;
		ItemName = null;
		Rlocation_one = null;
    	ALocation_one = null;
    	ALocation_two = null;
    	CLocation_one = null;
    	CLocation_two = null;
    	taskID=null;
    	itemBarcode=null;
    	iLpn=null;
    	minorserialNumbersforItem.clear();
    	minorSerialItemName=null;
    	IlpNWithOB.clear();
    	pdfCOntent=null;
    	itemWithBarCode.clear();
    	itemWithILPN.clear();
    	itemnameList.clear();
    	itemWithPalletID.clear();
    	numberOfLpn = null;
    	itemQTY = null;
    	LPNThreeDgtList.clear();
    	iLPN_list.clear();
    	updtLoc=null;
    	taskTypeList.clear();
    	taskTypeValues.clear();
    	newlpnID.clear();
    	

	}

	public static String getPdfCOntent() {
		return pdfCOntent;
	}

	public static void setPdfCOntent(String pdfCOntent) {
		Items.pdfCOntent = pdfCOntent;
	}

	public static String getLocationBarCodewithunderscore() {
		return locationBarCode;
	}

	public static void setLocationBarCodewithunderscore(String locationBarCode) {
		Items.locationBarCode = locationBarCode;
	}
}
