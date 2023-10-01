package generic_utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_repository.HomePage;
import pom_repository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public Java_Utitlity javaUtility = new Java_Utitlity();
	public Excel_Utility excelUtility = new Excel_Utility();
	public File_Utility fileUtility = new File_Utility();
	public WebDriver_Utility wlib = new WebDriver_Utility();

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void beforeSuite() {
		System.out.println("DataBase Connection");

	}

	@BeforeTest(groups = { "smokeTest", "regressionTest" })
	public void beforeTest() {
		System.out.println("Parallel Execution");
	}

	// @Parameters("browser")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	// public void beforeClass(String browser) throws IOException {// used for
	// parameter
	public void beforeClass() throws IOException {// used without parameter

		String browser = fileUtility.getKeyAndValue("browser");
		if (browser.equalsIgnoreCase("chrome")) {
		//	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		// driver=sdriver;
		System.out.println("Launching Browser");
	}
     
	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void beforeMethod() throws Throwable {
		wlib.implicityWait(driver);
		String URL = fileUtility.getKeyAndValue("url");
		String userName = fileUtility.getKeyAndValue("username");
		String password = fileUtility.getKeyAndValue("password");
		driver.get(URL);
		wlib.maximizeWindow(driver);
		LoginPage lp = new LoginPage(driver);
		lp.loginToVtiger(userName, password);
		System.out.println("Login to Application");

	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void afterMethod() {
		HomePage homePage = new HomePage(driver);
		homePage.logout(driver);
		System.out.println("Logout from Application");
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void afterClass() {
		driver.quit();
		System.out.println("Closed the Browser");
	}

	@AfterTest(groups = { "smokeTest", "regressionTest" })
	public void afterTest() {
		System.out.println("Parallel Execution Done");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void afterSuite() {
		System.out.println("Database Connection Close");
	}
}
