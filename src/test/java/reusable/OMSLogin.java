package reusable;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinition.Steps;
import utils.Config;

public class OMSLogin {

	public static void loginOMS() throws InterruptedException {
		
		
			WebDriver driver= Steps.seleniumDriver;
			driver.get(Config.getProperty("OMSUrl"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			WebElement username = driver.findElement(By.xpath("//INPUT[@id=\"username\"]"));
			username.sendKeys(Config.getProperty("OMSUsername"));

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(Config.getProperty("OMSPassword"));

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement submit = driver.findElement(By.id("submit"));
			submit.click();
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			Thread.sleep(10000);
			String text="Create An Order";
			if (driver.findElement(By.id("identifyCustomerForm:pageTitle")).getText().contains(text)) {
				System.out.println("User is logged in to OMS");
			//	test.log(LogStatus.PASS, "User is logged in to OMS");
			} else {
			//  test.log(LogStatus.FAIL, "Test Failed");
				System.out.println("User is not logged in to OMS");
				Assert.assertTrue(false);
			}
	}
}
