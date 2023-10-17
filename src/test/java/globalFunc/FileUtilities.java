package globalFunc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import StepDefinition.Steps;
import entity.Items;
import pages.ManhattanLoginPage;
import utils.Config;

public class FileUtilities {

    private List <String> fileList;
  //  private static final String OUTPUT_ZIP_FILE = "C:\\Jenkins\\workspace\\CIL\\ManhattanWMS-3535876\\ManhattanPOC\\Manh-Test-Specific-Functionalities-ScrumTeam\\resources\\WordDoc_"+Config.getProperty("Build_Number")+".zip";
//    private static final String SOURCE_FOLDER = "C:\\Jenkins\\workspace\\CIL\\ManhattanWMS-3535876\\ManhattanPOC\\Manh-Test-Specific-Functionalities-ScrumTeam\\resources\\WordScreenshots"; // SourceFolder path

    private static final String OUTPUT_ZIP_FILE = "resources\\WordDoc_"+Config.getProperty("Build_Number")+".zip";
    private static final String SOURCE_FOLDER = "resources\\WordScreenshots"; // SourceFolder path
    
    public FileUtilities() {
    	fileList = new ArrayList < String > ();
    }

    public static void zipFile() {
    	FileUtilities appZip = new FileUtilities();
        appZip.generateFileList(new File(SOURCE_FOLDER));
        appZip.zipIt(OUTPUT_ZIP_FILE);
    }

