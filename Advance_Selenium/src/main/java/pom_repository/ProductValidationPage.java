package pom_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriver_Utility;

public class ProductValidationPage {

	public ProductValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@value='Delete'])[1]")
	private WebElement deleteProd;

	public void checkProdName(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + productName
				+ "']/../preceding-sibling::td/input")).click();
	}

	public void deleteProdClick(WebDriver driver, WebDriver_Utility wlib) {
		deleteProd.click();
		wlib.alertAccept(driver);
	}
}
