package entity;

import java.net.URI;
/*
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
*/
public class TestSdk {
	 public static void main(String [] args){
		//Commented to remove leanft dependency
		/* Browser browser;
	        // initialize the SDK and report only once per process
	        try{
	        	ModifiableSDKConfiguration config;
	        	
	    		config =  SDKConfigurationFactory.loadConfigurationFromExternalPropertiesFile("src//main//resources//leanft.properties");
	    	   System.out.println(config.getAutoLaunch());
	    	   System.out.println(config.getSDKMode());
	    		SDK.init(config);
	        	
	        	  ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
	              config.setServerAddress(new URI("ws://localhost:5095"));
	              SDK.init(config);
	            //Reporter.init();
	    	    browser = BrowserFactory.launch(BrowserType.CHROME);
	            
	            //put your test code here.
	            
	            //Generate the report and cleanup the SDK usage.
	           // Reporter.generateReport();
	           // SDK.cleanup();
	        }
	        catch(Exception e){
	        	System.out.println(e);
	        }*/
}
}
