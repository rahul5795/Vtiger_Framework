package product;

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
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom_repository.CreateProductPage;
import pom_repository.HomePage;
import pom_repository.LoginPage;

public class CreateProduct extends BaseClass{
	@Test(groups = "smokeTest")
	public void CreateProduct() throws IOException, InterruptedException {
	HomePage homePage= new HomePage(driver);
	homePage.clickProductLink();
	CreateProductPage product= new CreateProductPage(driver);
	product.clickProductImg();
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	FileInputStream fes = new FileInputStream("./src/test/resources/Advance_Selenium.xlsx");
	Workbook wb = WorkbookFactory.create(fes);
	Sheet sheet = wb.getSheet("Product");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String productName = cell.getStringCellValue()+	ranNum;
	product.productName(productName);
	

	}

}
