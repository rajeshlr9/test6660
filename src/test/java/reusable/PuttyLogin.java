package reusable;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Button;
import com.hp.lft.sdk.stdwin.ButtonDescription;
import com.hp.lft.sdk.stdwin.ListBox;
import com.hp.lft.sdk.stdwin.ListBoxDescription;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;
import com.hp.lft.sdk.te.TextScreen;
import com.hp.lft.sdk.te.TextScreenDescription;

import StepDefinition.Steps;

public class PuttyLogin {

	public static void puttyLogin() throws InterruptedException, GeneralLeanFtException, AWTException {

		Properties prop=Steps.prop;
		 TextScreen teTextScreen = Desktop.describe(com.hp.lft.sdk.te.Window.class, new com.hp.lft.sdk.te.WindowDescription.Builder()
					.shortName("A").build())
					.describe(TextScreen.class, new TextScreenDescription());
		ListBox	Sterling=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTYConfigBox").windowTitleRegExp("PuTTY Configuration").build()).describe(ListBox.class, new ListBoxDescription.Builder()
						.attachedText("Sav&ed Sessions").nativeClass("ListBox").build());

	
		if(prop.getProperty("RFEnv").equals("QA")) {
			Sterling.select("Sterling-QA");
		}else {
			if(prop.getProperty("RFEnv").equals("UA")) {
			Sterling.select("Sterling-UA");
			}
		}
		
		Thread.sleep(2000);

		Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTYConfigBox").windowTitleRegExp("PuTTY Configuration").build()).describe(Button.class, new ButtonDescription.Builder()
						.text("&Open").nativeClass("Button").build()).click();
		Thread.sleep(2000);

		Window RFUsername=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());
		Thread.sleep(2000);

		RFUsername.sendKeys(prop.getProperty("RFUsername"));

		teTextScreen.sendKeys(com.hp.lft.sdk.Keys.RETURN);

		Thread.sleep(1000);
		
		Window RFPassword=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

		RFPassword.sendKeys(prop.getProperty("RFPassword"));

		teTextScreen.sendKeys(com.hp.lft.sdk.Keys.RETURN);
		Thread.sleep(1000);
		
		//Node Login
		Window RFNodeUser=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

		RFNodeUser.sendKeys(prop.getProperty("RFNodeUser"));
		Thread.sleep(1000);

		teTextScreen.sendKeys(com.hp.lft.sdk.Keys.TAB);


		Window RFNodePwd = Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("PuTTY").windowTitleRegExp(" PuTTY").build());

		RFNodePwd.sendKeys(prop.getProperty("RFNodePwd"));
		Thread.sleep(1000);

		teTextScreen.sendKeys(com.hp.lft.sdk.Keys.TAB);

		Thread.sleep(2000);
	}
}
