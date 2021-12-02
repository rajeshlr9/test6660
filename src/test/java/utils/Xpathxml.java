package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.DistributionOrders;
import entity.Items;
import reusable.copyFolder;

public class Xpathxml {
	
	WebDriver driver = Steps.seleniumDriver;
	public String dirPath = System.getProperty("user.dir");
	public String IBMasterOneItemFilePath = dirPath + "/src/test/resources/testdata/Inbound/"+Steps.scenarioData.get("Account") + "/IBMasterOneItem.xml";
	public String IBMasterTwoItemFilePath = dirPath + "/src/test/resources/testdata/Inbound/" +Steps.scenarioData.get("Account")+ "/IBMasterTwoItem.xml";
	public String IBMasterOneReturnFilePath = dirPath + "/src/test/resources/testdata/Inbound/"+Steps.scenarioData.get("Account") +"/IBMasterOne-Returns.xml";
	public String IBMasterTwoReturnFilePath = dirPath + "/src/test/resources/testdata/Inbound/" +Steps.scenarioData.get("Account")+"/IBMasterTwo-Returns.xml";
	public String inputIBFilePath = dirPath + "/src/test/resources/testdata/Inbound/"+Steps.scenarioData.get("Account") + "/InputIB.xml";
	public String DOMasterOneItemFilePath = dirPath + "/src/test/resources/testdata/Outbound/" +Steps.scenarioData.get("Account") + "/OBOneItem.xml";
	public String DOMasterTwoItemFilePath = dirPath + "/src/test/resources/testdata/Outbound/" +Steps.scenarioData.get("Account") + "/OBTwoItem.xml";
	public String inputOBFilePath = dirPath + "/src/test/resources/testdata/Outbound/" +Steps.scenarioData.get("Account") + "/InputOB.xml";
	
	//Fedexnet files
	public String SingleLineInboundFilePath = dirPath + "/src/test/resources/testdata/"+Steps.scenarioData.get("Account") + "/856/"+Steps.scenarioData.get("Account")+"_856_SingleLine.xml";
	public String MultiLineInboundFilePath = dirPath + "/src/test/resources/testdata/"+Steps.scenarioData.get("Account") + "/856/"+Steps.scenarioData.get("Account")+"_856_MultiLine.xml";
	public String inputEDIInboundFilePath = dirPath + "/src/test/resources/testdata/"+Steps.scenarioData.get("Account") + "/856/"+Steps.scenarioData.get("Account")+"_856_InputFile.xml";
	
	public String SingleLineOutboundFilePath = dirPath + "/src/test/resources/testdata/"+Steps.scenarioData.get("Account") + "/850/QSC_850_SingleLine.xml";
	public String MultiLineOutboundFilePath = dirPath + "/src/test/resources/testdata/"+Steps.scenarioData.get("Account") + "/850/QSC_850_MultiLine.xml";
	public String inputEDIOutboundFilePath = dirPath + "/src/test/resources/testdata/"+Steps.scenarioData.get("Account") + "/850/QSC_850_InputFile.xml";
	
	public static String ASNNumber = null;
	
	public static String ItemUpdateItemID() {
		return "//Item/ItemName";
	}
	public static String ASNUpdateASNID() {
		return "//ASN/ASNID";
	}
	public static String ASNUpdateDeliveryStart(){
		return "//ASN/DeliveryStart";
	}
	public String ASNUpdateShippedQty(int i) {
		return "//ASN/ASNDetail/Quantity//ShippedQty";
	}
	public String ASNUpdateQty(int i) {
		return "//ASN/ASNDetail[" + i + "]/Quantity//ShippedQty";
	}
	public String ASNUpdateItemName() {
		return "//ASN/ASNDetail//ItemName";
	}
	public String ASNUpdateItemName(int i) {
		return "//ASN/ASNDetail[" + i + "]//ItemName";
	}
	public String ASNUpdateQtyUOM(int i) {
		return "//ASN/ASNDetail[" + i + "]/Quantity//QtyUOM";
	}
	public String ASNItemName(int i) {
		return "//ShipOrdLp/ShipLineItemLp[" + i + "]//ItemID";
	}
	public String ASNQty(int i) {
		return "//ShipOrdLp/ShipLineItemLp[" + i + "]//ItemShipQty";
	}
	public String ASNItemUOM(int i) {
		return "//ShipOrdLp/ShipLineItemLp[" + i + "]//ItemUOM";
	}
	public String ASNUpdatePurchaseOrderID(int i) {
		return "//ASN/LPN[" + i + "]/LPNDetail//PurchaseOrderID";
	}
	public String ASNUpdateLPNID(int i) {
		return "//ASN/LPN[" + i + "]/LPNID";
	}
	public String ASNUpdatePalletID(int i) {
		return "//ASN/LPN[" + i + "]/PalletID";
	}
	
	
	public String ItemUpdateItemname(int i) {
		return "//Item[" + i + "]/ItemName";
	}
	
