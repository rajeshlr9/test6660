package pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import entity.Items;
import globalFunc.Screenshots;
import utils.Driver;
import utils.SeleniumTestHelper;

public class TasksPage {
	WebDriver driver;

	public TasksPage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

	HomePage homepage = new HomePage();
	public static String tasks[];
	public static String tasksType[] ;
	public static String tasksStatus[];
	public static String oLPNs[];

	@FindBy(xpath = "//input[@type='text' and @id='dataForm:lview:filterId:field10value1']")
	public WebElement taskIdSearchField;
	@FindBy(xpath = "//select[@id='dataForm:lview:filterId:field20value1']")
	public WebElement taskTypeDDL;
	@FindBy(xpath = "//select[@id='dataForm:lview:filterId:field30value1']")
	public WebElement headerStatusDDL;
	@FindBy(xpath = "//span[@id='dataForm:lview:dataTable:lsize' and .='Task ID']")
	public WebElement taskIDcolumn;
	@FindBy(xpath = "(//table[@id='dataForm:lview:dataTable_body']/tbody/tr/td[2]/span[1])[1]")
	public WebElement firstTaskId;
	@FindBy(xpath = "//input[@id='dataForm:lview:filterId:filterIdapply']")
	public WebElement applyBtn;
	@FindBy(id = "dataForm:lview:dataTable:0:statusVal")
	public WebElement taskStatus;
	
	@FindBy(xpath = "//div[@id='page-content_footer-panel']/div/input[5]")
	public WebElement cancelTaskBtn;
	@FindBy(xpath = "//img[@class='x-tool-img x-tool-refresh']")
	public WebElement refreshBtn;

	@FindBy(xpath = "//input[@type='checkbox' and @name='dataForm:lview:dataTable_checkAll']")
	public WebElement selectAllCheckbx;
	@FindBy(xpath = "//input[@type='B=button' and @id='rmButton_1View1_167271343']")
	public WebElement viewBtn;

	@FindBy(xpath = "//*[contains(@name,'dataForm:lview:filterId:field30value1')]")
	public WebElement headerStatusDdl;
	@FindBy(xpath = "//input[@title='Expand']")
	public WebElement expandButton;
	@FindBy(id = "as_bas1_in")
	public WebElement FromDate;
	@FindBy(id = "as_bas2_in")
	public WebElement TODate;
	@FindBy(id = "dataForm:lview:filterId:field40value1")
	public WebElement waveNoinputBox;
	@FindBy(id = "dataForm:lview:filterId:field90value1")
	public WebElement orderNoinputBox;
	@FindBy(xpath = "//input[@alt='Find Task generation reference number']")
	public WebElement Taskgenerationreferencenumber;
	@FindBy(xpath = "//span[text()='Task Type:']//following::select[1]")
	public WebElement taskType;

	public void select_list() {
		Select sel = new Select(headerStatusDdl);
		sel.selectByVisibleText("Released");
	}

	@FindBy(xpath = "//select[@id='dataForm:lview:filterId:field20value1']")
	public WebElement Task_Type_Drop;

	@FindBy(id = "dataForm:lview:filterId:filterIdapply")
	public WebElement apply;

	@FindBy(xpath = "//span[@id='dataForm:lview:dataTable:msg1s']")
	public WebElement Task_Type;

	@FindBy(xpath = "//*[contains(text(),'System generated cycle count of active')]")
	public WebElement expectedText;

	@FindBy(xpath = "//input[@type='button' and @id='rmButton_1View1_167271343']")
	public WebElement taskView;

	@FindBy(xpath = "//a[@name='HeaderTab' and @id='HeaderTab_lnk']")
	public WebElement header;

	@FindBy(xpath = "//span[@id='dataForm:itaskId']")
	public WebElement taskID;

	@FindBy(xpath = "//span[@id='dataForm:oGValue']")
	public WebElement activePickLoc;

	@FindBy(xpath = "//input[@id='checkAll_c0_dataForm:lview:dataTable' and @type='checkbox']")
	public WebElement checkBox;

	@FindBy(xpath = "//input[@id='rmButton_1ReleaseTask1_167271344' and @type='button']")
	public WebElement releaseTask;

	@FindBy(xpath = "//span[@id='dataForm:lview:dataTable:0:statusVal']")
	public WebElement headerStatus;

	@FindBy(xpath = "//span[@id='dataForm:lview:dataTable:0:descVal1']")
	public WebElement recount_Active_Task;

	@FindBy(xpath = "//input[@id='rmButton_1CancelTask1_167271347' and @type='button']")
	public WebElement cancel_Task;

	@FindBy(xpath = "//input[@id='dataForm:lview:filterId:field10value1']")
	public WebElement task_ID_Box;

