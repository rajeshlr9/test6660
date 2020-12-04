package utils;

import java.net.URI;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;

public class test {

	public static void main(String[] args) throws Exception {
	
		/*
		 * String[] iLPNz = new String[10]; ;
		 * 
		 * for(int i=0;i<5;i++) { iLPNz[i]= "ai"; System.out.println(i +"="+ iLPNz[i]);
		 * }
		 */
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		//config.setServerAddress(new URI("ws://localhost:5095"));
		config.setServerAddress(new URI("ws://10.60.27.227:5095"));
		SDK.init(config);  
		Browser browser = BrowserFactory.launch(BrowserType.CHROME);
		browser.navigate("https://ocfdl1wm1.logistics.fedex.com:12001/");
	}

}
