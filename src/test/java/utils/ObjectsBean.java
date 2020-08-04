package utils;

import java.util.HashMap;
import java.util.Map;

public class ObjectsBean {
	private static Map<String, String> skuMap = new HashMap<String, String>();
	
	public static void saveSkuValue(String skuName, String skuValue){
		skuMap.put(skuName, skuValue);
	}
	public static String getSkuValue(String skuName){
		return skuMap.get(skuName);
	}
}
