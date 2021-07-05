package pages;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import StepDefinition.StepDefOutBound;
import StepDefinition.Steps;
import entity.Items;
import globalFunc.Screenshots;
import utils.Driver;
import utils.SeleniumTestHelper;

public class ShipmentPlanningWorkspace extends StepDefOutBound{
public WebDriver driver;
	
	public ShipmentPlanningWorkspace() {
		
			this.driver = Steps.seleniumDriver;
			PageFactory.initElements(driver, this);

		}

	
	
	
	@FindBy(xpath= "//*[@id='combobox-2053-inputWrap']/div")
	public WebElement PrimaryField;
	
	
	@FindBy(xpath = "//input[@name='DistributionorderID']")
	public WebElement TCShipmentID;
     
	@FindBy(xpath = "//*[@id='mpslookupfield-2583-inputEl']")
	public WebElement DistIDInput;
	
	@FindBy(xpath ="//*[@id='button-1109-btnInnerEl']")
	public WebElement ApplyBtn;
	
	@FindBy(xpath = "//tr[@class='  x-grid-row']//td//div[@class='x-grid-row-checker']")
	public WebElement distributionOrder_chkbox;
	
	@FindBy(xpath = "//*[@id='gridview-1490-record-10437']/tbody/tr/td[1]/div/div")
	public WebElement QscCheckBox;
	
	@FindBy(css ="#menuitem-4437-itemEl")
	public WebElement Single;
	
	@FindBy(xpath = "//tr[@class='  x-grid-row']//td[4]//div[@class='x-grid-cell-inner ']")
	public WebElement ShipmentNumber;
	
	//Shipments Page
	
	@FindBy(xpath = "//*[@id='combobox-1777-inputEl']")
	public WebElement PrimaryFieldShipments;
	
	@FindBy(xpath = "//input[@name='TCShipmentID']")
	public WebElement TCShipmentID1;
	
	@FindBy(xpath ="//*[@id='button-1713-btnInnerEl']")
	public WebElement ApplyShipmentsBtn;
	
	@FindBy(xpath ="//tr[@class='  x-grid-row']//td[4]//div[@class='x-grid-cell-inner ']")
	public WebElement ShipmentStatus;
	
	@FindBy(xpath = "//tr[@class='  x-grid-row']//td//div[@class='x-grid-row-checker']")
	public WebElement shipmentID_chkbox;
	
	@FindBy(xpath ="//*[@id='gridview-1369-record-6048']/tbody/tr/td[1]/div/div")
	public WebElement ShipmentCheckBox;
	
	@FindBy(xpath ="//span[text()='Edit']")
	public WebElement EditShipment;
	
	//@FindBy(xpath="//*[@id=\"dataForm:ShpEdtGen_InText_PRONo\"]")
	@FindBy(xpath="//span[contains(text(),'PRO')]//parent::td//following-sibling::td[1]//input")
	public WebElement ProNumber;
	
	@FindBy(xpath ="//*[@id='dataForm:ShipEdit_CB_Save']")
	public WebElement Save;
	
	@FindBy(xpath ="//*[@id='backImage']")
	public WebElement EditShipmentsBack;
	
	@FindBy(xpath ="//*[@id='tool-2982-toolEl']")
	public WebElement EditShipmentsClose;
	
	@FindBy(xpath ="//*[@id='button-1382-btnIconEl']")
	public WebElement Refresh;
	
	@FindBy(xpath ="//span[text()='More']")
	//@FindBy(xpath="//span[@class='x-btn-inner x-btn-inner-default-small ' and @data-ref='btnInnerEl']")
	public WebElement MoreShipment;
	
	@FindBy(xpath="//div[@class='x-box-inner x-box-scroller-body-vertical']//descendant::span[contains(text(),'Close')]")
	public WebElement CloseMoreShipment;
	
	@FindBy(xpath="//div[@id='dataForm:closeShipmentTable_bodyDiv']/table/tbody/tr/td[9]/input")
	public WebElement printbolbox;
	
	@FindBy(xpath="//div[@id='dataForm:closeShipmentTable_bodyDiv']/table/tbody/tr/td[12]/input")
	public WebElement invoiceTrailerbox;
	
