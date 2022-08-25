package WebPages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

	protected WebDriver driver;

	  public SignInPage(WebDriver driver){
	    this.driver = driver;
	  }
	  
	 private By EmailField = By.xpath("//input[contains(@id, 'email_create')]");
	  
	 public void enterEmailAddress() {
			//Fill email address
			String emailText = RandomStringUtils.randomAlphanumeric(9);
			String emailNumber = RandomStringUtils.randomNumeric(3);  
		    driver.findElement(EmailField).sendKeys(emailText + emailNumber + "@gmail.com");
		    
	  }
	  
	  public void clickSubmitButton() {
		//Click Create account button
		driver.findElement(By.xpath("//div[contains(@class, 'submit')]/button")).click();  
	  }
}
