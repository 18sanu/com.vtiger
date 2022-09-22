package com.vtiger.genericLibrary;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * this class is used to fetch data from property and json file
 * @author sanu
 *
 */
public class FileUtility {
	/**
	 * this method fetches data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/propertyFile.properties");
		Properties property = new Properties();
		property.load(fis);
		return property.getProperty(key);
		
	}
	/**
	 * this method fetches data form json file
	 * @param filePath
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public String getDataFromJsonFile(String filePath,String key) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader file = new FileReader(filePath);
		Object obj = parser.parse(file);
		JSONObject jobj = (JSONObject)obj;
		return jobj.get(key).toString();
	
	}

}
