package pack1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct {
	public static void main(String []args) throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	FileInputStream fis = new FileInputStream("./src/test/resources/AdvanceSeleniumcommonData.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String URL = pro.getProperty("url");
	String userName = pro.getProperty("username");
	String password = pro.getProperty("password");
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(userName);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	FileInputStream fes = new FileInputStream("./src/test/resources/Advance_Selenium.xlsx");
	Workbook wb = WorkbookFactory.create(fes);
	Sheet sheet = wb.getSheet("Product");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String productName = cell.getStringCellValue()+	ranNum;
	driver.findElement(By.name("productname")).sendKeys(productName);
	WebElement saveButton = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
	Rectangle rect = saveButton.getRect();
	System.out.println(rect.getX());
	System.out.println(rect.getY());
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1156)");
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.linkText("Sign Out")).click();

	}

}