	@FindBy(xpath = "//input[@value='View']")
	WebElement viewButton;
	@FindBy(xpath = "//span[@id='dataForm:oGValue']")
	WebElement taskGenRefValue;
	@FindBy(xpath = "//span[@id='dataForm:oSGroup']")
	WebElement workGroup;
	@FindBy(xpath = "//input[@value='Cancel Task']")
	WebElement cancelTaskButton;
	@FindBy(xpath = "//img[@id='backImage']")
	WebElement backBtn;

	public int get_count_of_Existing_Tasks(WebDriver driver) {

		SeleniumTestHelper.selectFromDropDown(headerStatusDDL, "Released", "visibletext");
		applyBtn.click();
		return driver.findElements(By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr")).size() - 1;

	}

	public void task_ID_Select(String ExpectedTaskType) throws InterruptedException {
		if (SeleniumTestHelper.isElementDisplayed(driver
				.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//input[@type='checkbox']"))))

			driver.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//input[@type='checkbox']"))
					.click();
	}

	public void recount_Active_task_ID(String ExpectedTaskType) throws InterruptedException {
		if (SeleniumTestHelper.isElementDisplayed(driver
				.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//input[@type='checkbox']"))))

			driver.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//input[@type='checkbox']"))
					.click();
	}

	/*
	 * This method will cancel "Number" of tasks from the list
	 */
	public void cancel_number_of_Tasks(WebDriver driver, int Number) {

		SeleniumTestHelper.selectFromDropDown(headerStatusDDL, "Released", "visibletext");
		applyBtn.click();
		taskIDcolumn.click();
		for (int i = 1; i <= Number; i++) {
			String xpath = "(//table[@id='dataForm:lview:dataTable_body']/tbody/tr/td[1]/input[1])[" + i + "]";
			driver.findElement(By.xpath(xpath)).click();
		}

		cancelTaskBtn.sendKeys(Keys.ENTER);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.switchTo().alert().accept();

	}

	// This method will get the Task status is complete or not
	public void get_Task_Status(String expectedTaskstatus) throws Exception {

		// this is cheating and please fix it, see Zokir for "why cheating" question
		homepage.MenuItems_Configuration_Selection("Tasks");
		SeleniumTestHelper.switchToInnerFrame(driver);

		String a = Items.getTaskID();
		task_ID_Box.sendKeys(a);
		apply.click();
		String actualTaskstatus = driver.findElement(By.xpath(
				"//span[text()='" + expectedTaskstatus + "']/../..//span[@id='dataForm:lview:dataTable:0:statusVal']"))
				.getText();
		SeleniumTestHelper.assertEquals(actualTaskstatus, expectedTaskstatus);
		homepage.userClosesOpenedwindow("Tasks");

	}

	public void check_Task_location_ID(int numberOfTasks) {
		driver.switchTo().frame(0);
		SeleniumTestHelper.selectFromDropDown(headerStatusDDL, "Released", "visibletext");
		String ActualLocationID = null;
		String excpectedLocatinID = null;
		applyBtn.click();
		taskIDcolumn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 5);
		SeleniumTestHelper.assertTrue(checkBox.isEnabled());
		for (int i = 0; i < numberOfTasks; i++) {
			checkBox.click();
			viewButton.click();
			header.click();
			SeleniumTestHelper.WaitForElement(taskGenRefValue, 5);
			taskGenRefValue.click();
			ActualLocationID = taskGenRefValue.getText().replaceAll("-", "").trim();
			/*
			 * if(ActualLocationID.startsWith("R")){ excpectedLocatinID =
			 * Items.getRecerveLocation().replaceAll("-", "").trim(); }else
			 * if(ActualLocationID.startsWith("A")){ excpectedLocatinID =
			 * Items.getActiveLocation().replaceAll("-", "").trim(); }else
			 * if(ActualLocationID.startsWith("C")){ excpectedLocatinID =
			 * Items.getCasePickLocation().replaceAll("-", "").trim(); }
			 */
			System.out.println("ACtual loca: " + ActualLocationID);
			SeleniumTestHelper.assertEquals(ActualLocationID, excpectedLocatinID);
			cancelTaskBtn.sendKeys(Keys.ENTER + "" + Keys.ENTER);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.switchTo().alert().accept();

		}
	}

	public void getLastTaskID(String locationClass) throws InterruptedException {

		SeleniumTestHelper.switchToInnerFrame(driver);
		/*
		 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, headerStatusDDL, 20);
		 * SeleniumTestHelper.selectFromDropDown(headerStatusDDL,"Released",
		 * "visibletext"); SeleniumTestHelper.waitForElementToBeDisplayed(driver,
		 * applyBtn, 20); applyBtn.click();
		 */
		/*
		 * driver.switchTo().defaultContent();
		 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, refreshBtn, 20);
		 * refreshBtn.click(); driver.switchTo().frame(0);
		 */
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandButton, 20);
		expandButton.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Taskgenerationreferencenumber, 20);

		if (locationClass.equalsIgnoreCase("Reserve")) {
			Taskgenerationreferencenumber.sendKeys(Items.getRlocation_one().trim());
			SeleniumTestHelper.selectFromDropDown(taskType, "Sys generated CC from resv", "visibletext");
		} else if (locationClass.equalsIgnoreCase("Active")) {
			Taskgenerationreferencenumber.sendKeys(Items.getLocationBarCodewithunderscore().trim());
			SeleniumTestHelper.selectFromDropDown(taskType, "System generated cycle count of active", "visibletext");
		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, headerStatusDDL, 20);
		SeleniumTestHelper.selectFromDropDown(headerStatusDDL, "Released", "visibletext");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtn, 20);
		applyBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskIDcolumn, 50);
		taskIDcolumn.click();
		Thread.sleep(2000);
		WebElement firstTaskId = driver
				.findElement(By.xpath("(//table[@id='dataForm:lview:dataTable_body']/tbody/tr/td[2]/span[1])[1]"));
		Items.setTaskID(firstTaskId.getText());
		System.out.println("Task ID Created: " + Items.getTaskID());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 50);
		checkBox.click();
		SeleniumTestHelper.assertTrue(viewButton.isDisplayed());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewButton, 50);
		viewButton.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, header, 5);
		header.click();
		SeleniumTestHelper.WaitForElement(taskGenRefValue, 5);
		taskGenRefValue.click();
		String ActualLocationID = taskGenRefValue.getText().replaceAll("-", "").trim();
		String expectedLoationID = null;
		// tbody[@id='a']//tr[2]//span[contains(text(),'some Text')]
		// table[@id='dataForm:igl1']//..//select[@id='dataForm:primaryList']"

		System.out.println("RSV" + workGroup.getText());

		if (workGroup.getText().contains("RSV")) {
			expectedLoationID = Items.getRlocation_one().replaceAll("-", "").trim();
		} else if (workGroup.getText().contains("ACT")) {
			expectedLoationID = Items.getALocation_one().replaceAll("-", "").trim();
		}

