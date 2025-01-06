package com.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

public String getDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata/commondata.properties");
	Properties property=new Properties();
	property.load(fis);
	String value= property.getProperty(key);
	return value;
	
	
}
}