	public String ItemUpdateVendorItemNumber(int i) {
		return "//Item[" + i + "]/ItemVendorList/ItemVendor/VendorItemNumber";
	}
	public String ItemUpdateItemUpcGtin(int i) {
		return "//Item[" + i + "]/ItemUpcGtin";
	}
	public String ItemUpdateItemBarCode(int i) {
		return "//Item[" + i + "]/ItemBarCode";
	}
	
	public String ItemUpdateSerialRequired(int i) {
		return "//Item[" + i + "]/ItemWmos/SrlNbrReq";
	}
	
	public String ItemUpdateSlotMiscellaneous1(int i) {
		return "//Item[" + i + "]/ItemFacilityWMSList/ItemFacilityWMS/SlotMiscellaneous1";
	}
	
	public String ItemUpdateSlotMiscellaneous2(int i) {
		return "//Item[" + i + "]/ItemFacilityWMSList/ItemFacilityWMS/SlotMiscellaneous2";
	}
	
	public String ItemUpdateSlotMiscellaneous4(int i) {
		return "//Item[" + i + "]/ItemFacilityWMSList/ItemFacilityWMS/SlotMiscellaneous4";
	}
	public static String POUpdatePOID() {
		return "//Order/OrderId";
	}
	public static String PODate(){
		return "//Order/PODate";
	}
	public String POUpdateItemName(int i) {
		return "//Order/LineItem[" + i + "]//ItemName";
	}
	public String POUpdateQty(int i) {
		return "//Order/LineItem[" + i + "]/Quantity//OrderQty";
	}
	public String POUpdateQtyUOM(int i) {
		return "//Order/LineItem[" + i + "]/Quantity//QtyUOM";
	}
	public String POUpdatDescription(int i) {
		return "//Order/LineItem[" + i + "]//Description";
	}
	public String ItemUpdateVelocityCode(int i) {
		return "//Item[" + i + "]/ItemWmos/VelocityCode";
	}
	public String lineItemExternalPurchaseOrder(int i) {
		return "//LineItem[" + i + "]/ExternalSystemPurchaseOrderNbr";
	}
	
	public String ProductType(){
		return "//Item/ProductType";
	}
	
	public void ModifyXmlfile(String tagname, String inputValue, String inputFile)
			throws SAXException, IOException, ParserConfigurationException, XPathExpressionException,
			TransformerFactoryConfigurationError, TransformerException {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(inputFile));
		doc.setXmlStandalone(true);
		// locate the node(s)
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList nodes = (NodeList) xpath.evaluate

		(tagname, doc, XPathConstants.NODESET);

		// make the change
		for (int idx = 0; idx < nodes.getLength(); idx++) {
			nodes.item(idx).setTextContent(inputValue);
		}

