package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.fedex.commerce.automation.entity.Product;

import io.restassured.path.json.JsonPath;

public class JSONReadAndWrite {
	public String dirPath = System.getProperty("user.dir");
	public  String jsonFilePath = dirPath + "/src/test/resources/testdata/" +"order.json";
	public  String jsonMasterFilePath = dirPath + "/src/test/resources/testdata/" +"order_master.json";
	public  String jsonMasterFilePath_twoProd = dirPath + "/src/test/resources/testdata/" +"order_master_twoProd.json";
	public  String jsonMasterFilePath_fourProd = dirPath + "/src/test/resources/testdata/" +"order_master_fourProd.json";
	public  String jsonMasterFilePath_threeProd = dirPath + "/src/test/resources/testdata/" +"order_master_threeProd.json";
	public String cancelOrder_jsonPath = dirPath + "/src/test/resources/testdata/" +"cancel_order.json";
	public String apiResponse_jsonPath = dirPath + "/src/test/resources/testdata/" +"APIOrderResponse.txt";
	public  String jsonFilePathRMA = dirPath + "/src/test/resources/testdata/" +"RMA.json";
	public  String jsonMasterFilePathRMA = dirPath + "/src/test/resources/testdata/" +"RMA_master.json";
	public String jsonUOMMasterFilePath = dirPath + "/src/test/resources/testdata/" +"order_UOM_master.json";
	public String jsonMasterFilePathWebhook = dirPath + "/src/test/resources/testdata/" +"webhookSubscription_master.json";
	public String jsonFilePathWebhook = dirPath + "/src/test/resources/testdata/" +"webhookSubscription.json";
	public String jsonChannelOrderMasterFilePath = dirPath + "/src/test/resources/testdata/" +"MasterChannelOrder.json";
	public String jsonChannelOrderFilePath = dirPath + "/src/test/resources/testdata/" +"ChannelOrder.json";
	public ObjectMapper objectMapper;
	public  String jsonItemFilePath = dirPath + "/src/test/resources/testdata/" + "item.json";
	public  String itemjsonFilePath = dirPath + "/src/test/resources/testdata/";
	public  String jsonMasterItemFilePath = dirPath + "/src/test/resources/testdata/" +"item_master.json";
	public String jsonChannelOrderMasterFilePath_twoProd = dirPath + "/src/test/resources/testdata/" +"MasterChannelOrder_twoProd.json";
	public String jsonChannelOrderMasterFilePath_threeProd = dirPath + "/src/test/resources/testdata/" +"MasterChannelOrder_threeProd.json";
	public String jsonChannelOrderMasterFilePath_fourProd = dirPath + "/src/test/resources/testdata/" +"MasterChannelOrder_fourProd.json";

	// Random external order line id
	public String user_generate_random_external_order_id() {
		String externalOrderId = null;
		String firstString = "APIOrder";
		externalOrderId = firstString + "_" + System.nanoTime();
		return externalOrderId;
	}
	
	// Random external line id
		public String user_generate_random_external_line_id() {
			String externalLineId = null;
			String firstString = "00";
			externalLineId = firstString + "_" + System.nanoTime();
			return externalLineId;
		}
	
	// Random orderNumber
		public String user_generate_random_orderNumber() {
			long orderNumber;
			orderNumber = System.nanoTime();
			String strOrderNumber = String.valueOf(orderNumber);
			int lastIndex = strOrderNumber.length();
			int startIndex = lastIndex-9;
			return (String) strOrderNumber.subSequence(startIndex,lastIndex);
		}

	// Current order date with time
	public String user_generate_current_order_date() {
		String currentOrderDate = null;
		String currentOrderTime = null;
		String currentOrderDateTime = null;
		Date currDate = new Date();
		SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
		currentOrderDate = formatterDate.format(currDate);
		SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
		currentOrderTime = formatterTime.format(currDate);
		currentOrderDateTime = currentOrderDate + "T" + currentOrderTime + "-05:00";
		return currentOrderDateTime;
	}

