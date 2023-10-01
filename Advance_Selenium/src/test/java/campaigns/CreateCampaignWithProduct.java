package campaigns;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utitlity;
import generic_utilities.WebDriver_Utility;
import pom_repository.CreateCampainsPage;
import pom_repository.CreateProductPage;
import pom_repository.HomePage;
import pom_repository.LoginPage;
import pom_repository.ProductWindowPage;

public class CreateCampaignWithProduct extends BaseClass{
	@Test(groups = "regressionTest")
	public void CreateCampaignWithProduct() throws IOException, InterruptedException {
		//Excel_Utility excelUtility = new Excel_Utility();
	//	Java_Utitlity javaUtility = new Java_Utitlity();
	//	WebDriver_Utility wlib = new WebDriver_Utility();
		//wlib.maximizeWindow(driver);
	//	wlib.implicityWait(driver);
		HomePage homePage= new HomePage(driver);
		homePage.clickProductLink();
		CreateProductPage product= new CreateProductPage(driver);
		product.clickProductImg();
		int ranNum = javaUtility.getRandomNum();
		String productName = excelUtility.getExcelDataUsingDataFormatter("Product", 0, 0) + ranNum;
		product.productName(productName);
		homePage.clickMoreLink(driver);
		CreateCampainsPage campaigns= new CreateCampainsPage(driver);
		campaigns.clickCampPlusImg();
		ProductWindowPage prodWindow= new ProductWindowPage(driver);
		prodWindow.clickOnSelectSign(driver, wlib);
		prodWindow.productName(productName);
		prodWindow.searchProdData();
		prodWindow.selectProduct(driver, productName, wlib);
		String campaignName = excelUtility.getExcelDataUsingDataFormatter("Campaigns", 0, 0) + ranNum;
		campaigns.campaignsName(campaignName);
		//driver.findElement(By.name("campaignname")).sendKeys(campaignName);
	


	}
}
