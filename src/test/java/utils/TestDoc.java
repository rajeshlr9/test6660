package utils;

import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.verifications.*;
*/
import unittesting.*;
//Commented to remove leanft dependency
	/*
public class TestDoc extends UnitTestClassBase {

   
    @Test
    public void test() throws GeneralLeanFtException, Exception {
    	
		
		  ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		  config.setServerAddress(new URI("ws://localhost:5095"));
		//  config.setServerAddress(new URI("ws://10.60.27.227:5095"));
		 // config.setAutoLaunch(false);
		  SDK.init(config);
		 
		Browser browser = BrowserFactory.launch(BrowserType.CHROME);
		browser.navigate("https://ocfdl1wm1.logistics.fedex.com:12001/");
    	
    	
    }

}*/