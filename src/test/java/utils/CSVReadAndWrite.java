package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Reporter;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import utils.TestStubReader;

public class CSVReadAndWrite {
	public CSVReader csvReader;
	public CSVWriter writer;
	public static final char SEPARATOR = ',';
	public String dirPath = System.getProperty("user.dir");
	public String bulkOrderFilePath = dirPath + "/src/test/resources/"
			+ "OrdersUpload.csv";
	public String bulkOrderMasterFIlePath = dirPath + "/src/test/resources/"
			+ "OrdersUploadMaster.csv";
	public String bulkUploadErrorFile = dirPath + "/sel_downloads/"
			+ "error.csv";
	public String bulkUploadErrorCodeMaster = dirPath + "/src/test/resources/"
			+ "OrdersUpload_ErrorCodeMaster.csv";
	private static Map<String, Integer> bulkOrdersColumnHeader = new HashMap<>();
	public static ArrayList<String> bundleName = new ArrayList();
	public String masterBulkUploadPackageFilePath = dirPath
			+ "/src/test/resources/testdata/" + "BulkUploadPackageMaster.csv";
	public String bulkUploadPackageFilePath = dirPath
			+ "/src/test/resources/testdata/" + "BulkUploadPackage.csv";
	private static Map<String, Integer> bulkOrdersColumnHeaderTwo = new HashMap<>();
	public String orderTypeCSVFilePath = dirPath + "/sel_downloads/"
			+ "Order_Types.csv";
	public String productUploadCSVFilePath = dirPath + "/sel_downloads/"
			+ "Product Upload.csv";
	//public String extlineId;
	//public String extordernum;

	public int getBulkOrdersColumnHeader(String headerColumnName) {
		int accessorialValue = bulkOrdersColumnHeader.get(headerColumnName);
		return accessorialValue;
	}

	public void setBulkOrdersColumnHeader(String headerColumnName,
			int headerColumnIndex) {
		bulkOrdersColumnHeader.put(headerColumnName, headerColumnIndex);
	}

	public int getBulkOrdersPackageColumnHeader(String headerColumnName) {
		int accessorialValue = bulkOrdersColumnHeaderTwo.get(headerColumnName);
		return accessorialValue;
	}

	public void setBulkOrdersPackageHeader(String headerColumnName,
			int headerColumnIndex) {
		bulkOrdersColumnHeaderTwo.put(headerColumnName, headerColumnIndex);
	}

