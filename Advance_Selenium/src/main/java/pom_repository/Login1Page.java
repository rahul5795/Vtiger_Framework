package pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Login1Page {
	
	public Login1Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement userNameTxtBx;
	
	@FindBys({@FindBy(xpath="//input[@type='password']"),@FindBy(name="user_password")})
	private WebElement passwordTxtBx;
	
	
	@FindAll({@FindBy(xpath="//input[@type='submit']"),@FindBy(id="submitButton")})
	private WebElement loginBtn;


	public WebElement getUserNameTxtBx() {
		return userNameTxtBx;
	}


	public WebElement getPasswordTxtBx() {
		return passwordTxtBx;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void loginToApplication(String username, String password) {
		userNameTxtBx.sendKeys(username);
		passwordTxtBx.sendKeys(password);
		loginBtn.click();
	}

}
