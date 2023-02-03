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
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;

/**
 * This class is used for Create and Update EDI files. It contains methods for handling EDI files in X12 format.
 * @author ffd-sys-team
 *
 */
public class CreateAndUpdateEDIFiles {
	
	WebDriver driver = Steps.seleniumDriver;
	public String dirPath = System.getProperty("user.dir");
	public static String strDate11;
	public static String strDate5;
	public static String strDate12;
	public static String strDate6;
	//public static String asnNumber;
	//public static String doNumber;
	public String SingleLineLotItemIBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/856/"+"APC"+"-LotItem-WIP.x12";
	public String SingleLineNormalItemIBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/856/"+"APC"+"-NormalItem-WIP.x12";
	public String SingleLineSerialItemIBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/856/"+"APC"+"-SerialItem-WIP.x12";

	public String MultiLineLotItemIBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/856/"+"APC"+"-LotItem-Multiline-WIP.x12";
	public String MultiLineNormalItemIBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/856/"+"APC"+"-NormalItem-Multiline-WIP.x12";
	public String MultiLineSerialItemIBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/856/"+"APC"+"-SerialItem-Multiline-WIP.x12";

	public String SingleLineLotItemOBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/850/"+"APC"+"-LotItem-SingleLine.x12";
	public String SingleLineNormalItemOBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/850/"+"APC"+"-NormalItem-SingleLine.x12";
	public String SingleLineSerialItemOBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/850/"+"APC"+"-SerialItem-SingleLine.x12";
	
	//public String APCMultilineLineInboundFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/850/"+"APC"+"-LotItem-Multiline-WIP.x12";
	public String MultiLineLotItemOBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/850/"+"APC"+"-LotItem-Multiline-WIP.x12";
	public String MultiLineNormalItemOBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/850/"+"APC"+"-NormalItem-Multiline.x12";
	public String MultiLineSerialItemOBFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/850/"+"APC"+"-SerialItem-Multiline-WIP.x12";

	public String APCEDIInboundFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/856/"+"APC"+"-856_InputFile.x12";
	public String APCEDIOutboundFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/850/"+"APC"+"-850_InputFile.x12";

