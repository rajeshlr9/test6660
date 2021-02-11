package StepDefinition;

import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cucumber.listener.Reporter;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Window;
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
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.Items;
import globalFunc.CreateBrowser;
import globalFunc.DateTime;
import globalFunc.GlobalClass;
import globalFunc.Screenshots;
import globalFunc.GetScenarioStepSnapshots;
import pages.HomePage;
import pages.ManhattanLoginPage;
import utils.Config;

public class Steps {
	public static WebDriver seleniumDriver;
	public static Browser LeanFTDriver;
	public static Window winApp;
	String pageTitle;
	public static Robot robot;
	public static Scenario scenario;
	public static String dir;
	//public static Properties prop;
	public static String testRes = "";
	public static Logger logger;
	GlobalClass ob = new GlobalClass();
	public static HashMap<String, String> scenarioData;
	public static Map<Integer, Map<String, String>> ItemDataMap;
	public static Map<Integer, Map<String, String>> ServiceMap;

	// ManhattanLoginPage manhattanLoginPage = new ManhattanLoginPage();

	static {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	public Steps() throws Throwable {

	}

	@Before
	public void beforeClass(Scenario scenario) throws Exception {
		
			try {
				this.scenario = scenario;
				dir = System.getProperty("user.dir");
				System.out.println(dir);
				scenarioData=new HashMap<String, String>();
				ItemDataMap= new HashMap<Integer, Map<String,String>>();
				ServiceMap=new HashMap<Integer, Map<String,String>>();
				logger = Logger.getLogger("Selenium-leanFt");
				PropertyConfigurator.configure("Log4j.properties");
				if(Config.getProperty("WordScreenshots").equals("true")) {
					GetScenarioStepSnapshots.DeletingoldFiles();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * prop = new Properties(); FileInputStream ip = new FileInputStream(dir +
			 * "\\TestData\\config.properties"); try { prop.load(ip);
			 * 
			 * } catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
		}

	

	/*
	 * public void before(Scenario scenario) throws Exception { this.scenario =
	 * scenario; System.out.println("here"); }
	 */
	@After
	public void afterClass() throws GeneralLeanFtException {

		System.out.println("after scenario");
		
		System.out.println(testRes);
		// seleniumDriver.quit();

		//seleniumDriver.quit();
		
		/*
		 * if (LeanFTDriver.exists()) {
		 * 
		 * LeanFTDriver.close(); }
		 */
		 
		if ("Failed".equals(testRes)) {
			
			if (LeanFTDriver != null) {
				try {
					globalFunc.Screenshots.LeanFTSnapshot(LeanFTDriver);
					System.out.println("naka1");
				} catch (Exception e) {
					// TODO Auto-generated
					e.printStackTrace();
					System.out.println("raka1");
				}

			}
			if (winApp != null) {
				try {
					globalFunc.Screenshots.LeanFTSnapshot(winApp);
					System.out.println("naka3");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("raka3");
				}
			}
			if (seleniumDriver != null) {
				try {
					globalFunc.Screenshots.seleniumSnapshot(seleniumDriver);
					System.out.println("naka2");
					String jobName[]= Config.getProperty("Job_Name").split("/");
					Screenshots.addingScreenshottoExentReport();
					HomePage homePage1= new HomePage();
					homePage1.user_logout_from_application1();
				} catch (Exception e) { // TODO Auto-generated
					e.printStackTrace();
					System.out.println("raka3");
				}
			}
		}
		if (LeanFTDriver != null) {
			LeanFTDriver.close();
			LeanFTDriver = null;
		}
		if (seleniumDriver != null) {
			seleniumDriver.quit();
			seleniumDriver = null;
		}
		Items.removeAllTheValuesFromMap();
		if(Config.getProperty("WordScreenshots").equals("true")) {
			GetScenarioStepSnapshots.FolderScreenShotToWord(scenario.getName());
		}
		System.out.println(Config.getProperty("Job_Name"));
	}

	@Given("We have Manhattan environmnet up and running")
	public void givenCondition() {
		System.out.println("Assuming Manhattan environment is up and running");
		
	}
	
	@Given("I have excel data")
	public void readExcelData(DataTable scenarioName) throws Exception {
		try {
			
			List<List<String>> data = scenarioName.raw();
			scenarioData = ob.getExcelData(data.get(0).get(0), "ScenarioData", Config.getProperty("TestDataPath"));
			System.out.println(scenarioData);
			ItemDataMap = ob.filterData(ob.readData(Config.getProperty("TestDataPath"), "ItemData"),
					scenarioData.get("ItemReference"), "ItemData");
			System.out.println(ItemDataMap);
			logger.info("Excel data stored in Hashmap");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("Excel data not stored in Hashmap");
		}
	}

	@When("User open Browser")
	public void openBrowser() throws Throwable {
		try {
			System.setProperty("webdriver.ie.driver", dir + "\\Jars\\browsers\\IEDriverServer.exe");
			seleniumDriver = new InternetExplorerDriver();
			seleniumDriver.manage().window().maximize();
			logger.info("browser opened");
		} catch (Exception e) {
			testRes = "Failed";
			System.out.println("test red" + testRes);
			e.printStackTrace();
		}
	}

	@Given("Open the IE by selenium")
	public void open_the_IE_and_launch_the_application_using_Selenium() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			/*
			 * System.setProperty("webdriver.ie.driver", dir +
			 * "\\Jars\\browsers\\IEDriverServer.exe"); seleniumDriver = new
			 * InternetExplorerDriver(); // seleniumDriver= new ChromeDriver();
			 * seleniumDriver.manage().window().maximize();
			 * seleniumDriver.get("https://rr.secure.fedex.com/oms"); Thread.sleep(5000);
			 * System.out.println("page title: " + seleniumDriver.getTitle()); pageTitle =
			 * seleniumDriver.getTitle();
			 */
			seleniumDriver = CreateBrowser.CreateBrowserInstance("ie");
			logger.info("Browser Instance created");
		} catch (Exception e) {
			testRes = "Failed";
			e.printStackTrace();
		}
	}

	@And("Launch the \"([^\"]*)\" browser by selenium")
	public void Launch_the_browser_using_Selenium(String Browser) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		seleniumDriver = CreateBrowser.CreateBrowserInstance(Browser);
		logger.info("Browser Instance created");
	}

