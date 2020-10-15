package globalFunc;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.web.Browser;

public class Screenshots {


	public static void seleniumSnapshot(WebDriver webdriver) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("resources\\Screenshots\\" + DateTime.strDate3 + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public static void LeanFTSnapshot(Browser leanFTDriver) throws Exception {
		RenderedImage srcFile = leanFTDriver.getSnapshot();
		File fileObj = new File("resources\\Screenshots\\" + DateTime.strDate3 + ".jpeg");
		try {
			ImageIO.write(srcFile, "jpg", fileObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void LeanFTSnapshot(Window leanFTDriver) throws Exception {
		RenderedImage srcFile = leanFTDriver.getSnapshot();
		File fileObj = new File("resources\\Screenshots\\" + DateTime.strDate3 + ".jpeg");
		try {
			ImageIO.write(srcFile, "jpg", fileObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}