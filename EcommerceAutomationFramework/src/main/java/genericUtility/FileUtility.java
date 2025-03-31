package genericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility{

public String readDataFromPropertyFile(String key) throws IOException {
	FileInputStream file=new FileInputStream("./src/main/resources/configurationData.properties");
	Properties property=new Properties();
	property.load(file);
	return property.getProperty(key);
	
}
}