    public void zipIt(String zipFile) {
        byte[] buffer = new byte[1024];
        String source = new File(SOURCE_FOLDER).getName();
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(fos);

            System.out.println("Output to Zip : " + zipFile);
            FileInputStream in = null;

            for (String file: this.fileList) {
                System.out.println("File Added : " + file);
                ZipEntry ze = new ZipEntry(source + File.separator + file);
                zos.putNextEntry(ze);
                try {
                    in = new FileInputStream(SOURCE_FOLDER + File.separator + file);
                    int len;
                    while ((len = in .read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                } finally {
                    in.close();
                }
            }

            zos.closeEntry();
            System.out.println("Folder successfully compressed");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                zos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void generateFileList(File node) {
        // add file only
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename: subNote) {
                generateFileList(new File(node, filename));
            }
        }
    }

    private String generateZipEntry(String file) {
        return file.substring(SOURCE_FOLDER.length() + 1, file.length());
    }
    
    public static void copyReportFiles() {
    	 String sourceFolder = System.getProperty("user.dir")+ "\\resources\\Reports\\";
    	 String targetFolder = "C:\\ReportFiles\\MailableReports";
    	 File source= new File(sourceFolder);
    	 File target= new File(targetFolder);
    	 try {
			FileUtils.copyDirectory(source, target);
			Steps.logger.info("Report files copied successfully to other folder");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public static void copyScreenshotFiles() {
		String sourceFolder = System.getProperty("user.dir") + "\\resources\\Screenshots\\";
		String targetFolder = "C:\\ReportFiles\\Screenshots";
		File source = new File(sourceFolder);
		File target = new File(targetFolder);
		try {
			FileUtils.copyDirectory(source, target);
			Steps.logger.info("Screenshots copied successfully to other folder");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
 
	public static void verifyOrderNumIn861File(String fileName) throws Exception{
		try {
			String account = ManhattanLoginPage.account;
			if (account.equalsIgnoreCase("APC")) {
				String zipFilePath = "C:\\Users\\ffd-sys-team\\Downloads\\" + fileName + ".zip";
				String destDirectory = "C:\\Users\\ffd-sys-team\\Downloads\\TestExtract";
				UnZipUtility unZipClass = new UnZipUtility();
				Thread.sleep(10000);

				unZipClass.unzip(zipFilePath, destDirectory);
				Thread.sleep(10000);
				List<String> stringfile = unZipClass
						.readFile("C:\\Users\\ffd-sys-team\\Downloads\\TestExtract\\" + fileName + ".fnf");
				System.out.println("XML File Contents" + stringfile);
				String orderNum =  Items.getAsnNumber();
				//String orderNum =  "APOC000000694-211149022-1";
				String finalOrderNum = orderNum.substring(0, orderNum.length()-2);
				System.out.println("ASN number ="+finalOrderNum);
				//WIP--For Adding Validation for Item ID and QTY
				for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					System.out.println("Steps.ItemDataMap Size" + Steps.ItemDataMap.size());
					Steps.logger.info("Steps.ItemDataMap Size" + Steps.ItemDataMap.size());
					String itemName = Steps.ItemDataMap.get(i).get("Item");
					String itemQTY = Steps.ItemDataMap.get(i).get("ShippedQty");
					String itemUOM = Steps.ItemDataMap.get(i).get("UOM");
					System.out.println("ItemName"+itemName);
					System.out.println("ItemName"+itemQTY);
					System.out.println("ItemName"+itemUOM);
					System.out.println(stringfile.size());
					System.out.println(stringfile.toString().contains(itemName));
					System.out.println(stringfile.toString().contains(itemQTY));
					System.out.println(stringfile.toString().contains(itemUOM));
					System.out.println("------validated------");
				}
				
				
				//----WIP-----
				System.out.println(stringfile.size());
				System.out.println(stringfile.toString().contains(finalOrderNum));
				
				Assert.assertTrue(stringfile.toString().contains(finalOrderNum),"Order Number mismatch");
			} else {
				String zipFilePath = "C:\\Users\\ffd-sys-team\\Downloads\\" + fileName + ".zip";
				String destDirectory = "C:\\Users\\ffd-sys-team\\Downloads\\TestExtract";
				UnZipUtility unZipClass = new UnZipUtility();
				unZipClass.unzip(zipFilePath, destDirectory);
				List<String> stringfile = unZipClass
						.readFile("C:\\Users\\ffd-sys-team\\Downloads\\TestExtract\\" + fileName + ".fnf");
				System.out.println("XML File Contents" + stringfile);
				String orderNum = Items.getAsnNumber();
				String finalOrderNum[] = orderNum.split("-");
				System.out.println(stringfile.contains("<OrdNbr>" + finalOrderNum[0] + "</OrdNbr>"));
				System.out.println(stringfile.contains("<ConditionCD>07</ConditionCD>"));
				Assert.assertTrue(stringfile.contains("<OrdNbr>" + finalOrderNum[0] + "</OrdNbr>"),
						"Order Number mismatch");
				Assert.assertTrue(stringfile.contains("<ConditionCD>07</ConditionCD>"), "ConditionCD mismatch");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void verifyOrderNumIn856File(String fileName) throws Exception {
		try {
			String account = ManhattanLoginPage.account;
			if (account.equalsIgnoreCase("APC")) {
				String zipFilePath = "C:\\Users\\ffd-sys-team\\Downloads\\" + fileName + ".zip";
				String destDirectory = "C:\\Users\\ffd-sys-team\\Downloads\\TestExtract";
				UnZipUtility unZipClass = new UnZipUtility();
				unZipClass.unzip(zipFilePath, destDirectory);
				List<String> stringfile = unZipClass
						.readFile("C:\\Users\\ffd-sys-team\\Downloads\\TestExtract\\" + fileName + ".fnf");
				System.out.println(stringfile);
				String orderNum = Items.getDONumber();
				//String orderNum="APAPC0625419";
//				String finalOrderNum = orderNum.substring(0, orderNum.length()-2);
//				System.out.println("DO number ="+finalOrderNum);
				
				for (int i = 0; i < Steps.ItemDataMap.size(); i++) {
					System.out.println("Steps.ItemDataMap Size" + Steps.ItemDataMap.size());
					Steps.logger.info("Steps.ItemDataMap Size" + Steps.ItemDataMap.size());
					String itemName = Steps.ItemDataMap.get(i).get("Item");
					String itemQTY = Steps.ItemDataMap.get(i).get("ShippedQty");
					String itemUOM = Steps.ItemDataMap.get(i).get("UOM");
					System.out.println("ItemName"+itemName);
					System.out.println("ItemName"+itemQTY);
					System.out.println("ItemName"+itemUOM);
					System.out.println(stringfile.size());
					System.out.println(stringfile.toString().contains(itemName));
					System.out.println(stringfile.toString().contains(itemQTY));
					System.out.println(stringfile.toString().contains(itemUOM));
					System.out.println("------validated------");
				}

				//System.out.println("orderNumber:" + orderNum);
				System.out.println(stringfile.toString().contains(orderNum));
				Assert.assertTrue(stringfile.toString().contains(orderNum), "OrderNum or ShipID mismatch");
			} else {
				String zipFilePath = "C:\\Users\\ffd-sys-team\\Downloads\\" + fileName + ".zip";
				String destDirectory = "C:\\Users\\ffd-sys-team\\Downloads\\TestExtract";
				UnZipUtility unZipClass = new UnZipUtility();
				unZipClass.unzip(zipFilePath, destDirectory);
				List<String> stringfile = unZipClass
						.readFile("C:\\Users\\ffd-sys-team\\Downloads\\TestExtract\\" + fileName + ".fnf");
				System.out.println(stringfile);
				String orderNum = Items.getDONumber();
				System.out.println("orderNumber:" + orderNum);
				System.out.println(stringfile.contains("<ShipID>" + orderNum + "</ShipID>"));
				Assert.assertTrue(stringfile.contains("<ShipID>" + orderNum + "</ShipID>"),
						"OrderNum or ShipID mismatch");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}