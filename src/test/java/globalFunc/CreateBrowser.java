package globalFunc;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import StepDefinition.Steps;
import utils.Config;
import utils.SeleniumCustomListener;
import utils.WebDriverDispatcher;

public class CreateBrowser {
	public static WebDriver seleniumDriver;
	
	public static WebDriver CreateBrowserInstance() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
			//System.out.println("Browser is: "+Steps.prop.getProperty("browser"));
			switch ("chrome") {

			case "ie":
				System.setProperty("webdriver.ie.driver", Steps.dir + "\\Jars\\browsers\\IEDriverServer.exe");
				seleniumDriver = new InternetExplorerDriver();
				break;
				
			case "chrome":
				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ffd-sys-team\\git\\SampleMavenProj\\drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer"});
				prefs.put("plugins.always_open_pdf_externally", true);
				prefs.put("download.default_directory", Config.getDownloadLocation());
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("disable-infobars");
	
				seleniumDriver = new ChromeDriver(options);
				//seleniumDriver.manage().deleteAllCookies();
				Steps.logger.info("Chrome browser is open");
				break;
			}	
		
	
			
			
			return seleniumDriver;
	}
	
}
