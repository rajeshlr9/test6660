package pages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import entity.Items;
import utils.Driver;
import utils.SeleniumTestHelper;
import utils.TestStubReader;

public class ShipmentPage {
	WebDriver driver;
	
	public ShipmentPage() throws Throwable{
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	String shippingLabelDocumentStr;

	

	@FindBy(xpath = "//span[text()='View BOL']")
	public WebElement viewBOL;
	@FindBy(xpath = "//input[@name='TCShipmentID']")
	public WebElement TCShipmentID;
	@FindBy(xpath = "//tr[@class='  x-grid-row']//td//div[@class='x-grid-row-checker']")
	public WebElement shipmentID_chkbox;
	DistributionOrdersPage distributionOrdersPage1 = new DistributionOrdersPage();

	public void BillOfLadding(String sheetName, String rowname, int columnnumber)
			throws Exception {
		String expectedDOstatus = "Delivered";
		HomePage homepage = new HomePage();
		homepage.MenuItems_Distribution_Selection("Shipments");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrdersPage1.primaryField, 80);
		distributionOrdersPage1.primaryField.sendKeys("Shipment");

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, TCShipmentID, 50);
		TCShipmentID.click();
		TestStubReader stubReader = new TestStubReader();
		stubReader.setReadingSheet(sheetName);
		String ShipmentID = stubReader.setSheetAndGetData(sheetName, rowname, columnnumber);
		System.out.println("ShipmentID.." + ShipmentID);
		TCShipmentID.sendKeys(ShipmentID);
		distributionOrdersPage1.apply_Btn.click();

		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipmentID_chkbox, 50);
		shipmentID_chkbox.click();

		String ShipmentIDstatus = driver
				.findElement(By.xpath(
						"//td[@data-columnid='tCShipmentID']/div[text()='" + ShipmentID + "']//following::td[1]"))
				.getText();
		SeleniumTestHelper.assertEquals(ShipmentIDstatus, expectedDOstatus);
		distributionOrdersPage1.moreBtn.click();
		viewBOL.click();
		Thread.sleep(2000);
		homepage.user_closes_openedwindow("Shipments");

	}
	
	@Given("^user downloads shipping label document and read the PDF content$")
	public void user_downloads_shipping_label_document_and_read_the_PDF_content() throws Throwable {
	 
	
		SeleniumTestHelper.switchToOtherWindowAndCloseItAndComeBack(driver);
		File directory;
		File[] files;
		String dirPath = System.getProperty("user.dir");
		String directoryName = dirPath + "/sel_downloads/";
		directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdir();
			// use directory.mkdirs(); here instead.
		} else {
			files = directory.listFiles();
			for (File allFiles : files) {
				if (allFiles.getName().endsWith(".pdf")) {
					allFiles.delete();
					Reporter.log(allFiles.getName() + " deleted successfully");
					System.out.println(allFiles.getName() + " deleted successfully");
				}
			}
		}

		Thread.sleep(20000);
		Set<String> windowhandles = driver.getWindowHandles();
		Thread.sleep(3000);

		if (windowhandles.size() > 1) {
			Iterator<String> itrs = windowhandles.iterator();
			String pWindows = itrs.next();
			String cWindows = itrs.next();
			driver.switchTo().window(cWindows);
			if ((driver.getWindowHandle()).equals(cWindows)) {
				Thread.sleep(20000);
				driver.close();
			}
			driver.switchTo().window(pWindows);
		}
		directory = new File(directoryName);
		files = directory.listFiles();
		/*for (File allFiles : files) {
			if (allFiles.getName().contains("pdf")) {
				PDDocument document = PDDocument.load(allFiles);
				if (!document.isEncrypted()) {

					PDFTextStripperByArea stripper = new PDFTextStripperByArea();
					stripper.setSortByPosition(true);

					PDFTextStripper tStripper = new PDFTextStripper();

					String pdfFileInText = tStripper.getText(document);
					shippingLabelDocumentStr = pdfFileInText;
					Items.setPdfCOntent(shippingLabelDocumentStr);
					System.out.println("pdf content..."+shippingLabelDocumentStr);
					document.close();
				} else {
					SeleniumTestHelper.fail("Not verified PDF content as it is encrypted");
				}
			}
		}*/

	}
	

@Then("^user verifies shipping details in the BILL OF LADING PDF$")
public void user_verifies_shipping_details_in_the_BILL_OF_LADING_PDF() throws Throwable {
	String toMatchInstructionsExpected = "BILL OF LADING";

		Pattern patternInstructions = Pattern.compile(toMatchInstructionsExpected);
		Matcher matcherInstructions = patternInstructions.matcher(shippingLabelDocumentStr);

		String foundItemInstructionsActual = null;
		if (matcherInstructions.find()) {
			foundItemInstructionsActual = matcherInstructions.group(0);
			SeleniumTestHelper.assertEquals(toMatchInstructionsExpected, foundItemInstructionsActual);
			System.out.println("shipping details verified successfully in PDF");
		} else {
			System.out.println("shipping details  not found in PDF");
			SeleniumTestHelper.fail("shipping details  not found in PDF");
		}

		String toMatchInstructionsTxtExpected1 = "SHIP FROM" + "&"
				+ "Name:" + "&" + "9904"
				+ "&" + "SID#:" + "&" + "000000026";

		String[] firstInstructionInPDF = toMatchInstructionsTxtExpected1.split("&");
		for (String line : firstInstructionInPDF) {
			if (shippingLabelDocumentStr.contains(line)) {
				System.out.println(line);
			} else {
				System.out.println(line + " :--- not found in PDF");
			}
		}
		System.out.println("");

	}
}
