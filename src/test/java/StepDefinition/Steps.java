package StepDefinition;

import java.awt.Robot;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.NumericField;
import com.hp.lft.sdk.web.NumericFieldDescription;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	public static WebDriver seleniumDriver;
	public static Browser LeanFTDriver;
	String pageTitle;
	public static Robot robot;

	public static String dir;

	@Before
	public void beforeClass() throws GeneralLeanFtException {
		dir = System.getProperty("user.dir");
		System.out.println(dir);

	}

	@After
	public void afterClass() throws GeneralLeanFtException {
		System.out.println("after");
		//seleniumDriver.quit();
		/*
		 * seleniumDriver.quit(); if(LeanFTDriver.exists()) { LeanFTDriver.close(); }
		 */
		if(LeanFTDriver!=null) { 
			LeanFTDriver.close();
			LeanFTDriver=null;
		}
		if(seleniumDriver!=null) {
			seleniumDriver.quit();
			seleniumDriver=null;
		}
		
	}

	@Given("Open the InternetExplorer by leanft")
	public void open_the_Firefox_and_launch_the_application_using_LeanFT() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		reusable.LeanFtInitialize.initializeLeanFt();
		LeanFTDriver = BrowserFactory.launch(BrowserType.INTERNET_EXPLORER);
		try {
			// Navigate to the New Tours website.
			LeanFTDriver.navigate("https://rr.secure.fedex.com/oms");
			LeanFTDriver.sync();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Given("Open the Chrome by leanft")
	public void open_the_Chrome_and_launch_the_application_using_LeanFT() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		reusable.LeanFtInitialize.initializeLeanFt();
		LeanFTDriver = BrowserFactory.launch(BrowserType.CHROME);
		try {
			// Navigate to the New Tours website.
			LeanFTDriver.navigate("https://rr.secure.fedex.com/oms");
			LeanFTDriver.sync();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Given("Open the Chrome by selenium")
	public void open_the_Chrome_and_launch_the_application_using_Selenium() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		try {
			System.setProperty("webdriver.ie.driver", dir + "\\Jars\\browsers\\IEDriverServer.exe");
			seleniumDriver = new InternetExplorerDriver();
			// seleniumDriver= new ChromeDriver();
			seleniumDriver.manage().window().maximize();
			seleniumDriver.get("https://rr.secure.fedex.com/oms");
			Thread.sleep(5000);
			System.out.println("page title: " + seleniumDriver.getTitle());
			pageTitle = seleniumDriver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Given("Open the IE by selenium")
	public void open_the_IE_and_launch_the_application_using_Selenium() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.ie.driver", dir + "\\Jars\\browsers\\IEDriverServer.exe");
		seleniumDriver = new InternetExplorerDriver();
		// seleniumDriver= new ChromeDriver();
		seleniumDriver.manage().window().maximize();
		seleniumDriver.get("https://rr.secure.fedex.com/oms");
		Thread.sleep(5000);
		System.out.println("page title: " + seleniumDriver.getTitle());
		pageTitle = seleniumDriver.getTitle();

	}

	@Then("^Attach LeanFT IE browser to seleniumTest$")
	public void AttachLeanFTIEBrowseTtoSeleniumTest() throws Throwable {
		Thread.sleep(10000);
		System.out.println("page title2: " + pageTitle);
		reusable.LeanFtInitialize.initializeLeanFt();
		// LEANFT: Attach to the browser
		// LeanFTDriver = BrowserFactory.attach(new
		// BrowserDescription.Builder().type(BrowserType.INTERNET_EXPLORER).openTitle("Web
		// Single Sign On").build());
		LeanFTDriver = BrowserFactory.attach(
				new BrowserDescription.Builder().title("WSSO Login").type(BrowserType.INTERNET_EXPLORER).build());

	}

	@Then("^Attach LeanFT Chrome browser to seleniumTest$")
	public void AttachLeanFTChromeBrowseTtoSeleniumTest() throws Throwable {
		Thread.sleep(20000);
		System.out.println("page title2: " + pageTitle);
		reusable.LeanFtInitialize.initializeLeanFt();
		// LEANFT: Attach to the browser
		// LeanFTDriver = BrowserFactory.attach(new
		// BrowserDescription.Builder().type(BrowserType.INTERNET_EXPLORER).openTitle("Web
		// Single Sign On").build());
		LeanFTDriver = BrowserFactory
				.attach(new BrowserDescription.Builder().title("WSSO Login").type(BrowserType.CHROME).build());

	}

	@Then("Login to OMS by LeanFT")
	public void LogintoOMSbyLeanFT() throws InterruptedException {
		try {
			LeanFTDriver.describe(NumericField.class,
					new NumericFieldDescription.Builder().name("username").tagName("INPUT").type("number").build())
					.setValue("867949");
			Thread.sleep(2000);
			LeanFTDriver.describe(EditField.class,
					new EditFieldDescription.Builder().name("password").tagName("INPUT").type("password").build())
					.setValue("Manage16");

			Thread.sleep(2000);
			LeanFTDriver.describe(Button.class,
					new ButtonDescription.Builder().buttonType("submit").name(" Sign In ").tagName("INPUT").build())
					.click();
			LeanFTDriver.sync();

		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}

	}

	@And("Click on search Order using selenium")
	public void openOrder() {
		try {

			Thread.sleep(15000);

			seleniumDriver.findElement(By.id("ulaitem0_3")).click();
			seleniumDriver.findElement(By.id("orderSearchform:orderNumber")).sendKeys("9860217");
			seleniumDriver.findElement(By.id("orderSearchform:searchDetails")).click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@When("abc")
	public void abc() {
		System.out.println("Step 2");
	}

	@Then("^Close browser opened by selenium$")
	public void Close_browser_opened_by_selenium() throws Throwable {

		System.out.println("Step 3");
		seleniumDriver.close();
	}

	@Then("^Close_browser_opened_by_Leanft$")
	public void Close_browser_opened_by_Leanft() throws Throwable {

		System.out.println("Step 3");
		LeanFTDriver.close();
	}

	@Given("Open Filezilla")
	public void LaunchFilezilla() throws Throwable {

		new ProcessBuilder("C:\\Program Files (x86)\\FileZilla FTP Client\\filezilla.exe").start();
		Thread.sleep(3000);

	}

	@When("user connects to EMC customer and drop an OB order")
	public void orderUpload() throws Throwable {

		reusable.LeanFtInitialize.initializeLeanFt();
		reusable.ModifyXML.ModifyFile();
		reusable.Filezilla.uploadOrder();

	}

	@And("Login to OMS using Selenium")
	public void OMSLogin(DataTable usercredentials) throws Throwable {

		try {
			System.setProperty("webdriver.ie.driver", dir + "\\Jars\\browsers\\IEDriverServer.exe");
			seleniumDriver = new InternetExplorerDriver();
			seleniumDriver.manage().window().maximize();
			seleniumDriver.get("https://rr.secure.fedex.com/oms");
			seleniumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		reusable.OMSLogin.loginOMS(usercredentials);

	}

	@And("Search for the dropped order using Selenium")
	public void searchOrder() throws Throwable {

		try {

			Thread.sleep(12000);

			seleniumDriver.findElement(By.id("ulaitem0_3")).click();
			seleniumDriver.findElement(By.id("orderSearchform:custRef")).sendKeys("EMC" + globalFunc.DateTime.strDate6);
			seleniumDriver.findElement(By.id("orderSearchform:searchDetails")).click();
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@And("Resume the incomplete order using Selenium")
	public void resumeOrder() throws Throwable {

		try {

			seleniumDriver
					.findElement(By.xpath(
							"//TBODY[@id=\"orderSearchform:resultTable:tbody_element\"]/TR[1]/TD[1]/A[1]/SPAN[1]"))
					.click();
			Thread.sleep(12000);
			if (seleniumDriver.findElement(By.id("identifyCustomerForm:callerIdNumber")).getText().equals("")) {
				seleniumDriver.findElement(By.id("identifyCustomerForm:callerIdNumber")).sendKeys("123456");
				seleniumDriver.findElement(By.id("identifyCustomerForm:pageTitle")).click();
			}

			Thread.sleep(5000);

			seleniumDriver.findElement(By.id("identifyCustomerForm:submitT")).click();
			Thread.sleep(5000);

			seleniumDriver.findElement(By.id("inputForm:submitInv")).click();
			Thread.sleep(5000);

			seleniumDriver.findElement(By.id("form1:submit2")).click();
			Thread.sleep(10000);
			seleniumDriver.findElement(By.id("form1:requestedDeliveryLatest")).clear();

			globalFunc.DateTime.TimeDateFunc();
			String date = globalFunc.DateTime.strDate4;
			seleniumDriver.findElement(By.id("form1:requestedDeliveryLatest")).sendKeys(date);

			seleniumDriver.findElement(By.id("form1:filter")).click();
			Thread.sleep(5000);

			seleniumDriver.findElement(By.xpath(
					"//TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[3]/TBODY[1]/TR[1]/TD[3]/FORM[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/TABLE[1]/TBODY[1]/TR[6]/TD[1]/TABLE[3]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[3]/TBODY[1]/TR[1]/TD[1]/DIV[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/LABEL[1]/INPUT[1]"))
					.click();

			seleniumDriver.findElement(By.id("form1:submit2")).click();
			Thread.sleep(7000);

			seleniumDriver.findElement(By.id("form1:submitPlacement")).click();
			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail("WebDriver couldnâ€™t locate the element");
			seleniumDriver.close();
		}
	}

	@Then("Order is placed successfully")
	public void orderCreationValidation() throws Throwable {

		String expected = seleniumDriver.findElement(By.xpath(
				"//TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[3]/TBODY[1]/TR[1]/TD[2]/FORM[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/TABLE[1]/TBODY[1]/TR[4]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/SPAN[1]"))
				.getText();
		String actual = "Thank you for shipping with FedEx. Your shipment number is";

		if (expected.equals(actual)) {
			String orderno = seleniumDriver.findElement(By.id("form1:orderNum")).getText();
			System.out.println("order created " + orderno);
		} else {
			System.out.println("order not created ");
		}

	}

	@Then("Close browser opened by LeanFT")
	public void CloseBrowserOpenedByLeanFT() throws Throwable {
		LeanFTDriver.close();
	}

	@Given("Open Putty")
	public void openPutty() {
		try {
			new ProcessBuilder("C:\\Users\\QAAutoReg1\\Desktop\\putty.exe").start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("user login to Putty")
	public void puttyLogin(DataTable usercredentials) throws Throwable {

		reusable.LeanFtInitialize.initializeLeanFt();
		reusable.PuttyLogin.puttyLogin(usercredentials);
	}

	@And("Complete adhoc move")
	public void performAdhocmove(DataTable usercredentials) throws Throwable {

		reusable.AdhocMove.adhocMove(usercredentials);
	}

	@Then("Items are moved successfully")
	public void adhocmoveValidation() throws IOException {

		try {
			Runtime rt = Runtime.getRuntime();

			rt.exec("taskkill /F /IM putty.exe");
			System.out.println("adhoc move completed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false);
			e.printStackTrace();
		}
	}

}
