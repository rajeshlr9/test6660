package globalFunc;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import StepDefinition.Steps;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Config;
import utils.SeleniumCustomListener;
import utils.WebDriverDispatcher;

public class CreateBrowser {
	public static WebDriver seleniumDriver;
	
	public static WebDriver CreateBrowserInstance(String browser) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
			//System.out.println("Browser is: "+Steps.prop.getProperty("browser"));
			switch (browser) {

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
				seleniumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//seleniumDriver.manage().deleteAllCookies();
				Steps.logger.info("Chrome browser is open");
				break;
			}	
		
	
			
			
			return seleniumDriver;
	}
	
	
	public static WebDriver CreateBrowserInstance() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String sys1 =Config.getProperty("System");
		String getpodip = Config.getProperty("IP");
		System.out.println(sys1+getpodip);
			//System.out.println("Browser is: "+Steps.prop.getProperty("browser"));
			switch (sys1) {

			case "ie":
				System.setProperty("webdriver.ie.driver", Steps.dir + "\\Jars\\browsers\\IEDriverServer.exe");
				seleniumDriver = new InternetExplorerDriver();
				break;
				
			case "OCI_Windows-Chrome":
				
				//System.setProperty("webdriver.chrome.driver", Steps.dir + "\\drivers\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				//this one below line is added for connection timeout issue if not work we will remove
				options.addArguments("no-sandbox");

				options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer"});
				prefs.put("plugins.always_open_pdf_externally", true);
				prefs.put("download.default_directory", Config.getDownloadLocation());
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("disable-infobars");
	
				seleniumDriver = new ChromeDriver(options);
				seleniumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println(options.getVersion());
				//seleniumDriver.manage().deleteAllCookies();
				Steps.logger.info("Chrome browser is open");
				break;
				
			case "@Platform":
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", Steps.dir + "\\drivers\\chromedriver.exe");
				ChromeOptions options2 = new ChromeOptions();
				options2.addArguments("--start-maximized");
				Map<String, Object> prefs2 = new HashMap<String, Object>();
				prefs2.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer"});
				prefs2.put("plugins.always_open_pdf_externally", true);
				prefs2.put("download.default_directory", Config.getDownloadLocation());
				prefs2.put("profile.default_content_setting_values.notifications", 2);
				prefs2.put("credentials_enable_service", false);
				options2.setExperimentalOption("prefs", prefs2);
				options2.addArguments("disable-infobars");
				options2.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				options2.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				options2.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));

				seleniumDriver = new ChromeDriver(options2);
				seleniumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//seleniumDriver.manage().deleteAllCookies();
				Steps.logger.info("Chrome browser is open");
				break;
				
				case "OCI_Pod":
				//System.setProperty("webdriver.chrome.driver", Steps.dir + "\\drivers\\chromedriver.exe");
				ChromeOptions options1 = new ChromeOptions();
				//options1.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
				//URL dockerport = new URL("http://10.60.27.77:4444/wd/hub");
				
				//URL dockerport = new URL("http://10.60.28.5:31200/wd/hub");			
				URL dockerport = new URL(getpodip);
				seleniumDriver = new RemoteWebDriver(dockerport,options1);
				seleniumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//seleniumDriver.manage().deleteAllCookies();
				Steps.logger.info("Chrome browser is open");
				break;
			}	
		
	
			
			
			return seleniumDriver;
	}
	public static WebDriver CreateChromeBrowserInstance() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
			//System.out.println("Browser is: "+Steps.prop.getProperty("browser"));
			switch ("chromelinux") {

			case "ie":
				System.setProperty("webdriver.ie.driver", Steps.dir + "\\Jars\\browsers\\IEDriverServer.exe");
				seleniumDriver = new InternetExplorerDriver();
				break;
				
			case "chromelinux":
				
				System.setProperty("webdriver.chrome.driver", Steps.dir + "\\drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
				//URL dockerport = new URL("http://10.60.27.77:4444/wd/hub");
				
				URL dockerport = new URL("http://10.60.28.5:31200/wd/hub");			

				seleniumDriver = new RemoteWebDriver(dockerport,options);
				seleniumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//seleniumDriver.manage().deleteAllCookies();
				Steps.logger.info("Chrome browser is open");
				break;
			}	
		
	
			
			
			return seleniumDriver;
	}
	
	public void createSingletonBrsrInstance() {
		
	}
	
	public static WebDriver CreateBrowserInstance(boolean setProxy) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String sys1 = Config.getProperty("System");
		String getpodip = Config.getProperty("IP");
		System.out.println(sys1 + getpodip);
		// System.out.println("Browser is: "+Steps.prop.getProperty("browser"));
		switch (sys1) {

		case "ie":
			System.setProperty("webdriver.ie.driver", Steps.dir + "\\Jars\\browsers\\IEDriverServer.exe");
			seleniumDriver = new InternetExplorerDriver();
			break;

		case "OCI_Windows-Chrome":

			//System.setProperty("webdriver.chrome.driver", Steps.dir + "\\drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			// Below 4 lines of code has been added for proxy settings
			Proxy proxy = null;
			if(setProxy) {
			proxy = new Proxy();
			proxy.setAutodetect(false);
			proxy.setHttpProxy(Config.getProperty("Proxy_URL"));
			proxy.setSslProxy(Config.getProperty("Proxy_URL"));
			}

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable -extensions");
			options.addArguments("--disable-popup-blocking");
			
			options.addArguments("--incognito");
			options.addArguments("--start-maximized");
			
			options.addArguments("disable-infobars");
			
			
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
			prefs.put("plugins.always_open_pdf_externally", true);
			prefs.put("download.default_directory", Config.getDownloadLocation());
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			options.setExperimentalOption("prefs", prefs);
			//options.addArguments("disable-infobars");
			// Below 1 line of code has been added for proxy settings
			if(setProxy) {
			options.setCapability("proxy", proxy);
			}
			seleniumDriver = new ChromeDriver(options);
			seleniumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println(options.getVersion());
			seleniumDriver.manage().deleteAllCookies();
			Steps.logger.info("Chrome browser is open");
			break;

		case "@Platform":
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", Steps.dir +
			// "\\drivers\\chromedriver.exe");
			ChromeOptions options2 = new ChromeOptions();
			options2.addArguments("--start-maximized");
			Map<String, Object> prefs2 = new HashMap<String, Object>();
			prefs2.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
			prefs2.put("plugins.always_open_pdf_externally", true);
			prefs2.put("download.default_directory", Config.getDownloadLocation());
			prefs2.put("profile.default_content_setting_values.notifications", 2);
			prefs2.put("credentials_enable_service", false);
			options2.setExperimentalOption("prefs", prefs2);
			options2.addArguments("disable-infobars");
			options2.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options2.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options2.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

			seleniumDriver = new ChromeDriver(options2);
			seleniumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// seleniumDriver.manage().deleteAllCookies();
			Steps.logger.info("Chrome browser is open");
			break;

		case "OCI_Pod":
			// System.setProperty("webdriver.chrome.driver", Steps.dir +
			// "\\drivers\\chromedriver.exe");
			ChromeOptions options1 = new ChromeOptions();
			// options1.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
			// URL dockerport = new URL("http://10.60.27.77:4444/wd/hub");

			// URL dockerport = new URL("http://10.60.28.5:31200/wd/hub");
			URL dockerport = new URL(getpodip);
			seleniumDriver = new RemoteWebDriver(dockerport, options1);
			seleniumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// seleniumDriver.manage().deleteAllCookies();
			Steps.logger.info("Chrome browser is open");
			break;
		}

		return seleniumDriver;
	}

}
