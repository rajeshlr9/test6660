package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import entity.Items;
import utils.Driver;
import utils.SeleniumTestHelper;

public class TasksPage {
	WebDriver driver;
	
	
	
	public TasksPage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	HomePage homepage = new HomePage();
	
	@FindBy(xpath="//input[@type='text' and @id='dataForm:lview:filterId:field10value1']") public WebElement taskIdSearchField;
	@FindBy(xpath="//select[@id='dataForm:lview:filterId:field20value1']") public WebElement taskTypeDDL;
	@FindBy(xpath="//select[@id='dataForm:lview:filterId:field30value1']") public WebElement headerStatusDDL;
	@FindBy(xpath="//span[@id='dataForm:lview:dataTable:lsize' and .='Task ID']") public WebElement taskIDcolumn;
	@FindBy(xpath="(//table[@id='dataForm:lview:dataTable_body']/tbody/tr/td[2]/span[1])[1]") public WebElement firstTaskId;
	@FindBy(xpath="//input[@id='dataForm:lview:filterId:filterIdapply']") public WebElement applyBtn;
	@FindBy(xpath="//div[@id='page-content_footer-panel']/div/input[5]")   public WebElement cancelTaskBtn;
	@FindBy(xpath="//img[@class='x-tool-img x-tool-refresh']")             public WebElement refreshBtn;
		
	@FindBy(xpath="//*[contains(@name,'dataForm:lview:filterId:field30value1')]")
	public WebElement headerStatusDdl;
	@FindBy(xpath="//input[@title='Expand']")
	public WebElement expandButton;
	@FindBy(xpath="//input[@alt='Find Task generation reference number']")
	public WebElement Taskgenerationreferencenumber;
	@FindBy(xpath="//span[text()='Task Type:']//following::select[1]")
	public WebElement taskType;
	
	
	
	public void select_list(){
		Select sel = new Select(headerStatusDdl);
		sel.selectByVisibleText("Released");
	}
	
	@FindBy(xpath="//select[@id='dataForm:lview:filterId:field20value1']")
	public WebElement Task_Type_Drop;
	
	@FindBy(id="dataForm:lview:filterId:filterIdapply")
	public WebElement apply;
	
	@FindBy(xpath="//span[@id='dataForm:lview:dataTable:msg1s']")
	public WebElement Task_Type;

	@FindBy(xpath="//*[contains(text(),'System generated cycle count of active')]")
	public WebElement expectedText;

	@FindBy(xpath="//input[@type='button' and @id='rmButton_1View1_167271343']")
	public WebElement taskView;
	
	@FindBy(xpath="//a[@name='HeaderTab' and @id='HeaderTab_lnk']")
	public WebElement header;
	
	@FindBy(xpath="//span[@id='dataForm:itaskId']")
	public WebElement taskID;
	
	@FindBy(xpath="//span[@id='dataForm:oGValue']")
	public WebElement activePickLoc;
	
	@FindBy(xpath="//input[@id='checkAll_c0_dataForm:lview:dataTable' and @type='checkbox']")
	public WebElement checkBox;
	
	@FindBy(xpath="//input[@id='rmButton_1ReleaseTask1_167271344' and @type='button']")
	public WebElement releaseTask;
	
	@FindBy(xpath="//span[@id='dataForm:lview:dataTable:0:statusVal']")
	public WebElement headerStatus;
	
	@FindBy(xpath="//span[@id='dataForm:lview:dataTable:0:descVal1']")
	public WebElement recount_Active_Task;
	
	@FindBy(xpath="//input[@id='rmButton_1CancelTask1_167271347' and @type='button']")
	public WebElement cancel_Task;
	
	@FindBy(xpath="//input[@id='dataForm:lview:filterId:field10value1']")
	public WebElement task_ID_Box;
	
	@FindBy(xpath="//input[@value='View']") WebElement viewButton;
	@FindBy(xpath="//span[@id='dataForm:oGValue']") WebElement taskGenRefValue;
	@FindBy(xpath="//span[@id='dataForm:oSGroup']") WebElement workGroup;
	@FindBy(xpath="//input[@value='Cancel Task']") WebElement cancelTaskButton;
	@FindBy(xpath="//img[@id='backImage']") WebElement backBtn;
	
