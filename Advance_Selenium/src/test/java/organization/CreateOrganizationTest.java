package organization;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utitlity;
import pom_repository.CreateOrganizationPage;
import pom_repository.HomePage;
import pom_repository.LoginPage;
import pom_repository.ValidationPage;

public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups = {"smokeTest","regressionTest"})

	public void CreateOrganizationTest() throws IOException, InterruptedException {


		HomePage homePage= new HomePage(driver);
		homePage.clickOrganizationLink();
		CreateOrganizationPage org= new CreateOrganizationPage(driver);
		org.clickOrgPlus();
		
		int ranNum = javaUtility.getRandomNum();
		
		String orgName = excelUtility.getExcelDataUsingDataFormatter("Sheet2", 0, 0) + ranNum;
		Thread.sleep(2000);
		String orgNum = excelUtility.getExcelDataUsingDataFormatter("Sheet2", 1, 0);
		String orgEmail = excelUtility.getExcelDataUsingDataFormatter("Sheet2", 2, 0);
		org.organizationData(orgName, orgNum, orgEmail);
		org.clickSaveBtn();
		Thread.sleep(2000);
		ValidationPage vp= new ValidationPage(driver);
		String actualData = vp.validateOrgName();
		Assert.assertEquals(actualData, orgName);
		/*String actualData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if (actualData.contains(orgName)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
			
		}
		//homePage.logout(driver);
	}*/
}
}
