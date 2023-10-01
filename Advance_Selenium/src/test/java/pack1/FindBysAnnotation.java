package pack1;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utilities.File_Utility;
import pom_repository.Login1Page;

public class FindBysAnnotation {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		File_Utility fileUtility = new File_Utility();
		String URL = fileUtility.getKeyAndValue("url");
		String userName = fileUtility.getKeyAndValue("username");
		String password = fileUtility.getKeyAndValue("password");
		driver.get(URL);
		Login1Page lp1= new Login1Page(driver);
		lp1.loginToApplication(userName, password);
		//driver.findElement(By.name("user_name")).sendKeys(userName);
		//driver.findElement(By.name("user_password")).sendKeys(password);
		//driver.findElement(By.id("submitButton")).click();
	}
}
