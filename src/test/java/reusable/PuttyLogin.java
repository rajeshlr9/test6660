package reusable;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Button;
import com.hp.lft.sdk.stdwin.ButtonDescription;
import com.hp.lft.sdk.stdwin.ListBox;
import com.hp.lft.sdk.stdwin.ListBoxDescription;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;

import StepDefinition.Steps;
import cucumber.api.DataTable;

public class PuttyLogin {

	public static void puttyLogin(DataTable usercredentials) throws InterruptedException, GeneralLeanFtException, AWTException {

		
		List<List<String>> data = usercredentials.raw();

		Robot robot=Steps.robot;
		robot=new Robot();
		
		ListBox	 Sterlingqa=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTYConfigBox").windowTitleRegExp("PuTTY Configuration").build()).describe(ListBox.class, new ListBoxDescription.Builder()
						.attachedText("Sav&ed Sessions").nativeClass("ListBox").build());

		

		Sterlingqa.select(1);
		Thread.sleep(2000);

		Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTYConfigBox").windowTitleRegExp("PuTTY Configuration").build()).describe(Button.class, new ButtonDescription.Builder()
						.text("&Open").nativeClass("Button").build()).click();
		Thread.sleep(2000);

		Window login=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());
		Thread.sleep(2000);

		login.sendKeys(data.get(1).get(0));

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		Window pwd=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());


		pwd.sendKeys(data.get(1).get(1));

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		Window userid=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

		userid.sendKeys(data.get(1).get(2));
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);


		Window pass = Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

		pass.sendKeys(data.get(1).get(3));
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);
	}
}
