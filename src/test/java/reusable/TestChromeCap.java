package reusable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import globalFunc.DateTime;
import globalFunc.GlobalClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestChromeCap {

	public static void main(String[] args) throws Exception {
		/*
		 * WebDriverManager.chromedriver().setup(); DesiredCapabilities cap = new
		 * DesiredCapabilities();
		 * cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		 * cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); ChromeOptions
		 * opt=new ChromeOptions();
		 * 
		 * // pass the debuggerAddress and pass the port along with host. Since I am
		 * running test on local so using localhost
		 * opt.setExperimentalOption("debuggerAddress","localhost:9222 ");
		 * 
		 * // pass ChromeOptions object to ChromeDriver constructor WebDriver driver=new
		 * ChromeDriver(opt);
		 * 
		 * // now you can use now existing Browser
		 * //driver.get("https://ocfdl1wm1.logistics.fedex.com:12001/");
		 * driver.findElement(By.id("username")).sendKeys("aaa");
		 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ffd-sys-team\\git\\ffd-manhattan-testing\\Jars\\browsers\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress","localhost:10128");
		WebDriver driver=new ChromeDriver(opt);
		WebElement ele = driver.findElement(By.cssSelector(".x-grid-item.x-grid-item-selected.mps-grid-row-focused"));
		Actions actions = new Actions(driver);
		actions.contextClick(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		//Thread.sleep(1000);
		//Single.click();
		try {
			Thread.sleep(3500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
		for(int i=0;i<2;i++) {
			globalFunc.DateTime.TimeDateFunc();
			Thread.sleep(1000);
			System.out.println(DateTime.strDate67);
		}
	}

}
