package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Steps;
import utils.Driver;
import utils.SeleniumTestHelper;


public class PostMessagePage {
	WebDriver driver;
	public PostMessagePage()
	{
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='file' and @accept='text/xml']") 
	public WebElement choosefile;
	
	@FindBy(xpath="//input[@type='submit' and @value='Send']") 
	public WebElement sendBtn;
	
	@FindBy(id="dataForm:resultString") 
	public WebElement responseTxt;
	
	@FindBy(id="dataForm:xmlString") 
	public WebElement requestTextArea;
	
	@FindBy(id="dataForm:resetCmdId") 
	public WebElement resultReset;
	
	@FindBy(xpath="//a[@data-qtip='Open Windows']") 
	public WebElement openWindows;
	
	public void uploadFileInPostmessageScreen(WebDriver driver,String filename) throws IOException, InterruptedException
	{
		
		
		Thread.sleep(4000);
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, choosefile, 50);
		choosefile.click();
		//Thread.sleep(10000);
		SeleniumTestHelper.uploadfile(filename);
		Thread.sleep(6000);
		sendBtn.click();
				
	}
	public String Validate_Response(WebDriver driver,String tagname)
	{
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, responseTxt, 50);
		String Response=responseTxt.getAttribute("value");
		String Responsetxt=SeleniumTestHelper.Getvalueinbetweentags(tagname, Response);
		return Responsetxt;
		
	}
}
