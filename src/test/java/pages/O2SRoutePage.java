package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;

import StepDefinition.Steps;
import globalFunc.Screenshots;
import utils.SeleniumTestHelper;

public class O2SRoutePage {

	WebDriver driver;

	public static String TestedBy = null;

	public O2SRoutePage() {
		this.driver = Steps.seleniumDriver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//input[@name='form1:routeOptions:0:scheduleOptions:0:selSchdOpt']")
//	public WebElement route0;

	@FindBy(xpath = "//input[@type='radio' and @value='opt1']//following::span[contains(text(),'First Overnight')]")
	public WebElement firstOvernightOption;
	@FindBy(xpath = "//input[@type='radio' and @value='opt2']//following::span[contains(text(),'Priority Overnight')]")
	public WebElement priorityOvernightOption;
	@FindBy(xpath = "//input[@type='radio' and @value='opt0']//following::span[contains(text(),'Express Saver')]")
	public WebElement expressSaverOption;
	@FindBy(xpath = "//input[@type='radio' and @value='opt3']//following::span[contains(text(),'2Day')]")
	public WebElement twoDayOption;
	@FindBy(xpath = "//input[@type='radio' and @value='opt0']//following::span[contains(text(),'SameDay Courier')]")
	public WebElement sameDayCourierOption;
	
	@FindBy(xpath = "//input[@type='radio' and @name='form1:routeOptions:0:scheduleOptions:0:selSchdOpt']//following::span[contains(text(),'FedEx ')][1]")
	public WebElement fedExsameDayCourierOption;
	
	@FindBy(xpath = "//input[@type='radio' and @value='opt0']//following::span[contains(text(),'FedEx Ground')]")
	public WebElement fedExGroundOption;
	
	@FindBy(xpath = "//input[@type='radio' and @value='opt0']//following::span[contains(text(),'Will Call')]")
	public WebElement fedExWillCallOption;
	
	

	@FindBy(xpath = "//input[@id='form1:submit']")
	public WebElement continueBtn;
	
	@FindBy(xpath = "//input[@id='form1:submit1']")
	public WebElement continueBtn2;

	@FindBy(xpath = "//input[@id='form1:filter']")
	public WebElement applyFilterBtn;
	
	@FindBy(xpath = "//*[@id='LoadingDisplayBox']")
	public WebElement loadingDisplayBox;
	
	@FindBy(xpath = "//span[contains(text(),'There are no Route Options available for the selected warehouse ')]")
	public WebElement errorMessageForNoRoute;
	
	@FindBy(xpath = "//input[@type='radio' and @value='opt1']//following::span[contains(text(),'International Priority')]")
	public WebElement internationalPriorityOption;
	
	@FindBy(xpath = "//*[@id='form1:ordrInfoTbl:0:titleFinalInternational']")
	public WebElement InternationalPgHeader;
	
	@FindBy(xpath = "//*[@id='form1:ordrInfoTbl:0:cipaymentterms']")
	public WebElement invoicepaymentDropdown;
	
	@FindBy(xpath = "//*[@id='form1:ordrInfoTbl:0:reqItems:0:intlItemTree:0:t2']")
	public WebElement itemDataBtn;
	
	@FindBy(xpath = "//*[@id='form1:ordrInfoTbl:0:reqItems:0:intlItemTree:0:0:_idJsp242']")
	public WebElement harmonizedCodeVal;
	
	@FindBy(xpath = "//*[@id='form1:ordrInfoTbl:0:reqItems:0:intlItemTree:0:1:_idJsp242']")
	public WebElement harmonizedCodeDesc;
	
	@FindBy(xpath = "//*[@id='form1:ordrInfoTbl:0:reqItems:0:intlItemTree:0:2:_idJsp242']")
	public WebElement unitValue;
	
	@FindBy(xpath = "//*[@id='form1:ordrInfoTbl:0:reqItems:0:intlItemTree:0:3:_idJsp242']")
	public WebElement manufactureCountry;
	
	@FindBy(xpath = "//*[@id='form1:ordrInfoTbl:0:updateItem']")
	public WebElement updateBtn;
	
	@FindBy(xpath = "//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span")
	public WebElement o2sRouteName;
	/***
	 * This method selectRoute is use for selecting the route
	 * @throws Exception
	 */
	public void selectRoute() throws Exception {

		// SeleniumTestHelper.waitForElementToBeDisplayed(driver, expressSaverOption,
		// 180);
		
		int temp = 0;
		while ((temp != 3)) {
			if(SeleniumTestHelper.isElementDisplayed(errorMessageForNoRoute)) {
			applyFilterBtn.click();
			//Thread.sleep(3000);
			SeleniumTestHelper.WaitForPageLoad();
			}else {
				break;
			}
			temp++;
		}
		String service = String.valueOf(Steps.scenarioData.get("Service"));
		
		switch(service) {
		
		
			case "FedEx 2Day":
				WebElement ele2Day = driver.findElement(By.xpath("//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'2Day')]"));
				if (SeleniumTestHelper.isElementDisplayed(ele2Day)) {
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, ele2Day, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(ele2Day));
					SeleniumTestHelper.scrollToElement(driver, ele2Day);
					ele2Day.click();
					Steps.logger.info("Clicked on FedEx 2Day");
				}else {
					System.out.println("Expected Services  FedEx 2Day are not available at this time");
					Steps.logger.info("Expected Services FedEx 2Day are not available at this time");
					SeleniumTestHelper.assertTrue(false, "Expected Service FedEx 2Day are not Available,hence makes the script failed");
				}
			break;	
			
			
			case "FedEx Standard Overnight":
				WebElement eleSO = driver.findElement(By.xpath("//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'Standard Overnight')]"));
				if (SeleniumTestHelper.isElementDisplayed(eleSO)) {
				SeleniumTestHelper.waitForElementToBeDisplayed(driver, eleSO, 180);
				SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(eleSO));
				SeleniumTestHelper.scrollToElement(driver, eleSO);
				eleSO.click();
				Steps.logger.info("Clicked on Standard Overnight Option");
			}else {
				System.out.println("Expected Services Standard Overnight are not available at this time");
				Steps.logger.info("Expected Services Standard Overnight are not available at this time");
				SeleniumTestHelper.assertTrue(false, "Expected Service Standard Overnight are not Available,hence makes the script failed");
			}
			break;	
			
			case "FedEx First Overnight":
				WebElement eleFO = driver.findElement(By.xpath("//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'FedEx First Overnight')]"));
				if (SeleniumTestHelper.isElementDisplayed(eleFO)) {
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, eleFO, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(eleFO));
					SeleniumTestHelper.scrollToElement(driver, eleFO);
					eleFO.click();
					Steps.logger.info("Clicked on Fedex first Overnight Option");
				}else {
					System.out.println("Expected Services Fedex first Overnight are not available at this time");
					Steps.logger.info("Expected Services Fedex first Overnight are not available at this time");
					SeleniumTestHelper.assertTrue(false, "Expected Service Fedex first Overnight are not Available,hence makes the script failed");
				}
				break;
			
			
			case "FedEx SameDay NFO":
				WebElement eleSDNFO = driver.findElement(By.xpath("(//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'FedEx SameDay NFO')])[1]"));
				List<WebElement> eleNxtFlt = driver.findElements(By.xpath("//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'Next Flight')]"));
				Thread.sleep(10000);
				if (SeleniumTestHelper.isElementDisplayed(eleSDNFO)) {
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, eleSDNFO, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(eleSDNFO));
					SeleniumTestHelper.scrollToElement(driver, eleSDNFO);
					eleSDNFO.click();
					Steps.logger.info("Clicked on FedEx SameDay NFO");
				}else if(eleNxtFlt.size()>0) {
					WebElement eleNxtFlt1 = driver.findElement(By.xpath("//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'Next Flight')]"));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, eleNxtFlt1, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(eleNxtFlt1));
					SeleniumTestHelper.scrollToElement(driver, eleNxtFlt1);
					eleNxtFlt1.click();
					Steps.logger.info("Clicked on FedEx Nexy Flight");
				}
				else {
					System.out.println("Expected Services FedEx SameDay NFO are not available at this time");
					Steps.logger.info("Expected Services FedEx SameDay NFO are not available at this time");
					SeleniumTestHelper.assertTrue(false, "Expected Service FedEx SameDay NFO are not Available,hence makes the script failed");
				}
				break;	
				
			case "FedEx SameDay Courier":
				WebElement eleSDC = driver.findElement(By.xpath("//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'SameDay Courier')]"));	
				if (SeleniumTestHelper.isElementDisplayed(eleSDC)) {
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, eleSDC, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(eleSDC));
					SeleniumTestHelper.scrollToElement(driver, eleSDC);
					eleSDC.click();
					Steps.logger.info("Clicked on FedEx SameDay Courier");
				}else {
					System.out.println("Expected Service FedEx SameDay Courier are not available at this time");
					Steps.logger.info("Expected Service FedEx SameDay Courier are not available at this time");
					SeleniumTestHelper.assertTrue(false, "Expected Service FedEx SameDay Courier are not Available,hence makes the script failed");
				}
				break;
				
			case "FedEx Will Call":
				WebElement eleWC = driver.findElement(By.xpath("//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'Will Call')]"));		
					if (SeleniumTestHelper.isElementDisplayed(eleWC)) {
						SeleniumTestHelper.waitForElementToBeDisplayed(driver, eleWC, 180);
						SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(eleWC));
						SeleniumTestHelper.scrollToElement(driver, eleWC);
						eleWC.click();
						Steps.logger.info("Clicked on FedEx Will Call Option");
					}else {
						System.out.println("Expected Services FedEx Will Call are not available at this time");
						Steps.logger.info("Expected Services FedEx Will Call are not available at this time");
						SeleniumTestHelper.assertTrue(false, "Expected Service FedEx Will Call are not Available,hence makes the script failed");
					}
					break;
				
			case "FedEx International Priority":
				WebElement eleIP = driver.findElement(By.xpath("//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'International Priority')]"));
				if (SeleniumTestHelper.isElementDisplayed(eleIP)) {
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, eleIP, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(eleIP));
					SeleniumTestHelper.scrollToElement(driver, eleIP);
					eleIP.click();
					Steps.logger.info("Clicked on International Priority Option");
				}else {
					System.out.println("Expected Services International Priority are not available at this time");
					Steps.logger.info("Expected Services International Priority are not available at this time");
					SeleniumTestHelper.assertTrue(false, "Expected Service International Priority are not Available,hence makes the script failed");
				}
			break;
				
				
			case "FedEx Priority Overnight":
				WebElement elePO = driver.findElement(By.xpath("//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'Priority Overnight')]"));
				if (SeleniumTestHelper.isElementDisplayed(elePO)) {
					System.out.println(SeleniumTestHelper.isElementDisplayed(elePO));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, elePO, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(elePO));
					SeleniumTestHelper.scrollToElement(driver, elePO);
					elePO.click();
					Steps.logger.info("Clicked on Priority overnight option");
				}else {
					System.out.println("Expected Services are not available at this time");
					Steps.logger.info("Expected Services are not available at this time");
					SeleniumTestHelper.assertTrue(false, "Expected Service are not Available,hence makes the script failed");
				}
				break;
				
			case "expressSaverOption":
				if (SeleniumTestHelper.isElementDisplayed(expressSaverOption)) {
					System.out.println(SeleniumTestHelper.isElementDisplayed(expressSaverOption));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, expressSaverOption, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(expressSaverOption));
					SeleniumTestHelper.scrollToElement(driver, expressSaverOption);
					expressSaverOption.click();
					Steps.logger.info("Clicked on express saver");
				}else {
					System.out.println("Expected Services are not available at this time");
					Steps.logger.info("Expected Services are not available at this time");
					SeleniumTestHelper.assertTrue(false, "Expected Service are not Available,hence makes the script failed");
				}
				break;
				
			case "FedEx Ground": 
				WebElement eleGround = driver.findElement(By.xpath("//table[contains(@id,'form1:routeOptions')]/tbody/tr/td[2]/span[contains(text(),'FedEx Ground')]"));	
				if (SeleniumTestHelper.isElementDisplayed(eleGround)) {
					System.out.println(SeleniumTestHelper.isElementDisplayed(eleGround));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, eleGround, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(eleGround));
					SeleniumTestHelper.scrollToElement(driver, eleGround);
					eleGround.click();
					Steps.logger.info("Clicked on FedEx Ground");
				}else {
					System.out.println("Expected Services are not available at this time");
					Steps.logger.info("Expected Services are not available at this time");
					SeleniumTestHelper.assertTrue(false, "Expected Service are not Available,hence makes the script failed");
				}
				break;
				
				
			default:
				
				if (SeleniumTestHelper.isElementDisplayed(firstOvernightOption)) {
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, firstOvernightOption, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(firstOvernightOption));
					SeleniumTestHelper.scrollToElement(driver, firstOvernightOption);
					firstOvernightOption.click();
					Steps.logger.info("Clicked on firstOvernightOption");
				}
				else if (SeleniumTestHelper.isElementDisplayed(priorityOvernightOption)) {
					System.out.println(SeleniumTestHelper.isElementDisplayed(priorityOvernightOption));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, priorityOvernightOption, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(priorityOvernightOption));
					SeleniumTestHelper.scrollToElement(driver, priorityOvernightOption);
					priorityOvernightOption.click();
					Steps.logger.info("Clicked on Priority overnight option");
				}
				else if (SeleniumTestHelper.isElementDisplayed(expressSaverOption)) {
					System.out.println(SeleniumTestHelper.isElementDisplayed(expressSaverOption));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, expressSaverOption, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(expressSaverOption));
					SeleniumTestHelper.scrollToElement(driver, expressSaverOption);
					expressSaverOption.click();
					Steps.logger.info("Clicked on express saver");
				}else if (SeleniumTestHelper.isElementDisplayed(fedExGroundOption)) {
					System.out.println(SeleniumTestHelper.isElementDisplayed(fedExGroundOption));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, fedExGroundOption, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(fedExGroundOption));
					SeleniumTestHelper.scrollToElement(driver, fedExGroundOption);
					fedExGroundOption.click();
					Steps.logger.info("Clicked on FedEx Ground");
				}else if (SeleniumTestHelper.isElementDisplayed(twoDayOption)) {
					System.out.println(SeleniumTestHelper.isElementDisplayed(twoDayOption));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, twoDayOption, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(twoDayOption));
					SeleniumTestHelper.scrollToElement(driver, twoDayOption);
					twoDayOption.click();
					Steps.logger.info("Clicked on Two Day");
				}
				
				else if (SeleniumTestHelper.isElementDisplayed(fedExsameDayCourierOption)) {
					System.out.println(SeleniumTestHelper.isElementDisplayed(fedExsameDayCourierOption));
					SeleniumTestHelper.waitForElementToBeDisplayed(driver, fedExsameDayCourierOption, 180);
					SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(fedExsameDayCourierOption));
					SeleniumTestHelper.scrollToElement(driver, fedExsameDayCourierOption);
					fedExsameDayCourierOption.click();
					Steps.logger.info("Clicked on FedEx SameDay Courier Option");
				}
				else {
					System.out.println("No Expected Services are available at this time");
					Steps.logger.info("No Expected Services are available at this time");
					SeleniumTestHelper.assertTrue(false, "No Service Available,hence makes the script failed");
				}
		}

		
		Thread.sleep(5000);
		Screenshots.captureSnapshot(driver);
		Reporter.addStepLog("User selected the Route...");
		SeleniumTestHelper.waitForElementToBeDisplayed(driver, continueBtn, 180);
		SeleniumTestHelper.assertTrue(SeleniumTestHelper.isElementDisplayed(continueBtn));
		SeleniumTestHelper.scrollToElement(driver, continueBtn);
		SeleniumTestHelper.clickOnButton(continueBtn);
		//continueBtn.click();
		Steps.logger.info("Clicked on Continue button");
		//Thread.sleep(5000);
		SeleniumTestHelper.WaitForPageLoad(3000);
		while(SeleniumTestHelper.isElementDisplayed(loadingDisplayBox)) {
			System.out.println("Wait till the loading Display Box getting display");
			SeleniumTestHelper.WaitForPageLoad();
		}
		
		if(service.contains("International"))
		{
			SeleniumTestHelper.WaitForPageLoad(3000);
			SeleniumTestHelper.waitForElementToBeDisplayed(driver, InternationalPgHeader, 180);
			
			Select sel = new Select(invoicepaymentDropdown);
			sel.selectByIndex(1);
			SeleniumTestHelper.WaitForPageLoad(3000);
			SeleniumTestHelper.clickOnButton(itemDataBtn);
			SeleniumTestHelper.WaitForPageLoad(3000);
			SeleniumTestHelper.enterText(harmonizedCodeDesc, "TestVal");
			SeleniumTestHelper.WaitForPageLoad(3000);
			SeleniumTestHelper.clickOnButton(updateBtn);
			SeleniumTestHelper.WaitForPageLoad(3000);
			SeleniumTestHelper.scrollToElement(driver, continueBtn2);
			SeleniumTestHelper.clickOnButton(continueBtn2);
			//continueBtn.click();
			Steps.logger.info("Clicked on Continue button");
			//Thread.sleep(5000);
			SeleniumTestHelper.WaitForPageLoad(3000);
			
			
			
		}
	}

}