	/**
	 * Below block is to get the Column header name
	 */
	{
		List<String[]> allBulkUploadCSVData;
		try {
			allBulkUploadCSVData = user_read_all_data_of_mastersheet(bulkOrderMasterFIlePath);
			String[] colHeader = allBulkUploadCSVData.get(0);
			for (int i = 0; i < colHeader.length; i++) {
				setBulkOrdersColumnHeader(colHeader[i], i + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Below block is to get the Column header name
	 */
	{
		List<String[]> allBulkUploadPackageCSVData;
		try {
			allBulkUploadPackageCSVData = user_read_all_data_of_mastersheet(masterBulkUploadPackageFilePath);
			String[] colHeader1 = allBulkUploadPackageCSVData.get(0);
			for (int i = 0; i < colHeader1.length; i++) {
				setBulkOrdersPackageHeader(colHeader1[i], i + 1);
			}
			String[] colHeader2 = allBulkUploadPackageCSVData.get(1);
			for (int i = 0; i < colHeader2.length; i++) {
				setBulkOrdersPackageHeader(colHeader2[i], i + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String user_generate_random_external_order_id() {
		String externalOrderId = null;
		String firstString = "BulkOrder";
		externalOrderId = firstString + "_" + System.nanoTime();
		return externalOrderId;
	}

	public String user_generate_random_external_order_number() {
		String externalOrdernum = null;
		externalOrdernum = RandomStringUtils.random(6);
		System.out.println("External order number--->" + externalOrdernum);
		return externalOrdernum;
	}

	public String user_generate_random_external_line_id() {
		String externallineid = null;

		externallineid = RandomStringUtils.random(4);
		System.out.println("External order number--->" + externallineid);
		return externallineid;
	}

	public String user_generate_current_order_date() {
		String currentOrderDate = null;
		Date currDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyyy");
		currentOrderDate = formatter.format(currDate);
		return currentOrderDate;
	}

	public String user_generate_estimated_delivery_date() {
		String estimatedDeliveryDate = null;
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, 8);
		SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyyy");
		Date futuredate = calender.getTime();
		estimatedDeliveryDate = formatter.format(futuredate);
		return estimatedDeliveryDate;
	}

	public void user_update_the_shippingMethod_in_bulkUploadFile(
			int numOfRecords, String shippingMethod) {
		for (int i = 1; i <= numOfRecords; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Shipping method"), i,
					shippingMethod);
			System.out.println("Shipping method : " + shippingMethod
					+ " is updated for order : " + i);
		}
	}

	public void user_update_the_externalOrderId_in_bulkUploadFile(
			int numOfRecords) {
		String extOrderId = user_generate_random_external_order_id();
		for (int i = 1; i <= numOfRecords; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Order Id"), i,
					extOrderId);
			System.out.println("External Order ID : " + extOrderId
					+ " is updated for order : " + i);
		}
	}

	public void user_update_the_orderType_in_bulkUploadFile(int numOfRecords,
			String orderType) {
		for (int i = 1; i <= numOfRecords; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Order type"), i, orderType);
			System.out.println("Order Type : " + orderType
					+ " is updated for order : " + i);
		}
	}

	public void user_update_the_SKU_in_bulkUploadFile(int numOfRecords,
			String SKUId) {
		for (int i = 1; i <= numOfRecords; i++) {
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("SKU#"),
					i, SKUId);
			System.out.println("SKU# id : " + SKUId
					+ " is updated for order : " + i);
		}
	}

	public void user_update_the_accessorial_in_bulkUploadFile(int numOfRecords,
			String allAccessorial) {
		String[] accessorial = allAccessorial.split("/");
		if (accessorial.length == numOfRecords) {
			for (int i = 1; i <= numOfRecords; i++) {
				setCellValue(bulkOrderFilePath,
						getBulkOrdersColumnHeader("Accessorial"), i,
						accessorial[i - 1]);
				System.out.println("Accessorial : " + accessorial[i - 1]
						+ " is updated for order : " + i);
			}
		} else {
			System.out
					.println("No of records should be same as no of accessorial provided");
			Reporter.log("No of records should be same as no of accessorial provided");
		}

	}

	public List<String[]> user_read_all_data_of_mastersheet(String filePath)
			throws Exception {
		csvReader = new CSVReader(new FileReader(filePath), SEPARATOR);
		return csvReader.readAll();
	}

	public void user_copied_allData_from_bulkUploadMaster_to_bulkUploadWorking(
			int numOfRecords, String sourceFile, String targetFile)
			throws IOException {
		int readLine = 0;
		csvReader = new CSVReader(new FileReader(sourceFile), SEPARATOR);
		List<String[]> reader_bulkUploadSheet = csvReader.readAll();
		CSVWriter writer = new CSVWriter(new FileWriter(targetFile, false),
				SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);
		writer.writeNext(reader_bulkUploadSheet.get(readLine));
		readLine++;

		for (int i = 1; i <= numOfRecords; i++) {
			writer.writeNext(reader_bulkUploadSheet.get(readLine));
			writer.flush();
			readLine++;

		}
		// writer.flush();
		writer.close();

	}

	public void user_create_records_with_updated_externalOrderId_orderDate_and_esmimatedDeliveryDate(
			int numOfRecords) throws Exception {
		int readLine = 0;
		List<String[]> reader_MasterSheet = user_read_all_data_of_mastersheet(bulkOrderMasterFIlePath);
		CSVWriter writer = new CSVWriter(new FileWriter(bulkOrderFilePath,
				false), SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);
		writer.writeNext(reader_MasterSheet.get(readLine));
		readLine++;
		// System.out.println("Reading:: Line" + readLine);

		for (int i = 1; i <= numOfRecords; i++) {
			writer.writeNext(reader_MasterSheet.get(readLine));
			// String line = writer.DEFAULT_LINE_END;
			// System.out.println(line);
			writer.flush();

		}
		// writer.flush();
		writer.close();
		// String extOrderId = user_generate_random_external_order_id();
		for (int j = 1; j <= numOfRecords; j++) {
			// generate random external order id
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Order Id"), j,
					user_generate_random_external_order_id());

			// generate current order date
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Order Date"), j,
					user_generate_current_order_date());

			// generate estimated delivery date
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Estimated delivery date"), j,
					user_generate_estimated_delivery_date());
		}
	}

	public void user_create_orders_with_same_externalOrderId_orderDate_and_esmimatedDeliveryDate(
			int numOfRecords) throws Exception {
		int readLine = 0;
		List<String[]> reader_MasterSheet = user_read_all_data_of_mastersheet(bulkOrderMasterFIlePath);
		CSVWriter writer = new CSVWriter(new FileWriter(bulkOrderFilePath,
				false), SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);
		writer.writeNext(reader_MasterSheet.get(readLine));
		readLine++;
		// System.out.println("Reading:: Line" + readLine);

		for (int i = 1; i <= numOfRecords; i++) {
			writer.writeNext(reader_MasterSheet.get(readLine));
			// String line = writer.DEFAULT_LINE_END;
			// System.out.println(line);
			writer.flush();

		}
		// writer.flush();
		writer.close();

		String extOrderId = user_generate_random_external_order_id();
		for (int j = 1; j <= numOfRecords; j++) {
			// generate random external order id
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Order Id"), j,
					extOrderId);

			// generate current order date
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Order Date"), j,
					user_generate_current_order_date());

			// generate estimated delivery date
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Estimated delivery date"), j,
					user_generate_estimated_delivery_date());
		}
	}

	// updated on 9 Sep
	public void user_update_externalOrderId_orderDate_and_esmimatedDeliveryDate(
			int numOfRecords) throws Exception {
		String extOrderId = user_generate_random_external_order_id();
		for (int j = 1; j <= numOfRecords; j++) {
			// generate random external order id
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Order Id"), j,
					user_generate_random_external_order_id());

			// generate current order date
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Order Date"), j,
					user_generate_current_order_date());

			// generate estimated delivery date
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Estimated delivery date"), j,
					user_generate_estimated_delivery_date());
		}
	}

	public void user_update_orderDate_and_esmimatedDeliveryDate(int numOfRecords)
			throws Exception {

		for (int j = 1; j <= numOfRecords; j++) {

			// generate current order date
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Order Date"), j,
					user_generate_current_order_date());

			// generate estimated delivery date
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Estimated delivery date"), j,
					user_generate_estimated_delivery_date());
		}
	}

	public void setCellValue(String filePath, int columnNumber, int rowNumber,
			String value) {

		List<String> allLines = new LinkedList<>();

		// Reading
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filePath));

			int rowIndex = 0;
			String line = null;
			String columnsLine = br.readLine();
			allLines.add(columnsLine);

			int columnLength = columnsLine.split(",").length;
			String[] valueContainer = new String[columnLength];
			for (int j = 0; j < columnLength; j++) {
				valueContainer[j] = "";
			}

			while ((line = br.readLine()) != null) {

				if (rowIndex + 1 == rowNumber) {
					String[] values = line.split(",");

					for (int i = 0; i < values.length; i++) {
						valueContainer[i] = values[i];
					}

					valueContainer[columnNumber - 1] = value;

					line = "";

					for (int i = 0; i < valueContainer.length; i++) {
						line += valueContainer[i] + ",";
					}

					line = line.substring(0, line.length() - 1);
				}

				allLines.add(line);
				// System.out.println(allLines.size());
				rowIndex++;
			}

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
			}
		}

		// Writing
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(filePath));

			for (String line : allLines) {
				bw.write(line);
				bw.newLine();
			}

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (Exception e) {
			}
		}
	}

	/**
	 * below method is to create bulk upload csv sheet with multiple fulfillment
	 * center
	 * 
	 * @param totalOrders
	 *            - total no of orders
	 * @param WMS1Order
	 *            - no of orders related to "HFY" fulfillment center
	 * @throws Exception
	 */
	public void user_create_orders_in_bulkUploadFile_with_combination_of_multiple_fulfillmentCentre(
			int totalOrders, int WMS1Order) throws Exception {
		user_create_records_with_updated_externalOrderId_orderDate_and_esmimatedDeliveryDate(totalOrders);
		int WMS2Order = totalOrders - WMS1Order;
		String externalOrderIdForWMS1 = user_generate_random_external_order_id();
		String externalOrderIdForWMS2 = user_generate_random_external_order_id();

		for (int i = 1; i <= WMS1Order; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Order Id"), i,
					externalOrderIdForWMS1);
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Fulfillment Center"), i, "HFY");
		}
		for (int i = WMS1Order + 1; i <= totalOrders; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Order Id"), i,
					externalOrderIdForWMS2);
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Fulfillment Center"), i, "FCA");
		}
	}

	public void user_copied_rowData_from_bulkUploadMaster_to_bulkUploadWorking(
			int fromRow, int toRow, String sourceFile, String targetFile)
			throws IOException {
		int readLine = 0;
		csvReader = new CSVReader(new FileReader(sourceFile), SEPARATOR);
		List<String[]> reader_bulkUploadSheet = csvReader.readAll();
		CSVWriter writer = new CSVWriter(new FileWriter(targetFile, false),
				SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);
		writer.writeNext(reader_bulkUploadSheet.get(readLine));
		readLine++;
		for (int i = fromRow; i <= toRow; i++) {
			readLine = fromRow;
			writer.writeNext(reader_bulkUploadSheet.get(readLine));
			writer.flush();
			fromRow++;
		}
		// writer.flush();
		writer.close();

	}

	public List<String[]> readAllRowsAndColOfCSV(String bulkfilePath)
			throws Exception {

		CSVReader csvReader = new CSVReader(new FileReader(bulkfilePath),
				SEPARATOR);
		return csvReader.readAll();
	}

	public void user_get_the_productQty_of_bulkUploadOrders(String bulkfilePath)
			throws Exception {
		CSVReader csvReader = new CSVReader(new FileReader(bulkfilePath),
				SEPARATOR);
		int ordersCount = csvReader.readAll().size();
		System.out.println("Total Number of orders in bulk upload file : "
				+ (ordersCount - 1));
		for (int i = 1; i < ordersCount; i++) {
			String bulkOrderProductQty = readAllRowsAndColOfCSV(bulkfilePath)
					.get(i)[5];
			String bulkOrderProductName = readAllRowsAndColOfCSV(bulkfilePath)
					.get(i)[2];
			System.out.println("Productname : " + bulkOrderProductName
					+ " and it's qty : " + bulkOrderProductQty);
		//	Product.setBulkOrdersProductQty(bulkOrderProductName,
		//			bulkOrderProductQty);
		//	String prodQty = Product
		//			.getBulkOrdersProductQty(bulkOrderProductName);

		}
	}

	public void user_update_address_for_Order(int noOfOrders,
			String internationalAddress) {
		String[] internationAddrs = internationalAddress.split("/");
		for (int i = 1; i <= noOfOrders; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Address 1"), i,
					internationAddrs[0]);
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("City"),
					i, internationAddrs[1]);
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("State"),
					i, internationAddrs[2]);
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("Zip"),
					i, internationAddrs[3]);
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Country"), i,
					internationAddrs[4]);
		}

	}

	/**
	 * public static void main(String[] args) throws Exception { CSVReadAndWrite
	 * csvReadAndWrite = new CSVReadAndWrite(); csvReadAndWrite.
	 * user_create_records_with_updated_externalOrderId_orderDate_and_esmimatedDeliveryDate
	 * (5); csvReadAndWrite.
	 * user_create_orders_in_bulkUploadFile_with_combination_of_multiple_fulfillmentCentre
	 * (8,4); }
	 */
	public void user_gets_the_bundleName_from_sheets(String bulkfilePath)
			throws Exception {
		CSVReader csvReader = new CSVReader(new FileReader(bulkfilePath),
				SEPARATOR);
		int ordersCount = csvReader.readAll().size();
		System.out.println("Total Number of orders in bulk upload file : "
				+ (ordersCount - 1));
		String bundleNames = null;
		for (int i = 1; i < ordersCount; i++) {
			bundleNames = readAllRowsAndColOfCSV(bulkfilePath).get(i)[2];
			System.out.println("bundleName : " + bundleNames);
			bundleName.add(bundleNames);

		}
	}

	public void user_update_the_fulfillmentCenter_in_bulkUploadFile(
			int numOfRecords, String fulfillmentCenter) {
		for (int i = 1; i <= numOfRecords; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Fulfillment Center"), i,
					fulfillmentCenter);
			System.out.println("Fulfillment Center : " + fulfillmentCenter
					+ " is updated for order : " + i);
		}
	}

	public void user_updates_the_sku_value_in_CSV_file_and_updates_collateral_sku_from_excelSheet_and_sets_excludecollateral_to_No(
			int numOfRecords, String sheetName, int productNumber) {

		TestStubReader stubReader = new TestStubReader();
		for (int i = 1; i <= numOfRecords; i++) {
			String SKU = stubReader.setSheetAndGetData(sheetName,
					"Product Name", i);
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("SKU#"),
					i, SKU);

			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Exclude Collateral"), i, "No");
			System.out.println("SKU# id : " + SKU + " is updated for order : "
					+ i);

		}
		String productNameFromExcel = stubReader.setSheetAndGetData(sheetName,
				"Product Name", productNumber);
		setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("SKU#"),
				numOfRecords, productNameFromExcel);
	}

	public void user_update_the_SKU_in_bulkUploadFile_from_excelSheet(
			int numOfRecords, String sheetName) {
		for (int i = 1; i <= numOfRecords; i++) {
			TestStubReader stubReader = new TestStubReader();
			String SKU = stubReader.setSheetAndGetData(sheetName,
					"Product Name", i);
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("SKU#"),
					i, SKU);
			System.out.println("SKU# id : " + SKU + " is updated for order : "
					+ i);
		}
	}

	public void user_update_the_bundle_in_bulkUploadFile_from_excelSheet(
			int numOfRecords, String sheetName) {
		for (int i = 1; i <= numOfRecords; i++) {
			TestStubReader stubReader = new TestStubReader();
			String SKU = stubReader.setSheetAndGetData(sheetName,
					"Bundle Name", i);
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("SKU#"),
					i, SKU);
			System.out.println("SKU# id : " + SKU + " is updated for order : "
					+ i);
		}

	}

	public void user_update_the_SKU_in_bulkUploadFile_from_excelSheet_for_multiple_fulfillmentCentre(
			int noOfOrder, int noOfOrdersForWMS1, String productOrBundle,
			String sheetName1, String productOrBundle2, String sheetName2)
			throws Exception {
		String externalOrderIdForWMS1 = user_generate_random_external_order_id();
		String externalOrderIdForWMS2 = user_generate_random_external_order_id();
		TestStubReader stubReader = new TestStubReader();
		for (int i = 1; i <= noOfOrdersForWMS1; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Order Id"), i,
					externalOrderIdForWMS1);
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Fulfillment Center"), i, "HFY");
			String SKU = stubReader.setSheetAndGetData(sheetName1,
					productOrBundle, i);
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("SKU#"),
					i, SKU);
		}
		for (int i = noOfOrdersForWMS1 + 1; i <= noOfOrder; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Order Id"), i,
					externalOrderIdForWMS2);
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Fulfillment Center"), i, "FCA");
			String SKU = stubReader.setSheetAndGetData(sheetName2,
					productOrBundle2, i);
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("SKU#"),
					i, SKU);
		}

	}

	public String user_generate_holdUntil_date() {

		Calendar calendar = Calendar.getInstance();
		calendar.add(calendar.DATE, 5);
		SimpleDateFormat format = new SimpleDateFormat("M/dd/yyyy HH:mm");
		Date futureDate = calendar.getTime();
		return format.format(futureDate);

	}

	public String getCellValueCSV(String filePath, int rowNum, int colNum)
			throws Exception {

		String cellValue = readAllRowsAndColOfCSV(filePath).get(rowNum)[colNum];
		csvReader.close();
		return cellValue;
	}

	public void user_update_the_SKU_in_bulkUploadFile_from_excelSheet(
			int numOfRecords, String[] SKUsID) {
		if (numOfRecords == SKUsID.length) {
			for (int i = 1; i <= numOfRecords; i++) {
				setCellValue(bulkOrderFilePath,
						getBulkOrdersColumnHeader("SKU#"), i, SKUsID[i - 1]);
				System.out.println("SKU# id : " + SKUsID[i - 1]
						+ " is updated for order : " + (i));
			}
		} else {
			System.out
					.println("No of orders is not same as no of record need to be updated");
		}
	}

	public String[] user_gets_SKUs_from_sheet_as_array(String sheetName,
			String productNum) {
		TestStubReader stubReader = new TestStubReader();
		List<String> prodNames = new ArrayList<String>();
		if (sheetName.contains("/")) {
			String[] sheetNames = sheetName.split("/");
			String[] prodNums = productNum.split("/");
			if (prodNums.length == sheetNames.length) {
				for (int i = 0; i < prodNums.length; i++) {
					String[] headerAndIndex = prodNums[i].split("_");
					String header = headerAndIndex[0];
					String productNumber = headerAndIndex[1];
					prodNames.add(stubReader.setSheetAndGetData(sheetNames[i],
							header, Integer.parseInt(productNumber)));
				}
			}
		} else {
			String[] headerAndIndex = productNum.split("_");
			String header = headerAndIndex[0];
			String productNumber = headerAndIndex[1];
			prodNames.add(stubReader.setSheetAndGetData(sheetName, header,
					Integer.parseInt(productNumber)));
		}
		String[] prodNameAsArray = new String[prodNames.size()];
		prodNameAsArray = prodNames.toArray(prodNameAsArray);
		return prodNameAsArray;

	}

	public String user_get_the_cell_data_from_sheet(String fileName, int row,
			int col) throws Exception {
		return getCellValueCSV(fileName, row, col);
	}

	public void user_update_the_shipType_in_bulkUploadFile(int numOfRecords,
			String shipType) {
		for (int i = 1; i <= numOfRecords; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("Shipping Type"), i, shipType);
			System.out.println("Ship Type : " + shipType
					+ " is updated for order : " + i);
		}
	}

	/*
	 * public void user_create_records_with_updated_LotNUm_ExpirationDate(int
	 * numOfRecords) throws Exception {
	 * 
	 * writer.close(); for (int j = 1; j <= numOfRecords; j+2) {
	 * setCellValue(bulkUploadPackageFilePath,
	 * getBulkOrdersColumnHeader("Lot number"), j,
	 * user_generate_random_external_order_id());
	 * 
	 * // generate current order date setCellValue(bulkUploadPackageFilePath,
	 * getBulkOrdersColumnHeader("Expiration date"), j,
	 * user_generate_current_order_date());
	 * 
	 * // generate estimated delivery date
	 * setCellValue(bulkUploadPackageFilePath,
	 * getBulkOrdersColumnHeader("Estimated delivery date"), j,
	 * user_generate_estimated_delivery_date()); } }
	 */

	// Akash
	public void user_copied_allData_from_bulkUploadPackageMaster_to_bulkUploadWorking(
			int numOfRecords) throws IOException {
		int readLine = 0;
		csvReader = new CSVReader(new FileReader(
				masterBulkUploadPackageFilePath), SEPARATOR);
		List<String[]> reader_bulkUploadSheet = csvReader.readAll();
		CSVWriter writer = new CSVWriter(new FileWriter(
				bulkUploadPackageFilePath, false), SEPARATOR,
				CSVWriter.NO_QUOTE_CHARACTER);

		writer.writeNext(reader_bulkUploadSheet.get(readLine));
		readLine++;
		writer.writeNext(reader_bulkUploadSheet.get(readLine));
		readLine++;
		int line = readLine + 1;
		for (int i = 1; i <= numOfRecords; i++) {
			writer.writeNext(reader_bulkUploadSheet.get(readLine));
			writer.writeNext(reader_bulkUploadSheet.get(line));
			writer.flush();
			// readLine++;

		}
		// writer.flush();
		writer.close();

	}

	public String user_generate_random_Lot_Num() {
		String LotNum = null;
		String firstString = "L";
		LotNum = firstString + "_" + System.nanoTime();
		// System.out.println("Lot Num :" +LotNum);
		return LotNum;
	}

	public void user_update_the_LotNum_and_ExpirationDatein_bulkUploadFile(
			String containerType, String SheetName, String rowNameforSKU,
			int numOfRecords) {

		String Date = user_generate_estimated_delivery_date();
		System.out.println("Date :" + Date);
		System.out.println("numOfRecords " + numOfRecords);

		// String[] sku=skuName.split("/");
		int rowNum = 1;
		int rowNumOne = 0;
		for (int i = 1; i <= numOfRecords; i++) {

			// String a =sku[i-(i-1)];
			// System.out.println("a value is " + a);
			String Lotnum = user_generate_random_Lot_Num();
			System.out.println("Lotnum :" + Lotnum);
			rowNum = rowNum + 2;
			rowNumOne = rowNumOne + 2;
			System.out.println("rowNumOne value is " + rowNumOne);
			setCellValue(bulkUploadPackageFilePath,
					getBulkOrdersPackageColumnHeader("Lot number"), rowNum,
					Lotnum);
			System.out.println("LotNumber : " + Lotnum
					+ " is updated for order : " + i);
			setCellValue(bulkUploadPackageFilePath,
					getBulkOrdersPackageColumnHeader("Expiration date"),
					rowNum, Date);
			System.out.println("Expiration date : " + Date
					+ " is updated for order : " + i);
			setCellValue(bulkUploadPackageFilePath,
					getBulkOrdersPackageColumnHeader("Container type"),
					rowNumOne, containerType);
			System.out.println("Container is  : " + containerType);

			TestStubReader stubReader = new TestStubReader();
			stubReader.setReadingSheet(SheetName);
			String InboundPageLot = stubReader.getData(rowNameforSKU, i);
			System.out.println("InboundPageLot...." + InboundPageLot);
			setCellValue(bulkUploadPackageFilePath,
					getBulkOrdersPackageColumnHeader("Item SKU"), rowNum,
					InboundPageLot);
			System.out.println("Item SKU : " + InboundPageLot
					+ " is updated for order : " + rowNum);

			// Product.setProductAvailableQtyInShipmentMap(InboundPageLot,
			// "50");

		}

	}

	public void user_update_the_same_SKU_to_all_orders_in_bulkUploadFile_from_excelSheet(
			int numOfRecords, String sheetName) {
		TestStubReader stubReader = new TestStubReader();
		for (int i = 1; i <= numOfRecords; i++) {

			String SKU = stubReader.setSheetAndGetData(sheetName,
					"Product Name", 1);
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("SKU#"),
					i, SKU);
			System.out.println("SKU# id : " + SKU + " is updated for order : "
					+ i);
		}

	}

	public String[] user_gets_SKUsDesc_from_sheet_as_array(String sheetName,
			String productNum) {
		TestStubReader stubReader = new TestStubReader();
		List<String> prodDesc = new ArrayList<String>();
		if (sheetName.contains("/")) {
			String[] sheetNames = sheetName.split("/");
			String[] prodNums = productNum.split("/");
			if (prodNums.length == sheetNames.length) {
				for (int i = 0; i < prodNums.length; i++) {
					String[] headerAndIndex = prodNums[i].split("_");
					String productNumber = headerAndIndex[1];
					prodDesc.add(stubReader.setSheetAndGetData(sheetNames[i],
							"Product Desc", Integer.parseInt(productNumber)));
				}
			}
		} else {
			String[] headerAndIndex = productNum.split("_");
			String productNumber = headerAndIndex[1];
			prodDesc.add(stubReader.setSheetAndGetData(sheetName,
					"Product Desc", Integer.parseInt(productNumber)));
		}
		String[] prodDescAsArray = new String[prodDesc.size()];
		prodDescAsArray = prodDesc.toArray(prodDescAsArray);
		return prodDescAsArray;

	}

	/**
	 * public static void main(String[] args){ CSVReadAndWrite cReadAndWrite =
	 * new CSVReadAndWrite(); String[] SKU =
	 * cReadAndWrite.user_gets_SKUs_from_sheet_as_array
	 * ("Avaliable HFY&FCA FebTest/ProductWhichIsnotAvalOnBothWare",
	 * "Product Name_2/Product Name_1"); String[] SKUDesc =
	 * cReadAndWrite.user_gets_SKUsDesc_from_sheet_as_array
	 * ("Avaliable HFY&FCA FebTest/ProductWhichIsnotAvalOnBothWare",
	 * "Product Name_2/Product Name_1"); for (int i = 0; i < SKU.length ; i++){
	 * System.out.println(SKU[i]); System.out.println(SKUDesc[i]); } }
	 */

	public List<String> getHeaderValues(String filePath) throws Exception {

		List<String> headers = new LinkedList<String>();
		List<String[]> cellValue = readAllRowsAndColOfCSV(filePath);
		String[] columns = cellValue.get(0);
		for (int i = 0; i < columns.length; ++i)
			headers.add(columns[i]);
		csvReader.close();
		return headers;
	}

