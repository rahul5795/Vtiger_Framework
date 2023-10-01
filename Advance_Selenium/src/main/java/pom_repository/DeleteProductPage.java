package pom_repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {
	public DeleteProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Products']")
	private WebElement navigateProductTable;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteProduct;

	public WebElement getNavigateProductTable() {
		return navigateProductTable;
	}

	public WebElement getDeleteProduct() {
		return deleteProduct;
	}
	
	public void productTable() {
		navigateProductTable.click();
	}
	public void deleteProductData() {
		deleteProduct.click();
	}
   
	public void validateProduct(WebDriver driver,String productName ) {
		List<WebElement> productList = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));

		boolean flag = false;
		for (WebElement prodName : productList) {

			String actualData = prodName.getText();
			if (actualData.contains(productName)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("product data is deleted");

		} else {
			System.out.println("product data is not deleted");
		}
	}
}
