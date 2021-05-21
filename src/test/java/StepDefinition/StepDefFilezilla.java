package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class StepDefFilezilla {

	@Given("Open Filezilla")
	public void LaunchFilezilla() throws Throwable {
		try {
			new ProcessBuilder("C:\\Program Files (x86)\\FileZilla FTP Client\\filezilla.exe").start();
			Thread.sleep(3000);
			Steps.logger.info("FileZilla Opened");
		}catch(Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
		}
	}

	@When("user connects to EMC customer and drop an OB order")
	public void orderUpload() throws Throwable {
		try {
			//scenario.write("Enterprise code-");
			reusable.LeanFtInitialize.initializeLeanFt();
			System.out.println("leanft initialized");
			//reusable.ModifyXML.ModifyFile();
			reusable.Filezilla.uploadOrder();
			Steps.logger.info("Order is dropped successfully");
		}catch(Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
		}
	}
}
