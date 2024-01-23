package utils;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.testng.Assert;
import org.testng.Reporter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.gherkin.model.Scenario;

import StepDefinition.Steps;
import jdk.internal.org.jline.utils.Log;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;




public class SeleniumTestHelper {
	
	
	
	
	public static String TagNameWithTCname=null;
	

	static WebDriver driver = Steps.seleniumDriver;
	
	
	
	
	public static void clickOnButton(WebElement element) {
		try {
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (NoSuchElementException exe) {
			Assert.fail(exe.getMessage() + " exception occured.");
		}

	}

	public static void enterTextInTextBox(WebElement element, String text) {
		try {
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(text);
			}
		} catch (NoSuchElementException exe) {
			Assert.fail(exe.getMessage() + " exception occured.");
		}
	}

	public static void enterText(WebElement element, String text) {
		try {
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(text);
			}
		} catch (NoSuchElementException exe) {
			Assert.fail(exe.getMessage() + " exception occured.");
		}
	}

	public static void clear(WebElement element) {
		try {
			if (element.isDisplayed()) {
				element.clear();
			}
		} catch (NoSuchElementException exe) {
			Assert.fail(exe.getMessage() + " exception occured.");
		}
	}

	public enum DropDownMode {
		VISIBLE_TEXT, INDEX, VALUE
	}

	public static void selectFromDropDown(WebElement element, String value,
			DropDownMode mode) {
		try {
			Select select = new Select(element);

			switch (mode) {
			case VISIBLE_TEXT:
				select.selectByVisibleText(value);
				break;
			case INDEX:
				select.selectByIndex(Integer.parseInt(value));
				break;
			case VALUE:
				select.selectByValue(value);

			}
			retryCount = 0;

		} catch (Exception exe) {

			if (retryCount > 3) {
				throw exe;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			retryCount++;
			selectFromDropDown(element, value, mode);

		}
	}

	private static int retryCount = 0;

	public static void selectFromDropDown(WebElement element, String value,
			String mode) {
		try {
			Select select = new Select(element);
			if (mode.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			} else if (mode.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (mode.equalsIgnoreCase("visibletext")) {
				select.selectByVisibleText(value);
			} else {
				Assert.fail("Not a valid mode to select from a drop down.");
			}

			if (mode.equals(""))
				Reporter.log(element.getAttribute("value")
						+ " is entered successfully", true);
			retryCount = 0;

		} catch (Exception exe) {

			if (retryCount > 3) {
				throw exe;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			retryCount++;
			selectFromDropDown(element, value, mode);

		}
	}






	public static List<String> getAllOptionsInAdvancedDropdown(WebElement dropDown){

		WebDriver driver = Driver.getInstance();
		WebDriverWait wd = new WebDriverWait(Driver.getInstance(), 20);
		wd.until(ExpectedConditions.elementToBeClickable(dropDown));
		dropDown.click();
		List<WebElement> elements = driver.findElements(By.xpath("//li[contains(@class,'select2-results__option')]"));
		List<String> allOptions = new ArrayList<String>();
		for(WebElement element: elements){
			allOptions.add(element.getText());
		}
		dropDown.click();
		return allOptions;
	}

	public static boolean isElementDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			if (element.isDisplayed()) {
				displayed = true;
			}
		} catch (NoSuchElementException exeNo) {
			displayed = false;
		}
		return displayed;
	}

	public static WebElement WaitForElement(WebElement element, int seconds) {

		long start = System.currentTimeMillis();

		while (true) {

			try {
				element.isDisplayed();
				return element;
			} catch (WebDriverException e) {

				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
				}

				continue;

			} finally {

				long end = System.currentTimeMillis();
				if ((end - start) / 1000 > seconds) {
					throw new NoSuchElementException(
							"Timeout exceeded and element couldn't be found");
				}
			}
		}
	}

	public static void click(WebElement element) {

		try {
			element.click();
		} catch (WebDriverException e) {

			if (e instanceof NoSuchElementException) {
				WaitForElement(element, 10);
				element.click();
				return;
			} else if (e instanceof StaleElementReferenceException) {
				Driver.getInstance().navigate().refresh();
				element.click();
				return;
			}

			if (e.getMessage().startsWith("unknown error: Element")) {
				((JavascriptExecutor) (Driver.getInstance())).executeScript(
						"arguments[0].click()", element);
				return;
			}

			throw e;
		}
	}

	public static void waitForElementToBeDisplayed(WebDriver driver,
			WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToBeClickable(WebDriver driver,
			WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToBePresent(WebDriver driver, By element,
			int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	/**
	 * this function returns true if the element is enabled else false
	 * 
	 * @param element
	 * @return boolean
	 */
	public static boolean isElementEnabled(WebElement element) {
		boolean enabled = false;
		try {
			if (element.isDisplayed()) {
				if (element.isEnabled())
					enabled = true;
			}
		} catch (NoSuchElementException exe) {

			Assert.fail(exe.getMessage() + " exception occured.");
		}
		return enabled;
	}

	public static void switchingToParentWindow(WebDriver driver) {

		Set<String> childWindow = driver.getWindowHandles();
		Iterator<String> itrs = childWindow.iterator();
		String pWindows = itrs.next();
		String cWindows = itrs.next();
		driver.switchTo().window(cWindows);

		driver.switchTo().window(pWindows);

	}



	public static By getElementByInDefaultElementLocator(WebElement ele) {
		By by = null;
		String eleStr = ele.toString();
		System.out.println(eleStr);
		String byString = ele.toString().split("By.", 2)[1];
		String[] byDetail = byString.split(": ", 2);
		String locator = byDetail[1].substring(0,byDetail[1].length()-1);
		switch (byDetail[0].trim().toLowerCase()) {
		case "id":
			by = By.id(locator);
			break;
		case "name":
			by = By.name(locator);
			break;
		case "class name":
		case "classname":
			by = By.className(locator);
			break;
		case "linktext":
		case "link text":
			by = By.linkText(locator);
			break;
		case "partiallinktext":
		case "partial link text":
			by = By.partialLinkText(locator);
			break;
		case "tagname":
		case "tag name":
			by = By.tagName(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		case "cssselector":
		case "css selector":
			by = By.cssSelector(locator);
			break;
		default:
			System.out.println("None of the locator type matched. Locator type found is "+byDetail[0]+" and locator found is "+locator);
		}

		return by;
	}

	/*public static boolean verifyElement(WebElement element) {
		String eleStr = element.toString();
		if(eleStr.contains("By")){
			By locator = getElementByInDefaultElementLocator(element);
			return verifyElement(locator);
		}else{
			WebDriverDispatcher wpatch = (WebDriverDispatcher)element;
			return wpatch.
		}

	}
	public static boolean verifyElement(WebElement element, int maxWaitTime) {
		By locator = getElementByInDefaultElementLocator(element);
		return verifyElement(locator, maxWaitTime);
	}*/

	public static boolean verifyElement(By locator) {
		boolean isFound = true;
		WebDriverDispatcher wpatch = (WebDriverDispatcher)Driver.getInstance();
		try {
			isFound = wpatch.verifyElement(locator, 20);
		} catch (Exception e) {
			isFound = false;
		}
		return isFound;
	}

	public static boolean verifyElement(By locator, int maxWaitTime) {
		boolean isFound = true;
		WebDriverDispatcher wpatch = (WebDriverDispatcher)Driver.getInstance();
		try {
			isFound = wpatch.verifyElement(locator, maxWaitTime);
		} catch (Exception e) {
			isFound = false;
		}
		return isFound;
	}


	public static WebElement locateRow(String description) {
		return Driver.getInstance().findElement(By.partialLinkText(description));
	}

	public static WebElement dropDownPartialItem(String partialItemName){
		return Driver.getInstance().findElement(By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'"+partialItemName+"')]"));
	}

	public static WebElement dropDownItem(String itemName){
		return Driver.getInstance().findElement(By.xpath("//li[contains(@class,'select2-results__option') and text()='"+itemName+"']"));
	}

	public static void uploadFile(String filePath) throws IOException {
		/*try {
			String script = Config.getProperty("applicationFolder")
					+ "/automation-test/src/test/resources/script.exe";
			Runtime.getRuntime().exec(new String[] { script, filePath });
		} catch (IOException e) {
			throw new RuntimeException("File not found");
		}*/

		String script = Config.getProperty("applicationFolder")
				+ "/src/test/resources/script.exe";
		Runtime.getRuntime().exec(new String[] { script, filePath });

	}

	public static WebDriver switchToOtherWindow(WebDriver driver) {
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		return driver;
	}

	public static WebDriver switchToOtherWindowAndCloseCurrentWindow(
			WebDriver driver) {
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(currentHandle)) {
				driver.close();
				driver.switchTo().window(handle);
			}
		}
		return driver;
	}

	public static WebDriver switchToOtherWindowAndCloseItAndComeBack(
			WebDriver driver) {
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(currentHandle)) {
				driver.switchTo().window(handle);
				driver.close();
				break;
			}
		}
		driver.switchTo().window(currentHandle);
		return driver;
	}

	public static void switchingTochildtWindow(WebDriver driver) {

		Set<String> childWindow = driver.getWindowHandles();
		Iterator<String> itrs = childWindow.iterator();
		String pWindows = itrs.next();
		String cWindows = itrs.next();
		driver.switchTo().window(cWindows);

	}

	public static void waitForElementToAppear(By element, long minWaitTime,
			long maxWaitTime) {
		boolean isElementFound = false;
		try {
			Thread.sleep(minWaitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long maxDeltaTime = maxWaitTime - minWaitTime;
		long startTime = System.currentTimeMillis();
		long currentTime = startTime;

		while ((maxDeltaTime > (currentTime - startTime)) && !isElementFound) {
			isElementFound = true;
			try {
				Driver.getInstance().findElement(element);
			} catch (Exception e) {
				try {
					Thread.sleep(500);
					Driver.getInstance().navigate().refresh();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				isElementFound = false;
			}
			currentTime = System.currentTimeMillis();
		}
	}

	public static void assertEquals(Object actual, Object expected, String message){

		
		if(null != message){
			System.out.println(message + "Actual is: "+ actual + " Expected is: "+expected);
			Assert.assertEquals(actual, expected, message);
			

		}else{
			Assert.assertEquals(actual, expected);
		}
		if(!(actual.equals(true)||expected.equals(true)|| actual.equals(false)||expected.equals(false))) {
		com.cucumber.listener.Reporter.addStepLog( "Expected is "+expected.toString()+" and Actual is "+actual);
		}
	}
	public static void assertNotEquals(Object actual, Object expected, String message){
		
		com.cucumber.listener.Reporter.addStepLog("Expected is "+expected.toString()+" and Actual is "+actual);

		if(null != message){
			System.out.println(message + "actual is: "+ actual + "expected is: "+expected);
			Assert.assertNotEquals(actual, expected, message);

		}else{
			Assert.assertNotEquals(actual, expected);
		}
	}

	public static void assertEquals(Object actual, Object expected){
		try {
			assertEquals(actual, expected, null);
		} 
			catch (AssertionError e) {
				e.printStackTrace();
				Steps.testRes = "Failed";
				SeleniumTestHelper.fail(actual, expected, e.getMessage());
		}
	}

	public static void assertNotEquals(Object actual, Object expected){
		assertNotEquals(actual, expected, null);
	}

	public static void assertTrue(boolean bool, String message){
		assertEquals(bool, true, message);
	}	

	public static void assertTrue(boolean bool){
		assertTrue(bool, null);
	}

	public static void assertFalse(boolean bool, String message){
		assertEquals(bool, false, message);
	}	

	public static void assertFalse(boolean bool){
		assertFalse(bool, null);
	}

	public static void fail(Object actual, Object expected, String message){
		com.cucumber.listener.Reporter.addStepLog("Expected is "+expected.toString()+" and Actual is "+actual);
		Assert.assertTrue(false, message);
	}
	
	public static void fail(Object actual, Object expected){
		com.cucumber.listener.Reporter.addStepLog("Expected is "+expected.toString()+" and Actual is "+actual);
		Assert.assertTrue(false);
	}
	
	public static void fail(String message){
		assertEquals(true, false, message);
	}


	public static void assertNotNull(Object obj){
		assertNotNull(obj, null);
	}

	public static void assertNotNull(Object obj, String message){
		boolean truthness = true;
		if(null == obj){
			truthness = false;
		}
		assertEquals(truthness, true, message);
	}

	public static void fail(){
		fail(null);
	}
	public static String getFailedScreenshot(){
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		WebDriver driver = Driver.getInstance();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}
	
	public static int generateRandomInt(int min, int max){
		Random foo = new Random();
		return foo.nextInt((max + 1) - min) + min;
	}
	public static void jsClick(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)Driver.getInstance();
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * 
	 * @author nurmamet.hemrayev
	 * @param element
	 */
	public static void actionsClick(WebElement element){
		Actions actions = new Actions(Driver.getInstance());
		actions.moveToElement(element).perform();
		actions.click().perform();
	}
	/**
	 * This method is used for selecting date from calendar modal dialog
	 * @author nurmamet.hemrayev
	 * @param days - required days from current date
	 * @param months - required months from current date
	 * @param years - required years from current date
	 */
	public static void setCalendarFromCurrentDate(int days, int months, int years){
		Calendar cal = Calendar.getInstance();
		if(0 != days){
			cal.add(Calendar.DATE, days);
		}
		if(0 != months){
			cal.add(Calendar.MONTH, months);
		}
		if(0 != years){
			cal.add(Calendar.YEAR, years);
		}

		Date reqDate = cal.getTime();
		SimpleDateFormat fullDateFormat = new SimpleDateFormat("yyyy-MMMM-dd");
		SimpleDateFormat shortMonthFormat = new SimpleDateFormat("MMM");

		String reqDateStr = fullDateFormat.format(reqDate);
		String shortMonth = shortMonthFormat.format(reqDate);
		String reqYear = reqDateStr.split("-")[0];
		String reqMonth = reqDateStr.split("-")[1];
		String reqDay = reqDateStr.split("-")[2];
		reqDay = reqDay.replaceFirst("^0+(?!$)", "");
		WebDriver driver = Driver.getInstance();
		By dispYearMonthBy = By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']");
		By currentYearBy = By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch']");
		By yearRangeBy = By.xpath("//div[@class='datepicker-years']//th[@class='datepicker-switch']");
		String dispYearMonth = driver.findElement(dispYearMonthBy).getText();
		String dispMonth = dispYearMonth.split(" ")[0];
		String dispYear = dispYearMonth.split(" ")[1];
		By nextBtnBy = By.xpath("//th[@class='next'][not(./ancestor::*[contains(@style,'display: none')])]");
		if(!dispYear.equals(reqYear)){
			driver.findElement(dispYearMonthBy).click();
			driver.findElement(currentYearBy).click();
			String currentyearRange = driver.findElement(yearRangeBy).getText();
			int startYear = Integer.parseInt(currentyearRange.split("-")[0]);
			int endYear = Integer.parseInt(currentyearRange.split("-")[1]);
			int reqYearInt = Integer.parseInt(reqYear);
			while(!(reqYearInt>=startYear && reqYearInt<=endYear)){
				driver.findElement(nextBtnBy).click();
				currentyearRange = driver.findElement(yearRangeBy).getText();
				startYear = Integer.parseInt(currentyearRange.split("-")[0]);
				endYear = Integer.parseInt(currentyearRange.split("-")[1]);
			}
			driver.findElement(By.xpath("//span[contains(@class,'year') and text()='"+reqYear+"']")).click();;
			driver.findElement(By.xpath("//span[contains(@class,'month') and text()='"+shortMonth+"']")).click();
		}
		dispYearMonth = driver.findElement(dispYearMonthBy).getText();
		dispMonth = dispYearMonth.split(" ")[0];

		if(!(dispMonth.equals(reqMonth))){
			driver.findElement(dispYearMonthBy).click();
			driver.findElement(By.xpath("//span[contains(@class,'month') and text()='"+shortMonth+"']")).click();
		}

		driver.findElement(
				By.xpath("//div[@class='datepicker-days']//tbody//td[@class='day' and text()='"
						+ reqDay + "']")).click();
	}


	public static String getAbsolutePath(String fileName){

		String relativePath = Config.getProperty("attachmentsPath")+Config.getProperty(fileName);
		Path path = Paths.get(relativePath);
		Path absolutePath = path.toAbsolutePath();

		return absolutePath.toString();
	}

	public static File getLastDownloadedFile(){
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		File requiredFile = null;
		String requiredFileName = "";
		long lastModified = 0;
		String downloadDir = Config.getDownloadLocation();
		do{
			File f = new File(downloadDir);
			if(f.isDirectory())
				for(File currFile: f.listFiles()){
					if(!currFile.isDirectory()){
						if(lastModified<currFile.lastModified()){
							requiredFile = currFile;
							lastModified = currFile.lastModified();
						}
					}
				}
			requiredFileName = requiredFile.getName();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//lastModified = 0;
		}while(requiredFileName.contains(".crdownload")|| requiredFileName.contains(".download"));
		return requiredFile;
	}
	public static File getLastDownloadedFile(String matchingFileName){
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		File requiredFile = null;
		String requiredFileName = "";
		long lastModified = 0;
		String downloadDir = Config.getDownloadLocation();
		do{
			File f = new File(downloadDir);
			if(f.isDirectory())
				for(File currFile: f.listFiles()){
					if(!currFile.isDirectory()){
						if(currFile.getName().contains(matchingFileName) && lastModified<currFile.lastModified()){
							requiredFile = currFile;
							lastModified = currFile.lastModified();
						}
					}
				}
			requiredFileName = requiredFile.getName();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//lastModified = 0;
		}while(requiredFileName.contains(".crdownload")|| requiredFileName.contains(".download"));
		return requiredFile;
	}

	public static void waitForTextToBePresentInElement(WebDriver driver,
			WebElement element, int timeOutInSeconds,String text) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}


	public static void switchingTochildtWindowAndCloseIt(WebDriver driver) {

		Set<String> childWindow = driver.getWindowHandles();
		Iterator<String> itrs = childWindow.iterator();
		String pWindows = itrs.next();
		String cWindows = itrs.next();
		driver.switchTo().window(cWindows);
		driver.switchTo().window(cWindows).close();

	}

	public static void uploadfile(String filename) throws IOException
	{
		String script = System.getProperty("user.dir")+"\\"
				+ "upload.exe";
		//	Runtime.getRuntime().exec(script+" "+System.getProperty("user.dir")+"\\"+filename);
		Runtime.getRuntime().exec(script+" "+filename);
		System.out.println(System.getProperty("user.dir")+"\\"+filename);
	}
	public static String convertxmltostring(String filename) throws IOException
	{
		//filename is filepath string
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		String line;
		StringBuilder sb = new StringBuilder();

		while((line=br.readLine())!= null){
			sb.append(line.trim());
		}

		return sb.substring(3);
	}
	public static String XMLfile_update_singleinstance(String ASNID,String Parenttag,String Childtag,String filename) throws SAXException, IOException, ParserConfigurationException
	{
		String filePath = "D:\\Request.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			updateElementValue_generic(doc,Parenttag,Childtag,ASNID);
			doc.getDocumentElement().normalize();


			//write the updated document to file or console
			doc.getDocumentElement().normalize();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			System.out.println("XML file updated successfully");


		}
		catch (SAXException | ParserConfigurationException | IOException | TransformerException e1)
		{
			e1.printStackTrace();
		}
		return ASNID;
	}
	private static void updateElementValue_generic(Document doc,String Parentnode,String Childnode,String childvalue)
	{
		NodeList Parentnodes = doc.getElementsByTagName(Parentnode);
		Element child = null;
		//loop for each Parentnodes
		for(int i=0; i<Parentnodes.getLength();i++){
			child = (Element) Parentnodes.item(i);
			Node name = child.getElementsByTagName(Childnode).item(0).getFirstChild();
			name.setNodeValue(childvalue);
		}
	}
	public static void Close_OpenedWindow(String Screenname,WebDriver driver) throws InterruptedException
	{
		String Screenclose="(//label[text()='"+Screenname+"']//following::span[text()='Close'])[1]";
		//String Screenclose="(//label[contains(text() , '"+Screenname+"')]//following::span[text()='Close'])[1]";
		driver.findElement(By.xpath(Screenclose)).click();

	}
	
	public static void doubleclickonelement(WebDriver driver,WebElement ele)
	{
		Actions action=new Actions(driver);
		action.moveToElement(ele).doubleClick(ele).build().perform();
	}
	public static String Getvalueinbetweentags(String tagname,String Response)
	{
		final Pattern TAG_REGEX = Pattern.compile("<"+tagname+">(.+?)</"+tagname+">", Pattern.DOTALL);
		final Matcher matcher = TAG_REGEX.matcher(Response);
		matcher.find();
		System.out.println(matcher.group(1));
		if(matcher.group(1).equalsIgnoreCase("Confirmation"))
		{
			System.out.println("Response success");
		}
		return matcher.group(1);

	}
	public static void switchToInnerFrame(WebDriver driver){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public static String user_generate_estimated_delivery_date(int futureDate) {
		String estimatedDeliveryDate = null;
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, futureDate);
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-YYYY");
		Date futuredate = calender.getTime();
		estimatedDeliveryDate = formatter.format(futuredate);
		return estimatedDeliveryDate;
	}
	
	

/**
 * @author Vinay Kona
 * If Selenium regular dropdown doesn't work, We need to use this Method
 */
 public static void dropdownByFindElements(List<WebElement> element, String dropDownValue) {
		List<WebElement> dropDownList = element;
		 
		for (WebElement DropSource : dropDownList) {
			if (DropSource.getText().equalsIgnoreCase(dropDownValue)) {
				DropSource.click();
				break;
			}
		}
		dropDownList.clear();

	}
 
	public static String myCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		return dateFormat.format(date);
	}
	
	public static void actionMouseHoverAndClickOnSubMenu(WebElement element1,WebElement element2){
		Actions actions = new Actions(driver);
		actions.moveToElement(element1);
		actions.perform();
		Actions action1 = new Actions(driver);
		action1.moveToElement(element2).perform();
		action1.click().perform();
	}
	public static void scrollUp() {
		try {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight,0)", "");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean WaitForPageLoad() {
		boolean jQuery = false;
		boolean jsLoad = false;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("Pagestill loading");

			jQuery = ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
		} catch (Exception e) {
			jQuery = true;
		}

		try {
			System.out.println("Page is still loading");

			jsLoad = "complete"
					.equals(((JavascriptExecutor) driver).executeScript("return document.readyState").toString());
		} catch (Exception e) {
			jsLoad = true;
		}
		return jQuery && jsLoad;

	}

	public static boolean WaitForPageLoad(long milliSecond) {
		boolean jQuery = false;
		boolean jsLoad = false;

		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.println("Pagestill loading");

			jQuery = ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
		} catch (Exception e) {
			jQuery = true;
		}

		try {
			System.out.println("Page is still loading");

			jsLoad = "complete"
					.equals(((JavascriptExecutor) driver).executeScript("return document.readyState").toString());
		} catch (Exception e) {
			jsLoad = true;
		}
		return jQuery && jsLoad;
	}
 }

	
