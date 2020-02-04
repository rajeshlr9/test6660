package reusable;

import java.net.URI;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;

public class LeanFtInitialize {

	public static void initializeLeanFt() {
		
		try {
			ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
			config.setServerAddress(new URI("ws://localhost:5095"));
			SDK.init(config);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