	@FindBy(xpath="//span[contains(@class,'x-tbar-loading')]")
	public WebElement refreshBtn;
	
	
	DistributionOrdersPage distributionOrdersPage1 = new DistributionOrdersPage();
	static String shipno;
	
	
	public void Ship()throws Exception{
		
		
		HomePage homepage=new HomePage();
		Thread.sleep(3000);
		distributionOrdersPage1.primaryField.sendKeys("Distribution Order");
		TCShipmentID.click();
		TCShipmentID.sendKeys(Items.getDONumber());
		//TCShipmentID.sendKeys("210628135320");
		Thread.sleep(2000);		
		distributionOrdersPage1.apply_Btn.click();		
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrder_chkbox, 50);
		distributionOrder_chkbox.click();	
		System.out.println("done1");
		Thread.sleep(5000);	
		
		WebElement ele = driver.findElement(By.cssSelector(".x-grid-cell.x-grid-td.x-grid-cell-businessUnit"));
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ele, 50);
		// right - click
		Actions actions = new Actions(driver);
		
		//actions.contextClick(distributionOrder_chkbox).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		actions.contextClick(ele).build().perform();
		Thread.sleep(5000);
		
		WebElement ele1 = driver.findElement(By.cssSelector(".x-menu-item-text.x-menu-item-text-default.x-menu-item-indent"));		
		//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-menu  x-layer x-menu-default x-border-box']//descendant::span[@class='x-menu-item-text x-menu-item-text-default x-menu-item-indent'])[6]"))).click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, ele1, 50);
		if(ele1.isDisplayed()) {
			ele1.click();
		}
		Thread.sleep(3000);
		System.out.println("done2");
		//Get the shipment number	
		shipno = ShipmentNumber.getText();
		System.out.println("Shipment Number is:" +shipno);
		Thread.sleep(3500);
		homepage.user_closes_openedwindow("Shipment Planning Workspace");
	
		
		//Navigate to Shipments Page
		homepage.MenuItems_Distribution_Selection("Shipments");
		Thread.sleep(3500);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, distributionOrdersPage1.primaryField, 80);
		distributionOrdersPage1.primaryField.sendKeys("Shipment");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, TCShipmentID1, 50);
		TCShipmentID1.click();
		TCShipmentID1.sendKeys(shipno);
		Thread.sleep(3500);
		distributionOrdersPage1.apply_Btn.click();
		Thread.sleep(3500);	
		String shipstatus = ShipmentStatus.getText();
		System.out.println("shipment status is :" +shipstatus);
		SeleniumTestHelper.assertEquals(shipstatus, "60 - Accepted");	
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, shipmentID_chkbox, 50);
		shipmentID_chkbox.click();
		Thread.sleep(2000);	
		EditShipment.click();	
		Thread.sleep(5000);
		SeleniumTestHelper.switchToInnerFrame(driver);
		Thread.sleep(5000);
		ProNumber.sendKeys("1234567890");
		System.out.println("enterd pro number");
		Thread.sleep(2000);
		Save.click();
		Thread.sleep(2000);
		homepage.user_closes_openedwindow("Edit Shipment - Shipment");
		Thread.sleep(5000);
		//Closing Shipment
		MoreShipment.click();
		Thread.sleep(3000);
		CloseMoreShipment.click();
		SeleniumTestHelper.switchToInnerFrame(driver);
		Thread.sleep(2000);
		if(!(printbolbox.isSelected()))
	    {
			printbolbox.click();
	    }else
	    {
	    	System.out.println("Print bol is already selected");
	    }
		if(!(invoiceTrailerbox.isSelected()))
	    {
			invoiceTrailerbox.click();
	    }else {
	    	System.out.println("invoice trailer is already selected");
	    }
		Select LpnOptions = new Select(driver.findElement(By.id("dataForm:closeShipmentTable:0:lpnProcessOption")));
		LpnOptions.selectByVisibleText("Confirm To Loaded and Unassign < Packed");
		System.out.println("Confirm To Loaded and Unassign < Packed selected");
		Thread.sleep(3000);
		driver.findElement(By.id("dataForm:save_button")).click();
		Thread.sleep(3000);
		//homepage.user_closes_openedwindow("Close Shipment List");
		Thread.sleep(8000);                                          
		refreshBtn.click();
		//distributionOrdersPage1.apply_Btn.click();
		System.out.println("clicked on refresh button");
		Thread.sleep(5000);
		String shipstatus1 = ShipmentStatus.getText();
		System.out.println("shipment status is :" +shipstatus1);
		SeleniumTestHelper.assertEquals(shipstatus1, "80 - Delivered");
		System.out.println("Status : " + shipstatus1 + " has been verified successfully for Shipno : " + shipno); 
		Thread.sleep(5000);
		homepage.user_closes_openedwindow("Shipments");
	}
	

}

