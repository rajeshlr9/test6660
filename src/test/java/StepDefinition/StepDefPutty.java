package StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefPutty {

	@Given("Open Putty")
	public void openPutty() {
		try {
			new ProcessBuilder("E:\\putty.exe").start();
			Steps.logger.info("Putty Opened");
		} catch (IOException e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
		}
	}
	
	@When("user login to Putty")
	public void puttyLogin() throws Throwable {
		try {
			reusable.LeanFtInitialize.initializeLeanFt();
			reusable.PuttyLogin.puttyLogin();
			Steps.logger.info("Putty Login successfull");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
		}
	}
	
	@And("Complete adhoc move")
	public void performAdhocmove(DataTable usercredentials) throws Throwable {
		try {
			reusable.AdhocMove.adhocMove(usercredentials, Steps.winApp);
			Steps.logger.info("Adhocmove completed");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			e.printStackTrace();
		}
	}
	
	@Then("Items are moved successfully")
	public void adhocmoveValidation() throws IOException {
		try {
			Runtime rt = Runtime.getRuntime();
			rt.exec("taskkill /F /IM putty.exe");
			System.out.println("adhoc move completed");
			Steps.logger.info("Putty closed");
		} catch (Exception e) {
			Steps.testRes = "Failed";
			Assert.assertTrue(false);
			e.printStackTrace();
		}
	}
}
