package com.crm.SeleniumProject_Maven.GenericsLib;

import java.sql.Connection;

 import java.sql.DriverManager;
import java.sql.ResultSet;


import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Pratibha
 *
 */

public class DataBaseUtility {
	Connection con=null;
	Driver driverRef;
	/**
	 * @throws Throwable 
	 * 
	 */
        public void connectToDB() throws Throwable {
        	
        	DriverManager.registerDriver(driverRef);
        	
        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
        	
        	
        }
        public void closeDB() throws Throwable
        {
        	con.close();
        }
        public String getDataFromDB(String query,int columnIndex) throws Throwable {
        	String value=null;
        	ResultSet result = con.createStatement().executeQuery(query);
        	
        	while(result.next()) {
        	result.getString(columnIndex);
        		
        	}
        	return value;
        }
}
