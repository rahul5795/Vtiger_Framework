package campaigns;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import pom_repository.CreateCampainsPage;
import pom_repository.HomePage;
import pom_repository.ValidationPage;

public class CreateCampaign extends BaseClass {

	@Test(groups ="smokeTest")
	//@Test(retryAnalyzer = generic_utilities.RetryAnalyserImplementation.class)
	public void CreateCampaign() throws IOException, InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clickMoreLink(driver);
		CreateCampainsPage camp = new CreateCampainsPage(driver);
		camp.clickCampPlusImg();
		//Assert.assertEquals(false, true);
		//Java_Utitlity javaUtility = new Java_Utitlity();
		int ranNum = javaUtility.getRandomNum();
		Excel_Utility excelUtility = new Excel_Utility();
		String campaignName = excelUtility.getExcelDataUsingDataFormatter("Campaigns", 0, 0) + ranNum;
		camp.campaignsName(campaignName);
		camp.clickSaveBtn();
		Thread.sleep(2000);
		//String actualData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		ValidationPage vp =new ValidationPage(driver);
		String actualData = vp.validateCamp();
		Assert.assertEquals(actualData, campaignName);
		/*if (actualData.contains(campaignName)) {
			System.out.println("pass");
 
		} else {
			System.out.println("fail");
		}/*
		//homePage.logout(driver);

	}
	/*@Test(groups = "smokeTest")
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
	

	}*/

}}



