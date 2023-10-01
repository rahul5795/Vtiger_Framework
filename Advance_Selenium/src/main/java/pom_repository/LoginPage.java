package pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    @FindBy(name="user_name")
    private WebElement userNameTxtField;
    
    @FindBy(name="user_password")
    private WebElement passwordTxtField;
    
    @FindBy(id="submitButton")
    private WebElement loginBtn;

	public WebElement getUserNameTxtField() {
		return userNameTxtField;
	}

	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToVtiger(String username, String password) {
		userNameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		loginBtn.click();
		
	}
    
    
}
