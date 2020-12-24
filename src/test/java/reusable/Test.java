package reusable;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;
import com.hp.lft.sdk.te.Position;
import com.hp.lft.sdk.te.TextScreen;
import com.hp.lft.sdk.te.TextScreenDescription;

import StepDefinition.Steps;
import cucumber.api.DataTable;
import unittesting.UnitTestClassBase;
import utils.Config;

public class Test extends UnitTestClassBase {

	public static void adhocMove(DataTable usercredentials)
			throws IOException, GeneralLeanFtException, AWTException, InterruptedException {

		try {

			List<List<String>> data = usercredentials.raw();
			Robot robot = Steps.robot;
			robot = new Robot();

			Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false).childWindow(false)
					.windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());
			int temp = 0;
			if (Config.getProperty("RFEnv").equals("QA")) {
				temp = 8;
			} else {
				if (Config.getProperty("RFEnv").equals("UA")) {
					temp = 10;
				}
			}

			for (int i = 0; i <= temp; i++) {
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(1000);

			}

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(1000);

			Window location = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
					.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

			location.sendKeys(data.get(1).get(0));

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(2000);

			if (data.get(1).get(1).equals("Normal")) {

				Window item = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
						.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

				item.sendKeys(data.get(1).get(2));
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);

				Thread.sleep(2000);

				Window qty = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
						.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

				qty.sendKeys(data.get(1).get(3));

				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);

				Thread.sleep(4000);

			} else {
				if (data.get(1).get(1).equals("Serial")) {
					System.out.println("serial");
					Window serial = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
							.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

					serial.sendKeys(data.get(1).get(2));
					Thread.sleep(2000);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyRelease(KeyEvent.VK_TAB);

					Thread.sleep(4000);

					robot.keyPress(KeyEvent.VK_F8);
					robot.keyRelease(KeyEvent.VK_F8);

					Thread.sleep(4000);

				}
			}
			Thread.sleep(2000);

			TextScreen teTextScreen = Desktop
					.describe(com.hp.lft.sdk.te.Window.class,
							new com.hp.lft.sdk.te.WindowDescription.Builder().shortName("A").build())
					.describe(TextScreen.class, new TextScreenDescription());
			teTextScreen.click();
			Thread.sleep(1000);

			// Capturing suggested location
			Position position = new Position(8, 6);
			teTextScreen.click(position);
			teTextScreen.click(position);
			Thread.sleep(2000);

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

			// Pasting suggested location
			robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

			Thread.sleep(2000);

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_F8);
			robot.keyRelease(KeyEvent.VK_F8);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_F6);
			robot.keyRelease(KeyEvent.VK_F6);


			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
