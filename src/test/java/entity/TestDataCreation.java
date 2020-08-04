package entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import utils.Xpathxml;



public class TestDataCreation {
	static Map<String,String> data= new HashMap<>();
	private static Map<String, String> itemname = new HashMap<>();
	public static List<String> ItemNames=new ArrayList<String>();
	private static Map<String, List<String>> DataForLocations = new HashMap<>();
	
	public static String getDataForLocations(String Location,int i) {
		return DataForLocations.get(Location).get(i);
	}
	public static void setDataForLocations(String Location,List<String> mydata) {
		DataForLocations.put(Location,mydata);
	}
	
	
	static Xpathxml xmlInput = new Xpathxml();
	
	public static  String  getData(String TCname) {
		return data.get(TCname);
	}
	public static void setData(String Tcname,String ItemType) {
		data.put(Tcname,ItemType);
		
	}
	
	public static String getItemname(String itemnumber) {
		return itemname.get(itemnumber);
	}

	public static void setItemname(String itemnumber, String Itemname) {
		itemname.put(itemnumber, Itemname);
	}
	
	public static void SerialType(String serialType) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException
	{
		switch(serialType)
		{
		case "0":
			xmlInput.ModifyXmlfile(xmlInput.ItemUpdateSerialRequired(1),"0",xmlInput.inputItemCreationFilePath);
			System.out.println("Serial type updated as "+serialType );
			break;
		case "1":
			xmlInput.ModifyXmlfile(xmlInput.ItemUpdateSerialRequired(1),"1",xmlInput.inputItemCreationFilePath);
			System.out.println("Serial type updated as "+serialType );
			break;
		case "4" :
			xmlInput.ModifyXmlfile(xmlInput.ItemUpdateSerialRequired(1),"4",xmlInput.inputItemCreationFilePath);
			System.out.println("Serial type updated as "+serialType );
			break;
		default:
				System.out.println("Switched to Default serial type");
		}
	}
		
	}

