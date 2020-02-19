package globalFunc;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Image;

import StepDefinition.Steps;
import cucumber.api.Scenario;

public class Screenshots {

	public static void seleniumSnapshot(WebDriver webdriver) throws Exception{
       System.out.println("screeny");
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C:\\Users\\826920\\git\\SampleMavenProj\\resources\\Screenshots\\"+DateTime.strDate3+".jpeg");
        FileUtils.copyFile(SrcFile, DestFile);
       /* final byte[] screenshot = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.BYTES);
        //File DestFile=new File(Steps.dir+"\\resources\\Screenshots\\"+DateTime.strDate3+".png");
        
        
        scenario.embed(screenshot, "image/png"); */
    }

	
	public static void LeanFTSnapshot(Browser leanFTDriver) throws Exception{
	//Image img = LeanFTDriver.getSnapshot();
		//RenderedImage img = LeanFTDriver.getPage().getSnapshot();
	//	Reporter.reportEvent("Login","Login successful", Status.Passed, img);
		RenderedImage srcFile=leanFTDriver.getSnapshot(); 
		//File fileObj = new File(System.getProperty("user.dir")+"\\ScreenShots\\"+vendorID+"_"+".jpg");
		File fileObj = new File("C:\\Users\\826920\\git\\SampleMavenProj\\resources\\Screenshots\\"+DateTime.strDate3+".jpeg");
		try {
		ImageIO.write(srcFile, "jpg", fileObj);
		} catch (IOException e) {

		e.printStackTrace();
		}
}
	public static void LeanFTSnapshot(Window leanFTDriver) throws Exception{
		//Image img = LeanFTDriver.getSnapshot();
			//RenderedImage img = LeanFTDriver.getPage().getSnapshot();
		//	Reporter.reportEvent("Login","Login successful", Status.Passed, img);
			RenderedImage srcFile=leanFTDriver.getSnapshot(); 
			//File fileObj = new File(System.getProperty("user.dir")+"\\ScreenShots\\"+vendorID+"_"+".jpg");
			File fileObj = new File("C:\\Users\\826920\\git\\SampleMavenProj\\resources\\Screenshots\\"+DateTime.strDate3+".jpeg");
			try {
			ImageIO.write(srcFile, "jpg", fileObj);
			} catch (IOException e) {

			e.printStackTrace();
			}
	}
}