//		if(ActualLocationID.startsWith("R")){
//			expectedLoationID = Items.getRlocation_one().replaceAll("-", "").trim();
//		}else if(ActualLocationID.startsWith("A")){
//			expectedLoationID = Items.getALocation_one().replaceAll("-", "").trim();
//		}
		SeleniumTestHelper.assertEquals(ActualLocationID, expectedLoationID);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, backBtn, 5);
		backBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 5);
	}

	public void verify_task_ID_status(String taskID, String expeted_status) {

		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskIdSearchField, 5);
		taskIdSearchField.clear();
		taskIdSearchField.sendKeys(taskID);
		applyBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, headerStatus, 5);
		SeleniumTestHelper.assertEquals(headerStatus.getText(), expeted_status);
		driver.switchTo().defaultContent();
	}

	public void cancelLastTaskID(String TaskID) throws InterruptedException {

		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, task_ID_Box, 5);
		task_ID_Box.sendKeys(TaskID);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, apply, 5);
		apply.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 50);
		checkBox.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, cancelTaskBtn, 50);
		cancelTaskBtn.click();
	}

	public String getLatestTaskID() throws InterruptedException {

		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, headerStatusDDL, 20);
		SeleniumTestHelper.selectFromDropDown(headerStatusDDL, "Released", "visibletext");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtn, 20);
		applyBtn.click();
		driver.switchTo().defaultContent();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, refreshBtn, 20);
		refreshBtn.click();
		driver.switchTo().frame(0);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskIDcolumn, 50);
		taskIDcolumn.click();
		Thread.sleep(2000);
		WebElement firstTaskId = driver
				.findElement(By.xpath("(//table[@id='dataForm:lview:dataTable_body']/tbody/tr/td[2]/span[1])[1]"));
		Items.setTaskID(firstTaskId.getText());
		System.out.println("Task ID Created: " + Items.getTaskID());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 50);
		checkBox.click();
		SeleniumTestHelper.assertTrue(viewButton.isDisplayed());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewButton, 50);
		viewButton.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, header, 5);
		header.click();
		// SeleniumTestHelper.WaitForElement(taskGenRefValue, 5);
		// taskGenRefValue.click();
		// SeleniumTestHelper.assertEquals(taskGenRefValue.getText().replaceAll("-",
		// ""),Items.getRlocation_one());
		backBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 5);
		return Items.getTaskID();

	}

	public void getTaskDetails() throws Exception {
		homepage.MenuItems_Configuration_Selection("Tasks");
		Screenshots.captureSnapshot(driver);
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandButton, 10);
		expandButton.click();

		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		/*
		 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, FromDate, 10);
		 * FromDate.sendKeys("Today");
		 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, TODate, 10);
		 * Screenshots.captureSnapshot(driver); TODate.sendKeys("Today");
		 */
		/*
		 * SeleniumTestHelper.waitForElementToBeDisplayed(driver, waveNoinputBox, 10);
		 * Screenshots.captureSnapshot(driver);
		 * waveNoinputBox.sendKeys(Items.getWaveNumber());
		 */
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, orderNoinputBox, 10);
		Screenshots.captureSnapshot(driver);
		orderNoinputBox.sendKeys(Items.getDONumber());
		Thread.sleep(1000);
		Screenshots.captureSnapshot(driver);
		applyBtn.click();
		Thread.sleep(4000);
		Screenshots.captureSnapshot(driver);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr"));
		int count = rows.size();
		System.out.println("Total no of tasks : " + (count-1));

		Thread.sleep(1000);
		if(count==1) {
			Steps.logger.info("No tasks generated");
			Reporter.addStepLog("No tasks generated");
			Steps.testRes = "Failed";
			Assert.assertTrue(false);
		}

		tasks = new String[count-1];
		 tasksType = new String[count-1];
		 tasksStatus = new String[count-1];
		
		for (int i = 0; i < count-1; i++) {
			tasks[i] = driver.findElement(By.id("dataForm:lview:dataTable:" + i + ":taskIdVal")).getText();
			tasksType[i]= driver.findElement(By.id("dataForm:lview:dataTable:" + i + ":descVal1")).getText();
			tasksStatus[i]= driver.findElement(By.id("dataForm:lview:dataTable:" + i + ":statusVal")).getText();
		}

		for (int i = 0; i < tasks.length; i++) {
			SeleniumTestHelper.assertEquals(tasksStatus[i], "10 - Released");
			System.out.println("Tasks ID created for DO: " + tasks[i]);
			System.out.println("Task \""+ tasks[i]+ "\" is having status as \""+ tasksStatus[i] +"\" and task type is \""+ tasksType[i]+"\"" );
			Steps.logger.info("Tasks ID created for DO: " + tasks[i]);
			Steps.logger.info("Task \""+ tasks[i]+ "\" is having status as \""+ tasksStatus[i] +"\" and task type is \""+ tasksType[i]+"\"");
			Reporter.addStepLog("Tasks ID created for DO: " + tasks[i]);
			Reporter.addStepLog("Task \""+ tasks[i]+ "\" is having status as \""+ tasksStatus[i] +"\" and task type is \""+ tasksType[i]+"\"");
		}
		Steps.logger.info("Tasks generated successfully");
		Reporter.addStepLog("Tasks generated successfully");
		homepage.userClosesOpenedwindow("Tasks");
	}

	public void validateTaks() throws Exception {
		for (int i = 0; i < tasks.length; i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskIdSearchField, 10);
			taskIdSearchField.clear();
			Thread.sleep(1000);
			taskIdSearchField.sendKeys(tasks[i]);
			Screenshots.captureSnapshot(driver);
			Thread.sleep(1000);
			applyBtn.click();
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskStatus, 10);
			String actualtaskStatus= taskStatus.getText();
			SeleniumTestHelper.assertEquals(actualtaskStatus, "90 - Complete", "Status of the task id "+tasks[i]);
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Task status is: " + actualtaskStatus);
			Reporter.addStepLog("Task status is: " + actualtaskStatus);
		}
		homepage.userClosesOpenedwindow("Tasks");
	}
	
	public void validateSingleTask() throws Exception {
		for (int i = 0; i <1; i++) {
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskIdSearchField, 10);
			taskIdSearchField.clear();
			Thread.sleep(1000);
			taskIdSearchField.sendKeys(tasks[i]);
			Screenshots.captureSnapshot(driver);
			Thread.sleep(1000);
			applyBtn.click();
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskStatus, 10);
			String actualtaskStatus= taskStatus.getText();
			SeleniumTestHelper.assertEquals(actualtaskStatus, "90 - Complete", "Status of the task id "+tasks[i]);
			Thread.sleep(2000);
			Screenshots.captureSnapshot(driver);
			Steps.logger.info("Task status is: " + actualtaskStatus);
			Reporter.addStepLog("Task status is: " + actualtaskStatus);
		}
		homepage.userClosesOpenedwindow("Tasks");
	}
}
