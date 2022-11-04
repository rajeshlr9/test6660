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
	//public static String asnNumber;
	//public static String doNumber;

	
	public String APCSingleLineInboundFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/856/"+"APC"+"01-856.x12";
	public String APCIBMultiLineSerializedFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/856/"+"APC"+"08-856.x12";
	public String APCOBSingleLineFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/850/"+"APC"+"01-850.x12";

	public String APCEDIInboundFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/856/"+"APC"+"-856_InputFile.x12";
	public String APCEDIOutboundFilePath = dirPath + "/src/test/resources/testdata/"+"APC" + "/850/"+"APC"+"-850_InputFile.x12";

	public void user_create_EDI_file(String fileType) throws FileNotFoundException, XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		if(fileType.equals("APC Single Line PO")){
			Steps.logger.info("Contents Copy from : "+APCSingleLineInboundFilePath);
			Steps.logger.info("Contents Copy to : "+APCEDIInboundFilePath);
			user_copy_edi_file_content_from_source_to_target(APCSingleLineInboundFilePath, APCEDIInboundFilePath);
		}else if(fileType.equals("APC Multiline Serialized PO")){
			user_copy_edi_file_content_from_source_to_target(APCIBMultiLineSerializedFilePath, APCEDIInboundFilePath);
		}else if(fileType.equals("APC Single Line DO")){
			user_copy_edi_file_content_from_source_to_target(APCOBSingleLineFilePath, APCEDIOutboundFilePath);
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
		System.out.println("Date in yyMMdd format" + strDate5);

		SimpleDateFormat formatter11 = new SimpleDateFormat("ddHHmmsss");
		strDate11 = formatter11.format(date);
		System.out.println("ddHHmmsss" + strDate11);
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		
		if (fileType.contains("PO")) {
			PODONumber = "APOC000000" + randomNum + "-" + strDate11;
			Items.setPONumber(PODONumber);

			Steps.logger.info("PONumber: " + Items.getPONumber());
			Reporter.addStepLog("PONumber: " + Items.getPONumber());

			if (fileType.equals("APC Single Line PO")) {
				Steps.logger.info("Contents Copy from : " + APCSingleLineInboundFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				updateEDIFile(APCEDIInboundFilePath, "yyMMdd", strDate5);
				updateEDIFile(APCEDIInboundFilePath, "APOC000000001-ddHHmmsss", PODONumber);
				Steps.logger.info("PO Number is :" + PODONumber);
				String ASNno = PODONumber + "-1";
				Items.setAsnNumber(ASNno);
				Steps.logger.info("ASNNumber: " + Items.getAsnNumber());
				Reporter.addStepLog("ASNNumber: " + Items.getAsnNumber());

			} else if (fileType.equals("APC Multiline Serialized PO")) {
				System.out.println("APC Multiline Serialized PO");
				Steps.logger.info("Contents Copy from : " + APCIBMultiLineSerializedFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIInboundFilePath);
				updateEDIFile(APCEDIInboundFilePath, "yyMMdd", strDate5);
				updateEDIFile(APCEDIInboundFilePath, "APOC000000008-ddHHmmsss", PODONumber);
				Steps.logger.info("PO Number is :" + PODONumber);
				String ASNno = PODONumber + "-1";
				Items.setAsnNumber(ASNno);
				Steps.logger.info("ASNNumber: " + Items.getAsnNumber());
				Reporter.addStepLog("ASNNumber: " + Items.getAsnNumber());

			}
		}else if (fileType.contains("DO")) {
			SimpleDateFormat formatter12 = new SimpleDateFormat("HHmmsss");
			strDate12 = formatter12.format(date);
			PODONumber = "APC" + strDate12;
			Items.setDONumber(PODONumber);
			Steps.logger.info("DO Number: "+PODONumber);
			Reporter.addStepLog("DO Number: "+PODONumber);
			
			if (fileType.equals("APC Single Line DO")) {
				Steps.logger.info("Contents Copy from : " + APCOBSingleLineFilePath);
				Steps.logger.info("Contents Copy to : " + APCEDIOutboundFilePath);
				updateEDIFile(APCEDIOutboundFilePath, "yyMMdd", strDate5);
				updateEDIFile(APCEDIOutboundFilePath, "APCHHmmsss", PODONumber);
				Steps.logger.info("Do Number is" + PODONumber);
				System.out.println("Test");
			}
		}
		
		
//		else if(fileType.equals("Multi Line PO")){
//			user_copy_content_from_source_to_target(MultiLineInboundFilePath, inputEDIInboundFilePath);
//		}else if(fileType.equals("Single Line DO")){
//			user_copy_content_from_source_to_target(SingleLineOutboundFilePath, inputEDIOutboundFilePath);
//		}else if(fileType.equals("Multi Line DO")){
//			user_copy_content_from_source_to_target(MultiLineOutboundFilePath, inputEDIOutboundFilePath);
//		}
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


	

}
