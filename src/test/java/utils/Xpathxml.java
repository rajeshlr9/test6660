package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import StepDefinition.Steps;
import entity.DistributionOrders;
import entity.Items;

public class Xpathxml {
	
	WebDriver driver = Steps.seleniumDriver;
	public String dirPath = System.getProperty("user.dir");
	public String IBMasterOneItemFilePath = dirPath + "/src/test/resources/testdata/Inbound/"+Steps.scenarioData.get("Account") + "/IBMasterOneItem.xml";
	public String IBMasterTwoItemFilePath = dirPath + "/src/test/resources/testdata/Inbound/" +Steps.scenarioData.get("Account")+ "/IBMasterTwoItem.xml";
	public String IBMasterOneReturnFilePath = dirPath + "/src/test/resources/testdata/Inbound/"+Steps.scenarioData.get("Account") +"/IBMasterOne-Returns.xml";
	public String IBMasterTwoReturnFilePath = dirPath + "/src/test/resources/testdata/Inbound/" +Steps.scenarioData.get("Account")+"/IBMasterTwo-Returns.xml";
	public String ItemCreationMasterOneItemFilePath = dirPath + "/src/test/resources/testdata/Items/" + "ItemCreationMasterwithOneItem.xml";
	public String ItemCreationMasterTwoItemFilePath = dirPath + "/src/test/resources/testdata/Items/" + "ItemCreationMasterwithTwoItems.xml";
	public String inputIBFilePath = dirPath + "/src/test/resources/testdata/Inbound/"+Steps.scenarioData.get("Account") + "/InputIB.xml";
	public String ibfilePath = "C:/Users/ffd-sys-team/Desktop/ASN_QSC.txt";
	public String inputItemCreationFilePath = dirPath + "/src/test/resources/testdata/Items/" + "InputItem.xml";
	public String inputIBXMLFileName = "InputIB.xml";
	public String inputItemCreationXMLFileName = "InputItem.xml";
	public String POMasterOneItemFilePath = dirPath + "/src/test/resources/testdata/Inbound/" + "POMasterOneItem.xml";
	public String POMasterTwoItemFilePath = dirPath + "/src/test/resources/testdata/Inbound/" + "POMasterTwoItem.xml";
	public String inputPOFilePath = dirPath + "/src/test/resources/testdata/Inbound/" + "InputPO.xml";
	public String inputPOXMLFileName = "InputPO.xml";
	public String DOMasterFilePath = dirPath + "/src/test/resources/testdata/Outbound/" + "OutBoundMaster.xml";
	public String DOMasterTwoItemFilePath = dirPath + "/src/test/resources/testdata/Outbound/" + "OutBoundMasterTwoItems.xml";
	public String DOMasterLTLFilePath = dirPath + "/src/test/resources/testdata/Outbound/" + "OutBoundMasterTL_LTL.xml";
	public String tempDOXMLFileName="TempDO.xml";
	public String tempDOXML = dirPath + "/src/test/resources/testdata/Outbound/" + "TempDO.xml";
	public String UAT_ASN_path = dirPath + "/src/test/resources/testdata/Inbound/"+ "UAT_ASN_MULTI_LINE.xml";
	
	public String DFilParcelOneItemFilePath=dirPath + "/src/test/resources/testdata/Outbound/" + "DFil_XML_OneItem.xml";
	public String DFilParcelTwoItemFilePath=dirPath + "/src/test/resources/testdata/Outbound/" + "DFil_XML_TwoItems.xml";
	public String BulkParcelOneItemFilePath=dirPath + "/src/test/resources/testdata/Outbound/" + "Bulk_XML_Parcel_OneItem.xml";
	public String BulkParcelTwoItemFilePath=dirPath + "/src/test/resources/testdata/Outbound/" + "Bulk_XML_Parcel_TwoItems.xml";
	public String BulkTLLTLOneItemFilePath=dirPath + "/src/test/resources/testdata/Outbound/" + "BULK_TL_LTL_OneItem.xml";
	public String BulkTLLTLTwoItemFilePath=dirPath + "/src/test/resources/testdata/Outbound/" + "BULK_TL_LTL_TwoItems.xml";
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
		return "//DistributionOrder/LineItem[" + i + "]/ItemName";
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
    
