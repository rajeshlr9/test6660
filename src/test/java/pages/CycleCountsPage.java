package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;
import utils.SeleniumTestHelper;

public class CycleCountsPage {

	public WebDriver driver;

	
	public CycleCountsPage()
	{
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='dataForm:listView:filterId:itemLookUpId']") public WebElement item_lookUp_InputBox;
	@FindBy(xpath="(//input[@value='Apply'])[2]") public WebElement Apply_btn;
	@FindBy(xpath="//table[@id='dataForm:listView:dataTable_body']//tr[1]/td[4]/span[1]") public WebElement first_CC_loation;
	@FindBy(xpath="//table[@id='dataForm:listView:dataTable_body']//tr[1]/td[5]/span[1]") public WebElement first_CC_status;
	
	
	
	
	public void find_CC_with_item_and_verify_status(String locationToBe_verified, String item_tobe_verified, String status){
		
		driver.switchTo().frame(0);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, item_lookUp_InputBox, 5);
		item_lookUp_InputBox.sendKeys(item_tobe_verified);
		Apply_btn.click();
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, first_CC_loation, 5);
		String expected_Location = locationToBe_verified.replaceAll("-", "");
		String actual_Location = first_CC_loation.getText().replaceAll("-", "");
		SeleniumTestHelper.assertEquals(actual_Location, expected_Location);
		SeleniumTestHelper.assertEquals(first_CC_status.getText(), status);
	}
	
	
}
