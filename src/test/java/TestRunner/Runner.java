package TestRunner;


import java.io.File;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@SuppressWarnings("deprecation")
@CucumberOptions(
		strict = true,
		dryRun = false,
		//tags={"@tag1011,@tag1020"},
		//tags={"@tag1011,@tag1013,@tag1014,@tag1015,@tag1016,@tag1017,@tag1018,@tag1019,@tag1020,@tag1021,@tag1022,@tag1023"},
				tags={"@tag5"},
		features = {"src\\test\\java\\featureFile"},
		//features = {"src\\test\\java\\featureFile"},
		glue = {"StepDefinition"},
		//format={"pretty","html:resources\\Reports\\cucumber-report.html"},
		//format = { "pretty","json:resources\\cucumber-reports\\cucumber-report.json" },
	//	plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
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

		globalFunc.DateTime.TimeDateFunc();

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		
		String reportpath = "resources\\LatestReports\\Report-" + globalFunc.DateTime.strDate3 + ".html";
		extentProperties.setReportPath(reportpath);
		

		// Reporter.loadXMLConfig(new
		// File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		// Reporter.loadXMLConfig(new File("src/ConfigFiles/extent-config.xml"));

	}
	 //@AfterClass
	@AfterTest
	public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File("Config/report.xml"));
	        
	    }
	  
	 

}

