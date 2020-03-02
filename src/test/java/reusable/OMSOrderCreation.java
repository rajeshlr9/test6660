package reusable;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinition.Steps;

public class OMSOrderCreation {

	public static void enterdestinationDetails(WebDriver driver, HashMap<String, String> data) throws AWTException, InterruptedException {

		Thread.sleep(3000);
		System.out.println("First page of order creation");
		WebElement account= driver.findElement(By.id("identifyCustomerForm:customerAccount"));
		account.sendKeys(data.get("Account"));
		driver.findElement(By.id("identifyCustomerForm:pageTitle")).click();
		Thread.sleep(5000);

		WebElement employeeId = driver.findElement(By.id("identifyCustomerForm:callerIdNumber"));
		employeeId.sendKeys(data.get("EmployeeID"));
		driver.findElement(By.id("identifyCustomerForm:pageTitle")).click();
		Thread.sleep(5000);
		WebElement postalcode = driver.findElement(By.name("identifyCustomerForm:postalCd"));
		postalcode.sendKeys(data.get("ZipCode"));
		driver.findElement(By.id("identifyCustomerForm:pageTitle")).click();
		Thread.sleep(10000);

		WebElement firstname = driver.findElement(By.name("identifyCustomerForm:firstNm"));
		firstname.sendKeys(data.get("FirstName"));
		Thread.sleep(3000);
		//robot.keyPress(KeyEvent.VK_TAB);
		//robot.keyRelease(KeyEvent.VK_TAB);
		WebElement phone1 = driver.findElement(By.name("identifyCustomerForm:phone1"));
		phone1.sendKeys(data.get("Phone1"));
		Thread.sleep(3000);
		WebElement address1 = driver.findElement(By.name("identifyCustomerForm:address1"));
		address1.sendKeys(data.get("Address1"));
		Thread.sleep(3000);
		WebElement Continue = driver.findElement(By.name("identifyCustomerForm:submitB"));
		Continue.click();
	}

	public static void enterinventoryDetails(WebDriver driver, Map<Integer, Map<String, String>> data) throws AWTException, InterruptedException {
		Thread.sleep(3000);
		//inputForm:itemNum
		for (int i = 0; i < data.size(); i++) {
			WebElement InventoryItemNumber = driver.findElement(By.id("inputForm:itemNum"));
			InventoryItemNumber.sendKeys(data.get(i).get("Item_ID"));
			driver .findElement(By.id("inputForm:addItem")).click();
			//driver.findElement(By.id("inputForm:findInventoryOutboundRequestedItems:searchAvail")).click();
			//robot.keyPress(KeyEvent.VK_DOWN);
		}
		driver.findElement(By.id("inputInboundForm:submitBtn")).click();
		Thread.sleep(8000);
	}
	public static void enterRouteDetails(WebDriver driver, Map<Integer, Map<String, String>> data) throws AWTException, InterruptedException {

		for (int k = 0; k < data.size(); k++) {
			List<String> list = new ArrayList<String>();
			//need to add the total no of rows of service table
			for (int i = 0; i <= 8; i++) {
				WebElement s = driver.findElement(By.xpath("//*[@id=\"form1:routeOptions:0:scheduleOptions:" + i
						+ ":selSubGrid\"]/tbody/tr[1]/td[2]/span"));
				list.add(s.getText());
			}
			System.out.println(list);
			Thread.sleep(3000);
			for (int j = 0; j < list.size(); j++) {
				if ((list.get(j)).equalsIgnoreCase(data.get(k).get("ServiceName"))) {
					System.out.println(list.get(j));
					driver.findElement(By.xpath("//*[@id=\"form1:routeOptions:0:scheduleOptions:" + j
							+ ":selSchdOpt\"]/tbody/tr/td/label/input")).click();
					break;
				}
			} 
		}
		Thread.sleep(2000);
		driver.findElement(By.id( "form1:submit")).click();
	}

	public static void enterPlacementDetails(WebDriver driver, HashMap<String, String> data) throws AWTException, InterruptedException {
		Thread.sleep(3000);

		globalFunc.DateTime.TimeDateFunc();
		WebElement CustOrderNo= driver.findElement(By.id("form1:referenceFields:1:value"));
		CustOrderNo.sendKeys(data.get("CustomerPO#")+globalFunc.DateTime.strDate6);
		Thread.sleep(2000);
		driver.findElement(By.id("form1:submitPlacement")).click();
		Thread.sleep(6000);
	}
}