		// save the result
		Transformer xformer = TransformerFactory.newInstance().newTransformer();
		xformer.transform(new DOMSource(doc), new StreamResult(new File(inputFile)));
		
	}

	// Current order date with time
		public String user_generate_delivery_start_date() {
			String currentOrderDate = null;
			String currentOrderTime = null;
			String currentOrderDateTime = null;
			Date currDate = new Date();
			SimpleDateFormat formatterDate = new SimpleDateFormat("MM/dd/YY");
			currentOrderDate = formatterDate.format(currDate);
			//SimpleDateFormat formatterTime = new SimpleDateFormat("mm:ss");
			SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm");
			currentOrderTime = formatterTime.format(currDate);
			currentOrderDateTime = currentOrderDate + " " + currentOrderTime;
			return currentOrderDateTime;
		}
		// Current date with time in minutes
			public String current_date_time() {
				String strDate6=null;
				Date date = new Date();
				SimpleDateFormat formatter6 = new SimpleDateFormat("yyMMddHHmmss");              
			     strDate6= formatter6.format(date);
			     return strDate6;
			}

	public void user_copy_content_from_source_to_target(String sourceFile, String targetFile)
			throws IOException, FileNotFoundException, XPathExpressionException, SAXException,
			ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile), "UTF-8"));

		String line = null;

		while ((line = reader.readLine()) != null) {
			writer.write(line.trim());
		}

		// Close to unlock.
		reader.close();
		// Close to unlock and flush to disk.
		writer.close();
	}

	public static Date CurrentDayplusdays(int i) {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +i);
		return cal.getTime();
	}

	public static String CurrentDayplusdaysinOnlydateformat(int i) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.format(CurrentDayplusdays(i));
	}
	/**********************************************************************/
	/* Distribution Order Creation xpaths                                 */
	/**********************************************************************/
	
	
	public static String DistributionOrderIdUpdate() {
		return "//DistributionOrder/DistributionOrderId";
	}
	public static String ReferenceIdUpdate() {
	return "//Header/Reference_ID";
	}
	public static String PickupStartDttmUpdate() {
		return "//DistributionOrder/PickupStartDttm";
	}
	public static String OrderedDttmUpdate() {
		return "//DistributionOrder/OrderedDttm";
	}
	public static String PickupEndDttmUpdate() {
		return "//DistributionOrder/PickupEndDttm";
	}
	public static String DeliveryStartDttmUpdate() {
		return "//DistributionOrder/DeliveryStartDttm";
	}

	public static String DeliveryEndDttmUpdate() {
		return "//DistributionOrder/DeliveryEndDttm";
	}
	public String doNodePath(int i, String nodeName ) {
		return "//DistributionOrder/LineItem[" + i + "]/" + nodeName;
	}
	public String DOItemName(int i) {
		return "//DistributionOrder/LineItem[" + i + "]//ItemName";
	}
	public String DOItemDescription(int i) {
		return "//DistributionOrder/LineItem[" + i + "]/Description";
	}
	public String DOUpdateQtyUOM(int i) {
		return "//DistributionOrder/LineItem[" + i + "]/Quantity/QtyUOM";
	}
	public String DOUpdateOrderQty(int i) {
		return "//DistributionOrder/LineItem[" + i + "]/Quantity/OrderQty";
	}
	public String DOItem(int i) {
		return "//OrdLineItemLp[" + i + "]//ItemID";
	}
	public String DOItemUOM(int i) {
		return "//OrdLineItemLp[" + i + "]//ItemUOM";
	}
	public String DOQty(int i) {
		return "//OrdLineItemLp[" + i + "]//ItemQty";
	}
	
	public String DOTrnsprtSvcLvl(int i) {
		return "//TrnsprtLp[" + i + "]//TrnsprtSvcLvl";
	}
	
	public String DOTrnsprtSCAC(int i) {
		return "//TrnsprtLp[" + i + "]//TrnsprtSCAC";
	}
	
	public String DOSpecInstr(int i) {
		return "//SpecInstrLp[" + i + "]//SpecInstr";
	}
	
	public String DOSpecInstrCD(int i) {
		return "//SpecInstrLp[" + i + "]//SpecInstrCD";
	}
	
	public String DOUpdateLineNbr(int i) {
		return "//DistributionOrder/LineItem[" + i + "]/LineItem/DoLineNbr";
	}
	
	public String DescriptionUpdate(int i) {
		return "//DistributionOrder/LineItem[" + i + "]/LineItem/Description";
		
	}
	public static String CurrentDayplusdaysindateformat(int i) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        return dateFormat.format(CurrentDayplusdays(i));
	}
	public String DOUShipVia() {
		return "//DistributionOrder/DsgShipVia";
	}
	public String DOOrderType() {
		return "//DistributionOrder/OrderType";
	}
	public String POTypeAttributeUpdate() {
		return "//DistributionOrder/POTypeAttribute";
	}
	public String EpiServiceGroupShipVia() {
		return "//DistributionOrder/EpiServiceGroup";
	}

    public String Destination() {
		return "//DistributionOrder/Destination";
		
    }
    public String collate_Report_ReferenceField(int i) {
		return "//LineItem[" + i + "]/ReferenceField10";
		
    }

    
    public String RefShipmentNbr() {
		return "//DistributionOrder/RefShipmentNbr";
		
    }
  

    public String DestinationStateOrProvince() {
		return "//DistributionOrder/DestinationStateOrProvince";
		
    }
    public String DestinationCity() {
		return "//DistributionOrder/DestinationCity";		
    }
    public String DestinationPostalCode() {
		return "//DistributionOrder/DestinationPostalCode";
		
    }
    public String TaxDiscalimer() {
		return "//DistributionOrder/Comment[3]/CommentText";	
    }
    
    public static String ReferenceFieldtwo() {
		return "//DistributionOrder/ReferenceField2";
	}
    public String LBL_FLD_commenttxt() {
		return "//DistributionOrder/Comment[9]/CommentText";	
    }
    
    public static String PO_TypeAttribute() {
		return "//DistributionOrder/POTypeAttribute";	
    }

	/**
	 * below mehtod is to generate input xml with random ASNID and DeliveryStartDate for IB
	 * @param noOfItem - no Of items
	 * @throws FileNotFoundException
	 * @throws XPathExpressionException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 */
    public void user_create_inputXML_for_inbound_basedOn_noOfItem(String noOfItem) throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		String deliveryStartDate = user_generate_delivery_start_date();
		String ASNTime= current_date_time();
		ASNNumber = "QSC" + ASNTime;
		Items.setAsnNumber(ASNNumber);
		
			user_copy_content_from_source_to_target(IBMasterOneItemFilePath, inputIBFilePath);
		
		
		System.out.println("XML input data created with : " + noOfItem + " item");
		ModifyXmlfile(ASNUpdateASNID(), ASNNumber, inputIBFilePath);
		System.out.println("ASNID has been updated as : " + ASNNumber);
		ModifyXmlfile(ASNUpdateDeliveryStart(), deliveryStartDate, inputIBFilePath);
		System.out.println("DeliveryStartDate has been updated as : " + deliveryStartDate);
	}
    public void user_create_inputXML_for_inbound_basedOn_noOfItem() throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		String deliveryStartDate = user_generate_delivery_start_date();
		String ASNTime= current_date_time();
		String ASNNumber = ASNTime;
		Items.setAsnNumber(ASNNumber);
		Steps.logger.info("ASNNumber: "+ASNNumber);
		
		int noOfItem= Steps.ItemDataMap.size();
		System.out.println("ItemDataMap size:: "+noOfItem);
		if(noOfItem == 1){
			user_copy_content_from_source_to_target(IBMasterOneItemFilePath, inputIBFilePath);
		}else if(noOfItem == 2){
			user_copy_content_from_source_to_target(IBMasterTwoItemFilePath, inputIBFilePath);
		}
		
		ModifyXmlfile(ASNUpdateASNID(), ASNNumber, inputIBFilePath);
		System.out.println("ASNID has been updated as : " + ASNNumber);
		ModifyXmlfile(ASNUpdateDeliveryStart(), deliveryStartDate, inputIBFilePath);
		System.out.println("DeliveryStartDate has been updated as : " + deliveryStartDate);
		Steps.logger.info("DeliveryStartDate has been updated as : " + deliveryStartDate);
	}
    
    public void user_create_inputXML_for_inbound_basedOn_xmlType(String xmlType) throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
    	String deliveryStartDate = user_generate_delivery_start_date();
		String ASNTime= current_date_time();
		String ASNNumber = ASNTime;
		Items.setAsnNumber(ASNNumber);
		Steps.logger.info("ASNNumber: "+ASNNumber);
		
		if(xmlType.equals("Single Line ASN")){
			user_copy_content_from_source_to_target(IBMasterOneItemFilePath, inputIBFilePath);
		}else if(xmlType.equals("Multi Line ASN")){
			user_copy_content_from_source_to_target(IBMasterTwoItemFilePath, inputIBFilePath);
		}else if(xmlType.equals("Single Line Return ASN")) {
			System.out.println("test");
			user_copy_content_from_source_to_target(IBMasterOneReturnFilePath, inputIBFilePath);
		}else if(xmlType.equals("Multi Line Return ASN")) {
			user_copy_content_from_source_to_target(IBMasterTwoReturnFilePath, inputIBFilePath);
		}
		
		ModifyXmlfile(ASNUpdateASNID(), ASNNumber, inputIBFilePath);
		System.out.println("ASNID has been updated as : " + ASNNumber);
		ModifyXmlfile(ASNUpdateDeliveryStart(), deliveryStartDate, inputIBFilePath);
		System.out.println("DeliveryStartDate has been updated as : " + deliveryStartDate);
		Steps.logger.info("DeliveryStartDate has been updated as : " + deliveryStartDate);		
	}
    
	
	public void create_xmlFile_for_DistributionOrder_to_upload(String xmlType) throws Exception{
		
		String pickupStartDate = user_generate_delivery_start_date();
		String pickupEndDate = CurrentDayplusdaysindateformat(1);
		String deliveryStartDate = CurrentDayplusdaysindateformat(2);
		String deliveryEndDate = CurrentDayplusdaysindateformat(3);
		String DOTime= current_date_time();
		String DONumber = DOTime;
		Items.setDONumber(DONumber);
		
		if(xmlType.equals("Single Line DO")){
			user_copy_content_from_source_to_target(DOMasterOneItemFilePath, inputOBFilePath);
		}else if(xmlType.equals("Multi Line DO")){
			user_copy_content_from_source_to_target(DOMasterTwoItemFilePath, inputOBFilePath);
		}
		
		ModifyXmlfile(DistributionOrderIdUpdate(), Items.getDONumber(), inputOBFilePath);
		System.out.println("Distribution Order updated is : "+Items.getDONumber());
		ModifyXmlfile(ReferenceIdUpdate(), Items.getDONumber(), inputOBFilePath);
		System.out.println("Reference ID updated is : "+Items.getDONumber());
		ModifyXmlfile(OrderedDttmUpdate(),pickupStartDate , inputOBFilePath);
		System.out.println("OrderedDttm updated as : "+pickupStartDate);
		ModifyXmlfile(PickupStartDttmUpdate(),pickupStartDate , inputOBFilePath);
		System.out.println("PickupStartDttm updated as : "+pickupStartDate);
		ModifyXmlfile(PickupEndDttmUpdate(),pickupEndDate , inputOBFilePath);
		System.out.println("PickupEndDttm updated as : "+pickupEndDate);
		ModifyXmlfile(DeliveryStartDttmUpdate(),deliveryStartDate , inputOBFilePath);
		System.out.println("DeliveryStartDttm updated as : "+deliveryStartDate);
		ModifyXmlfile(DeliveryEndDttmUpdate(),deliveryEndDate , inputOBFilePath);
		System.out.println("DeliveryEndDttm updated as : "+deliveryEndDate);
		System.out.println("Distribution Order XML data for the scenario has been created successfully with all the required data");
	}
	public void update_details_for_DistributionOrder_to_upload() throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		String itemName = null;
		String shpQty = null;
		String uom = null;
		//String itemDesc=null;
		for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
			
			itemName = Steps.ItemDataMap.get(i).get("Item");
			ModifyXmlfile(DOItemName(i+1), itemName, inputOBFilePath);
			System.out.println("Item : " + itemName + " has been updated successfully");
			Steps.logger.info("Item : " + itemName + " has been updated successfully");
			
			//itemDesc=Steps.ItemDataMap.get(i).get("ItemDesc");
			//xmlInput.ModifyXmlfile(xmlInput.DOItemDescription(i), itemDesc, xmlInput.inputOBFilePath);
			//System.out.println("Item Description : " + itemDesc + " has been updated successfully");
			//Steps.logger.info("Item Description : " + itemDesc + " has been updated successfully");
			
			shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
			ModifyXmlfile(DOUpdateOrderQty(i+1), shpQty, inputOBFilePath);
			System.out.println("Shipped Qty : " + shpQty + " has been updated successfully");
			Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");
			
			uom = Steps.ItemDataMap.get(i).get("UOM");
			ModifyXmlfile(DOUpdateQtyUOM(i+1), uom, inputOBFilePath);
			System.out.println("QtyUOM : " + uom + " has been updated successfully");
			Steps.logger.info("QtyUOM : " + uom + " has been updated successfully");

			Items.setProductsForDistOrder(itemName);
			Items.setItemWithShippedQtyDO(itemName, Integer.parseInt(shpQty));
			Items.setItemWithQtyUOMDO(itemName, uom);
			
			Reporter.addStepLog("Item Id- " + Steps.ItemDataMap.get(i).get("Item") + ", Shipped Qty- "
					+ Steps.ItemDataMap.get(i).get("ShippedQty"));		
	}
}
	public void user_create_EDI_file(String xmlType) throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		if(xmlType.equals("Single Line PO")){
			Steps.logger.info("Contents Copy from : "+SingleLineInboundFilePath);
			Steps.logger.info("Contents Copy to : "+inputEDIInboundFilePath);
			user_copy_content_from_source_to_target(SingleLineInboundFilePath, inputEDIInboundFilePath);
		}else if(xmlType.equals("Multi Line PO")){
			user_copy_content_from_source_to_target(MultiLineInboundFilePath, inputEDIInboundFilePath);
		}else if(xmlType.equals("Single Line DO")){
			user_copy_content_from_source_to_target(SingleLineOutboundFilePath, inputEDIOutboundFilePath);
		}else if(xmlType.equals("Multi Line DO")){
			user_copy_content_from_source_to_target(MultiLineOutboundFilePath, inputEDIOutboundFilePath);
		}
	}
	
	public void user_modify_EDI_file(String xmlType) throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		String currTime= current_date_time();
		String PODONumber = currTime;
		
		String path=null;
		if(xmlType.contains("PO")) {
			path=inputEDIInboundFilePath;
			Items.setPONumber(PODONumber);
			String ASNno= PODONumber+"-1";
			Items.setAsnNumber(ASNno);
			Steps.logger.info("ASNNumber: "+Items.getAsnNumber());
			Steps.logger.info("PONumber: "+Items.getPONumber());
			Reporter.addStepLog("ASNNumber: "+Items.getAsnNumber());
			Reporter.addStepLog("PONumber: "+Items.getPONumber());
			
			String itemName = null;
			String shpQty = null;
			String uom = null;
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				itemName = Steps.ItemDataMap.get(i).get("Item");
				ModifyXmlfile(ASNItemName(i + 1), itemName, path);
				System.out.println("Item : " + itemName + " has been updated successfully");
				Steps.logger.info("Item : " + itemName + " has been updated successfully");
				
				shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
				ModifyXmlfile(ASNQty(i + 1), shpQty, path);
				System.out.println("Shipped Qty : " + shpQty + " has been updated successfully");
				Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");
				
				uom = Steps.ItemDataMap.get(i).get("UOM");
				ModifyXmlfile(ASNItemUOM(i + 1), uom, path);
				System.out.println("QtyUOM : " + uom + " has been updated successfully");
				Steps.logger.info("QtyUOM : " + uom + " has been updated successfully");

				Items.setItemsForReceivingASN(itemName);
				Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shpQty));
				Items.setItemWithQtyUOM(itemName, uom);
				Reporter.addStepLog("Item Id- " + Steps.ItemDataMap.get(i).get("Item") + ", Shipped Qty- "
						+ Steps.ItemDataMap.get(i).get("ShippedQty"));
			}
			
		}else if(xmlType.contains("DO")) {
			path=inputEDIOutboundFilePath;
			Items.setDONumber(PODONumber);
			Steps.logger.info("DO Number: "+PODONumber);
			Reporter.addStepLog("DO Number: "+PODONumber);
			
			String itemName = null;
			String shpQty = null;
			String uom = null;
			String TrnsprtSvcLvl = null;
			String TrnsprtSCAC = null;
			String SplIns = null;
			String SICode = null;
			
			
			
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				
				itemName = Steps.ItemDataMap.get(i).get("Item");
				ModifyXmlfile(DOItem(i+1), itemName, path);
				System.out.println("Item : " + itemName + " has been updated successfully");
				Steps.logger.info("Item : " + itemName + " has been updated successfully");
				
				shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
				ModifyXmlfile(DOQty(i+1), shpQty, path);
				System.out.println("Shipped Qty : " + shpQty + " has been updated successfully");
				Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");
				
				uom = Steps.ItemDataMap.get(i).get("UOM");
				ModifyXmlfile(DOItemUOM(i+1), uom, path);
				System.out.println("QtyUOM : " + uom + " has been updated successfully");
				Steps.logger.info("QtyUOM : " + uom + " has been updated successfully");
				
				//Rakesh
				TrnsprtSvcLvl = Steps.scenarioData.get("TrnsprtSvcLvl");
				ModifyXmlfile(DOTrnsprtSvcLvl(i+1), TrnsprtSvcLvl, path);
				System.out.println("TrnsprtSvcLvl : " + TrnsprtSvcLvl + " has been updated successfully");
				Steps.logger.info("TrnsprtSvcLvl : " + TrnsprtSvcLvl + " has been updated successfully");
				
				TrnsprtSCAC = Steps.scenarioData.get("TrnsprtSCAC");
				ModifyXmlfile(DOTrnsprtSCAC(i+1), TrnsprtSCAC, path);
				System.out.println("TrnsprtSCAC : " + TrnsprtSCAC + " has been updated successfully");
				Steps.logger.info("TrnsprtSCAC : " + TrnsprtSCAC + " has been updated successfully");
				
				SICode = Steps.scenarioData.get("SICode");
				if(!(SICode.equals("")||SICode.equals(null))) {
				ModifyXmlfile(DOSpecInstrCD(i+1), SICode, path);
				System.out.println("SICode : " + SICode + " has been updated successfully");
				Steps.logger.info("SICode : " + SICode + " has been updated successfully");
				}
				
				SplIns = Steps.scenarioData.get("SplIns");
				if(!(SplIns.equals("")||SplIns.equals(null))) {
				ModifyXmlfile(DOSpecInstr(i+1), SplIns, path);
				System.out.println("SplIns : " + SplIns + " has been updated successfully");
				Steps.logger.info("SplIns : " + SplIns + " has been updated successfully");
				}
				
				
				
				Items.setProductsForDistOrder(itemName);
				Items.setItemWithShippedQtyDO(itemName, Integer.parseInt(shpQty));
				Items.setItemWithQtyUOMDO(itemName, uom);
				Items.setItemOrderTrnsprtSvcLvlDO(TrnsprtSvcLvl);
				Items.setItemOrderTrnsprtSCACDO(TrnsprtSCAC);
				
				Reporter.addStepLog("Item Id- " + Steps.ItemDataMap.get(i).get("Item") + ", Shipped Qty- "
						+ Steps.ItemDataMap.get(i).get("ShippedQty"));		
		}
		}
		
		
		File fileToBeModified = new File(path);
		String oldContent = "";
		BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
		String line = reader.readLine();
		while (line != null) {
			oldContent = oldContent + line + System.lineSeparator();
			line = reader.readLine();
		}
		globalFunc.DateTime.TimeDateFunc();
		String newContent = oldContent.replaceAll("yyyymmdd", globalFunc.DateTime.strDate2);
		String newcontent_ship = newContent.replaceAll("yymmdd", PODONumber);
		FileWriter writer = new FileWriter(path);
		writer.write(newcontent_ship);
		reader.close();
		writer.close();
	
	
	}
	
	
	public void user_modify_EDI_file(String xmlType,String TrnsprtSvcLvl1,String TrnsprtSCAC1) throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		String currTime= current_date_time();
		String PODONumber = currTime;
		
		String path=null;
		if(xmlType.contains("PO")) {
			path=inputEDIInboundFilePath;
			Items.setPONumber(PODONumber);
			String ASNno= PODONumber+"-1";
			Items.setAsnNumber(ASNno);
			Steps.logger.info("ASNNumber: "+Items.getAsnNumber());
			Steps.logger.info("PONumber: "+Items.getPONumber());
			Reporter.addStepLog("ASNNumber: "+Items.getAsnNumber());
			Reporter.addStepLog("PONumber: "+Items.getPONumber());
			
			String itemName = null;
			String shpQty = null;
			String uom = null;
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				itemName = Steps.ItemDataMap.get(i).get("Item");
				ModifyXmlfile(ASNItemName(i + 1), itemName, path);
				System.out.println("Item : " + itemName + " has been updated successfully");
				Steps.logger.info("Item : " + itemName + " has been updated successfully");
				
				shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
				ModifyXmlfile(ASNQty(i + 1), shpQty, path);
				System.out.println("Shipped Qty : " + shpQty + " has been updated successfully");
				Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");
				
				uom = Steps.ItemDataMap.get(i).get("UOM");
				ModifyXmlfile(ASNItemUOM(i + 1), uom, path);
				System.out.println("QtyUOM : " + uom + " has been updated successfully");
				Steps.logger.info("QtyUOM : " + uom + " has been updated successfully");

				Items.setItemsForReceivingASN(itemName);
				Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shpQty));
				Items.setItemWithQtyUOM(itemName, uom);
				Reporter.addStepLog("Item Id- " + Steps.ItemDataMap.get(i).get("Item") + ", Shipped Qty- "
						+ Steps.ItemDataMap.get(i).get("ShippedQty"));
			}
			
		}else if(xmlType.contains("DO")) {
			path=inputEDIOutboundFilePath;
			Items.setDONumber(PODONumber);
			Steps.logger.info("DO Number: "+PODONumber);
			Reporter.addStepLog("DO Number: "+PODONumber);
			
			String itemName = null;
			String shpQty = null;
			String uom = null;
			String TrnsprtSvcLvl = null;
			String TrnsprtSCAC = null;
			
			for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
				
				itemName = Steps.ItemDataMap.get(i).get("Item");
				ModifyXmlfile(DOItem(i+1), itemName, path);
				System.out.println("Item : " + itemName + " has been updated successfully");
				Steps.logger.info("Item : " + itemName + " has been updated successfully");
				
				shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
				ModifyXmlfile(DOQty(i+1), shpQty, path);
				System.out.println("Shipped Qty : " + shpQty + " has been updated successfully");
				Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");
				
				uom = Steps.ItemDataMap.get(i).get("UOM");
				ModifyXmlfile(DOItemUOM(i+1), uom, path);
				System.out.println("QtyUOM : " + uom + " has been updated successfully");
				Steps.logger.info("QtyUOM : " + uom + " has been updated successfully");
				
				//Rakesh
				TrnsprtSvcLvl = TrnsprtSvcLvl1;
				ModifyXmlfile(DOTrnsprtSvcLvl(i+1), TrnsprtSvcLvl, path);
				System.out.println("TrnsprtSvcLvl : " + TrnsprtSvcLvl + " has been updated successfully");
				Steps.logger.info("TrnsprtSvcLvl : " + TrnsprtSvcLvl + " has been updated successfully");
				
				TrnsprtSCAC = TrnsprtSCAC1;
				ModifyXmlfile(DOTrnsprtSCAC(i+1), TrnsprtSCAC, path);
				System.out.println("TrnsprtSCAC : " + TrnsprtSCAC + " has been updated successfully");
				Steps.logger.info("TrnsprtSCAC : " + TrnsprtSCAC + " has been updated successfully");
				
				
				Items.setProductsForDistOrder(itemName);
				Items.setItemWithShippedQtyDO(itemName, Integer.parseInt(shpQty));
				Items.setItemWithQtyUOMDO(itemName, uom);
				Items.setItemOrderTrnsprtSvcLvlDO(TrnsprtSvcLvl);
				Items.setItemOrderTrnsprtSCACDO(TrnsprtSCAC);
				
				Reporter.addStepLog("Item Id- " + Steps.ItemDataMap.get(i).get("Item") + ", Shipped Qty- "
						+ Steps.ItemDataMap.get(i).get("ShippedQty"));		
		}
		}
		
		
		File fileToBeModified = new File(path);
		String oldContent = "";
		BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
		String line = reader.readLine();
		while (line != null) {
			oldContent = oldContent + line + System.lineSeparator();
			line = reader.readLine();
		}
		globalFunc.DateTime.TimeDateFunc();
		String newContent = oldContent.replaceAll("yyyymmdd", globalFunc.DateTime.strDate2);
		String newcontent_ship = newContent.replaceAll("yymmdd", PODONumber);
		FileWriter writer = new FileWriter(path);
		writer.write(newcontent_ship);
		reader.close();
		writer.close();
	
	
	}
}
