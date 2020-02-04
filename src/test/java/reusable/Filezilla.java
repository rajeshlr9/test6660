package reusable;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Button;
import com.hp.lft.sdk.stdwin.ButtonDescription;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.DialogDescription;
import com.hp.lft.sdk.stdwin.EditField;
import com.hp.lft.sdk.stdwin.EditFieldDescription;
import com.hp.lft.sdk.stdwin.ListView;
import com.hp.lft.sdk.stdwin.ListViewDescription;
import com.hp.lft.sdk.stdwin.Menu;
import com.hp.lft.sdk.stdwin.MenuDescription;
import com.hp.lft.sdk.stdwin.TreeView;
import com.hp.lft.sdk.stdwin.TreeViewDescription;
import com.hp.lft.sdk.stdwin.TreeViewNode;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;

//import com.hp.lft.sdk.web.Browser;
//import com.hp.lft.sdk.web.BrowserDescription;
//import com.hp.lft.sdk.web.BrowserFactory;
//import com.hp.lft.sdk.web.BrowserType;
//import com.hp.lft.sdk.web.ButtonDescription;
//import com.hp.lft.sdk.web.EditField;
//import com.hp.lft.sdk.web.EditFieldDescription;
//import com.hp.lft.sdk.web.Link;
//import com.hp.lft.sdk.web.LinkDescription;
import unittesting.UnitTestClassBase;

public class Filezilla extends UnitTestClassBase {

    public static void uploadOrder() throws GeneralLeanFtException, InterruptedException, IOException, AWTException {
    	
    	Robot robot= new Robot();
    	
    	Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("wxWindowNR").windowTitleRegExp("FileZilla").build()).describe(Menu.class, new MenuDescription.Builder()
						.type(com.hp.lft.sdk.stdwin.MenuType.MENU).build()).select("File;Site Manager...	Ctrl+S");
		Thread.sleep(1000);
		
		List<TreeViewNode> selectEntryTreeView = Desktop.describe(Window.class, new WindowDescription.Builder()
				.childWindow(false)
				.ownedWindow(false)
				.windowClassRegExp("wxWindowNR")
				.windowTitleRegExp("FileZilla").build())
			.describe(Dialog.class, new DialogDescription.Builder()
				.childWindow(false)
				.ownedWindow(true)
				.nativeClass("#32770")
				.text("Site Manager").build())
			.describe(TreeView.class, new TreeViewDescription.Builder()
				.attachedText("&Select Entry:")
				.nativeClass("SysTreeView32").build()).getVisibleNodes();
		
		for (int i = 0; i <selectEntryTreeView.size(); i++) {
			
			if(selectEntryTreeView.get(i).getText().contains("EMC")){
				System.out.println("site is-"+selectEntryTreeView.get(i).getText());
				Desktop.describe(Window.class, new WindowDescription.Builder()
						.childWindow(false)
						.ownedWindow(false)
						.windowClassRegExp("wxWindowNR")
						.windowTitleRegExp("FileZilla").build())
					.describe(Dialog.class, new DialogDescription.Builder()
						.childWindow(false)
						.ownedWindow(true)
						.nativeClass("#32770")
						.text("Site Manager").build())
					.describe(TreeView.class, new TreeViewDescription.Builder()
						.attachedText("&Select Entry:")
						.nativeClass("SysTreeView32").build()).select(i);
				
				
			}
			
		}
		
		//Desktop.describe(Dialog.class, new DialogDescription.Builder()
			//	.ownedWindow(true).childWindow(false).text("Site Manager").nativeClass("#32770").build()).describe(TreeView.class, new TreeViewDescription.Builder()
				//		.attachedText("&Select Entry:").nativeClass("SysTreeView32").build()).select(13);

		Desktop.describe(Dialog.class, new DialogDescription.Builder()
				.ownedWindow(true).childWindow(false).text("Site Manager").nativeClass("#32770").build()).describe(Button.class, new ButtonDescription.Builder()
						.text("&Connect").nativeClass("Button").build()).click();
		Thread.sleep(3000);
		
		EditField Setpath =Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("wxWindowNR").windowTitleRegExp(" FileZilla").build()).describe(EditField.class, new EditFieldDescription.Builder()
						.attachedText("Local site:").nativeClass("Edit").build());
		
		Thread.sleep(3000);
		Setpath.setText("E:\\eclipse-workspace\\EMC\\940");
		Setpath.click();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		EditField remotepath=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(false).childWindow(false).windowClassRegExp("wxWindowNR").windowTitleRegExp(" FileZilla").build()).describe(EditField.class, new EditFieldDescription.Builder()
						.attachedText("Remote site:").nativeClass("Edit").build());
		Thread.sleep(3000);
		remotepath.setText("/FSCSUA/940");
		remotepath.click();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		   
		ListView t = Desktop.describe(Window.class, new WindowDescription.Builder()
				.childWindow(false)
				.ownedWindow(false)
				.windowClassRegExp("wxWindowNR")
				.windowTitleRegExp(" FileZilla").build())
			.describe(ListView.class, new ListViewDescription.Builder()
				.nativeClass("SysListView32")
				.windowId(-31763).build());
		t.select(1);
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Runtime rt = Runtime.getRuntime();

		rt.exec("taskkill /F /IM filezilla.exe");
	}
    
   
}