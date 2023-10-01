package pack1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/AdvanceSeleniumcommonData.properties");
     Properties pro= new Properties();
     pro.load(fis);
     String url = pro.getProperty("url");
     String userName = pro.getProperty("username");
     String password = pro.getProperty("password");
     
     WebDriverManager.chromedriver().setup();
     ChromeDriver driver= new ChromeDriver();
     driver.manage().window().maximize();
     driver.get(url);
     driver.findElement(By.id("username")).sendKeys(userName);
     driver.findElement(By.name("pwd")).sendKeys(password);
     driver.findElement(By.id("loginButton")).click();
	}

}