	@And("Open the chrome browser by selenium")
	public void open_the_chrome_and_launch_the_application_using_Selenium() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		seleniumDriver = CreateBrowser.CreateBrowserInstance();
		logger.info("Browser Instance created");
	}

	/*
	 * @When("^user logs into Manhattan application using \"([^\"]*)\" Credentials$"
	 * ) public void open_the_browser_and_login_to_manhattan_application(String
	 * userType) { try { seleniumDriver = CreateBrowser.CreateBrowserInstance();
	 * logger.info("Browser Instance created");
	 * manhattanLoginPage.loginToManhattanApp(userType); } catch (Throwable e) {
	 * e.printStackTrace(); } }
	 */
	@And("Set the chrome browser by seleniumi in linux")
	public void please_launch_the_application_using_Seleniumtool_in_linux() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		seleniumDriver = CreateBrowser.CreateChromeBrowserInstance();
		logger.info("Browser Instance created");
	}

	@Then("^Attach LeanFT IE browser to seleniumTest$")
	public void AttachLeanFTIEBrowseTtoSeleniumTest() throws Throwable {
		try {
			Thread.sleep(10000);
			System.out.println("page title2: " + pageTitle);
			reusable.LeanFtInitialize.initializeLeanFt();
			// LEANFT: Attach to the browser
			// LeanFTDriver = BrowserFactory.attach(new
			// BrowserDescription.Builder().type(BrowserType.INTERNET_EXPLORER).openTitle("Web
			// Single Sign On").build());
			LeanFTDriver = BrowserFactory.attach(
					new BrowserDescription.Builder().title("WSSO Login").type(BrowserType.INTERNET_EXPLORER).build());
		} catch (Exception e) {
			testRes = "Failed";
			e.printStackTrace();
		}
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
			testRes = "Failed";
			e.printStackTrace();
		}
	}

	@Then("Close browser opened by LeanFT")
	public void Close_browser_opened_by_Leanft() throws Throwable {

		System.out.println("Step 3");
		LeanFTDriver.close();
		LeanFTDriver = null;
	}
}