/*	
	 * Author: Koti 
	 * this method to update External line id random generation
	 
	public void user_update_the_externallineId_in_bulkUploadFile(
			int numOfRecords) {
		 
		for (int i = 1; i <= numOfRecords; i++) {
			extlineId = user_generate_random_external_line_id();
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Line Id"), i, extlineId);
			System.out.println("External Line ID : " + extlineId
					+ " is updated for order : " + i);
		}
	}

	
	 * Author: Koti 
	 * this method to update External order number random generation
	 
	public void user_update_the_externalordernumber_in_bulkUploadFile(
			int numOfRecords) {
		
		for (int i = 1; i <= numOfRecords; i++) {
			extordernum = user_generate_random_external_order_number();
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Line Id"), i,
					extordernum);
			System.out.println("External Order num : " + extordernum
					+ " is updated for order : " + i);
		}
	}*/
	/*
	 * Author: Koti 
	 * this method to update External order number
	 */
	public void user_update_the_externallineid_in_bulkUploadFile(int numOfRecords,
			String extlineid) {
		for (int i = 1; i <= numOfRecords; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Line Id"), i, extlineid);
			System.out.println("External order number : " + extlineid
					+ " is updated for order : " + i);
		}
	}
	
	/*
	 * Author: Koti 
	 * this method to update External order number
	 */
	public void user_update_the_externalordernumber_in_bulkUploadFile(int numOfRecords,
			String extordernum) {
		for (int i = 1; i <= numOfRecords; i++) {
			setCellValue(bulkOrderFilePath,
					getBulkOrdersColumnHeader("External Order Number"), i, extordernum);
			System.out.println("External order number : " + extordernum
					+ " is updated for order : " + i);
		}
	}
	
	/*
	 * Author: Archana 
	 * this method to update Address Line 1
	 */
	public void user_update_the_addressLine1_in_bulkUploadFile(int numOfRecords, String addressLine1) {
		for (int i = 1; i <= numOfRecords; i++) {
			setCellValue(bulkOrderFilePath, getBulkOrdersColumnHeader("Address 1"), i, addressLine1);
			System.out.println("External Order ID : " + addressLine1 + " is updated for order : " + i);
		}
	}
	
}