	// Estimated delivery date(future date - 10 days after current date)
	public String user_generate_estimated_delivery_date() {
		String estimatedDeliveryDate = null;
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, 10);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date futuredate = calender.getTime();
		estimatedDeliveryDate = formatter.format(futuredate);
		return estimatedDeliveryDate;
	}

	// Hold until date (future date - 30 days after current date)
	public String user_generate_hold_until_date() {
		String holdUntilDate = null;
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, 30);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date futuredate = calender.getTime();
		holdUntilDate = formatter.format(futuredate);
		String holdUntilDateAndTime = holdUntilDate + "T00:00:00-05:00";
		return holdUntilDateAndTime;
	}

	/**
	 * below method is used to get specified node value
	 * @param jsonFilePath - JSON file path
	 * @param nodePath - complete path of that node(ex. order.orderNumber)
	 * @return - required node value
	 */

	public Object user_gets_JSON_node_value(String jsonFilePath, String nodePath) {
		Object JSONNodeValue = null;
		try {
			FileReader fileReader = new FileReader(jsonFilePath);
			JSONNodeValue = JsonPath.with(fileReader).get(nodePath);
		} catch (FileNotFoundException exec) {
			exec.getMessage();
		}
		return JSONNodeValue;

	}
	
	/**
	 * below method is used to get specified node value
	 * @param JSONResponse - response as string
	 * @param nodeName - name of the required node
	 * @return
	 */
	public String user_gets_JSON_node_value_from_responseString(String JSONResponse,String nodeName){
		String nodeValue = null;
		JSONObject jsonObj = new JSONObject(JSONResponse);
		nodeValue = jsonObj.getString(nodeName);
		return nodeValue ;
		
	}

	/**
	 * below method is used to read complete JSON file
	 * @param filePath - JSON file path
	 * @return - complete JSON
	 * @throws IOException
	 */
	public String user_reads_complete_JSON_file(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		try {
			StringBuilder strBuilder = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				strBuilder.append(line);
				strBuilder.append("\n");
				line = br.readLine();
			}
			return strBuilder.toString();

		} finally {
			br.close();
		}
	}

	/**
	 * below method is used to update specified node value
	 * @param JSONFilePath - JSON file path
	 * @param nodeName - name of the node for which updation need to be done
	 * @param nodeValue - value of the specified node
	 * @throws IOException
	 */
	public void user_update_required_JSON_node_value(String JSONFilePath, String nodeName, String nodeValue)
			throws IOException {

		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		 objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents(nodeName);
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put(nodeName, nodeValue);
			}
		}
		System.out.println(nodeName + " has been updated as -> " + nodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);	
	}

	/**
	 * below method is used to copy JSON data from master to working
	 * @param sourceFile - master JSON file path
	 * @param targetFile - working JSON file path
	 * @throws IOException
	 */
	public void user_copy_all_data_from_masterJSON_to_workingJSON(String sourceFile, String targetFile)
			throws IOException {
		byte[] jsonData = Files.readAllBytes(Paths.get(sourceFile));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode parentNode = objectMapper.readTree(jsonData);
		objectMapper.writeValue(new File(targetFile), parentNode);
		System.out.println("Test data is created");
	}

	/**
	 * below method is used to update accessorial
	 * @param JSONFilePath - JSON file path
	 * @param nodeValue - node value(Object)
	 * @throws IOException
	 */
	public void user_update_accessorial(String JSONFilePath, String accessorialNodeValue) throws IOException {

		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("accessorial");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				if (accessorialNodeValue.contains("/")) {
					String[] accessorialNodeValues = accessorialNodeValue.split("/");
					((ObjectNode) parentNode).putPOJO("accessorial", accessorialNodeValues);
				} else {
					((ObjectNode) parentNode).put("accessorial", accessorialNodeValue);
				}
			}
			System.out.println("Accessorial has been updated as :- " + accessorialNodeValue);
			objectMapper.writeValue(new File(JSONFilePath), jsonNode);
		}

	}
	
	/**
	 * below method is used to update shipping method
	 * @param JSONFilePath - JSON file path
	 * @param nodeValue - node value(Object)
	 * @throws IOException
	 */
	public void user_update_shippingMethod(String JSONFilePath, String shippingMethodNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("shipMethod");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("shipMethod", shippingMethodNodeValue);
			}
		}
		System.out.println("Shipping Method has been updated as :- " + shippingMethodNodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	

	/**
	below method is used to update order facility
	* @param JSONFilePath - JSON file path
	* @param nodeValue - node value(Object)
	* @throws IOException
	*/
	
	public void user_update_facility(String JSONFilePath, String facilityValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("facility");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("facility", facilityValue);
			}
		}
		System.out.println("Facility Type has been updated as :- " + facilityValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	
	
	/**
	below method is used to update order Shipping Type
	* @param JSONFilePath - JSON file path
	* @param nodeValue - node value(Object)
	* @throws IOException
	*/
	 
	public void user_update_ShippingType(String JSONFilePath, String ShipTypeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("shipType");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("shipType", ShipTypeValue);
			}
		}
		System.out.println("Shipping Type has been updated as :- " + ShipTypeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	  
	
	
	
	
	/**
	 * below method is used to update order type
	 * @param JSONFilePath - JSON file path
	 * @param nodeValue - node value(Object)
	 * @throws IOException
	 */
	public void user_update_orderType(String JSONFilePath, String orderTypeNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("orderType");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("orderType", orderTypeNodeValue);
			}
		}
		System.out.println("Order Type has been updated as :- " + orderTypeNodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	
	/**
	 * below method is used to update ship type
	 * @param JSONFilePath - JSON file path
	 * @param nodeValue - node value(Object)
	 * @throws IOException
	 */
	public void user_update_shippingType(String JSONFilePath, String shipTypeNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("shipType");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("shipType", shipTypeNodeValue);
			}
		}
		System.out.println("Ship Type has been updated as :- " + shipTypeNodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	
	/**
	 * below method is used to update sku,skuDescription,skuQty and unitPrice
	 * @param JSONFilePath - JSON file path
	 * @param skuId - SKU id(Multiple SKU can be passed based on no of order lines need to create in JSON.for ex. SKU1/SKU2)
	 * @param skuDescription - SKU description(Multiple SKU desc can be passed based on no of order lines need to create in JSON.for ex. Desc1/Desc2)
	 * @param qty - SKU Qty(Multiple SKU qty can be passed based on no of order lines need to create in JSON.for ex. 1/2)
	 * @param unitPrice - SKU price(Multiple SKU price can be passed based on no of order lines need to create in JSON.for ex. 1.43/2.43)
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void user_update_SKU_skuDescripton_orderedQty_and_unitPrice(String JSONFilePath, String skuId,String skuDescription, String qty, String unitPrice) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("sku");
		System.out.println("Total Order Line - > " + parentNodes.size());
		if (parentNodes != null) {
			if(skuId.contains("/")){
				String[] SKUs = skuId.split("/");
				String[] SKUsDesc = skuDescription.split("/");
				String[] SKUsQty = qty.split("/");
				String[] SKUsPrice = unitPrice.split("/");
				int i = 0;
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("sku", SKUs[i]);
				((ObjectNode) parentNode).put("skuDescription", SKUsDesc[i]);
				((ObjectNode) parentNode).put("orderedQty", SKUsQty[i]);
				((ObjectNode) parentNode).put("unitPrice", SKUsPrice[i]);
				i++;
			}
		}else{
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("sku", skuId);
				((ObjectNode) parentNode).put("skuDescription", skuDescription);
				((ObjectNode) parentNode).put("orderedQty", qty);
				((ObjectNode) parentNode).put("unitPrice", unitPrice);
			}
		}
	    System.out.println("SKU details has been updated");
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	    }
	}
	
	/**
	 * below method is used to update complete destinationAddress along with name, address, phone, email and delivery type
	 * @param JSONFilePath - JSON file path
	 * @param destinationAddress
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public void user_update_destinationAddress(String JSONFilePath, String destinationAddress) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("name");
		String[] completeDestinationAddress = destinationAddress.split("/");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("name", completeDestinationAddress[0]);
				((ObjectNode) parentNode).put("addressLine1", completeDestinationAddress[1]);
				((ObjectNode) parentNode).put("addressLine2", completeDestinationAddress[2]);
				((ObjectNode) parentNode).put("city", completeDestinationAddress[3]);
				((ObjectNode) parentNode).put("stateCode", completeDestinationAddress[4]);
				((ObjectNode) parentNode).put("zipCode", completeDestinationAddress[5]);
				((ObjectNode) parentNode).put("countryCode", completeDestinationAddress[6]);
				((ObjectNode) parentNode).put("deliveryType", completeDestinationAddress[7]);
				((ObjectNode) parentNode).put("phoneNumber", completeDestinationAddress[8]);
				((ObjectNode) parentNode).put("email", completeDestinationAddress[9]);
			}
		}
		System.out.println("Destination Address has been updated");
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	
	
	
	
	public void user_update_freightCost_insuranceCost_dutiesAndTaxes(String JSONFilePath, String FreigshtCostinsuranceCostdutiesAndTaxes) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("freightCost");
		String[] freightInsuranceDutyTaxesCost = FreigshtCostinsuranceCostdutiesAndTaxes.split("/");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("freightCost", freightInsuranceDutyTaxesCost[0]);
				((ObjectNode) parentNode).put("insuranceCost", freightInsuranceDutyTaxesCost[1]);
				((ObjectNode) parentNode).put("dutiesAndTaxes", freightInsuranceDutyTaxesCost[2]);
	
			}
		}
		System.out.println("Freight Insurance and Duty Taxes Cost Entered");
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * below method is used to create runtime test data JSON file with updated orderNumber, orderDate, estDeliveryDate, holdUntilDate and externalOrderLineId
	 * @param JSONFilePath -  - JSON file path
	 * @throws IOException
	 */
	public void user_create_JSON_with_updated_orderNumber_orderDate_estDeliveryDate_holdUntilDate_and_externalOrderLineId(int noOfProducts, String JSONFilePath) throws IOException{
		if(noOfProducts == 1){
			user_copy_all_data_from_masterJSON_to_workingJSON(jsonMasterFilePath, JSONFilePath);
		}
		if(noOfProducts == 2){
			user_copy_all_data_from_masterJSON_to_workingJSON(jsonMasterFilePath_twoProd, JSONFilePath);
		}if(noOfProducts == 3){
			user_copy_all_data_from_masterJSON_to_workingJSON(jsonMasterFilePath_threeProd, JSONFilePath);
		}
		if(noOfProducts == 4){
			user_copy_all_data_from_masterJSON_to_workingJSON(jsonMasterFilePath_fourProd, JSONFilePath);
		}
		
		user_update_required_JSON_node_value(JSONFilePath,"orderNumber",user_generate_random_orderNumber());
		user_update_required_JSON_node_value(JSONFilePath,"externalOrderNumber","API_"+user_generate_random_orderNumber());
		user_update_required_JSON_node_value(JSONFilePath,"orderDate",user_generate_current_order_date());
		user_update_required_JSON_node_value(JSONFilePath,"estimatedDeliveryDate",user_generate_estimated_delivery_date());
		user_update_required_JSON_node_value(JSONFilePath,"holdUntilDate",user_generate_hold_until_date());
		user_update_required_JSON_node_value(JSONFilePath,"externalOrderLineId",user_generate_random_external_order_id());
	}
	
	/**
	 * below method is used to update orderNumber and extOrderLineId in JSON
	 * @param JSONFilePath - path of JSON
	 * @param orderNum - order number which need to be updated
	 * @param extOrderLineId - external order line id which need to be updated
	 * @throws IOException
	 */
	public void user_update_JSON_with_orderNumber_and_externalOrderLineId(String JSONFilePath, String orderNum, String extOrderLineId) throws IOException{
		user_update_required_JSON_node_value(JSONFilePath,"orderNumber",orderNum);
		user_update_required_JSON_node_value(JSONFilePath,"externalOrderNumber",extOrderLineId);
	}
 
	/**
	 * below method is used to update excludeCollateral
	 * @param JSONFilePath - JSON file path
	 * @param nodeValue - node value(Object)
	 * @throws IOException
	 */
	public void user_update_excludeCollateral(String JSONFilePath, boolean excludeCollateralNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("excludeCollateral");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("excludeCollateral", excludeCollateralNodeValue);
			}
		}
		System.out.println("excludeCollateral has been updated as :- " + excludeCollateralNodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	
	/**
	 * below method is used to update sku,skuDescription,skuQty and unitPrice
	 * @param JSONFilePath
	 * @param skuId - Multiple or single product name as array
	 * @param skuDescription - Multiple or single product desc as array
	 * @param qty - Multiple or single product qty as array
	 * @param unitPrice - Multiple or single product price as array
	 * @throws IOException
	 */
	public void user_update_SKU_Details(String JSONFilePath, String[] skuId, String[] skuDescription, String[] qty, String[] unitPrice) throws IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("sku");
		System.out.println("Total Order Line - > " + parentNodes.size());
		if (parentNodes != null) {
			int i = 0;
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("sku", skuId[i]);
				((ObjectNode) parentNode).put("skuDescription", skuDescription[i]);
				((ObjectNode) parentNode).put("orderedQty", qty[i]);
				((ObjectNode) parentNode).put("unitPrice", unitPrice[i]);
				i++;
			}
			  System.out.println("SKU details has been updated");
			  objectMapper.writeValue(new File(JSONFilePath), jsonNode);
		}
	}
	// Estimated delivery date(future date - 10 days after current date)
	public String user_generate_estimated_delivery_date(int futureDate) {
		String estimatedDeliveryDate = null;
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, futureDate);
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-YYYY");
		Date futuredate = calender.getTime();
		estimatedDeliveryDate = formatter.format(futuredate);
		return estimatedDeliveryDate;
	}
	
	public void user_get_the_productQty_of_all_products_from_JSON(String JSONFilePath) throws Exception {
		String apiOrderProductName;
		String apiOrderProductQty;
		apiOrderProductName = String.valueOf(user_gets_JSON_node_value(JSONFilePath,"order.line.sku"));
		apiOrderProductQty = String.valueOf(user_gets_JSON_node_value(JSONFilePath,"order.line.orderedQty"));
		apiOrderProductName = apiOrderProductName.substring(1, apiOrderProductName.length()-1);
		apiOrderProductQty = apiOrderProductQty.substring(1, apiOrderProductQty.length()-1);
        String[] apiProductName = apiOrderProductName.split(",");
        String[] apiProductQty = apiOrderProductQty.split(",");
		System.out.println("Total Number of products in json file : " + (apiProductName.length));
		for (int i = 0; i < apiProductName.length; i++) {
			System.out.println("Productname : " + apiProductName[i].trim() + " and it's qty : " + apiProductQty[i].trim());
		//	Product.setBulkOrdersProductQty(apiProductName[i].trim(), apiProductQty[i].trim());
		//	String prodQty = Product.getBulkOrdersProductQty(apiProductName[i].trim());
		}
	}
	
	/**
	public static void main(String[] args) throws Exception{
		JSONReadAndWrite JSONReadAndWrite1 = new JSONReadAndWrite();
		JSONReadAndWrite1.user_get_the_productQty_of_all_products_from_JSON(JSONReadAndWrite1.jsonMasterFilePath_threeProd);
	}
	*/
		
	public void user_create_JSON_with_updated_orderNumber_orderDate_estDeliveryDate_holdUntilDate_and_externalOrderLineId(String JSONFilePath) throws IOException{
        user_copy_all_data_from_masterJSON_to_workingJSON(jsonMasterFilePath, JSONFilePath);
        user_update_required_JSON_node_value(JSONFilePath,"orderNumber",user_generate_random_orderNumber());
        user_update_required_JSON_node_value(JSONFilePath,"externalOrderNumber","API_"+user_generate_random_orderNumber());
        user_update_required_JSON_node_value(JSONFilePath,"orderDate",user_generate_current_order_date());
        user_update_required_JSON_node_value(JSONFilePath,"estimatedDeliveryDate",user_generate_estimated_delivery_date());
        user_update_required_JSON_node_value(JSONFilePath,"holdUntilDate",user_generate_hold_until_date());
        user_update_required_JSON_node_value(JSONFilePath,"externalOrderLineId",user_generate_random_external_order_id());
    }
	
	public void user_update_newdestinationAddress(String JSONFilePath, String newdestinationAddress) throws JsonGenerationException, JsonMappingException, IOException{
        byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
        ObjectMapper objectMapper = new ObjectMapper();
        final JsonNode jsonNode = objectMapper.readTree(jsonData);
        List<JsonNode> parentNodes = jsonNode.findParents("name");
        String[] newcompleteDestinationAddress = newdestinationAddress.split("/");
        if (parentNodes != null) {
            for (JsonNode parentNode : parentNodes) {
                ((ObjectNode) parentNode).put("name", newcompleteDestinationAddress[0]);
                ((ObjectNode) parentNode).put("addressLine1", newcompleteDestinationAddress[1]);
                ((ObjectNode) parentNode).put("addressLine2", newcompleteDestinationAddress[2]);
                ((ObjectNode) parentNode).put("city", newcompleteDestinationAddress[3]);
                ((ObjectNode) parentNode).put("stateCode", newcompleteDestinationAddress[4]);
                ((ObjectNode) parentNode).put("zipCode", newcompleteDestinationAddress[5]);
                ((ObjectNode) parentNode).put("countryCode", newcompleteDestinationAddress[6]);
                ((ObjectNode) parentNode).put("deliveryType", newcompleteDestinationAddress[7]);
                ((ObjectNode) parentNode).put("phoneNumber", newcompleteDestinationAddress[8]);
                ((ObjectNode) parentNode).put("email", newcompleteDestinationAddress[9]);
            }
        }
        System.out.println("New Destination Address has been updated");
        objectMapper.writeValue(new File(JSONFilePath), jsonNode);
    }
	
	public void user_update_newSKU_skuDescripton_orderedQty_and_unitPrice(String JSONFilePath, String newskuId,String newskuDescription, String newqty, String newunitPrice) throws JsonGenerationException, JsonMappingException, IOException{
        byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
        ObjectMapper objectMapper = new ObjectMapper();
        final JsonNode jsonNode = objectMapper.readTree(jsonData);
        List<JsonNode> parentNodes = jsonNode.findParents("sku");
        System.out.println("Total Order Line - > " + parentNodes.size());
        if (parentNodes != null) {
            if(newskuId.contains("/")){
                String[] SKUs = newskuId.split("/");
                String[] SKUsDesc = newskuDescription.split("/");
                String[] SKUsQty = newqty.split("/");
                String[] SKUsPrice = newunitPrice.split("/");
                int i = 0;
            for (JsonNode parentNode : parentNodes) {
                ((ObjectNode) parentNode).put("sku", SKUs[i]);
                ((ObjectNode) parentNode).put("skuDescription", SKUsDesc[i]);
                ((ObjectNode) parentNode).put("orderedQty", SKUsQty[i]);
                ((ObjectNode) parentNode).put("unitPrice", SKUsPrice[i]);
                i++;
            }
        }else{
            for (JsonNode parentNode : parentNodes) {
                ((ObjectNode) parentNode).put("sku", newskuId);
                ((ObjectNode) parentNode).put("skuDescription", newskuDescription);
                ((ObjectNode) parentNode).put("orderedQty", newqty);
                ((ObjectNode) parentNode).put("unitPrice", newunitPrice);
            }
        }
        System.out.println("new SKU details has been updated");
        objectMapper.writeValue(new File(JSONFilePath), jsonNode);
        }
    }
	
	public void user_copy_data_from_masterJSON(int noOfProducts, String JSONFilePath) throws IOException{
		if(noOfProducts == 1){			
			user_copy_all_data_from_masterJSON_to_workingJSON(jsonMasterFilePathRMA, JSONFilePath);
			user_update_required_JSON_node_value(JSONFilePath,"orderDate", user_generate_current_order_date());
			//user_update_required_JSON_node_value(JSONFilePath,"countryCode", "");
			
		}
	}
	public void user_update_customercity(String JSONFilePath, String shippingMethodNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("City");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("City", shippingMethodNodeValue);
			}
		}
		System.out.println("city has been updated as :- " + shippingMethodNodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	public void user_update_itemsku(String JSONFilePath, String itemskuNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("sku");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("sku", itemskuNodeValue);
			}
		}
		System.out.println("Itemsku has been updated as :- " + itemskuNodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	
	/**
	 * below method is used to update specified node value
	 * @param JSONFilePath - JSON file path
	 * @param nodeName - name of the node for which updation need to be done
	 * @param nodeValue - value of the specified node as boolean
	 * @throws IOException
	 */
	public void user_update_required_JSON_node_value(String JSONFilePath, String nodeName, boolean nodeValue)
			throws IOException {

		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents(nodeName);
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put(nodeName, nodeValue);
			}
		}
		System.out.println(nodeName + " has been updated as -> " + nodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}



