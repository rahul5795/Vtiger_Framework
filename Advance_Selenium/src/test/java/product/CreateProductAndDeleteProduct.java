package product;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utitlity;
import generic_utilities.WebDriver_Utility;
import pom_repository.CreateProductPage;
import pom_repository.DeleteProductPage;
import pom_repository.HomePage;
import pom_repository.LoginPage;
import pom_repository.ProductValidationPage;

public class CreateProductAndDeleteProduct extends BaseClass{
	//public static void main(String[] args) throws IOException, InterruptedException {
       @Test
       public void CreateProductAndDeleteProduct() throws EncryptedDocumentException, IOException, InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickProductLink();
	
		CreateProductPage product = new CreateProductPage(driver);
		product.clickProductImg();
		Java_Utitlity javaUtility = new Java_Utitlity();
		int ranNum = javaUtility.getRandomNum();
	
		String productName = excelUtility.getExcelDataUsingDataFormatter("Product", 0, 0) + ranNum;
		product.productName(productName);
		homePage.clickProductLink();
		ProductValidationPage deleteProd = new ProductValidationPage(driver);
		deleteProd.checkProdName(driver, productName);
		deleteProd.deleteProdClick(driver, wlib);
		
		Thread.sleep(2000);

		DeleteProductPage page= new DeleteProductPage(driver);
		page.validateProduct(driver, productName);
	}

}
