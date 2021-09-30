package entity;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLoops {
	static HashMap<String,String> ScenarioData = new HashMap<String,String>();
	
	public static void main(String[] args) throws Exception{
		
		

		ScenarioData.put("Account","QSC");

		System.out.println(ScenarioData.get("Account"));
		
		
		

	}

}