/**
 * below method is used to remove specified node Key and its value
 * @param JSONFilePath - JSON file path
 * @param nodeName - name of the node for which  need to be removed
 * @throws IOException
 */
public void user_remove_field_from_JSON_node_value(String JSONFilePath, String nodeName)
		throws IOException {

	byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
	 objectMapper = new ObjectMapper();
	final JsonNode jsonNode = objectMapper.readTree(jsonData);
	List<JsonNode> parentNodes = jsonNode.findParents(nodeName);
	if (parentNodes != null) {
		for (JsonNode parentNode : parentNodes) {
			((ObjectNode) parentNode).remove(nodeName);
		}
	}
	System.out.println(nodeName + " has been removed -> " );
	objectMapper.writeValue(new File(JSONFilePath), jsonNode);

}
	
	public void user_create_JSON_for_UOM_with_updated_orderNumber_orderDate_estDeliveryDate_holdUntilDate_and_externalOrderLineId(int noOfProducts, String JSONFilePath) throws IOException{
		if(noOfProducts == 1){
			user_copy_all_data_from_masterJSON_to_workingJSON(jsonUOMMasterFilePath, JSONFilePath);
		}
		user_update_required_JSON_node_value(JSONFilePath,"orderNumber",user_generate_random_orderNumber());
		user_update_required_JSON_node_value(JSONFilePath,"externalOrderNumber","API_"+user_generate_random_orderNumber());
		user_update_required_JSON_node_value(JSONFilePath,"orderDate",user_generate_current_order_date());
		user_update_required_JSON_node_value(JSONFilePath,"estimatedDeliveryDate",user_generate_estimated_delivery_date());
		user_update_required_JSON_node_value(JSONFilePath,"holdUntilDate",user_generate_hold_until_date());
		user_update_required_JSON_node_value(JSONFilePath,"externalLineId",user_generate_random_external_order_id());
	}
 
	public void user_update_salesChannel(String JSONFilePath, String salesChannelNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("salesChannel");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("salesChannel", salesChannelNodeValue);
			}
		}
		System.out.println("SalesChannel has been updated as :- " + salesChannelNodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	public void user_update_externalOrderLineId(String JSONFilePath, String externalOrderLineIdNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("externalOrderLineId");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("externalOrderLineId", externalOrderLineIdNodeValue);
			}
		}
		System.out.println("externalOrderLineId has been updated as :- " + externalOrderLineIdNodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	public void user_update_sku(String JSONFilePath, String skuNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("sku");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("sku", skuNodeValue);
			}
		}
		System.out.println("sku has been updated as :- " + skuNodeValue);
		objectMapper.writeValue(new File(JSONFilePath), jsonNode);
	}
	
	public void user_update_color(String JSONItemFilePath, String colorNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONItemFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("color");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("color", colorNodeValue);
			}
		}
		System.out.println("Color has been updated as :- " + colorNodeValue);
		objectMapper.writeValue(new File(JSONItemFilePath), jsonNode);
	}
	
	public void user_update_brand(String JSONItemFilePath, String brandNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONItemFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("dscription");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("brand", brandNodeValue);
			}
		}
		System.out.println("brand has been updated as :- " + brandNodeValue);
		objectMapper.writeValue(new File(JSONItemFilePath), jsonNode);
	}
	
	
	public void user_update_size(String JSONItemFilePath, String sizeNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONItemFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("size");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("size", sizeNodeValue);
			}
		}
		System.out.println("Size has been updated as :- " + sizeNodeValue);
		objectMapper.writeValue(new File(JSONItemFilePath), jsonNode);
	}
	
	public void user_update_style(String JSONItemFilePath, String styleNodeValue) throws JsonGenerationException, JsonMappingException, IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONItemFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("style");
		if (parentNodes != null) {
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("style", styleNodeValue);
			}
		}
		System.out.println("Style has been updated as :- " + styleNodeValue);
		objectMapper.writeValue(new File(JSONItemFilePath), jsonNode);
	}
	public void user_create_JSON_with_updated_productName(String JSONItemFilePath) throws IOException{
		
		user_copy_all_data_from_masterJSON_to_workingJSON(jsonMasterItemFilePath, JSONItemFilePath);
			
	
	user_update_required_JSON_node_value(JSONItemFilePath,"sku","product"+user_generate_random_itemName());
	
}
	
	public String user_generate_random_itemName() {
		long itemName;
		itemName = System.nanoTime();
		String stritemName = String.valueOf(itemName);
		int lastIndex = stritemName.length();
		int startIndex = lastIndex-9;
		return (String) stritemName.subSequence(startIndex,lastIndex);
	}
	

	/**
	 * below method is used to update variant id details for channel order
	 * @param JSONFilePath
	 * @param skuId - Multiple or single product name as array
	 * @param qty - Multiple or single product qty as array
	 * @throws IOException
	 */
	public void user_update_variant_Id_Details_for_channelOrder(String JSONFilePath, String[] variantId, String[] qty) throws IOException{
		byte[] jsonData = Files.readAllBytes(Paths.get(JSONFilePath));
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonNode jsonNode = objectMapper.readTree(jsonData);
		List<JsonNode> parentNodes = jsonNode.findParents("variant_id");
		System.out.println("Total Order Line - > " + parentNodes.size());
		if (parentNodes != null) {
			int i = 0;
			for (JsonNode parentNode : parentNodes) {
				((ObjectNode) parentNode).put("variant_id", variantId[i]);
				((ObjectNode) parentNode).put("quantity", qty[i]);
				i++;
			}
			  System.out.println("variantId details has been updated");
			  objectMapper.writeValue(new File(JSONFilePath), jsonNode);
		}
	}
	/**
	public static void main(String[] args)
	{
		JSONReadAndWrite jaAndWrite = new JSONReadAndWrite();
		String fututeDate = jaAndWrite.user_generate_estimated_delivery_date(365);
		String[] futureDateAsArray = fututeDate.split("-");
		System.out.println(futureDateAsArray[0]);
		System.out.println(futureDateAsArray[1]);
		System.out.println(futureDateAsArray[2]);
	}
*/
}





