package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.commons.net.nntp.NewGroupsOrNewsQuery;

public class DistributionOrders {
	
   
	public static List<String> productsForDistOrder = new ArrayList<>();
	public static List<String> oLPNList = new ArrayList<>();
	public static List<String> oLPN = new ArrayList<>();
	public static List<String> oLPNwithCase = new ArrayList<>();
	public static List<String> replnTasks = new ArrayList<>();
	
	private static Map<String, List<String>> serialNumbersforItem = new HashMap<>();
	public static List<String> casePickTasks = new ArrayList<>();
	
	public static String getSerialNumbersforItem(String itemName,int i) {
		return serialNumbersforItem.get(itemName).get(i);
	}
	public static void setSerialNumbersforItem(String itemName,List<String> serialNumber) {
		serialNumbersforItem.put(itemName,serialNumber);
	}
	public static String getoLPNwithCase(int num ) {
		return oLPNwithCase.get(num);
	}
	public static void setoLPNwithCase(String caseOLPN) {
		 oLPNwithCase.add(caseOLPN);
	}
	
	public static  String getoLPNwithReserve(int num2) {
		return oLPNwithReserve.get(num2);
	}
	public static void setoLPNwithReserve(String  oLPNwithReserve1) {
		 oLPNwithReserve.add(oLPNwithReserve1);
	}

	public static List<String> oLPNwithReserve = new ArrayList<>();
	public static List<String> oLPNwithActive = new ArrayList<>();
	public static String getoLPNwithActive(int num) {
		return oLPNwithActive.get(num);
	}
	public static void setoLPNwithActive(String activeOLPN) {
		oLPNwithActive.add(activeOLPN);
	}

	public static int totalQty;
	private static String Single_oLPN, Second_oLPN;
	public static int lpnQty;
	public static int CT3Qty;
	private static String waveNumber;
	 
	
	
	public static int getCT3Qty() {
		return CT3Qty;
	}
	public static void setCT3Qty(int cT3Qty) {
		CT3Qty = cT3Qty;
	}
	public static String getSecond_oLPN() {
		return Second_oLPN;
	}
	public static void setSecond_oLPN(String second_oLPN) {
		Second_oLPN = second_oLPN;
	}
	public static String getSingle_oLPN() {
		return Single_oLPN;
	}
	public static void setSingle_oLPN(String single_oLPN) {
		Single_oLPN = single_oLPN;
	}

	private static Map<String, String> oLPNwithitem  = new HashMap<>();
	private static Map<String, String> oLPNwithpickLocation  = new HashMap<>();
	private static Map<String, String> oLPNForMixeditem  = new HashMap<>();
	
	public static String getoLPNwithpickLocation(String oLPN) {
		return oLPNwithpickLocation.get(oLPN);
	}
	public static void setoLPNwithpickLocation(String oLPN, String oLPNpickLocation) {
		oLPNwithpickLocation.put(oLPN, oLPNpickLocation);
	}
	public static String getoLPNwithitem(String keyoLPN) {
		return oLPNwithitem.get(keyoLPN);
	}
	public static void setoLPNwithitem( String LPN,String item) {
		 
		oLPNwithitem.put(LPN, item);
	}
	public static  String getoLPNwithQty(String oLPN) {
		return oLPNwithQty.get(oLPN);
	}
	public static void setoLPNwithQty(String oLPN,String Qty ) {
		oLPNwithQty.put(oLPN, Qty);  
	}

	private static Map<String, String> oLPNwithQty = new HashMap<>();
	 
	
	private static Map<String, Integer> itemWithShippedQty = new HashMap<>();
	private static Map<String, String> itemWithQtyUOM = new HashMap<>();
	private static Map<String, String> ItemWithbarCode = new HashMap<>();
	public static Map<String, String> DOItemQTYUOM=new HashMap<String, String>();
	public static Map<String, Map<String, String>> DOMap = new HashMap<String, Map<String, String>>();
	private static Map<String, String> lineItemWithPO = new HashMap<>();
	
	public static String getLineItemWithPO(String lineitem ) {
		return lineItemWithPO.get(lineitem);
	}
	public static void setLineItemWithPO(String item,String linePO) {
		lineItemWithPO.put(item,linePO);
	}
	public static String getItemWithbarCode(String item) {
		return ItemWithbarCode.get(item);
	}
	public static void setItemWithbarCode(String item, String itembarCode) {
		ItemWithbarCode.put(item,itembarCode);
	}
	
	
	public static String getProductsForDistOrder(int i) {
		return productsForDistOrder.get(i);
	}
	public static void setProductsForDistOrder(String productsForDistOrd) {
		productsForDistOrder.add(productsForDistOrd);
	}
	
