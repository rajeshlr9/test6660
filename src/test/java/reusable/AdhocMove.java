package reusable;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;
/*
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;
import com.hp.lft.sdk.te.Position;
import com.hp.lft.sdk.te.TextScreen;
import com.hp.lft.sdk.te.TextScreenDescription;
*/
import StepDefinition.Steps;
import cucumber.api.DataTable;
//import unittesting.UnitTestClassBase;
import utils.Config;
//Commented to remove leanft dependency
/*
public class AdhocMove extends UnitTestClassBase {
	
	public static void adhocMove(DataTable usercredentials, Window putty)
			throws IOException, GeneralLeanFtException, AWTException, InterruptedException {

		try {

			List<List<String>> data = usercredentials.raw();

			 putty=Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false).childWindow(false)
					.windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());
			 TextScreen teTextScreen = Desktop.describe(com.hp.lft.sdk.te.Window.class, new com.hp.lft.sdk.te.WindowDescription.Builder()
						.shortName("A").build())
						.describe(TextScreen.class, new TextScreenDescription());
			int temp = 0;
			if (Config.getProperty("RFEnv").equals("QA")) {
				temp = 8;
			} else {
				if (Config.getProperty("RFEnv").equals("UA")) {
					temp = 10;
				}
			}

			for (int i = 0; i <= temp; i++) {
				teTextScreen.sendKeys(com.hp.lft.sdk.Keys.DOWN);
				Thread.sleep(1000);

			}

			teTextScreen.sendKeys(com.hp.lft.sdk.Keys.RETURN);
			Thread.sleep(2000);
			teTextScreen.sendKeys(com.hp.lft.sdk.Keys.RETURN);
			Thread.sleep(2000);


			Window startlocation = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
					.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

			startlocation.sendKeys(data.get(1).get(0)+com.hp.lft.sdk.Keys.TAB);

			Thread.sleep(2000);

			if(data.get(1).get(1).equals("Normal")) {
			
			Window item = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
					.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

			item.sendKeys(data.get(1).get(2)+com.hp.lft.sdk.Keys.TAB);

			Thread.sleep(2000);

			Window qty = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
					.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

			qty.sendKeys(data.get(1).get(3)+com.hp.lft.sdk.Keys.TAB);
			
			Thread.sleep(4000);
			
			}
			else if(data.get(1).get(1).equals("Serial")) {
					System.out.println("serial item");
				Window serial = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
						.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

				serial.sendKeys(data.get(1).get(2)+com.hp.lft.sdk.Keys.TAB);
				Thread.sleep(4000);
				
				if(teTextScreen.exists()) {
				teTextScreen.click();
				Thread.sleep(1000);
				//Capturing suggested location
				Position position= new Position(3, 6);
				teTextScreen.click(position);
				teTextScreen.click(position);
				Thread.sleep(2000);
				}else {
					System.out.println("unable to find textscreen");
					System.out.println("AdhocMove failed");
					try {
						Runtime rt = Runtime.getRuntime();
						rt.exec("taskkill /F /IM putty.exe");
					} catch (Exception e) {
						Assert.assertTrue(false);
						e.printStackTrace();
					}
					Assert.assertTrue(false);
				}
				
				String serialerr = Desktop.describe(com.hp.lft.sdk.te.Window.class, new com.hp.lft.sdk.te.WindowDescription.Builder()
						.shortName("A").build())
					.describe(TextScreen.class, new TextScreenDescription()).getVisibleText();
				
				String serialerr2= Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
						.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build()).getVisibleText();
				Thread.sleep(4000);
				if(serialerr.contains("Error")||serialerr2.contains("Error")) {
					System.out.println("AdhocMove failed as Serial does not exist");
					Steps.testRes="Failed";
					globalFunc.Screenshots.LeanFTSnapshot(putty);
					try {
						Runtime rt = Runtime.getRuntime();
						rt.exec("taskkill /F /IM putty.exe");
					} catch (Exception e) {
						Assert.assertTrue(false, e.getMessage());
						e.printStackTrace();
					}
					Assert.assertTrue(false);
				}
			}
			Thread.sleep(4000);	
			teTextScreen.sendKeys(com.hp.lft.sdk.Keys.F8);

			Thread.sleep(4000);
			String qtyerror= Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
					.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build()).getVisibleText();
			if(qtyerror.contains("Error")) {
				System.out.println("AdhocMove failed as quantity is greater than system");
				Steps.testRes="Failed";
				globalFunc.Screenshots.LeanFTSnapshot(putty);
				try {
					Runtime rt = Runtime.getRuntime();
					rt.exec("taskkill /F /IM putty.exe");
				} catch (Exception e) {
					Assert.assertTrue(false, e.getMessage());
					e.printStackTrace();
				}
				Assert.assertTrue(false);
			}
			
			Thread.sleep(4000);
			
			if(teTextScreen.exists()) {
			teTextScreen.click();
			Thread.sleep(1000);
			//Capturing suggested location
			Position position= new Position(8, 6);
			teTextScreen.click(position);
			teTextScreen.click(position);
			Thread.sleep(2000);
			}else {
				System.out.println("unable to find textscreen");
				System.out.println("AdhocMove failed");
				try {
					Runtime rt = Runtime.getRuntime();
					rt.exec("taskkill /F /IM putty.exe");
				} catch (Exception e) {
					Assert.assertTrue(false);
					e.printStackTrace();
				}
				Assert.assertTrue(false);
			}
				
			
			teTextScreen.sendKeys(com.hp.lft.sdk.Keys.TAB);
			Thread.sleep(2000);
			
			//Pasting suggested location
			teTextScreen.click(com.hp.lft.sdk.MouseButton.RIGHT);
			
			Thread.sleep(2000);
			
			teTextScreen.sendKeys(com.hp.lft.sdk.Keys.TAB);
			
			Thread.sleep(2000);
			teTextScreen.sendKeys(com.hp.lft.sdk.Keys.F8);
			Thread.sleep(1000);
			teTextScreen.sendKeys(com.hp.lft.sdk.Keys.F6);
			
			String zoneconstraint= Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
					.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build()).getVisibleText();
			
			if(zoneconstraint.contains("Error")) {
				System.out.println("AdhocMove failed due to zone constraints issue");
				Steps.testRes="Failed";
				globalFunc.Screenshots.LeanFTSnapshot(putty);
				try {
					Runtime rt = Runtime.getRuntime();
					rt.exec("taskkill /F /IM putty.exe");
				} catch (Exception e) {
					Assert.assertTrue(false);
					e.printStackTrace();
				}
				Assert.assertTrue(false);
			}
			
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}
}*/