package reusable;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;

import StepDefinition.Steps;
import cucumber.api.DataTable;
import unittesting.UnitTestClassBase;

public class AdhocMove extends UnitTestClassBase {

	public static void adhocMove(DataTable usercredentials)
			throws IOException, GeneralLeanFtException, AWTException, InterruptedException {

		try {
			List<List<String>> data = usercredentials.raw();
			Robot robot = Steps.robot;
			robot = new Robot();

			Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false).childWindow(false)
					.windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

			for (int i = 0; i <= 8; i++) {
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

			Window item = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
					.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

			item.sendKeys(data.get(1).get(1));
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(2000);

			Window lot = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
					.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);

			Thread.sleep(1000);

			Window qty = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
					.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

			qty.sendKeys(data.get(1).get(2));

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(2000);

			robot.keyPress(KeyEvent.VK_F8);
			robot.keyRelease(KeyEvent.VK_F8);

			Thread.sleep(2000);

			Window suggloc = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false)
					.childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

			suggloc.sendKeys(data.get(1).get(3));
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_F8);
			robot.keyRelease(KeyEvent.VK_F8);

			robot.keyPress(KeyEvent.VK_F6);
			robot.keyRelease(KeyEvent.VK_F6);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

}