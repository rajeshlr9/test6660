package TestRunner;


import java.io.File;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@SuppressWarnings("deprecation")
@CucumberOptions(
		strict = true,
		dryRun = false,
		
	
		tags={"@tag5"},

		features = {"E:\\eclipse-workspace\\SampleMavenPorj\\src\\test\\java\\featureFile\\MyTest.feature"},
		glue = {"StepDefinition"},
		format={"pre"
				+ ""
				+ "tty","html:E:\\eclipse-workspace\\SampleMavenPorj\\resources\\Reports\\cucumber-report.html"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 

		monochrome=true
		)

public class Runner extends AbstractTestNGCucumberTests {
	
	
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
	 @AfterClass
	    public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File("config/report.xml"));
	    
	    }

}
