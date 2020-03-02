package StepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class StepDefOMS {

	WebDriver seleniumDriver=Steps.seleniumDriver;
	
	@And("Login to OMS using Selenium")
	public void OMSLogin() throws Throwable {
		try {
			reusable.OMSLogin.loginOMS();
			Steps.logger.info("OMS Login successfull");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println("test red"+Steps.testRes);
			e.printStackTrace();
		}
	}
	
	@And("Click on search Order using selenium")
	public void searchClick() {
		try {
			Thread.sleep(15000);
			seleniumDriver.findElement(By.id("ulaitem0_3")).click();
			seleniumDriver.findElement(By.id("orderSearchform:orderNumber")).sendKeys("9860217");
			seleniumDriver.findElement(By.id("orderSearchform:searchDetails")).click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
		}
	}
	
	@And("Search for the dropped order using Selenium")
	public void searchOrder() throws Throwable {
		try {
			Thread.sleep(12000);
			seleniumDriver.findElement(By.id("ulaitem0_3")).click();
			seleniumDriver.findElement(By.id("orderSearchform:custRef")).sendKeys("EMC" + globalFunc.DateTime.strDate6);
			seleniumDriver.findElement(By.id("orderSearchform:searchDetails")).click();
			Thread.sleep(8000);
			Steps.logger.info("Order present in O2S");
		} catch (InterruptedException e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
		}
	}

	
	@And("Resume the incomplete order using Selenium")
	public void resumeOrder() throws Throwable {

		try {
			System.out.println("Resume Order");
			seleniumDriver.findElement(By.xpath("//TBODY[@id=\"orderSearchform:resultTable:tbody_element\"]/TR[1]/TD[1]/A[1]/SPAN[1]"))
			.click();
			Thread.sleep(12000);
			if (seleniumDriver.findElement(By.id("identifyCustomerForm:callerIdNumber")).getText().equals("")) {
				seleniumDriver.findElement(By.id("identifyCustomerForm:callerIdNumber")).sendKeys("123456");
				seleniumDriver.findElement(By.id("identifyCustomerForm:pageTitle")).click();
			}
			Thread.sleep(5000);

			seleniumDriver.findElement(By.id("identifyCustomerForm:submitT")).click();
			Thread.sleep(5000);

			seleniumDriver.findElement(By.id("inputForm:submitInv")).click();
			Thread.sleep(5000);

			seleniumDriver.findElement(By.id("form1:submit2")).click();
			Thread.sleep(10000);
			seleniumDriver.findElement(By.id("form1:requestedDeliveryLatest")).clear();

			globalFunc.DateTime.TimeDateFunc();
			String date = globalFunc.DateTime.strDate4;
			seleniumDriver.findElement(By.id("form1:requestedDeliveryLatest")).sendKeys(date);

			seleniumDriver.findElement(By.id("form1:filter")).click();
			Thread.sleep(5000);

			seleniumDriver.findElement(By.xpath(
					"//TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[3]/TBODY[1]/TR[1]/TD[3]/FORM[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/TABLE[1]/TBODY[1]/TR[6]/TD[1]/TABLE[3]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[3]/TBODY[1]/TR[1]/TD[1]/DIV[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/LABEL[1]/INPUT[1]"))
			.click();

			seleniumDriver.findElement(By.id("form1:submit2")).click();
			Thread.sleep(7000);

			seleniumDriver.findElement(By.id("form1:submitPlacement")).click();
			Thread.sleep(5000);
			Steps.logger.info("Order resumed successfully");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			Assert.fail("WebDriver couldnâ€™t locate the element");
			seleniumDriver.close();
		}
	}

	@And("Add destination Details")
	public void AddDestDetails() throws IOException, AWTException, InterruptedException {
		try {
			reusable.OMSOrderCreation.enterdestinationDetails(Steps.seleniumDriver, Steps.hmap);
		} catch (Exception e) {
			e.printStackTrace();
			Steps.testRes = "Failed";
			Assert.assertTrue(false);
		}
		
	}
	@And("Add Inventory Details")
	public void AddInventoryDetails() throws AWTException, InterruptedException {
		try {
			reusable.OMSOrderCreation.enterinventoryDetails(Steps.seleniumDriver, Steps.ItemDataMap);
		} catch (Exception e) {
			e.printStackTrace();
			Steps.testRes = "Failed";
			Assert.assertTrue(false);
		}

}
	@And("Enter Route Details")
	public void enterRouteDetails() throws AWTException, InterruptedException {
		try {
			reusable.OMSOrderCreation.enterRouteDetails(Steps.seleniumDriver, Steps.ServiceMap);
		} catch (Exception e) {
			e.printStackTrace();
			Steps.testRes = "Failed";
			Assert.assertTrue(false);
		}
	}
	@And("Enter Placement Details")
	public void enterPlacementDetails() throws AWTException, InterruptedException {
		try {
			reusable.OMSOrderCreation.enterPlacementDetails(Steps.seleniumDriver, Steps.hmap);
		} catch (Exception e) {
			e.printStackTrace();
			Steps.testRes = "Failed";
			Assert.assertTrue(false);
		}
	}
	
	@Then("Order is placed successfully")
	public void orderCreationValidation() throws Throwable {
		try {
			String expected = seleniumDriver.findElement(By.xpath(
					"//TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[3]/TBODY[1]/TR[1]/TD[2]/FORM[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/TABLE[1]/TBODY[1]/TR[4]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/SPAN[1]"))
					.getText();
			String actual = "Thank you for shipping with FedEx. Your shipment number is";

			if (expected.equals(actual)) {
				String orderno = seleniumDriver.findElement(By.id("form1:orderNum")).getText();
				System.out.println("order created " + orderno);
				Steps.logger.info("Order is placed successfully");
			} else {
				System.out.println("order not created ");
			}
			
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
		}
	}
}