	public void user_create_EDI_file(String fileType) throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		if (fileType.contains("PO")) {
			if (fileType.equals("APC SingleLine PO - LotItems")) {
				Steps.logger.info("Contents Copy from : " + SingleLineLotItemIBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				user_copy_edi_file_content_from_source_to_target(SingleLineLotItemIBFilePath, APCEDIInboundFilePath);
			} else if (fileType.equals("APC SingleLine PO - NormalItems")) {
				Steps.logger.info("Contents Copy from : " + SingleLineNormalItemIBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				user_copy_edi_file_content_from_source_to_target(SingleLineNormalItemIBFilePath, APCEDIInboundFilePath);
			}else if (fileType.equals("APC SingleLine PO - SerailItems")) {
				Steps.logger.info("Contents Copy from : " + SingleLineSerialItemIBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				user_copy_edi_file_content_from_source_to_target(SingleLineSerialItemIBFilePath, APCEDIInboundFilePath);
			}else if (fileType.equals("APC MultiLine PO - LotItems")) {
				Steps.logger.info("Contents Copy from : " + MultiLineLotItemIBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				user_copy_edi_file_content_from_source_to_target(MultiLineLotItemIBFilePath,APCEDIInboundFilePath);
			}else if (fileType.equals("APC MultiLine PO - NormalItems")) {
				Steps.logger.info("Contents Copy from : " + MultiLineNormalItemIBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				user_copy_edi_file_content_from_source_to_target(MultiLineNormalItemIBFilePath, APCEDIInboundFilePath);
			}else if (fileType.equals("APC MultiLine PO - SerialItems")) {
				Steps.logger.info("Contents Copy from : " + MultiLineSerialItemIBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				user_copy_edi_file_content_from_source_to_target(MultiLineSerialItemIBFilePath, APCEDIInboundFilePath);
			}
		} else if (fileType.contains("DO")) {
//			if (fileType.equals("APC SingleLine DO - LotItems")) {
//				Steps.logger.info("Contents Copy from : " + APCOBSingleLineFilePath);
//				Steps.logger.info("Contents Copy to : " + APCEDIOutboundFilePath);
//				user_copy_edi_file_content_from_source_to_target(APCOBSingleLineFilePath, APCEDIOutboundFilePath);
//			}
			if (fileType.equals("APC SingleLine DO - LotItems")) {
				Steps.logger.info("Contents Copy from : " + SingleLineLotItemOBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIOutboundFilePath);
				user_copy_edi_file_content_from_source_to_target(SingleLineLotItemOBFilePath, APCEDIOutboundFilePath);
			} else if (fileType.equals("APC SingleLine DO - NormalItems")) {
				Steps.logger.info("Contents Copy from : " + SingleLineNormalItemOBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIOutboundFilePath);
				user_copy_edi_file_content_from_source_to_target(SingleLineNormalItemOBFilePath, APCEDIOutboundFilePath);
			} else if (fileType.equals("APC SingleLine DO - SerailItems")) {
				Steps.logger.info("Contents Copy from : " + SingleLineSerialItemOBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIOutboundFilePath);
				user_copy_edi_file_content_from_source_to_target(SingleLineSerialItemOBFilePath, APCEDIOutboundFilePath);
			}else if (fileType.equals("APC MultiLine DO - LotItems")) {
				Steps.logger.info("Contents Copy from : " + MultiLineLotItemIBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				user_copy_edi_file_content_from_source_to_target(MultiLineLotItemIBFilePath,APCEDIInboundFilePath);
			}else if (fileType.equals("APC MultiLine DO - NormalItems")) {
				Steps.logger.info("Contents Copy from : " + MultiLineNormalItemOBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIOutboundFilePath);
				user_copy_edi_file_content_from_source_to_target(MultiLineNormalItemOBFilePath, APCEDIOutboundFilePath);
			}else if (fileType.equals("APC MultiLine DO - SerialItems")) {
				Steps.logger.info("Contents Copy from : " + MultiLineSerialItemIBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				user_copy_edi_file_content_from_source_to_target(MultiLineSerialItemIBFilePath, APCEDIInboundFilePath);
			}
		}
//		else if(fileType.equals("Single Line DO")){
//			user_copy_content_from_source_to_target(SingleLineOutboundFilePath, inputEDIOutboundFilePath);
//		}else if(fileType.equals("Multi Line DO")){
//			user_copy_content_from_source_to_target(MultiLineOutboundFilePath, inputEDIOutboundFilePath);
//		}
	}
	
	public void user_update_EDI_file(String fileType)
			throws FileNotFoundException, XPathExpressionException, IOException, SAXException,
			ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		Date date = new Date();
		String PODONumber = "";

		SimpleDateFormat formatter5 = new SimpleDateFormat("yyMMdd");
		strDate5 = formatter5.format(date);
		Steps.logger.info("Date in yyMMdd format" + strDate5);

		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		strDate6 = sdf.format(date);
		Steps.logger.info("Date in HHmmss format" + strDate6);

		SimpleDateFormat formatter11 = new SimpleDateFormat("ddHHmmsss");
		strDate11 = formatter11.format(date);
		Steps.logger.info("ddHHmmsss" + strDate11);
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		String path = null;
		if (fileType.contains("PO")) {

			path = APCEDIInboundFilePath;

			PODONumber = "APOC000000" + randomNum + "-" + strDate11;
			Items.setPONumber(PODONumber);

			Steps.logger.info("PONumber: " + Items.getPONumber());
			Reporter.addStepLog("PONumber: " + Items.getPONumber());

			String itemName = null;
			String shpQty = null;
			String uom = null;
			
			if (fileType.contains("APC SingleLine PO")) {
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				modifyEDIFile(APCEDIInboundFilePath, "yyMMdd", strDate5);
				modifyEDIFile(APCEDIInboundFilePath, "APOC000000001-ddHHmmsss", PODONumber);
				modifyEDIFile(APCEDIInboundFilePath, "HHmmss", strDate6);
				Steps.logger.info("PO Number is :" + PODONumber);
				String ASNno = PODONumber + "-1";
				Items.setAsnNumber(ASNno);
				Steps.logger.info("ASNNumber: " + Items.getAsnNumber());
				Reporter.addStepLog("ASNNumber: " + Items.getAsnNumber());

				for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					Steps.logger.info("Steps.ItemDataMap Size" + Steps.ItemDataMap.size());
					itemName = Steps.ItemDataMap.get(i).get("Item");

					modifyEDIFile(APCEDIInboundFilePath, "XXXItemId", itemName);
					Steps.logger.info("Item : " + itemName + " has been updated successfully");
					Steps.logger.info("Item : " + itemName + " has been updated successfully");

					shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
					modifyEDIFile(APCEDIInboundFilePath, "XXXItemQty", shpQty);
					Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");
					Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");

					uom = Steps.ItemDataMap.get(i).get("UOM");
					modifyEDIFile(APCEDIInboundFilePath, "XXXUOM", uom);
					modifyEDIFile(APCEDIInboundFilePath, "XXXItemUOM", shpQty);
					Steps.logger.info("QtyUOM : " + shpQty + " has been updated successfully");
					Steps.logger.info("QtyUOM : " + shpQty + " has been updated successfully");

					Items.setItemsForReceivingASN(itemName);
					Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shpQty));
					Reporter.addStepLog("Item Id- " + Steps.ItemDataMap.get(i).get("Item") + ", Shipped Qty- "
							+ Steps.ItemDataMap.get(i).get("ShippedQty"));

					Steps.logger.info("Item" + Items.getItemsForReceivingASN(i));
					Steps.logger.info("Qty" + Steps.ItemDataMap.get(i).get("ShippedQty"));
				}

			} else {
				Steps.logger.info("APC Multiline PO");
				Steps.logger.info("Contents Copy from : " + MultiLineLotItemIBFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				modifyEDIFile(APCEDIInboundFilePath, "yyMMdd", strDate5);
				modifyEDIFile(APCEDIInboundFilePath, "APOC000000001-ddHHmmsss", PODONumber);
				modifyEDIFile(APCEDIInboundFilePath, "HHmmss", strDate6);
				Steps.logger.info("PO Number is :" + PODONumber);
				String ASNno = PODONumber + "-1";
				Items.setAsnNumber(ASNno);
				Steps.logger.info("ASNNumber: " + Items.getAsnNumber());
				Reporter.addStepLog("ASNNumber: " + Items.getAsnNumber());

				for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					Steps.logger.info("Steps.ItemDataMap Size" + Steps.ItemDataMap.size());
					itemName = Steps.ItemDataMap.get(i).get("Item");

					modifyEDIFile(APCEDIInboundFilePath, "XXXItemId" + i, itemName);
					Steps.logger.info("Item : " + itemName + " has been updated successfully");
					Steps.logger.info("Item : " + itemName + " has been updated successfully");

					shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
					modifyEDIFile(APCEDIInboundFilePath, "XXXItemQty" + i, shpQty);
					Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");
					Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");

					uom = Steps.ItemDataMap.get(i).get("UOM");
					modifyEDIFile(APCEDIInboundFilePath, "XXXUOM" + i, uom);
					modifyEDIFile(APCEDIInboundFilePath, "XXXItemUOM" + i, shpQty);
					Steps.logger.info("QtyUOM : " + shpQty + " has been updated successfully");
					Steps.logger.info("QtyUOM : " + shpQty + " has been updated successfully");

					Items.setItemsForReceivingASN(itemName);
					Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shpQty));
					Reporter.addStepLog("Item Id- " + Steps.ItemDataMap.get(i).get("Item") + ", Shipped Qty- "
							+ Steps.ItemDataMap.get(i).get("ShippedQty"));

					Steps.logger.info("Item" + Items.getItemsForReceivingASN(i));
					Steps.logger.info("Qty" + Steps.ItemDataMap.get(i).get("ShippedQty"));
				}
			}

		} else if (fileType.contains("DO")) {
			
			path = APCEDIOutboundFilePath;
			
			SimpleDateFormat formatter12 = new SimpleDateFormat("HHmmsss");
			strDate12 = formatter12.format(date);
			PODONumber = "APC" + strDate12;
			Items.setDONumber(PODONumber);
			Steps.logger.info("DO Number: " + PODONumber);
			Reporter.addStepLog("DO Number: " + PODONumber);
			String itemName = null;
			String shpQty = null;
			String uom = null;
			String TrnsprtSvcLvl = null;
			String TrnsprtSCAC = null;
			

			if (fileType.contains("APC SingleLine DO")) {
				//Steps.logger.info("Contents Copy from : " + APCOBSingleLineFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIOutboundFilePath);
				modifyEDIFile(APCEDIOutboundFilePath, "yyMMdd", strDate5);
				modifyEDIFile(APCEDIOutboundFilePath, "APCHHmmsss", PODONumber);
				modifyEDIFile(APCEDIOutboundFilePath, "HHmmss", strDate6);
				Steps.logger.info("Do Number is" + PODONumber);
				Reporter.addStepLog("Do Number is" + PODONumber);
				
				for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					Steps.logger.info("Steps.ItemDataMap Size" + Steps.ItemDataMap.size());
					itemName = Steps.ItemDataMap.get(i).get("Item");

					modifyEDIFile(APCEDIOutboundFilePath, "XXXItemId", itemName);
					Steps.logger.info("Item : " + itemName + " has been updated successfully");
					Steps.logger.info("Item : " + itemName + " has been updated successfully");

					shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
					modifyEDIFile(APCEDIOutboundFilePath, "XXXItemQty", shpQty);
					Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");
					Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");

					uom = Steps.ItemDataMap.get(i).get("UOM");
					modifyEDIFile(APCEDIOutboundFilePath, "XXXUOM", uom);
					//modifyEDIFile(APCEDIOutboundFilePath, "XXXItemUOM" + i, shpQty);
					Steps.logger.info("QtyUOM : " + shpQty + " has been updated successfully");
					Steps.logger.info("QtyUOM : " + shpQty + " has been updated successfully");

					if (itemName.contains("-")) {
						itemName = itemName.replace("-", "");
						modifyEDIFile(APCEDIOutboundFilePath, "XXXProxyItemId", itemName);
					} else {
						modifyEDIFile(APCEDIOutboundFilePath, "XXXProxyItemId", itemName);
					}
					
					TrnsprtSvcLvl = Steps.scenarioData.get("TrnsprtSvcLvl");
					modifyEDIFile(APCEDIOutboundFilePath, "XXXTransServLevel", TrnsprtSvcLvl);
					System.out.println("TrnsprtSvcLvl : " + TrnsprtSvcLvl + " has been updated successfully");
					Steps.logger.info("TrnsprtSvcLvl : " + TrnsprtSvcLvl + " has been updated successfully");
					
					TrnsprtSCAC = Steps.scenarioData.get("TrnsprtSCAC");
					modifyEDIFile(APCEDIOutboundFilePath, "XXXTransCarrier", TrnsprtSCAC);
					System.out.println("TrnsprtSCAC : " + TrnsprtSCAC + " has been updated successfully");
					Steps.logger.info("TrnsprtSCAC : " + TrnsprtSCAC + " has been updated successfully");
					
					Items.setItemsForReceivingASN(itemName);
					Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shpQty));
					Reporter.addStepLog("Item Id- " + Steps.ItemDataMap.get(i).get("Item") + ", Shipped Qty- "
							+ Steps.ItemDataMap.get(i).get("ShippedQty"));

					Steps.logger.info("Item" + Items.getItemsForReceivingASN(i));
					Steps.logger.info("Qty" + Steps.ItemDataMap.get(i).get("ShippedQty"));
				}

			}else if (fileType.contains("APC MultiLine DO")) {
				//Steps.logger.info("Contents Copy from : " + APCOBSingleLineFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIOutboundFilePath);
				modifyEDIFile(APCEDIOutboundFilePath, "yyMMdd", strDate5);
				modifyEDIFile(APCEDIOutboundFilePath, "APCHHmmsss", PODONumber);
				modifyEDIFile(APCEDIOutboundFilePath, "HHmmss", strDate6);
				Steps.logger.info("Do Number is" + PODONumber);
				Reporter.addStepLog("Do Number is" + PODONumber);
				
				for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					Steps.logger.info("Steps.ItemDataMap Size" + Steps.ItemDataMap.size());
					itemName = Steps.ItemDataMap.get(i).get("Item");

					modifyEDIFile(APCEDIOutboundFilePath, "XXXItemId"+i, itemName);
					Steps.logger.info("Item : " + itemName + " has been updated successfully");

					shpQty = Steps.ItemDataMap.get(i).get("ShippedQty");
					modifyEDIFile(APCEDIOutboundFilePath, "XXXItemQty"+i, shpQty);
					Steps.logger.info("Shipped Qty : " + shpQty + " has been updated successfully");

					uom = Steps.ItemDataMap.get(i).get("UOM");
					modifyEDIFile(APCEDIOutboundFilePath, "XXXUOM"+i, uom);
					//modifyEDIFile(APCEDIOutboundFilePath, "XXXItemUOM" + i, shpQty);
					Steps.logger.info("QtyUOM : " + shpQty + " has been updated successfully");

					if (itemName.contains("-")) {
						itemName = itemName.replace("-", "");
						modifyEDIFile(APCEDIOutboundFilePath, "XXXProxyItemId"+i, itemName);
					} else {
						modifyEDIFile(APCEDIOutboundFilePath, "XXXProxyItemId"+i, itemName);
					}
					
					TrnsprtSvcLvl = Steps.scenarioData.get("TrnsprtSvcLvl");
					modifyEDIFile(APCEDIOutboundFilePath, "XXXTransServLevel", TrnsprtSvcLvl);
					System.out.println("TrnsprtSvcLvl : " + TrnsprtSvcLvl + " has been updated successfully");
					Steps.logger.info("TrnsprtSvcLvl : " + TrnsprtSvcLvl + " has been updated successfully");
					
					TrnsprtSCAC = Steps.scenarioData.get("TrnsprtSCAC");
					modifyEDIFile(APCEDIOutboundFilePath, "XXXTransCarrier", TrnsprtSCAC);
					System.out.println("TrnsprtSCAC : " + TrnsprtSCAC + " has been updated successfully");
					Steps.logger.info("TrnsprtSCAC : " + TrnsprtSCAC + " has been updated successfully");
					
					Items.setItemsForReceivingASN(itemName);
					Items.setItemWithShippedASNQty(itemName, Integer.parseInt(shpQty));
					Reporter.addStepLog("Item Id- " + Steps.ItemDataMap.get(i).get("Item") + ", Shipped Qty- "
							+ Steps.ItemDataMap.get(i).get("ShippedQty"));

					Steps.logger.info("Item" + Items.getItemsForReceivingASN(i));
					Steps.logger.info("Qty" + Steps.ItemDataMap.get(i).get("ShippedQty"));
				} 
				
		}
		}

	}

	//Copy files from one folder to another folder
	public static void user_copy_edi_file_content_from_source_to_target(String sourceFile, String targetFile)
			throws IOException {
		@SuppressWarnings("resource")
		FileChannel src = new FileInputStream(sourceFile).getChannel();
		@SuppressWarnings("resource")
		FileChannel dest = new FileOutputStream(targetFile).getChannel();

		// Try block to check for exceptions
		try {

			// Transferring files in one go from source to destination using transferFrom() method
			dest.transferFrom(src, 0, src.size());
			// we can also use transferTo
			// src.transferTo(0,src.size(),dest);
		}

		// finally keyword is good practice to save space in
		// memory by closing files, connections, streams
		finally {

			// Closing the channels this makes the space free
			// Closing the source channel
			src.close();

			// Closing the destination channel
			dest.close();
		}

	}
	
	//Code to update the EDI file content
	public static void updateEDIFile(String filePath, String oldString, String newString) {
	    File fileToBeModified = new File(filePath);
	    StringBuilder oldContent = new StringBuilder();
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified))) {
	        String line = reader.readLine();
	        while (line != null) {
	            oldContent.append(line).append(System.lineSeparator());
	            line = reader.readLine();
	        }
	        String content = oldContent.toString();
	        String newContent = content.replaceAll(oldString, newString);
	        try (FileWriter writer = new FileWriter(fileToBeModified)) {
	            writer.write(newContent);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	//Code to Modify the EDI file content such as Item Name and Quantity
		public static void modifyEDIFile(String filePath, String oldString, String newString) {
		    File fileToBeModified = new File(filePath);
		    StringBuilder oldContent = new StringBuilder();
		    try (BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified))) {
		        String line = reader.readLine();
		        while (line != null) {
		            oldContent.append(line).append(System.lineSeparator());
		            line = reader.readLine();
		        }
		        String content = oldContent.toString();
		        String newContent = content.replaceAll(oldString, newString);
		       // newContent = newContent.replaceAll("XXXItemQty", "1");
		       // newContent = newContent.replaceAll("XXXItemId", "03P76-25");
		        
		        try (FileWriter writer = new FileWriter(fileToBeModified)) {
		            writer.write(newContent);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}



	

}
