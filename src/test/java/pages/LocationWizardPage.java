package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class LocationWizardPage {
	WebDriver driver;
	
	public LocationWizardPage()
	{
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//select[contains(@id,'primaryList')]")
	public WebElement maintenanceTypeDDL;
	@FindBy(xpath="//select[contains(@id,'dependentList')]")
	public WebElement locationclassDDL;
	@FindBy(xpath="//input[contains(@value,'Next>')]")
	public WebElement nextBtn;
	@FindBy(xpath="//input[contains(@id,'fromDyLocn_Cloneable:areafromDyLocn_Cloneable')]")
	public WebElement fromareaInputBox;
	@FindBy(xpath="//input[contains(@id,'fromDyLocn_Cloneable:zonefromDyLocn_Cloneable')]")
	public WebElement fromZoneInputBox;
	@FindBy(xpath="//input[contains(@id,'fromDyLocn_Cloneable:aislefromDyLocn_Cloneable')]")
	public WebElement fromAisleInputBox;
	@FindBy(xpath="//input[contains(@id,'fromDyLocn_Cloneable:bayfromDyLocn_Cloneable')]")
	public WebElement fromBayInputBox;
	@FindBy(xpath="//input[contains(@id,'fromDyLocn_Cloneable:levelfromDyLocn_Cloneable')]")
	public WebElement fromLevelInputBox;
	@FindBy(xpath="//input[contains(@id,'fromDyLocn_Cloneable:positionfromDyLocn_Cloneable')]")
	public WebElement fromPositionInputBox;
	@FindBy(xpath="//input[contains(@id,'toDyLocn_Cloneable:areatoDyLocn_Cloneable')]")
	public WebElement toareaInputBox;
	@FindBy(xpath="//input[contains(@id,'toDyLocn_Cloneable:zonetoDyLocn_Cloneable')]")
	public WebElement toZoneInputBox;
	@FindBy(xpath="//input[contains(@id,'toDyLocn_Cloneable:aisletoDyLocn_Cloneable')]")
	public WebElement toAisleInputBox;
	@FindBy(xpath="//input[contains(@id,'toDyLocn_Cloneable:baytoDyLocn_Cloneable')]")
	public WebElement toBayInputBox;
	@FindBy(xpath="//input[contains(@id,'toDyLocn_Cloneable:leveltoDyLocn_Cloneable')]")
	public WebElement toLevelInputBox;
	@FindBy(xpath="//input[contains(@id,'toDyLocn_Cloneable:positiontoDyLocn_Cloneable')]")
	public WebElement toPositionInputBox;
	
	@FindBy(xpath="//input[contains(@id,'length')]")
	public WebElement locationLength;
	@FindBy(xpath="//input[contains(@id,'Width')]")
	public WebElement locationWidth;
	@FindBy(xpath="//input[contains(@id,'Height')]")
	public WebElement locationHeight;
	@FindBy(xpath="//span[text()='Work Group/Work Area definition:']/following::select[1]")
	public WebElement workGroupDDL;
	@FindBy(xpath="//span[text()='Max Qty:']/following::input[1]")
	public WebElement maxQtyInput;
	@FindBy(xpath="//span[text()='Item dedication Type:']/following::Select[1]")
	public WebElement itemDedicationTypeDDL;
	@FindBy(xpath="//span[text()='Putaway Zone:']/following::Select[1]")
	public WebElement putawayTypeZoneDDL;
	@FindBy(xpath="//input[contains(@id,'dataForm:lwght')]")
	public WebElement maxWeightInputBox;
	@FindBy(xpath="//span[text()='Max volume:']//following::input[1]")
	public WebElement maxVolumeInputBox;
	@FindBy(xpath="//input[@value='Submit']")
	public WebElement submitBtn;
	@FindBy(xpath="//input[@value='<Back']")
	public WebElement backBtn;
	@FindBy(xpath="//span[text()='Slot type:']/following::Select[1]")
	public WebElement slotType;
	@FindBy(xpath="//span[text()='Pick assignment zone:']/following::Select[1]")
	public WebElement pickAssignmentZone;
	@FindBy(xpath="//input[@id='dataForm:chx_repl']")
	public WebElement replenishmentChkBox;
	@FindBy(xpath="//span[text()='Pick determination zone:']/following::Select[1]")
	public WebElement pickDeterminationZone;
	@FindBy(xpath="//span[text()='Pick Location assignment type:']/following::select[1]")
	public WebElement pickLocationAssignmentType;
	@FindBy(xpath="//span[text()='Max number of Items:']//following::input[1]")
	public WebElement maxNumberOfItemsInputBox;
	@FindBy(xpath="//span[text()='Group Type:']//following::Select[1]")
	public WebElement groupType;
	
	@FindBy(xpath="//input[@id='dataForm:mxw_repl']") public WebElement maxWeight;
	
	
	
	
}
