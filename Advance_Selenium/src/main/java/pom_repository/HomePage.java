package pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriver_Utility;

public class HomePage {
     //Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstrator;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	

//  Getter method
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}

	public WebElement getAdminstrator() {
		return adminstrator;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	/**
	 * This method is used to click organization
	 */
   //BusinessLogics
	public void clickOrganizationLink() {
		organizationLink.click();
	}
	public void clickProductLink() {
		productsLink.click();
		
	}
	
	public void clickMoreLink(WebDriver driver) {
		WebDriver_Utility wlib= new WebDriver_Utility();
		wlib.mouseOverOnElement(driver, moreLink);
		CampaignsLink.click();
		
	}
	//public void clickCampaignsLink() {
		//CampaignsLink.click();
	//}
	public void logout(WebDriver driver) {
		WebDriver_Utility wlib= new WebDriver_Utility();
		wlib.actionsMoveToElement(driver, adminstrator);
		signOut.click();
		//OR
//		Actions act =new Actions(driver);
//		act.moveToElement(adminstrator).perform();
//		signOut.click();
		
	}
}
	
		
	