package pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    @FindBy(xpath="//img[@title='Create Product...']")
    private WebElement productImg;
    
    @FindBy(name="productname")
    private WebElement productName;
    
    @FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
    private WebElement saveBtn;

	public WebElement getProductImg() {
		return productImg;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
    
    public void clickProductImg() {
    	productImg.click();
    	
    }
    public void productName(String productName1) {
    	productName.sendKeys(productName1);
    	saveBtn.click();
    	
    }
}
