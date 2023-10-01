package pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampainsPage {
	
	public CreateCampainsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
      @FindBy(xpath="//img[@title='Create Campaign...']")
      private WebElement campaignsPlus;
      
      @FindBy(name="campaignname")
      private WebElement campaignName;
      
      @FindBy(xpath="//input[@title='Save [Alt+S]']")
      private WebElement saveBtn;

	public WebElement getCampaignsPlus() {
		return campaignsPlus;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
      
      
      public void clickCampPlusImg() {
    	  campaignsPlus.click(); 	  
    	  
      }
      public void campaignsName(String campName) {
    	  campaignName.sendKeys(campName);
    	  
      }
      public void clickSaveBtn() {
    	  saveBtn.click();
    	  
      }
}
  
