package pom_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriver_Utility;

public class ProductWindowPage {
	
	public ProductWindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement selectPlusSign;
	
	@FindBy(id="search_txt")
	private WebElement productTxtBx;
	 
	@FindBy(name="search")
	private WebElement productSearchBtn;

	public WebElement getSelectPlusSign() {
		return selectPlusSign;
	}

	public WebElement getProductTxtBx() {
		return productTxtBx;
	}

	public WebElement getProductSearchBtn() {
		return productSearchBtn;
	}
	  
	//Business Logics
	public void clickOnSelectSign(WebDriver driver, WebDriver_Utility wlib) {
		selectPlusSign.click();
		wlib.switchingWindows(driver, "Products&action");
	}
	public void productName(String prodName) {
		productTxtBx.sendKeys(prodName);
	}
	public void searchProdData() {
		productSearchBtn.click();
	}
	public void selectProduct(WebDriver driver,String productName, WebDriver_Utility wlib) {
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
		wlib.switchingWindows(driver, "Campaigns&action");

	}

}
