package generic_utilities;

import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {
	/**
	 * This method is used for maximizing windows
	 * 
	 * @param driver
	 * @author Rahul
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will the element to load in GUI
	 * 
	 * @param driver
	 * @author Rahul
	 */
	public void implicityWait(WebDriver driver) {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void switchingWindows(WebDriver driver, String visibleText) {
		/**
		 * This method used for switching windows
		 * 
		 * @author Rahul
		 */
		Set<String> allIDS = driver.getWindowHandles();
		Iterator<String> id = allIDS.iterator();
		while (id.hasNext()) {
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(visibleText)) {

				break;
			}
		}
	}

	public void scrollPage(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument.scrollIntoView()", element);
	}

	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}  
	public void actionsMoveToElement(WebDriver driver, WebElement element) {
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();;
	}
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();;
	}

}
