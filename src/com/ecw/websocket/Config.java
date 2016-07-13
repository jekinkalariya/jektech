package com.ecw.websocket;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	public static String getURL(){
		
		Properties prop = new Properties();
		InputStream input = null;
		try {

			input = Config.class.getClassLoader().getResourceAsStream("config.properties");

			// load a properties file
			prop.load(input);
			String value=prop.getProperty("url");;
			System.out.println("value"+value);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return prop.getProperty("url");
	}

}
