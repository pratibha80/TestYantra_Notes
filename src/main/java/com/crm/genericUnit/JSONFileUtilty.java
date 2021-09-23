package com.crm.genericUnit;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

/**
 * 
 * @author Pratibha
 *
 */

public class JSONFileUtilty {
	
	/**
	 * this method reads the data from json file
	 * @return 
	 * @throws Throwable 
	 * @throws IOException 
	 */
	
	public String readDataFromJSON(String key) throws IOException, Throwable {
		FileReader file=new FileReader("./commonData.json");
		JSONParser jsonobj = new JSONParser();
		Object jobj = jsonobj.parse(file);
		
		HashMap map=(HashMap)jobj;
		String val = map.get(key).toString();
		
		return val;
	}

}