	public static String DOnumber;
	
	public static String getDOnumber() {
		return DOnumber;
	}
	public static void setDOnumber(String dOnumber) {
		DOnumber = dOnumber;
	}
	public static int getItemWithShippedQty(String item) {
		return itemWithShippedQty.get(item);
	}

	public static void setItemWithShippedQty(String item, int itemQty) {
		itemWithShippedQty.put(item, itemQty);
	}
	public static String getItemWithQtyUOM(String item) {
		return itemWithQtyUOM.get(item);
	}

	public static void setItemWithQtyUOM(String item, String QtyUOM) {
		itemWithQtyUOM.put(item, QtyUOM);
	}
	
	public static  String getoLPNList(int index) {
		return oLPNList.get(index);
	}
	public static void setoLPNList(String oLPNdata) {
		oLPNList.add(oLPNdata);
	}
	public static String pickCartNumber;
	
	public static String getPickCartNumber() {
		return pickCartNumber;
	}
	public static void setPickCartNumber(String pickCartnum) {
		pickCartNumber = pickCartnum;
	}
	public static String caseiLPNwithOB;
	public static String getCaseiLPNwithOB() {
		return caseiLPNwithOB;
	}
	public static void setCaseiLPNwithOB(String caseiLPNwithOB) {
		DistributionOrders.caseiLPNwithOB = caseiLPNwithOB;
	}
	
	public static List<String> activeTasks = new ArrayList<>();
	
	public static String getActiveTasks(int id) {
		return activeTasks.get(id);
	}
	public static void setActiveTasks(String activeTaskid) {
		activeTasks.add(activeTaskid);
	}
	
	public static String getCasePickTasks(int id) {
		return casePickTasks.get(id);
	}
	public static void setCasePickTasks(String casePickTaskid) {
		casePickTasks.add(casePickTaskid);
	}
	
    public static String packedOlpn;
	
	
	public static String getPackedOlpn() {
		return packedOlpn;
	}
	public static void setPackedOlpn(String packedOlpn) {
		DistributionOrders.packedOlpn = packedOlpn;
	}
	public static void removeAllTheValuesFromMap(){
		productsForDistOrder.clear();
		oLPNList.clear();
		oLPN.clear();
		oLPNwithCase.clear();
		oLPNwithReserve.clear();
		totalQty = 0;
		Single_oLPN = null;
		Second_oLPN = null;
		lpnQty = 0;
		CT3Qty = 0;
		oLPNwithitem.clear();
		oLPNwithpickLocation.clear();
		oLPNwithQty.clear();
		itemWithShippedQty.clear();
		itemWithQtyUOM.clear();
		ItemWithbarCode.clear();
		DOItemQTYUOM.clear();
		DOMap.clear();
		DOnumber = null;
		pickCartNumber = null;
		caseiLPNwithOB = null;
		serialNumbersforItem.clear();
		activeTasks.clear();
		waveNumber = null;
		casePickTasks.clear();
		replnTasks.clear();
		shippingID = null;
		trailerNumber = null;
		oLPNwithActive.clear();
		oLPNForMixeditem.clear();
		lineItemWithPO.clear();
		packedOlpn = null;
		
    }
	public static int getTotalQty() {
		return totalQty;
	}

	public static void setTotalQty(int totalQ) {
		totalQty = totalQ;
	}
	public static int getLpnQty() {
		return lpnQty;
	}

	public static void setLpnQty(int totalLpn) {
		lpnQty = totalLpn;
	}
	public static String getReplnTasks(int id) {
		return replnTasks.get(id);
	}
	public static void setReplnTasks(String replnTasksids) {
		replnTasks.add(replnTasksids);
	}
	
	public static String getoLPNForMixeditem(String item) {
		return oLPNForMixeditem.get(item);
	}
	public static void setoLPNForMixeditem( String item,String lpn) {
		 
		oLPNForMixeditem.put(item, lpn);
	}
	
	public static String getWaveNumber() {
		return DistributionOrders.waveNumber;
	}
	public static void setWaveNumber(String waveNum) {
		waveNumber = waveNum;
	}
	
	private static String shippingID;

	public static String getShippingID() {
		return shippingID;
	}
	public static void setShippingID(String shippingNum) {
		DistributionOrders.shippingID = shippingNum;
	}
	
	private static String trailerNumber;

	public static String getTrailerNumber() {
		return trailerNumber;
	}
	public static void setTrailerNumber(String trailerNum) {
		DistributionOrders.trailerNumber = trailerNum;
	}
	
}
