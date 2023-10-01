package pack1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct {
	public static void main(String []args) throws IOException {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> id = allWindows.iterator();
		while (id.hasNext()) {
			String win =  id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains("Products&action")) {
				
				break;
			}
		}
				driver.findElement(By.id("search_txt")).sendKeys(productName);
				driver.findElement(By.name("search")).click();
				
			driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
			Set<String> allWindows1 = driver.getWindowHandles();
			Iterator<String> id1 = allWindows1.iterator();
			while (id1.hasNext()) {
				String win =  id1.next();
				driver.switchTo().window(win);
				String title = driver.getTitle();
				
				if (title.contains("Campaigns&action")) {
					
					break;
					
				}
					
				}
			FileInputStream fes1 = new FileInputStream("./src/test/resources/Advance_Selenium.xlsx");
			Workbook wb1 = WorkbookFactory.create(fes1);
			Sheet sheet1 = wb1.getSheet("Campaigns");
			Row row1 = sheet1.getRow(0);
			Cell cell1 = row1.getCell(0);
			String campaignName = cell1.getStringCellValue()+ranNum;
			driver.findElement(By.name("campaignname")).sendKeys(campaignName);
				
			}
	}
		

//}
