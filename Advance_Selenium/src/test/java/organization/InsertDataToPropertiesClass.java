package organization;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDataToPropertiesClass {

	public static void main(String[] args) throws IOException {
		Properties pro=new Properties();
		pro.setProperty("username", "admin");
		pro.setProperty("password", "manager");
		pro.setProperty("url", "https://demo.actitime.com/login.do");
  FileOutputStream fos=new FileOutputStream("./src/test/resources/AdvanceSeleniumcommonData.properties");
  pro.store(fos, "common Data");
  System.out.println("Data written successfull");
	}

}
