package pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgaizationImg;
	
	@FindBy(name="accountname")
	private WebElement OrgaizationName;
	
	@FindBy(id="phone")
	private WebElement OrganizationPhoneNum;
	
	@FindBy(id="email1")
	private WebElement OrganizationEmailID;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getCreateOrgaizationImg() {
		return createOrgaizationImg;
	}

	public WebElement getOrgaizationName() {
		return OrgaizationName;
	}
 
	public void clickOrganizationPlus() {
		createOrgaizationImg.click();
		
	}
	public void organizationName(String name) {
		OrgaizationName.sendKeys(name);
		
	}

	public WebElement getOrganizationPhoneNum() {
		return OrganizationPhoneNum;
	}

	public WebElement getOrganizationEmailID() {
		return OrganizationEmailID;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
   public void clickOrgPlus() {
	   createOrgaizationImg.click();
   }
   public void organizationData(String orgName,String phoneNum,String emailID) {
	   OrgaizationName.sendKeys(orgName);
	   OrganizationPhoneNum.sendKeys(phoneNum);
	   OrganizationEmailID.sendKeys(emailID);	   
	   
   }
   public void clickSaveBtn() {
	   
	   saveBtn.click();
	   
   }
   
   }

