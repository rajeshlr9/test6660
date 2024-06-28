package TestRunner;


import java.io.File;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import globalFunc.GetScenarioStepSnapshots;
import globalFunc.FileUtilities;
import utils.Config;
import utils.ExtentReportUpdate;
 


@SuppressWarnings("deprecation")
@CucumberOptions(
		strict = true,
		dryRun = false,
		tags={"tag5"}, 
				
		features = {"src\\test\\java\\featureFile"},
		glue = {"StepDefinition"},
		//  format = { "pretty","html:resources\\cucumber-reports\\cucumber-report.html"},
		format = { "pretty","json:resources\\cucumber-reports\\cucumber-report.json" },
		//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:","html:target\\cucumber-reports" },
		monochrome=true
		)

public class Runner extends AbstractTestNGCucumberTests {
	public  static String jenkinJobName = null;

	// private TestNGCucumberRunner testNGCucumberRunner;  


	/*@BeforeClass  
	public void setUpClass() throws Exception {  
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		config.setServerAddress(new URI("ws://localhost:5095"));
		SDK.init(config);  
	}

	@AfterClass
    public void tearDownClass() throws Exception {  
	SDK.cleanup();
	}*/
	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
	@BeforeTest
	public static void createExtentReport() {
		GetScenarioStepSnapshots.DeletingolddocFiles();
		globalFunc.DateTime.TimeDateFunc();

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;

		String reportpath = "./resources/Reports/" +Config.getProperty("Build_Number")+"_"+Config.getProperty("Account")+"_"+ globalFunc.DateTime.strDate32 + ".html";
		extentProperties.setReportPath(reportpath);


		// Reporter.loadXMLConfig(new
		// File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		// Reporter.loadXMLConfig(new File("src/ConfigFiles/extent-config.xml"));
		//Commented somelines

	}
	//@AfterClass
	@AfterTest
	public static void writeExtentReport() {

		Reporter.loadXMLConfig(new File("Config/report.xml"));
		/*
		 * if(!Config.getProperty("Job_Name").contains("ScrumTeam")) {
		 * ExtentReportUpdate.deleteOldFiles(); ExtentReportUpdate.copyReports(); }
		 */
		if(Config.getProperty("WordScreenshots").equals("true")) {
			FileUtilities.zipFile();
		}

		if(Config.getProperty("RunEnvironment").equals("Jenkins")){
			FileUtilities.copyReportFiles();
			FileUtilities.copyScreenshotFiles();
		}
	}
}