	public int get_count_of_Existing_Tasks(WebDriver driver) {
		
		SeleniumTestHelper.selectFromDropDown(headerStatusDDL, "Released", "visibletext");
		applyBtn.click();
		return driver.findElements(By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr")).size()-1;
		
	}
	
	public void task_ID_Select(String ExpectedTaskType) throws InterruptedException
	{
		if(SeleniumTestHelper.isElementDisplayed(driver.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//input[@type='checkbox']"))))
			
			driver.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//input[@type='checkbox']")).click();
	}
	
	public void recount_Active_task_ID(String ExpectedTaskType) throws InterruptedException
	{
		if(SeleniumTestHelper.isElementDisplayed(driver.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//input[@type='checkbox']"))))
			
			driver.findElement(By.xpath("//span[text()='" + ExpectedTaskType + "']/../..//input[@type='checkbox']")).click();
	}
	
	
	
	/*
		This method will cancel "Number" of tasks from the list	
	*/
	public void cancel_number_of_Tasks(WebDriver driver, int Number) {
		
		SeleniumTestHelper.selectFromDropDown(headerStatusDDL, "Released", "visibletext");
		applyBtn.click();
		taskIDcolumn.click();
		for(int i=1; i<=Number;i++) {
			String xpath = "(//table[@id='dataForm:lview:dataTable_body']/tbody/tr/td[1]/input[1])["+i+"]";
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
	
	//This method will get the Task status is complete or not 
	public void get_Task_Status(String expectedTaskstatus) throws Exception
	{
		
		// this is cheating and please fix it, see Zokir for "why cheating" question
		homepage.MenuItems_Configuration_Selection("Tasks");
		SeleniumTestHelper.switchToInnerFrame(driver);
		
		String a = Items.getTaskID();
		task_ID_Box.sendKeys(a);
		apply.click();
		String actualTaskstatus=driver.findElement(By.xpath("//span[text()='"+expectedTaskstatus+"']/../..//span[@id='dataForm:lview:dataTable:0:statusVal']")).getText();
		SeleniumTestHelper.assertEquals(actualTaskstatus, expectedTaskstatus);   
		homepage.userClosesOpenedwindow("Tasks");
		
	}
	
	public void check_Task_location_ID(int numberOfTasks){
		driver.switchTo().frame(0);
		SeleniumTestHelper.selectFromDropDown(headerStatusDDL, "Released", "visibletext");
		String ActualLocationID  = null;
		String excpectedLocatinID = null;
		applyBtn.click();
		taskIDcolumn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 5);
		SeleniumTestHelper.assertTrue(checkBox.isEnabled());
		for(int i = 0; i<numberOfTasks; i++){
			checkBox.click();
			viewButton.click();
			header.click();
			SeleniumTestHelper.WaitForElement(taskGenRefValue, 5);
			taskGenRefValue.click();
			ActualLocationID = taskGenRefValue.getText().replaceAll("-", "").trim();
			/*if(ActualLocationID.startsWith("R")){
				excpectedLocatinID = Items.getRecerveLocation().replaceAll("-", "").trim();
			}else if(ActualLocationID.startsWith("A")){
				excpectedLocatinID = Items.getActiveLocation().replaceAll("-", "").trim();
			}else if(ActualLocationID.startsWith("C")){
				excpectedLocatinID = Items.getCasePickLocation().replaceAll("-", "").trim();
			}*/
			System.out.println("ACtual loca: " + ActualLocationID);
			SeleniumTestHelper.assertEquals(ActualLocationID, excpectedLocatinID);
			cancelTaskBtn.sendKeys(Keys.ENTER +""+ Keys.ENTER);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.switchTo().alert().accept();
			
		}
	}
	
	public void getLastTaskID(String locationClass) throws InterruptedException{
		
		SeleniumTestHelper.switchToInnerFrame(driver);
		/*SeleniumTestHelper.waitForElementToBeDisplayed(driver, headerStatusDDL, 20);
		SeleniumTestHelper.selectFromDropDown(headerStatusDDL,"Released", "visibletext");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtn, 20);
		applyBtn.click();*/
		/*driver.switchTo().defaultContent();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, refreshBtn, 20);
		refreshBtn.click();
		driver.switchTo().frame(0);*/
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, expandButton, 20);
		expandButton.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, Taskgenerationreferencenumber, 20);
		
		if(locationClass.equalsIgnoreCase("Reserve"))
		{
			Taskgenerationreferencenumber.sendKeys(Items.getRlocation_one().trim());
			SeleniumTestHelper.selectFromDropDown(taskType,"Sys generated CC from resv", "visibletext");
		}
		else if(locationClass.equalsIgnoreCase("Active"))
		{
			Taskgenerationreferencenumber.sendKeys(Items.getLocationBarCodewithunderscore().trim());
			SeleniumTestHelper.selectFromDropDown(taskType,"System generated cycle count of active", "visibletext");
		}
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, headerStatusDDL, 20);
		SeleniumTestHelper.selectFromDropDown(headerStatusDDL,"Released", "visibletext");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtn, 20);
		applyBtn.click();	
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskIDcolumn, 50);
		taskIDcolumn.click();
		Thread.sleep(2000);
		WebElement firstTaskId = driver.findElement(By.xpath("(//table[@id='dataForm:lview:dataTable_body']/tbody/tr/td[2]/span[1])[1]"));
		Items.setTaskID(firstTaskId.getText());
		System.out.println("Task ID Created: "+ Items.getTaskID());
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
		String expectedLoationID =null;
		//tbody[@id='a']//tr[2]//span[contains(text(),'some Text')]
		//table[@id='dataForm:igl1']//..//select[@id='dataForm:primaryList']"
		
		System.out.println("RSV" + workGroup.getText());
			
		if(workGroup.getText().contains("RSV")){
			expectedLoationID = Items.getRlocation_one().replaceAll("-", "").trim();
		}else if(workGroup.getText().contains("ACT")){
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
	
	public void verify_task_ID_status(String taskID, String expeted_status){
		
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskIdSearchField, 5);
		taskIdSearchField.clear();
		taskIdSearchField.sendKeys(taskID);
		applyBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, headerStatus, 5);
		SeleniumTestHelper.assertEquals(headerStatus.getText(),expeted_status);
		driver.switchTo().defaultContent();
	}
	
	public void cancelLastTaskID(String TaskID) throws InterruptedException{
		
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
	
	
    public String getLatestTaskID() throws InterruptedException{
		
		SeleniumTestHelper.switchToInnerFrame(driver);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, headerStatusDDL, 20);
		SeleniumTestHelper.selectFromDropDown(headerStatusDDL,"Released", "visibletext");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, applyBtn, 20);
		applyBtn.click();
		driver.switchTo().defaultContent();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, refreshBtn, 20);
		refreshBtn.click();
		driver.switchTo().frame(0);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, taskIDcolumn, 50);
		taskIDcolumn.click();
		Thread.sleep(2000);
		WebElement firstTaskId = driver.findElement(By.xpath("(//table[@id='dataForm:lview:dataTable_body']/tbody/tr/td[2]/span[1])[1]"));
		Items.setTaskID(firstTaskId.getText());
		System.out.println("Task ID Created: "+ Items.getTaskID());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 50);
		checkBox.click();
		SeleniumTestHelper.assertTrue(viewButton.isDisplayed());
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, viewButton, 50);
		viewButton.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, header, 5);
		header.click();
		//SeleniumTestHelper.WaitForElement(taskGenRefValue, 5);
		//taskGenRefValue.click();
		//SeleniumTestHelper.assertEquals(taskGenRefValue.getText().replaceAll("-", ""),Items.getRlocation_one());
		backBtn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, checkBox, 5);
		return Items.getTaskID();

	}
	
}
