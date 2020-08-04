package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Config {
	private static Properties configFile;

	public static void EstablishFileStream(String fileName) {
		try {
			String path = "./TestData/" + fileName + ".properties";
			FileInputStream input = new FileInputStream(path);

			configFile = new Properties();
			configFile.load(input);

			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String keyName) {
		String fileName = "config";
		EstablishFileStream(fileName);
		return configFile.getProperty(keyName);
	}

	public static String getProperty(String keyName, String fileName) {
		EstablishFileStream(fileName);
		return configFile.getProperty(keyName);
	}

	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	public static String getDownloadLocation(){
		String location = null;
		if(null != getProperty("downloadLocation")){
			location = System.getProperty("user.dir")+"/"+getProperty("downloadLocation");
		}else{
			location = System.getProperty("user.home")+"/"+"Downloads";
		}
		 
		return location.replace("/", File.separator);
	}

}
