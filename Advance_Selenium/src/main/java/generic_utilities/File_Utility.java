package generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * This method used for launching Application
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getKeyAndValue(String key) throws IOException   {
	
	
	FileInputStream fis = new FileInputStream("./src/test/resources/AdvanceSeleniumcommonData.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String value = pro.getProperty(key);
	return value;
	}

}