	public void user_create_inputXML_for_inbound_basedOn_noOfItem_ItemCreation(int noOfItem) throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		
		if(noOfItem == 1){
			user_copy_content_from_source_to_target(ItemCreationMasterOneItemFilePath, inputItemCreationFilePath);
			
		}else if(noOfItem == 2){
			user_copy_content_from_source_to_target(ItemCreationMasterTwoItemFilePath, inputItemCreationFilePath);
		}
		
		
	}
	public void user_create_inputPOXML_for_inbound_basedOn_noOfItem(int noOfItem) throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		String PODate = user_generate_delivery_start_date();
		
		String POrderId = "POGVK" + SeleniumTestHelper.generateRandomInt(1000, 9999) + "-"
				+ SeleniumTestHelper.generateRandomInt(1, 9);	
			
		Items.setPurchaseOrderID(POrderId);
		if(noOfItem == 1){
			user_copy_content_from_source_to_target(POMasterOneItemFilePath, inputPOFilePath);
		}else if(noOfItem == 2){
			user_copy_content_from_source_to_target(POMasterTwoItemFilePath, inputPOFilePath);
		}
		System.out.println("XML input data created with : " + noOfItem + " item");
		ModifyXmlfile(POUpdatePOID(), POrderId, inputPOFilePath);
		System.out.println("POID has been updated as : " + POrderId);
		ModifyXmlfile(PODate(), PODate, inputPOFilePath);
		System.out.println("DeliveryStartDate has been updated as : " + PODate);
	}
	public String ItemUpdateItemdescription(int i) {
		return "//Item[" + i + "]/Description";
	}
	public void create_xmlFile_for_DistributionOrder_to_upload(int noOfItem,String orderType)
			throws FileNotFoundException, IOException, XPathExpressionException, SAXException,
			ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		String pickupStartDate = user_generate_delivery_start_date();
		String pickupEndDate = CurrentDayplusdaysindateformat(1);
		String deliveryStartDate = CurrentDayplusdaysindateformat(2);
		String deliveryEndDate = CurrentDayplusdaysindateformat(3);
		int DOID = SeleniumTestHelper.generateRandomInt(1000000, 9999999);
		String DONumber = "DO" + DOID;
		DistributionOrders.setDOnumber(DONumber);
		System.out.println("DO number generated is " +DistributionOrders.getDOnumber());
		
			if(orderType.equalsIgnoreCase("DFILL"))
			{
				if(noOfItem == 1 )
				{
					user_copy_content_from_source_to_target(DFilParcelOneItemFilePath, tempDOXML);
				}
				else if(noOfItem == 2 ){
					user_copy_content_from_source_to_target(DFilParcelTwoItemFilePath, tempDOXML);
				}
			}
			else if(orderType.equalsIgnoreCase("Bulk Parcel"))
			{
				if(noOfItem == 1 )
				{
					user_copy_content_from_source_to_target(BulkParcelOneItemFilePath, tempDOXML);
				}
				else if(noOfItem == 2 ){
					user_copy_content_from_source_to_target(BulkParcelTwoItemFilePath, tempDOXML);
				}
			}
			else if(orderType.equalsIgnoreCase("NL"))
			{
				if(noOfItem == 1 )
				{
					user_copy_content_from_source_to_target(BulkTLLTLOneItemFilePath, tempDOXML);
				}
				else if(noOfItem == 2 ){
					user_copy_content_from_source_to_target(BulkTLLTLTwoItemFilePath, tempDOXML);
				}
				ModifyXmlfile(RefShipmentNbr(),DistributionOrders.getDOnumber() , tempDOXML);
				System.out.println("Reference Shipping Nbr upadted as : "+DistributionOrders.getDOnumber());
			}
		
		ModifyXmlfile(DistributionOrderIdUpdate(), DistributionOrders.getDOnumber(), tempDOXML);
		System.out.println("Distribution Order upadted is : "+DistributionOrders.getDOnumber());
		ModifyXmlfile(OrderedDttmUpdate(),pickupStartDate , tempDOXML);
		System.out.println("OrderedDttm upadted as : "+pickupStartDate);
		ModifyXmlfile(PickupStartDttmUpdate(),pickupStartDate , tempDOXML);
		System.out.println("PickupStartDttm upadted as : "+pickupStartDate);
		ModifyXmlfile(PickupEndDttmUpdate(),pickupEndDate , tempDOXML);
		System.out.println("PickupEndDttm upadted as : "+pickupEndDate);
		ModifyXmlfile(DeliveryStartDttmUpdate(),deliveryStartDate , tempDOXML);
		System.out.println("DeliveryStartDttm upadted as : "+deliveryStartDate);
		ModifyXmlfile(DeliveryEndDttmUpdate(),deliveryEndDate , tempDOXML);
		System.out.println("DeliveryEndDttm upadted as : "+deliveryEndDate);
		System.out.println("TempDO XML data for the scenario has been created successfully with all the required data");
	}
	
	
	public void create_xmlFile_for_DistributionOrder_to_uploadbyshipvia(int noOfItem,String orderType,String shipvia, String SaturdayFlag)
			throws FileNotFoundException, IOException, XPathExpressionException, SAXException,
			ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		String pickupStartDate = user_generate_delivery_start_date();
		int DOID = SeleniumTestHelper.generateRandomInt(1000000, 9999999);
		String DONumber = "DO" + DOID;
		DistributionOrders.setDOnumber(DONumber);
		System.out.println("DO number generated is " +DistributionOrders.getDOnumber());
		
			if(orderType.equalsIgnoreCase("DFILL"))
			{
				if(noOfItem == 1 )
				{
					user_copy_content_from_source_to_target(DFilParcelOneItemFilePath, tempDOXML);
				}
				else if(noOfItem == 2 ){
					user_copy_content_from_source_to_target(DFilParcelTwoItemFilePath, tempDOXML);
				}
			}
			else if(orderType.equalsIgnoreCase("Bulk Parcel"))
			{
				if(noOfItem == 1 )
				{
					user_copy_content_from_source_to_target(BulkParcelOneItemFilePath, tempDOXML);
				}
				else if(noOfItem == 2 ){
					user_copy_content_from_source_to_target(BulkParcelTwoItemFilePath, tempDOXML);
				}
			}
			else if(orderType.equalsIgnoreCase("NL"))
			{
				if(noOfItem == 1 )
				{
					user_copy_content_from_source_to_target(BulkTLLTLOneItemFilePath, tempDOXML);
				}
				else if(noOfItem == 2 ){
					user_copy_content_from_source_to_target(BulkTLLTLTwoItemFilePath, tempDOXML);
				}
			}
		
			if(shipvia.equalsIgnoreCase("SHP012")){
		ModifyXmlfile(DistributionOrderIdUpdate(), DistributionOrders.getDOnumber(), tempDOXML);
		System.out.println("Distribution Order upadted is : "+DistributionOrders.getDOnumber());
		ModifyXmlfile(OrderedDttmUpdate(),pickupStartDate , tempDOXML);
		System.out.println("OrderedDttm upadted as : "+pickupStartDate);
		ModifyXmlfile(PickupStartDttmUpdate(),pickupStartDate , tempDOXML);
		System.out.println("PickupStartDate upadted as : "+pickupStartDate);
		ModifyXmlfile(PickupEndDttmUpdate(),CurrentDayplusdaysindateformat(3), tempDOXML);
		System.out.println("PickupEndDate upadted as : "+CurrentDayplusdaysindateformat(3));
		ModifyXmlfile(DeliveryStartDttmUpdate(), CurrentDayplusdaysindateformat(6), tempDOXML);
		System.out.println("DeliveryStartDate upadted as : "+CurrentDayplusdaysindateformat(6));
		ModifyXmlfile(DeliveryEndDttmUpdate(), CurrentDayplusdaysindateformat(9), tempDOXML);
		System.out.println("DeliveryEndDate upadted as : "+CurrentDayplusdaysindateformat(9));
		System.out.println("TempDO XML data for the scenario has been created successfully with all the required data");
			}
			
			else if(shipvia.equalsIgnoreCase("03")||shipvia.equalsIgnoreCase("02")||shipvia.equalsIgnoreCase("UPSGROUND2")){
				ModifyXmlfile(DistributionOrderIdUpdate(), DistributionOrders.getDOnumber(), tempDOXML);
				System.out.println("Distribution Order upadted is : "+DistributionOrders.getDOnumber());
				ModifyXmlfile(OrderedDttmUpdate(),pickupStartDate , tempDOXML);
				if(SaturdayFlag=="No")
				{
					Calendar cl = Calendar.getInstance();
					if ((cl.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)||(cl.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY))
					{
						SeleniumTestHelper.user_generate_estimated_delivery_date(3);
						System.out.println("OrderedDttm upadted as : "+SeleniumTestHelper.user_generate_estimated_delivery_date(3) );
						ModifyXmlfile(PickupStartDttmUpdate(),SeleniumTestHelper.user_generate_estimated_delivery_date(3) , tempDOXML);
						System.out.println("PickupStartDttm upadted as : "+SeleniumTestHelper.user_generate_estimated_delivery_date(3) );
						ModifyXmlfile(PickupEndDttmUpdate(),SeleniumTestHelper.user_generate_estimated_delivery_date(4) , tempDOXML);
						System.out.println("PickupEndDttm upadted as : "+SeleniumTestHelper.user_generate_estimated_delivery_date(4));
						ModifyXmlfile(DeliveryStartDttmUpdate(),SeleniumTestHelper.user_generate_estimated_delivery_date(5), tempDOXML);
						System.out.println("DeliveryStartDttm upadted as : "+SeleniumTestHelper.user_generate_estimated_delivery_date(5));
						ModifyXmlfile(DeliveryEndDttmUpdate(),SeleniumTestHelper.user_generate_estimated_delivery_date(5) , tempDOXML);
						System.out.println("DeliveryEndDttm upadted as : "+SeleniumTestHelper.user_generate_estimated_delivery_date(5));
					}
					else if((cl.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY))
					{
						ModifyXmlfile(OrderedDttmUpdate(),SeleniumTestHelper.user_generate_estimated_delivery_date(4) , tempDOXML);
						System.out.println("OrderedDttm upadted as : "+SeleniumTestHelper.user_generate_estimated_delivery_date(4) );
						ModifyXmlfile(PickupStartDttmUpdate(),SeleniumTestHelper.user_generate_estimated_delivery_date(4) , tempDOXML);
						System.out.println("PickupStartDttm upadted as : "+SeleniumTestHelper.user_generate_estimated_delivery_date(4) );
						ModifyXmlfile(PickupEndDttmUpdate(),SeleniumTestHelper.user_generate_estimated_delivery_date(4) , tempDOXML);
						System.out.println("PickupEndDttm upadted as : "+SeleniumTestHelper.user_generate_estimated_delivery_date(4));
						ModifyXmlfile(DeliveryStartDttmUpdate(),SeleniumTestHelper.user_generate_estimated_delivery_date(5), tempDOXML);
						System.out.println("DeliveryStartDttm upadted as : "+SeleniumTestHelper.user_generate_estimated_delivery_date(5));
						ModifyXmlfile(DeliveryEndDttmUpdate(),SeleniumTestHelper.user_generate_estimated_delivery_date(6) , tempDOXML);
						System.out.println("DeliveryEndDttm upadted as : "+SeleniumTestHelper.user_generate_estimated_delivery_date(6));
						
					}
				}
				System.out.println("OrderedDttm upadted as : "+pickupStartDate);
				ModifyXmlfile(PickupStartDttmUpdate(),pickupStartDate , tempDOXML);
				System.out.println("PickupStartDate upadted as : "+pickupStartDate);
				ModifyXmlfile(PickupEndDttmUpdate(),CurrentDayplusdaysindateformat(3), tempDOXML);
				System.out.println("PickupEndDate upadted as : "+CurrentDayplusdaysindateformat(3));
				ModifyXmlfile(DeliveryStartDttmUpdate(), CurrentDayplusdaysindateformat(6), tempDOXML);
				System.out.println("DeliveryStartDate upadted as : "+CurrentDayplusdaysindateformat(6));
				ModifyXmlfile(DeliveryEndDttmUpdate(), CurrentDayplusdaysindateformat(9), tempDOXML);
				System.out.println("DeliveryEndDate upadted as : "+CurrentDayplusdaysindateformat(9));
				System.out.println("TempDO XML data for the scenario has been created successfully with all the required data");
				
			}
			
			else{
				ModifyXmlfile(DistributionOrderIdUpdate(), DistributionOrders.getDOnumber(), tempDOXML);
				System.out.println("Distribution Order upadted is : "+DistributionOrders.getDOnumber());
				ModifyXmlfile(OrderedDttmUpdate(),pickupStartDate , tempDOXML);
				System.out.println("OrderedDttm upadted as : "+pickupStartDate);
				System.out.println("TempDO XML data for the scenario has been created successfully with all the required data");
			}
	}
	
	public void create_ASN_XML_for_UAT() throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		String deliveryStartDate = user_generate_delivery_start_date();
		user_copy_content_from_source_to_target(UAT_ASN_path, inputIBFilePath);
		ModifyXmlfile(ASNUpdateDeliveryStart(), deliveryStartDate, inputIBFilePath);
		System.out.println("DeliveryStartDate has been updated as : " + deliveryStartDate);
	}
	
}
