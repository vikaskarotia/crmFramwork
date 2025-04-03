package com.comcast.com.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class FileUtility {


	public String getData(String key) throws IOException { 
		FileInputStream fis=new FileInputStream("./configAppData/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		
	   return pobj.getProperty(key);
	    
	}
}
