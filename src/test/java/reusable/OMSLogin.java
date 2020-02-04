package reusable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import StepDefinition.Steps;

public class OMSLogin {

	public static void loginOMS(DataTable usercredentials) throws InterruptedException {
		
		WebDriver driver= Steps.seleniumDriver;
		
		List<List<String>> data = usercredentials.raw();
		System.out.println("this is test1");
		WebElement username = driver.findElement(By.xpath("//INPUT[@id=\"username\"]"));
		System.out.println("test");
		username.sendKeys(data.get(1).get(0));

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(data.get(1).get(1));

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
		}
		
	}
	
}
